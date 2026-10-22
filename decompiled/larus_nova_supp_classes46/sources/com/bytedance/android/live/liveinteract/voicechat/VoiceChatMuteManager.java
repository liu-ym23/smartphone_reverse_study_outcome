package com.bytedance.android.live.liveinteract.voicechat;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.ac1;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/VoiceChatMuteManager;", "Lcom/bytedance/android/live/liveinteract/voicechat/b;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VoiceChatMuteManager implements com.bytedance.android.live.liveinteract.voicechat.b, LifecycleObserver {
    public boolean a;
    public boolean b;
    public final String c;
    public final CopyOnWriteArrayList<a> d;
    public final CompositeDisposable e;
    public final MutableLiveData<Boolean> f;
    public boolean g;
    public long h;
    public long i;
    public long j;
    public final ac1 k;
    public final boolean l;
    public final boolean m;
    public final VoiceChatMuteManager$listCallback$1 n;
    public int o;
    public final IRoom p;
    public final boolean q;
    public final y r;
    public final DataCenter s;
    public final com.bytedance.android.live.liveinteract.voicechat.a t;
    public final LifecycleOwner u;
    public final j1 v;

    public interface a {
        void C(String r1);

        void Q(String r1, Throwable r2);

        void V(String r1);

        void i0(String r1, Throwable r2);
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
        public final /* synthetic */ VoiceChatMuteManager a;
        public final /* synthetic */ String b;

        public c(VoiceChatMuteManager r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r12) {
            com.bytedance.android.live.network.response.e r13 = (com.bytedance.android.live.network.response.e) r12;
            if (r13 == null) goto L9;
            r1 r0 = (r1) r13.data;
            if (r0 == null) goto L9;
            dn0.c r1 = (dn0.c) this.a.v.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
            if (r1 == null) goto L9;
            r1.Z(this.b, r0.getAckMessage(), AckFromSource.VOICE_CHAT_SILENCE_API);
        L9:
            InteractLinkFullLinkMonitor.X(this.b, System.currentTimeMillis() - this.a.h, r13.logId);
            r1 r2 = (r1) r13.data;
            String r3 = null;
            if (r2 == null) goto L34;
            List r4 = r2.getLinkedUsers();
            if (r4 == null) goto L34;
            Iterator<T> r5 = r4.iterator();
        L15:
            if (r5.hasNext() == false) goto L23;
            T r6 = r5.next();
            IBaseUser r7 = ((com.bytedance.android.livesdk.link.model.bridge.k) r6).getUser();
            if (r7 == null) goto L19;
            String r8 = r7.getIdString();
        L21:
            if (Intrinsics.areEqual(r8, je0.d.b0()) == false) goto L15;
        L24:
            com.bytedance.android.livesdk.link.model.bridge.k r9 = (com.bytedance.android.livesdk.link.model.bridge.k) r6;
            if (r9 == null) goto L34;
            if (r9.getSilenceStatus() != 0) goto L34;
            String r10 = this.b;
            r1 r14 = (r1) r13.data;
            if (r14 == null) goto L33;
            List r15 = r14.getLinkedUsers();
            if (r15 == null) goto L33;
            r3 = je0.d.g0(r15);
        L33:
            x.c0(r10, r3, true);
            ALogger.i("voice_chat", "resetSilenceStatus success but unSilence");
            return;
        L19:
            r8 = null;
            goto L21
        L23:
            r6 = null;
        L34:
            String r11 = this.b;
            r1 r16 = (r1) r13.data;
            if (r16 == null) goto L39;
            List r17 = r16.getLinkedUsers();
            if (r17 == null) goto L39;
            r3 = je0.d.g0(r17);
        L39:
            x.c0(r11, r3, false);
            r1 r18 = (r1) r13.data;
            if (r18 == null) goto L44;
            List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r19 = r18.getLinkedUsers();
            if (r19 == null) goto L44;
            this.a.r.S4(r19, ((r1) r13.data).getClientUiInfo(), ((r1) r13.data).getVersion(), "resetSilence");
        L44:
            this.a.t.G4(true, "reset last silence");
            MutableLiveData<Boolean> r110 = this.a.f;
            Boolean r20 = Boolean.TRUE;
            r110.postValue(r20);
            this.a.s.put("data_self_is_silenced", r20);
            ALogger.i("voice_chat", "resetSilenceStatus success");
            f2.b(2131919327, 0);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ VoiceChatMuteManager a;
        public final /* synthetic */ String b;

        public d(VoiceChatMuteManager r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            je0.d.Q(this.a.c, r7);
            String r0 = this.b;
            long r1 = this.a.h;
            InteractLinkFullLinkMonitor.W(r0, System.currentTimeMillis() - r1, r7);
            ALogger.i("voice_chat", "resetSilenceStatus failed");
            String r2 = this.b;
            int r3 = x.a;
            Intrinsics.checkNotNullParameter(r2, "targetId");
            LinkedHashMap r4 = new LinkedHashMap();
            r4.put("target_user_id", r2);
            x.X(r7, r4);
            x.t0("resume_last_silence_failed", r4);
        }
    }

    public static boolean r(long r3) {
        if (r3 > 12000) goto L5;
    L7:
        return false;
    L5:
        if (r3 >= 86400000) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final boolean i() {
        return this.t.O5();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final boolean isMute() {
        Boolean r0 = (Boolean) this.f.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final void j() {
        this.f.setValue(Boolean.FALSE);
        this.u.getLifecycle().addObserver(this);
        this.r.Q4(this.n);
    }

    public final void n() {
        this.e.clear();
        this.d.clear();
        this.u.getLifecycle().removeObserver(this);
        this.r.T4(this.n);
    }

    public final int o() {
        ILinkPlayerInfoBridge r0 = this.r.p(je0.d.b0(), tc0.c.h().f);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getSilenceStatus();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        ALogger.i("voice_chat", this.c + " onPause");
        this.g = true;
        this.j = System.currentTimeMillis();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        ALogger.i("voice_chat", this.c + " onResume");
        this.g = false;
        this.j = System.currentTimeMillis();
    }

    public final boolean p() {
        if (this.m == true) goto L5;
    L7:
        return false;
    L5:
        if (this.r.t <= 0) goto L7;
        return true;
    }

    public final boolean q() {
        if (this.a == false) goto L5;
    L8:
        return true;
    L5:
        if (this.b == true) goto L8;
        return false;
    }

    public final void v() {
        Intrinsics.checkNotNullParameter("match apply", "reason");
        ALogger.i("voice_chat", "silenceSelfByServer, reason=match apply");
        DataCenter r0 = this.s;
        Boolean r2 = Boolean.TRUE;
        r0.put("data_self_is_silenced", r2);
        this.t.G4(true, "match apply");
        this.f.postValue(r2);
        Iterator<a> r1 = this.d.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().V(je0.d.b0());
        goto L4
    }

    public final void s() {
        String r8 = je0.d.b0();
        this.h = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.V(r8);
        this.e.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silence(this.p.getId(), d5.c(r8), r8, 0, true).subscribeOn(Schedulers.io()).flatMap(b.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r8), new d(this, r8)));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.d.add(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final boolean e(boolean r4) {
        ILinkPlayerInfoBridge r0 = this.r.p(je0.d.b0(), tc0.c.h().f);
        if (this.q == true) goto L11;
        if (r4 == false) goto L11;
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.getSilenceStatus() == 2) goto L10;
    L11:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void g(a r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.d.remove(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void h(String r9) {
        Intrinsics.checkNotNullParameter(r9, "uid");
        u(this, r9, false, false, null, null, 28);
    }

    public final void k(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        this.f.setValue(Boolean.TRUE);
        ALogger.i("voice_chat", "autoMuteSelf ".concat(r10));
        u(this, je0.d.b0(), true, true, r10, null, 16);
    }

    public final void l(String r9) {
        Intrinsics.checkNotNullParameter(r9, "reason");
        this.f.setValue(Boolean.FALSE);
        ALogger.i("voice_chat", "autoUnMuteSelf ".concat(r9));
        w(this, je0.d.b0(), true, r9, null, 20);
    }

    public final void m(Throwable r6) {
        Intrinsics.checkNotNullParameter(r6, "throwable");
        if ((r6 instanceof ApiServerException) == true) goto L5;
        return;
    L5:
        int r7 = ((ApiServerException) r6).getErrorCode();
        if (r7 == 4004031) goto L8;
        if (r7 == 4004054) goto L8;
        return;
    L8:
        int r0 = o();
        Boolean r2 = this.t.t0();
        if (r0 != 0) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L22;
        if (r7 != 4004054) goto L14;
        String r1 = "unsilence failed not allowed";
    L16:
        if (this.k.enableReqFailedCheck == false) goto L18;
        this.t.G4(true, r1);
        DataCenter r3 = this.s;
        Boolean r4 = Boolean.TRUE;
        r3.put("data_self_is_silenced", r4);
        this.f.postValue(r4);
    L18:
        int r5 = x.a;
        Intrinsics.checkNotNullParameter(r1, "errorMsg");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("error_msg", r1);
        r8.put("error_code", Integer.valueOf(r7));
        r8.put("list_status", Integer.valueOf(r0));
        x.t0("check_mute_when_request_failed", r8);
        return;
    L14:
        r1 = "silence failed already mute";
        goto L16
    }

    public final void t(boolean r3) {
        this.h = System.currentTimeMillis();
        this.f.postValue(Boolean.valueOf(r3));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void b(String r9, MediaOperation.a r10) {
        Intrinsics.checkNotNullParameter(r9, "reason");
        if (this.q == false) goto L5;
        u(this, je0.d.b0(), true, false, r9, r10, 4);
        return;
    L5:
        u(this, je0.d.b0(), true, false, r9, r10, 4);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void c(LifecycleOwner r2, Observer<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.f.observe(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void f(String r8, MediaOperation.a r9) {
        Intrinsics.checkNotNullParameter(r8, "uid");
        w(this, r8, false, null, r9, 12);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void d(String r9, boolean r10, MediaOperation.a r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "reason");
        if (r10 == false) goto L8;
        String r13 = je0.d.b0();
        if (this.b == true) goto L11;
        this.b = true;
        this.h = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.n0(r13);
        this.e.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilence(this.p.getId(), d5.c(r13), r13, true).subscribeOn(Schedulers.io()).flatMap(i.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r13, r12), new k(this, r13)));
        return;
    L11:
        return;
    L8:
        w(this, je0.d.b0(), true, r9, r11, 4);
    }

    public static void w(VoiceChatMuteManager r10, String r11, boolean r12, String r13, MediaOperation.a r14, int r15) {
        if ((r15 & 8) == 0) goto L6;
        r13 = "";
    L6:
        if ((r15 & 16) == 0) goto L9;
        r14 = null;
    L9:
        if (r10.b == true) goto L13;
        r10.b = true;
        r10.h = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.n0(r11);
        String r3 = r13;
        r10.e.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilence(r10.p.getId(), r11, r11).subscribeOn(Schedulers.io()).flatMap(o.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(r10, r11, r3, false, r12, r14), new q(r10, r11, r3, false, r14)));
        return;
    }

    public VoiceChatMuteManager(IRoom r2, boolean r3, y r4, DataCenter r5, com.bytedance.android.live.liveinteract.voicechat.a r6, LifecycleOwner r7, j1 r8) {
        Intrinsics.checkNotNullParameter(r2, "mRoom");
        Intrinsics.checkNotNullParameter(r4, "mInfoCenter");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "muteImpl");
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r8, "multiLinkRoomScopeProvider");
        this.p = r2;
        this.q = r3;
        this.r = r4;
        this.s = r5;
        this.t = r6;
        this.u = r7;
        this.v = r8;
        this.c = "VoiceChatMuteManager";
        this.d = new CopyOnWriteArrayList();
        this.e = new CompositeDisposable();
        this.f = new MutableLiveData();
        this.h = System.currentTimeMillis();
        this.i = System.currentTimeMillis();
        this.j = System.currentTimeMillis();
        ReadOnlyProperty r9 = vm2.d.m5;
        KProperty[] r10 = vm2.d.a;
        this.k = (ac1) r9.getValue(null, r10[322(0x142, float:4.51E-43)]);
        this.l = ((Boolean) vm2.d.h5.getValue(null, r10[317(0x13d, float:4.44E-43)])).booleanValue();
        if (vm2.d.m().enable == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        this.m = r11;
        this.n = new VoiceChatMuteManager$listCallback$1(this);
        return;
    L5:
        if (vm2.d.P() == false) goto L7;
        r11 = true;
        goto L8
    }

    public static void u(VoiceChatMuteManager r18, String r19, boolean r20, boolean r21, String r22, MediaOperation.a r23, int r24) {
        if ((r24 & 4) == 0) goto L5;
        boolean r11 = false;
    L7:
        if ((r24 & 8) == 0) goto L9;
        String r12 = "";
    L11:
        if ((r24 & 16) == 0) goto L13;
        MediaOperation.a r13 = null;
    L15:
        if (r18.a == true) goto L19;
        r18.a = true;
        r18.h = System.currentTimeMillis();
        long r14 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.V(r19);
        r18.e.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silence(r18.p.getId(), r19, r19, r11 ? 1 : 0).subscribeOn(Schedulers.io()).flatMap(l.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(r18, r19, r11 ? 1 : 0, r12, r14, r11, r20, r13), new n(r18, r19, r14, r12, r11, r13)));
        return;
    L19:
        return;
    L13:
        r13 = r23;
        goto L15
    L9:
        r12 = r22;
        goto L11
    L5:
        r11 = r21;
        goto L7
    }
}
