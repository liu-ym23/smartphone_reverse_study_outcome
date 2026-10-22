package com.larus.bmhome.chat.deepresearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.component.r;
import com.larus.bmhome.chat.deepresearch.view.MarkdownIconTextBlockView;
import com.larus.bmhome.chat.deepresearch.view.ReferenceListBlockView;
import com.larus.bmhome.chat.deepresearch.view.d0;
import com.larus.bmhome.chat.deepresearch.view.i;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.bmhome.chat.deepresearch.view.j2;
import com.larus.bmhome.chat.deepresearch.view.k;
import com.larus.bmhome.chat.deepresearch.view.n2;
import com.larus.bmhome.chat.deepresearch.view.t2;
import com.larus.bmhome.chat.deepresearch.view.v;
import com.larus.bmhome.chat.deepresearch.viewholder.AbsDeepResearchViewHolder;
import com.larus.bmhome.chat.deepresearch.viewholder.DeepResearchBannerViewHolder;
import com.larus.bmhome.chat.deepresearch.viewholder.DeepResearchEmptyViewHolder;
import com.larus.bmhome.chat.deepresearch.viewholder.DeepResearchHeadViewHolder;
import com.larus.bmhome.chat.deepresearch.viewholder.DeepResearchImageViewWithTextViewHolder;
import com.larus.bmhome.chat.deepresearch.viewholder.DeepResearchMarkdownCodeTextViewHolder;
import com.larus.bmhome.chat.deepresearch.viewholder.DeepResearchPodcastViewHolder;
import com.larus.bmhome.chat.deepresearch.viewholder.DeepResearchReferenceListViewHolder;
import com.larus.bmhome.chat.deepresearch.viewholder.DeepResearchSingleImageViewHolder;
import com.larus.bmhome.chat.deepresearch.viewholder.DeepResearchTextSwitchViewHolder;
import com.larus.bmhome.chat.deepresearch.viewholder.DeepResearchTextViewHolder;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CodeBlock;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.mainbot.impl.databinding.LarusBlockItemPodcastBinding;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mf9.e;
import ne8.l;
import ne8.m;
import ne8.n;
import pe8.a;
import pe8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001e\u0010\b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0003H\u0016J\u001a\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/DeepResearchAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/chat/deepresearch/DeepResearchData;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isProcessContent", "", "injectExtra", "Lkotlin/Function1;", "", "", "", "", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;ZLkotlin/jvm/functions/Function1;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "lastAnimatedPosition", "", "enableFadeAnimation", "podcastAction", "Lcom/larus/bmhome/chat/deepresearch/DeepResearchPodcastAction;", "setEnableFadeAnimation", "enable", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "onBindViewHolder", "holder", "onViewRecycled", "fadeIn", "view", "Landroid/view/View;", "duration", "", "setDeepResearchPodcastAction", "updatePodcastItemStatus", "status", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepResearchAdapter extends ListAdapter<m, RecyclerView.ViewHolder> {
    public final RecyclerView a;
    public final boolean b;
    public final Function1<Map<String, Object>, Unit> c;
    public int d;
    public boolean e;
    public n f;

    public final int getItemViewType(int r5) {
        m r6 = (m) getItem(r5);
        boolean r0 = true;
        if (r6 == null) goto L7;
        int r2 = r6.a;
        int r3 = j.a;
        if (r2 != j.o) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L25;
        Block r7 = r6.c;
        if (r7 == null) goto L21;
        BlockContent r8 = r7.getContent();
        if (r8 == null) goto L21;
        CodeBlock r9 = r8.getCodeBlock();
        if (r9 == null) goto L21;
        Integer r10 = r9.type;
        if (r10 == null) goto L21;
        if (r10.intValue() != 0) goto L21;
    L22:
        if (r0 == false) goto L25;
        int r11 = j.a;
        return j.c;
    L21:
        r0 = false;
    L25:
        if (r6 != null) goto L29;
        int r12 = j.a;
        return j.c;
    L29:
        return r6.a;
    L7:
        r4 = false;
        goto L8
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r2);
        if ((r2 instanceof AbsDeepResearchViewHolder) == false) goto L6;
        ((AbsDeepResearchViewHolder) r2).a.c();
        return;
    }

    public final void y2(String r5) {
        Intrinsics.checkNotNullParameter(r5, "status");
        Iterator r0 = getCurrentList().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((m) r1).a != j.a) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        m r3 = (m) r1;
        if (r3 != null) goto L15;
        return;
    L15:
        Map<String, String> r4 = r3.d;
        if (r4 == null) goto L18;
        r4.put("loading_status", r5);
    L18:
        notifyItemChanged(getCurrentList().indexOf(r3));
        return;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "holder");
        m r0 = (m) getItem(r12);
        Block r1 = r0.c;
        String r3 = null;
        boolean r4 = true;
        if ((r11 instanceof DeepResearchPodcastViewHolder) == false) goto L69;
        DeepResearchPodcastViewHolder r13 = (DeepResearchPodcastViewHolder) r11;
        final n r14 = this.f;
        r13.getClass();
        e r2 = r0.b;
        if (r2 != null) goto L11;
        FLogger.a.i("DeepResearchPodcastViewHolder", "bindData: data is null");
        FrameLayout r15 = r13.a.a;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L10;
        r16.height = 0;
        r15.setLayoutParams(r16);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        String r7 = r2.a;
        if (r7 != null) goto L14;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == true) goto L63;
        String r9 = r2.b;
        if (r9 != null) goto L22;
    L25:
        boolean r10 = true;
    L26:
        if (r10 == true) goto L63;
        String r17 = r2.c;
        if (r17 != null) goto L30;
    L33:
        if (r4 == true) goto L63;
        Map<String, String> r5 = r0.d;
        if (r5 == null) goto L38;
        r3 = r5.get("loading_status");
    L38:
        if (r3 == null) goto L57;
        int r6 = r3.hashCode();
        if (r6 == (-1313911455)) goto L54;
        if (r6 == (-599445191)) goto L51;
        if (r6 != 336650556) goto L57;
        if (r3.equals("loading") == false) goto L57;
        e1.q(r13.a.f);
        e1.x(r13.a.g);
        goto L57
    L51:
        if (r3.equals("complete") == false) goto L57;
    L56:
        e1.x(r13.a.f);
        e1.o(r13.a.g);
        goto L57
    L54:
        if (r3.equals("timeout") == true) goto L56;
    L57:
        r13.a.i.setText(r2.a);
        r13.a.b.setText(r2.b);
        if (o0.d(r2.e) == false) goto L60;
        r13.a.c.setText(r2.e);
    L60:
        ImageLoaderKt.u(r13.a.e, r2.c, "deep_research_podcast_cover");
        e1.d(r13.a.h, new a(r14));
        e1.d(r13.a.d, new b(r14));
        IFlowChatThemeConfigProvider r18 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r18 == null) goto L118;
        r18.b(r13.a.h, AdaptThemeFeatureKey.CHAT_DEEP_RESEARCH_DETAIL_PODCAST);
        return;
    L118:
        return;
    L30:
        if (r17.length() == 0) goto L33;
        r4 = false;
        goto L33
    L22:
        if (r9.length() == 0) goto L25;
        r10 = false;
    L63:
        FLogger.a.i("DeepResearchPodcastViewHolder", "bindData: title is null or author is null");
        FrameLayout r19 = r13.a.a;
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();
        if (r110 == null) goto L67;
        r110.height = 0;
        r19.setLayoutParams(r110);
        return;
    L67:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        if (r7.length() == 0) goto L17;
        r8 = false;
        goto L18
    L69:
        if ((r11 instanceof AbsDeepResearchViewHolder) == false) goto L121;
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put("block_view_extra_position", Integer.valueOf(r12));
        r20.put("block_view_extra_count", Integer.valueOf(getItemCount()));
        r20.put("block_view_extra_max_width", Integer.valueOf(this.a.getWidth()));
        if (r1 != null) goto L73;
    L75:
        boolean r21 = false;
    L76:
        if (r21 == false) goto L101;
        List r22 = getCurrentList();
        ArrayList r23 = new ArrayList();
        Iterator r24 = r22.iterator();
    L79:
        if (r24.hasNext() == false) goto L88;
        Object r25 = r24.next();
        Block r26 = ((m) r25).c;
        if (r26 != null) goto L83;
    L85:
        boolean r27 = false;
    L86:
        if (r27 == false) goto L79;
        r23.add(r25);
        goto L79
    L83:
        if (r26.getBlockType() != j.s) goto L85;
        r27 = true;
        goto L86
    L88:
        Iterator r28 = r23.iterator();
        int r29 = 0;
    L90:
        if (r28.hasNext() == false) goto L99;
        m r30 = (m) r28.next();
        if (r30 == null) goto L94;
        Block r31 = r30.c;
    L96:
        if (Intrinsics.areEqual(r31, r1) == true) goto L100;
        r29 = r29 + 1;
    L100:
        r20.put("block_view_extra_image_order", Integer.valueOf(r29 + 1));
        goto L101
    L94:
        r31 = null;
        goto L96
    L99:
        r29 = -1;
    L101:
        this.c.invoke(r20);
        if (r12 <= this.d) goto L108;
        View r32 = r11.itemView;
        if (this.e == false) goto L107;
        r32.setAlpha(0.0f);
        r32.setVisibility(0);
        r32.animate().alpha(1.0f).setDuration(300).start();
    L107:
        this.d = r12;
    L108:
        ((AbsDeepResearchViewHolder) r11).a.a(r1, r20);
        return;
    L73:
        if (r1.getBlockType() != j.s) goto L75;
        r21 = true;
        goto L76
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        Context r0 = r13.getContext();
        if (r14 != j.j) goto L6;
        Intrinsics.checkNotNull(r0);
        return new DeepResearchHeadViewHolder(new v(r0));
    L6:
        if (r14 != j.e) goto L8;
    L68:
        Intrinsics.checkNotNull(r0);
        MarkdownIconTextBlockView r15 = new MarkdownIconTextBlockView(r0, null, 6, 0);
        r15.k = this.a;
        RecyclerView.ViewHolder r16 = new DeepResearchTextViewHolder(r15);
    L70:
        return r16;
    L8:
        if (r14 == j.u) goto L68;
        if (r14 == j.p) goto L68;
        if (r14 == j.x) goto L68;
        if (r14 == j.n) goto L68;
        if (r14 != j.k) goto L19;
    L67:
        Intrinsics.checkNotNull(r0);
        return new DeepResearchTextSwitchViewHolder(new t2(r0));
    L19:
        if (r14 == j.m) goto L67;
        if (r14 != j.l) goto L25;
        Intrinsics.checkNotNull(r0);
        return new DeepResearchReferenceListViewHolder(new ReferenceListBlockView(r0));
    L25:
        if (r14 == j.q) goto L64;
        if (r14 == j.s) goto L64;
        if (r14 != j.o) goto L36;
        if (this.b == false) goto L34;
        Intrinsics.checkNotNull(r0);
        return new DeepResearchMarkdownCodeTextViewHolder(new d0(r0, this.a));
    L34:
        Intrinsics.checkNotNull(r0);
        MarkdownIconTextBlockView r17 = new MarkdownIconTextBlockView(r0, null, 6, 0);
        r17.k = this.a;
        r16 = new DeepResearchTextViewHolder(r17);
        goto L70
    L36:
        if (r14 != j.i) goto L39;
        Intrinsics.checkNotNull(r0);
        return new DeepResearchBannerViewHolder(new i(r0));
    L39:
        if (r14 != j.a) goto L60;
        View r18 = LayoutInflater.from(r0).inflate(2131561839, r13, false);
        int r1 = 2131382498;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r18, 2131382498);
        if (r4 == null) goto L58;
        r1 = 2131382499;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r18, 2131382499);
        if (r5 == null) goto L58;
        r1 = 2131382500;
        RelativeLayout r6 = (RelativeLayout) ViewBindings.findChildViewById(r18, 2131382500);
        if (r6 == null) goto L58;
        r1 = 2131382501;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(r18, 2131382501);
        if (r7 == null) goto L58;
        r1 = 2131382502;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r18, 2131382502);
        if (r8 == null) goto L58;
        r1 = 2131382503;
        ProgressBar r9 = (ProgressBar) ViewBindings.findChildViewById(r18, 2131382503);
        if (r9 == null) goto L58;
        r1 = 2131382504;
        ConstraintLayout r10 = ViewBindings.findChildViewById(r18, 2131382504);
        if (r10 == null) goto L58;
        r1 = 2131382505;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r18, 2131382505);
        if (r11 == null) goto L58;
        r16 = new DeepResearchPodcastViewHolder(new LarusBlockItemPodcastBinding((FrameLayout) r18, r4, r5, r6, r7, r8, r9, r10, r11));
    L58:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    L60:
        if (r14 != j.b) goto L62;
        Intrinsics.checkNotNull(r0);
        return new l(new DeepResearchAiDisclaimerView(r0));
    L62:
        Intrinsics.checkNotNull(r0);
        return new DeepResearchEmptyViewHolder(new k(r0));
    L64:
        if (this.b == false) goto L66;
        Intrinsics.checkNotNull(r0);
        return new DeepResearchImageViewWithTextViewHolder(new n2(r0));
    L66:
        Intrinsics.checkNotNull(r0);
        j2 r19 = new j2(r0);
        r19.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        r16 = new DeepResearchSingleImageViewHolder(r19);
        goto L70
    }

    public DeepResearchAdapter(RecyclerView r2, boolean r3, r r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r4, "injectExtra");
        super(new DeepResearchDiffCallback());
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = -1;
    }
}
