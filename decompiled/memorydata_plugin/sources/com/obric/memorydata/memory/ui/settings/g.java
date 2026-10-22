package com.obric.memorydata.memory.ui.settings;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"autoAlignText", "", "Landroid/widget/TextView;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/memory/ui/settings/GlobalMemoryBannerViewHolderKt$autoAlignText$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f11470a;

        a(TextView r1) {
            this.f11470a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f11470a.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
            int r0 = this.f11470a.getLineCount();
            TextView r3 = this.f11470a;
            if (r0 > 1) goto L5;
            int r1 = 17;
        L6:
            r3.setGravity(r1);
            return;
        L5:
            r1 = 8388627;
            goto L6
        }
    }

    public static final void a(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(new a(r3), ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
    }
}
