package com.bytedance.android.monitorV2.forest;

import androidx.annotation.Keep;
import com.bytedance.forest.c;
import java.util.ArrayList;
import kotlin.Metadata;
import y4.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/monitorV2/forest/ForestMonitorHelper;", "", "()V", "startMonitor", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ForestMonitorHelper {
    public static final ForestMonitorHelper INSTANCE = null;

    static {
        INSTANCE = new ForestMonitorHelper();
    }

    private ForestMonitorHelper() {
    }

    public final void startMonitor() {
        a r5 = new a();
        ArrayList r10 = c.f4233a;
        monitor-enter(r10);
        r10.add(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
