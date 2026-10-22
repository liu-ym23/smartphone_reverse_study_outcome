package com.ss.android.lark.flow.feed.base;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.arch.jack.f;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MixedFeedDataController<VM extends s> implements com.ss.android.lark.flow.feed.base.a {
    public static final /* synthetic */ int r = 0;
    public final boolean a;
    public final com.ss.android.lark.flow.feed.base.b<VM> b;
    public l c;
    public com.ss.android.lark.flow.feed.data.a d;
    public boolean e;
    public final Lazy f;
    public final Lazy g;
    public UpdateRecord h;
    public boolean i;
    public com.ss.android.lark.feed.molten.cache.b j;
    public chb.a k;
    public final Lazy l;
    public final c m;
    public final Function0<Unit> n;
    public final d o;
    public final Function0<Unit> p;
    public final Function0<Unit> q;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MixedFeedDataController<VM> a;
        public final /* synthetic */ UpdateRecord b;

        public b(MixedFeedDataController<VM> r1, UpdateRecord r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b.getAdapter().update(this.b);     // Catch: Throwable -> L4
            this.a.b.d1(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements hza.a {
        public final /* synthetic */ MixedFeedDataController<VM> a;

        public c(MixedFeedDataController<VM> r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "doubao migrate finished, drop local conversation data");
            this.a.c().clear();
            this.a.d();
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MixedFeedDataController<VM> a;

        public d(MixedFeedDataController<VM> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MixedFeedDataController<VM> r0 = this.a;     // Catch: Throwable -> L6
            if (r0.e == true) goto L9;
            MixedFeedDataController.a(r0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.flow.feed.base.a
    public final void T() {
        chb.a r0 = this.k;
        if (r0 != null) goto L6;
        com.ss.android.lark.flow.feed.utils.b.e("MixedFeedDataController", "unregisterUserReadyListener skipped: dataSource not bound");
        return;
    L6:
        r0.k3(this.n);
        r0.ce(this.p);
    }

    @Override // com.ss.android.lark.flow.feed.base.a
    public final void U() {
        chb.a r0 = this.k;
        if (r0 != null) goto L6;
        com.ss.android.lark.flow.feed.utils.b.e("MixedFeedDataController", "registerUserReadyListener skipped: dataSource not bound");
        return;
    L6:
        r0.i8(this.n);
        r0.Nb(this.p);
    }

    public final List<UIFeedCard> b() {
        return (List) this.g.getValue();
    }

    public final List<UIFeedCard> c() {
        return (List) this.f.getValue();
    }

    public final void d() {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
        if (this.e == false) goto L22;
        UpdateRecord r1 = this.h;
        if (r1 == null) goto L8;
        List r3 = r1.b;
        if (r3 == null) goto L8;
    L10:
        if (this.h != null) goto L12;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "user ready but server not arrived yet, fallback to cache");
        r0.addAll(c());
        r0.addAll(b());
    L25:
        List<UIFeedCard> r4 = this.b.h1(r0);
        HashSet r5 = new HashSet();
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r4.iterator();
    L26:
        UIFeedCard r8 = null;
        if (r7.hasNext() == false) goto L44;
        Object r9 = r7.next();
        UIFeedCard r10 = (UIFeedCard) r9;
        UIFeedCard r11 = r10.getBizId();
        if (r11 != null) goto L31;
    L34:
        boolean r12 = true;
    L36:
        if ((!r12) == false) goto L38;
        r8 = r11;
    L38:
        if (r8 == null) goto L42;
        r10 = r8;
    L42:
        if (r5.add(r10) == false) goto L26;
        r6.add(r9);
        goto L26
    L31:
        if (r11.length() == 0) goto L34;
        r12 = false;
        goto L36
    L44:
        List r13 = CollectionsKt.sorted(r6);
        StringBuilder r14 = new StringBuilder("dispatchMergedSnapshot, isUserReady=");
        r14.append(this.e);
        r14.append(", migrateStatus=");
        com.ss.android.lark.flow.feed.data.a r15 = this.d;
        if (r15 == null) goto L47;
        Boolean r16 = Boolean.valueOf(r15.b());
    L48:
        r14.append(r16);
        r14.append(", latestServerSize=");
        UpdateRecord r17 = this.h;
        if (r17 == null) goto L53;
        List r18 = r17.b;
        if (r18 == null) goto L53;
        r8 = Integer.valueOf(((ArrayList) r18).size());
    L53:
        r14.append(r8);
        r14.append(", localSize=");
        r14.append(c().size());
        r14.append(", cachedSize=");
        r14.append(b().size());
        r14.append(", mergedSize=");
        r14.append(r0.size());
        r14.append(", distinct=");
        r14.append(r13.size());
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", r14.toString());
        List r19 = r13;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r21 = r19.iterator();
    L55:
        if (r21.hasNext() == false) goto L57;
        r20.add(((UIFeedCard) r21.next()).getId());
        goto L55
    L57:
        Iterator r22 = CollectionsKt.chunked(r20, 20).iterator();
    L59:
        if (r22.hasNext() == false) goto L65;
        Object r23 = r22.next();
        int r24 = r2 + 1;
        if (r2 >= 0) goto L63;
        CollectionsKt.throwIndexOverflow();
    L63:
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "mergeDataLogic after sorted feedIds part" + r2 + '=' + ((List) r23));
        r2 = r24;
        goto L59
    L65:
        if (this.a == false) goto L67;
    L70:
        FeedFolder r25 = this.b.g1();
        UpdateRecord r26 = new UpdateRecord();
        FeedCard.FeedType r27 = FeedCard.FeedType.ALL;
        r26.c = r13.isEmpty();
        r26.a(r13);
        r26.d = true;
        r26.e = this.b.t();
        UpdateRecord r28 = this.h;
        if (r28 == null) goto L73;
        long r29 = r28.a;
    L74:
        r26.a = r29;
        r26.g = r25;
        r26.h = r25;
        ThreadUtils.runOnUIThread(new b(this, r26));
        return;
    L73:
        r29 = 1;
        goto L74
    L67:
        if (r13.isEmpty() == false) goto L70;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "mergeDataLogic - tab mode skip dispatch empty merge ");
        return;
    L47:
        r16 = null;
        goto L48
    L12:
        com.ss.android.lark.flow.feed.data.a r30 = this.d;
        if (r30 != null) goto L15;
    L17:
        boolean r31 = false;
    L18:
        if (r31 == false) goto L20;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "user server record");
        r0.addAll(r3);
        goto L25
    L20:
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "user server + local conversation record");
        r0.addAll(c());
        r0.addAll(r3);
        goto L25
    L15:
        if (r30.b() != true) goto L17;
        r31 = true;
    L8:
        r3 = CollectionsKt.emptyList();
        goto L10
    L22:
        if ((!b().isEmpty()) == false) goto L24;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "user cachedFeed record");
        r0.addAll(b());
        goto L25
    L24:
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "user local conversation record");
        r0.addAll(c());
        goto L25
    }

    @Override // com.ss.android.lark.flow.feed.base.a
    public final void release() {
        CoroutineScopeKt.cancel$default((CoroutineScope) this.l.getValue(), null, 1, null);
        UICallbackExecutor.removeCallbacks(this.o);
        com.ss.android.lark.flow.feed.data.a r0 = this.d;
        if (r0 == null) goto L5;
        r0.c(this.m);
    L5:
        this.d = null;
        this.e = false;
        this.h = null;
        b().clear();
        c().clear();
        this.i = false;
        this.k = null;
    }

    @Override // com.ss.android.lark.flow.feed.base.a
    public final void R() {
        d();
    }

    public static final void a(MixedFeedDataController r10) {
        r10.getClass();
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "try enter user ready");
        chb.a r0 = r10.k;
        if (r0 != null) goto L6;
        com.ss.android.lark.flow.feed.utils.b.e("MixedFeedDataController", "tryEnterUserReady skipped: dataSource not bound");
        return;
    L6:
        if (r10.b.c1() == true) goto L8;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "tryEnterUserReady skipped: delegate.canEnterUserReady() is false");
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "start schedule retry");
        UICallbackExecutor.removeCallbacks(r10.o);
        UICallbackExecutor.executeDelayed(r10.o, 50);
        return;
    L8:
        l r2 = r0.w();
        com.ss.android.lark.flow.feed.data.a r1 = r0.Q();
        s r6 = r10.b.a1();
        boolean r7 = true;
        if (r2 == null) goto L14;
        if (r1 == null) goto L14;
        if (r6 == null) goto L14;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "tryEnterUserReady: switch to user-scope！");
        UICallbackExecutor.removeCallbacks(r10.o);
        r10.c = r2;
        r10.d = r1;
        r10.b.b1(r2, r6, r1);
        r10.e = true;
        r1.a(r10.m);
        r10.b.j1(r6);
        r6.start(r10.b.g1());
        f r3 = r10.b.e1();
        LifecycleCoroutineScope r4 = LifecycleOwnerKt.getLifecycleScope(r10.b.getLifecycleOwner());
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r6.notifyItemChangedEvent(r3), new MixedFeedDataController$observeStateFlow$1$1$1(r10, null)), r4);
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r6.feedItemEntities(r3), new MixedFeedDataController$observeStateFlow$1$1$2(r10, null)), r4);
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r6.refreshItems(r3), new MixedFeedDataController$observeStateFlow$1$1$3(r10, null)), r4);
        return;
    L14:
        StringBuilder r8 = new StringBuilder("tryEnterUserReady: SPI not ready, rustClient ready=");
        if (r2 == null) goto L17;
        boolean r5 = true;
    L18:
        r8.append(r5);
        r8.append(", migrate ready=");
        if (r1 == null) goto L21;
        boolean r9 = true;
    L22:
        r8.append(r9);
        r8.append(", viewModel ready=");
        if (r6 != null) goto L26;
        r7 = false;
    L26:
        r8.append(r7);
        com.ss.android.lark.flow.feed.utils.b.e("MixedFeedDataController", r8.toString());
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "start schedule retry");
        UICallbackExecutor.removeCallbacks(r10.o);
        UICallbackExecutor.executeDelayed(r10.o, 50);
        return;
    L21:
        r9 = false;
        goto L22
    L17:
        r5 = false;
        goto L18
    }

    @Override // com.ss.android.lark.flow.feed.base.a
    public final void Q(List<? extends UIFeedCard> r8) {
        Intrinsics.checkNotNullParameter(r8, "conversationData");
        com.ss.android.lark.flow.feed.data.a r0 = this.d;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.b() != true) goto L7;
    L9:
        if (r2 == false) goto L12;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "setLocalConversationData ignored: doubao migrate already finished");
        return;
    L12:
        List<? extends UIFeedCard> r3 = r8;
        Iterator<T> r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L17;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "setLocalConversationData uiCard=" + geb.a.b((UIFeedCard) r4.next()));
        goto L14
    L17:
        if (r8.size() <= c().size()) goto L19;
        this.i = false;
    L19:
        c().clear();
        c().addAll(r8);
        Iterator<T> r9 = r3.iterator();
    L21:
        if (r9.hasNext() == false) goto L23;
        com.ss.android.lark.feed.shared.data.utils.f.b((UIFeedCard) r9.next());
        goto L21
    L23:
        d();
        return;
    L7:
        r2 = false;
        goto L9
    }

    public MixedFeedDataController(boolean r2, com.ss.android.lark.flow.feed.base.b<VM> r3) {
        Intrinsics.checkNotNullParameter(r3, "delegate");
        this.a = r2;
        this.b = r3;
        this.f = LazyKt.lazy(MixedFeedDataController$localConversationData$2.INSTANCE);
        this.g = LazyKt.lazy(MixedFeedDataController$cachedFeedCards$2.INSTANCE);
        this.l = LazyKt.lazy(MixedFeedDataController$loadDataScope$2.INSTANCE);
        this.m = new c(this);
        this.n = new MixedFeedDataController$userReadyListener$1(this);
        this.o = new d(this);
        this.p = new MixedFeedDataController$userNotReadyListener$1(this);
        this.q = new MixedFeedDataController$loadCacheToUI$1(this);
    }

    @Override // com.ss.android.lark.flow.feed.base.a
    public final void S(vmb.c r9, com.ss.android.lark.feed.molten.cache.b r10) {
        Intrinsics.checkNotNullParameter(r9, "dataSource");
        Intrinsics.checkNotNullParameter(r10, "localCache");
        boolean r0 = false;
        this.e = false;
        this.h = null;
        b().clear();
        c().clear();
        this.i = false;
        this.k = r9;
        this.j = r10;
        if (r10 != null) goto L5;
    L7:
        if (r0 == false) goto L9;
        BuildersKt.launch$default((CoroutineScope) this.l.getValue(), Dispatchers.getMain(), null, new MixedFeedDataController$installCacheData$1(this, null), 2, null);
        return;
    L9:
        BuildersKt.launch$default((CoroutineScope) this.l.getValue(), Dispatchers.getIO(), null, new MixedFeedDataController$installCacheData$2(this, null), 2, null);
        return;
    L5:
        if (r10.c() != true) goto L7;
        r0 = true;
        goto L7
    }
}
