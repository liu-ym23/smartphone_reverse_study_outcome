package com.bytedance.awemeopen.infra.base.net.request;

import com.bytedance.awemeopen.infra.base.net.AoNetRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/request/BaseBdpRequestCallback;", "Lcom/bytedance/awemeopen/infra/base/net/request/AoRequestCallback;", "()V", "onCancel", "", "id", "", "request", "Lcom/bytedance/awemeopen/infra/base/net/AoNetRequest;", "onStart", "ao_base_core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BaseBdpRequestCallback implements AoRequestCallback {
    @Override // com.bytedance.awemeopen.infra.base.net.request.AoRequestCallback
    public void onCancel(int r1, AoNetRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
    }

    @Override // com.bytedance.awemeopen.infra.base.net.request.AoRequestCallback
    public void onStart(int r1) {
    }

    public BaseBdpRequestCallback() {
    }
}
