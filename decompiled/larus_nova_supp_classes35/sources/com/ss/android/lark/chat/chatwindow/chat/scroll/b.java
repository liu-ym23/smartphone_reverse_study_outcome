package com.ss.android.lark.chat.chatwindow.chat.scroll;

import com.larksuite.framework.utils.p;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements com.ss.android.lark.chat.chatwindow.chat.a.InterfaceC0036a {
    public final /* synthetic */ ScrollBottomController a;

    public static final class a implements ScrollBottomController.c {
        public final /* synthetic */ y6b.c<?> a;
        public final /* synthetic */ ScrollBottomController.e b;

        public a(y6b.c<?> r1, ScrollBottomController.e r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.scroll.ScrollBottomController.c
        public final void a(ScrollBottomController.d r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            y6b.c<?> r0 = this.a;
            Intrinsics.checkNotNullParameter(r0, "<set-?>");
            r3.f = r0;
            this.b.c(r3);
        }
    }

    public b(ScrollBottomController r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.a.InterfaceC0036a
    public final Object a(y6b.c<?> r6, y6b.c<?> r7) {
        Intrinsics.checkNotNullParameter(r6, "from");
        Intrinsics.checkNotNullParameter(r7, "to");
        List r0 = p.a(this.a.b.keySet());
        ScrollBottomController r1 = this.a;
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        ScrollBottomController.e r3 = (ScrollBottomController.e) r2.next();
        Intrinsics.checkNotNull(r3);
        Function2<y6b.c<?>, y6b.c<?>, Boolean> r4 = r1.b.get(r3);
        if (r4 == null) goto L8;
        Boolean r5 = (Boolean) r4.invoke(r6, r7);
    L10:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L4;
        return new a(r7, r3);
    L8:
        r5 = null;
        goto L10
    L15:
        return Unit.INSTANCE;
    }
}
