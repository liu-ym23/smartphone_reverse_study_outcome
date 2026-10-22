package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.DraweeView;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ WindScreenCombinedAnimTrayView a;
    public final /* synthetic */ AbstractDraweeController b;

    public d(WindScreenCombinedAnimTrayView r1, AbstractDraweeController r2) {
        this.a = r1;
        this.b = r2;
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
        Long r4 = (Long) r3;
        DraweeView r5 = this.a.e;
        r5.setController(this.b);
        r5.setRadius(UtilityKotlinExtentionsKt.h(23.0f));
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (r0 == null) goto L5;
        r0.width = this.a.b.getMeasuredWidth();
        Unit r1 = Unit.INSTANCE;
    L6:
        r5.setLayoutParams(r0);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
