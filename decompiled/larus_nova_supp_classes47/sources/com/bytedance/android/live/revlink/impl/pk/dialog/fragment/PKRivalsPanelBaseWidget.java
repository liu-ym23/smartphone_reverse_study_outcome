package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revlink.impl.control.dialog.r;
import com.bytedance.android.live.revlink.impl.pk.utils.u;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/PKRivalsPanelBaseWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsPanelBaseWidget extends LiveRecyclableWidget {
    public ViewGroup a;
    public ViewGroup b;
    public ViewGroup c;
    public ViewGroup d;
    public ViewGroup e;
    public TextView f;
    public TextView g;
    public View h;
    public PKRivalsPanelSearchWidget i;
    public final com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j j;
    public final r k;
    public final View l;
    public final boolean m;
    public final String n;
    public final u o;

    public static final class a<T> implements Observer {
        public final /* synthetic */ PKRivalsPanelBaseWidget a;

        public a(PKRivalsPanelBaseWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            List r8 = (List) r7;
            PKRivalsPanelBaseWidget r0 = this.a;
            if (r8 != null) goto L5;
        L8:
            boolean r9 = true;
        L10:
            if (r9 == false) goto L27;
            ViewGroup r10 = r0.d;
            if (r10 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("mListLayout");
        L14:
            r10.setVisibility(8);
            ViewGroup r12 = r0.c;
            if (r12 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchLayout");
        L17:
            r12.setVisibility(0);
            ViewGroup r13 = r0.e;
            if (r13 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        L20:
            r13.setVisibility(0);
            TextView r14 = r0.f;
            if (r14 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyHintPhase1Tv");
        L23:
            r14.setText(s1.B(2131921541));
            TextView r15 = r0.g;
            if (r15 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyHintPhase2Tv");
        L26:
            r15.setText(s1.B(2131921542));
        L37:
            ViewGroup r16 = r0.a;
            if (r16 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("mPreloadLayout");
        L40:
            r16.setVisibility(8);
            View r17 = r0.h;
            if (r17 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        L43:
            r17.setVisibility(8);
            PKRivalsPanelSearchWidget r18 = this.a.i;
            if (r18 == null) goto L47;
            r18.Aq();
            return;
        L47:
            return;
        L27:
            ViewGroup r19 = r0.e;
            if (r19 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        L30:
            r19.setVisibility(8);
            ViewGroup r20 = r0.c;
            if (r20 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchLayout");
        L33:
            r20.setVisibility(0);
            ViewGroup r22 = r0.d;
            if (r22 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("mListLayout");
        L36:
            r22.setVisibility(0);
            goto L37
        L5:
            if (r8.isEmpty() == true) goto L8;
            r9 = false;
            goto L10
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ PKRivalsPanelBaseWidget a;

        public b(PKRivalsPanelBaseWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            Intrinsics.checkNotNull(r5);
            if (r5.booleanValue() == false) goto L14;
            ViewGroup r6 = this.a.a;
            if (r6 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mPreloadLayout");
        L7:
            r6.setVisibility(0);
            View r7 = this.a.h;
            if (r7 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        L10:
            r7.setVisibility(0);
            ViewGroup r8 = this.a.d;
            if (r8 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mListLayout");
        L13:
            r8.setVisibility(8);
            return;
        L14:
            ViewGroup r9 = this.a.a;
            if (r9 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mPreloadLayout");
        L17:
            r9.setVisibility(8);
            View r10 = this.a.h;
            if (r10 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        L20:
            r10.setVisibility(8);
        }
    }

    public final int getLayoutId() {
        return 2131566742;
    }

    public final void onUnload() {
        this.j.i(this);
    }

    public final void onInit(Object[] r2) {
        this.a = (ViewGroup) findViewById(2131382878);
        this.b = (ViewGroup) findViewById(2131367794);
        this.c = (ViewGroup) findViewById(2131385642);
        this.d = (ViewGroup) findViewById(2131378190);
        this.e = (ViewGroup) findViewById(2131385837);
        this.f = (TextView) findViewById(2131371577);
        this.g = (TextView) findViewById(2131371578);
        this.h = findViewById(2131370124);
        ViewGroup r3 = this.c;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchLayout");
    L5:
        r3.bringToFront();
    }

    public final void onLoad(Object[] r9) {
        this.j.e.observe(this, new a(this));
        this.j.p.observe(this, new b(this));
        enableSubWidgetManager();
        PKRivalsPanelSearchWidget r10 = new PKRivalsPanelSearchWidget(this.j, this.k, this.l, this.m, this.n, this.o);
        this.i = r10;
        ((Widget) this).subWidgetManager.load(2131385642, r10);
        PKRivalsPanelListWidget r12 = new PKRivalsPanelListWidget(this.j, this.n, this.o.a);
        ((Widget) this).subWidgetManager.load(2131378190, r12);
        HSImageView r13 = findViewById(2131371572);
        int r0 = r41.c.a;
        ImageLoader.bindImage(r13, "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_bg_pk_rivals_search_empty_dy.png");
    }

    public PKRivalsPanelBaseWidget(com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r2, r r3, View r4, boolean r5, String r6, u r7) {
        Intrinsics.checkNotNullParameter(r2, "mPresenter");
        Intrinsics.checkNotNullParameter(r3, "mDialog");
        Intrinsics.checkNotNullParameter(r4, "mTopView");
        Intrinsics.checkNotNullParameter(r6, "mActivityName");
        Intrinsics.checkNotNullParameter(r7, "searchSource");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.n = r6;
        this.o = r7;
    }
}
