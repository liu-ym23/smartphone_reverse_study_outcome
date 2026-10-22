package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.intent.export.entity.input.SendChatInfo;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/OpenLarkIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "sendMessage", "Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "sendChatInfo", "Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;", "msg", "", "<init>", "(Lcom/ss/android/lark/intent/export/entity/output/SendMessage;Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;Ljava/lang/String;)V", "getSendMessage", "()Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "getSendChatInfo", "()Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;", "getMsg", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OpenLarkIntentOutput extends CommonSuccessIntentOutput {
    public static final Parcelable.Creator<OpenLarkIntentOutput> CREATOR = null;
    private final String msg;
    private final SendChatInfo sendChatInfo;
    private final SendMessage sendMessage;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<OpenLarkIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OpenLarkIntentOutput createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            SendChatInfo r2 = null;
            if (r5.readInt() != 0) goto L5;
            SendMessage r1 = null;
        L6:
            SendMessage r3 = r1;
            if (r5.readInt() == 0) goto L11;
            r2 = SendChatInfo.CREATOR.createFromParcel(r5);
        L11:
            return new OpenLarkIntentOutput(r3, r2, r5.readString());
        L5:
            r1 = SendMessage.CREATOR.createFromParcel(r5);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OpenLarkIntentOutput createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OpenLarkIntentOutput[] newArray(int r1) {
            return new OpenLarkIntentOutput[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OpenLarkIntentOutput[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        SendMessage r0 = this.sendMessage;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        SendChatInfo r1 = this.sendChatInfo;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        r4.writeString(this.msg);
        return;
    L9:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        goto L10
    L5:
        r4.writeInt(1);
        r0.writeToParcel(r4, r5);
        goto L6
    }

    public final String getMsg() {
        return this.msg;
    }

    public final SendChatInfo getSendChatInfo() {
        return this.sendChatInfo;
    }

    public final SendMessage getSendMessage() {
        return this.sendMessage;
    }

    public OpenLarkIntentOutput(SendMessage r2, SendChatInfo r3, String r4) {
        super(Direction.MAIN_PAGE_MESSAGE, r4);
        this.sendMessage = r2;
        this.sendChatInfo = r3;
        this.msg = r4;
    }

    public /* synthetic */ OpenLarkIntentOutput(SendMessage r1, SendChatInfo r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
