package com.ss.android.lark.newemoji.emoji_list.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements c<ssb.b.d, TitleViewHolder> {

    public static final class a {
    }

    static {
    }

    public g() {
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.c
    public final RecyclerView.ViewHolder a(Context r9, ssb.a r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "params");
        ConstraintLayout r1 = new ConstraintLayout(r9);
        FlexboxLayoutManager.LayoutParams r2 = new FlexboxLayoutManager.LayoutParams(-1, -2);
        r2.setMarginStart((r10.a - r10.d) / 2);
        Intrinsics.checkNotNullParameter(r9, "context");
        ((ViewGroup.MarginLayoutParams) r2).topMargin = UIUtils.dp2px(r9, 8.0f);
        r1.setLayoutParams(r2);
        ImageView r11 = new ImageView(r9);
        r11.setId(2131374769);
        r11.setVisibility(8);
        Intrinsics.checkNotNullParameter(r9, "context");
        int r6 = UIUtils.dp2px(r9, 22.0f);
        Intrinsics.checkNotNullParameter(r9, "context");
        ConstraintLayout.LayoutParams r5 = new ConstraintLayout.LayoutParams(r6, UIUtils.dp2px(r9, 16.0f));
        r5.startToStart = 0;
        r5.topToTop = 0;
        r5.bottomToBottom = 0;
        r11.setLayoutParams(r5);
        Intrinsics.checkNotNullParameter(r9, "context");
        r11.setPadding(0, 0, UIUtils.dp2px(r9, 6.0f), 0);
        r11.setVisibility(8);
        r1.addView(r11);
        TextView r12 = new TextView(r9);
        r12.setId(2131388920);
        r12.setTextSize(12.0f);
        Intrinsics.checkNotNullParameter(r9, "context");
        r12.setTextColor(UIUtils.getColor(r9, 2131106607));
        ConstraintLayout.LayoutParams r13 = new ConstraintLayout.LayoutParams(0, -2);
        r13.topToTop = 0;
        r13.bottomToBottom = 0;
        r13.endToEnd = 0;
        r13.startToEnd = 2131374769;
        r12.setLayoutParams(r13);
        r1.addView(r12);
        return new TitleViewHolder(r1);
    }
}
