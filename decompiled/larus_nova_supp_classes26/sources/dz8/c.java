package dz8;

import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.chat.job.impl.page.g0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.job.AIJob;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import gz8.f;
import gz8.h;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements IIMCallback<AIJob> {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ FragmentActivity c;
    public final /* synthetic */ Bundle d;
    public final /* synthetic */ a e;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Set r0 = a.a;
        a.a.a(this.a);
        FLogger.a.e("ChatJobEditorRouterInterceptor", "open editor skipped, preload failed jobId=" + this.a + " code=" + r4.getCode() + ", tips=" + r4.getTips());
        h.b(r4);
    }

    public final void onSuccess(Object r8) {
        final AIJob r2 = (AIJob) r8;
        Intrinsics.checkNotNullParameter(r2, "result");
        if (Intrinsics.areEqual(r2.getJobId(), this.a) == false) goto L12;
        int r9 = r2.getJobType();
        int r1 = this.b;
        if (r9 != r1) goto L12;
        if (r1 != 3) goto L12;
        if (r2.getStatus() != 4) goto L12;
        Set r10 = a.a;
        a.a.a(this.a);
        FLogger.a.i("ChatJobEditorRouterInterceptor", "open editor skipped, event task is deleted jobId=" + this.a);
        s r11 = s.a;
        Application r0 = AppHost.a.getApplication();
        String r3 = f.b("triggerTasks_dialog_desc_alreadyDelete");
        r11.getClass();
        s.c(r0, r3);
        return;
    L12:
        if (Intrinsics.areEqual(r2.getJobId(), this.a) == false) goto L20;
        if (r2.getJobType() != this.b) goto L20;
        if (g0.c(r2) == false) goto L20;
        final FragmentActivity r12 = this.c;
        final Bundle r4 = this.d;
        final a r5 = this.e;
        final String r6 = this.a;
        r12.runOnUiThread(new b(r4, r2, r5, r12, r6));
        return;
    L20:
        if (Intrinsics.areEqual(r2.getJobId(), this.a) == true) goto L22;
    L25:
        FLogger.a.e("ChatJobEditorRouterInterceptor", "open editor skipped, preload returned unexpected jobId=" + r2.getJobId() + " expected=" + this.a);
    L26:
        Set r13 = a.a;
        a.a.a(this.a);
        h.a();
        return;
    L22:
        if (r2.getJobType() != this.b) goto L25;
        FLogger.a.i("ChatJobEditorRouterInterceptor", "open editor skipped, task is unavailable jobId=" + this.a);
        goto L26
    }

    public c(String r1, int r2, FragmentActivity r3, Bundle r4, a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
