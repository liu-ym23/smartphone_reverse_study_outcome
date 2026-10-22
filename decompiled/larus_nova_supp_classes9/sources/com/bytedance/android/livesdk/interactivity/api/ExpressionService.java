package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.adapter.EmojiPanelAdapter;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.interactivity.api.expression.MentionSpan;
import com.bytedance.android.livesdk.mention.MentionEditText;
import com.bytedance.android.livesdk.widget.EmojiEditView;
import com.bytedance.android.livesdk.widget.EmojiSelectPanel;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class ExpressionService implements IExpressionService {
    public ExpressionService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public GradientEditText createEmojiEditText(Context r2, int r3) {
        EmojiEditView r0 = new EmojiEditView(r2);
        r0.setTextEmojiSize(r3);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public View createExpressionPanelV3(Context r2, com.bytedance.android.livesdk.interactivity.api.expression.a r3) {
        com.bytedance.android.livesdk.widget.newboard.c r0 = new com.bytedance.android.livesdk.widget.newboard.c(r2, r3);
        r0.setOnCommentSendDelegate(r3.g);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public GradientEditText createEmojiEditText(Context r13, int r14, com.bytedance.android.livesdk.interactivity.api.expression.c r15) {
        MentionEditText r0 = new MentionEditText(r13);
        r0.setTextEmojiSize(r14);
        if (r15 == null) goto L27;
        Intrinsics.checkNotNullParameter(r0, "$this$addMentionText");
        Intrinsics.checkNotNullParameter(r15, "param");
        String r5 = r15.d;
        String r4 = r15.c;
        String r16 = r15.b;
        int r17 = r0.getSelectionStart();
        Editable r8 = r0.getText();
        if (r8 == null) goto L27;
        SpannableString r9 = new SpannableString("@" + r16);
        r9.setSpan(new MentionSpan(new com.bytedance.android.livesdk.interactivity.api.expression.d(r15.a, r9.toString(), r4, r5, r15.e, false)), 0, r9.length(), 33);
        if (r0.getMentionTextTypeface() == 0) goto L11;
        r9.setSpan(new StyleSpan(r0.getMentionTextTypeface()), 0, r9.length(), 33);
    L11:
        if (TextUtils.isEmpty(r8) == false) goto L13;
        r8.insert(0, r9);
        r8.append(" ");
        goto L27
    L13:
        int r18 = r8.length();
        if (r17 < 0) goto L27;
        if (r18 < r17) goto L27;
        if (r17 <= 0) goto L21;
        int r2 = r17 - 1;
        if (TextUtils.equals(r8.subSequence(r2, r17), "@") == false) goto L21;
        r8.delete(r2, r17);
        r18 = r18 - 1;
        r17 = r2;
    L21:
        int r19 = Math.min(r18, Math.max(0, r17));
        r8.insert(r19, r9);
        if (r8.length() > r19) goto L24;
    L26:
        r8.insert(Math.min(r19 + r9.length(), r8.length()), " ");
        goto L27
    L24:
        if (r8.length() >= (r9.length() + r19)) goto L26;
    L27:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public com.bytedance.android.livesdk.interactivity.api.expression.b createSimpleExpressionPanelV3(Context r2, boolean r3, com.bytedance.android.livesdk.interactivity.api.expression.j r4) {
        com.bytedance.android.livesdk.widget.newboard.f r0 = new com.bytedance.android.livesdk.widget.newboard.f(r2, r3);
        r0.setOnCommentSendDelegate(r4);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public View createEmojiSelectPanel(Context r13, boolean r14, int r15, com.bytedance.android.livesdk.interactivity.api.expression.k r16) {
        EmojiSelectPanel r0 = new EmojiSelectPanel(r13);
        r0.setOnEmojiSelectListener(r16);
        if (r14 == false) goto L5;
        int r17 = 3;
    L6:
        r0.h = r17;
        if (r14 == false) goto L9;
        int r18 = 6;
    L10:
        r0.i = r18;
        r0.j = r17 * r18;
        r0.k = r15;
        r0.a = r0.findViewById(2131378057);
        r0.c = r0.findViewById(2131381814);
        EmojiPanelAdapter r19 = new EmojiPanelAdapter(r0.getContext(), r0.h, r0.i, r0.k);
        r0.b = r19;
        r19.i = r0;
        r0.a.setAdapter(r19);
        int r110 = 0;
        r0.a.setLayoutManager(new SSGridLayoutManager(r0.getContext(), r0.h, 0));
        r0.a.setHasFixedSize(true);
        r0.a.setItemViewCacheSize(36);
        com.bytedance.android.livesdk.widget.o r111 = new com.bytedance.android.livesdk.widget.o(r0);
        r111.h(r0.h);
        r111.g(r0.i);
        r111.attachToRecyclerView(r0.a);
        r0.a.addOnScrollListener(new com.bytedance.android.livesdk.widget.p(r0));
        r0.c.setMargin((int) r0.getContext().getResources().getDimension(2131168969));
        RtlViewPagerShower r112 = r0.c;
        Drawable r113 = r0.getContext().getResources().getDrawable(2131250531);
        Drawable r1 = r0.getContext().getResources().getDrawable(2131250532);
        r112.c = r113;
        r112.d = r1;
        ab2.b.a().a.getClass();
        IMiddleWareHostEmoji r114 = jc1.k.f(IMiddleWareHostEmoji.class);
        if (r114 == null) goto L13;
        List r115 = r114.loadAllBaseEmoji();
    L15:
        if (Lists.isEmpty(r115) == true) goto L46;
        EmojiPanelAdapter r116 = r0.b;
        r116.getClass();
        if (Lists.isEmpty(r115) == false) goto L20;
        int r2 = 0;
    L25:
        int r3 = r116.f * r2;
        int r4 = 1;
    L26:
        if (r4 > r2) goto L31;
        int r5 = (r116.f * r4) - 1;
        if (r5 >= r115.size()) goto L30;
        ListProtector.add(r115, r5, new com.bytedance.android.livesdk.model.a(r116.h));
    L30:
        r4 = r4 + 1;
        goto L26
    L31:
        BaseEmoji[] r6 = new BaseEmoji[r3];
        int r7 = 0;
    L32:
        if (r7 >= r3) goto L34;
        r6[r7] = new com.bytedance.android.livesdk.model.c();
        r7 = r7 + 1;
        goto L32
    L34:
        Iterator r8 = r115.iterator();
    L36:
        if (r8.hasNext() == false) goto L41;
        BaseEmoji r9 = (BaseEmoji) r8.next();
        int r10 = r116.d;
        int r11 = r116.e;
        int r20 = r116.f;
        int r21 = r110 % r20;
        int r117 = ((r21 / r11) + 1) - 1;
        int r23 = ((r10 * (r21 - (r11 * r117))) + r117) + ((r110 / r20) * r20);
        r110 = r110 + 1;
        if (r23 >= r3) goto L36;
        r6[r23] = r9;
        goto L36
    L41:
        r6[r3 - 1] = new com.bytedance.android.livesdk.model.a(r116.h);
        List r118 = Arrays.asList(r6);
        ((ArrayList) r116.c).clear();
        if (r118 == null) goto L45;
        ((ArrayList) r116.c).addAll(r118);
    L45:
        r0.b.notifyDataSetChanged();
        int r119 = (r115.size() / r0.j) + 1;
        r0.g = r119;
        r0.c.a(r119, r0.e);
        goto L46
    L20:
        int r24 = r115.size() / (r116.f - 1);
        if ((r115.size() % (r116.f - 1)) <= 0) goto L23;
        int r25 = 1;
    L24:
        r2 = r24 + r25;
        goto L25
    L23:
        r25 = 0;
    L46:
        return r0;
    L13:
        r115 = new ArrayList();
        goto L15
    L9:
        r18 = 12;
        goto L10
    L5:
        r17 = 2;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public View createNewEmojiSelectPanel(Context r2, boolean r3, int r4, com.bytedance.android.livesdk.interactivity.api.expression.i r5, com.bytedance.android.livesdk.interactivity.api.expression.j r6) {
        com.bytedance.android.livesdk.widget.board.e r0 = new com.bytedance.android.livesdk.widget.board.e(r2, r4, r3, r5);
        r0.setOnCommentSendDelegate(r6);
        return r0;
    }
}
