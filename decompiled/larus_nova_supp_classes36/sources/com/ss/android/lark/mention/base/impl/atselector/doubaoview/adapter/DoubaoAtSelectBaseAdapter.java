package com.ss.android.lark.mention.base.impl.atselector.doubaoview.adapter;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.entity.tag.TagDataItem;
import com.ss.android.lark.chat.entity.tag.TagRelationTypeEnum;
import com.ss.android.lark.chat.entity.tag.TagTypeEnum;
import com.ss.android.lark.flow.common.component.tag.FlowTagView;
import com.ss.android.lark.flow.common.utils.FlowTagBuilder;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.AllAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.GroupMemAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SkeletonAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.WantAtMemBean;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.h;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.i;
import com.ss.android.lark.picker.base.view.SearchRecyclerViewBaseAdapter;
import com.ss.android.lark.utils.UIHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 32\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0003345B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\nJ\u001a\u0010\u0016\u001a\u00020\u00102\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010 \u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u001a\u0010'\u001a\u00020\u00102\u0006\u0010 \u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0002J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001bH\u0016J\u0010\u0010/\u001a\u0002002\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u00101\u001a\u00020\u001bH\u0016J\n\u00102\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/adapter/DoubaoAtSelectBaseAdapter;", "Lcom/ss/android/lark/picker/base/view/SearchRecyclerViewBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/BaseAtBean;", "Lcom/ss/android/lark/mention/base/impl/atselector/IItemContainer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mOnItemClickListener", "Lcom/ss/android/lark/mention/base/impl/atselector/IItemContainer$OnItemSelectListener;", "searchKeyword", "", "showDepartment", "", "updateSearchKeyword", "", "keyword", "updateShowDepartment", "show", "setOnItemClickListener", "listener", "resetAll", "collection", "", "getItem", "position", "", "getTopNRptId", "getItemViewType", "isItemSelectable", "onBindViewHolder", "holder", "payloads", "", "", "bindDepartment", "Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/adapter/DoubaoAtSelectBaseAdapter$ItemViewHolder;", "bean", "bindTags", "highLightSearchWorld", "Landroid/text/Spannable;", "displayName", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemId", "", "getSelectMode", "getSelectListener", "Companion", "ItemViewHolder", "SkeletonViewHolder", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DoubaoAtSelectBaseAdapter extends SearchRecyclerViewBaseAdapter<RecyclerView.ViewHolder, BaseAtBean> implements IItemContainer {
    public final Context a;
    public IItemContainer.a b;
    public String c;
    public boolean d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/adapter/DoubaoAtSelectBaseAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "avatarImageView", "Landroid/widget/ImageView;", "getAvatarImageView", "()Landroid/widget/ImageView;", "nameTextView", "Landroid/widget/TextView;", "getNameTextView", "()Landroid/widget/TextView;", "departmentTextView", "getDepartmentTextView", "tagContainer", "Landroid/widget/LinearLayout;", "getTagContainer", "()Landroid/widget/LinearLayout;", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final TextView b;
        public final TextView c;
        public final LinearLayout d;

        public ItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131363623);
            this.b = (TextView) r2.findViewById(2131380593);
            this.c = (TextView) r2.findViewById(2131368809);
            this.d = (LinearLayout) r2.findViewById(2131388092);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/adapter/DoubaoAtSelectBaseAdapter$SkeletonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class SkeletonViewHolder extends RecyclerView.ViewHolder {
        public SkeletonViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DoubaoAtSelectBaseAdapter a;
        public final /* synthetic */ BaseAtBean b;

        public b(DoubaoAtSelectBaseAdapter r1, BaseAtBean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            IItemContainer.a r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.c(this.b);
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer
    public final int y0() {
        return 0;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer
    public final IItemContainer.a a0() {
        return this.b;
    }

    public DoubaoAtSelectBaseAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.c = "";
    }

    public final /* bridge */ /* synthetic */ Object getItem(int r1) {
        return y2(r1);
    }

    public final long getItemId(int r3) {
        if (r3 >= ((LarkRecyclerViewBaseAdapter) this).items.size()) goto L6;
        r3 = ((BaseAtBean) ListProtector.get(((LarkRecyclerViewBaseAdapter) this).items, r3)).hashCode();
    L6:
        return r3;
    }

    public final int getItemViewType(int r1) {
        return y2(r1) instanceof SkeletonAtBean ? 1 : 0;
    }

    public final String getTopNRptId(int r2) {
        BaseAtBean r3 = y2(r2);
        if ((r3 instanceof SearchBean) == true) goto L9;
        if ((r3 instanceof WantAtMemBean) == true) goto L9;
        return null;
    L9:
        return r3.getId();
    }

    public final boolean isItemSelectable(int r1) {
        return !(y2(r1) instanceof SkeletonAtBean);
    }

    public final void resetAll(Collection<? extends BaseAtBean> r1) {
        super/*com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter*/.resetAll(r1);
    }

    public final BaseAtBean y2(int r2) {
        if (r2 < ((LarkRecyclerViewBaseAdapter) this).items.size()) goto L7;
        return null;
    L7:
        return (BaseAtBean) ListProtector.get(((LarkRecyclerViewBaseAdapter) this).items, r2);
    }

    public final Spannable z2(String r9) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(r9);
        String r1 = this.c;
        int r4 = 0;
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L25;
        if (r9.length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L25;
        int r5 = ContextCompat.getColor(this.a, 2131108946);
    L15:
        if (r4 >= r9.length()) goto L23;
        int r6 = StringsKt.indexOf(r9, r1, r4, true);
        if (r6 < 0) goto L23;
        int r7 = RangesKt.coerceAtMost(r1.length() + r6, r9.length());
        if (r7 <= r6) goto L21;
        r0.setSpan(new ForegroundColorSpan(r5), r6, r7, 33);
    L21:
        r4 = r7;
    L23:
        return SpannableString.valueOf(r0);
    L10:
        r3 = false;
    L25:
        return SpannableString.valueOf(r0);
    L5:
        r2 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 1) goto L5;
        View r5 = LayoutInflater.from(this.a).inflate(2131561586, r3, false);
        Intrinsics.checkNotNull(r5);
        return new SkeletonViewHolder(r5);
    L5:
        View r6 = LayoutInflater.from(this.a).inflate(2131561585, r3, false);
        Intrinsics.checkNotNull(r6);
        ItemViewHolder r7 = new ItemViewHolder(r6);
        r6.setTag(r7);
        return r7;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r18, int r19, List<Object> r20) {
        Intrinsics.checkNotNullParameter(r18, "holder");
        Intrinsics.checkNotNullParameter(r20, "payloads");
        if ((r18 instanceof SkeletonViewHolder) == false) goto L5;
        return;
    L5:
        super.onBindViewHolder(r18, r19);
        TagRelationTypeEnum r3 = null;
        if ((r18 instanceof ItemViewHolder) == false) goto L8;
        ItemViewHolder r4 = (ItemViewHolder) r18;
    L9:
        if (r4 != null) goto L11;
        return;
    L11:
        List r0 = ((LarkRecyclerViewBaseAdapter) this).items;
        if (r0 == null) goto L14;
        BaseAtBean r5 = (BaseAtBean) ListProtector.get(r0, r19);
    L15:
        boolean r7 = true;
        if (r5 != null) goto L18;
    L61:
        r4.d.removeAllViews();
        r4.d.setVisibility(8);
        if ((r5 instanceof SearchBean) == false) goto L65;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r1 = ((SearchBean) r5).getChatterInfo();
    L71:
        if (r1 == null) goto L132;
        int r9 = i.a;
        long r10 = System.currentTimeMillis() / 1000;
        Intrinsics.checkNotNullParameter(r1, "chatterInfo");
        TagData r11 = r1.s;
        if (r11 == null) goto L88;
        List r12 = r11.getTagDataItems();
        if (r12 == null) goto L88;
        Iterator r13 = r12.iterator();
    L79:
        if (r13.hasNext() == false) goto L86;
        Object r14 = r13.next();
        if (((TagDataItem) r14).getTagType() != TagTypeEnum.RELATION_TAG) goto L83;
        boolean r15 = true;
    L84:
        if (r15 == false) goto L79;
    L87:
        TagDataItem r16 = (TagDataItem) r14;
    L89:
        if (r16 == null) goto L92;
        r3 = r16.getRelationTagType();
    L92:
        if (r3 != TagRelationTypeEnum.RELATION_TAG_EXTERNAL) goto L94;
        boolean r6 = true;
    L95:
        boolean r17 = r1.j;
        boolean r110 = r1.k;
        List<Chatter.ChatterCustomStatus> r111 = r1.r;
        if (r111 != null) goto L98;
        r111 = CollectionsKt.emptyList();
    L98:
        List<Chatter.ChatterCustomStatus> r112 = r111;
        if ((r112 instanceof Collection) == true) goto L101;
    L103:
        Iterator<T> r113 = r112.iterator();
    L105:
        if (r113.hasNext() == false) goto L123;
        Chatter.ChatterCustomStatus r114 = (Chatter.ChatterCustomStatus) r113.next();
        StatusEffectiveInterval r115 = r114.effective_interval;
        if (r115 != null) goto L110;
    L119:
        boolean r8 = false;
    L120:
        if (r8 == false) goto L105;
    L124:
        boolean r2 = r1.u;
        FlowTagBuilder r21 = new FlowTagBuilder(this.a);
        r21.e = r17;
        r21.f = r110;
        r21.h = r7;
        r21.i = r6;
        r21.j = r2;
        FlowTagView r22 = r21.b();
        if (r22 == null) goto L127;
        r4.d.addView(r22, new LinearLayout.LayoutParams(-2, -2));
    L127:
        LinearLayout r23 = r4.d;
        if (r22 != null) goto L130;
        int r24 = 8;
    L131:
        r23.setVisibility(r24);
        goto L132
    L130:
        r24 = 0;
        goto L131
    L110:
        if (Intrinsics.areEqual(r114.icon_key, "GeneralVacation") == false) goto L119;
        Long r25 = r115.start_time;
        if (r10 <= r115.end_time.longValue()) goto L114;
    L116:
        boolean r26 = false;
    L117:
        if (r26 == false) goto L119;
        r8 = true;
        goto L120
    L114:
        if (r25.longValue() > r10) goto L116;
        r26 = true;
    L123:
        r7 = false;
        goto L124
    L101:
        if (r112.isEmpty() == false) goto L103;
    L94:
        r6 = false;
        goto L95
    L83:
        r15 = false;
        goto L84
    L86:
        r14 = null;
    L88:
        r16 = null;
    L132:
        r18.itemView.setOnClickListener(new b(this, r5));
        return;
    L65:
        if ((r5 instanceof WantAtMemBean) == false) goto L68;
        r1 = ((WantAtMemBean) r5).getChatterInfo();
        goto L71
    L68:
        if ((r5 instanceof GroupMemAtBean) == false) goto L70;
        r1 = ((GroupMemAtBean) r5).getChatterInfo();
        goto L71
    L70:
        r1 = null;
        goto L71
    L18:
        if (r5.getType() != 1) goto L25;
        r4.a.setImageResource(2131243932);
        if ((r5 instanceof AllAtBean) == false) goto L22;
        AllAtBean r27 = (AllAtBean) r5;
    L23:
        if (r27 == null) goto L134;
        r27.allSize = 0;
    L134:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L28
        r4.b.setText(z2(r5.getDisplayName()));     // Catch: Throwable -> L28
        Object r29 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L31:
        if (Result.exceptionOrNull-impl(r29) == null) goto L34;
        r4.b.setText(r5.getDisplayName());
    L34:
        if (this.d == true) goto L37;
        r4.c.setVisibility(8);
        r4.c.setText("");
        goto L61
    L37:
        if ((r5 instanceof SearchBean) == false) goto L39;
        SearchBean r30 = (SearchBean) r5;
    L40:
        if (r30 == null) goto L51;
        int r116 = h.a;
        Intrinsics.checkNotNullParameter(r30, "bean");
        com.ss.android.lark.mention.base.impl.atselector.bean.a r31 = r30.getChatterInfo();
        if (r31 == null) goto L48;
        ChatterSensitiveInfo r32 = r31.q;
        if (r32 == null) goto L48;
        String r33 = r32.getChatterDepartmentName();
        if (r33 == null) goto L48;
        String r34 = StringsKt.trim(r33).toString();
    L49:
        if (r34 != null) goto L52;
        r34 = "";
    L52:
        if (r34 != null) goto L55;
        r34 = "";
    L55:
        if (r34.length() != 0) goto L57;
        boolean r117 = true;
    L58:
        if (r117 == false) goto L60;
        r4.c.setVisibility(8);
        r4.c.setText("");
        goto L61
    L60:
        r4.c.setVisibility(0);
        r4.c.setText(r34);
        goto L61
    L57:
        r117 = false;
    L48:
        r34 = null;
        goto L49
    L51:
        r34 = null;
        goto L52
    L39:
        r30 = null;
    L28:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L22:
        r27 = null;
        goto L23
    L25:
        r5.showAvatar(this.a, r4.a, UIHelper.dp2px(32.0f), UIHelper.dp2px(32.0f));
        goto L134
    L14:
        r5 = null;
        goto L15
    L8:
        r4 = null;
        goto L9
    }
}
