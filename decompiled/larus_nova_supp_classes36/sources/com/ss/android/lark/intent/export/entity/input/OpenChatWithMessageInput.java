package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.intent.export.entity.output.SendMessage;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/OpenChatWithMessageInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", "sendMessage", "Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "sendChatInfo", "Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;", "<init>", "(Lcom/ss/android/lark/intent/export/entity/output/SendMessage;Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;)V", "getSendMessage", "()Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "getSendChatInfo", "()Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;", "toString", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OpenChatWithMessageInput extends IntentInput implements Serializable {
    private final SendChatInfo sendChatInfo;
    private final SendMessage sendMessage;

    public String toString() {
        return "OpenChatWithMessageInput(sendMessage=" + this.sendMessage + ", sendChatInfo=" + this.sendChatInfo + ')';
    }

    public final SendChatInfo getSendChatInfo() {
        return this.sendChatInfo;
    }

    public final SendMessage getSendMessage() {
        return this.sendMessage;
    }

    public OpenChatWithMessageInput(SendMessage r2, SendChatInfo r3) {
        super(IntentInput.IntentType.OPEN_CHAT_DETAIL);
        this.sendMessage = r2;
        this.sendChatInfo = r3;
    }

    public /* synthetic */ OpenChatWithMessageInput(SendMessage r1, SendChatInfo r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
