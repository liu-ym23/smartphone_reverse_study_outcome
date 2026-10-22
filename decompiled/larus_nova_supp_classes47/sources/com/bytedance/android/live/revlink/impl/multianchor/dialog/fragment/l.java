package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.LinkNoScrollViewPager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ AnchorInteractContainerFragment a;

    public l(AnchorInteractContainerFragment r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        AnchorInteractContainerFragment r8 = this.a;
        boolean r1 = false;
        if (r8.P == false) goto L19;
        LinkNoScrollViewPager r0 = r8.ba0(2131392847);
        if (r0 == null) goto L9;
        int r2 = r0.getCurrentItem();
        KProperty[] r3 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        if (r2 != 1) goto L9;
        r1 = true;
    L9:
        com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d r4 = r8.q;
        if (r4 == null) goto L26;
        HashMap r5 = new HashMap();
        r5.put("pk_description", "routine");
        if (r1 == false) goto L15;
        String r6 = "pk_banner";
    L16:
        r5.put("source", r6);
        r5.put("room_status", "live");
        r5.put("anchor_connect_status", DataType.FALSE);
        mz0.n r9 = new mz0.n();
        Map<String, String> r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r10.putAll(r5);
        mz0.m r12 = new mz0.m();
        r12.b(LogCommon.ROOM);
        List<Object> r13 = r9.b;
        ArrayList r14 = (ArrayList) r13;
        r14.addAll(r12.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((mz0.i) ((f80.a) r16)).w3("livesdk_pk_record_click", r9.a, r9.b);
        DataCenter r17 = r8.p;
        if (r17 == null) goto L24;
        com.bytedance.android.live.revlink.impl.control.dialog.r r18 = r8.d;
        int r19 = InteractRecordContainerFragment.o;
        int r20 = r4.getSkinType();
        Intrinsics.checkNotNullParameter(r17, "dataCenter");
        InteractRecordContainerFragment r22 = new InteractRecordContainerFragment();
        r22.d = r18;
        r22.h = r17;
        r22.l = r20;
        r22.m = r1;
        r18.zD(r22);
        return;
    L24:
        return;
    L15:
        r6 = "link_banner";
        goto L16
    L26:
        return;
    L19:
        boolean r23 = r8.J;
        r8.J = false;
        View r24 = r8.n;
        if (r24 == null) goto L22;
        r24.setBackground(s1.m(2131252591));
    L22:
        this.a.ga0(r23 ? 1 : 0, false);
    }
}
