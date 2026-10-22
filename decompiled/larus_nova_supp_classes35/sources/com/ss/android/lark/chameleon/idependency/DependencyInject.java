package com.ss.android.lark.chameleon.idependency;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/DependencyInject;", BuildConfig.FLAVOR, "()V", "initDependency", BuildConfig.FLAVOR, "iDependency", "Lcom/ss/android/lark/chameleon/idependency/IDependency;", "injectEnv", "env", "Lcom/ss/android/lark/chameleon/idependency/IEnv;", "injectLog", "log", "Lcom/ss/android/lark/chameleon/idependency/ILog;", "injectNetService", "netService", "Lcom/ss/android/lark/chameleon/idependency/INetService;", "injectSettings", "settings", "Lcom/ss/android/lark/chameleon/idependency/ISettings;", "injectStatisticService", "statistic", "Lcom/ss/android/lark/chameleon/idependency/IStatisticService;", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DependencyInject {
    public static final DependencyInject INSTANCE = null;

    static {
        INSTANCE = new DependencyInject();
    }

    private DependencyInject() {
    }

    private final void injectEnv(IEnv r2) {
        Env.INSTANCE.setIEnv(r2);
    }

    private final void injectLog(ILog r2) {
        Log.INSTANCE.setILog(r2);
    }

    private final void injectNetService(INetService r2) {
        NetService.INSTANCE.setNetService(r2);
    }

    private final void injectSettings(ISettings r2) {
        Settings.INSTANCE.setSSettings(r2);
    }

    private final void injectStatisticService(IStatisticService r2) {
        StatisticService.INSTANCE.setIStatisticService(r2);
    }

    public final void initDependency(IDependency r3) {
        Intrinsics.checkNotNullParameter(r3, "iDependency");
        IEnv r0 = r3.getEnvDependency();
        if (r0 == null) goto L5;
        INSTANCE.injectEnv(r0);
    L5:
        ILog r1 = r3.getLogDependency();
        if (r1 == null) goto L8;
        INSTANCE.injectLog(r1);
    L8:
        IStatisticService r2 = r3.getStatisticService();
        if (r2 == null) goto L11;
        INSTANCE.injectStatisticService(r2);
    L11:
        INetService r4 = r3.getNetSerivice();
        if (r4 == null) goto L14;
        INSTANCE.injectNetService(r4);
    L14:
        ISettings r5 = r3.getSettings();
        if (r5 == null) goto L18;
        INSTANCE.injectSettings(r5);
        return;
    }
}
