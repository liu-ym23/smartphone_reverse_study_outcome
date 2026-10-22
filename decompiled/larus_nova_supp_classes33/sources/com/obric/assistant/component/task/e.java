package com.obric.assistant.component.task;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e implements jl9.a {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final View a(jl9.b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new OngoingTaskItemSingleIconView(r5.getContext(), null, 6, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.view.ViewGroup, com.obric.assistant.component.task.OngoingTaskItemSingleIconView] */
    /* JADX WARN: Type inference failed for: r10v4 */
    public final void b(View r10, jl9.b r11, final kl9.u r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "taskBasicInfo");
        if ((r10 instanceof OngoingTaskItemSingleIconView) == false) goto L5;
        final ?? r13 = (OngoingTaskItemSingleIconView) r10;
    L6:
        if (r13 == 0) goto L102;
        final Function2 r14 = r11.b;
        Intrinsics.checkNotNullParameter(r12, "item");
        TextView r1 = r13.a.e;
        kl9.x r3 = r12.i;
        String r4 = "";
        if (r3 == null) goto L12;
        String r5 = r3.a;
        if (r5 == null) goto L12;
    L13:
        r1.setText(r5);
        kl9.x r2 = r12.i;
        if (r2 == null) goto L19;
        String r6 = r2.b;
        if (r6 == null) goto L19;
        r4 = r6;
    L19:
        r13.a.c.setText(r4);
        Map r7 = r12.s;
        if (r7 == null) goto L22;
        String r8 = (String) r7.get("biz_scene");
    L24:
        if (Intrinsics.areEqual(r8, "clarify") == true) goto L33;
        Map r9 = r12.s;
        if (r9 == null) goto L28;
        String r15 = (String) r9.get("biz_scene");
    L30:
        if (Intrinsics.areEqual(r15, "call_user") == true) goto L33;
        r13.a.c.setTextColor(v19.c.a(2130972081, r13.getContext(), 2131103143));
    L34:
        TextView r16 = r13.a.c;
        boolean r17 = o0.d(r4);
        boolean r18 = false;
        if (r17 == false) goto L37;
        int r19 = 0;
    L38:
        r16.setVisibility(r19);
        List r20 = r12.j;
        if (r20 == null) goto L51;
        Iterator r21 = r20.iterator();
    L42:
        if (r21.hasNext() == false) goto L49;
        Object r22 = r21.next();
        if (((kl9.p) r22) == null) goto L46;
        boolean r23 = true;
    L47:
        if (r23 == false) goto L42;
    L50:
        final kl9.p r24 = (kl9.p) r22;
    L52:
        r13.a.d.setVisibility(0);
        SimpleDraweeView r25 = r13.a.d;
        if (r24 == null) goto L55;
        String r26 = r24.a;
    L56:
        r25.setContentDescription(r26);
        Context r27 = r13.getContext();
        SimpleDraweeView r28 = r13.a.d;
        if (r24 == null) goto L59;
        String r29 = r24.b;
    L60:
        if (r24 == null) goto L62;
        String r30 = r24.c;
    L63:
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "imageView");
        boolean r0 = v19.h.a;
        if (v19.h.b(r27) == false) goto L75;
        if (r30 != null) goto L67;
    L70:
        boolean r31 = true;
    L71:
        if (r31 == true) goto L75;
        r29 = r30;
        goto L75
    L67:
        if (r30.length() == 0) goto L70;
        r31 = false;
    L75:
        if (o0.d(r29) == false) goto L94;
        if (r29 == null) goto L92;
        Uri r32 = UriProtector.parse(r29);
        if (r32 == null) goto L92;
        if (Intrinsics.areEqual(r32.getScheme(), "res") == false) goto L92;
        String r33 = r32.getLastPathSegment();
        if (r33 == null) goto L88;
        Integer r34 = StringsKt.toIntOrNull(r33);
        if (r34 == null) goto L88;
        int r35 = r34.intValue();
    L89:
        if (r35 == 0) goto L92;
        r28.setImageResource(r35);
        r18 = true;
    L88:
        r35 = 0;
    L92:
        if (r18 == true) goto L95;
        ImageLoaderKt.u(r28, r29, "multitask");
    L95:
        e1.d(r13.a.d, new d(r13, r14, r24, r12));
        return;
    L94:
        r28.setImageDrawable(null);
        goto L95
    L62:
        r30 = null;
        goto L63
    L59:
        r29 = null;
        goto L60
    L55:
        r26 = null;
        goto L56
    L46:
        r23 = false;
        goto L47
    L49:
        r22 = null;
        goto L50
    L51:
        r24 = null;
        goto L52
    L37:
        r19 = 8;
        goto L38
    L28:
        r15 = null;
    L33:
        r13.a.c.setTextColor(v19.c.a(2130972123, r13.getContext(), 2131103203));
        goto L34
    L22:
        r8 = null;
    L12:
        r5 = "";
        goto L13
    L102:
        return;
    L5:
        r13 = 0;
        goto L6
    }
}
