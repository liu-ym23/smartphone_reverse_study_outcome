package com.ss.android.lark.forwardv3.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.lark.pb.im.v1.FilePermCheckBlockInfo;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ FilePermCheckBlockInfo b;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public c(Context r1, FilePermCheckBlockInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        new UDDialogBuilder(this.a).title(this.b.popup_title).message(this.b.popup_text).addActionButton(2131391777, this.b.button, a.a).show();
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
