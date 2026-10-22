package com.obric.oui.popover.menu;

import com.obric.oui.popover.OPopoverLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "isPressed", "", "pressedColor", "", "invoke", "(ZI)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class OPopoverMenuView$registerPressedCallback$1 extends Lambda implements Function2<Boolean, Integer, Unit> {
    final /* synthetic */ PopoverMenuLinearLayout $itemView;
    final /* synthetic */ OPopoverMenuView this$0;

    OPopoverMenuView$registerPressedCallback$1(OPopoverMenuView r10, PopoverMenuLinearLayout r11) {
        this.this$0 = r10;
        this.$itemView = r11;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r10, Integer r11) {
        invoke(r10.booleanValue(), r11.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void invoke(boolean r10, int r11) {
        OPopoverMenuView r12 = this.this$0;
        OPopoverLayout r13 = r12.c(r12);
        if (r13 == null) goto L20;
        int r14 = a.f7162a[this.$itemView.getIndexPos().ordinal()];
        boolean r15 = false;
        if (r14 == 1) goto L15;
        if (r14 == 2) goto L12;
        if (r14 != 3) goto L17;
    L10:
        r15 = true;
    L17:
        if (r15 == false) goto L21;
        r13.e(r10, r11);
        return;
    L21:
        return;
    L12:
        if (r13.a() != 3) goto L17;
    L15:
        if (r13.a() != 0) goto L17;
    }
}
