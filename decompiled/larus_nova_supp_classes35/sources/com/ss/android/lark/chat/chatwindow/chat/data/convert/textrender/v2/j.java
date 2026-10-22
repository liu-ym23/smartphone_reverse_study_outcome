package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j {
    public static final a a = null;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "ConfigKey(contextHash=" + this.a + ", richTextNodeParseHash=" + this.b + ", themeParseHash=" + this.c + ", markdownPluginHash=" + this.d + ", parseListenersHash=" + this.e + ')';
        }

        public a(int r1, int r2, int r3, int r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class b implements b3c.d {
        public int a;

        public b() {
        }

        public final b3c.d a(RichTextElement.RichTextTag r2, b3c.a r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "nodeMapper");
            int r0 = (this.a * 31) + r2.hashCode();
            this.a = r0;
            this.a = (r0 * 31) + r3.hashCode();
            return this;
        }
    }

    static {
        a = new a(0, 0, 0, 0, 0);
    }

    public static a a(n r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        b r0 = new b();
        final com.ss.android.lark.coremd.base.parse.b r1 = r10.f;
        v9b.a r2 = (v9b.a) IMContextExtend.A.b(new TextLayoutCacheCoordinator$shouldSkipCacheByData$messageData$1(r1));
        if (r2.i == false) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L38;
        int r5 = r10.f.getValues().hashCode();
        if (DevEnvUtil.isDebugMode(r10.getContext()) == false) goto L30;
        StringBuilder r4 = new StringBuilder("context hash is ");
        Map<Object, Object> r6 = r10.f.getValues();
        LinkedHashMap r7 = new LinkedHashMap(MapsKt.mapCapacity(r6.size()));
        Iterator<T> r8 = r6.entrySet().iterator();
    L15:
        if (r8.hasNext() == false) goto L21;
        Map.Entry r9 = (Map.Entry) r8.next();
        Object r11 = r9.getKey();
        Object r12 = r9.getValue();
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        r7.put(r11, Integer.valueOf(r13));
        goto L15
    L19:
        r13 = 0;
        goto L20
    L21:
        r4.append(r7);
        Log.d("TextLayoutCacheCoordinator", r4.toString());
        StringBuilder r14 = new StringBuilder("theme hash is ");
        Map<Object, Object> r15 = r10.e.getValues();
        LinkedHashMap r16 = new LinkedHashMap(MapsKt.mapCapacity(r15.size()));
        Iterator<T> r17 = r15.entrySet().iterator();
    L23:
        if (r17.hasNext() == false) goto L29;
        Map.Entry r18 = (Map.Entry) r17.next();
        Object r19 = r18.getKey();
        Object r20 = r18.getValue();
        if (r20 == null) goto L27;
        int r21 = r20.hashCode();
    L28:
        r16.put(r19, Integer.valueOf(r21));
        goto L23
    L27:
        r21 = 0;
        goto L28
    L29:
        r14.append(r16);
        Log.d("TextLayoutCacheCoordinator", r14.toString());
    L30:
        r0.a = 0;
        r10.c.a(r0);
        return new a(r5, r0.a, r10.e.getValues().hashCode(), r10.d.hashCode(), r10.g.hashCode());
    L38:
        return a;
    L5:
        if (r2.g == true) goto L8;
        r3 = false;
        goto L9
    }
}
