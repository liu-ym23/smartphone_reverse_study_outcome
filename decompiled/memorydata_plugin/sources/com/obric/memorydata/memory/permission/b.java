package com.obric.memorydata.memory.permission;

import com.obric.memorydata.memory.api.ICommonAddressManager;
import com.obric.memorydata.memory.ui.address.edit.AddressManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/permission/MemoryLocationPermissionHelper;", "", "<init>", "()V", "TAG", "", "hasRequiredLocationPermission", "", "syncLocationPermissionState", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10340a = null;

    static {
        f10340a = new b();
    }

    private b() {
    }

    public final boolean a() {
        return com.obric.memorydata.address.a.f8427a.b();
    }

    public final void b() {
        com.obric.memorydata.b.a.f8796a.c();
        if (com.obric.memorydata.address.a.f8427a.a() == true) goto L6;
        return;
    L6:
        if (a() == false) goto L8;
        return;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLocationPermissionHelper", "disable auto learn because location permission is missing", false, 4, null);
        ICommonAddressManager.a.a((ICommonAddressManager) ZeusTransformUtils.preCheckCast(AddressManager.INSTANCE, ICommonAddressManager.class, "com.obric.memorydata.plugin"), false, null, 2, null);
    }
}
