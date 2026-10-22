package com.bytedance.android.live.room.widget;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ LiveRoomAudienceWidget a;

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
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        RecyclerView r0 = this.a.j;
        if (r0 == null) goto L5;
        int r1 = r0.getWidth();
    L6:
        if (r1 >= 0) goto L8;
        return;
    L8:
        LiveRoomAudienceWidget r2 = this.a;
        int r3 = r2.p;
        if (r1 > (r3 * 2)) goto L13;
        RecyclerView r4 = r2.j;
        if (r4 == null) goto L16;
        r4.setFadingEdgeLength(LiveRoomAudienceWidget.x);
    L16:
        RecyclerView r5 = this.a.j;
        if (r5 == null) goto L22;
        ViewTreeObserver r6 = r5.getViewTreeObserver();
        if (r6 == null) goto L23;
        r6.removeOnGlobalLayoutListener(this);
        return;
    L23:
        return;
    L22:
        return;
    L13:
        RecyclerView r7 = r2.j;
        if (r7 == null) goto L16;
        r7.setFadingEdgeLength(r3);
        goto L16
    L5:
        r1 = 0;
        goto L6
    }

    public i(LiveRoomAudienceWidget r1) {
        this.a = r1;
    }
}
