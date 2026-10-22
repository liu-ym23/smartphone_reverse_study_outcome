package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.mainbot.impl.databinding.LarusBlockItemResearchBannerBinding;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i extends AbsBlockView {
    public LarusBlockItemResearchBannerBinding b;

    public i(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(final Block r12, Map<String, Object> r13) {
        String r0 = null;
        if (r13 == null) goto L5;
        Object r1 = r13.get("block_view_extra_message");
    L6:
        final Message r6 = (Message) r1;
        if (r13 == null) goto L9;
        Object r2 = r13.get("block_view_extra_bot_model");
    L11:
        if ((r2 instanceof BotModel) == false) goto L13;
        final BotModel r7 = (BotModel) r2;
    L14:
        if (r13 == null) goto L16;
        Object r3 = r13.get("block_view_extra_chat_key");
    L18:
        if ((r3 instanceof Long) == false) goto L20;
        Long r4 = (Long) r3;
    L21:
        if (r4 == null) goto L23;
        long r5 = r4.longValue();
    L24:
        final long r8 = r5;
        if (r13 == null) goto L27;
        Object r14 = r13.get("block_view_extra_current_page");
    L29:
        if ((r14 instanceof String) == false) goto L31;
        r0 = (String) r14;
    L31:
        final String r10 = r0;
        final boolean r9 = Intrinsics.areEqual(r10, "dr_process_detail");
        String r11 = AbsBlockView.a.f(r12, r9, false);
        LarusBlockItemResearchBannerBinding r15 = this.b;
        if (r15 == null) goto L43;
        if (r11 != null) goto L35;
    L38:
        boolean r16 = true;
    L39:
        if (r16 == false) goto L41;
        r15.a.setVisibility(8);
        return;
    L41:
        r15.a.setVisibility(0);
        r15.b.setText(r11);
        com.larus.utils.e1.d(r15.a, new h(r12, this, r9, r6, r7, r8, r10));
        return;
    L35:
        if (r11.length() == 0) goto L38;
        r16 = false;
        goto L39
    L43:
        return;
    L27:
        r14 = null;
        goto L29
    L23:
        r5 = 0;
        goto L24
    L20:
        r4 = null;
        goto L21
    L16:
        r3 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r2 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        View r5 = LayoutInflater.from(r3).inflate(2131561841, this, false);
        addView(r5);
        LinearLayout r6 = (LinearLayout) r5;
        int r0 = 2131375994;
        if (ViewBindings.findChildViewById(r5, 2131375994) == null) goto L9;
        r0 = 2131391606;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r5, 2131391606);
        if (r1 == null) goto L9;
        this.b = new LarusBlockItemResearchBannerBinding(r6, r1);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r0)));
    }
}
