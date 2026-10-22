package com.ss.android.lark.contact.customized.externalcontact.view;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeContactPageLayoutBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnLayoutChangeListener {
    public final /* synthetic */ OfficeExternalContactFragment a;

    public static final class a implements Runnable {
        public final /* synthetic */ OfficeExternalContactFragment a;

        public a(OfficeExternalContactFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeExternalContactFragment r0 = this.a;     // Catch: Throwable -> L4
            int r1 = OfficeExternalContactFragment.r;     // Catch: Throwable -> L4
            r0.ea0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public e(OfficeExternalContactFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        ContactDbFragmentOfficeContactPageLayoutBinding r10 = this.a.d;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r10 = null;
    L5:
        r10.a.post(new a(this.a));
    }
}
