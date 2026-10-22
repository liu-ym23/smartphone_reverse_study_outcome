package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.android.livesdk.link.model.bridge.m1;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ListUserContent extends FlexModelBase<k1> implements k1 {

    @SerializedName("linkmic_content")
    public ListUserLinkmicContent linkmicContent;

    @SerializedName("linkmic_audience_content")
    public ListUserLinkmicAudienceContent mLinkmicAudienceContent;

    public ListUserContent() {
        super(k1.class);
    }

    /* JADX INFO: renamed from: getLinkMicAudienceContent, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ l1 m199getLinkMicAudienceContent() {
        return getLinkMicAudienceContent();
    }

    /* JADX INFO: renamed from: getLinkMicContent, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ m1 m200getLinkMicContent() {
        return getLinkMicContent();
    }

    public ListUserLinkmicAudienceContent getLinkMicAudienceContent() {
        return this.mLinkmicAudienceContent;
    }

    public ListUserLinkmicContent getLinkMicContent() {
        return this.linkmicContent;
    }

    public void setLinkMicAudienceContent(l1 r1) {
        this.mLinkmicAudienceContent = jm2.a.d(r1);
    }

    public void setLinkMicContent(m1 r1) {
        this.linkmicContent = jm2.a.e(r1);
    }
}
