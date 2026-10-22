package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.animation.Animator;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.live.core.utils.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 4, 3})
final class AudienceExplainCardWidget$hideCard$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ s $listener;
    final /* synthetic */ AudienceExplainCardWidget this$0;

    public AudienceExplainCardWidget$hideCard$1(AudienceExplainCardWidget r1, s r2) {
        this.this$0 = r1;
        this.$listener = r2;
        super(0);
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
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m737invoke() {
        this.this$0.g.setPivotX(0.0f);
        LinearLayout r0 = this.this$0.g;
        r0.setPivotY(r0.getHeight());
        Animator r1 = this.this$0.e;
        if (r1 == null) goto L9;
        h.a(r1, new AudienceExplainCardWidget$hideCard$1$$special$$inlined$run$lambda$1(this));
        s r2 = this.$listener;
        if (r2 == null) goto L7;
        r1.addListener(r2);
    L7:
        r1.start();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m737invoke();
        return Unit.INSTANCE;
    }
}
