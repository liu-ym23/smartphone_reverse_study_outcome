package com.bytedance.applog.map.api;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/applog/map/api/MapContext;", "", "()V", "config", "Lcom/bytedance/applog/map/api/MapConfig;", "getConfig", "()Lcom/bytedance/applog/map/api/MapConfig;", "setConfig", "(Lcom/bytedance/applog/map/api/MapConfig;)V", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "logger", "Lcom/bytedance/applog/log/AbsLogger;", "getLogger", "()Lcom/bytedance/applog/log/AbsLogger;", "setLogger", "(Lcom/bytedance/applog/log/AbsLogger;)V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "map-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakReference<Context> f1666b;
    private static com.bytedance.applog.log.a c;

    static {
        f1665a = new d();
    }

    private d() {
    }

    public final com.bytedance.applog.log.a a() {
        return c;
    }

    public final WeakReference<Context> getContext() {
        return f1666b;
    }
}
