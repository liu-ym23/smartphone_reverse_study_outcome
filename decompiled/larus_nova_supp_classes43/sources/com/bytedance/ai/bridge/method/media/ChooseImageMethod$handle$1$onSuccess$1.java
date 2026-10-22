package com.bytedance.ai.bridge.method.media;

import com.bytedance.ai.bridge.media.image.AbsChooseImageMethodIDL;
import com.bytedance.ai.bridge.service.ChooseImageFileResult;
import com.bytedance.ai.bridge.service.ChooseImageResultData;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import f3.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import k3.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.media.ChooseImageMethod$handle$1$onSuccess$1", f = "ChooseImageMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChooseImageMethod$handle$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h<AbsChooseImageMethodIDL.b> $callback;
    final /* synthetic */ AppletFileManager $fileManager;
    final /* synthetic */ ChooseImageResultData $result;
    int label;
    final /* synthetic */ ChooseImageMethod this$0;

    public ChooseImageMethod$handle$1$onSuccess$1(ChooseImageResultData r1, ChooseImageMethod r10, AppletFileManager r11, h<AbsChooseImageMethodIDL.b> r12, Continuation<? super ChooseImageMethod$handle$1$onSuccess$1> r13) {
        this.$result = r1;
        this.this$0 = r10;
        this.$fileManager = r11;
        this.$callback = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChooseImageMethod$handle$1$onSuccess$1(this.$result, this.this$0, this.$fileManager, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r19);
        g.a.i("AISDK_JSB_ChooseImageMethod", "call success, fileCount=" + this.$result.getTempFilePaths().size());
        Intrinsics.checkNotNullParameter(AbsChooseImageMethodIDL.b.class, "<this>");
        AbsChooseImageMethodIDL.b r10 = (AbsChooseImageMethodIDL.b) c.a(AbsChooseImageMethodIDL.b.class);
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Iterator<ChooseImageFileResult> r13 = this.$result.getTempFiles().iterator();
    L6:
        if (r13.hasNext() == false) goto L32;
        ChooseImageFileResult r14 = r13.next();
        ChooseImageMethod r0 = this.this$0;
        AppletFileManager r15 = this.$fileManager;
        String r16 = r14.getPath();
        int r17 = ChooseImageMethod.b;
        r0.getClass();
        if (r15 != null) goto L36;
    L27:
        String r1 = null;
    L28:
        if (r1 == null) goto L29;
        r11.add(r1);
        r12.add(new AbsChooseImageMethodIDL.ChooseImageFileInfo(r1, r14.getSize(), r14.getType()));
        goto L6
    L29:
        g r18 = g.a;
        StringBuilder r20 = new StringBuilder("call failed, errNo=");
        f3.a r21 = f3.a.f;
        r20.append(r21.a);
        r20.append(", msg=failed to encode file path");
        r18.e("AISDK_JSB_ChooseImageMethod", r20.toString());
        h.a.a(this.$callback, "failed to encode file path", r21, null, 10);
        return Unit.INSTANCE;
    L36:
        PolarisFileWrapper r110 = new PolarisFileWrapper(r16);     // Catch: Exception -> L25
        if (r110.exists() == false) goto L27;
        String r22 = FilesKt.getExtension(r110);     // Catch: Exception -> L25
        if (r22.length() <= 0) goto L16;
        boolean r23 = true;
    L17:
        if (r23 == false) goto L19;
        String r24 = ".".concat(r22);     // Catch: Exception -> L25
    L20:
        PolarisFileWrapper r25 = new PolarisFileWrapper(r15.e, UUID.randomUUID() + r24);     // Catch: Exception -> L25
        if (Intrinsics.areEqual(r25.getAbsolutePath(), r110.getAbsolutePath()) == true) goto L23;
        FilesKt.copyTo$default(r110, r25, true, 0, 4, null);     // Catch: Exception -> L25
    L23:
        r1 = r15.e(r25).a();     // Catch: Exception -> L25
        goto L28
    L19:
        r24 = "";
        goto L20
    L16:
        r23 = false;
    L25:
        e = move-exception;
        g.a.e("AISDK_JSB_ChooseImageMethod", "copyToTempAndEncode failed: " + e);
        goto L27
    L32:
        r10.setTempFilePaths(r11);
        r10.setTempFiles(r12);
        h.a.b(this.$callback, r10);
        return Unit.INSTANCE;
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
