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
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
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

    public Icon toIcon() {
        return toIcon(null);
    }

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public Bitmap getBitmap() {
        int r0 = this.mType;
        if (r0 != (-1)) goto L13;
        if (Build.VERSION.SDK_INT < 23) goto L13;
        Object r1 = this.mObj1;
        if ((r1 instanceof Bitmap) == true) goto L9;
        return null;
    L9:
        return (Bitmap) r1;
    L13:
        if (r0 != 1) goto L17;
        return (Bitmap) this.mObj1;
    L17:
        if (r0 != 5) goto L21;
        return createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
    L21:
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int getResId() {
        int r0 = this.mType;
        if (r0 != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getResId(this.mObj1);
    L9:
        if (r0 != 2) goto L13;
        return this.mInt1;
    L13:
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String getResPackage() {
        int r0 = this.mType;
        if (r0 != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getResPackage(this.mObj1);
    L9:
        if (r0 != 2) goto L20;
        String r1 = this.mString1;
        if (r1 == null) goto L18;
        if (TextUtils.isEmpty(r1) == true) goto L18;
        return this.mString1;
    L18:
        return ((String) this.mObj1).split(":", -1)[0];
    L20:
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        int r0 = this.mType;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return r0;
    L7:
        return Api23Impl.getType(this.mObj1);
    }

    public Uri getUri() {
        int r0 = this.mType;
        if (r0 != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getUri(this.mObj1);
    L9:
        if (r0 == 4) goto L16;
        if (r0 == 6) goto L16;
        throw new IllegalStateException("called getUri() on " + this);
    L16:
        return UriProtector.parse((String) this.mObj1);
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
        String r0 = new String(this.mData, Charset.forName("UTF-16"));
        this.mObj1 = r0;
        if (this.mType == 2) goto L9;
        return;
    L9:
        if (this.mString1 != null) goto L22;
        this.mString1 = r0.split(":", -1)[0];
        return;
    L22:
        return;
    L11:
        Parcelable r1 = this.mParcelable;
        if (r1 == null) goto L14;
        this.mObj1 = r1;
        return;
    L14:
        byte[] r2 = this.mData;
        this.mObj1 = r2;
        this.mType = 3;
        this.mInt1 = 0;
        this.mInt2 = r2.length;
        return;
    L15:
        Parcelable r3 = this.mParcelable;
        if (r3 == null) goto L19;
        this.mObj1 = r3;
        return;
    L19:
        throw new IllegalArgumentException("Invalid icon");
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
        r0.putByteArray(EXTRA_OBJ, (byte[]) this.mObj1);
    L10:
        r0.putInt(EXTRA_TYPE, this.mType);
        r0.putInt(EXTRA_INT1, this.mInt1);
        r0.putInt(EXTRA_INT2, this.mInt2);
        r0.putString(EXTRA_STRING1, this.mString1);
        ColorStateList r1 = this.mTintList;
        if (r1 == null) goto L13;
        r0.putParcelable(EXTRA_TINT_LIST, r1);
    L13:
        PorterDuff.Mode r2 = this.mTintMode;
        if (r2 == DEFAULT_TINT_MODE) goto L16;
        r0.putString(EXTRA_TINT_MODE, r2.name());
    L16:
        return r0;
    L7:
        r0.putString(EXTRA_OBJ, (String) this.mObj1);
        goto L10
    L8:
        r0.putParcelable(EXTRA_OBJ, (Bitmap) this.mObj1);
        goto L10
    L9:
        r0.putParcelable(EXTRA_OBJ, (Parcelable) this.mObj1);
        goto L10
    L5:
        throw new IllegalArgumentException("Invalid icon");
    }

    public String toString() {
        if (this.mType == (-1)) goto L5;
        StringBuilder r0 = new StringBuilder("Icon(typ=");
        r0.append(typeToString(this.mType));
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
        r0.append(" uri=");
        r0.append(this.mObj1);
        goto L16
    L10:
        r0.append(" len=");
        r0.append(this.mInt1);
        if (this.mInt2 == 0) goto L16;
        r0.append(" off=");
        r0.append(this.mInt2);
        goto L16
    L13:
        r0.append(" pkg=");
        r0.append(this.mString1);
        r0.append(" id=");
        r0.append(String.format("0x%08x", new Object[]{Integer.valueOf(getResId())}));
        goto L16
    L14:
        r0.append(" size=");
        r0.append(((Bitmap) this.mObj1).getWidth());
        r0.append("x");
        r0.append(((Bitmap) this.mObj1).getHeight());
    L16:
        if (this.mTintList == null) goto L19;
        r0.append(" tint=");
        r0.append(this.mTintList);
    L19:
        if (this.mTintMode == DEFAULT_TINT_MODE) goto L21;
        r0.append(" mode=");
        r0.append(this.mTintMode);
    L21:
        r0.append(")");
        return r0.toString();
    L5:
        return String.valueOf(this.mObj1);
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

    public IconCompat(int r3) {
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = r3;
    }

    public static IconCompat createFromBundle(Bundle r4) {
        int r0 = r4.getInt(EXTRA_TYPE);
        IconCompat r1 = new IconCompat(r0);
        r1.mInt1 = r4.getInt(EXTRA_INT1);
        r1.mInt2 = r4.getInt(EXTRA_INT2);
        r1.mString1 = r4.getString(EXTRA_STRING1);
        if (r4.containsKey(EXTRA_TINT_LIST) == false) goto L6;
        r1.mTintList = (ColorStateList) r4.getParcelable(EXTRA_TINT_LIST);
    L6:
        if (r4.containsKey(EXTRA_TINT_MODE) == false) goto L9;
        r1.mTintMode = PorterDuff.Mode.valueOf(r4.getString(EXTRA_TINT_MODE));
    L9:
        switch(r0) {
            case -1: goto L14;
            case 0: goto L11;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L13;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L11;
        };
    L12:
        r1.mObj1 = r4.getByteArray(EXTRA_OBJ);
    L15:
        return r1;
    L13:
        r1.mObj1 = r4.getString(EXTRA_OBJ);
        goto L15
    L14:
        r1.mObj1 = r4.getParcelable(EXTRA_OBJ);
        goto L15
    L11:
        return null;
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

    private Drawable loadDrawableInner(Context r6) {
        switch(this.mType) {
            case 1: goto L29;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L5;
            default: goto L30;
        };
    L5:
        InputStream r0 = getUriInputStream(r6);
        if (r0 == null) goto L30;
        if (Build.VERSION.SDK_INT < 26) goto L12;
        return Api26Impl.createAdaptiveIconDrawable(null, new BitmapDrawable(r6.getResources(), BitmapFactory.decodeStream(r0)));
    L12:
        return new BitmapDrawable(r6.getResources(), createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream(r0), false));
    L15:
        InputStream r1 = getUriInputStream(r6);
        if (r1 == null) goto L30;
        return new BitmapDrawable(r6.getResources(), BitmapFactory.decodeStream(r1));
    L21:
        String r2 = getResPackage();
        if (TextUtils.isEmpty(r2) == false) goto L31;
        r2 = r6.getPackageName();
    L31:
        return ResourcesCompat.getDrawable(getResources(r6, r2), this.mInt1, r6.getTheme());
    L27:
        String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.mInt1), this.mObj1});
    L30:
        return null;
    L14:
        return new BitmapDrawable(r6.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
    L20:
        return new BitmapDrawable(r6.getResources(), BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
    L29:
        return new BitmapDrawable(r6.getResources(), (Bitmap) this.mObj1);
    }

    public void checkResource(Context r9) {
        if (this.mType != 2) goto L16;
        Object r0 = this.mObj1;
        if (r0 == null) goto L17;
        String r1 = (String) r0;
        if (r1.contains(":") == true) goto L9;
        return;
    L9:
        String r3 = r1.split(":", -1)[1];
        String r6 = r3.split("/", -1)[0];
        String r4 = r3.split("/", -1)[1];
        String r2 = r1.split(":", -1)[0];
        if ("0_resource_name_obfuscated".equals(r4) == false) goto L12;
        return;
    L12:
        int r10 = getResources(r9, getResPackage()).getIdentifier(r4, r6, r2);
        if (this.mInt1 == r10) goto L18;
        this.mInt1 = r10;
        return;
    L18:
        return;
    L17:
        return;
    }

    public InputStream getUriInputStream(Context r4) {
        Uri r0 = getUri();
        String r1 = r0.getScheme();
        if ("content".equals(r1) == false) goto L5;
    L17:
        return r4.getContentResolver().openInputStream(r0);
    L12:
        r0.toString();
        return null;
    L5:
        if ("file".equals(r1) == true) goto L17;
        return new FileInputStream(new File((String) this.mObj1));
    L9:
        r0.toString();
        return null;
    }

    public Drawable loadDrawable(Context r3) {
        checkResource(r3);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Drawable r4 = loadDrawableInner(r3);
        if (r4 != null) goto L9;
    L13:
        return r4;
    L9:
        if (this.mTintList == null) goto L11;
    L12:
        r4.mutate();
        DrawableCompat.setTintList(r4, this.mTintList);
        DrawableCompat.setTintMode(r4, this.mTintMode);
        goto L13
    L11:
        if (this.mTintMode == DEFAULT_TINT_MODE) goto L13;
    L5:
        return Api23Impl.loadDrawable(toIcon(r3), r3);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean r4) {
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
        if (r4 == false) goto L10;
        Bitmap r5 = (Bitmap) this.mObj1;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        r5.compress(Bitmap.CompressFormat.PNG, 90, r0);
        this.mData = r0.toByteArray();
        return;
    L10:
        this.mParcelable = (Parcelable) this.mObj1;
        return;
    L11:
        if (r4 == true) goto L14;
        this.mParcelable = (Parcelable) this.mObj1;
        return;
    L14:
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

    public Icon toIcon(Context r3) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.toIcon(this, r3);
    L7:
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(String r2) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(6);
        r0.mObj1 = r2;
        return r0;
    }

    public static IconCompat createWithContentUri(String r2) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(4);
        r0.mObj1 = r2;
        return r0;
    }

    public static IconCompat createFromIcon(Context r0, Icon r1) {
        Preconditions.checkNotNull(r1);
        return Api23Impl.createFromIcon(r0, r1);
    }

    public static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap r9, boolean r10) {
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
        r3.setColor(-16777216);
        Shader.TileMode r7 = Shader.TileMode.CLAMP;
        BitmapShader r12 = new BitmapShader(r9, r7, r7);
        Matrix r8 = new Matrix();
        r8.setTranslate((-(r9.getWidth() - r0)) / 2.0f, (-(r9.getHeight() - r0)) / 2.0f);
        r12.setLocalMatrix(r8);
        r3.setShader(r12);
        r2.drawCircle(r5, r5, r6, r3);
        r2.setBitmap(null);
        return r1;
    }

    public static IconCompat createWithResource(Context r1, int r2) {
        ObjectsCompat.requireNonNull(r1);
        return createWithResource(r1.getResources(), r1.getPackageName(), r2);
    }

    public static Resources getResources(Context r2, String r3) {
        if ("android".equals(r3) == true) goto L5;
        PackageManager r4 = r2.getPackageManager();
        ApplicationInfo r0 = r4.getApplicationInfo(r3, 8192);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r0 == null) goto L11;
        return r4.getResourcesForApplication(r0);
    L11:
        return null;
    L12:
        String.format("Unable to find pkg=%s for icon", new Object[]{r3});
        return null;
    L5:
        return Resources.getSystem();
    }

    public static IconCompat createWithData(byte[] r2, int r3, int r4) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(3);
        r0.mObj1 = r2;
        r0.mInt1 = r3;
        r0.mInt2 = r4;
        return r0;
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

    public void addToShortcutIntent(Intent r5, Drawable r6, Context r7) {
        checkResource(r7);
        int r0 = this.mType;
        if (r0 != 1) goto L5;
        Bitmap r8 = (Bitmap) this.mObj1;
        if (r6 == null) goto L30;
        r8 = r8.copy(r8.getConfig(), true);
    L30:
        if (r6 == null) goto L32;
        int r1 = r8.getWidth();
        int r2 = r8.getHeight();
        r6.setBounds(r1 / 2, r2 / 2, r1, r2);
        r6.draw(new Canvas(r8));
    L32:
        r5.putExtra("android.intent.extra.shortcut.ICON", r8);
        return;
    L5:
        if (r0 != 2) goto L7;
        Context r9 = r7.createPackageContext(getResPackage(), 0);     // Catch: PackageManager.NameNotFoundException -> L24
        if (r6 != null) goto L15;
        r5.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(r9, this.mInt1));     // Catch: PackageManager.NameNotFoundException -> L24
        return;
    L15:
        Drawable r3 = ContextCompat.getDrawable(r9, this.mInt1);     // Catch: PackageManager.NameNotFoundException -> L24
        if (r3.getIntrinsicWidth() > 0) goto L18;
    L21:
        int r10 = ((ActivityManager) r9.getSystemService("activity")).getLauncherLargeIconSize();     // Catch: PackageManager.NameNotFoundException -> L24
        r8 = Bitmap.createBitmap(r10, r10, Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L24
    L22:
        r3.setBounds(0, 0, r8.getWidth(), r8.getHeight());     // Catch: PackageManager.NameNotFoundException -> L24
        r3.draw(new Canvas(r8));     // Catch: PackageManager.NameNotFoundException -> L24
        goto L30
    L18:
        if (r3.getIntrinsicHeight() <= 0) goto L21;
        r8 = Bitmap.createBitmap(r3.getIntrinsicWidth(), r3.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L24
    L24:
        e = move-exception;
        throw new IllegalArgumentException("Can't find package " + this.mObj1, e);
    L7:
        if (r0 != 5) goto L10;
        r8 = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
        goto L30
    L10:
        throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
    }
}
