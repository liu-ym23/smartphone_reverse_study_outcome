package com.obric.search.api.c;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.search.common.log.RuntimeLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J!\u0010\r\u001a\u00020\u000b2\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004H\u0002¢\u0006\u0002\u0010\u000fJ\u0016\u0010\r\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bJ\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ6\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J \u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u001c0\u001cH\u0002R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/search/api/migration/MigrationContainer;", "", "migrationsList", "", "Lcom/obric/search/api/migration/AbstractMigration;", "(Ljava/util/List;)V", "migrations", "", "", "Ljava/util/TreeMap;", "addMigration", "", "migration", "addMigrations", "", "([Lcom/obric/search/api/migration/AbstractMigration;)V", "contains", "", "startVersion", "endVersion", "findMigrationPath", CommonConsts.APM_INNER_EVENT_COST_START, "end", "findUpMigrationPath", "result", "", "upgrade", "getMigrations", "", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14934a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, TreeMap<Integer, com.obric.search.api.c.a>> f14935b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/api/migration/MigrationContainer$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14934a = new a(null);
    }

    public e(List<? extends com.obric.search.api.c.a> r4) {
        List<? extends com.obric.search.api.c.a> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "migrationsList");
        this.f14935b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        a(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<com.obric.search.api.c.a> a(List<com.obric.search.api.c.a> r10, boolean r11, int r12, int r13) {
        List<com.obric.search.api.c.a> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
    L3:
        boolean r0 = true;
        if (r11 == false) goto L7;
        if (r12 < r13) goto L8;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L36;
        TreeMap r4 = (TreeMap) ZeusTransformUtils.preCheckCast(this.f14935b.get(Integer.valueOf(r12)), TreeMap.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        if (r11 == false) goto L16;
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(r4.descendingKeySet(), Set.class, "com.obric.memorydata.plugin");
    L17:
        Iterator r6 = r5.iterator();
    L19:
        if (r6.hasNext() == false) goto L33;
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r6.next(), Integer.class, "com.obric.memorydata.plugin");
        if (r11 == false) goto L26;
        int r8 = r12 + 1;
        Intrinsics.checkNotNullExpressionValue(r7, "targetVersion");
        int r9 = r7.intValue();
        if (r8 > r9) goto L30;
        if (r9 > r13) goto L30;
    L29:
        boolean r15 = true;
    L31:
        if (r15 == false) goto L19;
        Object r16 = r4.get(r7);
        Intrinsics.checkNotNull(r16);
        r14.add(r16);
        r12 = r7.intValue();
    L34:
        if (r0 == true) goto L3;
        return null;
    L30:
        r15 = false;
        goto L31
    L26:
        Intrinsics.checkNotNullExpressionValue(r7, "targetVersion");
        int r17 = r7.intValue();
        if (r13 > r17) goto L30;
        if (r17 >= r12) goto L30;
    L33:
        r0 = false;
        goto L34
    L16:
        r5 = r4.keySet();
        goto L17
    L13:
        return null;
    L36:
        return r14;
    L8:
        r3 = true;
        goto L10
    L7:
        if (r12 <= r13) goto L9;
        goto L8
    }

    private final void a(com.obric.search.api.c.a r6) {
        int r0 = r6.a();
        int r1 = r6.b();
        Map<Integer, TreeMap<Integer, com.obric.search.api.c.a>> r5 = this.f14935b;
        Integer r2 = Integer.valueOf(r0);
        TreeMap<Integer, com.obric.search.api.c.a> r3 = r5.get(r2);
        if (r3 != null) goto L5;
        r3 = new TreeMap();
        r5.put(r2, r3);
    L5:
        TreeMap r7 = (TreeMap) ZeusTransformUtils.preCheckCast(r3, TreeMap.class, "com.obric.memorydata.plugin");
        if (((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin")).containsKey(Integer.valueOf(r1)) == false) goto L8;
        RuntimeLogger.f14958a.c("MigrationContainer", "Overriding migration " + r7.get(Integer.valueOf(r1)) + " with " + r6);
    L8:
        ((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r1), r6);
    }

    private final void a(List<? extends com.obric.search.api.c.a> r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        a((com.obric.search.api.c.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.search.api.c.a.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public final List<com.obric.search.api.c.a> a(int r5, int r6) {
        if (r5 == r6) goto L4;
        if (r6 <= r5) goto L7;
        boolean r0 = true;
    L9:
        return a((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"), r0, r5, r6);
    L7:
        r0 = false;
        goto L9
    L4:
        return CollectionsKt.emptyList();
    }
}
