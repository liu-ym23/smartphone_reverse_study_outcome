package com.ss.android.lark.intent.export.entity.output.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.intent.export.entity.output.Direction;
import com.ss.android.lark.intent.export.entity.output.IntentOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessAsyncIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/IntentOutput;", "Landroid/os/Parcelable;", "direct", "Lcom/ss/android/lark/intent/export/entity/output/Direction;", "displayMsg", "", "<init>", "(Lcom/ss/android/lark/intent/export/entity/output/Direction;Ljava/lang/String;)V", "getDirect", "()Lcom/ss/android/lark/intent/export/entity/output/Direction;", "getDisplayMsg", "()Ljava/lang/String;", "isAsyncCall", "", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class CommonSuccessAsyncIntentOutput extends IntentOutput {
    public static final Parcelable.Creator<CommonSuccessAsyncIntentOutput> CREATOR = null;
    private final Direction direct;
    private final String displayMsg;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<CommonSuccessAsyncIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonSuccessAsyncIntentOutput createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new CommonSuccessAsyncIntentOutput(Direction.valueOf(r3.readString()), r3.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonSuccessAsyncIntentOutput createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonSuccessAsyncIntentOutput[] newArray(int r1) {
            return new CommonSuccessAsyncIntentOutput[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonSuccessAsyncIntentOutput[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    @Override // com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.intent.export.entity.output.IntentOutput, com.ss.android.lark.intent.export.entity.output.IAsyncCall
    public boolean isAsyncCall() {
        return true;
    }

    @Override // com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.direct.name());
        r1.writeString(this.displayMsg);
    }

    public final Direction getDirect() {
        return this.direct;
    }

    public final String getDisplayMsg() {
        return this.displayMsg;
    }

    public CommonSuccessAsyncIntentOutput(Direction r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "direct");
        super(r2);
        this.direct = r2;
        this.displayMsg = r3;
    }

    public /* synthetic */ CommonSuccessAsyncIntentOutput(Direction r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
