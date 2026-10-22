package com.obric.oui.panel.header;

import android.view.View;
import android.widget.ImageView;
import com.obric.oui.common.util.h;
import com.obric.oui.titlebar.ONormalTitleBar;
import com.obric.oui.titlebar.OTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/obric/oui/titlebar/OTitleBar;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class BasicPanelNormalTitleBarHeader$1 extends Lambda implements Function1<OTitleBar, Unit> {
    public static final BasicPanelNormalTitleBarHeader$1 INSTANCE = null;

    static {
        INSTANCE = new BasicPanelNormalTitleBarHeader$1();
    }

    BasicPanelNormalTitleBarHeader$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(OTitleBar r3) {
        invoke2((OTitleBar) ZeusTransformUtils.preCheckCast(r3, OTitleBar.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(OTitleBar r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$initHeader");
        if (ZeusTransformUtils.instanceOf(r7, ONormalTitleBar.class) == false) goto L13;
        ImageView r6 = ((ONormalTitleBar) ZeusTransformUtils.preCheckCast(r7, ONormalTitleBar.class, "com.obric.memorydata.plugin")).getStartBtn();
        if (r6 == null) goto L8;
        r6.setPadding(h.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), 10), h.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), 10), h.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), 10), h.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), 10));
    L8:
        ImageView r8 = ((ONormalTitleBar) ZeusTransformUtils.preCheckCast(r7, ONormalTitleBar.class, "com.obric.memorydata.plugin")).getEndBtn();
        if (r8 == null) goto L14;
        r8.setPadding(h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 10), h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 10), h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 10), h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 10));
        return;
    L14:
        return;
    }
}
