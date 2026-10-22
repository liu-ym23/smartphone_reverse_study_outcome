package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import com.ss.android.lark.search.dto.info.CalendarResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/CalendarMainTabIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/intent/export/entity/output/ISDKCallback;", "result", "", "Lcom/ss/android/lark/search/dto/info/CalendarResult;", "msg", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getResult", "()Ljava/util/List;", "getMsg", "()Ljava/lang/String;", "callback", "R", "visitor", "Lcom/ss/android/lark/intent/export/entity/output/ISDKCallbackVisitor;", "(Lcom/ss/android/lark/intent/export/entity/output/ISDKCallbackVisitor;)Ljava/lang/Object;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CalendarMainTabIntentOutput extends CommonSuccessIntentOutput implements ISDKCallback {
    public static final Parcelable.Creator<CalendarMainTabIntentOutput> CREATOR = null;
    private final String msg;
    private final List<CalendarResult> result;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<CalendarMainTabIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CalendarMainTabIntentOutput createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            int r0 = r5.readInt();
            ArrayList r1 = new ArrayList(r0);
            int r2 = 0;
        L3:
            if (r2 == r0) goto L6;
            r1.add(r5.readParcelable(CalendarMainTabIntentOutput.class.getClassLoader()));
            r2 = r2 + 1;
            goto L3
        L6:
            return new CalendarMainTabIntentOutput(r1, r5.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarMainTabIntentOutput createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CalendarMainTabIntentOutput[] newArray(int r1) {
            return new CalendarMainTabIntentOutput[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarMainTabIntentOutput[] newArray(int r1) {
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
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        List<CalendarResult> r0 = this.result;
        r3.writeInt(r0.size());
        Iterator<CalendarResult> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r3.writeParcelable((Parcelable) r1.next(), r4);
        goto L4
    L6:
        r3.writeString(this.msg);
    }

    public final String getMsg() {
        return this.msg;
    }

    public final List<CalendarResult> getResult() {
        return this.result;
    }

    @Override // com.ss.android.lark.intent.export.entity.output.ISDKCallback
    public <R> R callback(ISDKCallbackVisitor<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "visitor");
        return r2.visit(this);
    }

    public CalendarMainTabIntentOutput(List<CalendarResult> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        super(Direction.MAIN_PAGE_CALENDAR, r3);
        this.result = r2;
        this.msg = r3;
    }

    public /* synthetic */ CalendarMainTabIntentOutput(List r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
