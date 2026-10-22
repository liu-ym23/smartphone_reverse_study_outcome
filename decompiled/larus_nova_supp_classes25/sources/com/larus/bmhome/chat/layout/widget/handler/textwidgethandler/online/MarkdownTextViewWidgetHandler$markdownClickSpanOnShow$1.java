package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.list.trace.HighlightWordShowScene;
import com.larus.bmhome.utils.c3;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;
import fh8.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tx9.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online.MarkdownTextViewWidgetHandler$markdownClickSpanOnShow$1", f = "MarkdownTextViewWidgetHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MarkdownTextViewWidgetHandler$markdownClickSpanOnShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ lw8.l $currentNodeContent;
    final /* synthetic */ CustomMarkdownTextView $markdownTextView;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ k this$0;

    public MarkdownTextViewWidgetHandler$markdownClickSpanOnShow$1(lw8.l r1, k r2, Message r3, CustomMarkdownTextView r4, Continuation<? super MarkdownTextViewWidgetHandler$markdownClickSpanOnShow$1> r5) {
        this.$currentNodeContent = r1;
        this.this$0 = r2;
        this.$msg = r3;
        this.$markdownTextView = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MarkdownTextViewWidgetHandler$markdownClickSpanOnShow$1(this.$currentNodeContent, this.this$0, this.$msg, this.$markdownTextView, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L50;
        ResultKt.throwOnFailure(r22);
        lw8.l r0 = this.$currentNodeContent;
        k r2 = this.this$0;
        final Message r3 = this.$msg;
        CustomMarkdownTextView r4 = this.$markdownTextView;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L45
        Unit r6 = null;
        if (r0 == null) goto L43;
        Iterator r1 = ((ArrayList) x.b(r0)).iterator();     // Catch: Throwable -> L45
        final int r7 = 0;
    L9:
        if (r1.hasNext() == false) goto L42;
        Object r8 = r1.next();     // Catch: Throwable -> L45
        int r9 = r7 + 1;     // Catch: Throwable -> L45
        if (r7 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L45
    L13:
        final lw8.k r10 = (lw8.k) r8;     // Catch: Throwable -> L45
        final String r11 = r10.a;     // Catch: Throwable -> L45
        boolean r12 = true;
        if (r11 == null) goto L27;
        if (r4 == null) goto L19;
        Boolean r13 = (Boolean) com.larus.bmhome.chat.layout.widget.handler.e.a(r4, "pc_guide: " + r3.getMessageId() + r11);     // Catch: Throwable -> L45
    L20:
        if (r13 != null) goto L27;
        if (c3.a(r11) == false) goto L27;
        if (r4 == null) goto L25;
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, "pc_guide: " + r3.getMessageId() + r11, Boxing.boxBoolean(true));     // Catch: Throwable -> L45
    L25:
        x1.f(UriProtector.getQueryParameter(UriProtector.parse(r11), "pc_guide_scene"), null, null, null, null, null, 126);     // Catch: Throwable -> L45
        goto L27
    L19:
        r13 = null;
    L27:
        if (r2.a.r == true) goto L41;
        Uri r14 = UriProtector.parse(r11);     // Catch: Throwable -> L45
        if (Intrinsics.areEqual(r14.getScheme(), "sslocal") == true) goto L32;
    L36:
        r12 = false;
    L37:
        Set<String> r15 = com.larus.bmhome.chat.list.trace.a.a;     // Catch: Throwable -> L45
        boolean r16 = com.larus.bmhome.chat.list.trace.a.d(r11);     // Catch: Throwable -> L45
        if (r12 == true) goto L40;
        if (r16 == false) goto L41;
    L40:
        com.larus.bmhome.chat.list.trace.a.e(HighlightWordShowScene.LINK_LONG_URL, r2.a.f, r3.getMessageId(), r11 + '_' + r7, new n(r3, r10, r11, r7));     // Catch: Throwable -> L45
        goto L41
    L32:
        if (Intrinsics.areEqual(r14.getHost(), "flow") == false) goto L36;
        if (Intrinsics.areEqual(r14.getPath(), "/file_open") == false) goto L36;
    L41:
        r7 = r9;
        goto L9
    L42:
        r6 = Unit.INSTANCE;     // Catch: Throwable -> L45
    L43:
        Result.constructor-impl(r6);     // Catch: Throwable -> L45
    L48:
        return Unit.INSTANCE;
    L45:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L50:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
