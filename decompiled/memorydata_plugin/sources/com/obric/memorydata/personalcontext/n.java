package com.obric.memorydata.personalcontext;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.gq;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0011J\u0006\u0010!\u001a\u00020\u001eJ\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#2\u0006\u0010$\u001a\u00020\u0005J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0011H\u0002J*\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050'*\u00020\u000e2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000RP\u0010\u0016\u001aB\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\f0\f \u0018* \u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\f0\f\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019RP\u0010\u001a\u001aB\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\f0\f \u0018* \u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\f0\f\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019RP\u0010\u001b\u001aB\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\f0\f \u0018* \u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\f0\f\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019RP\u0010\u001c\u001aB\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\f0\f \u0018* \u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\f0\f\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006."}, d2 = {"Lcom/obric/memorydata/personalcontext/MetaLocationManagerForSlotExtract;", "", "<init>", "()V", "SLOT_COUNTRY", "", "SLOT_ADMINISTRATIVE_AREA", "SLOT_LOCALITY", "SLOT_SUB_LOCALITY", "TAG", "CHINESE_CHINA_NAME", "isInit", "", "config", "Lcom/obric/memorydata/personalcontext/MetaLocationManagerForSlotExtract$NameConfig;", "waitProcessLocationEntities", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/database/entity/RawMetaLocationEntity;", "ahoCorasick", "Lcom/obric/memorydata/personalcontext/util/AhoCorasickAlgorithm;", "ahoLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "countrySet", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "administrativeAreaSet", "localitySet", "subLocalitySet", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "addLocation", "locationEntity", "reload", "processLocationSlot", "Lkotlin/Pair;", EventBody.KEY_VALUE, "internalProcessLocation", "getAlternativeNames", "", "country", ActivityLifecycle.NAME, "nameType", "extractRegionNameComplete", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "NameConfig", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f12234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12235b;
    private static final a c = null;
    private static final CopyOnWriteArrayList<gq> d = null;
    private static final com.obric.memorydata.personalcontext.util.a e = null;
    private static final ReentrantReadWriteLock f = null;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> g = null;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> h = null;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> i = null;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> j = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/MetaLocationManagerForSlotExtract$NameConfig;", "", "<init>", "()V", "specialAdministrativeRegions", "", "", "getSpecialAdministrativeRegions", "()Ljava/util/List;", "autonomousRegions", "getAutonomousRegions", "provinceSuffixes", "getProvinceSuffixes", "localitySuffixes", "getLocalitySuffixes", "subLocalitySuffixes", "getSubLocalitySuffixes", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0657a f12236a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f12237b;
        private final List<String> c;
        private final List<String> d;
        private final List<String> e;
        private final List<String> f;

        /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.n$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/MetaLocationManagerForSlotExtract$NameConfig$Companion;", "", "<init>", "()V", "PROVINCE", "", "AUTONOMOUS_REGION", "SPECIAL_ADMINISTRATIVE_REGION", "STATE", "SHIRE", "CANTON", "CITY", "AUTONOMOUS_STATE", "UNION", "DISTRICT", "COUNTY", "AUTONOMOUS_COUNTY", "FLAG", "AUTONOMOUS_FLAG", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0657a {
            private C0657a() {
            }

            public /* synthetic */ C0657a(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            f12236a = new C0657a(null);
        }

        public a() {
            this.f12237b = CollectionsKt.listOf(new String[]{"香港", "澳门"});
            this.c = CollectionsKt.listOf(new String[]{"内蒙古", "西藏", "宁夏回族", "新疆维吾尔", "广西壮族"});
            this.d = CollectionsKt.listOf(new String[]{"省", "自治区", "特别行政区", "州", "郡", "邦"});
            this.e = CollectionsKt.listOf(new String[]{"市", "盟", "自治州"});
            this.f = CollectionsKt.listOf(new String[]{"区", "县", "市", "旗", "自治县", "自治旗"});
        }

        public final List<String> a() {
            return this.f12237b;
        }

        public final List<String> b() {
            return this.c;
        }

        public final List<String> c() {
            return this.d;
        }

        public final List<String> d() {
            return this.e;
        }

        public final List<String> e() {
            return this.f;
        }
    }

    static {
        f12234a = new n();
        c = new a();
        d = new CopyOnWriteArrayList();
        e = new com.obric.memorydata.personalcontext.util.a();
        f = new ReentrantReadWriteLock();
        g = ConcurrentHashMap.newKeySet();
        h = ConcurrentHashMap.newKeySet();
        i = ConcurrentHashMap.newKeySet();
        j = ConcurrentHashMap.newKeySet();
    }

    private n() {
    }

    private final List<String> a(a r11, String r12, String r13, String r14) {
        List<String> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r10.add(r13);
        int r0 = r14.hashCode();
        if (r0 == (-1079648317)) goto L52;
        if (r0 == 995589851) goto L23;
        if (r0 == 1900805475) goto L10;
    L67:
        return r10;
    L10:
        if (r14.equals("locality") == false) goto L67;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.d(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r15.hasNext() == false) goto L67;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.endsWith$default(r13, r16, false, 2, null) == false) goto L14;
        if (Intrinsics.areEqual(r16, "自治州") == false) goto L20;
        String r17 = f12234a.b(r13);
    L21:
        r10.add(r17);
        goto L14
    L20:
        r17 = r13.substring(0, r13.length() - r16.length());
        Intrinsics.checkNotNullExpressionValue(r17, "substring(...)");
        goto L21
    L23:
        if (r14.equals("administrativeArea") == false) goto L67;
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L26:
        if (r18.hasNext() == false) goto L67;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.endsWith$default(r13, r1, false, 2, null) == false) goto L37;
        String r2 = r13.substring(0, r13.length() - r1.length());
        Intrinsics.checkNotNullExpressionValue(r2, "substring(...)");
        r10.add(r2);
        if (Intrinsics.areEqual(r1, "自治区") == true) goto L34;
        if (Intrinsics.areEqual(r1, "特别行政区") == false) goto L37;
    L34:
        if (r13.length() <= 4) goto L37;
        String r3 = r13.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        r10.add(r3);
    L37:
        if (Intrinsics.areEqual(r12, "中国") == false) goto L42;
        if (StringsKt.endsWith$default(r13, "省", false, 2, null) == true) goto L42;
        r10.add(r13 + 30465);
    L42:
        if (r11.a().contains(r13) == false) goto L47;
        if (StringsKt.endsWith$default(r13, "特别行政区", false, 2, null) == true) goto L47;
        r10.add(r13 + "特别行政区");
    L47:
        if (r11.b().contains(r13) == false) goto L26;
        if (StringsKt.endsWith$default(r13, "自治区", false, 2, null) == true) goto L26;
        r10.add(r13 + "自治区");
        goto L26
    L52:
        if (r14.equals("subLocality") == false) goto L67;
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.e(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L56:
        if (r19.hasNext() == false) goto L67;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.endsWith$default(r13, r110, false, 2, null) == false) goto L56;
        if (Intrinsics.areEqual(r110, "自治县") == false) goto L62;
    L65:
        String r111 = f12234a.b(r13);
    L66:
        r10.add(r111);
        goto L56
    L62:
        if (Intrinsics.areEqual(r110, "自治旗") == true) goto L65;
        r111 = r13.substring(0, r13.length() - r110.length());
        Intrinsics.checkNotNullExpressionValue(r111, "substring(...)");
        goto L66
    }

    private final String b(String r5) {
        String r4 = (String) ZeusTransformUtils.preCheckCast(MapsKt.mapOf(new Pair[]{TuplesKt.to("巴音郭楞蒙古自治州", "巴音郭楞"), TuplesKt.to("克孜勒苏柯尔克孜自治州", "克孜勒苏"), TuplesKt.to("博尔塔拉蒙古自治州", "博尔塔拉"), TuplesKt.to("西双版纳傣族自治州", "西双版纳"), TuplesKt.to("前郭尔罗斯蒙古族自治县", "前郭尔罗斯"), TuplesKt.to("杜尔伯特蒙古族自治县", "杜尔伯特"), TuplesKt.to("鄂伦春自治旗", "鄂伦春"), TuplesKt.to("鄂温克族自治旗", "鄂温克"), TuplesKt.to("莫力达瓦达斡尔族自治旗", "莫力达瓦")}).get(r5), String.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        return r4;
    L6:
        if (r5.length() < 2) goto L9;
        String r6 = r5.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(r6, "substring(...)");
        return r6;
    L9:
        return r5;
    }

    private static final void b() {
        Iterator<gq> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaLocationRawDbDao().queryAllDistinct().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        f12234a.b((gq) ZeusTransformUtils.preCheckCast(r0.next(), gq.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        gq r2 = (gq) ZeusTransformUtils.preCheckCast(r1.next(), gq.class, "com.obric.memorydata.plugin");
        n r3 = f12234a;
        Intrinsics.checkNotNull(r2);
        r3.b(r2);
        goto L8
    L10:
        ReentrantReadWriteLock r4 = f;
        ReentrantReadWriteLock.ReadLock r5 = r4.readLock();
        int r6 = 0;
        if (r4.getWriteHoldCount() != 0) goto L13;
        int r7 = r4.getReadHoldCount();
    L14:
        int r8 = 0;
    L15:
        if (r8 >= r7) goto L17;
        r5.unlock();
        r8 = r8 + 1;
        goto L15
    L17:
        ReentrantReadWriteLock.WriteLock r9 = r4.writeLock();
        r9.lock();
        e.a();     // Catch: Throwable -> L23
        f12235b = true;     // Catch: Throwable -> L23
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L19:
        if (r6 >= r7) goto L21;
        r5.lock();
        r6 = r6 + 1;
        goto L19
    L21:
        r9.unlock();
        return;
    L23:
        th = move-exception;
    L24:
        if (r6 >= r7) goto L26;
        r5.lock();
        r6 = r6 + 1;
        goto L24
    L26:
        r9.unlock();
        throw th;
    L13:
        r7 = 0;
        goto L14
    }

    private final void b(gq r9) {
        String r8 = r9.b();
        int r0 = 0;
        if (r8 != null) goto L5;
    L24:
        String r10 = r9.d();
        String r1 = "";
        if (r10 != null) goto L27;
    L53:
        String r11 = r9.e();
        if (r11 != null) goto L56;
    L82:
        String r12 = r9.f();
        if (r12 != null) goto L85;
        return;
    L85:
        if (j.add(r12) == false) goto L135;
        n r3 = f12234a;
        a r4 = c;
        String r13 = r9.b();
        if (r13 == null) goto L90;
        r1 = r13;
    L90:
        List<String> r14 = r3.a(r4, r1, r12, "subLocality");
        ReentrantReadWriteLock r15 = f;
        ReentrantReadWriteLock.ReadLock r2 = r15.readLock();
        if (r15.getWriteHoldCount() != 0) goto L93;
        int r5 = r15.getReadHoldCount();
    L94:
        int r6 = 0;
    L95:
        if (r6 >= r5) goto L97;
        r2.unlock();
        r6 = r6 + 1;
        goto L95
    L97:
        ReentrantReadWriteLock.WriteLock r16 = r15.writeLock();
        r16.lock();
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L106
    L100:
        if (r17.hasNext() == false) goto L102;
        e.insert((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L106
        goto L100
    L102:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L106
    L103:
        if (r0 >= r5) goto L105;
        r2.lock();
        r0 = r0 + 1;
        goto L103
    L105:
        r16.unlock();
        return;
    L106:
        th = move-exception;
    L107:
        if (r0 >= r5) goto L109;
        r2.lock();
        r0 = r0 + 1;
        goto L107
    L109:
        r16.unlock();
        throw th;
    L93:
        r5 = 0;
        goto L94
    L135:
        return;
    L56:
        if (i.add(r11) == false) goto L82;
        n r7 = f12234a;
        a r19 = c;
        String r20 = r9.b();
        if (r20 != null) goto L60;
        r20 = "";
    L60:
        List<String> r21 = r7.a(r19, r20, r11, "locality");
        ReentrantReadWriteLock r22 = f;
        ReentrantReadWriteLock.ReadLock r23 = r22.readLock();
        if (r22.getWriteHoldCount() != 0) goto L63;
        int r24 = r22.getReadHoldCount();
    L64:
        int r25 = 0;
    L65:
        if (r25 >= r24) goto L67;
        r23.unlock();
        r25 = r25 + 1;
        goto L65
    L67:
        ReentrantReadWriteLock.WriteLock r26 = r22.writeLock();
        r26.lock();
        Iterator r27 = ((Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L77
    L70:
        if (r27.hasNext() == false) goto L72;
        e.insert((String) ZeusTransformUtils.preCheckCast(r27.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L77
        goto L70
    L72:
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L77
        int r29 = 0;
    L74:
        if (r29 >= r24) goto L76;
        r23.lock();
        r29 = r29 + 1;
        goto L74
    L76:
        r26.unlock();
    L77:
        th = move-exception;
    L78:
        if (r0 >= r24) goto L80;
        r23.lock();
        r0 = r0 + 1;
        goto L78
    L80:
        r26.unlock();
        throw th;
    L63:
        r24 = 0;
        goto L64
    L27:
        if (h.add(r10) == false) goto L53;
        n r30 = f12234a;
        a r31 = c;
        String r32 = r9.b();
        if (r32 != null) goto L31;
        r32 = "";
    L31:
        List<String> r33 = r30.a(r31, r32, r10, "administrativeArea");
        ReentrantReadWriteLock r34 = f;
        ReentrantReadWriteLock.ReadLock r35 = r34.readLock();
        if (r34.getWriteHoldCount() != 0) goto L34;
        int r36 = r34.getReadHoldCount();
    L35:
        int r37 = 0;
    L36:
        if (r37 >= r36) goto L38;
        r35.unlock();
        r37 = r37 + 1;
        goto L36
    L38:
        ReentrantReadWriteLock.WriteLock r38 = r34.writeLock();
        r38.lock();
        Iterator r39 = ((Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L48
    L41:
        if (r39.hasNext() == false) goto L43;
        e.insert((String) ZeusTransformUtils.preCheckCast(r39.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L48
        goto L41
    L43:
        Unit r40 = Unit.INSTANCE;     // Catch: Throwable -> L48
        int r41 = 0;
    L45:
        if (r41 >= r36) goto L47;
        r35.lock();
        r41 = r41 + 1;
        goto L45
    L47:
        r38.unlock();
    L48:
        th = move-exception;
    L49:
        if (r0 >= r36) goto L51;
        r35.lock();
        r0 = r0 + 1;
        goto L49
    L51:
        r38.unlock();
        throw th;
    L34:
        r36 = 0;
        goto L35
    L5:
        if (g.add(r8) == false) goto L24;
        ReentrantReadWriteLock r42 = f;
        ReentrantReadWriteLock.ReadLock r43 = r42.readLock();
        if (r42.getWriteHoldCount() != 0) goto L9;
        int r44 = r42.getReadHoldCount();
    L10:
        int r45 = 0;
    L11:
        if (r45 >= r44) goto L13;
        r43.unlock();
        r45 = r45 + 1;
        goto L11
    L13:
        ReentrantReadWriteLock.WriteLock r46 = r42.writeLock();
        r46.lock();
        e.insert(r8);     // Catch: Throwable -> L19
        Unit r47 = Unit.INSTANCE;     // Catch: Throwable -> L19
        int r48 = 0;
    L16:
        if (r48 >= r44) goto L18;
        r43.lock();
        r48 = r48 + 1;
        goto L16
    L18:
        r46.unlock();
    L19:
        th = move-exception;
    L20:
        if (r0 >= r44) goto L22;
        r43.lock();
        r0 = r0 + 1;
        goto L20
    L22:
        r46.unlock();
        throw th;
    L9:
        r44 = 0;
        goto L10
    }

    public static /* synthetic */ void lambda$Cm1BOvsCiqTTzVc9oJW7qoEvbbk() {
        b();
    }

    public final Pair<String, String> a(String r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        if (f12235b == true) goto L6;
        a();
        return new Pair(r10, "");
    L6:
        RunLog.INSTANCE.debug("MetaLocationManagerForSlotExtract", "processLocationSlot value: " + r10);
        ReentrantReadWriteLock.ReadLock r9 = f.readLock();
        r9.lock();
        HashMap<String, List<Integer>> r0 = e.a(r10);     // Catch: Throwable -> L21
        r9.unlock();
        if (r0.isEmpty() == true) goto L11;
        Iterator r11 = ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
        int r3 = 0;
    L14:
        if (r11.hasNext() == false) goto L19;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterator r5 = ((List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r5.hasNext() == false) goto L14;
        r3 = Math.max(r3, ((Number) ZeusTransformUtils.preCheckCast(r5.next(), Number.class, "com.obric.memorydata.plugin")).intValue() + ((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")).length());
        goto L17
    L19:
        RunLog r12 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("processLocationSlot result: ");
        String r6 = r10.substring(0, r3);
        Intrinsics.checkNotNullExpressionValue(r6, "substring(...)");
        String r7 = r10.substring(r3);
        Intrinsics.checkNotNullExpressionValue(r7, "substring(...)");
        r12.debug("MetaLocationManagerForSlotExtract", r1.append(new Pair(r6, r7)).toString());
        String r2 = r10.substring(0, r3);
        Intrinsics.checkNotNullExpressionValue(r2, "substring(...)");
        String r13 = r10.substring(r3);
        Intrinsics.checkNotNullExpressionValue(r13, "substring(...)");
        return new Pair(r2, r13);
    L11:
        return new Pair("", r10);
    L21:
        th = move-exception;
        r9.unlock();
        throw th;
    }

    public final void a() {
        if (f12235b == false) goto L5;
        return;
    L5:
        RunLog.INSTANCE.debug("MetaLocationManagerForSlotExtract", "MetaLocationManagerForSlotExtract Init");
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$n$Cm1BOvsCiqTTzVc9oJW7qoEvbbk.INSTANCE);
    }

    public final synchronized void a(gq r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "locationEntity");     // Catch: Throwable -> L11
        if (f12235b == true) goto L8;
        d.add(r2);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        b(r2);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
