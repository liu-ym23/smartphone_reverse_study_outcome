package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.ClipData;
import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class ChatInputWithMentionDelegate$configCustomCopyAndSendActionMode$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public ChatInputWithMentionDelegate$configCustomCopyAndSendActionMode$1(Object r8) {
        super(0, r8, ChatInputWithMentionDelegate.class, "pasteMarkdownFromClipboard", "pasteMarkdownFromClipboard()Z", 0);
    }

    public final Boolean invoke() {
        final ChatInputWithMentionDelegate r0 = (ChatInputWithMentionDelegate) ((CallableReference) this).receiver;
        int r1 = ChatInputWithMentionDelegate.m;
        r0.getClass();
        int r2 = com.larus.bmhome.utils.p.a;
        Context r3 = r0.e.getContext();
        Intrinsics.checkNotNullParameter(r3, "context");
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r5 = false;
        String r6 = null;
        if (r4 == null) goto L33;
        r4.d0();
        ClipData r7 = com.larus.home.impl.sdk.i1.a.e(r3, "bpea-input-long-press");
        if (r7 == null) goto L33;
        if (r7.getDescription().hasMimeType("text/markdown") == false) goto L33;
        int r8 = r7.getItemCount();
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L20;
        String r10 = r7.getItemAt(r9).getHtmlText();
        if (r10 == null) goto L19;
        if ((!StringsKt.isBlank(r10)) == true) goto L17;
        r10 = null;
    L17:
        if (r10 == null) goto L19;
    L34:
        if (r10 == null) goto L41;
        if ((!StringsKt.isBlank(r10)) == false) goto L38;
        r6 = r10;
    L38:
        if (r6 == null) goto L41;
        r0.l(r6, new u(r0));
        r5 = true;
    L41:
        return Boolean.valueOf(r5);
    L19:
        r9 = r9 + 1;
        goto L10
    L20:
        int r11 = r7.getItemCount();
        int r12 = 0;
    L21:
        if (r12 >= r11) goto L33;
        CharSequence r13 = r7.getItemAt(r12).getText();
        if (r13 == null) goto L32;
        r10 = r13.toString();
        if (r10 == null) goto L32;
        if ((!StringsKt.isBlank(r10)) == true) goto L30;
        r10 = null;
    L30:
        if (r10 != null) goto L34;
    L32:
        r12 = r12 + 1;
    L33:
        r10 = null;
        goto L34
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m60invoke() {
        return invoke();
    }
}
