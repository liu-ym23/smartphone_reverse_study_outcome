package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.model.SwitchResolutionDialogConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LandscapeVideoQualityViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeVideoQualityViewHolder extends RecyclerView.ViewHolder {
    public final SwitchResolutionDialogConfig a;

    public LandscapeVideoQualityViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (SwitchResolutionDialogConfig) com.bytedance.android.livesdk.f3.a.getValue();
    }

    public final void T3(l5 r8) {
        if (r8 == null) goto L8;
        c8 r9 = r8.i;
        if (r9 == null) goto L8;
        boolean r0 = true;
        if (r9.a != true) goto L8;
    L9:
        if (r0 == false) goto L11;
        int r10 = 2131107042;
    L12:
        int r11 = com.bytedance.android.live.core.utils.s1.h(r10);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131383526)).setTextColor(r11);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131381784)).setTextColor(r11);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385704)).setTextColor(r11);
        View r12 = ((RecyclerView.ViewHolder) this).itemView;
        StringBuilder r1 = new StringBuilder("已选中 ");
        View r5 = ((RecyclerView.ViewHolder) this).itemView;
        View r6 = null;
        if (r5 == null) goto L15;
        View r2 = r5.findViewById(2131383526);
    L16:
        TextView r3 = (TextView) r2;
        CharSequence r7 = "";
        if (r3 == null) goto L20;
        CharSequence r4 = r3.getText();
        if (r4 == null) goto L20;
    L21:
        r1.append(r4);
        View r13 = ((RecyclerView.ViewHolder) this).itemView;
        if (r13 == null) goto L24;
        View r14 = r13.findViewById(2131381784);
    L25:
        TextView r15 = (TextView) r14;
        if (r15 == null) goto L29;
        CharSequence r16 = r15.getText();
        if (r16 == null) goto L29;
    L30:
        r1.append(r16);
        View r17 = ((RecyclerView.ViewHolder) this).itemView;
        if (r17 == null) goto L33;
        r6 = r17.findViewById(2131385704);
    L33:
        TextView r18 = (TextView) r6;
        if (r18 == null) goto L39;
        CharSequence r19 = r18.getText();
        if (r19 == null) goto L39;
        r7 = r19;
    L39:
        r1.append(r7);
        r1.append("按钮");
        r12.setContentDescription(r1.toString());
        if (r0 == false) goto L42;
        int r20 = 2131249867;
    L43:
        ((RecyclerView.ViewHolder) this).itemView.setBackgroundResource(r20);
        return;
    L42:
        r20 = 2131249866;
    L29:
        r16 = "";
        goto L30
    L24:
        r14 = null;
    L20:
        r4 = "";
        goto L21
    L15:
        r2 = null;
        goto L16
    L11:
        r10 = 2131108569;
    L8:
        r0 = false;
        goto L9
    }
}
