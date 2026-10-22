package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.GiftTopicClickType;
import com.bytedance.android.livesdk.gift.model.c1;
import com.bytedance.android.livesdk.gift.model.c3;
import com.bytedance.android.livesdk.gift.model.d2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListCacheRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.MostlyUsedGiftOperateAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.q0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.model.e0;
import com.bytedance.android.livesdk.gift.platform.core.model.u;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.sort.GiftStickerSortService;
import com.bytedance.android.livesdk.gift.platform.core.utils.FindInnerScopeSetting;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.gift.util.GiftListFetchAction;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdk.utils.u2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftListRepository implements i, xc6.c, com.bytedance.android.scope.o {
    public Map<Long, ? extends LinkedHashMap<Integer, h1>> a;
    public com.bytedance.android.livesdk.gift.platform.core.model.l b;
    public int c;
    public List<k> d;
    public final List<k> e;
    public h1 f;
    public final Map<Long, h1> g;
    public final Map<Long, h1> h;
    public final Map<Long, h1> i;
    public Map<String, Long> j;
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.a k;
    public Pair<? extends List<? extends w1>, Long> l;
    public Map<String, Long> m;
    public long n;
    public final GiftListCacheRepo o;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b p;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final com.bytedance.android.livesdk.gift.platform.core.model.j N3() {
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.p.getValue()).booleanValue() == true) goto L5;
        d.a("GiftListRepository", "get global list cache, currentReceiverType, cache is empty " + this.b.a.isEmpty());
    L5:
        Pair<? extends List<? extends w1>, Long> r0 = this.l;
        if (r0 != null) goto L8;
    L28:
        List r2 = SequencesKt.toList(SequencesKt.map(CollectionsKt.asSequence(this.b.a), new GiftListRepository$getOriginGiftPageList$giftPages$1(this)));
        this.l = TuplesKt.to(r2, Long.valueOf(SystemClock.uptimeMillis()));
        com.bytedance.android.livesdk.gift.platform.core.model.l r1 = this.b;
        return new com.bytedance.android.livesdk.gift.platform.core.model.j(r2, r1.b, r1.c, r1.d, r1.e);
    L8:
        if (((Boolean) GiftPanelBizBoostUtils.D.getValue()).booleanValue() == false) goto L18;
        long r3 = SystemClock.uptimeMillis();
        Pair<? extends List<? extends w1>, Long> r4 = this.l;
        if (r4 == null) goto L14;
        Long r5 = (Long) r4.getSecond();
        if (r5 == null) goto L14;
        long r6 = r5.longValue();
    L16:
        if ((r3 - r6) >= 60000) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L22;
        r0 = null;
    L22:
        if (r0 == null) goto L28;
        List r8 = (List) r0.getFirst();
        if (r8 != null) goto L26;
        r8 = CollectionsKt.emptyList();
    L26:
        com.bytedance.android.livesdk.gift.platform.core.model.l r9 = this.b;
        return new com.bytedance.android.livesdk.gift.platform.core.model.j(r8, r9.b, r9.c, r9.d, r9.e);
    L14:
        r6 = 0;
    L18:
        r7 = false;
        goto L19
    }

    public final boolean f() {
        if (this.b.a.isEmpty() == false) goto L5;
        return false;
    L5:
        com.bytedance.android.livesdk.gift.platform.core.model.l r0 = this.b;
        if (r0.c != 99) goto L9;
        return false;
    L9:
        return !r0.a.isEmpty();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final py.k f3() {
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r0 = this.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final Map<String, String> getExtraParam() {
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r0 = this.k;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.model.g r1 = r0.b;
        if (r1 == null) goto L7;
        return r1.a();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final List<h1> getStickerGifts() {
        Collection<? extends LinkedHashMap<Integer, h1>> r0 = this.a.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        CollectionsKt.addAll(r1, ((LinkedHashMap) r2.next()).values());
        goto L4
    L6:
        ArrayList r3 = new ArrayList();
        Iterator r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L16;
        Object r5 = r4.next();
        if (((h1) r5).getType() != 4) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L8;
        r3.add(r5);
        goto L8
    L12:
        r6 = false;
        goto L13
    L16:
        return CollectionsKt.toMutableList(r3);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final boolean isGiftListLoaded() {
        return !this.b.a.isEmpty();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final com.bytedance.android.livesdk.gift.platform.core.model.d j0() {
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r0 = this.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final List<com.bytedance.android.livesdk.gift.platform.core.model.e> q() {
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r0 = this.k;
        if (r0 == null) goto L7;
        List<com.bytedance.android.livesdk.gift.platform.core.model.e> r1 = r0.c;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public static h a() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, h.class);
    L7:
        return (h) r1;
    L5:
        r1 = null;
        goto L7
    }

    public final String J5() {
        return F5(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f());
    }

    public final void clearGiftMemoryCache() {
        Map<Long, ? extends LinkedHashMap<Integer, h1>> r0 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.a = r0;
        com.bytedance.android.livesdk.gift.platform.core.model.l r1 = new com.bytedance.android.livesdk.gift.platform.core.model.l(CollectionsKt.emptyList(), 0, 0, 0, BuildConfig.FLAVOR);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.b = r1;
        this.d.clear();
        ((ArrayList) this.e).clear();
        this.l = null;
        ((LinkedHashMap) this.m).clear();
        ((LinkedHashMap) this.i).clear();
        ((LinkedHashMap) this.j).clear();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final int N0() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final long c5() {
        return this.n;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final Map<String, Long> n3() {
        return this.m;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final com.bytedance.android.livesdk.gift.platform.core.model.l n5() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final void F(List<? extends h1> r5) {
        Intrinsics.checkNotNullParameter(r5, "giftList");
        ((LinkedHashMap) this.g).clear();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        h1 r0 = (h1) r6.next();
        this.g.put(Long.valueOf(r0.getId()), r0);
        goto L4
    L6:
        jy0.b.d("GiftListRepository", "update gifts to props binding gifts");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final String F5(int r4) {
        Iterator<T> r0 = this.b.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((j) r1).a != r4) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        j r3 = (j) r1;
        if (r3 == null) goto L16;
        String r5 = r3.b;
        if (r5 == null) goto L16;
        return r5;
    L16:
        return "礼物";
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final GiftListFetchAction K3(int r3) {
        if (r3 == 2) goto L24;
        if (r3 != 3) goto L7;
        i12.e r4 = i12.o.b();
        if (r4 == null) goto L13;
        Object r5 = com.bytedance.android.scope.m.e.d(r4, GiftDataStorageService.class);
    L14:
        GiftDataStorageService r6 = (GiftDataStorageService) r5;
        if (r6 == null) goto L17;
        int r7 = r6.p;
    L18:
        if (r7 != 0) goto L22;
        return GiftListFetchAction.FETCH_ACTION_FIRST_OPEN_GIFT_PANEL;
    L22:
        return GiftListFetchAction.FETCH_ACTION_DEFAULT;
    L17:
        r7 = 0;
        goto L18
    L13:
        r5 = null;
        goto L14
    L7:
        if (r3 == 15) goto L24;
        return GiftListFetchAction.FETCH_ACTION_DEFAULT;
    L24:
        if (f() == true) goto L28;
        return GiftListFetchAction.FETCH_ACTION_FIRST_ENTER_ROOM;
    L28:
        return GiftListFetchAction.FETCH_ACTION_DEFAULT;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final void R(int r1) {
        this.c = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final w1 U(int r4) {
        Iterator<T> r0 = N3().c.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((w1) r1).getPageType() != r4) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L13:
        return (w1) r1;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final void X(h1 r1) {
        this.f = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final h1 d(String r9) {
        Intrinsics.checkNotNullParameter(r9, "comment");
        Object r1 = null;
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return null;
    L5:
        Set r0 = ((LinkedHashMap) this.j).entrySet();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r0.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        if (StringsKt.equals(r9, (String) ((Map.Entry) r4).getKey(), true) == false) goto L7;
        r2.add(r4);
        goto L7
    L11:
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r5 = r2.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        r10.add(o4(((Number) ((Map.Entry) r5.next()).getValue()).longValue(), null));
        goto L13
    L15:
        Iterator r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L37;
        Object r6 = r11.next();
        h1 r7 = (h1) r6;
        boolean r8 = false;
        if (r7 == null) goto L34;
        if (r7.isDisplayedOnPanel() == false) goto L34;
        Intrinsics.checkNotNullParameter(r7, "$this$resourceNotDownLoad");
        if (r7.getType() == 2) goto L29;
        if (r7.getType() == 8) goto L29;
        if (r7.getType() == 11) goto L29;
    L31:
        boolean r13 = false;
    L32:
        if (r13 == true) goto L34;
        r8 = true;
    L29:
        if (((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).g1(r7.getPrimaryEffectId()) == true) goto L31;
        r13 = true;
    L34:
        if (r8 == false) goto L17;
        r1 = r6;
    L37:
        return (h1) r1;
    }

    public final void g(u r4) {
        if (r4 == null) goto L19;
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r0 = this.k;
        if (r0 == null) goto L6;
        List<com.bytedance.android.livesdk.gift.platform.core.model.e> r1 = r4.getGiftComboInfoList();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.c = r1;
    L6:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r2 = this.k;
        if (r2 == null) goto L9;
        r2.a = r4.getGiftEntranceIcon();
    L9:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r3 = this.k;
        if (r3 == null) goto L12;
        r3.b = r4.getExtraParam();
    L12:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r5 = this.k;
        if (r5 == null) goto L15;
        r5.d = r4.getGiftSearchConfig();
    L15:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r6 = this.k;
        if (r6 == null) goto L20;
        r6.e = r4.getGiftAgentConfig();
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final void h3(Map<Integer, com.bytedance.android.livesdk.gift.platform.core.model.i> r20) {
        Intrinsics.checkNotNullParameter(r20, "giftResultMap");
        if ((!this.b.a.isEmpty()) == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, com.bytedance.android.livesdk.gift.platform.core.model.i>> r1 = r20.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L63;
        com.bytedance.android.livesdk.gift.platform.core.model.i r2 = r1.next().getValue();
        long r6 = System.currentTimeMillis();
        List<? extends w1> r4 = r2.giftPages;
        if (r4 != null) goto L11;
        r4 = CollectionsKt.emptyList();
    L11:
        Intrinsics.checkNotNullParameter(r4, "giftPages");
        Intrinsics.checkNotNullParameter("local", "logId");
        ReceiverType r13 = ReceiverType.Anchor;
        LinkedHashMap r14 = new LinkedHashMap();
        LinkedHashMap r15 = new LinkedHashMap();
        if (v.b() == true) goto L14;
    L22:
        List<? extends w1> r3 = r4;
        com.bytedance.android.livesdk.gift.platform.core.model.l r16 = new com.bytedance.android.livesdk.gift.platform.core.model.l(SequencesKt.toList(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(r3), GiftListRepository$updateGiftListCache$1.INSTANCE), GiftListRepository$updateGiftListCache$2.INSTANCE)), r6, 99, -2, "local");
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        this.b = r16;
        this.l = null;
        d.a("GiftListRepository", "update global list cache, currentReceiverType" + r13);
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<T> r5 = r3.iterator();
    L24:
        if (r5.hasNext() == false) goto L62;
        w1 r8 = (w1) r5.next();
        List<h1> r9 = r8.getGifts();
        List<c3> r10 = r8.getSectionList();
        if (r10 == null) goto L31;
        Collection r11 = new ArrayList();
        Iterator<T> r17 = r10.iterator();
    L29:
        if (r17.hasNext() == false) goto L32;
        CollectionsKt.addAll(r11, ((c3) r17.next()).d());
    L32:
        Iterator r18 = CollectionsKt.plus(r9, r11).iterator();
    L34:
        if (r18.hasNext() == false) goto L24;
        h1 r19 = (h1) r18.next();
        Long r110 = Long.valueOf(r19.getId());
        LinkedHashMap r111 = (LinkedHashMap) r14.get(Long.valueOf(r19.getId()));
        if (r111 != null) goto L38;
        r111 = new LinkedHashMap();
    L38:
        r111.put(Integer.valueOf(r8.getPageType()), r19);
        Unit r21 = Unit.INSTANCE;
        r14.put(r110, r111);
        String r23 = r19.getName();
        if ((!TextUtils.isEmpty(r23)) == true) goto L42;
        r23 = null;
    L42:
        if (r23 != null) goto L44;
        r23 = r19.getDescribe();
    L44:
        if (r23 != null) goto L47;
        r23 = BuildConfig.FLAVOR;
    L47:
        if (r23.length() <= 0) goto L49;
        boolean r112 = true;
    L50:
        if (r112 == false) goto L52;
        r7.put(r23, Long.valueOf(r19.getId()));
    L52:
        List<String> r24 = r19.getTriggerWords();
        if ((!r24.isEmpty()) == true) goto L56;
        r24 = null;
    L56:
        if (r24 == null) goto L34;
        Iterator<T> r25 = r24.iterator();
    L59:
        if (r25.hasNext() == false) goto L34;
        r15.put((String) r25.next(), Long.valueOf(r19.getId()));
        goto L59
    L49:
        r112 = false;
        goto L50
    L31:
        r11 = CollectionsKt.emptyList();
        goto L32
    L62:
        this.m = r7;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        this.a = r14;
        this.j = r15;
        d.a("GiftListRepository", "update global gift cache, currentReceiverType" + r13);
        g(r2.giftsInfo);
        goto L7
    L14:
        if (v.g() == false) goto L22;
        i12.e r26 = i12.o.b();
        if (r26 == null) goto L18;
        Object r27 = com.bytedance.android.scope.m.e.d(r26, q0.class);
    L19:
        q0 r28 = (q0) r27;
        if (r28 == null) goto L22;
        r28.d(r4);
        goto L22
    L18:
        r27 = null;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final void s5(List<? extends h1> r5) {
        Intrinsics.checkNotNullParameter(r5, "giftList");
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        h1 r0 = (h1) r6.next();
        this.h.put(Long.valueOf(r0.getId()), r0);
        goto L4
    L6:
        jy0.b.d("GiftListRepository", "insert gift to hiding gifts");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final void y(List<? extends h1> r5) {
        Intrinsics.checkNotNullParameter(r5, "giftList");
        ((LinkedHashMap) this.i).clear();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        h1 r0 = (h1) r6.next();
        this.i.put(Long.valueOf(r0.getId()), r0);
        goto L4
    L6:
        jy0.b.d("GiftListRepository", "insert  gift to search result");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final h1 y3(long r3) {
        LinkedHashMap<Integer, h1> r4 = this.a.get(Long.valueOf(r3));
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.size() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r4 = null;
    L11:
        if (r4 != null) goto L13;
        return null;
    L13:
        return r4.get(1);
    L7:
        r0 = false;
        goto L8
    }

    public GiftListRepository(GiftListCacheRepo r9, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r10) {
        Intrinsics.checkNotNullParameter(r9, "listGlobalCacheRepo");
        Intrinsics.checkNotNullParameter(r10, "fastGiftCacheRepo");
        this.o = r9;
        this.p = r10;
        this.a = MapsKt.emptyMap();
        this.b = new com.bytedance.android.livesdk.gift.platform.core.model.l(CollectionsKt.emptyList(), 0, 0, 0, BuildConfig.FLAVOR);
        this.c = 1;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
        this.j = new LinkedHashMap();
        this.k = new com.bytedance.android.livesdk.gift.platform.core.giftlist.a(CollectionsKt.emptyList());
        this.m = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final h1 o4(long r19, Integer r21) {
        int r2 = 0;
        h1 r3 = null;
        h1 r0 = z1(r19, r21);     // Catch: Exception -> L21
        if (r0 != null) goto L6;
        r0 = (h1) ((LinkedHashMap) this.g).get(Long.valueOf(r19));     // Catch: Exception -> L21
    L6:
        if (r0 != null) goto L8;
        r0 = (h1) ((LinkedHashMap) this.h).get(Long.valueOf(r19));     // Catch: Exception -> L21
    L8:
        if (r0 != null) goto L18;
        r0 = this.f;     // Catch: Exception -> L21
        if (r0 != null) goto L12;
    L17:
        r0 = null;
        goto L18
    L12:
        if (r0.getId() != r19) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
    L14:
        r4 = false;
    L18:
        if (r0 != null) goto L20;
        r0 = (h1) ((LinkedHashMap) this.i).get(Long.valueOf(r19));     // Catch: Exception -> L21
    L20:
        r3 = r0;
    L23:
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.e() == true) goto L39;
        if (r3 != null) goto L39;
        boolean r1 = d0.a;
        yz0.k r5 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r5 == null) goto L31;
        IRoom r6 = r5.getRoom();
        if (r6 == null) goto L31;
        r2 = (int) r6.getRoomLayout();
    L31:
        String r7 = z.a("ttlive_find_gift_fail_status");
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        JSONObject r10 = new JSONObject();
        Intrinsics.checkNotNullParameter(r10, "extra");
        Intrinsics.checkNotNullParameter(r9, "metric");
        EventModule r11 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r11, "eventModule");
        String r13 = r11.getValue();
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter("status_code", "key");
        Intrinsics.checkNotNullParameter(12, "value");
        r8.put("status_code", 12);
        Intrinsics.checkNotNullParameter(r9, "map");
        Long r14 = Long.valueOf(r19);
        Intrinsics.checkNotNullParameter("gift_id", "key");
        Intrinsics.checkNotNullParameter(r14, "value");
        r9.put("gift_id", r14);
        Integer r15 = Integer.valueOf(r2);
        Intrinsics.checkNotNullParameter("liveType", "key");
        Intrinsics.checkNotNullParameter(r15, "value");
        r9.put("liveType", r15);
        yz0.k r16 = d0.b();
        if (r16 == null) goto L34;
        long r17 = r16.Hl();
    L36:
        if (r17 <= 0) goto L38;
        Long r18 = Long.valueOf(System.currentTimeMillis() - r17);
        Intrinsics.checkNotNullParameter("enter_duration", "key");
        Intrinsics.checkNotNullParameter(r18, "value");
        r9.put("enter_duration", r18);
    L38:
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r20).b(n97.a.class);
        Intrinsics.checkNotNull(r23);
        ((com.bytedance.live.kmp.core.c) r23).g(r7, r13, "bussiness_api_call", r8, r9, r10);
        Unit r24 = Unit.INSTANCE;
        goto L39
    L34:
        r17 = 0;
    L39:
        return r3;
    L21:
        e = move-exception;
        jy0.b.a("GiftListRepository", "findGiftById exception: " + e.getMessage());
        goto L23
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final h1 z1(long r2, Integer r4) {
        LinkedHashMap<Integer, h1> r3 = this.a.get(Long.valueOf(r2));
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.size() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L18;
        if (r4 == null) goto L16;
        h1 r5 = r3.get(Integer.valueOf(r4.intValue()));
        if (r5 == null) goto L16;
        return r5;
    L16:
        return (h1) ((Map.Entry) CollectionsKt.last(r3.entrySet())).getValue();
    L18:
        return null;
    L7:
        r0 = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final void N(long r16, int r18, @MostlyUsedGiftOperateAction int r19, ReceiverType r20) {
        Intrinsics.checkNotNullParameter(r20, "receiverType");
        Iterator<T> r1 = this.b.a.iterator();
    L3:
        Object r9 = null;
        if (r1.hasNext() == false) goto L11;
        Object r4 = r1.next();
        if (((j) r4).a != 17) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L3;
    L12:
        j r5 = (j) r4;
        if (r5 != null) goto L15;
    L82:
        h r2 = a();
        if (r2 == null) goto L107;
        r2.N(r16, r18, r19, r20);
        return;
    L107:
        return;
    L15:
        if (r19 == 1) goto L52;
        if (r19 != 2) goto L82;
        List<Long> r13 = CollectionsKt.toMutableList(r5.l);
        r13.remove(Long.valueOf(r16));
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r5.l = r13;
        Map<Long, ? extends LinkedHashMap<Integer, h1>> r6 = MapsKt.toMutableMap(this.a);
        LinkedHashMap<Integer, h1> r14 = r6.get(Long.valueOf(r16));
        if (r14 == null) goto L22;
        h1 r15 = r14.remove(17);
    L22:
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.a = r6;
        Pair<? extends List<? extends w1>, Long> r3 = this.l;
        if (r3 == null) goto L82;
        List r7 = (List) r3.getFirst();
        if (r7 == null) goto L82;
        Iterator r8 = r7.iterator();
    L28:
        if (r8.hasNext() == false) goto L35;
        Object r10 = r8.next();
        if (((w1) r10).getPageType() != 17) goto L32;
        boolean r17 = true;
    L33:
        if (r17 == false) goto L28;
    L36:
        w1 r21 = (w1) r10;
        if (r21 == null) goto L82;
        Iterator<T> r23 = r21.getGifts().iterator();
    L40:
        if (r23.hasNext() == false) goto L47;
        Object r110 = r23.next();
        if (((h1) r110).getId() != r16) goto L44;
        boolean r111 = true;
    L45:
        if (r111 == false) goto L40;
        r9 = r110;
        goto L47
    L44:
        r111 = false;
    L47:
        h1 r24 = (h1) r9;
        if (r24 == null) goto L82;
        List<? extends h1> r25 = CollectionsKt.toMutableList(r21.getGifts());
        r25.remove(r24);
        Unit r26 = Unit.INSTANCE;
        r21.setGifts(r25);
        goto L82
    L32:
        r17 = false;
        goto L33
    L35:
        r10 = null;
        goto L36
    L52:
        if (r5.l.contains(Long.valueOf(r16)) == true) goto L54;
        List<Long> r112 = CollectionsKt.toMutableList(r5.l);
        ListProtector.add(r112, 0, Long.valueOf(r16));
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r5.l = r112;
    L54:
        h1 r27 = o4(r16, Integer.valueOf(r18));
        if (r27 != null) goto L57;
        return;
    L57:
        Map<Long, ? extends LinkedHashMap<Integer, h1>> r113 = MapsKt.toMutableMap(this.a);
        Long r114 = Long.valueOf(r16);
        LinkedHashMap<Integer, h1> r115 = r113.get(Long.valueOf(r16));
        if (r115 != null) goto L60;
        r115 = new LinkedHashMap();
    L60:
        r115.put(17, r27);
        Unit r116 = Unit.INSTANCE;
        r113.put(r114, r115);
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        this.a = r113;
        Pair<? extends List<? extends w1>, Long> r28 = this.l;
        if (r28 == null) goto L82;
        List r29 = (List) r28.getFirst();
        if (r29 == null) goto L82;
        Iterator r30 = r29.iterator();
    L66:
        if (r30.hasNext() == false) goto L73;
        Object r117 = r30.next();
        if (((w1) r117).getPageType() != 17) goto L70;
        boolean r118 = true;
    L71:
        if (r118 == false) goto L66;
        r9 = r117;
        goto L73
    L70:
        r118 = false;
    L73:
        w1 r31 = (w1) r9;
        if (r31 == null) goto L82;
        List<h1> r33 = r31.getGifts();
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator<T> r35 = r33.iterator();
    L77:
        if (r35.hasNext() == false) goto L80;
        r34.add(Long.valueOf(((h1) r35.next()).getId()));
        goto L77
    L80:
        if (r34.contains(Long.valueOf(r16)) == true) goto L82;
        List<? extends h1> r36 = CollectionsKt.toMutableList(r31.getGifts());
        ListProtector.add(r36, 0, r27);
        Unit r37 = Unit.INSTANCE;
        r31.setGifts(r36);
        goto L82
    L8:
        r11 = false;
        goto L9
    L11:
        r4 = null;
        goto L12
    }

    public final Observable D4(String r9, String r10, int r11, int r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r9, "roomId");
        Intrinsics.checkNotNullParameter(r10, "toRoomId");
        return Observable.create(new e(r9, r10, r11, r13, r14, r15));
    }

    public final void x4(GiftReceiverRepoService.j r13, String r14, String r15, int r16, boolean r17, String r18, String r19) {
        Intrinsics.checkNotNullParameter(r14, "roomId");
        Intrinsics.checkNotNullParameter(r15, "toRoomId");
        n01.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r0 == null) goto L5;
        Episode r1 = r0.jf();
    L6:
        long r3 = u2.a(r14);
        long r7 = u2.a(r15);
        GiftListRepo.i(r13, r3, r7, r16, 3, r17, r18, r19, r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v37, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v38, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v53, types: [java.util.ArrayList, java.util.Collection] */
    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.i
    public final void J2(com.bytedance.android.livesdk.gift.platform.core.model.i r34, int r35, int r36, boolean r37, List<? extends w1> r38, ReceiverType r39, boolean r40, List<Long> r41, Integer r43, long r44, long r45, String r47) {
        String r14 = "response";
        Intrinsics.checkNotNullParameter(r34, "response");
        Intrinsics.checkNotNullParameter(r38, "giftPages");
        Intrinsics.checkNotNullParameter(r39, "receiverType");
        Intrinsics.checkNotNullParameter(r47, "logId");
        Long r4 = r34.fetchStrategy;
        if (r4 == null) goto L5;
        long r5 = r4.longValue();
    L6:
        this.n = r5;
        boolean r18 = false;
        long r19 = -1;
        if (r40 == false) goto L142;
        Iterator r6 = r34.giftPages.iterator();
    L10:
        if (r6.hasNext() == false) goto L20;
        Object r7 = r6.next();
        int r8 = ((w1) r7).getPageType();
        if (r43 != null) goto L15;
    L17:
        boolean r9 = false;
    L18:
        if (r9 == false) goto L10;
    L21:
        w1 r10 = (w1) r7;
        if (r10 == null) goto L40;
        List<h1> r11 = r10.getGifts();
        if (r11 == null) goto L40;
        ArrayList r13 = new ArrayList();
        Iterator r15 = r11.iterator();
    L27:
        if (r15.hasNext() == false) goto L42;
        Object r16 = r15.next();
        h1 r17 = (h1) r16;
        if (r41 == null) goto L31;
        boolean r20 = r41.contains(Long.valueOf(r17.getId()));
    L32:
        if (r20 == false) goto L34;
    L37:
        boolean r21 = true;
    L38:
        if (r21 == false) goto L27;
        r13.add(r16);
        goto L27
    L34:
        if (r17.isDisplayedOnPanel() == false) goto L37;
        r21 = false;
        goto L38
    L31:
        r20 = false;
    L42:
        if (r44 <= 0) goto L77;
        Iterator r23 = ((ArrayList) this.e).iterator();
    L45:
        if (r23.hasNext() == false) goto L52;
        Object r24 = r23.next();
        if (((k) r24).a != r44) goto L49;
        boolean r25 = true;
    L50:
        if (r25 == false) goto L45;
        Object r26 = r24;
    L53:
        k r27 = (k) r26;
        if (r27 == null) goto L114;
        if (r13 != null) goto L57;
    L60:
        boolean r28 = true;
    L61:
        if (r28 == false) goto L63;
        List<Long> r29 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r27.e = r29;
    L72:
        if (r41 == null) goto L76;
        Long r3 = (Long) CollectionsKt.last(r41);
        if (r3 == null) goto L76;
        r19 = r3.longValue();
    L76:
        r27.d = r19;
        goto L114
    L63:
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r31 = r13.iterator();
    L65:
        if (r31.hasNext() == false) goto L67;
        r30.add(Long.valueOf(((h1) r31.next()).getId()));
        goto L65
    L67:
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r27.e = r30;
        List<Long> r33 = r27.b;
        ArrayList r46 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r48 = r13.iterator();
    L69:
        if (r48.hasNext() == false) goto L71;
        r46.add(Long.valueOf(((h1) r48.next()).getId()));
        goto L69
    L71:
        r33.addAll(r46);
        goto L72
    L57:
        if (r13.isEmpty() == true) goto L60;
        r28 = false;
    L114:
        if (r13 != null) goto L116;
    L119:
        boolean r49 = true;
    L120:
        if (r49 == true) goto L141;
        Map<Long, ? extends LinkedHashMap<Integer, h1>> r50 = MapsKt.toMutableMap(this.a);
        Iterator r51 = r13.iterator();
    L124:
        if (r51.hasNext() == false) goto L140;
        h1 r53 = (h1) r51.next();
        if (r43 == null) goto L131;
        int r54 = r43.intValue();
        Long r55 = Long.valueOf(r53.getId());
        LinkedHashMap<Integer, h1> r56 = r50.get(Long.valueOf(r53.getId()));
        if (r56 != null) goto L130;
        r56 = new LinkedHashMap();
    L130:
        r56.put(Integer.valueOf(r54), r53);
        Unit r57 = Unit.INSTANCE;
        r50.put(r55, r56);
    L131:
        List<String> r58 = r53.getTriggerWords();
        if ((!r58.isEmpty()) == true) goto L135;
        r58 = null;
    L135:
        if (r58 == null) goto L124;
        Iterator r59 = r58.iterator();
    L138:
        if (r59.hasNext() == false) goto L124;
        this.j.put((String) r59.next(), Long.valueOf(r53.getId()));
        goto L138
    L140:
        Intrinsics.checkNotNullParameter(r50, "<set-?>");
        this.a = r50;
    L141:
        String r210 = "response";
    L284:
        if (r40 == true) goto L371;
        GiftListCacheRepo r2 = this.o;
        r2.getClass();
        String r60 = r210;
        Intrinsics.checkNotNullParameter(r34, r60);
        Intrinsics.checkNotNullParameter(r38, "giftPages");
        int r61 = r36;
        if (r61 != 0) goto L289;
    L287:
        int r63 = 1;
    L304:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r64 = this.p;
        r64.getClass();
        Intrinsics.checkNotNullParameter(r34, r60);
        if (r64.d == false) goto L307;
    L306:
        Object r65 = null;
    L364:
        i12.e r66 = i12.o.b();
        if (r66 == null) goto L367;
        Object r67 = com.bytedance.android.scope.m.e.d(r66, GiftStickerSortService.class);
    L368:
        GiftStickerSortService r68 = (GiftStickerSortService) r67;
        if (r68 == null) goto L372;
        r68.c(((gz0.a) r68.e.getValue()).K2());
    L372:
        g(r34.giftsInfo);
        if (r61 != 10) goto L375;
        return;
    L375:
        if (r61 == 11) goto L469;
        if (r40 == true) goto L380;
        h r1 = a();
        if (r1 == null) goto L470;
        r1.lm(r39, this.b, this.d, this.e, r36, r47);
        return;
    L470:
        return;
    L380:
        h r69 = a();
        if (r69 == null) goto L472;
        r69.t1(r39, r43, Long.valueOf(r44), this.b, this.d, this.e, r36, r47);
        return;
    L472:
        return;
    L469:
        return;
    L367:
        r67 = r65;
        goto L368
    L307:
        u r70 = r34.giftsInfo;
        if (r70 == null) goto L306;
        Intrinsics.checkNotNullParameter(r70, "giftsInfo");
        yz0.k r71 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r71 == null) goto L337;
        IRoom r73 = r71.getRoom();
        if (r73 == null) goto L337;
        e0 r74 = r70.getSpeedyGiftPopupInfo();
        if (r74 != null) goto L318;
    L326:
        if (r18 == false) goto L328;
        u r75 = r70;
    L329:
        if (r75 == null) goto L335;
        e0 r76 = r75.getSpeedyGiftPopupInfo();
        if (r76 == null) goto L333;
        r76.a = r75.getFirstChargeSpeedyGiftId();
        r64.a.put(Long.valueOf(r73.getId()), r76);
        Unit r77 = Unit.INSTANCE;
    L334:
        if (r77 != null) goto L337;
    L333:
        r77 = null;
    L335:
        r64.a.remove(Long.valueOf(r73.getId()));
        goto L337
    L328:
        r75 = null;
        goto L329
    L318:
        if (a1.j(r74.e()) == false) goto L326;
        if (a1.j(r74.c()) == false) goto L326;
        if (r74.b() == null) goto L326;
        if (r74.d() == null) goto L326;
        r18 = true;
    L337:
        if (Lists.isEmpty(r34.giftPages) == true) goto L339;
        ArrayList r78 = new ArrayList(r34.giftPages);
    L340:
        if (r61 == r63) goto L306;
        long r79 = r70.getFastGiftId();
        if (0 != r79) goto L344;
        xs2.b.a().post(new com.bytedance.android.livesdk.gift.platform.core.model.c());
        goto L306
    L344:
        ArrayList r80 = new ArrayList();
        Iterator r81 = r78.iterator();
    L346:
        if (r81.hasNext() == false) goto L348;
        r80.addAll(((w1) r81.next()).getGifts());
        goto L346
    L348:
        ArrayList r83 = new ArrayList(r80);
        h2 r84 = GiftManagerKt.l(r79);
        if (r84 != null) goto L351;
    L354:
        r65 = null;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.E.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[29])).booleanValue() == false) goto L357;
        com.bytedance.android.livesdk.gift.platform.core.utils.f.e(r83, r37, null);
    L357:
        Iterator r85 = r83.iterator();
    L359:
        if (r85.hasNext() == false) goto L363;
        h1 r86 = (h1) r85.next();
        if (r86.getId() != r79) goto L359;
        GiftManagerKt.z.getClass();
        GiftManagerKt.F(r86);
        xs2.b.a().post(new com.bytedance.android.livesdk.gift.platform.core.model.c(r86, 3));
        goto L364
    L363:
        xs2.b.a().post(new com.bytedance.android.livesdk.gift.platform.core.model.c());
        goto L364
    L351:
        if (r84.getType() != r63) goto L354;
        r65 = null;
        goto L357
    L339:
        r78 = new ArrayList();
        goto L340
    L289:
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().a() == true) goto L291;
        int r87 = r35;
        r63 = 1;
    L297:
        if (((Lists.isEmpty(r38) ? 1 : 0) ^ r63) == 0) goto L304;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.R.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[42])).booleanValue() == true) goto L301;
    L303:
        Single.create(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.l(r2, r34, r87)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        goto L304
    L301:
        if (((Boolean) FindInnerScopeSetting.a.getValue()).booleanValue() == false) goto L303;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.e.class).ni(new yz1.a(r34, r87, r2.c));
        goto L304
    L291:
        if (r2.c.contains(Integer.valueOf(r35)) == true) goto L287;
        r87 = r35;
        r63 = 1;
        if (r87 >= 0) goto L297;
    L371:
        r61 = r36;
        goto L372
    L116:
        if (r13.isEmpty() == true) goto L119;
        r49 = false;
        goto L120
    L49:
        r25 = false;
        goto L50
    L52:
        r26 = null;
        goto L53
    L77:
        Iterator r88 = this.d.iterator();
    L79:
        if (r88.hasNext() == false) goto L89;
        Object r89 = r88.next();
        long r90 = ((k) r89).a;
        if (r43 == null) goto L85;
        Object r410 = r89;
        if (r90 != r43.intValue()) goto L86;
        boolean r91 = true;
    L87:
        if (r91 == false) goto L79;
        Object r93 = r410;
    L90:
        k r94 = (k) r93;
        if (r94 == null) goto L114;
        if (r13 != null) goto L94;
    L97:
        boolean r95 = true;
    L98:
        if (r95 == false) goto L100;
        List<Long> r96 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r96, "<set-?>");
        r94.e = r96;
    L109:
        if (r41 == null) goto L113;
        Long r97 = (Long) CollectionsKt.last(r41);
        if (r97 == null) goto L113;
        r19 = r97.longValue();
    L113:
        r94.d = r19;
        goto L114
    L100:
        ArrayList r98 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r99 = r13.iterator();
    L102:
        if (r99.hasNext() == false) goto L104;
        r98.add(Long.valueOf(((h1) r99.next()).getId()));
        goto L102
    L104:
        Intrinsics.checkNotNullParameter(r98, "<set-?>");
        r94.e = r98;
        List<Long> r100 = r94.b;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r110 = r13.iterator();
    L106:
        if (r110.hasNext() == false) goto L108;
        r101.add(Long.valueOf(((h1) r110.next()).getId()));
        goto L106
    L108:
        r100.addAll(r101);
        goto L109
    L94:
        if (r13.isEmpty() == true) goto L97;
        r95 = false;
    L86:
        r91 = false;
        goto L87
    L85:
        r410 = r89;
        goto L86
    L89:
        r93 = null;
    L40:
        r13 = null;
        goto L42
    L15:
        if (r8 != r43.intValue()) goto L17;
        r9 = true;
        goto L18
    L20:
        r7 = null;
        goto L21
    L142:
        List<? extends w1> r102 = r34.giftPages;
        LinkedHashMap r111 = new LinkedHashMap();
        LinkedHashMap r103 = new LinkedHashMap();
        List<? extends w1> r211 = r102;
        com.bytedance.android.livesdk.gift.platform.core.model.l r104 = new com.bytedance.android.livesdk.gift.platform.core.model.l(SequencesKt.toList(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(r211), GiftListRepository$updateGiftListCacheForPagingOpt$1.INSTANCE), GiftListRepository$updateGiftListCacheForPagingOpt$2.INSTANCE)), System.currentTimeMillis(), r36, r45, r47);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.b = r104;
        this.l = null;
        d.a("GiftListRepository", "update global list cache, currentReceiverType" + r39);
        this.d = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(r211), GiftListRepository$updateGiftListCacheForPagingOpt$4.INSTANCE), GiftListRepository$updateGiftListCacheForPagingOpt$5.INSTANCE));
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator r106 = r211.iterator();
    L144:
        if (r106.hasNext() == false) goto L190;
        w1 r107 = (w1) r106.next();
        List<c1> r108 = r107.getBaseGifts();
        if (r108 == null) goto L153;
        ArrayList r109 = new ArrayList();
        Iterator r112 = r108.iterator();
    L149:
        if (r112.hasNext() == false) goto L154;
        h1 r113 = z1(((c1) r112.next()).getId(), Integer.valueOf(r107.getPageType()));
        if (r113 == null) goto L149;
        r109.add(r113);
    L154:
        List r114 = CollectionsKt.plus(r109, r107.getGifts());
        List<c3> r115 = r107.getSectionList();
        if (r115 == null) goto L160;
        List r116 = new ArrayList();
        Iterator r117 = r115.iterator();
    L158:
        if (r117.hasNext() == false) goto L161;
        CollectionsKt.addAll(r116, ((c3) r117.next()).d());
    L161:
        Iterator r118 = CollectionsKt.asSequence(CollectionsKt.plus(r114, r116)).iterator();
    L163:
        if (r118.hasNext() == false) goto L144;
        h1 r119 = (h1) r118.next();
        Long r120 = Long.valueOf(r119.getId());
        LinkedHashMap r121 = (LinkedHashMap) r111.get(Long.valueOf(r119.getId()));
        if (r121 != null) goto L167;
        r121 = new LinkedHashMap();
    L167:
        r121.put(Integer.valueOf(r107.getPageType()), r119);
        Unit r122 = Unit.INSTANCE;
        r111.put(r120, r121);
        List<String> r123 = r119.getTriggerWords();
        if ((!r123.isEmpty()) == true) goto L171;
        r123 = null;
    L171:
        if (r123 == null) goto L176;
        Iterator r124 = r123.iterator();
    L174:
        if (r124.hasNext() == false) goto L176;
        r103.put((String) r124.next(), Long.valueOf(r119.getId()));
    L176:
        String r125 = r119.getName();
        if ((!TextUtils.isEmpty(r125)) == true) goto L180;
        r125 = null;
    L180:
        if (r125 != null) goto L182;
        r125 = r119.getDescribe();
    L182:
        if (r125 != null) goto L185;
        r125 = BuildConfig.FLAVOR;
    L185:
        if (r125.length() <= 0) goto L187;
        boolean r126 = true;
    L188:
        if (r126 == false) goto L163;
        r105.put(r125, Long.valueOf(r119.getId()));
        goto L163
    L187:
        r126 = false;
        goto L188
    L160:
        r116 = CollectionsKt.emptyList();
        goto L161
    L153:
        r109 = new ArrayList();
        goto L154
    L190:
        this.m = r105;
        if (v.g() == false) goto L282;
        LinkedHashMap r127 = new LinkedHashMap();
        LinkedHashMap r128 = new LinkedHashMap();
        ArrayList r129 = new ArrayList();
        Iterator r130 = CollectionsKt.asSequence(r211).iterator();
    L194:
        if (r130.hasNext() == false) goto L260;
        w1 r131 = (w1) r130.next();
        Sequence r132 = SequencesKt.map(CollectionsKt.asSequence(r131.getTopicList()), GiftListRepository$generateTopicList$topicIds$1.INSTANCE);
        CollectionsKt.addAll(r129, r132);
        if (v.b() == false) goto L227;
        List<d2> r133 = r131.getTopicList();
        ArrayList r134 = new ArrayList();
        Iterator r135 = r133.iterator();
    L199:
        if (r135.hasNext() == false) goto L207;
        Object r136 = r135.next();
        Iterator r411 = r130;
        Iterator r412 = r135;
        if (((d2) r136).getClickType() != GiftTopicClickType.Recommend.getValue()) goto L203;
        boolean r137 = true;
    L204:
        if (r137 == false) goto L206;
        r134.add(r136);
    L206:
        r130 = r411;
        r135 = r412;
        goto L199
    L203:
        r137 = false;
        goto L204
    L207:
        Iterator r413 = r130;
        Iterator r138 = r134.iterator();
    L209:
        if (r138.hasNext() == false) goto L217;
        d2 r139 = (d2) r138.next();
        Long r140 = Long.valueOf(r139.getId());
        ArrayList r141 = new ArrayList();
        List<Integer> r142 = r139.getRelatedGiftIds();
        if (r142 == null) goto L216;
        Iterator r143 = r142.iterator();
    L214:
        if (r143.hasNext() == false) goto L216;
        Iterator r414 = r138;
        r141.add(Long.valueOf(((Number) r143.next()).intValue()));
        r138 = r414;
        r14 = r14;
    L216:
        Iterator r415 = r138;
        Unit r144 = Unit.INSTANCE;
        r127.put(r140, r141);
        r138 = r415;
        r14 = r14;
        goto L209
    L217:
        String r212 = r14;
        List<d2> r145 = r131.getTopicList();
        ArrayList r146 = new ArrayList();
        Iterator r147 = r145.iterator();
    L219:
        if (r147.hasNext() == false) goto L226;
        Object r148 = r147.next();
        if (((d2) r148).getClickType() != GiftTopicClickType.ClientDefault.getValue()) goto L223;
        boolean r149 = true;
    L224:
        if (r149 == false) goto L219;
        r146.add(r148);
        goto L219
    L223:
        r149 = false;
        goto L224
    L226:
        r132 = SequencesKt.map(CollectionsKt.asSequence(r146), GiftListRepository$generateTopicList$4.INSTANCE);
    L228:
        Iterator r150 = r131.getGifts().iterator();
    L230:
        if (r150.hasNext() == false) goto L243;
        h1 r151 = (h1) r150.next();
        Iterator r152 = r132.iterator();
    L233:
        if (r152.hasNext() == false) goto L230;
        long r153 = ((Number) r152.next()).longValue();
        if ((r151.getTopicId() & r153) <= 0) goto L233;
        Iterator r416 = r150;
        if (r127.get(Long.valueOf(r153)) == null) goto L241;
        List r154 = (List) r127.get(Long.valueOf(r153));
        if (r154 == null) goto L242;
        r154.add(Long.valueOf(r151.getId()));
    L242:
        r150 = r416;
        goto L233
    L241:
        Long r155 = Long.valueOf(r153);
        ArrayList r156 = new ArrayList();
        r156.add(Long.valueOf(r151.getId()));
        Unit r157 = Unit.INSTANCE;
        r127.put(r155, r156);
        goto L242
    L243:
        List<c1> r158 = r131.getBaseGifts();
        if (r158 == null) goto L259;
        Iterator r159 = r158.iterator();
    L247:
        if (r159.hasNext() == false) goto L259;
        c1 r160 = (c1) r159.next();
        Iterator r161 = r132.iterator();
    L250:
        if (r161.hasNext() == false) goto L247;
        long r162 = ((Number) r161.next()).longValue();
        if ((r160.getTopicId() & r162) <= 0) goto L250;
        if (r128.get(Long.valueOf(r162)) != null) goto L255;
        Long r163 = Long.valueOf(r162);
        ArrayList r164 = new ArrayList();
        r164.add(r160);
        Unit r165 = Unit.INSTANCE;
        r128.put(r163, r164);
        goto L250
    L255:
        List r166 = (List) r128.get(Long.valueOf(r162));
        if (r166 == null) goto L250;
        r166.add(r160);
    L259:
        r130 = r413;
        r14 = r212;
        goto L194
    L227:
        r413 = r130;
        r212 = r14;
        goto L228
    L260:
        r210 = r14;
        ArrayList r167 = new ArrayList();
        List r168 = CollectionsKt.distinct(r129);
        ArrayList r169 = new ArrayList();
        Iterator r170 = r168.iterator();
    L262:
        if (r170.hasNext() == false) goto L269;
        Object r171 = r170.next();
        if (((Number) r171).longValue() == (-1)) goto L266;
        boolean r172 = true;
    L267:
        if (r172 == false) goto L262;
        r169.add(r171);
        goto L262
    L266:
        r172 = false;
        goto L267
    L269:
        Iterator r173 = r169.iterator();
    L271:
        if (r173.hasNext() == false) goto L281;
        long r213 = ((Number) r173.next()).longValue();
        List r174 = (List) r127.get(Long.valueOf(r213));
        if (r174 != null) goto L275;
        r174 = new ArrayList();
    L275:
        List r214 = r174;
        List r175 = (List) r128.get(Long.valueOf(r213));
        if (r175 == null) goto L279;
        List r176 = CollectionsKt.toList(r175);
        if (r176 == null) goto L279;
    L280:
        r167.add(new k(r213, r214, r176, -1, CollectionsKt.emptyList()));
    L279:
        r176 = CollectionsKt.emptyList();
        goto L280
    L281:
        ((ArrayList) this.e).clear();
        ((ArrayList) this.e).addAll(r167);
    L283:
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        this.a = r111;
        this.j = r103;
        d.a("GiftListRepository", "update global gift cache, currentReceiverType" + r39);
        goto L284
    L282:
        r210 = "response";
        goto L283
    L5:
        r5 = 0;
        goto L6
    }
}
