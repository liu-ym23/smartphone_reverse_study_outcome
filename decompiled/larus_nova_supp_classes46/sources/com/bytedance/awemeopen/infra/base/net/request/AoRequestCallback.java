package com.bytedance.awemeopen.infra.base.net.request;

import com.bytedance.awemeopen.infra.base.net.AoNetRequest;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/request/AoRequestCallback;", "", "onCancel", "", "id", "", "request", "Lcom/bytedance/awemeopen/infra/base/net/AoNetRequest;", "onFinish", "response", "Lcom/bytedance/awemeopen/infra/base/net/AoNetResponse;", "onStart", "ao_base_core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface AoRequestCallback {
    void onCancel(int r1, AoNetRequest r2);

    void onFinish(int r1, AoNetRequest r2, AoNetResponse r3);

    void onStart(int r1);
}
