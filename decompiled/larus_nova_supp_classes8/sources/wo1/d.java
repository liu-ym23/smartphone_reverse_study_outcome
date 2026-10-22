package wo1;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.browser.jsbridge.base.ChangeShortTouchSizeResultModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.ShortTermIndicatorManager;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.CommonIconTemplate;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import w20.p;
import w20.y7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends p<y7, ChangeShortTouchSizeResultModel> {
    public final com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f a;

    public final void onTerminate() {
    }

    public d(com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r2) {
        Intrinsics.checkNotNullParameter(r2, "commonIconModel");
        this.a = r2;
    }

    public final void invoke(Object r6, CallContext r7) {
        y7 r8 = (y7) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        Integer r9 = r8.a();
        if (r9 == null) goto L42;
        int r10 = r9.intValue();
        if (r10 <= 0) goto L41;
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r11 = this.a;
        int r12 = UtilityKotlinExtentionsKt.i(r10);
        if (r12 == r11.m) goto L40;
        if (r12 == 0) goto L11;
        r11.m = r12;
    L11:
        CommonIconTemplate r13 = r11.g;
        if (r13 != null) goto L14;
    L27:
        r r14 = z51.a.d(r11.a());
        Object r15 = null;
        if (r14 == null) goto L32;
        com.bytedance.live.datacontext.j r16 = r14.D();
        if (r16 == null) goto L32;
        Object r17 = r16.getValue();
    L34:
        if ((r17 instanceof ShortTermIndicatorManager) == false) goto L37;
        r15 = r17;
    L37:
        ShortTermIndicatorManager r18 = (ShortTermIndicatorManager) r15;
        if (r18 == null) goto L40;
        r18.refresh();
    L32:
        r17 = null;
        goto L34
    L14:
        if ((r13.getParent() instanceof ViewGroup) == false) goto L26;
        ViewParent r0 = r13.getParent();
        if (r0 == null) goto L25;
        ViewGroup.LayoutParams r1 = ((ViewGroup) r0).getLayoutParams();
        if (r1 == null) goto L26;
        r1.width = r11.m;
        ViewParent r2 = r13.getParent();
        if (r2 == null) goto L23;
        ViewGroup r3 = (ViewGroup) r2;
        Intrinsics.checkNotNullParameter(r3, "view");
        r3.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0, r11.m), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0, r11.n));
        goto L26
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L26:
        r13.requestLayout();
    L40:
        finishWithSuccess();
        return;
    L41:
        finishWithFailure();
        return;
    L42:
        finishWithFailure();
    }
}
