package com.obric.oui.toast;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.c;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OPopupNotice$Builder$setDefaultAnchorView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OPopupNotice.a this$0;

    OPopupNotice$Builder$setDefaultAnchorView$1(OPopupNotice.a r1) {
        this.this$0 = r1;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        View r0 = c.a((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.a(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"));
        View r2 = null;
        if (r0 != null) goto L5;
        ViewGroup r1 = null;
    L6:
        int[] r4 = new int[2];
        if (r1 == null) goto L10;
        r1.getLocationOnScreen(r4);
    L10:
        Rect r5 = new Rect();
        if (r1 == null) goto L14;
        r1.getGlobalVisibleRect(r5);
    L14:
        StringBuilder r6 = new StringBuilder().append("check contentView@");
        if (r1 != null) goto L17;
        Integer r7 = null;
    L18:
        boolean r8 = false;
        g.a(r6.append(r7).append(" 's location=").append(r4[0]).append(',').append(r4[1]).append(", rect.bottom=").append(r5.bottom).toString());
        if (r1 == null) goto L22;
        r2 = r1.findViewWithTag(((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.a(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oui_tag_vertical_view_pager, TypedValues.Custom.S_STRING, "oui_tag_vertical_view_pager")));
    L22:
        int[] r3 = new int[2];
        if (r2 == null) goto L26;
        r2.getLocationOnScreen(r3);
    L26:
        Rect r9 = new Rect();
        if (r2 == null) goto L30;
        r2.getGlobalVisibleRect(r9);
    L30:
        StringBuilder r12 = new StringBuilder().append("check verticalViewPager@");
        if (r2 == null) goto L33;
        int r13 = r2.hashCode();
    L34:
        g.a(r12.append(r13).append(" 's location=").append(r3[0]).append(',').append(r3[1]).append(", rect.bottom=").append(r9.bottom).toString());
        if (r2 != null) goto L37;
    L39:
        boolean r10 = false;
    L40:
        OPopupNotice.a r11 = this.this$0;
        if (r10 == true) goto L43;
        View r14 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
    L44:
        r11.a(r14);
        if (r2 != null) goto L47;
    L49:
        g.a("check: isVerticalViewPagerInScreen=" + r10 + ", verticalVVsBottomIsAligningContent=" + r8);
        if (r10 == false) goto L52;
        if (r8 == true) goto L52;
        return;
    L52:
        OPopupNotice.a r15 = this.this$0;
        r15.a(r15.b() + h.a((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.a(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 58));
        return;
    L47:
        if (r9.bottom != r5.bottom) goto L49;
        r8 = true;
        goto L49
    L43:
        r14 = r2;
        goto L44
    L37:
        if (Math.abs(r3[0] - r4[0]) >= h.a((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.a(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"))) goto L39;
        r10 = true;
        goto L40
    L33:
        r13 = 0;
        goto L34
    L17:
        r7 = Integer.valueOf(r1.hashCode());
        goto L18
    L5:
        r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0.findViewById(android.R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
        goto L6
    }
}
