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
    public static class Api23Impl {
        private Api23Impl() {
        }

        @Nullable
        public static IconCompat createFromIcon(@NonNull Context r5, @NonNull Icon r10) {
            int r11 = getType(r10);
            if (r11 != 2) goto L5;
            String r12 = getResPackage(r10);
            return IconCompat.createWithResource(IconCompat.getResources(r5, r12), r12, getResId(r10));
        L18:
            throw new IllegalArgumentException("Icon resource cannot be found");
        L5:
            if (r11 == 4) goto L13;
            if (r11 == 6) goto L11;
            IconCompat r13 = new IconCompat(-1);
            r13.mObj1 = r10;
            return r13;
        L11:
            return IconCompat.createWithAdaptiveBitmapContentUri(getUri(r10));
        L13:
            return IconCompat.createWithContentUri(getUri(r10));
        }

        public static IconCompat createFromIconInner(@NonNull Object r5) {
            Preconditions.checkNotNull(r5);
            int r10 = getType(r5);
            if (r10 == 2) goto L15;
            if (r10 == 4) goto L13;
            if (r10 == 6) goto L11;
            IconCompat r11 = new IconCompat(-1);
            r11.mObj1 = r5;
            return r11;
        L11:
            return IconCompat.createWithAdaptiveBitmapContentUri(getUri(r5));
        L13:
            return IconCompat.createWithContentUri(getUri(r5));
        L15:
            return IconCompat.createWithResource(null, getResPackage(r5), getResId(r5));
        }

        @DrawableRes
        @IdRes
        public static int getResId(@NonNull Object r5) {
            return Api28Impl.getResId(r5);
        }

        @Nullable
        public static String getResPackage(@NonNull Object r5) {
            return Api28Impl.getResPackage(r5);
        }

        public static int getType(@NonNull Object r5) {
            return Api28Impl.getType(r5);
        }

        @Nullable
        @DoNotInline
        public static Uri getUri(@NonNull Object r5) {
            return Api28Impl.getUri(r5);
        }

        @DoNotInline
        public static Drawable loadDrawable(Icon r5, Context r10) {
            return r5.loadDrawable(r10);
        }

        @DoNotInline
        public static Icon toIcon(IconCompat r5, Context r10) {
            switch(r5.mType) {
                case -1: goto L20;
                case 0: goto L5;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            Icon r11 = Api30Impl.createWithAdaptiveBitmapContentUri(r5.getUri());
        L12:
            ColorStateList r12 = r5.mTintList;
            if (r12 == null) goto L15;
            r11.setTintList(r12);
        L15:
            PorterDuff.Mode r13 = r5.mTintMode;
            if (r13 == IconCompat.DEFAULT_TINT_MODE) goto L18;
            r11.setTintMode(r13);
        L18:
            return r11;
        L7:
            r11 = Api26Impl.createWithAdaptiveBitmap((Bitmap) r5.mObj1);
            goto L12
        L8:
            r11 = Icon.createWithContentUri((String) r5.mObj1);
            goto L12
        L9:
            r11 = Icon.createWithData((byte[]) r5.mObj1, r5.mInt1, r5.mInt2);
            goto L12
        L10:
            r11 = Icon.createWithResource(r5.getResPackage(), r5.mInt1);
            goto L12
        L11:
            r11 = Icon.createWithBitmap((Bitmap) r5.mObj1);
            goto L12
        L5:
            throw new IllegalArgumentException("Unknown type");
        L20:
            return (Icon) r5.mObj1;
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static Drawable createAdaptiveIconDrawable(Drawable r5, Drawable r10) {
            return new AdaptiveIconDrawable(r5, r10);
        }

        @DoNotInline
        public static Icon createWithAdaptiveBitmap(Bitmap r5) {
            return Icon.createWithAdaptiveBitmap(r5);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static int getResId(Object r5) {
            return ((Icon) r5).getResId();
        }

        @DoNotInline
        public static String getResPackage(Object r5) {
            return ((Icon) r5).getResPackage();
        }

        @DoNotInline
        public static int getType(Object r5) {
            return ((Icon) r5).getType();
        }

        @DoNotInline
        public static Uri getUri(Object r5) {
            return ((Icon) r5).getUri();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static Icon createWithAdaptiveBitmapContentUri(Uri r5) {
            return Icon.createWithAdaptiveBitmapContentUri(r5);
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

    @Nullable
    public static IconCompat createFromBundle(@NonNull Bundle r5) {
        int r10 = r5.getInt("type");
        IconCompat r11 = new IconCompat(r10);
        r11.mInt1 = r5.getInt(EXTRA_INT1);
        r11.mInt2 = r5.getInt(EXTRA_INT2);
        r11.mString1 = r5.getString(EXTRA_STRING1);
        if (r5.containsKey(EXTRA_TINT_LIST) == false) goto L6;
        r11.mTintList = (ColorStateList) r5.getParcelable(EXTRA_TINT_LIST);
    L6:
        if (r5.containsKey(EXTRA_TINT_MODE) == false) goto L9;
        r11.mTintMode = PorterDuff.Mode.valueOf(r5.getString(EXTRA_TINT_MODE));
    L9:
        switch(r10) {
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
        Log.w(TAG, "Unknown type " + r10);
        return null;
    L12:
        r11.mObj1 = r5.getByteArray(EXTRA_OBJ);
    L15:
        return r11;
    L13:
        r11.mObj1 = r5.getString(EXTRA_OBJ);
        goto L15
    L14:
        r11.mObj1 = r5.getParcelable(EXTRA_OBJ);
        goto L15
    }

    @Nullable
    @RequiresApi(23)
    public static IconCompat createFromIcon(@NonNull Context r5, @NonNull Icon r10) {
        Preconditions.checkNotNull(r10);
        return Api23Impl.createFromIcon(r5, r10);
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIconOrNullIfZeroResId(@NonNull Icon r5) {
        if (Api23Impl.getType(r5) != 2) goto L9;
        if (Api23Impl.getResId(r5) != 0) goto L9;
        return null;
    L9:
        return Api23Impl.createFromIconInner(r5);
    }

    @VisibleForTesting
    public static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap r10, boolean r11) {
        int r5 = (int) (Math.min(r10.getWidth(), r10.getHeight()) * DEFAULT_VIEW_PORT_SCALE);
        Bitmap r12 = Bitmap.createBitmap(r5, r5, Bitmap.Config.ARGB_8888);
        Canvas r13 = new Canvas(r12);
        Paint r14 = new Paint(3);
        float r15 = r5;
        float r16 = 0.5f * r15;
        float r17 = ICON_DIAMETER_FACTOR * r16;
        if (r11 == false) goto L5;
        float r18 = BLUR_FACTOR * r15;
        r14.setColor(0);
        r14.setShadowLayer(r18, 0.0f, r15 * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
        r13.drawCircle(r16, r16, r17, r14);
        r14.setShadowLayer(r18, 0.0f, 0.0f, 503316480);
        r13.drawCircle(r16, r16, r17, r14);
        r14.clearShadowLayer();
    L5:
        r14.setColor(ViewCompat.MEASURED_STATE_MASK);
        Shader.TileMode r19 = Shader.TileMode.CLAMP;
        BitmapShader r110 = new BitmapShader(r10, r19, r19);
        Matrix r20 = new Matrix();
        r20.setTranslate((-(r10.getWidth() - r5)) / 2.0f, (-(r10.getHeight() - r5)) / 2.0f);
        r110.setLocalMatrix(r20);
        r14.setShader(r110);
        r13.drawCircle(r16, r16, r17, r14);
        r13.setBitmap(null);
        return r12;
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmap(@NonNull Bitmap r5) {
        ObjectsCompat.requireNonNull(r5);
        IconCompat r10 = new IconCompat(5);
        r10.mObj1 = r5;
        return r10;
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull String r5) {
        ObjectsCompat.requireNonNull(r5);
        IconCompat r10 = new IconCompat(6);
        r10.mObj1 = r5;
        return r10;
    }

    @NonNull
    public static IconCompat createWithBitmap(@NonNull Bitmap r5) {
        ObjectsCompat.requireNonNull(r5);
        IconCompat r10 = new IconCompat(1);
        r10.mObj1 = r5;
        return r10;
    }

    @NonNull
    public static IconCompat createWithContentUri(@NonNull String r5) {
        ObjectsCompat.requireNonNull(r5);
        IconCompat r10 = new IconCompat(4);
        r10.mObj1 = r5;
        return r10;
    }

    @NonNull
    public static IconCompat createWithData(@NonNull byte[] r5, int r10, int r11) {
        ObjectsCompat.requireNonNull(r5);
        IconCompat r12 = new IconCompat(3);
        r12.mObj1 = r5;
        r12.mInt1 = r10;
        r12.mInt2 = r11;
        return r12;
    }

    @NonNull
    public static IconCompat createWithResource(@NonNull Context r5, @DrawableRes int r10) {
        ObjectsCompat.requireNonNull(r5);
        return createWithResource(r5.getResources(), r5.getPackageName(), r10);
    }

    public static Resources getResources(Context r5, String r10) {
        if ("android".equals(r10) == true) goto L5;
        PackageManager r11 = r5.getPackageManager();
        ApplicationInfo r12 = r11.getApplicationInfo(r10, 8192);     // Catch: PackageManager.NameNotFoundException -> L11
        if (r12 == null) goto L13;
        return r11.getResourcesForApplication(r12);
    L13:
        return null;
    L11:
        e = move-exception;
        Log.e(TAG, "Unable to find pkg=" + r10 + " for icon", e);
        return null;
    L5:
        return Resources.getSystem();
    }

    private Drawable loadDrawableInner(Context r5) {
        switch(this.mType) {
            case 1: goto L27;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L5;
            default: goto L25;
        };
    L5:
        InputStream r10 = getUriInputStream(r5);
        if (r10 == null) goto L25;
        return Api26Impl.createAdaptiveIconDrawable(null, new BitmapDrawable(r5.getResources(), BitmapFactory.decodeStream(r10)));
    L11:
        InputStream r11 = getUriInputStream(r5);
        if (r11 == null) goto L25;
        return new BitmapDrawable(r5.getResources(), BitmapFactory.decodeStream(r11));
    L17:
        String r12 = getResPackage();
        if (TextUtils.isEmpty(r12) == false) goto L20;
        r12 = r5.getPackageName();
    L20:
        Resources r13 = getResources(r5, r12);
        return ResourcesCompat.getDrawable(r13, this.mInt1, r5.getTheme());
    L23:
        e = move-exception;
        Log.e(TAG, String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.mInt1), this.mObj1}), e);
    L25:
        return null;
    L10:
        return new BitmapDrawable(r5.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
    L16:
        return new BitmapDrawable(r5.getResources(), BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
    L27:
        return new BitmapDrawable(r5.getResources(), (Bitmap) this.mObj1);
    }

    private static String typeToString(int r5) {
        switch(r5) {
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
    public void addToShortcutIntent(@NonNull Intent r5, @Nullable Drawable r10, @NonNull Context r11) {
        checkResource(r11);
        int r12 = this.mType;
        if (r12 != 1) goto L5;
        Bitmap r13 = (Bitmap) this.mObj1;
        if (r10 == null) goto L31;
        r13 = r13.copy(r13.getConfig(), true);
    L31:
        if (r10 == null) goto L33;
        int r14 = r13.getWidth();
        int r15 = r13.getHeight();
        r10.setBounds(r14 / 2, r15 / 2, r14, r15);
        r10.draw(new Canvas(r13));
    L33:
        r5.putExtra("android.intent.extra.shortcut.ICON", r13);
        return;
    L5:
        if (r12 != 2) goto L7;
        Context r16 = r11.createPackageContext(getResPackage(), 0);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r10 != null) goto L17;
        r5.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(r16, this.mInt1));     // Catch: PackageManager.NameNotFoundException -> L15
        return;
    L17:
        Drawable r17 = ContextCompat.getDrawable(r16, this.mInt1);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r17.getIntrinsicWidth() > 0) goto L20;
    L23:
        int r18 = ((ActivityManager) r16.getSystemService("activity")).getLauncherLargeIconSize();     // Catch: PackageManager.NameNotFoundException -> L15
        Bitmap r19 = Bitmap.createBitmap(r18, r18, Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L15
    L24:
        r17.setBounds(0, 0, r19.getWidth(), r19.getHeight());     // Catch: PackageManager.NameNotFoundException -> L15
        r17.draw(new Canvas(r19));     // Catch: PackageManager.NameNotFoundException -> L15
        r13 = r19;
        goto L31
    L20:
        if (r17.getIntrinsicHeight() <= 0) goto L23;
        r19 = Bitmap.createBitmap(r17.getIntrinsicWidth(), r17.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L15
    L15:
        e = move-exception;
        throw new IllegalArgumentException("Can't find package " + this.mObj1, e);
    L7:
        if (r12 != 5) goto L10;
        r13 = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
        goto L31
    L10:
        throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void checkResource(@NonNull Context r10) {
        if (this.mType != 2) goto L17;
        Object r5 = this.mObj1;
        if (r5 == null) goto L18;
        String r11 = (String) r5;
        if (r11.contains(":") == true) goto L9;
        return;
    L9:
        String r12 = r11.split(":", -1)[1];
        String r13 = r12.split("/", -1)[0];
        String r14 = r12.split("/", -1)[1];
        String r15 = r11.split(":", -1)[0];
        if ("0_resource_name_obfuscated".equals(r14) == false) goto L13;
        Log.i(TAG, "Found obfuscated resource, not trying to update resource id for it");
        return;
    L13:
        String r16 = getResPackage();
        int r17 = getResources(r10, r16).getIdentifier(r14, r13, r15);
        if (this.mInt1 == r17) goto L19;
        Log.i(TAG, "Id has changed for " + r16 + " " + r11);
        this.mInt1 = r17;
        return;
    L19:
        return;
    L18:
        return;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bitmap getBitmap() {
        int r5 = this.mType;
        if (r5 != (-1)) goto L11;
        Object r10 = this.mObj1;
        if ((r10 instanceof Bitmap) == true) goto L7;
        return null;
    L7:
        return (Bitmap) r10;
    L11:
        if (r5 != 1) goto L15;
        return (Bitmap) this.mObj1;
    L15:
        if (r5 != 5) goto L19;
        return createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
    L19:
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    @DrawableRes
    public int getResId() {
        int r5 = this.mType;
        if (r5 != (-1)) goto L7;
        return Api23Impl.getResId(this.mObj1);
    L7:
        if (r5 != 2) goto L11;
        return this.mInt1;
    L11:
        throw new IllegalStateException("called getResId() on " + this);
    }

    @NonNull
    public String getResPackage() {
        int r5 = this.mType;
        if (r5 != (-1)) goto L7;
        return Api23Impl.getResPackage(this.mObj1);
    L7:
        if (r5 != 2) goto L18;
        String r10 = this.mString1;
        if (r10 == null) goto L16;
        if (TextUtils.isEmpty(r10) == true) goto L16;
        return this.mString1;
    L16:
        return ((String) this.mObj1).split(":", -1)[0];
    L18:
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        int r5 = this.mType;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        return Api23Impl.getType(this.mObj1);
    }

    @NonNull
    public Uri getUri() {
        int r5 = this.mType;
        if (r5 != (-1)) goto L7;
        return Api23Impl.getUri(this.mObj1);
    L7:
        if (r5 == 4) goto L14;
        if (r5 == 6) goto L14;
        throw new IllegalStateException("called getUri() on " + this);
    L14:
        return Uri.parse((String) this.mObj1);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InputStream getUriInputStream(@NonNull Context r5) {
        Uri r10 = getUri();
        String r11 = r10.getScheme();
        if ("content".equals(r11) == false) goto L5;
    L17:
        return r5.getContentResolver().openInputStream(r10);
    L13:
        e = move-exception;
        Log.w(TAG, "Unable to load image from URI: " + r10, e);
        return null;
    L5:
        if ("file".equals(r11) == true) goto L17;
        return new FileInputStream(new File((String) this.mObj1));
    L9:
        e = move-exception;
        Log.w(TAG, "Unable to load image from path: " + r10, e);
        return null;
    }

    @Nullable
    public Drawable loadDrawable(@NonNull Context r5) {
        checkResource(r5);
        return Api23Impl.loadDrawable(toIcon(r5), r5);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
        switch(this.mType) {
            case -1: goto L15;
            case 0: goto L27;
            case 1: goto L11;
            case 2: goto L6;
            case 3: goto L5;
            case 4: goto L6;
            case 5: goto L11;
            case 6: goto L6;
            default: goto L27;
        };
    L5:
        this.mObj1 = this.mData;
        return;
    L6:
        String r5 = new String(this.mData, Charset.forName("UTF-16"));
        this.mObj1 = r5;
        if (this.mType == 2) goto L9;
        return;
    L9:
        if (this.mString1 != null) goto L23;
        this.mString1 = r5.split(":", -1)[0];
        return;
    L23:
        return;
    L11:
        Parcelable r10 = this.mParcelable;
        if (r10 == null) goto L14;
        this.mObj1 = r10;
        return;
    L14:
        byte[] r11 = this.mData;
        this.mObj1 = r11;
        this.mType = 3;
        this.mInt1 = 0;
        this.mInt2 = r11.length;
        return;
    L15:
        Parcelable r12 = this.mParcelable;
        if (r12 == null) goto L20;
        this.mObj1 = r12;
        return;
    L20:
        throw new IllegalArgumentException("Invalid icon");
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean r5) {
        this.mTintModeStr = this.mTintMode.name();
        switch(this.mType) {
            case -1: goto L11;
            case 0: goto L21;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L5;
            case 5: goto L8;
            case 6: goto L5;
            default: goto L21;
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
        if (r5 == false) goto L10;
        Bitmap r10 = (Bitmap) this.mObj1;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        r10.compress(Bitmap.CompressFormat.PNG, 90, r11);
        this.mData = r11.toByteArray();
        return;
    L10:
        this.mParcelable = (Parcelable) this.mObj1;
        return;
    L11:
        if (r5 == true) goto L15;
        this.mParcelable = (Parcelable) this.mObj1;
        return;
    L15:
        throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
    }

    @NonNull
    public IconCompat setTint(@ColorInt int r5) {
        return setTintList(ColorStateList.valueOf(r5));
    }

    @NonNull
    public IconCompat setTintList(@Nullable ColorStateList r5) {
        this.mTintList = r5;
        return this;
    }

    @NonNull
    public IconCompat setTintMode(@Nullable PorterDuff.Mode r5) {
        this.mTintMode = r5;
        return this;
    }

    @NonNull
    public Bundle toBundle() {
        Bundle r5 = new Bundle();
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
        r5.putByteArray(EXTRA_OBJ, (byte[]) this.mObj1);
    L10:
        r5.putInt("type", this.mType);
        r5.putInt(EXTRA_INT1, this.mInt1);
        r5.putInt(EXTRA_INT2, this.mInt2);
        r5.putString(EXTRA_STRING1, this.mString1);
        ColorStateList r10 = this.mTintList;
        if (r10 == null) goto L13;
        r5.putParcelable(EXTRA_TINT_LIST, r10);
    L13:
        PorterDuff.Mode r11 = this.mTintMode;
        if (r11 == DEFAULT_TINT_MODE) goto L16;
        r5.putString(EXTRA_TINT_MODE, r11.name());
    L16:
        return r5;
    L7:
        r5.putString(EXTRA_OBJ, (String) this.mObj1);
        goto L10
    L8:
        r5.putParcelable(EXTRA_OBJ, (Bitmap) this.mObj1);
        goto L10
    L9:
        r5.putParcelable(EXTRA_OBJ, (Parcelable) this.mObj1);
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
    public String toString() {
        if (this.mType == (-1)) goto L5;
        StringBuilder r5 = new StringBuilder("Icon(typ=");
        r5.append(typeToString(this.mType));
        switch(this.mType) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L14;
            case 6: goto L9;
            default: goto L16;
        };
    L9:
        r5.append(" uri=");
        r5.append(this.mObj1);
        goto L16
    L10:
        r5.append(" len=");
        r5.append(this.mInt1);
        if (this.mInt2 == 0) goto L16;
        r5.append(" off=");
        r5.append(this.mInt2);
        goto L16
    L13:
        r5.append(" pkg=");
        r5.append(this.mString1);
        r5.append(" id=");
        r5.append(String.format("0x%08x", new Object[]{Integer.valueOf(getResId())}));
        goto L16
    L14:
        r5.append(" size=");
        r5.append(((Bitmap) this.mObj1).getWidth());
        r5.append("x");
        r5.append(((Bitmap) this.mObj1).getHeight());
    L16:
        if (this.mTintList == null) goto L19;
        r5.append(" tint=");
        r5.append(this.mTintList);
    L19:
        if (this.mTintMode == DEFAULT_TINT_MODE) goto L21;
        r5.append(" mode=");
        r5.append(this.mTintMode);
    L21:
        r5.append(")");
        return r5.toString();
    L5:
        return String.valueOf(this.mObj1);
    }

    @NonNull
    @RequiresApi(23)
    public Icon toIcon(@Nullable Context r5) {
        return Api23Impl.toIcon(this, r5);
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIcon(@NonNull Icon r5) {
        return Api23Impl.createFromIconInner(r5);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createWithResource(@Nullable Resources r5, @NonNull String r10, @DrawableRes int r11) {
        ObjectsCompat.requireNonNull(r10);
        if (r11 == 0) goto L14;
        IconCompat r12 = new IconCompat(2);
        r12.mInt1 = r11;
        if (r5 != null) goto L15;
        r12.mObj1 = r10;
    L11:
        r12.mString1 = r10;
        return r12;
    L15:
        r12.mObj1 = r5.getResourceName(r11);     // Catch: Resources.NotFoundException -> L8
    L9:
        throw new IllegalArgumentException("Icon resource cannot be found");
    L14:
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull Uri r5) {
        ObjectsCompat.requireNonNull(r5);
        return createWithAdaptiveBitmapContentUri(r5.toString());
    }

    @NonNull
    public static IconCompat createWithContentUri(@NonNull Uri r5) {
        ObjectsCompat.requireNonNull(r5);
        return createWithContentUri(r5.toString());
    }

    public IconCompat(int r5) {
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = r5;
    }
}
