package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.clearscreen.ClearGuideManager;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.utils.condition.base.Condition;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant;
import com.bytedance.android.livesdk.widget.GuidePageController;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/ClearMonitorServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClearMonitorServiceWidget extends LiveRecyclableWidget {
    public final Handler a;
    public final long b;
    public b c;
    public final CompositeDisposable d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ClearMonitorServiceWidget a;

        public a(ClearMonitorServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Unit r5 = (Unit) r4;
            if (com.bytedance.android.live.core.utils.z.m(((Widget) this.a).dataCenter, true) == false) goto L6;
            xs2.b.a().post(new com.bytedance.android.livesdk.clearscreen.m(ClearScreenConst.GuideType.SHOW_CLICK_CLEAR_ENTER_ROOM, "enterRoom"));
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ClearMonitorServiceWidget a;

        public final void a() {
            Iterator r0 = ClearGuideManager.c().iterator();
            boolean r2 = false;
        L3:
            boolean r4 = true;
            if (r0.hasNext() == false) goto L27;
            com.bytedance.android.livesdk.utils.condition.base.c r3 = (com.bytedance.android.livesdk.utils.condition.base.c) r0.next();
            if (r3 == null) goto L16;
            Iterator r5 = ((HashMap) r3.a.getValue()).values().iterator();
        L9:
            if (r5.hasNext() == false) goto L13;
            Condition r6 = (Condition) r5.next();
            if (r6.f.b((HashMap) r6.c.getValue(), r6.b) == true) goto L9;
            boolean r7 = false;
        L14:
            if (r7 != true) goto L16;
        L17:
            if (r4 == false) goto L26;
            ClearGuideManager.a();
            if (r3 == null) goto L26;
            Iterator r8 = ((HashMap) r3.b.getValue()).values().iterator();
        L22:
            if (r8.hasNext() == false) goto L26;
            Runnable r9 = ((com.bytedance.android.livesdk.utils.condition.base.f) r8.next()).a;
            if (r9 == null) goto L22;
            r9.run();
        L26:
            r2 = r4;
            goto L3
        L13:
            r7 = true;
        L16:
            r4 = false;
            goto L17
        L27:
            Iterator r1 = ClearGuideManager.c().iterator();
        L29:
            if (r1.hasNext() == false) goto L36;
            com.bytedance.android.livesdk.utils.condition.base.c r10 = (com.bytedance.android.livesdk.utils.condition.base.c) r1.next();
            if (r10 == null) goto L29;
            Iterator r11 = ((HashMap) r10.a.getValue()).values().iterator();
        L34:
            if (r11.hasNext() == false) goto L29;
            ((Condition) r11.next()).c();
            goto L34
        L36:
            if (r2 != true) goto L40;
            ClearMonitorServiceWidget r12 = this.a;
            b r13 = r12.c;
            if (r13 == null) goto L58;
            r12.a.removeCallbacks(r13);
            return;
        L58:
            return;
        L40:
            ClearMonitorServiceWidget r14 = this.a;
            r14.a.postDelayed(this, r14.b);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ClearMonitorServiceWidget r1) {
            this.a = r1;
        }
    }

    public final void onLoad(Object[] r1) {
    }

    public final void onUnload() {
        b r0 = this.c;
        if (r0 == null) goto L5;
        this.a.removeCallbacks(r0);
    L5:
        this.d.clear();
        ClearGuideManager.a();
        ClearGuideManager.c().clear();
        ClearGuideManager.a = new com.bytedance.android.livesdk.clearscreen.g();
    }

    public ClearMonitorServiceWidget() {
        this.a = new Handler(Looper.getMainLooper());
        this.b = 3000;
        this.d = new CompositeDisposable();
    }

    public final void onStart() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStart();
        b r0 = this.c;
        if (r0 == null) goto L6;
        this.a.postDelayed(r0, this.b);
        return;
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        b r0 = this.c;
        if (r0 == null) goto L6;
        this.a.removeCallbacks(r0);
        return;
    }

    public final void onInit(Object[] r13) {
        boolean r0 = false;
        if (wt2.a.n() != 1) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == false) goto L100;
        RoomContext.a r15 = RoomContext.Companion;
        RoomContext r2 = RoomContext.a.c(r15, ((Widget) this).dataCenter, 0, 2);
        if (r2 == null) goto L19;
        com.bytedance.live.datacontext.n r3 = r2.getExternalConfigJudger();
        if (r3 == null) goto L19;
        IExternalConfigJudger r4 = (IExternalConfigJudger) r3.getValue();
        if (r4 == null) goto L19;
        if (r4.disable(EXTERNAL_CONFIG_TYPE.Gesture, "rightScroll") != true) goto L19;
    L27:
        boolean r5 = true;
    L29:
        if (r5 == false) goto L31;
        return;
    L31:
        ALogger.d("CLEAR_GUIDE_TAG", "可以展示CLEAR_GUIDE");
        Lazy r6 = ClearScreenHelper.a;
        if (ClearScreenHelper.d(((Widget) this).dataCenter) == true) goto L34;
    L41:
        boolean r7 = false;
    L42:
        if (r7 == true) goto L44;
    L58:
        com.bytedance.android.livesdk.utils.condition.base.e r16 = ClearGuideManager.a;
        Context r17 = getContext();
        Intrinsics.checkNotNullParameter(r17, "context");
        SharedPrefHelper r8 = SharedPrefHelper.b(r17);
        r8.h(ClearGuideManager.d, 0);
        r8.h(ClearGuideManager.e, 0);
        r8.i(ClearGuideManager.f, 0);
        String r9 = ClearGuideManager.c;
        if (r8.h(r9, 0) == 0) goto L64;
        if (ClearScreenHelper.k().c() == true) goto L64;
    L93:
        if (r0 == false) goto L101;
        this.c = new b(this);
        return;
    L101:
        return;
    L64:
        if (r8.h(r9, 0) != 0) goto L66;
    L67:
        ConditionConstant.ConditionRepo r1 = ConditionConstant.ConditionRepo.SHOW_CLEAR_GUIDE;
        ConditionConstant.Target r10 = ConditionConstant.Target.SHOW_CLEAR_GUIDE;
        com.bytedance.android.livesdk.utils.condition.base.f r11 = new com.bytedance.android.livesdk.utils.condition.base.f(r10, new com.bytedance.android.livesdk.clearscreen.f("0"));
        ClearGuideManager.a = new com.bytedance.android.livesdk.clearscreen.c(r17);
        r1.getId();
        com.bytedance.android.livesdk.utils.condition.base.c r18 = new com.bytedance.android.livesdk.utils.condition.base.c(r1.getDescription());
        com.bytedance.android.livesdk.utils.condition.base.e r12 = ClearGuideManager.a;
        if (r12 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("interceptr");
    L70:
        Condition r19 = new Condition(ConditionConstant.ConditionType.SHOW_COMMENT, r12, new com.bytedance.android.livesdk.clearscreen.b(ClearScreenHelper.k().a()));
        com.bytedance.android.livesdk.utils.condition.base.e r20 = ClearGuideManager.a;
        if (r20 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("interceptr");
    L73:
        ConditionConstant.ConditionType r21 = ConditionConstant.ConditionType.SHOW_GIFT_EFFECT;
        Condition r110 = new Condition(r21, r20, new com.bytedance.android.livesdk.clearscreen.b(ClearScreenHelper.k().b()));
        r18.a(r19);
        r18.a(r110);
        Intrinsics.checkNotNullParameter(r11, "target");
        ((HashMap) r18.b.getValue()).put(r11.getType(), r11);
        com.bytedance.android.livesdk.utils.condition.base.f r22 = new com.bytedance.android.livesdk.utils.condition.base.f(r10, new com.bytedance.android.livesdk.clearscreen.f("1"));
        r1.getId();
        com.bytedance.android.livesdk.utils.condition.base.c r23 = new com.bytedance.android.livesdk.utils.condition.base.c(r1.getDescription());
        com.bytedance.android.livesdk.utils.condition.base.e r24 = ClearGuideManager.a;
        if (r24 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("interceptr");
    L76:
        ConditionConstant.ConditionType r25 = ConditionConstant.ConditionType.CLAER_GUIDE_TRIGGER_2;
        Condition r26 = new Condition(r25, r24, new com.bytedance.android.livesdk.clearscreen.e());
        ConditionConstant.ConditionType r27 = ConditionConstant.ConditionType.SHOW_CARD;
        com.bytedance.android.livesdk.utils.condition.base.e r28 = ClearGuideManager.a;
        if (r28 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("interceptr");
    L79:
        r26.a(r27, ClearGuideManager.b(r28, r27, r25));
        ConditionConstant.ConditionType r29 = ConditionConstant.ConditionType.SHOW_SALE;
        com.bytedance.android.livesdk.utils.condition.base.e r30 = ClearGuideManager.a;
        if (r30 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("interceptr");
    L82:
        r26.a(r29, ClearGuideManager.b(r30, r29, r25));
        ConditionConstant.ConditionType r31 = ConditionConstant.ConditionType.SHOW_PIN_COMMENT;
        com.bytedance.android.livesdk.utils.condition.base.e r32 = ClearGuideManager.a;
        if (r32 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("interceptr");
    L85:
        r26.a(r31, ClearGuideManager.b(r32, r31, r25));
        ConditionConstant.ConditionType r33 = ConditionConstant.ConditionType.SHOW_BUBBLE;
        com.bytedance.android.livesdk.utils.condition.base.e r34 = ClearGuideManager.a;
        if (r34 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("interceptr");
    L88:
        r26.a(r33, ClearGuideManager.b(r34, r33, r25));
        com.bytedance.android.livesdk.utils.condition.base.e r35 = ClearGuideManager.a;
        if (r35 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("interceptr");
    L91:
        r26.a(r21, ClearGuideManager.b(r35, r21, r25));
        r23.a(r26);
        Intrinsics.checkNotNullParameter(r22, "target");
        ((HashMap) r23.b.getValue()).put(r22.getType(), r22);
        ClearGuideManager.c().add(r18);
        ClearGuideManager.c().add(r23);
    L92:
        r0 = true;
        goto L93
    L66:
        if (ClearScreenHelper.k().c() == false) goto L92;
    L44:
        if (GuidePageController.c.a() == false) goto L58;
        RoomContext r111 = RoomContext.a.c(r15, ((Widget) this).dataCenter, 0, 2);
        if (r111 == null) goto L96;
        com.bytedance.live.datacontext.m r112 = r111.getCsGuideTimer();
        if (r112 == null) goto L97;
        ig1.b r113 = (ig1.b) r112.getValue();
        if (r113 == null) goto L98;
        Disposable r36 = RxUtilKt.h(r113.c()).subscribe(new a(this));
        if (r36 == null) goto L55;
        RxUtilKt.c(r36, this.d);
    L55:
        if (r113.b() == true) goto L99;
        r113.a();
        return;
    L99:
        return;
    L98:
        return;
    L97:
        return;
    L96:
        return;
    L34:
        if (ClearScreenHelper.l(((Widget) this).dataCenter) == true) goto L36;
    L38:
        boolean r37 = false;
    L39:
        if (r37 == false) goto L41;
        r7 = true;
        goto L42
    L36:
        if (ClearScreenHelper.j().l() == false) goto L38;
        r37 = true;
    L19:
        RoomContext r38 = RoomContext.a.c(r15, ((Widget) this).dataCenter, 0, 2);
        if (r38 == null) goto L28;
        com.bytedance.live.datacontext.n r39 = r38.getExternalConfigJudger();
        if (r39 == null) goto L28;
        IExternalConfigJudger r40 = (IExternalConfigJudger) r39.getValue();
        if (r40 == null) goto L28;
        if (r40.disable(EXTERNAL_CONFIG_TYPE.Guide, "rightScrollGuide") == true) goto L27;
    L28:
        r5 = false;
        goto L29
    L100:
        return;
    L5:
        if (wt2.a.n() == 4) goto L8;
        r14 = false;
        goto L9
    }
}
