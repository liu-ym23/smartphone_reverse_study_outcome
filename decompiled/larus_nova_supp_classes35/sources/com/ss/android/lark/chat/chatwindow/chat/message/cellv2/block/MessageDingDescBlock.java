package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.d1;
import com.ss.android.lark.chat.utils.f1;
import com.ss.android.lark.ding.entity.DingStatus;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageDingDescBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;

    public static final class a implements Runnable {
        public final /* synthetic */ MessageDingDescBlock a;
        public final /* synthetic */ com.ss.android.lark.blueprint.k<AppCompatTextView> b;
        public final /* synthetic */ y6b.a<?> c;
        public final /* synthetic */ DingStatus d;

        public a(MessageDingDescBlock r1, com.ss.android.lark.blueprint.k<AppCompatTextView> r2, y6b.a<?> r3, DingStatus r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            MessageDingDescBlock r1 = this.a;
            com.ss.android.lark.blueprint.k<AppCompatTextView> r2 = this.b;
            y6b.a<?> r3 = this.c;
            DingStatus r4 = this.d;
            r1.getClass();
            String r5 = UIHelper.getString(2131890353) + ' ';
            SpannableStringBuilder r6 = new SpannableStringBuilder(r5);
            int r7 = r5.length();
            Drawable r8 = UIUtils.getDrawable(r1.getContext(), 2131237570);
            int r9 = zz7.b.g(r1.getContext(), 12);
            r8.setBounds(0, 0, r9, r9);
            com.ss.android.lark.chat.drawable.b r11 = new com.ss.android.lark.chat.drawable.b(r8);
            SpannableString r10 = new SpannableString(" ");
            r10.setSpan(r11, 0, 1, 33);
            r6.insert(0, r10);
            TextPaint r12 = r2.getView().getPaint();
            ChatThemeInfo r13 = r1.c.r8();
            ChatThemeInfo.Scene r14 = null;
            if (r13 == null) goto L5;
            ChatThemeInfo.Scene r15 = r13.getComponentScene();
        L6:
            boolean r16 = com.ss.android.lark.chat.utils.p.g(r15);
            if (r16 == false) goto L14;
            ChatThemeInfo r17 = r1.c.r8();
            if (r17 == null) goto L12;
            r14 = r17.getComponentScene();
        L12:
            if (com.ss.android.lark.chat.utils.p.f(r14) == false) goto L14;
            boolean r18 = true;
        L15:
            Context r19 = r1.getContext();
            float r20 = (r2.getView().getMeasuredWidth() - r9) - r12.measureText(r5);
            Map<String, String> r21 = r4.getChatterNameMap();
            List<String> r22 = r4.getConfirmedChatterIds();
            y r110 = new y(r1, r3);
            pl.droidsonroids.gif.d r23 = f1.a;
            String r24 = UIUtils.getString(ChatCoreModule.a().getContext(), 2131892254);
            float r111 = r12.measureText(r24);
            float r112 = r12.measureText("…");
            int r113 = ncc.f.d;
            int r0 = ((UIHelper.dp2px(2.0f) * 2) + UIHelper.dp2px(3.0f)) + UIHelper.dp2px(2.0f);
            int r25 = r21.size();
            float r26 = r20 - r12.measureText("…" + UIHelper.mustacheFormat(2131890352, "number", Integer.toString(r25)));
            if (r22 != null) goto L18;
            Set r27 = Collections.emptySet();
        L19:
            SpannableStringBuilder r28 = new SpannableStringBuilder();
            Iterator<Map.Entry<String, String>> r29 = r21.entrySet().iterator();
            float r30 = 0.0f;
            int r114 = 0;
        L21:
            if (r29.hasNext() == false) goto L47;
            Map.Entry<String, String> r210 = r29.next();
            Iterator<Map.Entry<String, String>> r211 = r29;
            if (r114 != (r25 - 1)) goto L25;
            boolean r31 = true;
        L26:
            float r212 = r111;
            String r213 = r24;
            float r115 = r12.measureText(r210.getValue()) + r0;
            boolean r32 = r27.contains(r210.getKey());
            r30 = r30 + r115;
            if (r30 > r26) goto L29;
        L43:
            String r116 = r210.getKey();
            int r214 = r0;
            String r33 = r210.getValue();
            ncc.f r34 = f1.b(r19, r32, r18);
            float r215 = r26;
            int r35 = r28.length();
            r28.append(r33);
            int r36 = r28.length();
            int r216 = r25;
            r28.setSpan(new d1(r110, r116), r35, r36, 33);
            r28.setSpan(r34, r35, r36, 33);
            if (r31 == true) goto L46;
            r28.append(r213);
            r30 = r30 + r212;
        L46:
            r114 = r114 + 1;
            r24 = r213;
            r26 = r215;
            r29 = r211;
            r111 = r212;
            r0 = r214;
            r25 = r216;
            goto L21
        L29:
            if (r30 > r20) goto L32;
            if (r31 == true) goto L43;
        L32:
            if (r114 != 0) goto L42;
            if (r31 == false) goto L35;
            r26 = r20 - r112;
        L35:
            String r37 = r210.getKey();
            String r38 = r210.getValue();
            ncc.f r39 = f1.b(r19, r32, r18);
            String r40 = TextUtils.ellipsize(r38, r12, r26, TextUtils.TruncateAt.END).toString();
            if (r40.length() <= 0) goto L38;
            r40 = r40.substring(0, r40.length() - 1);
        L38:
            int r41 = r28.length();
            r28.append(r40);
            int r42 = r28.length();
            r28.setSpan(new d1(r110, r37), r41, r42, 33);
            r28.setSpan(r39, r41, r42, 33);
            if (r31 == false) goto L41;
            r28.append("…");
            goto L47
        L41:
            f1.a(r19, r28, r25, r110);
            goto L47
        L42:
            r28.delete(r28.length() - r213.length(), r28.length());
            f1.a(r19, r28, r25, r110);
            goto L47
        L25:
            r31 = false;
        L47:
            r6.append(r28);
            if (r16 == true) goto L50;
        L53:
            int r43 = com.ss.android.lark.chat.utils.p.e(r1.getContext());
            int r44 = com.ss.android.lark.chat.utils.p.d(r1.getContext());
        L54:
            int r45 = r7 + 1;
            r6.setSpan(new ForegroundColorSpan(r43), 0, r45, 33);
            r6.setSpan(new ForegroundColorSpan(r44), r45, r6.length(), 33);
            r2.getView().setText(r6, TextView.BufferType.SPANNABLE);
            r2.getView().setMovementMethod(LinkMovementMethod.getInstance());
            return;
        L50:
            if (h18.f.a(r1.getContext()) == true) goto L52;
            if (r18 == false) goto L53;
        L52:
            r43 = com.ss.android.lark.chat.utils.p.b(r1.getContext());
            Context r46 = r1.getContext();
            Intrinsics.checkNotNullParameter(r46, "context");
            r44 = UIUtils.getColor(r46, 2131106617);
            goto L54
        L18:
            r27 = new HashSet(r22);
        L14:
            r18 = false;
            goto L15
        L5:
            r15 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public MessageDingDescBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.DING_DESC;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys$Slots.BOTTOM);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r5, com.ss.android.lark.blueprint.q<y6b.a<?>> r6, y6b.a<?> r7) {
        Intrinsics.checkNotNullParameter(r5, "cell");
        Intrinsics.checkNotNullParameter(r6, "layout");
        Intrinsics.checkNotNullParameter(r7, Keys.API_RETURN_KEY_DATA);
        y6b.c r8 = (y6b.c) r7;
        DingStatus r0 = r8.V;
        if (r8.y == false) goto L5;
    L20:
        g(r6, this.g, IMMessageKeys$Slots.BOTTOM);
        return;
    L5:
        if (r8.T == false) goto L20;
        if (r0 == null) goto L20;
        if (r8.z == true) goto L20;
        if ((r0.getConfirmedChatterIds().size() + r0.getUnconfirmedChatterIds().size()) > 0) goto L14;
        g(r6, this.g, IMMessageKeys$Slots.BOTTOM);
        return;
    L14:
        com.ss.android.lark.blueprint.k r9 = r6.c(this.g, IMMessageKeys$Slots.BOTTOM, new MessageDingDescBlock$update$blockView$1(this));
        if (r8.k1 == false) goto L17;
        r9.getView().setGravity(8388629);
    L18:
        r9.getView().post(new a(this, r9, r7, r0));
        return;
    L17:
        r9.getView().setGravity(8388627);
        goto L18
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
