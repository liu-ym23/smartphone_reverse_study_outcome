package zib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ s5c.d b;

    public f(boolean r1, s5c.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Log.d("ForwardHitPointV3", "sendForwardListShow enableAIKnowledge: " + this.a);
        int r0 = e.a;
        s5c.d.o2.getClass();
        s5c.d r1 = s5c.d.b.b(new s5c.a("NewForward", "view"), new s5c.a("is_knowledge_ai_show", String.valueOf(this.a)));
        com.ss.android.lark.forwardv3.utils.b.d();
        s5c.d r2 = r1.plus(new s5c.a("panel_version", "integration_portrait_display")).plus(this.b);
        Intrinsics.checkNotNullParameter(r2, "param");
        Statistics.sendEvent("im_msg_forward_select_view", r2.plus(ChatParamUtils.e()).toJson());
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
