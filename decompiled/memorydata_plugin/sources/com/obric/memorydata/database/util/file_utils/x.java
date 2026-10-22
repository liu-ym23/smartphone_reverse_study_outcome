package com.obric.memorydata.database.util.file_utils;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import javax.xml.stream.XMLStreamException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J&\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J6\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J&\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PptxPreflightValidator;", "", "<init>", "()V", "TAG", "", "validate", "Lcom/obric/memorydata/database/util/file_utils/PptxPreflightResult;", "file", "Ljava/io/File;", "isPresentationXmlPart", "", "entryName", "createXmlInputFactory", "Ljavax/xml/stream/XMLInputFactory;", "scanXml", "", "inputStream", "Ljava/io/InputStream;", "inputFactory", "stats", "Lcom/obric/memorydata/database/util/file_utils/MutablePptxPreflightStats;", "validateXmlEntryMetadata", "entry", "Ljava/util/zip/ZipEntry;", "recordElementName", "reader", "Ljavax/xml/stream/XMLStreamReader;", "expatInternedNames", "", "recordQualifiedName", "namespaceUri", "localName", "prefix", "recordExpatName", EventBody.KEY_VALUE, "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f9673a = null;

    static {
        f9673a = new x();
    }

    private x() {
    }

    private static final Object a(String r0, String r1, String r2, String r3) {
        throw new XMLStreamException("PPTX preflight does not allow external entities");
    }

    private final javax.xml.stream.b a() {
        com.ctc.wstx.h.a r3 = new com.ctc.wstx.h.a();
        r3.a("javax.xml.stream.isNamespaceAware", true);
        r3.a("javax.xml.stream.supportDTD", false);
        r3.a("javax.xml.stream.isSupportingExternalEntities", false);
        r3.a("javax.xml.stream.isReplacingEntityReferences", false);
        r3.a("com.ctc.wstx.lazyParsing", false);
        r3.a("org.codehaus.stax2.internNames", false);
        r3.a("org.codehaus.stax2.internNsUris", false);
        r3.a("org.codehaus.stax2.closeInputSource", false);
        r3.a("com.ctc.wstx.maxEntityCount", 1);
        r3.a("com.ctc.wstx.maxEntityDepth", 1);
        r3.a("com.ctc.wstx.maxAttributesPerElement", 10000);
        r3.a("com.ctc.wstx.maxAttributeSize", 1048576);
        r3.a("com.ctc.wstx.maxElementCount", 500000L);
        r3.a("com.ctc.wstx.maxTextLength", 16777216);
        r3.a("com.ctc.wstx.maxCharacters", 67108864L);
        r3.a($$Lambda$x$uZ9r4wexr90dFHwyinlu5dn_ns.INSTANCE);
        return (javax.xml.stream.b) ZeusTransformUtils.preCheckCast(r3, javax.xml.stream.b.class, "com.obric.memorydata.plugin");
    }

    private final void a(InputStream r6, javax.xml.stream.b r7, r r8) {
        HashSet r0 = new HashSet();
        r8.d(1);
        javax.xml.stream.e r9 = r7.a(r6);
        int r10 = 0;
    L25:
    L22:
        th = move-exception;
        r9.close();
        throw th;
    L4:
        if (r9.hasNext() == false) goto L20;
        int r2 = r9.next();     // Catch: Throwable -> L22
        if (r2 != 1) goto L9;
        r10 = r10 + 1;     // Catch: Throwable -> L22
        if (r10 > 256) goto L19;
        r8.c(r9.getAttributeCount() + 1);     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L22
        a(r9, (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"), r8);     // Catch: Throwable -> L22
        goto L25
    L19:
        throw new PptxPreflightLimitException(PptxPreflightRejectReason.XML_RESOURCE_LIMIT);     // Catch: Throwable -> L22
    L9:
        if (r2 != 2) goto L11;
        r10 = r10 - 1;     // Catch: Throwable -> L22
        goto L25
    L11:
        if (r2 != 3) goto L25;
        String r3 = r9.getPITarget();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r3, "getPITarget(...)");     // Catch: Throwable -> L22
        a(r3, (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"), r8);     // Catch: Throwable -> L22
        goto L25
    L20:
        r9.close();
    }

    private final void a(String r3, String r4, String r5, Set<String> r6, r r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        a(r3, r8, r7);
        a(r4, r8, r7);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L9;
        a(r5 + ':' + r4, r8, r7);
        return;
    L9:
        return;
    L5:
        r9 = false;
        goto L6
    }

    private final void a(String r2, Set<String> r3, r r4) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L8;
        return;
    L8:
        if (r1.add(r2) == false) goto L12;
        r4.d(1);
        return;
    L12:
        return;
    L5:
        r5 = false;
        goto L6
    }

    private final void a(ZipEntry r7, r r8) {
        long r0 = r7.getSize();
        if (r0 > 67108864) goto L17;
        if (r0 > (268435456 - r8.c())) goto L17;
        long r6 = r7.getCompressedSize();
        if (r0 > WsConstants.DEFAULT_IO_LIMIT) goto L9;
        return;
    L9:
        if (r6 >= 0) goto L11;
        return;
    L11:
        if ((r6 / r0) < 0.01d) goto L14;
        return;
    L14:
        throw new PptxPreflightLimitException(PptxPreflightRejectReason.ZIP_RESOURCE_LIMIT);
    L17:
        throw new PptxPreflightLimitException(PptxPreflightRejectReason.XML_RESOURCE_LIMIT);
    }

    private final void a(javax.xml.stream.e r9, Set<String> r10, r r11) {
        javax.xml.stream.e r12 = (javax.xml.stream.e) ZeusTransformUtils.wrapperContextForParams(r9, javax.xml.stream.e.class, "com.obric.memorydata.plugin");
        Set<String> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        String r0 = r12.getNamespaceURI();
        if (r0 != null) goto L5;
        String r1 = "";
    L6:
        String r2 = r12.getLocalName();
        Intrinsics.checkNotNullExpressionValue(r2, "getLocalName(...)");
        String r3 = r12.getPrefix();
        if (r3 != null) goto L9;
        String r4 = "";
    L10:
        a(r1, r2, r4, r13, r11);
        int r8 = r12.getNamespaceCount();
        int r5 = 0;
    L11:
        if (r5 >= r8) goto L19;
        x r6 = f9673a;
        String r7 = r12.getNamespacePrefix(r5);
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        r6.a(r7, r13, r11);
        String r14 = r12.getNamespaceURI(r5);
        if (r14 != null) goto L18;
        r14 = "";
    L18:
        r6.a(r14, r13, r11);
        r5 = r5 + 1;
        goto L11
    L19:
        int r15 = r12.getAttributeCount();
        int r16 = 0;
    L20:
        if (r16 >= r15) goto L28;
        x r17 = f9673a;
        String r18 = r12.getAttributeNamespace(r16);
        if (r18 != null) goto L24;
        r18 = "";
    L24:
        String r19 = r12.getAttributeLocalName(r16);
        Intrinsics.checkNotNullExpressionValue(r19, "getAttributeLocalName(...)");
        String r20 = r12.getAttributePrefix(r16);
        if (r20 != null) goto L27;
        r20 = "";
    L27:
        r17.a(r18, r19, r20, r13, r11);
        r16 = r16 + 1;
        goto L20
    L28:
        return;
    L9:
        r4 = r3;
        goto L10
    L5:
        r1 = r0;
        goto L6
    }

    private final boolean a(String r5) {
        if (StringsKt.endsWith$default(r5, ".xml", false, 2, null) == false) goto L5;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r5, "[content_types].xml") == true) goto L19;
        if (Intrinsics.areEqual(r5, "_rels/.rels") == true) goto L19;
        if (StringsKt.startsWith$default(r5, "ppt/", false, 2, null) == true) goto L19;
        return false;
    L19:
        return true;
    L5:
        if (StringsKt.endsWith$default(r5, ".rels", false, 2, null) == true) goto L10;
        if (StringsKt.endsWith$default(r5, ".vml", false, 2, null) == true) goto L10;
        r4 = false;
        goto L11
    }

    /* JADX INFO: renamed from: lambda$uZ9r4we-xr90dFHwyinlu5dn_ns, reason: not valid java name */
    public static /* synthetic */ Object m587lambda$uZ9r4wexr90dFHwyinlu5dn_ns(String r0, String r1, String r2, String r3) {
        return a(r0, r1, r2, r3);
    }

    public final v a(File r19) {
        String r1 = "";
        Intrinsics.checkNotNullParameter(r19, "file");
        r r4 = new r();
        javax.xml.stream.b r5 = a();     // Catch: IOException -> L36 ZipException -> L42 XMLStreamException -> L48 PptxPreflightLimitException -> L55
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipFile(r19), Closeable.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L36 ZipException -> L42 XMLStreamException -> L48 PptxPreflightLimitException -> L55
        ZipFile r0 = (ZipFile) ZeusTransformUtils.preCheckCast(r6, ZipFile.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Enumeration<? extends ZipEntry> r7 = r0.entries();     // Catch: Throwable -> L29
    L6:
        if (r7.hasMoreElements() == false) goto L26;
        ZipEntry r8 = (ZipEntry) ZeusTransformUtils.preCheckCast(r7.nextElement(), ZipEntry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        r4.a(r4.a() + 1);     // Catch: Throwable -> L29
        if (r4.a() > 10000) goto L25;
        String r12 = r8.getName();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r12, "getName(...)");     // Catch: Throwable -> L29
        String r10 = StringsKt.replace$default(r12, '\\', '/', false, 4, null);     // Catch: Throwable -> L29
        Locale r11 = Locale.ROOT;     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r11, "ROOT");     // Catch: Throwable -> L29
        String r13 = r10.toLowerCase(r11);     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r13, "toLowerCase(...)");     // Catch: Throwable -> L29
        if (r8.isDirectory() == true) goto L6;
        x r14 = f9673a;     // Catch: Throwable -> L29
        if (r14.a(r13) == false) goto L6;
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L29
        r14.a(r8, r4);     // Catch: Throwable -> L29
        r4.b(r4.b() + 1);     // Catch: Throwable -> L29
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r0.getInputStream(r8), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        InputStream r15 = (InputStream) ZeusTransformUtils.preCheckCast(r9, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L17
        r14.a((InputStream) ZeusTransformUtils.preCheckCast(new e(r15, r4), InputStream.class, "com.obric.memorydata.plugin"), r5, r4);     // Catch: Throwable -> L17
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L29
        goto L6
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L25:
        throw new PptxPreflightLimitException(PptxPreflightRejectReason.ZIP_RESOURCE_LIMIT);     // Catch: Throwable -> L29
    L26:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r6, null);     // Catch: IOException -> L36 ZipException -> L42 XMLStreamException -> L48 PptxPreflightLimitException -> L55
        return (v) ZeusTransformUtils.preCheckCast(new v.a(r4.d()), v.class, "com.obric.memorydata.plugin");
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: IOException -> L36 ZipException -> L42 XMLStreamException -> L48 PptxPreflightLimitException -> L55
        throw th;     // Catch: IOException -> L36 ZipException -> L42 XMLStreamException -> L48 PptxPreflightLimitException -> L55
    L55:
        e = move-exception;
        Object r3 = ZeusTransformUtils.preCheckCast(new v.b(e.getReason(), r4.d()), v.class, "com.obric.memorydata.plugin");
    L58:
        return (v) r3;
    L42:
        e = move-exception;
        IRunLog r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r18 = new StringBuilder().append("PPTX 预检 ZIP 解析异常，type=").append(e.getClass().getSimpleName()).append(", message=");
        com.obric.memorydata.utils.q r20 = com.obric.memorydata.utils.q.f13259a;
        String r21 = e.getMessage();
        if (r21 == null) goto L47;
        r1 = r21;
    L47:
        IRunLog.a.a(r17, "PptxPreflightValidator", r18.append(r20.b(r1)).toString(), null, 4, null);
        v.b r22 = new v.b(PptxPreflightRejectReason.XML_STRUCTURE, r4.d());
    L54:
        r3 = ZeusTransformUtils.preCheckCast(r22, v.class, "com.obric.memorydata.plugin");
    L36:
        e = move-exception;
        IRunLog r23 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r24 = new StringBuilder().append("PPTX 预检 I/O 异常，type=").append(e.getClass().getSimpleName()).append(", message=");
        com.obric.memorydata.utils.q r25 = com.obric.memorydata.utils.q.f13259a;
        String r26 = e.getMessage();
        if (r26 == null) goto L41;
        r1 = r26;
    L41:
        IRunLog.a.a(r23, "PptxPreflightValidator", r24.append(r25.b(r1)).toString(), null, 4, null);
        r22 = new v.b(PptxPreflightRejectReason.XML_STRUCTURE, r4.d());
    L48:
        e = move-exception;
        IRunLog r27 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r28 = new StringBuilder().append("PPTX 预检 XML 解析异常，type=").append(e.getClass().getSimpleName()).append(", message=");
        com.obric.memorydata.utils.q r29 = com.obric.memorydata.utils.q.f13259a;
        String r30 = e.getMessage();
        if (r30 == null) goto L53;
        r1 = r30;
    L53:
        IRunLog.a.a(r27, "PptxPreflightValidator", r28.append(r29.b(r1)).toString(), null, 4, null);
        r22 = new v.b(PptxPreflightRejectReason.XML_STRUCTURE, r4.d());
        goto L54
    }
}
