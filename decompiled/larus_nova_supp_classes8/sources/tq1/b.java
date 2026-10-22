package tq1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.vs_base.api.ReplayListApi;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final NextLiveData<List<EpisodeGroup>> a;
    public long b;
    public boolean c;
    public Throwable d;
    public final List<EpisodeGroup> e;
    public final CompositeDisposable f;
    public final NextLiveData<Boolean> g;
    public final NextLiveData<Boolean> h;
    public boolean i;
    public final long j;
    public final long k;
    public final mq1.b l;

    public static final class a {
    }

    /* JADX INFO: renamed from: tq1.b$b, reason: collision with other inner class name */
    public static final class C0416b<T, R> implements Function {
        public static final C0416b a = null;

        static {
            a = new C0416b();
        }

        public C0416b() {
        }

        public final Object apply(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return ((ReplayListApi.ReplayListData) ((BaseResponse) r3).data).getAllReplayGroup();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            List r8 = (List) r7;
            b r0 = this.a;
            r0.c = true;
            r0.d = null;
            ((ArrayList) r0.e).clear();
            if (r8 == null) goto L16;
            List<EpisodeGroup> r2 = r0.e;
            ArrayList r3 = new ArrayList();
            Iterator<T> r9 = r8.iterator();
        L6:
            if (r9.hasNext() == false) goto L15;
            T r4 = r9.next();
            List r5 = ((EpisodeGroup) r4).episodes;
            if (r5 != null) goto L10;
        L12:
            boolean r6 = false;
        L13:
            if (r6 == false) goto L6;
            r3.add(r4);
            goto L6
        L10:
            if (r5.isEmpty() == true) goto L12;
            r6 = true;
            goto L13
        L15:
            ((ArrayList) r2).addAll(r3);
        L16:
            r0.l.onListDataChanged(r0.e);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ALogger.e("ReplayPlayListProvider", "get play list error", r4);
            b r0 = this.a;
            r0.c = true;
            r0.d = r4;
            r0.l.onPullDataFailed(r4);
        }
    }

    static {
    }

    public final List<Episode> b() {
        List<EpisodeGroup> r0 = this.e;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        List r3 = ((EpisodeGroup) r2.next()).episodes;
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        r1.add(r3);
        goto L4
    L10:
        return CollectionsKt.flatten(r1);
    }

    public final Observable<List<EpisodeGroup>> c() {
        Observable<Response<ReplayListApi.ReplayListData>> r0 = ((ReplayListApi) r.n().getService(ReplayListApi.class)).getReplayList(this.j, this.k);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.map(C0416b.a);
    }

    public final void d() {
        Observable<List<EpisodeGroup>> r0 = c();
        if (r0 == null) goto L12;
        Observable r1 = r0.subscribeOn(Schedulers.io());
        if (r1 == null) goto L13;
        Observable r2 = r1.observeOn(AndroidSchedulers.mainThread());
        if (r2 == null) goto L14;
        Disposable r3 = r2.subscribe(new c(this), new d(this));
        if (r3 == null) goto L15;
        RxUtilKt.c(r3, this.f);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final Episode a(long r10) {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L24;
        Object r1 = r0.next();
        List r5 = ((EpisodeGroup) r1).episodes;
        if (r5 == null) goto L21;
        List r6 = r5;
        if ((r6 instanceof Collection) == true) goto L10;
    L12:
        Iterator r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L21;
        if (((Episode) r7.next()).getId() != r10) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == false) goto L14;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L4;
    L25:
        EpisodeGroup r2 = (EpisodeGroup) r1;
        if (r2 == null) goto L29;
        List r3 = r2.episodes;
        if (r3 == null) goto L29;
    L31:
        if (r10 > 0) goto L33;
        return null;
    L33:
        if (r3.isEmpty() == true) goto L64;
        Iterator r4 = r3.iterator();
        boolean r11 = false;
    L37:
        if (r4.hasNext() == false) goto L45;
        Episode r12 = (Episode) r4.next();
        if (r11 == true) goto L63;
        if (r12.getId() != r10) goto L37;
        r11 = true;
        goto L37
    L63:
        return r12;
    L45:
        return (Episode) ListProtector.get(r3, 0);
    L64:
        return null;
    L29:
        r3 = CollectionsKt.emptyList();
        goto L31
    L18:
        r8 = false;
        goto L19
    L10:
        if (r6.isEmpty() == false) goto L12;
    L21:
        r9 = false;
        goto L22
    L24:
        r1 = null;
        goto L25
    }

    public b(long r2, long r4, mq1.b r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.j = r2;
        this.k = r4;
        this.l = r6;
        this.a = new NextLiveData();
        this.e = new ArrayList();
        this.f = new CompositeDisposable();
        this.g = new NextLiveData();
        this.h = new NextLiveData();
        d();
    }
}
