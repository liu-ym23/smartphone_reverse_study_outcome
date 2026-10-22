package com.obric.memorydata.memory.ui.automemory.memorylist;

import com.obric.memorydata.datatransport.api.MemoryBuildExportRequest;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aV\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000220\b\u0002\u0010\u0006\u001a*\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H\u0080@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"exportAutoMemoryPreviewPackage", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Ljava/io/File;", "autoMemoryId", "", "outputDir", "previewExporter", "Lkotlin/Function3;", "Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;", "Lkotlin/coroutines/Continuation;", "", "(JLjava/io/File;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class h {
    public static final Object a(long r7, File r9, Function3<? super MemoryBuildExportRequest, ? super File, ? super Continuation<? super z<? extends File>>, ? extends Object> r10, Continuation<? super z<? extends File>> r11) {
        Function3 r12 = (Function3) ZeusTransformUtils.wrapperContextForParams(r10, Function3.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return r12.invoke(new MemoryBuildExportRequest(null, false, Boxing.boxLong(r7), 3, null), r9, r13);
    }

    public static /* synthetic */ Object a(long r1, File r3, Function3 r4, Continuation r5, int r6, Object r7) {
        Function3 r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r8 = (Function3) ZeusTransformUtils.preCheckCast(new AutoMemoryProFeedbackHelperKt$exportAutoMemoryPreviewPackage$2(null), Function3.class, "com.obric.memorydata.plugin");
    L6:
        return a(r1, r3, r8, r9);
    }
}
