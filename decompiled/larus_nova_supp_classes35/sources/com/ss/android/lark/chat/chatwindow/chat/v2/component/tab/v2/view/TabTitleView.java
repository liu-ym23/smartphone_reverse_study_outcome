package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.chameleon.basewebview.BizScene;
import com.ss.android.lark.chat.entity.chat.ChatTab;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \\2\u00020\u0001:\t\\]^_`abcdB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\fB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\rJ\b\u00108\u001a\u00020\u0017H\u0002J\b\u0010?\u001a\u00020@H\u0002J,\u0010\u0002\u001a\u00020@2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010A\u001a\u00020\u00112\b\u0010B\u001a\u0004\u0018\u00010'2\b\u0010C\u001a\u0004\u0018\u00010\u0019J\u0014\u0010D\u001a\u00020@2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010F\u001a\u00020@J\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020IH\u0002J\n\u0010K\u001a\u0004\u0018\u00010/H\u0002J\u001e\u0010L\u001a\u0004\u0018\u00010/2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020<0NH\u0002J\u0010\u0010O\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0011J?\u0010P\u001a\u00020@*\u00020/2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010R2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010R2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010R¢\u0006\u0002\u0010VJ5\u0010W\u001a\u00020@\"\n\b\u0000\u0010X\u0018\u0001*\u00020Y*\u00020/2\u0017\u0010Z\u001a\u0013\u0012\u0004\u0012\u0002HX\u0012\u0004\u0012\u00020@0N¢\u0006\u0002\b[H\u0086\bø\u0001\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b5\u00106R\u0014\u00109\u001a\b\u0018\u00010:R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006e"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fragment", "Landroidx/fragment/app/Fragment;", "mChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "mOriginList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/chat/ChatTab;", "mGuideThrottle", "Lcom/larksuite/framework/utils/AndroidThrottle;", "Ljava/lang/Runnable;", "mOnItemClickListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$OnTabTitleItemClickListener;", "mTabShowListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$OnTabShowListener;", "getMTabShowListener", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$OnTabShowListener;", "setMTabShowListener", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$OnTabShowListener;)V", "mTabViewExposedCallack", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$OnTabItemViewExposedCallback;", "getMTabViewExposedCallack", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$OnTabItemViewExposedCallback;", "setMTabViewExposedCallack", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$OnTabItemViewExposedCallback;)V", "mContractFactory", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/ChatJumpTabContractFactory;", "mTitleTabRV", "Landroidx/recyclerview/widget/RecyclerView;", "getMTitleTabRV", "()Landroidx/recyclerview/widget/RecyclerView;", "mTitleTabRV$delegate", "Lkotlin/Lazy;", "mDividerView", "Landroid/view/View;", "getMDividerView", "()Landroid/view/View;", "mDividerView$delegate", "mDataChangeObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "getMDataChangeObserver", "()Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "mDataChangeObserver$delegate", "showGuideIfNeed", "mAdapter", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$TabItemAdapter;", "isInit", BuildConfig.FLAVOR, "timeInit", BuildConfig.FLAVOR, "initView", BuildConfig.FLAVOR, "chat", "factory", "onItemClickListener", "updateData", "chatTabs", "unInit", "getOriginData", "getSuiteTitleText", BuildConfig.FLAVOR, "title", "getSettingItemView", "getItemExposed", "judge", "Lkotlin/Function1;", "updateChat", "margin", "left", BuildConfig.FLAVOR, "top", "right", "bottom", "(Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "layoutParams", "T", "Landroid/view/ViewGroup$LayoutParams;", BizScene.BLOCK, "Lkotlin/ExtensionFunctionType;", "Companion", "DelayRunnable", "TabItemAdapter", "OnItemClickListener", "OnTabShowListener", "OnTabItemViewExposedCallback", "TabCommonItemViewHolder", "TabSettingItemViewHolder", "OnTabTitleItemClickListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabTitleView extends ConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public final List<ChatTab> a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$TabCommonItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView;Landroid/view/View;)V", "mIcon", "Landroid/widget/ImageView;", "getMIcon", "()Landroid/widget/ImageView;", "setMIcon", "(Landroid/widget/ImageView;)V", "mText", "Landroid/widget/TextView;", "getMText", "()Landroid/widget/TextView;", "setMText", "(Landroid/widget/TextView;)V", "mContent", "getMContent", "()Landroid/view/View;", "setMContent", "(Landroid/view/View;)V", "mCount", "getMCount", "setMCount", "mBadge", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "getMBadge", "()Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "setMBadge", "(Lcom/larksuite/component/universe_design/badge/UDBadgeView;)V", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TabCommonItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(9636)
        public UDBadgeView mBadge;

        @BindView(9895)
        public View mContent;

        @BindView(9938)
        public TextView mCount;

        @BindView(10257)
        public ImageView mIcon;

        @BindView(11342)
        public TextView mText;

        public TabCommonItemViewHolder() {
            throw null;
        }
    }

    public final class TabCommonItemViewHolder_ViewBinding implements Unbinder {
        public TabCommonItemViewHolder a;

        public final void unbind() {
            TabCommonItemViewHolder r0 = this.a;
            if (r0 == null) goto L7;
            this.a = null;
            r0.mIcon = null;
            r0.mText = null;
            r0.mContent = null;
            r0.mCount = null;
            r0.mBadge = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public TabCommonItemViewHolder_ViewBinding(TabCommonItemViewHolder r4, View r5) {
            this.a = r4;
            r4.mIcon = (ImageView) Utils.findRequiredViewAsType(r5, 2131374718, "field 'mIcon'", ImageView.class);
            r4.mText = (TextView) Utils.findRequiredViewAsType(r5, 2131388367, "field 'mText'", TextView.class);
            r4.mContent = Utils.findRequiredView(r5, 2131367794, "field 'mContent'");
            r4.mCount = (TextView) Utils.findRequiredViewAsType(r5, 2131368004, "field 'mCount'", TextView.class);
            r4.mBadge = (UDBadgeView) Utils.findRequiredViewAsType(r5, 2131363831, "field 'mBadge'", UDBadgeView.class);
        }
    }

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u001e\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u001fR\u00020 2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J\u0014\u0010!\u001a\u00020\u001c*\u00020\"2\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0018\u0010$\u001a\u00020\u001c*\u00060\u001fR\u00020 2\u0006\u0010%\u001a\u00020&H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0002J\u001c\u0010+\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060,R\u00020 2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010/\u001a\u00020\u0014H\u0016J\u0014\u00100\u001a\u00020\u001c2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000302R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u00063"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$TabItemAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/ChatTabTitleData;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView;)V", "itemClickListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$OnItemClickListener;", "getItemClickListener", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$OnItemClickListener;", "setItemClickListener", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$OnItemClickListener;)V", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "getDiffer", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "differ$delegate", "Lkotlin/Lazy;", "getItem", "position", BuildConfig.FLAVOR, "getItems", BuildConfig.FLAVOR, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", BuildConfig.FLAVOR, "holder", "bindCommonView", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$TabCommonItemViewHolder;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView;", "loadTabIcon", "Landroid/widget/ImageView;", Keys.API_RETURN_KEY_DATA, "setSelectState", "selected", BuildConfig.FLAVOR, "getOriginData", "Lcom/ss/android/lark/chat/entity/chat/ChatTab;", "tabServerId", BuildConfig.FLAVOR, "bindSettingView", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$TabSettingItemViewHolder;", "getItemViewType", "getItemId", "getItemCount", "submitList", "list", BuildConfig.FLAVOR, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TabItemAdapter extends LarkRecyclerViewBaseAdapter<RecyclerView.ViewHolder, ChatTabTitleData> {
        public final int getItemCount() {
            throw null;
        }

        public final List<ChatTabTitleData> getItems() {
            throw null;
        }

        public final Object getItem(int r1) {
            throw null;
        }

        public final long getItemId(int r1) {
            throw null;
        }

        public final int getItemViewType(int r1) {
            throw null;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "holder");
            throw null;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            if (r3 != 0) goto L5;
            throw null;
        L5:
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView$TabSettingItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/TabTitleView;Landroid/view/View;)V", "mIcon", "Landroid/widget/ImageView;", "getMIcon", "()Landroid/widget/ImageView;", "setMIcon", "(Landroid/widget/ImageView;)V", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TabSettingItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(10257)
        public ImageView mIcon;

        public TabSettingItemViewHolder() {
            throw null;
        }
    }

    public final class TabSettingItemViewHolder_ViewBinding implements Unbinder {
        public TabSettingItemViewHolder a;

        public final void unbind() {
            TabSettingItemViewHolder r0 = this.a;
            if (r0 == null) goto L7;
            this.a = null;
            r0.mIcon = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public TabSettingItemViewHolder_ViewBinding(TabSettingItemViewHolder r4, View r5) {
            this.a = r4;
            r4.mIcon = (ImageView) Utils.findRequiredViewAsType(r5, 2131374718, "field 'mIcon'", ImageView.class);
        }
    }

    public static final class a {
    }

    public interface b {
    }

    public interface c {
    }

    static {
    }

    private final View getSettingItemView() {
        return null;
    }

    public final c getMTabShowListener() {
        return null;
    }

    public final b getMTabViewExposedCallack() {
        return null;
    }

    public final void setMTabShowListener(c r1) {
    }

    public final void setMTabViewExposedCallack(b r1) {
    }

    private final RecyclerView.AdapterDataObserver getMDataChangeObserver() {
        return (RecyclerView.AdapterDataObserver) this.d.getValue();
    }

    private final View getMDividerView() {
        return (View) this.c.getValue();
    }

    private final RecyclerView getMTitleTabRV() {
        return (RecyclerView) this.b.getValue();
    }

    public final List<ChatTab> getOriginData() {
        return this.a;
    }

    public TabTitleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public TabTitleView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, -1);
    }

    public TabTitleView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 0);
    }

    public TabTitleView(final Context r1, AttributeSet r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r2, r3, -1);
        this.a = new ArrayList();
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.b = LazyKt.lazy(r5, new TabTitleView$mTitleTabRV$2(r1));
        this.c = LazyKt.lazy(r5, new TabTitleView$mDividerView$2(r1));
        this.d = LazyKt.lazy(r5, new TabTitleView$mDataChangeObserver$2(this));
    }
}
