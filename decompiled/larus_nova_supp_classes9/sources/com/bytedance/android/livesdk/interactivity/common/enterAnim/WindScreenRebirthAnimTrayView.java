package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.message.o6;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.o;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/WindScreenRebirthAnimTrayView;", "Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/BaseWindScreenAnimEnterTrayView;", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "listener", BuildConfig.FLAVOR, "setOnSchemaHandleListener", BuildConfig.FLAVOR, "textSize", "setTextSize", "Landroid/animation/Animator;", "k", "Landroid/animation/Animator;", "getDelegateReleaseAnimator", "()Landroid/animation/Animator;", "delegateReleaseAnimator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindScreenRebirthAnimTrayView extends BaseWindScreenAnimEnterTrayView {
    public static final int l = 0;
    public static final int m = 0;
    public final View b;
    public final View c;
    public final HSImageView d;
    public final HSImageView e;
    public final TextView f;
    public final RadiusHSImageView g;
    public AnimatorSet h;
    public h3 i;
    public com.bytedance.android.livesdk.interactivity.enteranim.utils.i j;
    public final e k;

    public static final class a {
    }

    public static final class b extends q0 {
        public final /* synthetic */ WindScreenRebirthAnimTrayView a;

        public b(WindScreenRebirthAnimTrayView r1) {
            this.a = r1;
        }

        public final void h(py.k r2, int r3, int r4) {
            if (r3 <= 0) goto L6;
            if (r4 <= 0) goto L7;
            ViewGroup.LayoutParams r5 = this.a.d.getLayoutParams();
            int r0 = WindScreenRebirthAnimTrayView.m;
            r5.height = r0;
            r5.width = (r3 / r4) * r0;
            this.a.d.setLayoutParams(r5);
            return;
        L7:
            return;
        }
    }

    public static final class c extends q0 {
        public final /* synthetic */ WindScreenRebirthAnimTrayView a;

        public c(WindScreenRebirthAnimTrayView r1) {
            this.a = r1;
        }

        public final void h(py.k r2, int r3, int r4) {
            if (r3 <= 0) goto L6;
            if (r4 <= 0) goto L7;
            ViewGroup.LayoutParams r5 = this.a.e.getLayoutParams();
            int r0 = WindScreenRebirthAnimTrayView.m;
            r5.height = r0;
            r5.width = (r3 / r4) * r0;
            this.a.e.setLayoutParams(r5);
            return;
        L7:
            return;
        }
    }

    public static final class d implements ak6.e {
        public final /* synthetic */ WindScreenRebirthAnimTrayView a;

        public d(WindScreenRebirthAnimTrayView r1) {
            this.a = r1;
        }

        public final void a(ak6.g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            Intrinsics.checkNotNullParameter(r2, "rendResult");
        }

        public final void b(ak6.g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            this.a.f.setText(r2.a);
        }
    }

    public static final class e extends Animator {
        public final /* synthetic */ WindScreenRebirthAnimTrayView a;

        @Override // android.animation.Animator
        public final long getDuration() {
            return 0;
        }

        @Override // android.animation.Animator
        public final long getStartDelay() {
            return 0;
        }

        @Override // android.animation.Animator
        public final boolean isRunning() {
            return false;
        }

        @Override // android.animation.Animator
        public final Animator setDuration(long r1) {
            return this;
        }

        @Override // android.animation.Animator
        public final void setInterpolator(TimeInterpolator r1) {
        }

        @Override // android.animation.Animator
        public final void setStartDelay(long r1) {
        }

        @Override // android.animation.Animator
        public final void cancel() {
            super.cancel();
            AnimatorSet r0 = this.a.h;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            this.a.g.setVisibility(8);
        }

        public e(WindScreenRebirthAnimTrayView r1) {
            this.a = r1;
        }
    }

    public WindScreenRebirthAnimTrayView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public WindScreenRebirthAnimTrayView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final void U5(int r1, int r2) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public void setTextSize(float r1) {
    }

    static {
        l = s1.f(24.0f);
        m = s1.f(16.0f);
    }

    public final Animator getDelegateReleaseAnimator() {
        return this.k;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final void R5(k32.d r19) {
        List r2 = null;
        if (r19 == null) goto L5;
        h3 r3 = r19.t;
    L6:
        this.i = r3;
        if (r3 == null) goto L18;
        List r4 = r3.N();
        if (r4 == null) goto L18;
        if (r4.size() < 2) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        r2 = r4;
    L16:
        if (r2 == null) goto L18;
        py.k r9 = (py.k) ListProtector.get(r2, 0);
        py.k r6 = (py.k) ListProtector.get(r2, 1);
        ImageLoader.bindImage(this.d, r9, null, -1, -1, null, new b(this), true);
        ImageLoader.bindImage(this.e, r6, null, -1, -1, null, new c(this), true);
    L19:
        yb2.a r7 = w.a();
        r7.m = 7;
        if (r19 == null) goto L35;
        h3 r1 = r19.t;
        if (r1 == null) goto L36;
        com.bytedance.android.live.base.model.message.d r8 = r1.I0();
        if (r8 == null) goto L37;
        List r10 = r8.b();
        if (r10 == null) goto L38;
        com.bytedance.android.live.base.model.message.f r11 = (com.bytedance.android.live.base.model.message.f) ListProtector.get(r10, 0);
        if (r11 == null) goto L39;
        o6 r13 = r11.g();
        if (r13 == null) goto L40;
        a5 r14 = r13.a();
        if (r14 == null) goto L41;
        LiveRichContentEngine.a().a().c(mb2.d.a(r14, r7, 1.0f), new qb2.g(false, 0.0f, 7), new d(this));
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L13:
        r5 = false;
    L18:
        ALogger.e("WindScreenRebirthAnimTrayView", "icons list is empty!");
        goto L19
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setOnSchemaHandleListener(final o r5) {
        h3 r0 = this.i;
        if (r0 == null) goto L9;
        com.bytedance.android.live.base.model.message.d r1 = r0.I0();
        if (r1 == null) goto L9;
        m6 r2 = r1.c();
        if (r2 == null) goto L9;
        final String r3 = r2.a();
    L11:
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
        setOnClickListener(x0.a(new AnonymousClass1(r3, r5)));
        return;
    L19:
        setOnClickListener(null);
        setClickable(false);
        return;
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
    L9:
        r3 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindScreenRebirthAnimTrayView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ViewGroup.inflate(r2, 2131568048, this);
        this.b = findViewById(2131384822);
        this.c = findViewById(2131380904);
        this.d = findViewById(2131381429);
        this.e = findViewById(2131380696);
        this.f = (TextView) findViewById(2131367858);
        this.g = (RadiusHSImageView) findViewById(2131387815);
        this.k = new e(this);
    }

    public /* synthetic */ WindScreenRebirthAnimTrayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
