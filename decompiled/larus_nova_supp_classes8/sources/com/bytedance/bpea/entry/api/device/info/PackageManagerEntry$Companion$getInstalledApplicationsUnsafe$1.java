package com.bytedance.bpea.entry.api.device.info;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a$\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/content/pm/ApplicationInfo;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class PackageManagerEntry$Companion$getInstalledApplicationsUnsafe$1 extends Lambda implements Function0<List<ApplicationInfo>> {
    final /* synthetic */ int $flags;
    final /* synthetic */ PackageManager $this_getInstalledApplicationsUnsafe;

    public PackageManagerEntry$Companion$getInstalledApplicationsUnsafe$1(PackageManager r1, int r2) {
        this.$this_getInstalledApplicationsUnsafe = r1;
        this.$flags = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<ApplicationInfo> m1619invoke() {
        PackageManager r8 = this.$this_getInstalledApplicationsUnsafe;
        int r9 = this.$flags;
        f06.c r10 = new f06.c();
        Object[] r11 = {Integer.valueOf(r9)};
        f06.b r12 = new f06.b();
        f06.d r13 = r10.b(101304, "android/content/pm/PackageManager", "getInstalledApplications", r8, r11, "java.util.List", r12);
        if (r13.a == false) goto L5;
        r10.a(101304, "android/content/pm/PackageManager", "getInstalledApplications", r8, r11, null, r12, false);
        return (List) r13.b;
    L5:
        List<ApplicationInfo> r14 = r8.getInstalledApplications(r9);
        r10.a(101304, "android/content/pm/PackageManager", "getInstalledApplications", r8, r11, r14, r12, true);
        return r14;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1619invoke();
    }
}
