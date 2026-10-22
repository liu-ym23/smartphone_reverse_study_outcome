package com.bytedance.ai.settings.provider;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/settings/provider/AIBridgeSettingsConfig;", "", "<init>", "()V", "", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "mustRunInMainJsbList", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIBridgeSettingsConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("must_run_in_main_jsb_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> f2775a;

    public AIBridgeSettingsConfig() {
        this.f2775a = CollectionsKt.listOf("x.getAppInfo");
    }

    public final List a() {
        return this.f2775a;
    }
}
