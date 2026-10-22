package py0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(a.class, "aioLinkWorkerThreadWhiteList", "getAioLinkWorkerThreadWhiteList()Ljava/util/List;", 1))};
        a = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("aiolink_worker_thread_white_list", CollectionsKt.listOf(new String[]{"core.service.NativeHostService", "webcast.revenue.biz.foundation.SettingService", "webcast.revenue.biz.foundation.StorageService", "webcast.revenue.biz.foundation.NetworkService", "webcast.revenue.biz.user.UserService", "webcast.revenue.biz.room.RoomService"}), hn3.a.b, false);
        b = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[0]);
    }
}
