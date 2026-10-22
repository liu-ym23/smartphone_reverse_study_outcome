package com.obric.assistant.card.layout.viewholder;

import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.utils.e1;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemStyleIconContentBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemIconContentStyle;
import com.obric.assistant.card.provider.PrivilegedUriProvider;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0012\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J0\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0014J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0019H\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0019H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006)"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/LarkMessageViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconContentStyle;", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "mButtonContainer", "Landroid/view/View;", "mBtnSend", "Landroid/widget/TextView;", "mBtnCancel", "mTvStatus", "currentMessageId", NameKeys.UnloadStrategy_No_Strategy, "currentStatus", NameKeys.UnloadStrategy_No_Strategy, "timerListener", "com/obric/assistant/card/layout/viewholder/LarkMessageViewHolder$timerListener$1", "Lcom/obric/assistant/card/layout/viewholder/LarkMessageViewHolder$timerListener$1;", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconContentStyle$StyleData;", "entity", "position", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "onViewDetached", "onViewAttached", "ensureButtonsInflated", "updateStatusUI", "status", "setContentAlpha", "alpha", NameKeys.UnloadStrategy_No_Strategy, "resetContentAlpha", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkMessageViewHolder extends AbsCardItemIconContentStyle<MessageEntity> {
    public static final /* synthetic */ int s = 0;
    public View l;
    public TextView m;
    public TextView n;
    public TextView o;
    public String p;
    public int q;
    public final b r;

    public static final class a {
    }

    public static final class b implements com.obric.assistant.card.manager.a.InterfaceC0076a {
        public final /* synthetic */ LarkMessageViewHolder a;

        @Override // com.obric.assistant.card.manager.a.InterfaceC0076a
        public final void onFinish() {
            LarkMessageViewHolder r0 = this.a;
            int r1 = LarkMessageViewHolder.s;
            r0.d4(1);
        }

        public b(LarkMessageViewHolder r1) {
            this.a = r1;
        }

        @Override // com.obric.assistant.card.manager.a.InterfaceC0076a
        public final void onTick(long r6) {
            LarkMessageViewHolder r0 = this.a;
            TextView r1 = r0.m;
            if (r1 == null) goto L6;
            r1.setText(((RecyclerView.ViewHolder) r0).itemView.getContext().getString(2131912005, new Object[]{Long.valueOf((r6 / ((long) 1000)) + 1)}));
            return;
        }
    }

    static {
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void U3() {
        if (this.q != 0) goto L15;
        String r0 = this.p;
        if (r0 == null) goto L16;
        ConcurrentHashMap<String, CountDownTimer> r1 = com.obric.assistant.card.manager.a.a;
        Intrinsics.checkNotNullParameter(r0, "messageId");
        if (com.obric.assistant.card.manager.a.a.containsKey(r0) == false) goto L13;
        com.obric.assistant.card.manager.a.a(r0, this.r);
        Intrinsics.checkNotNullParameter(r0, "messageId");
        Long r2 = com.obric.assistant.card.manager.a.b.get(r0);
        if (r2 == null) goto L17;
        TextView r3 = this.m;
        if (r3 == null) goto L18;
        r3.setText(((RecyclerView.ViewHolder) this).itemView.getContext().getString(2131912005, new Object[]{Long.valueOf((r2.longValue() / ((long) 1000)) + 1)}));
        return;
    L18:
        return;
    L17:
        return;
    L13:
        d4(1);
        return;
    L16:
        return;
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void V3() {
        String r0 = this.p;
        if (r0 == null) goto L6;
        ConcurrentHashMap<String, CountDownTimer> r1 = com.obric.assistant.card.manager.a.a;
        Intrinsics.checkNotNullParameter(r0, "messageId");
        com.obric.assistant.card.manager.a.c.remove(r0);
        return;
    }

    public final void b4() {
        if (this.l != null) goto L12;
        ViewStub r0 = (ViewStub) ((ObricCardItemStyleIconContentBinding) this.a).e.findViewById(2131365006);
        if (r0 == null) goto L7;
        this.l = r0.inflate();
    L8:
        View r1 = this.l;
        if (r1 == null) goto L13;
        this.m = (TextView) r1.findViewById(2131364828);
        this.n = (TextView) r1.findViewById(2131364673);
        this.o = (TextView) r1.findViewById(2131391507);
        return;
    L13:
        return;
    L7:
        this.l = ((ObricCardItemStyleIconContentBinding) this.a).e.findViewById(2131365005);
        goto L8
    }

    public final void c4() {
        View r0 = ((ObricCardItemStyleIconContentBinding) this.a).e.findViewById(2131367812);
        if (r0 == null) goto L6;
        r0.setAlpha(1.0f);
        return;
    }

    public LarkMessageViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
        this.q = -1;
        this.r = new b(this);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemIconContentStyle
    public final AbsCardItemIconContentStyle.a a4(Object r7) {
        MessageEntity r8 = (MessageEntity) r7;
        Intrinsics.checkNotNullParameter(r8, "entity");
        GroupChatEntity r0 = r8.getGroupChat();
        String r2 = null;
        if (r0 == null) goto L8;
        FileEntity r1 = r0.getAvatar();
        if (r1 == null) goto L8;
        Uri r3 = r1.getContentUrl();
        if (r3 == null) goto L8;
    L16:
        if (r3 == null) goto L18;
        int r4 = PrivilegedUriProvider.b;
        Uri r5 = PrivilegedUriProvider.a.a(r3, r8.getPackageName(), false, false);
    L19:
        GroupChatEntity r6 = r8.getGroupChat();
        if (r6 == null) goto L25;
        String r9 = r6.getName();
        if (r9 == null) goto L25;
        r2 = r9;
    L30:
        lca.a r10 = new lca.a(2131244449, r5, 4);
        if (r2 != null) goto L34;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L34:
        return new AbsCardItemIconContentStyle.a(r10, r2, "我: " + r8.getText());
    L25:
        List r11 = r8.getContacts();
        if (r11 == null) goto L30;
        ContactEntity r12 = (ContactEntity) CollectionsKt.getOrNull(r11, 0);
        if (r12 == null) goto L30;
        r2 = r12.getName();
        goto L30
    L18:
        r5 = null;
    L8:
        List r13 = r8.getContacts();
        if (r13 == null) goto L15;
        ContactEntity r14 = (ContactEntity) CollectionsKt.getOrNull(r13, 0);
        if (r14 == null) goto L15;
        FileEntity r15 = r14.getAvatar();
        if (r15 == null) goto L15;
        r3 = r15.getContentUrl();
    L15:
        r3 = null;
        goto L16
    }

    public final void d4(int r5) {
        this.q = r5;
        if (r5 != (-1)) goto L9;
        View r6 = this.l;
        if (r6 == null) goto L7;
        r6.setVisibility(8);
    L7:
        c4();
        return;
    L9:
        b4();
        if (r5 == 0) goto L52;
        if (r5 != 1) goto L13;
        View r7 = this.l;
        if (r7 == null) goto L39;
        r7.setVisibility(0);
    L39:
        TextView r8 = this.n;
        if (r8 == null) goto L42;
        r8.setVisibility(8);
    L42:
        TextView r9 = this.m;
        if (r9 == null) goto L45;
        r9.setVisibility(8);
    L45:
        TextView r10 = this.o;
        if (r10 == null) goto L48;
        r10.setVisibility(0);
    L48:
        TextView r11 = this.o;
        if (r11 == null) goto L51;
        r11.setText(((RecyclerView.ViewHolder) this).itemView.getContext().getString(2131912006));
    L51:
        c4();
        return;
    L13:
        if (r5 == 2) goto L18;
        View r12 = this.l;
        if (r12 == null) goto L17;
        r12.setVisibility(8);
    L17:
        c4();
        return;
    L18:
        View r13 = this.l;
        if (r13 == null) goto L21;
        r13.setVisibility(0);
    L21:
        TextView r14 = this.n;
        if (r14 == null) goto L24;
        r14.setVisibility(8);
    L24:
        TextView r15 = this.m;
        if (r15 == null) goto L27;
        r15.setVisibility(8);
    L27:
        TextView r16 = this.o;
        if (r16 == null) goto L30;
        r16.setVisibility(0);
    L30:
        TextView r17 = this.o;
        if (r17 == null) goto L33;
        r17.setText(((RecyclerView.ViewHolder) this).itemView.getContext().getString(2131912004));
    L33:
        View r18 = ((ObricCardItemStyleIconContentBinding) this.a).e.findViewById(2131367812);
        if (r18 == null) goto L73;
        r18.setAlpha(0.3f);
        return;
    L73:
        return;
    L52:
        View r19 = this.l;
        if (r19 == null) goto L55;
        r19.setVisibility(0);
    L55:
        TextView r20 = this.n;
        if (r20 == null) goto L58;
        r20.setVisibility(0);
    L58:
        TextView r21 = this.m;
        if (r21 == null) goto L61;
        r21.setVisibility(0);
    L61:
        TextView r22 = this.o;
        if (r22 == null) goto L64;
        r22.setVisibility(8);
    L64:
        TextView r23 = this.m;
        if (r23 == null) goto L67;
        r23.setText(((RecyclerView.ViewHolder) this).itemView.getContext().getString(2131912005, new Object[]{4}));
    L67:
        TextView r24 = this.n;
        if (r24 == null) goto L70;
        r24.setText(((RecyclerView.ViewHolder) this).itemView.getContext().getString(2131912003));
    L70:
        c4();
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemIconContentStyle, com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r7, Object r8, int r9, boolean r10, boolean r11) {
        MessageEntity r12 = (MessageEntity) r8;
        Intrinsics.checkNotNullParameter(r7, "messageExtra");
        Intrinsics.checkNotNullParameter(r12, "entity");
        super.T3(r7, r12, r9, r10, r11);
        String r13 = this.p;
        if (r13 != null) goto L5;
    L7:
        ConcurrentHashMap<String, CountDownTimer> r14 = com.obric.assistant.card.manager.a.a;
        String r15 = r7.e;
        Intrinsics.checkNotNullParameter(r15, "messageId");
        Integer r16 = com.obric.assistant.card.manager.a.e.get(r15);
        if (r16 == null) goto L11;
        String r17 = r16.toString();
        if (r17 == null) goto L11;
    L20:
        if (r17 == null) goto L22;
        int r18 = CastIntegerProtector.parseInt(r17);
    L23:
        final String r19 = r7.e;
        this.p = r19;
        d4(r18);
        if (r18 != 0) goto L36;
        b4();
        com.obric.assistant.card.manager.a.a(r19, this.r);
        Intrinsics.checkNotNullParameter(r19, "messageId");
        Long r20 = com.obric.assistant.card.manager.a.b.get(r19);
        if (r20 == null) goto L30;
        TextView r110 = this.m;
        if (r110 == null) goto L30;
        r110.setText(((RecyclerView.ViewHolder) this).itemView.getContext().getString(2131912005, new Object[]{Long.valueOf((r20.longValue() / ((long) 1000)) + 1)}));
    L30:
        TextView r21 = this.n;
        if (r21 == null) goto L33;
        e1.d(r21, new g(r19, this));
    L33:
        TextView r22 = this.m;
        if (r22 == null) goto L43;
        e1.d(r22, new h(r19, this));
    L43:
        TextView r23 = ((ObricCardItemStyleIconContentBinding) this.a).b;
        r23.setText(StringsKt.replace$default("我: " + r12.getText(), "\n", NameKeys.UnloadStrategy_No_Strategy, false, 4, null));
        r23.setMaxLines(3);
        r23.setEllipsize(TextUtils.TruncateAt.END);
        return;
    L36:
        TextView r24 = this.n;
        if (r24 == null) goto L39;
        r24.setOnClickListener(null);
    L39:
        TextView r25 = this.m;
        if (r25 == null) goto L42;
        r25.setOnClickListener(null);
    L42:
        Intrinsics.checkNotNullParameter(r19, "messageId");
        com.obric.assistant.card.manager.a.c.remove(r19);
        goto L43
    L22:
        r18 = -1;
    L11:
        Map<String, String> r26 = r7.g;
        if (r26 == null) goto L14;
        r17 = r26.get("lark_message_card_status");
    L15:
        if (r17 != null) goto L20;
        Map<String, String> r27 = r7.f;
        if (r27 == null) goto L19;
        r17 = r27.get("lark_message_card_status");
        goto L20
    L19:
        r17 = null;
        goto L20
    L14:
        r17 = null;
        goto L15
    L5:
        if (Intrinsics.areEqual(r13, r7.e) == true) goto L7;
        ConcurrentHashMap<String, CountDownTimer> r111 = com.obric.assistant.card.manager.a.a;
        Intrinsics.checkNotNullParameter(r13, "messageId");
        com.obric.assistant.card.manager.a.c.remove(r13);
        goto L7
    }
}
