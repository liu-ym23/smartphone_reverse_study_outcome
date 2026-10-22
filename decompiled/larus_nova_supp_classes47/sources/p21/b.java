package p21;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.service.g;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.live.datacontext.j;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r41.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public final boolean b() {
        boolean r0 = f.a;
        if (f.c == true) goto L12;
        w r1 = e();
        if (r1 == null) goto L7;
        int r2 = r1.i();
    L9:
        if (r2 <= 4) goto L13;
        return true;
    L13:
        return false;
    L7:
        r2 = 0;
        goto L9
    L12:
        return false;
    }

    public final boolean c() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = r0.Ig();
    L7:
        if (r2 == null) goto L13;
        PkBaseStateMachine.c r3 = r2.getCurPKBaseState();
        if (r3 == null) goto L13;
        if (r3.b() != true) goto L13;
        return false;
    L13:
        com.bytedance.android.live.revlink.impl.global.c r4 = this.a;
        if (r4 == null) goto L16;
        r1 = r4.Ig();
    L16:
        if (r1 != null) goto L18;
    L20:
        return false;
    L18:
        if (r1.isInRobC() != true) goto L20;
        return true;
    L5:
        r2 = null;
        goto L7
    }

    public final w e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkUtil();
    }

    public final boolean f() {
        w r0 = e();
        if (r0 == null) goto L5;
        int r1 = r0.i();
    L7:
        if (d(r1) == false) goto L12;
        y41.d r2 = y41.d.j;
        r2.getClass();
        if (((Boolean) y41.d.e.getValue(r2, y41.d.a[3])).booleanValue() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L5:
        r1 = 0;
        goto L7
    }

    public b(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public static boolean d(int r6) {
        y41.d r0 = y41.d.j;
        r0.getClass();
        Integer[] r1 = (Integer[]) y41.d.d.getValue(r0, y41.d.a[2]);
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L14;
        if (r1[r3].intValue() != r6) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L9;
        r3 = r3 + 1;
        goto L3
    L9:
        return true;
    L7:
        r4 = false;
        goto L8
    L14:
        return false;
    }

    public final boolean a(int r7) {
        com.bytedance.android.live.revlink.impl.global.c r8 = this.a;
        g r0 = null;
        if (r8 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.utils.a r9 = r8.km();
    L7:
        if (r9 != null) goto L9;
    L10:
        w r10 = e();
        if (r10 == null) goto L13;
        UILayout r12 = r10.b();
    L15:
        if (r12 == UILayout.FULL) goto L65;
        w r13 = e();
        if (r13 == null) goto L19;
        UILayout r14 = r13.b();
    L21:
        if (r14 == UILayout.FULL_RECORD) goto L68;
        com.bytedance.android.live.revlink.impl.global.c r15 = this.a;
        if (r15 == null) goto L30;
        RevLinkWindowRegionContext r16 = r15.P8();
        if (r16 == null) goto L30;
        j<g> r17 = r16.getPartnerService();
        if (r17 == null) goto L30;
        r0 = (g) r17.getValue();
    L30:
        if (r0 != null) goto L32;
    L34:
        w r18 = e();
        if (r18 == null) goto L37;
        int r19 = r18.i();
    L38:
        y41.d r2 = y41.d.j;
        r2.getClass();
        Integer[] r3 = (Integer[]) y41.d.b.getValue(r2, y41.d.a[0]);
        int r4 = r3.length;
        int r5 = 0;
    L39:
        if (r5 >= r4) goto L47;
        if (r3[r5].intValue() != r19) goto L43;
        boolean r6 = true;
    L44:
        if (r6 == true) goto L45;
        r5 = r5 + 1;
        goto L39
    L45:
        boolean r20 = true;
    L48:
        if (r20 == true) goto L50;
        return false;
    L50:
        w r22 = e();
        if (r22 != null) goto L53;
    L60:
        y41.d r23 = y41.d.j;
        r23.getClass();
        return ((Boolean) y41.d.f.getValue(r23, y41.d.a[4])).booleanValue();
    L53:
        if (w.f(r22) != true) goto L60;
        y41.d r24 = y41.d.j;
        r24.getClass();
        ReadOnlyProperty r25 = y41.d.e;
        KProperty[] r26 = y41.d.a;
        if (((Boolean) r25.getValue(r24, r26[3])).booleanValue() == true) goto L66;
        r24.getClass();
        if (((Boolean) y41.d.f.getValue(r24, r26[4])).booleanValue() == true) goto L69;
        return false;
    L69:
        return true;
    L66:
        return true;
    L43:
        r6 = false;
        goto L44
    L47:
        r20 = false;
        goto L48
    L37:
        r19 = 0;
        goto L38
    L32:
        if (r0.n() != true) goto L34;
        return true;
    L68:
        return true;
    L19:
        r14 = null;
        goto L21
    L65:
        return true;
    L13:
        r12 = null;
        goto L15
    L9:
        if (r9.a() != true) goto L10;
        return true;
    L5:
        r9 = null;
        goto L7
    }
}
