package com.bytedance.android.live.search.impl.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.search.impl.search.model.LiveSearchResultParam;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/LiveSearchIntermediateView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/search/impl/search/LiveSearchIntermediateView$b;", "listener", "", "setOnDispatchTouchEventListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchIntermediateView extends FrameLayout {
    public LiveSearchIntermediateViewModel a;
    public c b;
    public FragmentManager c;
    public LiveSearchIntermediateFragment d;
    public int e;
    public final d f;
    public b g;

    public static final class a {
    }

    public interface b {
        void c(MotionEvent r1);
    }

    public interface c {
        void d50(LiveSearchResultParam r1);
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ LiveSearchIntermediateView a;

        public d(LiveSearchIntermediateView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 != null) goto L6;
            return;
        L6:
            if (this.a.e != r5.intValue()) goto L8;
        L20:
            this.a.setVisibility(0);
        L22:
            if (r5.intValue() != 0) goto L29;
            LiveSearchIntermediateView r0 = this.a;
            LiveSearchIntermediateFragment r1 = r0.d;
            if (r1 == null) goto L29;
            FragmentManager r2 = r0.c;
            if (r2 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
        L28:
            r2.beginTransaction().hide(r1).commitAllowingStateLoss();
        L29:
            LiveSearchIntermediateView r3 = this.a;
            r3.e = r5.intValue();
            return;
        L8:
            if (r5.intValue() != 0) goto L20;
            LiveSearchIntermediateViewModel r6 = this.a.a;
            if (r6 == null) goto L14;
            NextLiveData<LiveSearchResultParam> r7 = r6.getOpenSearchParam();
            if (r7 == null) goto L14;
            LiveSearchResultParam r8 = (LiveSearchResultParam) r7.getValue();
        L15:
            if (r8 == null) goto L22;
            c r9 = this.a.b;
            if (r9 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("responder");
        L19:
            r9.d50(r8);
            this.a.setVisibility(8);
        L14:
            r8 = null;
            goto L15
        }
    }

    static {
    }

    public LiveSearchIntermediateView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LiveSearchIntermediateView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        FragmentManager r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
    L6:
        if ((r0.findFragmentByTag("tag_intermediate") instanceof LiveSearchIntermediateFragment) == true) goto L17;
        this.d = new LiveSearchIntermediateFragment();
        FragmentManager r1 = this.c;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
    L10:
        FragmentTransaction r2 = r1.beginTransaction();
        LiveSearchIntermediateFragment r3 = this.d;
        if (r3 != null) goto L13;
        return;
    L13:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "tag_intermediate", 2131385515) == true) goto L16;
        r2 = r2.replace(2131385515, r3, "tag_intermediate");
    L16:
        r2.show(r3).commitAllowingStateLoss();
        return;
    L17:
        FragmentManager r4 = this.c;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
    L20:
        FragmentTransaction r5 = r4.beginTransaction();
        LiveSearchIntermediateFragment r6 = this.d;
        if (r6 == null) goto L26;
        r5.show(r6).commitAllowingStateLoss();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        boolean r0 = super.dispatchTouchEvent(r3);
        b r1 = this.g;
        if (r1 == null) goto L5;
        r1.c(r3);
    L5:
        return r0;
    }

    public final void setOnDispatchTouchEventListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g = r2;
    }

    public LiveSearchIntermediateView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setVisibility(0);
        this.e = 0;
        this.f = new d(this);
    }

    public /* synthetic */ LiveSearchIntermediateView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
