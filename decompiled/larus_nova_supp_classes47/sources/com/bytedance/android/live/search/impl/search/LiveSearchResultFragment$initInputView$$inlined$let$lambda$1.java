package com.bytedance.android.live.search.impl.search;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.EditText;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/search/impl/search/LiveSearchResultFragment$initInputView$2$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchResultFragment$initInputView$$inlined$let$lambda$1 extends AccessibilityDelegateCompat {
    public boolean a;
    public final /* synthetic */ LiveSearchResultFragment b;

    public static final class a implements Runnable {
        public final /* synthetic */ LiveSearchResultFragment$initInputView$$inlined$let$lambda$1 a;
        public final /* synthetic */ View b;

        public a(LiveSearchResultFragment$initInputView$$inlined$let$lambda$1 r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveSearchResultFragment$initInputView$$inlined$let$lambda$1 r0 = this.a;     // Catch: Throwable -> L6
            r0.a = true;     // Catch: Throwable -> L6
            EditText r1 = r0.b.g;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.sendAccessibilityEvent(8);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public LiveSearchResultFragment$initInputView$$inlined$let$lambda$1(LiveSearchResultFragment r1) {
        this.b = r1;
    }

    public final boolean dispatchPopulateAccessibilityEvent(View r2, AccessibilityEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "event");
        return super.dispatchPopulateAccessibilityEvent(r2, r3);
    }

    public final void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "info");
        super.onInitializeAccessibilityNodeInfo(r2, r3);
        r3.setContentDescription(s1.B(2131922377));
        r3.setClassName(Button.class.getName());
    }

    public final void onPopulateAccessibilityEvent(View r3, AccessibilityEvent r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "event");
        super.onPopulateAccessibilityEvent(r3, r4);
        if (r4.getEventType() == 32768) goto L5;
        return;
    L5:
        if (this.a == false) goto L8;
        this.a = false;
        return;
    L8:
        ViewCompat.isAttachedToWindow(r3);
        r3.postDelayed(new a(this, r3), 10);
    }
}
