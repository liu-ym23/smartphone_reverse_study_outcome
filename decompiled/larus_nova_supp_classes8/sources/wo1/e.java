package wo1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.jsb.ChangeSTTempStateResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends a<f, ChangeSTTempStateResultModel> {
    public final com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f a;

    public e(com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r2) {
        Intrinsics.checkNotNullParameter(r2, "commonIconModel");
        this.a = r2;
    }

    public final void invoke(Object r6, CallContext r7) {
        f r8 = (f) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        String r9 = r8.getType();
        if (r9 == null) goto L40;
        int r1 = r9.hashCode();
        if (r1 == (-690213213)) goto L29;
        if (r1 == (-338834319)) goto L21;
        if (r1 != 635343428) goto L40;
        if (r9.equals("showNormal") == false) goto L40;
        Intrinsics.checkNotNullParameter(r8, "params");
        Integer r10 = r8.b();
        if (r10 == null) goto L42;
        r10.intValue();
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r11 = this.a;
        if (r11.e != null) goto L19;
        ALogger.i("CommonIconModel", "id:" + r11.q.type + ",showCommonToNormalState common icon modle is recycled");
        return;
    L19:
        r11.showNormalState();
        return;
    L42:
        return;
    L21:
        if (r9.equals("showTemp") == false) goto L40;
        Intrinsics.checkNotNullParameter(r8, "params");
        Integer r12 = r8.b();
        if (r12 == null) goto L45;
        r12.intValue();
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r13 = this.a;
        if (r13.e != null) goto L27;
        ALogger.i("CommonIconModel", "id:" + r13.q.type + ",changeCommonToTempWidth common icon modle is recycled");
        return;
    L27:
        r13.changeTempWidth();
        return;
    L45:
        return;
    L29:
        if (r9.equals("register") == false) goto L40;
        Intrinsics.checkNotNullParameter(r8, "params");
        Integer r14 = r8.b();
        if (r14 == null) goto L48;
        int r15 = r14.intValue();
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r0 = this.a;
        Long r16 = r8.a();
        if (r16 == null) goto L35;
        long r2 = r16.longValue();
    L37:
        if (r0.e != null) goto L39;
        ALogger.i("CommonIconModel", "id:" + r0.q.type + ",registerCommonShowTempState common icon modle is recycled");
        return;
    L39:
        r0.registerShowTempState(r15, r2);
        return;
    L35:
        r2 = 0;
        goto L37
    L48:
        return;
    L40:
        finishWithFailure(new Exception("ChangeSTTempStateMethod no this type"));
    }
}
