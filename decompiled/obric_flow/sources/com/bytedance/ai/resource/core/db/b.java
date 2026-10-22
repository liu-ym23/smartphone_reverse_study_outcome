package com.bytedance.ai.resource.core.db;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.obric.feature.miniapp.widget.jsb.AppletOpenPageMethod;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import u1.f;
import u1.g;
import z2.d;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2668b;

    public /* synthetic */ b(Object r5, int r10) {
        this.f2667a = r10;
        this.f2668b = r5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch(this.f2667a) {
            case 0: goto L34;
            case 1: goto L32;
            case 2: goto L30;
            case 3: goto L14;
            default: goto L4;
        };
    L4:
        boolean r5 = s0.a.f21798a.get();
        Runnable r10 = (Runnable) this.f2668b;
        if (r5 == true) goto L7;
    L11:
        d.f23375c.add(r10);
    L13:
        return Unit.INSTANCE;
    L7:
        if (s0.a.f21800c == null) goto L11;
        Handler r11 = d.f23374b;
        if (r11 == null) goto L13;
        r11.post(r10);
        goto L13
    L14:
        f r12 = (f) this.f2668b;
        if (r12.b() == false) goto L28;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.d.iterator();
    L18:
        if (r14.hasNext() == false) goto L22;
        Object r15 = r14.next();
        if ((((g) r15).f22238b.code / 100) != 2) goto L18;
        r13.add(r15);
        goto L18
    L22:
        ArrayList r16 = new ArrayList(CollectionsKt.h(r13));
        Iterator r17 = r13.iterator();
    L24:
        if (r17.hasNext() == false) goto L41;
        r16.add(((g) r17.next()).f22237a);
        goto L24
    L41:
        return CollectionsKt.flatten(r16);
    L28:
        return CollectionsKt.emptyList();
    L30:
        return AppletOpenPageMethod.b((Ref.BooleanRef) this.f2668b);
    L32:
        return new com.bytedance.ai.widget.contianer.g(Looper.getMainLooper(), (WidgetContainer) this.f2668b);
    L34:
        return AIPackageDatabase$Companion$MIGRATION_1_2$1.a((Exception) this.f2668b);
    }
}
