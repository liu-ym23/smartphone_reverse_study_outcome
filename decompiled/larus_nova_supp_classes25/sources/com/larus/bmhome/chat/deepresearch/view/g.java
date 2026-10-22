package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.im.bean.message.block.AuthIdentityBlock;
import com.larus.im.bean.message.block.AuthIdentityType;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.mainbot.impl.databinding.LarusBlockItemAuthIdentityBinding;
import com.larus.platform.service.AccountService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g extends AbsBlockView {
    public LarusBlockItemAuthIdentityBinding b;

    public g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(Block r5, Map<String, Object> r6) {
        LarusBlockItemAuthIdentityBinding r7 = this.b;
        if (r7 != null) goto L5;
        return;
    L5:
        if (r5 == null) goto L9;
        BlockContent r8 = r5.getContent();
        if (r8 == null) goto L9;
        final AuthIdentityBlock r9 = r8.getAuthIdentityBlock();
    L10:
        boolean r1 = false;
        if (r9 == null) goto L18;
        Integer r2 = r9.authType;
        int r3 = AuthIdentityType.AUTH_IDENTITY_TOURIST_LOGIN.getType();
        if (r2 == null) goto L18;
        if (r2.intValue() != r3) goto L18;
        r1 = true;
    L18:
        if (r1 == false) goto L28;
        com.larus.utils.e1.d(r7.b, new f(r9, this));
        TextView r0 = r7.b;
        String r10 = r9.text;
        if (r10 != null) goto L23;
        r10 = "";
    L23:
        r0.setText(r10);
        if (AccountService.a.isLogin().booleanValue() == false) goto L26;
        r7.b.setTextColor(ContextCompat.getColor(getContext(), 2131103681));
    L27:
        com.larus.utils.e1.x(r7.b);
        return;
    L26:
        r7.b.setTextColor(ContextCompat.getColor(getContext(), 2131105539));
        goto L27
    L28:
        r7.b.setOnClickListener(null);
        com.larus.utils.e1.o(r7.b);
        return;
    L9:
        r9 = null;
        goto L10
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r4 = LayoutInflater.from(r2).inflate(2131561824, this, false);
        addView(r4);
        if (r4 == null) goto L7;
        TextView r5 = (TextView) r4;
        this.b = new LarusBlockItemAuthIdentityBinding(r5, r5);
        return;
    L7:
        throw new NullPointerException("rootView");
    }
}
