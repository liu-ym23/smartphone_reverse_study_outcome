package com.ss.android.lark.officesdk.minutes.ui.record.widget.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.record.panel.MmRecordingPanelFactory;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/widget/more/MmLittleAppCapsuleView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "littleAppCapsuleLayout", "Landroid/view/View;", "ivMore", "Landroid/widget/ImageView;", "ivBack", "listener", "Lcom/ss/android/lark/officesdk/minutes/ui/record/widget/more/MmLittleAppCapsuleView$Listener;", "hostFragment", "Landroidx/fragment/app/Fragment;", "setListener", "", "setHostFragment", "fragment", "updateTheme", "onDetachedFromWindow", "Listener", "officesdk-minutes-doubao-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmLittleAppCapsuleView extends FrameLayout {
    public static final /* synthetic */ int c = 0;
    public final View a;
    public Fragment b;

    public interface a {
    }

    public MmLittleAppCapsuleView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmLittleAppCapsuleView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setListener(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Fragment r0 = this.b;
        if (r0 == null) goto L6;
        int r1 = MmRecordingPanelFactory.a;
        Intrinsics.checkNotNullParameter(r0, "fragment");
        MmRecordingPanelFactory.a(r0.getChildFragmentManager(), "MmMoreActionDialog");
        return;
    }

    public final void setHostFragment(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.b = r2;
    }

    public MmLittleAppCapsuleView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        LayoutInflater.from(r10).inflate(2131564093, this, true);
        View r13 = findViewById(2131378204);
        this.a = r13;
        ImageView r14 = (ImageView) findViewById(2131375920);
        ImageView r2 = (ImageView) findViewById(2131375900);
        int r3 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        int r0 = zvb.a.b;
        r13.setBackground(zvb.a.C0209a.b(r10, 2131102022, Float.valueOf(0.8f), 18, 2131102045, 1));
        h.a(r14, new AnonymousClass1(this));
        h.a(r2, new AnonymousClass2(this));
    }

    public /* synthetic */ MmLittleAppCapsuleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
