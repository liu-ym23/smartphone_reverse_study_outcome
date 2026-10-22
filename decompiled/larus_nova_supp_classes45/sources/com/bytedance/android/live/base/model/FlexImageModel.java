package com.bytedance.android.live.base.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.im.FlexImageStruct")
public class FlexImageModel extends ImageModel implements f {

    @SerializedName("top_border_height")
    long topBorderHeight;

    public FlexImageModel() {
    }

    @Override // com.bytedance.android.live.base.model.f
    public long flexImageTopBorderHeight() {
        return this.topBorderHeight;
    }

    public long getTopBorderHeight() {
        return this.topBorderHeight;
    }

    public void setTopBorderHeight(long r1) {
        this.topBorderHeight = r1;
    }
}
