package com.bytedance.android.live.room.widget;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ LiveRoomAudienceWidget a;

    public g(LiveRoomAudienceWidget r1) {
        this.a = r1;
    }

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
    public final void accept(Object r3) {
        Float r4 = (Float) sh6.c.b((sh6.b) r3);
        if (r4 == null) goto L18;
        float r0 = r4.floatValue();
        if (r0 >= 0.0f) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L19;
        float r5 = r4.floatValue();
        RecyclerView r2 = this.a.j;
        if (r2 == null) goto L20;
        r2.setAlpha((r5 * 0.7f) + 0.3f);
        return;
    L20:
        return;
    L19:
        return;
    L7:
        if (r0 > 1.0f) goto L9;
        r1 = true;
        goto L10
    }
}
