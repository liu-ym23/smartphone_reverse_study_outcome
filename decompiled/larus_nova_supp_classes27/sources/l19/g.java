package l19;

import com.larus.common_ui.photoviewer.transition.TransitionPhotoDraweeView;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements f {
    public final /* synthetic */ TransitionPhotoDraweeView a;

    public g(TransitionPhotoDraweeView r1) {
        this.a = r1;
    }

    @Override // l19.f
    public final void onTransitionBegin(int r3) {
        Iterator<T> r0 = this.a.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).onTransitionBegin(r3);
        goto L4
    }

    @Override // l19.f
    public final void onTransitionEnd(int r3) {
        Iterator<T> r0 = this.a.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).onTransitionEnd(r3);
        goto L4
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
    @Override // l19.f
    public final void onTransitionChanged(int r3, float r4) {
        Iterator<T> r0 = this.a.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((f) r0.next()).onTransitionChanged(r3, r4);
        goto L4
    L7:
        if (r3 == 2) goto L9;
        return;
    L9:
        if (this.a.getDismissAnimationType() != 1) goto L14;
        this.a.setAlpha(1 - r4);
        return;
    }
}
