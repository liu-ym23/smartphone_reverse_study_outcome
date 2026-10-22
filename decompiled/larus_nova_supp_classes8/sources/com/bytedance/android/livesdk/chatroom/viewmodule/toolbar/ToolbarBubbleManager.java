package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 A*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002BCB\u0007¢\u0006\u0004\b?\u0010@J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002J\b\u0010\n\u001a\u00020\bH\u0014J=\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J=\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J.\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\u0004\b\u0001\u0010 2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016J5\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016¢\u0006\u0004\b\u0013\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00180/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R8\u00105\u001a&\u0012\f\u0012\n 3*\u0004\u0018\u00010\u001b0\u001b 3*\u0012\u0012\f\u0012\n 3*\u0004\u0018\u00010\u001b0\u001b\u0018\u000104028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010<\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010=\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006D"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarBubbleManager;", "CMD", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a0;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarBubbleManager$BubbleInfo;", "info", "", "checkCanShowBubble", "", "observeBubbleState", "onCleared", "command", "", "priority", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/z;", "bubble", "Lkotlin/Function0;", "onClickButtonArea", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a0$b;", "addBubble", "(Ljava/lang/Object;ILcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/z;Lkotlin/jvm/functions/Function0;)Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a0$b;", "onClickBubbleArea", "addBubbleLocal", "dismissBubble", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/b0;", "strategy", "addStrategy", "", "holder", "lock", "unlock", "tryStartNextBubble", "T", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroid/content/Context;", "context", "Landroid/view/View;", "anchorView", "createToolbarBubble", "(Ljava/lang/Object;Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/z;Lkotlin/jvm/functions/Function0;)Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a0$b;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Ljava/util/PriorityQueue;", "queue", "Ljava/util/PriorityQueue;", "", "strategies", "Ljava/util/List;", "", "kotlin.jvm.PlatformType", "", "lockSet", "Ljava/util/Set;", "Lcom/bytedance/android/livesdk/log/b;", "logger", "Lcom/bytedance/android/livesdk/log/b;", "getCurrentBubble", "()Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarBubbleManager$BubbleInfo;", "currentBubble", "isCleared", "()Z", "<init>", "()V", "Companion", "BubbleInfo", "b", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarBubbleManager<CMD> extends ViewModel implements a0<CMD> {
    public static final b Companion = null;
    public static final long SHOW_TIMEOUT = 10;
    public static final String TAG = "ToolbarBubbleManager";
    private final CompositeDisposable cd;
    private final Set<Object> lockSet;
    private final com.bytedance.android.livesdk.log.b logger;
    private final PriorityQueue<BubbleInfo<CMD>> queue;
    private final List<b0> strategies;

    public static final class BubbleInfo<CMD> implements a0.b {
        public final String a;
        public final PropertyOwner<State> b;
        public final PropertyOwner c;
        public final CMD d;
        public final int e;
        public final z<CMD> f;
        public final w g;
        public final com.bytedance.android.livesdk.popup.manager.c h;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarBubbleManager$BubbleInfo$State;", "", "target", "", "isAtLeast", "", "level", "I", "getLevel", "()I", "PENDING", "SHOW_REQUESTED", "SHOWING", "DISMISSED", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum State extends Enum<State> {
            public static final State DISMISSED = null;
            public static final State PENDING = null;
            public static final State SHOWING = null;
            public static final State SHOW_REQUESTED = null;
            public static final /* synthetic */ State[] a = null;
            private final int level;

            static {
                State r1 = new State("PENDING", 0, 0);
                PENDING = r1;
                State r2 = new State("SHOW_REQUESTED", 1, 1);
                SHOW_REQUESTED = r2;
                State r3 = new State("SHOWING", 2, 2);
                SHOWING = r3;
                State r4 = new State("DISMISSED", 3, 3);
                DISMISSED = r4;
                a = new State[]{r1, r2, r3, r4};
            }

            public static State valueOf(String r1) {
                return (State) r27.a.a(State.class, r1);
            }

            public static State[] values() {
                return (State[]) a.clone();
            }

            public final int getLevel() {
                return this.level;
            }

            public final boolean isAtLeast(State r2) {
                Intrinsics.checkNotNullParameter(r2, "target");
                if (this.level < r2.level) goto L5;
                return true;
            L5:
                return false;
            }

            public State(String r1, int r2, int r3) {
                super(r1, r2);
                this.level = r3;
            }
        }

        public final String toString() {
            return this.a + "(state=" + ((State) this.b.a) + ", command=" + this.d + ", bubble=" + this.f + ')';
        }

        public final boolean a(State r5) {
            Intrinsics.checkNotNullParameter(r5, "target");
            if (((State) this.b.a).isAtLeast(r5) == false) goto L6;
            return false;
        L6:
            this.b.a(r5);
            int r6 = t2.a[r5.ordinal()];
            if (r6 != 1) goto L9;
            this.f.a(this.d, this.g, this.h);
        L13:
            return true;
        L9:
            if (r6 != 2) goto L13;
            this.f.dismiss();
            goto L13
        }

        public BubbleInfo(CMD r2, int r3, z<CMD> r4, w r5, com.bytedance.android.livesdk.popup.manager.c r6) {
            Intrinsics.checkNotNullParameter(r4, "bubble");
            Intrinsics.checkNotNullParameter(r5, "clickCallback");
            Intrinsics.checkNotNullParameter(r6, "livePopupCallback");
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r6;
            this.a = "BubbleInfo@" + com.bytedance.android.live.core.utils.z0.c(this);
            PropertyOwner<State> r7 = new PropertyOwner(State.PENDING);
            this.b = r7;
            this.c = r7;
        }
    }

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((BubbleInfo) r2).e), Integer.valueOf(((BubbleInfo) r1).e));
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c implements w {
        public final /* synthetic */ Function0 a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void b() {
            this.a.invoke();
        }

        public c(Function0 r1) {
            this.a = r1;
        }
    }

    public static final class d implements w {
        public final /* synthetic */ Function0 a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void b() {
            this.a.invoke();
        }

        public d(Function0 r1) {
            this.a = r1;
        }
    }

    public static final class e implements com.bytedance.android.livesdk.popup.manager.c {
        public final /* synthetic */ Ref.ObjectRef a;

        public final void waiting() {
        }

        public final void a() {
            BubbleInfo r0 = (BubbleInfo) this.a.element;
            Intrinsics.checkNotNull(r0);
            r0.a(BubbleInfo.State.DISMISSED);
        }

        public final void b() {
            BubbleInfo r0 = (BubbleInfo) this.a.element;
            Intrinsics.checkNotNull(r0);
            r0.a(BubbleInfo.State.SHOWING);
        }

        public e(Ref.ObjectRef r1) {
            this.a = r1;
        }
    }

    public static final class f implements com.bytedance.android.livesdk.popup.manager.c {
        public final /* synthetic */ Ref.ObjectRef a;

        public final void waiting() {
        }

        public final void a() {
            BubbleInfo r0 = (BubbleInfo) this.a.element;
            Intrinsics.checkNotNull(r0);
            r0.a(BubbleInfo.State.DISMISSED);
        }

        public final void b() {
            BubbleInfo r0 = (BubbleInfo) this.a.element;
            Intrinsics.checkNotNull(r0);
            r0.a(BubbleInfo.State.SHOWING);
        }

        public f(Ref.ObjectRef r1) {
            this.a = r1;
        }
    }

    public static final class g implements w {
        public final /* synthetic */ Function0 a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void b() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void a() {
            this.a.invoke();
        }

        public g(Function0 r1) {
            this.a = r1;
        }
    }

    public static final class h implements com.bytedance.android.livesdk.popup.manager.c {
        public final /* synthetic */ Ref.ObjectRef a;

        public final void waiting() {
        }

        public final void a() {
            BubbleInfo r0 = (BubbleInfo) this.a.element;
            Intrinsics.checkNotNull(r0);
            r0.a(BubbleInfo.State.DISMISSED);
        }

        public final void b() {
            BubbleInfo r0 = (BubbleInfo) this.a.element;
            Intrinsics.checkNotNull(r0);
            r0.a(BubbleInfo.State.SHOWING);
        }

        public h(Ref.ObjectRef r1) {
            this.a = r1;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ ToolbarBubbleManager a;
        public final /* synthetic */ BubbleInfo b;
        public final /* synthetic */ Ref.BooleanRef c;

        public i(ToolbarBubbleManager r1, BubbleInfo r2, Ref.BooleanRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            BubbleInfo.State r5 = (BubbleInfo.State) r4;
            ToolbarBubbleManager.access$getLogger$p(this.a).b(this.b.a + ' ' + ((BubbleInfo.State) this.b.c.a));
            if (r5 == null) goto L28;
            int r6 = u2.a[r5.ordinal()];
            if (r6 != 1) goto L8;
            ToolbarBubbleManager.access$getQueue$p(this.a).remove(this.b);
            if (this.c.element == false) goto L23;
            Iterator<T> r7 = ToolbarBubbleManager.access$getStrategies$p(this.a).iterator();
        L21:
            if (r7.hasNext() == false) goto L23;
            ((b0) r7.next()).e(this.b);
        L23:
            this.a.tryStartNextBubble();
            return;
        L8:
            if (r6 != 2) goto L10;
            RxUtilKt.c(RxUtilKt.h(Observable.timer(10, TimeUnit.SECONDS)).takeUntil(this.b.c.filter(v2.a)).subscribe(new w2(this)), ToolbarBubbleManager.access$getCd$p(this.a));
            return;
        L10:
            if (r6 != 3) goto L29;
            this.c.element = true;
            xs2.b.a().post(new com.bytedance.android.livesdk.utils.condition.base.b(ConditionConstant.ConditionType.SHOW_BUBBLE));
            Iterator<T> r8 = ToolbarBubbleManager.access$getStrategies$p(this.a).iterator();
        L14:
            if (r8.hasNext() == false) goto L30;
            ((b0) r8.next()).d(this.b);
            goto L14
        L30:
            return;
        L29:
            return;
        }
    }

    static {
        Companion = new b();
    }

    private final BubbleInfo<CMD> getCurrentBubble() {
        return this.queue.peek();
    }

    public final boolean isCleared() {
        return this.cd.isDisposed();
    }

    public void onCleared() {
        this.cd.dispose();
        Iterator<T> r0 = this.queue.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((BubbleInfo) r0.next()).a(BubbleInfo.State.DISMISSED);
        goto L4
    L6:
        this.queue.clear();
        Iterator<T> r1 = this.strategies.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((b0) r1.next()).c(this);
        goto L8
    L10:
        this.strategies.clear();
        this.lockSet.clear();
        this.logger.b("onCleared");
    }

    public ToolbarBubbleManager() {
        this.cd = new CompositeDisposable();
        this.queue = new PriorityQueue(11, new a());
        this.strategies = new ArrayList();
        this.lockSet = Collections.newSetFromMap(new WeakHashMap());
        com.bytedance.android.livesdk.log.b r0 = new com.bytedance.android.livesdk.log.b(TAG, "[" + com.bytedance.android.live.core.utils.z0.c(this) + ']');
        this.logger = r0;
        r0.b("created");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public void tryStartNextBubble() {
        if (isCleared() == false) goto L5;
        return;
    L5:
        BubbleInfo<CMD> r0 = getCurrentBubble();
        if (r0 != null) goto L9;
        return;
    L9:
        if (((BubbleInfo.State) r0.c.a) == BubbleInfo.State.PENDING) goto L11;
        return;
    L11:
        if (checkCanShowBubble(r0) == false) goto L15;
        r0.a(BubbleInfo.State.SHOW_REQUESTED);
        return;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(ToolbarBubbleManager r0) {
        return r0.cd;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.log.b access$getLogger$p(ToolbarBubbleManager r0) {
        return r0.logger;
    }

    public static final /* synthetic */ PriorityQueue access$getQueue$p(ToolbarBubbleManager r0) {
        return r0.queue;
    }

    public static final /* synthetic */ List access$getStrategies$p(ToolbarBubbleManager r0) {
        return r0.strategies;
    }

    private final boolean checkCanShowBubble(BubbleInfo<CMD> r8) {
        List<b0> r0 = this.strategies;
        boolean r2 = true;
        String r4 = "";
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        b0 r3 = (b0) r1.next();
        boolean r5 = !r3.a(r8);
        if (r5 == false) goto L13;
        r4 = "strategy " + r3;
    L13:
        if (r5 == false) goto L9;
        boolean r9 = true;
    L15:
        int r6 = this.lockSet.size();
        if (r9 == true) goto L19;
        if (r6 != 0) goto L19;
    L20:
        if (r2 == true) goto L22;
        this.logger.b("cannot show bubble, blockSource=" + r4 + ", lockCount=" + r6);
    L22:
        return r2;
    L19:
        r2 = false;
    L6:
        r9 = false;
        goto L15
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L6
    }

    private final void observeBubbleState(BubbleInfo<CMD> r4) {
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = false;
        RxUtilKt.c(r4.c.subscribe(new i(this, r4, r0)), this.cd);
    }

    public void addStrategy(b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        if (isCleared() == false) goto L5;
        return;
    L5:
        this.strategies.add(r2);
        r2.b(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public boolean dismissBubble(a0.b r4) {
        if ((r4 instanceof BubbleInfo) == true) goto L5;
        r4 = null;
    L5:
        BubbleInfo<CMD> r5 = (BubbleInfo) r4;
        if (r5 != null) goto L8;
        r5 = getCurrentBubble();
    L8:
        if (r5 != null) goto L11;
        return false;
    L11:
        this.logger.b("dismissBubble: " + r5);
        return r5.a(BubbleInfo.State.DISMISSED);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public void lock(Object r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        this.logger.b("lock: " + r4);
        this.lockSet.add(r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public void unlock(Object r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        this.logger.b("unlock: " + r4);
        this.lockSet.remove(r4);
        tryStartNextBubble();
    }

    public a0.b addBubble(CMD r9, z<CMD> r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "bubble");
        Intrinsics.checkNotNullParameter(r11, "onClickButtonArea");
        if (isCleared() == false) goto L5;
        return null;
    L5:
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        r0.element = new BubbleInfo(r9, 0, r10, new d(r11), new f(r0));
        this.logger.b("addBubble: " + ((BubbleInfo) r0.element));
        observeBubbleState((BubbleInfo) r0.element);
        this.queue.add((BubbleInfo) r0.element);
        tryStartNextBubble();
        return (BubbleInfo) r0.element;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public <T> z<T> createToolbarBubble(DataCenter r2, Context r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "anchorView");
        return new q2(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public a0.b addBubble(CMD r9, int r10, z<CMD> r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r11, "bubble");
        Intrinsics.checkNotNullParameter(r12, "onClickButtonArea");
        if (isCleared() == false) goto L5;
        return null;
    L5:
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        r0.element = new BubbleInfo(r9, r10, r11, new c(r12), new e(r0));
        this.logger.b("addBubble: " + ((BubbleInfo) r0.element));
        observeBubbleState((BubbleInfo) r0.element);
        this.queue.add((BubbleInfo) r0.element);
        tryStartNextBubble();
        return (BubbleInfo) r0.element;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public a0.b addBubbleLocal(CMD r9, int r10, z<CMD> r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r11, "bubble");
        Intrinsics.checkNotNullParameter(r12, "onClickBubbleArea");
        if (isCleared() == false) goto L5;
        return null;
    L5:
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        r0.element = new BubbleInfo(r9, r10, r11, new g(r12), new h(r0));
        this.logger.b("addBubble: " + ((BubbleInfo) r0.element));
        observeBubbleState((BubbleInfo) r0.element);
        this.queue.add((BubbleInfo) r0.element);
        tryStartNextBubble();
        return (BubbleInfo) r0.element;
    }
}
