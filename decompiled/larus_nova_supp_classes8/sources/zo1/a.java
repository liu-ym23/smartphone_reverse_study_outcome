package zo1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a implements f<s> {
    public final HashMap<String, i> a;

    /* JADX INFO: renamed from: zo1.a$a, reason: collision with other inner class name */
    public static final class C0429a {
    }

    static {
    }

    @Override // zo1.d
    public final void a() {
        Intrinsics.checkNotNullParameter("onRoomExit", "event");
        Iterator<Map.Entry<String, i>> r2 = this.a.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        i r3 = r2.next().getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter("onRoomExit", "event");
        r3.a.clear();
        r3.b.clear();
        goto L4
    }

    public final i e() {
        return this.a.get("ready");
    }

    public final i n() {
        return this.a.get("showing");
    }

    public a() {
        this.a = new HashMap();
    }

    @Override // zo1.f
    public final List<s> b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        i r3 = this.a.get(r2);
        if (r3 == null) goto L7;
        List r4 = r3.a;
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new ArrayList();
    }

    @Override // zo1.f
    public Integer getComponentByGroupId(int r1) {
        return -1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // zo1.f
    public final void d(String r3, g<s> r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "observer");
        i r5 = this.a.get(r3);
        if (r5 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "observer");
        r5.b.add((g<T>) r4);
        return;
    }
}
