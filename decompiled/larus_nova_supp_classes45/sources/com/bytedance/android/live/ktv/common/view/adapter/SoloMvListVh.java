package com.bytedance.android.live.ktv.common.view.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.message.model.ag;
import com.bytedance.android.livesdk.message.model.od;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/adapter/SoloMvListVh;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class SoloMvListVh extends RecyclerView.ViewHolder {
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public View a;
    public final View b;
    public final HSImageView c;
    public final FrameLayout d;
    public LiveDoubleColorBallAnimationView e;
    public final com.bytedance.android.live.ktv.common.view.adapter.b f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SoloMvListVh a;
        public final /* synthetic */ int b;
        public final /* synthetic */ c c;
        public final /* synthetic */ od d;

        public b(SoloMvListVh r1, int r2, c r3, od r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            SoloMvListVh r4 = this.a;
            if (r4.a != null) goto L11;
            r4.f.c(this.b, this.c);
            View r5 = this.a.b;
            if (r5 == null) goto L7;
            r5.setVisibility(8);
        L7:
            this.a.V3();
            if (this.a.f.b(this.d) == true) goto L12;
            this.a.U3();
            return;
        L12:
            return;
        }
    }

    static {
        s1.f(65.0f);
        g = s1.f(88.0f);
        h = s1.f(10.0f);
        i = s1.f(18.0f);
    }

    public final void U3() {
        if (this.e != null) goto L6;
        View r0 = new LiveDoubleColorBallAnimationView(((RecyclerView.ViewHolder) this).itemView.getContext());
        FrameLayout r1 = this.d;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams((int) s1.e(20.0f), (int) s1.e(20.0f));
        r2.gravity = 17;
        Unit r3 = Unit.INSTANCE;
        r1.addView(r0, r2);
        r0.b();
        this.e = r0;
        return;
    }

    public final void V3() {
        this.f.d(new SoloMvListVh$showSelected$1(this));
        View r0 = this.a;
        if (r0 != null) goto L5;
        r0 = new View(((RecyclerView.ViewHolder) this).itemView.getContext());
        this.a = r0;
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.setBackgroundResource(2131247402);
        this.d.addView(r0);
    L5:
        r0.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.View, com.bytedance.android.live.core.widget.HSImageView] */
    public SoloMvListVh(View r4, com.bytedance.android.live.ktv.common.view.adapter.b r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "adapterClickCb");
        super(r4);
        this.f = r5;
        View r6 = new View(r4.getContext());
        r6.setBackgroundResource(2131253063);
        int r1 = i;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r1, r1);
        r0.gravity = 8388613;
        r0.leftMargin = s1.f(2.0f);
        r0.topMargin = s1.f(2.0f);
        Unit r2 = Unit.INSTANCE;
        r6.setLayoutParams(r0);
        this.b = r6;
        ?? r3 = new HSImageView(r4.getContext());
        this.c = r3;
        FrameLayout r7 = new FrameLayout(r4.getContext());
        r7.addView(r3, new ViewGroup.LayoutParams(-1, -1));
        r7.addView(r6);
        this.d = r7;
    }

    public void T3(c r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "data");
        od r7 = r4.a;
        if (r7 != null) goto L5;
        return;
    L5:
        ag r0 = r7.a();
        if (r0 == null) goto L16;
        String r1 = r0.a();
        if (r1 == null) goto L16;
        if ((!TextUtils.isEmpty(r1)) == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L16;
        this.c.setImageURI(r1);
    L16:
        if (r4.b == false) goto L18;
        V3();
    L24:
        if (this.f.b(r7) == false) goto L32;
        View r2 = this.b;
        if (r2 == null) goto L28;
        r2.setVisibility(8);
    L28:
        View r3 = this.e;
        if (r3 == null) goto L40;
        r3.c();
        this.d.removeView(r3);
    L40:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new b(this, r5, r4, r7));
        return;
    L32:
        if (this.f.a(r7) == false) goto L36;
        U3();
        View r8 = this.b;
        if (r8 == null) goto L40;
        r8.setVisibility(8);
        goto L40
    L36:
        View r9 = this.e;
        if (r9 == null) goto L39;
        r9.c();
        this.d.removeView(r9);
    L39:
        this.b.setVisibility(0);
        goto L40
    L18:
        View r11 = this.a;
        if (r11 == null) goto L24;
        if (r11 == null) goto L22;
        this.d.removeView(r11);
    L22:
        this.a = null;
        goto L24
    }
}
