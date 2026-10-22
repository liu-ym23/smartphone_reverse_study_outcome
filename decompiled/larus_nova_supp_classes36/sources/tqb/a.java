package tqb;

import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder;
import com.ss.android.lark.lynxkit.host.LarkLynxCloseSource;
import com.ss.android.lark.lynxkit.host.LarkLynxHostOptions;
import com.ss.android.lark.lynxkit.host.LarkLynxHostParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a implements ILarkLynxHostHolder, g {
    public final LarkLynxHostParams a;
    public final LarkLynxHostOptions b;
    public final AtomicBoolean c;
    public boolean d;
    public ILarkLynxContainer e;
    public c f;

    public void d() {
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public void destroy() {
        if (this.c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        c r0 = this.f;
        if (r0 == null) goto L8;
        r0.K40(LarkLynxCloseSource.PROGRAMMATIC);
    L11:
        this.f = null;
        this.e = null;
        return;
    L8:
        ILarkLynxContainer r1 = this.e;
        if (r1 == null) goto L11;
        r1.destroy();
        goto L11
    }

    @Override // tqb.g
    public final boolean f() {
        if (this.d == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.d = false;
        return r0;
    L5:
        if (this.b.getRenderOnCreateView() == true) goto L8;
        r0 = false;
        goto L9
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final boolean isDestroyed() {
        return this.c.get();
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public void load() {
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r0 = this.e;
        if (r0 != null) goto L9;
        this.d = true;
        return;
    L9:
        this.d = false;
        int r1 = b.a;
        b.c(r0, this.a);
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final ILarkLynxContainer getContainer() {
        return this.e;
    }

    @Override // tqb.g
    public final void a(ILarkLynxContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        if (this.e != r2) goto L6;
        this.e = null;
        return;
    }

    @Override // tqb.g
    public final void b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        if (this.f != r2) goto L6;
        this.f = null;
        return;
    }

    public void c(c r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        this.f = r2;
    }

    @Override // tqb.g
    public final void e(ILarkLynxContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.e = r2;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateData(Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r0 = this.e;
        if (r0 == null) goto L28;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r7 = r6.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L16;
        Map.Entry<String, ? extends Object> r2 = r7.next();
        if (r2.getValue() == null) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L9;
        r1.put(r2.getKey(), r2.getValue());
        goto L9
    L13:
        r3 = false;
        goto L14
    L16:
        LinkedHashMap r8 = new LinkedHashMap(MapsKt.mapCapacity(r1.size()));
        Iterator r4 = r1.entrySet().iterator();
    L18:
        if (r4.hasNext() == false) goto L20;
        Map.Entry r5 = (Map.Entry) r4.next();
        Object r9 = r5.getKey();
        Object r10 = r5.getValue();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Any");
        r8.put(r9, r10);
        goto L18
    L20:
        r0.updateData(r8, this.a.getLynxViewShareData());
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateGlobalProps(String r2) {
        Intrinsics.checkNotNullParameter(r2, "globalPropsJson");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r0 = this.e;
        if (r0 == null) goto L9;
        r0.updateGlobalData(r2);
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateShareData(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "shareData");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r0 = this.e;
        if (r0 == null) goto L9;
        r0.updateShareData(new HashMap(r3));
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateData(String r3) {
        Intrinsics.checkNotNullParameter(r3, "json");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r0 = this.e;
        if (r0 == null) goto L9;
        r0.updateData(r3, this.a.getLynxViewShareData());
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateGlobalProps(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "globalProps");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r0 = this.e;
        if (r0 == null) goto L9;
        r0.updateGlobalData(r2);
        return;
    }

    public a(LarkLynxHostParams r2, LarkLynxHostOptions r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "options");
        this.a = r2;
        this.b = r3;
        this.c = new AtomicBoolean(false);
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void sendEvent(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        if (r3 != null) goto L6;
        List<? extends Object> r4 = CollectionsKt.emptyList();
    L9:
        sendEvent(r2, r4);
        return;
    L6:
        if ((r3 instanceof List) == false) goto L8;
        r4 = CollectionsKt.filterNotNull((Iterable) r3);
        goto L9
    L8:
        r4 = CollectionsKt.listOf(r3);
        goto L9
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateSize(int r2, int r3) {
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r0 = this.e;
        if (r0 == null) goto L9;
        r0.updateSize(r2, r3);
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void sendEvent(String r2, List<? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "params");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r0 = this.e;
        if (r0 == null) goto L9;
        r0.sendGlobalEventToJS(r2, r3);
        return;
    }
}
