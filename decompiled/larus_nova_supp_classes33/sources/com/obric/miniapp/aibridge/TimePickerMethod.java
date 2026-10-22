package com.obric.miniapp.aibridge;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.obric.oui.selection.OSelectionPanelBtnView;
import com.obric.oui.sheet.OInsetSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/miniapp/aibridge/TimePickerMethod;", "Lcom/obric/miniapp/aibridge/AbsTimePickerMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsTimePickerMethodIDL$TimePickerParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsTimePickerMethodIDL$TimePickerResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimePickerMethod extends AbsTimePickerMethodIDL {
    public final boolean mustRunInMain() {
        return true;
    }

    public TimePickerMethod() {
    }

    public final void handle(e3.d r12, ParamModel r13, f3.h r14) {
        AbsTimePickerMethodIDL.a r15 = (AbsTimePickerMethodIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        Activity r16 = AppHost.a.a().getCurrentActivity();
        FrameLayout r1 = null;
        if ((r16 instanceof Context) == true) goto L7;
        r16 = null;
    L7:
        if (r16 != null) goto L9;
        f3.h.a.a(r14, "No available activity context", null, null, 14);
        return;
    L9:
        final List<Integer> r6 = r15.getValue();
        final List<String> r5 = r15.getUnit();
        List<Integer> r2 = r6;
        if (r2 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L65;
        List<String> r4 = r5;
        if (r4 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L65;
        com.obric.miniapp.utils.a0 r0 = com.obric.miniapp.utils.a0.a;
        Integer r8 = r15.getSelectedValueIndex();
        Integer r17 = r15.getSelectedUnitIndex();
        final d0 r9 = new d0(r14);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r16, "ctx");
        Intrinsics.checkNotNullParameter(r6, "value");
        Intrinsics.checkNotNullParameter(r5, "unit");
        hma.a.a r18 = new hma.a.a();
        ArrayList r10 = new ArrayList();
        Iterator<Integer> r11 = r6.iterator();
    L28:
        if (r11.hasNext() == false) goto L30;
        r10.add(String.valueOf(r11.next().intValue()));
        goto L28
    L30:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r18.d = r10;
        ArrayList r19 = new ArrayList();
        Iterator<String> r20 = r5.iterator();
    L32:
        if (r20.hasNext() == false) goto L34;
        r19.add(r20.next());
        goto L32
    L34:
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r18.e = r19;
        if (r8 == null) goto L41;
        int r21 = r8.intValue();
        if (r21 >= 0) goto L39;
    L40:
        r21 = r6.size() / 2;
    L42:
        if (r17 == null) goto L48;
        int r110 = r17.intValue();
        if (r110 >= 0) goto L46;
    L47:
        r110 = r5.size() / 2;
    L49:
        int r22 = r6.size() - 1;
        r18.a = true;
        r18.h.a = r21;
        hma.a.b r23 = r18.i;
        r23.b = r22;
        r23.a = 0;
        int r24 = r5.size() - 1;
        r18.b = true;
        r18.h.b = r110;
        hma.a.b r111 = r18.j;
        r111.b = r24;
        r111.a = 0;
        Consumer r112 = new com.obric.miniapp.utils.o();
        Intrinsics.checkNotNullParameter(r112, "listener");
        r18.c = r112;
        final hma.a r25 = (hma.a) hma.d.a.a(r18, r16);
        final OInsetSheet r113 = new OInsetSheet(r16);
        r113.e(OInsetSheet.PanelWidth.BOARD_WIDTH);
        hma.a.a r114 = r25.a;
        if (r114 == null) goto L54;
        gma.a r115 = r114.k;
        if (r115 == null) goto L54;
        View r116 = r115.asView();
    L56:
        FrameLayout r26 = r113.a;
        if (r26 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        r26 = null;
    L60:
        OInsetSheet.d(r26, r116);
        com.obric.miniapp.utils.a0 r117 = com.obric.miniapp.utils.a0.a;
        View.OnClickListener r27 = new com.obric.miniapp.utils.p(r113);
        View.OnClickListener r28 = new com.obric.miniapp.utils.q(r25, r113, r5, r6, r9);
        r117.getClass();
        OSelectionPanelBtnView r118 = com.obric.miniapp.utils.a0.m(r16, r27, r28);
        FrameLayout r119 = r113.b;
        if (r119 == null) goto L63;
        r1 = r119;
    L64:
        OInsetSheet.d(r1, r118);
        com.obric.miniapp.utils.a0.c(r113);
        return;
    L63:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
    L54:
        r116 = null;
        goto L56
    L46:
        if (r110 < r5.size()) goto L49;
    L48:
        r110 = r5.size() / 2;
        goto L49
    L39:
        if (r21 < r6.size()) goto L42;
    L41:
        r21 = r6.size() / 2;
        goto L42
    L20:
        if (r4.isEmpty() == true) goto L23;
        r7 = false;
    L65:
        f3.h.a.a(r14, "null", null, null, 14);
        return;
    L12:
        if (r2.isEmpty() == true) goto L15;
        r3 = false;
        goto L16
    }
}
