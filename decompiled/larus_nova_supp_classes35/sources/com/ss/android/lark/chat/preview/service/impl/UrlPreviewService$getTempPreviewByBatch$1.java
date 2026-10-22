package com.ss.android.lark.chat.preview.service.impl;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.url.v1.GetTempPreviewByBatchResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.base.b;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import h6b.g;
import j6b.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.preview.service.impl.UrlPreviewService", f = "UrlPreviewService.kt", i = {}, l = {154}, m = "getTempPreviewByBatch", n = {}, s = {})
final class UrlPreviewService$getTempPreviewByBatch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UrlPreviewService this$0;

    public UrlPreviewService$getTempPreviewByBatch$1(UrlPreviewService r1, Continuation<? super UrlPreviewService$getTempPreviewByBatch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= PluginList.LEVEL_NOT_SET;
        UrlPreviewService r9 = this.this$0;
        r9.getClass();
        int r1 = this.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L5;
        this.label = r1 - PluginList.LEVEL_NOT_SET;
        UrlPreviewService$getTempPreviewByBatch$1 r0 = this;
    L6:
        Object r10 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        Object r3 = null;
        if (r2 != 0) goto L9;
        ResultKt.throwOnFailure(r10);
        throw null;
    L9:
        if (r2 != 1) goto L33;
        ResultKt.throwOnFailure(r10);
        b r11 = (b) r10;
        r11.getClass();
        boolean r4 = r11 instanceof b.b;
        if (r4 == false) goto L16;
        ErrorResult r12 = r11.a();
        if (r12 != null) goto L41;
        r12 = new ErrorResult("get temp preview by batch failed");
    L41:
        return new b.b(r12);
    L16:
        if (r4 == true) goto L19;
        r3 = r11.b();
    L19:
        GetTempPreviewByBatchResponse r5 = (GetTempPreviewByBatchResponse) r3;
        if (r5 == null) goto L42;
        Map r13 = r5.preview_entitys;
        LinkedHashMap r6 = new LinkedHashMap();
        if (r13 == null) goto L31;
        Iterator r14 = r13.entrySet().iterator();
    L26:
        if (r14.hasNext() == false) goto L31;
        Map.Entry r7 = (Map.Entry) r14.next();
        String r15 = (String) r7.getKey();
        UrlPreviewEntity r16 = (UrlPreviewEntity) r7.getValue();
        if (r16 == null) goto L26;
        UrlCardPreviewEntity r17 = d.d(r16, false);
        g r18 = g.b;
        UrlInlinePreviewEntity r19 = r17.getInlineEntity();
        r18.getClass();
        Intrinsics.checkNotNullParameter("[URLPreview] GetTempPreviewByBatchRequest", "tag");
        r18.a.getClass();
        k6b.a.b(r19, "[URLPreview] GetTempPreviewByBatchRequest", BuildConfig.FLAVOR);
        r6.put(r15, r17);
    L31:
        return new b.c(r6);
    L42:
        return new b.b(new ErrorResult("response is null"));
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new UrlPreviewService$getTempPreviewByBatch$1(r9, this);
        goto L6
    }
}
