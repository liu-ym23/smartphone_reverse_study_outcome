package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.SendReplayTextEvent;
import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.android.livesdk.event.e0;
import com.bytedance.android.livesdk.schema.event.VsAutoNextLiveRoomEvent;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import zg1.e3;
import zg1.h1;
import zg1.i1;
import zg1.r2;
import zg1.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements yr1.g, com.bytedance.android.scope.o {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function3 a;

        public a(Function3 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.event.a r5 = (com.bytedance.android.livesdk.event.a) r4;
            this.a.invoke(Integer.valueOf(r5.a), Integer.valueOf(r5.b), r5.c);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.invoke(((VsAutoNextLiveRoomEvent) r2).getUri());
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function5 a;

        public c(Function5 r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            HorizontalPlayEvent r8 = (HorizontalPlayEvent) r7;
            this.a.invoke(Integer.valueOf(r8.what), Integer.valueOf(r8.screenOrientation), Integer.valueOf(r8.rotationType), r8.source, r8.extra);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function6 a;

        public d(Function6 r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            JumpToOtherRoomEvent r9 = (JumpToOtherRoomEvent) r8;
            this.a.invoke(Long.valueOf(r9.roomId), r9.enterLiveSource, r9.enterExtra, r9.jumpSource, Boolean.valueOf(r9.isBackPreRoom), Boolean.valueOf(r9.sameRoomRefresh));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public e(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((h1) r2).a != 40) goto L6;
            this.a.invoke();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ l a;
        public final /* synthetic */ Function1 b;

        public f(l r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            com.bytedance.android.livesdk.event.j r7 = (com.bytedance.android.livesdk.event.j) r6;
            if ((r7 instanceof e0) == false) goto L19;
            Function1 r0 = this.b;
            e0 r8 = (e0) r7;
            this.a.getClass();
            SendReplayTextEvent r1 = new SendReplayTextEvent();
            String r2 = r8.a;
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r1.a = r2;
            ISendCommentEvent.Sender r3 = r8.b;
            int r4 = k.b[r3.ordinal()];
            if (r4 != 1) goto L7;
            SendReplayTextEvent.Sender r5 = SendReplayTextEvent.Sender.CommentWidget;
        L17:
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r1.b = r5;
            Map<String, ? extends Object> r9 = r8.c;
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r1.c = r9;
            r0.invoke(r1);
            return;
        L7:
            if (r4 != 2) goto L9;
            r5 = SendReplayTextEvent.Sender.Lottery;
            goto L17
        L9:
            if (r4 != 3) goto L11;
            r5 = SendReplayTextEvent.Sender.VsPlusOne;
            goto L17
        L11:
            if (r4 == 4) goto L13;
            r5 = SendReplayTextEvent.Sender.Unknown;
            goto L17
        L13:
            r5 = SendReplayTextEvent.Sender.Unknown;
            goto L17
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ l a;
        public final /* synthetic */ Function1 b;

        public g(l r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            UserProfileEvent r6 = (UserProfileEvent) r5;
            Function1 r0 = this.b;
            this.a.getClass();
            vk1.a r1 = new vk1.a();
            r1.a = r6.user;
            r1.b = r6.getClickUserPosition();
            r1.c = r6.secUserId;
            r1.d = r6.mSource;
            r1.e = r6.mReportSource;
            r1.f = r6.mReportTypeForLog;
            r6.isFallbackFromLynx();
            String r2 = r6.vsFollowPosition;
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r1.g = r2;
            String r3 = r6.toCommentCategory;
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r1.h = r3;
            r1.i = r6.isFromUserNickname;
            String r4 = r6.toDiscussionBoardCommentId;
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r1.j = r4;
            Intrinsics.checkNotNullParameter(r6.requestPage, "<set-?>");
            Intrinsics.checkNotNullParameter(r6.reportType, "<set-?>");
            String r7 = r6.getUserIdStr();
            Intrinsics.checkNotNullParameter(r7, "<set-?>");
            r1.k = r7;
            r1.l = r6.forceNoRotate;
            r0.invoke(r1);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public h(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.invoke(((b30.e0) r2).a);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ Function4 a;

        public i(Function4 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            e3 r6 = (e3) r5;
            this.a.invoke(Boolean.valueOf(r6.b), Integer.valueOf(r6.c), r6.d, Boolean.valueOf(r6.a));
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public j(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Function1 r0 = this.a;
            r0.invoke((u22.m) r2);
        }
    }

    public l() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.g
    public final void I() {
        xs2.b.a().post(new com.bytedance.android.livesdk.castscreen.utils.b(true));
    }

    @Override // yr1.g
    public final void f() {
        xs2.b.a().post(new zg1.w());
    }

    @Override // yr1.g
    public final void o() {
        xs2.b.a().post(40);
    }

    @Override // yr1.g
    public final void w() {
        xs2.b.a().post(new h1(5));
    }

    @Override // yr1.g
    public final Disposable E(Function1<Object, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        return xs2.b.a().b(u22.m.class).subscribe(new j(r3));
    }

    @Override // yr1.g
    public final void F(DataCenter r2) {
        com.bytedance.android.livesdk.provideservices.b.a().bindDataCenter(r2);
    }

    @Override // yr1.g
    public final void J(boolean r4) {
        xs2.b.a().post(new i1(0, r4));
    }

    @Override // yr1.g
    public final Disposable K(Function4<? super Boolean, ? super Integer, ? super String, ? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        return xs2.b.a().b(e3.class).subscribe(new i(r3));
    }

    @Override // yr1.g
    public final Disposable g(Function1<? super vk1.a, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        return xs2.b.a().b(UserProfileEvent.class).subscribe(new g(this, r3));
    }

    @Override // yr1.g
    public final Disposable h(Function5<? super Integer, ? super Integer, ? super Integer, ? super String, Object, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        return xs2.b.a().b(HorizontalPlayEvent.class).subscribe(new c(r3));
    }

    @Override // yr1.g
    public final Disposable k(Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        return xs2.b.a().b(b30.e0.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r3));
    }

    @Override // yr1.g
    public final Disposable n(Function6<? super Long, ? super String, ? super Bundle, ? super String, ? super Boolean, ? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        return xs2.b.a().b(JumpToOtherRoomEvent.class).subscribe(new d(r3));
    }

    @Override // yr1.g
    public final Disposable s(Function1<? super SendReplayTextEvent, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        return xs2.b.a().b(com.bytedance.android.livesdk.event.j.class).subscribe(new f(this, r3));
    }

    @Override // yr1.g
    public final void a(Episode r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "episode");
        Intrinsics.checkNotNullParameter(r5, "map");
        xs2.b.a().post(new t0(new com.bytedance.android.live.base.a(r4), r5));
    }

    @Override // yr1.g
    public final void d(LifecycleOwner r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ((ObservableSubscribeProxy) xs2.b.a().b(h1.class).as(AutoDispose.bind(r3))).subscribe(new e(r4));
    }

    @Override // yr1.g
    public final void i(LifecycleOwner r3, Function1<? super Uri, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ((ObservableSubscribeProxy) xs2.b.a().b(VsAutoNextLiveRoomEvent.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r3))).subscribe(new b(r4));
    }

    @Override // yr1.g
    public final void q(LifecycleOwner r3, Function3<? super Integer, ? super Integer, ? super KeyEvent, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ((ObservableSubscribeProxy) xs2.b.a().b(com.bytedance.android.livesdk.event.a.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r3))).subscribe(new a(r4));
    }

    @Override // yr1.g
    public final void x(int r4, KeyEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        xs2.b.a().post(new com.bytedance.android.livesdk.event.a(0, r4, r5));
    }

    @Override // yr1.g
    public final void y(SendReplayTextEvent r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "sendReplayTextEvent");
        xs2.b r0 = xs2.b.a();
        String r3 = r7.a;
        SendReplayTextEvent.Sender r4 = r7.b;
        int r5 = k.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        ISendCommentEvent.Sender r6 = ISendCommentEvent.Sender.CommentWidget;
    L16:
        r0.post(new com.bytedance.android.livesdk.event.z(new e0(r3, r6, r7.c), r8, null));
        return;
    L5:
        if (r5 != 2) goto L7;
        r6 = ISendCommentEvent.Sender.Lottery;
        goto L16
    L7:
        if (r5 != 3) goto L9;
        r6 = ISendCommentEvent.Sender.VsPlusOne;
        goto L16
    L9:
        if (r5 != 4) goto L12;
        r6 = ISendCommentEvent.Sender.Unknown;
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // yr1.g
    public final void A(String r3, long r4, String r6) {
        xs2.b.a().post(new r2(r3, r4, r6));
    }

    @Override // yr1.g
    public final void c(long r2, String r4, Bundle r5) {
        JumpToOtherRoomEvent r0 = new JumpToOtherRoomEvent(r2);
        r0.enterExtra = r5;
        r0.enterLiveSource = r4;
        xs2.b.a().post(r0);
    }

    @Override // yr1.g
    public final void j(String r3, SendReplayTextEvent.Sender r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "sender");
        Intrinsics.checkNotNullParameter(r5, "args");
        xs2.b.a().post(new e0(r3, ISendCommentEvent.Sender.VsPlusOne, r5));
    }
}
