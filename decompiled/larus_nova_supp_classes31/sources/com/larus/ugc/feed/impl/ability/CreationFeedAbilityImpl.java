package com.larus.ugc.feed.impl.ability;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.internal.delegate.c0;
import com.larus.ugc.feed.api.model.CommonCreationFeedDataKmp;
import com.larus.ugc.feed.api.model.CreationFeedCacheEntityKmp;
import com.larus.ugc.feed.api.model.CreationFeedInitParamsKmp;
import com.larus.ugc.feed.api.model.CreationFeedTrackParamsKmp;
import com.larus.ugc.feed.api.model.ImageInfoKmp;
import com.larus.ugc.feed.api.model.TabItemInfoKmp;
import com.larus.ugc.feed.api.model.UserCreationContentKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationModelKmp;
import com.larus.ugc.feed.api.model.UserCreationMusicKmp;
import com.larus.ugc.feed.api.model.UserCreationTrackParamsKmp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.RandomKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationFeedAbilityImpl implements g0a.g {
    public static final /* synthetic */ int o = 0;
    public final CoroutineScope a;
    public final a1a.b b;
    public CreationFeedInitParamsKmp c;
    public m0a.h d;
    public long e;
    public long f;
    public int g;
    public String h;
    public boolean i;
    public Job j;
    public Job k;
    public final Map<Integer, Boolean> l;
    public boolean m;
    public UserCreationKmp n;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final List<UserCreationModelKmp> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.b.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "DeletionResult(changed=" + this.a + ", newList=" + this.b + ')';
        }

        public b(boolean r2, List<UserCreationModelKmp> r3) {
            Intrinsics.checkNotNullParameter(r3, "newList");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final m0a.l n() {
        m0a.h r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public final Unit o(boolean r9) {
        n0a.a r0 = this.b.a();
        int r1 = this.g;
        if (r1 < 200) goto L6;
        p("preCheckCanLoadMore: pageIndex=" + this.g + " hit MAX_PAGES=200, stop load more");
    L14:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L20;
        if (r9 == true) goto L20;
        p("tryLoadMore refused, pageIndex:" + this.g + ", isForce:" + r9);
    L27:
        return Unit.INSTANCE;
    L20:
        p("loadMore:" + this.g + ", isForce:" + r9);
        if (r9 == false) goto L25;
        Job r10 = this.j;
        if (r10 == null) goto L25;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L25:
        this.l.put(Integer.valueOf(this.g), Boolean.TRUE);
        this.b.update(new h());
        this.j = BuildersKt.launch$default(this.a, Dispatchers.getDefault(), null, new CreationFeedAbilityImpl$loadMoreRecommendList$2(this, null), 2, null);
        goto L27
    L6:
        if (this.i == false) goto L14;
        if (this.l.containsKey(Integer.valueOf(r1)) == true) goto L14;
        if ((r0.c instanceof n0a.e.b) == true) goto L14;
        if (Intrinsics.areEqual(r0.d, n0a.b.C0067b.a) == true) goto L14;
        r2 = true;
        goto L16
    }

    public final void p(String r3) {
        c0.b.i("CreationFeedAbilityImpl", r3);
    }

    public static final void b(CreationFeedAbilityImpl r1, String r2) {
        r1.getClass();
        c0.b.d("CreationFeedAbilityImpl", r2);
    }

    public static boolean i(List r6, List r7) {
        if (((ArrayList) r6).size() == ((ArrayList) r7).size()) goto L5;
        return false;
    L5:
        List r8 = CollectionsKt.zip(r6, r7);
        if ((r8 instanceof Collection) == true) goto L8;
    L10:
        Iterator r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L63;
        Pair r10 = (Pair) r9.next();
        UserCreationKmp r1 = (UserCreationKmp) r10.component1();
        UserCreationKmp r11 = (UserCreationKmp) r10.component2();
        if (r11.getUserCreationType() != 1) goto L52;
        if (Intrinsics.areEqual(r11.getCreationId(), r1.getCreationId()) == true) goto L18;
    L60:
        boolean r12 = false;
    L61:
        if (r12 == true) goto L12;
        return false;
    L18:
        if (Intrinsics.areEqual(r11.getPrivateStatus(), r1.getPrivateStatus()) == false) goto L60;
        if (Intrinsics.areEqual(r11.getStatus(), r1.getStatus()) == false) goto L60;
        if (r11.getUserCreationType() != r1.getUserCreationType()) goto L60;
        UserCreationContentKmp r3 = r11.getContent();
        String r4 = null;
        if (r3 == null) goto L28;
        UserCreationMusicKmp r5 = r3.getMusicContent();
        if (r5 == null) goto L28;
        ImageInfoKmp r13 = r5.getCover();
    L29:
        UserCreationContentKmp r14 = r1.getContent();
        if (r14 == null) goto L34;
        UserCreationMusicKmp r15 = r14.getMusicContent();
        if (r15 == null) goto L34;
        ImageInfoKmp r16 = r15.getCover();
    L36:
        if (Intrinsics.areEqual(r13, r16) == false) goto L60;
        UserCreationContentKmp r17 = r11.getContent();
        if (r17 == null) goto L42;
        UserCreationMusicKmp r18 = r17.getMusicContent();
        if (r18 == null) goto L42;
        String r19 = r18.getTitle();
    L43:
        UserCreationContentKmp r2 = r1.getContent();
        if (r2 == null) goto L49;
        UserCreationMusicKmp r20 = r2.getMusicContent();
        if (r20 == null) goto L49;
        r4 = r20.getTitle();
    L49:
        if (Intrinsics.areEqual(r19, r4) == false) goto L60;
    L59:
        r12 = true;
    L42:
        r19 = null;
    L34:
        r16 = null;
    L28:
        r13 = null;
        goto L29
    L52:
        if (Intrinsics.areEqual(r11.getCreationId(), r1.getCreationId()) == false) goto L60;
        if (Intrinsics.areEqual(r11.getPrivateStatus(), r1.getPrivateStatus()) == false) goto L60;
        if (Intrinsics.areEqual(r11.getStatus(), r1.getStatus()) == false) goto L60;
        if (r11.getUserCreationType() != r1.getUserCreationType()) goto L60;
    L63:
        return true;
    L8:
        if (r8.isEmpty() == false) goto L10;
        goto L10
    }

    public final Object c(boolean r33, Continuation<? super Boolean> r34) {
        if ((r34 instanceof CreationFeedAbilityImpl$checkCurrentData$1) == false) goto L7;
        CreationFeedAbilityImpl$checkCurrentData$1 r3 = (CreationFeedAbilityImpl$checkCurrentData$1) r34;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        CreationFeedAbilityImpl$checkCurrentData$1 r9 = r3;
        Object r2 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        int r10 = 0;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        int r1 = r9.I$0;
        ResultKt.throwOnFailure(r2);
    L24:
        Pair r7 = (Pair) r2;
        if (r7 == null) goto L92;
        CommonCreationFeedDataKmp r8 = (CommonCreationFeedDataKmp) r7.getFirst();
        if (r8 == null) goto L92;
        Map<String, String> r11 = r8.getTraceMap();
        if (r11 == null) goto L31;
        String r12 = r11.get("request_id");
    L32:
        List<UserCreationKmp> r13 = r8.getCreationList();
        if (r13 != null) goto L35;
    L38:
        boolean r14 = true;
    L40:
        if (r14 == true) goto L42;
        List<UserCreationModelKmp> r15 = t(r12, r1, r8.getCreationList());
    L54:
        p("New data size: " + r15.size());
        HashSet r16 = new HashSet();
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r15.iterator();
    L56:
        if (r18.hasNext() == false) goto L60;
        Object r19 = r18.next();
        if (r16.add(((UserCreationModelKmp) r19).getModelId()) == false) goto L56;
        r17.add(r19);
        goto L56
    L60:
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r21 = r17.iterator();
    L62:
        if (r21.hasNext() == false) goto L75;
        Object r22 = r21.next();
        int r23 = r10 + 1;
        if (r10 >= 0) goto L66;
        CollectionsKt.throwIndexOverflow();
    L66:
        UserCreationModelKmp r110 = (UserCreationModelKmp) r22;
        List<UserCreationKmp> r24 = r110.getCreationList();
        if (r24 == null) goto L73;
        List<UserCreationKmp> r25 = r24;
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        Iterator<T> r27 = r25.iterator();
    L70:
        if (r27.hasNext() == false) goto L72;
        r26.add(w.a((UserCreationKmp) r27.next(), r23));
        goto L70
    L72:
        List r111 = CollectionsKt.toMutableList(r26);
    L74:
        UserCreationModelKmp r28 = UserCreationModelKmp.copy$default(r110, 0, r111, null, 5, null);
        m0a.o.a(r28);
        r20.add(r28);
        r10 = r23;
        goto L62
    L73:
        r111 = null;
        goto L74
    L75:
        p("Processed data size: " + r20.size());
        List r29 = CollectionsKt.take(this.b.a().a, r20.size());
        ArrayList r30 = new ArrayList();
        Iterator r31 = r29.iterator();
    L77:
        if (r31.hasNext() == false) goto L82;
        List<UserCreationKmp> r32 = ((UserCreationModelKmp) r31.next()).getCreationList();
        if (r32 != null) goto L81;
        r32 = CollectionsKt.emptyList();
    L81:
        CollectionsKt.addAll(r30, r32);
        goto L77
    L82:
        ArrayList r35 = new ArrayList();
        Iterator r36 = r20.iterator();
    L84:
        if (r36.hasNext() == false) goto L89;
        List<UserCreationKmp> r37 = ((UserCreationModelKmp) r36.next()).getCreationList();
        if (r37 != null) goto L88;
        r37 = CollectionsKt.emptyList();
    L88:
        CollectionsKt.addAll(r35, r37);
        goto L84
    L89:
        boolean r38 = !i(r30, r35);
        p("Data changed: " + r38);
        return Boxing.boxBoolean(r38);
    L42:
        List<List<UserCreationKmp>> r39 = r8.getCreationGroupList();
        if (r39 == null) goto L53;
        List<List<UserCreationKmp>> r40 = r39;
        ArrayList r41 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10));
        Iterator<T> r42 = r40.iterator();
    L46:
        if (r42.hasNext() == false) goto L52;
        List r43 = (List) r42.next();
        ArrayList r44 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r43, 10));
        Iterator r45 = r43.iterator();
    L49:
        if (r45.hasNext() == false) goto L51;
        r44.add(UserCreationKmp.copy$default((UserCreationKmp) r45.next(), null, 0, null, null, null, null, null, null, null, null, null, null, null, f(r1, r12), null, null, null, 122879, null));
        goto L49
    L51:
        UserCreationModelKmp r46 = new UserCreationModelKmp(2, CollectionsKt.toMutableList(r44), null, 4, null);
        m0a.o.a(r46);
        r41.add(r46);
        goto L46
    L52:
        r15 = r41;
        goto L54
    L53:
        r15 = CollectionsKt.emptyList();
        goto L54
    L35:
        if (r13.isEmpty() == true) goto L38;
        r14 = false;
        goto L40
    L31:
        r12 = null;
    L92:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        p("Start checking current data, request index: 1, isHotLaunch: " + r33);
        long r47 = RandomKt.Random(com.larus.im.internal.delegate.c.a.currentTimeMillis()).nextLong();
        if (r33 == false) goto L17;
        String r48 = "hot_launch";
    L18:
        String r49 = r48;
        m0a.l r50 = n();
        if (r50 == null) goto L92;
        Long r51 = Boxing.boxLong(r47);
        r9.I$0 = 1;
        r9.label = 1;
        r2 = r50.a(1, null, r51, r49, r9);
        if (r2 != r5) goto L23;
        return r5;
    L23:
        r1 = 1;
        goto L24
    L17:
        r48 = "refresh";
    L7:
        r3 = new CreationFeedAbilityImpl$checkCurrentData$1(this, r34);
        goto L8
    }

    public final UserCreationTrackParamsKmp f(int r12, String r13) {
        Integer r2 = Integer.valueOf(r12);
        CreationFeedInitParamsKmp r14 = this.c;
        if (r14 == null) goto L7;
        TabItemInfoKmp r15 = r14.getCurrentTabItemInfo();
        if (r15 == null) goto L7;
        String r4 = r15.getId();
    L8:
        CreationFeedInitParamsKmp r16 = this.c;
        if (r16 == null) goto L13;
        TabItemInfoKmp r17 = r16.getCurrentTabItemInfo();
        if (r17 == null) goto L13;
        String r5 = r17.getStarlingKey();
    L14:
        CreationFeedInitParamsKmp r18 = this.c;
        if (r18 == null) goto L19;
        TabItemInfoKmp r19 = r18.getCurrentTabItemInfo();
        if (r19 == null) goto L19;
        String r6 = r19.getTrackerTabType();
    L20:
        CreationFeedInitParamsKmp r110 = this.c;
        if (r110 == null) goto L25;
        CreationFeedTrackParamsKmp r111 = r110.getTrackParams();
        if (r111 == null) goto L25;
        String r7 = r111.getBotId();
    L27:
        return new UserCreationTrackParamsKmp(r13, r2, null, r4, r5, r6, r7, 4, null);
    L25:
        r7 = null;
    L19:
        r6 = null;
    L13:
        r5 = null;
    L7:
        r4 = null;
        goto L8
    }

    public final Object q(String r2, boolean r3) {
        p(r2.concat(", refresh"));
        if (r3 == false) goto L5;
        this.n = null;
        p("clearMock");
    L5:
        Object r4 = r(true, false, false);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r4;
    L9:
        return Unit.INSTANCE;
    }

    public CreationFeedAbilityImpl(CoroutineScope r2, a1a.b r3, o0a.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "stateHolder");
        Intrinsics.checkNotNullParameter(r4, "tracker");
        this.a = r2;
        this.b = r3;
        this.f = RandomKt.Random(com.larus.im.internal.delegate.c.a.currentTimeMillis()).nextLong();
        this.g = 1;
        this.l = new LinkedHashMap();
    }

    public static b d(List r12, String r13, boolean r14) {
        ArrayList r0 = new ArrayList();
        Iterator r15 = r12.iterator();
        boolean r3 = false;
        int r4 = 1;
    L4:
        if (r15.hasNext() == false) goto L67;
        UserCreationModelKmp r6 = (UserCreationModelKmp) r15.next();
        Integer r7 = null;
        if (r14 == true) goto L7;
        List<UserCreationKmp> r8 = r6.getCreationList();
        if (r8 == null) goto L43;
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r8.iterator();
    L39:
        if (r10.hasNext() == false) goto L44;
        Object r11 = r10.next();
        if ((!Intrinsics.areEqual(((UserCreationKmp) r11).getCreationId(), r13)) == false) goto L39;
        r9.add(r11);
    L44:
        List<UserCreationKmp> r16 = r6.getCreationList();
        if (r16 == null) goto L47;
        Integer r17 = Integer.valueOf(r16.size());
    L48:
        if (r9 == null) goto L51;
        r7 = Integer.valueOf(r9.size());
    L51:
        if (Intrinsics.areEqual(r17, r7) == true) goto L53;
        r3 = true;
    L53:
        if (r9 != null) goto L55;
    L58:
        boolean r18 = true;
    L59:
        if (r18 == true) goto L4;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r5 = r9.iterator();
    L62:
        if (r5.hasNext() == false) goto L64;
        r19.add(w.a((UserCreationKmp) r5.next(), r4));
        goto L62
    L64:
        UserCreationModelKmp r20 = UserCreationModelKmp.copy$default(r6, 0, CollectionsKt.toMutableList(r19), null, 5, null);
        m0a.o.a(r20);
        r0.add(r20);
    L65:
        r4 = r4 + 1;
        goto L4
    L55:
        if (r9.isEmpty() == true) goto L58;
        r18 = false;
        goto L59
    L47:
        r17 = null;
        goto L48
    L43:
        r9 = null;
        goto L44
    L7:
        List<UserCreationKmp> r21 = r6.getCreationList();
        if (r21 == null) goto L23;
        List<UserCreationKmp> r22 = r21;
        if ((r22 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r23 = r22.iterator();
    L16:
        if (r23.hasNext() == false) goto L20;
        if (Intrinsics.areEqual(((UserCreationKmp) r23.next()).getCreationId(), r13) == false) goto L16;
        boolean r24 = true;
    L21:
        if (r24 != true) goto L23;
        boolean r25 = true;
    L24:
        if (r25 == false) goto L25;
        r3 = true;
        goto L4
    L25:
        List<UserCreationKmp> r26 = r6.getCreationList();
        if (r26 == null) goto L32;
        List<UserCreationKmp> r27 = r26;
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator<T> r29 = r27.iterator();
    L29:
        if (r29.hasNext() == false) goto L31;
        r28.add(w.a((UserCreationKmp) r29.next(), r4));
        goto L29
    L31:
        List r30 = CollectionsKt.toMutableList(r28);
    L33:
        UserCreationModelKmp r31 = UserCreationModelKmp.copy$default(r6, 0, r30, null, 5, null);
        m0a.o.a(r31);
        r0.add(r31);
        goto L65
    L32:
        r30 = null;
    L20:
        r24 = false;
        goto L21
    L12:
        if (r22.isEmpty() == false) goto L14;
    L23:
        r25 = false;
        goto L24
    L67:
        return new b(r3, r0);
    }

    public final Object r(boolean r15, boolean r16, boolean r17) {
        ((LinkedHashMap) this.l).clear();
        this.g = 1;
        this.h = null;
        Job r2 = this.j;
        if (r2 == null) goto L5;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L5:
        this.l.put(Boxing.boxInt(this.g), Boxing.boxBoolean(true));
        if (r15 == true) goto L10;
        m0a.l r3 = n();
        if (r3 == null) goto L10;
        CreationFeedCacheEntityKmp r4 = r3.b();
    L11:
        final boolean r7 = false;
        if (r4 == null) goto L40;
        CommonCreationFeedDataKmp r1 = r4.getListData();
        if (r1 == null) goto L39;
        int r5 = this.g;
        this.g = r5 + 1;
        Long r6 = r4.getRandomSeed();
        if (r6 == null) goto L19;
        long r8 = r6.longValue();
    L20:
        this.f = r8;
        this.h = r1.getNextCursor();
        u(r5, r1, false, true);
        List<UserCreationKmp> r9 = r1.getCreationList();
        if (r9 != null) goto L23;
    L26:
        boolean r10 = true;
    L27:
        if (r10 == false) goto L37;
        List<List<UserCreationKmp>> r11 = r1.getCreationGroupList();
        if (r11 != null) goto L31;
    L34:
        boolean r12 = true;
    L35:
        if (r12 == false) goto L37;
        r7 = true;
        goto L37
    L31:
        if (r11.isEmpty() == true) goto L34;
        r12 = false;
    L37:
        this.b.b(new n(r7));
        goto L39
    L23:
        if (r9.isEmpty() == true) goto L26;
        r10 = false;
        goto L27
    L19:
        r8 = 0;
    L39:
        return Boxing.boxBoolean(true);
    L40:
        if (r15 == false) goto L42;
        this.b.update(new k());
    L43:
        Job r13 = this.k;
        if (r13 == null) goto L46;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L46:
        this.k = BuildersKt.launch$default(this.a, Dispatchers.getDefault(), null, new CreationFeedAbilityImpl$requestFirstRecommendList$4(this, r17, r15, r16, null), 2, null);
        return Boxing.boxBoolean(false);
    L42:
        this.b.update(new l());
    L10:
        r4 = null;
        goto L11
    }

    public final List<UserCreationModelKmp> t(String r26, int r27, List<UserCreationKmp> r28) {
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = r28;
        UserCreationKmp r3 = this.n;
        if (r3 == null) goto L11;
        List<UserCreationKmp> r1 = r28;
        if (r1 == null) goto L9;
        List r4 = CollectionsKt.toMutableList(r1);
        if (r4 == null) goto L9;
        ListProtector.add(r4, 0, r3);
    L10:
        r2.element = r4;
    L9:
        r4 = null;
    L11:
        List r5 = (List) r2.element;
        if (r5 == null) goto L18;
        List r6 = r5;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L15:
        if (r8.hasNext() == false) goto L20;
        UserCreationModelKmp r12 = new UserCreationModelKmp(1, CollectionsKt.arrayListOf(new UserCreationKmp[]{UserCreationKmp.copy$default((UserCreationKmp) r8.next(), null, 0, null, null, null, null, null, null, null, null, null, null, null, f(r27, r26), null, null, null, 122879, null)}), null, 4, null);
        m0a.o.a(r12);
        r7.add(r12);
        goto L15
    L20:
        return r7;
    L18:
        return CollectionsKt.emptyList();
    }

    public final Object l(boolean r2, boolean r3, boolean r4, Continuation<? super Boolean> r5) {
        boolean r6 = false;
        if (r2 == true) goto L5;
    L14:
        this.m = true;
        return r(false, r3, r4);
    L5:
        if (this.m == false) goto L14;
        p("viewModel has init so return");
        m0a.l r7 = n();
        if (r7 == null) goto L9;
        CreationFeedCacheEntityKmp r8 = r7.b();
    L10:
        if (r8 == null) goto L13;
        r6 = true;
    L13:
        return Boxing.boxBoolean(r6);
    L9:
        r8 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.util.ArrayList] */
    public final void u(final int r35, CommonCreationFeedDataKmp r36, boolean r37, boolean r38) {
        this.i = r36.getHasMore();
        final n0a.a r2 = this.b.a();
        ArrayList r3 = new ArrayList();
        if (r37 == false) goto L5;
        r3.addAll(r2.a);
    L5:
        Map<String, String> r4 = r36.getTraceMap();
        if (r4 == null) goto L8;
        String r5 = r4.get("request_id");
    L9:
        List<UserCreationKmp> r6 = r36.getCreationList();
        int r7 = 0;
        if (r6 != null) goto L12;
    L15:
        boolean r8 = true;
    L17:
        if (r8 == true) goto L19;
        r3.addAll(t(r5, r35, r36.getCreationList()));
    L31:
        p("origin size: " + r3.size());
        HashSet r9 = new HashSet();
        ArrayList r10 = new ArrayList();
        Iterator r11 = r3.iterator();
    L33:
        if (r11.hasNext() == false) goto L37;
        Object r12 = r11.next();
        if (r9.add(((UserCreationModelKmp) r12).getModelId()) == false) goto L33;
        r10.add(r12);
        goto L33
    L37:
        final ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r14 = r10.iterator();
    L39:
        if (r14.hasNext() == false) goto L52;
        Object r15 = r14.next();
        int r16 = r7 + 1;
        if (r7 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        UserCreationModelKmp r17 = (UserCreationModelKmp) r15;
        List<UserCreationKmp> r18 = r17.getCreationList();
        if (r18 == null) goto L50;
        List<UserCreationKmp> r19 = r18;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r21 = r19.iterator();
    L47:
        if (r21.hasNext() == false) goto L49;
        r20.add(w.a((UserCreationKmp) r21.next(), r16));
        goto L47
    L49:
        List r110 = CollectionsKt.toMutableList(r20);
    L51:
        UserCreationModelKmp r22 = UserCreationModelKmp.copy$default(r17, 0, r110, null, 5, null);
        m0a.o.a(r22);
        r13.add(r22);
        r7 = r16;
        goto L39
    L50:
        r110 = null;
        goto L51
    L52:
        p("final size: " + r13.size());
        if (r37 == true) goto L76;
        if (r38 == true) goto L76;
        if ((!r2.a.isEmpty()) == false) goto L76;
        if ((!r13.isEmpty()) == false) goto L76;
        List r23 = CollectionsKt.take(r2.a, r13.size());
        ArrayList r24 = new ArrayList();
        Iterator r25 = r23.iterator();
    L61:
        if (r25.hasNext() == false) goto L66;
        List<UserCreationKmp> r26 = ((UserCreationModelKmp) r25.next()).getCreationList();
        if (r26 != null) goto L65;
        r26 = CollectionsKt.emptyList();
    L65:
        CollectionsKt.addAll(r24, r26);
        goto L61
    L66:
        ArrayList r27 = new ArrayList();
        Iterator r28 = r13.iterator();
    L68:
        if (r28.hasNext() == false) goto L73;
        List<UserCreationKmp> r29 = ((UserCreationModelKmp) r28.next()).getCreationList();
        if (r29 != null) goto L72;
        r29 = CollectionsKt.emptyList();
    L72:
        CollectionsKt.addAll(r27, r29);
        goto L68
    L73:
        boolean r30 = i(r24, r27);
        p("blockRefresh: " + r30);
        if (r30 == false) goto L76;
        return;
    L76:
        Function1<? super n0a.a, n0a.a> r31 = new m(r35, this, r2, r13);
        if (r38 == false) goto L79;
        this.b.b(r31);
        return;
    L79:
        this.b.update(r31);
        return;
    L19:
        List<List<UserCreationKmp>> r32 = r36.getCreationGroupList();
        if (r32 == null) goto L29;
        List<List<UserCreationKmp>> r33 = r32;
        ?? r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator r34 = r33.iterator();
    L23:
        if (r34.hasNext() == false) goto L30;
        List r112 = (List) r34.next();
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r114 = r112.iterator();
    L26:
        if (r114.hasNext() == false) goto L28;
        r113.add(UserCreationKmp.copy$default((UserCreationKmp) r114.next(), null, 0, null, null, null, null, null, null, null, null, null, null, null, f(r35, r5), null, null, null, 122879, null));
        goto L26
    L28:
        UserCreationModelKmp r115 = new UserCreationModelKmp(2, CollectionsKt.toMutableList(r113), null, 4, null);
        m0a.o.a(r115);
        r111.add(r115);
    L30:
        r3.addAll((Collection) r111);
        goto L31
    L29:
        r111 = CollectionsKt.emptyList();
        goto L30
    L12:
        if (r6.isEmpty() == true) goto L15;
        r8 = false;
        goto L17
    L8:
        r5 = null;
        goto L9
    }
}
