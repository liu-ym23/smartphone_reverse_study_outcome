package zqb;

import android.app.Activity;
import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: zqb.a$a, reason: collision with other inner class name */
    public static final class RunnableC0357a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public RunnableC0357a(Context r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Context r0 = this.a;
            if ((r0 instanceof Activity) == true) goto L6;
            String r1 = this.b;
            Intrinsics.checkNotNull(r1);
            UDToast.show(r0, r1);
            return;
        L6:
            UDDialogBuilder r2 = new UDDialogBuilder(this.a);
            String r3 = this.b;
            Intrinsics.checkNotNull(r3);
            r2.message(r3).addActionButton(2131391777, 2131891840, null).show();
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

    static {
    }

    public static void a(Context r1, ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "error");
        UICallbackExecutor.execute(new RunnableC0357a(r1, r2.getDisplayMsg(UIUtils.getString(r1, 2131890782))));
    }
}
