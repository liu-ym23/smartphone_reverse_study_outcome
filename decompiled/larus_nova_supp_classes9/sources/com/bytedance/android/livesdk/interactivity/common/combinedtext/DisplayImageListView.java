package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0004\rR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/DisplayImageListView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/m;", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "a", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "getOnSchemaHandleListener", "()Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "setOnSchemaHandleListener", "(Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;)V", "onSchemaHandleListener", "Lkotlin/Function0;", BuildConfig.FLAVOR, "b", "Lkotlin/jvm/functions/Function0;", "getRenderCallback", "()Lkotlin/jvm/functions/Function0;", "renderCallback", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DisplayImageListView extends FrameLayout implements m {
    public o a;
    public final Function0<Unit> b;

    public static final class a {
        public int a;
        public int b;
        public boolean c;
        public float d;
        public Drawable e;
        public boolean f;

        public a(int r1, int r2) {
            this.a = r1;
            this.b = r2;
            this.c = true;
            this.d = 0.0f;
            this.e = null;
            this.f = false;
        }
    }

    public static final class b {
        public int a;
        public final int b;
        public final Function0<Unit> c;

        public b(int r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r3, "onAllLoadEndCallback");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements e {
        public final /* synthetic */ n a;

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.e
        public final void a() {
            this.a.a();
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.e
        public final void b() {
            this.a.b();
        }

        public c(CombinedTextRenderView.b r1) {
            this.a = r1;
        }
    }

    public DisplayImageListView() {
        throw null;
    }

    public DisplayImageListView(Context r7) {
        this(r7, null, 0, null, 14);
    }

    public DisplayImageListView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, null, 12);
    }

    public DisplayImageListView(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, null, 8);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.m
    public final void f(com.bytedance.android.live.base.model.message.f r1, n r2) {
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r1, int r2) {
        return (r1 - 1) - r2;
    }

    public final o getOnSchemaHandleListener() {
        return this.a;
    }

    public final Function0<Unit> getRenderCallback() {
        return this.b;
    }

    public final void setOnSchemaHandleListener(o r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.m
    public final void n(com.bytedance.android.live.base.model.message.f r1, n r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "comboItem");
        Intrinsics.checkNotNullParameter(r2, "comboListener");
        if (r1.d() != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.common.combinedtext.a.a(this, new c((CombinedTextRenderView.b) r2)).start();
    }

    public DisplayImageListView(Context r2, AttributeSet r3, int r4, Function0 r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = AnonymousClass1.INSTANCE;
    L11:
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "renderCallback");
        super(r2, r3, r4);
        this.b = r5;
        setChildrenDrawingOrderEnabled(true);
    }
}
