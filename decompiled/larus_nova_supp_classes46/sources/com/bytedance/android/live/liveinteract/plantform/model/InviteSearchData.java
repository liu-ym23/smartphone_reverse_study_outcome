package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.linkmic_audience.InviteSearchResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
public class InviteSearchData extends FlexModelBase<j> implements j {

    @SerializedName("user")
    public List<LinkPlayerInfo> mPlayerInfo;

    public InviteSearchData() {
        super(j.class);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.j
    public List<ILinkPlayerInfoBridge> getMPlayerInfo() {
        return this.mPlayerInfo;
    }
}
