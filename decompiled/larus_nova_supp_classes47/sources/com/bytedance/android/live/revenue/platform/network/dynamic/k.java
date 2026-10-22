package com.bytedance.android.live.revenue.platform.network.dynamic;

import com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements IPreviewSyncDataType {
    public final /* synthetic */ String a;

    public final Class<?> getDataClass() {
        return Object.class;
    }

    public final String getSyncKey() {
        return this.a;
    }

    public k(String r1) {
        this.a = r1;
    }
}
