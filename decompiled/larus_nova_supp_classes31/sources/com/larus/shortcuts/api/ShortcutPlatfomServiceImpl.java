package com.larus.shortcuts.api;

import com.larus.platform.api.IShortcutPlatformService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J8\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\nH\u0016¨\u0006\u0016"}, d2 = {"Lcom/larus/shortcuts/api/ShortcutPlatfomServiceImpl;", "Lcom/larus/platform/api/IShortcutPlatformService;", "<init>", "()V", "addDynamicShortcut", "", "canShowCamera", "", "canShowRealtime", "cvsID", "", "refreshDynamicShortcut", "snapshotDynamicShortcutConfig", "clearDynamicShortcut", "tryAddPinShortcut", "cvsName", "iconUrl", "isCallBot", "eventJson", "Lorg/json/JSONObject;", "tryDisablePinShortcut", "cvsdID", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ShortcutPlatfomServiceImpl implements IShortcutPlatformService {
    public ShortcutPlatfomServiceImpl() {
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void b() {
        IShortcutsService r0 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void d() {
        IShortcutsService r0 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void e() {
        IShortcutsService r0 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "cvsdID");
        IShortcutsService r0 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void s0(boolean r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "cvsID");
        IShortcutsService r0 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r0 == null) goto L6;
        r0.s0(r3, r4, r5);
        return;
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void c(String r8, String r9, String r10, boolean r11, JSONObject r12) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r9 != null) goto L6;
        return;
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        IShortcutsService r1 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r1 == null) goto L12;
        r1.c(r8, r9, r10, r11, r12);
        return;
    }
}
