package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends AbsPSHighlightComp {
    public static final /* synthetic */ int i = 0;
    public final View f;
    public final a.C0095a g;
    public final a h;

    public static final class a {
        public Function0<? extends View> a;
        public Function1<? super C0095a, Unit> b;
        public final String c;
        public final n d;
        public final Context e;
        public final DataCenter f;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.f$a$a, reason: collision with other inner class name */
        public static final class C0095a {
            public Function0<Unit> a;
            public Function0<Unit> b;
            public Function0<Unit> c;
            public final AbsPSHighlightComp d;

            public C0095a(AbsPSHighlightComp r2) {
                Intrinsics.checkNotNullParameter(r2, "comp");
                this.d = r2;
            }
        }

        public a(String r2, n r3, Context r4, DataCenter r5) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "type");
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.f = r5;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void k() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void m(FailReason r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void n(InterruptReason r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.g
    public final View getView() {
        Function0<? extends View> r0 = this.h.a;
        if (r0 == null) goto L7;
        View r1 = (View) r0.invoke();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void j() {
        a.C0095a r0 = this.g;
        if (r0 == null) goto L7;
        Function0<Unit> r1 = r0.c;
        if (r1 == null) goto L7;
        Unit r2 = (Unit) r1.invoke();
    L7:
        ((Map) this.a.getValue()).clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void l() {
        a.C0095a r0 = this.g;
        if (r0 == null) goto L8;
        Function0<Unit> r1 = r0.b;
        if (r1 == null) goto L9;
        Unit r2 = (Unit) r1.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void o() {
        a.C0095a r0 = this.g;
        if (r0 == null) goto L8;
        Function0<Unit> r1 = r0.a;
        if (r1 == null) goto L9;
        Unit r2 = (Unit) r1.invoke();
        return;
    L9:
        return;
    }

    public f(String r2, n r3, Context r4, DataCenter r5, a r6) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r6, "builder");
        super(r2, r3, r5);
        this.h = r6;
        this.f = new View(r4);
        Function1<? super a.C0095a, Unit> r7 = r6.b;
        if (r7 == null) goto L5;
        a.C0095a r8 = new a.C0095a(this);
        r7.invoke(r8);
    L6:
        this.g = r8;
        return;
    L5:
        r8 = null;
        goto L6
    }
}
