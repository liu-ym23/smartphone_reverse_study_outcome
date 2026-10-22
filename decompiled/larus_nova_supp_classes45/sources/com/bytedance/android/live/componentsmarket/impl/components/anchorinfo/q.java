package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import com.bytedance.android.live.core.utils.ImageLoader;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ MediaAnchorInfoWidget a;

    public q(MediaAnchorInfoWidget r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.MediaAnchorInfoWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onChanged(Object r4) {
        py.k r5 = (py.k) r4;
        ?? r0 = this.a;
        if (r5 == null) goto L11;
        ImageLoader.bindImage(r0.d, r5, 2131250965);
        SimpleDraweeView r6 = r0.d;
        if (r6 != null) goto L7;
        return;
    L7:
        if (r0.isScreenLandscape() == false) goto L9;
        int r1 = 8;
    L10:
        r6.setVisibility(r1);
        return;
    L9:
        r1 = 0;
        goto L10
    L11:
        int r7 = MediaAnchorInfoWidget.x;
        r0.getClass();
    }
}
