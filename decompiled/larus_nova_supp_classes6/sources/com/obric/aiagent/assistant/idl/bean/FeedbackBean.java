package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cR%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/FeedbackBean;", "Landroid/os/Parcelable;", "filePath", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "description", "needReportVoc", "", "launchReportAppWhenNoPermission", "needShowToast", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;ZZZ)V", "getFilePath", "()Ljava/util/ArrayList;", "getDescription", "()Ljava/lang/String;", "getNeedReportVoc", "()Z", "getLaunchReportAppWhenNoPermission", "getNeedShowToast", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class FeedbackBean implements Parcelable {
    public static final Parcelable.Creator<FeedbackBean> CREATOR = null;
    private final String description;
    private final ArrayList<String> filePath;
    private final boolean launchReportAppWhenNoPermission;
    private final boolean needReportVoc;
    private final boolean needShowToast;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedbackBean copy$default(FeedbackBean r3, ArrayList r4, String r5, boolean r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.filePath;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.description;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.needReportVoc;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.launchReportAppWhenNoPermission;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.needShowToast;
    L17:
        ArrayList r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final ArrayList<String> component1() {
        return this.filePath;
    }

    public final String component2() {
        return this.description;
    }

    public final boolean component3() {
        return this.needReportVoc;
    }

    public final boolean component4() {
        return this.launchReportAppWhenNoPermission;
    }

    public final boolean component5() {
        return this.needShowToast;
    }

    public final FeedbackBean copy(ArrayList<String> r8, String r9, boolean r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "description");
        return new FeedbackBean(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FeedbackBean) == true) goto L8;
        return false;
    L8:
        FeedbackBean r6 = (FeedbackBean) r5;
        if (Intrinsics.areEqual(this.filePath, r6.filePath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L15;
        return false;
    L15:
        if (this.needReportVoc == r6.needReportVoc) goto L18;
        return false;
    L18:
        if (this.launchReportAppWhenNoPermission == r6.launchReportAppWhenNoPermission) goto L21;
        return false;
    L21:
        if (this.needShowToast == r6.needShowToast) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        ArrayList<String> r0 = this.filePath;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((r1 * 31) + this.description.hashCode()) * 31;
        int r3 = 1231;
        if (this.needReportVoc == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.launchReportAppWhenNoPermission == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.needShowToast == true) goto L19;
        r3 = 1237;
    L19:
        return r7 + r3;
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "FeedbackBean(filePath=" + this.filePath + ", description=" + this.description + ", needReportVoc=" + this.needReportVoc + ", launchReportAppWhenNoPermission=" + this.launchReportAppWhenNoPermission + ", needShowToast=" + this.needShowToast + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeStringList(this.filePath);
        r1.writeString(this.description);
        r1.writeInt(this.needReportVoc ? 1 : 0);
        r1.writeInt(this.launchReportAppWhenNoPermission ? 1 : 0);
        r1.writeInt(this.needShowToast ? 1 : 0);
    }

    public final String getDescription() {
        return this.description;
    }

    public final ArrayList<String> getFilePath() {
        return this.filePath;
    }

    public final boolean getLaunchReportAppWhenNoPermission() {
        return this.launchReportAppWhenNoPermission;
    }

    public final boolean getNeedReportVoc() {
        return this.needReportVoc;
    }

    public final boolean getNeedShowToast() {
        return this.needShowToast;
    }

    public FeedbackBean(ArrayList<String> r2, String r3, boolean r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "description");
        this.filePath = r2;
        this.description = r3;
        this.needReportVoc = r4;
        this.launchReportAppWhenNoPermission = r5;
        this.needShowToast = r6;
    }

    public /* synthetic */ FeedbackBean(ArrayList r8, String r9, boolean r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r13 & 16) == 0) goto L9;
        boolean r6 = false;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }
}
