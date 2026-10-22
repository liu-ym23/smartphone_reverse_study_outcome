package com.bytedance.ai.settings.provider;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/settings/provider/FrontierConfig;", "", "<init>", "()V", "", "a", "I", "()I", "frontierServerId", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FrontierConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("frontier_server_id")
    private final int f2776a;

    public FrontierConfig() {
        this.f2776a = 33554696;
    }

    public final int a() {
        return this.f2776a;
    }
}
