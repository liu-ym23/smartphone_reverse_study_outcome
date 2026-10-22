package com.obric.memorydata.sdk.screencapture;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J'\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010 \u001a\u00020\u0017J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;", "Landroid/os/Parcelable;", "id", "", "rule", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "taskOptions", "Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;Lcom/obric/memorydata/sdk/screencapture/TaskOptions;)V", "getId", "()Ljava/lang/String;", "getRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "getTaskOptions", "()Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "sourcePackage", "getSourcePackage$annotations", "()V", "getSourcePackage", "setSourcePackage", "(Ljava/lang/String;)V", "hashCode", "", "equals", "", "other", "", "component1", "component2", "component3", "copy", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ScreenEventReaction implements Parcelable {
    public static final Parcelable.Creator<ScreenEventReaction> CREATOR = null;
    public final String a;
    public final ScreenEventRule b;
    public final TaskOptions c;

    public static final class a implements Parcelable.Creator<ScreenEventReaction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenEventReaction createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new ScreenEventReaction(r5.readString(), (ScreenEventRule) r5.readParcelable(ScreenEventReaction.class.getClassLoader()), TaskOptions.CREATOR.createFromParcel(r5));
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenEventReaction[] newArray(int r1) {
            return new ScreenEventReaction[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ScreenEventReaction(id=" + this.a + ", rule=" + this.b + ", taskOptions=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.a);
        r2.writeParcelable(this.b, r3);
        this.c.writeToParcel(r2, r3);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof ScreenEventReaction) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.a, ((ScreenEventReaction) r2).a);
    }

    public ScreenEventReaction(String r2, ScreenEventRule r3, TaskOptions r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "rule");
        Intrinsics.checkNotNullParameter(r4, "taskOptions");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
