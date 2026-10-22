package com.larksuite.component.card.service.bridge;

import androidx.lifecycle.Lifecycle;
import com.larksuite.component.card.service.CardServiceManager;
import com.larksuite.component.card.service.ICardServiceFactory;
import com.larksuite.component.card.service.LifecycleCardServiceHolder;
import com.larksuite.component.card.service.b;
import com.larksuite.component.card.service.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CardBridgeService implements com.larksuite.component.card.service.bridge.a {
    public static final /* synthetic */ int d = 0;
    public final com.larksuite.component.card.service.a a;
    public final Lifecycle b;
    public final ILarkLynxContainer c;

    public static final class a {
    }

    static {
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
    @Override // com.larksuite.component.card.service.bridge.a
    public final <T extends c> T getService(Class<T> r8) {
        Intrinsics.checkNotNullParameter(r8, "serviceClass");
        if (this.a.a == false) goto L6;
        Log.e("CardBridgeService", "getService " + r8.getSimpleName() + " on a destroyed CardBridgeService");
        return null;
    L6:
        Map<Class<? extends c>, ICardServiceFactory<? extends c>> r1 = CardServiceManager.e;
        Intrinsics.checkNotNullParameter(r8, "serviceClass");
        Object r0 = ((HashMap) CardServiceManager.e).get(r8);
        if ((r0 instanceof ICardServiceFactory) == false) goto L9;
        final ICardServiceFactory r2 = (ICardServiceFactory) r0;
    L10:
        if (r2 != null) goto L13;
        Log.e("CardBridgeService", "getService " + r8.getSimpleName() + " has no factory");
        return null;
    L13:
        Lifecycle r3 = this.b;
        ILarkLynxContainer r4 = this.c;
        com.larksuite.component.card.service.a r5 = this.a;
        Intrinsics.checkNotNullParameter(r5, "serviceHolder");
        if ((r5 instanceof LifecycleCardServiceHolder) == false) goto L16;
        CardBridgeService r6 = new CardBridgeService(r5, r3, null);
    L17:
        final b r7 = new b(r3, r4, r6);
        return (T) this.a.b(r8, new AnonymousClass1(r2, r7));
    L16:
        r6 = new CardBridgeService(r5, r3, r4);
        goto L17
    L9:
        r2 = null;
        goto L10
    }

    public CardBridgeService(com.larksuite.component.card.service.a r1, Lifecycle r2, ILarkLynxContainer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
