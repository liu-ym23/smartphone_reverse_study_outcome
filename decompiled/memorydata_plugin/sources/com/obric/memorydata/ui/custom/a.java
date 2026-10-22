package com.obric.memorydata.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.util.f;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ao;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.button.OShadowFrame;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.segmentedtab.OBottomNavActionBar;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006\u001a\u0019\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\n\u001a\u0019\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\f\u001a\u0019\u0010\r\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\n\u0010\u0016\u001a\u00020\u000f*\u00020\u0017\u001a\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\n\u0010\u001a\u001a\u00020\u000f*\u00020\u0014\u001a\n\u0010\u001b\u001a\u00020\t*\u00020\u001c\u001a\f\u0010\u001d\u001a\u00020\u000f*\u00020\u001cH\u0002\u001a\u0018\u0010\u001e\u001a\u00020\u000f*\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0 \u001a\n\u0010\u001b\u001a\u00020\t*\u00020!\u001a\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0002\u001a\u0010\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0003H\u0002\u001a\u0014\u0010'\u001a\u00020(*\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002\u001a\u0014\u0010+\u001a\u00020\u000f*\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u0001\u001a\u0014\u0010-\u001a\u00020\t*\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"TAG", "", "resolveThemeDimen", "", "Landroid/content/Context;", "attrRes", "(Landroid/content/Context;I)Ljava/lang/Integer;", "resolveThemeInt", "resolveThemeBoolean", "", "(Landroid/content/Context;I)Ljava/lang/Boolean;", "Landroid/view/View;", "(Landroid/view/View;I)Ljava/lang/Boolean;", "resolveThemeColor", "killOUIHelpers", "", "view", "Lcom/obric/oui/layout/OUIFrameLayout;", "nukeChildrenRecursive", "parent", "Landroid/view/ViewGroup;", "nukeFrameLayoutStyle", "nukeStyle", "Lcom/obric/oui/button/OButtonGroup;", "findAllButtonGroups", "", "nukeAllButtonGroups", "applyDeviceStyle", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "disableTitleTextFallbackLineSpacingForVerification", "reloadStartAction", "onBackPressed", "Lkotlin/Function0;", "Lcom/obric/oui/segmentedtab/OBottomNavigationBar;", "nukeBottomNavActionBar", "navBar", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "typeStr", "t", "resolveOne", "Lcom/obric/memorydata/ui/custom/ResolvedAttr;", "entry", "Lcom/obric/memorydata/ui/custom/DeviceAttrRegistry$Entry;", "dumpDeviceAttrs", LocationMonitorConst.TAG, "verifyDeviceOverlayApplied", "ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: com.obric.memorydata.ui.custom.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C0711a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13000a = null;

        static {
            int[] r0 = new int[DeviceAttrRegistry.Kind.values().length];
            r0[DeviceAttrRegistry.Kind.DIMEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[DeviceAttrRegistry.Kind.COLOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[DeviceAttrRegistry.Kind.INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DeviceAttrRegistry.Kind.BOOLEAN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f13000a = r0;
        }
    }

    private static final b a(Context r12, DeviceAttrRegistry.a r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        TypedValue r0 = new TypedValue();
        boolean r4 = true;
        if (r14.getTheme().resolveAttribute(r13.b(), r0, true) == true) goto L7;
        return new b(r13.a(), "NOT_FOUND", -1, "<未在 theme 中定义>", false);
    L7:
        if (r0.type == 2) goto L9;
        boolean r11 = true;
    L10:
        int r2 = C0711a.f13000a[r13.c().ordinal()];
        if (r2 == 1) goto L26;
        if (r2 != 2) goto L14;
        StringBuilder r15 = new StringBuilder().append("0x");
        String r1 = Integer.toHexString(r0.data);
    L27:
        String r16 = r15.append(r1).toString();
    L29:
        return new b(r13.a(), a(r0.type), r0.type, r16, r11);
    L14:
        if (r2 != 3) goto L16;
        r16 = String.valueOf(r0.data);
        goto L29
    L16:
        if (r2 != 4) goto L23;
        if (r0.data != 0) goto L21;
        r4 = false;
    L21:
        r16 = String.valueOf(r4);
        goto L29
    L23:
        throw new NoWhenBranchMatchedException();
    L26:
        int r3 = TypedValue.complexToDimensionPixelSize(r0.data, ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getDisplayMetrics());
        r15 = new StringBuilder().append(r3 / ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getDisplayMetrics().density).append("dp (").append(r3);
        r1 = "px)";
        goto L27
    L9:
        r11 = false;
        goto L10
    }

    public static final Boolean a(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "getContext(...)");
        return b(r4, r3);
    }

    public static final Integer a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        TypedArray r5 = r4.getTheme().obtainStyledAttributes(new int[]{r3});
        Intrinsics.checkNotNullExpressionValue(r5, "obtainStyledAttributes(...)");
        int r0 = r5.getDimensionPixelSize(0, Integer.MIN_VALUE);     // Catch: Throwable -> L9
        if (r0 != Integer.MIN_VALUE) goto L6;
        Integer r6 = null;
    L7:
        r5.recycle();
        return r6;
    L6:
        r6 = Integer.valueOf(r0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    private static final Object a(DeviceAttrRegistry.a r1) {
        Intrinsics.checkNotNullParameter(r1, "e");
        return r1.d();
    }

    private static final String a(int r5) {
        if (r5 != 0) goto L4;
        return "NULL";
    L4:
        boolean r0 = true;
        if (r5 != 1) goto L8;
        return "REFERENCE";
    L8:
        if (r5 != 2) goto L11;
        return "ATTRIBUTE(未解析!)";
    L11:
        if (r5 != 3) goto L14;
        return "STRING";
    L14:
        if (r5 != 4) goto L17;
        return "FLOAT";
    L17:
        if (r5 != 5) goto L20;
        return "DIMENSION";
    L20:
        if (r5 != 6) goto L23;
        return "FRACTION";
    L23:
        if (r5 != 16) goto L26;
        return "INT_DEC";
    L26:
        if (r5 != 17) goto L29;
        return "INT_HEX";
    L29:
        if (r5 != 18) goto L32;
        return "INT_BOOLEAN";
    L32:
        if (28 > r5) goto L35;
        if (r5 >= 32) goto L35;
        boolean r2 = true;
    L36:
        if (r2 == false) goto L38;
        return "COLOR";
    L38:
        if (16 > r5) goto L41;
        if (r5 >= 32) goto L41;
    L42:
        if (r0 == false) goto L45;
        return "INT";
    L45:
        return "UNKNOWN(0x" + Integer.toHexString(r5) + ')';
    L41:
        r0 = false;
    L35:
        r2 = false;
        goto L36
    }

    public static final void a(Context r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r12, LocationMonitorConst.TAG);
        String r0 = DeviceInfoState.INSTANCE.getDeviceModel();
        StringBuilder r2 = new StringBuilder();
        r2.append("\n==== DeviceAttrs dump [tag=" + r12 + ", device=" + r0 + "] ====\n");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(DeviceAttrRegistry.f12995a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r1 = true;
    L4:
        if (r14.hasNext() == false) goto L10;
        DeviceAttrRegistry.a r3 = (DeviceAttrRegistry.a) ZeusTransformUtils.preCheckCast(r14.next(), DeviceAttrRegistry.a.class, "com.obric.memorydata.plugin");
        b r5 = a(r13, r3);
        if (r5.c() == false) goto L8;
        String r6 = "[OK ]";
    L9:
        r2.append("  " + r6 + ' ' + StringsKt.padEnd$default(r3.a(), 48, 0, 2, null) + " = " + StringsKt.padEnd$default(r5.b(), 20, 0, 2, null) + " type=" + r5.a() + '\n');
        goto L4
    L8:
        r6 = "[BAD]";
        r1 = false;
        goto L9
    L10:
        r2.append("====================================== allOk=" + r1 + '\n');
        RunLog r15 = RunLog.INSTANCE;
        if (r1 == false) goto L13;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(r15, IRunLog.class, "com.obric.memorydata.plugin");
        String r7 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        IRunLog.a.a(r4, "OUIDeviceAdaptive", r7, false, 4, null);
        return;
    L13:
        IRunLog r8 = (IRunLog) ZeusTransformUtils.preCheckCast(r15, IRunLog.class, "com.obric.memorydata.plugin");
        String r9 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        IRunLog.a.b(r8, "OUIDeviceAdaptive", r9, null, 4, null);
    }

    public static final void a(ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeAllButtonGroups: START on " + r9.getClass().getSimpleName() + '@' + Integer.toHexString(r9.hashCode()), false, 4, null);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(c(r9), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a((OButtonGroup) ZeusTransformUtils.preCheckCast(r0.next(), OButtonGroup.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeAllButtonGroups: END, found " + c(r9).size() + " groups", false, 4, null);
    }

    public static final void a(final OButtonGroup r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "OButtonGroup.nukeStyle: START on " + r9.getClass().getSimpleName() + '@' + Integer.toHexString(r9.hashCode()), false, 4, null);
        r9.setShadowStyle(ZeusTransformUtils.mapRes(R.style.ShadowNone, "style", "ShadowNone"));
        r9.a(0, 0);
        r9.setPressColor(0);
        OShadowFrame.a((OShadowFrame) ZeusTransformUtils.preCheckCast(r9, OShadowFrame.class, "com.obric.memorydata.plugin"), null, null, false, 4, null);
        r9.setChangeAlphaWhenPress(false);
        r9.setOverridePressColor(0);
        r9.refreshColors("OUIDeviceAdaptive");
        r9.setBackground(null);
        r9.setForeground(null);
        r9.setElevation(0.0f);
        a((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r9, OUIFrameLayout.class, "com.obric.memorydata.plugin"));
        b((ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.memorydata.plugin"));
        r9.invalidate();
        r9.post(new $$Lambda$a$mc1y42IvjF7LPeKc3Xb1nzVvT8(r9));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "OButtonGroup.nukeStyle: END", false, 4, null);
    }

    private static final void a(OUIFrameLayout r13) {
        String r4 = null;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L11
        Field r6 = OUIFrameLayout.class.getDeclaredField("d");     // Catch: Throwable -> L11
        r6.setAccessible(true);     // Catch: Throwable -> L11
        Object r7 = r6.get(r13);     // Catch: Throwable -> L11
        r6.set(r13, null);     // Catch: Throwable -> L11
        IRunLog r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        StringBuilder r9 = new StringBuilder().append("killOUIHelpers: mLayoutHelper ");     // Catch: Throwable -> L11
        if (r7 == null) goto L8;
        Class<?> r10 = r7.getClass();     // Catch: Throwable -> L11
        if (r10 == null) goto L8;
        String r11 = r10.getSimpleName();     // Catch: Throwable -> L11
    L9:
        IRunLog.a.a(r8, "OUIDeviceAdaptive", r9.append(r11).append(" -> null on ").append(r13.getClass().getSimpleName()).append('@').append(Integer.toHexString(r13.hashCode())).toString(), false, 4, null);     // Catch: Throwable -> L11
        Object r12 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r12);
        if (r14 == null) goto L31;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "killOUIHelpers: mLayoutHelper failed", r14);
    L31:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L23
        Field r16 = OUIFrameLayout.class.getDeclaredField("e");     // Catch: Throwable -> L23
        r16.setAccessible(true);     // Catch: Throwable -> L23
        Object r3 = r16.get(r13);     // Catch: Throwable -> L23
        r16.set(r13, null);     // Catch: Throwable -> L23
        IRunLog r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        StringBuilder r1 = new StringBuilder().append("killOUIHelpers: mAlphaHelper ");     // Catch: Throwable -> L23
        if (r3 == null) goto L21;
        Class<?> r18 = r3.getClass();     // Catch: Throwable -> L23
        if (r18 == null) goto L21;
        r4 = r18.getSimpleName();     // Catch: Throwable -> L23
    L21:
        IRunLog.a.a(r17, "OUIDeviceAdaptive", r1.append(r4).append(" -> null on ").append(r13.getClass().getSimpleName()).append('@').append(Integer.toHexString(r13.hashCode())).toString(), false, 4, null);     // Catch: Throwable -> L23
        Object r19 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r110 = Result.m1424exceptionOrNullimpl(r19);
        if (r110 == null) goto L33;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "killOUIHelpers: mAlphaHelper failed", r110);
        return;
    L33:
        return;
    L23:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L8:
        r11 = null;
    L11:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private static final void a(OBottomNavActionBar r13) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeBottomNavActionBar: START", false, 4, null);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Field r4 = OBottomNavActionBar.class.getDeclaredField("B");     // Catch: Throwable -> L5
        r4.setAccessible(true);     // Catch: Throwable -> L5
        r4.setInt(r13, 0);     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeBottomNavActionBar: mBarColor -> TRANSPARENT", false, 4, null);     // Catch: Throwable -> L5
        Object r5 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L73;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "nukeBottomNavActionBar: mBarColor failed", r6);
    L73:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L13
        Field r8 = OBottomNavActionBar.class.getDeclaredField("C");     // Catch: Throwable -> L13
        r8.setAccessible(true);     // Catch: Throwable -> L13
        r8.setInt(r13, 0);     // Catch: Throwable -> L13
        Field r9 = OBottomNavActionBar.class.getDeclaredField(com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b);     // Catch: Throwable -> L13
        r9.setAccessible(true);     // Catch: Throwable -> L13
        r9.setFloat(r13, 0.0f);     // Catch: Throwable -> L13
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeBottomNavActionBar: mBarStrokeColor -> TRANSPARENT, mBarStrokeWidth -> 0", false, 4, null);     // Catch: Throwable -> L13
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L63;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "nukeBottomNavActionBar: stroke fields failed", r11);
    L63:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L21
        Field r14 = OBottomNavActionBar.class.getDeclaredField("I");     // Catch: Throwable -> L21
        r14.setAccessible(true);     // Catch: Throwable -> L21
        r14.set(r13, null);     // Catch: Throwable -> L21
        Field r15 = OBottomNavActionBar.class.getDeclaredField("J");     // Catch: Throwable -> L21
        r15.setAccessible(true);     // Catch: Throwable -> L21
        r15.set(r13, null);     // Catch: Throwable -> L21
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeBottomNavActionBar: shadows -> null", false, 4, null);     // Catch: Throwable -> L21
        Object r16 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L71;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "nukeBottomNavActionBar: shadow fields failed", r17);
    L71:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L28
        Field r19 = OBottomNavActionBar.class.getDeclaredField(ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L28
        r19.setAccessible(true);     // Catch: Throwable -> L28
        r19.setBoolean(r13, false);     // Catch: Throwable -> L28
        Field r20 = OBottomNavActionBar.class.getDeclaredField("S");     // Catch: Throwable -> L28
        r20.setAccessible(true);     // Catch: Throwable -> L28
        r20.setBoolean(r13, false);     // Catch: Throwable -> L28
        r13.a(false);     // Catch: Throwable -> L28
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeBottomNavActionBar: material -> disabled", false, 4, null);     // Catch: Throwable -> L28
        Object r21 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r22 = Result.m1424exceptionOrNullimpl(r21);
        if (r22 == null) goto L69;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "nukeBottomNavActionBar: material fields failed", r22);
    L69:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L42
        Field r24 = OBottomNavActionBar.class.getDeclaredField("O");     // Catch: Throwable -> L42
        r24.setAccessible(true);     // Catch: Throwable -> L42
        Object r25 = r24.get(r13);     // Catch: Throwable -> L42
        if (r25 == null) goto L37;
        r25.getClass().getMethod("cancelAnimation", new Class[0]).invoke(r25, new Object[0]);     // Catch: Throwable -> L42
    L37:
        r24.set(r13, null);     // Catch: Throwable -> L42
        Field r26 = OBottomNavActionBar.class.getDeclaredField(i.m);     // Catch: Throwable -> L42
        r26.setAccessible(true);     // Catch: Throwable -> L42
        Object r27 = r26.get(r13);     // Catch: Throwable -> L42
        if (r27 == null) goto L40;
        r27.getClass().getMethod("cancelAnimation", new Class[0]).invoke(r27, new Object[0]);     // Catch: Throwable -> L42
    L40:
        r26.set(r13, null);     // Catch: Throwable -> L42
        Field r0 = OBottomNavActionBar.class.getDeclaredField("Q");     // Catch: Throwable -> L42
        r0.setAccessible(true);     // Catch: Throwable -> L42
        r0.setFloat(r13, 1.0f);     // Catch: Throwable -> L42
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeBottomNavActionBar: press anim -> disabled", false, 4, null);     // Catch: Throwable -> L42
        Object r1 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
        if (r2 == null) goto L67;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "nukeBottomNavActionBar: pressAnim fields failed", r2);
    L67:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L56
        Field r29 = OBottomNavActionBar.class.getDeclaredField(f.f1488a);     // Catch: Throwable -> L56
        r29.setAccessible(true);     // Catch: Throwable -> L56
        Object r30 = r29.get(r13);     // Catch: Throwable -> L56
        if (ZeusTransformUtils.instanceOf(r30, OUIFrameLayout.class) == false) goto L50;
        OUIFrameLayout r31 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r30, OUIFrameLayout.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
    L51:
        if (r31 == null) goto L53;
        b(r31);     // Catch: Throwable -> L56
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeBottomNavActionBar: mContentRoot nuked", false, 4, null);     // Catch: Throwable -> L56
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L56
    L54:
        Object r33 = Result.m1421constructorimpl(r32);     // Catch: Throwable -> L56
    L58:
        Throwable r34 = Result.m1424exceptionOrNullimpl(r33);
        if (r34 == null) goto L61;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "nukeBottomNavActionBar: mContentRoot failed", r34);
    L61:
        r13.setShadowStyle(ZeusTransformUtils.mapRes(R.style.ShadowNone, "style", "ShadowNone"));
        r13.setBackground(null);
        r13.setForeground(null);
        r13.setElevation(0.0f);
        a((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r13, OUIFrameLayout.class, "com.obric.memorydata.plugin"));
        r13.invalidate();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeBottomNavActionBar: END", false, 4, null);
        return;
    L53:
        r32 = null;
        goto L54
    L50:
        r31 = null;
    L56:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r33 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L42:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L28:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r21 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L13:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final void a(OFloatingTitleBar r8, Function0<Unit> r9) {
        final Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r10, "onBackPressed");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        OFloatingTitleBar.a(r8, false, 1, null);     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(DeviceInfoState.INSTANCE.getDeviceModel(), "Genesis-R") == false) goto L7;
        int r1 = R.drawable.ic_floating_title_bar_icon_back_gr;     // Catch: Throwable -> L10
        String r3 = "ic_floating_title_bar_icon_back_gr";
    L8:
        OFloatingTitleBar.a(r8, ZeusTransformUtils.mapRes(r1, "drawable", r3), 0, new $$Lambda$a$NyLR3__942COktL9rzABsHZTg0M(r10), 2, null);     // Catch: Throwable -> L10
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "reloadStartAction: addStartAction done", false, 4, null);     // Catch: Throwable -> L10
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "reloadStartAction: applyDeviceStyle done, bgVisible=" + a(r8), false, 4, null);     // Catch: Throwable -> L10
        Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 == null) goto L18;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "reloadStartAction failed", r12);
        return;
    L18:
        return;
    L7:
        r1 = R.drawable.o_floating_title_bar_icon_back;     // Catch: Throwable -> L10
        r3 = "o_floating_title_bar_icon_back";
    L10:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private static final void a(Function0 r1, View r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r1, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    public static final boolean a(final OBottomNavigationBar r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullExpressionValue(r2, "getContext(...)");     // Catch: Throwable -> L12
        Boolean r3 = b(r2, ZeusTransformUtils.mapRes(R.attr.OBottomNavigationBarBgVisible, "attr", "OBottomNavigationBarBgVisible"));     // Catch: Throwable -> L12
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "OBottomNavigationBar.applyDeviceStyle: showBg=" + r3, false, 4, null);     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(r3, false) == false) goto L10;
        r9.setMaskBlurRadius(0.0f);     // Catch: Throwable -> L12
        View r4 = r9.getMaskView();     // Catch: Throwable -> L12
        r4.setVisibility(8);     // Catch: Throwable -> L12
        r4.setBackground(null);     // Catch: Throwable -> L12
        a(r9.getNavigationBar());     // Catch: Throwable -> L12
        View r5 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.bottom_nav_bar_container, OaidModel.KEY_ID, "bottom_nav_bar_container"));     // Catch: Throwable -> L12
        if (ZeusTransformUtils.instanceOf(r5, OUIFrameLayout.class) == false) goto L8;
        b((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r5, OUIFrameLayout.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
    L8:
        b((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r9, OUIFrameLayout.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
        r9.post(new $$Lambda$a$Qyai0hc8sbwP0SCMD8jJcTUm6ck(r9));     // Catch: Throwable -> L12
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "OBottomNavigationBar.applyDeviceStyle: background removed", false, 4, null);     // Catch: Throwable -> L12
        return false;
    L10:
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L20;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "OBottomNavigationBar.applyDeviceStyle failed", r11);
        return true;
    L20:
        return true;
    L12:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static final boolean a(OFloatingTitleBar r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        b(r9);     // Catch: Throwable -> L9
        Boolean r2 = a((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarStartButtonGroupBgVisible, "attr", "OFloatingTitleBarStartButtonGroupBgVisible"));     // Catch: Throwable -> L9
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "applyDeviceStyle: showBg=" + r2, false, 4, null);     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(r2, false) == false) goto L7;
        a((ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
        return false;
    L7:
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L17;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "applyDeviceStyle failed", r11);
        return true;
    L17:
        return true;
    L9:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final Boolean b(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        TypedValue r0 = new TypedValue();
        boolean r1 = true;
        if (r4.getTheme().resolveAttribute(r3, r0, true) == true) goto L5;
        return null;
    L5:
        if (r0.data != 0) goto L11;
        r1 = false;
    L11:
        return Boolean.valueOf(r1);
    }

    private static final Object b(DeviceAttrRegistry.a r1) {
        Intrinsics.checkNotNullParameter(r1, "e");
        return r1.e();
    }

    private static final void b(ViewGroup r9) {
        int r0 = r9.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        View r3 = r9.getChildAt(r2);
        r3.setBackground(null);
        r3.setForeground(null);
        r3.setElevation(0.0f);
        if (ZeusTransformUtils.instanceOf(r3, OUIFrameLayout.class) == false) goto L8;
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r3, OUIFrameLayout.class, "com.obric.memorydata.plugin")).setShadowStyle(ZeusTransformUtils.mapRes(R.style.ShadowNone, "style", "ShadowNone"));
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r3, OUIFrameLayout.class, "com.obric.memorydata.plugin")).setChangeAlphaWhenPress(false);
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r3, OUIFrameLayout.class, "com.obric.memorydata.plugin")).setOverridePressColor(0);
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r3, OUIFrameLayout.class, "com.obric.memorydata.plugin")).refreshColors("OUIDeviceAdaptive");
        a((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r3, OUIFrameLayout.class, "com.obric.memorydata.plugin"));
    L8:
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L10;
        b((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin"));
    L10:
        r2 = r2 + 1;
        goto L3
    }

    private static final void b(OButtonGroup r9) {
        r9.setShadowStyle(ZeusTransformUtils.mapRes(R.style.ShadowNone, "style", "ShadowNone"));
        r9.a(0, 0);
        r9.setPressColor(0);
        OShadowFrame.a((OShadowFrame) ZeusTransformUtils.preCheckCast(r9, OShadowFrame.class, "com.obric.memorydata.plugin"), null, null, false, 4, null);
        r9.setChangeAlphaWhenPress(false);
        r9.setOverridePressColor(0);
        r9.refreshColors("OUIDeviceAdaptive");
        r9.setBackground(null);
        r9.setForeground(null);
        r9.setElevation(0.0f);
        a((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r9, OUIFrameLayout.class, "com.obric.memorydata.plugin"));
        b((ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.memorydata.plugin"));
        r9.invalidate();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "OButtonGroup.nukeStyle: post re-nuke done", false, 4, null);
    }

    private static final void b(OUIFrameLayout r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeFrameLayoutStyle: START on " + r9.getClass().getSimpleName() + '@' + Integer.toHexString(r9.hashCode()), false, 4, null);
        r9.setShadowStyle(ZeusTransformUtils.mapRes(R.style.ShadowNone, "style", "ShadowNone"));
        r9.setChangeAlphaWhenPress(false);
        r9.setOverridePressColor(0);
        r9.refreshColors("OUIDeviceAdaptive");
        r9.setBackground(null);
        r9.setForeground(null);
        r9.setElevation(0.0f);
        a(r9);
        r9.invalidate();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "nukeFrameLayoutStyle: END", false, 4, null);
    }

    private static final void b(OBottomNavigationBar r6) {
        r6.setMaskBlurRadius(0.0f);
        View r0 = r6.getMaskView();
        r0.setVisibility(8);
        r0.setBackground(null);
        a(r6.getNavigationBar());
        View r1 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.bottom_nav_bar_container, OaidModel.KEY_ID, "bottom_nav_bar_container"));
        if (ZeusTransformUtils.instanceOf(r1, OUIFrameLayout.class) == false) goto L5;
        b((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r1, OUIFrameLayout.class, "com.obric.memorydata.plugin"));
    L5:
        b((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r6, OUIFrameLayout.class, "com.obric.memorydata.plugin"));
        r6.invalidate();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "OBottomNavigationBar.applyDeviceStyle: post re-nuke done", false, 4, null);
    }

    private static final void b(OFloatingTitleBar r12) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return;
    L5:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"startTitleView", "startSubtitleView", "centerTitleView", "centerSubtitleView"}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r0.hasNext() == false) goto L22;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L17
        Object r4 = ao.a(r12, r1);     // Catch: Throwable -> L17
        if (ZeusTransformUtils.instanceOf(r4, TextView.class) == false) goto L12;
        TextView r5 = (TextView) ZeusTransformUtils.preCheckCast(r4, TextView.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
    L13:
        if (r5 == null) goto L14;
        boolean r6 = r5.isFallbackLineSpacing();     // Catch: Throwable -> L17
        r5.setFallbackLineSpacing(false);     // Catch: Throwable -> L17
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "disableTitleTextFallbackLineSpacing field=" + r1 + ", view=" + r5.getClass().getName() + ", before=" + r6 + ", after=" + r5.isFallbackLineSpacing(), false, 4, null);     // Catch: Throwable -> L17
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L7;
        RunLog.INSTANCE.error("OUIDeviceAdaptive", "disableTitleTextFallbackLineSpacing failed field=" + r1, r8);
        goto L7
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OUIDeviceAdaptive", "disableTitleTextFallbackLineSpacing skip field=" + r1, false, 4, null);     // Catch: Throwable -> L17
        goto L7
    L12:
        r5 = null;
    L17:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public static final boolean b(Context r16, String r17) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r17, LocationMonitorConst.TAG);
        String r3 = DeviceInfoState.INSTANCE.getDeviceModel();
        int r4 = r3.hashCode();
        if (r4 == (-2002884275)) goto L17;
        if (r4 == (-1048984789)) goto L13;
        if (r4 == 1328894480) goto L10;
    L18:
        Function1 r5 = $$Lambda$a$7oZMJGbieKCkRu1Kx2sg4acGo4.INSTANCE;
    L20:
        StringBuilder r6 = new StringBuilder();
        r6.append("\n==== verifyDeviceOverlayApplied [tag=" + r17 + ", device=" + r3 + "] ====\n");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(DeviceAttrRegistry.f12995a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r7 = true;
    L22:
        if (r0.hasNext() == false) goto L72;
        DeviceAttrRegistry.a r8 = (DeviceAttrRegistry.a) ZeusTransformUtils.preCheckCast(r0.next(), DeviceAttrRegistry.a.class, "com.obric.memorydata.plugin");
        a(r1, r8);
        Object r9 = r5.invoke(r8);
        int r10 = C0711a.f13000a[r8.c().ordinal()];
        if (r10 == 1) goto L58;
        if (r10 != 2) goto L27;
        TypedValue r11 = new TypedValue();
        r1.getTheme().resolveAttribute(r8.b(), r11, true);
        if (r11.data != 0) goto L52;
        boolean r12 = true;
    L54:
        if (r12 != Intrinsics.areEqual(r9, "transparent")) goto L56;
        boolean r13 = true;
    L57:
        Pair r14 = new Pair(Boolean.valueOf(r13), "isTransparent=" + r12 + " vs expect " + r9);
    L67:
        boolean r15 = ((Boolean) ZeusTransformUtils.preCheckCast(r14.component1(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        String r18 = (String) ZeusTransformUtils.preCheckCast(r14.component2(), String.class, "com.obric.memorydata.plugin");
        if (r15 == false) goto L70;
        String r19 = "[OK ]";
    L71:
        r6.append("  " + r19 + ' ' + StringsKt.padEnd$default(r8.a(), 48, 0, 2, null) + " actual=" + r18 + '\n');
        goto L22
    L70:
        r19 = "[MISS]";
        r7 = false;
        goto L71
    L56:
        r13 = false;
        goto L57
    L52:
        r12 = false;
        goto L54
    L27:
        if (r10 != 3) goto L29;
        TypedValue r20 = new TypedValue();
        r1.getTheme().resolveAttribute(r8.b(), r20, true);
        int r110 = r20.data;
        if (ZeusTransformUtils.instanceOf(r9, Integer.class) == true) goto L45;
    L47:
        boolean r111 = false;
    L48:
        r14 = new Pair(Boolean.valueOf(r111), r20.data + " vs expected " + r9);
        goto L67
    L45:
        if (r110 != ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue()) goto L47;
        r111 = true;
        goto L48
    L29:
        if (r10 != 4) goto L40;
        TypedValue r112 = new TypedValue();
        r1.getTheme().resolveAttribute(r8.b(), r112, true);
        if (r112.data == 0) goto L33;
        boolean r113 = true;
    L34:
        Boolean r114 = Boolean.valueOf(Intrinsics.areEqual(Boolean.valueOf(r113), r9));
        StringBuilder r21 = new StringBuilder();
        if (r112.data == 0) goto L37;
        boolean r115 = true;
    L38:
        r14 = new Pair(r114, r21.append(r115).append(" vs expected ").append(r9).toString());
        goto L67
    L37:
        r115 = false;
        goto L38
    L33:
        r113 = false;
        goto L34
    L40:
        throw new NoWhenBranchMatchedException();
    L58:
        TypedValue r22 = new TypedValue();
        r1.getTheme().resolveAttribute(r8.b(), r22, true);
        if (r22.type != 5) goto L61;
        int r23 = TypedValue.complexToDimensionPixelSize(r22.data, ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDisplayMetrics());
    L62:
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Int");
        int r24 = (int) (((Integer) ZeusTransformUtils.preCheckCast(r9, Integer.class, "com.obric.memorydata.plugin")).intValue() * ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDisplayMetrics().density);
        if (r23 != r24) goto L65;
        boolean r116 = true;
    L66:
        r14 = new Pair(Boolean.valueOf(r116), r23 + "px vs expected " + r24 + "px");
        goto L67
    L65:
        r116 = false;
        goto L66
    L61:
        r23 = -1;
        goto L62
    L72:
        r6.append("====================================== allMatch=" + r7 + '\n');
        IRunLog r25 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r26 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r26, "toString(...)");
        if (r7 == false) goto L75;
        IRunLog.a.a(r25, "OUIDeviceAdaptive", r26, false, 4, null);
    L76:
        return r7;
    L75:
        IRunLog.a.b(r25, "OUIDeviceAdaptive", r26, null, 4, null);
        goto L76
    L10:
        if (r3.equals("nerida-lite") == false) goto L18;
    L15:
        r5 = $$Lambda$a$dyTzEIkfg71r1DTaWB05BGfJwU.INSTANCE;
        goto L20
    L13:
        if (r3.equals("nerida") == true) goto L15;
    L17:
        if (r3.equals("Genesis-R") == false) goto L18;
        r5 = $$Lambda$a$F7OQe_C8RmQiU8CN8MiVLwda0.INSTANCE;
        goto L20
    }

    public static final Integer c(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        TypedArray r5 = r4.getTheme().obtainStyledAttributes(new int[]{r3});
        Intrinsics.checkNotNullExpressionValue(r5, "obtainStyledAttributes(...)");
        int r0 = r5.getColor(0, Integer.MIN_VALUE);     // Catch: Throwable -> L9
        if (r0 != Integer.MIN_VALUE) goto L6;
        Integer r6 = null;
    L7:
        r5.recycle();
        return r6;
    L6:
        r6 = Integer.valueOf(r0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    private static final Object c(DeviceAttrRegistry.a r1) {
        Intrinsics.checkNotNullParameter(r1, "e");
        return r1.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<OButtonGroup> c(ViewGroup r6) {
        List<OButtonGroup> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r1 = r6.getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        View r4 = r6.getChildAt(r3);
        if (ZeusTransformUtils.instanceOf(r4, OButtonGroup.class) == false) goto L8;
        r0.add(r4);
    L10:
        r3 = r3 + 1;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L10;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(c((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
        goto L10
    L11:
        return r0;
    }

    /* JADX INFO: renamed from: lambda$7oZMJGbieKC-kRu1Kx2sg4acGo4, reason: not valid java name */
    public static /* synthetic */ Object m1212lambda$7oZMJGbieKCkRu1Kx2sg4acGo4(DeviceAttrRegistry.a r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$F-7OQe_C8RmQiU8CN8MiV-Lwda0, reason: not valid java name */
    public static /* synthetic */ Object m1213lambda$F7OQe_C8RmQiU8CN8MiVLwda0(DeviceAttrRegistry.a r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$NyLR3__942COktL9rzABsHZTg0M(Function0 r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$Qyai0hc8sbwP0SCMD8jJcTUm6ck(OBottomNavigationBar r0) {
        b(r0);
    }

    /* JADX INFO: renamed from: lambda$dyTzEIkfg71-r1DTaWB05BGfJwU, reason: not valid java name */
    public static /* synthetic */ Object m1214lambda$dyTzEIkfg71r1DTaWB05BGfJwU(DeviceAttrRegistry.a r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$mc1y42IvjF7LPeKc3Xb1nzVv-T8, reason: not valid java name */
    public static /* synthetic */ void m1215lambda$mc1y42IvjF7LPeKc3Xb1nzVvT8(OButtonGroup r0) {
        b(r0);
    }
}
