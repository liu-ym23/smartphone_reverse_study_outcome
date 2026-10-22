package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u0006\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/n;", "", "<init>", "()V", "", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "appendCommonParamsHostAllowList", "", "Z", "()Z", "androidEnableCommonParamsCheck", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("appendCommonParamsHostAllowList")
    private final List<String> f5222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("android_enable_common_params_check")
    private final boolean f5223b;

    public n() {
        this.f5222a = CollectionsKt.emptyList();
    }

    public final boolean a() {
        return this.f5223b;
    }

    public final List b() {
        return this.f5222a;
    }
}
