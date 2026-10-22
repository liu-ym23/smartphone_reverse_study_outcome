package com.ss.android.lark.chat.chatwindow.chat.message.cellv2;

import android.content.Context;
import android.view.View;
import b3b.f;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;
import v4b.c;
import v4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class b<Data, PatchData> implements i<Data, PatchData> {
    public final g a;
    public final Context b;
    public final m2b.a c;
    public final f d;
    public final d e;
    public final c f;

    public static final class a implements View.OnLongClickListener {
        public final /* synthetic */ m<Data> a;
        public final /* synthetic */ b<Data, PatchData> b;
        public final /* synthetic */ Data c;

        public a(m<Data> r1, b<Data, PatchData> r2, Data r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            e6b.b r4 = this.a;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 != null) goto L10;
            return false;
        L10:
            return r5.e(this.b, this.c);
        L5:
            r5 = null;
            goto L6
        }
    }

    public final Class<PatchData> b() {
        return null;
    }

    public abstract /* synthetic */ void update(m<Data> r1, q<Data> r2, Data r3);

    public final Context getContext() {
        return this.b;
    }

    public b(g r4) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        this.a = r4;
        this.b = r4.getContext();
        i3b.d r0 = (i3b.d) r4.c.a(i3b.d.class);
        c r1 = null;
        if (r0 == null) goto L5;
        m2b.a r2 = r0.a();
    L6:
        if (r2 == null) goto L21;
        this.c = r2;
        i3b.d r3 = (i3b.d) r4.c.a(i3b.d.class);
        if (r3 == null) goto L10;
        f r5 = r3.g();
    L11:
        this.d = r5;
        i3b.d r6 = (i3b.d) r4.c.a(i3b.d.class);
        if (r6 == null) goto L14;
        d r7 = r6.j();
    L15:
        this.e = r7;
        i3b.d r8 = (i3b.d) r4.c.a(i3b.d.class);
        if (r8 == null) goto L18;
        r1 = r8.b();
    L18:
        this.f = r1;
        return;
    L14:
        r7 = null;
        goto L15
    L10:
        r5 = null;
        goto L11
    L21:
        throw new IllegalStateException("chatContext is null".toString());
    L5:
        r2 = null;
        goto L6
    }

    public void a(m<Data> r1, q<Data> r2) {
        i.a.a(r1, r2);
    }

    public final void f(View r2, m<Data> r3, Data r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "cell");
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        r2.setOnLongClickListener(new a(r3, this, r4));
    }

    public final void g(q r2, j r3, IMMessageKeys$Slots r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "slotId");
        k r5 = r2.o(r3, r4);
        if (r5 == null) goto L6;
        this.a.d.b(r3, k.class, r5);
        return;
    }

    public final void c(BlueprintCell r1, q r2, Object r3, Object r4) {
        i.a.b(this, r1, r2, r3, r4);
    }
}
