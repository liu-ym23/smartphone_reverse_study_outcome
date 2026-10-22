package u4;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements b {
    public final boolean a;
    public final String b;
    public final d c;
    public final e d;
    public final Lazy e;

    public static final class a {
    }

    static {
    }

    @Override // u4.b
    public final void cleanup() {
        d r0 = this.c;
        Iterator<Map.Entry<String, ConcurrentHashMap<String, String>>> r1 = r0.a.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().getValue().clear();
        goto L4
    L6:
        r0.a.clear();
    }

    public final ConcurrentHashMap<String, CopyOnWriteArrayList<h>> g() {
        return (ConcurrentHashMap) this.e.getValue();
    }

    @Override // u4.b
    public final void a(h r10) {
        Intrinsics.checkNotNullParameter(r10, "subscriber");
        com.bytedance.ai.utils.g.a.d("AIStorageItem", "subscribeStorageItem " + r10);
        CopyOnWriteArrayList<h> r0 = g().get(r10.a);
        if (r0 != null) goto L6;
        r0 = new CopyOnWriteArrayList();
        g().put(r10.a, r0);
    L8:
        r0.add(r10);
        g().put(r10.a, r0);
        if (r10.c == false) goto L11;
        c r1 = this.d;
    L12:
        String r11 = r1.a(r10.a, r10.b, null);
        if (r11 == null) goto L20;
        List r12 = new Regex("&").split(r10.a, 0);
        WeakReference<u4.a> r13 = r10.d;
        if (r13 == null) goto L21;
        u4.a r14 = r13.get();
        if (r14 == null) goto L22;
        JsonObject r15 = new JsonObject();
        r15.addProperty("groupID", this.b);
        r15.addProperty("storageID", (String) ListProtector.get(r12, r12.size() - 1));
        r15.addProperty("persistent", Boolean.valueOf(r10.c));
        r15.addProperty("key", r10.b);
        r15.addProperty(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, r11);
        Unit r16 = Unit.INSTANCE;
        r14.onMessageToAIBridge("onDataUpdated", r15);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r1 = this.c;
        goto L12
    L6:
        if (r0.contains(r10) == false) goto L8;
    }

    @Override // u4.b
    public final void b(h r10) {
        Intrinsics.checkNotNullParameter(r10, "subscriber");
        com.bytedance.ai.utils.g.a.d("AIStorageItem", "unSubscribeStorageItem=" + r10);
        CopyOnWriteArrayList<h> r0 = g().get(r10.a);
        if (r0 == null) goto L6;
        r0.remove(r10);
        return;
    }

    public g(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "groupId");
        this.a = r10;
        this.b = r11;
        this.c = new d();
        this.d = new e();
        this.e = LazyKt.lazy(new f());
    }

    @Override // u4.b
    public final String d(String r10, String r11) {
        Intrinsics.checkNotNullParameter("ai_storage_user", "userId");
        Intrinsics.checkNotNullParameter(r10, "groupId");
        Intrinsics.checkNotNullParameter(r11, "storageId");
        StringBuilder r0 = new StringBuilder("ai_storage_user&");
        if (this.a == false) goto L5;
        String r1 = "shared";
    L6:
        r0.append(r1);
        r0.append('&');
        r0.append(r10);
        r0.append('&');
        r0.append(r11);
        String r12 = r0.toString();
        com.bytedance.ai.utils.g.a.d("AIStorageItem", "mappingStorage=" + r12);
        return r12;
    L5:
        r1 = "private";
        goto L6
    }

    @Override // u4.b
    public final String c(String r10, boolean r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter("ai_storage_user", "userId");
        Intrinsics.checkNotNullParameter(r10, "storageId");
        Intrinsics.checkNotNullParameter(r12, "key");
        if (r11 == false) goto L5;
        c r14 = this.d;
    L6:
        String r15 = r14.a(d(this.b, r10), r12, r13);
        com.bytedance.ai.utils.g.a.d("AIStorage", "getStorageItem key " + r12 + " value " + r15);
        return r15;
    L5:
        r14 = this.c;
        goto L6
    }

    @Override // u4.b
    public final void e(String r10, boolean r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter("ai_storage_user", "userId");
        Intrinsics.checkNotNullParameter(r10, "storageId");
        Intrinsics.checkNotNullParameter(r12, "key");
        String r1 = d(this.b, r10);
        if (r11 == false) goto L5;
        c r14 = this.d;
    L6:
        String r15 = r14.a(r1, r12, null);
        if (r11 == false) goto L9;
        c r16 = this.d;
    L10:
        r16.b(r1, r12);
        com.bytedance.ai.utils.g.a.d("AIStorage", "removeStorageItem key " + r1);
        CopyOnWriteArrayList<h> r17 = g().get(r1);
        if (r17 == null) goto L26;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L14:
        if (r19.hasNext() == false) goto L18;
        Object r20 = r19.next();
        if (Intrinsics.areEqual(((h) r20).b, r12) == false) goto L14;
        r18.add(r20);
        goto L14
    L18:
        Iterator r21 = r18.iterator();
    L20:
        if (r21.hasNext() == false) goto L39;
        h r22 = (h) r21.next();
        com.bytedance.ai.utils.g.a.d("AIStorage", "removeStorageItem notify  " + r22);
        WeakReference<u4.a> r23 = r22.d;
        if (r23 == null) goto L20;
        u4.a r24 = r23.get();
        if (r24 == null) goto L20;
        JsonObject r25 = new JsonObject();
        r25.addProperty("groupID", this.b);
        r25.addProperty("storageID", r10);
        r25.addProperty("persistent", Boolean.valueOf(r11));
        r25.addProperty("key", r12);
        r25.addProperty(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, r15);
        r25.addProperty("extra", r13);
        Unit r26 = Unit.INSTANCE;
        r24.onMessageToAIBridge("onDataRemoved", r25);
        goto L20
    L39:
        return;
    L26:
        return;
    L9:
        r16 = this.c;
        goto L10
    L5:
        r14 = this.c;
        goto L6
    }

    @Override // u4.b
    public final void f(String r10, boolean r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter("ai_storage_user", "userId");
        Intrinsics.checkNotNullParameter(r10, "storageId");
        Intrinsics.checkNotNullParameter(r12, "key");
        String r1 = d(this.b, r10);
        com.bytedance.ai.utils.g.a.d("AIStorage", "updateStorageItem key " + r12 + " value " + r13);
        if (r11 == false) goto L5;
        c r15 = this.d;
    L7:
        if (r15.a(r1, r12, null) != null) goto L9;
        String r16 = "onDataCreated";
    L10:
        r15.c(r1, r12, r13);
        CopyOnWriteArrayList<h> r17 = g().get(r1);
        if (r17 == null) goto L26;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L14:
        if (r19.hasNext() == false) goto L18;
        Object r20 = r19.next();
        if (Intrinsics.areEqual(((h) r20).b, r12) == false) goto L14;
        r18.add(r20);
        goto L14
    L18:
        Iterator r21 = r18.iterator();
    L20:
        if (r21.hasNext() == false) goto L39;
        h r22 = (h) r21.next();
        com.bytedance.ai.utils.g.a.d("AIStorage", "updateStorageItem notify  " + r22);
        WeakReference<u4.a> r23 = r22.d;
        if (r23 == null) goto L20;
        u4.a r24 = r23.get();
        if (r24 == null) goto L20;
        JsonObject r25 = new JsonObject();
        r25.addProperty("groupID", this.b);
        r25.addProperty("storageID", r10);
        r25.addProperty("persistent", Boolean.valueOf(r11));
        r25.addProperty("key", r12);
        r25.addProperty(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, r13);
        r25.addProperty("extra", r14);
        Unit r26 = Unit.INSTANCE;
        r24.onMessageToAIBridge(r16, r25);
        goto L20
    L39:
        return;
    L26:
        return;
    L9:
        r16 = "onDataUpdated";
        goto L10
    L5:
        r15 = this.c;
        goto L7
    }
}
