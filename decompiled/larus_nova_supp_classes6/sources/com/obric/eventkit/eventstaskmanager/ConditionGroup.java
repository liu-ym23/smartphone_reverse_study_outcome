package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00042\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "type", "", "conditions", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getConditions", "()Ljava/util/ArrayList;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ConditionGroup implements Condition, Parcelable {
    public static final Parcelable.Creator<ConditionGroup> CREATOR = null;
    private final ArrayList<Condition> conditions;
    private final String type;

    static {
        CREATOR = new a();
    }

    public ConditionGroup(@ConditionGroupType String r2, ArrayList<Condition> r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "conditions");
        this.type = r2;
        this.conditions = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConditionGroup copy$default(ConditionGroup r0, String r1, ArrayList r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.conditions;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.type;
    }

    public final ArrayList<Condition> component2() {
        return this.conditions;
    }

    public final ConditionGroup copy(@ConditionGroupType String r2, ArrayList<Condition> r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "conditions");
        return new ConditionGroup(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(ConditionGroup.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ConditionGroup");
        ConditionGroup r6 = (ConditionGroup) r5;
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
    L19:
        return false;
    L15:
        if (this.conditions.size() != r6.conditions.size()) goto L19;
        if (Intrinsics.areEqual(CollectionsKt.toSet(this.conditions), CollectionsKt.toSet(r6.conditions)) == false) goto L19;
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final ArrayList<Condition> getConditions() {
        return this.conditions;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + CollectionsKt.toSet(this.conditions).hashCode();
    }

    public String toString() {
        return "ConditionGroup(type=" + this.type + ", conditions=" + this.conditions + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeString(this.type);
        ArrayList<Condition> r0 = this.conditions;
        r3.writeInt(r0.size());
        Iterator<Condition> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r3.writeParcelable(r1.next(), r4);
        goto L4
    }
}
