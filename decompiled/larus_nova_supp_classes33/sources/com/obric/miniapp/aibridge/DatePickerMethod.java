package com.obric.miniapp.aibridge;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.FrameLayout;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.miniapp.utils.c1;
import com.obric.miniapp.utils.g0;
import com.obric.miniapp.utils.h0;
import com.obric.miniapp.utils.i0;
import com.obric.oui.picker.reels.views.OReelPickerThreeReels;
import com.obric.oui.selection.OSelectionPanelBtnView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.obric.oui.titlebar.OCTitleBar;
import java.lang.ref.WeakReference;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/miniapp/aibridge/DatePickerMethod;", "Lcom/obric/miniapp/aibridge/AbsDatePickerMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsDatePickerMethodIDL$DatePickerParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsDatePickerMethodIDL$DatePickerResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DatePickerMethod extends AbsDatePickerMethodIDL {
    public final boolean mustRunInMain() {
        return true;
    }

    public DatePickerMethod() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void handle(e3.d r28, ParamModel r29, f3.h r30) {
        AbsDatePickerMethodIDL.a r1 = (AbsDatePickerMethodIDL.a) r29;
        Intrinsics.checkNotNullParameter(r28, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r30, "callback");
        final Activity r2 = AppHost.a.a().getCurrentActivity();
        Map r4 = null;
        if ((r2 instanceof Context) == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L8;
        f3.h.a.a(r30, "No available activity context", null, null, 14);
        return;
    L8:
        Integer r3 = r1.getType();
        final a r14 = new a(r30);
        if (r3 != null) goto L12;
    L63:
        if (r3 == null) goto L88;
        if (r3.intValue() != 4) goto L88;
        Long r0 = r1.getDefaultTime();
        if (r0 == null) goto L70;
        long r5 = r0.longValue();
        com.obric.miniapp.utils.a0.a.getClass();
        final LocalDate r6 = com.obric.miniapp.utils.a0.v(r5);
    L71:
        com.obric.miniapp.utils.a0 r7 = com.obric.miniapp.utils.a0.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "ctx");
        r7.k("showDatePickerV2");
        hma.c.a r8 = new hma.c.a();
        if (r6 != null) goto L74;
        r6 = LocalDate.now();
    L74:
        r8.i(r2, 1001, 1900, 2050, Integer.valueOf(r6.getYear()), null);
        r8.f(r2, 1002, Integer.valueOf(r6.getMonthValue()), null);
        hma.c.a.c(r8, r2, 1003, Integer.valueOf(r6.getDayOfMonth()));
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        Consumer r10 = new com.obric.miniapp.utils.v(r9, r2, r6);
        Intrinsics.checkNotNullParameter(r10, "listener");
        r8.a = r10;
        final hma.c r11 = (hma.c) hma.d.a.a(r8, r2);
        r9.element = r11;
        FrameLayout r12 = com.obric.miniapp.utils.a0.j(r2, r11);
        hma.c.b r13 = r11.b();
        if (r13 == null) goto L77;
        Map r15 = r13.a;
    L78:
        com.obric.miniapp.utils.a0.e(r2, r11, r15, 1001, 1002, 1003, 1900, r6.getYear(), r6.getMonthValue());
        final AtomicBoolean r16 = new AtomicBoolean(false);
        Activity r17 = com.obric.miniapp.utils.a0.l(r2);
        if (r17 != null) goto L81;
    L86:
        FLogger.a.w("DatePickerUtils", "showDatePickerV2 blocked: invalid Activity context");
        com.obric.miniapp.utils.a0.s(r16, r14, null);
        c1.a(r2, 0);
        return;
    L81:
        if (r17.isFinishing() == true) goto L86;
        if (r17.isDestroyed() == true) goto L86;
        System.identityHashCode(r17);
        final OSheetBase r18 = c1.a(r2, 0);
        com.obric.miniapp.utils.a0.d = new WeakReference(r18);
        final LocalDate r19 = r6;
        OSheetBase.DefaultImpls.o(r18, OSheet.Header.ACTION, null, "选择日期", null, true, new com.obric.miniapp.utils.w(r16, r14, r18), new com.obric.miniapp.utils.x(r11, r19, r18, r16, r14, r18), 16134);
        OSheetBase.DefaultImpls.j(r18, r12);
        r18.setOnDismissListener(new com.obric.miniapp.utils.y(r18, r16, r14));
        r7.u(r18, new com.obric.miniapp.utils.z(r16, r14));
        return;
    L77:
        r15 = null;
        goto L78
    L70:
        r6 = null;
    L88:
        if (r3 != null) goto L91;
    L117:
        Long r20 = r1.getDefaultTime();
        if (r20 == null) goto L120;
        long r21 = r20.longValue();
        com.obric.miniapp.utils.a0.a.getClass();
        LocalDate r22 = com.obric.miniapp.utils.a0.v(r21);
    L121:
        com.obric.miniapp.utils.a0.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "ctx");
        hma.e.a r23 = new hma.e.a();
        r23.b = 1900;
        r23.c = 2050;
        if (r22 == null) goto L124;
        Intrinsics.checkNotNullParameter(r22, "selected");
        r23.e = new hma.e.b(r22.getYear(), r22.getMonthValue(), r22.getDayOfMonth());
    L124:
        Consumer r24 = new com.obric.miniapp.utils.i();
        Intrinsics.checkNotNullParameter(r24, "listener");
        r23.d = r24;
        final hma.e r25 = (hma.e) hma.d.a.a(r23, r2);
        final OInsetSheet r26 = new OInsetSheet(r2);
        r26.e(OInsetSheet.PanelWidth.BOARD_WIDTH);
        OCTitleBar r27 = new OCTitleBar(r2, null, 6, 0);
        r27.setShowLeftBack(false);
        r27.setTitleText("选择日期");
        FrameLayout r31 = r26.a;
        if (r31 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        r31 = null;
    L128:
        OInsetSheet.d(r31, r27);
        hma.e.a r32 = r25.a;
        if (r32 == null) goto L133;
        OReelPickerThreeReels r33 = r32.f;
        if (r33 == null) goto L133;
    L134:
        OInsetSheet.d(r26.b(), r33);
        OSelectionPanelBtnView r34 = com.obric.miniapp.utils.a0.m(r2, new com.obric.miniapp.utils.j(r26), new com.obric.miniapp.utils.k(r25, r14, r26));
        FrameLayout r35 = r26.b;
        if (r35 == null) goto L137;
        FrameLayout r36 = r35;
    L138:
        OInsetSheet.d(r36, r34);
        com.obric.miniapp.utils.a0.c(r26);
        return;
    L137:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        r36 = null;
    L133:
        r33 = null;
        goto L134
    L120:
        r22 = null;
        goto L121
    L91:
        if (r3.intValue() != 1) goto L117;
        Long r37 = r1.getDefaultTime();
        if (r37 == null) goto L95;
        long r38 = r37.longValue();
        com.obric.miniapp.utils.a0.a.getClass();
        LocalDateTime r39 = com.obric.miniapp.utils.a0.w(r38);
    L96:
        com.obric.miniapp.utils.a0.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "ctx");
        hma.g.a r40 = new hma.g.a();
        if (r39 == null) goto L99;
        Intrinsics.checkNotNullParameter(r39, "selected");
        r40.d = r39;
    L99:
        LocalDate r41 = LocalDate.of(2010, 1, 1);
        LocalDate r42 = LocalDate.of(2037, 12, 31);
        Intrinsics.checkNotNullParameter(r41, "from");
        Intrinsics.checkNotNullParameter(r42, "to");
        if (r41.compareTo(r42) > 0) goto L102;
        r40.a = r41;
        r40.b = r42;
    L102:
        Consumer r43 = new com.obric.miniapp.utils.l();
        Intrinsics.checkNotNullParameter(r43, "listener");
        r40.c = r43;
        final hma.g r44 = (hma.g) hma.d.a.a(r40, r2);
        final OInsetSheet r45 = new OInsetSheet(r2);
        r45.e(OInsetSheet.PanelWidth.BOARD_WIDTH);
        OCTitleBar r46 = new OCTitleBar(r2, null, 6, 0);
        r46.setShowLeftBack(false);
        r46.setTitleText("选择日期及时间");
        FrameLayout r47 = r45.a;
        if (r47 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        r47 = null;
    L106:
        OInsetSheet.d(r47, r46);
        hma.g.a r48 = r44.a;
        if (r48 == null) goto L111;
        OReelPickerThreeReels r49 = r48.e;
        if (r49 == null) goto L111;
    L112:
        OInsetSheet.d(r45.b(), r49);
        OSelectionPanelBtnView r50 = com.obric.miniapp.utils.a0.m(r2, new com.obric.miniapp.utils.m(r45), new com.obric.miniapp.utils.n(r44, r14, r45));
        FrameLayout r51 = r45.b;
        if (r51 == null) goto L115;
        FrameLayout r52 = r51;
    L116:
        OInsetSheet.d(r52, r50);
        com.obric.miniapp.utils.a0.c(r45);
        return;
    L115:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        r52 = null;
    L111:
        r49 = null;
        goto L112
    L95:
        r39 = null;
        goto L96
    L12:
        if (r3.intValue() != 3) goto L63;
        Long r53 = r1.getDefaultTime();
        if (r53 == null) goto L16;
        long r54 = r53.longValue();
        com.obric.miniapp.utils.a0.a.getClass();
        LocalDateTime r55 = com.obric.miniapp.utils.a0.w(r54);
    L17:
        com.obric.miniapp.utils.a0 r56 = com.obric.miniapp.utils.a0.a;
        r56.getClass();
        Intrinsics.checkNotNullParameter(r2, "ctx");
        r56.k("showDateTimePickerV2");
        AtomicBoolean r110 = new AtomicBoolean(false);
        if (r55 != null) goto L20;
        r55 = LocalDateTime.now();
    L20:
        Activity r57 = com.obric.miniapp.utils.a0.l(r2);
        if (r57 != null) goto L23;
    L62:
        FLogger.a.w("DatePickerUtils", "showDateTimePickerV2 blocked: invalid Activity context");
        com.obric.miniapp.utils.a0.t(r110, r14, null);
        c1.a(r2, 0);
        return;
    L23:
        if (r57.isFinishing() == true) goto L62;
        if (r57.isDestroyed() == true) goto L62;
        System.identityHashCode(r57);
        OSheetBase r111 = c1.a(r2, 0);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L61;
        hma.c.a r58 = new hma.c.a();
        r58.i(r2, ErrorCode.Clock.TIMER_NOT_EXIST_ERROR, 2010, 2037, Integer.valueOf(r55.getYear()), null);
        r58.f(r2, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR, Integer.valueOf(r55.getMonthValue()), null);
        hma.c.a.c(r58, r2, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR, Integer.valueOf(r55.getDayOfMonth()));
        hma.c.a.d(r58, r2, 2004, true, true, Integer.valueOf(r55.getHour()));
        hma.c.a.e(r58, r2, 2005, true, Integer.valueOf(r55.getMinute()));
        Ref.ObjectRef r59 = new Ref.ObjectRef();
        com.obric.miniapp.utils.e0 r60 = new com.obric.miniapp.utils.e0(r59, r2, r55);
        Intrinsics.checkNotNullParameter(r60, "listener");
        r58.a = r60;
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L32
        Object r62 = Result.constructor-impl((hma.c) hma.d.a.a(r58, r2));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r62) == false) goto L37;
        r62 = null;
    L37:
        hma.c r63 = (hma.c) r62;
        r59.element = r63;
        if (r63 == null) goto L40;
        com.obric.miniapp.utils.a0.a.getClass();
        FrameLayout r64 = com.obric.miniapp.utils.a0.j(r2, r63);
    L41:
        FrameLayout r112 = r64;
        if (r63 == null) goto L59;
        com.obric.miniapp.utils.a0 r65 = com.obric.miniapp.utils.a0.a;
        hma.c.b r66 = r63.b();     // Catch: Throwable -> L53
        if (r66 == null) goto L47;
        r4 = r66.a;     // Catch: Throwable -> L53
    L47:
        Map r67 = r4;
        int r68 = r55.getYear();     // Catch: Throwable -> L53
        int r113 = r55.getMonthValue();     // Catch: Throwable -> L53
        r65.getClass();     // Catch: Throwable -> L53
        Activity r69 = r2;
        FrameLayout r70 = r112;
        String r71 = "DatePickerUtils";
        com.obric.miniapp.utils.a0.e(r69, r63, r67, ErrorCode.Clock.TIMER_NOT_EXIST_ERROR, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR, 2010, r68, r113);     // Catch: Throwable -> L51
        Object r72 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L56:
        Throwable r73 = Result.exceptionOrNull-impl(r72);
        if (r73 == null) goto L60;
        FLogger.a.w(r71, "showDateTimePickerV2 initial adjustDayReelIfNeeded failed: " + r73.getMessage());
    L60:
        com.obric.miniapp.utils.a0.d = new WeakReference(r111);
        OSheetBase.DefaultImpls.o(r111, OSheet.Header.ACTION, null, "选择日期", null, true, new com.obric.miniapp.utils.f0(r110, r14, r111), new g0(r63, r55, r110, r14, r111), 16134);
        OSheetBase.DefaultImpls.j(r111, r70);
        r111.setOnDismissListener(new h0(r111, r110, r14));
        com.obric.miniapp.utils.a0.a.u(r111, new i0(r110, r14));
        return;
    L51:
        th = th;
    L55:
        Result.Companion r74 = Result.Companion;
        r72 = Result.constructor-impl(ResultKt.createFailure(th));
    L53:
        th = th;
        r70 = r112;
        r71 = "DatePickerUtils";
        goto L55
    L59:
        r70 = r112;
        goto L60
    L40:
        FLogger.a.e("DatePickerUtils", "showDateTimePickerV2 build picker failed");
        r64 = new FrameLayout(r2);
    L32:
        th = move-exception;
        Result.Companion r75 = Result.Companion;
        r62 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L61:
        com.obric.miniapp.utils.a0.d(r56).post(new com.obric.miniapp.utils.d0(r2, r55, r111, r110, r14));
        return;
    L16:
        r55 = null;
        goto L17
    }
}
