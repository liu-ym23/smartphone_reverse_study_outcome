package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/datamergev2/LinkRoomFightWindowListHelperV2;", "Lcom/bytedance/android/live/liveinteract/plantform/datamergev2/WindowListHelperV2;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRoomFightWindowListHelperV2 extends WindowListHelperV2 {
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d m;
    public final eh0.b n;

    public static final class a<T1, T2, R> implements BiFunction {
        public final /* synthetic */ LinkRoomFightWindowListHelperV2 a;

        public a(LinkRoomFightWindowListHelperV2 r1) {
            this.a = r1;
        }

        public final Object apply(Object r3, Object r4) {
            List r5 = (List) r3;
            List r6 = (List) r4;
            Intrinsics.checkNotNullParameter(r5, "list");
            Intrinsics.checkNotNullParameter(r6, "remoteList");
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelperV2", "linkedUserMergeDataListObservable and remoteLinkedUserMergeDataListObservable change, size: self " + r5.size() + " remote " + r6.size());
            this.a.u();
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LinkRoomFightWindowListHelperV2 a;

        public c(LinkRoomFightWindowListHelperV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "specialStubListObservable change, size: " + r4.size());
            this.a.u();
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.WindowListHelperV2, com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void u() {
        int r0 = this.h.a;
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1.add(g(r3));
        r3 = r3 + 1;
        goto L3
    L5:
        com.bytedance.live.datacontext.m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L11;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L11;
        String r6 = r5.getOwnerUserIdString();
        if (r6 == null) goto L11;
    L12:
        List<ch0.e> r7 = (List) this.m.f().getValue();
        if (r7 != null) goto L15;
        r7 = new ArrayList();
    L15:
        i(r6, r1, r7, r0);
        i(r6, r1, this.n.d(), r0);
        int r8 = r1.size();
    L16:
        if (r2 >= r8) goto L18;
        ((tf0.e) ListProtector.get(r1, r2)).b = r2;
        r2 = r2 + 1;
        goto L16
    L18:
        y(r1);
        v((IVoiceLiveTheme) this.m.G0().getValue(), r1);
        this.b.onNext(r1);
        ALogger.i("WindowListHelper", "updateWindowList, size: " + r1.size());
        return;
    L11:
        r6 = "";
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.WindowListHelperV2
    public final void x() {
        RxUtilKt.c(Observable.combineLatest(this.m.f(), this.n.h(), new a(this)).subscribe(b.a), this.c);
        RxUtilKt.c(this.m.g().subscribe(new c(this)), this.c);
    }

    public LinkRoomFightWindowListHelperV2(IRoom r12, DataCenter r13, boolean r14, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r15, com.bytedance.android.live.liveinteract.plantform.datamerge.k r16, com.bytedance.android.live.liveinteract.plantform.datamerge.d r17, eh0.b r18, int r19) {
        Intrinsics.checkNotNullParameter(r15, "layoutConfig");
        Intrinsics.checkNotNullParameter(r16, "windowConfig");
        Intrinsics.checkNotNullParameter(r17, "linkUserDataMergeCenter");
        Intrinsics.checkNotNullParameter(r18, "linkRoomFightDataMergeCenter");
        super(r12, r13, r14, r15, r16, r17, r19);
        this.m = r17;
        this.n = r18;
    }
}
