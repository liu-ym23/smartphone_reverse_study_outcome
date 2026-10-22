package com.obric.memorydata.datatransport.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "sourceInput", "Ljava/io/InputStream;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.utils.EntityFileExporter$saveFile$2$openResult$1", f = "EntityFileExporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EntityFileExporter$saveFile$2$openResult$1 extends SuspendLambda implements Function2<InputStream, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppEntity $entity;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $subDirName;
    final /* synthetic */ e $this_runCatching;
    /* synthetic */ Object L$0;
    int label;

    EntityFileExporter$saveFile$2$openResult$1(e r3, String r4, String r5, AppEntity r6, Continuation<? super EntityFileExporter$saveFile$2$openResult$1> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_runCatching = r3;
        this.$subDirName = r4;
        this.$fileName = r5;
        this.$entity = r6;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        EntityFileExporter$saveFile$2$openResult$1 r11 = new EntityFileExporter$saveFile$2$openResult$1(this.$this_runCatching, this.$subDirName, this.$fileName, this.$entity, r7);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InputStream r3, Continuation<? super Unit> r4) {
        return ((EntityFileExporter$saveFile$2$openResult$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityFileExporter$saveFile$2$openResult$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(InputStream r3, Continuation<? super Unit> r4) {
        return invoke2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L48;
        ResultKt.throwOnFailure(r12);
        InputStream r13 = (InputStream) ZeusTransformUtils.preCheckCast(this.L$0, InputStream.class, "com.obric.memorydata.plugin");
        File r0 = new File(e.a(this.$this_runCatching), this.$subDirName);
        if (r0.exists() == true) goto L14;
        if (r0.mkdirs() == true) goto L14;
        if (r0.exists() == true) goto L14;
        throw new IllegalStateException(e.b.a(e.f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_create_dir_failed, TypedValues.Custom.S_STRING, "data_transport_entity_file_create_dir_failed"), new Object[]{r0.getAbsolutePath()}));
    L14:
        if (ZeusTransformUtils.instanceOf(r13, BufferedInputStream.class) == false) goto L16;
        BufferedInputStream r2 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r13, BufferedInputStream.class, "com.obric.memorydata.plugin");
    L17:
        if (r2 != null) goto L19;
        r2 = new BufferedInputStream(r13);
    L19:
        String r14 = h.f9842a.a(this.$fileName, r2);
        if (Intrinsics.areEqual(r14, this.$fileName) == true) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", "Normalize image extension: " + this.$fileName + " -> " + r14, false, 4, null);
    L22:
        File r4 = new File(r0, r14);
        if (r4.exists() == false) goto L25;
        r4 = new File(r0, this.$entity.getId() + '_' + r14);
    L25:
        File r15 = File.createTempFile(".export_", ".part", r0);
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r15), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        e.a(this.$this_runCatching, (InputStream) ZeusTransformUtils.preCheckCast(r2, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r1, FileOutputStream.class, "com.obric.memorydata.plugin"), OutputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L42
        if (r15.renameTo(r4) == false) goto L36;
        if (r15.exists() == false) goto L34;
        r15.delete();
    L34:
        return Unit.INSTANCE;
    L36:
        throw new IOException("Failed to publish attachment to " + r4.getAbsolutePath());     // Catch: Throwable -> L42
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        if (r15.exists() == false) goto L46;
        r15.delete();
    L46:
        throw th;
    L16:
        r2 = null;
        goto L17
    L48:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
