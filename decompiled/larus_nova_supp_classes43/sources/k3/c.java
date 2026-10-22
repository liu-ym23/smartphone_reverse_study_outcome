package k3;

import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.google.gson.JsonObject;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DefaultType.values().length];
            r0[DefaultType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[DefaultType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[DefaultType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DefaultType.BOOL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[DefaultType.STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public static BaseModel a(final Class r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        final JsonObject r0 = new JsonObject();
        Object r11 = Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new b(r10, r0));
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type T of com.bytedance.ai.bridge.core.utils.ResultModelArguments.createModel");
        return (BaseModel) r11;
    }
}
