package com.bytedance.android.live.broadcastgame.opengame.network;

import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "it", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveOpenGameClient$checkOpenApi$3 extends Lambda implements Function1<Method, Method> {
    final /* synthetic */ List $openApiPathList;
    final /* synthetic */ Ref.ObjectRef $requestPath;

    public LiveOpenGameClient$checkOpenApi$3(List r1, Ref.ObjectRef r2) {
        this.$openApiPathList = r1;
        this.$requestPath = r2;
        super(1);
    }

    public final Method invoke(Method r6) {
        Type r0 = r6.getGenericReturnType();
        if ((r0 instanceof ParameterizedType) == true) goto L5;
        r0 = null;
    L5:
        ParameterizedType r1 = (ParameterizedType) r0;
        if (r1 != null) goto L8;
    L12:
        return r6;
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        if (StringsKt.contains$default(r1.getActualTypeArguments()[0].getTypeName(), "OpenPlatformRespExtra", false, 2, null) == true) goto L12;
        this.$openApiPathList.add((String) this.$requestPath.element);
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Method) r1);
    }
}
