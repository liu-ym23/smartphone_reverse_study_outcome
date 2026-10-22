package com.obric.memorydata.awareness.c;

import com.bytedance.obric.memory.a.b;
import com.bytedance.obric.memory.model.WeatherInfoReq;
import com.bytedance.obric.memory.model.WeatherInfoResp;
import com.bytedance.rpc.RpcException;
import com.obric.memorydata.awareness.api.LocationSnapshot;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.h;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/awareness/weather/WeatherDateQueryManager;", "", "<init>", "()V", "TAG", "", "getCurrentLocationWeather", "dailySteps", "", "hourlySteps", "getWeatherOfLocation", "location", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8544a = null;

    static {
        f8544a = new a();
    }

    private a() {
    }

    public final String a(int r9, int r10) {
        List<Double> r8 = LocationSnapshot.INSTANCE.getLocation(300000);
        if (r8 != null) goto L5;
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "WeatherDateQueryManager", "currentGps is null", null, 4, null);
        return "";
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L12;
        double r2 = ((Number) ZeusTransformUtils.preCheckCast(r8.get(0), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r4 = ((Number) ZeusTransformUtils.preCheckCast(r8.get(1), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        WeatherInfoReq r11 = new WeatherInfoReq();     // Catch: RpcException -> L9
        r11.longitude = r2;     // Catch: RpcException -> L9
        r11.latitude = r4;     // Catch: RpcException -> L9
        r11.dailySteps = r9;     // Catch: RpcException -> L9
        r11.hourlySteps = r10;     // Catch: RpcException -> L9
        WeatherInfoResp r12 = b.a(r11);     // Catch: RpcException -> L9
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "WeatherDateQueryManager", "getCurrentLocationWeather code: " + r12.code + " msg: " + r12.msg, false, 4, null);     // Catch: RpcException -> L9
        Intrinsics.checkNotNull(r12);     // Catch: RpcException -> L9
        return u.a(r12);
    L9:
        e = move-exception;
        RunLog.INSTANCE.error("WeatherDateQueryManager", "getCurrentLocationWeather RpcException", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return "";
    }

    public final String a(String r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "location");
        Pair<Double, Double> r7 = h.a(r8);
        if (r7 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "WeatherDateQueryManager", "getWeatherOfLocation currentGps is null", null, 4, null);
        return "";
    L6:
        double r1 = ((Number) ZeusTransformUtils.preCheckCast(r7.getFirst(), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r3 = ((Number) ZeusTransformUtils.preCheckCast(r7.getSecond(), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        WeatherInfoReq r11 = new WeatherInfoReq();     // Catch: RpcException -> L9
        r11.longitude = r1;     // Catch: RpcException -> L9
        r11.latitude = r3;     // Catch: RpcException -> L9
        r11.dailySteps = r9;     // Catch: RpcException -> L9
        r11.hourlySteps = r10;     // Catch: RpcException -> L9
        WeatherInfoResp r12 = b.a(r11);     // Catch: RpcException -> L9
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "WeatherDateQueryManager", "getWeatherOfLocation code: " + r12.code + " msg: " + r12.msg, false, 4, null);     // Catch: RpcException -> L9
        Intrinsics.checkNotNull(r12);     // Catch: RpcException -> L9
        return u.a(r12);
    L9:
        e = move-exception;
        RunLog.INSTANCE.error("WeatherDateQueryManager", "getCurrentLocationWeather RpcException", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return "";
    }
}
