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
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = null;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    static final String EXTRA_INT1 = "int1";
    static final String EXTRA_INT2 = "int2";
    static final String EXTRA_OBJ = "obj";
    static final String EXTRA_STRING1 = "string1";
    static final String EXTRA_TINT_LIST = "tint_list";
    static final String EXTRA_TINT_MODE = "tint_mode";
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
    public byte[] mData;
    public int mInt1;
    public int mInt2;
    Object mObj1;
    public Parcelable mParcelable;
    public String mString1;
    public ColorStateList mTintList;
    PorterDuff.Mode mTintMode;
    public String mTintModeStr;
    public int mType;

    static class Api23Impl {
        private Api23Impl() {
        }

        static IconCompat createFromIcon(Context r2, Icon r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            int r0 = getType(r3);
            if (r0 != 2) goto L5;
            String r1 = getResPackage(r3);
            return IconCompat.createWithResource(IconCompat.getResources(r4, r1), r1, getResId(r3));
        L18:
            throw new IllegalArgumentException("Icon resource cannot be found");
        L5:
            if (r0 == 4) goto L13;
            if (r0 == 6) goto L11;
            IconCompat r5 = new IconCompat(-1);
            r5.mObj1 = r3;
            return r5;
        L11:
            return IconCompat.createWithAdaptiveBitmapContentUri(getUri(r3));
        L13:
            return IconCompat.createWithContentUri(getUri(r3));
        }

        static IconCompat createFromIconInner(Object r2) {
            Preconditions.checkNotNull(r2);
            int r0 = getType(r2);
            if (r0 == 2) goto L15;
            if (r0 == 4) goto L13;
            if (r0 == 6) goto L11;
            IconCompat r1 = new IconCompat(-1);
            r1.mObj1 = r2;
            return r1;
        L11:
            return IconCompat.createWithAdaptiveBitmapContentUri(getUri(r2));
        L13:
            return IconCompat.createWithContentUri(getUri(r2));
        L15:
            return IconCompat.createWithResource(null, getResPackage(r2), getResId(r2));
        }

        static int getResId(Object r6) {
            if (Build.VERSION.SDK_INT < 28) goto L18;
            return Api28Impl.getResId(r6);
        L18:
            return ((Integer) ZeusTransformUtils.preCheckCast(r6.getClass().getMethod("getResId", new Class[0]).invoke(r6, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();
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

        static String getResPackage(Object r7) {
            if (Build.VERSION.SDK_INT < 28) goto L18;
            return Api28Impl.getResPackage(r7);
        L18:
            return (String) ZeusTransformUtils.preCheckCast(r7.getClass().getMethod("getResPackage", new Class[0]).invoke(r7, new Object[0]), String.class, "com.obric.memorydata.plugin");
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

        static int getType(Object r7) {
            if (Build.VERSION.SDK_INT < 28) goto L17;
            return Api28Impl.getType(r7);
        L17:
            return ((Integer) ZeusTransformUtils.preCheckCast(r7.getClass().getMethod("getType", new Class[0]).invoke(r7, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();
        L15:
            e = e;
            StringBuilder r4 = new StringBuilder();
        L11:
            Log.e(IconCompat.TAG, r4.append("Unable to get icon type ").append(r7).toString(), e);
            return -1;
        L9:
            e = e;
            r4 = new StringBuilder();
        L13:
            e = e;
            r4 = new StringBuilder();
            goto L11
        }

        static Uri getUri(Object r7) {
            if (Build.VERSION.SDK_INT < 28) goto L18;
            return Api28Impl.getUri(r7);
        L18:
            return (Uri) ZeusTransformUtils.preCheckCast(r7.getClass().getMethod("getUri", new Class[0]).invoke(r7, new Object[0]), Uri.class, "com.obric.memorydata.plugin");
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

        static Drawable loadDrawable(Icon r2, Context r3) {
            return r2.loadDrawable((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        }

        static Icon toIcon(IconCompat r4, Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            switch(r4.mType) {
                case -1: goto L38;
                case 0: goto L5;
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L20;
                case 6: goto L7;
                default: goto L5;
            };
        L25:
            Icon r7 = Icon.createWithContentUri((String) ZeusTransformUtils.preCheckCast(r4.mObj1, String.class, "com.obric.memorydata.plugin"));
        L31:
            if (r4.mTintList == null) goto L34;
            r7.setTintList(r4.mTintList);
        L34:
            if (r4.mTintMode == IconCompat.DEFAULT_TINT_MODE) goto L36;
            r7.setTintMode(r4.mTintMode);
        L36:
            return r7;
        L26:
            r7 = Icon.createWithData((byte[]) ZeusTransformUtils.preCheckCast(r4.mObj1, byte[].class, "com.obric.memorydata.plugin"), r4.mInt1, r4.mInt2);
            goto L31
        L27:
            r7 = Icon.createWithResource(r4.getResPackage(), r4.mInt1);
            goto L31
        L28:
            Bitmap r8 = (Bitmap) ZeusTransformUtils.preCheckCast(r4.mObj1, Bitmap.class, "com.obric.memorydata.plugin");
        L29:
            r7 = Icon.createWithBitmap(r8);
            goto L31
        L5:
            throw new IllegalArgumentException("Unknown type");
        L7:
            if (Build.VERSION.SDK_INT < 30) goto L9;
            r7 = Api30Impl.createWithAdaptiveBitmapContentUri(r4.getUri());
            goto L31
        L9:
            if (r6 == null) goto L18;
            InputStream r9 = r4.getUriInputStream(r6);
            if (r9 == null) goto L16;
            int r0 = Build.VERSION.SDK_INT;
            Bitmap r10 = BitmapFactory.decodeStream(r9);
            if (r0 >= 26) goto L22;
        L24:
            r8 = IconCompat.createLegacyIconFromAdaptiveIcon(r10, false);
        L22:
            r7 = Api26Impl.createWithAdaptiveBitmap(r10);
            goto L31
        L16:
            throw new IllegalStateException("Cannot load adaptive icon from uri: " + r4.getUri());
        L18:
            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + r4.getUri());
        L20:
            if (Build.VERSION.SDK_INT < 26) goto L23;
            r10 = (Bitmap) ZeusTransformUtils.preCheckCast(r4.mObj1, Bitmap.class, "com.obric.memorydata.plugin");
            goto L22
        L23:
            r10 = (Bitmap) ZeusTransformUtils.preCheckCast(r4.mObj1, Bitmap.class, "com.obric.memorydata.plugin");
            goto L24
        L38:
            return (Icon) ZeusTransformUtils.preCheckCast(r4.mObj1, Icon.class, "com.obric.memorydata.plugin");
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Drawable createAdaptiveIconDrawable(Drawable r1, Drawable r2) {
            return new AdaptiveIconDrawable(r1, r2);
        }

        static Icon createWithAdaptiveBitmap(Bitmap r0) {
            return Icon.createWithAdaptiveBitmap(r0);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static int getResId(Object r2) {
            return ((Icon) ZeusTransformUtils.preCheckCast(r2, Icon.class, "com.obric.memorydata.plugin")).getResId();
        }

        static String getResPackage(Object r2) {
            return ((Icon) ZeusTransformUtils.preCheckCast(r2, Icon.class, "com.obric.memorydata.plugin")).getResPackage();
        }

        static int getType(Object r2) {
            return ((Icon) ZeusTransformUtils.preCheckCast(r2, Icon.class, "com.obric.memorydata.plugin")).getType();
        }

        static Uri getUri(Object r2) {
            return ((Icon) ZeusTransformUtils.preCheckCast(r2, Icon.class, "com.obric.memorydata.plugin")).getUri();
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Icon createWithAdaptiveBitmapContentUri(Uri r0) {
            return Icon.createWithAdaptiveBitmapContentUri(r0);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconType {
    }

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

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

    IconCompat(int r3) {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = r3;
    }

    public static IconCompat createFromBundle(Bundle r5) {
        int r0 = r5.getInt("type");
        IconCompat r1 = new IconCompat(r0);
        r1.mInt1 = r5.getInt(EXTRA_INT1);
        r1.mInt2 = r5.getInt(EXTRA_INT2);
        r1.mString1 = r5.getString(EXTRA_STRING1);
        if (r5.containsKey(EXTRA_TINT_LIST) == false) goto L6;
        r1.mTintList = (ColorStateList) ZeusTransformUtils.preCheckCast(r5.getParcelable(EXTRA_TINT_LIST), ColorStateList.class, "com.obric.memorydata.plugin");
    L6:
        if (r5.containsKey(EXTRA_TINT_MODE) == false) goto L9;
        r1.mTintMode = PorterDuff.Mode.valueOf(r5.getString(EXTRA_TINT_MODE));
    L9:
        switch(r0) {
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
        Log.w(TAG, "Unknown type " + r0);
        return null;
    L12:
        r1.mObj1 = r5.getByteArray(EXTRA_OBJ);
    L16:
        return r1;
    L13:
        Object r6 = r5.getString(EXTRA_OBJ);
    L15:
        r1.mObj1 = r6;
        goto L16
    L14:
        r6 = r5.getParcelable(EXTRA_OBJ);
        goto L15
    }

    public static IconCompat createFromIcon(Context r2, Icon r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Preconditions.checkNotNull(r3);
        return Api23Impl.createFromIcon(r4, r3);
    }

    public static IconCompat createFromIcon(Icon r0) {
        return Api23Impl.createFromIconInner(r0);
    }

    public static IconCompat createFromIconOrNullIfZeroResId(Icon r2) {
        if (Api23Impl.getType(r2) != 2) goto L9;
        if (Api23Impl.getResId(r2) != 0) goto L9;
        return null;
    L9:
        return Api23Impl.createFromIconInner(r2);
    }

    static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap r9, boolean r10) {
        int r0 = (int) (Math.min(r9.getWidth(), r9.getHeight()) * DEFAULT_VIEW_PORT_SCALE);
        Bitmap r1 = Bitmap.createBitmap(r0, r0, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        Paint r3 = new Paint(3);
        float r4 = r0;
        float r5 = 0.5f * r4;
        float r6 = ICON_DIAMETER_FACTOR * r5;
        if (r10 == false) goto L5;
        float r11 = BLUR_FACTOR * r4;
        r3.setColor(0);
        r3.setShadowLayer(r11, 0.0f, r4 * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
        r2.drawCircle(r5, r5, r6, r3);
        r3.setShadowLayer(r11, 0.0f, 0.0f, 503316480);
        r2.drawCircle(r5, r5, r6, r3);
        r3.clearShadowLayer();
    L5:
        r3.setColor(ViewCompat.MEASURED_STATE_MASK);
        BitmapShader r12 = new BitmapShader(r9, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix r7 = new Matrix();
        r7.setTranslate((-(r9.getWidth() - r0)) / 2.0f, (-(r9.getHeight() - r0)) / 2.0f);
        r12.setLocalMatrix(r7);
        r3.setShader(r12);
        r2.drawCircle(r5, r5, r6, r3);
        r2.setBitmap(null);
        return r1;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap r2) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(5);
        r0.mObj1 = r2;
        return r0;
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(Uri r0) {
        ObjectsCompat.requireNonNull(r0);
        return createWithAdaptiveBitmapContentUri(r0.toString());
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(String r2) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(6);
        r0.mObj1 = r2;
        return r0;
    }

    public static IconCompat createWithBitmap(Bitmap r2) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(1);
        r0.mObj1 = r2;
        return r0;
    }

    public static IconCompat createWithContentUri(Uri r0) {
        ObjectsCompat.requireNonNull(r0);
        return createWithContentUri(r0.toString());
    }

    public static IconCompat createWithContentUri(String r2) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(4);
        r0.mObj1 = r2;
        return r0;
    }

    public static IconCompat createWithData(byte[] r2, int r3, int r4) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(3);
        r0.mObj1 = r2;
        r0.mInt1 = r3;
        r0.mInt2 = r4;
        return r0;
    }

    public static IconCompat createWithResource(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        ObjectsCompat.requireNonNull(r4);
        return createWithResource(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin"), r4.getPackageName(), r3);
    }

    public static IconCompat createWithResource(Resources r2, String r3, int r4) {
        ObjectsCompat.requireNonNull(r3);
        if (r4 == 0) goto L14;
        IconCompat r0 = new IconCompat(2);
        r0.mInt1 = r4;
        if (r2 != null) goto L15;
        r0.mObj1 = r3;
    L11:
        r0.mString1 = r3;
        return r0;
    L15:
        r0.mObj1 = r2.getResourceName(r4);     // Catch: Resources.NotFoundException -> L8
    L9:
        throw new IllegalArgumentException("Icon resource cannot be found");
    L14:
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    static Resources getResources(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if ("android".equals(r4) == true) goto L5;
        PackageManager r6 = r5.getPackageManager();
        ApplicationInfo r0 = r6.getApplicationInfo(r4, 8192);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r0 == null) goto L11;
        return r6.getResourcesForApplication(r0);
    L11:
        return null;
    L12:
        e = move-exception;
        Log.e(TAG, String.format("Unable to find pkg=%s for icon", new Object[]{r4}), e);
        return null;
    L5:
        return Resources.getSystem();
    }

    private Drawable loadDrawableInner(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
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
        InputStream r5 = getUriInputStream(r7);
        if (r5 == null) goto L31;
        if (Build.VERSION.SDK_INT < 26) goto L12;
        return Api26Impl.createAdaptiveIconDrawable(null, new BitmapDrawable(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin"), BitmapFactory.decodeStream(r5)));
    L12:
        return new BitmapDrawable(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin"), createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream(r5), false));
    L15:
        InputStream r8 = getUriInputStream(r7);
        if (r8 == null) goto L31;
        return new BitmapDrawable(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin"), BitmapFactory.decodeStream(r8));
    L21:
        String r0 = getResPackage();
        if (TextUtils.isEmpty(r0) == false) goto L32;
        r0 = r7.getPackageName();
    L32:
        return ResourcesCompat.getDrawable(getResources(r7, r0), this.mInt1, r7.getTheme());
    L27:
        e = move-exception;
        Log.e(TAG, String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.mInt1), this.mObj1}), e);
    L31:
        return null;
    L14:
        return new BitmapDrawable(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin"), createLegacyIconFromAdaptiveIcon((Bitmap) ZeusTransformUtils.preCheckCast(this.mObj1, Bitmap.class, "com.obric.memorydata.plugin"), false));
    L20:
        return new BitmapDrawable(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin"), BitmapFactory.decodeByteArray((byte[]) ZeusTransformUtils.preCheckCast(this.mObj1, byte[].class, "com.obric.memorydata.plugin"), this.mInt1, this.mInt2));
    L30:
        return new BitmapDrawable(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin"), (Bitmap) ZeusTransformUtils.preCheckCast(this.mObj1, Bitmap.class, "com.obric.memorydata.plugin"));
    }

    private static String typeToString(int r0) {
        switch(r0) {
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

    public void addToShortcutIntent(Intent r5, Drawable r6, Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        checkResource(r8);
        int r0 = this.mType;
        if (r0 != 1) goto L5;
        Bitmap r4 = (Bitmap) ZeusTransformUtils.preCheckCast(this.mObj1, Bitmap.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L30;
        r4 = r4.copy(r4.getConfig(), true);
    L30:
        if (r6 == null) goto L32;
        int r9 = r4.getWidth();
        int r1 = r4.getHeight();
        r6.setBounds(r9 / 2, r1 / 2, r9, r1);
        r6.draw(new Canvas(r4));
    L32:
        r5.putExtra("android.intent.extra.shortcut.ICON", r4);
        return;
    L5:
        if (r0 != 2) goto L7;
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.createPackageContext(getResPackage(), 0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: PackageManager.NameNotFoundException -> L24
        if (r6 != null) goto L15;
        r5.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(r10, this.mInt1));     // Catch: PackageManager.NameNotFoundException -> L24
        return;
    L15:
        Drawable r2 = ContextCompat.getDrawable(r10, this.mInt1);     // Catch: PackageManager.NameNotFoundException -> L24
        if (r2.getIntrinsicWidth() > 0) goto L18;
    L21:
        int r11 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r10.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin")).getLauncherLargeIconSize();     // Catch: PackageManager.NameNotFoundException -> L24
        Bitmap r12 = Bitmap.createBitmap(r11, r11, Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L24
    L22:
        r2.setBounds(0, 0, r12.getWidth(), r12.getHeight());     // Catch: PackageManager.NameNotFoundException -> L24
        r2.draw(new Canvas(r12));     // Catch: PackageManager.NameNotFoundException -> L24
        r4 = r12;
        goto L30
    L18:
        if (r2.getIntrinsicHeight() <= 0) goto L21;
        r12 = Bitmap.createBitmap(r2.getIntrinsicWidth(), r2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L24
    L24:
        e = move-exception;
        throw new IllegalArgumentException("Can't find package " + this.mObj1, e);
    L7:
        if (r0 != 5) goto L10;
        r4 = createLegacyIconFromAdaptiveIcon((Bitmap) ZeusTransformUtils.preCheckCast(this.mObj1, Bitmap.class, "com.obric.memorydata.plugin"), true);
        goto L30
    L10:
        throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
    }

    public void checkResource(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (this.mType != 2) goto L17;
        Object r0 = this.mObj1;
        if (r0 == null) goto L18;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        if (r1.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) == true) goto L9;
        return;
    L9:
        String r4 = r1.split(ParameterizedMessage.ERROR_MSG_SEPARATOR, -1)[1];
        String r7 = r4.split("/", -1)[0];
        String r5 = r4.split("/", -1)[1];
        String r2 = r1.split(ParameterizedMessage.ERROR_MSG_SEPARATOR, -1)[0];
        if ("0_resource_name_obfuscated".equals(r5) == false) goto L13;
        Log.i(TAG, "Found obfuscated resource, not trying to update resource id for it");
        return;
    L13:
        String r3 = getResPackage();
        int r12 = ZeusTransformUtils.getIdentifier(getResources(r11, r3), r5, r7, r2, "com.obric.memorydata.plugin");
        if (this.mInt1 == r12) goto L19;
        Log.i(TAG, "Id has changed for " + r3 + " " + r1);
        this.mInt1 = r12;
        return;
    L19:
        return;
    L18:
        return;
    }

    public Bitmap getBitmap() {
        if (this.mType == (-1)) goto L5;
    L12:
        int r0 = this.mType;
        if (r0 != 1) goto L17;
        return (Bitmap) ZeusTransformUtils.preCheckCast(this.mObj1, Bitmap.class, "com.obric.memorydata.plugin");
    L17:
        if (r0 != 5) goto L21;
        return createLegacyIconFromAdaptiveIcon((Bitmap) ZeusTransformUtils.preCheckCast(this.mObj1, Bitmap.class, "com.obric.memorydata.plugin"), true);
    L21:
        throw new IllegalStateException("called getBitmap() on " + this);
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        if (ZeusTransformUtils.instanceOf(this.mObj1, Bitmap.class) == true) goto L9;
        return null;
    L9:
        return (Bitmap) ZeusTransformUtils.preCheckCast(this.mObj1, Bitmap.class, "com.obric.memorydata.plugin");
    }

    public int getResId() {
        if (this.mType != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getResId(this.mObj1);
    L9:
        if (this.mType != 2) goto L13;
        return this.mInt1;
    L13:
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String getResPackage() {
        if (this.mType != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getResPackage(this.mObj1);
    L9:
        if (this.mType != 2) goto L20;
        String r0 = this.mString1;
        if (r0 == null) goto L18;
        if (TextUtils.isEmpty(r0) == true) goto L18;
        return this.mString1;
    L18:
        return ((String) ZeusTransformUtils.preCheckCast(this.mObj1, String.class, "com.obric.memorydata.plugin")).split(ParameterizedMessage.ERROR_MSG_SEPARATOR, -1)[0];
    L20:
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        if (this.mType != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getType(this.mObj1);
    L9:
        return this.mType;
    }

    public Uri getUri() {
        if (this.mType == (-1)) goto L5;
    L8:
        int r0 = this.mType;
        if (r0 == 4) goto L16;
        if (r0 == 6) goto L16;
        throw new IllegalStateException("called getUri() on " + this);
    L16:
        return Uri.parse((String) ZeusTransformUtils.preCheckCast(this.mObj1, String.class, "com.obric.memorydata.plugin"));
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        return Api23Impl.getUri(this.mObj1);
    }

    public InputStream getUriInputStream(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Uri r0 = getUri();
        String r2 = r0.getScheme();
        if (Params.CONTENT.equals(r2) == false) goto L5;
    L17:
        return r7.getContentResolver().openInputStream(r0);
    L13:
        e = e;
        StringBuilder r8 = new StringBuilder();
        String r1 = "Unable to load image from URI: ";
    L15:
        Log.w(TAG, r8.append(r1).append(r0).toString(), e);
        return null;
    L5:
        if ("file".equals(r2) == true) goto L17;
        return new FileInputStream(new File((String) ZeusTransformUtils.preCheckCast(this.mObj1, String.class, "com.obric.memorydata.plugin")));
    L9:
        e = e;
        r8 = new StringBuilder();
        r1 = "Unable to load image from path: ";
        goto L15
    }

    public Drawable loadDrawable(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        checkResource(r4);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Drawable r5 = loadDrawableInner(r4);
        if (r5 != null) goto L9;
    L13:
        return r5;
    L9:
        if (this.mTintList == null) goto L11;
    L12:
        r5.mutate();
        DrawableCompat.setTintList(r5, this.mTintList);
        DrawableCompat.setTintMode(r5, this.mTintMode);
        goto L13
    L11:
        if (this.mTintMode == DEFAULT_TINT_MODE) goto L13;
    L5:
        return Api23Impl.loadDrawable(toIcon(r4), r4);
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
        String r0 = new String(this.mData, Charset.forName("UTF-16"));
        this.mObj1 = r0;
        if (this.mType == 2) goto L9;
        return;
    L9:
        if (this.mString1 != null) goto L22;
        this.mString1 = ((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin")).split(ParameterizedMessage.ERROR_MSG_SEPARATOR, -1)[0];
        return;
    L22:
        return;
    L11:
        Parcelable r1 = this.mParcelable;
        if (r1 != null) goto L17;
        byte[] r2 = this.mData;
        this.mObj1 = r2;
        this.mType = 3;
        this.mInt1 = 0;
        this.mInt2 = r2.length;
        return;
    L17:
        this.mObj1 = r1;
        return;
    L15:
        r1 = this.mParcelable;
        if (r1 != null) goto L17;
        throw new IllegalArgumentException("Invalid icon");
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean r4) {
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
        this.mData = (byte[]) ZeusTransformUtils.preCheckCast(this.mObj1, byte[].class, "com.obric.memorydata.plugin");
        return;
    L7:
        this.mData = ((String) ZeusTransformUtils.preCheckCast(this.mObj1, String.class, "com.obric.memorydata.plugin")).getBytes(Charset.forName("UTF-16"));
        return;
    L8:
        if (r4 == false) goto L11;
        Bitmap r5 = (Bitmap) ZeusTransformUtils.preCheckCast(this.mObj1, Bitmap.class, "com.obric.memorydata.plugin");
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        r5.compress(Bitmap.CompressFormat.PNG, 90, r0);
        this.mData = r0.toByteArray();
        return;
    L11:
        this.mParcelable = (Parcelable) ZeusTransformUtils.preCheckCast(this.mObj1, Parcelable.class, "com.obric.memorydata.plugin");
        return;
    L10:
        if (r4 == false) goto L11;
        throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
    }

    public IconCompat setTint(int r1) {
        return setTintList(ColorStateList.valueOf(r1));
    }

    public IconCompat setTintList(ColorStateList r1) {
        this.mTintList = r1;
        return this;
    }

    public IconCompat setTintMode(PorterDuff.Mode r1) {
        this.mTintMode = r1;
        return this;
    }

    public Bundle toBundle() {
        Bundle r0 = new Bundle();
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
        r0.putByteArray(EXTRA_OBJ, (byte[]) ZeusTransformUtils.preCheckCast(this.mObj1, byte[].class, "com.obric.memorydata.plugin"));
    L11:
        r0.putInt("type", this.mType);
        r0.putInt(EXTRA_INT1, this.mInt1);
        r0.putInt(EXTRA_INT2, this.mInt2);
        r0.putString(EXTRA_STRING1, this.mString1);
        ColorStateList r1 = this.mTintList;
        if (r1 == null) goto L14;
        r0.putParcelable(EXTRA_TINT_LIST, r1);
    L14:
        PorterDuff.Mode r5 = this.mTintMode;
        if (r5 == DEFAULT_TINT_MODE) goto L17;
        r0.putString(EXTRA_TINT_MODE, r5.name());
    L17:
        return r0;
    L7:
        r0.putString(EXTRA_OBJ, (String) ZeusTransformUtils.preCheckCast(this.mObj1, String.class, "com.obric.memorydata.plugin"));
        goto L11
    L8:
        Parcelable r2 = (Bitmap) ZeusTransformUtils.preCheckCast(this.mObj1, Bitmap.class, "com.obric.memorydata.plugin");
    L10:
        r0.putParcelable(EXTRA_OBJ, r2);
        goto L11
    L9:
        r2 = (Parcelable) ZeusTransformUtils.preCheckCast(this.mObj1, Parcelable.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        throw new IllegalArgumentException("Invalid icon");
    }

    @Deprecated
    public Icon toIcon() {
        return toIcon(null);
    }

    public Icon toIcon(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.toIcon(this, r4);
    L7:
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public String toString() {
        if (this.mType == (-1)) goto L5;
        StringBuilder r0 = new StringBuilder("Icon(typ=").append(typeToString(this.mType));
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
        r0.append(" uri=").append(this.mObj1);
        goto L17
    L10:
        r0.append(" len=").append(this.mInt1);
        if (this.mInt2 == 0) goto L17;
        StringBuilder r1 = r0.append(" off=");
        int r2 = this.mInt2;
    L15:
        r1.append(r2);
        goto L17
    L13:
        r0.append(" pkg=").append(this.mString1).append(" id=").append(String.format("0x%08x", new Object[]{Integer.valueOf(getResId())}));
        goto L17
    L14:
        r1 = r0.append(" size=").append(((Bitmap) ZeusTransformUtils.preCheckCast(this.mObj1, Bitmap.class, "com.obric.memorydata.plugin")).getWidth()).append("x");
        r2 = ((Bitmap) ZeusTransformUtils.preCheckCast(this.mObj1, Bitmap.class, "com.obric.memorydata.plugin")).getHeight();
    L17:
        if (this.mTintList == null) goto L20;
        r0.append(" tint=");
        r0.append(this.mTintList);
    L20:
        if (this.mTintMode == DEFAULT_TINT_MODE) goto L22;
        r0.append(" mode=").append(this.mTintMode);
    L22:
        r0.append(")");
        return r0.toString();
    L5:
        return String.valueOf(this.mObj1);
    }
}
