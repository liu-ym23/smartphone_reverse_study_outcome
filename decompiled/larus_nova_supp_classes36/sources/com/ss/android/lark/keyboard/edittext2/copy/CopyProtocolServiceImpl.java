package com.ss.android.lark.keyboard.edittext2.copy;

import b38.b;
import com.bytedance.lark.pb.im.v1.BatchHardLinkResourcesV2Request;
import com.bytedance.lark.pb.im.v1.BatchHardLinkResourcesV2Response;
import com.bytedance.lark.pb.im.v1.ResourceExtraInfo;
import com.bytedance.lark.pb.im.v1.TransformHtmlToRichTextRequest;
import com.bytedance.lark.pb.im.v1.TransformHtmlToRichTextResponse;
import com.bytedance.lark.pb.im.v1.TransformRichTextToHtmlRequest;
import com.bytedance.lark.pb.im.v1.TransformRichTextToHtmlResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CopyProtocolServiceImpl implements com.ss.android.lark.keyboard.edittext2.copy.a {
    public final a b;

    public interface a {
        @SdkCall(50703)
        RucketJob<BatchHardLinkResourcesV2Response> batchHardLinkV2(BatchHardLinkResourcesV2Request r1);

        @SdkCall(50701)
        RucketJob<TransformHtmlToRichTextResponse> htmlToRichText(TransformHtmlToRichTextRequest r1);

        @SdkCall(50702)
        RucketJob<TransformRichTextToHtmlResponse> richTextToHtml(TransformRichTextToHtmlRequest r1);
    }

    public CopyProtocolServiceImpl() {
        this.b = (a) b.a.create(a.class);
    }

    public final Object a(String r5, Continuation<? super Result<com.ss.android.lark.keyboard.edittext2.copy.a.C0136a>> r6) {
        if ((r6 instanceof CopyProtocolServiceImpl$htmlToRichText$1) == false) goto L7;
        CopyProtocolServiceImpl$htmlToRichText$1 r0 = (CopyProtocolServiceImpl$htmlToRichText$1) r6;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        com.larksuite.rucket.job.base.b r8 = (com.larksuite.rucket.job.base.b) r7;
        r8.getClass();
        if ((r8 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L24;
        Result.Companion r9 = Result.Companion;
        ErrorResult r10 = r8.a();
        if (r10 != null) goto L23;
        r10 = new ErrorResult("");
    L23:
        return Result.constructor-impl(ResultKt.createFailure(r10));
    L24:
        TransformHtmlToRichTextResponse r11 = (TransformHtmlToRichTextResponse) r8.b();
        Result.Companion r12 = Result.Companion;
        return Result.constructor-impl(new com.ss.android.lark.keyboard.edittext2.copy.a.C0136a(g0.e(r11.rich_text, null), r11.extra_infos));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        RucketJob<TransformHtmlToRichTextResponse> r13 = this.b.htmlToRichText(new TransformHtmlToRichTextRequest.Builder().html_string(r5).build());
        r0.label = 1;
        r7 = r13.awaitGet(r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new CopyProtocolServiceImpl$htmlToRichText$1(this, r6);
        goto L8
    }

    public final Object b(RichText r5, List<ResourceExtraInfo> r6, Continuation<? super String> r7) {
        if ((r7 instanceof CopyProtocolServiceImpl$richTextToHtml$1) == false) goto L7;
        CopyProtocolServiceImpl$richTextToHtml$1 r0 = (CopyProtocolServiceImpl$richTextToHtml$1) r7;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        com.larksuite.rucket.job.base.b r9 = (com.larksuite.rucket.job.base.b) r8;
        r9.getClass();
        if ((r9 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L20;
        return "";
    L20:
        String r10 = ((TransformRichTextToHtmlResponse) r9.b()).html_string;
        if (r10 != null) goto L24;
        return "";
    L24:
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        com.bytedance.lark.pb.basic.v1.RichText r11 = g0.d(r5);
        RucketJob<TransformRichTextToHtmlResponse> r12 = this.b.richTextToHtml(new TransformRichTextToHtmlRequest.Builder().rich_text(r11).extra_infos(r6).build());
        r0.label = 1;
        r8 = r12.awaitGet(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new CopyProtocolServiceImpl$richTextToHtml$1(this, r7);
        goto L8
    }
}
