package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = null;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;

    @VisibleForTesting
    static final String EXTRA_INT1 = "int1";

    @VisibleForTesting
    static final String EXTRA_INT2 = "int2";

    @VisibleForTesting
    static final String EXTRA_OBJ = "obj";

    @VisibleForTesting
    static final String EXTRA_STRING1 = "string1";

    @VisibleForTesting
    static final String EXTRA_TINT_LIST = "tint_list";

    @VisibleForTesting
    static final String EXTRA_TINT_MODE = "tint_mode";

    @VisibleForTesting
    static final String EXTRA_TYPE = "type";
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public byte[] mData;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt2;
    Object mObj1;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable mParcelable;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mString1;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ColorStateList mTintList;
    PorterDuff.Mode mTintMode;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mTintModeStr;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mType;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @Nullable
        static IconCompat createFromIcon(@NonNull Context r10, @NonNull Icon r11) {
            int r12 = getType(r11);
            if (r12 != 2) goto L5;
            String r13 = getResPackage(r11);
            return IconCompat.createWithResource(IconCompat.getResources(r10, r13), r13, getResId(r11));
        L18:
            throw new IllegalArgumentException("Icon resource cannot be found");
        L5:
            if (r12 == 4) goto L13;
            if (r12 == 6) goto L11;
            IconCompat r14 = new IconCompat(-1);
            r14.mObj1 = r11;
            return r14;
        L11:
            return IconCompat.createWithAdaptiveBitmapContentUri(getUri(r11));
        L13:
            return IconCompat.createWithContentUri(getUri(r11));
        }

        static IconCompat createFromIconInner(@NonNull Object r10) {
            Preconditions.checkNotNull(r10);
            int r11 = getType(r10);
            if (r11 == 2) goto L15;
            if (r11 == 4) goto L13;
            if (r11 == 6) goto L11;
            IconCompat r12 = new IconCompat(-1);
            r12.mObj1 = r10;
            return r12;
        L11:
            return IconCompat.createWithAdaptiveBitmapContentUri(getUri(r10));
        L13:
            return IconCompat.createWithContentUri(getUri(r10));
        L15:
            return IconCompat.createWithResource(null, getResPackage(r10), getResId(r10));
        }

        @DrawableRes
        @IdRes
        static int getResId(@NonNull Object r10) {
            if (Build.VERSION.SDK_INT < 28) goto L18;
            return Api28Impl.getResId(r10);
        L18:
            return ((Integer) r10.getClass().getMethod("getResId", new Class[0]).invoke(r10, new Object[0])).intValue();
        L15:
            e = move-exception;
            Log.e(IconCompat.TAG, "Unable to get icon resource", e);
            return 0;
        L9:
            e = move-exception;
            Log.e(IconCompat.TAG, "Unable to get icon resource", e);
            return 0;
        L12:
            e = move-exception;
            Log.e(IconCompat.TAG, "Unable to get icon resource", e);
            return 0;
        }

        @Nullable
        static String getResPackage(@NonNull Object r10) {
            if (Build.VERSION.SDK_INT < 28) goto L18;
            return Api28Impl.getResPackage(r10);
        L18:
            return (String) r10.getClass().getMethod("getResPackage", new Class[0]).invoke(r10, new Object[0]);
        L15:
            e = move-exception;
            Log.e(IconCompat.TAG, "Unable to get icon package", e);
            return null;
        L9:
            e = move-exception;
            Log.e(IconCompat.TAG, "Unable to get icon package", e);
            return null;
        L12:
            e = move-exception;
            Log.e(IconCompat.TAG, "Unable to get icon package", e);
            return null;
        }

        static int getType(@NonNull Object r10) {
            if (Build.VERSION.SDK_INT < 28) goto L17;
            return Api28Impl.getType(r10);
        L17:
            return ((Integer) r10.getClass().getMethod("getType", new Class[0]).invoke(r10, new Object[0])).intValue();
        L15:
            e = e;
            StringBuilder r11 = new StringBuilder();
        L11:
            r11.append("Unable to get icon type ");
            r11.append(r10);
            Log.e(IconCompat.TAG, r11.toString(), e);
            return -1;
        L9:
            e = e;
            r11 = new StringBuilder();
        L13:
            e = e;
            r11 = new StringBuilder();
            goto L11
        }

        @Nullable
        @DoNotInline
        static Uri getUri(@NonNull Object r10) {
            if (Build.VERSION.SDK_INT < 28) goto L18;
            return Api28Impl.getUri(r10);
        L18:
            return (Uri) r10.getClass().getMethod("getUri", new Class[0]).invoke(r10, new Object[0]);
        L15:
            e = move-exception;
            Log.e(IconCompat.TAG, "Unable to get icon uri", e);
            return null;
        L9:
            e = move-exception;
            Log.e(IconCompat.TAG, "Unable to get icon uri", e);
            return null;
        L12:
            e = move-exception;
            Log.e(IconCompat.TAG, "Unable to get icon uri", e);
            return null;
        }

        @DoNotInline
        static Drawable loadDrawable(Icon r10, Context r11) {
            return r10.loadDrawable(r11);
        }

        @DoNotInline
        static Icon toIcon(IconCompat r10, Context r11) {
            switch(r10.mType) {
                case -1: goto L38;
                case 0: goto L5;
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L20;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            int r12 = Build.VERSION.SDK_INT;
            if (r12 < 30) goto L9;
            Icon r13 = Api30Impl.createWithAdaptiveBitmapContentUri(r10.getUri());
        L30:
            ColorStateList r14 = r10.mTintList;
            if (r14 == null) goto L33;
            r13.setTintList(r14);
        L33:
            PorterDuff.Mode r15 = r10.mTintMode;
            if (r15 == IconCompat.DEFAULT_TINT_MODE) goto L36;
            r13.setTintMode(r15);
        L36:
            return r13;
        L9:
            if (r11 == null) goto L18;
            InputStream r16 = r10.getUriInputStream(r11);
            if (r16 == null) goto L16;
            Bitmap r17 = BitmapFactory.decodeStream(r16);
            if (r12 >= 26) goto L22;
        L24:
            Bitmap r18 = IconCompat.createLegacyIconFromAdaptiveIcon(r17, false);
        L29:
            r13 = Icon.createWithBitmap(r18);
        L22:
            r13 = Api26Impl.createWithAdaptiveBitmap(r17);
            goto L30
        L16:
            throw new IllegalStateException("Cannot load adaptive icon from uri: " + r10.getUri());
        L18:
            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + r10.getUri());
        L25:
            r13 = Icon.createWithContentUri((String) r10.mObj1);
            goto L30
        L26:
            r13 = Icon.createWithData((byte[]) r10.mObj1, r10.mInt1, r10.mInt2);
            goto L30
        L27:
            r13 = Icon.createWithResource(r10.getResPackage(), r10.mInt1);
            goto L30
        L28:
            r18 = (Bitmap) r10.mObj1;
            goto L29
        L5:
            throw new IllegalArgumentException("Unknown type");
        L20:
            if (Build.VERSION.SDK_INT < 26) goto L23;
            r17 = (Bitmap) r10.mObj1;
            goto L22
        L23:
            r17 = (Bitmap) r10.mObj1;
            goto L24
        L38:
            return (Icon) r10.mObj1;
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static Drawable createAdaptiveIconDrawable(Drawable r10, Drawable r11) {
            return new AdaptiveIconDrawable(r10, r11);
        }

        @DoNotInline
        static Icon createWithAdaptiveBitmap(Bitmap r10) {
            return Icon.createWithAdaptiveBitmap(r10);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int getResId(Object r10) {
            return ((Icon) r10).getResId();
        }

        @DoNotInline
        static String getResPackage(Object r10) {
            return ((Icon) r10).getResPackage();
        }

        @DoNotInline
        static int getType(Object r10) {
            return ((Icon) r10).getType();
        }

        @DoNotInline
        static Uri getUri(Object r10) {
            return ((Icon) r10).getUri();
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static Icon createWithAdaptiveBitmapContentUri(Uri r10) {
            return Icon.createWithAdaptiveBitmapContentUri(r10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface IconType {
    }

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IconCompat() {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    IconCompat(int r10) {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = r10;
    }

    @Nullable
    public static IconCompat createFromBundle(@NonNull Bundle r10) {
        int r11 = r10.getInt("type");
        IconCompat r12 = new IconCompat(r11);
        r12.mInt1 = r10.getInt(EXTRA_INT1);
        r12.mInt2 = r10.getInt(EXTRA_INT2);
        r12.mString1 = r10.getString(EXTRA_STRING1);
        if (r10.containsKey(EXTRA_TINT_LIST) == false) goto L6;
        r12.mTintList = (ColorStateList) r10.getParcelable(EXTRA_TINT_LIST);
    L6:
        if (r10.containsKey(EXTRA_TINT_MODE) == false) goto L9;
        r12.mTintMode = PorterDuff.Mode.valueOf(r10.getString(EXTRA_TINT_MODE));
    L9:
        switch(r11) {
            case -1: goto L14;
            case 0: goto L10;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L13;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L10;
        };
    L10:
        Log.w(TAG, "Unknown type " + r11);
        return null;
    L12:
        r12.mObj1 = r10.getByteArray(EXTRA_OBJ);
    L16:
        return r12;
    L13:
        Object r13 = r10.getString(EXTRA_OBJ);
    L15:
        r12.mObj1 = r13;
        goto L16
    L14:
        r13 = r10.getParcelable(EXTRA_OBJ);
        goto L15
    }

    @Nullable
    @RequiresApi(23)
    public static IconCompat createFromIcon(@NonNull Context r10, @NonNull Icon r11) {
        Preconditions.checkNotNull(r11);
        return Api23Impl.createFromIcon(r10, r11);
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIcon(@NonNull Icon r10) {
        return Api23Impl.createFromIconInner(r10);
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIconOrNullIfZeroResId(@NonNull Icon r10) {
        if (Api23Impl.getType(r10) != 2) goto L9;
        if (Api23Impl.getResId(r10) != 0) goto L9;
        return null;
    L9:
        return Api23Impl.createFromIconInner(r10);
    }

    @VisibleForTesting
    static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap r10, boolean r11) {
        int r12 = (int) (Math.min(r10.getWidth(), r10.getHeight()) * DEFAULT_VIEW_PORT_SCALE);
        Bitmap r13 = Bitmap.createBitmap(r12, r12, Bitmap.Config.ARGB_8888);
        Canvas r14 = new Canvas(r13);
        Paint r15 = new Paint(3);
        float r16 = r12;
        float r17 = 0.5f * r16;
        float r18 = ICON_DIAMETER_FACTOR * r17;
        if (r11 == false) goto L5;
        float r19 = BLUR_FACTOR * r16;
        r15.setColor(0);
        r15.setShadowLayer(r19, 0.0f, r16 * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
        r14.drawCircle(r17, r17, r18, r15);
        r15.setShadowLayer(r19, 0.0f, 0.0f, 503316480);
        r14.drawCircle(r17, r17, r18, r15);
        r15.clearShadowLayer();
    L5:
        r15.setColor(ViewCompat.MEASURED_STATE_MASK);
        Shader.TileMode r20 = Shader.TileMode.CLAMP;
        BitmapShader r110 = new BitmapShader(r10, r20, r20);
        Matrix r21 = new Matrix();
        r21.setTranslate((-(r10.getWidth() - r12)) / 2.0f, (-(r10.getHeight() - r12)) / 2.0f);
        r110.setLocalMatrix(r21);
        r15.setShader(r110);
        r14.drawCircle(r17, r17, r18, r15);
        r14.setBitmap(null);
        return r13;
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmap(@NonNull Bitmap r10) {
        ObjectsCompat.requireNonNull(r10);
        IconCompat r11 = new IconCompat(5);
        r11.mObj1 = r10;
        return r11;
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull Uri r10) {
        ObjectsCompat.requireNonNull(r10);
        return createWithAdaptiveBitmapContentUri(r10.toString());
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull String r10) {
        ObjectsCompat.requireNonNull(r10);
        IconCompat r11 = new IconCompat(6);
        r11.mObj1 = r10;
        return r11;
    }

    @NonNull
    public static IconCompat createWithBitmap(@NonNull Bitmap r10) {
        ObjectsCompat.requireNonNull(r10);
        IconCompat r11 = new IconCompat(1);
        r11.mObj1 = r10;
        return r11;
    }

    @NonNull
    public static IconCompat createWithContentUri(@NonNull Uri r10) {
        ObjectsCompat.requireNonNull(r10);
        return createWithContentUri(r10.toString());
    }

    @NonNull
    public static IconCompat createWithContentUri(@NonNull String r10) {
        ObjectsCompat.requireNonNull(r10);
        IconCompat r11 = new IconCompat(4);
        r11.mObj1 = r10;
        return r11;
    }

    @NonNull
    public static IconCompat createWithData(@NonNull byte[] r10, int r11, int r12) {
        ObjectsCompat.requireNonNull(r10);
        IconCompat r13 = new IconCompat(3);
        r13.mObj1 = r10;
        r13.mInt1 = r11;
        r13.mInt2 = r12;
        return r13;
    }

    @NonNull
    public static IconCompat createWithResource(@NonNull Context r10, @DrawableRes int r11) {
        ObjectsCompat.requireNonNull(r10);
        return createWithResource(r10.getResources(), r10.getPackageName(), r11);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createWithResource(@Nullable Resources r10, @NonNull String r11, @DrawableRes int r12) {
        ObjectsCompat.requireNonNull(r11);
        if (r12 == 0) goto L14;
        IconCompat r13 = new IconCompat(2);
        r13.mInt1 = r12;
        if (r10 != null) goto L15;
        r13.mObj1 = r11;
    L11:
        r13.mString1 = r11;
        return r13;
    L15:
        r13.mObj1 = r10.getResourceName(r12);     // Catch: Resources.NotFoundException -> L8
    L9:
        throw new IllegalArgumentException("Icon resource cannot be found");
    L14:
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    static Resources getResources(Context r10, String r11) {
        if ("android".equals(r11) == true) goto L5;
        PackageManager r12 = r10.getPackageManager();
        ApplicationInfo r13 = r12.getApplicationInfo(r11, 8192);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r13 == null) goto L11;
        return r12.getResourcesForApplication(r13);
    L11:
        return null;
    L12:
        e = move-exception;
        Log.e(TAG, String.format("Unable to find pkg=%s for icon", new Object[]{r11}), e);
        return null;
    L5:
        return Resources.getSystem();
    }

    private Drawable loadDrawableInner(Context r10) {
        switch(this.mType) {
            case 1: goto L30;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L5;
            default: goto L31;
        };
    L5:
        InputStream r11 = getUriInputStream(r10);
        if (r11 == null) goto L31;
        if (Build.VERSION.SDK_INT < 26) goto L12;
        return Api26Impl.createAdaptiveIconDrawable(null, new BitmapDrawable(r10.getResources(), BitmapFactory.decodeStream(r11)));
    L12:
        return new BitmapDrawable(r10.getResources(), createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream(r11), false));
    L15:
        InputStream r12 = getUriInputStream(r10);
        if (r12 == null) goto L31;
        return new BitmapDrawable(r10.getResources(), BitmapFactory.decodeStream(r12));
    L21:
        String r13 = getResPackage();
        if (TextUtils.isEmpty(r13) == false) goto L32;
        r13 = r10.getPackageName();
    L32:
        return ResourcesCompat.getDrawable(getResources(r10, r13), this.mInt1, r10.getTheme());
    L27:
        e = move-exception;
        Log.e(TAG, String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.mInt1), this.mObj1}), e);
    L31:
        return null;
    L14:
        return new BitmapDrawable(r10.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
    L20:
        return new BitmapDrawable(r10.getResources(), BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
    L30:
        return new BitmapDrawable(r10.getResources(), (Bitmap) this.mObj1);
    }

    private static String typeToString(int r10) {
        switch(r10) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "URI_MASKABLE";
    L7:
        return "BITMAP_MASKABLE";
    L9:
        return "URI";
    L11:
        return "DATA";
    L13:
        return "RESOURCE";
    L15:
        return "BITMAP";
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addToShortcutIntent(@NonNull Intent r10, @Nullable Drawable r11, @NonNull Context r12) {
        checkResource(r12);
        int r13 = this.mType;
        if (r13 != 1) goto L5;
        Bitmap r14 = (Bitmap) this.mObj1;
        if (r11 == null) goto L30;
        r14 = r14.copy(r14.getConfig(), true);
    L30:
        if (r11 == null) goto L32;
        int r15 = r14.getWidth();
        int r16 = r14.getHeight();
        r11.setBounds(r15 / 2, r16 / 2, r15, r16);
        r11.draw(new Canvas(r14));
    L32:
        r10.putExtra("android.intent.extra.shortcut.ICON", r14);
        return;
    L5:
        if (r13 != 2) goto L7;
        Context r17 = r12.createPackageContext(getResPackage(), 0);     // Catch: PackageManager.NameNotFoundException -> L24
        if (r11 != null) goto L15;
        r10.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(r17, this.mInt1));     // Catch: PackageManager.NameNotFoundException -> L24
        return;
    L15:
        Drawable r18 = ContextCompat.getDrawable(r17, this.mInt1);     // Catch: PackageManager.NameNotFoundException -> L24
        if (r18.getIntrinsicWidth() > 0) goto L18;
    L21:
        int r19 = ((ActivityManager) r17.getSystemService("activity")).getLauncherLargeIconSize();     // Catch: PackageManager.NameNotFoundException -> L24
        Bitmap r20 = Bitmap.createBitmap(r19, r19, Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L24
    L22:
        r18.setBounds(0, 0, r20.getWidth(), r20.getHeight());     // Catch: PackageManager.NameNotFoundException -> L24
        r18.draw(new Canvas(r20));     // Catch: PackageManager.NameNotFoundException -> L24
        r14 = r20;
        goto L30
    L18:
        if (r18.getIntrinsicHeight() <= 0) goto L21;
        r20 = Bitmap.createBitmap(r18.getIntrinsicWidth(), r18.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L24
    L24:
        e = move-exception;
        throw new IllegalArgumentException("Can't find package " + this.mObj1, e);
    L7:
        if (r13 != 5) goto L10;
        r14 = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
        goto L30
    L10:
        throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void checkResource(@NonNull Context r10) {
        if (this.mType != 2) goto L17;
        Object r11 = this.mObj1;
        if (r11 == null) goto L18;
        String r12 = (String) r11;
        if (r12.contains(":") == true) goto L9;
        return;
    L9:
        String r13 = r12.split(":", -1)[1];
        String r14 = r13.split("/", -1)[0];
        String r15 = r13.split("/", -1)[1];
        String r16 = r12.split(":", -1)[0];
        if ("0_resource_name_obfuscated".equals(r15) == false) goto L13;
        Log.i(TAG, "Found obfuscated resource, not trying to update resource id for it");
        return;
    L13:
        String r17 = getResPackage();
        int r18 = getResources(r10, r17).getIdentifier(r15, r14, r16);
        if (this.mInt1 == r18) goto L19;
        Log.i(TAG, "Id has changed for " + r17 + " " + r12);
        this.mInt1 = r18;
        return;
    L19:
        return;
    L18:
        return;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bitmap getBitmap() {
        int r10 = this.mType;
        if (r10 != (-1)) goto L13;
        if (Build.VERSION.SDK_INT < 23) goto L13;
        Object r11 = this.mObj1;
        if ((r11 instanceof Bitmap) == true) goto L9;
        return null;
    L9:
        return (Bitmap) r11;
    L13:
        if (r10 != 1) goto L17;
        return (Bitmap) this.mObj1;
    L17:
        if (r10 != 5) goto L21;
        return createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
    L21:
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    @DrawableRes
    public int getResId() {
        int r10 = this.mType;
        if (r10 != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getResId(this.mObj1);
    L9:
        if (r10 != 2) goto L13;
        return this.mInt1;
    L13:
        throw new IllegalStateException("called getResId() on " + this);
    }

    @NonNull
    public String getResPackage() {
        int r10 = this.mType;
        if (r10 != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getResPackage(this.mObj1);
    L9:
        if (r10 != 2) goto L20;
        String r11 = this.mString1;
        if (r11 == null) goto L18;
        if (TextUtils.isEmpty(r11) == true) goto L18;
        return this.mString1;
    L18:
        return ((String) this.mObj1).split(":", -1)[0];
    L20:
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        int r10 = this.mType;
        if (r10 == (-1)) goto L5;
    L8:
        return r10;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        return Api23Impl.getType(this.mObj1);
    }

    @NonNull
    public Uri getUri() {
        int r10 = this.mType;
        if (r10 != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getUri(this.mObj1);
    L9:
        if (r10 == 4) goto L16;
        if (r10 == 6) goto L16;
        throw new IllegalStateException("called getUri() on " + this);
    L16:
        return Uri.parse((String) this.mObj1);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InputStream getUriInputStream(@NonNull Context r10) {
        Uri r11 = getUri();
        String r12 = r11.getScheme();
        if ("content".equals(r12) == false) goto L5;
    L17:
        return r10.getContentResolver().openInputStream(r11);
    L13:
        e = e;
        StringBuilder r13 = new StringBuilder();
        String r14 = "Unable to load image from URI: ";
    L15:
        r13.append(r14);
        r13.append(r11);
        Log.w(TAG, r13.toString(), e);
        return null;
    L5:
        if ("file".equals(r12) == true) goto L17;
        return new FileInputStream(new File((String) this.mObj1));
    L9:
        e = e;
        r13 = new StringBuilder();
        r14 = "Unable to load image from path: ";
        goto L15
    }

    @Nullable
    public Drawable loadDrawable(@NonNull Context r10) {
        checkResource(r10);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Drawable r11 = loadDrawableInner(r10);
        if (r11 != null) goto L9;
    L13:
        return r11;
    L9:
        if (this.mTintList == null) goto L11;
    L12:
        r11.mutate();
        DrawableCompat.setTintList(r11, this.mTintList);
        DrawableCompat.setTintMode(r11, this.mTintMode);
        goto L13
    L11:
        if (this.mTintMode == DEFAULT_TINT_MODE) goto L13;
    L5:
        return Api23Impl.loadDrawable(toIcon(r10), r10);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
        switch(this.mType) {
            case -1: goto L15;
            case 0: goto L26;
            case 1: goto L11;
            case 2: goto L6;
            case 3: goto L5;
            case 4: goto L6;
            case 5: goto L11;
            case 6: goto L6;
            default: goto L26;
        };
    L5:
        this.mObj1 = this.mData;
        return;
    L6:
        String r10 = new String(this.mData, Charset.forName("UTF-16"));
        this.mObj1 = r10;
        if (this.mType == 2) goto L9;
        return;
    L9:
        if (this.mString1 != null) goto L22;
        this.mString1 = r10.split(":", -1)[0];
        return;
    L22:
        return;
    L11:
        Parcelable r11 = this.mParcelable;
        if (r11 != null) goto L17;
        byte[] r12 = this.mData;
        this.mObj1 = r12;
        this.mType = 3;
        this.mInt1 = 0;
        this.mInt2 = r12.length;
        return;
    L17:
        this.mObj1 = r11;
        return;
    L15:
        r11 = this.mParcelable;
        if (r11 != null) goto L17;
        throw new IllegalArgumentException("Invalid icon");
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean r10) {
        this.mTintModeStr = this.mTintMode.name();
        switch(this.mType) {
            case -1: goto L10;
            case 0: goto L19;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L5;
            case 5: goto L8;
            case 6: goto L5;
            default: goto L19;
        };
    L5:
        this.mData = this.mObj1.toString().getBytes(Charset.forName("UTF-16"));
        return;
    L6:
        this.mData = (byte[]) this.mObj1;
        return;
    L7:
        this.mData = ((String) this.mObj1).getBytes(Charset.forName("UTF-16"));
        return;
    L8:
        if (r10 == false) goto L11;
        Bitmap r11 = (Bitmap) this.mObj1;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        r11.compress(Bitmap.CompressFormat.PNG, 90, r12);
        this.mData = r12.toByteArray();
        return;
    L11:
        this.mParcelable = (Parcelable) this.mObj1;
        return;
    L10:
        if (r10 == false) goto L11;
        throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
    }

    @NonNull
    public IconCompat setTint(@ColorInt int r10) {
        return setTintList(ColorStateList.valueOf(r10));
    }

    @NonNull
    public IconCompat setTintList(@Nullable ColorStateList r10) {
        this.mTintList = r10;
        return this;
    }

    @NonNull
    public IconCompat setTintMode(@Nullable PorterDuff.Mode r10) {
        this.mTintMode = r10;
        return this;
    }

    @NonNull
    public Bundle toBundle() {
        Bundle r10 = new Bundle();
        switch(this.mType) {
            case -1: goto L9;
            case 0: goto L5;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L7;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L5;
        };
    L6:
        r10.putByteArray(EXTRA_OBJ, (byte[]) this.mObj1);
    L11:
        r10.putInt("type", this.mType);
        r10.putInt(EXTRA_INT1, this.mInt1);
        r10.putInt(EXTRA_INT2, this.mInt2);
        r10.putString(EXTRA_STRING1, this.mString1);
        ColorStateList r11 = this.mTintList;
        if (r11 == null) goto L14;
        r10.putParcelable(EXTRA_TINT_LIST, r11);
    L14:
        PorterDuff.Mode r12 = this.mTintMode;
        if (r12 == DEFAULT_TINT_MODE) goto L17;
        r10.putString(EXTRA_TINT_MODE, r12.name());
    L17:
        return r10;
    L7:
        r10.putString(EXTRA_OBJ, (String) this.mObj1);
        goto L11
    L8:
        Parcelable r13 = (Bitmap) this.mObj1;
    L10:
        r10.putParcelable(EXTRA_OBJ, r13);
        goto L11
    L9:
        r13 = (Parcelable) this.mObj1;
        goto L10
    L5:
        throw new IllegalArgumentException("Invalid icon");
    }

    @NonNull
    @RequiresApi(23)
    @Deprecated
    public Icon toIcon() {
        return toIcon(null);
    }

    @NonNull
    @RequiresApi(23)
    public Icon toIcon(@Nullable Context r10) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.toIcon(this, r10);
    L7:
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    @NonNull
    public String toString() {
        if (this.mType == (-1)) goto L5;
        StringBuilder r10 = new StringBuilder("Icon(typ=");
        r10.append(typeToString(this.mType));
        switch(this.mType) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L14;
            case 6: goto L9;
            default: goto L17;
        };
    L9:
        r10.append(" uri=");
        r10.append(this.mObj1);
        goto L17
    L10:
        r10.append(" len=");
        r10.append(this.mInt1);
        if (this.mInt2 == 0) goto L17;
        r10.append(" off=");
        int r11 = this.mInt2;
    L15:
        r10.append(r11);
        goto L17
    L13:
        r10.append(" pkg=");
        r10.append(this.mString1);
        r10.append(" id=");
        r10.append(String.format("0x%08x", new Object[]{Integer.valueOf(getResId())}));
        goto L17
    L14:
        r10.append(" size=");
        r10.append(((Bitmap) this.mObj1).getWidth());
        r10.append("x");
        r11 = ((Bitmap) this.mObj1).getHeight();
    L17:
        if (this.mTintList == null) goto L20;
        r10.append(" tint=");
        r10.append(this.mTintList);
    L20:
        if (this.mTintMode == DEFAULT_TINT_MODE) goto L22;
        r10.append(" mode=");
        r10.append(this.mTintMode);
    L22:
        r10.append(")");
        return r10.toString();
    L5:
        return String.valueOf(this.mObj1);
    }
}
