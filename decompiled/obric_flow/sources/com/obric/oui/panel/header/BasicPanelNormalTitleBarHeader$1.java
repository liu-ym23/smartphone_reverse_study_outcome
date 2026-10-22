package com.obric.oui.panel.header;

import android.widget.ImageView;
import com.obric.oui.titlebar.ONormalTitleBar;
import com.obric.oui.titlebar.OTitleBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/obric/oui/titlebar/OTitleBar;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class BasicPanelNormalTitleBarHeader$1 extends Lambda implements Function1<OTitleBar, Unit> {
    public static final BasicPanelNormalTitleBarHeader$1 INSTANCE = null;

    static {
        INSTANCE = new BasicPanelNormalTitleBarHeader$1();
    }

    public BasicPanelNormalTitleBarHeader$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OTitleBar r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(OTitleBar r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$initHeader");
        if ((r10 instanceof ONormalTitleBar) == false) goto L13;
        ONormalTitleBar r11 = (ONormalTitleBar) r10;
        ImageView r5 = r11.getStartBtn();
        if (r5 == null) goto L8;
        r5.setPadding(com.lynx.tasm.utils.a.B(10, r5), com.lynx.tasm.utils.a.B(10, r5), com.lynx.tasm.utils.a.B(10, r5), com.lynx.tasm.utils.a.B(10, r5));
    L8:
        ImageView r12 = r11.getEndBtn();
        if (r12 == null) goto L14;
        r12.setPadding(com.lynx.tasm.utils.a.B(10, r12), com.lynx.tasm.utils.a.B(10, r12), com.lynx.tasm.utils.a.B(10, r12), com.lynx.tasm.utils.a.B(10, r12));
        return;
    L14:
        return;
    }
}
