package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ IDLXBridgeMethod a;

    public static final class a extends com.bytedance.ies.web.jsbridge2.f<Map<String, ? extends Object>, Object> {
        public final /* synthetic */ IDLXBridgeMethod a;

        /* JADX INFO: renamed from: com.bytedance.android.annie.xbridge.mix.q$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0089a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[IDLXBridgeMethod.Access.values().length];
                r0[IDLXBridgeMethod.Access.PRIVATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[IDLXBridgeMethod.Access.PROTECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[IDLXBridgeMethod.Access.PUBLIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[IDLXBridgeMethod.Access.SECURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public final void onTerminate() {
        }

        public final PermissionGroup getPermissionGroup() {
            IDLXBridgeMethod.Access r0 = this.a.getAccess();
            int r1 = C0089a.a[r0.ordinal()];
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L19;
            if (r1 == 3) goto L18;
            if (r1 != 4) goto L12;
            return PermissionGroup.SECURE;
        L12:
            throw new NoWhenBranchMatchedException();
        L18:
            return PermissionGroup.PUBLIC;
        L19:
            return PermissionGroup.PROTECTED;
        L16:
            return PermissionGroup.PRIVATE;
        }

        public a(IDLXBridgeMethod r1) {
            this.a = r1;
        }

        public final void invoke(Object r10, CallContext r11) {
            Map r12 = (Map) r10;
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r11, "context");
            IDLXBridgeMethod r0 = this.a;
            List<String> r1 = s.a;
            r0.realHandle(new p(new o(r11, r12, r0.getName()), r11), r12, new r(this));
        }
    }

    public q(IDLXBridgeMethod r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f a() {
        return new a(this.a);
    }
}
