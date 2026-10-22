package com.obric.memorydata.middleware.api.bdtracker;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&JD\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/middleware/api/bdtracker/IMemoryAppLogSettings;", "Lcom/bytedance/news/common/service/manager/IService;", "registerDidReadyListener", "", "onDidReady", "Lkotlin/Function0;", "registerDidListener", "onRemoteDidChanged", "Lkotlin/Function1;", "", "onIdLoaded", "onCurrentDid", "getServerDeviceId", "getIid", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IMemoryAppLogSettings extends IService {
    String getIid();

    String getServerDeviceId();

    void registerDidListener(Function1<? super String, Unit> r1, Function1<? super String, Unit> r2, Function1<? super String, Unit> r3);

    void registerDidReadyListener(Function0<Unit> r1);
}
