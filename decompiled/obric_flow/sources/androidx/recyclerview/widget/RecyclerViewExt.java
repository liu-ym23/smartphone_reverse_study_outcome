package androidx.recyclerview.widget;

import android.view.MotionEvent;
import androidx.recyclerview.base.EdgeEffectAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/recyclerview/widget/RecyclerViewExt;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mAllowClickDuringOverScroll", "", "allowClickDuringOverScroll", "", "enable", "isDisallowInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "defaultVal", "Companion", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewExt {
    public static final Companion Companion = null;
    private static final int MAX_ALLOW_CLICK_OVER_SCROLL_DISTANCE = 100;
    private static final String TAG = "RecyclerViewExt";
    private boolean mAllowClickDuringOverScroll;
    private final RecyclerView recyclerView;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/recyclerview/widget/RecyclerViewExt$Companion;", "", "()V", "MAX_ALLOW_CLICK_OVER_SCROLL_DISTANCE", "", "TAG", "", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RecyclerViewExt(RecyclerView r5) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        this.recyclerView = r5;
    }

    public final void allowClickDuringOverScroll(boolean r5) {
        this.mAllowClickDuringOverScroll = r5;
    }

    public final boolean isDisallowInterceptTouchEvent(MotionEvent r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.mAllowClickDuringOverScroll == true) goto L6;
        return r10;
    L6:
        if (r5.getAction() == 0) goto L8;
        return r10;
    L8:
        RecyclerView r11 = this.recyclerView;
        EdgeEffectAdapter r12 = r11.mHorizontalEdgeEffect;
        EdgeEffectAdapter r13 = r11.mVerticalEdgeEffect;
        if (r12 != null) goto L11;
    L16:
        if (r13 == null) goto L24;
        if (r13.getDistance() == 0.0f) goto L24;
        if (Math.abs(r13.getDistance()) >= 100.0f) goto L24;
        return true;
    L24:
        return r10;
    L11:
        if (r12.getDistance() == 0.0f) goto L16;
        if (Math.abs(r12.getDistance()) >= 100.0f) goto L16;
        r10 = true;
        goto L16
    }
}
