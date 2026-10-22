package com.ss.android.lark.chat.preview.components;

import com.ss.android.lark.chat.preview.entity.component.property.LinearLayoutProperty;
import com.ss.android.lark.export.entity.preview.Padding;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.tangram.engine.TangramNative;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i extends s6c.c<LinearLayoutProperty> {
    public final long c(int r9) {
        long r6 = TangramNative.newLinearLayoutNode();
        m(r6);
        Props r10 = ((s6c.a) this).e;
        if ((r10 instanceof LinearLayoutProperty) == false) goto L21;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.chat.preview.entity.component.property.LinearLayoutProperty");
        LinearLayoutProperty r11 = (LinearLayoutProperty) r10;
        Padding r0 = r11.getSidePadding();
        if (r0 == null) goto L7;
        float r1 = r0.getTop();
    L8:
        float r2 = r1;
        Padding r3 = r11.getSidePadding();
        if (r3 == null) goto L11;
        float r4 = r3.getLeft();
    L12:
        float r5 = r4;
        Padding r7 = r11.getSidePadding();
        if (r7 == null) goto L15;
        float r8 = r7.getBottom();
    L16:
        float r12 = r8;
        Padding r13 = r11.getSidePadding();
        if (r13 == null) goto L19;
        float r14 = r13.getRight();
    L20:
        TangramNative.setLinearLayoutPropsPadding(r6, r2, r5, r12, r14);
        TangramNative.setLinearLayoutPropsSpace(r6, r11.getSpacing());
        TangramNative.setLinearLayoutPropsOrientation(r6, r11.getOrientation().getValue());
        TangramNative.setLinearLayoutPropsAlign(r6, r11.getCrossAxisAlign().getValue());
        TangramNative.setLinearLayoutPropsJustify(r6, r11.getMainAxisJustify().getValue());
        TangramNative.setLinearLayoutPropsWrapWidth(r6, r11.getWrapWidth());
        goto L21
    L19:
        r14 = r11.getPadding();
        goto L20
    L15:
        r8 = r11.getPadding();
        goto L16
    L11:
        r4 = r11.getPadding();
        goto L12
    L7:
        r1 = r11.getPadding();
    L21:
        return r6;
    }

    public i(String r3, LinearLayoutProperty r4, TCStyle r5) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter("android.view.View", "viewTypeIdentity");
        Intrinsics.checkNotNullParameter(r4, "props");
        super(r3, "android.view.View", r4, r5);
    }
}
