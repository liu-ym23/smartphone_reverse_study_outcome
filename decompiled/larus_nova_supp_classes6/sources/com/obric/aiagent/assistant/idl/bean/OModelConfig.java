package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OModelConfig;", "Landroid/os/Parcelable;", "intentModel", "", "pcSearchModel", "queryWithPicTimeout", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getIntentModel", "()Ljava/lang/String;", "getPcSearchModel", "getQueryWithPicTimeout", "()J", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class OModelConfig implements Parcelable {
    public static final Parcelable.Creator<OModelConfig> CREATOR = null;
    private final String intentModel;
    private final String pcSearchModel;
    private final long queryWithPicTimeout;

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.intentModel);
        r3.writeString(this.pcSearchModel);
        r3.writeLong(this.queryWithPicTimeout);
    }

    public final String getIntentModel() {
        return this.intentModel;
    }

    public final String getPcSearchModel() {
        return this.pcSearchModel;
    }

    public final long getQueryWithPicTimeout() {
        return this.queryWithPicTimeout;
    }

    public OModelConfig(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "intentModel");
        Intrinsics.checkNotNullParameter(r3, "pcSearchModel");
        this.intentModel = r2;
        this.pcSearchModel = r3;
        this.queryWithPicTimeout = r4;
    }
}
