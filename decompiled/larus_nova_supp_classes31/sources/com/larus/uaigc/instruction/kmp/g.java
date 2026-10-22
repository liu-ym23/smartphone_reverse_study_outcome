package com.larus.uaigc.instruction.kmp;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import cq8.v;
import cq8.w;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class g implements Function3 {
    public final /* synthetic */ KmpImageTemplateSelectorWithMoreWidget a;

    public /* synthetic */ g(KmpImageTemplateSelectorWithMoreWidget r1) {
        this.a = r1;
    }

    public final Object invoke(Object r8, Object r9, Object r10) {
        KmpImageTemplateSelectorWithMoreWidget r0 = this.a;
        TemplateInfo$TemplateInfo r11 = (TemplateInfo$TemplateInfo) r8;
        String r12 = (String) r9;
        Uri r13 = (Uri) r10;
        int r14 = KmpImageTemplateSelectorWithMoreWidget.s;
        Intrinsics.checkNotNullParameter(r11, "templateInfo");
        w r15 = r0.h;
        if (r15 == null) goto L5;
        r15.d.a(new v(r15.c, r11));
    L5:
        Fragment r16 = r0.getFragment();
        if (r16 == null) goto L31;
        Bundle r17 = r16.getArguments();
        if (r17 == null) goto L31;
        UserCreation r1 = r11.j;
        Pair[] r3 = new Pair[6];
        String r4 = null;
        if (r1 == null) goto L12;
        String r5 = r1.a;
    L13:
        r3[0] = TuplesKt.to("from_template_id", r5);
        if (r1 == null) goto L16;
        String r6 = zp9.d.d(r1);
    L17:
        r3[1] = TuplesKt.to("from_template_type", r6);
        if (r1 == null) goto L22;
        UserCreationTrackParams r7 = r1.n;
        if (r7 == null) goto L22;
        String r18 = r7.a;
    L23:
        r3[2] = TuplesKt.to("template_rec_req_id", r18);
        if (r1 == null) goto L26;
        String r19 = zp9.d.b(r1);
    L27:
        r3[3] = TuplesKt.to("from_template_source", r19);
        r3[4] = TuplesKt.to("is_from_template", "1");
        if (r1 == null) goto L30;
        r4 = r1.i;
    L30:
        r3[5] = TuplesKt.to("template_rec_extra", r4);
        r17.putParcelable("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(MapsKt.mapOf(r3)));
        goto L31
    L26:
        r19 = null;
    L22:
        r18 = null;
        goto L23
    L16:
        r6 = null;
        goto L17
    L12:
        r5 = null;
    L31:
        com.larus.bmhome.view.actionbar.edit.c r20 = r0.j;
        if (r20 == null) goto L35;
        r20.onInstructionImageTemplateSelected(r11, r13);
    L35:
        return Unit.INSTANCE;
    }
}
