package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006!"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "Landroid/os/Parcelable;", "domainName", "", "intentName", "sourceIntent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDomainName", "()Ljava/lang/String;", "setDomainName", "(Ljava/lang/String;)V", "getIntentName", "setIntentName", "getSourceIntent", "setSourceIntent", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class DataSource implements Parcelable {
    public static final Parcelable.Creator<DataSource> CREATOR = null;
    private String domainName;
    private String intentName;
    private String sourceIntent;

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ DataSource copy$default(DataSource r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.domainName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.intentName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.sourceIntent;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.domainName;
    }

    public final String component2() {
        return this.intentName;
    }

    public final String component3() {
        return this.sourceIntent;
    }

    public final DataSource copy(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "domainName");
        Intrinsics.checkNotNullParameter(r3, "intentName");
        return new DataSource(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DataSource) == true) goto L8;
        return false;
    L8:
        DataSource r6 = (DataSource) r5;
        if (Intrinsics.areEqual(this.domainName, r6.domainName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.intentName, r6.intentName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceIntent, r6.sourceIntent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.domainName.hashCode() * 31) + this.intentName.hashCode()) * 31;
        String r1 = this.sourceIntent;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "DataSource(domainName=" + this.domainName + ", intentName=" + this.intentName + ", sourceIntent=" + this.sourceIntent + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.domainName);
        r1.writeString(this.intentName);
        r1.writeString(this.sourceIntent);
    }

    public final String getDomainName() {
        return this.domainName;
    }

    public final String getIntentName() {
        return this.intentName;
    }

    public final String getSourceIntent() {
        return this.sourceIntent;
    }

    public final void setDomainName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.domainName = r2;
    }

    public final void setIntentName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.intentName = r2;
    }

    public final void setSourceIntent(String r1) {
        this.sourceIntent = r1;
    }

    public DataSource(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "domainName");
        Intrinsics.checkNotNullParameter(r3, "intentName");
        this.domainName = r2;
        this.intentName = r3;
        this.sourceIntent = r4;
    }

    public /* synthetic */ DataSource(String r1, String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
