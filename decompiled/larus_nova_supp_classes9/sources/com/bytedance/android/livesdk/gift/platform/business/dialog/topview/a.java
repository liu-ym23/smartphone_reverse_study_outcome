package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements d {
    public final ViewGroup a;
    public final g b;
    public h1 c;
    public e0 d;
    public final Context e;
    public final DataCenter f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0016a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0016a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.d();
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d
    public void a() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d
    public void b() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d
    public void c() {
    }

    public abstract void d();

    public void e(long r1) {
    }

    public void f(p2 r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
    }

    public abstract void g(e0 r1);

    public final Context getContext() {
        return this.e;
    }

    public a(Context r9, DataCenter r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        this.e = r9;
        this.f = r10;
        View r13 = LayoutInflater.from(r9).inflate(r11, new FrameLayout(r9), false);
        if (r13 == null) goto L7;
        ViewGroup r14 = (ViewGroup) r13;
        this.a = r14;
        r14.setOnClickListener(new ViewOnClickListenerC0016a(this));
        this.b = new g(r14, a1.b(r14.getLayoutParams(), null, null, null, null, null, null, null), this);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
