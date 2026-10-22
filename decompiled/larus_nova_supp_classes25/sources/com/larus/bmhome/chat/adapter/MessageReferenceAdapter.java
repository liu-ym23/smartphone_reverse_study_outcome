package com.larus.bmhome.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00039:;B¥\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\u001e\b\u0002\u0010\u0015\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0017\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001e\u001a\u00020\u000b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\nH\u0016J\u0018\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\nH\u0016J4\u0010(\u001a\u00020\u000b2\n\u0010&\u001a\u00060)R\u00020\u00002\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0002JD\u0010-\u001a\u00020\u000b2\n\u0010&\u001a\u00060.R\u00020\u00002\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0010H\u0003J\u000e\u00101\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004J\b\u00102\u001a\u00020\nH\u0016J#\u00103\u001a\u00020\u000b2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u0007052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0016J\u0006\u00108\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0017\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/bmhome/chat/adapter/MessageReferenceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "showItemIcon", "", "textList", "", "", "onClickItem", "Lkotlin/Function1;", "", "", "context", "Landroid/content/Context;", "isDeepThinkingShow", "chatType", "", "isThinkReference", "hideExpandText", "onExpand", "expandMaxNum", "mobParams", "Lkotlin/Function0;", "", "<init>", "(ZLjava/util/List;Lkotlin/jvm/functions/Function1;Landroid/content/Context;ZLjava/lang/String;ZZLkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function0;)V", "isListFold", "serverFirstIndex", "SOURCE_ITEM_TYPE_NORMAL", "SOURCE_ITEM_TYPE_EXPAND", "updateListFoldState", "foldState", "(Ljava/lang/Boolean;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "bindExpandData", "Lcom/larus/bmhome/chat/adapter/MessageReferenceAdapter$ExpandSourceViewHolder;", "title", "url", "index", "bindData", "Lcom/larus/bmhome/chat/adapter/MessageReferenceAdapter$SourceViewHolder;", "docId", "iconURL", "notifyLastItemChanged", "getItemCount", "setList", "list", "", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getItemViewType", "getListFoldState", "Companion", "SourceViewHolder", "ExpandSourceViewHolder", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageReferenceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int o = 0;
    public final boolean a;
    public final List<Object> b;
    public final Function1<Integer, Unit> c;
    public final Context d;
    public final boolean e;
    public final String f;
    public final boolean g;
    public boolean h;
    public final Function1<Boolean, Unit> i;
    public final int j;
    public final Function0<Map<String, String>> k;
    public boolean l;
    public int m;
    public final int n;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/adapter/MessageReferenceAdapter$ExpandSourceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/chat/adapter/MessageReferenceAdapter;Landroid/view/View;)V", "tvContent", "Landroid/widget/TextView;", "getTvContent", "()Landroid/widget/TextView;", "tvIndex", "getTvIndex", "llSourceItem", "Landroid/widget/LinearLayout;", "getLlSourceItem", "()Landroid/widget/LinearLayout;", "tvSourceExpandView", "getTvSourceExpandView", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public final class ExpandSourceViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final LinearLayout c;
        public final TextView d;

        public ExpandSourceViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131391263);
            this.b = (TextView) r2.findViewById(2131391265);
            this.c = (LinearLayout) r2.findViewById(2131378882);
            this.d = (TextView) r2.findViewById(2131391494);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/adapter/MessageReferenceAdapter$SourceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/chat/adapter/MessageReferenceAdapter;Landroid/view/View;)V", "tvContent", "Landroid/widget/TextView;", "getTvContent", "()Landroid/widget/TextView;", "tvIndex", "getTvIndex", "itemIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getItemIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public final class SourceViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final SimpleDraweeView c;

        public SourceViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131391263);
            this.b = (TextView) r2.findViewById(2131391265);
            this.c = r2.findViewById(2131375773);
        }
    }

    public static final class a {
        public a() {
        }

        public static Map a(String r3, String r4, String r5) {
            int r0 = MessageReferenceAdapter.o;
            Map r1 = MapsKt.emptyMap();
            Intrinsics.checkNotNullParameter(r1, "extraParams");
            LinkedHashMap r2 = new LinkedHashMap();
            r2.put("conversation_id", r3);
            r2.put("message_id", r4);
            r2.put("bot_id", r5);
            r2.putAll(r1);
            return r2;
        }
    }

    static {
        new a();
    }

    public final int getItemCount() {
        if (this.l == false) goto L6;
        return Math.min(this.j, this.b.size());
    L6:
        return this.b.size();
    }

    public final int getItemViewType(int r2) {
        if (this.l == true) goto L5;
    L7:
        return 0;
    L5:
        if (r2 != (this.j - 1)) goto L7;
        return this.n;
    }

    public final void y2(Boolean r2) {
        if (r2 == null) goto L6;
        this.l = r2.booleanValue();
        return;
    L6:
        if (this.g == false) goto L8;
    L12:
        boolean r3 = false;
    L13:
        this.l = r3;
        return;
    L8:
        if (this.e == false) goto L12;
        if (this.b.size() <= this.j) goto L12;
        r3 = true;
        goto L13
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r25, final int r26) {
        Intrinsics.checkNotNullParameter(r25, "holder");
        int r3 = 0;
        if ((ListProtector.get(this.b, r26) instanceof TextCard) == false) goto L35;
        Object r1 = ListProtector.get(this.b, r26);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larus.im.bean.message.TextCard");
        String r2 = ((TextCard) r1).getTitle();
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        Object r8 = ListProtector.get(this.b, r26);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.larus.im.bean.message.TextCard");
        String r9 = ((TextCard) r8).getUrl();
        if (r9 != null) goto L10;
        r9 = "";
    L10:
        Object r10 = ListProtector.get(this.b, r26);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.larus.im.bean.message.TextCard");
        Integer r11 = ((TextCard) r10).getIndex();
        if (r11 == null) goto L13;
        int r12 = r11.intValue();
    L14:
        Object r13 = ListProtector.get(this.b, r26);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.larus.im.bean.message.TextCard");
        String r7 = ((TextCard) r13).getDocId();
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        boolean r14 = v19.h.a;
        if (v19.h.b(this.d) == false) goto L27;
        Object r15 = ListProtector.get(this.b, r26);
        if ((r15 instanceof TextCard) == false) goto L22;
        TextCard r16 = (TextCard) r15;
    L23:
        if (r16 == null) goto L48;
        String r17 = r16.getIconUrlDark();
        if (r17 == null) goto L48;
    L49:
        if (r26 != 0) goto L52;
        this.m = r12;
    L52:
        if ((r25 instanceof SourceViewHolder) == false) goto L100;
        final SourceViewHolder r0 = (SourceViewHolder) r25;
        Context r5 = this.d;
        final int r4 = ContextCompat.getColor(r5, v19.c.b(2130970957, r5, 2131102626));
        Context r6 = this.d;
        final int r18 = ContextCompat.getColor(r6, v19.c.b(2130973613, r6, 2131105594));
        r0.a.setOnTouchListener(new k0(r0, r18, r4));
        if (this.a == false) goto L56;
        e1.x(r0.c);
        ImageLoaderKt.u(r0.c, r17, "cot_icon");
        e1.o(r0.b);
    L57:
        TextView r19 = r0.b;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if (r20 == null) goto L98;
        int r110 = this.m;
        if (r110 <= 0) goto L62;
        int r111 = (r110 - 1) + this.b.size();
    L63:
        if (r111 >= 10) goto L65;
        float r112 = we8.a.a(i5.o(), false);
    L68:
        r20.width = (int) r112;
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == false) goto L71;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r20;
    L72:
        if (r113 != null) goto L74;
    L78:
        r19.setLayoutParams(r20);
        StringBuilder r21 = new StringBuilder();
        if (this.m <= 0) goto L81;
        StringBuilder r114 = new StringBuilder();
    L82:
        r114.append(r12);
        r114.append('.');
        r21.append(r114.toString());
        r19.setText(r21.toString());
        we8.a.b(r19, i5.o(), false, null, null, 12);
        final TextView r22 = r0.a;
        r22.setText(r2);
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L96;
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L87;
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
    L88:
        if (r24 != null) goto L90;
    L94:
        r22.setLayoutParams(r23);
        we8.a.b(r22, i5.o(), false, null, null, 12);
        final String r27 = r9;
        final String r28 = r7;
        e1.d(r22, new l0(this, r27, r22, r26, r28));
        return;
    L90:
        if (this.g == true) goto L93;
        r3 = i5.q();
    L93:
        r24.setMarginEnd(r3);
        goto L94
    L87:
        r24 = null;
        goto L88
    L96:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L81:
        r114 = new StringBuilder();
        r12 = r26 + 1;
        goto L82
    L74:
        if (this.g == false) goto L76;
        int r115 = 0;
    L77:
        r113.setMarginStart(r115);
        goto L78
    L76:
        r115 = i5.q();
        goto L77
    L71:
        r113 = null;
        goto L72
    L65:
        if (r111 >= 100) goto L67;
        r112 = we8.a.a(((Number) i5.A.getValue()).intValue(), false);
        goto L68
    L67:
        r112 = we8.a.a(((Number) i5.J.getValue()).intValue(), false);
        goto L68
    L62:
        r111 = this.b.size();
        goto L63
    L98:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L56:
        e1.o(r0.c);
        e1.x(r0.b);
        goto L57
    L100:
        if ((r25 instanceof ExpandSourceViewHolder) == false) goto L123;
        final ExpandSourceViewHolder r29 = (ExpandSourceViewHolder) r25;
        TextView r30 = r29.b;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        if (r31 == null) goto L121;
        int r32 = this.m;
        if (r32 <= 0) goto L106;
        int r33 = (r32 - 1) + this.b.size();
    L107:
        if (r33 >= 10) goto L109;
        float r34 = we8.a.a(i5.o(), false);
    L112:
        r31.width = (int) r34;
        r30.setLayoutParams(r31);
        StringBuilder r35 = new StringBuilder();
        if (this.m <= 0) goto L115;
        StringBuilder r36 = new StringBuilder();
    L116:
        r36.append(r12);
        r36.append('.');
        r35.append(r36.toString());
        r30.setText(r35.toString());
        r29.a.setText(r2);
        we8.a.b(r29.a, i5.o(), false, null, null, 12);
        we8.a.b(r29.b, i5.o(), false, null, null, 12);
        we8.a.b(r29.d, i5.o(), false, null, null, 12);
        ViewGroup.LayoutParams r37 = r29.d.getLayoutParams();
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r38 = (ViewGroup.MarginLayoutParams) r37;
        r38.topMargin = -i5.h();
        r38.bottomMargin = i5.N();
        r29.d.setLayoutParams(r38);
        if (this.h == false) goto L119;
        r29.d.setText("");
    L119:
        r29.c.post(new m0(r29));
        e1.d(r29.c, new n0(this));
        return;
    L115:
        r12 = r26 + 1;
        r36 = new StringBuilder();
        goto L116
    L109:
        if (r33 >= 100) goto L111;
        r34 = we8.a.a(((Number) i5.A.getValue()).intValue(), false);
        goto L112
    L111:
        r34 = we8.a.a(((Number) i5.J.getValue()).intValue(), false);
        goto L112
    L106:
        r33 = this.b.size();
        goto L107
    L121:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L123:
        return;
    L48:
        r17 = "";
        goto L49
    L22:
        r16 = null;
        goto L23
    L27:
        Object r116 = ListProtector.get(this.b, r26);
        if ((r116 instanceof TextCard) == false) goto L30;
        TextCard r117 = (TextCard) r116;
    L31:
        if (r117 == null) goto L48;
        r17 = r117.getIconUrl();
        if (r17 != null) goto L49;
    L30:
        r117 = null;
        goto L31
    L13:
        r12 = 0;
        goto L14
    L35:
        Object r39 = ListProtector.get(this.b, r26);
        Intrinsics.checkNotNull(r39, "null cannot be cast to non-null type com.larus.im.bean.message.VideoCard");
        r2 = ((VideoCard) r39).getVideoCaptions();
        if (r2 != null) goto L38;
        r2 = "";
    L38:
        Object r40 = ListProtector.get(this.b, r26);
        Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type com.larus.im.bean.message.VideoCard");
        r9 = ((VideoCard) r40).getMainSiteUrl();
        if (r9 != null) goto L41;
        r9 = "";
    L41:
        Object r41 = ListProtector.get(this.b, r26);
        Intrinsics.checkNotNull(r41, "null cannot be cast to non-null type com.larus.im.bean.message.VideoCard");
        Integer r42 = ((VideoCard) r41).getIndex();
        if (r42 == null) goto L44;
        r12 = r42.intValue();
    L45:
        Object r118 = ListProtector.get(this.b, r26);
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type com.larus.im.bean.message.VideoCard");
        r7 = ((VideoCard) r118).getItemId();
        if (r7 != null) goto L48;
        r7 = "";
        goto L48
    L44:
        r12 = 0;
        goto L45
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 0) goto L6;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562662, r3, false);
        Intrinsics.checkNotNull(r5);
        return new SourceViewHolder(r5);
    L6:
        View r6 = LayoutInflater.from(r3.getContext()).inflate(2131562661, r3, false);
        Intrinsics.checkNotNull(r6);
        return new ExpandSourceViewHolder(r6);
    }

    public /* synthetic */ MessageReferenceAdapter(boolean r13, List r14, Function1 r15, Context r16, boolean r17, String r18, boolean r19, boolean r20, Function0 r21) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, null, 4, r21);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageReferenceAdapter(boolean r2, List<Object> r3, Function1<? super Integer, Unit> r4, Context r5, boolean r6, String r7, boolean r8, boolean r9, Function1<? super Boolean, Unit> r10, int r11, Function0<? extends Map<String, String>> r12) {
        Intrinsics.checkNotNullParameter(r3, "textList");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.n = 1;
        y2(null);
    }
}
