package com.ss.android.lark.flow.chat.message.downgrade.block;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.lark.pb.basic.v1.TodoOperationContent;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.databinding.FlowChatMessageV2BlockTodoContentBinding;
import com.ss.android.lark.flow.chat.message.downgrade.data.LarkDowngradeTodoContent;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import java.util.Date;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowTodoContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<mgb.b>, Object> {
    public final IMMessageKeys.Blocks g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0<Unit> a;

        public a(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0<Unit> a;

        public b(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Function0<Unit> b;

        public c(boolean r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            if (this.a == false) goto L6;
            this.b.invoke();
            return;
        }
    }

    public final j getKey() {
        return this.g;
    }

    public FlowTodoContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.FLOW_TODO_CONTENT;
    }

    public void update(m<y6b.a<mgb.b>> r28, q<y6b.a<mgb.b>> r29, final y6b.a<mgb.b> r30) {
        Intrinsics.checkNotNullParameter(r28, "cell");
        Intrinsics.checkNotNullParameter(r29, "layout");
        Intrinsics.checkNotNullParameter(r30, "data");
        FlowChatMessageV2BlockTodoContentBinding r2 = (FlowChatMessageV2BlockTodoContentBinding) r29.c(this.g, IMMessageKeys.Slots.CONTENT, FlowTodoContentBlock$update$blockView$1.INSTANCE).a;
        LarkDowngradeTodoContent r4 = (LarkDowngradeTodoContent) ((v5b.a) ((mgb.b) r30.b())).a;
        int r5 = com.ss.android.lark.flow.chat.message.a.a;
        int r6 = FlowChatModule.d;
        int r7 = 0;
        if (FlowChatModule.a.a().a().getBrowserDependency().getAppLinkDomain().length() <= 0) goto L5;
        boolean r8 = true;
    L6:
        TextView r9 = r2.k;
        if (r4.getOperationType() != TodoOperationContent.Type.CREATE) goto L9;
        boolean r10 = true;
    L11:
        if (r10 == false) goto L13;
        int r11 = 0;
    L14:
        r9.setVisibility(r11);
        r2.k.setText(UIUtils.getString(getContext(), 2131893198));
        r2.i.setText(r4.getTitle());
        r2.i.getPaint().setStrikeThruText(r4.isCompleted());
        TextView r12 = r2.i;
        if (r4.isCompleted() == false) goto L17;
        float r13 = 0.55f;
    L18:
        r12.setAlpha(r13);
        r2.j.setImageDrawable(UDIconUtils.getIconDrawable(getContext(), 2131235466, UIUtils.getColor(getContext(), 2131102049)));
        TextView r14 = r2.c;
        if (r4.getAssigneeName().length() <= 0) goto L21;
        boolean r15 = true;
    L22:
        if (r15 == false) goto L24;
        int r16 = 0;
    L25:
        r14.setVisibility(r16);
        r2.c.setText(r4.getAssigneeName());
        LinearLayout r17 = r2.f;
        if (r4.getDueTimeSeconds() <= 0) goto L28;
        boolean r18 = true;
    L29:
        if (r18 == false) goto L31;
        int r19 = 0;
    L32:
        r17.setVisibility(r19);
        TextView r20 = r2.e;
        long r110 = r4.getDueTimeSeconds();
        boolean r21 = r4.isAllDay();
        Date r111 = new Date(((long) AudioViewModel.ASR_SESSION_IDLE) * r110);
        c7c.a r22 = new c7c.a(null, DisplayPattern.RELATIVE, LengthType.SHORT, null, null, false, false, false, false, 2041);
        if (r21 == false) goto L35;
        String r23 = c7c.b.a(getContext(), r111, r22);
    L36:
        r20.setText(r23);
        ImageView r24 = r2.h;
        if (r4.getDueTimeSeconds() > 0) goto L39;
    L41:
        boolean r25 = false;
    L42:
        if (r25 == false) goto L44;
        int r26 = 0;
    L45:
        r24.setVisibility(r26);
        r2.h.setImageDrawable(UDIconUtils.getIconDrawable(getContext(), 2131235455, UIUtils.getColor(getContext(), 2131102042)));
        TextView r27 = r2.g;
        if (r8 == true) goto L48;
    L50:
        boolean r31 = false;
    L51:
        if (r31 == false) goto L53;
        int r32 = 0;
    L54:
        r27.setVisibility(r32);
        TextView r33 = r2.d;
        if (r8 == false) goto L57;
        int r34 = 0;
    L58:
        r33.setVisibility(r34);
        LinearLayout r35 = r2.b;
        if (r2.g.getVisibility() != 0) goto L61;
        boolean r36 = true;
    L62:
        if (r36 == false) goto L64;
    L70:
        boolean r37 = true;
    L71:
        if (r37 == true) goto L74;
        r7 = 8;
    L74:
        r35.setVisibility(r7);
        Function0<Unit> r38 = new FlowTodoContentBlock$update$openInLark$1(this, r30);
        r2.g.setOnClickListener(new a(r38));
        r2.d.setOnClickListener(new b(r38));
        r2.a.setOnClickListener(new c(r8, r38));
        f(r2.a, r28, r30);
        return;
    L64:
        if (r2.d.getVisibility() != 0) goto L66;
        boolean r39 = true;
    L67:
        if (r39 == true) goto L70;
        r37 = false;
        goto L71
    L66:
        r39 = false;
        goto L67
    L61:
        r36 = false;
        goto L62
    L57:
        r34 = 8;
        goto L58
    L53:
        r32 = 8;
        goto L54
    L48:
        if (r4.getCanFollow() == false) goto L50;
        r31 = true;
        goto L51
    L44:
        r26 = 8;
        goto L45
    L39:
        if (r4.getHasReminder() == false) goto L41;
        r25 = true;
        goto L42
    L35:
        r23 = c7c.b.c(getContext(), r111, r22);
        goto L36
    L31:
        r19 = 8;
        goto L32
    L28:
        r18 = false;
        goto L29
    L24:
        r16 = 8;
        goto L25
    L21:
        r15 = false;
        goto L22
    L17:
        r13 = 1.0f;
        goto L18
    L13:
        r11 = 8;
        goto L14
    L9:
        r10 = false;
        goto L11
    L5:
        r8 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}
