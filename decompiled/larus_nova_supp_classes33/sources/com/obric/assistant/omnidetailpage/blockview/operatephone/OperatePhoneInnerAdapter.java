package com.obric.assistant.omnidetailpage.blockview.operatephone;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.component.share.g1;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.chat.layout.widget.handler.e;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common_ui.widget.TagTextView;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OHistoryGui;
import com.larus.im.bean.message.block.OHistoryGuiSteps;
import com.larus.im.bean.message.block.OOmniDetailGUIProcessBlock;
import com.larus.utils.e1;
import com.obric.assistant.card.databinding.ObricOmniBlockOperatePhoneInnerBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.omnidetailpage.util.OmniPageUtil;
import hfa.a;
import hfa.b;
import hfa.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import lw8.d;
import lw8.l;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB?\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\f\u0010\rJ@\u0010\u0013\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/operatephone/OperatePhoneInnerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/assistant/omnidetailpage/blockview/operatephone/OperatePhoneInnerAdapter$InnerViewHolder;", "items", "", "Lcom/larus/im/bean/message/block/OHistoryGui;", "onItemClick", "Lkotlin/Function1;", "", "", "instructionTypeProvider", "Lkotlin/Function0;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "needShowCurrent", "", "block", "Lcom/larus/im/bean/message/block/Block;", "shouldShowAnim", "updateData", "newItems", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "InnerViewHolder", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperatePhoneInnerAdapter extends RecyclerView.Adapter<InnerViewHolder> {
    public List<OHistoryGui> a;
    public final Function1<String, Unit> b;
    public Function0<String> c;
    public boolean d;
    public Block e;
    public boolean f;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJB\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J \u0010\u0015\u001a\u00020\u00062\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/operatephone/OperatePhoneInnerAdapter$InnerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockOperatePhoneInnerBinding;", "onItemClick", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/obric/assistant/card/databinding/ObricOmniBlockOperatePhoneInnerBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "Lcom/larus/im/bean/message/block/OHistoryGui;", "isLastHolder", "", "block", "Lcom/larus/im/bean/message/block/Block;", "needShowCurrent", "shouldShowAnim", "instructionTypeProvider", "Lkotlin/Function0;", "generateHistory", "historyGuiSteps", "", "Lcom/larus/im/bean/message/block/OHistoryGuiSteps;", "noLast", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InnerViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final ObricOmniBlockOperatePhoneInnerBinding a;
        public final Function1<String, Unit> b;

        public static DisplayMetrics T3(Resources r1) {
            return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public InnerViewHolder(ObricOmniBlockOperatePhoneInnerBinding r2, Function1<? super String, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            Intrinsics.checkNotNullParameter(r3, "onItemClick");
            super(r2.a);
            this.a = r2;
            this.b = r3;
        }
    }

    public OperatePhoneInnerAdapter() {
        this(null, 7);
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public OperatePhoneInnerAdapter(c r4, int r5) {
        g1 r1 = null;
        if ((r5 & 1) == 0) goto L5;
        List<OHistoryGui> r0 = CollectionsKt.emptyList();
    L6:
        Function1<String, Unit> r6 = r4;
        if ((r5 & 2) == 0) goto L10;
        r6 = new a();
    L10:
        if ((r5 & 4) == 0) goto L12;
        r1 = new g1();
    L12:
        Intrinsics.checkNotNullParameter(r0, "items");
        Intrinsics.checkNotNullParameter(r6, "onItemClick");
        Intrinsics.checkNotNullParameter(r1, "instructionTypeProvider");
        this.a = r0;
        this.b = r6;
        this.c = r1;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r48, int r49) {
        final InnerViewHolder r2 = (InnerViewHolder) r48;
        Intrinsics.checkNotNullParameter(r2, "holder");
        OHistoryGui r3 = (OHistoryGui) ListProtector.get(this.a, r49);
        if (r49 != (getItemCount() - 1)) goto L5;
        boolean r1 = true;
    L6:
        final Block r4 = this.e;
        boolean r7 = this.d;
        final boolean r8 = this.f;
        final Function0<String> r9 = this.c;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "instructionTypeProvider");
        if (r3 == null) goto L182;
        String r10 = r3.getPackageName();
        if (r10 != null) goto L11;
        r10 = "";
    L11:
        PackageManager r12 = r2.a.a.getContext().getPackageManager();
        ConcurrentHashMap<String, Pair<Drawable, String>> r13 = OmniPageUtil.a;
        Intrinsics.checkNotNull(r12);
        Pair r11 = OmniPageUtil.b(r10, r12, r2.a.a.getContext(), false);
        if (r11.getFirst() == null) goto L14;
        r2.a.g.setImageDrawable((Drawable) r11.getFirst());
        r2.a.g.setBackground(null);
    L14:
        r2.a.h.setText((CharSequence) r11.getSecond());
        String r14 = r3.getChangePackageTag();
        if (r14 != null) goto L17;
        r14 = "";
    L17:
        TagTextView r15 = r2.a.i;
        if (r14.length() <= 0) goto L20;
        boolean r16 = true;
    L21:
        if (r16 == false) goto L23;
        int r17 = 0;
    L24:
        r15.setVisibility(r17);
        if (r14.length() <= 0) goto L27;
        boolean r18 = true;
    L28:
        if (r18 == false) goto L32;
        r2.a.i.x(r14, TagTextView.TagStyle.BLUE);
        float r19 = 6;
        float r6 = 4;
        r2.a.i.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r19, InnerViewHolder.T3(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r6, InnerViewHolder.T3(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r19, InnerViewHolder.T3(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r6, InnerViewHolder.T3(Resources.getSystem()))));
    L32:
        if (r11.getFirst() == null) goto L34;
    L45:
        boolean r0 = true;
    L46:
        LinearLayout r20 = r2.a.b;
        if (r0 == false) goto L49;
        int r110 = 0;
    L50:
        r20.setVisibility(r110);
        List r5 = r3.getHistoryGuiSteps();
        if (r1 == false) goto L54;
        if (r7 == false) goto L54;
        boolean r21 = true;
    L55:
        StringBuilder r111 = new StringBuilder();
        List r112 = r5;
        if (r112 != null) goto L58;
    L61:
        boolean r113 = true;
    L62:
        if (r113 == false) goto L65;
        String r22 = "";
    L100:
        if (r22.length() <= 0) goto L102;
        boolean r23 = true;
    L104:
        if (r23 == false) goto L135;
        r2.a.f.setVisibility(0);
        r2.a.j.setVisibility(0);
        ObricOmniBlockOperatePhoneInnerBinding r24 = r2.a;
        r24.j.setMarkdownWidth(InnerViewHolder.T3(r24.a.getContext().getResources()).widthPixels - MathKt.roundToInt(TypedValue.applyDimension(1, 80, InnerViewHolder.T3(Resources.getSystem()))));
        gw8.c.a.getClass();
        gw8.c r25 = gw8.c.a.b();
        if (r25 == null) goto L108;
        l r26 = gw8.c.b.b(r25, r2.a.j, r22, true, new d(0, null, null, false, Integer.valueOf(r2.a.j.getCurrentTextColor()), 0, Float.valueOf(1.0f), 0.0f, Float.valueOf(1.0f), 0, 0, Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 8, InnerViewHolder.T3(Resources.getSystem())))), null, null, null, null, null, null, null, null, null, null, null, null, -39489, 31));
    L109:
        CustomMarkdownTextView r27 = r2.a.j;
        if (r4 == null) goto L112;
        String r28 = r4.getBlockId();
    L113:
        if (r28 != null) goto L115;
        r28 = r11;
    L115:
        e.b(r27, "obric_omni_detail_block_id", r28);
        r2.a.j.setMarkdown(r26);
        ShimmerLinearLayout r29 = r2.a.d;
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        if (r30 == null) goto L134;
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        r31.topMargin = i5.Y();
        r29.setLayoutParams(r31);
        LinearLayout r32 = r2.a.e;
        if (r0 == true) goto L128;
        if (r4 == null) goto L125;
        BlockContent r33 = r4.getContent();
        if (r33 == null) goto L125;
        OOmniDetailGUIProcessBlock r34 = r33.getOOmniDetailGUIBlock();
        if (r34 == null) goto L125;
        boolean r35 = Intrinsics.areEqual(r34.getForceExpand(), Boolean.TRUE);
    L126:
        if (r35 == false) goto L128;
        boolean r36 = true;
    L129:
        if (r36 == false) goto L131;
        int r37 = 8;
    L132:
        r32.setVisibility(r37);
    L138:
        e1.d(r2.a.c, new b(r8, r4, r2, r9));
        if (r1 == false) goto L179;
        if (r7 == false) goto L179;
        if (r4 == null) goto L155;
        BlockContent r38 = r4.getContent();
        if (r38 == null) goto L155;
        OOmniDetailGUIProcessBlock r39 = r38.getOOmniDetailGUIBlock();
        if (r39 == null) goto L155;
        String r40 = r39.getNowProcessContent();
        if (r40 == null) goto L155;
        if (r40.length() <= 0) goto L151;
        boolean r41 = true;
    L153:
        if (r41 != true) goto L155;
        boolean r42 = true;
    L156:
        if (r42 == false) goto L179;
        r2.a.c.setVisibility(0);
        ObricOmniBlockOperatePhoneInnerBinding r43 = r2.a;
        r43.c.setMarkdownWidth(InnerViewHolder.T3(r43.a.getContext().getResources()).widthPixels - MathKt.roundToInt(TypedValue.applyDimension(1, 80, InnerViewHolder.T3(Resources.getSystem()))));
        gw8.c.a.getClass();
        gw8.c r44 = gw8.c.a.b();
        if (r44 == null) goto L168;
        CustomMarkdownTextView r45 = r2.a.c;
        BlockContent r46 = r4.getContent();
        if (r46 == null) goto L164;
        OOmniDetailGUIProcessBlock r47 = r46.getOOmniDetailGUIBlock();
        if (r47 == null) goto L164;
        String r50 = r47.getNowProcessContent();
    L165:
        if (r50 != null) goto L167;
        r50 = r11;
    L167:
        l r51 = gw8.c.b.b(r44, r45, r50, true, new d(0, null, null, false, Integer.valueOf(r2.a.c.getCurrentTextColor()), 0, Float.valueOf(1.0f), 0.0f, Float.valueOf(1.0f), 0, 0, Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 8, InnerViewHolder.T3(Resources.getSystem())))), null, null, null, null, null, null, null, null, null, null, null, null, -39489, 31));
    L169:
        CustomMarkdownTextView r52 = r2.a.c;
        String r53 = r4.getBlockId();
        if (r53 != null) goto L172;
        r53 = r11;
    L172:
        e.b(r52, "obric_omni_detail_block_id", r53);
        r2.a.c.setMarkdown(r51);
        r2.a.f.setVisibility(0);
        r2.a.d.setVisibility(0);
        boolean r54 = h.a;
        if (h.a(null) == false) goto L175;
        ObricOmniBlockOperatePhoneInnerBinding r55 = r2.a;
        r55.d.setShimmerColor(ContextCompat.getColor(r55.a.getContext(), 2131100494));
    L176:
        if (r8 == false) goto L178;
        r2.a.d.b();
        return;
    L178:
        r2.a.d.a();
        return;
    L175:
        ObricOmniBlockOperatePhoneInnerBinding r56 = r2.a;
        r56.d.setShimmerColor(ContextCompat.getColor(r56.a.getContext(), 2131100492));
    L164:
        r50 = null;
        goto L165
    L168:
        r51 = null;
        goto L169
    L151:
        r41 = false;
    L155:
        r42 = false;
    L179:
        r2.a.d.setVisibility(8);
        r2.a.d.a();
        return;
    L131:
        r37 = 0;
    L125:
        r35 = false;
    L128:
        r36 = false;
        goto L129
    L134:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L112:
        r28 = null;
        goto L113
    L108:
        r26 = null;
        goto L109
    L135:
        r2.a.f.setVisibility(8);
        r2.a.j.setVisibility(8);
        ShimmerLinearLayout r57 = r2.a.d;
        ViewGroup.LayoutParams r58 = r57.getLayoutParams();
        if (r58 == null) goto L181;
        ViewGroup.MarginLayoutParams r59 = (ViewGroup.MarginLayoutParams) r58;
        r59.topMargin = 0;
        r57.setLayoutParams(r59);
        goto L138
    L181:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L102:
        r23 = false;
        goto L104
    L65:
        if (r21 == false) goto L83;
        Iterator r60 = r5.iterator();
        int r114 = 0;
    L68:
        if (r60.hasNext() == false) goto L98;
        Object r115 = r60.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L72;
        CollectionsKt.throwIndexOverflow();
    L72:
        OHistoryGuiSteps r117 = (OHistoryGuiSteps) r115;
        if (r114 == CollectionsKt.getLastIndex(r5)) goto L82;
        if (r117 == null) goto L82;
        String r118 = r117.getHistoryGuiSteps();
        if (r118 == null) goto L82;
        if (r114 >= (CollectionsKt.getLastIndex(r5) - 1)) goto L81;
        r111.append(r118.concat("\n\n"));
        goto L82
    L81:
        r111.append(r118);
    L82:
        r114 = r116;
    L98:
        r22 = r111.toString();
        goto L100
    L83:
        Iterator r61 = r5.iterator();
        int r119 = 0;
    L85:
        if (r61.hasNext() == false) goto L98;
        Object r120 = r61.next();
        int r121 = r119 + 1;
        if (r119 >= 0) goto L89;
        CollectionsKt.throwIndexOverflow();
    L89:
        OHistoryGuiSteps r122 = (OHistoryGuiSteps) r120;
        if (r122 == null) goto L97;
        String r123 = r122.getHistoryGuiSteps();
        if (r123 == null) goto L97;
        if (r119 >= CollectionsKt.getLastIndex(r5)) goto L96;
        r111.append(r123.concat("\n\n"));
        goto L97
    L96:
        r111.append(r123);
    L97:
        r119 = r121;
        goto L85
    L58:
        if (r112.isEmpty() == true) goto L61;
        r113 = false;
    L54:
        r21 = false;
        goto L55
    L49:
        r110 = 8;
        goto L50
    L34:
        if (((CharSequence) r11.getSecond()).length() <= 0) goto L36;
        boolean r62 = true;
    L37:
        if (r62 == true) goto L45;
        if (r14.length() <= 0) goto L41;
        boolean r63 = true;
    L42:
        if (r63 == true) goto L45;
        r0 = false;
        goto L46
    L41:
        r63 = false;
        goto L42
    L36:
        r62 = false;
        goto L37
    L27:
        r18 = false;
        goto L28
    L23:
        r17 = 8;
        goto L24
    L20:
        r16 = false;
        goto L21
    L182:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        View r15 = LayoutInflater.from(r13.getContext()).inflate(2131564040, r13, false);
        int r16 = 2131363084;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131363084);
        if (r3 == null) goto L25;
        r16 = 2131368330;
        CustomMarkdownTextView r4 = ViewBindings.findChildViewById(r15, 2131368330);
        if (r4 == null) goto L25;
        r16 = 2131368331;
        ShimmerLinearLayout r5 = ViewBindings.findChildViewById(r15, 2131368331);
        if (r5 == null) goto L25;
        r16 = 2131369202;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131369202);
        if (r6 == null) goto L25;
        r16 = 2131374384;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131374384);
        if (r7 == null) goto L25;
        r16 = 2131375897;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r15, 2131375897);
        if (r8 == null) goto L25;
        r16 = 2131384507;
        if (ViewBindings.findChildViewById(r15, 2131384507) == null) goto L25;
        r16 = 2131389997;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, 2131389997);
        if (r9 == null) goto L25;
        r16 = 2131389998;
        TagTextView r10 = ViewBindings.findChildViewById(r15, 2131389998);
        if (r10 == null) goto L25;
        r16 = 2131390076;
        CustomMarkdownTextView r11 = ViewBindings.findChildViewById(r15, 2131390076);
        if (r11 == null) goto L25;
        return new InnerViewHolder(new ObricOmniBlockOperatePhoneInnerBinding((LinearLayout) r15, r3, r4, r5, r6, r7, r8, r9, r10, r11), this.b);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }
}
