package com.ss.android.lark.forwardv3.plugins.at;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardAtStrategy extends com.ss.android.lark.keyboard.edittext2.edittors.at.common.b {
    public static final /* synthetic */ int j = 0;
    public final Function0<String> c;
    public AndroidThrottle<String> d;
    public final Map<String, List<com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>>> e;
    public final Map<String, hob.c> f;
    public final c g;
    public final Function1<List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>>, Unit> h;
    public final Function2<hob.c, List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>>, Unit> i;

    public static final class a implements AndroidThrottle.d<String> {
        public final Set<String> a;

        public final Collection<String> a() {
            ArrayList r0 = new ArrayList(this.a);
            this.a.clear();
            return r0;
        }

        public final void clear() {
            this.a.clear();
        }

        public final int size() {
            return this.a.size();
        }

        public a() {
            this.a = new LinkedHashSet();
        }

        public final void put(Object r2) {
            String r3 = (String) r2;
            if (r3 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == true) goto L13;
            this.a.add(r3);
            return;
        L13:
            return;
        L5:
            if (r3.length() == 0) goto L8;
            r0 = false;
            goto L9
        }
    }

    public static final class b {
    }

    public static final class c {
        public final /* synthetic */ ForwardAtStrategy a;

        public c(ForwardAtStrategy r1) {
            this.a = r1;
        }

        public final void a(hob.c r6, com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c> r7) {
            Intrinsics.checkNotNullParameter(r6, "data");
            Intrinsics.checkNotNullParameter(r7, "result");
            Log.i("ForwardAtStrategy", "begin loadData = " + r6.a);
            if (Intrinsics.areEqual(this.a.c.invoke(), "forward_ai_knowledge_id") == false) goto L5;
            boolean r0 = true;
            r6.d = true;
            r7.d(r6);
        L6:
            if (r0 == false) goto L8;
            return;
        L8:
            String r1 = r6.a;
            hob.c r2 = (hob.c) ((LinkedHashMap) this.a.f).get(r1);
            List r3 = (List) ((LinkedHashMap) this.a.e).get(r1);
            if (r2 != null) goto L11;
        L14:
            this.a.f.put(r1, r6);
            if (r3 == null) goto L19;
            r3.add(r7);
            return;
        L19:
            if (this.a.e.size() < 100) goto L22;
            Log.w("ForwardAtStrategy", "not load chatter, exceeded the limit, chatterId = " + r1);
            return;
        L22:
            ArrayList r8 = new ArrayList();
            r8.add(r7);
            this.a.e.put(r1, r8);
            ForwardAtStrategy r9 = this.a;
            if (r9.d != null) goto L25;
            AndroidThrottle.a r10 = new AndroidThrottle.a();
            r10.b = 200;
            r10.a = CoreThreadPool.getNonblockingHandler();
            r10.d = new a();
            r10.e = new com.ss.android.lark.forwardv3.plugins.at.b(r9);
            r9.d = r10.a();
        L25:
            AndroidThrottle<String> r11 = r9.d;
            if (r11 == null) goto L29;
            r11.d(r1);
            return;
        L29:
            return;
        L11:
            if (CollectionUtils.isEmpty(r3) == false) goto L14;
            Log.i("ForwardAtStrategy", "get result from history = (" + r2.a + ',' + r2.d + ')');
            r7.d(r2);
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    static {
    }

    public ForwardAtStrategy(Function0<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "chatIdProvider");
        this.c = r2;
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new c(this);
        this.h = ForwardAtStrategy$notifyFailedAction$1.INSTANCE;
        this.i = ForwardAtStrategy$notifySuccessAction$1.INSTANCE;
    }

    public final void a(List<String> r3) {
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        String r0 = (String) r4.next();
        List<com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>> r1 = this.e.remove(r0);
        this.h.invoke(r1);
        if (r1 == null) goto L4;
        r1.clear();
        goto L4
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.b, com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final com.ss.android.lark.keyboard.edittext2.edittors.at.a<hob.c> c(com.ss.android.lark.keyboard.edittext2.edittors.a r5, hob.c r6) {
        Intrinsics.checkNotNullParameter(r5, "editor");
        Intrinsics.checkNotNullParameter(r6, "data");
        boolean r0 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.alert_support_at", false);
        Log.i("FGUtils", "FG key: core.forward.alert_support_at: " + r0);
        if (r0 == false) goto L10;
        boolean r2 = true;
        if (((CharSequence) this.c.invoke()).length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L11:
        if (r2 == false) goto L14;
        r6.d = false;
        Log.i("ForwardAtStrategy", "set outChatUser by multi-target selected ");
    L14:
        return new com.ss.android.lark.forwardv3.plugins.at.a(this.g, r5, r6);
    L7:
        r1 = false;
    L10:
        r2 = false;
        goto L11
    }
}
