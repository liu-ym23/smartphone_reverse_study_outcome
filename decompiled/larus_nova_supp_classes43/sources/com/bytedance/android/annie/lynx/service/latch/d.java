package com.bytedance.android.annie.lynx.service.latch;

import android.content.Context;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.ies.web.jsbridge2.u;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements ex.b.a {
    public static final a b = null;
    public final e a;

    public static final class a implements Function3<Context, com.bytedance.ies.web.jsbridge2.b, LatchProcessOptions, ex.b.a> {
        public a() {
        }

        public final Object invoke(Object r10, Object r11, Object r12) {
            Context r13 = (Context) r10;
            com.bytedance.ies.web.jsbridge2.b r14 = (com.bytedance.ies.web.jsbridge2.b) r11;
            LatchProcessOptions r15 = (LatchProcessOptions) r12;
            Intrinsics.checkNotNullParameter(r13, "context");
            Intrinsics.checkNotNullParameter(r14, "bridge");
            Intrinsics.checkNotNullParameter(r15, "options");
            return new d(r13, r14, r15);
        }
    }

    static {
        b = new a();
    }

    public final void release() {
        this.a.release();
    }

    public d(Context r11, com.bytedance.ies.web.jsbridge2.b r12, LatchProcessOptions r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "bridgeImpl");
        Intrinsics.checkNotNullParameter(r13, "options");
        e r0 = new e();
        this.a = r0;
        JSBridgeManager r10 = new JSBridgeManager(null);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r0.a = r10;
        com.bytedance.android.latch.b r1 = new com.bytedance.android.latch.b(r13.f, "enableRegisterXBridge");
        e r14 = this.a;
        List<? extends u> r15 = CollectionsKt.emptyList();
        Boolean r16 = Boolean.FALSE;
        String r17 = (String) r1.a.get(r1.b);
        KClass r18 = Reflection.getOrCreateKotlinClass(Boolean.class);
        if (Intrinsics.areEqual(r18, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L15;
        if (r17 != null) goto L36;
        Object r19 = null;
    L9:
        if ((r19 instanceof Boolean) == true) goto L11;
        r19 = null;
    L11:
        Boolean r20 = (Boolean) r19;     // Catch: Exception -> L6
        if (r20 == null) goto L31;
    L29:
        r16 = r20;
    L31:
        if (r16.booleanValue() == false) goto L33;
        String r110 = "all";
    L34:
        r10.e(r14, r11, r12, r15, null, r110);
        ((com.bytedance.android.annie.service.prefetch.p) Annie.getService$default(com.bytedance.android.annie.service.prefetch.p.class, null, 2, null)).r0(this.a);
        r10.d();
        return;
    L33:
        r110 = "none";
        goto L34
    L36:
        r19 = Integer.valueOf(CastIntegerProtector.parseInt(r17));     // Catch: Exception -> L6
        goto L9
    L15:
        if (Intrinsics.areEqual(r18, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L22;
        if (r17 == null) goto L31;
        if (Intrinsics.areEqual(r17, "1") == false) goto L20;
        r16 = Boolean.TRUE;
        goto L31
    L20:
        Intrinsics.areEqual(r17, "0");
        goto L31
    L22:
        if (Intrinsics.areEqual(r18, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L31;
        boolean r21 = r17 instanceof Boolean;
        Object r22 = r17;
        if (r21 == true) goto L26;
        r22 = null;
    L26:
        r20 = (Boolean) r22;
        if (r20 != null) goto L29;
        goto L29
    }
}
