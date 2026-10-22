package com.obric.memorydata.sdk.screencapture;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.obric.memorydata.sdk.screencapture.rule.ViewTreeOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "Landroid/os/Parcelable;", "screenshot", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "viewTree", "Lcom/obric/memorydata/sdk/screencapture/rule/ViewTreeOption;", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;Lcom/obric/memorydata/sdk/screencapture/rule/ViewTreeOption;)V", "getScreenshot", "()Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "getViewTree", "()Lcom/obric/memorydata/sdk/screencapture/rule/ViewTreeOption;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class TaskOptions implements Parcelable {
    public static final Parcelable.Creator<TaskOptions> CREATOR = null;
    public final ScreenshotOption a;
    public final ViewTreeOption b;

    public static final class a implements Parcelable.Creator<TaskOptions> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TaskOptions createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            ViewTreeOption r2 = null;
            if (r5.readInt() != 0) goto L5;
            ScreenshotOption r1 = null;
        L6:
            ScreenshotOption r3 = r1;
            if (r5.readInt() == 0) goto L11;
            r2 = ViewTreeOption.CREATOR.createFromParcel(r5);
        L11:
            return new TaskOptions(r3, r2);
        L5:
            r1 = ScreenshotOption.CREATOR.createFromParcel(r5);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TaskOptions[] newArray(int r1) {
            return new TaskOptions[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public TaskOptions() {
        this(null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TaskOptions) == true) goto L8;
        return false;
    L8:
        TaskOptions r6 = (TaskOptions) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        ScreenshotOption r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ViewTreeOption r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskOptions(screenshot=" + this.a + ", viewTree=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        ScreenshotOption r0 = this.a;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        ViewTreeOption r1 = this.b;
        if (r1 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        return;
    L5:
        r4.writeInt(1);
        r0.writeToParcel(r4, r5);
        goto L6
    }

    public TaskOptions(ScreenshotOption r1, ViewTreeOption r2) {
        this.a = r1;
        this.b = r2;
    }
}
