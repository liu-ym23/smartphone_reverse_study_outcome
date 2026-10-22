package com.bytedance.android.livesdk.interactivity.like.controller;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.interactivity.like.wrdsmodel.DoubleLikeSyncModel;
import com.bytedance.android.livesdk.message.model.c4;
import com.bytedance.android.livesdk.message.model.d4;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u32.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b=\u0010>J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0014J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J \u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020\n2\u0006\u0010 \u001a\u00020#H\u0016R\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010(\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u0012018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00107R\u0017\u00109\u001a\u0002088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/controller/DoubleLikeManager;", "Landroidx/lifecycle/ViewModel;", "Lu32/l;", BuildConfig.FLAVOR, "seqId", BuildConfig.FLAVOR, "doubleFlag", "checkAndUpdateSeqId", "Lcom/bytedance/android/livesdk/interactivity/like/controller/b$a;", "info", BuildConfig.FLAVOR, "notifyActivityStart", "notifyActivityEnd", "notifyActivityRenewalUpdate", "notifyActivityUserRankUpdate", "notifyActivitySummary", "onCleared", "isDoubleLike", "Lu32/l$a;", "listener", "notifyLatest", "addListener", "removeListener", BuildConfig.FLAVOR, "count", "doubleLikeFlag", "doubleLikeFlagV2", "onLocalLikeResult", "onLocalLike", "enable", "setDoubleLikeEnable", "Lcom/bytedance/android/livesdk/interactivity/api/like/model/b;", "message", "version", "onDoubleLikeSyncData", "Lcom/bytedance/android/livesdk/message/model/c4;", "onDoubleLikeTopUserMessage", "lastDisableSeqId", "J", "lastEnableSeqId", "currentRealLocalDoubleLikeCount", "I", "currentLocalDoubleLikeCount", "Lcom/bytedance/android/livesdk/interactivity/api/like/model/a;", "currentDoubleLikeDetail", "Lcom/bytedance/android/livesdk/interactivity/api/like/model/a;", "Lcom/bytedance/android/livesdk/interactivity/like/controller/b;", "stateMachine", "Lcom/bytedance/android/livesdk/interactivity/like/controller/b;", BuildConfig.FLAVOR, "listeners", "Ljava/util/List;", "Lio/reactivex/disposables/Disposable;", "roomDataSyncModelSubscribe", "Lio/reactivex/disposables/Disposable;", "Z", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DoubleLikeManager extends ViewModel implements l {
    private com.bytedance.android.livesdk.interactivity.api.like.model.a currentDoubleLikeDetail;
    private int currentLocalDoubleLikeCount;
    private int currentRealLocalDoubleLikeCount;
    private boolean enable;
    private long lastDisableSeqId;
    private long lastEnableSeqId;
    private final List<l.a> listeners;
    private final MiddlewareRoomContext roomContext;
    private Disposable roomDataSyncModelSubscribe;
    private final com.bytedance.android.livesdk.interactivity.like.controller.b stateMachine;

    public static final class a implements com.bytedance.android.livesdk.interactivity.like.controller.b.c {
        public final /* synthetic */ DoubleLikeManager a;

        public a(DoubleLikeManager r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.controller.b.c
        public final void a(com.bytedance.android.livesdk.interactivity.like.controller.b.a r6) {
            Intrinsics.checkNotNullParameter(r6, "info");
            com.bytedance.android.livesdk.interactivity.api.like.model.a r0 = DoubleLikeManager.access$getCurrentDoubleLikeDetail$p(this.a);
            long r1 = 0;
            if (r0 == null) goto L5;
            long r3 = r0.b();
        L6:
            com.bytedance.android.livesdk.interactivity.api.like.model.a r2 = r6.b;
            if (r2 == null) goto L10;
            r1 = r2.b();
        L10:
            if (r3 >= r1) goto L12;
            DoubleLikeManager.access$setCurrentDoubleLikeDetail$p(this.a, r6.b);
            DoubleLikeManager.access$notifyActivityRenewalUpdate(this.a, r6);
        L12:
            DoubleLikeManager.access$notifyActivityUserRankUpdate(this.a, r6);
            return;
        L5:
            r3 = 0;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.controller.b.c
        public final void b(com.bytedance.android.livesdk.interactivity.like.controller.b.a r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            DoubleLikeManager.access$notifyActivitySummary(this.a, r2);
            DoubleLikeManager.access$setCurrentRealLocalDoubleLikeCount$p(this.a, 0);
            DoubleLikeManager.access$setCurrentLocalDoubleLikeCount$p(this.a, 0);
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.controller.b.c
        public final void c(com.bytedance.android.livesdk.interactivity.like.controller.b.a r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            DoubleLikeManager.access$notifyActivityEnd(this.a);
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.controller.b.c
        public final void d(com.bytedance.android.livesdk.interactivity.like.controller.b.a r3) {
            Intrinsics.checkNotNullParameter(r3, "info");
            DoubleLikeManager.access$setCurrentDoubleLikeDetail$p(this.a, r3.b);
            DoubleLikeManager.access$notifyActivityStart(this.a, r3);
            DoubleLikeManager.access$notifyActivityUserRankUpdate(this.a, r3);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DoubleLikeManager a;

        public b(DoubleLikeManager r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            dc2.c.b r6 = (dc2.c.b) r5;
            this.a.onDoubleLikeSyncData((com.bytedance.android.livesdk.interactivity.api.like.model.b) r6.b, r6.a);
        }
    }

    private final void notifyActivityEnd() {
        Iterator<T> r0 = this.listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((l.a) r0.next()).e(this, this.currentLocalDoubleLikeCount);
        goto L4
    }

    public boolean isDoubleLike() {
        return Intrinsics.areEqual((com.bytedance.android.livesdk.interactivity.like.controller.b.e) this.stateMachine.a.b(), com.bytedance.android.livesdk.interactivity.like.controller.b.e.a.b);
    }

    public void onCleared() {
        this.listeners.clear();
        Disposable r0 = this.roomDataSyncModelSubscribe;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final MiddlewareRoomContext getRoomContext() {
        return this.roomContext;
    }

    public DoubleLikeManager(MiddlewareRoomContext r3) {
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.roomContext = r3;
        this.lastDisableSeqId = -1;
        this.lastEnableSeqId = -1;
        this.listeners = new ArrayList();
        this.enable = true;
        this.stateMachine = new com.bytedance.android.livesdk.interactivity.like.controller.b(new a(this));
        this.roomDataSyncModelSubscribe = ((DoubleLikeSyncModel) dc2.b.a(n3.g(r3), DoubleLikeManager$roomDataSyncModel$1.INSTANCE)).getDoubleLikeSyncData().e.subscribe(new b(this));
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.like.model.a access$getCurrentDoubleLikeDetail$p(DoubleLikeManager r0) {
        return r0.currentDoubleLikeDetail;
    }

    public static final /* synthetic */ int access$getCurrentLocalDoubleLikeCount$p(DoubleLikeManager r0) {
        return r0.currentLocalDoubleLikeCount;
    }

    public static final /* synthetic */ int access$getCurrentRealLocalDoubleLikeCount$p(DoubleLikeManager r0) {
        return r0.currentRealLocalDoubleLikeCount;
    }

    public static final /* synthetic */ void access$notifyActivityEnd(DoubleLikeManager r0) {
        r0.notifyActivityEnd();
    }

    private final void notifyActivityRenewalUpdate(com.bytedance.android.livesdk.interactivity.like.controller.b.a r4) {
        Iterator<T> r0 = this.listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        l.a r1 = (l.a) r0.next();
        com.bytedance.android.livesdk.interactivity.api.like.model.a r2 = r4.b;
        if (r2 == null) goto L4;
        r1.l(this, r2);
        goto L4
    }

    private final void notifyActivityStart(com.bytedance.android.livesdk.interactivity.like.controller.b.a r4) {
        Iterator<T> r0 = this.listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        l.a r1 = (l.a) r0.next();
        com.bytedance.android.livesdk.interactivity.api.like.model.a r2 = r4.b;
        if (r2 == null) goto L4;
        r1.b(this, r2);
        goto L4
    }

    private final void notifyActivitySummary(com.bytedance.android.livesdk.interactivity.like.controller.b.a r9) {
        if (r9.d != null) goto L5;
        return;
    L5:
        if (r9.e == null) goto L12;
        Iterator<T> r0 = this.listeners.iterator();
    L8:
        if (r0.hasNext() == false) goto L13;
        ((l.a) r0.next()).d(this, this.currentLocalDoubleLikeCount, this.currentRealLocalDoubleLikeCount, r9.d, r9.e);
        goto L8
    L13:
        return;
    }

    private final void notifyActivityUserRankUpdate(com.bytedance.android.livesdk.interactivity.like.controller.b.a r4) {
        List<d4> r0 = r4.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!r0.isEmpty()) == false) goto L12;
        Iterator<T> r1 = this.listeners.iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        ((l.a) r1.next()).k(this, r4.c);
        goto L8
    L13:
        return;
    }

    public void onDoubleLikeTopUserMessage(c4 r13) {
        Intrinsics.checkNotNullParameter(r13, "message");
        this.stateMachine.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.AbstractC0171b.C0172b(new com.bytedance.android.livesdk.interactivity.like.controller.b.a(0, null, r13.E(), null, null, 27)));
    }

    @Override // u32.l
    public void onLocalLike(int r2) {
        if (isDoubleLike() == false) goto L6;
        this.currentLocalDoubleLikeCount += r2;
        return;
    }

    @Override // u32.l
    public void removeListener(l.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listeners.remove(r2);
    }

    @Override // u32.l
    public void setDoubleLikeEnable(boolean r11) {
        this.enable = r11;
        if (r11 == true) goto L6;
        this.stateMachine.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.AbstractC0171b.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.a(0, null, null, null, null, 30)));
        return;
    }

    public static final /* synthetic */ void access$notifyActivityRenewalUpdate(DoubleLikeManager r0, com.bytedance.android.livesdk.interactivity.like.controller.b.a r1) {
        r0.notifyActivityRenewalUpdate(r1);
    }

    public static final /* synthetic */ void access$notifyActivityStart(DoubleLikeManager r0, com.bytedance.android.livesdk.interactivity.like.controller.b.a r1) {
        r0.notifyActivityStart(r1);
    }

    public static final /* synthetic */ void access$notifyActivitySummary(DoubleLikeManager r0, com.bytedance.android.livesdk.interactivity.like.controller.b.a r1) {
        r0.notifyActivitySummary(r1);
    }

    public static final /* synthetic */ void access$notifyActivityUserRankUpdate(DoubleLikeManager r0, com.bytedance.android.livesdk.interactivity.like.controller.b.a r1) {
        r0.notifyActivityUserRankUpdate(r1);
    }

    public static final /* synthetic */ void access$setCurrentDoubleLikeDetail$p(DoubleLikeManager r0, com.bytedance.android.livesdk.interactivity.api.like.model.a r1) {
        r0.currentDoubleLikeDetail = r1;
    }

    public static final /* synthetic */ void access$setCurrentLocalDoubleLikeCount$p(DoubleLikeManager r0, int r1) {
        r0.currentLocalDoubleLikeCount = r1;
    }

    public static final /* synthetic */ void access$setCurrentRealLocalDoubleLikeCount$p(DoubleLikeManager r0, int r1) {
        r0.currentRealLocalDoubleLikeCount = r1;
    }

    private final boolean checkAndUpdateSeqId(long r7, boolean r9) {
        if (r9 == false) goto L9;
        long r2 = Math.max(this.lastEnableSeqId, r7);
        this.lastEnableSeqId = r2;
        if (r7 > this.lastDisableSeqId) goto L7;
    L12:
        return false;
    L7:
        if (r7 < r2) goto L12;
        return true;
    L9:
        this.lastDisableSeqId = Math.max(this.lastDisableSeqId, r7);
        if (r7 < this.lastEnableSeqId) goto L12;
        return true;
    }

    @Override // u32.l
    public void addListener(l.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.listeners.contains(r2) == true) goto L13;
        this.listeners.add(r2);
        if (r3 == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual((com.bytedance.android.livesdk.interactivity.like.controller.b.e) this.stateMachine.a.b(), com.bytedance.android.livesdk.interactivity.like.controller.b.e.a.b) == false) goto L11;
        com.bytedance.android.livesdk.interactivity.api.like.model.a r4 = this.currentDoubleLikeDetail;
        if (r4 == null) goto L15;
        r2.b(this, r4);
        return;
    L15:
        return;
    L11:
        r2.e(this, this.currentLocalDoubleLikeCount);
        return;
    }

    public void onDoubleLikeSyncData(com.bytedance.android.livesdk.interactivity.api.like.model.b r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, "message");
        if (this.enable == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.like.model.a r0 = r13.a();
        if (r0 != null) goto L8;
        return;
    L8:
        if (checkAndUpdateSeqId(r0.c(), r0.a()) == true) goto L12;
        com.bytedance.android.livesdk.interactivity.like.utils.d r15 = com.bytedance.android.livesdk.interactivity.like.utils.d.a;
        Intrinsics.checkNotNullParameter(r0, "detail");
        r15.a("onSeqIdInValid, msgId is " + r14 + ", detail info is " + JsonUtil.toJSONString(r0) + ' ');
        return;
    L12:
        if (r0.a() == false) goto L14;
        this.stateMachine.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.AbstractC0171b.C0172b(new com.bytedance.android.livesdk.interactivity.like.controller.b.a(r14, r0, null, null, null, 28)));
        return;
    L14:
        this.stateMachine.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.AbstractC0171b.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.a(r14, r0, null, null, null, 28)));
        if (r13.b() != null) goto L17;
        return;
    L17:
        if (r13.c() == null) goto L23;
        this.stateMachine.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.AbstractC0171b.c(new com.bytedance.android.livesdk.interactivity.like.controller.b.a(r14, r0, null, r13.b(), r13.c(), 4)));
        return;
    }

    @Override // u32.l
    public void onLocalLikeResult(int r1, boolean r2, boolean r3) {
        if (r3 == false) goto L5;
        this.currentRealLocalDoubleLikeCount += r1;
        return;
    }
}
