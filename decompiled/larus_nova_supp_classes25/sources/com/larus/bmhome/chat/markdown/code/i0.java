package com.larus.bmhome.chat.markdown.code;

import android.view.View;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i0 implements IIMCallback<Message> {
    public final /* synthetic */ ClickableMarkdownCodeView a;
    public final /* synthetic */ View b;
    public final /* synthetic */ String c;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("MarkdownCodeView", "getMessageById failed for long press menu, id=" + this.c + ", code=" + r4.getCode());
        ClickableMarkdownCodeView r5 = this.a;
        Message r0 = r5.y;
        if (r0 == null) goto L6;
        ClickableMarkdownCodeView.b(r5, this.b, r0);
        return;
    }

    public final void onSuccess(Object r3) {
        Message r4 = (Message) r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        ClickableMarkdownCodeView r0 = this.a;
        r0.y = r4;
        ClickableMarkdownCodeView.b(r0, this.b, r4);
    }

    public i0(ClickableMarkdownCodeView r1, View r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
