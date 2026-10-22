package com.larus.bmhome.chat.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.BotBioHolder;
import com.larus.bmhome.chat.layout.holder.BotBioImmersHolder;
import com.larus.bmhome.chat.layout.holder.PrivateHolder;
import com.larus.common_ui.widget.ExpandTextview;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fH\u0016J\u0010\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100J\u0018\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00106\u001a\u00020\u00132\u0006\u00102\u001a\u000203H\u0002J\u0010\u00107\u001a\u00020\u00192\u0006\u00102\u001a\u000203H\u0002J\u0015\u00108\u001a\u00020.2\b\u0010$\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\u0010\u00109\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010\u0006J\b\u0010;\u001a\u00020\fH\u0016J\u0018\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\fH\u0016J\u0006\u0010>\u001a\u00020.R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/bmhome/chat/adapter/HeaderAreaAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "conversationId", "", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "conversationType", "", "getConversationType", "()Ljava/lang/Integer;", "setConversationType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bioHolder", "Lcom/larus/bmhome/chat/layout/holder/BotBioHolder;", "getBioHolder", "()Lcom/larus/bmhome/chat/layout/holder/BotBioHolder;", "setBioHolder", "(Lcom/larus/bmhome/chat/layout/holder/BotBioHolder;)V", "bioImmersHolder", "Lcom/larus/bmhome/chat/layout/holder/BotBioImmersHolder;", "getBioImmersHolder", "()Lcom/larus/bmhome/chat/layout/holder/BotBioImmersHolder;", "setBioImmersHolder", "(Lcom/larus/bmhome/chat/layout/holder/BotBioImmersHolder;)V", "privateHolder", "Lcom/larus/bmhome/chat/layout/holder/PrivateHolder;", "getPrivateHolder", "()Lcom/larus/bmhome/chat/layout/holder/PrivateHolder;", "setPrivateHolder", "(Lcom/larus/bmhome/chat/layout/holder/PrivateHolder;)V", "immerseBgColor", "getImmerseBgColor", "setImmerseBgColor", "enableTips", "", "enableBio", "isMainBot", "getItemViewType", "position", "updateConversation", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "createPrivateHolder", "createBotBioHolder", "createBotBioImmersHolder", "updateBgColor", "updateBio", "bio", "getItemCount", "onBindViewHolder", "holder", "setVisible", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class HeaderAreaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public String a;
    public BotBioHolder b;
    public PrivateHolder c;
    public Integer d;
    public final boolean e;
    public boolean f;
    public boolean g;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        boolean r0 = this.e;
        if (r0 == true) goto L5;
    L8:
        if (r0 == false) goto L10;
        return 1;
    L10:
        if (this.f == true) goto L16;
        return 0;
    L16:
        return 1;
    L5:
        if (this.f == false) goto L8;
        return 2;
    }

    public HeaderAreaAdapter() {
        z2 r0 = z2.a;
        boolean r2 = true;
        if (r0.enableChatWithTab() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.e = r1;
        if (r0.enableBioInChatTop() == 2) goto L12;
        r2 = false;
    L12:
        this.f = r2;
        return;
    L5:
        if (r0.enableShowDisclaimer() == false) goto L7;
        r1 = true;
        goto L8
    }

    public final int getItemViewType(int r5) {
        if (getItemCount() != 2) goto L11;
        if (r5 != 1) goto L7;
        return 3;
    L7:
        if (this.d != null) goto L9;
        return 1;
    L9:
        return 2;
    L11:
        if (this.e == false) goto L14;
        return 3;
    L14:
        if (this.d != null) goto L16;
        return 1;
    L16:
        return 2;
    }

    public final BotBioHolder y2(ViewGroup r4) {
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131562507, r4, false);
        ExpandTextview r0 = r5.findViewById(2131388367);
        if (r0 == null) goto L7;
        TextView r1 = r0.getContentView();
        if (r1 == null) goto L7;
        r1.setLineSpacing(0.0f, 1.3f);
    L7:
        Intrinsics.checkNotNull(r5);
        BotBioHolder r2 = new BotBioHolder(r5);
        this.b = r2;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.bmhome.chat.layout.holder.BotBioHolder");
        return r2;
    }

    public final void z2(String r7) {
        FLogger.a.i("HeaderAreaAdapter", "updateBio bio=" + r7 + ",enableBio=" + this.f);
        if (this.f == false) goto L15;
        if (r7 != null) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L15;
        this.f = false;     // Catch: Exception -> L13
        notifyItemRemoved(0);     // Catch: Exception -> L13
        return;
    L13:
        FLogger.a.e("HeaderAreaAdapter", "updateBio remove error");
        return;
    L6:
        if (r7.length() == 0) goto L9;
        r0 = false;
    L15:
        if (this.f == true) goto L17;
    L21:
        z2 r1 = z2.a;
        if (r1.enableBioInChatTop() == 2) goto L28;
        if (r1.enableBioInChatTop() == 1) goto L26;
        return;
    L26:
        if (this.d != null) goto L28;
        return;
    L28:
        if (com.larus.utils.o0.d(r7) == true) goto L30;
        return;
    L30:
        if (this.g == true) goto L46;
        this.f = true;     // Catch: Exception -> L33
        notifyItemInserted(0);     // Catch: Exception -> L33
        return;
    L33:
        FLogger.a.e("HeaderAreaAdapter", "updateBio insert error");
        return;
    L46:
        return;
    L17:
        if (com.larus.utils.o0.d(r7) == false) goto L21;
        notifyItemChanged(0);     // Catch: Exception -> L20
        return;
    L20:
        FLogger.a.e("HeaderAreaAdapter", "updateBio change error");
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if ((r2 instanceof BotBioHolder) == false) goto L6;
        ((BotBioHolder) r2).T3(this.a, this);
        return;
    L6:
        if ((r2 instanceof BotBioImmersHolder) == false) goto L9;
        ((BotBioImmersHolder) r2).T3(this.a, this.d, this);
        return;
    L9:
        if ((r2 instanceof PrivateHolder) == false) goto L11;
        PrivateHolder r4 = (PrivateHolder) r2;
    L12:
        if (r4 == null) goto L17;
        TextView r5 = (TextView) r4.a.findViewById(2131388367);
        r5.setText(r5.getContext().getString(2131906309));
        return;
    L17:
        return;
    L11:
        r4 = null;
        goto L12
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        if (r7 == 1) goto L37;
        if (r7 != 2) goto L7;
        View r8 = LayoutInflater.from(r6.getContext()).inflate(2131562508, r6, false);
        Integer r0 = this.d;
        if (r0 == null) goto L34;
        int r1 = r0.intValue();
        ExpandTextview r2 = r8.findViewById(2131388367);
        CardView r3 = r8.findViewById(2131367728);
        if (r2 == null) goto L23;
        r2.setContentTextColor(ContextCompat.getColor(r6.getContext(), 2131103298));
    L23:
        if (r2 == null) goto L25;
        r2.setContentTextAlpha(0.7f);
    L25:
        if (r2 == null) goto L27;
        r2.setExpandTextColor(ContextCompat.getColor(r6.getContext(), 2131106539));
    L27:
        if (r2 == null) goto L31;
        TextView r9 = r2.getContentView();
        if (r9 == null) goto L31;
        r9.setLineSpacing(0.0f, 1.3f);
    L31:
        r3.setCardBackgroundColor(com.larus.bmhome.chat.immerse.k0.a(r1, 0.4f, 0.15f));
        Drawable r10 = r3.getBackground();
        if (r10 == null) goto L34;
        r10.setAlpha(230);
    L34:
        Intrinsics.checkNotNull(r8);
        BotBioImmersHolder r11 = new BotBioImmersHolder(r8);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.larus.bmhome.chat.layout.holder.BotBioImmersHolder");
        return r11;
    L7:
        if (r7 != 3) goto L9;
        View r12 = LayoutInflater.from(r6.getContext()).inflate(2131562617, r6, false);
        if (this.d == null) goto L16;
        TextView r4 = (TextView) r12.findViewById(2131388367);
        if (r4 == null) goto L15;
        r4.setTextColor(ContextCompat.getColor(r6.getContext(), 2131103298));
    L15:
        r4.setShadowLayer(3.0f, 2.0f, 2.0f, 2131103292);
    L16:
        Intrinsics.checkNotNull(r12);
        PrivateHolder r13 = new PrivateHolder(r12);
        this.c = r13;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.larus.bmhome.chat.layout.holder.PrivateHolder");
        return r13;
    L9:
        return y2(r6);
    L37:
        return y2(r6);
    }
}
