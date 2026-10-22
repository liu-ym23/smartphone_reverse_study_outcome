package com.obric.memorydata.migration.sdk.internal.file;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Environment;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/file/ConfigurableFileUriMapper;", "Lcom/obric/memorydata/migration/sdk/internal/file/FileUriMapper;", "context", "Landroid/content/Context;", "authority", "", "originPackageName", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "specs", "", "Lcom/obric/memorydata/migration/sdk/internal/file/ConfigurableFileUriMapper$Spec;", "nameToSpec", "", "specByPrefix", "toBackupRelativePath", "uriString", "resolveRestoreFile", "Ljava/io/File;", "relativePath", "extractName", "firstSegment", "normalizeDir", "path", "sanitizeRelativePath", "parseFileProviderPaths", "Lcom/obric/memorydata/migration/sdk/internal/file/FileUriMapperSpec;", "Spec", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements com.obric.memorydata.migration.sdk.internal.file.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11927b;
    private final List<C0647a> c;
    private final Map<String, C0647a> d;
    private final List<C0647a> e;

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.internal.file.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/file/ConfigurableFileUriMapper$Spec;", "", "spec", "Lcom/obric/memorydata/migration/sdk/internal/file/FileUriMapperSpec;", "prefix", "", "<init>", "(Lcom/obric/memorydata/migration/sdk/internal/file/FileUriMapperSpec;Ljava/lang/String;)V", "getSpec", "()Lcom/obric/memorydata/migration/sdk/internal/file/FileUriMapperSpec;", "getPrefix", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0647a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.memorydata.migration.sdk.internal.file.c f11928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11929b;

        public C0647a(com.obric.memorydata.migration.sdk.internal.file.c r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "spec");
            Intrinsics.checkNotNullParameter(r3, "prefix");
            this.f11928a = r2;
            this.f11929b = r3;
        }

        public final com.obric.memorydata.migration.sdk.internal.file.c a() {
            return this.f11928a;
        }

        public final String b() {
            return this.f11929b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0647a.class) == true) goto L8;
            return false;
        L8:
            C0647a r6 = (C0647a) ZeusTransformUtils.preCheckCast(r5, C0647a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11928a, r6.f11928a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11929b, r6.f11929b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11928a.hashCode() * 31) + this.f11929b.hashCode();
        }

        public String toString() {
            return "Spec(spec=" + this.f11928a + ", prefix=" + this.f11929b + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11930a = null;

        static {
            int[] r0 = new int[FileRoot.values().length];
            r0[FileRoot.FILES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[FileRoot.CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[FileRoot.EXTERNAL_FILES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[FileRoot.EXTERNAL_CACHE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[FileRoot.EXTERNAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f11930a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((C0647a) ZeusTransformUtils.preCheckCast(r3, C0647a.class, "com.obric.memorydata.plugin")).b().length()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((C0647a) ZeusTransformUtils.preCheckCast(r2, C0647a.class, "com.obric.memorydata.plugin")).b().length()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r5, String r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r6, "authority");
        Intrinsics.checkNotNullParameter(r7, "originPackageName");
        this.f11926a = r6;
        this.f11927b = r7;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(a(r8), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        com.obric.memorydata.migration.sdk.internal.file.c r0 = (com.obric.memorydata.migration.sdk.internal.file.c) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.memorydata.migration.sdk.internal.file.c.class, "com.obric.memorydata.plugin");
        r10.add(new C0647a(r0, c(r0.c())));
        goto L4
    L6:
        List<C0647a> r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        this.c = r12;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Map<String, C0647a> r14 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r13, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        Object r16 = r15.next();
        r14.put(((C0647a) ZeusTransformUtils.preCheckCast(r16, C0647a.class, "com.obric.memorydata.plugin")).a().a(), r16);
        goto L8
    L10:
        this.d = r14;
        this.e = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ a(Context r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = "com.larus.nova.zeus.memorydata.fileprovider";
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = BuildConfig.LIBRARY_PACKAGE_NAME;
    L8:
        this(r7, r3, r4);
    }

    private final List<com.obric.memorydata.migration.sdk.internal.file.c> a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        int r0 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin"), "shared_file_paths", "xml", r8.getPackageName(), "com.obric.memorydata.plugin");
        if (r0 == 0) goto L5;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L46
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        XmlResourceParser r9 = ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin").getXml(r0);     // Catch: Throwable -> L46
        Intrinsics.checkNotNullExpressionValue(r9, "getXml(...)");     // Catch: Throwable -> L46
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        int r1 = r9.getEventType();     // Catch: Throwable -> L46
    L8:
        if (r1 == 1) goto L44;
        if (r1 != 2) goto L43;
        String r3 = r9.getName();     // Catch: Throwable -> L46
        if (r3 != null) goto L14;
    L35:
        FileRoot r4 = null;
    L36:
        String r5 = r9.getAttributeValue(null, ActivityLifecycle.NAME);     // Catch: Throwable -> L46
        if (r4 == null) goto L43;
        if (r5 == null) goto L43;
        String r11 = r9.getAttributeValue(null, "path");     // Catch: Throwable -> L46
        if (r11 != null) goto L42;
        r11 = "";
    L42:
        r10.add(new com.obric.memorydata.migration.sdk.internal.file.c(r5, r4, r11));     // Catch: Throwable -> L46
        goto L43
    L14:
        switch(r3.hashCode()) {
            case -1642807877: goto L33;
            case -1360690478: goto L29;
            case -50149145: goto L25;
            case -17221744: goto L21;
            case 1308690685: goto L17;
            default: goto L35;
        };     // Catch: Throwable -> L46
    L17:
        if (r3.equals("external-files-path") == false) goto L35;
        r4 = FileRoot.EXTERNAL_FILES;     // Catch: Throwable -> L46
        goto L36
    L21:
        if (r3.equals("cache-path") == false) goto L35;
        r4 = FileRoot.CACHE;     // Catch: Throwable -> L46
        goto L36
    L25:
        if (r3.equals("external-path") == false) goto L35;
        r4 = FileRoot.EXTERNAL;     // Catch: Throwable -> L46
        goto L36
    L29:
        if (r3.equals("external-cache-path") == false) goto L35;
        r4 = FileRoot.EXTERNAL_CACHE;     // Catch: Throwable -> L46
        goto L36
    L33:
        if (r3.equals("files-path") == false) goto L35;
        r4 = FileRoot.FILES;     // Catch: Throwable -> L46
    L43:
        r1 = r9.next();     // Catch: Throwable -> L46
        goto L8
    L44:
        Object r12 = Result.m1421constructorimpl(r10);     // Catch: Throwable -> L46
    L48:
        List r13 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r12) == false) goto L52;
        r12 = r13;
    L52:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
    L46:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L48
    L5:
        return CollectionsKt.emptyList();
    }

    private final String b(String r4) {
        String r3 = this.f11927b + ".plugin_";
        if (StringsKt.startsWith$default(r4, r3, false, 2, null) == true) goto L5;
        return null;
    L5:
        String r5 = StringsKt.removePrefix(r4, (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        return null;
    L8:
        return r5;
    }

    private final String c(String r11) {
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r12 = true;
        String r13 = StringsKt.replace$default(StringsKt.trimStart(r10, new char[]{'/'}), '\\', '/', false, 4, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L6;
        r12 = false;
    L6:
        if (r12 == false) goto L8;
        return "";
    L8:
        if (Intrinsics.areEqual(r13, ".") == false) goto L11;
        return "";
    L11:
        if (StringsKt.endsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), '/', false, 2, null) == false) goto L14;
        return r13;
    L14:
        return r13 + '/';
    }

    private final String d(String r14) {
        String r13 = StringsKt.replace$default(r14, '\\', '/', false, 4, null);
        boolean r15 = true;
        String r16 = StringsKt.trimStart(r13, new char[]{'/'});
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
    L40:
        return null;
    L9:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"), ':', false, 2, null) == true) goto L40;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'/'}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L13:
        if (r18.hasNext() == false) goto L20;
        Object r2 = r18.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L13;
        r1.add(r2);
        goto L13
    L17:
        r5 = false;
        goto L18
    L20:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L23;
    L25:
        Iterator r4 = r3.iterator();
    L27:
        if (r4.hasNext() == false) goto L24;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r6, ".") == false) goto L31;
    L34:
        boolean r7 = true;
    L35:
        if (r7 == false) goto L27;
    L36:
        if (r15 == false) goto L39;
        return null;
    L39:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L31:
        if (Intrinsics.areEqual(r6, "..") == true) goto L34;
        r7 = false;
    L24:
        r15 = false;
        goto L36
    L23:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L25;
    L5:
        r0 = false;
        goto L7
    }

    @Override // com.obric.memorydata.migration.sdk.internal.file.b
    public File a(Context r8, String r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r9, "relativePath");
        String r11 = d(r9);
        if (r11 != null) goto L5;
        return null;
    L5:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (StringsKt.startsWith$default(r11, ((C0647a) ZeusTransformUtils.preCheckCast(r3, C0647a.class, "com.obric.memorydata.plugin")).b(), false, 2, null) == false) goto L7;
    L12:
        C0647a r4 = (C0647a) ZeusTransformUtils.preCheckCast(r3, C0647a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L15;
        return null;
    L15:
        String r7 = c(r4.a().c()) + StringsKt.removePrefix(r11, (CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        int r12 = b.f11930a[r4.a().b().ordinal()];
        if (r12 == 1) goto L30;
        if (r12 != 2) goto L19;
        File r13 = r10.getCacheDir();
    L31:
        if (r13 != null) goto L34;
        return null;
    L34:
        return new File(r13, r7);
    L19:
        if (r12 != 3) goto L21;
        r13 = r10.getExternalFilesDir(null);
        goto L31
    L21:
        if (r12 != 4) goto L23;
        r13 = r10.getExternalCacheDir();
        goto L31
    L23:
        if (r12 != 5) goto L26;
        r13 = Environment.getExternalStorageDirectory();
        goto L31
    L26:
        throw new NoWhenBranchMatchedException();
    L30:
        r13 = r10.getFilesDir();
        goto L31
    L11:
        r3 = null;
        goto L12
    }

    @Override // com.obric.memorydata.migration.sdk.internal.file.b
    public String a(String r12) {
        Intrinsics.checkNotNullParameter(r12, "uriString");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r13 = Result.m1421constructorimpl(Uri.parse(r12));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r13) == false) goto L10;
        r13 = null;
    L10:
        Uri r14 = (Uri) ZeusTransformUtils.preCheckCast(r13, Uri.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L14;
        return null;
    L14:
        if (Intrinsics.areEqual(r14.getScheme(), Params.CONTENT) == true) goto L16;
    L34:
        return null;
    L16:
        if (Intrinsics.areEqual(r14.getAuthority(), this.f11926a) == false) goto L34;
        List<String> r15 = r14.getPathSegments();
        if (r15 == null) goto L34;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L24;
        r15 = null;
    L24:
        if (r15 == null) goto L34;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r15.get(0), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r3);
        String r4 = b(r3);
        if (r4 != null) goto L29;
        return null;
    L29:
        C0647a r5 = (C0647a) ZeusTransformUtils.preCheckCast(this.d.get(r4), C0647a.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L33;
        return null;
    L33:
        return d(r5.b() + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), 1), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
