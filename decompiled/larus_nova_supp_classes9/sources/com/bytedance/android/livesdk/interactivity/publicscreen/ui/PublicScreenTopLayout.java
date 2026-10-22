package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/PublicScreenTopLayout;", "Landroid/widget/LinearLayout;", BuildConfig.FLAVOR, "topMargin", BuildConfig.FLAVOR, "setTopMarginWhenShowing", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenTopLayout extends LinearLayout {
    public final int a;
    public boolean b;
    public int c;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PublicScreenTopLayout a;

        public b(PublicScreenTopLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a1.o(this.a, 0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ PublicScreenTopLayout a;

        public c(PublicScreenTopLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PublicScreenTopLayout r0 = this.a;     // Catch: Throwable -> L4
            a1.o(r0, r0.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public PublicScreenTopLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PublicScreenTopLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        int r0 = a1.h(this);
        boolean r1 = this.b;
        if (r1 == true) goto L5;
    L6:
        if (r0 <= 0) goto L8;
        b(0, r0, r1, this.c);
        postOnAnimation(new b(this));
        return;
    L8:
        if (r1 == false) goto L15;
        int r2 = this.c;
        if (r2 <= 0) goto L16;
        if (r0 == r2) goto L17;
        b(r2, r0, r1, r2);
        postOnAnimation(new c(this));
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (this.c > 0) goto L8;
        goto L6
    }

    public final void setTopMarginWhenShowing(int r1) {
        this.c = r1;
        a();
    }

    public PublicScreenTopLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = s1.f(5.0f);
    }

    public /* synthetic */ PublicScreenTopLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void b(int r2, int r3, boolean r4, int r5) {
        ALogger.i("PublicScreenTopLayout", "newTopMargin:" + r2 + ", children showing:" + r4 + ", topMarginWhenShowing:" + r5 + ", oldTopMargin:" + r3);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r4, int r5, int r6, int r7) {
        super.onSizeChanged(r4, r5, r6, r7);
        int r8 = this.a;
        if (r7 >= r8) goto L6;
        if (r5 <= r8) goto L6;
        this.b = true;
        ALogger.i("PublicScreenTopLayout", "has showing children, old h:" + r7 + ", new h:" + r5 + ' ');
        a();
        return;
    L6:
        if (r7 <= r8) goto L11;
        if (r5 >= r8) goto L12;
        this.b = false;
        ALogger.i("PublicScreenTopLayout", "children all dismiss, old h:" + r7 + ", new h:" + r5 + ' ');
        a();
        return;
    L12:
        return;
    }
}
