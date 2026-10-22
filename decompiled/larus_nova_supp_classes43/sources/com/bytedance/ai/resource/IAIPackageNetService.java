package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageBaseRequest;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoList;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.ai.resource.core.bean.IsInAppWhitelistData;
import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.bean.OpenPlatformDebugSchemaData;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptResponseData;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppVersionList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPublicKeyListData;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\tH&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\tH&J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\u0006\u001a\u00020\rH&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u000fH&J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H&J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0017H&JJ\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014H&J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010$\u001a\u00020\u0014H&J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00112\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020'H&J>\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00112\u0006\u0010*\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u001bH&¨\u0006."}, d2 = {"Lcom/bytedance/ai/resource/IAIPackageNetService;", "Lcom/bytedance/ai/infra/service/IAppletService;", "requestPreInstallList", "Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", "Lcom/bytedance/ai/resource/core/bean/AIPackageAppList;", "requestPreInstallListByApp", "request", "Lcom/bytedance/ai/resource/core/bean/AIPackageBaseRequest;", "requestDeploymentInfoById", "Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkRequest;", "requestUpdateInfo", "requestGeckoInfo", "Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoList;", "Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoRequest;", "requestPackageDeploymentInfo", "Lcom/bytedance/ai/resource/core/bean/AIPackageInfoRequest;", "getSignPublicKeys", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformBaseResponse;", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPublicKeyListData;", "packageName", "", "decryptDek", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformDekDecryptResponseData;", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformDekDecryptRequest;", "requestDebugDeploymentInfo", "Lcom/bytedance/ai/resource/core/bean/IsInAppWhitelistData;", "source", "", "versionCode", "", "versionTag", "deviceId", BdpShareBaseInfo.CHANNEL_TOKEN, "xToken", "getDebugSchema", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformDebugSchemaData;", "shortToken", "getPreviewAppInfoList", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoList;", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoRequest;", "getPreviewAppVersionList", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppVersionList;", "appKey", "mode", "cursor", "limit", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAIPackageNetService extends b5.b {
    OpenPlatformBaseResponse<OpenPlatformDekDecryptResponseData> decryptDek(String r1, OpenPlatformDekDecryptRequest r10);

    OpenPlatformBaseResponse<OpenPlatformDebugSchemaData> getDebugSchema(String r1);

    OpenPlatformBaseResponse<OpenPlatformPreviewAppInfoList> getPreviewAppInfoList(String r1, OpenPlatformPreviewAppInfoRequest r10);

    OpenPlatformBaseResponse<OpenPlatformPreviewAppVersionList> getPreviewAppVersionList(String r1, String r10, String r11, String r12, String r13, int r14);

    OpenPlatformBaseResponse<OpenPlatformPublicKeyListData> getSignPublicKeys(String r1);

    OpenPlatformBaseResponse<IsInAppWhitelistData> requestDebugDeploymentInfo(int r1, String r10, long r11, String r12, String r13, String r14, String r15);

    AIPackageNetworkResponse<AIPackageAppList> requestDeploymentInfoById(AIPackageNetworkRequest r1);

    AIPackageNetworkResponse<AIPackageGeckoInfoList> requestGeckoInfo(AIPackageGeckoInfoRequest r1);

    AIPackageNetworkResponse<AIPackageAppList> requestPackageDeploymentInfo(AIPackageInfoRequest r1);

    AIPackageNetworkResponse<AIPackageAppList> requestPreInstallList();

    AIPackageNetworkResponse<AIPackageAppList> requestPreInstallListByApp(AIPackageBaseRequest r1);

    AIPackageNetworkResponse<AIPackageAppList> requestUpdateInfo(AIPackageNetworkRequest r1);
}
