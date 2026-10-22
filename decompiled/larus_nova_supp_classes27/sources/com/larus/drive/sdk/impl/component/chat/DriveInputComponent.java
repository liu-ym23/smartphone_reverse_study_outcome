package com.larus.drive.sdk.impl.component.chat;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\"\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020%H\u0016J\b\u0010*\u001a\u00020%H\u0016J\b\u0010+\u001a\u00020%H\u0016J\u0016\u0010,\u001a\u00020%2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0016J\u0010\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\u0006H\u0016J\f\u00102\u001a\u00020/*\u000203H\u0002J\f\u00104\u001a\u00020/*\u000203H\u0002J\f\u00105\u001a\u00020/*\u000203H\u0002J\f\u00106\u001a\u00020%*\u000203H\u0002J\b\u00107\u001a\u00020%H\u0002J\b\u00108\u001a\u00020%H\u0002J\u0018\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020/H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#¨\u0006>"}, d2 = {"Lcom/larus/drive/sdk/impl/component/chat/DriveInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/drive/sdk/api/ability/IDriveGalleryInputAbility;", "<init>", "()V", "inputCallback", "Lcom/larus/drive/sdk/api/ability/IDriveGalleryInputCallback;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "driveChatReceiveAbility", "Lcom/larus/drive/sdk/api/ability/IDriveChatReceiveAbility;", "getDriveChatReceiveAbility", "()Lcom/larus/drive/sdk/api/ability/IDriveChatReceiveAbility;", "driveChatReceiveAbility$delegate", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "speakerStateListener", "com/larus/drive/sdk/impl/component/chat/DriveInputComponent$speakerStateListener$1", "Lcom/larus/drive/sdk/impl/component/chat/DriveInputComponent$speakerStateListener$1;", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "onResume", "onFragmentViewDestroyed", "hideIme", "setExternalImeShowingFunc", "func", "Lkotlin/Function0;", "", "setInputCallback", "callback", "onReadyToInput", "Lcom/larus/bmhome/chat/component/bottom/core/InputView$Operator;", "onReadyToSend", "onReadyToSpeak", "operateCommonConfig", "configureNavigationEntrances", "renderNavigationEntrances", "sendText", "text", "", "isSpeak", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveInputComponent extends BaseContentWidget implements r79.c {
    public static final /* synthetic */ int t = 0;
    public r79.d m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final c s;

    public static final class a {
    }

    public static final class b implements ICoreInputAbility.e {
        public final /* synthetic */ DriveInputComponent a;

        public b(DriveInputComponent r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }

        public final void i(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
            r79.d r0 = this.a.m;
            if (r0 == null) goto L5;
            r0.a(r2);
        L5:
            DriveInputComponent r3 = this.a;
            ICoreInputAbility r1 = r3.h3();
            if (r1 == null) goto L11;
            g9.c r4 = r1.q20();
            if (r4 == null) goto L12;
            r3.p3(r4);
            return;
        L12:
            return;
        }

        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }
    }

    public static final class c implements com.larus.bmhome.chat.component.bottom.core.speaker.h {
        public final /* synthetic */ DriveInputComponent a;

        public c(DriveInputComponent r1) {
            this.a = r1;
        }

        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            if ((r3 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L8;
            com.larus.bmhome.chat.component.bottom.core.speaker.g.e r4 = (com.larus.bmhome.chat.component.bottom.core.speaker.g.e) r3;
            if (r4.c == true) goto L9;
            DriveInputComponent r0 = this.a;
            String r5 = r4.a;
            int r1 = DriveInputComponent.t;
            r0.z3(r5, true);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final ICoreInputAbility h3() {
        return (ICoreInputAbility) this.n.getValue();
    }

    public final z8 m3() {
        return (z8) this.r.getValue();
    }

    public final void onResume() {
        com.larus.bmhome.chat.component.bottom.core.speaker.l r0 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.p.getValue();
        if (r0 == null) goto L5;
        com.larus.bmhome.chat.component.bottom.core.speaker.l.a.b(r0, new d());
    L5:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.p.getValue();
        if (r1 == null) goto L8;
        r1.e8(this.s);
    L8:
        ICoreInputAbility r2 = h3();
        if (r2 == null) goto L11;
        r2.YT(new b(this));
    L11:
        ICoreInputAbility r3 = h3();
        if (r3 == null) goto L15;
        r3.tr(new i(this));
        return;
    }

    public final void y2() {
        FLogger.a.i("DriveGalleryInputComponent", "[onAttach]");
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, r79.c.class);
    }

    public DriveInputComponent() {
        this.n = LazyKt.lazy(new q(this));
        this.o = LazyKt.lazy(new e(this));
        this.p = LazyKt.lazy(new f(this));
        this.q = LazyKt.lazy(new g(this));
        this.r = LazyKt.lazy(new h(this));
        this.s = new c(this);
    }

    public final void A2() {
        z8 r0 = m3();
        if (r0 == null) goto L5;
        r0.t9(null);
    L5:
        z8 r1 = m3();
        if (r1 == null) goto L8;
        r1.W8(null);
    L8:
        z8 r2 = m3();
        if (r2 == null) goto L11;
        r2.l9(null);
    L11:
        z8 r3 = m3();
        if (r3 == null) goto L15;
        r3.S8(false);
        return;
    }

    public final void Y2() {
        z8 r0 = m3();
        boolean r1 = true;
        if (r0 == null) goto L5;
        r0.S8(true);
    L5:
        z8 r2 = m3();
        if (r2 == null) goto L8;
        r2.W8(new z8.c(new j(this), new k()));
    L8:
        z8 r3 = m3();
        if (r3 == null) goto L18;
        r79.d r4 = this.m;
        if (r4 != null) goto L13;
    L15:
        r1 = false;
    L16:
        r3.l9(new z8.b(r1, new l(this)));
        return;
    L13:
        if (r4.d() != true) goto L15;
    }

    @Override // r79.c
    public final void g() {
        ICoreInputAbility r0 = h3();
        if (r0 == null) goto L6;
        r0.qp(false);
        return;
    }

    @Override // r79.c
    public final void i1(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "func");
        va8.o r0 = (va8.o) this.o.getValue();
        if (r0 == null) goto L6;
        r0.i1(r2);
        return;
    }

    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        FLogger.a.i("DriveGalleryInputComponent", "[onViewCreated]");
        z8 r6 = m3();
        if (r6 == null) goto L5;
        r6.z9(true);
    L5:
        z8 r7 = m3();
        if (r7 == null) goto L8;
        r7.R8();
    L8:
        z8 r8 = m3();
        if (r8 == null) goto L11;
        r8.s9();
    L11:
        z8 r9 = m3();
        if (r9 == null) goto L14;
        r9.w8();
    L14:
        z8 r10 = m3();
        if (r10 == null) goto L17;
        r10.w9(false);
    L17:
        z8 r11 = m3();
        ViewGroup r2 = null;
        if (r11 == null) goto L20;
        r11.r8(false, null);
    L20:
        z8 r12 = m3();
        if (r12 == null) goto L23;
        r12.y9(1, new g9.a(new m(this)));
    L23:
        z8 r13 = m3();
        if (r13 == null) goto L26;
        r13.y9(2, new g9.a(new n(this)));
    L26:
        z8 r14 = m3();
        if (r14 == null) goto L29;
        r14.y9(3, new g9.a(new o(this)));
    L29:
        Y2();
        va8.o r15 = (va8.o) this.o.getValue();
        if (r15 == null) goto L32;
        r15.N4();
    L32:
        Intrinsics.checkNotNullParameter(this, "<this>");
        DialogFragment r16 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragment();
        if ((r16 instanceof DialogFragment) == false) goto L35;
        DialogFragment r17 = r16;
    L36:
        if (r17 == null) goto L38;
        View r18 = r17.getView();
    L40:
        if ((r18 instanceof ViewGroup) == false) goto L42;
        r2 = (ViewGroup) r18;
    L42:
        if (r2 == null) goto L46;
        va8.o r20 = (va8.o) this.o.getValue();
        if (r20 == null) goto L46;
        r20.m1(r2);
    L46:
        z8 r21 = m3();
        if (r21 == null) goto L50;
        r21.t9(new z8.d(new p()));
        return;
    L50:
        return;
    L38:
        r18 = null;
        goto L40
    L35:
        r17 = null;
        goto L36
    }

    public final void p3(g9.c r6) {
        h9 r0 = r6.h();
        boolean r1 = true;
        r0.e(true);
        r0.b(true);
        r0.a(1.0f);
        va8.o r2 = (va8.o) this.o.getValue();
        if (r2 == null) goto L5;
        String r3 = r2.u7();
    L7:
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        h9 r5 = r6.e();
        r79.d r7 = this.m;
        if (r7 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L29;
        if (r4 == true) goto L28;
        ICoreInputAbility r9 = h3();
        if (r9 != null) goto L24;
    L26:
        boolean r10 = false;
    L27:
        if (r10 == false) goto L29;
    L24:
        if (r9.CS() != true) goto L26;
        r10 = true;
    L28:
        boolean r11 = true;
    L30:
        r5.e(r11);
        r6.c().e(false);
        r6.b().c(2131242487);
        h9 r12 = r6.a();
        r79.d r13 = this.m;
        if (r13 != null) goto L33;
    L35:
        boolean r14 = false;
    L36:
        if (r14 == false) goto L46;
        if (r4 == true) goto L47;
        ICoreInputAbility r15 = h3();
        if (r15 != null) goto L41;
    L43:
        boolean r16 = false;
    L44:
        if (r16 == false) goto L46;
    L41:
        if (r15.J8() != true) goto L43;
        r16 = true;
    L47:
        r12.e(r1);
        return;
    L46:
        r1 = false;
        goto L47
    L33:
        if (r13.g() != true) goto L35;
        r14 = true;
    L29:
        r11 = false;
        goto L30
    L16:
        if (r7.d() != true) goto L18;
        r8 = true;
        goto L19
    L9:
        if (r3.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r3 = null;
        goto L7
    }

    @Override // r79.c
    public final void po(r79.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.m = r2;
        Y2();
        ICoreInputAbility r3 = h3();
        if (r3 == null) goto L8;
        g9.c r4 = r3.q20();
        if (r4 == null) goto L9;
        p3(r4);
        return;
    L9:
        return;
    }

    public final void z3(String r4, boolean r5) {
        r79.d r0 = this.m;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        r79.d r2 = this.m;
        if (r2 == null) goto L14;
        z79.c r3 = r2.f();
        if (r3 == null) goto L14;
        DriveFileItem r6 = r3.a;
    L15:
        r79.d r7 = this.m;
        if (r7 == null) goto L18;
        r7.b(r4);
    L18:
        r79.a r8 = (r79.a) this.q.getValue();
        if (r8 == null) goto L22;
        r8.wk(r4, r6, r5);
        return;
    L22:
        return;
    L14:
        r6 = null;
        goto L15
    L5:
        if (r0.h(r4, r5) != true) goto L7;
        r1 = true;
        goto L7
    }
}
