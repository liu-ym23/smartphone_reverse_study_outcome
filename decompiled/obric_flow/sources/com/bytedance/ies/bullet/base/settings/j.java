package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/j;", "", "<init>", "()V", "", "", "a", "Ljava/util/List;", "getRouterBlockList", "()Ljava/util/List;", "setRouterBlockList", "(Ljava/util/List;)V", "routerBlockList", "b", "getRouterAllowList", "setRouterAllowList", "routerAllowList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("routerBlockList")
    private List<String> f5212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("routerAllowList")
    private List<String> f5213b;

    public j() {
        this.f5212a = CollectionsKt.emptyList();
        this.f5213b = CollectionsKt.emptyList();
    }
}
