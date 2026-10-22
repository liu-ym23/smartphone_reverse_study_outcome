package com.larus.uaigc.createpage.component.template;

import android.os.Bundle;
import com.larus.bmhome.view.ChatConstraintLayout;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q implements ChatConstraintLayout.b {
    public final /* synthetic */ TemplateFeedComponent a;

    public final void onUpdate(int r1) {
    }

    public final void a() {
        if (((Boolean) this.a.t.getValue()).booleanValue() == false) goto L31;
        va8.o r1 = (va8.o) this.a.x.getValue();
        boolean r2 = false;
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L32;
        this.a.t.setValue(Boolean.FALSE);
        ny9.u r4 = this.a.E3();
        if (r4 == null) goto L14;
        String r5 = r4.q();
    L15:
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        if (r5.length() != 0) goto L20;
        r2 = true;
    L20:
        if (r2 == false) goto L22;
        r5 = "image_generate";
    L22:
        String r10 = r5;
        ny9.s r6 = this.a.z3();
        if (r6 == null) goto L28;
        Bundle r7 = r6.a;
        if (r7 == null) goto L28;
        String r8 = r7.getString("enter_method");
        if (r8 == null) goto L28;
    L29:
        a1.c(null, null, null, null, null, r10, null, null, r8, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1153, -1, 7);
        return;
    L28:
        r8 = "click_input_box";
        goto L29
    L14:
        r5 = null;
        goto L15
    L32:
        return;
    L7:
        if (r1.n5() != true) goto L9;
        r3 = true;
        goto L10
    }

    public final void b() {
        if (((Boolean) this.a.t.getValue()).booleanValue() == false) goto L31;
        va8.o r1 = (va8.o) this.a.x.getValue();
        boolean r2 = false;
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L32;
        this.a.t.setValue(Boolean.FALSE);
        ny9.u r4 = this.a.E3();
        if (r4 == null) goto L14;
        String r5 = r4.q();
    L15:
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        if (r5.length() != 0) goto L20;
        r2 = true;
    L20:
        if (r2 == false) goto L22;
        r5 = "image_generate";
    L22:
        String r10 = r5;
        ny9.s r6 = this.a.z3();
        if (r6 == null) goto L28;
        Bundle r7 = r6.a;
        if (r7 == null) goto L28;
        String r8 = r7.getString("enter_method");
        if (r8 == null) goto L28;
    L29:
        a1.c(null, null, null, null, null, r10, null, null, r8, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1153, -1, 7);
        return;
    L28:
        r8 = "click_input_box";
        goto L29
    L14:
        r5 = null;
        goto L15
    L32:
        return;
    L7:
        if (r1.n5() != true) goto L9;
        r3 = true;
        goto L10
    }

    public q(TemplateFeedComponent r1) {
        this.a = r1;
    }
}
