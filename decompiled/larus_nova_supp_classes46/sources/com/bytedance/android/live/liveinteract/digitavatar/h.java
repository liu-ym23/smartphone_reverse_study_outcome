package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public final CompositeDisposable a;
    public int b;
    public List<Integer> c;
    public Integer d;
    public final DigitAvatarMsgController e;
    public final boolean f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            com.bytedance.android.livesdk.chatroom.viewmodel.j r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.j) r6;
            h r0 = this.a;
            r0.getClass();
            int r1 = je0.d.f();
            List<Integer> r2 = r7.b;
            int r8 = r7.c;
            if (r0.b == r1) goto L5;
        L11:
            ALogger.i("KtvDigitAvatar", "video talk scene change: " + r0.b + " -> " + r1);
            r0.b = r1;
            r0.c = r2;
            r0.d = Integer.valueOf(r8);
            VideoShowMode r3 = null;
            if (r0.f == false) goto L19;
            DigitAvatarContext r9 = DigitAvatarContext.Companion.getContext();
            if (r9 == null) goto L17;
            r3 = r9.getCurrentVideoShowMode();
        L17:
            if (r3 != VideoShowMode.DIGIT_AVATAR) goto L27;
            r0.b();
            return;
        L27:
            return;
        L19:
            DigitAvatarContext r10 = DigitAvatarContext.Companion.getContext();
            if (r10 == null) goto L23;
            r3 = r10.getCurrentVideoShowMode();
        L23:
            if (r3 != VideoShowMode.DIGIT_AVATAR) goto L29;
            r0.c();
            return;
        L29:
            return;
        L5:
            if ((!Intrinsics.areEqual(r0.c, r2)) == true) goto L11;
            Integer r4 = r0.d;
            if (r4 == null) goto L11;
            if (r4.intValue() != r8) goto L11;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ h a;

        public c(h r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            h r5 = this.a;
            VideoShowMode r1 = null;
            if (r5.f == false) goto L10;
            DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
            if (r0 == null) goto L8;
            r1 = r0.getCurrentVideoShowMode();
        L8:
            if (r1 != VideoShowMode.DIGIT_AVATAR) goto L17;
            r5.b();
            return;
        L17:
            return;
        L10:
            DigitAvatarContext r2 = DigitAvatarContext.Companion.getContext();
            if (r2 == null) goto L14;
            r1 = r2.getCurrentVideoShowMode();
        L14:
            if (r1 != VideoShowMode.DIGIT_AVATAR) goto L19;
            r5.c();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ h a;

        public d(h r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Integer r2 = (Integer) r1;
            this.a.a();
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ h a;

        public f(h r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            Integer r0 = je0.d.h();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.intValue() != 7) goto L10;
            if (r4 == null) goto L11;
            this.a.b();
            return;
        L11:
            return;
        }
    }

    public final void a() {
        if (this.f == false) goto L5;
        return;
    L5:
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = r1.t();
        if (r2 == null) goto L22;
        List r3 = r2.b;
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.contains(4) == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L24;
        this.e.b(90, 2.0f);
        return;
    L24:
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void b() {
        int r0 = this.b;
        if (r0 != 8) goto L5;
        Integer r1 = je0.d.h();
        if (r1 != null) goto L12;
    L13:
        Integer r2 = je0.d.h();
        if (r2 == null) goto L20;
        if (r2.intValue() != 103) goto L20;
    L35:
        this.e.b(90, 2.1f);
        return;
    L20:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.d() == false) goto L22;
    L34:
        this.e.b(92, 2.0f);
        return;
    L22:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.g(this.c) == true) goto L34;
        rj0.k.m2.getClass();
        rj0.k r3 = rj0.k.a.a();
        if (r3 == null) goto L30;
        boolean r4 = true;
        if (r3.isLinkCasting() != true) goto L30;
        if (wf0.b.e() == false) goto L30;
    L31:
        if (r4 == true) goto L34;
        this.e.b(0, 1.0f);
        return;
    L30:
        r4 = false;
        goto L31
    L12:
        if (r1.intValue() == 102) goto L35;
    L5:
        if (r0 == 16) goto L7;
        this.e.b(90, 2.1f);
        return;
    L7:
        this.e.b(92, 2.1f);
    }

    public final void c() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L7;
        boolean r2 = r1.k();
    L8:
        int r3 = this.b;
        if (r3 != 8) goto L31;
        Integer r4 = je0.d.h();
        if (r4 != null) goto L14;
    L15:
        Integer r5 = je0.d.h();
        if (r5 != null) goto L19;
    L21:
        String r6 = je0.d.b0();
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r7 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r7 == null) goto L26;
        ILinkPlayerInfoBridge r8 = (ILinkPlayerInfoBridge) r7.a5(r6, "");
        if (r8 == null) goto L26;
        boolean r9 = r8.isEnlarged();
    L27:
        if (r9 == false) goto L29;
        this.e.b(0, 1.0f);
        return;
    L29:
        this.e.b(92, 2.0f);
        return;
    L26:
        r9 = false;
        goto L27
    L19:
        if (r5.intValue() != 103) goto L21;
    L30:
        this.e.b(90, 2.0f);
        return;
    L14:
        if (r4.intValue() == 102) goto L30;
    L31:
        if (r2 == false) goto L39;
        com.bytedance.live.datacontext.j r10 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r10 == null) goto L37;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r11 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r10.getValue();
        if (r11 == null) goto L37;
        r11.getWindowCount();
    L37:
        a();
        return;
    L39:
        if (r3 != 16) goto L41;
        this.e.b(92, 2.1f);
        return;
    L41:
        this.e.b(92, 3.0f);
        return;
    L7:
        r2 = false;
        goto L8
    }

    public h(DigitAvatarMsgController r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "effectMsgController");
        this.e = r3;
        this.f = r4;
        CompositeDisposable r5 = new CompositeDisposable();
        this.a = r5;
        this.b = je0.d.f();
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r6 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r7 == null) goto L11;
        BehaviorSubject r8 = r7.a();
        if (r8 == null) goto L11;
        Disposable r9 = r8.subscribe(new a(this), b.a);
        if (r9 == null) goto L11;
        r5.add(r9);
    L11:
        CPositionContext r10 = CPositionContext.Companion.getContext();
        if (r10 == null) goto L20;
        com.bytedance.live.datacontext.m<Boolean> r11 = r10.isCPositionOpen();
        if (r11 == null) goto L20;
        Observable r12 = r11.a();
        if (r12 == null) goto L20;
        Disposable r13 = r12.subscribe(new c(this));
        if (r13 == null) goto L20;
        r5.add(r13);
    L20:
        com.bytedance.live.datacontext.j r14 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r14 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r15 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r14.getValue();
        if (r15 == null) goto L29;
        BehaviorSubject r16 = r15.j();
        if (r16 == null) goto L29;
        Disposable r17 = r16.subscribe(new d(this), e.a);
        if (r17 == null) goto L29;
        r5.add(r17);
    L29:
        f r18 = new f(this);
        Intrinsics.checkNotNullParameter(r18, "observer");
        com.bytedance.android.livesdk.chatroom.t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L36;
        com.bytedance.live.datacontext.m r1 = r0.isCasting();
        if (r1 == null) goto L36;
        Observable r2 = r1.a();
        if (r2 == null) goto L36;
        Disposable r19 = r2.subscribe(r18);
    L37:
        if (r19 == null) goto L40;
        r5.add(r19);
        return;
    L40:
        return;
    L36:
        r19 = null;
        goto L37
    }
}
