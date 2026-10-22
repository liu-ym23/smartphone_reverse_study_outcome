package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import android.text.TextUtils;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.ai.GiftAsyncSortManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdatePanelGiftSearch;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.a2;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.util.GiftListFetchAction;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ ca0.w i;
    public final /* synthetic */ ReceiverType j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ List l;
    public final /* synthetic */ Integer m;
    public final /* synthetic */ long n;
    public final /* synthetic */ String o;
    public final /* synthetic */ String p;
    public final /* synthetic */ IEpisode q;
    public final /* synthetic */ long r;
    public final /* synthetic */ boolean s;
    public final /* synthetic */ boolean t;
    public final /* synthetic */ int u;
    public final /* synthetic */ long v;
    public final /* synthetic */ Ref.LongRef w;
    public final /* synthetic */ int x;
    public final /* synthetic */ Map y;
    public final /* synthetic */ GiftListFetchAction z;

    public v(int r4, String r5, boolean r6, long r7, long r9, boolean r11, int r13, int r14, ca0.w r15, ReceiverType r16, boolean r17, List r18, Integer r19, long r110, String r21, String r23, IEpisode r24, long r25, boolean r26, boolean r27, int r28, long r29, Ref.LongRef r31, int r33, Map r34, GiftListFetchAction r35) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r9;
        this.f = r11;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r110;
        this.o = r21;
        this.p = r23;
        this.q = r24;
        this.r = r25;
        this.s = r26;
        this.t = r27;
        this.u = r28;
        this.v = r29;
        this.w = r31;
        this.x = r33;
        this.y = r34;
        this.z = r35;
    }

    public final void accept(Object r46) {
        ExtraResponse r1 = (ExtraResponse) r46;
        long r14 = System.currentTimeMillis();
        String r2 = null;
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.model.i r3 = (com.bytedance.android.livesdk.gift.platform.core.model.i) r1.data;
    L6:
        boolean r4 = false;
        if (r3 == null) goto L109;
        long r5 = r1.extra.now;
        if (this.a == 17) goto L11;
    L13:
        boolean r6 = false;
    L14:
        GiftListRepo r16 = GiftListRepo.k;
        int r7 = this.a;
        r16.getClass();
        if (r7 == 16) goto L17;
    L19:
        if (r7 == 16) goto L23;
        if (r7 == 15) goto L23;
    L33:
        boolean r8 = false;
    L34:
        if (r8 == false) goto L42;
        Observable<Unit> r9 = Observable.empty().doOnSubscribe(new m((com.bytedance.android.livesdk.gift.platform.core.model.i) r1.data, this.c, this.d, this.e, this.f, this.a, this.g, this.h, r5, this.i, this.j, GiftListRepo.b, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, r1.logId));
        i12.e r10 = i12.o.b();
        if (r10 == null) goto L38;
        Object r11 = com.bytedance.android.scope.m.e.d(r10, e1.class);
    L39:
        e1 r13 = (e1) r11;
        if (r13 == null) goto L75;
        Intrinsics.checkNotNullParameter(r9, "observable");
        r13.b = r9;
    L75:
        if (this.k == true) goto L116;
        if (r6 == true) goto L116;
        if (this.a != 11) goto L80;
        GiftAsyncSortManager r15 = (GiftAsyncSortManager) GiftAsyncSortManager.e.getValue();
        String r17 = r1.logId;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r17, "logId");
        r15.a.put("logId", r17);
        mz0.n r18 = new mz0.n();
        Map r19 = r18.a;
        Intrinsics.checkNotNullParameter(r19, "map");
        HashMap<String, String> r20 = r15.a;
        Intrinsics.checkNotNullParameter(r20, "map");
        r19.putAll(r20);
        mz0.m r21 = new mz0.m();
        r21.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r23 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r23, "pageSourceLog");
        ((ArrayList) r21.a).add(r23.a);
        ((ArrayList) r18.b).addAll(r21.a);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r25);
        ((f80.a) r25).w3("livesdk_gift_ai_async_sort", r18.a, r18.b);
        r15.a.clear();
    L80:
        GiftListRepo r26 = GiftListRepo.k;
        GiftListRepo.c = this.a;
        String r27 = r1.logId;
        r26.getClass();
        if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L116;
        GiftContext r28 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r28 == null) goto L87;
        com.bytedance.live.datacontext.n<Boolean> r29 = r28.isContinuous();
        if (r29 == null) goto L87;
        Boolean r30 = (Boolean) r29.getValue();
    L88:
        if (r30 == null) goto L103;
        GiftContext r31 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r31 == null) goto L94;
        com.bytedance.live.datacontext.n<Boolean> r33 = r31.isContinuous();
        if (r33 == null) goto L94;
        Boolean r34 = (Boolean) r33.getValue();
    L96:
        if (Intrinsics.areEqual(r34, Boolean.FALSE) == true) goto L103;
        GiftContext r35 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r35 == null) goto L102;
        com.bytedance.live.datacontext.m<String> r36 = r35.getGiftListResultLogId();
        if (r36 == null) goto L102;
        r2 = (String) r36.getValue();
    L102:
        if (r2 != null) goto L116;
    L94:
        r34 = null;
    L103:
        GiftContext r37 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r37 == null) goto L116;
        com.bytedance.live.datacontext.m<String> r38 = r37.getGiftListResultLogId();
        if (r38 == null) goto L116;
        r38.setValue(r27);
    L87:
        r30 = null;
    L116:
        if (this.k == false) goto L118;
        ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).f1(this.u, this.c);
    L119:
        long r39 = System.currentTimeMillis();
        long r40 = this.v;
        long r110 = r39 - r40;
        if (this.t == false) goto L123;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.U(this.a, r40, this.w.element, r14, GiftListRepo.d, this.x, this.y, ((com.bytedance.android.livesdk.gift.platform.core.model.i) r1.data).fetchStrategy, this.z.getValue());
        com.bytedance.android.livesdk.gift.platform.core.c0 r41 = com.bytedance.android.livesdk.gift.platform.core.c0.a;
        com.bytedance.android.livesdk.gift.platform.core.c0.e(r110, this.g);
    L123:
        StringBuilder r43 = new StringBuilder("handle list response, src=");
        r43.append(this.a);
        r43.append(" reqTimes=");
        GiftListRepo r44 = GiftListRepo.k;
        r43.append(GiftListRepo.d);
        r43.append(" total=");
        r43.append(System.currentTimeMillis() - this.v);
        r43.append(" api=");
        r43.append(this.w.element - this.v);
        r43.append(" schedule=");
        r43.append(r14 - this.w.element);
        r43.append('/');
        r44.getClass();
        r43.append(((Boolean) GiftListRepo.f.getValue()).booleanValue());
        r43.append(" resp=");
        r43.append(System.currentTimeMillis() - r14);
        jy0.b.d("ttlive_gift_list", r43.toString());
        return;
    L118:
        GiftListRepo.k.getClass();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g.a(((Boolean) GiftListRepo.j.getValue()).booleanValue(), new GiftListRepo$syncGiftList$6$1(this));
        goto L119
    L38:
        r11 = null;
        goto L39
    L42:
        if (r6 == false) goto L73;
        com.bytedance.android.livesdk.gift.platform.core.model.i r45 = (com.bytedance.android.livesdk.gift.platform.core.model.i) r1.data;
        r16.getClass();
        GiftListRepo.d(r45);
        i12.d r47 = i12.m.e2.a();
        if (r47 == null) goto L46;
        Object r48 = com.bytedance.android.scope.m.e.d(r47, com.bytedance.android.livesdk.gift.platform.core.giftlist.f.class);
    L47:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.f r49 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.f) r48;
        if (r49 == null) goto L75;
        com.bytedance.android.livesdk.gift.platform.core.model.i r50 = (com.bytedance.android.livesdk.gift.platform.core.model.i) r1.data;
        ReceiverType r51 = this.j;
        Intrinsics.checkNotNullParameter(r50, "response");
        Intrinsics.checkNotNullParameter(r51, "receiverType");
        r49.a.clear();
        List<? extends h1> r53 = r50.giftList;
        if (r53 != null) goto L52;
    L53:
        r4 = true;
    L54:
        if (r4 == false) goto L58;
        uz1.a r54 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r54 == null) goto L75;
        r54.a(new UpdatePanelGiftSearch(r49.a, r50.eventTrack));
        goto L75
    L58:
        List<? extends h1> r55 = r50.giftList;
        if (r55 == null) goto L70;
        ArrayList r56 = new ArrayList();
        Iterator<T> r57 = r55.iterator();
    L62:
        if (r57.hasNext() == false) goto L66;
        T r58 = r57.next();
        if (r49.b.g((h1) r58, r51) == false) goto L62;
        r56.add(r58);
        goto L62
    L66:
        Iterator r59 = r56.iterator();
    L68:
        if (r59.hasNext() == false) goto L70;
        r49.a.add((h1) r59.next());
    L70:
        ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).y(r49.a);
        uz1.a r60 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r60 == null) goto L75;
        r60.a(new UpdatePanelGiftSearch(r49.a, r50.eventTrack));
        goto L75
    L52:
        if (r53.isEmpty() == false) goto L54;
    L46:
        r48 = null;
        goto L47
    L73:
        GiftListRepo.a(r16, (com.bytedance.android.livesdk.gift.platform.core.model.i) r1.data, this.c, this.d, this.e, this.a, this.g, this.h, r5, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, r1.logId);
    L23:
        if (com.bytedance.android.livesdk.gift.platform.business.i.l().q4() == false) goto L33;
        i12.d r61 = i12.m.e2.a();
        if (r61 == null) goto L27;
        Object r63 = com.bytedance.android.scope.m.e.d(r61, a2.class);
    L28:
        a2 r64 = (a2) r63;
        if (r64 == null) goto L33;
        if (r64.b != true) goto L33;
    L32:
        r8 = true;
        goto L34
    L27:
        r63 = null;
        goto L28
    L17:
        if (com.bytedance.android.livesdk.gift.platform.business.i.l().q4() == true) goto L19;
    L11:
        if (TextUtils.isEmpty(this.b) == true) goto L13;
        r6 = true;
        goto L14
    L109:
        if (this.t == false) goto L116;
        com.bytedance.android.livesdk.gift.platform.core.c0 r65 = com.bytedance.android.livesdk.gift.platform.core.c0.a;
        if (r1 != null) goto L113;
        String r66 = "response is empty";
    L114:
        r65.d(r66, 0, this.g);
        goto L116
    L113:
        r66 = "response.data is empty";
        goto L114
    L5:
        r3 = null;
        goto L6
    }
}
