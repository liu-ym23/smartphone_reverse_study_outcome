package com.bytedance.android.live.liveinteract.plantform.datamerge;

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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkMicGameWindowHelper extends l {
    public final f p;
    public final d q;
    public final eh0.b r;

    public static final class a {
    }

    public static final class b<T1, T2, R> implements BiFunction {
        public final /* synthetic */ LinkMicGameWindowHelper a;

        public b(LinkMicGameWindowHelper r1) {
            this.a = r1;
        }

        public final Object apply(Object r3, Object r4) {
            List r5 = (List) r3;
            List r6 = (List) r4;
            Intrinsics.checkNotNullParameter(r5, "list");
            Intrinsics.checkNotNullParameter(r6, "remoteList");
            if (this.a.a == false) goto L6;
            ALogger.i("LinkMicGameWindowHelper", "linkedUserMergeDataListObservable and remoteLinkedUserMergeDataListObservable change, size: self " + r5.size() + " remote " + r6.size());
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

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.l
    public final void x() {
        RxUtilKt.c(Observable.combineLatest(this.q.f(), this.r.h(), new b(this)).subscribe(c.a), this.c);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void d() {
        super.d();
        MainThreadPostUtils.d(this.p.f);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void i(String r3, List<tf0.e> r4, List<ch0.e> r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        Intrinsics.checkNotNullParameter(r4, "windowList");
        Intrinsics.checkNotNullParameter(r5, "linkedUserMergeDataList");
        List<ch0.e> r0 = this.r.d();
        ArrayList r1 = new ArrayList();
        r1.addAll(r5);
        r1.addAll(r0);
        this.p.a(r3, r4, r1, r6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void l(List<tf0.e> r3, List<ch0.e> r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "windowList");
        Intrinsics.checkNotNullParameter(r4, "linkedUserMergeDataList");
        Intrinsics.checkNotNullParameter(r6, "anchorId");
        List<ch0.e> r0 = this.r.d();
        ArrayList r1 = new ArrayList();
        r1.addAll(r4);
        r1.addAll(r0);
        this.p.b(r3, r1, r5, r6);
    }

    public LinkMicGameWindowHelper(IRoom r13, final DataCenter r14, boolean r15, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r16, k r17, d r18, eh0.b r19) {
        Intrinsics.checkNotNullParameter(r16, "layoutConfig");
        Intrinsics.checkNotNullParameter(r17, "windowConfig");
        Intrinsics.checkNotNullParameter(r18, "linkUserDataMergeCenter");
        Intrinsics.checkNotNullParameter(r19, "linkMicGameDataMergeCenter");
        super(r13, r14, r15, r16, r17, r18);
        this.q = r18;
        this.r = r19;
        this.p = new f(r13, r14, r15, r16, this, r18, r19, 0, new LinkMicGameWindowHelper$linkMicGameWindowHelperExt$1(r14));
    }
}
