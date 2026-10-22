package jp;

import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.util.ArrayList;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f18409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f18410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RunMode f18411c;
    public final /* synthetic */ float d;
    public final /* synthetic */ RepeatMode e;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ Lambda g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Function2 f18412h;

    /* JADX WARN: Multi-variable type inference failed */
    public c(d r5, float r10, View r11, RunMode r12, float r13, RepeatMode r14, ArrayList r15, Function3 r16, Function2 r17) {
        this.f18409a = r5;
        this.f18410b = r11;
        this.f18411c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = (Lambda) r16;
        this.f18412h = r17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.Lambda] */
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
    @Override // java.lang.Runnable
    public final void run() {
        d r5 = this.f18409a;
        ArrayList r10 = this.f;
        ?? r11 = this.g;
        Function2 r12 = this.f18412h;
        r5.b(this.f18410b, this.f18411c, this.d, this.e, r10, r11, r12);
    }
}
