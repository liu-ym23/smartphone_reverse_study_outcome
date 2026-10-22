package com.xiphias.browser.scanner.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.DocumentEnhancement;
import com.xiphias.browser.scanner.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/xiphias/browser/scanner/document/DocumentProcessingContract;", "", "<init>", "()V", "EXTRA_ORIGINAL_URI", "", "EXTRA_MODEL_DIRECTORY", "EXTRA_ENHANCEMENTS", "EXTRA_JPEG_QUALITY", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "originalUri", "Landroid/net/Uri;", "config", "Lcom/xiphias/browser/scanner/DocumentScanConfig;", "PROCESSING_ACTIVITY_CLASS", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16319a = null;

    static {
        f16319a = new b();
    }

    private b() {
    }

    public final Intent a(Context r4, Uri r5, com.xiphias.browser.scanner.c r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "originalUri");
        Intrinsics.checkNotNullParameter(r6, "config");
        if (d.d == false) goto L11;
        Intent r7 = new Intent().setClassName(r3, "com.xiphias.browser.scanner.document.DocumentProcessingActivity");
        Intrinsics.checkNotNullExpressionValue(r7, "setClassName(...)");
        r7.putExtra("originalUri", r5.toString());
        r7.putExtra("modelDirectory", r6.a());
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6.b(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        r9.add(((DocumentEnhancement) ZeusTransformUtils.preCheckCast(r10.next(), DocumentEnhancement.class, "com.obric.memorydata.plugin")).name());
        goto L6
    L8:
        r7.putStringArrayListExtra("enhancements", new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        r7.putExtra("jpegQuality", r6.c());
        return r7;
    L11:
        throw new IllegalStateException("DocAI is not included in this AScan artifact".toString());
    }
}
