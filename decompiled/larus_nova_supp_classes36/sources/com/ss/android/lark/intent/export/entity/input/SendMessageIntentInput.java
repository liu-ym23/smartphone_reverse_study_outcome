package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SendMessageIntentInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", "target", "Lcom/ss/android/lark/intent/export/entity/input/SendTarget;", "content", "Lcom/ss/android/lark/intent/export/entity/input/SendContent;", "<init>", "(Lcom/ss/android/lark/intent/export/entity/input/SendTarget;Lcom/ss/android/lark/intent/export/entity/input/SendContent;)V", "getTarget", "()Lcom/ss/android/lark/intent/export/entity/input/SendTarget;", "getContent", "()Lcom/ss/android/lark/intent/export/entity/input/SendContent;", "toString", "", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SendMessageIntentInput extends IntentInput implements Serializable {
    private final SendContent content;
    private final SendTarget target;

    public static /* synthetic */ SendMessageIntentInput copy$default(SendMessageIntentInput r0, SendTarget r1, SendContent r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        return r0.copy(r1, r2);
    }

    public final SendTarget component1() {
        return this.target;
    }

    public final SendContent component2() {
        return this.content;
    }

    public final SendMessageIntentInput copy(SendTarget r2, SendContent r3) {
        return new SendMessageIntentInput(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SendMessageIntentInput) == true) goto L8;
        return false;
    L8:
        SendMessageIntentInput r6 = (SendMessageIntentInput) r5;
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        SendTarget r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        SendContent r4 = this.content;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("SendMessageIntentInput(target=");
        Object r1 = this.target;
        Object r2 = "null";
        if (r1 != null) goto L6;
        r1 = "null";
    L6:
        r0.append(r1);
        r0.append(", content=");
        SendContent r3 = this.content;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    }

    public final SendContent getContent() {
        return this.content;
    }

    public final SendTarget getTarget() {
        return this.target;
    }

    public SendMessageIntentInput(SendTarget r2, SendContent r3) {
        super(IntentInput.IntentType.SEND_MESSAGE);
        this.target = r2;
        this.content = r3;
    }
}
