package com.larus.uaigc.instruction;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class t implements Function3 {
    public final /* synthetic */ DropFeatureSelectorWidget a;

    public /* synthetic */ t(DropFeatureSelectorWidget r1) {
        this.a = r1;
    }

    public final Object invoke(Object r12, Object r13, Object r14) {
        DropFeatureSelectorWidget r0 = this.a;
        TemplateInfo$TemplateInfo r15 = (TemplateInfo$TemplateInfo) r12;
        String r16 = (String) r13;
        Uri r17 = (Uri) r14;
        int r18 = DropFeatureSelectorWidget.k;
        Intrinsics.checkNotNullParameter(r15, "templateInfo");
        com.larus.bmhome.actionbar.model.h r19 = r0.getCurrentBindData();
        String r3 = null;
        if (r19 == null) goto L20;
        List r110 = r19.e;
        if (r110 == null) goto L20;
        Iterator r111 = r110.iterator();
    L8:
        if (r111.hasNext() == false) goto L18;
        Object r4 = r111.next();
        Long r5 = ((com.larus.bmhome.actionbar.model.w) r4).a;
        long r6 = r15.h;
        if (r5 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == false) goto L8;
    L19:
        com.larus.bmhome.actionbar.model.w r8 = (com.larus.bmhome.actionbar.model.w) r4;
    L21:
        if (r8 == null) goto L37;
        com.larus.bmhome.actionbar.model.h r112 = r0.getCurrentBindData();
        if (r112 == null) goto L36;
        List r113 = r112.e;
        if (r113 == null) goto L36;
        Iterator r114 = r113.iterator();
    L28:
        if (r114.hasNext() == false) goto L36;
        com.larus.bmhome.actionbar.model.w r9 = (com.larus.bmhome.actionbar.model.w) r114.next();
        Long r10 = r9.a;
        long r11 = r15.h;
        if (r10 == null) goto L35;
        if (r10.longValue() != r11) goto L35;
        r9.s = 1;
    L35:
        r9.s = 0;
    L36:
        e1.x(r0.getBinding().f);
        r0.getBinding().f.setText(r8.b);
    L37:
        Fragment r115 = r0.getFragment();
        if (r115 == null) goto L63;
        Bundle r116 = r115.getArguments();
        if (r116 == null) goto L63;
        UserCreation r20 = r15.j;
        Pair[] r21 = new Pair[6];
        if (r20 == null) goto L44;
        String r22 = r20.a;
    L45:
        r21[0] = TuplesKt.to("from_template_id", r22);
        if (r20 == null) goto L48;
        String r1 = zp9.d.d(r20);
    L49:
        r21[1] = TuplesKt.to("from_template_type", r1);
        if (r20 == null) goto L54;
        UserCreationTrackParams r2 = r20.n;
        if (r2 == null) goto L54;
        String r23 = r2.a;
    L55:
        r21[2] = TuplesKt.to("template_rec_req_id", r23);
        if (r20 == null) goto L58;
        String r24 = zp9.d.b(r20);
    L59:
        r21[3] = TuplesKt.to("from_template_source", r24);
        r21[4] = TuplesKt.to("is_from_template", "1");
        if (r20 == null) goto L62;
        r3 = r20.i;
    L62:
        r21[5] = TuplesKt.to("template_rec_extra", r3);
        r116.putParcelable("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(MapsKt.mapOf(r21)));
        goto L63
    L58:
        r24 = null;
    L54:
        r23 = null;
        goto L55
    L48:
        r1 = null;
        goto L49
    L44:
        r22 = null;
    L63:
        com.larus.bmhome.actionbar.model.h r117 = r0.getCurrentBindData();
        if (r117 == null) goto L70;
        List<com.larus.bmhome.actionbar.model.w> r118 = r117.e;
        if (r118 == null) goto L70;
        DropFeatureSelectorFragment r25 = r0.g;
        if (r25 == null) goto L70;
        int r26 = DropFeatureSelectorFragment.l;
        r25.S90(r118, true);
    L70:
        com.larus.bmhome.view.actionbar.edit.c r119 = r0.getViewModel();
        if (r119 == null) goto L74;
        r119.onInstructionImageTemplateSelected(r15, r17);
    L74:
        return Unit.INSTANCE;
    L13:
        if (r5.longValue() != r6) goto L15;
        r7 = true;
        goto L16
    L18:
        r4 = null;
    L20:
        r8 = null;
        goto L21
    }
}
