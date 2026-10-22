package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleScrollMode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001/B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0006\u0010 \u001a\u00020\u0015J\b\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001eH\u0016J \u0010'\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020+H\u0002J\u0018\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleScrollHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "backToBottomView", "Landroid/view/View;", "stackFromEndController", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleStackFromEndController;", "callback", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleScrollHelper$Callback;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/LinearLayoutManager;Landroid/view/View;Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleStackFromEndController;Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleScrollHelper$Callback;)V", "scrollMode", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleScrollMode;", "adapterDataObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "getAdapterDataObserver", "()Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "initListeners", "", "pendingRecheckSource", "", "itemHeightRecheckRunnable", "Ljava/lang/Runnable;", "scheduleItemHeightRecheck", "source", "handleItemRangeInserted", "positionStart", "", "itemCount", "scrollToBottomOnInitialized", "scrollToBottom", "scrollToBottomInternal", "setScrollMode", "mode", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "isReachBottom", "", "updateFloatingViews", "showBackToBottom", "from", "Callback", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSubtitleScrollHelper extends RecyclerView.OnScrollListener {
    public final RecyclerView a;
    public final LinearLayoutManager b;
    public final View c;
    public final w d;
    public final a e;
    public MmSubtitleScrollMode f;
    public final MmSubtitleScrollHelper$adapterDataObserver$1 g;
    public String h;
    public final u i;

    public interface a {
        void a();

        void b(MmSubtitleScrollMode r1);

        void c();
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MmSubtitleScrollHelper a;

        public b(MmSubtitleScrollHelper r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.m();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final boolean k() {
        int r0 = this.b.findLastCompletelyVisibleItemPosition();
        if (r0 >= 0) goto L5;
        return false;
    L5:
        if (this.b.getChildCount() != 0) goto L8;
        return false;
    L8:
        if (r0 < (this.b.getItemCount() - 1)) goto L12;
        return true;
    L12:
        return false;
    }

    public final void l() {
        n(MmSubtitleScrollMode.FOLLOW);
        this.d.e(false, "scrollToBottom");
        this.a.stopScroll();
        this.a.postDelayed(new b(this), 20);
        o(false);
    }

    public final void m() {
        if (this.b.getItemCount() <= 0) goto L6;
        LinearLayoutManager r0 = this.b;
        r0.scrollToPositionWithOffset(r0.getItemCount() - 1, 0);
        return;
    }

    public final void n(MmSubtitleScrollMode r5) {
        if (this.f == r5) goto L6;
        this.f = r5;
        this.e.b(r5);
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.SUBTITLE, "setScrollMode", "mode=" + r5, null, 8);
        return;
    }

    public final void o(boolean r2) {
        View r0 = this.c;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public static final void j(MmSubtitleScrollHelper r2, String r3) {
        if (r2.f == MmSubtitleScrollMode.FOLLOW) goto L5;
        return;
    L5:
        if (r2.d.e == true) goto L10;
        r2.h = r3;
        r2.a.removeCallbacks(r2.i);
        r2.a.post(r2.i);
        return;
    }

    public final void onScrollStateChanged(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrollStateChanged(r2, r3);
        if (r3 != 1) goto L13;
        this.e.c();
        MmSubtitleScrollMode r4 = this.f;
        MmSubtitleScrollMode r0 = MmSubtitleScrollMode.FREE;
        if (r4 == r0) goto L13;
        n(r0);
        if (this.b.getItemCount() > 0) goto L9;
    L11:
        boolean r5 = false;
    L12:
        o(r5);
        goto L13
    L9:
        if (k() == true) goto L11;
        r5 = true;
    L13:
        int r6 = this.b.findFirstVisibleItemPosition();
        if (r6 == 0) goto L17;
        if (r6 == 1) goto L17;
        return;
    L17:
        this.e.a();
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        if (this.b.getItemCount() > 0) goto L5;
        return;
    L5:
        if (k() == false) goto L11;
        MmSubtitleScrollMode r5 = this.f;
        MmSubtitleScrollMode r6 = MmSubtitleScrollMode.FOLLOW;
        if (r5 == r6) goto L9;
        n(r6);
        this.d.e(false, "onScrolledToBottom");
    L9:
        o(false);
        return;
    L11:
        if (this.f != MmSubtitleScrollMode.FREE) goto L16;
        o(true);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleScrollHelper$adapterDataObserver$1] */
    public MmSubtitleScrollHelper(RecyclerView r2, StableLinearLayoutManager r3, UDShadowLayout r4, w r5, n r6) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
        Intrinsics.checkNotNullParameter(r4, "backToBottomView");
        Intrinsics.checkNotNullParameter(r5, "stackFromEndController");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = MmSubtitleScrollMode.FOLLOW;
        this.g = new MmSubtitleScrollHelper$adapterDataObserver$1(this);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r4, new MmSubtitleScrollHelper$initListeners$1(this));
        this.i = new u(this);
    }
}
