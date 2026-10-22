package com.ss.android.lark.photoeditor.impl.ui;

import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l implements jkc.b {
    public final /* synthetic */ File a;
    public final /* synthetic */ m.a b;

    public class a implements Runnable {
        public final /* synthetic */ l a;

        public final void a() {
            if (UIUtils.isActivityRunning(this.a.b.c.a.a) == true) goto L5;
            return;
        L5:
            l r0 = this.a;
            o.a r1 = r0.b.c.a.f;
            if (r1 == null) goto L9;
            PhotoEditorFragment.b r2 = (PhotoEditorFragment.b) r1;
            r2.a(r0.a.getAbsolutePath(), new Pair(Integer.valueOf(this.a.b.a.getWidth()), Integer.valueOf(this.a.b.a.getHeight())), this.a.b.b);
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

        public a(l r1) {
            this.a = r1;
        }
    }

    public final void a(PolarisFileWrapper r2) {
        UICallbackExecutor.execute(new k(this, r2));
    }

    public final void b(DecryptException r3) {
        Log.e("PhotoEditorPresenter", "occurs decrypt error: " + r3.getMessage());
        o r4 = this.b.c.a;
        if ("from_preview".equals(r4.c) == false) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        return;
    L11:
        UICallbackExecutor.execute(new a(this));
        return;
    L5:
        if ("from_screenshot_forward_preview".equals(r4.c) == true) goto L8;
        r5 = false;
        goto L9
    }

    public l(m.a r1, File r2) {
        this.b = r1;
        this.a = r2;
    }
}
