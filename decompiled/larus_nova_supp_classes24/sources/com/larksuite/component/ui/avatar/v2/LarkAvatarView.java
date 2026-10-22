package com.larksuite.component.ui.avatar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import b08.a;
import b08.b;
import b08.c;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import uz7.e;
import wz7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LarkAvatarView extends LKUIRoundedImageView2 implements c {
    public final a a;

    public LarkAvatarView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public final void j(AvatarModel r3) {
        this.a.a(getClass(), this, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public final void l(d r3) {
        if (r3 == null) goto L4;
        this.a.a(getClass(), this, r3);
        return;
    L4:
        m(d.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(Class<?> r4) {
        a r0 = this.a;
        Class<?> r1 = getClass();
        r0.getClass();
        b r5 = r0.b(r1, getClass(), r4);
        if (r5 == null) goto L6;
        r5.unbind(this);
        return;
    }

    public LarkAvatarView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LarkAvatarView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.a = new a();
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130969229, 2130969230, 2130969231, 2130969232, 2130969233, 2130969234, 2130969235, 2130969236, 2130969237, 2130969238, 2130969239, 2130969240, 2130969241, 2130969242, 2130969243, 2130969244, 2130969245, 2130969246, 2130969247, 2130969248, 2130969249}, r5, 0);
        setOval(r6.getBoolean(12, true));
        r6.recycle();
        registerModelBinder(tz7.a.class, ImageView.class, new tz7.b());
        registerModelBinder(uz7.d.class, ImageView.class, new e());
        registerModelBinder(AvatarModel.class, ImageView.class, new uz7.c());
        registerModelBinder(vz7.b.class, View.class, new vz7.a());
        registerModelBinder(wz7.a.class, View.class, new wz7.b());
        registerModelBinder(d.class, View.class, new wz7.c());
    }

    @Override // b08.c
    public final <M, V extends View> void registerModelBinder(Class<M> r2, Class<V> r3, b<? super V, ? super M> r4) {
        this.a.registerModelBinder(r2, r3, r4);
    }
}
