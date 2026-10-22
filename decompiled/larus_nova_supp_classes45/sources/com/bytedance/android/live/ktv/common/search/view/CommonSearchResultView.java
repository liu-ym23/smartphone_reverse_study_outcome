package com.bytedance.android.live.ktv.common.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.commonui.KtvCommonEmptyView;
import com.bytedance.android.live.ktv.common.karaokestation.model.t;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CommonSongListView;
import com.bytedance.android.live.ktv.common.ordersong.view.DialogLoadingView;
import com.bytedance.android.livesdk.chatroom.ui.FastScrollRecyclerView;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchResultView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/ktv/common/search/view/q;", "outerInject", "", "setOuterCallback", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "b", "Lkotlin/Lazy;", "getCommonSearchViewModel", "()Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "commonSearchViewModel", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonSongListView;", "c", "getMusicListRecyclerView", "()Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonSongListView;", "musicListRecyclerView", "Lcom/bytedance/android/live/ktv/common/commonui/KtvCommonEmptyView;", "d", "getEmptyView", "()Lcom/bytedance/android/live/ktv/common/commonui/KtvCommonEmptyView;", "emptyView", "Lcom/bytedance/android/live/ktv/common/ordersong/view/DialogLoadingView;", "e", "getLoadingAnimView", "()Lcom/bytedance/android/live/ktv/common/ordersong/view/DialogLoadingView;", "loadingAnimView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSearchResultView extends FrameLayout {
    public q a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    public CommonSearchResultView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonSearchResultView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final com.bytedance.android.live.ktv.common.search.viewmodel.a getCommonSearchViewModel() {
        return (com.bytedance.android.live.ktv.common.search.viewmodel.a) this.b.getValue();
    }

    private final KtvCommonEmptyView getEmptyView() {
        return (KtvCommonEmptyView) this.d.getValue();
    }

    private final DialogLoadingView getLoadingAnimView() {
        return (DialogLoadingView) this.e.getValue();
    }

    private final CommonSongListView getMusicListRecyclerView() {
        return (CommonSongListView) this.c.getValue();
    }

    public final void a(List<MusicPanel> r5) {
        Intrinsics.checkNotNullParameter(r5, "musicList");
        y r0 = new y(0, 0, 65535);
        r0.h.addAll(r5);
        Intrinsics.checkNotNullParameter("search", "<set-?>");
        r0.c = "search";
        com.bytedance.android.live.ktv.common.search.viewmodel.a r6 = getCommonSearchViewModel();
        boolean r1 = true;
        if (r6 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        r0.l = r7;
        CommonSearchResultView$bindSearchedResult$1 r8 = CommonSearchResultView$bindSearchedResult$1.INSTANCE;
        CommonSongListView r3 = getMusicListRecyclerView();
        if (r3 == null) goto L11;
        r3.w(r0, r8);
    L11:
        List<MusicPanel> r9 = r0.h;
        if (r9 != null) goto L14;
    L17:
        if (r1 == false) goto L27;
        FastScrollRecyclerView r11 = getMusicListRecyclerView();
        if (r11 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r11);
    L21:
        KtvCommonEmptyView r12 = getEmptyView();
        if (r12 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r12);
    L24:
        KtvCommonEmptyView r13 = getEmptyView();
        if (r13 == null) goto L34;
        r13.b(r0.c, false);
        return;
    L34:
        return;
    L27:
        FastScrollRecyclerView r14 = getMusicListRecyclerView();
        if (r14 == null) goto L30;
        UtilityKotlinExtentionsKt.w(r14);
    L30:
        KtvCommonEmptyView r15 = getEmptyView();
        if (r15 == null) goto L36;
        UtilityKotlinExtentionsKt.t(r15);
        return;
    L36:
        return;
    L14:
        if (r9.isEmpty() == true) goto L17;
        r1 = false;
        goto L17
    L5:
        if (r6.hasMoreSearchResult() != true) goto L7;
        r7 = true;
        goto L8
    }

    public final void setOuterCallback(q r3) {
        Intrinsics.checkNotNullParameter(r3, "outerInject");
        this.a = r3;
        if (r3 == null) goto L9;
        Function1<t, Unit> r4 = r3.d(getLoadingAnimView());
        if (r4 == null) goto L9;
        CommonSongListView r0 = getMusicListRecyclerView();
        if (r0 == null) goto L9;
        r0.setHandleLoadMoreAction(r4);
    L9:
        CommonSongListView r5 = getMusicListRecyclerView();
        Function1<MultiTypeAdapter, Unit> r1 = null;
        if (r5 == null) goto L16;
        q r2 = this.a;
        if (r2 == null) goto L14;
        me.drakeet.multitype.b<MusicPanel, RecyclerView.ViewHolder> r6 = r2.g();
    L15:
        r5.setCommonSongListItemViewBinder(r6);
        goto L16
    L14:
        r6 = null;
    L16:
        CommonSongListView r7 = getMusicListRecyclerView();
        if (r7 == null) goto L22;
        q r8 = this.a;
        if (r8 == null) goto L21;
        r1 = r8.b();
    L21:
        r7.setCustomItemViewBinderAction(r1);
    L22:
        CommonSongListView r9 = getMusicListRecyclerView();
        if (r9 == null) goto L25;
        r9.v();
    L25:
        q r11 = this.a;
        if (r11 == null) goto L29;
        r11.c(getMusicListRecyclerView());
        return;
    }

    public CommonSearchResultView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(new CommonSearchResultView$commonSearchViewModel$2(this));
        this.c = LazyKt.lazy(new CommonSearchResultView$musicListRecyclerView$2(this));
        this.d = LazyKt.lazy(new CommonSearchResultView$emptyView$2(this));
        this.e = LazyKt.lazy(new CommonSearchResultView$loadingAnimView$2(this));
        LayoutInflater.from(r2).inflate(2131566472, this);
    }

    public /* synthetic */ CommonSearchResultView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
