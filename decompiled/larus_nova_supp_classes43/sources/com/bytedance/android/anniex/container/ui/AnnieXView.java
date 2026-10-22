package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.p0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/anniex/container/n;", "container", "", "setViewContainer$anniex_release", "(Lcom/bytedance/android/anniex/container/n;)V", "setViewContainer", "Lka/c;", "listener", "setListener$anniex_release", "(Lka/c;)V", "setListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXView extends FrameLayout {
    public com.bytedance.android.anniex.container.n a;

    public static final class a extends ia.i.a {
        public final /* synthetic */ AnnieXView a;

        @Override // ia.j
        public final View b() {
            com.bytedance.android.anniex.container.n r0 = this.a.a;
            if (r0 == null) goto L21;
            int r10 = com.bytedance.android.anniex.container.util.e.a;
            Intrinsics.checkNotNullParameter(r0, "container");
            t36.d r11 = r0.getSchemaData();
            if (r11 != null) goto L7;
            return null;
        L7:
            if (Intrinsics.areEqual(((y36.i) new y36.p(r11, "error_page_style", null)).b, "host") == false) goto L9;
            HybridLogger.f("CustomViewUtil", "use host theme to create error view", null, 12);
            String r12 = "default_bid";
        L10:
            String r13 = r0.getViewType();
            s26.d r14 = s26.d.c;
            p0 r15 = s26.d.c.d(r12, p0.class);
            if (r15 == null) goto L23;
            com.bytedance.ies.bullet.service.base.i r16 = r15.n(r0.getSystemContext(), r13);
            if (r16 == null) goto L24;
            View r1 = r16.a(new com.bytedance.android.anniex.container.util.c(r0), new com.bytedance.android.anniex.container.util.d(r0));
            if (r1 == null) goto L25;
            FrameLayout.LayoutParams r17 = r15.c0(r13);
            if (r17 == null) goto L20;
            r1.setLayoutParams(r17);
        L20:
            return r1;
        L25:
            return null;
        L24:
            return null;
        L23:
            return null;
        L9:
            HybridLogger.f("CustomViewUtil", "use custom theme to create error view", null, 12);
            r12 = r0.getBid();
            goto L10
        L21:
            return null;
        }

        @Override // ia.j
        public final View c() {
            com.bytedance.android.anniex.container.n r0 = this.a.a;
            if (r0 == null) goto L21;
            int r10 = com.bytedance.android.anniex.container.util.e.a;
            Intrinsics.checkNotNullParameter(r0, "container");
            t36.d r11 = r0.getSchemaData();
            if (r11 != null) goto L7;
            return null;
        L7:
            if (Intrinsics.areEqual(((y36.i) new y36.p(r11, "loading_style", null)).b, "host") == false) goto L9;
            HybridLogger.f("CustomViewUtil", "use host theme to create loading view", null, 12);
            String r12 = "default_bid";
        L10:
            String r13 = r0.getViewType();
            s26.d r14 = s26.d.c;
            p0 r15 = s26.d.c.d(r12, p0.class);
            if (r15 == null) goto L23;
            com.bytedance.ies.bullet.service.base.q r1 = r15.b(r0.getSystemContext(), r13);
            if (r1 == null) goto L24;
            View r16 = r1.getView();
            if (r16 == null) goto L25;
            FrameLayout.LayoutParams r17 = r15.B0(r13);
            if (r17 == null) goto L20;
            r16.setLayoutParams(r17);
        L20:
            return r16;
        L25:
            return null;
        L24:
            return null;
        L23:
            return null;
        L9:
            HybridLogger.f("CustomViewUtil", "use custom theme to create loading view", null, 12);
            r12 = r0.getBid();
            goto L10
        L21:
            return null;
        }

        public a(AnnieXView r1) {
            this.a = r1;
        }
    }

    public final void setListener$anniex_release(ka.c r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void setViewContainer$anniex_release(com.bytedance.android.anniex.container.n r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        this.a = r10;
    }

    public AnnieXView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        new a(this);
    }
}
