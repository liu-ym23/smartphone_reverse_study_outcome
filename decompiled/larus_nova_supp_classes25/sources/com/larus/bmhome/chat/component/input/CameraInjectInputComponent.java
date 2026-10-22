package com.larus.bmhome.chat.component.input;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.ab.InputMultilineScene;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import com.larus.bmhome.chat.component.bottom.core.speaker.l$a;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.popupwindow.AutoOffsetPopupWindow;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0014\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0014\u0010 \u001a\u00020\u00172\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\u0018\u0010-\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/H\u0016J$\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000202012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/H\u0002J\u001c\u00103\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000202012\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u00109\u001a\u00020\u00172\b\u0010:\u001a\u0004\u0018\u00010\u0019H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\r\u001a\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/larus/bmhome/chat/component/input/CameraInjectInputComponent;", "Lcom/larus/bmhome/chat/component/input/InjectInputComponent;", "<init>", "()V", "inputMultilineSceneKey", "", "getInputMultilineSceneKey", "()Ljava/lang/String;", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "speakerStateListener", "com/larus/bmhome/chat/component/input/CameraInjectInputComponent$speakerStateListener$1", "Lcom/larus/bmhome/chat/component/input/CameraInjectInputComponent$speakerStateListener$1;", "onViewCreated", "", "view", "Landroid/view/View;", "onResume", "syncSuggestedActionSuppression", "onPause", "operateCommonConfig", "operator", "Lcom/larus/bmhome/chat/component/bottom/core/InputView$Operator;", "renderCameraActionEntrance", "onReadyToInput", "", "onReadyToSend", "onReadyToSpeak", "setCallback", "callback", "Lcom/larus/bmhome/injectinput/IInjectInputCallback;", "startInput", "inputType", "Lcom/larus/bmhome/injectinput/IInjectInputService$InjectInputType;", "stopInput", "refreshActionEntrance", "dispatchTouchEventToSpeaker", "event", "Landroid/view/MotionEvent;", "getGlobalActionXY", "Lkotlin/Pair;", "", "getDeltaXY", "kvStore", "Lcom/bytedance/keva/Keva;", "getKvStore", "()Lcom/bytedance/keva/Keva;", "kvStore$delegate", "showCameraMultiCaptureTips", "anchorView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CameraInjectInputComponent extends InjectInputComponent {
    public static final /* synthetic */ int w = 0;
    public final String r;
    public final Lazy s;
    public final Lazy t;
    public final c u;
    public final Lazy v;

    public static final class a {
    }

    public static final class b implements ICoreInputAbility.e {
        public final /* synthetic */ CameraInjectInputComponent a;

        public b(CameraInjectInputComponent r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }

        public final void i(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
            op8.f r0 = this.a.n;
            if (r0 == null) goto L5;
            r0.a(r2);
        L5:
            CameraInjectInputComponent r3 = this.a;
            int r1 = CameraInjectInputComponent.w;
            r3.B3(null);
            this.a.C3();
        }

        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }
    }

    public static final class c implements com.larus.bmhome.chat.component.bottom.core.speaker.h {
        public final /* synthetic */ CameraInjectInputComponent a;

        public c(CameraInjectInputComponent r1) {
            this.a = r1;
        }

        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            if (Intrinsics.areEqual(r5, com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a) == false) goto L6;
            op8.f.a.a r0 = op8.f.a.a.a;
        L20:
            FLogger.a.i("CameraInjectInputComponent", "[onAsrStateChanged] state:" + r5 + ", mappedState:" + r0);
            op8.f r6 = this.a.n;
            if (r6 == null) goto L26;
            r6.e(r0);
            return;
        L26:
            return;
        L6:
            if (Intrinsics.areEqual(r5, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.a) == false) goto L9;
            r0 = op8.f.a.b.a;
            goto L20
        L9:
            if (Intrinsics.areEqual(r5, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a) == false) goto L12;
            r0 = op8.f.a.c.a;
            goto L20
        L12:
            if ((r5 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L18;
            com.larus.bmhome.chat.component.bottom.core.speaker.g.e r1 = (com.larus.bmhome.chat.component.bottom.core.speaker.g.e) r5;
            if (r1.c == false) goto L16;
            r0 = op8.f.a.a.a;
            goto L20
        L16:
            r0 = new op8.f.a.e(r1.a);
            goto L20
        L18:
            if ((r5 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.d) == false) goto L25;
            r0 = new op8.f.a.d(((com.larus.bmhome.chat.component.bottom.core.speaker.g.d) r5).a);
            goto L20
        L25:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.component.input.InjectInputComponent
    public final void o8() {
        B3(null);
    }

    public final void C3() {
        op8.f r0 = this.n;
        if (r0 == null) goto L11;
        ICoreInputAbility r1 = Y2();
        boolean r2 = false;
        if (r1 != null) goto L7;
    L9:
        r0.h(r2);
        return;
    L7:
        if (r1.b9() != true) goto L9;
        r2 = true;
        goto L9
    }

    public final void onPause() {
        FLogger.a.i("CameraInjectInputComponent", "[onPause]");
        com.larus.bmhome.chat.component.bottom.core.speaker.l r0 = p3();
        if (r0 == null) goto L5;
        l$a.b(r0, new com.larus.bmhome.chat.component.input.a());
    L5:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = p3();
        if (r1 == null) goto L9;
        r1.B9(this.u);
        return;
    }

    public final com.larus.bmhome.chat.component.bottom.core.speaker.l p3() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.s.getValue();
    }

    @Override // com.larus.bmhome.chat.component.input.InjectInputComponent
    public final void stopInput() {
        va8.o r0 = (va8.o) this.t.getValue();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L13;
        FLogger.a.i("CameraInjectInputComponent", "[stopInput] text");
        ICoreInputAbility r3 = Y2();
        if (r3 == null) goto L13;
        r3.qp(false);
    L13:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r4 = p3();
        if (r4 != null) goto L16;
    L18:
        r1 = false;
    L19:
        if (r1 == false) goto L24;
        FLogger.a.i("CameraInjectInputComponent", "[stopInput] audio");
        com.larus.bmhome.chat.component.bottom.core.speaker.l r5 = p3();
        if (r5 == null) goto L25;
        r5.A9();
        return;
    L25:
        return;
    L24:
        return;
    L16:
        if (r4.m0() != true) goto L18;
    L5:
        if (r0.w() != true) goto L7;
        r2 = true;
        goto L9
    }

    public CameraInjectInputComponent() {
        this.r = InputMultilineScene.CAMERA_PREVIEW.getSceneKey();
        this.s = LazyKt.lazy(new f(this));
        this.t = LazyKt.lazy(new g(this));
        this.u = new c(this);
        this.v = LazyKt.lazy(new h());
    }

    @Override // com.larus.bmhome.chat.component.input.InjectInputComponent
    public final void onResume() {
        super.onResume();
        com.larus.bmhome.chat.component.bottom.core.speaker.l r0 = p3();
        if (r0 == null) goto L5;
        l$a.b(r0, new i());
    L5:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = p3();
        if (r1 == null) goto L8;
        r1.e8(this.u);
    L8:
        ICoreInputAbility r2 = Y2();
        if (r2 == null) goto L11;
        r2.YT(new b(this));
    L11:
        C3();
    }

    @Override // com.larus.bmhome.chat.component.input.InjectInputComponent
    public final String m3() {
        return this.r;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.view.View, java.lang.Object] */
    public final void B3(g9.c r33) {
        String r1 = null;
        if (r33 != null) goto L10;
        ICoreInputAbility r2 = Y2();
        if (r2 == null) goto L7;
        g9.c r3 = r2.q20();
    L8:
        if (r3 != null) goto L11;
        return;
    L11:
        op8.f r4 = this.n;
        if (r4 != null) goto L14;
    L16:
        boolean r5 = false;
    L17:
        h9 r6 = r3.a();
        if (r5 == false) goto L37;
        va8.o r7 = (va8.o) this.t.getValue();
        if (r7 == null) goto L22;
        r1 = r7.u7();
    L22:
        if (r1 != null) goto L24;
    L27:
        boolean r8 = true;
    L28:
        if (r8 == true) goto L36;
        ICoreInputAbility r9 = Y2();
        if (r9 != null) goto L32;
    L34:
        boolean r10 = false;
    L35:
        if (r10 == false) goto L37;
    L32:
        if (r9.J8() != true) goto L34;
        r10 = true;
    L36:
        boolean r11 = true;
    L38:
        r6.e(r11);
        r3.c().e(false);
        z8 r12 = h3();
        if (r12 == null) goto L41;
        r12.C8(r5);
    L41:
        if (r5 == true) goto L43;
        return;
    L43:
        h9 r13 = r3.a();
        int r14 = com.larus.utils.j0.a;
        String r15 = com.larus.utils.j0.d(2131898784);
        Intrinsics.checkNotNullParameter(r15, "contentDescription");
        ?? r16 = r13.a;
        if (r16 == 0) goto L46;
        r16.setContentDescription(r15);
    L46:
        r3.b().c(v19.c.b(2130971931, getContext(), 2131242482));
        final ?? r17 = r3.b().a;
        if (r17 != 0) goto L49;
        return;
    L49:
        if (((Keva) this.v.getValue()).getBoolean("camera_multi_capture_show_tips", false) == false) goto L52;
        return;
    L52:
        if (r17.isAttachedToWindow() == false) goto L58;
        int r18 = AutoOffsetPopupWindow.a;
        Context r19 = r17.getContext();
        AppHost.Companion r20 = AppHost.a;
        final PopupWindow r21 = AutoOffsetPopupWindow.a(r19, r17, r20.getApplication().getString(2131901495), null, r20.getApplication().getString(2131900558), i5.h(), i5.h(), i5.m(), AutoOffsetPopupWindow.WindowGravity.TOP, i5.r0(), 0, null, new d(), 0, 0, null, null, null, false, false, null, 0, null, false, null, 67103752);
        r17.postDelayed(new e(r17, r21), 3000);
        ((Keva) this.v.getValue()).storeBoolean("camera_multi_capture_show_tips", true);
        return;
    L58:
        return;
    L24:
        if (r1.length() == 0) goto L27;
        r8 = false;
    L37:
        r11 = false;
        goto L38
    L14:
        if (r4.g() != true) goto L16;
        r5 = true;
        goto L17
    L7:
        r3 = null;
        goto L8
    L10:
        r3 = r33;
        goto L11
    }

    @Override // com.larus.bmhome.chat.component.input.InjectInputComponent
    public final void M2(op8.i.a r14) {
        Intrinsics.checkNotNullParameter(r14, "inputType");
        FLogger.a.i("CameraInjectInputComponent", "[startInput] inputType:" + r14);
        if (Intrinsics.areEqual(r14, op8.i.a.a.a) == false) goto L8;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = p3();
        if (r1 == null) goto L18;
        l$a.a(r1, true, true, null, false, null, null, null, null, null, null, 1020);
        return;
    L18:
        return;
    L8:
        if (Intrinsics.areEqual(r14, op8.i.a.b.a) == false) goto L17;
        ICoreInputAbility r15 = Y2();
        if (r15 == null) goto L12;
        r15.g2(1, true);
    L12:
        ICoreInputAbility r16 = Y2();
        if (r16 == null) goto L20;
        ICoreInputAbility.b.e(r16, "InjectInputComponent#startInput", null, false, 6);
        return;
    L20:
        return;
    L17:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.bmhome.chat.component.input.InjectInputComponent
    public final void Tv(op8.f r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super.Tv(r2);
        B3(null);
        C3();
    }

    @Override // com.larus.bmhome.chat.component.input.InjectInputComponent
    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r0 == null) goto L12;
        final String r1 = r0.getString("inject_input_initial_text");
        if (r1 == null) goto L12;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        r5.post(new j(this, r1));
    L12:
        va8.o r6 = (va8.o) this.t.getValue();
        if (r6 == null) goto L15;
        r6.N4();
    L15:
        z2.a.w3();
        z8 r7 = h3();
        if (r7 == null) goto L18;
        r7.z9(true);
    L18:
        z8 r8 = h3();
        if (r8 == null) goto L21;
        r8.S8(true);
    L21:
        ICoreInputAbility r9 = Y2();
        if (r9 == null) goto L24;
        r9.v6(new k(this));
    L24:
        z8 r10 = h3();
        if (r10 == null) goto L27;
        r10.y9(1, new g9.a(new l(this)));
    L27:
        z8 r11 = h3();
        if (r11 == null) goto L30;
        r11.y9(2, new g9.a(new m(this)));
    L30:
        z8 r12 = h3();
        if (r12 == null) goto L33;
        r12.y9(3, new g9.a(new n(this)));
    L33:
        z8 r13 = h3();
        if (r13 == null) goto L36;
        r13.W8(new z8.c(new com.larus.bmhome.chat.component.input.b(this), new com.larus.bmhome.chat.component.input.c(this)));
    L36:
        B3(null);
    }

    public final void z3(g9.c r3) {
        h9 r0 = r3.h();
        r0.e(true);
        r0.b(true);
        r0.a(1.0f);
        r3.e().e(false);
        B3(r3);
    }

    @Override // com.larus.bmhome.chat.component.input.InjectInputComponent
    public final void PP(View r10, MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "event");
        Rect r0 = new Rect();
        r10.getGlobalVisibleRect(r0);
        Pair r2 = new Pair(Float.valueOf(r0.left + r11.getX()), Float.valueOf(r0.top + r11.getY()));
        Object r1 = r10.getTag(2131365544);
        Float r4 = null;
        if ((r1 instanceof Pair) == false) goto L5;
        Pair r3 = (Pair) r1;
    L7:
        if (r3 != null) goto L9;
        Pair r12 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(0.0f));
    L22:
        if (r11.getAction() != 1) goto L24;
    L27:
        int r5 = -1;
    L28:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r6 = p3();
        if (r6 == null) goto L32;
        r6.pv(r5, ((Number) r2.getFirst()).floatValue(), ((Number) r2.getSecond()).floatValue(), ((Number) r12.getFirst()).floatValue(), ((Number) r12.getSecond()).floatValue());
        return;
    L32:
        return;
    L24:
        if (r11.getAction() == 3) goto L27;
        r5 = 0;
        goto L28
    L9:
        r10.setTag(2131365544, null);
        Object r13 = r3.getFirst();
        if ((r13 instanceof Float) == false) goto L12;
        Float r14 = (Float) r13;
    L13:
        if (r14 == null) goto L20;
        float r15 = r14.floatValue();
        Object r7 = r3.getSecond();
        if ((r7 instanceof Float) == false) goto L17;
        r4 = (Float) r7;
    L17:
        if (r4 == null) goto L19;
        r12 = TuplesKt.to(Float.valueOf(r15), Float.valueOf(r4.floatValue()));
        goto L22
    L19:
        r12 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L22
    L20:
        r12 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L22
    L12:
        r14 = null;
        goto L13
    L5:
        r3 = null;
        goto L7
    }
}
