package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.viewmodel.OpusPreviewViewModel;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public final NestedScrollView a;
    public final ViewGroup b;
    public final ArrayList<com.bytedance.android.livesdk.ktvapi.model.mv.e<?>> c;
    public final OpusPreviewViewModel d;

    public static final class a implements View.OnScrollChangeListener {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnScrollChangeListener
        public final void onScrollChange(View r7, int r8, int r9, int r11, int r12) {
            if (r9 != r7.getScrollY()) goto L16;
            NestedScrollView r13 = this.a.a;
            if (r13 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("previewContainer");
        L7:
            View r14 = r13.getChildAt(0);
            if (r14 == null) goto L17;
            int r15 = r14.getHeight();
            NestedScrollView r16 = this.a.a;
            if (r16 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("previewContainer");
        L13:
            if ((r16.getHeight() + r9) < r15) goto L18;
            h r17 = this.a;
            r17.getClass();
            ALogger.i("onScrollToEnd", "onScrollToEnd");
            OpusPreviewViewModel.requestMvList$default(r17.d, false, true, null, 4, null);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public h(Context r2, OpusPreviewViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vm");
        this.d = r3;
        this.c = new ArrayList();
        NestedScrollView r4 = LayoutInflater.from(r2).inflate(2131563365, null);
        if (r4 == null) goto L7;
        NestedScrollView r5 = r4;
        this.a = r5;
        r5.setOnScrollChangeListener(new a(this));
        this.b = (ViewGroup) r5.findViewById(2131377467);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.core.widget.NestedScrollView");
    }
}
