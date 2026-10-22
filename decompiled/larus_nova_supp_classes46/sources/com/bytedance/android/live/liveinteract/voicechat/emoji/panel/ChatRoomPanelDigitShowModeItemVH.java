package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarAuditStatus;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelDigitShowModeItemVH;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelItemBaseVH;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatRoomPanelDigitShowModeItemVH extends ChatRoomPanelItemBaseVH {
    public g a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ChatRoomPanelDigitShowModeItemVH a;

        public a(ChatRoomPanelDigitShowModeItemVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            r2.setTag(VideoShowMode.AUDIO);
            g r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.k(r2);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ChatRoomPanelDigitShowModeItemVH a;

        public b(ChatRoomPanelDigitShowModeItemVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            r2.setTag(VideoShowMode.VIDEO);
            g r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.k(r2);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ChatRoomPanelDigitShowModeItemVH a;

        public c(ChatRoomPanelDigitShowModeItemVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            r2.setTag(VideoShowMode.DIGIT_AVATAR);
            g r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.k(r2);
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemBaseVH
    public final void U3(ChatRoomPanelItemBaseVH r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
    }

    public ChatRoomPanelDigitShowModeItemVH(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        ((ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363386)).setOnClickListener(new a(this));
        ((ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392239)).setOnClickListener(new b(this));
        ((ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363635)).setOnClickListener(new c(this));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemBaseVH
    public final void T3(g r13) {
        Intrinsics.checkNotNullParameter(r13, "panelItem");
        this.a = r13;
        LinearLayout r0 = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363387);
        UtilityKotlinExtentionsKt.t(r0);
        boolean r2 = false;
        r0.setSelected(false);
        LinearLayout r1 = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392240);
        UtilityKotlinExtentionsKt.t(r1);
        r1.setSelected(false);
        LinearLayout r3 = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363636);
        UtilityKotlinExtentionsKt.t(r3);
        r3.setSelected(false);
        Object r14 = r13.c();
        if (r14 == null) goto L44;
        m r15 = (m) r14;
        Enum[] r4 = r15.a;
        int r5 = r4.length;
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L16;
        Enum r10 = r4[r6];
        int r11 = f.a[r10.ordinal()];
        if (r11 == 1) goto L14;
        if (r11 == 2) goto L13;
        if (r11 != 3) goto L15;
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) this).itemView.findViewById(2131363636));
    L15:
        r6 = r6 + 1;
        goto L6
    L13:
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) this).itemView.findViewById(2131392240));
        goto L15
    L14:
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) this).itemView.findViewById(2131363387));
        goto L15
    L16:
        VideoShowMode r7 = r15.b;
        int r8 = f.b[r7.ordinal()];
        if (r8 == 1) goto L23;
        if (r8 == 2) goto L22;
        if (r8 != 3) goto L24;
        ((LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363636)).setSelected(true);
    L24:
        TextView r9 = (TextView) ((LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363636)).findViewById(2131363637);
        if (r9.getVisibility() == 0) goto L28;
        return;
    L28:
        if (r15.b != VideoShowMode.DIGIT_AVATAR) goto L31;
        r2 = true;
    L31:
        if (r2 == false) goto L41;
        DigitAvatarAuditStatus r16 = r15.c;
        int r17 = f.c[r16.ordinal()];
        if (r17 != 1) goto L35;
        r9.setTextColor(Color.argb(255, 254, 56, 36));
        r9.setText(2131918204);
        return;
    L35:
        if (r17 == 2) goto L39;
        if (r17 != 3) goto L54;
        r9.setTextColor(Color.argb(255, 77, 77, 77));
        r9.setText(2131918202);
        return;
    L54:
        return;
    L39:
        r9.setTextColor(Color.argb(255, 77, 77, 77));
        r9.setText(2131916219);
        return;
    L41:
        r9.setTextColor(Color.argb(255, 148, 148, 148));
        r9.setText(2131916219);
        return;
    L22:
        ((LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392240)).setSelected(true);
        goto L24
    L23:
        ((LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363387)).setSelected(true);
        goto L24
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.voicechat.emoji.panel.DigitShowModeData");
    }
}
