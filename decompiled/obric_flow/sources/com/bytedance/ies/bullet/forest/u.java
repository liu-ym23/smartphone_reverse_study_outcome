package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.ProcessedData;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.ui.image.f0;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends ForestPostProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5421a;

    public u(String r5, int r10) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        super(true);
        this.f5421a = r5;
    }

    @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
    public final ProcessedData onProcess(com.bytedance.forest.postprocessor.f r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        if (r10.f4550c == false) goto L31;
        InputStream r5 = (InputStream) r10.f4551h.getValue();
        f0.h("TemplateBundleProcessor", 60, "TemplateBundleProcessor onProcess", false);     // Catch: Throwable -> L13
        byte[] r11 = ByteStreamsKt.readBytes(r5);     // Catch: Throwable -> L13
        int r12 = (r11.length * 3) / 2;     // Catch: Throwable -> L13
        f0.h("TemplateBundleProcessor", 60, "size: " + r12, false);     // Catch: Throwable -> L13
        TemplateBundle r13 = TemplateBundle.a(r11);     // Catch: Throwable -> L13
        String r14 = this.f5421a;
        if (r14 != null) goto L9;
    L15:
        String r15 = r10.f4549b;
        if (r15 != null) goto L18;
    L21:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L13
        ProcessedData r17 = new ProcessedData(r12, r13);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r5, null);
        return r17;
    L18:
        if (r15.length() == 0) goto L21;
        f0.h("TemplateBundleProcessor", 60, "====preCodeCache======", false);     // Catch: Throwable -> L13
        r13.b(r15);     // Catch: Throwable -> L13
        goto L21
    L9:
        if (r14.length() == 0) goto L15;
        f0.h("TemplateBundleProcessor", 60, "====preCodeCache======", false);     // Catch: Throwable -> L13
        r13.b(r14);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        f0.g(112, "TemplateBundleProcessor", "error occurs when read data", th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L31:
        f0.h("TemplateBundleProcessor", 60, "Only preload request can be processed", false);
        throw new Throwable("Only preload request can be processed");
    }
}
