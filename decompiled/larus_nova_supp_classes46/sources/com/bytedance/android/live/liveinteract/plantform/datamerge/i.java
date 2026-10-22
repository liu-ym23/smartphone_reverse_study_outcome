package com.bytedance.android.live.liveinteract.plantform.datamerge;

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
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends l {
    public final d p;
    public final eh0.b q;

    public static final class a<T1, T2, R> implements BiFunction {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final Object apply(Object r3, Object r4) {
            List r5 = (List) r3;
            List r6 = (List) r4;
            Intrinsics.checkNotNullParameter(r5, "list");
            Intrinsics.checkNotNullParameter(r6, "remoteList");
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "linkedUserMergeDataListObservable and remoteLinkedUserMergeDataListObservable change, size: self " + r5.size() + " remote " + r6.size());
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

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.l, com.bytedance.android.live.liveinteract.plantform.datamerge.a
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
        List<ch0.e> r7 = (List) this.p.f().getValue();
        if (r7 != null) goto L15;
        r7 = new ArrayList();
    L15:
        i(r6, r1, r7, r0);
        i(r6, r1, this.q.d(), r0);
        switch(this.g.getUiLayout()) {
            case 56: goto L36;
            case 57: goto L28;
            case 58: goto L18;
            default: goto L44;
        };
    L18:
        Iterator r8 = r1.iterator();
    L20:
        if (r8.hasNext() == false) goto L44;
        tf0.e r9 = (tf0.e) r8.next();
        int r10 = r9.a;
        if (1 > r10) goto L24;
        if (5 < r10) goto L24;
    L27:
        r9.j = false;
    L24:
        if (7 > r10) goto L20;
        if (11 < r10) goto L20;
    L28:
        Iterator r11 = r1.iterator();
    L30:
        if (r11.hasNext() == false) goto L44;
        tf0.e r12 = (tf0.e) r11.next();
        int r13 = r12.a;
        if (7 > r13) goto L30;
        if (11 < r13) goto L30;
        r12.j = false;
        goto L30
    L36:
        Iterator r14 = r1.iterator();
    L38:
        if (r14.hasNext() == false) goto L44;
        tf0.e r15 = (tf0.e) r14.next();
        int r16 = r15.a;
        if (1 > r16) goto L38;
        if (5 < r16) goto L38;
        r15.j = false;
    L44:
        int r17 = r1.size();
    L45:
        if (r2 >= r17) goto L47;
        ((tf0.e) ListProtector.get(r1, r2)).b = r2;
        r2 = r2 + 1;
        goto L45
    L47:
        A(r1);
        z(r1);
        B(r1);
        v((IVoiceLiveTheme) this.p.G0().getValue(), r1);
        y(r1);
        this.b.onNext(r1);
        ALogger.i("WindowListHelper", "updateWindowList, size: " + r1.size());
        return;
    L11:
        r6 = "";
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.l
    public final void x() {
        RxUtilKt.c(Observable.combineLatest(this.p.f(), this.q.h(), new a(this)).subscribe(b.a), this.c);
    }

    public i(IRoom r2, DataCenter r3, boolean r4, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5, k r6, d r7, eh0.b r8) {
        Intrinsics.checkNotNullParameter(r5, "layoutConfig");
        Intrinsics.checkNotNullParameter(r6, "windowConfig");
        Intrinsics.checkNotNullParameter(r7, "linkUserDataMergeCenter");
        Intrinsics.checkNotNullParameter(r8, "linkRoomFightDataMergeCenter");
        super(r2, r3, r4, r5, r6, r7);
        this.p = r7;
        this.q = r8;
    }
}
