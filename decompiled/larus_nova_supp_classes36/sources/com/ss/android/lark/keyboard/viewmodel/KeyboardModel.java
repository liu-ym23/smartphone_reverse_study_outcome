package com.ss.android.lark.keyboard.viewmodel;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterRequest;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterResponse;
import com.bytedance.lark.pb.im.v1.TransformMarkdownToRichTextRequest;
import com.bytedance.lark.pb.im.v1.TransformMarkdownToRichTextResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.base.b;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.parser.internal.j;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import lec.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardModel {

    public static final class a {
    }

    static {
    }

    public KeyboardModel() {
    }

    public final Object a(SyncDataStrategy r5, Continuation<? super Chatter> r6) {
        if ((r6 instanceof KeyboardModel$getDoubaoChatter$1) == false) goto L7;
        KeyboardModel$getDoubaoChatter$1 r0 = (KeyboardModel$getDoubaoChatter$1) r6;
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
        b r8 = (b) r7;
        r8.getClass();
        if ((r8 instanceof b.b) == false) goto L22;
        Log.e("KeyboardModel", "getDoubaoChatter failed, " + r8.a());
        return null;
    L22:
        return j.a(((PullDoubaoChatterResponse) r8.b()).doubao);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        RucketJob<PullDoubaoChatterResponse> r9 = ((com.ss.android.lark.keyboard.viewmodel.a) b38.b.a.create(com.ss.android.lark.keyboard.viewmodel.a.class)).getDoubaoChatter(new PullDoubaoChatterRequest.Builder().sync_data_strategy(r5).build());
        r0.label = 1;
        r7 = r9.awaitGet(r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new KeyboardModel$getDoubaoChatter$1(this, r6);
        goto L8
    }

    public final Object b(Context r6, String r7, Continuation<? super RichText> r8) {
        if ((r8 instanceof KeyboardModel$markdownToRichText$1) == false) goto L7;
        KeyboardModel$markdownToRichText$1 r0 = (KeyboardModel$markdownToRichText$1) r8;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L24:
        Object r10 = ((Result) r9).unbox-impl();
        if (Result.isFailure-impl(r10) == false) goto L29;
        Log.e("KeyboardModel", "markdownToRichText failed", Result.exceptionOrNull-impl(r10));
        return null;
    L29:
        if (Result.isFailure-impl(r10) == false) goto L31;
        r10 = null;
    L31:
        b r11 = (b) r10;
        if (r11 != null) goto L34;
    L41:
        StringBuilder r12 = new StringBuilder("markdownToRichText response failed, ");
        if (r11 == null) goto L44;
        ErrorResult r13 = r11.a();
    L45:
        r12.append(r13);
        Log.e("KeyboardModel", r12.toString());
        return null;
    L44:
        r13 = null;
        goto L45
    L34:
        if ((r11 instanceof b.b) == true) goto L41;
        com.bytedance.lark.pb.basic.v1.RichText r14 = ((TransformMarkdownToRichTextResponse) r11.b()).rich_text;
        if (r14 != null) goto L39;
        return null;
    L39:
        RichText r15 = g0.e(r14, null);
        c.c(r6, r15, new lec.b(new lec.b.a()));
        return r15;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (r7.length() != 0) goto L17;
        boolean r16 = true;
    L18:
        if (r16 == true) goto L20;
        TransformMarkdownToRichTextRequest r17 = new TransformMarkdownToRichTextRequest.Builder().markdown(r7).build();
        CoroutineDispatcher r18 = Dispatchers.getIO();
        KeyboardModel$markdownToRichText$result$1 r4 = new KeyboardModel$markdownToRichText$result$1(this, r17, null);
        r0.L$0 = r6;
        r0.label = 1;
        r9 = BuildersKt.withContext(r18, r4, r0);
        if (r9 != r2) goto L24;
        return r2;
    L20:
        return com.ss.android.lark.widget.richtext.c.a();
    L17:
        r16 = false;
    L7:
        r0 = new KeyboardModel$markdownToRichText$1(this, r8);
        goto L8
    }
}
