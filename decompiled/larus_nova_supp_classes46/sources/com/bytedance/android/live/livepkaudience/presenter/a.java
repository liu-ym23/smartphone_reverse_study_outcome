package com.bytedance.android.live.livepkaudience.presenter;

import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import dl0.q;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends q46.b<InterfaceC0115a> implements l {
    public vlc.d b;
    public final CompositeDisposable c;
    public boolean d;
    public boolean e;
    public final String f;
    public final DataCenter g;

    /* JADX INFO: renamed from: com.bytedance.android.live.livepkaudience.presenter.a$a, reason: collision with other inner class name */
    public interface InterfaceC0115a extends q46.a {
        void D(String r1);

        void F(String r1, Throwable r2);

        void G(String r1);

        void q(int r1);

        void r(String r1, Throwable r2);
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public b(a r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
            o0.a r0 = o0.a;
            String r1 = jc1.k.n(IUserService.class).user().b().getIdString();
            String r2 = this.c;
            r0.getClass();
            if (o0.a.a(r1, r2) == true) goto L5;
        L7:
            CompositeDisposable r3 = LinkSecurityManager.b;
            LinkSecurityManager.b(this.c, ((r1) r5.data).getAckMessage(), LinkSecurityManager.AckFromSource.PK_WITH_AUDIENCE_SILENCE_API);
            a r6 = this.a;
            r6.d = false;
            q46.a r7 = ((q46.b) r6).a;
            if (r7 == null) goto L10;
            ((InterfaceC0115a) r7).D(this.c);
        L10:
            String r8 = this.c.toString();
            List r9 = ((r1) r5.data).getLinkedUsers();
            if (r9 == null) goto L13;
            String r10 = q.a(r9);
        L14:
            x.w0(r8, "", r10, null);
            return;
        L13:
            r10 = null;
            goto L14
        L5:
            if (this.b != 0) goto L7;
            cl0.a.g(cl0.a.d);
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public c(a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            ALogger.stacktrace(6, this.a.f, r5.getStackTrace());
            this.a.d = false;
            x.x0(this.b.toString(), r5, "");
            q46.a r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            ((InterfaceC0115a) r0).F(this.b, r5);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public d(a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            this.a.e = false;
            String r0 = this.b.toString();
            List r5 = ((c2) ((com.bytedance.android.live.network.response.e) r4).data).getLinkedUsers();
            if (r5 == null) goto L5;
            String r6 = q.a(r5);
        L6:
            x.D0(r0, "", r6, null);
            q46.a r7 = ((q46.b) this.a).a;
            if (r7 == null) goto L10;
            ((InterfaceC0115a) r7).G(this.b);
            return;
        L10:
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public e(a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            ALogger.stacktrace(6, this.a.f, r5.getStackTrace());
            this.a.e = false;
            x.E0(this.b.toString(), r5, "");
            q46.a r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            ((InterfaceC0115a) r0).r(this.b, r5);
            return;
        }
    }

    public final void detachView() {
        this.c.clear();
        vlc.d r0 = this.b;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
    L6:
        ((q46.b) this).a = null;
    }

    public final void c0(InterfaceC0115a r2) {
        ((q46.b) this).a = r2;
        DataCenter r3 = this.g;
        if (r3 == null) goto L5;
        this.b = (vlc.d) r3.get("data_message_manager");
    L5:
        vlc.d r4 = this.b;
        if (r4 == null) goto L9;
        r4.addMessageListener(MessageType.LINK_MIC.getIntType(), this);
        return;
    }

    public final void e0(String r6) {
        Intrinsics.checkNotNullParameter(r6, "toUserId");
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        CompositeDisposable r0 = this.c;
        LinkApi r1 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        DataCenter r2 = this.g;
        if (r2 == null) goto L8;
        Room r3 = (Room) r2.get("data_room", new Room());
    L9:
        if (r3 == null) goto L11;
        long r4 = r3.id;
    L12:
        r0.add(r1.unSilence(r4, r6, r6.toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r6), new e(this, r6)));
        return;
    L11:
        r4 = 0;
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    public final void onMessage(tlc.d r6) {
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        if (((q46.b) this).a != null) goto L6;
        return;
    L6:
        if ((r6 instanceof xe) == false) goto L35;
        xe r7 = (xe) r6;
        int r1 = (int) r7.getType2();
        if (r1 == 10) goto L27;
        if (r1 == 11) goto L20;
        if (r1 == 16) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r7.getToUserIdStr(), jc1.k.n(IUserService.class).user().n()) == false) goto L36;
        InterfaceC0115a r8 = (InterfaceC0115a) ((q46.b) this).a;
        if (r8 == null) goto L37;
        r8.q(3);
        return;
    L37:
        return;
    L36:
        return;
    L20:
        if (Intrinsics.areEqual(r7.getToUserIdStr(), jc1.k.n(IUserService.class).user().n()) == true) goto L22;
        return;
    L22:
        if ((!Intrinsics.areEqual(r7.getFromUserIdStr(), jc1.k.n(IUserService.class).user().n())) == false) goto L40;
        InterfaceC0115a r9 = (InterfaceC0115a) ((q46.b) this).a;
        if (r9 == null) goto L41;
        r9.q(0);
        return;
    L41:
        return;
    L40:
        return;
    L27:
        if (Intrinsics.areEqual(r7.getToUserIdStr(), jc1.k.n(IUserService.class).user().n()) == true) goto L29;
        return;
    L29:
        if ((!Intrinsics.areEqual(r7.getFromUserIdStr(), jc1.k.n(IUserService.class).user().n())) == false) goto L44;
        cl0.a r0 = cl0.a.d;
        LinkedHashMap r2 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r3 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r4 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "config");
        r0.d("mute_by_other", r2, r3, r4);
        InterfaceC0115a r5 = (InterfaceC0115a) ((q46.b) this).a;
        if (r5 == null) goto L33;
        r5.q(2);
    L33:
        CompositeDisposable r10 = LinkSecurityManager.b;
        LinkSecurityManager.b(r7.getToUserIdStr(), r7.getAckMessage(), LinkSecurityManager.AckFromSource.PK_WITH_AUDIENCE_SILENCE_MESSAGE);
        return;
    L44:
        return;
    }

    public a(boolean r1, DataCenter r2) {
        this.g = r2;
        this.c = new CompositeDisposable();
        if (r1 == false) goto L7;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r3 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r3 == null) goto L10;
        r3.getLinkUserCenter();
    L10:
        this.f = "LinkPkAudioManagerPresenter";
        return;
    L7:
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r4 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r4 == null) goto L10;
        r4.getLinkUserCenter();
        goto L10
    }

    public final void d0(String r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        CompositeDisposable r0 = this.c;
        LinkApi r2 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        DataCenter r1 = this.g;
        if (r1 == null) goto L8;
        Room r3 = (Room) r1.get("data_room", new Room());
    L9:
        if (r3 == null) goto L11;
        long r4 = r3.id;
    L12:
        r0.add(r2.silence(r4, r9, r9, r10).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r10, r9), new c(this, r9)));
        return;
    L11:
        r4 = 0;
        goto L12
    L8:
        r3 = null;
        goto L9
    }
}
