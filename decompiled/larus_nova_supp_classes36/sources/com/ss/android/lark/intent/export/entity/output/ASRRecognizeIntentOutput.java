package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/ASRRecognizeIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "entity", "Lcom/ss/android/lark/intent/export/entity/output/ASROutput;", "display", "", "<init>", "(Lcom/ss/android/lark/intent/export/entity/output/ASROutput;Ljava/lang/String;)V", "getEntity", "()Lcom/ss/android/lark/intent/export/entity/output/ASROutput;", "getDisplay", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ASRRecognizeIntentOutput extends CommonSuccessIntentOutput {
    public static final Parcelable.Creator<ASRRecognizeIntentOutput> CREATOR = null;
    private final String display;
    private final ASROutput entity;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<ASRRecognizeIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ASRRecognizeIntentOutput createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new ASRRecognizeIntentOutput(ASROutput.CREATOR.createFromParcel(r3), r3.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ASRRecognizeIntentOutput createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ASRRecognizeIntentOutput[] newArray(int r1) {
            return new ASRRecognizeIntentOutput[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ASRRecognizeIntentOutput[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ ASRRecognizeIntentOutput copy$default(ASRRecognizeIntentOutput r0, ASROutput r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.entity;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.display;
    L9:
        return r0.copy(r1, r2);
    }

    public final ASROutput component1() {
        return this.entity;
    }

    public final String component2() {
        return this.display;
    }

    public final ASRRecognizeIntentOutput copy(ASROutput r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return new ASRRecognizeIntentOutput(r2, r3);
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ASRRecognizeIntentOutput) == true) goto L8;
        return false;
    L8:
        ASRRecognizeIntentOutput r6 = (ASRRecognizeIntentOutput) r5;
        if (Intrinsics.areEqual(this.entity, r6.entity) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.display, r6.display) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.entity.hashCode() * 31;
        String r1 = this.display;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ASRRecognizeIntentOutput(entity=" + this.entity + ", display=" + this.display + ')';
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        this.entity.writeToParcel(r2, r3);
        r2.writeString(this.display);
    }

    public final String getDisplay() {
        return this.display;
    }

    public final ASROutput getEntity() {
        return this.entity;
    }

    public ASRRecognizeIntentOutput(ASROutput r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        super(Direction.CALLBACK_ASR_RESULT, r3);
        this.entity = r2;
        this.display = r3;
    }

    public /* synthetic */ ASRRecognizeIntentOutput(ASROutput r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
