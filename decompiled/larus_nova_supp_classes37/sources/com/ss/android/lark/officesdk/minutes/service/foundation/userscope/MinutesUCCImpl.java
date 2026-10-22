package com.ss.android.lark.officesdk.minutes.service.foundation.userscope;

import bvb.b;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.d;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.f;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.MmD1204RecordingEventTracker;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.i;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.o;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.ApiUtils;
import f0c.h;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import mcb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesUCCImpl implements a, o {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final CoroutineScope E;
    public final String a;
    public final c b;
    public final g c;
    public final l d;
    public final m e;
    public final Function1<a, bvb.a> f;
    public final String g;
    public final CoroutineScope h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy<bvb.a> k;
    public final Lazy l;
    public final Lazy<com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a> m;
    public final Lazy<dvb.a> n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy<com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.a> t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<a, bvb.a> {
        public AnonymousClass1(Object r8) {
            super(1, r8, evb.c.class, "create", "create(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/hardware/IMmHardwareManager;", 0);
        }

        public final bvb.a invoke(a r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            ((evb.c) ((CallableReference) this).receiver).getClass();
            Intrinsics.checkNotNullParameter(r2, "userContext");
            return b.a;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((a) r1);
        }
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final MmRecordingSessionManager A() {
        return (MmRecordingSessionManager) this.i.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final fub.a C() {
        return (fub.a) OfficeSDKManager.getHostUserService(this.a, fub.a.class);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final UserSession D() {
        return this.e.getSession();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.a E() {
        return (com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.a) this.A.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final MmMinutesFileUploadSessionManager F() {
        return (MmMinutesFileUploadSessionManager) this.o.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final MmRecordingNetHelper G() {
        return (MmRecordingNetHelper) this.y.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final KVRepo H() {
        return (KVRepo) this.x.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final bvb.a I() {
        return (bvb.a) this.k.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final zub.a J() {
        return (zub.a) this.p.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final f K() {
        return (f) this.B.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final i L() {
        return (i) this.l.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final MmMockAwareRequestService M() {
        return (MmMockAwareRequestService) this.s.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c N() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c) this.C.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final MmUserInfoHelper O() {
        return (MmUserInfoHelper) this.z.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final nub.b P() {
        return (nub.b) OfficeSDKManager.getHostUserService(this.a, nub.b.class);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.a Q() {
        return (com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.a) this.u.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final com.ss.android.lark.officesdk.minutes.service.foundation.feature.a getFeatureService() {
        return (com.ss.android.lark.officesdk.minutes.service.foundation.feature.a) this.v.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b getSettingsService() {
        return (com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b) this.w.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final String getTenantId() {
        return this.e.getUser().getTenantId();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator.b v() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator.b) this.j.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a w() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a) this.m.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final MmD1204RecordingEventTracker x() {
        return (MmD1204RecordingEventTracker) this.D.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final gpb.a y() {
        return (gpb.a) ApiUtils.getApi(gpb.a.class);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final dvb.a z() {
        return (dvb.a) this.n.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final CoroutineScope B() {
        return this.E;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final String getCurrentUserId() {
        return this.a;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        Scene r0 = r4.b;
        if (r0 != Scene.SWITCH_ONLINE) goto L5;
    L7:
        lvb.a.e(this.g, "afterUserOnline: resume pending uploads, userId=" + this.a + ", scene=" + r4.b);
        ((MmMinutesFileUploadSessionManager) this.o.getValue()).C();
        return;
    L5:
        if (r0 == Scene.SWITCH_FOREGROUND) goto L7;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r7) {
        Intrinsics.checkNotNullParameter(r7, "state");
        lvb.a.e(this.g, "onUserOffline");
        if (this.t.isInitialized() == false) goto L9;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.g r8 = ((com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.a) this.t.getValue()).b;
        Iterator r2 = CollectionsKt.flatten(r8.g.values()).iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        Job.DefaultImpls.cancel$default((Job) r2.next(), null, 1, null);
        goto L6
    L8:
        r8.g.clear();
        r8.f.clear();
        r8.e.clear();
        CoroutineScopeKt.cancel$default(r8.d, null, 1, null);
    L9:
        com.ss.android.lark.officesdk.minutes.service.foundation.network.core.c r9 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.core.c) this.q.getValue();
        r9.getClass();
        lvb.a.e("MmNetHandler", "onDestroy");
        d r3 = r9.f;
        r3.getClass();
        lvb.a.e("MmNetPushHandler", "onDestroy");
        Iterator<Map.Entry<Command, Disposable>> r4 = r3.d.entrySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r4.next().getValue().dispose();
        goto L11
    L13:
        Iterator<Map.Entry<com.ss.android.lark.pb.improto.Command, Disposable>> r5 = r3.e.entrySet().iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r5.next().getValue().dispose();
        goto L15
    L17:
        r3.d.clear();
        r3.e.clear();
        r3.g.clear();
        r3.f.clear();
        CoroutineScopeKt.cancel$default(r3.c, null, 1, null);
        r9.c.clear();
        CoroutineScopeKt.cancel$default((CoroutineScope) r9.d.getValue(), null, 1, null);
        CoroutineScopeKt.cancel$default(((com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b) this.w.getValue()).a, null, 1, null);
        lvb.a.e("MmRecordAppSettingsService", "onDestroy");
        MmRecordingSessionManager r10 = (MmRecordingSessionManager) this.i.getValue();
        lvb.a.e(r10.b, "[releaseSessionManager]");
        r10.w(MinutesForegroundService.ForegroundServiceOwner.RECORDING);
        r10.w(MinutesForegroundService.ForegroundServiceOwner.HARDWARE_LIVE_RECORDING);
        r10.a.N().b.a.clear();
        r10.m.clear();
        CoroutineScope r6 = r10.d;
        if (r6 == null) goto L20;
        CoroutineScopeKt.cancel$default(r6, null, 1, null);
    L20:
        CoroutineScopeKt.cancel$default(r10.c, null, 1, null);
        if (this.m.isInitialized() == false) goto L24;
        ((com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a) this.m.getValue()).b();
    L24:
        if (this.n.isInitialized() == false) goto L27;
        ((dvb.a) this.n.getValue()).b();
    L27:
        if (this.k.isInitialized() == false) goto L29;
        ((bvb.a) this.k.getValue()).release();
    L29:
        CoroutineScopeKt.cancel$default(((com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.a) this.A.getValue()).d, null, 1, null);
        ((MmMinutesFileUploadSessionManager) this.o.getValue()).x();
        CoroutineScopeKt.cancel$default(this.h, null, 1, null);
        this.e.c(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        lvb.a.e(this.g, "onUserOnline, userId=" + this.a + ", rustClientHash=" + System.identityHashCode(this.d));
        ((bvb.a) this.k.getValue()).b();
        ((com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b) this.w.getValue()).a();
        ((MmRecordingSessionManager) this.i.getValue()).t();
        ((com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a) this.m.getValue()).a();
        ((dvb.a) this.n.getValue()).a();
        ((MmMinutesFileUploadSessionManager) this.o.getValue()).A();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final nub.a t(String r4) {
        Intrinsics.checkNotNullParameter(r4, "meetingId");
        nub.b r0 = P();     // Catch: Exception -> L7
        if (r0 == null) goto L9;
        return r0.t(r4);
    L9:
        return null;
    L7:
        e = move-exception;
        lvb.a.b(this.g, "getMeetingExternalAudioInput failed: " + e);
        goto L9
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a
    public final <T extends IOfficeSDKProtocol> T u(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceClass");
        return (T) OfficeSDKManager.getHostUserService(this.a, r2);
    }

    public MinutesUCCImpl(String r8, c r9, g r10, l r11, m r12) {
        Intrinsics.checkNotNullParameter(r8, "userId");
        Intrinsics.checkNotNullParameter(r9, "userDomainConfig");
        Intrinsics.checkNotNullParameter(r10, "featureGatingService");
        Intrinsics.checkNotNullParameter(r11, "rustClient");
        Intrinsics.checkNotNullParameter(r12, "passportService");
        AnonymousClass1 r5 = new AnonymousClass1(evb.c.a);
        Intrinsics.checkNotNullParameter(r8, "userId");
        Intrinsics.checkNotNullParameter(r9, "userDomainConfig");
        Intrinsics.checkNotNullParameter(r10, "featureGatingService");
        Intrinsics.checkNotNullParameter(r11, "rustClient");
        Intrinsics.checkNotNullParameter(r12, "passportService");
        Intrinsics.checkNotNullParameter(r5, "hardwareManagerFactory");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r5;
        String r13 = "MinutesUCCImpl_" + hashCode();
        this.g = r13;
        CoroutineScope r14 = CoroutineScopeKt.MainScope();
        this.h = r14;
        this.i = LazyKt.lazy(new MinutesUCCImpl$sessionManager$2(this));
        this.j = LazyKt.lazy(new MinutesUCCImpl$recordingPriorityCoordinatorInstance$2(this));
        this.k = LazyKt.lazy(new MinutesUCCImpl$hardwareDeviceManagerLazy$1(this));
        this.l = LazyKt.lazy(new MinutesUCCImpl$hardwareRecordingManagerInstance$2(this));
        this.m = LazyKt.lazy(new MinutesUCCImpl$hardwareLiveRecordingManagerLazy$1(this));
        this.n = LazyKt.lazy(new MinutesUCCImpl$hardwareFileSyncControlManagerLazy$1(this));
        this.o = LazyKt.lazy(new MinutesUCCImpl$minutesFileUploadManager$2(this));
        this.p = LazyKt.lazy(new MinutesUCCImpl$domainConfig$2(this));
        this.q = LazyKt.lazy(new MinutesUCCImpl$mmNetworkHandler$2(this));
        this.r = LazyKt.lazy(new MinutesUCCImpl$recordingNetworkMockEngine$2(this));
        this.s = LazyKt.lazy(new MinutesUCCImpl$netRequestService$2(this));
        this.t = LazyKt.lazy(new MinutesUCCImpl$mockAwarePushServiceLazy$1(this));
        this.u = LazyKt.lazy(new MinutesUCCImpl$netPushService$2(this));
        this.v = LazyKt.lazy(new MinutesUCCImpl$mFeatureService$2(this));
        this.w = LazyKt.lazy(MinutesUCCImpl$appSettingsService$2.INSTANCE);
        this.x = LazyKt.lazy(new MinutesUCCImpl$userKVRepo$2(this));
        this.y = LazyKt.lazy(new MinutesUCCImpl$mmRecordingNetHelper$2(this));
        this.z = LazyKt.lazy(new MinutesUCCImpl$mmUserInfoHelper$2(this));
        this.A = LazyKt.lazy(new MinutesUCCImpl$adminSettingsService$2(this));
        this.B = LazyKt.lazy(new MinutesUCCImpl$mRtcPreloadCache$2(this));
        this.C = LazyKt.lazy(new MinutesUCCImpl$mmRecordingBusinessTracker$2(this));
        this.D = LazyKt.lazy(new MinutesUCCImpl$d1204RecordingEventTrackerInstance$2(this));
        this.E = r14;
        lvb.a.e(r13, "init, userId=" + r8 + ", rustClientHash=" + System.identityHashCode(r11));
    }
}
