package com.obric.assistant.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class v6 implements Function1 {
    public final /* synthetic */ com.larus.bmhome.actionbar.model.z0 a;
    public final /* synthetic */ OrionInstructionComponent b;
    public final /* synthetic */ ConstraintLayout c;
    public final /* synthetic */ View d;
    public final /* synthetic */ AppCompatImageView e;

    public /* synthetic */ v6(com.larus.bmhome.actionbar.model.z0 r1, OrionInstructionComponent r2, ConstraintLayout r3, View r4, AppCompatImageView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r36) {
        com.larus.bmhome.actionbar.model.z0 r1 = this.a;
        OrionInstructionComponent r2 = this.b;
        ConstraintLayout r3 = this.c;
        View r4 = this.d;
        AppCompatImageView r5 = this.e;
        int r7 = OrionInstructionComponent.p1;
        Intrinsics.checkNotNullParameter((ConstraintLayout) r36, "it");
        FLogger.a.i("OrionExtraComponent", "secondaryMenu click open");
        if (Intrinsics.areEqual(r1.b, "obric_phone_operation") == false) goto L9;
        t1a.b r6 = s1a.d.a(r2);
        Context r8 = r3.getContext();
        Intrinsics.checkNotNullParameter(r6, "vContext");
        Intrinsics.checkNotNullParameter(r8, "context");
        qha.g r9 = new qha.g(r6, r8);
        long r10 = 1360883263;
        Resources r11 = r8.getResources();
        if (r11 == null) goto L7;
        String r12 = r11.getString(2131911893);
    L8:
        String r15 = r12;
        int r13 = r9.m();
        StringBuilder r14 = new StringBuilder("res://");
        AppHost.Companion r16 = AppHost.a;
        r14.append(r16.getApplication().getPackageName());
        r14.append("/2131244356");
        com.larus.bmhome.actionbar.model.g1 r23 = new com.larus.bmhome.actionbar.model.g1(null, com.larus.utils.y0.k(UriProtector.parse(r14.toString())), null, null, 29);
        com.larus.bmhome.actionbar.model.g1 r29 = new com.larus.bmhome.actionbar.model.g1(null, com.larus.utils.y0.k(UriProtector.parse("res://" + r16.getApplication().getPackageName() + "/2131244356")), null, null, 29);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("KEY_FILE_OR_WEB_ADDRESS", r9.f);
        r1 = new com.larus.bmhome.actionbar.model.z0(Long.valueOf(r10), "obric_omni", r23, r29, r15, null, Integer.valueOf(r13), null, null, null, null, null, true, r0, null, -536936544, 13);
        goto L9
    L7:
        r12 = null;
    L9:
        laa.h r17 = r2.a4();
        if (r17 == null) goto L14;
        boolean r18 = true;
        if (r17.Hi(r4, r1, r5) != true) goto L14;
    L15:
        if (r18 == false) goto L22;
        Context r19 = r3.getContext();
        if (Intrinsics.areEqual(r1.b, "obric_omni") == false) goto L19;
        int r20 = 2131244368;
    L20:
        r5.setImageDrawable(AppCompatResources.getDrawable(r19, r20));
        goto L22
    L19:
        r20 = 2131244366;
    L22:
        return Unit.INSTANCE;
    L14:
        r18 = false;
        goto L15
    }
}
