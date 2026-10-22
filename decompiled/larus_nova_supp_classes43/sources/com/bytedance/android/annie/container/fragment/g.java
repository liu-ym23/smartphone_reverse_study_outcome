package com.bytedance.android.annie.container.fragment;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.android.annie.view.WebRiskHintView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements Runnable {
    public final /* synthetic */ hr7.c a;
    public final /* synthetic */ AnnieFragment b;

    public static final class a implements Runnable {
        public final /* synthetic */ AnnieFragment a;

        public a(AnnieFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebRiskHintView r0 = this.a.F;     // Catch: Throwable -> L7
            if (r0 == null) goto L10;
            r0.setVisibility(8);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    public g(hr7.c r1, AnnieFragment r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void a() {
        hr7.c r0 = this.a;
        if (r0 != null) goto L5;
    L18:
        AnnieFragment r1 = this.b;
        WebRiskHintView r10 = r1.F;
        if (r10 == null) goto L25;
        r10.post(new a(r1));
        return;
    L25:
        return;
    L5:
        if (r0.e == false) goto L18;
        if (TextUtils.isEmpty(r0.f) == true) goto L18;
        WebRiskHintView r11 = this.b.F;
        if (r11 == null) goto L12;
        r11.setVisibility(0);
    L12:
        WebRiskHintView r12 = this.b.F;
        if (r12 == null) goto L22;
        String r13 = this.a.f;
        Intrinsics.checkNotNullParameter(r13, "hintText");
        ViewGroup r14 = r12.c;
        if (r14 == null) goto L17;
        r14.post(new ea.a(r12, r13));
        return;
    L17:
        r12.post(new ea.b(r12, r13));
        return;
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
