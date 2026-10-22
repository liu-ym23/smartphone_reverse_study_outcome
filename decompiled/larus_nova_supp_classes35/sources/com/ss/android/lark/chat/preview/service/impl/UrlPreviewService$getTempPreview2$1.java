package com.ss.android.lark.chat.preview.service.impl;

import com.larksuite.framework.callback.CancelableGetDataCallback;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.preview.service.impl.UrlPreviewService", f = "UrlPreviewService.kt", i = {0, 0, 0, 0, 0, 0}, l = {366}, m = "getTempPreview2-yxL6bBk", n = {"url", "baseContext", "$this$getTempPreview2_yxL6bBk_u24lambda_u241", "$completion$iv", Keys.API_RETURN_KEY_APP_ID, IPortraitService.TYPE}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "J$1"})
final class UrlPreviewService$getTempPreview2$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UrlPreviewService this$0;

    public UrlPreviewService$getTempPreview2$1(UrlPreviewService r1, Continuation<? super UrlPreviewService$getTempPreview2$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= PluginList.LEVEL_NOT_SET;
        UrlPreviewService r10 = this.this$0;
        r10.getClass();
        int r1 = this.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L5;
        this.label = r1 - PluginList.LEVEL_NOT_SET;
        UrlPreviewService$getTempPreview2$1 r0 = this;
    L6:
        Object r2 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        UrlPreviewService$getTempPreview2$1 r11 = (UrlPreviewService$getTempPreview2$1) r0.L$3;
        UrlPreviewService r12 = (UrlPreviewService) r0.L$2;
        String r13 = (String) r0.L$1;
        String r14 = (String) r0.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L17
        Object r15 = Result.constructor-impl((UrlCardPreviewEntity) r2);     // Catch: Throwable -> L17
    L20:
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        return r15;
    L23:
        return Result.box-impl(r15);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        r0.L$0 = null;     // Catch: Throwable -> L17
        r0.L$1 = null;     // Catch: Throwable -> L17
        r0.L$2 = r10;     // Catch: Throwable -> L17
        r0.L$3 = r0;     // Catch: Throwable -> L17
        r0.J$0 = 0;     // Catch: Throwable -> L17
        r0.J$1 = 0;     // Catch: Throwable -> L17
        r0.label = 1;     // Catch: Throwable -> L17
        final j r16 = new j(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L17
        r16.C();     // Catch: Throwable -> L17
        final CancelableGetDataCallback r7 = new CancelableGetDataCallback(new UrlPreviewService$getTempPreview2$2$1$callback$1(r16));     // Catch: Throwable -> L17
        r16.i(new UrlPreviewService$getTempPreview2$2$1$1(r7));     // Catch: Throwable -> L17
        UrlPreviewService.d(null, 0, 0, r7);     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L5:
        r0 = new UrlPreviewService$getTempPreview2$1(r10, this);
        goto L6
    }
}
