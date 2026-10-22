package com.ss.android.lark.forwardv3;

import android.content.DialogInterface;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Runnable {
    public final /* synthetic */ ForwardNewFragment a;
    public final /* synthetic */ ForwardErrorResultV3 b;
    public final /* synthetic */ Ref.ObjectRef<String> c;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ ForwardErrorResultV3 a;
        public final /* synthetic */ ForwardNewFragment b;

        public a(ForwardErrorResultV3 r1, ForwardNewFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            if (this.a.isWillClose() == false) goto L6;
            ForwardNewFragment r3 = this.b;
            int r0 = ForwardNewFragment.t;
            r3.X90(null, null);
            return;
        }
    }

    public f(ForwardNewFragment r1, ForwardErrorResultV3 r2, Ref.ObjectRef<String> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        new UDDialogBuilder(this.a.requireContext()).cancelable(true).cancelOnTouchOutside(false).onDismissListener(new a(this.b, this.a)).title(this.b.getTitle()).message((CharSequence) this.c.element).addActionButton(2131391777, 2131893531, null).show();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
