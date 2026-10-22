package com.obric.memorydata.utils.icon;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.util.TypedValue;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.function.IntFunction;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/utils/icon/CalendarDrawableWrapper;", "Landroid/graphics/drawable/AdaptiveIconDrawable;", "base", "<init>", "(Landroid/graphics/drawable/AdaptiveIconDrawable;)V", "Companion", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends AdaptiveIconDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13243a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f13244b;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000bH\u0007J:\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u000b2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dH\u0003J0\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J(\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J\u001e\u0010.\u001a\u0004\u0018\u0001H*\"\u0006\b\u0000\u0010*\u0018\u0001*\u0004\u0018\u00010\u0001H\u0082\b¢\u0006\u0002\u0010/R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010)\u001a\u00020\u000b\"\n\b\u0000\u0010*\u0018\u0001*\u00020+*\u0002H*8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/obric/memorydata/utils/icon/CalendarDrawableWrapper$Companion;", "", "<init>", "()V", "TAG", "", "LAUNCHER_PACKAGE", "WEEKDAY_LAYER_INDEX", "METADATA_KEY_ICON_BASE", "METADATA_KEY_ICON_WEEKDAY", "INVALID_VALUE", "", "WEEK_TEXT_COLOR", "THEME_SETTING_KEY", "SQUARE_METADATA_KEY_ICON_BASE", "DEFAULT_THEME_PATH", "mIsDefaultTheme", "", "forPackage", "Lcom/obric/memorydata/utils/icon/CalendarDrawableWrapper;", "context", "Landroid/content/Context;", "pkg", "iconDpi", "forExtras", ObricMemoryConstants.KEY_PACKAGE_NAME, "metadata", "Landroid/os/Bundle;", "drawableProvider", "Ljava/util/function/IntFunction;", "Landroid/graphics/drawable/Drawable;", "createWeekDayIconLayer", "dayOfWeek", "textColor", "bgColor", "getDynamicIconId", "resources", "Landroid/content/res/Resources;", "key", "index", "dayOfMonth", "dp", ExifInterface.GPS_DIRECTION_TRUE, "", "getDp", "(Ljava/lang/Number;)I", "safeCastTo", "(Ljava/lang/Object;)Ljava/lang/Object;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final int a() {
            return Calendar.getInstance().get(5) - 1;
        }

        private final int a(Resources r7, Bundle r8, String r9, int r10) {
            int r11 = r8.getInt(r9, 0);
            if (r11 != 0) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarDrawableWrapper", "Array id not found, key: " + r9, null, 4, null);
            return 0;
        L10:
            TypedArray r12 = r7.obtainTypedArray(r11);     // Catch: Resources.NotFoundException -> L8
            Intrinsics.checkNotNullExpressionValue(r12, "obtainTypedArray(...)");     // Catch: Resources.NotFoundException -> L8
            int r13 = r12.getResourceId(r10, 0);     // Catch: Resources.NotFoundException -> L8
            r12.recycle();     // Catch: Resources.NotFoundException -> L8
            return r13;
        L8:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarDrawableWrapper", "Resource not found, key: " + r9 + ", index: " + r10, null, 4, null);
            return 0;
        }

        private final Drawable a(Context r8, String r9, int r10, int r11, int r12) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, 108, Resources.getSystem().getDisplayMetrics()));
            Bitmap r1 = Bitmap.createBitmap(r13, r13, Bitmap.Config.ARGB_8888);
            r1.setDensity(r12);
            Canvas r3 = new Canvas(r1);
            r3.drawColor(r11);
            if (c.a() == false) goto L5;
            int r14 = 33;
        L6:
            float r15 = MathKt.roundToInt(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics()));
            float r4 = MathKt.roundToInt(TypedValue.applyDimension(1, 9, Resources.getSystem().getDisplayMetrics()));
            Paint r5 = new Paint(1);
            r5.setTextAlign(Paint.Align.CENTER);
            r5.setColor(r10);
            if (c.a() == false) goto L9;
            a r16 = c.f13243a;
            float r17 = MathKt.roundToInt(TypedValue.applyDimension(1, 13, Resources.getSystem().getDisplayMetrics()));
        L10:
            r5.setTextSize(r17);
            r5.setLetterSpacing(0.08f);
            if (c.a() == false) goto L13;
            Typeface r18 = Typeface.create(Typeface.DEFAULT, 500, false);
        L14:
            r5.setTypeface(r18);
            r3.drawText(r9, r13 / 2, (r15 + r4) - r5.descent(), r5);
            Resources r19 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r19, "getResources(...)");
            BitmapDrawable r20 = new BitmapDrawable(r19, r1);
            r20.setTargetDensity(r12);
            r20.setBounds(0, 0, r13, r13);
            return (Drawable) ZeusTransformUtils.preCheckCast(r20, Drawable.class, "com.obric.memorydata.plugin");
        L13:
            r18 = Typeface.create(Typeface.DEFAULT, 1);
            goto L14
        L9:
            r17 = 31.5f;
            goto L10
        L5:
            r14 = 31;
            goto L6
        }

        private static final Drawable a(Resources r0, int r1, int r2) {
            return r0.getDrawableForDensity(r2, r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final c a(Context r9, String r10, Bundle r11, int r12, IntFunction<Drawable> r13) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
            IntFunction r14 = (IntFunction) ZeusTransformUtils.wrapperContextForParams(r13, IntFunction.class, "com.obric.memorydata.plugin");
            if (r11 == null) goto L45;
            Resources r15 = r3.getPackageManager().getResourcesForApplication(r10);
            Intrinsics.checkNotNullExpressionValue(r15, "getResourcesForApplication(...)");
            int r0 = a(r15, r11, "com.android.launcher3.CALENDAR_DYNAMIC_ICONS_WEEKDAY", b());
            String r4 = r15.getString(r0);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
            boolean r2 = true;
        L9:
            if (r2 == true) goto L43;
            if (c.a() == true) goto L13;
        L15:
            int r16 = a();
            String r1 = "com.android.launcher3.CALENDAR_DYNAMIC_ICONS_BASE";
        L16:
            int r17 = a(r15, r11, r1, r16);
            Drawable r18 = (Drawable) ZeusTransformUtils.preCheckCast(r14.apply(r17), Drawable.class, "com.obric.memorydata.plugin");
            if (r18 == null) goto L41;
            Drawable r19 = r18.mutate();
            if (r19 == null) goto L41;
            if (ZeusTransformUtils.instanceOf(r19, AdaptiveIconDrawable.class) == false) goto L39;
            DefaultConstructorMarker r110 = 0;
            r110 = 0;
            c r111 = new c((AdaptiveIconDrawable) ZeusTransformUtils.preCheckCast(r19, AdaptiveIconDrawable.class, "com.obric.memorydata.plugin"), r110);
            Drawable r20 = r111.getForeground();
            if (r20 != null) goto L26;
        L28:
            LayerDrawable r21 = (LayerDrawable) ZeusTransformUtils.preCheckCast(r110, LayerDrawable.class, "com.obric.memorydata.plugin");
            if (r21 == null) goto L37;
            int r112 = r21.getNumberOfLayers();
            int r113 = r11.getInt("com.android.launcher3.WEEKDAY_LAYER_INDEX", -1);
            if (r112 <= r113) goto L35;
            r21.setDrawable(r113, a(r3, r4, Color.parseColor("#FF311A"), 0, r12));
            return r111;
        L35:
            throw new IllegalStateException("Layer count is less than " + r113);
        L37:
            throw new IllegalStateException("Foreground is not a LayerDrawable");
        L26:
            if (ZeusTransformUtils.instanceOf(r20, LayerDrawable.class) == false) goto L28;
            r110 = r20;
            goto L28
        L39:
            throw new IllegalStateException("Drawable is not an AdaptiveIconDrawable for id: [" + r17 + ']');
        L41:
            throw new IllegalStateException("Drawable not found for id: [" + r17 + ']');
        L13:
            if (Intrinsics.areEqual(r10, "com.larus.nova") == true) goto L15;
            r16 = a();
            r1 = "com.android.launcher3.CALENDAR_DYNAMIC_ICONS_BASE_SQUARE";
            goto L16
        L43:
            throw new IllegalArgumentException("Weekday string is empty for id: [" + r0 + ']');
        L7:
            r2 = false;
            goto L9
        L45:
            throw new IllegalArgumentException("Metadata cannot be null");
        }

        private final int b() {
            return Calendar.getInstance().get(7) - 1;
        }

        public static /* synthetic */ Drawable lambda$CXHjnhajPedlnNcrtjdyLdvaipU(Resources r0, int r1, int r2) {
            return a(r0, r1, r2);
        }

        @JvmStatic
        public final c a(Context r9, String r10, final int r11) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r10, "pkg");
            String r12 = Settings.System.getString(r3.getContentResolver(), "obric_theme_path");     // Catch: Exception -> L15
            boolean r0 = false;
            if (r12 != null) goto L6;
        L12:
            r0 = true;
        L13:
            c.a(r0);     // Catch: Exception -> L15
            PackageManager r13 = r3.getPackageManager();     // Catch: Exception -> L15
            ApplicationInfo r1 = r13.getApplicationInfo(r10, 8320);     // Catch: Exception -> L15
            Intrinsics.checkNotNullExpressionValue(r1, "getApplicationInfo(...)");     // Catch: Exception -> L15
            final Resources r14 = r13.getResourcesForApplication(r1);     // Catch: Exception -> L15
            Intrinsics.checkNotNullExpressionValue(r14, "getResourcesForApplication(...)");     // Catch: Exception -> L15
            return a(r3, r10, r1.metaData, r11, new $$Lambda$c$a$CXHjnhajPedlnNcrtjdyLdvaipU(r14, r11));
        L6:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L8;
            boolean r4 = true;
        L9:
            if (r4 == true) goto L12;
            if (Intrinsics.areEqual(r12, "/system/etc/themes/DefaultTheme.ot") == false) goto L13;
        L8:
            r4 = false;
        L15:
            e = move-exception;
            RunLog.INSTANCE.error("CalendarDrawableWrapper", "Load calendar drawable failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return null;
        }
    }

    static {
        f13243a = new a(null);
        f13244b = true;
    }

    private c(AdaptiveIconDrawable r2) {
        super(r2.getBackground(), r2.getForeground());
    }

    public /* synthetic */ c(AdaptiveIconDrawable r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static final /* synthetic */ void a(boolean r0) {
        f13244b = r0;
    }

    public static final /* synthetic */ boolean a() {
        return f13244b;
    }
}
