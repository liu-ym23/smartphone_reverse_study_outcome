package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.larksuite.framework.utils.AndroidThrottle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.facade.mdeditor.at.a$a, reason: collision with other inner class name */
    public static final class C0182a {
    }

    public static final class b implements AndroidThrottle.d<c> {
        public final List<c> a;

        public final Collection<c> a() {
            List r0 = CollectionsKt.toMutableList(this.a);
            ((ArrayList) this.a).clear();
            return r0;
        }

        public final void clear() {
            ((ArrayList) this.a).clear();
        }

        public final int size() {
            return ((ArrayList) this.a).size();
        }

        public b() {
            this.a = new ArrayList();
        }

        public final void put(Object r2) {
            c r3 = (c) r2;
            if (r3 == null) goto L6;
            ((ArrayList) this.a).add(r3);
            return;
        }
    }

    public static final class c {
    }

    static {
    }
}
