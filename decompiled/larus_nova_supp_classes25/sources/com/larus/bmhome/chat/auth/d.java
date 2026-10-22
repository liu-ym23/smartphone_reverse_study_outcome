package com.larus.bmhome.chat.auth;

import com.facebook.drawee.generic.RoundingParams;
import com.larus.bmhome.chat.auth.model.PluginAuthType;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.databinding.LarusFragmentPluginDetailDialogBinding;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ PluginDetailDialogFragment.a a;
    public final /* synthetic */ PluginDetailDialogFragment b;

    public /* synthetic */ d(PluginDetailDialogFragment.a r1, PluginDetailDialogFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.chat.auth.m] */
    public final Object invoke(Object r14) {
        final PluginDetailDialogFragment.a r7 = this.a;
        final PluginDetailDialogFragment r8 = this.b;
        final LarusFragmentPluginDetailDialogBinding r15 = (LarusFragmentPluginDetailDialogBinding) r14;
        Intrinsics.checkNotNullParameter(r15, "binding");
        Boolean r0 = r7.a;
        if (r0 != null) goto L5;
    L8:
        PluginItem r1 = r7.b;
        if (r1 == null) goto L49;
        Integer r2 = r1.authType;
        if (r2 == null) goto L17;
        int r3 = r2.intValue();
        Boolean r4 = r7.a;
        if (r4 == null) goto L15;
        boolean r5 = r4.booleanValue();
    L16:
        PluginDetailDialogFragment.a.b(r15, r5, r3);
        goto L17
    L15:
        r5 = false;
    L17:
        String r6 = r1.iconUrl;
        if (r6 == null) goto L21;
        r15.r.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(c7.c(12)));
        ImageLoaderKt.y(r15.r, r6, "settings.avatar", new i(r15), 4);
    L21:
        String r9 = r1.pluginName;
        if (r9 == null) goto L24;
        r15.s.setText(r9);
    L24:
        String r10 = r1.developer;
        if (r10 == null) goto L29;
        String r11 = AppHost.a.getApplication().getResources().getString(2131908370) + r10;
        if (r11 == null) goto L29;
        r15.o.setText(r11);
    L29:
        final Function0<Unit> r12 = r7.e;
        e1.d(r15.d, new j());
        e1.d(r15.b, new k(r12, r8));
        e1.d(r15.c, new l(r12, r8));
        final Function1<? super String, Unit> r13 = r7.d;
        String r16 = r1.privacy;
        String r17 = null;
        if (r16 != null) goto L32;
    L41:
        StringBuilder r18 = new StringBuilder();
        AppHost.Companion r19 = AppHost.a;
        r18.append(r19.getApplication().getResources().getString(2131908372));
        r18.append(r19.getApplication().getResources().getString(2131908511));
        String r20 = r18.toString();
    L42:
        final String r21 = r20;
        String r22 = r1.usage;
        if (r22 == null) goto L45;
        r17 = AppHost.a.getApplication().getString(2131908380, new Object[]{r22});
    L45:
        if (r17 != null) goto L47;
        String r23 = "";
    L48:
        final String r110 = " " + AppHost.a.getApplication().getResources().getString(2131908374) + " >";
        final String r24 = r23;
        r15.p.post(new f(r7, r15, r21, r24, r110, r13));
        goto L49
    L47:
        r23 = r17;
        goto L48
    L32:
        if (r16.length() <= 0) goto L34;
        boolean r25 = true;
    L35:
        if (r25 == true) goto L38;
        r16 = null;
    L38:
        if (r16 == null) goto L41;
        r20 = AppHost.a.getApplication().getResources().getString(2131908372) + r16;
        if (r20 != null) goto L42;
    L34:
        r25 = false;
    L49:
        final Function1<? super PluginAuthType, Unit> r26 = r7.c;
        if (r26 == null) goto L57;
        Boolean r27 = r7.a;
        if (r27 == null) goto L54;
        final boolean r28 = r27.booleanValue();
    L55:
        final ?? r29 = new m(r7, r15, r28, r26, r8);
        e1.d(r15.h, new n(r29));
        e1.d(r15.j, new o(r29));
        e1.d(r15.i, new p(r29));
        e1.d(r15.k, new q(r29));
        e1.d(r15.m, new e(r29));
        goto L57
    L54:
        r28 = false;
    L57:
        return Unit.INSTANCE;
    L5:
        if (r0.booleanValue() == false) goto L7;
        e1.x(r15.q);
        e1.o(r15.t);
        goto L8
    L7:
        e1.o(r15.q);
        e1.x(r15.t);
        goto L8
    }
}
