package yj0;

import com.bytedance.android.live.base.model.message.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContentKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends q46.b<InterfaceC0294a> implements l {
    public vlc.d b;
    public final CompositeDisposable c;
    public boolean d;
    public boolean e;
    public final y f;
    public boolean g;
    public final String h;
    public final IRoom i;
    public final boolean j;
    public final DataCenter k;

    /* JADX INFO: renamed from: yj0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0294a extends q46.a {
        void A50();

        void D(String r1);

        void F(String r1, Throwable r2);

        void G(String r1);

        void Y2();

        void Z(String r1, String r2, AckFromSource r3);

        void q(int r1);

        void r(String r1, Throwable r2);
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return LinkWRDSHelper.d(r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ MediaOperation.a e;

        public c(a r1, String r2, int r3, long r4, MediaOperation.a r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            if (Intrinsics.areEqual(k.n(IMiddlewareUserService.class).user().n(), this.b) == true) goto L5;
        L7:
            a r0 = this.a;
            r0.d = false;
            InterfaceC0294a r1 = (InterfaceC0294a) ((q46.b) r0).a;
            if (r1 == null) goto L10;
            r1.Z(this.b, ((r1) r9.data).getAckMessage(), AckFromSource.TALK_ROOM_SILENCE_API);
        L10:
            q46.a r2 = ((q46.b) this.a).a;
            if (r2 == null) goto L13;
            ((InterfaceC0294a) r2).D(this.b);
        L13:
            InteractLinkFullLinkMonitor.X(this.b, System.currentTimeMillis() - this.d, r9.logId);
            String r3 = this.b;
            r1 r4 = (r1) r9.data;
            String r5 = null;
            if (r4 == null) goto L18;
            List r6 = r4.getLinkedUsers();
            if (r6 == null) goto L18;
            String r7 = je0.d.g0(r6);
        L19:
            r1 r10 = (r1) r9.data;
            if (r10 == null) goto L24;
            Map r11 = r10.getLinkerContentMap();
            if (r11 == null) goto L24;
            r5 = r11.toString();
        L24:
            x.w0(r3, "", r7, r5);
            r1 r12 = (r1) r9.data;
            if (r12 == null) goto L31;
            List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r13 = r12.getLinkedUsers();
            if (r13 == null) goto L31;
            y r14 = this.a.f;
            if (r14 == null) goto L31;
            r14.S4(r13, ((r1) r9.data).getClientUiInfo(), ((r1) r9.data).getVersion(), "silence");
        L31:
            MediaOperation.a r15 = this.e;
            if (r15 == null) goto L35;
            r15.onSuccess();
            return;
        L35:
            return;
        L18:
            r7 = null;
            goto L19
        L5:
            if (this.c != 0) goto L7;
            com.bytedance.android.live.liveinteract.linksecurity.b.o(com.bytedance.android.live.liveinteract.linksecurity.b.g);
            goto L7
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ MediaOperation.a d;

        public d(a r1, String r2, long r3, MediaOperation.a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            Intrinsics.checkNotNullParameter(r7, "throwable");
            ALogger.stacktrace(6, this.a.h, r7.getStackTrace());
            this.a.d = false;
            String r0 = this.b;
            long r1 = this.c;
            InteractLinkFullLinkMonitor.W(r0, System.currentTimeMillis() - r1, r7);
            x.x0(this.b, r7, "");
            q46.a r2 = ((q46.b) this.a).a;
            if (r2 == null) goto L5;
            ((InterfaceC0294a) r2).F(this.b, r7);
        L5:
            MediaOperation.a r3 = this.d;
            if (r3 == null) goto L9;
            r3.onError(r7);
            return;
        }
    }

    public static final class e<T, R> implements Function {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return LinkWRDSHelper.e(r3);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ MediaOperation.a d;

        public f(a r1, String r2, long r3, MediaOperation.a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            this.a.e = false;
            InteractLinkFullLinkMonitor.p0(this.b, System.currentTimeMillis() - this.c, r9.logId);
            String r0 = this.b;
            c2 r1 = (c2) r9.data;
            String r2 = null;
            if (r1 == null) goto L7;
            List r3 = r1.getLinkedUsers();
            if (r3 == null) goto L7;
            String r4 = je0.d.g0(r3);
        L8:
            c2 r5 = (c2) r9.data;
            if (r5 == null) goto L13;
            Map r6 = r5.getLinkerContentMap();
            if (r6 == null) goto L13;
            r2 = r6.toString();
        L13:
            x.D0(r0, "", r4, r2);
            q46.a r7 = ((q46.b) this.a).a;
            if (r7 == null) goto L16;
            ((InterfaceC0294a) r7).G(this.b);
        L16:
            c2 r10 = (c2) r9.data;
            if (r10 == null) goto L23;
            List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r11 = r10.getLinkedUsers();
            if (r11 == null) goto L23;
            y r12 = this.a.f;
            if (r12 == null) goto L23;
            r12.S4(r11, ((c2) r9.data).getClientUiInfo(), ((c2) r9.data).getVersion(), "unSilence");
        L23:
            MediaOperation.a r13 = this.d;
            if (r13 == null) goto L27;
            r13.onSuccess();
            return;
        L27:
            return;
        L7:
            r4 = null;
            goto L8
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ MediaOperation.a d;

        public g(a r1, String r2, long r3, MediaOperation.a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            Intrinsics.checkNotNullParameter(r7, "throwable");
            ALogger.stacktrace(6, this.a.h, r7.getStackTrace());
            this.a.e = false;
            String r0 = this.b;
            long r1 = this.c;
            InteractLinkFullLinkMonitor.o0(r0, System.currentTimeMillis() - r1, r7);
            x.E0(this.b, r7, "");
            q46.a r2 = ((q46.b) this.a).a;
            if (r2 == null) goto L5;
            ((InterfaceC0294a) r2).r(this.b, r7);
        L5:
            MediaOperation.a r3 = this.d;
            if (r3 == null) goto L9;
            r3.onError(r7);
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

    public final int e0() {
        y r0 = this.f;
        if (r0 == null) goto L5;
        ILinkPlayerInfoBridge r1 = r0.p(k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f);
    L6:
        if (r1 != null) goto L10;
        return -1;
    L10:
        return r1.getSilenceStatus();
    L5:
        r1 = null;
        goto L6
    }

    public final void c0(InterfaceC0294a r2) {
        ((q46.b) this).a = r2;
        DataCenter r3 = this.k;
        if (r3 == null) goto L5;
        this.b = (vlc.d) r3.get("data_message_manager");
    L5:
        vlc.d r4 = this.b;
        if (r4 == null) goto L8;
        r4.addMessageListener(MessageType.LINK_MIC.getKey(), this);
    L8:
        vlc.d r5 = this.b;
        if (r5 == null) goto L11;
        r5.addMessageListener(MessageType.CONTROL.getKey(), this);
    L11:
        vlc.d r6 = this.b;
        if (r6 == null) goto L15;
        r6.addMessageListener(MessageType.LINKER.getKey(), this);
        return;
    }

    public final boolean d0(boolean r4) {
        y r0 = this.f;
        if (r0 == null) goto L5;
        ILinkPlayerInfoBridge r1 = r0.p(k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f);
    L7:
        if (this.j == true) goto L17;
        if (r4 == false) goto L16;
        if (r1 != null) goto L12;
    L14:
        return false;
    L12:
        if (r1.getSilenceStatus() == 2) goto L14;
        return true;
    L16:
        return true;
    L17:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public final void onMessage(tlc.d r5) {
        Intrinsics.checkNotNullParameter(r5, MultiLinkOpenSource.MESSAGE);
        if (((q46.b) this).a != null) goto L6;
        return;
    L6:
        if ((r5 instanceof z0) == false) goto L42;
        z0 r6 = (z0) r5;
        int r0 = (int) r6.getType2();
        if (r0 != 1) goto L10;
        InterfaceC0294a r7 = (InterfaceC0294a) ((q46.b) this).a;
        if (r7 == null) goto L85;
        r7.A50();
        return;
    L85:
        return;
    L10:
        if (r0 == 16) goto L34;
        if (r0 == 10) goto L24;
        if (r0 == 11) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(r6.getToUserId().toString(), k.n(IMiddlewareUserService.class).user().n()) == true) goto L19;
        return;
    L19:
        if ((!Intrinsics.areEqual(r6.getFromUserIdStr(), k.n(IMiddlewareUserService.class).user().n())) == false) goto L75;
        InterfaceC0294a r8 = (InterfaceC0294a) ((q46.b) this).a;
        if (r8 == null) goto L76;
        r8.q(0);
        return;
    L76:
        return;
    L75:
        return;
    L24:
        if (Intrinsics.areEqual(r6.getToUserId().toString(), k.n(IMiddlewareUserService.class).user().n()) == true) goto L26;
        return;
    L26:
        if ((!Intrinsics.areEqual(r6.getFromUserIdStr(), k.n(IMiddlewareUserService.class).user().n())) == false) goto L79;
        InterfaceC0294a r1 = (InterfaceC0294a) ((q46.b) this).a;
        if (r1 == null) goto L30;
        r1.Z(r6.getToUserId(), r6.getAckMessage(), AckFromSource.TALK_ROOM_SILENCE_MESSAGE);
    L30:
        com.bytedance.android.live.liveinteract.linksecurity.b.n(com.bytedance.android.live.liveinteract.linksecurity.b.g);
        InterfaceC0294a r9 = (InterfaceC0294a) ((q46.b) this).a;
        if (r9 == null) goto L80;
        r9.q(2);
        return;
    L80:
        return;
    L79:
        return;
    L34:
        if (Intrinsics.areEqual(r6.getToUserId().toString(), k.n(IMiddlewareUserService.class).user().n()) == false) goto L82;
        InterfaceC0294a r10 = (InterfaceC0294a) ((q46.b) this).a;
        if (r10 == null) goto L83;
        r10.q(3);
        return;
    L83:
        return;
    L82:
        return;
    L42:
        if ((r5 instanceof o0) == false) goto L49;
        if (((o0) r5).getAction() != 3) goto L87;
        InterfaceC0294a r11 = (InterfaceC0294a) ((q46.b) this).a;
        if (r11 == null) goto L88;
        r11.Y2();
        return;
    L88:
        return;
    L87:
        return;
    L49:
        if ((r5 instanceof h1) == false) goto L90;
        h1 r12 = (h1) r5;
        if (r12.getMUpdateUser() != null) goto L53;
        return;
    L53:
        ILinkerUpdateUserContent r2 = r12.getMUpdateUser();
        if (r2 != null) goto L56;
        return;
    L56:
        if (ILinkerUpdateUserContentKt.isSilenceStatusUpdate(r2) == true) goto L59;
        return;
    L59:
        if (12 != r12.getMType()) goto L92;
        ILinkerUpdateUserContent r3 = r12.getMUpdateUser();
        if (r3 != null) goto L63;
        return;
    L63:
        if (4 != ILinkerUpdateUserContentKt.getSilenceStatus(r3)) goto L94;
        ILinkerUpdateUserContent r13 = r12.getMUpdateUser();
        if (r13 == null) goto L67;
        String r14 = ILinkerUpdateUserContentKt.getToUserIdString(r13);
    L69:
        if (Intrinsics.areEqual(r14, je0.d.b0()) == false) goto L95;
        InterfaceC0294a r15 = (InterfaceC0294a) ((q46.b) this).a;
        if (r15 == null) goto L96;
        r15.q(4);
        return;
    L96:
        return;
    L95:
        return;
    L67:
        r14 = null;
        goto L69
    L94:
        return;
    L92:
        return;
    }

    public a(IRoom r2, boolean r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "mRoom");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.c = new CompositeDisposable();
        i<ILinkPlayerInfoBridge> r5 = null;
        if (r3 == false) goto L8;
        rj0.k.m2.getClass();
        rj0.k r6 = rj0.k.a.a();
        if (r6 == null) goto L7;
        r5 = r6.getLinkUserInfoCenter();
    L7:
        y r7 = (y) r5;
    L12:
        this.f = r7;
        this.h = "AudioManagerPresenter";
        return;
    L8:
        rj0.l.n2.getClass();
        rj0.l r8 = rj0.l.a.a();
        if (r8 == null) goto L11;
        r5 = r8.getLinkUserInfoCenter();
    L11:
        r7 = (y) r5;
        goto L12
    }

    public final void f0(String r13, int r14, MediaOperation.a r15) {
        Intrinsics.checkNotNullParameter(r13, "toUserId");
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        long r8 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.V(r13);
        this.c.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silence(this.i.getId(), r13, r13, r14).subscribeOn(Schedulers.io()).flatMap(b.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r13, r14, r8, r15), new d(this, r13, r8, r15)));
    }

    public final void g0(String r18, MediaOperation.a r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r18, "toUserId");
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        long r15 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.n0(r18);
        this.c.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilence(this.i.getId(), d5.c(r18), r18, r20).subscribeOn(Schedulers.io()).flatMap(e.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r18, r15, r19), new g(this, r18, r15, r19)));
    }

    public static /* synthetic */ void h0(a r0, String r1, MediaOperation.a r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.g0(r1, r2, false);
    }
}
