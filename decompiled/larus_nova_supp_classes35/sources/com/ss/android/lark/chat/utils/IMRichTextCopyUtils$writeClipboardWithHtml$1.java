package com.ss.android.lark.chat.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.lark.pb.im.v1.ResourceExtraInfo;
import com.bytedance.lark.pb.im.v1.VisitInfo;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.utils.IMRichTextCopyUtils$writeClipboardWithHtml$1", f = "IMRichTextCopyUtils.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {})
final class IMRichTextCopyUtils$writeClipboardWithHtml$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMRichTextCopyUtils.a $callback;
    final /* synthetic */ CharSequence $content;
    final /* synthetic */ Context $context;
    final /* synthetic */ Token $copyToken;
    final /* synthetic */ RichText $richText;
    final /* synthetic */ VisitInfo $visitInfo;
    int label;

    public IMRichTextCopyUtils$writeClipboardWithHtml$1(RichText r1, VisitInfo r2, Context r3, CharSequence r4, Token r5, IMRichTextCopyUtils.a r6, Continuation<? super IMRichTextCopyUtils$writeClipboardWithHtml$1> r7) {
        this.$richText = r1;
        this.$visitInfo = r2;
        this.$context = r3;
        this.$content = r4;
        this.$copyToken = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new IMRichTextCopyUtils$writeClipboardWithHtml$1(this.$richText, this.$visitInfo, this.$context, this.$content, this.$copyToken, this.$callback, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L52:
        String r14 = (String) r13;
    L54:
        Log.d("IMRichTextCopyUtils", "richTextToHtml: html is " + r14);
        Object r2 = this.$context.getSystemService("clipboard");     // Catch: Exception -> L57
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: Exception -> L57
        ClipData r15 = new ClipData("IMRichTextCopyUtils", new String[]{"text/plain", "text/html"}, new ClipData.Item(this.$content, r14));     // Catch: Exception -> L57
        qf7.a.a.a((ClipboardManager) r2, r15, this.$copyToken);     // Catch: Exception -> L57
        this.$callback.onSuccess();     // Catch: Exception -> L57
    L60:
        return Unit.INSTANCE;
    L57:
        e = move-exception;
        this.$callback.onError(e);
        Log.e("IMRichTextCopyUtils", e);
        goto L60
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        IMRichTextCopyUtils r16 = IMRichTextCopyUtils.a;
        RichText r17 = this.$richText;
        if (r17 == null) goto L29;
        Map r3 = r17.getElements().getDictionary();
        List r18 = r17.getAnchorIds();
        if (r18 == null) goto L29;
        Iterator r19 = r18.iterator();
    L15:
        if (r19.hasNext() == false) goto L29;
        RichTextElement r4 = (RichTextElement) r3.get((String) r19.next());
        if (r4 == null) goto L15;
        RichTextElement.AnchorProperty r5 = r4.getProperty();
        String r6 = r5.getContent();
        String r7 = r5.getHref();
        String r8 = r5.getDisplayTitle();
        if (Intrinsics.areEqual(r6, r7) == false) goto L15;
        if (r8 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == true) goto L15;
        r5.setContent(r8);
        goto L15
    L23:
        if (r8.length() == 0) goto L26;
        r9 = false;
    L29:
        RichText r110 = this.$richText;
        if (r110 == null) goto L53;
        com.ss.android.lark.keyboard.edittext2.copy.a.b r10 = com.ss.android.lark.keyboard.edittext2.copy.a.a;
        IMRichTextCopyUtils r11 = IMRichTextCopyUtils.a;
        VisitInfo r12 = this.$visitInfo;
        List r20 = r110.getImageIds();
        List r21 = r110.getMediaIds();
        Map r22 = r110.getElements().getDictionary();
        ArrayList r23 = new ArrayList(r20.size() + r21.size());
        Intrinsics.checkNotNull(r20);
        Iterator r24 = r20.iterator();
    L33:
        if (r24.hasNext() == false) goto L40;
        String r25 = (String) r24.next();
        RichTextElement r111 = (RichTextElement) r22.get(r25);
        if (r111 == null) goto L33;
        RichTextElement.ImageProperty r112 = r111.getProperty();
        if (r112 == null) goto L33;
        r23.add(new ResourceExtraInfo.Builder().visit_info(r12).token(r112.getToken()).element_id(r25).biz("imkey").build());
        goto L33
    L40:
        Intrinsics.checkNotNull(r21);
        Iterator r26 = r21.iterator();
    L42:
        if (r26.hasNext() == false) goto L49;
        String r27 = (String) r26.next();
        RichTextElement r28 = (RichTextElement) r22.get(r27);
        if (r28 == null) goto L42;
        RichTextElement.MediaProperty r29 = r28.getProperty();
        if (r29 == null) goto L42;
        r23.add(new ResourceExtraInfo.Builder().visit_info(r12).token(r29.getKey()).element_id(r27).biz("imkey").build());
        goto L42
    L49:
        this.label = 1;
        r13 = r10.b.b(r110, r23, this);
        if (r13 != r0) goto L52;
        return r0;
    L53:
        r14 = BuildConfig.FLAVOR;
        goto L54
    }
}
