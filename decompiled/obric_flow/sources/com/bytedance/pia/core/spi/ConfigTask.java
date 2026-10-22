package com.bytedance.pia.core.spi;

import androidx.annotation.Keep;
import com.bytedance.pia.core.utils.j;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.annotation.DowngradeImpl;
import kotlin.jvm.internal.Intrinsics;
import ph.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@DowngradeImpl
public class ConfigTask implements a {
    public ConfigTask() {
    }

    public static a get() {
        return (a) ServiceManager.a().a(a.class);
    L4:
        Intrinsics.checkNotNullParameter("[SPI] try get config task failed, fallback to default.", "message");
        j.y("[SPI] try get config task failed, fallback to default.", null);
        return new ConfigTask();
    }

    @Override // java.lang.Runnable
    public void run() {
    }
}
