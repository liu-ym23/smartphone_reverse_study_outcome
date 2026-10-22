package com.obric.memorydata.database.util.file_utils;

import android.graphics.Bitmap;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.util.file_utils.PdfFileProcessor$processPageImages$2", f = "PdfFileProcessor.kt", i = {0}, l = {184}, m = "invokeSuspend", n = {"resources"}, s = {"L$0"})
final class PdfFileProcessor$processPageImages$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tom_roush.pdfbox.pdmodel.c $document;
    final /* synthetic */ j $documentTree;
    final /* synthetic */ FileEntity $fileEntity;
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ int $parentId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PdfFileProcessor this$0;

    PdfFileProcessor$processPageImages$2(com.tom_roush.pdfbox.pdmodel.c r3, int r4, PdfFileProcessor r5, j r6, int r7, FileEntity r8, Continuation<? super PdfFileProcessor$processPageImages$2> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$document = r3;
        this.$pageIndex = r4;
        this.this$0 = r5;
        this.$documentTree = r6;
        this.$parentId = r7;
        this.$fileEntity = r8;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PdfFileProcessor$processPageImages$2(this.$document, this.$pageIndex, this.this$0, this.$documentTree, this.$parentId, this.$fileEntity, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((PdfFileProcessor$processPageImages$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PdfFileProcessor$processPageImages$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00c6 -> B:38:0x00c9). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r21) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L11;
        Iterator<com.tom_roush.pdfbox.a.i> r6 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$1, Iterator.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.pdmodel.i r7 = (com.tom_roush.pdfbox.pdmodel.i) ZeusTransformUtils.preCheckCast(this.L$0, com.tom_roush.pdfbox.pdmodel.i.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r21);     // Catch: Exception -> L8
        Object r1 = r21;
        com.tom_roush.pdfbox.pdmodel.i r15 = r7;
    L38:
    L27:
        Exception e = e;
    L28:
        RunLog.INSTANCE.error("PdfFileProcessor", "Failed to process image on page " + (this.$pageIndex + 1), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L30
    L14:
        if (r6.hasNext() == false) goto L33;
        com.tom_roush.pdfbox.pdmodel.graphics.d r3 = r15.f((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r6.next(), com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L30
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.pdmodel.graphics.d.b.class) == false) goto L14;
        String r10 = PdfFileProcessor.a(this.this$0, (com.tom_roush.pdfbox.pdmodel.graphics.d.b) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.pdmodel.graphics.d.b.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L27
        Bitmap r4 = ((com.tom_roush.pdfbox.pdmodel.graphics.d.b) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.pdmodel.graphics.d.b.class, "com.obric.memorydata.plugin")).k();     // Catch: Exception -> L27
        PdfFileProcessor r8 = this.this$0;     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L27
        byte[] r9 = PdfFileProcessor.a(r8, r4, r10);     // Catch: Exception -> L27
        if (r9 == null) goto L14;
        PdfFileProcessor r11 = this.this$0;     // Catch: Exception -> L27
        j r5 = this.$documentTree;     // Catch: Exception -> L27
        int r14 = this.$parentId;     // Catch: Exception -> L27
        FileEntity r13 = this.$fileEntity;     // Catch: Exception -> L27
        i r16 = new i(r10, null, 1, 2, null);     // Catch: Exception -> L27
        this.L$0 = r15;     // Catch: Exception -> L27
        this.L$1 = r6;     // Catch: Exception -> L27
        this.label = 1;     // Catch: Exception -> L27
        r1 = r11.a(r9, r16, r5, r14, r13, true, this);     // Catch: Exception -> L27
        if (r1 != r2) goto L38;
        return r2;
    L33:
        return Unit.INSTANCE;
    L24:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L14;
        return Unit.INSTANCE;
    L8:
        e = e;
        r15 = r7;
        goto L28
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r21);
        com.tom_roush.pdfbox.pdmodel.i r12 = this.$document.a(this.$pageIndex).getResources();     // Catch: Exception -> L30
        r6 = r12.b().iterator();     // Catch: Exception -> L30
        r15 = r12;
    L30:
        e = move-exception;
        RunLog.INSTANCE.error("PdfFileProcessor", "Error processing images on page " + (this.$pageIndex + 1), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L33
    }
}
