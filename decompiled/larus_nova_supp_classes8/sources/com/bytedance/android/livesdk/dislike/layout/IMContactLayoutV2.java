package com.bytedance.android.livesdk.dislike.layout;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.dislike.action.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/IMContactLayoutV2;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/dislike/l;", "item", "", "update", "Landroidx/fragment/app/Fragment;", "fragment", "setFragment", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMContactLayoutV2 extends FrameLayout {
    public final IMContactDescItemLayoutV2 a;
    public l b;
    public final FrameLayout c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            f2.c(this.a, 0);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ IMContactLayoutV2 a;

        public b(IMContactLayoutV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            l r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.b(r2);
            return;
        }
    }

    public IMContactLayoutV2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        View.inflate(getContext(), 2131565626, this);
        this.a = (IMContactDescItemLayoutV2) findViewById(2131368830);
        this.c = (FrameLayout) findViewById(2131374914);
    }

    public final void setFragment(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a.setFragment(r2);
    }

    public final void update(com.bytedance.android.livesdk.dislike.l r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this.b = r2.d;
        this.a.update(r2.c);
    }

    public IMContactLayoutV2(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        View.inflate(getContext(), 2131565626, this);
        this.a = (IMContactDescItemLayoutV2) findViewById(2131368830);
        this.c = (FrameLayout) findViewById(2131374914);
    }

    public final void b(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "tipContent");
        if (r3 == false) goto L10;
        FrameLayout r5 = this.c;
        if (r5 == null) goto L14;
        TextView r0 = (TextView) r5.findViewById(2131374915);
        if (r0 == null) goto L9;
        r0.setBackground(s1.m(2131249491));
    L9:
        r5.setOnClickListener(new a(r4));
        return;
    L14:
        return;
    L10:
        FrameLayout r6 = this.c;
        if (r6 == null) goto L16;
        r6.setOnClickListener(new b(this));
        r6.setOnTouchListener(new nt1.a(this));
        return;
    }

    public IMContactLayoutV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View.inflate(getContext(), 2131565626, this);
        this.a = (IMContactDescItemLayoutV2) findViewById(2131368830);
        this.c = (FrameLayout) findViewById(2131374914);
    }

    public static final void a(IMContactLayoutV2 r4, boolean r5, View r6) {
        r4.getClass();
        float[] r7 = new float[2];
        float r0 = 1.0f;
        if (r5 == false) goto L5;
        float r2 = 1.0f;
    L6:
        r7[0] = r2;
        if (r5 == false) goto L9;
        r0 = 0.75f;
    L9:
        r7[1] = r0;
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r6, "alpha", r7);
        r8.setDuration(100);
        r8.start();
        return;
    L5:
        r2 = 0.75f;
        goto L6
    }
}
