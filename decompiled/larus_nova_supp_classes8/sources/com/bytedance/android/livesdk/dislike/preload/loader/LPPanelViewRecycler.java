package com.bytedance.android.livesdk.dislike.preload.loader;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.config.v61;
import com.bytedance.android.livesdk.dislike.layout.IMContactLayoutV2;
import com.bytedance.android.livesdk.dislike.layout.IMMoreContactLayout;
import com.bytedance.android.livesdk.dislike.layout.OptionDescItemLayoutV2;
import com.bytedance.android.livesdk.dislike.layout.RecommendToFriendsLayout;
import com.bytedance.android.livesdk.utils.LivePanelsOptUtil;
import com.bytedance.bpea.cert.token.BuildConfig;
import com.bytedance.ies.bullet.pool.util.PoolUtilKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\rJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0015J\b\u0010\u001e\u001a\u00020\u0015H\u0002J$\u0010\u001f\u001a\u0004\u0018\u0001H \"\u0004\b\u0000\u0010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\"H\u0082\b¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u0015*\u0004\u0018\u00010%H\u0002J\f\u0010&\u001a\u00020\u0015*\u00020'H\u0002J(\u0010(\u001a\u0004\u0018\u0001H \"\n\b\u0000\u0010 *\u0004\u0018\u00010%*\n\u0012\u0004\u0012\u0002H \u0018\u00010\nH\u0082\b¢\u0006\u0002\u0010)R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/preload/loader/LPPanelViewRecycler;", "Landroidx/lifecycle/ViewModel;", "()V", "dc", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDc", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDc", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "iMContactLayoutV2", "Ljava/util/LinkedList;", "Lcom/bytedance/android/livesdk/dislike/layout/IMContactLayoutV2;", "moreContactLayout", "Lcom/bytedance/android/livesdk/dislike/layout/IMMoreContactLayout;", "optionDescItemLayoutV2", "Lcom/bytedance/android/livesdk/dislike/layout/OptionDescItemLayoutV2;", "recommendToFriendsLayout", "Lcom/bytedance/android/livesdk/dislike/layout/RecommendToFriendsLayout;", "enableViewRecycle", "", "onCleared", "", "pollIMContactLayoutV2", "pollMoreContactView", "pollRecommendToFriendsLayout", "pollpollOptionDescItemLayoutV2", "recycle", "linearLayout", "Landroid/widget/LinearLayout;", BuildConfig.BUILD_TYPE, "removeAllList", "withSetting", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ensureRecycle", "Landroid/view/View;", "foreachRecycle", "Landroid/view/ViewGroup;", "pollView", "(Ljava/util/LinkedList;)Landroid/view/View;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LPPanelViewRecycler extends ViewModel {
    private DataCenter dc;
    private final LinkedList<IMContactLayoutV2> iMContactLayoutV2;
    private final LinkedList<IMMoreContactLayout> moreContactLayout;
    private final LinkedList<OptionDescItemLayoutV2> optionDescItemLayoutV2;
    private final LinkedList<RecommendToFriendsLayout> recommendToFriendsLayout;

    private final boolean enableViewRecycle() {
        if (LivePanelsOptUtil.b(this.dc) == false) goto L15;
        v61.a r0 = ((v61) LivePanelsOptUtil.c.getValue()).a();
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r0.a() == true) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 != true) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r0.c() == false) goto L11;
        r1 = true;
        goto L12
    L15:
        return false;
    }

    private final void removeAllList() {
        this.moreContactLayout.clear();
        this.optionDescItemLayoutV2.clear();
        this.iMContactLayoutV2.clear();
        this.recommendToFriendsLayout.clear();
    }

    public final IMContactLayoutV2 pollIMContactLayoutV2() {
        LinkedList<IMContactLayoutV2> r0 = this.iMContactLayoutV2;
        if (access$enableViewRecycle(this) == false) goto L8;
        if (r0 == null) goto L8;
        IMContactLayoutV2 r1 = r0.poll();
        if (r1 == null) goto L8;
        boolean r2 = LivePanelsOptUtil.b;
        LivePanelsOptUtil.c("使用了缓存：".concat(r1.getClass().getSimpleName()));
        PoolUtilKt.a(r1);
    L10:
        return r1;
    L8:
        r1 = null;
        goto L10
    }

    public final IMMoreContactLayout pollMoreContactView() {
        LinkedList<IMMoreContactLayout> r0 = this.moreContactLayout;
        if (access$enableViewRecycle(this) == false) goto L8;
        if (r0 == null) goto L8;
        IMMoreContactLayout r1 = r0.poll();
        if (r1 == null) goto L8;
        boolean r2 = LivePanelsOptUtil.b;
        LivePanelsOptUtil.c("使用了缓存：".concat(r1.getClass().getSimpleName()));
        PoolUtilKt.a(r1);
    L10:
        return r1;
    L8:
        r1 = null;
        goto L10
    }

    public final RecommendToFriendsLayout pollRecommendToFriendsLayout() {
        LinkedList<RecommendToFriendsLayout> r0 = this.recommendToFriendsLayout;
        if (access$enableViewRecycle(this) == false) goto L8;
        if (r0 == null) goto L8;
        RecommendToFriendsLayout r1 = r0.poll();
        if (r1 == null) goto L8;
        boolean r2 = LivePanelsOptUtil.b;
        LivePanelsOptUtil.c("使用了缓存：".concat(r1.getClass().getSimpleName()));
        PoolUtilKt.a(r1);
    L10:
        return r1;
    L8:
        r1 = null;
        goto L10
    }

    public final OptionDescItemLayoutV2 pollpollOptionDescItemLayoutV2() {
        LinkedList<OptionDescItemLayoutV2> r0 = this.optionDescItemLayoutV2;
        if (access$enableViewRecycle(this) == false) goto L8;
        if (r0 == null) goto L8;
        OptionDescItemLayoutV2 r1 = r0.poll();
        if (r1 == null) goto L8;
        boolean r2 = LivePanelsOptUtil.b;
        LivePanelsOptUtil.c("使用了缓存：".concat(r1.getClass().getSimpleName()));
        PoolUtilKt.a(r1);
    L10:
        return r1;
    L8:
        r1 = null;
        goto L10
    }

    public LPPanelViewRecycler() {
        this.moreContactLayout = new LinkedList();
        this.optionDescItemLayoutV2 = new LinkedList();
        this.iMContactLayoutV2 = new LinkedList();
        this.recommendToFriendsLayout = new LinkedList();
    }

    public void onCleared() {
        super.onCleared();
        release();
    }

    public final DataCenter getDc() {
        return this.dc;
    }

    public final void release() {
        removeAllList();
    }

    public static final /* synthetic */ boolean access$enableViewRecycle(LPPanelViewRecycler r0) {
        return r0.enableViewRecycle();
    }

    private final void ensureRecycle(View r2) {
        if ((r2 instanceof IMMoreContactLayout) == false) goto L6;
        this.moreContactLayout.add(r2);
        LivePanelsOptUtil.c("缓存了IMMoreContactLayout");
        return;
    L6:
        if ((r2 instanceof OptionDescItemLayoutV2) == false) goto L9;
        this.optionDescItemLayoutV2.add(r2);
        LivePanelsOptUtil.c("缓存了OptionDescItemLayoutV2");
        return;
    L9:
        if ((r2 instanceof IMContactLayoutV2) == false) goto L12;
        this.iMContactLayoutV2.add(r2);
        LivePanelsOptUtil.c("缓存了IMContactLayoutV2");
        return;
    L12:
        if ((r2 instanceof RecommendToFriendsLayout) == false) goto L18;
        this.recommendToFriendsLayout.add(r2);
        LivePanelsOptUtil.c("缓存了RecommendToFriendsLayout");
        return;
    }

    private final void foreachRecycle(ViewGroup r5) {
        int r0 = r5.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        View r2 = r5.getChildAt(r1);
        ensureRecycle(r2);
        if ((r2 instanceof ViewGroup) == true) goto L7;
        r2 = null;
    L7:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L10;
        foreachRecycle(r3);
    L10:
        r1 = r1 + 1;
        goto L3
    }

    private final <T extends View> T pollView(LinkedList<T> r3) {
        if (access$enableViewRecycle(this) == false) goto L8;
        if (r3 == null) goto L8;
        T r4 = r3.poll();
        if (r4 == null) goto L8;
        boolean r0 = LivePanelsOptUtil.b;
        LivePanelsOptUtil.c("使用了缓存：".concat(r4.getClass().getSimpleName()));
        PoolUtilKt.a(r4);
        return r4;
    L8:
        return null;
    }

    private final <T> T withSetting(Function0<? extends T> r2) {
        if (access$enableViewRecycle(this) == true) goto L7;
        return null;
    L7:
        return (T) r2.invoke();
    }

    public final void recycle(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "linearLayout");
        removeAllList();
        if (access$enableViewRecycle(this) == false) goto L6;
        foreachRecycle(r2);
        return;
    }

    public final void setDc(DataCenter r1) {
        this.dc = r1;
    }

    public static final /* synthetic */ Object access$withSetting(LPPanelViewRecycler r0, Function0 r1) {
        return r0.withSetting(r1);
    }
}
