package com.ss.android.lark.intent.export.entity.output.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.intent.export.entity.output.Direction;
import com.ss.android.lark.intent.export.entity.output.IntentOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0017\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/common/CommonErrorIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/IntentOutput;", "Landroid/os/Parcelable;", "errorCode", "", "isObricError", "", "errorMsg", "", "displayErrorMsg", "extra", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getErrorCode", "()I", "()Z", "getErrorMsg", "()Ljava/lang/String;", "getDisplayErrorMsg", "getExtra", "()Ljava/util/HashMap;", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CommonErrorIntentOutput extends IntentOutput {
    public static final Parcelable.Creator<CommonErrorIntentOutput> CREATOR = null;
    private final String displayErrorMsg;
    private final int errorCode;
    private final String errorMsg;
    private final HashMap<String, String> extra;
    private final boolean isObricError;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<CommonErrorIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonErrorIntentOutput createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            int r2 = r10.readInt();
            int r1 = 0;
            if (r10.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            String r4 = r10.readString();
            String r5 = r10.readString();
            int r0 = r10.readInt();
            HashMap r6 = new HashMap(r0);
        L7:
            if (r1 == r0) goto L10;
            r6.put(r10.readString(), r10.readString());
            r1 = r1 + 1;
            goto L7
        L10:
            return new CommonErrorIntentOutput(r2, r3, r4, r5, r6);
        L5:
            r3 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonErrorIntentOutput createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonErrorIntentOutput[] newArray(int r1) {
            return new CommonErrorIntentOutput[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonErrorIntentOutput[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public CommonErrorIntentOutput() {
        this(0, false, null, null, null, 31, null);
    }

    @Override // com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.errorCode);
        r3.writeInt(this.isObricError ? 1 : 0);
        r3.writeString(this.errorMsg);
        r3.writeString(this.displayErrorMsg);
        HashMap<String, String> r5 = this.extra;
        r3.writeInt(r5.size());
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, String> r0 = r6.next();
        r3.writeString(r0.getKey());
        r3.writeString(r0.getValue());
        goto L4
    }

    public final String getDisplayErrorMsg() {
        return this.displayErrorMsg;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final HashMap<String, String> getExtra() {
        return this.extra;
    }

    public final boolean isObricError() {
        return this.isObricError;
    }

    public CommonErrorIntentOutput(int r2, boolean r3, String r4, String r5, HashMap<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "extra");
        super(Direction.ERROR);
        this.errorCode = r2;
        this.isObricError = r3;
        this.errorMsg = r4;
        this.displayErrorMsg = r5;
        this.extra = r6;
    }

    public /* synthetic */ CommonErrorIntentOutput(int r4, boolean r5, String r6, String r7, HashMap r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = -1;
    L6:
        if ((r9 & 2) == 0) goto L8;
        boolean r11 = false;
    L9:
        String r0 = null;
        if ((r9 & 4) == 0) goto L12;
        String r1 = null;
    L14:
        if ((r9 & 8) != 0) goto L18;
        r0 = r7;
    L18:
        if ((r9 & 16) == 0) goto L20;
        r8 = new HashMap();
    L20:
        this(r4, r11, r1, r0, r8);
        return;
    L12:
        r1 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L9
    }
}
