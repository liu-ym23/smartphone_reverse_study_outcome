package com.larus.bmhome.chat.component.bottom;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/bmhome/chat/component/bottom/ChatBottomComponent$buildHumanMergeForwardResourceRender$1$1", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "bind", "", "data", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatBottomComponent$buildHumanMergeForwardResourceRender$1$1 extends BaseResourceViewHolder {
    public static final /* synthetic */ int d = 0;
    public final /* synthetic */ ChatBottomComponent b;
    public final /* synthetic */ ChatBottomComponent$b c;

    public final void T3(ResourceItemBean r13, lt8.a r14) {
        Intrinsics.checkNotNullParameter(r13, "data");
        View r15 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r15 instanceof FrameLayout) == false) goto L5;
        FrameLayout r16 = (FrameLayout) r15;
    L6:
        if (r16 != null) goto L8;
        return;
    L8:
        r16.removeAllViews();
        r16.setPadding(0, r13.getPaddingTop(), i5.r0(), r13.getPaddingBottom());
        final ChatBottomComponent r17 = this.b;
        final ChatBottomComponent$b r0 = this.c;
        int r2 = ChatBottomComponent.L0;
        r17.getClass();
        FrameLayout r3 = new FrameLayout(r17.getContext());
        r3.setClickable(true);
        r3.setBackgroundResource(c.b(2130970785, r3.getContext(), 2131239523));
        r3.setOnClickListener(new v(r17, r0));
        TextView r5 = new TextView(r3.getContext());
        r5.setText(r0.a);
        r5.setTextColor(c.a(2130972079, r17.getContext(), 2131103136));
        r5.setTextSize(0, r5.getResources().getDimension(c.b(2130972273, null, 2131167616)));
        r5.setMaxLines(2);
        r5.setIncludeFontPadding(false);
        r5.setLineSpacing(0.0f, 1.2f);
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -2);
        r6.leftMargin = i5.c();
        r6.rightMargin = i5.J();
        r6.topMargin = i5.c();
        Unit r9 = Unit.INSTANCE;
        r3.addView(r5, r6);
        LinearLayout r7 = new LinearLayout(r3.getContext());
        r7.setOrientation(0);
        r7.setGravity(16);
        ImageView r8 = new ImageView(r7.getContext());
        r8.setImageResource(2131241531);
        r7.addView(r8, new LinearLayout.LayoutParams(i5.m(), i5.m()));
        TextView r10 = new TextView(r7.getContext());
        r10.setText(r10.getContext().getResources().getQuantityString(2131755091, r0.b.size(), new Object[]{Integer.valueOf(r0.b.size())}));
        r10.setTextColor(c.a(2130972082, r17.getContext(), 2131103146));
        r10.setTextSize(0, r10.getResources().getDimension(c.b(2130972270, null, 2131167610)));
        r10.setIncludeFontPadding(false);
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-2, -2);
        r18.leftMargin = i5.Y();
        r7.addView(r10, r18);
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-2, -2);
        r19.gravity = 8388691;
        r19.leftMargin = i5.c();
        r19.bottomMargin = i5.c();
        r3.addView(r7, r19);
        View r110 = new View(r3.getContext());
        r110.setBackgroundResource(c.b(2130970786, r110.getContext(), 2131239525));
        r3.addView(r110, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-1, -1);
        r111.gravity = 8388659;
        r16.addView(r3, r111);
        ImageView r112 = new ImageView(r16.getContext());
        final ChatBottomComponent r1 = this.b;
        r112.setImageResource(2131243252);
        r112.setContentDescription(r16.getContext().getString(2131898869));
        r112.setOnClickListener(new a1(r1));
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
        r4.gravity = 8388661;
        r4.topMargin = i5.Y();
        r4.rightMargin = i5.Y();
        r16.addView(r112, r4);
        return;
    L5:
        r16 = null;
        goto L6
    }

    public ChatBottomComponent$buildHumanMergeForwardResourceRender$1$1(ResourceBarConfig r1, ChatBottomComponent r2, ChatBottomComponent$b r3, FrameLayout r4) {
        this.b = r2;
        this.c = r3;
        super(r1, r4);
    }
}
