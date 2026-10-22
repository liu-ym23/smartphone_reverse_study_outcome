package i08;

import android.text.TextUtils;
import android.widget.TextView;
import com.larksuite.component.ui.toast.loading.LKUILoadingToastImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements Runnable {
    public final /* synthetic */ LKUILoadingToastImpl a;
    public final /* synthetic */ CharSequence b;

    public b(LKUILoadingToastImpl r1, CharSequence r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LKUILoadingToastImpl r0 = this.a;     // Catch: Throwable -> L8
        CharSequence r1 = this.b;     // Catch: Throwable -> L8
        LKUILoadingToastImpl.b r2 = r0.f;     // Catch: Throwable -> L8
        r2.getClass();     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r1) == false) goto L5;
        int r3 = 8;
    L6:
        TextView r4 = r2.a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L8
        r4.setText(r1);     // Catch: Throwable -> L8
        TextView r5 = r2.a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L8
        r5.setVisibility(r3);     // Catch: Throwable -> L8
        return;
    L5:
        r3 = 0;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
