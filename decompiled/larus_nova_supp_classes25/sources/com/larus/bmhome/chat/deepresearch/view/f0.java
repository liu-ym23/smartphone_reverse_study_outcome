package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CommerceCreditBlock;
import com.larus.im.bean.message.block.CommerceCreditBlockScene;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f0 extends MarkdownTextBlockView {
    public LinearLayout m;
    public TextView n;
    public View o;

    @Override // com.larus.bmhome.chat.deepresearch.view.MarkdownTextBlockView
    public LinearLayout getMarkdownContainer() {
        LinearLayout r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this;
    }

    public f0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public static CustomMarkdownTextView i(ViewGroup r4) {
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        CustomMarkdownTextView r2 = r4.getChildAt(r1);
        if ((r2 instanceof CustomMarkdownTextView) == true) goto L7;
        if ((r2 instanceof ViewGroup) == false) goto L13;
        CustomMarkdownTextView r3 = i((ViewGroup) r2);
        if (r3 == null) goto L13;
        return r3;
    L13:
        r1 = r1 + 1;
        goto L3
    L7:
        return r2;
    L14:
        return null;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.MarkdownTextBlockView, com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.b(r2, r3);
        LayoutInflater.from(r2).inflate(2131561829, this, true);
        this.m = (LinearLayout) findViewById(2131377464);
        this.n = (TextView) findViewById(2131367489);
        this.o = findViewById(2131392487);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.MarkdownTextBlockView
    public final String h(Message r5, Block r6) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Integer r0 = null;
        if (r6 == null) goto L7;
        BlockContent r7 = r6.getContent();
        if (r7 == null) goto L7;
        CommerceCreditBlock r8 = r7.getCommerceCreditBlock();
    L8:
        if (r8 == null) goto L10;
        r0 = r8.scene;
    L10:
        int r1 = CommerceCreditBlockScene.CREDIT_BLOCK_SCENE_INSUFFICIENT_BALANCE.getScene();
        String r2 = "";
        if (r0 != null) goto L14;
    L19:
        int r3 = CommerceCreditBlockScene.CREDIT_BLOCK_SCENE_CREDIT_REFUND.getScene();
        if (r0 != null) goto L23;
    L27:
        int r4 = CommerceCreditBlockScene.CREDIT_BLOCK_SCENE_USAGE_DETAIL.getScene();
        if (r0 != null) goto L31;
    L32:
        int r9 = CommerceCreditBlockScene.CREDIT_BLOCK_SCENE_CREDIT_ESTIMATION.getScene();
        if (r0 != null) goto L36;
    L37:
        int r10 = CommerceCreditBlockScene.CREDIT_BLOCK_SCENE_USAGE_DETAIL_ASYNC.getScene();
        if (r0 != null) goto L41;
        return "";
    L41:
        if (r0.intValue() == r10) goto L43;
        return "";
    L43:
        if (Intrinsics.areEqual(r8.triggerCreditAcquire, Boolean.TRUE) == true) goto L45;
    L51:
        String r11 = r8.text;
        if (r11 != null) goto L53;
        return "";
    L53:
        return r11;
    L45:
        if (com.larus.im.bean.message.a.w0(r5) == true) goto L51;
        StringBuilder r12 = new StringBuilder();
        String r13 = r8.text;
        if (r13 == null) goto L50;
        r2 = r13;
    L50:
        r12.append(r2);
        r12.append('[');
        r12.append(getContext().getString(2131901295));
        r12.append("](sslocal://flow/open_applet?commerce_credit_info=1&previous_page=chat&current_page=chat&message_id=");
        r12.append(r5.getMessageId());
        r12.append("&conversation_id=");
        r12.append(r5.getConversationId());
        r12.append("&enter_method=credit_deduct&card_type=credit_deduct)");
        return r12.toString();
    L36:
        if (r0.intValue() == r9) goto L43;
    L31:
        if (r0.intValue() == r4) goto L43;
    L23:
        if (r0.intValue() != r3) goto L27;
        r11 = r8.text;
        if (r11 != null) goto L53;
        return "";
    L14:
        if (r0.intValue() != r1) goto L19;
        int r14 = com.larus.bmhome.u.a;
        r11 = com.larus.bmhome.u.a(getContext());
        if (r11 != null) goto L53;
        return "";
    L7:
        r8 = null;
        goto L8
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.MarkdownTextBlockView
    public final void e(RectF r15, final Message r16, Block r17, boolean r18, final p0 r19, f1 r20, fh8.f r21) {
        Intrinsics.checkNotNullParameter(r16, "message");
        Intrinsics.checkNotNullParameter(r19, "config");
        Intrinsics.checkNotNullParameter(r20, "msgBoxConfig");
        Intrinsics.checkNotNullParameter(r21, "commonInputData");
        LinearLayout r0 = this.m;
        if (r0 == null) goto L5;
        com.larus.utils.e1.o(r0);
    L5:
        TextView r1 = this.n;
        if (r1 == null) goto L8;
        com.larus.utils.e1.o(r1);
    L8:
        Map r2 = r16.getBusinessExt();
        CustomMarkdownTextView r12 = null;
        if (r2 == null) goto L11;
        String r3 = (String) r2.get("share_pic_mode");
    L12:
        boolean r13 = true;
        if (Intrinsics.areEqual(r3, "1") == true) goto L15;
        View r4 = this.o;
        if (r4 == null) goto L26;
        com.larus.utils.e1.o(r4);
    L26:
        super.e(null, r16, r17, r18, r19, r20, r21);
        if (r17 == null) goto L38;
        BlockContent r5 = r17.getContent();
        if (r5 == null) goto L38;
        CommerceCreditBlock r6 = r5.getCommerceCreditBlock();
        if (r6 == null) goto L38;
        Integer r7 = r6.scene;
        int r8 = CommerceCreditBlockScene.CREDIT_BLOCK_SCENE_INSUFFICIENT_BALANCE.getScene();
        if (r7 == null) goto L38;
        if (r7.intValue() != r8) goto L38;
        boolean r9 = true;
    L39:
        if (r9 == false) goto L46;
        TextView r10 = this.n;
        if (r10 == null) goto L43;
        com.larus.utils.e1.d(r10, new e0(r19, r16, this));
    L43:
        TextView r11 = this.n;
        if (r11 == null) goto L53;
        com.larus.utils.e1.x(r11);
    L53:
        if (com.larus.utils.o0.d(h(r16, r17)) == false) goto L57;
        LinearLayout r14 = this.m;
        if (r14 == null) goto L60;
        com.larus.utils.e1.x(r14);
    L60:
        LinearLayout r22 = this.m;
        if (r22 != null) goto L63;
    L68:
        boolean r23 = false;
    L69:
        if (r23 == false) goto L101;
        if (r17 == null) goto L74;
        BlockContent r24 = r17.getContent();
        if (r24 == null) goto L74;
        CommerceCreditBlock r25 = r24.getCommerceCreditBlock();
    L75:
        LinearLayout r26 = this.m;
        if (r26 != null) goto L78;
        CustomMarkdownTextView r27 = null;
    L79:
        if (r27 == null) goto L81;
        r12 = r27;
    L81:
        if (r25 == null) goto L88;
        Integer r28 = r25.scene;
        int r29 = CommerceCreditBlockScene.CREDIT_BLOCK_SCENE_USAGE_DETAIL.getScene();
        if (r28 == null) goto L88;
        if (r28.intValue() != r29) goto L88;
    L89:
        if (r13 == true) goto L91;
    L96:
        if (r12 == null) goto L98;
        r12.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
    L98:
        if (r12 == null) goto L101;
        r12.setTextSize(0, i5.t());
        goto L101
    L91:
        if (Intrinsics.areEqual(r25.displayBlack, Boolean.TRUE) == true) goto L96;
        if (r12 == null) goto L94;
        r12.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(2130972081, getContext(), 2131103143)));
    L94:
        if (r12 == null) goto L101;
        r12.setTextSize(0, i5.o());
    L88:
        r13 = false;
        goto L89
    L78:
        r27 = i(r26);
    L74:
        r25 = null;
    L101:
        if (com.larus.im.bean.message.a.w0(r16) == true) goto L116;
        ri8.c r30 = ri8.c.a;
        String r31 = r16.getConversationId();
        String r32 = r19.b.getBotId();
        if (r32 != null) goto L106;
        String r33 = "";
    L107:
        ChatParam r110 = new ChatParam(r31, r33, null, "chat", null, 244);
        String r34 = com.larus.im.bean.message.a.t(r16);
        if (r34 != null) goto L110;
        String r35 = "";
    L111:
        ri8.c.p(r16, r110, -1, null, r35, 0, 0, 8388448);
        return;
    L110:
        r35 = r34;
        goto L111
    L106:
        r33 = r32;
        goto L107
    L116:
        return;
    L63:
        if (r22.getVisibility() != 0) goto L65;
        boolean r36 = true;
    L66:
        if (r36 != true) goto L68;
        r23 = true;
        goto L69
    L65:
        r36 = false;
        goto L66
    L57:
        LinearLayout r37 = this.m;
        if (r37 == null) goto L60;
        com.larus.utils.e1.o(r37);
        goto L60
    L46:
        TextView r38 = this.n;
        if (r38 == null) goto L49;
        r38.setOnClickListener(null);
    L49:
        TextView r39 = this.n;
        if (r39 == null) goto L53;
        com.larus.utils.e1.o(r39);
    L38:
        r9 = false;
        goto L39
    L15:
        if ((!com.larus.im.bean.message.a.k(r16).isEmpty()) == false) goto L19;
        View r40 = this.o;
        if (r40 == null) goto L113;
        com.larus.utils.e1.x(r40);
        return;
    L113:
        return;
    L19:
        View r41 = this.o;
        if (r41 == null) goto L115;
        com.larus.utils.e1.o(r41);
        return;
    L115:
        return;
    L11:
        r3 = null;
        goto L12
    }
}
