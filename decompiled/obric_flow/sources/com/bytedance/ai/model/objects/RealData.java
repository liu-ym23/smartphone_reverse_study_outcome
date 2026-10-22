package com.bytedance.ai.model.objects;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/model/objects/RealData;", "", "<init>", "()V", "pluginId", "", "getPluginId", "()Ljava/lang/String;", "setPluginId", "(Ljava/lang/String;)V", "appletId", "getAppletId", "setAppletId", "pluginParams", "getPluginParams", "setPluginParams", "decodeType", "getDecodeType", "setDecodeType", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealData {
    private String appletId;
    private String decodeType;
    private String pluginId;
    private String pluginParams;

    public RealData() {
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final String getDecodeType() {
        return this.decodeType;
    }

    public final String getPluginId() {
        return this.pluginId;
    }

    public final String getPluginParams() {
        return this.pluginParams;
    }

    public final void setAppletId(String r5) {
        this.appletId = r5;
    }

    public final void setDecodeType(String r5) {
        this.decodeType = r5;
    }

    public final void setPluginId(String r5) {
        this.pluginId = r5;
    }

    public final void setPluginParams(String r5) {
        this.pluginParams = r5;
    }
}
