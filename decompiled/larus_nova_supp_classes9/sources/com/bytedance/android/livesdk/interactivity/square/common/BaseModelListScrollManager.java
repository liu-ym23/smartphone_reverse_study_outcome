package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class BaseModelListScrollManager {
    public ScrollState a;
    public ScrollState b;
    public int c;
    public boolean d;
    public final SmoothLinearLayoutManager e;
    public final AnonymousClass3 f;
    public Disposable g;
    public IModelListDataManager h;
    public final boolean i;
    public final RecyclerView j;
    public final View k;
    public final TextView l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/square/common/BaseModelListScrollManager$ScrollState;", BuildConfig.FLAVOR, "AutoScroll", "Focus", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ScrollState extends Enum<ScrollState> {
        public static final ScrollState AutoScroll = null;
        public static final ScrollState Focus = null;
        public static final /* synthetic */ ScrollState[] a = null;

        static {
            ScrollState r1 = new ScrollState("AutoScroll", 0);
            AutoScroll = r1;
            ScrollState r2 = new ScrollState("Focus", 1);
            Focus = r2;
            a = new ScrollState[]{r1, r2};
        }

        public static ScrollState valueOf(String r1) {
            return (ScrollState) r27.a.a(ScrollState.class, r1);
        }

        public static ScrollState[] values() {
            return (ScrollState[]) a.clone();
        }

        public ScrollState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void c() {
        if (this.j.canScrollVertically(1) == true) goto L5;
        return;
    L5:
        RecyclerView.Adapter r0 = this.j.getAdapter();
        if (r0 == null) goto L9;
        int r1 = r0.getItemCount() - 1;
        this.j.scrollToPosition(r1);
        b(r1);
        return;
    }

    public static final void a(BaseModelListScrollManager r4) {
        int r0 = r4.e.findLastVisibleItemPosition();
        if (r0 <= r4.c) goto L11;
        IModelListDataManager r1 = r4.h;
        if (r1 == null) goto L9;
        m52.e r2 = r1.c();
        if (r2 == null) goto L9;
        r2.a(Math.max(r2.a - (r0 - r4.c), 0));
    L9:
        r4.b(r0);
        return;
    }

    public final void b(int r2) {
        this.c = Math.max(r2, 0);
    }

    public final void d(ScrollState r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        int r0 = b.a[r4.ordinal()];
        if (r0 != 1) goto L5;
        IModelListDataManager r1 = this.h;
        if (r1 == null) goto L17;
        m52.e r2 = r1.c();
        if (r2 == null) goto L17;
        r2.c = false;
        r2.a(0);
    L17:
        c();
    L18:
        this.a = r4;
        return;
    L5:
        if (r0 != 2) goto L18;
        IModelListDataManager r3 = this.h;
        if (r3 == null) goto L18;
        m52.e r5 = r3.c();
        if (r5 == null) goto L18;
        r5.c = true;
        goto L18
    }

    public final void onEvent(IModelListDataManager.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        IModelListDataManager.ModelChangeType r0 = r3.getType();
        int r1 = b.b[r0.ordinal()];
        if (r1 != 1) goto L5;
        int r4 = r3.b;
        int r2 = this.c;
        if (r4 > r2) goto L20;
        b(r2 + 1);
        return;
    L20:
        return;
    L5:
        if (r1 != 2) goto L21;
        int r5 = this.c;
        int r6 = r3.d;
        if (r5 < r6) goto L10;
        b(r5 - (r6 - r3.c));
        return;
    L10:
        int r7 = r3.c;
        if (r5 < r7) goto L18;
        b(r7);
        return;
    L18:
        return;
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.bytedance.android.livesdk.interactivity.square.common.BaseModelListScrollManager$3] */
    public BaseModelListScrollManager(RecyclerView r3, View r4, NoMoreSpaceTextView r5, float r6) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        Intrinsics.checkNotNullParameter(r4, "hintLayout");
        Intrinsics.checkNotNullParameter(r5, "hintTextView");
        this.j = r3;
        this.k = r4;
        this.l = r5;
        ScrollState r7 = ScrollState.AutoScroll;
        this.a = r7;
        this.b = r7;
        this.i = true;
        r4.setOnClickListener(x0.a(new AnonymousClass1(this)));
        SmoothLinearLayoutManager r8 = new SmoothLinearLayoutManager(r3.getContext());
        r8.p(r6);
        Unit r9 = Unit.INSTANCE;
        this.e = r8;
        ?? r10 = new AnonymousClass3(this);
        this.f = r10;
        RecyclerView.OnFlingListener r11 = new AnonymousClass4(this);
        com.bytedance.android.livesdk.interactivity.square.common.a r0 = new com.bytedance.android.livesdk.interactivity.square.common.a(this);
        r3.setItemAnimator(null);
        r3.setLayoutManager(r8);
        r3.addOnScrollListener(r10);
        r3.setOnFlingListener(r11);
        r3.setOnTouchListener(r0);
    }
}
