package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/AwarenessConditionRule;", "Landroid/os/Parcelable;", "operator", "", "values", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getOperator", "()Ljava/lang/String;", "getValues", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessConditionRule implements Parcelable {
    public static final Parcelable.Creator<AwarenessConditionRule> CREATOR = null;
    private final String operator;
    private final ArrayList<String> values;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<AwarenessConditionRule> {
        public a() {
        }

        public final AwarenessConditionRule a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new AwarenessConditionRule(r2.readString(), r2.createStringArrayList());
        }

        public final AwarenessConditionRule[] a(int r1) {
            return new AwarenessConditionRule[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AwarenessConditionRule createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AwarenessConditionRule[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public AwarenessConditionRule(String r2, ArrayList<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "operator");
        Intrinsics.checkNotNullParameter(r3, "values");
        this.operator = r2;
        this.values = r3;
    }

    public /* synthetic */ AwarenessConditionRule(String r1, ArrayList r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new ArrayList();
    L5:
        this(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AwarenessConditionRule copy$default(AwarenessConditionRule r0, String r1, ArrayList r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.operator;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.values;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.operator;
    }

    public final ArrayList<String> component2() {
        return this.values;
    }

    public final AwarenessConditionRule copy(String r1, ArrayList<String> r2) {
        Intrinsics.checkNotNullParameter(r1, "operator");
        Intrinsics.checkNotNullParameter(r2, "values");
        return new AwarenessConditionRule(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AwarenessConditionRule.class) == true) goto L8;
        return false;
    L8:
        AwarenessConditionRule r6 = (AwarenessConditionRule) ZeusTransformUtils.preCheckCast(r5, AwarenessConditionRule.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.operator, r6.operator) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.values, r6.values) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final ArrayList<String> getValues() {
        return this.values;
    }

    public int hashCode() {
        return (this.operator.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        return "AwarenessConditionRule(operator=" + this.operator + ", values=" + this.values + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.operator);
        r2.writeStringList((List) ZeusTransformUtils.preCheckCast(this.values, List.class, "com.obric.memorydata.plugin"));
    }
}
