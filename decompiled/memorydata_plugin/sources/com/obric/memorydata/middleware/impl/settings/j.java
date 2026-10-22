package com.obric.memorydata.middleware.impl.settings;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.middleware.api.settings.IReportPackageNameBlackListSetting;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0000H\u0016R(\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/ReportPackageNameBlackListSetting;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "Lcom/obric/memorydata/middleware/api/settings/IReportPackageNameBlackListSetting;", "<init>", "()V", "create", "blackList", "", "", "getBlackList", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j implements IReportPackageNameBlackListSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("black_list")
    private List<String> f11867a;

    public j() {
        this.f11867a = CollectionsKt.emptyList();
    }

    public j a() {
        return new j();
    }

    @Override // com.obric.memorydata.middleware.api.settings.IReportPackageNameBlackListSetting
    public List<String> getBlackList() {
        return this.f11867a;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IReportPackageNameBlackListSetting
    public void setBlackList(List<String> r3) {
        this.f11867a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }
}
