package com.obric.memorydata.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a=\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u001a\b\u0002\u0010\n\u001a\u0014\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u0002H\t\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\t0\u000f¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"getOrNull", "", "Lorg/json/JSONObject;", ActivityLifecycle.NAME, "", "getIntOrDefault", "", "getStringOrDefault", "runSafely", ExifInterface.GPS_DIRECTION_TRUE, "onError", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class y {
    public static final int a(JSONObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        return r1.getInt(r2);
    L5:
        return -1;
    }

    public static final <T> T a(Function1<? super Exception, ? extends T> r2, Function0<? extends T> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "block");
        return (T) r5.invoke();
    L5:
        e = move-exception;
        e.printStackTrace();
        if (AppContext.INSTANCE.isDebug() == true) goto L13;
        if (r4 == null) goto L11;
        T r6 = (T) r4.invoke(e);
        if (r6 == null) goto L11;
        return r6;
    L11:
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L13:
        throw e;
    }

    public static /* synthetic */ Object a(Function1 r1, Function0 r2, int r3, Object r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r1, Function1.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = null;
    L6:
        return a(r5, r6);
    }

    public static final String b(JSONObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        String r3 = r1.getString(r2);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L5
        return r3;
    L5:
        return "";
    }
}
