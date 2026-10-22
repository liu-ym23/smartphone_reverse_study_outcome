package com.xiphias.browser.scanner;

import android.content.Context;
import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerOptions;", "", "uiKey", "", "<init>", "(Ljava/lang/String;)V", "getUiKey", "()Ljava/lang/String;", "visualSearchEnabled", "", "getVisualSearchEnabled", "()Z", "setVisualSearchEnabled", "(Z)V", "barcodeScanEngine", "Lcom/xiphias/browser/scanner/BarcodeScanEngine;", "getBarcodeScanEngine", "()Lcom/xiphias/browser/scanner/BarcodeScanEngine;", "setBarcodeScanEngine", "(Lcom/xiphias/browser/scanner/BarcodeScanEngine;)V", "documentScanConfig", "Lcom/xiphias/browser/scanner/DocumentScanConfig;", "getDocumentScanConfig", "()Lcom/xiphias/browser/scanner/DocumentScanConfig;", "setDocumentScanConfig", "(Lcom/xiphias/browser/scanner/DocumentScanConfig;)V", "enabledModes", "", "Lcom/xiphias/browser/scanner/ScannerMode;", "getEnabledModes", "()Ljava/util/Set;", "setEnabledModes", "(Ljava/util/Set;)V", "initialMode", "getInitialMode", "()Lcom/xiphias/browser/scanner/ScannerMode;", "setInitialMode", "(Lcom/xiphias/browser/scanner/ScannerMode;)V", "createScanIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "Companion", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16343a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16344b;
    private boolean c;
    private BarcodeScanEngine d;
    private c e;
    private Set<? extends ScannerMode> f;
    private ScannerMode g;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b\u0012J\u0017\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b\u0018J\u0017\u0010\u0019\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b\u001bJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/xiphias/browser/scanner/ScannerOptions$Companion;", "", "<init>", "()V", "EXTRA_UI_KEY", "", "EXTRA_VISUAL_SEARCH_ENABLED", "EXTRA_BARCODE_SCAN_ENGINE", "EXTRA_DOCUMENT_MODEL_DIRECTORY", "EXTRA_DOCUMENT_ENHANCEMENTS", "EXTRA_DOCUMENT_JPEG_QUALITY", "EXTRA_INITIAL_MODE", "EXTRA_ENABLED_MODES", "getUiKey", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "isVisualSearchEnabled", "", "isVisualSearchEnabled$scanner_selectedRelease", "getBarcodeScanEngine", "Lcom/xiphias/browser/scanner/BarcodeScanEngine;", "getBarcodeScanEngine$scanner_selectedRelease", "getDocumentScanConfig", "Lcom/xiphias/browser/scanner/DocumentScanConfig;", "getDocumentScanConfig$scanner_selectedRelease", "getInitialMode", "Lcom/xiphias/browser/scanner/ScannerMode;", "getInitialMode$scanner_selectedRelease", "getEnabledModes", "", "getEnabledModes$scanner_selectedRelease", "defaultEnabledModes", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final Set<ScannerMode> a() {
            if (d.f == false) goto L7;
            ScannerMode r0 = ScannerMode.BARCODE;
        L14:
            return SetsKt.setOf(r0);
        L7:
            if (d.d == false) goto L10;
            r0 = ScannerMode.DOCUMENT;
            goto L14
        L10:
            if (d.e == false) goto L13;
            r0 = ScannerMode.GENERAL;
            goto L14
        L13:
            return SetsKt.emptySet();
        }

        public static final /* synthetic */ Set a(a r0) {
            return r0.a();
        }

        public final String a(Intent r1) {
            if (r1 != null) goto L6;
            return null;
        L6:
            return r1.getStringExtra("com.xiphias.browser.scanner.extra.UI_KEY");
        }

        public final boolean b(Intent r3) {
            if (r3 == null) goto L8;
            if (r3.getBooleanExtra("com.xiphias.browser.scanner.extra.VISUAL_SEARCH_ENABLED", false) != true) goto L8;
            return true;
        L8:
            return false;
        }

        public final BarcodeScanEngine c(Intent r5) {
            Object r4 = null;
            if (r5 == null) goto L5;
            String r6 = r5.getStringExtra("com.xiphias.browser.scanner.extra.BARCODE_SCAN_ENGINE");
        L6:
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(BarcodeScanEngine.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L8:
            if (r0.hasNext() == false) goto L12;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((BarcodeScanEngine) ZeusTransformUtils.preCheckCast(r1, BarcodeScanEngine.class, "com.obric.memorydata.plugin")).name(), r6) == false) goto L8;
            r4 = r1;
        L12:
            BarcodeScanEngine r7 = (BarcodeScanEngine) ZeusTransformUtils.preCheckCast(r4, BarcodeScanEngine.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L15;
            return r7;
        L15:
            if (d.c == false) goto L18;
            return BarcodeScanEngine.BACH;
        L18:
            return BarcodeScanEngine.ZXING;
        L5:
            r6 = null;
            goto L6
        }

        public final c d(Intent r9) {
            Set<? extends DocumentEnhancement> r8 = null;
            if (r9 == null) goto L31;
            String r0 = r9.getStringExtra("com.xiphias.browser.scanner.extra.DOCUMENT_MODEL_DIRECTORY");
            if (r0 == null) goto L31;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
            r0 = null;
        L10:
            if (r0 == null) goto L31;
            c r1 = new c(r0);
            ArrayList<String> r2 = r9.getStringArrayListExtra("com.xiphias.browser.scanner.extra.DOCUMENT_ENHANCEMENTS");
            if (r2 == null) goto L27;
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r5 = r3.iterator();
        L15:
            if (r5.hasNext() == false) goto L26;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(DocumentEnhancement.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L18:
            if (r7.hasNext() == false) goto L22;
            Object r10 = r7.next();
            if (Intrinsics.areEqual(((DocumentEnhancement) ZeusTransformUtils.preCheckCast(r10, DocumentEnhancement.class, "com.obric.memorydata.plugin")).name(), r6) == false) goto L18;
        L23:
            DocumentEnhancement r11 = (DocumentEnhancement) ZeusTransformUtils.preCheckCast(r10, DocumentEnhancement.class, "com.obric.memorydata.plugin");
            if (r11 == null) goto L15;
            r4.add(r11);
            goto L15
        L22:
            r10 = null;
            goto L23
        L26:
            r8 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        L27:
            if (r8 != null) goto L29;
            r8 = SetsKt.emptySet();
        L29:
            r1.a(r8);
            r1.a(r9.getIntExtra("com.xiphias.browser.scanner.extra.DOCUMENT_JPEG_QUALITY", 95));
            return r1;
        L31:
            return null;
        }

        public final ScannerMode e(Intent r3) {
            ScannerMode.a r0 = ScannerMode.Companion;
            if (r3 == null) goto L5;
            String r4 = r3.getStringExtra("com.xiphias.browser.scanner.extra.INITIAL_MODE");
        L6:
            ScannerMode r5 = r0.a(r4);
            if (r5 == null) goto L9;
            return r5;
        L9:
            return (ScannerMode) ZeusTransformUtils.preCheckCast(CollectionsKt.first((Iterable) ZeusTransformUtils.preCheckCast(a(), Iterable.class, "com.obric.memorydata.plugin")), ScannerMode.class, "com.obric.memorydata.plugin");
        L5:
            r4 = null;
            goto L6
        }

        public final Set<ScannerMode> f(Intent r6) {
            if (r6 == null) goto L13;
            ArrayList<String> r7 = r6.getStringArrayListExtra("com.xiphias.browser.scanner.extra.ENABLED_MODES");
            if (r7 == null) goto L13;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
            ScannerMode.a r1 = ScannerMode.Companion;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r9 = r8.iterator();
        L8:
            if (r9.hasNext() == false) goto L12;
            ScannerMode r3 = r1.a((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin"));
            if (r3 == null) goto L8;
            r2.add(r3);
            goto L8
        L12:
            Set r10 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        L14:
            if (r10 != null) goto L16;
            r10 = SetsKt.emptySet();
        L16:
            Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin");
            if (r11.isEmpty() == false) goto L20;
            r11 = a();
        L20:
            return (Set) ZeusTransformUtils.preCheckCast(r11, Set.class, "com.obric.memorydata.plugin");
        L13:
            r10 = null;
            goto L14
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16345a = null;

        static {
            int[] r0 = new int[BarcodeScanEngine.values().length];
            r0[BarcodeScanEngine.BACH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[BarcodeScanEngine.ZXING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f16345a = r0;
        }
    }

    static {
        f16343a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public f(String r3) {
        this.f16344b = r3;
        if (d.e == true) goto L5;
    L9:
        boolean r4 = false;
    L10:
        this.c = r4;
        if (d.c == false) goto L13;
        BarcodeScanEngine r5 = BarcodeScanEngine.BACH;
    L14:
        this.d = r5;
        Set<? extends ScannerMode> r6 = a.a(f16343a);
        this.f = r6;
        this.g = (ScannerMode) ZeusTransformUtils.preCheckCast(CollectionsKt.first((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")), ScannerMode.class, "com.obric.memorydata.plugin");
        return;
    L13:
        r5 = BarcodeScanEngine.ZXING;
        goto L14
    L5:
        if (d.f == true) goto L9;
        if (d.d == true) goto L9;
        r4 = true;
        goto L10
    }

    public /* synthetic */ f(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final Intent a(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        boolean r2 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L68;
        if (this.f.contains(ScannerMode.BARCODE) == false) goto L19;
        int r0 = b.f16345a[this.d.ordinal()];
        if (r0 != 1) goto L9;
        boolean r1 = d.c;
    L14:
        if (r1 == true) goto L19;
        throw new IllegalStateException((this.d + " is not included in this AScan artifact").toString());
    L9:
        if (r0 != 2) goto L12;
        r1 = d.f16340b;
        goto L14
    L12:
        throw new NoWhenBranchMatchedException();
    L19:
        if (this.f.contains(ScannerMode.DOCUMENT) == true) goto L21;
    L32:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L35;
    L37:
        Iterator r4 = r3.iterator();
    L39:
        if (r4.hasNext() == false) goto L36;
        if (((ScannerMode) ZeusTransformUtils.preCheckCast(r4.next(), ScannerMode.class, "com.obric.memorydata.plugin")).isVisualSearch() == false) goto L39;
        boolean r5 = true;
    L43:
        if (r5 == true) goto L45;
    L54:
        Intent r6 = new Intent(r9, ScannerActivity.class);
        r6.putExtra("com.xiphias.browser.scanner.extra.UI_KEY", this.f16344b);
        r6.putExtra("com.xiphias.browser.scanner.extra.VISUAL_SEARCH_ENABLED", this.c);
        r6.putExtra("com.xiphias.browser.scanner.extra.BARCODE_SCAN_ENGINE", this.d.name());
        c r10 = this.e;
        if (r10 == null) goto L61;
        r6.putExtra("com.xiphias.browser.scanner.extra.DOCUMENT_MODEL_DIRECTORY", r10.a());
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r10.b(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r7.iterator();
    L58:
        if (r12.hasNext() == false) goto L60;
        r11.add(((DocumentEnhancement) ZeusTransformUtils.preCheckCast(r12.next(), DocumentEnhancement.class, "com.obric.memorydata.plugin")).name());
        goto L58
    L60:
        r6.putStringArrayListExtra("com.xiphias.browser.scanner.extra.DOCUMENT_ENHANCEMENTS", new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        r6.putExtra("com.xiphias.browser.scanner.extra.DOCUMENT_JPEG_QUALITY", r10.c());
    L61:
        r6.putExtra("com.xiphias.browser.scanner.extra.INITIAL_MODE", this.g.name());
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L63:
        if (r15.hasNext() == false) goto L65;
        r14.add(((ScannerMode) ZeusTransformUtils.preCheckCast(r15.next(), ScannerMode.class, "com.obric.memorydata.plugin")).name());
        goto L63
    L65:
        r6.putStringArrayListExtra("com.xiphias.browser.scanner.extra.ENABLED_MODES", new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        return r6;
    L45:
        if (d.e == true) goto L47;
    L49:
        r2 = false;
    L50:
        if (r2 == true) goto L54;
        throw new IllegalStateException("Vision search is not available or not enabled".toString());
    L47:
        if (this.c == false) goto L49;
    L36:
        r5 = false;
        goto L43
    L35:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L37;
    L21:
        if (d.d == false) goto L31;
        if (this.e == null) goto L25;
        boolean r16 = true;
    L26:
        if (r16 == true) goto L32;
        throw new IllegalStateException("DocumentScanConfig is required when document mode is enabled".toString());
    L25:
        r16 = false;
        goto L26
    L31:
        throw new IllegalStateException("DocAI is not included in this AScan artifact".toString());
    L68:
        throw new IllegalStateException("At least one scanner mode must be enabled".toString());
    }
}
