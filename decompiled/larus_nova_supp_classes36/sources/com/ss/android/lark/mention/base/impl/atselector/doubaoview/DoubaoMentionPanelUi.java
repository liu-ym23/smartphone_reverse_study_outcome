package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.adapter.DoubaoAtSelectBaseAdapter;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DoubaoMentionPanelUi {
    public final DoubaoAtSelectBaseAdapter a;
    public final View b;
    public final TextView c;
    public final LinearLayout d;
    public final DoubaoMentionRecyclerView e;
    public final TextView f;

    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionRecyclerView] */
    public DoubaoMentionPanelUi(final Context r14, DoubaoAtSelectBaseAdapter r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "adapter");
        this.a = r15;
        int r0 = UIHelper.dp2px(24.0f);
        AppCompatImageView r1 = new AppCompatImageView(r14);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(r0, r0);
        r2.gravity = 17;
        r1.setLayoutParams(r2);
        r1.setImageResource(2131235854);
        r1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout r3 = new FrameLayout(r14);
        r3.setLayoutParams(new LinearLayout.LayoutParams(r0, r0));
        r3.addView(r1);
        this.b = r3;
        TextView r4 = new TextView(r14);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        r5.setMarginStart(UIHelper.dp2px(6.0f));
        r4.setLayoutParams(r5);
        r4.setText(UIHelper.getString(2131890882));
        r4.setTextColor(ContextCompat.getColor(r14, 2131106622));
        r4.setTextSize(14.0f);
        r4.getPaint().setFakeBoldText(true);
        r4.setMaxLines(1);
        TextViewCompat.setLineHeight(r4, UIHelper.dp2px(20.0f));
        this.c = r4;
        LinearLayout r6 = new LinearLayout(r14);
        r6.setOrientation(0);
        r6.setGravity(16);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r6.setPadding(UIHelper.dp2px(16.0f), UIHelper.dp2px(12.0f), UIHelper.dp2px(12.0f), UIHelper.dp2px(0.0f));
        AppCompatImageView r9 = new AppCompatImageView(r14);
        r9.setLayoutParams(new LinearLayout.LayoutParams(UIHelper.dp2px(16.0f), UIHelper.dp2px(16.0f)));
        r9.setImageResource(2131233757);
        r9.setImageTintList(ContextCompat.getColorStateList(r14, 2131102418));
        r6.addView(r9);
        r6.addView(r4);
        r6.addView(r3);
        r6.post(new d(r3, UIHelper.dp2px(44.0f), r6));
        this.d = r6;
        Object r7 = LayoutInflater.from(r14).inflate(2131568162, null, false);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionRecyclerView");
        ?? r8 = (DoubaoMentionRecyclerView) r7;
        r8.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r8.setLayoutManager(new LinearLayoutManager(r14, 1, false));
        r8.setAdapter(r15);
        r8.setItemAnimator(null);
        r8.addItemDecoration(new DoubaoMentionPanelUi$recyclerView$1$1(r14));
        this.e = r8;
        TextView r16 = new TextView(r14);
        r16.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r16.setGravity(17);
        r16.setVisibility(8);
        r16.setText(UIHelper.getString(2131892028));
        this.f = r16;
    }
}
