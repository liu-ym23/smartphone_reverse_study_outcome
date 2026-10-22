package com.ss.android.lark.keyboard.biz.mention;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IMCommonAtStrategy extends com.ss.android.lark.keyboard.edittext2.edittors.at.common.b {
    public static final /* synthetic */ int i = 0;
    public final Function0<String> c;
    public final c d;
    public AndroidThrottle<String> e;
    public final Map<String, List<com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<String, String>>>> f;
    public final Function1<List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<String, String>>>, Unit> g;
    public final Function2<Pair<String, String>, List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<String, String>>>, Unit> h;

    public static final class a {
    }

    public static final class b implements AndroidThrottle.d<String> {
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

        public b() {
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

    public static final class c {
        public final /* synthetic */ IMCommonAtStrategy a;

        public c(IMCommonAtStrategy r1) {
            this.a = r1;
        }

        public final void a(hob.c r4, com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<String, String>> r5) {
            Intrinsics.checkNotNullParameter(r4, "data");
            Intrinsics.checkNotNullParameter(r5, "result");
            String r6 = r4.a;
            LinkedHashMap r0 = (LinkedHashMap) this.a.f;
            Object r1 = r0.get(r6);
            if (r1 != null) goto L5;
            r1 = new ArrayList();
            r0.put(r6, r1);
        L5:
            ((List) r1).add(r5);
            IMCommonAtStrategy r7 = this.a;
            if (r7.e != null) goto L8;
            AndroidThrottle.a r2 = new AndroidThrottle.a();
            r2.b = 200;
            r2.a = CoreThreadPool.getNonblockingHandler();
            r2.d = new b();
            r2.e = new m(r7);
            r7.e = r2.a();
        L8:
            AndroidThrottle<String> r8 = r7.e;
            if (r8 == null) goto L12;
            r8.d(r6);
            return;
        }
    }

    static {
    }

    public IMCommonAtStrategy(Function0<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "chatIdProvider");
        this.c = r2;
        this.d = new c(this);
        this.f = new LinkedHashMap();
        this.g = IMCommonAtStrategy$notifyFailedAction$1.INSTANCE;
        this.h = IMCommonAtStrategy$notifySuccessAction$1.INSTANCE;
    }

    public final void a(List<String> r3) {
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        String r0 = (String) r4.next();
        List<com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<String, String>>> r1 = this.f.remove(r0);
        this.g.invoke(r1);
        if (r1 == null) goto L4;
        r1.clear();
        goto L4
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.b, com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final com.ss.android.lark.keyboard.edittext2.edittors.at.a<hob.c> c(com.ss.android.lark.keyboard.edittext2.edittors.a r3, hob.c r4) {
        Intrinsics.checkNotNullParameter(r3, "editor");
        Intrinsics.checkNotNullParameter(r4, "data");
        String r0 = f.a;
        f.a(r4, r4.a);
        return new IMCommonAtSpanHolder(this.d, r3, r4);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.b, com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final fob.c.a<hob.c> k(com.ss.android.lark.keyboard.edittext2.edittors.a r3, RichTextElement.AtProperty r4) {
        Intrinsics.checkNotNullParameter(r3, "editor");
        Intrinsics.checkNotNullParameter(r4, "property");
        fob.c.a<hob.c> r5 = super.k(r3, r4);
        hob.c r0 = r5.b;
        if (r0 == null) goto L5;
        String r1 = f.a;
        f.a(r0, r4.getUserId());
    L5:
        return r5;
    }
}
