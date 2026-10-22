package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0016J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/common/intent/AppFuncExecuteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "toolName", "", "parameters", "(Ljava/lang/String;Ljava/lang/String;)V", "getParameters", "()Ljava/lang/String;", "setParameters", "(Ljava/lang/String;)V", "getToolName", "setToolName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AppFuncExecuteParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<AppFuncExecuteParams> CREATOR = null;
    private String parameters;
    private String toolName;

    static {
        CREATOR = new a();
    }

    public AppFuncExecuteParams() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ AppFuncExecuteParams copy$default(AppFuncExecuteParams r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.toolName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.parameters;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.toolName;
    }

    public final String component2() {
        return this.parameters;
    }

    public final AppFuncExecuteParams copy(String r2, String r3) {
        return new AppFuncExecuteParams(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppFuncExecuteParams) == true) goto L8;
        return false;
    L8:
        AppFuncExecuteParams r6 = (AppFuncExecuteParams) r5;
        if (Intrinsics.areEqual(this.toolName, r6.toolName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parameters, r6.parameters) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.toolName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.parameters;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppFuncExecuteParams(toolName=" + this.toolName + ", parameters=" + this.parameters + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.toolName);
        r1.writeString(this.parameters);
    }

    public boolean isParamsCompleted() {
        if (this.toolName == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getParameters() {
        return this.parameters;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof AppFuncExecuteParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.toolName;
        if (r0 != null) goto L8;
        r0 = ((AppFuncExecuteParams) r3).toolName;
    L8:
        String r1 = this.parameters;
        if (r1 != null) goto L12;
        r1 = ((AppFuncExecuteParams) r3).parameters;
    L12:
        return new AppFuncExecuteParams(r0, r1);
    }

    public final void setParameters(String r1) {
        this.parameters = r1;
    }

    public final void setToolName(String r1) {
        this.toolName = r1;
    }

    public AppFuncExecuteParams(String r1, String r2) {
        this.toolName = r1;
        this.parameters = r2;
    }

    public /* synthetic */ AppFuncExecuteParams(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
