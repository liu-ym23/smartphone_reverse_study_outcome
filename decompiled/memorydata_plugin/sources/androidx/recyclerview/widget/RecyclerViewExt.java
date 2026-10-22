package androidx.recyclerview.widget;

import android.util.Log;
import android.view.MotionEvent;
import androidx.recyclerview.base.EdgeEffectAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/recyclerview/widget/RecyclerViewExt;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mAllowClickDuringOverScroll", "", "mAllowClickDuringOverScrollDebugLogEnabled", "allowClickDuringOverScroll", "", "enable", "isDisallowInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "defaultVal", "log", "message", "", "setAllowClickDuringOverScrollDebugLogEnabled", "Companion", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewExt {
    public static final Companion Companion = null;
    private static final String TAG = "RecyclerViewExt";
    private boolean mAllowClickDuringOverScroll;
    private boolean mAllowClickDuringOverScrollDebugLogEnabled;
    private final RecyclerView recyclerView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/recyclerview/widget/RecyclerViewExt$Companion;", "", "()V", "TAG", "", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RecyclerViewExt(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.recyclerView = r2;
        this.mAllowClickDuringOverScroll = true;
    }

    private final void log(String r1) {
        if (this.mAllowClickDuringOverScrollDebugLogEnabled == false) goto L6;
        Log.d(TAG, r1);
        return;
    }

    public final void allowClickDuringOverScroll(boolean r2) {
        this.mAllowClickDuringOverScroll = r2;
        log(Intrinsics.stringPlus("allowClickDuringOverScroll enable=", Boolean.valueOf(r2)));
    }

    public final boolean isDisallowInterceptTouchEvent(MotionEvent r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.mAllowClickDuringOverScroll == true) goto L7;
        log("allowClickDecision action=" + r10.getActionMasked() + " allow=false result=" + r11);
        return r11;
    L7:
        if (r10.getAction() == 0) goto L9;
        return r11;
    L9:
        EdgeEffectAdapter r0 = this.recyclerView.mHorizontalEdgeEffect;
        EdgeEffectAdapter r2 = this.recyclerView.mVerticalEdgeEffect;
        if (r0 != null) goto L12;
        float r4 = 0.0f;
    L13:
        if (r2 != null) goto L15;
        float r5 = 0.0f;
    L16:
        boolean r7 = true;
        if (r4 != 0.0f) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L29;
        if (r0 != null) goto L24;
    L22:
        boolean r1 = false;
    L26:
        if (r1 == true) goto L29;
        boolean r3 = false;
    L31:
        if (r5 != 0.0f) goto L33;
        boolean r8 = true;
    L34:
        if (r8 == false) goto L43;
        if (r2 != null) goto L38;
    L36:
        boolean r9 = false;
    L40:
        if (r9 == true) goto L43;
        boolean r12 = false;
    L44:
        if (r3 == true) goto L49;
        if (r12 == true) goto L49;
        if (r11 == true) goto L49;
        r7 = false;
    L49:
        log("allowClickDecision action=" + r10.getActionMasked() + " result=" + r7 + " horizontal=" + r4 + " horizontalActive=" + r3 + " vertical=" + r5 + " verticalActive=" + r12);
        return r7;
    L38:
        if (r2.isFinished() == true) goto L36;
        r9 = true;
    L43:
        r12 = true;
        goto L44
    L33:
        r8 = false;
        goto L34
    L24:
        if (r0.isFinished() == true) goto L22;
        r1 = true;
    L29:
        r3 = true;
        goto L31
    L19:
        r6 = false;
        goto L20
    L15:
        r5 = r2.getDistance();
        goto L16
    L12:
        r4 = r0.getDistance();
        goto L13
    }

    public final void setAllowClickDuringOverScrollDebugLogEnabled(boolean r2) {
        this.mAllowClickDuringOverScrollDebugLogEnabled = r2;
        log(Intrinsics.stringPlus("allowClickDuringOverScrollDebugLog enable=", Boolean.valueOf(r2)));
    }
}
