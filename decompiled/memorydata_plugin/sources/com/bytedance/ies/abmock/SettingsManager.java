package com.bytedance.ies.abmock;

import com.bytedance.ies.abmock.datacenter.l;
import com.bytedance.ies.abmock.datacenter.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile SettingsManager f2657b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2658a;
    private final m c;
    private final List<Object> d;

    private SettingsManager() {
        this.f2658a = "SettingsManager";
        this.d = new ArrayList();
        this.c = new l();
    }

    public static SettingsManager a() {
        if (f2657b != null) goto L15;
        monitor-enter(SettingsManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2657b != null) goto L9;
        f2657b = new SettingsManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SettingsManager.class);     // Catch: Throwable -> L11
    L15:
        return f2657b;
    }

    private static /* synthetic */ Integer a(String r1, Integer r2, Class r3) {
        return Integer.valueOf(b.a().a(r1, r2.intValue(), false));
    }

    /* JADX INFO: renamed from: lambda$7qQsGbYM-SX0HBYa96nsByx46YM, reason: not valid java name */
    public static /* synthetic */ Integer m92lambda$7qQsGbYMSX0HBYa96nsByx46YM(String r0, Integer r1, Class r2) {
        return a(r0, r1, r2);
    }

    @Deprecated
    public int a(String r4, int r5) {
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.event.a.a().a(r4, Integer.valueOf(r5), null, $$Lambda$SettingsManager$7qQsGbYMSX0HBYa96nsByx46YM.INSTANCE), Integer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return r5;
    L6:
        return r3.intValue();
    }

    public m getSettingsValueProvider() {
        return this.c;
    }
}
