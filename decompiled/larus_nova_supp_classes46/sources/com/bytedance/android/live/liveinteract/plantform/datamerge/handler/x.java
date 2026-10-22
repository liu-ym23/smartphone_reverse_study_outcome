package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.model.u0;
import com.bytedance.android.live.liveinteract.plantform.model.v0;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b {
    public com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a b;
    public final List<ch0.j> c;
    public final CompositeDisposable d;
    public boolean e;
    public final c f;
    public eg6.b g;
    public final DataCenter h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ x a;

        public b(x r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ch0.d r2 = (ch0.d) r1;
            this.a.a().l1().getClass();
        }
    }

    public static final class c extends eg6.a {
        public final /* synthetic */ x a;

        public c(x r1) {
            this.a = r1;
        }

        public final void i(String r4) {
            x r5 = this.a;
            if ((!((ArrayList) r5.c).isEmpty()) == false) goto L6;
            gh0.a.b("SeiHandlerV1", "clear", 4);
            ((ArrayList) r5.c).clear();
            r5.c();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.d.clear();
        eg6.b r0 = this.g;
        if (r0 == null) goto L5;
        r0.s(this.f);
    L5:
        this.e = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        RxUtilKt.c(a().a1().subscribe(new b(this)), this.d);
        eg6.b r0 = this.g;
        if (r0 == null) goto L5;
        r0.h0(this.f);
    L5:
        IRoomModuleService r1 = jc1.k.f(IRoomModuleService.class);
        long r2 = 0;
        if (r1 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.room.backend.g r3 = r1.getLiveRoomBackendUtils();
        if (r3 == null) goto L14;
        Room r5 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.h, null, 2).getCurrentRoom();
        if (r5 == null) goto L12;
        long r6 = r5.getId();
    L13:
        r3.f(r6, u0.class, new SeiHandlerV1$initSeiAppData$1(this));
        goto L14
    L12:
        r6 = 0;
    L14:
        IRoomModuleService r4 = jc1.k.f(IRoomModuleService.class);
        if (r4 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.room.backend.g r7 = r4.getLiveRoomBackendUtils();
        if (r7 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.o r8 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.h, null, 2);
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L25;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L25;
        r2 = r10.getId();
    L25:
        r7.f(r2, v0.class, new SeiHandlerV1$initSeiAppData$2(this));
    L26:
        this.e = true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r13) {
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
        return new h.a(r5, r4, r6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b
    public final void d(SeiAppData r18) {
        Intrinsics.checkNotNullParameter(r18, "sei");
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.h, null, 2).getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L7;
        String r3 = String.valueOf(r2.getId());
    L9:
        if ((!Intrinsics.areEqual(r18.getChannelId(), r3)) == false) goto L13;
        ALogger.d("SeiHandlerV1", "sei channel id wrong " + r18.getChannelId() + " room " + r3);
        return;
    L13:
        if (this.b.a == r18.getVersion()) goto L15;
    L20:
        this.b = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a(r18.getVersion(), r18.getUiLayout(), r18.getStyle(), r18.getSubUILayout());
        a().C0(this.b);
    L21:
        ArrayList r4 = new ArrayList();
        int r5 = r18.getGrids().size();
        int r6 = 0;
        boolean r7 = false;
    L22:
        if (r6 >= r5) goto L45;
        SeiRegion r8 = (SeiRegion) ListProtector.get(r18.getGrids(), r6);
        Iterator r9 = ((ArrayList) this.c).iterator();
    L25:
        if (r9.hasNext() == false) goto L29;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((ch0.j) r10).a, r8.getInteractId()) == false) goto L25;
    L30:
        ch0.j r11 = (ch0.j) r10;
        if (r11 != null) goto L33;
        r4.add(new ch0.j(r8.getInteractId(), r8.isTalking(), r8.getType(), r8.position, r8.isVisible()));
    L43:
        r7 = true;
    L44:
        r6 = r6 + 1;
        goto L22
    L33:
        if (r8.getType() == r11.c) goto L35;
    L41:
        r4.add(ch0.j.a(r11, r8.isTalking(), r8.getType(), r8.position, r8.isVisible(), 1));
        goto L43
    L35:
        if (r8.position != r11.d) goto L41;
        if (r8.isTalking() != r11.b) goto L41;
        if (r8.isVisible() != r11.e) goto L41;
        r4.add(r11);
        goto L44
    L29:
        r10 = null;
        goto L30
    L45:
        if (r7 == false) goto L47;
    L48:
        ((ArrayList) this.c).clear();
        ((ArrayList) this.c).addAll(r4);
    L49:
        if (r7 == false) goto L58;
        c();
        return;
    L58:
        return;
    L47:
        if (r4.isEmpty() == false) goto L49;
    L15:
        if (this.b.b != r18.getUiLayout()) goto L20;
        if (this.b.c != r18.getStyle()) goto L20;
        if (this.b.d == r18.getSubUILayout()) goto L21;
    L7:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b
    public final void e(eg6.b r3) {
        eg6.b r0 = this.g;
        if (r0 == null) goto L5;
        r0.s(this.f);
    L5:
        this.g = r3;
        if (this.e == false) goto L10;
        if (r3 == null) goto L11;
        r3.h0(this.f);
        return;
    L11:
        return;
    }

    public x(eg6.b r1, DataCenter r2) {
        this.g = r1;
        this.h = r2;
        this.b = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a(0, 0, 0, 0);
        this.c = new ArrayList();
        this.d = new CompositeDisposable();
        this.f = new c(this);
    }
}
