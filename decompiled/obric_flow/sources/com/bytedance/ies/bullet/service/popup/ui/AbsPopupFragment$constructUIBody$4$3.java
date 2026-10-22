package com.bytedance.ies.bullet.service.popup.ui;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import w8.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AbsPopupFragment$constructUIBody$4$3 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsPopupFragment f6081a;

    public AbsPopupFragment$constructUIBody$4$3(AbsPopupFragment r5) {
        this.f6081a = r5;
        super(0);
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
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        final AbsPopupFragment r10 = this.f6081a;
        if (r10.g == null) goto L5;
        boolean r5 = true;
    L6:
        ObjectAnimator r11 = null;
        AbsPopupDialog r12 = null;
        if (r5 == true) goto L13;
        Dialog r13 = r10.getDialog();
        if ((r13 instanceof AbsPopupDialog) == false) goto L11;
        r12 = (AbsPopupDialog) r13;
    L11:
        if (r12 == null) goto L24;
        r12.d();
    L24:
        return Unit.INSTANCE;
    L13:
        Dialog r14 = r10.getDialog();
        if (r14 == null) goto L18;
        Window r15 = r14.getWindow();
        if (r15 == null) goto L18;
        View r16 = r15.getDecorView();
    L19:
        f r17 = r10.e;
        if (r17 == null) goto L22;
        r11 = r17.h();
    L22:
        int r18 = r10.i().e;
        Function0<Unit> r19 = new AbsPopupFragment$callbackDialogDismiss$1(r10);
        Function1<Float, Unit> r20 = new AbsPopupFragment$callbackDialogDismiss$2(r10);
        r10.f6067i.b(r16, r11, r18, r19, r20);
    L18:
        r16 = null;
        goto L19
    L5:
        r5 = false;
        goto L6
    }
}
