package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/datamergev2/LinkMicGameWindowHelperV2;", "Lcom/bytedance/android/live/liveinteract/plantform/datamergev2/WindowListHelperV2;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkMicGameWindowHelperV2 extends WindowListHelperV2 {
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.f m;
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d n;
    public final eh0.b o;

    public static final class a {
    }

    public static final class b<T1, T2, R> implements BiFunction {
        public final /* synthetic */ LinkMicGameWindowHelperV2 a;

        public b(LinkMicGameWindowHelperV2 r1) {
            this.a = r1;
        }

        public final Object apply(Object r3, Object r4) {
            List r5 = (List) r3;
            List r6 = (List) r4;
            Intrinsics.checkNotNullParameter(r5, "list");
            Intrinsics.checkNotNullParameter(r6, "remoteList");
            if (this.a.a == false) goto L6;
            ALogger.i("LinkMicGameWindowHelperV2", "linkedUserMergeDataListObservable and remoteLinkedUserMergeDataListObservable change, size: self " + r5.size() + " remote " + r6.size());
            this.a.u();
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LinkMicGameWindowHelperV2 a;

        public d(LinkMicGameWindowHelperV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Map r3 = (Map) r2;
            LinkMicGameWindowHelperV2 r4 = this.a;
            if (r4.a == false) goto L6;
            r4.u();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.WindowListHelperV2
    public final void x() {
        RxUtilKt.c(Observable.combineLatest(this.n.f(), this.o.h(), new b(this)).subscribe(c.a), this.c);
        RxUtilKt.c(this.o.o().subscribe(new d(this)), this.c);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.WindowListHelperV2, com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void d() {
        super.d();
        MainThreadPostUtils.d(this.m.f);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void i(String r3, List<tf0.e> r4, List<ch0.e> r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        Intrinsics.checkNotNullParameter(r4, "windowList");
        Intrinsics.checkNotNullParameter(r5, "linkedUserMergeDataList");
        List<ch0.e> r0 = this.o.d();
        ArrayList r1 = new ArrayList();
        r1.addAll(r5);
        r1.addAll(r0);
        this.m.a(r3, r4, r1, r6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void l(List<tf0.e> r3, List<ch0.e> r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "windowList");
        Intrinsics.checkNotNullParameter(r4, "linkedUserMergeDataList");
        Intrinsics.checkNotNullParameter(r6, "anchorId");
        List<ch0.e> r0 = this.o.d();
        ArrayList r1 = new ArrayList();
        r1.addAll(r4);
        r1.addAll(r0);
        this.m.b(r3, r1, r5, r6);
    }

    public LinkMicGameWindowHelperV2(IRoom r15, DataCenter r16, boolean r17, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r18, com.bytedance.android.live.liveinteract.plantform.datamerge.k r19, com.bytedance.android.live.liveinteract.plantform.datamerge.d r20, eh0.b r21, int r22) {
        Intrinsics.checkNotNullParameter(r18, "layoutConfig");
        Intrinsics.checkNotNullParameter(r19, "windowConfig");
        Intrinsics.checkNotNullParameter(r20, "linkUserDataMergeCenter");
        Intrinsics.checkNotNullParameter(r21, "linkMicGameDataMergeCenter");
        super(r15, r16, r17, r18, r19, r20, r22);
        this.n = r20;
        this.o = r21;
        this.m = new com.bytedance.android.live.liveinteract.plantform.datamerge.f(r15, r16, r17, r18, this, r20, r21, r22, new LinkMicGameWindowHelperV2$linkMicGameWindowHelperExt$1(this));
    }
}
