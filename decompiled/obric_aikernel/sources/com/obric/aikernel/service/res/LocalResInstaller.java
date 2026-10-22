package com.obric.aikernel.service.res;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.res.PrmContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalResInstaller implements com.obric.aikernel.res.installer.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<File> f5465a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r10, T r11) {
            File r12 = (File) r10;
            String r13 = r12.getName();
            Intrinsics.checkNotNullExpressionValue(r13, "it.name");
            int r14 = 0;
            if (StringsKt.startsWith$default(r13, "package@", false, 2, null) == false) goto L5;
            int r15 = 2;
        L9:
            Integer r16 = Integer.valueOf(r15);
            File r17 = (File) r11;
            String r18 = r17.getName();
            Intrinsics.checkNotNullExpressionValue(r18, "it.name");
            if (StringsKt.startsWith$default(r18, "package@", false, 2, null) == false) goto L12;
            r14 = 2;
        L16:
            return ComparisonsKt.compareValues(r16, Integer.valueOf(r14));
        L12:
            String r19 = r17.getName();
            Intrinsics.checkNotNullExpressionValue(r19, "it.name");
            if (StringsKt.startsWith$default(r19, "lora@", false, 2, null) == false) goto L16;
            r14 = 1;
            goto L16
        L5:
            String r20 = r12.getName();
            Intrinsics.checkNotNullExpressionValue(r20, "it.name");
            if (StringsKt.startsWith$default(r20, "lora@", false, 2, null) == false) goto L8;
            r15 = 1;
            goto L9
        L8:
            r15 = 0;
            goto L9
        }
    }

    static {
        new a(null);
    }

    public LocalResInstaller() {
        this.f5465a = CollectionsKt.listOf(new File("/cust_model/aik_models/"));
    }

    public static /* synthetic */ boolean d(File r10, String r11) {
        return i(r10, r11);
    }

    private final boolean e(PrmContext r10, String r11, String r12, String r13) {
        Iterator<T> r14 = this.f5465a.iterator();
    L4:
        if (r14.hasNext() == false) goto L11;
        File r15 = new File((File) r14.next(), r11 + '@' + r12 + '@' + r13);
        if (r15.exists() == false) goto L4;
        if (g(r10, r11, r12, r13, r15, false).getFirst().booleanValue() == false) goto L4;
        return true;
    L11:
        return false;
    }

    private final boolean f(PrmContext r10, String r11, String r12) {
        Iterator<T> r13 = this.f5465a.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        File r14 = new File((File) r13.next(), r11 + '@' + r12);
        if (r14.exists() == false) goto L4;
        if (h(r10, r11, r12, r14, false).getFirst().booleanValue() == false) goto L4;
        return true;
    L11:
        return false;
    }

    private final Pair<Boolean, Boolean> g(final PrmContext r17, String r18, final String r19, final String r20, final File r21, boolean r22) {
        if (r21.exists() == true) goto L7;
        Boolean r10 = Boolean.FALSE;
        return new Pair(r10, r10);
    L7:
        if (Intrinsics.areEqual(r18, "model") == true) goto L9;
        final Function2<String, String, Boolean> r11 = new LocalResInstaller$installByType$copyZipFiles$1(r21, r19);
        final Ref.BooleanRef r12 = new Ref.BooleanRef();
        int r13 = r18.hashCode();
        if (r13 == (-807062458)) goto L25;
        if (r13 == 107141) goto L21;
        if (r13 == 3327730) goto L18;
    L26:
        boolean r14 = false;
    L30:
        return new Pair(Boolean.valueOf(r14), Boolean.valueOf(r12.element));
    L18:
        if (r18.equals("lora") == false) goto L26;
    L23:
        final com.google.gson.k r15 = null;
        boolean r16 = false;
        final String r23 = r18;
        Function1<String, com.obric.aikernel.res.metadata.data.b> r110 = new LocalResInstaller$installByType$installRet$2(r23, r17, r19, r20, r21, r11, r12);
        int r111 = 24;
        Object r112 = null;
    L28:
        r14 = PrmContext.install$default(r17, r23, r19, r20, r15, r16, r22, r110, r111, r112);
        goto L30
    L21:
        if (r18.equals("lib") == true) goto L23;
    L25:
        if (r18.equals("package") == false) goto L26;
        r15 = (com.google.gson.k) new com.google.gson.d().k(FilesKt.readText$default(new File(r21, "configuration.json"), null, 1, null), com.google.gson.k.class);
        r16 = false;
        r110 = new LocalResInstaller$installByType$installRet$1(r17, r19, r20, r15, r11, r12);
        r111 = 16;
        r112 = null;
        r23 = r18;
        goto L28
    L9:
        return h(r17, r19, r20, r21, r22);
    }

    private final Pair<Boolean, Boolean> h(final PrmContext r11, final String r12, final String r13, final File r14, boolean r15) {
        String[] r10 = r14.list(i.f5523a);
        boolean r16 = false;
        if (r10 != null) goto L5;
    L11:
        if (r16 == false) goto L14;
        AIKLog.INSTANCE.w("LocalResInstaller", "ignore invalid model res");
        Boolean r17 = Boolean.FALSE;
        return new Pair(r17, r17);
    L14:
        final Ref.BooleanRef r18 = new Ref.BooleanRef();
        boolean r19 = PrmContext.install$default(r11, "model", r12, r13, null, false, r15, new LocalResInstaller$installModel$resReady$1(r11, r12, r13, r14, r18), 24, null);
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new LocalResInstaller$installModel$2(r12, r13, null), 3, null);
        return new Pair(Boolean.valueOf(r19), Boolean.valueOf(r18.element));
    L5:
        if (r10.length != 0) goto L7;
        boolean r110 = true;
    L9:
        if ((!r110) != true) goto L11;
        r16 = true;
        goto L11
    L7:
        r110 = false;
        goto L9
    }

    private static final boolean i(File r10, String r11) {
        Intrinsics.checkNotNullExpressionValue(r11, "f");
        return StringsKt.endsWith$default(r11, ".tp", false, 2, null);
    }

    private final Pair<Boolean, Boolean> j(PrmContext r10, String r11, String r12, File r13, boolean r14) {
        return h(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.aikernel.res.installer.a
    public void a(PrmContext r10) {
        com.obric.aikernel.res.installer.a.C0113a.b(this, r10);
    }

    @Override // com.obric.aikernel.res.installer.a
    public List<com.obric.aikernel.res.installer.a.b> b(PrmContext r19) {
        Intrinsics.checkNotNullParameter(r19, "context");
        List r10 = CollectionsKt.listOf(new String[]{"model", "lib", "lora", "package"});
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(new com.obric.aikernel.res.installer.a.b(tag(), (String) r12.next(), 0, 0, 12, null));
        goto L4
    L6:
        LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16));
        Iterator r14 = r11.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        Object r15 = r14.next();
        r13.put(((com.obric.aikernel.res.installer.a.b) r15).c(), r15);
        goto L8
    L10:
        Iterator<T> r16 = this.f5465a.iterator();
    L12:
        if (r16.hasNext() == false) goto L51;
        File r17 = (File) r16.next();
        if (r17.exists() == false) goto L12;
        File[] r18 = r17.listFiles();
        if (r18 == null) goto L12;
        List r20 = ArraysKt.sortedWith(r18, new b());
        if (r20 == null) goto L12;
        Iterator r110 = r20.iterator();
    L21:
        if (r110.hasNext() == false) goto L12;
        File r21 = (File) r110.next();
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L48
        String r23 = r21.getName();     // Catch: Throwable -> L48
        Intrinsics.checkNotNullExpressionValue(r23, "it.name");     // Catch: Throwable -> L48
        List r24 = StringsKt.split$default(r23, new char[]{'@'}, false, 0, 6, null);     // Catch: Throwable -> L48
        int r25 = r24.size();     // Catch: Throwable -> L48
        Object r111 = null;
        if (r25 != 2) goto L27;
        String r26 = (String) r24.get(0);     // Catch: Throwable -> L48
        String r27 = (String) r24.get(1);     // Catch: Throwable -> L48
        Intrinsics.checkNotNullExpressionValue(r21, "it");     // Catch: Throwable -> L48
        if (j(r19, r26, r27, r21, true).getSecond().booleanValue() == false) goto L43;
        com.obric.aikernel.res.installer.a.b r28 = (com.obric.aikernel.res.installer.a.b) r13.get("model");     // Catch: Throwable -> L48
        if (r28 == null) goto L43;
        r28.d(r28.a() + 1);     // Catch: Throwable -> L48
    L43:
        com.obric.aikernel.res.installer.a.b r29 = (com.obric.aikernel.res.installer.a.b) r13.get("model");     // Catch: Throwable -> L48
        if (r29 == null) goto L46;
        int r30 = r29.b();     // Catch: Throwable -> L48
        r29.e(r30 + 1);     // Catch: Throwable -> L48
    L37:
        r111 = Integer.valueOf(r30);     // Catch: Throwable -> L48
    L46:
        Result.m32constructorimpl(r111);     // Catch: Throwable -> L48
        goto L21
    L27:
        if (r25 == 3) goto L29;
        r111 = Unit.INSTANCE;     // Catch: Throwable -> L48
        goto L46
    L29:
        String r31 = (String) r24.get(0);     // Catch: Throwable -> L48
        String r32 = (String) r24.get(0);     // Catch: Throwable -> L48
        String r33 = (String) r24.get(1);     // Catch: Throwable -> L48
        String r112 = (String) r24.get(2);     // Catch: Throwable -> L48
        Intrinsics.checkNotNullExpressionValue(r21, "it");     // Catch: Throwable -> L48
        if (g(r19, r32, r33, r112, r21, true).getSecond().booleanValue() == false) goto L34;
        com.obric.aikernel.res.installer.a.b r34 = (com.obric.aikernel.res.installer.a.b) r13.get(r31);     // Catch: Throwable -> L48
        if (r34 == null) goto L34;
        r34.d(r34.a() + 1);     // Catch: Throwable -> L48
    L34:
        com.obric.aikernel.res.installer.a.b r35 = (com.obric.aikernel.res.installer.a.b) r13.get(r31);     // Catch: Throwable -> L48
        if (r35 == null) goto L46;
        r30 = r35.b();     // Catch: Throwable -> L48
        r35.e(r30 + 1);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L21
    L51:
        return CollectionsKt.toList(r13.values());
    }

    @Override // com.obric.aikernel.res.installer.a
    public boolean c(PrmContext r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r12, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r13, "version");
        if (Intrinsics.areEqual(r11, "model") == false) goto L6;
        return f(r10, r12, r13);
    L6:
        return e(r10, r11, r12, r13);
    }

    @Override // com.obric.aikernel.res.installer.a
    public String tag() {
        return "LocalResInstaller";
    }
}
