package com.larus.bmhome.chat.layout.holder.image;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;
import com.larus.bmhome.databinding.LarusImageScrollItemBinding;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k1 implements n0 {
    public final /* synthetic */ ScrollImageViewHolder a;

    @Override // com.larus.bmhome.chat.layout.holder.image.n0
    public final void a() {
        this.a.a.k.setAlpha(1.0f);
        ((ly9.a) this.a.p.getValue()).a(null, null);
        this.a.b.hide();
    }

    public k1(ScrollImageViewHolder r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.n0
    public final void b(String r18, int r19) {
        Message r1 = this.a.k;
        wc9.e r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getMessageId();
    L7:
        if (Intrinsics.areEqual(r3, r18) == false) goto L230;
        Integer r4 = this.a.l;
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.intValue() != r19) goto L231;
        this.a.a.k.setAlpha(1.0f);
        ((ly9.a) this.a.p.getValue()).a(null, null);
        this.a.b.hide();
        final ScrollImageViewHolder r5 = this.a;
        final m0 r6 = r5.j;
        LarusImageScrollItemBinding r7 = r5.a;
        boolean r8 = true;
        if (((Boolean) ScrollImageViewHolder.q.getValue()).booleanValue() == false) goto L25;
        Message r9 = r5.k;
        if (r9 != null) goto L18;
    L20:
        boolean r10 = false;
    L21:
        if (r10 == true) goto L25;
        if (r5.n == true) goto L25;
        boolean r11 = true;
    L27:
        if (((Boolean) ScrollImageViewHolder.r.getValue()).booleanValue() == false) goto L38;
        Message r12 = r5.k;
        if (r12 != null) goto L31;
    L33:
        boolean r13 = false;
    L34:
        if (r13 == true) goto L38;
        if (r5.n == true) goto L38;
        boolean r14 = true;
    L39:
        ImageView r15 = r7.h;
        int r16 = 8;
        if (r11 == false) goto L42;
        int r17 = 0;
    L43:
        r15.setVisibility(r17);
        ImageView r20 = r7.e;
        if (r14 == false) goto L46;
        int r110 = 0;
    L47:
        r20.setVisibility(r110);
        r7.e.setBackground(ContextCompat.getDrawable(r5.a.a.getContext(), 2131239118));
        r7.f.setBackground(ContextCompat.getDrawable(r5.a.a.getContext(), 2131239118));
        r7.h.setBackground(ContextCompat.getDrawable(r5.a.a.getContext(), 2131239118));
        if (r6 == null) goto L60;
        ImageItem r21 = r6.b;
        if (r21 == null) goto L60;
        String r22 = r21.getImageTips();
        if (r22 == null) goto L60;
        if (r22.length() <= 0) goto L56;
        boolean r111 = true;
    L57:
        if (r111 == false) goto L60;
        com.larus.utils.e1.x(r7.i);
        r7.j.setText(r22);
        goto L60
    L56:
        r111 = false;
    L60:
        if (r14 == true) goto L67;
        if (r11 == false) goto L67;
        ImageView r23 = r7.h;
        ViewGroup.LayoutParams r112 = r23.getLayoutParams();
        if (r112 == null) goto L66;
        ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r112;
        r113.setMarginStart(i5.Y());
        r23.setLayoutParams(r113);
    L70:
        if (r14 == false) goto L81;
        if (r6 == null) goto L81;
        ImageItem r24 = r6.b;
        if (r24 == null) goto L81;
        ImageEntity r25 = r24.getImageOrigin();
        if (r25 == null) goto L81;
        String r26 = r25.getUrl();
        if (r26 == null) goto L81;
        CoroutineScope r114 = (CoroutineScope) r5.g.invoke();
        if (r114 == null) goto L81;
        BuildersKt.launch$default(r114, null, null, new ScrollImageViewHolder$refreshShareOrDownloadBtn$1$4$1(r26, r7, null), 3, null);
    L81:
        boolean r27 = Intrinsics.areEqual(PollingConfigService.a.f("cre_sc_dg"), "1");
        if (r5.n == true) goto L232;
        z2 r28 = z2.a;
        if (r28.getAIBeautifyConfig().b == false) goto L233;
        Message r29 = r5.k;
        if (r29 != null) goto L88;
    L90:
        boolean r30 = false;
    L91:
        if (r30 == true) goto L234;
        com.larus.bmhome.chat.api.q0 r31 = r5.i;
        if (r31 == null) goto L99;
        com.larus.bmhome.chat.api.l0 r32 = r31.D9();
        if (r32 == null) goto L99;
        com.larus.bmhome.instruction.g r33 = (com.larus.bmhome.instruction.g) r32.invoke();
        if (r33 == null) goto L99;
        Pair r34 = r33.N8();
    L100:
        if (r34 == null) goto L102;
        boolean r115 = ((Boolean) r34.getSecond()).booleanValue();
    L103:
        com.larus.bmhome.chat.api.q0 r116 = r5.i;
        if (r116 == null) goto L110;
        com.larus.bmhome.chat.api.l0 r117 = r116.D9();
        if (r117 == null) goto L110;
        com.larus.bmhome.instruction.g r118 = (com.larus.bmhome.instruction.g) r117.invoke();
        if (r118 == null) goto L110;
        Pair r119 = r118.A7();
    L111:
        if (r119 == null) goto L113;
        boolean r120 = ((Boolean) r119.getSecond()).booleanValue();
    L114:
        com.larus.bmhome.chat.api.q0 r121 = r5.i;
        if (r121 == null) goto L121;
        com.larus.bmhome.chat.api.n0 r122 = r121.M7();
        if (r122 == null) goto L121;
        com.larus.bmhome.chat.component.cvs.y r123 = (com.larus.bmhome.chat.component.cvs.y) r122.invoke();
        if (r123 == null) goto L121;
        r2 = r123.h();
    L121:
        Integer r124 = r28.attachmentEditConfig().getCreationCoverFollowUp();
        if (r124 != null) goto L125;
    L156:
        boolean r35 = false;
    L157:
        if (r35 == false) goto L159;
        com.larus.utils.e1.o(r7.d);
        com.larus.utils.e1.x(r7.c);
        com.larus.utils.e1.d(r7.c, new h1(r5, r6));
        return;
    L159:
        com.larus.utils.e1.o(r7.c);
        ImageCoverEditView r36 = r7.d;
        if (r34 == null) goto L166;
        com.larus.bmhome.actionbar.model.z0 r125 = (com.larus.bmhome.actionbar.model.z0) r34.getFirst();
        if (r125 == null) goto L166;
        com.larus.bmhome.actionbar.model.r r126 = r125.q;
        if (r126 == null) goto L166;
        boolean r127 = Intrinsics.areEqual(r126.h, Boolean.TRUE);
    L167:
        if (r127 == true) goto L178;
        if (r119 == null) goto L174;
        com.larus.bmhome.actionbar.model.z0 r128 = (com.larus.bmhome.actionbar.model.z0) r119.getFirst();
        if (r128 == null) goto L174;
        com.larus.bmhome.actionbar.model.r r129 = r128.q;
        if (r129 == null) goto L174;
        boolean r130 = Intrinsics.areEqual(r129.h, Boolean.TRUE);
    L175:
        if (r130 == true) goto L178;
        boolean r131 = false;
    L179:
        if (r131 == false) goto L181;
        r16 = 0;
    L181:
        r36.setVisibility(r16);
        ImageCoverEditView r37 = r7.d;
        Message r132 = r5.k;
        if (r132 != null) goto L184;
    L186:
        boolean r133 = false;
    L187:
        if (r133 == true) goto L203;
        if (r27 == true) goto L203;
        sq9.c0 r134 = r28.getCreationEditControlConfig().d();
        if (r134 == null) goto L192;
        boolean r135 = Intrinsics.areEqual(r134.a(), Boolean.TRUE);
    L193:
        if (r135 == false) goto L203;
        if (r119 == null) goto L200;
        com.larus.bmhome.actionbar.model.z0 r136 = (com.larus.bmhome.actionbar.model.z0) r119.getFirst();
        if (r136 == null) goto L200;
        com.larus.bmhome.actionbar.model.r r137 = r136.q;
        if (r137 == null) goto L200;
        boolean r138 = Intrinsics.areEqual(r137.h, Boolean.TRUE);
    L201:
        if (r138 == false) goto L203;
        boolean r139 = true;
    L204:
        Boolean r140 = Boolean.valueOf(r139);
        Message r141 = r5.k;
        if (r141 != null) goto L207;
    L209:
        boolean r142 = false;
    L210:
        if (r142 == true) goto L226;
        if (r27 == true) goto L226;
        sq9.c0 r38 = r28.getCreationEditControlConfig().d();
        if (r38 == null) goto L215;
        boolean r39 = Intrinsics.areEqual(r38.b(), Boolean.TRUE);
    L216:
        if (r39 == true) goto L226;
        if (r34 == null) goto L223;
        com.larus.bmhome.actionbar.model.z0 r40 = (com.larus.bmhome.actionbar.model.z0) r34.getFirst();
        if (r40 == null) goto L223;
        com.larus.bmhome.actionbar.model.r r41 = r40.q;
        if (r41 == null) goto L223;
        boolean r42 = Intrinsics.areEqual(r41.h, Boolean.TRUE);
    L224:
        if (r42 == false) goto L226;
    L227:
        r37.a(new com.larus.bmhome.chat.layout.widget.n0(r140, Boolean.valueOf(r8)), new m1(r5, r34, r6, r115, r119, r120));
        return;
    L223:
        r42 = false;
        goto L224
    L215:
        r39 = false;
    L226:
        r8 = false;
        goto L227
    L207:
        if (com.larus.im.bean.message.a.e0(r141) != true) goto L209;
        r142 = true;
    L200:
        r138 = false;
        goto L201
    L192:
        r135 = false;
    L203:
        r139 = false;
        goto L204
    L184:
        if (com.larus.im.bean.message.a.e0(r132) != true) goto L186;
        r133 = true;
    L174:
        r130 = false;
    L178:
        r131 = true;
    L166:
        r127 = false;
        goto L167
    L125:
        if (r124.intValue() != 1) goto L156;
        Message r143 = r5.k;
        if (r143 == null) goto L136;
        String r144 = r143.getMessageId();
        if (r144 == null) goto L136;
        if (r144.length() <= 0) goto L133;
        boolean r145 = true;
    L134:
        if (r145 != true) goto L136;
        boolean r146 = true;
    L137:
        if (r146 == false) goto L156;
        if (com.larus.bmhome.utils.i.f(r2) == false) goto L156;
        if (r2 == null) goto L147;
        Integer r147 = r2.j;
        if (r147 == null) goto L147;
        if (r147.intValue() != 2) goto L147;
        boolean r148 = true;
    L148:
        if (r148 == false) goto L150;
    L153:
        boolean r43 = true;
    L154:
        if (r43 == true) goto L156;
        r35 = true;
        goto L157
    L150:
        if (ic8.n.q(r2) == true) goto L153;
        r43 = false;
    L147:
        r148 = false;
        goto L148
    L133:
        r145 = false;
    L136:
        r146 = false;
        goto L137
    L113:
        r120 = false;
    L110:
        r119 = null;
        goto L111
    L102:
        r115 = false;
    L99:
        r34 = null;
        goto L100
    L234:
        return;
    L88:
        if (com.larus.bmhome.chat.bean.d.y(r29) != true) goto L90;
        r30 = true;
        goto L91
    L233:
        return;
    L232:
        return;
    L66:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L67:
        ImageView r44 = r7.h;
        ViewGroup.LayoutParams r149 = r44.getLayoutParams();
        if (r149 == null) goto L229;
        ConstraintLayout.LayoutParams r150 = (ConstraintLayout.LayoutParams) r149;
        r150.setMarginStart(0);
        r44.setLayoutParams(r150);
        goto L70
    L229:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L46:
        r110 = 8;
        goto L47
    L42:
        r17 = 8;
        goto L43
    L31:
        if (com.larus.bmhome.chat.bean.d.y(r12) != true) goto L33;
        r13 = true;
    L38:
        r14 = false;
        goto L39
    L18:
        if (com.larus.bmhome.chat.bean.d.y(r9) != true) goto L20;
        r10 = true;
    L25:
        r11 = false;
        goto L27
    L231:
        return;
    L230:
        return;
    L5:
        r3 = null;
        goto L7
    }
}
