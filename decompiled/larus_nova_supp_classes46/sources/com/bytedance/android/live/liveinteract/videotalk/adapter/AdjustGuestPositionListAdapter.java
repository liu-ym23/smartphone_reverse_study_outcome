package com.bytedance.android.live.liveinteract.videotalk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.MicPanelType;
import com.bytedance.android.livesdk.multilink.base.model.c0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/adapter/AdjustGuestPositionListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/liveinteract/videotalk/adapter/AdjustGuestPositionViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AdjustGuestPositionListAdapter extends RecyclerView.Adapter<AdjustGuestPositionViewHolder> {
    public final int a;
    public final LayoutInflater b;
    public final ArrayList<c0> c;
    public int d;
    public b e;
    public c0 f;
    public final ArrayList<c0> g;
    public final int h;

    public final int getItemCount() {
        return this.c.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        AdjustGuestPositionViewHolder r9 = (AdjustGuestPositionViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "vh");
        c0 r0 = (c0) ListProtector.get(this.c, r8);
        boolean r2 = false;
        ViewGroup.LayoutParams r5 = null;
        if (r0.getEnable() == true) goto L22;
        ArrayList<c0> r1 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        if (this.a != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L8;
        r2 = true;
    L8:
        if (r2 == false) goto L10;
        r9.b.setImageResource(2131248586);
        r9.a.setBackgroundResource(2131248585);
    L11:
        Integer r3 = je0.d.h();
        if (r3 != null) goto L15;
    L49:
        r9.b.setOnClickListener(new a(this, r8));
        return;
    L15:
        if (r3.intValue() != 28) goto L49;
        if (r8 != 0) goto L49;
        r9.a.setBackgroundResource(2131248585);
        r9.b.setImageResource(2131248577);
        ImageView r4 = r9.b;
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
        if (r6 == null) goto L20;
        r6.width = UtilityKotlinExtentionsKt.i(36);
        r6.height = UtilityKotlinExtentionsKt.i(36);
        Unit r10 = Unit.INSTANCE;
        r5 = r6;
    L20:
        r4.setLayoutParams(r5);
        goto L49
    L10:
        r9.b.setImageResource(2131248580);
        goto L11
    L22:
        if (this.d != r8) goto L30;
        ArrayList<c0> r11 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        if (this.a != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L26;
        r2 = true;
    L26:
        if (r2 == false) goto L28;
        r9.b.setImageResource(2131248584);
        r9.a.setBackgroundResource(2131248583);
    L37:
        Integer r12 = je0.d.h();
        if (r12 == null) goto L49;
        if (r12.intValue() != 28) goto L49;
        ImageView r13 = r9.b;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof ConstraintLayout.LayoutParams) == true) goto L45;
        r14 = null;
    L45:
        ViewGroup.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        if (r15 == null) goto L48;
        ((ConstraintLayout.LayoutParams) r15).matchConstraintPercentWidth = 1.0f;
        ((ConstraintLayout.LayoutParams) r15).matchConstraintPercentHeight = 1.0f;
        Unit r16 = Unit.INSTANCE;
        r5 = r15;
    L48:
        r13.setLayoutParams(r5);
        goto L49
    L28:
        r9.b.setImageResource(2131248579);
        goto L37
    L30:
        if (r0.getEnable() != true) goto L37;
        ArrayList<c0> r17 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        if (this.a != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L34;
        r2 = true;
    L34:
        if (r2 == false) goto L36;
        r9.b.setImageResource(2131248582);
        r9.a.setBackgroundResource(2131248581);
        goto L37
    L36:
        r9.b.setImageResource(2131248578);
        goto L37
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "container");
        ArrayList<c0> r6 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        if (this.a != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L9;
        return new AdjustGuestPositionViewHolder(this.b.inflate(2131566874, r4, false));
    L9:
        if (this.h != 30) goto L12;
        return new AdjustGuestPositionViewHolder(this.b.inflate(2131566853, r4, false));
    L12:
        return new AdjustGuestPositionViewHolder(this.b.inflate(2131566852, r4, false));
    L5:
        r7 = false;
        goto L6
    }

    public AdjustGuestPositionListAdapter(Context r2, int r3, ArrayList<c0> r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "list");
        this.g = r4;
        this.h = r5;
        this.a = r3;
        this.b = LayoutInflater.from(r2);
        this.c = r4;
    }
}
