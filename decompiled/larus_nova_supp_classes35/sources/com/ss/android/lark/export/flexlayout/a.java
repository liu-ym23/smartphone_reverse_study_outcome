package com.ss.android.lark.export.flexlayout;

import com.ss.android.lark.export.entity.preview.Padding;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.tangram.engine.TangramNative;
import kotlin.jvm.internal.Intrinsics;
import s6c.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends c<FlexLayoutProperty> {

    /* JADX INFO: renamed from: com.ss.android.lark.export.flexlayout.a$a, reason: collision with other inner class name */
    public static final class C0196a {
    }

    static {
    }

    public final long c(int r9) {
        long r6 = TangramNative.newFlexLayoutNode();
        m(r6);
        Props r0 = ((s6c.a) this).e;
        if ((r0 instanceof FlexLayoutProperty) == false) goto L14;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.export.flexlayout.FlexLayoutProperty");
        FlexLayoutProperty r1 = (FlexLayoutProperty) r0;
        TangramNative.setFlexLayoutPropsAlign(r6, r1.getCrossAxisAlign().getValue());
        TangramNative.setFlexLayoutPropsCrossAxisSpace(r6, r1.getCrossAxisSpacing());
        TangramNative.setFlexLayoutPropsMainAxisSpace(r6, r1.getMainAxisSpacing());
        if (r9 > 378) goto L7;
    L9:
        TangramNative.setFlexLayoutPropsFlexWrap(r6, r1.getFlexWrap().getValue());
    L10:
        TangramNative.setFlexLayoutPropsJustify(r6, r1.getMainAxisJustify().getValue());
        TangramNative.setFlexLayoutPropsOrientation(r6, r1.getOrientation().getValue());
        Padding r10 = r1.getPadding();
        if (r10 != null) goto L13;
        r10 = new Padding(0.0f, 0.0f, 0.0f, 0.0f);
    L13:
        TangramNative.setFlexLayoutPropsPadding(r6, r10.getTop(), r10.getLeft(), r10.getBottom(), r10.getRight());
        goto L14
    L7:
        if (r1.getForceUseCompactMode() == true) goto L9;
        TangramNative.setFlexLayoutPropsFlexWrap(r6, FlexLayoutProperty.FlexWrap.NO_WRAP.getValue());
    L14:
        return r6;
    }

    public a(String r3, FlexLayoutProperty r4, TCStyle r5) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter("android.view.View", "viewTypeIdentity");
        Intrinsics.checkNotNullParameter(r4, "props");
        super(r3, "android.view.View", r4, r5);
    }
}
