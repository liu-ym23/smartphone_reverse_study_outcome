package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.StartAutoMatchResultModel;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomCheckDataContext;
import com.bytedance.android.livesdk.link.model.j8;
import com.bytedance.android.livesdk.link.model.k8;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.ze;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0 extends wy0.b<ze, StartAutoMatchResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public g0(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.b = r1;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(ze.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r14, CallContext r15) {
        final ze r16 = (ze) r14;
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "callContext");
        r16.getMatchType();
        final Ref.ObjectRef r17 = new Ref.ObjectRef();
        r17.element = DataType.FALSE;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r1 = null;
        com.bytedance.android.live.revlink.impl.pk.service.a r2 = null;
        String r3 = r16.getExtra();     // Catch: Exception -> L14
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        e r4 = (e) l97.a.a.fromJson(r3, TypesJVMKt.getJavaType(Reflection.typeOf(e.class)));     // Catch: Exception -> L14
        j8 r5 = r4.getAutoMatchInfo();     // Catch: Exception -> L14
        r17.element = r4.d2();     // Catch: Exception -> L12
        String r6 = r4.getGameAppId();     // Catch: Exception -> L12
        boolean r7 = r4.r6();     // Catch: Exception -> L10
    L17:
        String r12 = r6;
        j8 r8 = r5;
        if (r16.getScene() != 1) goto L38;
        if (r7 == false) goto L21;
        RandomCheckDataContext.Companion.e(r16.getSource());
        return;
    L21:
        com.bytedance.android.live.revlink.impl.global.c r18 = this.b;
        if (r18 == null) goto L24;
        r2 = r18.ja();
    L24:
        if (r2 == null) goto L54;
        int r9 = r16.getMatchType();
        String r10 = r16.getActivityType();
        if (r10 != null) goto L28;
        String r13 = "";
    L29:
        String r19 = r16.getSource();
        if (r19 != null) goto L32;
        String r20 = "";
    L33:
        int r22 = r16.W4();
        if (r8 != null) goto L36;
        b51.b r110 = b51.b.c0;
        r110.getClass();
        b51.a r111 = (b51.a) b51.b.z.getValue(r110, b51.b.a[24]);
        r8 = (j8) vh7.f.c(j8.class);
        r8.setWaitSec(r111.getWaitSec());
        r8.setAccelerateLimit(r111.getAccelerateLimit());
        r8.setDefaultWaitLimit(r111.getDefaultWaitLimit());
        k8 r0 = vh7.f.c(k8.class);
        r0.setInviteLimitSec(r111.getInviteLimitSec());
        r0.setPkAutoMatchIndex(r111.getPkAutoMatchIndex());
        Unit r112 = Unit.INSTANCE;
        r8.setConfig(r0);
    L36:
        r2.a(new com.bytedance.android.live.revlink.impl.pk.service.j(r9, r13, r20, r22, r8, new f0(), r12));
        return;
    L32:
        r20 = r19;
        goto L33
    L28:
        r13 = r10;
        goto L29
    L54:
        return;
    L38:
        if (r16.getScene() != 7) goto L56;
        if (r8 == null) goto L57;
        com.bytedance.android.live.revlink.impl.global.c r23 = this.b;
        if (r23 == null) goto L43;
        r1 = r23.Mf();
    L43:
        com.bytedance.android.live.revlink.impl.multianchor.match.a r24 = r1;
        if (r24 == null) goto L58;
        com.bytedance.android.live.revlink.impl.multianchor.match.a.C0145a.a(r24, r8, r16.getMatchType(), true, r16.W4(), new StartAutoMatchMethod$invokeActual$$inlined$let$lambda$1(this, r16, r17), 16);
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L10:
        e = e;
    L16:
        jy0.b.c("start_auto_match_method", e.toString(), null, 4);
        r7 = false;
    L12:
        e = e;
        r6 = "";
    L14:
        e = e;
        r6 = "";
        r5 = null;
        goto L16
    }
}
