package com.obric.assistant.omnidetailpage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.c;
import com.larus.bmhome.chat.component.share.g1;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.bmhome.chat.layout.widget.handler.e;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.IconAlignment;
import com.larus.im.bean.message.block.OClickActionBlock;
import com.larus.im.bean.message.block.OHistoryGui;
import com.larus.im.bean.message.block.OOmniDetailGUIProcessBlock;
import com.larus.im.bean.message.block.OOmniDetailPlanStateBlock;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyIcon;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.im.bean.message.block.RenderStyle;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.card.databinding.ObricOmniBlockTaskHeaderBinding;
import com.obric.assistant.card.databinding.ObricOmniBlockTaskOperatePhoneBinding;
import com.obric.assistant.card.databinding.ObricOmniBlockTaskTitleBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.omnidetailpage.blockview.LocalSearchResultView;
import com.obric.assistant.omnidetailpage.blockview.TaskContentView;
import com.obric.assistant.omnidetailpage.blockview.TaskHeaderView;
import com.obric.assistant.omnidetailpage.blockview.TaskLocalFileView;
import com.obric.assistant.omnidetailpage.blockview.TaskQuickReplyView;
import com.obric.assistant.omnidetailpage.blockview.TaskTitleView;
import com.obric.assistant.omnidetailpage.blockview.a0;
import com.obric.assistant.omnidetailpage.blockview.k0;
import com.obric.assistant.omnidetailpage.blockview.o0;
import com.obric.assistant.omnidetailpage.blockview.operatephone.OperatePhoneInnerAdapter;
import com.obric.assistant.omnidetailpage.blockview.operatephone.OperatePhoneView;
import com.obric.assistant.omnidetailpage.blockview.p0;
import com.obric.assistant.omnidetailpage.blockview.x;
import com.obric.assistant.omnidetailpage.blockview.z;
import com.obric.assistant.omnidetailpage.componment.m;
import com.obric.assistant.omnidetailpage.localmedia.TaskLocalAudioButtonView;
import com.obric.assistant.omnidetailpage.localmedia.q;
import com.obric.assistant.omnidetailpage.localmedia.v;
import com.obric.assistant.omnidetailpage.localmedia.w;
import com.obric.assistant.omnidetailpage.localmedia.y;
import com.obric.assistant.omnidetailpage.util.OmniPageUtil;
import com.obric.assistant.omnidetailpage.viewholder.ContentViewHolder;
import com.obric.assistant.omnidetailpage.viewholder.HeaderViewHolder;
import com.obric.assistant.omnidetailpage.viewholder.LocalFileViewHolder;
import com.obric.assistant.omnidetailpage.viewholder.LocalMediaPreviewViewHolder;
import com.obric.assistant.omnidetailpage.viewholder.LocalSearchResultViewHolder;
import com.obric.assistant.omnidetailpage.viewholder.ModeSettingViewHolder;
import com.obric.assistant.omnidetailpage.viewholder.OperatePhoneViewHolder;
import com.obric.assistant.omnidetailpage.viewholder.QuickReplyViewHolder;
import com.obric.assistant.omnidetailpage.viewholder.TitleViewHolder;
import gfa.j;
import gfa.k;
import gfa.l;
import gfa.n;
import gfa.o;
import gfa.p;
import ifa.a;
import ifa.b;
import ifa.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lw8.d;
import v19.h;
import v19.i5;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0015H\u0016J\u0018\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0015H\u0016J\u0018\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0015H\u0016J\u0010\u0010:\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R,\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R2\u0010#\u001a\u001a\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R,\u0010+\u001a\u0014\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020100X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/assistant/omnidetailpage/TaskDetailAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "localVideoAutoPlayManager", "Lcom/obric/assistant/omnidetailpage/localmedia/TaskLocalVideoAutoPlayManager;", "onItemClick", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/obric/assistant/omnidetailpage/localmedia/TaskLocalVideoAutoPlayManager;Lkotlin/jvm/functions/Function1;)V", "instructionTypeProvider", "Lkotlin/Function0;", "getInstructionTypeProvider", "()Lkotlin/jvm/functions/Function0;", "setInstructionTypeProvider", "(Lkotlin/jvm/functions/Function0;)V", "onQuickReplyClick", "Lkotlin/Function2;", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$QuickReply;", "", "getOnQuickReplyClick", "()Lkotlin/jvm/functions/Function2;", "setOnQuickReplyClick", "(Lkotlin/jvm/functions/Function2;)V", "onQuickReplyShow", "getOnQuickReplyShow", "setOnQuickReplyShow", "onContentShow", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$Content;", "getOnContentShow", "()Lkotlin/jvm/functions/Function1;", "setOnContentShow", "(Lkotlin/jvm/functions/Function1;)V", "onHeaderAttachmentClick", "Lkotlin/Function3;", "Lcom/obric/assistant/omnidetailpage/model/HeaderAttachment;", "Landroid/view/View;", "getOnHeaderAttachmentClick", "()Lkotlin/jvm/functions/Function3;", "setOnHeaderAttachmentClick", "(Lkotlin/jvm/functions/Function3;)V", "onModeSettingClick", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$ModeSetting;", "getOnModeSettingClick", "setOnModeSettingClick", "expandStateMap", "", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onViewRecycled", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskDetailAdapter extends ListAdapter<f, RecyclerView.ViewHolder> {
    public final w a;
    public final Function1<String, Unit> b;
    public Function0<String> c;
    public Function2<? super f.i, ? super Integer, Unit> d;
    public Function2<? super f.i, ? super Integer, Unit> e;
    public Function1<? super f.b, Unit> f;
    public Function3<? super a, ? super View, ? super Integer, Unit> g;
    public Function2<? super f.g, ? super String, Unit> h;
    public final Map<String, Boolean> i;

    public final int getItemViewType(int r1) {
        return ((f) getItem(r1)).a;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r10) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r10);
        int r1 = 0;
        TaskQuickReplyView r2 = null;
        if ((r10 instanceof LocalSearchResultViewHolder) == false) goto L6;
        LocalSearchResultView r0 = ((LocalSearchResultViewHolder) r10).a;
        r0.getClass();
        FLogger.a.d("LocalResultView", "onRecycled");
        r0.b(r0.c, true);
    L22:
        if ((r10 instanceof QuickReplyViewHolder) == false) goto L30;
        View r11 = ((RecyclerView.ViewHolder) ((QuickReplyViewHolder) r10)).itemView;
        if ((r11 instanceof TaskQuickReplyView) == false) goto L26;
        r2 = (TaskQuickReplyView) r11;
    L26:
        if (r2 == null) goto L38;
        LinearLayout r12 = r2.c.b;
        int r3 = r12.getChildCount();
    L28:
        if (r1 >= r3) goto L39;
        ExposureTrackerExtKt.c(r12.getChildAt(r1));
        r1 = r1 + 1;
        goto L28
    L39:
        return;
    L38:
        return;
    L30:
        return;
    L6:
        if ((r10 instanceof LocalFileViewHolder) == false) goto L9;
        TaskLocalFileView r4 = ((LocalFileViewHolder) r10).a;
        r4.h = null;
        r4.g.a(new q(0));
        goto L22
    L9:
        if ((r10 instanceof LocalMediaPreviewViewHolder) == false) goto L22;
        k0 r5 = ((LocalMediaPreviewViewHolder) r10).a;
        w r6 = r5.c;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "owner");
        LinkedHashSet<y> r7 = r6.a;
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L12:
        if (r9.hasNext() == false) goto L16;
        Object r13 = r9.next();
        LinkedHashMap r14 = (LinkedHashMap) r6.b;
        if (Intrinsics.areEqual(r14.get((y) r13), r5) == false) goto L12;
        r8.add(r13);
        goto L12
    L16:
        Iterator r15 = CollectionsKt.toList(r8).iterator();
    L18:
        if (r15.hasNext() == false) goto L20;
        r6.c((y) r15.next());
        goto L18
    L20:
        r5.g = CollectionsKt.emptyList();
        r5.h = CollectionsKt.emptyList();
        r5.j.y2(CollectionsKt.emptyList(), r5.b(), r5.i);
        goto L22
    }

    public TaskDetailAdapter(w r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "localVideoAutoPlayManager");
        Intrinsics.checkNotNullParameter(r3, "onItemClick");
        super(new TaskDiffCallback());
        this.a = r2;
        this.b = r3;
        this.c = new g1();
        this.d = new l();
        this.e = new gfa.m();
        this.f = new n();
        this.g = new o();
        this.h = new p();
        this.i = new LinkedHashMap();
    }

    /* JADX WARN: Type inference failed for: r13v13, types: [gfa.j, java.lang.Object] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r49, int r50) {
        Intrinsics.checkNotNullParameter(r49, "holder");
        f r2 = (f) getItem(r50);
        String r9 = null;
        if ((r2 instanceof f.c) == false) goto L152;
        f.c r3 = (f.c) r2;
        final String r4 = r3.b.getBlockId();
        if (r4 != null) goto L7;
        r4 = "-1";
    L7:
        Object r11 = ((LinkedHashMap) this.i).get(r4);
        if (r11 != null) goto L10;
        r11 = Boolean.FALSE;
    L10:
        boolean r12 = ((Boolean) r11).booleanValue();
        HeaderViewHolder r0 = (HeaderViewHolder) r49;
        final Function1<String, Unit> r13 = this.b;
        final ?? r14 = new j(this, r4);
        Function3<? super a, ? super View, ? super Integer, Unit> r5 = this.g;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r13, "onItemClick");
        Intrinsics.checkNotNullParameter(r14, "onExpandChanged");
        Intrinsics.checkNotNullParameter(r5, "onAttachmentClick");
        View r1 = ((RecyclerView.ViewHolder) r0).itemView;
        if ((r1 instanceof TaskHeaderView) == false) goto L13;
        final TaskHeaderView r6 = (TaskHeaderView) r1;
    L14:
        if (r6 == null) goto L518;
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r13, "onItemClick");
        Intrinsics.checkNotNullParameter(r14, "onExpandChanged");
        Intrinsics.checkNotNullParameter(r5, "onAttachmentClick");
        List<a> r7 = r3.j;
        List<a> r8 = r7;
        LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));
        Iterator<T> r10 = r8.iterator();
    L17:
        if (r10.hasNext() == false) goto L19;
        Object r16 = r10.next();
        r15.put(((a) r16).a, r16);
        goto L17
    L19:
        r6.d = r15;
        ObricOmniBlockTaskHeaderBinding r17 = r6.a;
        if (r17 == null) goto L63;
        FrameLayout r18 = r17.b;
        if (r18 == null) goto L63;
        if (r7.isEmpty() == false) goto L27;
        r6.c.h(new ResourceBarConfig(Mode.SHOW, false, 0, 0, null, null, 60, null), new ArrayList(), null);
        r18.setVisibility(8);
        goto L63
    L27:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r7.iterator();
    L29:
        if (r20.hasNext() == false) goto L62;
        a r110 = (a) r20.next();
        UplinkFileEntity r111 = r110.c;
        if (n1.d(r111) == false) goto L33;
    L36:
        int r21 = 100;
    L38:
        if (n1.d(r111) == false) goto L52;
        String r22 = r110.d;
        if (r22 != null) goto L42;
    L47:
        r22 = l1.d(r111);
        if (r22 == null) goto L52;
        if ((!StringsKt.isBlank(r22)) == false) goto L52;
    L53:
        Iterator r410 = r20;
        ResourceItemBean r23 = c.a(r111, Mode.SHOW, r6.c(r21), r6.c(92), 32);
        String r24 = r110.a;
        HashMap r25 = new HashMap(r23.getExt());
        if (r22 == null) goto L61;
        if ((!StringsKt.isBlank(r22)) == true) goto L59;
        r22 = null;
    L59:
        if (r22 == null) goto L61;
        r25.put("ext_img_show_path", r22);
    L61:
        Unit r26 = Unit.INSTANCE;
        r19.add(ResourceItemBean.copy$default(r23, r24, null, null, null, null, null, 0, null, false, null, 0, 0, 0, 0, false, false, false, false, 0, r25, 524286, null));
        r20 = r410;
        r9 = null;
        goto L29
    L42:
        if ((!StringsKt.isBlank(r22)) == true) goto L45;
        r22 = r9;
    L45:
        if (r22 == null) goto L47;
    L52:
        r22 = r9;
        goto L53
    L33:
        if (n1.e(r111) == true) goto L36;
        r21 = 198;
        goto L38
    L62:
        r6.c.h(new ResourceBarConfig(Mode.SHOW, false, 0, 0, null, null, 48, null), r19, new com.obric.assistant.omnidetailpage.blockview.y(r6, r5));
        r18.setVisibility(0);
    L63:
        BlockContent r27 = r3.b.getContent();
        if (r27 == null) goto L519;
        TextBlock r28 = r27.getTextBlock();
        if (r28 == null) goto L540;
        ObricOmniBlockTaskHeaderBinding r29 = r6.a;
        if (r29 == null) goto L71;
        r29.h.setVisibility(0);
        r29.h.setMinLines(0);
    L71:
        int r30 = 4;
        if (r3.i == false) goto L81;
        ObricOmniBlockTaskHeaderBinding r31 = r6.a;
        if (r31 == null) goto L76;
        r31.h.setVisibility(4);
        r31.h.setText(" ");
        r31.h.setMinLines(2);
        r31.h.setMaxLines(4);
        r31.h.setEllipsize(null);
        r31.g.setVisibility(8);
        r31.f.setVisibility(8);
        r31.d.setVisibility(8);
        r31.d.removeAllViews();
        r6.e(false, false);
    L76:
        ObricOmniBlockTaskHeaderBinding r32 = r6.a;
        if (r32 == null) goto L520;
        LinearLayout r33 = r32.e;
        if (r33 == null) goto L521;
        r33.setOnClickListener(null);
        return;
    L521:
        return;
    L520:
        return;
    L81:
        Intrinsics.checkNotNullParameter(r28, "<this>");
        String r34 = r28.summary;
        if (r34 != null) goto L84;
    L90:
        final boolean r35 = false;
    L91:
        r6.e = r12;
        r6.f = false;
        r6.g = new TaskHeaderView.a(0);
        String r36 = "";
        if (r35 == false) goto L103;
        ObricOmniBlockTaskHeaderBinding r37 = r6.a;
        if (r37 == null) goto L110;
        r37.g.setVisibility(0);
        String r38 = r28.text;
        if (r38 != null) goto L98;
        r38 = "";
    L98:
        r37.h.setText(r38);
        r37.h.setMaxLines(Integer.MAX_VALUE);
        r37.h.setEllipsize(null);
        TextView r39 = r37.g;
        Context r40 = r6.getContext();
        Object[] r41 = new Object[1];
        String r42 = r28.summary;
        if (r42 == null) goto L102;
        r36 = r42;
    L102:
        r41[0] = r36;
        r39.setText(r40.getString(2131912288, r41));
    L110:
        List<String> r43 = r3.h;
        r6.b = r43;
        ObricOmniBlockTaskHeaderBinding r44 = r6.a;
        if (r44 == null) goto L125;
        TextView r45 = r44.f;
        if (r45 == null) goto L125;
        SpannableStringBuilder r46 = new SpannableStringBuilder();
        Iterator<T> r47 = r43.iterator();
        int r48 = 0;
    L116:
        if (r47.hasNext() == false) goto L124;
        Object r51 = r47.next();
        int r52 = r48 + 1;
        if (r48 >= 0) goto L120;
        CollectionsKt.throwIndexOverflow();
    L120:
        String r53 = (String) r51;
        if (r48 <= 0) goto L123;
        r46.append('\n');
    L123:
        r6.a(r46, r53);
        r48 = r52;
        goto L116
    L124:
        r45.setText(r46);
    L125:
        ObricOmniBlockTaskHeaderBinding r54 = r6.a;
        if (r54 == null) goto L130;
        LinearLayout r55 = r54.d;
        if (r55 == null) goto L130;
        r55.removeAllViews();
    L130:
        ObricOmniBlockTaskHeaderBinding r56 = r6.a;
        if (r56 == null) goto L143;
        if (r35 == false) goto L134;
        TextView r57 = r56.g;
    L135:
        Intrinsics.checkNotNull(r57);
        if (r6.e == false) goto L138;
        r30 = Integer.MAX_VALUE;
    L138:
        r57.setMaxLines(r30);
        if (r6.e == false) goto L141;
        TextUtils.TruncateAt r58 = null;
    L142:
        r57.setEllipsize(r58);
        r56.f.setVisibility(8);
        r56.d.setVisibility(8);
        r6.e(false, r6.e);
        goto L143
    L141:
        r58 = TextUtils.TruncateAt.END;
        goto L142
    L134:
        r57 = r56.h;
    L143:
        final ObricOmniBlockTaskHeaderBinding r59 = r6.a;
        if (r59 == null) goto L146;
        r59.a.post(new x(r35, r59, r6));
    L146:
        ObricOmniBlockTaskHeaderBinding r60 = r6.a;
        if (r60 == null) goto L523;
        LinearLayout r61 = r60.e;
        if (r61 == null) goto L524;
        r61.setOnClickListener(new com.obric.assistant.omnidetailpage.blockview.w(r6, r35, r14, r13));
        return;
    L524:
        return;
    L523:
        return;
    L103:
        ObricOmniBlockTaskHeaderBinding r62 = r6.a;
        if (r62 == null) goto L110;
        r62.g.setVisibility(8);
        TextView r63 = r62.h;
        String r64 = r28.text;
        if (r64 == null) goto L109;
        r36 = r64;
    L109:
        r63.setText(r36);
        goto L110
    L84:
        if (r34.length() <= 0) goto L86;
        boolean r65 = true;
    L88:
        if (r65 != true) goto L90;
        r35 = true;
        goto L91
    L86:
        r65 = false;
        goto L88
    L540:
        return;
    L519:
        return;
    L518:
        return;
    L13:
        r6 = null;
        goto L14
    L152:
        if ((r2 instanceof f.j) == false) goto L198;
        TitleViewHolder r66 = (TitleViewHolder) r49;
        f.j r67 = (f.j) r2;
        Function1<String, Unit> r68 = this.b;
        r66.getClass();
        Intrinsics.checkNotNullParameter(r67, "item");
        Intrinsics.checkNotNullParameter(r68, "onItemClick");
        View r69 = ((RecyclerView.ViewHolder) r66).itemView;
        if ((r69 instanceof TaskTitleView) == false) goto L156;
        TaskTitleView r70 = (TaskTitleView) r69;
    L157:
        if (r70 == null) goto L526;
        Intrinsics.checkNotNullParameter(r67, "item");
        Intrinsics.checkNotNullParameter(r68, "onItemClick");
        r70.b = r68;
        BlockContent r71 = r67.b.getContent();
        if (r71 == null) goto L161;
        OOmniDetailPlanStateBlock r72 = r71.getOOmniDetailPlanStateBlock();
    L162:
        ObricOmniBlockTaskTitleBinding r73 = r70.a;
        if (r73 == null) goto L172;
        ShimmerTextView r74 = r73.c;
        if (r72 == null) goto L167;
        String r75 = r72.getPlanState();
    L168:
        r74.setText(r75);
        if (r67.d == false) goto L171;
        ShimmerTextView r76 = r73.c;
        int r77 = ShimmerTextView.h;
        r76.z(false);
        goto L172
    L171:
        r73.c.x();
        goto L172
    L167:
        r75 = null;
    L172:
        if (r72 == null) goto L174;
        String r78 = r72.getLightIconUrl();
    L175:
        boolean r79 = h.a;
        if (h.a(null) == false) goto L190;
        if (r72 == null) goto L179;
        String r80 = r72.getDarkIconUrl();
    L180:
        if (r80 != null) goto L182;
    L185:
        boolean r81 = true;
    L186:
        if (r81 == true) goto L190;
        r78 = r72.getDarkIconUrl();
        if (r78 == null) goto L191;
    L192:
        ObricOmniBlockTaskTitleBinding r82 = r70.a;
        if (r82 == null) goto L527;
        SimpleDraweeView r83 = r82.b;
        if (r83 == null) goto L528;
        com.obric.assistant.card.utils.h.a(r83, r78, "obric_omni.operate_phone");
        return;
    L528:
        return;
    L527:
        return;
    L191:
        r78 = "";
        goto L192
    L182:
        if (r80.length() == 0) goto L185;
        r81 = false;
        goto L186
    L179:
        r80 = null;
    L190:
        if (r78 != null) goto L192;
    L174:
        r78 = null;
        goto L175
    L161:
        r72 = null;
        goto L162
    L526:
        return;
    L156:
        r70 = null;
        goto L157
    L198:
        if ((r2 instanceof f.b) == false) goto L215;
        ContentViewHolder r84 = (ContentViewHolder) r49;
        f.b r85 = (f.b) r2;
        Function1<? super f.b, Unit> r86 = this.f;
        r84.getClass();
        Intrinsics.checkNotNullParameter(r85, "item");
        Intrinsics.checkNotNullParameter(r86, "onContentShow");
        View r87 = ((RecyclerView.ViewHolder) r84).itemView;
        if ((r87 instanceof TaskContentView) == false) goto L202;
        TaskContentView r88 = (TaskContentView) r87;
    L203:
        if (r88 == null) goto L213;
        Intrinsics.checkNotNullParameter(r85, "item");
        BlockContent r89 = r85.b.getContent();
        if (r89 == null) goto L209;
        TextBlock r90 = r89.getTextBlock();
        if (r90 == null) goto L209;
        String r91 = r90.text;
    L210:
        if (r91 != null) goto L212;
        r91 = "";
    L212:
        r88.a(r85, r91, null, null);
    L209:
        r91 = null;
    L213:
        r86.invoke(r85);
        return;
    L202:
        r88 = null;
        goto L203
    L215:
        if ((r2 instanceof f.i) == false) goto L335;
        QuickReplyViewHolder r92 = (QuickReplyViewHolder) r49;
        final f.i r93 = (f.i) r2;
        final Function1<String, Unit> r94 = this.b;
        final Function2<? super f.i, ? super Integer, Unit> r112 = this.d;
        final Function2<? super f.i, ? super Integer, Unit> r113 = this.e;
        r92.getClass();
        Intrinsics.checkNotNullParameter(r93, "item");
        Intrinsics.checkNotNullParameter(r94, "onItemClick");
        Intrinsics.checkNotNullParameter(r112, "onQuickReplyClick");
        Intrinsics.checkNotNullParameter(r113, "onQuickReplyShow");
        View r95 = ((RecyclerView.ViewHolder) r92).itemView;
        if ((r95 instanceof TaskQuickReplyView) == false) goto L219;
        TaskQuickReplyView r96 = (TaskQuickReplyView) r95;
    L220:
        if (r96 == null) goto L531;
        Intrinsics.checkNotNullParameter(r93, "item");
        Intrinsics.checkNotNullParameter(r94, "onItemClick");
        Intrinsics.checkNotNullParameter(r112, "onQuickReplyClick");
        Intrinsics.checkNotNullParameter(r113, "onQuickReplyShow");
        r96.setShowLine(r93.c);
        if (r93.e == true) goto L224;
    L228:
        boolean r97 = false;
    L229:
        LinearLayout r98 = r96.c.a;
        if (r97 == false) goto L232;
        int r99 = i5.q();
    L233:
        r98.setPaddingRelative(r99, r96.c.a.getPaddingTop(), i5.q(), r96.c.a.getPaddingBottom());
        BlockContent r100 = r93.b.getContent();
        if (r100 == null) goto L236;
        QuickReplyBlock r101 = r100.getQuickReplyBlock();
    L237:
        LinearLayout r114 = r96.c.b;
        int r102 = r114.getChildCount();
        int r103 = 0;
    L238:
        if (r103 >= r102) goto L240;
        ExposureTrackerExtKt.c(r114.getChildAt(r103));
        r103 = r103 + 1;
        goto L238
    L240:
        r114.removeAllViews();
        if (r101 == null) goto L243;
        List r104 = r101.getItems();
    L244:
        if (r104 != null) goto L246;
        r104 = CollectionsKt.emptyList();
    L246:
        List r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
        int r108 = 0;
    L248:
        if (r107.hasNext() == false) goto L253;
        Object r109 = r107.next();
        int r115 = r108 + 1;
        if (r108 >= 0) goto L252;
        CollectionsKt.throwIndexOverflow();
    L252:
        r106.add(TuplesKt.to(Integer.valueOf(r108), (QuickReplyItem) r109));
        r108 = r115;
        goto L248
    L253:
        ArrayList r116 = new ArrayList();
        Iterator r117 = r106.iterator();
    L255:
        if (r117.hasNext() == false) goto L267;
        Object r118 = r117.next();
        String r119 = ((QuickReplyItem) ((Pair) r118).component2()).getText();
        if (r119 != null) goto L259;
    L262:
        boolean r210 = true;
    L264:
        if ((!r210) == false) goto L255;
        r116.add(r118);
        goto L255
    L259:
        if (StringsKt.isBlank(r119) == true) goto L262;
        r210 = false;
        goto L264
    L267:
        if (r116.isEmpty() == false) goto L269;
        e1.o(r96);
        return;
    L269:
        e1.x(r96);
        Iterator r120 = r116.iterator();
        int r121 = 0;
    L271:
        if (r120.hasNext() == false) goto L542;
        Object r122 = r120.next();
        int r123 = r121 + 1;
        if (r121 >= 0) goto L275;
        CollectionsKt.throwIndexOverflow();
    L275:
        Pair r124 = (Pair) r122;
        final int r125 = ((Number) r124.component1()).intValue();
        final QuickReplyItem r126 = (QuickReplyItem) r124.component2();
        View r127 = LayoutInflater.from(r96.getContext()).inflate(2131564042, r114, false);
        ConstraintLayout r128 = (ConstraintLayout) r127;
        int r129 = 2131383560;
        View r130 = (SimpleDraweeView) ViewBindings.findChildViewById(r127, 2131383560);
        if (r130 == null) goto L333;
        r129 = 2131383561;
        View r131 = (SimpleDraweeView) ViewBindings.findChildViewById(r127, 2131383561);
        if (r131 == null) goto L333;
        AppCompatTextView r132 = ViewBindings.findChildViewById(r127, 2131383564);
        if (r132 == null) goto L331;
        boolean r133 = h.a;
        if (h.a(null) == false) goto L286;
        QuickReplyIcon r134 = r126.getIcon();
        if (r134 == null) goto L289;
        String r135 = r134.getUrlDark();
    L290:
        QuickReplyIcon r136 = r126.getIcon();
        if (r136 == null) goto L298;
        Integer r137 = r136.getAlignment();
        View r510 = r130;
        int r138 = IconAlignment.ALIGN_LEFT.getValue();
        Iterator r139 = r120;
        if (r137 != null) goto L296;
    L299:
        boolean r140 = false;
    L300:
        if (r140 == false) goto L302;
        View r141 = r510;
    L303:
        Intrinsics.checkNotNull(r141);
        if (r140 == false) goto L306;
        View r142 = r131;
    L307:
        Intrinsics.checkNotNull(r142);
        String r143 = r126.getText();
        if (r143 != null) goto L310;
        r143 = "";
    L310:
        r132.setText(r143);
        e1.o(r142);
        if (r135 != null) goto L313;
    L316:
        boolean r144 = true;
    L317:
        if (r144 == false) goto L319;
        e1.o(r141);
    L320:
        Integer r145 = r126.getRenderStyle();
        int r146 = RenderStyle.RENDER_STYLE_BUTTON_BLOCK.getValue();
        if (r145 != null) goto L324;
    L326:
        int r147 = -2;
    L327:
        LinearLayout.LayoutParams r148 = new LinearLayout.LayoutParams(r147, -2);
        if (r121 <= 0) goto L330;
        r148.topMargin = r96.d;
    L330:
        r128.setLayoutParams(r148);
        e1.d(r128, new o0(r94, r112, r93, r125));
        r114.addView(r128);
        final TaskQuickReplyView r149 = r96;
        ExposureTrackerExtKt.a(r128, new p0(r149, r93, r126, r125, r113));
        r121 = r123;
        r120 = r139;
        goto L271
    L324:
        if (r145.intValue() != r146) goto L326;
        r147 = -1;
        goto L327
    L319:
        e1.x(r141);
        com.obric.assistant.card.utils.h.a(r141, r135, "obric_omni.operate_phone");
        goto L320
    L313:
        if (r135.length() == 0) goto L316;
        r144 = false;
        goto L317
    L306:
        r142 = r510;
        goto L307
    L302:
        r141 = r131;
        goto L303
    L296:
        if (r137.intValue() != r138) goto L299;
        r140 = true;
        goto L300
    L298:
        r510 = r130;
        r139 = r120;
    L289:
        r135 = null;
        goto L290
    L286:
        QuickReplyIcon r150 = r126.getIcon();
        if (r150 == null) goto L289;
        r135 = r150.getUrlLight();
        goto L290
    L331:
        r129 = 2131383564;
    L333:
        throw new NullPointerException("Missing required view with ID: ".concat(r127.getResources().getResourceName(r129)));
    L542:
        return;
    L243:
        r104 = null;
        goto L244
    L236:
        r101 = null;
        goto L237
    L232:
        r99 = i5.d0();
        goto L233
    L224:
        if (r93.f == false) goto L228;
        if (r93.c == true) goto L228;
        r97 = true;
        goto L229
    L531:
        return;
    L219:
        r96 = null;
        goto L220
    L335:
        if ((r2 instanceof f.h) == false) goto L436;
        final f.h r151 = (f.h) r2;
        final String r152 = r151.b.getBlockId();
        if (r152 != null) goto L339;
        r152 = "";
    L339:
        Object r153 = ((LinkedHashMap) this.i).get(r152);
        if (r153 != null) goto L342;
        r153 = Boolean.FALSE;
    L342:
        boolean r154 = ((Boolean) r153).booleanValue();
        OperatePhoneViewHolder r155 = (OperatePhoneViewHolder) r49;
        final Function0<String> r156 = this.c;
        final Function1<String, Unit> r157 = this.b;
        Function1<? super Boolean, Unit> r158 = new k(r152, this);
        r155.getClass();
        Intrinsics.checkNotNullParameter(r151, "item");
        Intrinsics.checkNotNullParameter(r156, "instructionTypeProvider");
        Intrinsics.checkNotNullParameter(r157, "onItemClick");
        Intrinsics.checkNotNullParameter(r158, "onExpandChange");
        View r159 = ((RecyclerView.ViewHolder) r155).itemView;
        if ((r159 instanceof OperatePhoneView) == false) goto L345;
        OperatePhoneView r160 = (OperatePhoneView) r159;
    L346:
        if (r160 == null) goto L533;
        Intrinsics.checkNotNullParameter(r151, "item");
        Intrinsics.checkNotNullParameter(r156, "instructionTypeProvider");
        Intrinsics.checkNotNullParameter(r157, "onItemClick");
        Intrinsics.checkNotNullParameter(r158, "onExpandChange");
        BlockContent r161 = r151.b.getContent();
        if (r161 == null) goto L352;
        OOmniDetailGUIProcessBlock r162 = r161.getOOmniDetailGUIBlock();
        if (r162 == null) goto L352;
        boolean r163 = Intrinsics.areEqual(r162.getForceExpand(), Boolean.TRUE);
    L353:
        r160.g = r163;
        if (r154 == true) goto L358;
        if (r163 == true) goto L358;
        boolean r164 = false;
    L359:
        r160.f = r164;
        r160.j = r157;
        r160.h = r158;
        r160.i = r151.d;
        Block r165 = r151.b;
        r160.e = r165;
        if (r165 == null) goto L534;
        BlockContent r166 = r165.getContent();
        if (r166 == null) goto L535;
        OOmniDetailGUIProcessBlock r167 = r166.getOOmniDetailGUIBlock();
        if (r167 == null) goto L541;
        r160.b();
        r160.setShowLine(r151.c);
        ObricOmniBlockTaskOperatePhoneBinding r168 = r160.c;
        if (r168 == null) goto L426;
        r168.j.setText(r167.getTitle());
        r168.f.setEnabled(!r160.g);
        CustomMarkdownTextView r169 = r168.i;
        ObricOmniBlockTaskOperatePhoneBinding r170 = r160.c;
        Intrinsics.checkNotNull(r170);
        Resources r171 = r170.a.getContext().getResources();
        int r172 = WindowDisplayMetricsOverride.apply(r171, r171.getDisplayMetrics()).widthPixels;
        Resources r173 = Resources.getSystem();
        r169.setMarkdownWidth(r172 - MathKt.roundToInt(TypedValue.applyDimension(1, 80, WindowDisplayMetricsOverride.apply(r173, r173.getDisplayMetrics()))));
        gw8.c.a.getClass();
        gw8.c r174 = gw8.c.a.b();
        String r175 = "";
        if (r174 == null) goto L374;
        CustomMarkdownTextView r176 = r168.i;
        String r177 = r167.getNowProcessContent();
        if (r177 != null) goto L373;
        r177 = "";
    L373:
        Resources r178 = Resources.getSystem();
        lw8.l r179 = gw8.c.b.b(r174, r176, r177, true, new d(0, null, null, false, Integer.valueOf(r168.i.getCurrentTextColor()), 0, Float.valueOf(1.0f), 0.0f, Float.valueOf(1.0f), 0, 0, Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r178, r178.getDisplayMetrics())))), null, null, null, null, null, null, null, null, null, null, null, null, -39489, 31));
    L375:
        CustomMarkdownTextView r180 = r168.i;
        String r181 = r151.b.getBlockId();
        if (r181 != null) goto L378;
        r181 = "";
    L378:
        e.b(r180, "obric_omni_detail_block_id", r181);
        r168.i.setMarkdown(r179);
        ConcurrentHashMap<String, Pair<Drawable, String>> r182 = OmniPageUtil.a;
        String r183 = r167.getNowPackageName();
        if (r183 == null) goto L382;
        r175 = r183;
    L382:
        Pair r184 = OmniPageUtil.b(r175, r160.getContext().getPackageManager(), r160.getContext(), true);
        if (r184.getFirst() == null) goto L385;
        r168.g.setVisibility(0);
        r168.g.setImageDrawable((Drawable) r184.getFirst());
        r168.g.setBackground(null);
    L400:
        r160.a();
        OperatePhoneInnerAdapter r185 = r160.d;
        List<OHistoryGui> r186 = r167.getOHistoryGui();
        if (r186 != null) goto L403;
        r186 = CollectionsKt.emptyList();
    L403:
        Block r187 = r160.e;
        if (r184.getFirst() != null) goto L424;
        Block r188 = r160.e;
        if (r188 == null) goto L420;
        BlockContent r189 = r188.getContent();
        if (r189 == null) goto L420;
        OOmniDetailGUIProcessBlock r190 = r189.getOOmniDetailGUIBlock();
        if (r190 == null) goto L420;
        String r191 = r190.getNowProcessContent();
        if (r191 == null) goto L420;
        if (r191.length() <= 0) goto L416;
        boolean r192 = true;
    L418:
        if (r192 != true) goto L420;
        boolean r193 = true;
    L421:
        if (r193 == true) goto L424;
        boolean r194 = false;
    L425:
        boolean r195 = r160.i;
        r185.getClass();
        Intrinsics.checkNotNullParameter(r186, "newItems");
        Intrinsics.checkNotNullParameter(r156, "instructionTypeProvider");
        r185.a = r186;
        r185.e = r187;
        r185.d = r194;
        r185.f = r195;
        r185.c = r156;
        r185.notifyDataSetChanged();
        goto L426
    L416:
        r192 = false;
    L420:
        r193 = false;
    L424:
        r194 = true;
        goto L425
    L385:
        String r196 = r167.getNowProcessContent();
        if (r196 != null) goto L388;
    L394:
        boolean r197 = false;
    L395:
        if (r197 == true) goto L397;
    L399:
        r168.g.setVisibility(8);
        r168.h.setVisibility(8);
        r168.h.a();
        goto L400
    L397:
        if (r160.f == true) goto L399;
        r168.g.setVisibility(8);
        r168.h.setVisibility(0);
        goto L400
    L388:
        if (r196.length() <= 0) goto L390;
        boolean r198 = true;
    L392:
        if (r198 != true) goto L394;
        r197 = true;
        goto L395
    L390:
        r198 = false;
        goto L392
    L374:
        r179 = null;
    L426:
        ObricOmniBlockTaskOperatePhoneBinding r199 = r160.c;
        if (r199 == null) goto L536;
        Iterator r200 = CollectionsKt.listOf(new View[]{r199.h, r199.i}).iterator();
    L430:
        if (r200.hasNext() == false) goto L543;
        View r201 = (View) r200.next();
        if (r160.i == false) goto L430;
        e1.d(r201, new hfa.e(r151, r157, r156));
        goto L430
    L543:
        return;
    L536:
        return;
    L541:
        return;
    L535:
        return;
    L534:
        return;
    L358:
        r164 = true;
    L352:
        r163 = false;
        goto L353
    L533:
        return;
    L345:
        r160 = null;
        goto L346
    L436:
        if ((r2 instanceof f.C0060f) == false) goto L439;
        LocalSearchResultViewHolder r202 = (LocalSearchResultViewHolder) r49;
        f.C0060f r203 = (f.C0060f) r2;
        Function1<String, Unit> r204 = this.b;
        r202.getClass();
        Intrinsics.checkNotNullParameter(r203, "item");
        Intrinsics.checkNotNullParameter(r204, "onItemClick");
        r202.a.a(r203, r204);
        return;
    L439:
        if ((r2 instanceof f.d) == false) goto L469;
        LocalFileViewHolder r205 = (LocalFileViewHolder) r49;
        f.d r206 = (f.d) r2;
        r205.getClass();
        Intrinsics.checkNotNullParameter(r206, "item");
        final TaskLocalFileView r207 = r205.a;
        r207.getClass();
        Intrinsics.checkNotNullParameter(r206, "item");
        final b r208 = r206.h;
        r207.h = r208.d;
        r207.setShowLine(r206.c);
        r207.e.setText(r208.b);
        String r209 = r208.c;
        Locale r211 = Locale.ROOT;
        String r212 = r209.toUpperCase(r211);
        if (StringsKt.isBlank(r212) == false) goto L443;
        r212 = StringsKt.substringAfterLast(r208.d, '.', "").toUpperCase(r211);
    L443:
        r207.e.setMaxLines(Integer.MAX_VALUE);
        r207.e.setEllipsize(null);
        r207.f.setText(r212);
        r207.f.setVisibility(8);
        boolean r213 = h.a;
        if (h.b(r207.getContext()) == false) goto L446;
        String r214 = r208.g;
    L447:
        r207.d.setVisibility(0);
        ImageLoaderKt.e(r207.d);
        if ((!StringsKt.isBlank(r214)) == false) goto L450;
        com.obric.assistant.card.utils.h.a(r207.d, r214, "obric_omni.operate_phone");
    L450:
        String r215 = r208.d;
        TaskLocalAudioButtonView r216 = r207.g;
        v r217 = v.a;
        monitor-enter(r217);
        Intrinsics.checkNotNullParameter(r215, "path");     // Catch: Throwable -> L465
        if (Intrinsics.areEqual(v.d, r215) == true) goto L458;
        q r218 = new q(0);     // Catch: Throwable -> L465
        monitor-exit(r217);
    L460:
        r216.a(r218);
        TaskLocalAudioButtonView r219 = r207.g;
        if (r208.h == false) goto L463;
        int r220 = 0;
    L464:
        r219.setVisibility(r220);
        e1.d(r207.g, new z(r208, r207));
        e1.d(r207.c, new a0(r207, r208));
        return;
    L463:
        r220 = 8;
        goto L464
    L458:
        r218 = v.b();     // Catch: Throwable -> L465
        monitor-exit(r217);
    L465:
        th = move-exception;
        throw th;
    L446:
        r214 = r208.f;
        goto L447
    L469:
        if ((r2 instanceof f.e) == false) goto L472;
        LocalMediaPreviewViewHolder r221 = (LocalMediaPreviewViewHolder) r49;
        f.e r222 = (f.e) r2;
        r221.getClass();
        Intrinsics.checkNotNullParameter(r222, "item");
        r221.a.a(r222);
        return;
    L472:
        if ((r2 instanceof f.g) == false) goto L488;
        ModeSettingViewHolder r223 = (ModeSettingViewHolder) r49;
        final f.g r224 = (f.g) r2;
        final Function1<String, Unit> r225 = this.b;
        final Function2<? super f.g, ? super String, Unit> r226 = this.h;
        r223.getClass();
        Intrinsics.checkNotNullParameter(r224, "item");
        Intrinsics.checkNotNullParameter(r225, "onItemClick");
        Intrinsics.checkNotNullParameter(r226, "onModeSettingClick");
        TaskContentView r227 = r223.a;
        Function1<? super String, Unit> r228 = new jfa.a(r225, r226, r224);
        r227.getClass();
        Intrinsics.checkNotNullParameter(r224, "item");
        Intrinsics.checkNotNullParameter(r228, "onClick");
        BlockContent r229 = r224.b.getContent();
        if (r229 == null) goto L476;
        OClickActionBlock r230 = r229.getOClickActionBlock();
    L477:
        if (r230 == null) goto L479;
        String r231 = r230.content;
    L480:
        if (r231 != null) goto L482;
        r231 = "";
    L482:
        if (r230 == null) goto L484;
        String r232 = r230.clickAction;
    L485:
        r227.a(r224, r231, r232, r228);
        return;
    L484:
        r232 = null;
        goto L485
    L479:
        r231 = null;
        goto L480
    L476:
        r230 = null;
        goto L477
    L488:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Context r7 = r5.getContext();
        switch(r6) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNull(r7);
        return new HeaderViewHolder(new TaskHeaderView(r7, null, 6, 0));
    L5:
        Intrinsics.checkNotNull(r7);
        return new ModeSettingViewHolder(new TaskContentView(r7, null, 6, 0));
    L6:
        Intrinsics.checkNotNull(r7);
        return new LocalMediaPreviewViewHolder(new k0(r7, this.a));
    L7:
        Intrinsics.checkNotNull(r7);
        return new LocalFileViewHolder(new TaskLocalFileView(r7, null, 6, 0));
    L8:
        Intrinsics.checkNotNull(r7);
        return new QuickReplyViewHolder(new TaskQuickReplyView(r7, null, 6, 0));
    L9:
        Intrinsics.checkNotNull(r7);
        return new LocalSearchResultViewHolder(new LocalSearchResultView(r7, null, 6, 0));
    L10:
        Intrinsics.checkNotNull(r7);
        return new OperatePhoneViewHolder(new OperatePhoneView(r7, null, 6, 0));
    L11:
        Intrinsics.checkNotNull(r7);
        return new ContentViewHolder(new TaskContentView(r7, null, 6, 0));
    L12:
        Intrinsics.checkNotNull(r7);
        return new TitleViewHolder(new TaskTitleView(r7, null, 6, 0));
    L13:
        Intrinsics.checkNotNull(r7);
        return new HeaderViewHolder(new TaskHeaderView(r7, null, 6, 0));
    }
}
