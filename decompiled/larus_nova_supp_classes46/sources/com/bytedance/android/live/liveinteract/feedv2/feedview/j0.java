package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0 implements jk0.e {
    public final /* synthetic */ MultiLinkRadioFeedView a;

    public static final class a implements Runnable {
        public final /* synthetic */ j0 a;
        public final /* synthetic */ FrameLayout b;

        public a(j0 r1, FrameLayout r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiLinkRadioFeedView.u(this.a.a, this.b, 82);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ j0 a;
        public final /* synthetic */ FrameLayout b;

        public b(j0 r1, FrameLayout r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiLinkRadioFeedView.u(this.a.a, this.b, 136);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // jk0.e
    public final void onStop() {
        MultiLinkRadioFeedView r0 = this.a;
        int r1 = MultiLinkRadioFeedView.C;
        if (r0.x() == false) goto L5;
        MultiLinkRadioFeedView.t(this.a, false, "");
    L5:
        IPreviewMultiLinkOuterConfigProvider r2 = this.a.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        FrameLayout r3 = r2.getContainerView();
        if (r3 == null) goto L12;
        r3.post(new b(this, r3));
        return;
    }

    public j0(MultiLinkRadioFeedView r1) {
        this.a = r1;
    }

    @Override // jk0.e
    public final void onStart(String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        MultiLinkRadioFeedView r0 = this.a;
        int r1 = MultiLinkRadioFeedView.C;
        if (r0.x() == false) goto L5;
        MultiLinkRadioFeedView.t(this.a, true, r3);
    L5:
        IPreviewMultiLinkOuterConfigProvider r4 = this.a.b;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        FrameLayout r5 = r4.getContainerView();
        if (r5 == null) goto L12;
        r5.post(new a(this, r5));
        return;
    }
}
