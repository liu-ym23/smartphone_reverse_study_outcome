package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.v2;
import com.bytedance.android.live.liveinteract.plantform.model.u0;
import com.bytedance.android.live.liveinteract.plantform.model.v0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b {
    public com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a b;
    public final List<ch0.j> c;
    public final Map<String, Boolean> d;
    public final long e;
    public SeiAppData f;
    public final AtomicLong g;
    public final BehaviorSubject<SeiAppData> h;
    public final CompositeDisposable i;
    public boolean j;
    public final b k;
    public eg6.b l;
    public final com.bytedance.android.live.liveinteract.plantform.datamergev2.d m;
    public final DataCenter n;

    public static final class a {
    }

    public static final class b extends eg6.a {
        public final /* synthetic */ p a;

        public b(p r1) {
            this.a = r1;
        }

        public final void i(String r10) {
            p r11 = this.a;
            if ((!((ArrayList) r11.c).isEmpty()) == false) goto L9;
            gh0.a.b("SeiHandlerV3", "clear", 4);
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r3 = r11.m;
            if (r3 == null) goto L7;
            r3.m("SeiHandlerV3", r11.hashCode(), "clear", false, false);
        L7:
            ((ArrayList) r11.c).clear();
            ((LinkedHashMap) r11.d).clear();
            r11.a().h1(r11.d);
            r11.c();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.j = false;
        this.i.clear();
        eg6.b r0 = this.l;
        if (r0 == null) goto L6;
        r0.s(this.k);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        if (this.j == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.j = true;
        eg6.b r1 = this.l;
        if (r1 == null) goto L8;
        r1.h0(this.k);
    L8:
        Observable r2 = this.h.distinctUntilChanged().map(new w(this)).share();
        Observable r3 = r2.filter(u.a).map(v.a);
        Observable r4 = r2.filter(x.a).map(y.a).sample(this.e, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        this.i.add(r3.filter(new q(this)).subscribe(new r(this)));
        this.i.add(r4.filter(new s(this)).subscribe(new t(this)));
        if (MultiLinkLoadWidgetUtils.g() == true) goto L11;
    L13:
        r0 = false;
    L15:
        if (r0 == true) goto L64;
    L37:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r5 = this.m;
        if (r5 != null) goto L40;
        return;
    L40:
        if (r5.getShowFrom() != 0) goto L69;
        IRoomModuleService r6 = jc1.k.f(IRoomModuleService.class);
        long r7 = 0;
        if (r6 == null) goto L51;
        com.bytedance.android.livesdk.chatroom.room.backend.g r8 = r6.getLiveRoomBackendUtils();
        if (r8 == null) goto L51;
        Room r9 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.n, null, 2).getCurrentRoom();
        if (r9 == null) goto L49;
        long r10 = r9.getId();
    L50:
        r8.f(r10, u0.class, new SeiHandlerV3$initSeiAppData$1(this));
        goto L51
    L49:
        r10 = 0;
    L51:
        IRoomModuleService r11 = jc1.k.f(IRoomModuleService.class);
        if (r11 == null) goto L67;
        com.bytedance.android.livesdk.chatroom.room.backend.g r12 = r11.getLiveRoomBackendUtils();
        if (r12 == null) goto L68;
        com.bytedance.android.livesdk.chatroom.o r13 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.n, null, 2);
        if (r13 == null) goto L62;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L62;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L62;
        r7 = r15.getId();
    L62:
        r12.f(r7, v0.class, new SeiHandlerV3$initSeiAppData$2(this));
        return;
    L68:
        return;
    L67:
        return;
    L69:
        return;
    L64:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r16 = this.m;     // Catch: Exception -> L35
        if (r16 == null) goto L19;
        DataCenter r17 = this.n;     // Catch: Exception -> L35
        r16.getShowFrom();     // Catch: Exception -> L35
        ILivePlayerClient r18 = r16.o(r17);     // Catch: Exception -> L35
    L20:
        if (r18 == null) goto L24;
        LivePlayerClientContext r19 = r18.context();     // Catch: Exception -> L35
        if (r19 == null) goto L24;
        String r20 = r19.getLastLayoutSei();     // Catch: Exception -> L35
    L25:
        DataCenter r21 = this.n;     // Catch: Exception -> L35
        StringBuilder r22 = new StringBuilder("showFrom=");     // Catch: Exception -> L35
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r23 = this.m;     // Catch: Exception -> L35
        if (r23 == null) goto L28;
        Integer r24 = Integer.valueOf(r23.getShowFrom());     // Catch: Exception -> L35
    L29:
        r22.append(r24);     // Catch: Exception -> L35
        r22.append(" initSeiAppData with lastLayoutSei ");     // Catch: Exception -> L35
        r22.append(r20);     // Catch: Exception -> L35
        MultiLinkLoadWidgetUtils.n(r21, "SeiHandlerV3", r22.toString());     // Catch: Exception -> L35
        if (r20 == null) goto L37;
        JSONObject r25 = new JSONObject(r20);     // Catch: Exception -> L35
        if (r25.has("app_data") == false) goto L37;
        String r26 = StringsKt.replace$default(JSONObjectProtectorUtils.getString(r25, "app_data"), "\\\\", "", false, 4, null);     // Catch: Exception -> L35
        d(com.bytedance.android.live.liveinteract.api.utils.j.a(new JSONObject(r26), r26));     // Catch: Exception -> L35
        goto L37
    L28:
        r24 = null;
    L24:
        r20 = null;
        goto L25
    L19:
        r18 = null;
    L35:
        e = move-exception;
        ALogger.e("SeiHandlerV3", "initSeiAppData error", e);
        goto L37
    L11:
        if (vm2.h.W().lastLayoutSei() == false) goto L13;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a b(List<ch0.e> r13) {
        Intrinsics.checkNotNullParameter(r13, "oldMergeDataList");
        List<ch0.j> r0 = this.c;
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = ((ArrayList) r0).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r2 = r1.next();
        r3.put(((ch0.j) r2).a, r2);
        goto L4
    L6:
        List<ch0.e> r14 = r13;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
        boolean r5 = false;
        ch0.e r6 = null;
    L8:
        if (r15.hasNext() == false) goto L23;
        ch0.e r7 = (ch0.e) r15.next();
        ch0.j r9 = (ch0.j) r3.get(r7.a.getInteractId());
        if (r7.d(r9) == false) goto L12;
        boolean r8 = r5;
        ch0.e r10 = r7;
    L13:
        IBaseUser r11 = r10.a.getUser();
        if (r11 == null) goto L16;
        String r12 = r11.getIdString();
    L18:
        if (Intrinsics.areEqual(r12, gh0.a.c()) == false) goto L21;
        if (r10 == r7) goto L21;
        r6 = r10;
    L21:
        r4.add(r10);
        r5 = r8;
        goto L8
    L16:
        r12 = null;
        goto L18
    L12:
        r10 = ch0.e.a(r7, null, null, r9, null, 11);
        r8 = true;
        goto L13
    L23:
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a(r5, r4, r6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b
    public final void d(SeiAppData r4) {
        Intrinsics.checkNotNullParameter(r4, "sei");
        List r0 = r4.getGrids();
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L6:
        if (r1 <= 0) goto L13;
        List r2 = r4.getGrids();
        if (r2 == null) goto L13;
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        SeiRegion r5 = (SeiRegion) r3.next();
        r5.getInteractId();
        r5.isTalking();
    L13:
        this.h.onNext(r4);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b
    public final void e(eg6.b r3) {
        eg6.b r0 = this.l;
        if (r0 == null) goto L5;
        r0.s(this.k);
    L5:
        this.l = r3;
        if (this.j == false) goto L10;
        if (r3 == null) goto L11;
        r3.h0(this.k);
        return;
    L11:
        return;
    }

    public p(eg6.b r1, com.bytedance.android.live.liveinteract.plantform.datamergev2.d r2, DataCenter r3) {
        this.l = r1;
        this.m = r2;
        this.n = r3;
        this.b = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a(0, 0, 0, 0);
        this.c = new ArrayList();
        this.d = new LinkedHashMap();
        this.e = ((MultiLinkFrequencyOptConfig) v2.a.getValue()).getSeiHandlerSamplingIntervalMs();
        this.g = new AtomicLong(-1);
        this.h = BehaviorSubject.create();
        this.i = new CompositeDisposable();
        this.k = new b(this);
    }
}
