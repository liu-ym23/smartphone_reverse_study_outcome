package o1;

import ai.j0;
import com.bytedance.ai.bridge.core.AIBridgeMethod$InvalidResultError;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.google.gson.JsonObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JsonObject f20392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f20393c;

    public /* synthetic */ g(JsonObject r5, CoreAIBridgeMethod r10) {
        this.f20391a = 0;
        this.f20392b = r5;
        this.f20393c = r10;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r13, Method r14, Object[] r15) {
        JsonObject r5 = this.f20392b;
        Object r10 = this.f20393c;
        switch(this.f20391a) {
            case 0: goto L57;
            default: goto L4;
        };
    L4:
        ConcurrentHashMap r12 = e.f20389a;
        Class r11 = (Class) r10;
        Intrinsics.checkNotNullParameter(r11, "resultModelClazz");
        Class r16 = (Class) e.f20390b.get(r11);
        k r17 = null;
        if (r16 != null) goto L7;
        c r18 = null;
    L8:
        if (r18 == null) goto L10;
        HashMap r19 = r18.d.f20388a;
    L12:
        if (Intrinsics.areEqual(r14.getName(), "toJson") == false) goto L43;
        if (r19 == null) goto L82;
        Iterator r110 = r19.entrySet().iterator();
    L16:
        if (r110.hasNext() == false) goto L84;
        k r111 = (k) ((Map.Entry) r110.next()).getValue();
        if (r5.has(r111.f20400b) == true) goto L16;
        h r112 = r111.f20401c;
        DefaultType r113 = r112.f20394a;
        DefaultType r20 = DefaultType.NONE;
        String r21 = r111.f20400b;
        if (r113 != r20) goto L22;
        if (r111.f20399a == false) goto L16;
        throw new AIBridgeMethod$InvalidResultError(j0.C("can not find required result:", r21));
    L22:
        int r114 = r1.a.f21639a[r113.ordinal()];
        if (r114 != 1) goto L25;
        r5.addProperty(r21, Integer.valueOf(r112.d));
        goto L16
    L25:
        if (r114 != 2) goto L27;
        r5.addProperty(r21, Long.valueOf(r112.f));
        goto L16
    L27:
        if (r114 != 3) goto L29;
        r5.addProperty(r21, Double.valueOf(r112.f20395b));
        goto L16
    L29:
        if (r114 != 4) goto L30;
        r5.addProperty(r21, Boolean.valueOf(r112.e));
        goto L16
    L30:
        String r115 = r112.f20396c;
        if (r114 != 5) goto L32;
        r5.addProperty(r21, r115);
        goto L16
    L32:
        r5.addProperty(r21, r115);
        goto L16
    L84:
        return r5;
    L82:
        return r5;
    L43:
        if (r19 == null) goto L48;
        k r116 = (k) r19.get(r14);
        if (r116 == null) goto L83;
        Intrinsics.checkNotNull(r15);
        r5.add(r116.f20400b, z0.a.a().toJsonTree(ArraysKt.first(r15)));
    L83:
        return Unit.INSTANCE;
    L48:
        Intrinsics.checkNotNull(r14);
        AIBridgeParamField r117 = (AIBridgeParamField) r14.getAnnotation(AIBridgeParamField.class);
        if (r117 == null) goto L52;
        AIBridgeDefaultValue r118 = r117.defaultValue();
        r17 = new k(r117.required(), r117.keyPath(), new h(r118.type(), r118.doubleValue(), r118.stringValue(), r118.intValue(), r118.boolValue(), r118.longValue()));
    L52:
        if (r17 == null) goto L55;
        Intrinsics.checkNotNull(r15);
        r5.add(r17.f20400b, z0.a.a().toJsonTree(ArraysKt.first(r15)));
    L55:
        return Unit.INSTANCE;
    L10:
        r19 = null;
        goto L12
    L7:
        r18 = (c) e.f20389a.get(r16);
        goto L8
    L57:
        return CoreAIBridgeMethod.a(r5, (CoreAIBridgeMethod) r10, r13, r14, r15);
    }

    public /* synthetic */ g(Class r5, JsonObject r10) {
        this.f20391a = 1;
        this.f20393c = r5;
        this.f20392b = r10;
    }
}
