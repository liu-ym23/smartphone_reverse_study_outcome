package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class AnchorLinkMicIdInfo extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.j> implements com.bytedance.android.livesdk.link.model.bridge.j {

    @SerializedName("backup_linkmic_id_str")
    public String backupLinkMicId;

    @SerializedName("main_linkmic_id_str")
    public String mainLinkMicId;

    @SerializedName("use_backup_stream")
    public boolean useBackupStream;

    public AnchorLinkMicIdInfo() {
        super(com.bytedance.android.livesdk.link.model.bridge.j.class);
    }

    public String getInUseLinkMicId() {
        if (this.useBackupStream == false) goto L6;
        return this.backupLinkMicId;
    L6:
        return this.mainLinkMicId;
    }

    public String toString() {
        return "AnchorLinkMicIdInfo{useBackupStream=" + this.useBackupStream + ", mainLinkMicId='" + this.mainLinkMicId + "', backupLinkMicId='" + this.backupLinkMicId + "'}";
    }

    public String getBackupLinkMicId() {
        return this.backupLinkMicId;
    }

    public String getMainLinkMicId() {
        return this.mainLinkMicId;
    }

    public boolean getUseBackupStream() {
        return this.useBackupStream;
    }
}
