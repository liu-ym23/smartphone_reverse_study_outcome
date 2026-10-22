package com.xiphias.browser.scanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.google.zxing.BarcodeFormat;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR \u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/xiphias/browser/scanner/ScannerIntentResult;", "", "<init>", "()V", "resultCode", "", "getResultCode", "()Ljava/lang/Integer;", "setResultCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "contents", "", "getContents", "()Ljava/lang/String;", "setContents", "(Ljava/lang/String;)V", "barcodeFormat", "Lcom/google/zxing/BarcodeFormat;", "getBarcodeFormat", "()Lcom/google/zxing/BarcodeFormat;", "setBarcodeFormat", "(Lcom/google/zxing/BarcodeFormat;)V", "documentOriginalImageUri", "Landroid/net/Uri;", "getDocumentOriginalImageUri", "()Landroid/net/Uri;", "setDocumentOriginalImageUri", "(Landroid/net/Uri;)V", "documentImageUri", "getDocumentImageUri", "setDocumentImageUri", "documentEnhancements", "", "Lcom/xiphias/browser/scanner/DocumentEnhancement;", "getDocumentEnhancements", "()Ljava/util/Set;", "setDocumentEnhancements", "(Ljava/util/Set;)V", "Companion", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16341a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f16342b;
    private String c;
    private BarcodeFormat d;
    private Uri e;
    private Uri f;
    private Set<? extends DocumentEnhancement> g;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerIntentResult$Companion;", "", "<init>", "()V", "CONTENTS", "", "BARCODE_FORMAT", "DOCUMENT_ORIGINAL_IMAGE_URI", "DOCUMENT_IMAGE_URI", "DOCUMENT_ENHANCEMENTS", "parseActivityResult", "Lcom/xiphias/browser/scanner/ScannerIntentResult;", "resultCode", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final e a(int r7, Intent r8) {
            if (r7 != (-1)) goto L33;
            if (r8 == null) goto L33;
            e r6 = new e();
            r6.a(Integer.valueOf(r7));
            String r9 = r8.getStringExtra("contents");
            if (r9 != null) goto L8;
            r9 = "";
        L8:
            r6.a(r9);
            if (Build.VERSION.SDK_INT < 33) goto L11;
            r6.a((BarcodeFormat) ZeusTransformUtils.preCheckCast(r8.getSerializableExtra("barcodeFormat", BarcodeFormat.class), BarcodeFormat.class, "com.obric.memorydata.plugin"));
            r6.b((Uri) ZeusTransformUtils.preCheckCast(r8.getParcelableExtra("documentImageUri", Uri.class), Uri.class, "com.obric.memorydata.plugin"));
            Object r10 = r8.getParcelableExtra("documentOriginalImageUri", Uri.class);
        L12:
            r6.a((Uri) ZeusTransformUtils.preCheckCast(r10, Uri.class, "com.obric.memorydata.plugin"));
            ArrayList<String> r11 = r8.getStringArrayListExtra("documentEnhancements");
            Set<? extends DocumentEnhancement> r12 = null;
            if (r11 == null) goto L28;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r14 = r13.iterator();
        L16:
            if (r14.hasNext() == false) goto L27;
            String r1 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
            Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(DocumentEnhancement.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L19:
            if (r2.hasNext() == false) goto L23;
            Object r4 = r2.next();
            if (Intrinsics.areEqual(((DocumentEnhancement) ZeusTransformUtils.preCheckCast(r4, DocumentEnhancement.class, "com.obric.memorydata.plugin")).name(), r1) == false) goto L19;
        L24:
            DocumentEnhancement r3 = (DocumentEnhancement) ZeusTransformUtils.preCheckCast(r4, DocumentEnhancement.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L16;
            r0.add(r3);
            goto L16
        L23:
            r4 = null;
            goto L24
        L27:
            r12 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        L28:
            if (r12 != null) goto L30;
            r12 = SetsKt.emptySet();
        L30:
            r6.a(r12);
            return r6;
        L11:
            r6.b((Uri) ZeusTransformUtils.preCheckCast(r8.getParcelableExtra("documentImageUri"), Uri.class, "com.obric.memorydata.plugin"));
            r10 = r8.getParcelableExtra("documentOriginalImageUri");
        L33:
            return new e();
        }
    }

    static {
        f16341a = new a(null);
    }

    public e() {
        this.c = "";
        this.g = SetsKt.emptySet();
    }

    public final Integer a() {
        return this.f16342b;
    }

    public final void a(Uri r1) {
        this.e = r1;
    }

    public final void a(BarcodeFormat r1) {
        this.d = r1;
    }

    public final void a(Integer r1) {
        this.f16342b = r1;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void a(Set<? extends DocumentEnhancement> r3) {
        Set<? extends DocumentEnhancement> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.g = r4;
    }

    public final String b() {
        return this.c;
    }

    public final void b(Uri r1) {
        this.f = r1;
    }
}
