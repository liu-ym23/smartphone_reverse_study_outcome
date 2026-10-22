package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ComposePool<ItemId, Item extends b<ItemId>> {
    public static final /* synthetic */ int e = 0;
    public final Pair<ItemId, Item>[] a;
    public int b;
    public final Function1<Item, Unit> c;
    public final int d;

    public static final class a {
    }

    static {
    }

    public ComposePool(int r1) {
        this.d = r1;
        this.a = new Pair[r1];
        this.c = ComposePool$recycleAction$1.INSTANCE;
    }

    public final Item a(ItemId r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        int r0 = 0;
    L3:
        int r1 = this.d;
        if (r0 < 0) goto L25;
        if (r1 <= r0) goto L26;
        if (this.b <= 0) goto L27;
        Pair<ItemId, Item> r2 = this.a[r0];
        if (r2 == null) goto L12;
        Object r3 = r2.getFirst();
    L14:
        if (Intrinsics.areEqual(r3, r5) == true) goto L15;
        r0 = r0 + 1;
        goto L3
    L15:
        if (r2 == null) goto L17;
        b r6 = (b) r2.getSecond();
    L18:
        this.a[r0] = null;
        this.b--;
        return (Item) r6;
    L17:
        r6 = null;
        goto L18
    L12:
        r3 = null;
        goto L14
    L27:
        return null;
    L26:
        return null;
    L25:
        return null;
    }

    public final void b(Function1<? super Item, Unit> r6) {
        int r0 = this.d;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (r6 == null) goto L10;
        Pair<ItemId, Item> r3 = this.a[r2];
        if (r3 == null) goto L10;
        b r4 = (b) r3.getSecond();
        if (r4 == null) goto L10;
        r6.invoke(r4);
    L10:
        this.a[r2] = null;
        r2 = r2 + 1;
        goto L3
    L11:
        this.b = 0;
    }

    public static void c(ComposePool r9, b r10) {
        Function1<Item, Unit> r0 = r9.c;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "item");
        Object r1 = r10.g();
        if (r0 == null) goto L5;
        Unit r2 = (Unit) r0.invoke(r10);
    L5:
        int r3 = 0;
        if (r9.b <= 0) goto L27;
        Intrinsics.checkNotNullParameter(r10, "instance");
        int r4 = r9.d;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L24;
        Pair<ItemId, Item> r6 = r9.a[r5];
        Pair<ItemId, Item> r7 = null;
        if (r6 != null) goto L12;
    L21:
        if (r7 != null) goto L22;
        r5 = r5 + 1;
        goto L8
    L22:
        boolean r8 = true;
    L25:
        if (r8 == true) goto L27;
    L28:
        int r11 = r9.d;
    L29:
        if (r3 >= r11) goto L40;
        Pair<ItemId, Item>[] r12 = r9.a;
        if (r12[r3] == null) goto L32;
        r3 = r3 + 1;
        goto L29
    L32:
        r12[r3] = new Pair(r1, r10);
        r9.b++;
        return;
    L40:
        return;
    L12:
        if (Intrinsics.areEqual(r6.getFirst(), r10.g()) == true) goto L14;
    L16:
        boolean r13 = false;
    L17:
        if (r13 == true) goto L20;
        r6 = null;
    L20:
        r7 = r6;
        goto L21
    L14:
        if (((b) r6.getSecond()) != r10) goto L16;
        r13 = true;
        goto L17
    L24:
        r8 = false;
    L27:
        if (r9.b == 0) goto L28;
    }
}
