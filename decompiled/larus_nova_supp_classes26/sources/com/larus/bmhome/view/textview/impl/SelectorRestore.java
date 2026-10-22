package com.larus.bmhome.view.textview.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tt8.c;
import ut8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class SelectorRestore {
    public String a;
    public final Map<String, c> b;
    public boolean c;
    public com.larus.bmhome.chat.component.bottom.reference.a d;
    public final g e;
    public final SelectorRestore$outClearStoreListener$1 f;
    public final SelectorRestore$touchHideSelectorListener$1 g;
    public tt8.a h;

    public static final class a implements g.a {
        public final /* synthetic */ SelectorRestore a;

        @Override // ut8.g.a
        public final void b() {
        }

        @Override // ut8.g.a
        public final void onStart() {
            SelectorRestore r0 = this.a;
            Map<String, c> r1 = r0.b;
            LinkedHashMap r2 = (LinkedHashMap) r1;
            c r3 = (c) r2.get(r0.a);
            if (r3 == null) goto L7;
            boolean r4 = true;
            if (r3.c != true) goto L7;
        L8:
            if (r4 == false) goto L18;
            SelectorRestore r5 = this.a;
            if (r5.c == false) goto L19;
            com.larus.bmhome.chat.component.bottom.reference.a r6 = r5.d;
            if (r6 != null) goto L14;
        L16:
            ((LinkedHashMap) this.a.b).clear();
            this.a.c = false;
            return;
        L14:
            if (r6.i9() == false) goto L16;
            r6.sZ();
            goto L16
        L19:
            return;
        L18:
            return;
        L7:
            r4 = false;
            goto L8
        }

        @Override // ut8.g.a
        public final void onStop() {
            SelectorRestore r0 = this.a;
            Map<String, c> r1 = r0.b;
            LinkedHashMap r2 = (LinkedHashMap) r1;
            c r3 = (c) r2.get(r0.a);
            boolean r4 = false;
            if (r3 != null) goto L5;
        L7:
            if (r4 == false) goto L12;
            SelectorRestore r5 = this.a;
            if (r5.c == true) goto L13;
            r5.c = true;
            return;
        L13:
            return;
        L12:
            return;
        L5:
            if (r3.c != true) goto L7;
            r4 = true;
            goto L7
        }

        public a(SelectorRestore r1) {
            this.a = r1;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.view.textview.impl.SelectorRestore$outClearStoreListener$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.view.textview.impl.SelectorRestore$touchHideSelectorListener$1] */
    public SelectorRestore() {
        this.b = new LinkedHashMap();
        this.f = new SelectorRestore$outClearStoreListener$1(this);
        this.g = new SelectorRestore$touchHideSelectorListener$1(this);
        g r0 = new g();
        this.e = r0;
        a r1 = new a(this);
        Intrinsics.checkNotNullParameter(r1, "listener");
        r0.b = r1;
    }
}
