package com.bytedance.ai.resource;

import androidx.annotation.Keep;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageBaseRequest;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoList;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000J\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\u000bJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00012\u0006\u0010\u0006\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/resource/IAIPackageNetService;", "Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", "Lcom/bytedance/ai/resource/core/bean/AIPackageAppList;", "requestPreInstallList", "()Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", "Lcom/bytedance/ai/resource/core/bean/AIPackageBaseRequest;", "request", "requestPreInstallListByApp", "(Lcom/bytedance/ai/resource/core/bean/AIPackageBaseRequest;)Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", "Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkRequest;", "requestDeploymentInfoById", "(Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkRequest;)Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", "requestUpdateInfo", "Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoRequest;", "Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoList;", "requestGeckoInfo", "(Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoRequest;)Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", "Lcom/bytedance/ai/resource/core/bean/AIPackageInfoRequest;", "requestPackageDeploymentInfo", "(Lcom/bytedance/ai/resource/core/bean/AIPackageInfoRequest;)Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAIPackageNetService {
    AIPackageNetworkResponse<AIPackageAppList> requestDeploymentInfoById(AIPackageNetworkRequest r5);

    AIPackageNetworkResponse<AIPackageGeckoInfoList> requestGeckoInfo(AIPackageGeckoInfoRequest r5);

    AIPackageNetworkResponse<AIPackageAppList> requestPackageDeploymentInfo(AIPackageInfoRequest r5);

    AIPackageNetworkResponse<AIPackageAppList> requestPreInstallList();

    AIPackageNetworkResponse<AIPackageAppList> requestPreInstallListByApp(AIPackageBaseRequest r5);

    AIPackageNetworkResponse<AIPackageAppList> requestUpdateInfo(AIPackageNetworkRequest r5);
}
