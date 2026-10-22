package com.ss.android.lark.chat.core.extension;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends com.ss.android.lark.chat.core.api.a implements com.ss.android.lark.chat.core.api.a.InterfaceC0084a {
    public final FragmentActivity a;
    public final List<com.ss.android.lark.chat.core.api.a> b;

    @Override // com.ss.android.lark.chat.core.api.a
    public final boolean b() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        com.ss.android.lark.chat.core.api.a r1 = (com.ss.android.lark.chat.core.api.a) r0.next();
        r1.getClass();
        if (r1.b() == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void d() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r1 = (com.ss.android.lark.chat.core.api.a) r0.next();
        r1.getClass();
        r1.d();
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void f() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r1 = (com.ss.android.lark.chat.core.api.a) r0.next();
        r1.getClass();
        r1.f();
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void h() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r1 = (com.ss.android.lark.chat.core.api.a) r0.next();
        r1.getClass();
        r1.h();
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void i() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r1 = (com.ss.android.lark.chat.core.api.a) r0.next();
        r1.getClass();
        r1.i();
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void j() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r1 = (com.ss.android.lark.chat.core.api.a) r0.next();
        r1.getClass();
        r1.j();
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a.InterfaceC0084a
    public FragmentActivity getActivity() {
        return this.a;
    }

    public a(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.a = r2;
        this.b = new ArrayList();
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void c(Bundle r3) {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r1 = (com.ss.android.lark.chat.core.api.a) r0.next();
        r1.getClass();
        r1.c(r3);
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void e(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r1 = (com.ss.android.lark.chat.core.api.a) r0.next();
        r1.getClass();
        r1.e(r3);
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void g(AssistContent r3) {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r1 = (com.ss.android.lark.chat.core.api.a) r0.next();
        r1.getClass();
        r1.g(r3);
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void a(int r3, int r4, Intent r5) {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r1 = (com.ss.android.lark.chat.core.api.a) r0.next();
        r1.getClass();
        r1.a(r3, r4, r5);
        goto L4
    }
}
