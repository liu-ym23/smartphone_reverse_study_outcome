package com.larksuite.component.card.service;

import androidx.lifecycle.Lifecycle;
import com.larksuite.component.card.service.bridge.CardBridgeService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CardServiceManager implements d {
    public static final Map<Class<? extends c>, ICardServiceFactory<? extends c>> e = null;
    public final Lifecycle a;
    public final Function0<ILarkLynxContainer> b;
    public final e c;
    public boolean d;

    public static final class a {
    }

    static {
        HashMap r0 = new HashMap();
        e = r0;
        r0.put(gz7.c.class, new gz7.b());
        r0.put(com.larksuite.component.card.resources.e.class, new com.larksuite.component.card.resources.c());
        r0.put(zy7.c.class, new zy7.a());
        r0.put(com.larksuite.component.card.component.audio.service.b.class, new com.larksuite.component.card.component.audio.service.a());
        r0.put(com.larksuite.component.card.component.video.service.c.class, new com.larksuite.component.card.component.video.service.a());
    }

    @Override // com.larksuite.component.card.service.d
    public final void destroy() {
        this.c.a();
        this.d = true;
    }

    @Override // com.larksuite.component.card.service.d
    public final <T extends c> T getService(Class<T> r8) {
        Intrinsics.checkNotNullParameter(r8, "serviceClass");
        if (this.d == false) goto L6;
        Log.e("CardServiceManager", "tried to get service on a destroyed CardServiceManager");
        return null;
    L6:
        final ICardServiceFactory r0 = (ICardServiceFactory) ((HashMap) e).get(r8);
        if (r0 != null) goto L10;
        Log.e("CardServiceManager", "getService " + r8.getSimpleName() + " has no factory");
        return null;
    L10:
        Lifecycle r2 = this.a;
        if (r2 != null) goto L13;
    L15:
        com.larksuite.component.card.service.a r3 = this.c;
    L16:
        ILarkLynxContainer r4 = (ILarkLynxContainer) this.b.invoke();
        int r6 = CardBridgeService.d;
        Intrinsics.checkNotNullParameter(r3, "serviceHolder");
        if ((r3 instanceof LifecycleCardServiceHolder) == false) goto L19;
        CardBridgeService r7 = new CardBridgeService(r3, r2, null);
    L20:
        final b r5 = new b(r2, r4, r7);
        return (T) r3.b(r8, new AnonymousClass1(r0, r5));
    L19:
        r7 = new CardBridgeService(r3, r2, r4);
        goto L20
    L13:
        if (r0.a() != ICardServiceFactory.Scope.LIFECYCLE) goto L15;
        r3 = LifecycleCardServiceHolder.d.a(r2);
        goto L16
    }

    public CardServiceManager(Lifecycle r2, Function0<? extends ILarkLynxContainer> r3) {
        Intrinsics.checkNotNullParameter(r3, "lynxContainerGetter");
        this.a = r2;
        this.b = r3;
        this.c = new e();
    }
}
