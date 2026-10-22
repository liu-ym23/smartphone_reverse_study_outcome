package com.bytedance.ai.resource.core.net;

import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageBaseRequest;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoList;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u001e\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u001e\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\nH'J\u001e\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\nH'J\u001e\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u000eH'J\u001e\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0010H'¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/resource/core/net/AIPackageNetApi;", "", "requestPreInstallList", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", "Lcom/bytedance/ai/resource/core/bean/AIPackageAppList;", "requestPreInstallListByApp", "body", "Lcom/bytedance/ai/resource/core/bean/AIPackageBaseRequest;", "requestDeploymentInfoById", "Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkRequest;", "requestUpdateInfo", "requestGeckoInfo", "Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoList;", "Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoRequest;", "requestPackageDeploymentInfo", "Lcom/bytedance/ai/resource/core/bean/AIPackageInfoRequest;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AIPackageNetApi {
    @POST("/aiverse/app/get_by_id_list")
    Call<AIPackageNetworkResponse<AIPackageAppList>> requestDeploymentInfoById(@Body AIPackageNetworkRequest r1);

    @POST("/aiverse/app/get_by_package_list_gecko")
    Call<AIPackageNetworkResponse<AIPackageGeckoInfoList>> requestGeckoInfo(@Body AIPackageGeckoInfoRequest r1);

    @POST("/aiverse/app/get_by_package_list")
    Call<AIPackageNetworkResponse<AIPackageAppList>> requestPackageDeploymentInfo(@Body AIPackageInfoRequest r1);

    @POST("/aiverse/app/get_preinstall_list")
    Call<AIPackageNetworkResponse<AIPackageAppList>> requestPreInstallList();

    @POST("/aiverse/app/get_preinstall_list_by_app")
    Call<AIPackageNetworkResponse<AIPackageAppList>> requestPreInstallListByApp(@Body AIPackageBaseRequest r1);

    @POST("/aiverse/app/get_update_list")
    Call<AIPackageNetworkResponse<AIPackageAppList>> requestUpdateInfo(@Body AIPackageNetworkRequest r1);
}
