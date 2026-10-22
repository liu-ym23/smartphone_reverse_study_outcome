package com.obric.matrix.platform.sdk.ones.safecushion;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0001 B]\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u001f\u001a\u00020\u0005R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006!"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig;", "", "pkgName", "", "versionCode", "", "versionName", "isBoe", "", "crashThreshold", "repairRules", "", "", "Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/BaseRepair;", "targetClassName", "uiProvider", "Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionUiProvider;", "(Ljava/lang/String;ILjava/lang/String;ZILjava/util/Map;Ljava/lang/String;Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionUiProvider;)V", "getCrashThreshold", "()I", "()Z", "getPkgName", "()Ljava/lang/String;", "getRepairRules", "()Ljava/util/Map;", "getTargetClassName", "getUiProvider", "()Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionUiProvider;", "getVersionCode", "getVersionName", "getRepairsForCrashCount", "crashCount", "Builder", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8130b;
    private final Map<Integer, List<com.obric.matrix.platform.sdk.ones.safecushion.repair.a>> c;
    private final com.obric.matrix.platform.sdk.ones.safecushion.ui.b d;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    public final String a() {
        return this.f8129a;
    }

    public final List<com.obric.matrix.platform.sdk.ones.safecushion.repair.a> a(int r6) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.c.entrySet(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        Object r2 = r7.next();
        if (((Number) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Number.class, "com.obric.memorydata.plugin")).intValue() > r6) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r3 = false;
        goto L9
    L11:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        CollectionsKt.addAll(r9, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L13
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    }

    public final int b() {
        return this.f8130b;
    }

    public final com.obric.matrix.platform.sdk.ones.safecushion.ui.b c() {
        return this.d;
    }
}
