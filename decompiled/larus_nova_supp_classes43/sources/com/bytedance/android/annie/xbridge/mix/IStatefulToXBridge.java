package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/IStatefulToXBridge;", "Lcom/bytedance/android/annie/xbridge/mix/BaseA2BBridgeMethod;", "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class IStatefulToXBridge extends BaseA2BBridgeMethod {
    public final ConcurrentLinkedQueue<com.bytedance.ies.web.jsbridge2.f<Object, Object>> c;
    public volatile com.bytedance.ies.web.jsbridge2.f<Object, Object> d;
    public IBridgeMethod.Access e;
    public final IBridgeMethod.Access f;

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

    public abstract com.bytedance.ies.web.jsbridge2.f<?, ?> b(m16.b r1);

    public final void release() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.bytedance.ies.web.jsbridge2.f r1 = (com.bytedance.ies.web.jsbridge2.f) r0.next();
        if (r1 == null) goto L4;
        r1.terminateActualProxy();
        goto L4
    L8:
        this.c.clear();
        com.bytedance.ies.web.jsbridge2.f<Object, Object> r10 = this.d;
        if (r10 == null) goto L11;
        r10.terminateActualProxy();
    L11:
        this.d = null;
    }

    public final IBridgeMethod.Access getAccess() {
        return this.f;
    }

    public IStatefulToXBridge(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        super(r10);
        this.c = new ConcurrentLinkedQueue();
        IBridgeMethod.Access r11 = this.e;
        if (r11 != null) goto L27;
        this.d = b(((com.bytedance.ies.bullet.core.kit.bridge.j) this).a);
        com.bytedance.ies.web.jsbridge2.f<Object, Object> r12 = this.d;
        if (r12 == null) goto L7;
        PermissionGroup r13 = r12.getPermission();
    L8:
        if (r13 != null) goto L10;
        int r14 = -1;
    L12:
        if (r14 != 1) goto L14;
        r11 = IBridgeMethod.Access.PRIVATE;
    L24:
        this.e = r11;
        if (r11 != null) goto L27;
        r11 = IBridgeMethod.Access.PRIVATE;
        goto L27
    L14:
        if (r14 != 2) goto L16;
        r11 = IBridgeMethod.Access.PROTECT;
        goto L24
    L16:
        if (r14 != 3) goto L18;
        r11 = IBridgeMethod.Access.PUBLIC;
        goto L24
    L18:
        if (r14 == 4) goto L20;
        r11 = IBridgeMethod.Access.PRIVATE;
        goto L24
    L20:
        r11 = IBridgeMethod.Access.SECURE;
        goto L24
    L10:
        r14 = a.a[r13.ordinal()];
        goto L12
    L7:
        r13 = null;
    L27:
        this.f = r11;
    }

    @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod
    public final void a(JSONObject r10, BaseA2BBridgeMethod.b r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        com.bytedance.ies.web.jsbridge2.f<?, ?> r12 = this.d;
        if (r12 != null) goto L5;
        r12 = b(((com.bytedance.ies.bullet.core.kit.bridge.j) this).a);
    L5:
        this.d = null;
        if (r12 != null) goto L20;
        r11.onFailed(new Throwable("stateful method null"));
    L20:
        CallContext r13 = b.a(((com.bytedance.ies.bullet.core.kit.bridge.j) this).a);     // Catch: Throwable -> L17
        this.c.add(r12);     // Catch: Throwable -> L17
        if (r12 == null) goto L11;
        g r14 = new g(this);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r14, "callBack");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r13, "callContext");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r11, "iReturn");     // Catch: Throwable -> L17
        r12.setProxy(new h(r13, r11, r14, r12));     // Catch: Throwable -> L17
    L11:
        if (r12 == null) goto L21;
        c.a r1 = c.a;     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r10, "params");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r12, "target");     // Catch: Throwable -> L17
        Type r0 = r12.getClass().getGenericSuperclass();     // Catch: Throwable -> L17
        if (r0 == null) goto L16;
        r12.invokeProxy(c.b(r10, ((ParameterizedType) r0).getActualTypeArguments()[0]), r13);     // Catch: Throwable -> L17
        return;
    L16:
        throw new IllegalStateException("Method is not parameterized?!");     // Catch: Throwable -> L17
    L21:
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        r11.onFailed(new Throwable("stateful handle error: " + th.getMessage()));
    }
}
