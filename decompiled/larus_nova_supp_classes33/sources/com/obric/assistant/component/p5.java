package com.obric.assistant.component;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class p5 implements Function6 {
    public final /* synthetic */ OrionChatWindowComponent a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ p5(OrionChatWindowComponent r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r6, Object r7, Object r8, Object r9, Object r10, Object r11) {
        OrionChatWindowComponent r0 = this.a;
        boolean r1 = this.b;
        List r12 = (List) r7;
        List r13 = (List) r8;
        List r14 = (List) r9;
        boolean r15 = ((Boolean) r10).booleanValue();
        boolean r16 = ((Boolean) r11).booleanValue();
        int r2 = OrionChatWindowComponent.T;
        Intrinsics.checkNotNullParameter((View) r6, "<unused var>");
        Intrinsics.checkNotNullParameter(r12, "areaViews");
        Intrinsics.checkNotNullParameter(r13, "imageViews");
        Intrinsics.checkNotNullParameter(r14, "textViews");
        r0.getClass();
        if (r1 == false) goto L5;
        com.larus.bmhome.view.b r17 = new com.larus.bmhome.view.b(v19.c.b(2130972082, null, 2131103146), Integer.valueOf(v19.c.b(2130970596, null, 2131238753)));
    L6:
        Iterator r3 = r13.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ImageView r4 = (ImageView) r3.next();
        r4.setAlpha(r17.b);
        r4.setColorFilter(r17.c);
        goto L8
    L10:
        Iterator r18 = r14.iterator();
    L12:
        if (r18.hasNext() == false) goto L14;
        ((TextView) r18.next()).setTextColor(ContextCompat.getColor(r0.getContext(), r17.a));
        goto L12
    L14:
        if (r15 == true) goto L17;
        r12 = r13;
    L17:
        Iterator r19 = r12.iterator();
    L19:
        if (r19.hasNext() == false) goto L30;
        View r20 = (View) r19.next();
        if (r15 == false) goto L26;
        if (r16 == true) goto L26;
        Integer r21 = r17.e;
        if (r21 == null) goto L19;
        int r22 = r21.intValue();
        r20.setBackground(ContextCompat.getDrawable(r0.getContext(), r22));
    L26:
        Drawable r23 = r20.getBackground();
        if (r23 == null) goto L19;
        r23.setAlpha(r17.d);
        goto L19
    L30:
        return Unit.INSTANCE;
    L5:
        r17 = ObricChatPageStateComponent.v2;
        goto L6
    }
}
