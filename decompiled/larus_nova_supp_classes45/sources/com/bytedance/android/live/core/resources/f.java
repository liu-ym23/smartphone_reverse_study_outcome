package com.bytedance.android.live.core.resources;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/resources/f;", "Lvh7/e;", "Lcom/bytedance/android/live/core/resources/e;", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f extends vh7.e<e>, e {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ a getAnchorGuide();

    /* synthetic */ int getAssetSource();

    /* synthetic */ b getCleanStrategy();

    /* synthetic */ String getDescribe();

    /* synthetic */ int getDownloadType();

    /* synthetic */ long getExpireTime();

    /* synthetic */ Object getFlexInstance();

    /* synthetic */ j getH265ResourceModel();

    /* synthetic */ k getH265SuperResourceModel();

    /* synthetic */ long getId();

    /* synthetic */ String getLokiExtra();

    /* synthetic */ h getLokiExtraModel();

    /* synthetic */ String getLynxSchema();

    /* synthetic */ String getMD5();

    /* synthetic */ long getMinPlayTime();

    /* synthetic */ List<String> getModelRequirements();

    /* synthetic */ long getModifyVersion();

    /* synthetic */ String getName();

    /* synthetic */ long getPlayChannel();

    /* synthetic */ l getResourceModel();

    /* synthetic */ int getResourceType();

    /* synthetic */ String getResourceUri();

    /* synthetic */ long getSize();

    /* synthetic */ boolean isHighCostAsset();

    /* synthetic */ boolean isTest();

    /* synthetic */ void setAssetSource(int r1);

    /* synthetic */ void setCdnDomainOpt(boolean r1);

    /* synthetic */ void setDescribe(String r1);

    /* synthetic */ void setDownloadType(int r1);

    /* synthetic */ void setExpireTime(long r1);

    /* synthetic */ void setH265ResourceModel(j r1);

    /* synthetic */ void setH265SuperResourceModel(k r1);

    /* synthetic */ void setId(long r1);

    /* synthetic */ void setLokiExtra(String r1);

    /* synthetic */ void setLokiExtraModel(h r1);

    /* synthetic */ void setLynxSchema(String r1);

    /* synthetic */ void setMD5(String r1);

    /* synthetic */ void setModifyVersion(long r1);

    /* synthetic */ void setName(String r1);

    /* synthetic */ void setResourceModel(l r1);

    /* synthetic */ void setResourceType(int r1);

    /* synthetic */ void setResourceUri(String r1);

    /* synthetic */ void setSize(long r1);
}
