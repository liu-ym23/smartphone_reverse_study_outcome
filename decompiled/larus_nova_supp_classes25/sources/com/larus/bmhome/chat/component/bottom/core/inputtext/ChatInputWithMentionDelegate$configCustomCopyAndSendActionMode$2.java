package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class ChatInputWithMentionDelegate$configCustomCopyAndSendActionMode$2 extends FunctionReferenceImpl implements Function1<Boolean, Boolean> {
    public ChatInputWithMentionDelegate$configCustomCopyAndSendActionMode$2(Object r8) {
        super(1, r8, ChatInputWithMentionDelegate.class, "copyOrCutRichTextToClipboard", "copyOrCutRichTextToClipboard(Z)Z", 0);
    }

    public final Boolean invoke(boolean r11) {
        ChatInputWithMentionDelegate r0 = (ChatInputWithMentionDelegate) ((CallableReference) this).receiver;
        Editable r1 = r0.e.getEditableText();
        boolean r2 = false;
        if (r1 == null) goto L28;
        int r3 = RangesKt.coerceAtLeast(Math.min(r0.e.getSelectionStart(), r0.e.getSelectionEnd()), 0);
        int r4 = RangesKt.coerceAtMost(Math.max(r0.e.getSelectionStart(), r0.e.getSelectionEnd()), r1.length());
        if (r3 >= r4) goto L28;
        SpannableStringBuilder r5 = new SpannableStringBuilder(r1, r3, r4);
        if (r5.getSpans(0, r5.length(), l0.class).length != 0) goto L11;
        boolean r6 = true;
    L13:
        if ((!r6) == false) goto L28;
        String r7 = r0.i(r5);
        if (r7 == null) goto L28;
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L28;
        r8.d0();
        com.larus.home.impl.sdk.i1 r9 = com.larus.home.impl.sdk.i1.a;
        int r10 = com.larus.bmhome.utils.p.a;     // Catch: Exception -> L25
        r9.i(r0.e.getContext(), com.larus.bmhome.utils.p.b(r5.toString(), r7), "bpea-markdown-text-copy");     // Catch: Exception -> L25
        if (r11 == false) goto L24;
        r1.delete(r3, r4);     // Catch: Exception -> L25
    L24:
        r2 = true;
    L25:
        e = move-exception;
        FLogger.a.e("ChatInputWithMentionDelegate", "[copyOrCutRichTextToClipboard] clipboard write failed", e);
        goto L28
    L11:
        r6 = false;
    L28:
        return Boolean.valueOf(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Boolean) r1).booleanValue());
    }
}
