package com.bytedance.applog.params;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applog/params/EmptyCommonParams;", "Lcom/bytedance/applog/params/CommonParamsApi;", "Lcom/bytedance/applog/params/CommonParamsHelper;", "()V", "destroy", "", "getBiz", "Lcom/bytedance/applog/params/BizCommonParamsApi;", "biz", "", "handleEvent", "event", "paramsJsonString", "setLogEnable", "enabled", "", "EmptyBizCommonParams", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d implements b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1767a = null;

    static {
        f1767a = new d();
    }

    private d() {
    }

    @Override // com.bytedance.applog.params.c
    public String a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "event");
        return "";
    }

    @Override // com.bytedance.applog.params.c
    public void a(boolean r1) {
    }
}
