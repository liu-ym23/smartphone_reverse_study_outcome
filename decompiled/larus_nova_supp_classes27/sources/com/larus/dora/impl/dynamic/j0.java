package com.larus.dora.impl.dynamic;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.dora.device.DoraDevice;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.impl.databinding.LarusDoraPageDynamicListBinding;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j0 implements Runnable {
    public final /* synthetic */ DoraDynamicViewModelV2.f a;
    public final /* synthetic */ DoraDynamicFragment b;

    public static final class a implements Runnable {
        public final /* synthetic */ DoraDynamicFragment a;
        public final /* synthetic */ DoraDynamicViewModelV2.f b;

        public a(DoraDynamicFragment r1, DoraDynamicViewModelV2.f r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LarusDoraPageDynamicListBinding r0 = this.a.f;     // Catch: Throwable -> L12
            if (r0 == null) goto L15;
            HistoryDeviceNavigationBar r1 = r0.b;     // Catch: Throwable -> L12
            if (r1 == null) goto L19;
            z49.b r2 = ((DoraDynamicViewModelV2.f.c) this.b).b;     // Catch: Throwable -> L12
            if (r2 == null) goto L9;
            String r3 = r2.c();     // Catch: Throwable -> L12
        L10:
            r1.U5(r3);     // Catch: Throwable -> L12
            return;
        L9:
            r3 = null;
            goto L10
        L19:
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public j0(DoraDynamicViewModelV2.f r1, DoraDynamicFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        z49.b r0 = ((DoraDynamicViewModelV2.f.c) this.a).b;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.c();
    L6:
        DoraDevice r3 = this.b.p;
        if (r3 == null) goto L9;
        String r4 = r3.mac;
    L11:
        if (Intrinsics.areEqual(r2, r4) == false) goto L22;
        DoraDynamicFragment r5 = this.b;
        LarusDoraPageDynamicListBinding r6 = r5.f;
        if (r6 == null) goto L17;
        ConstraintLayout r7 = r6.a;
        if (r7 == null) goto L17;
        r7.post(new a(r5, this.a));
    L17:
        DoraDynamicViewModelV2 r8 = this.b.ba0();
        z49.b r9 = ((DoraDynamicViewModelV2.f.c) this.a).b;
        if (r9 == null) goto L20;
        r1 = r9.c();
    L20:
        r8.updateConnectState(new DoraDynamicViewModelV2.c.C0077c(r1));
        return;
    L22:
        return;
    L9:
        r4 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
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
