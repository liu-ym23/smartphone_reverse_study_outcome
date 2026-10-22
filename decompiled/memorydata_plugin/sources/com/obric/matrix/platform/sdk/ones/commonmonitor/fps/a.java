package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/CommonUtil;", "", "()V", "getCurrentPrinter", "Landroid/util/Printer;", "toDropFrameJson", "Lorg/json/JSONObject;", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8086a = null;

    static {
        f8086a = new a();
    }

    private a() {
    }

    public final Printer a() {
        Field r0 = ZeusTransformUtils.forName("android.os.Looper", "com.obric.memorydata.plugin").getDeclaredField("mLogging");     // Catch: Exception -> L8
        r0.setAccessible(true);     // Catch: Exception -> L8
        Object r1 = r0.get(Looper.getMainLooper());     // Catch: Exception -> L8
        if (r1 == null) goto L7;
        return (Printer) ZeusTransformUtils.preCheckCast(r1, Printer.class, "com.obric.memorydata.plugin");
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L8
    L9:
        return (Printer) ZeusTransformUtils.preCheckCast(null, Printer.class, "com.obric.memorydata.plugin");
    }

    public final JSONObject a(d r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        JSONObject r3 = new JSONObject();
        r3.put("drop_rate", r4.b());
        r3.put("drop_3", r4.c());
        r3.put("drop_7", r4.d());
        r3.put("drop_25", r4.e());
        return r3;
    }
}
