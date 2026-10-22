package com.obric.memorydata.middleware.impl.abtest;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/impl/abtest/MemoryAbVersionManager;", "", "sink", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "sourceVids", "", "Lcom/obric/memorydata/middleware/impl/abtest/AbVersionSource;", "", "lastWrittenValue", BuildConfig.CHANNEL, AILabCheckPermissionTask.KEY_SOURCE, "rawVids", "parseVids", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11677a = null;
    private static final Regex e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<String, Unit> f11678b;
    private final Map<AbVersionSource, Set<String>> c;
    private String d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/middleware/impl/abtest/MemoryAbVersionManager$Companion;", "", "<init>", "()V", "VID_PATTERN", "Lkotlin/text/Regex;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f11677a = new a(null);
        e = new Regex("^[0-9]+$");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public c(Function1<? super String, Unit> r3) {
        Function1<String, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "sink");
        this.f11678b = r4;
        this.c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.d = "";
    }

    public /* synthetic */ c(Function1 r2, int r3, DefaultConstructorMarker r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = (Function1) ZeusTransformUtils.preCheckCast(MemoryAbVersionManager$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L5:
        this(r5);
    }

    private final Set<String> a(String r8) {
        if (r8 != null) goto L4;
        r8 = "";
    L4:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{','}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r7.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        r9.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L6
    L8:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L10:
        if (r13.hasNext() == false) goto L15;
        Object r1 = r13.next();
        if (e.matches((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L10;
        r12.add(r1);
        goto L10
    L15:
        return CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final synchronized void update(AbVersionSource r10, String r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L16
        this.c.put(r10, a(r11));     // Catch: Throwable -> L16
        String r12 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.flatten((Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);     // Catch: Throwable -> L16
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L6;
        boolean r13 = true;
    L7:
        if (r13 == false) goto L9;
    L14:
        monitor-exit(this);
        return;
    L9:
        if (Intrinsics.areEqual(r12, this.d) == true) goto L14;
        this.f11678b.invoke(r12);     // Catch: Throwable -> L16
        this.d = r12;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L6:
        r13 = false;
    L16:
        th = move-exception;
        throw th;
    }
}
