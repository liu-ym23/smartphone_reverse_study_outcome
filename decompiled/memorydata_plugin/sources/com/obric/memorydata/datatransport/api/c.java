package com.obric.memorydata.datatransport.api;

import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"DataTransportManager", "Lcom/obric/memorydata/datatransport/api/DataTransportManagerApi;", "getDataTransportManager", "()Lcom/obric/memorydata/datatransport/api/DataTransportManagerApi;", "data_transport_api_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DataTransportManagerApi f9725a = null;

    static {
        f9725a = (DataTransportManagerApi) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(DataTransportManagerApi.class)), DataTransportManagerApi.class, "com.obric.memorydata.plugin");
    }

    public static final DataTransportManagerApi a() {
        return f9725a;
    }
}
