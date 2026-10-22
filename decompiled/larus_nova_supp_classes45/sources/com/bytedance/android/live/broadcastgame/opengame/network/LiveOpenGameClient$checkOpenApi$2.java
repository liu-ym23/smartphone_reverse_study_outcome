package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.broadcastgame.opengame.network.model.PassOpenApiCheck;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "method", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveOpenGameClient$checkOpenApi$2 extends Lambda implements Function1<Method, Boolean> {
    public static final LiveOpenGameClient$checkOpenApi$2 INSTANCE = null;

    static {
        INSTANCE = new LiveOpenGameClient$checkOpenApi$2();
    }

    public LiveOpenGameClient$checkOpenApi$2() {
        super(1);
    }

    public final boolean invoke(Method r6) {
        Annotation[] r7 = r6.getAnnotations();
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Annotation r3 = r7[r2];
        if ((r3 instanceof PassOpenApiCheck) == true) goto L9;
        r2 = r2 + 1;
    L9:
        if (r3 != null) goto L14;
        return true;
    L14:
        return false;
    L8:
        r3 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((Method) r1));
    }
}
