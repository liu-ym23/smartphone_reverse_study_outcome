package com.bytedance.android.live.context;

import com.bytedance.android.live.observer.ExpBizPerfObserver;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.context.PlatformExpRoomContext;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import com.bytedance.keva.Keva;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b5\u00106J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0005R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR!\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010%R\u001a\u0010(\u001a\u00020'8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R,\u0010.\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0-0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/bytedance/android/live/context/NewExpContext;", "Lcom/bytedance/android/live/room/api/experience/context/PlatformExpRoomContext;", "Ld61/b;", "Lcom/bytedance/android/live/observer/ExpBizPerfObserver;", "observer", "", "resetExpState", "Ll61/b;", "scene", "Lg61/a;", "listener", "Lio/reactivex/disposables/Disposable;", "registerExpBizListener", "unregisterExpBizListener", "unregisterAllListener", "startWork", "release", "", "reset", "shouldResetPerfBySwitchClose", "checkResetPerfWhenRoomExit", "", "tag$delegate", "Lkotlin/Lazy;", "getTag", "()Ljava/lang/String;", "tag", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "released", "Z", "resetPerfBySwitchClose", "", "Li61/b;", "producers$delegate", "getProducers", "()Ljava/util/List;", "producers", "Lh90/a;", "dispatch", "Lh90/a;", "getDispatch", "()Lh90/a;", "", "Lkotlin/Pair;", "bizPerfListeners", "Ljava/util/Map;", "", "roomFragmentTag", "I", "getRoomFragmentTag", "()I", "<init>", "(I)V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewExpContext extends PlatformExpRoomContext implements d61.b {
    private final Map<l61.b, Pair<ExpBizPerfObserver, Disposable>> bizPerfListeners;
    private final CompositeDisposable cd;
    private final h90.a dispatch;
    private final Lazy producers$delegate;
    private boolean released;
    private boolean resetPerfBySwitchClose;
    private final int roomFragmentTag;
    private final Lazy tag$delegate;

    public static final class a implements Action {
        public final /* synthetic */ ExpBizPerfObserver a;
        public final /* synthetic */ Disposable b;
        public final /* synthetic */ NewExpContext c;
        public final /* synthetic */ l61.b d;
        public final /* synthetic */ g61.a e;

        public a(ExpBizPerfObserver r1, Disposable r2, NewExpContext r3, l61.b r4, g61.a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void run() {
            NewExpContext.access$resetExpState(this.c, this.a);
            this.b.dispose();
            NewExpContext.access$getBizPerfListeners$p(this.c).remove(this.d);
            Keva r0 = o61.a.a;
            o61.a.d(this.d);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ExpBizPerfObserver a;

        public b(ExpBizPerfObserver r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ExpBizPerfObserver r0 = this.a;
            r0.b((k61.a) r2);
        }
    }

    private final String getTag() {
        return (String) this.tag$delegate.getValue();
    }

    public List<i61.b> getProducers() {
        return (List) this.producers$delegate.getValue();
    }

    public final void checkResetPerfWhenRoomExit() {
        Map<l61.b, Pair<ExpBizPerfObserver, Disposable>> r0 = this.bizPerfListeners;
        if (r0 == null) goto L14;
        Collection<Pair<ExpBizPerfObserver, Disposable>> r1 = r0.values();
        if (r1 == null) goto L14;
        Collection<Pair<ExpBizPerfObserver, Disposable>> r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r3.add((ExpBizPerfObserver) ((Pair) r4.next()).getFirst());
        goto L8
    L10:
        Iterator r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        resetExpState((ExpBizPerfObserver) r5.next());
    L14:
        this.resetPerfBySwitchClose = false;
    }

    public final void release() {
        if (this.released == false) goto L5;
        return;
    L5:
        this.released = true;
        unregisterAllListener();
        Iterator<T> r0 = getProducers().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((i61.b) r0.next()).onRelease();
        goto L7
    L9:
        this.cd.clear();
    }

    public final void unregisterAllListener() {
        Map<l61.b, Pair<ExpBizPerfObserver, Disposable>> r0 = this.bizPerfListeners;
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<Map.Entry<l61.b, Pair<ExpBizPerfObserver, Disposable>>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add((Disposable) r2.next().getValue().getSecond());
        goto L4
    L6:
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ((Disposable) r3.next()).dispose();
        goto L8
    L10:
        this.bizPerfListeners.clear();
    }

    public /* bridge */ /* synthetic */ e61.a getDispatch() {
        return m558getDispatch();
    }

    public final void startWork() {
        getWorkshop().start();
    }

    public final int getRoomFragmentTag() {
        return this.roomFragmentTag;
    }

    /* JADX INFO: renamed from: getDispatch, reason: collision with other method in class */
    public h90.a m558getDispatch() {
        return this.dispatch;
    }

    public NewExpContext(int r1) {
        this.roomFragmentTag = r1;
        this.tag$delegate = LazyKt.lazy(NewExpContext$tag$2.INSTANCE);
        this.cd = new CompositeDisposable();
        this.producers$delegate = LazyKt.lazy(new NewExpContext$producers$2(this));
        this.dispatch = new h90.a();
        this.bizPerfListeners = new LinkedHashMap();
    }

    public static final /* synthetic */ Map access$getBizPerfListeners$p(NewExpContext r0) {
        return r0.bizPerfListeners;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void resetExpState(ExpBizPerfObserver r4) {
        if (r4.a == true) goto L5;
        return;
    L5:
        if (this.resetPerfBySwitchClose == true) goto L7;
        return;
    L7:
        if (((Boolean) o61.a.f.a).booleanValue() == true) goto L10;
        r4.b(new k61.a(LivePerfBizType.Normal, LivePerfBizLevel.Default));
        return;
    L10:
        if (((Boolean) o61.a.h.a).booleanValue() == true) goto L16;
        r4.b(new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P0));
        return;
    }

    public final void shouldResetPerfBySwitchClose(boolean r1) {
        this.resetPerfBySwitchClose = r1;
    }

    public static final /* synthetic */ void access$resetExpState(NewExpContext r0, ExpBizPerfObserver r1) {
        r0.resetExpState(r1);
    }

    public Disposable registerExpBizListener(l61.b r9, g61.a r11) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r11, "listener");
        SimpleAlogArgsBuilder r0 = new SimpleAlogArgsBuilder();
        r0.d(getTag());
        r0.c(r9.getDesc() + " 业务注册了体验性能回调");
        ExpOptLog.d(r0.b());
        Pair<ExpBizPerfObserver, Disposable> r1 = this.bizPerfListeners.get(r9);
        if (r1 == null) goto L6;
        Disposable r2 = (Disposable) r1.getSecond();
        if (r2 == null) goto L6;
        return r2;
    L6:
        ExpBizPerfObserver r3 = new ExpBizPerfObserver(r9, r11);
        Disposable r12 = Disposables.fromAction(new a(r3, m558getDispatch().a.a().subscribe(new b(r3)), this, r9, r11));
        this.bizPerfListeners.put(r9, TuplesKt.to(r3, r12));
        return r12;
    }

    public void unregisterExpBizListener(l61.b r3, g61.a r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Pair<ExpBizPerfObserver, Disposable> r5 = this.bizPerfListeners.get(r3);
        if (r5 == null) goto L8;
        Disposable r6 = (Disposable) r5.getSecond();
        if (r6 == null) goto L9;
        SimpleAlogArgsBuilder r0 = new SimpleAlogArgsBuilder();
        r0.d(getTag());
        r0.c(r3.getDesc() + " 业务反注册了体验性能回调");
        ExpOptLog.d(r0.b());
        r6.dispose();
        return;
    L9:
        return;
    }
}
