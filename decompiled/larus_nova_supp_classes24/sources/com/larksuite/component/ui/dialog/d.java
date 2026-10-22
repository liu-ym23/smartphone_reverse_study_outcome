package com.larksuite.component.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.larksuite.component.ui.dialog.d;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class d<T extends d> {
    public static final SparseIntArray e = null;
    public Context a;
    public int b;
    public UDBaseDialogBuilder c;
    public UDDialogController d;

    public static abstract class a<T extends LKUIDialog> {
        public a() {
        }

        public void a(T r1) {
        }

        public void b(T r1) {
        }
    }

    static {
        SparseIntArray r0 = new SparseIntArray();
        e = r0;
        r0.put(2131378560, 2131391809);
        r0.put(2131378556, 2131391794);
        r0.put(2131378559, 2131391770);
        r0.put(2131378550, 2131391778);
        r0.put(2131378551, 2131391777);
        r0.put(2131378549, 2131391777);
        r0.put(2131378555, 2131391793);
        r0.put(2131378548, 2131391775);
    }

    public final LKUIDialog c() {
        if (this.b != 0) goto L5;
        LKUIDialog r0 = new LKUIDialog(this.a);
    L6:
        this.d.apply(this.c, r0);
        return r0;
    L5:
        r0 = new LKUIDialog(this.a, this.b);
        goto L6
    }

    public final void d() {
        f r0 = new f(this);
        Context r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        int r2 = LKUIGlobalDialogActivity.b;
        Intrinsics.checkNotNullParameter(r0, "lkuiDialog");
        LKUIGlobalDialogActivity.b++;
        LKUIGlobalDialogActivity.c.put(Integer.valueOf(LKUIGlobalDialogActivity.b), new WeakReference(r0));
        int r3 = LKUIGlobalDialogActivity.b;
        Intent r4 = new Intent(r1, LKUIGlobalDialogActivity.class);
        r4.putExtra("id_key", r3);
        r4.addFlags(268435456);
        r1.startActivity(r4);
    }

    public final LKUIDialog i() {
        LKUIDialog r0 = c();
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
    L7:
        return r0;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L7
    }

    public d(Context r2) {
        this.a = r2;
        this.c = new UDDialogBuilder(this.a);
        this.d = new e(this.a);
    }

    public final void e(int r2) {
        this.c.gravity(r2);
        if (r2 != 80) goto L6;
        int r3 = LKUIDialog.c;
        return;
    }

    public final void f(float r2) {
        this.c.height(r2);
        if (r2 != 1.0f) goto L8;
        this.c.height(-1.0f);
        if (this.b != 0) goto L9;
        this.b = 2131952408;
        return;
    L9:
        return;
    }

    public final void g(a r3) {
        if (r3 != null) goto L4;
        this.c.lifecycleCallback(null);
        return;
    L4:
        this.c.lifecycleCallback(new j(r3));
    }

    public final void h(CharSequence r3) {
        UDBaseDialogBuilder r0 = this.c;
        if (TextUtils.isEmpty(r3) == false) goto L5;
        r3 = "";
    L5:
        r0.message(r3);
    }

    public final void j(int r2) {
        this.c.title(r2);
        this.a.getString(r2);
    }

    public final void k(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        this.c.title("");
        return;
    L5:
        this.c.title(r2);
    }

    public final void a(int r3, int r4, DialogInterface.OnClickListener r5) {
        this.c.addActionButton(e.get(r3, r3), r4, r5);
    }

    public final void b(int r3, CharSequence r4, DialogInterface.OnClickListener r5) {
        this.c.addActionButton(e.get(r3, r3), r4, r5);
    }
}
