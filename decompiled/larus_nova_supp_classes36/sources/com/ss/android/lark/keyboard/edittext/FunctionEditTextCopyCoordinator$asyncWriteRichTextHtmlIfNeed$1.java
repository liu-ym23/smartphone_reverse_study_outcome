package com.ss.android.lark.keyboard.edittext;

import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.bytedance.lark.pb.im.v1.ResourceExtraInfo;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.utils.RichTextCopyUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext.FunctionEditTextCopyCoordinator$asyncWriteRichTextHtmlIfNeed$1", f = "FunctionEditTextCopyCoordinator.kt", i = {0}, l = {69}, m = "invokeSuspend", n = {"content"}, s = {"L$0"})
final class FunctionEditTextCopyCoordinator$asyncWriteRichTextHtmlIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ b this$0;

    public FunctionEditTextCopyCoordinator$asyncWriteRichTextHtmlIfNeed$1(b r1, Continuation<? super FunctionEditTextCopyCoordinator$asyncWriteRichTextHtmlIfNeed$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FunctionEditTextCopyCoordinator$asyncWriteRichTextHtmlIfNeed$1(this.this$0, r3);
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
        CharSequence r2 = (CharSequence) this.L$0;
        ResultKt.throwOnFailure(r13);
    L30:
        String r14 = (String) r13;
        Log.d("FunctionEditTextCopyCoordinator", "richTextToHtml: html is " + r14);
        ClipData r15 = new ClipData("FunctionEditTextCopyCoordinator", new String[]{"text/plain", "text/html"}, new ClipData.Item(r2, r14));
        ClipboardManager r3 = (ClipboardManager) ContextCompat.getSystemService(this.this$0.a.getContext(), ClipboardManager.class);
        if (r3 == null) goto L33;
        qf7.a.a.a(r3, r15, RichTextCopyUtils.a);     // Catch: SensitiveAPIException -> L36
    L39:
        return Unit.INSTANCE;
    L36:
        e = move-exception;
        Log.e("FunctionEditTextCopyCoordinator", "beforeTextCopy: set primary clip failed: " + e.getMessage());
        goto L39
    L33:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        AppCompatEditText r16 = this.this$0.a;
        RichText r17 = ((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) r16.q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g)).i(r16.getSelectionStart(), r16.getSelectionEnd());
        RichTextCopyUtils.e(r17.getInnerText(), r17);
        CharSequence r4 = RichTextCopyUtils.a(r17.getInnerText());
        com.ss.android.lark.keyboard.edittext2.copy.a.b r5 = this.this$0.b;
        List r6 = r17.getImageIds();
        List r7 = r17.getMediaIds();
        Map r8 = r17.getElements().getDictionary();
        ArrayList r9 = new ArrayList(r6.size() + r7.size());
        Intrinsics.checkNotNull(r6);
        Iterator r10 = r6.iterator();
    L10:
        if (r10.hasNext() == false) goto L17;
        String r11 = (String) r10.next();
        RichTextElement r12 = (RichTextElement) r8.get(r11);
        if (r12 == null) goto L10;
        RichTextElement.ImageProperty r18 = r12.getProperty();
        if (r18 == null) goto L10;
        r9.add(new ResourceExtraInfo.Builder().token(r18.getToken()).element_id(r11).biz("imkey").build());
        goto L10
    L17:
        Intrinsics.checkNotNull(r7);
        Iterator r19 = r7.iterator();
    L19:
        if (r19.hasNext() == false) goto L26;
        String r20 = (String) r19.next();
        RichTextElement r21 = (RichTextElement) r8.get(r20);
        if (r21 == null) goto L19;
        RichTextElement.MediaProperty r22 = r21.getProperty();
        if (r22 == null) goto L19;
        r9.add(new ResourceExtraInfo.Builder().token(r22.getKey()).element_id(r20).biz("imkey").build());
        goto L19
    L26:
        this.L$0 = r4;
        this.label = 1;
        r13 = r5.b.b(r17, r9, this);
        if (r13 != r0) goto L29;
        return r0;
    L29:
        r2 = r4;
        goto L30
    }
}
