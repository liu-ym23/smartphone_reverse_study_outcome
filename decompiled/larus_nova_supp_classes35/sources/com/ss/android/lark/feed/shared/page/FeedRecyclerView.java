package com.ss.android.lark.feed.shared.page;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0014\u0010\u0015\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ(\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0014R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/FeedRecyclerView;", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialMaxFlingVelocity", "finalMaxFlingVelocity", "onSizeChangedListener", "Lkotlin/Function0;", BuildConfig.FLAVOR, "fling", BuildConfig.FLAVOR, "velocityX", "velocityY", "setOnSizeChangedListener", "listener", "onSizeChanged", SRStrategy.MEDIAINFO_KEY_WIDTH, "h", "oldw", "oldh", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedRecyclerView extends CommonRecyclerView {
    public int k;
    public final int l;
    public Function0<Unit> m;

    public static final class a implements Runnable {
        public final /* synthetic */ FeedRecyclerView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public a(FeedRecyclerView r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FeedRecyclerView.u(this.a, this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public FeedRecyclerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setOnSizeChangedListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.m = r2;
    }

    public FeedRecyclerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean fling(int r3, int r4) {
        if (Math.abs(r4) <= (getMaxFlingVelocity() / 2)) goto L5;
        int r0 = this.k;
        int r5 = Math.max(-r0, Math.min(r4, r0));
        int r1 = this.k;
        int r2 = this.l;
        if (r1 >= r2) goto L11;
        int r6 = r1 + 2000;
        this.k = r6;
        if (r6 <= r2) goto L11;
        this.k = r2;
    L11:
        post(new a(this, r3, r5));
        return true;
    L5:
        return super/*androidx.recyclerview.widget.RecyclerView*/.fling(r3, r4);
    }

    public FeedRecyclerView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        requestDisallowInterceptTouchEvent(true);
        int r6 = (int) (((double) getMaxFlingVelocity()) * 0.5d);
        int r7 = (int) (((double) getMaxFlingVelocity()) * 0.8d);
        int r8 = Build.VERSION.SDK_INT;
        if (r8 >= 23) goto L6;
        this.k = r6;
        this.l = r6;
        return;
    L6:
        if (r8 > 26) goto L8;
        this.k = r6;
        this.l = r7;
        return;
    L8:
        this.k = r7;
        this.l = getMaxFlingVelocity();
    }

    public static final /* synthetic */ void u(FeedRecyclerView r0, int r1, int r2) {
        super/*androidx.recyclerview.widget.RecyclerView*/.fling(r1, r2);
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        Function0<Unit> r5 = this.m;
        if (r5 == null) goto L6;
        r5.invoke();
        return;
    }
}
