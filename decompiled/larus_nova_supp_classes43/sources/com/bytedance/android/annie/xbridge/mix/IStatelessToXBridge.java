package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/IStatelessToXBridge;", "Lcom/bytedance/android/annie/xbridge/mix/BaseA2BBridgeMethod;", "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class IStatelessToXBridge extends BaseA2BBridgeMethod {
    public com.bytedance.ies.web.jsbridge2.g<Object, Object> c;
    public final boolean d;
    public final IBridgeMethod.Access e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PermissionGroup.values().length];
            r0[PermissionGroup.PRIVATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PermissionGroup.PROTECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PermissionGroup.PUBLIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PermissionGroup.SECURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public abstract com.bytedance.ies.web.jsbridge2.g<?, ?> b(m16.b r1);

    public final void release() {
    }

    public final IBridgeMethod.Access getAccess() {
        return this.e;
    }

    @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod
    public final boolean i90() {
        return this.d;
    }

    public IStatelessToXBridge(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        super(r10);
        this.d = true;
        if (this.c != null) goto L5;
        this.c = b(((com.bytedance.ies.bullet.core.kit.bridge.j) this).a);
    L5:
        com.bytedance.ies.web.jsbridge2.g<Object, Object> r0 = this.c;
        if (r0 == null) goto L8;
        PermissionGroup r1 = r0.getPermission();
    L9:
        if (r1 != null) goto L11;
        int r11 = -1;
    L12:
        if (r11 != 1) goto L14;
        IBridgeMethod.Access r12 = IBridgeMethod.Access.PRIVATE;
    L24:
        this.e = r12;
        return;
    L14:
        if (r11 != 2) goto L16;
        r12 = IBridgeMethod.Access.PROTECT;
        goto L24
    L16:
        if (r11 != 3) goto L18;
        r12 = IBridgeMethod.Access.PUBLIC;
        goto L24
    L18:
        if (r11 == 4) goto L20;
        r12 = IBridgeMethod.Access.PRIVATE;
        goto L24
    L20:
        r12 = IBridgeMethod.Access.SECURE;
        goto L24
    L11:
        r11 = a.a[r1.ordinal()];
        goto L12
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod
    public final void a(JSONObject r10, BaseA2BBridgeMethod.b r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        if (this.c != null) goto L6;
        this.c = b(((com.bytedance.ies.bullet.core.kit.bridge.j) this).a);
    L6:
        if (this.c != null) goto L18;
        r11.onFailed(new Throwable("stateless method null"));
    L18:
        com.bytedance.ies.web.jsbridge2.g<Object, Object> r12 = this.c;     // Catch: Throwable -> L15
        if (r12 == null) goto L19;
        Intrinsics.checkNotNullParameter(r11, "iReturn");     // Catch: Throwable -> L15
        r12.setProxy(new i(r11));     // Catch: Throwable -> L15
        c.a r1 = c.a;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r10, "params");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r12, "target");     // Catch: Throwable -> L15
        Type r0 = r12.getClass().getGenericSuperclass();     // Catch: Throwable -> L15
        if (r0 == null) goto L14;
        r11.b(r12.invoke(c.b(r10, ((ParameterizedType) r0).getActualTypeArguments()[0]), b.a(((com.bytedance.ies.bullet.core.kit.bridge.j) this).a)));     // Catch: Throwable -> L15
        return;
    L14:
        throw new IllegalStateException("Method is not parameterized?!");     // Catch: Throwable -> L15
    L19:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        r11.onFailed(new Throwable("stateless handle error: " + th.getMessage()));
    }
}
