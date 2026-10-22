package com.bytedance.android.livesdk.feed.squarefeed;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.fragment.FeedLiveFragment;
import com.bytedance.android.livesdk.feed.openui.view.HorizontalLiveListView;
import com.bytedance.android.livesdk.feed.squarefeed.ui.InterceptTouchLayout;
import com.bytedance.android.livesdk.feed.viewmodel.TimeOutRefreshViewModel;
import com.bytedance.android.livesdkapi.feed.model.HorFollowListParams;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/BaseOpenFeedFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/android/livesdk/feed/squarefeed/e;", "<init>", "()V", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseOpenFeedFragment extends Fragment implements com.bytedance.android.livesdk.feed.squarefeed.e {
    public final PublishSubject<Boolean> d;
    public View e;
    public boolean f;
    public HorizontalLiveListView g;
    public int h;
    public boolean i;
    public ValueAnimator j;
    public final CompositeDisposable k;
    public TimeOutRefreshViewModel l;
    public String m;
    public final int n;

    public static final class a<T> implements Observer {
        public final /* synthetic */ BaseOpenFeedFragment a;

        public a(BaseOpenFeedFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Boolean r6 = (Boolean) r5;
            if (this.a.f == true) goto L5;
        L9:
            ViewGroup.LayoutParams r2 = null;
            if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L22;
            InterceptTouchLayout r0 = this.a.T90();
            if (r0 == null) goto L14;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        L16:
            if ((r1 instanceof RelativeLayout.LayoutParams) == false) goto L19;
            r2 = r1;
        L19:
            RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) r2;
            if (r3 == null) goto L33;
            r3.topMargin = 0;
        L33:
            BaseOpenFeedFragment r4 = this.a;
            boolean r7 = Intrinsics.areEqual(r6, Boolean.FALSE);
            InterceptTouchLayout r8 = r4.T90();
            if (r8 == null) goto L37;
            r8.setInterceptTouchEvent(r7);
            return;
        L37:
            return;
        L14:
            r1 = null;
            goto L16
        L22:
            InterceptTouchLayout r9 = this.a.T90();
            if (r9 == null) goto L25;
            ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        L27:
            if ((r10 instanceof RelativeLayout.LayoutParams) == false) goto L30;
            r2 = r10;
        L30:
            RelativeLayout.LayoutParams r11 = (RelativeLayout.LayoutParams) r2;
            if (r11 == null) goto L33;
            r11.topMargin = this.a.n;
            goto L33
        L25:
            r10 = null;
            goto L27
        L5:
            if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L9;
            BaseOpenFeedFragment r12 = this.a;
            r12.f = false;
            TextView r13 = r12.W90();
            if (r13 == null) goto L9;
            r13.setVisibility(8);
            goto L9
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BaseOpenFeedFragment a;

        public b(BaseOpenFeedFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L19;
            InterceptTouchLayout r4 = this.a.T90();
            ViewGroup.LayoutParams r0 = null;
            if (r4 == null) goto L7;
            ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        L9:
            if ((r5 instanceof RelativeLayout.LayoutParams) == false) goto L12;
            r0 = r5;
        L12:
            RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) r0;
            if (r1 == null) goto L15;
            r1.topMargin = 0;
        L15:
            InterceptTouchLayout r2 = this.a.T90();
            if (r2 == null) goto L20;
            r2.setInterceptTouchEvent(false);
            return;
        L20:
            return;
        L7:
            r5 = null;
            goto L9
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ BaseOpenFeedFragment a;

        public c(BaseOpenFeedFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            TextView r0 = this.a.W90();
            if (r0 == null) goto L6;
            r0.setText(LiveResUtil.getString(2131916623, new Object[]{String.valueOf(r5)}));
            return;
        }
    }

    public static final class d implements View.OnTouchListener {
        public final /* synthetic */ BaseOpenFeedFragment a;

        public d(BaseOpenFeedFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r6, MotionEvent r7) {
            ViewGroup r8 = this.a.V90();
            if (r8 != null) goto L5;
            return false;
        L5:
            if (r8.getVisibility() == 0) goto L7;
            return false;
        L7:
            if (r7.getAction() != 1) goto L46;
            BaseOpenFeedFragment r9 = this.a;
            if (r9.i == false) goto L46;
            ViewGroup r1 = r9.V90();
            if (r1 == null) goto L14;
            int r2 = r1.getMeasuredHeight();
        L15:
            r9.h = r2;
            ValueAnimator r3 = r9.j;
            if (r3 == null) goto L18;
            r3.removeAllUpdateListeners();
        L18:
            ValueAnimator r4 = r9.j;
            if (r4 == null) goto L21;
            r4.removeAllListeners();
        L21:
            ValueAnimator r5 = ValueAnimator.ofInt(new int[]{r9.n, 0}).setDuration(300);
            r9.j = r5;
            if (r5 == null) goto L24;
            r5.addListener(new com.bytedance.android.livesdk.feed.squarefeed.a(r9));
        L24:
            ValueAnimator r10 = r9.j;
            if (r10 == null) goto L27;
            r10.addUpdateListener(new com.bytedance.android.livesdk.feed.squarefeed.b(r9));
        L27:
            ValueAnimator r11 = r9.j;
            if (r11 == null) goto L30;
            r11.start();
        L30:
            TextView r12 = r9.W90();
            if (r12 == null) goto L33;
            r12.setVisibility(0);
        L33:
            TextView r13 = r9.W90();
            if (r13 == null) goto L46;
            ViewPropertyAnimator r14 = r13.animate();
            if (r14 == null) goto L46;
            ViewPropertyAnimator r15 = r14.alpha(1.0f);
            if (r15 == null) goto L46;
            ViewPropertyAnimator r16 = r15.scaleX(1.0f);
            if (r16 == null) goto L46;
            ViewPropertyAnimator r17 = r16.scaleY(1.0f);
            if (r17 == null) goto L46;
            ViewPropertyAnimator r18 = r17.setDuration(300);
            if (r18 == null) goto L46;
            r18.start();
            goto L46
        L14:
            r2 = 0;
        L46:
            return true;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ BaseOpenFeedFragment a;

        public e(BaseOpenFeedFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            BaseOpenFeedFragment r6 = this.a;
            if (r6.i == true) goto L5;
            return;
        L5:
            if (r6.h == 0) goto L46;
            ViewGroup r0 = r6.V90();
            if (r0 == null) goto L10;
            r0.setVisibility(0);
        L10:
            ValueAnimator r1 = r6.j;
            if (r1 == null) goto L13;
            r1.removeAllUpdateListeners();
        L13:
            ValueAnimator r2 = r6.j;
            if (r2 == null) goto L16;
            r2.removeAllListeners();
        L16:
            ValueAnimator r3 = ValueAnimator.ofInt(new int[]{0, r6.n}).setDuration(300);
            r6.j = r3;
            if (r3 == null) goto L19;
            r3.addListener(new com.bytedance.android.livesdk.feed.squarefeed.c(r6));
        L19:
            ValueAnimator r4 = r6.j;
            if (r4 == null) goto L22;
            r4.addUpdateListener(new com.bytedance.android.livesdk.feed.squarefeed.d(r6));
        L22:
            ValueAnimator r7 = r6.j;
            if (r7 == null) goto L25;
            r7.start();
        L25:
            TextView r8 = r6.W90();
            if (r8 == null) goto L40;
            ViewPropertyAnimator r9 = r8.animate();
            if (r9 == null) goto L41;
            ViewPropertyAnimator r10 = r9.alpha(0.0f);
            if (r10 == null) goto L42;
            ViewPropertyAnimator r11 = r10.scaleX(0.01f);
            if (r11 == null) goto L43;
            ViewPropertyAnimator r12 = r11.scaleY(0.01f);
            if (r12 == null) goto L44;
            ViewPropertyAnimator r13 = r12.setDuration(300);
            if (r13 == null) goto L45;
            r13.start();
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L42:
            return;
        L41:
            return;
        L40:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.e
    public final int I9() {
        return 4;
    }

    public void S90() {
    }

    public abstract InterceptTouchLayout T90();

    public abstract String U90();

    public abstract ViewGroup V90();

    public abstract TextView W90();

    public abstract HorFollowListParams X90();

    public abstract int Y90();

    public abstract BannerSwipeRefreshLayout Z90();

    public abstract long aa0();

    public abstract boolean ca0();

    @Override // com.bytedance.android.livesdk.feed.squarefeed.e
    public final int f8() {
        return 10;
    }

    public abstract RecyclerView getRecyclerView();

    public abstract void initView(View r1);

    public BaseOpenFeedFragment() {
        this.d = PublishSubject.create();
        this.k = new CompositeDisposable();
        this.m = "";
        this.n = LiveResUtil.dp2Px(97.0f);
    }

    public final void ba0() {
        TextView r0 = W90();
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        BannerSwipeRefreshLayout r1 = Z90();
        if (r1 == null) goto L9;
        r1.G = getRecyclerView();
    L9:
        if (ca0() == false) goto L25;
        this.g = new HorizontalLiveListView(X90(), requireContext(), null, 0);
        ViewGroup r2 = V90();
        if (r2 == null) goto L13;
        r2.setVisibility(0);
        r2.removeAllViews();
        r2.addView(this.g);
    L13:
        HorizontalLiveListView r3 = this.g;
        if (r3 == null) goto L16;
        r3.j.observe(r3, new a(this));
        r3.h.observe(r3, new b(this));
        r3.l.observe(r3, new c(this));
    L16:
        InterceptTouchLayout r4 = T90();
        if (r4 == null) goto L19;
        r4.setOnTouchListener(new d(this));
    L19:
        TextView r5 = W90();
        if (r5 == null) goto L22;
        r5.setOnClickListener(new e(this));
    L22:
        InterceptTouchLayout r6 = T90();
        if (r6 == null) goto L32;
        r6.setInterceptTouchEvent(true);
        return;
    L32:
        return;
    L25:
        ViewGroup r7 = V90();
        if (r7 == null) goto L28;
        r7.setVisibility(8);
    L28:
        InterceptTouchLayout r8 = T90();
        if (r8 == null) goto L34;
        r8.setInterceptTouchEvent(false);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.k.clear();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.i = false;
        S90();
    }

    public void onResume() {
        super.onResume();
        TimeOutRefreshViewModel r0 = this.l;
        if (r0 == null) goto L6;
        r0.onReturn();
        return;
    }

    public final void onStop() {
        super.onStop();
        TimeOutRefreshViewModel r0 = this.l;
        if (r0 == null) goto L6;
        r0.onLeave();
        return;
    }

    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.i = false;
        this.l = ViewModelProviders.of(this).get(TimeOutRefreshViewModel.class);
        HashMap r4 = new HashMap();
        r4.put("event_type", "click");
        r4.put("event_belong", "tab_click");
        r4.put("enter_from_merge", U90());
        kw1.c.d("live_enter", r4);
        if (getUserVisibleHint() == false) goto L6;
        HashMap r5 = new HashMap();
        r5.put("page_name", FeedLiveFragment.class.getName());
        kw1.b.o().b("ttlive_page", r5);
        return;
    }

    public void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        aa0();
        this.d.onNext(Boolean.valueOf(r3));
        if (r3 == false) goto L7;
        TimeOutRefreshViewModel r4 = this.l;
        if (r4 == null) goto L11;
        r4.onReturn();
        return;
    L11:
        return;
    L7:
        TimeOutRefreshViewModel r5 = this.l;
        if (r5 == null) goto L13;
        r5.onLeave();
        return;
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.i = true;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(Y90(), r3, false);
        this.e = r5;
        if (r5 == null) goto L6;
        initView(r5);
    L6:
        return this.e;
    }
}
