package com.larus.dora.impl.device.manage;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.impl.databinding.LarusDoraGDeviceManagementPageBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e0 implements Runnable {
    public final /* synthetic */ DoraGDeviceManagementFragment a;

    public static final class a implements Runnable {
        public final /* synthetic */ DoraGDeviceManagementFragment a;

        public a(DoraGDeviceManagementFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DoraGDeviceManagementFragment r0 = this.a;     // Catch: Throwable -> L10
            DoraGDeviceManagementAdapter r1 = r0.j;     // Catch: Throwable -> L10
            if (r1 == null) goto L13;
            LarusDoraGDeviceManagementPageBinding r2 = r0.g;     // Catch: Throwable -> L10
            if (r2 == null) goto L7;
            RecyclerView r3 = r2.b;     // Catch: Throwable -> L10
        L8:
            r1.y2(r3);     // Catch: Throwable -> L10
            return;
        L7:
            r3 = null;
            goto L8
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public e0(DoraGDeviceManagementFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraGDeviceManagementFragment r0 = this.a;     // Catch: Throwable -> L8
        LarusDoraGDeviceManagementPageBinding r1 = r0.g;     // Catch: Throwable -> L8
        if (r1 == null) goto L11;
        RecyclerView r2 = r1.b;     // Catch: Throwable -> L8
        if (r2 == null) goto L15;
        r2.post(new a(r0));     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
