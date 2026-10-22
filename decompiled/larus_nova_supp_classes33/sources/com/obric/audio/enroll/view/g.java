package com.obric.audio.enroll.view;

import android.view.View;
import android.widget.TextView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.obric.audio.enroll.model.TeamMember;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ EnrollTeamView a;
    public final /* synthetic */ List b;

    public /* synthetic */ g(EnrollTeamView r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        final EnrollTeamView r0 = this.a;
        List r1 = this.b;
        Pair<Integer, Integer> r2 = EnrollStageView.e;
        Iterator<T> r3 = r0.getTextViews().iterator();
        int r4 = 0;
    L4:
        if (r3.hasNext() == false) goto L32;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TextView r7 = (TextView) r5;
        TeamMember.Companion.getClass();
        View r8 = r0.Z5(TeamMember.a.a(r4));
        DynamicAnimation.ViewProperty r9 = DynamicAnimation.TRANSLATION_Y;
        TeamMember r10 = TeamMember.a.a(r4);
        Intrinsics.checkNotNullParameter(r10, "teamMember");
        float r11 = r0.d.getNeckGuideLine();
        if (r10 != TeamMember.TITLE) goto L11;
        float r12 = ((Number) mia.h.g.getValue()).floatValue();
    L25:
        float r13 = r11 - r12;
    L26:
        SpringAnimation r14 = new SpringAnimation(r8, r9, r13);
        TeamMember.Companion.getClass();
        TeamMember r15 = TeamMember.a.a(r4);
        Intrinsics.checkNotNullParameter(r15, "from");
        r14.setStartValue(r0.b6(r15));
        r14.getSpring().setStiffness(480.0f);
        r14.getSpring().setDampingRatio(1.0f);
        r1.add(r14);
        SpringAnimation r16 = new SpringAnimation(r0, DynamicAnimation.ALPHA, 0.0f);
        r16.setStartValue(1.0f);
        r16.getSpring().setStiffness(960.0f);
        r16.getSpring().setDampingRatio(1.3f);
        r16.addEndListener(new h(r0));
        SpringAnimation r17 = new SpringAnimation(r0, DynamicAnimation.SCALE_X, 0.6f);
        r17.setStartValue(1.0f);
        r17.getSpring().setStiffness(240.0f);
        r17.getSpring().setDampingRatio(1.0f);
        SpringAnimation r18 = new SpringAnimation(r0, DynamicAnimation.SCALE_Y, 0.6f);
        r18.setStartValue(1.0f);
        r18.getSpring().setStiffness(240.0f);
        r18.getSpring().setDampingRatio(1.0f);
        r1.add(r16);
        r1.add(r17);
        r1.add(r18);
        Iterator r19 = r1.iterator();
    L28:
        if (r19.hasNext() == false) goto L30;
        ((SpringAnimation) r19.next()).start();
        goto L28
    L30:
        r4 = r6;
        goto L4
    L11:
        Iterator r110 = ((ArrayList) r0.z).iterator();
    L13:
        if (r110.hasNext() == false) goto L20;
        Object r111 = r110.next();
        if (((Pair) r111).getFirst() != r10) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == false) goto L13;
    L21:
        Pair r113 = (Pair) r111;
        if (r113 != null) goto L24;
        r13 = 0.0f;
        goto L26
    L24:
        r11 = (r11 + ((Number) mia.h.d.getValue()).floatValue()) + (((Number) mia.h.f.getValue()).floatValue() * ((TeamMember) r113.getFirst()).getOrder());
        r12 = ((Number) mia.h.g.getValue()).floatValue();
        goto L25
    L17:
        r112 = false;
        goto L18
    L20:
        r111 = null;
        goto L21
    L32:
        return Unit.INSTANCE;
    }
}
