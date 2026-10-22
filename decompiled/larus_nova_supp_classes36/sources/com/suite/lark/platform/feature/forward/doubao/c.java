package com.suite.lark.platform.feature.forward.doubao;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ DoubaoForwardConfirmFragment a;
    public final /* synthetic */ ForwardErrorResultV3 b;
    public final /* synthetic */ String c;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ ForwardErrorResultV3 a;
        public final /* synthetic */ DoubaoForwardConfirmFragment b;

        public a(ForwardErrorResultV3 r1, DoubaoForwardConfirmFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            if (this.a.isWillClose() == false) goto L8;
            FragmentActivity r2 = this.b.getActivity();
            if (r2 == null) goto L9;
            r2.finish();
            return;
        L9:
            return;
        }
    }

    public c(DoubaoForwardConfirmFragment r1, ForwardErrorResultV3 r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a.isAdded() == true) goto L5;
        return;
    L5:
        Context r0 = this.a.getContext();
        if (r0 != null) goto L8;
        return;
    L8:
        UDDialogBuilder r1 = new UDDialogBuilder(r0).cancelable(true).cancelOnTouchOutside(false).onDismissListener(new a(this.b, this.a)).title(this.b.getTitle());
        String r2 = this.c;
        Intrinsics.checkNotNull(r2);
        r1.message(r2).addActionButton(2131391777, 2131893531, null).show();
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
