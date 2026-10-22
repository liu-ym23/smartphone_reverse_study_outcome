package com.bytedance.android.ec.core.widget.flow;

import android.view.View;
import ei.b;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ int b;
    public final /* synthetic */ TagFlowLayout c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        TagFlowLayout r11 = this.c;
        b r0 = this.a;
        int r1 = this.b;
        int r12 = TagFlowLayout.m;
        r11.getClass();
        if (r0.a == false) goto L5;
        r0.setChecked(false);
        ei.a r13 = r11.i;
        r0.getTagView();
        r13.getClass();
        Set<Integer> r14 = r11.k;
        HashSet r15 = (HashSet) r14;
        r15.remove(Integer.valueOf(r1));
    L16:
        TagFlowLayout.b r16 = this.c.l;
        if (r16 == null) goto L20;
        r16.a(this.b);
        return;
    L20:
        return;
    L5:
        if (r11.j != 1) goto L10;
        if (((HashSet) r11.k).size() != 1) goto L10;
        Integer r17 = (Integer) ((HashSet) r11.k).iterator().next();
        b r18 = (b) r11.getChildAt(r17.intValue());
        r17.intValue();
        r18.setChecked(false);
        ei.a r19 = r11.i;
        r18.getTagView();
        r19.getClass();
        r11.a(r0);
        ((HashSet) r11.k).remove(r17);
        Set<Integer> r20 = r11.k;
        HashSet r21 = (HashSet) r20;
        r21.add(Integer.valueOf(r1));
    L10:
        if (r11.j > 0) goto L12;
    L14:
        r11.a(r0);
        Set<Integer> r22 = r11.k;
        HashSet r23 = (HashSet) r22;
        r23.add(Integer.valueOf(r1));
        goto L16
    L12:
        if (((HashSet) r11.k).size() < r11.j) goto L14;
        goto L14
    }

    public a(TagFlowLayout r1, b r10, int r11) {
        this.c = r1;
        this.a = r10;
        this.b = r11;
    }
}
