package com.ss.android.lark.chat.chatwindow.chat.v2.widget;

import com.larksuite.framework.utils.AndroidThrottle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> implements AndroidThrottle.d<T> {
    public final c.b<T> a;
    public final Map<String, T> b;

    public final Collection<T> a() {
        ArrayList r0 = new ArrayList(((HashMap) this.b).values());
        ((HashMap) this.b).clear();
        return r0;
    }

    public final void clear() {
        ((HashMap) this.b).clear();
    }

    public final int size() {
        return ((HashMap) this.b).size();
    }

    public a(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.e r2) {
        Intrinsics.checkNotNullParameter(r2, "mDataProvider");
        this.a = r2;
        this.b = new HashMap();
    }

    public final void put(T r3) {
        if (r3 == null) goto L10;
        String r0 = this.a.a(r3);
        if (r0 != null) goto L7;
        return;
    L7:
        if (((HashMap) this.b).containsKey(r0) == true) goto L11;
        ((HashMap) this.b).put(r0, r3);
        return;
    L11:
        return;
    }
}
