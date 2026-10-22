package com.bytedance.applog.log;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH&J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/applog/log/AbsLogger;", "", NotificationCompat.CATEGORY_ERROR, "", LocationMonitorConst.TAG, "", "throwable", "", "message", "Lkotlin/Function0;", "info", "log_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface a {
    void a(String r1, Throwable r2, Function0<String> r3);

    void a(String r1, Function0<String> r2);
}
