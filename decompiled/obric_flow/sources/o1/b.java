package o1;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.adapter.XBridge3ToAIBridgeAdapter;
import com.bytedance.sdk.xbridge.cn.protocol.l;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20384b;

    public b(int r10) {
        int r5 = 2;
        this.f20383a = r10;
        switch(r10) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f20384b = new ConcurrentHashMap();
        return;
    L6:
        l r11 = new l();
        Intrinsics.checkNotNullParameter(new rb.b(), "providerFactory");
        this.f20384b = CollectionsKt.mutableListOf(new com.bytedance.sdk.xbridge.cn.protocol.h[]{r11, new com.bytedance.ai.lynx.j(r5)});
    }

    public final a a(String r5, ContainerType r10) {
        switch(this.f20383a) {
            case 0: goto L19;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Intrinsics.checkNotNullParameter(r10, "aiContainerType");
        IDLXBridgeMethod r11 = com.bytedance.sdk.xbridge.cn.protocol.k.f7462c.a("", r5);
        if (r11 == null) goto L7;
        XBridge3ToAIBridgeAdapter r12 = new XBridge3ToAIBridgeAdapter(r11);
    L8:
        if (r12 != null) goto L18;
        Iterator r13 = ((List) this.f20384b).iterator();
    L12:
        if (r13.hasNext() == false) goto L18;
        IDLXBridgeMethod r14 = ((com.bytedance.sdk.xbridge.cn.protocol.h) r13.next()).a("", r5);
        if (r14 == null) goto L16;
        r12 = new XBridge3ToAIBridgeAdapter(r14);
    L17:
        if (r14 == null) goto L12;
    L16:
        r14 = null;
    L18:
        return r12;
    L7:
        r12 = null;
        goto L8
    L19:
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Intrinsics.checkNotNullParameter(r10, "aiContainerType");
        if (r5.length() == 0) goto L32;
        Class r15 = (Class) ((ConcurrentHashMap) this.f20384b).get(r5);
        if (r15 != null) goto L25;
        return null;
    L25:
        return (a) r15.newInstance();
    L32:
        return null;
    }

    public void b(Class r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        ConcurrentHashMap r5 = j.f20398a;
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        ConcurrentHashMap r12 = j.f20398a;     // Catch: Throwable -> L8
        Object r13 = r12.get(r10);     // Catch: Throwable -> L8
        if (r13 != null) goto L11;
        a r14 = (a) r10.newInstance();     // Catch: Throwable -> L8
        LinkedHashSet r15 = new LinkedHashSet();     // Catch: Throwable -> L8
        r15.add(r14.getName());     // Catch: Throwable -> L8
        List r16 = r14.getAltNames();     // Catch: Throwable -> L8
        if (r16 == null) goto L10;
        r15.addAll(r16);     // Catch: Throwable -> L8
    L10:
        r13 = CollectionsKt.toList(r15);     // Catch: Throwable -> L8
        r12.put(r10, r13);     // Catch: Throwable -> L8
    L11:
        Object r17 = Result.m124constructorimpl((List) r13);     // Catch: Throwable -> L8
    L15:
        if (Result.m130isFailureimpl(r17) == false) goto L17;
        r17 = null;
    L17:
        List r18 = (List) r17;
        if (r18 != null) goto L20;
        r18 = CollectionsKt.emptyList();
    L20:
        Iterator r19 = r18.iterator();
    L22:
        if (r19.hasNext() == false) goto L24;
        String r20 = (String) r19.next();
        ((ConcurrentHashMap) this.f20384b).put(r20, r10);
        goto L22
    L24:
        ConcurrentHashMap r21 = e.f20389a;
        Intrinsics.checkNotNullParameter(r10, "clazz");
        if (e.f20389a.contains(r10) == true) goto L32;
        c1.b.a(new com.obric.oui.lisitem.a(r10, 21));
        return;
    L32:
        return;
    L8:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
