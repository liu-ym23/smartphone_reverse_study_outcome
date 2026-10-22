package ayb;

import android.text.TextUtils;
import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import com.larksuite.component.card.utils.FalconApiCallResult;
import com.larksuite.framework.apiplugin.LKEvent;
import com.lynx.react.bridge.Callback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeMethodDispatcher;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements ILynxBridgeMethodDispatcher {
    public final IAppContext a;
    public final boolean b;
    public final Executor c;

    /* JADX INFO: renamed from: ayb.a$a, reason: collision with other inner class name */
    public static final class C0001a implements j18.a {
        public final IAppContext a;
        public final Executor b;

        public final void a(String r2, i18.a r3) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "runnable");
            this.b.execute(r3);
        }

        public C0001a(IAppContext r2, Executor r3, LKEvent r4) {
            Intrinsics.checkNotNullParameter(r2, "appContext");
            Intrinsics.checkNotNullParameter(r3, "executor");
            Intrinsics.checkNotNullParameter(r4, "lkEvent");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    public static final class c implements j18.c {
        public final IAppContext a;
        public final Callback b;
        public final LKEvent c;

        public final void onSuccess(JSONObject r6) {
            Intrinsics.checkNotNullParameter(r6, "successParams");
            Callback r0 = this.b;
            if (r0 == null) goto L6;
            FalconApiCallResult.b r3 = new FalconApiCallResult.b(this.c.a, "ok");
            r3.d = r6;
            r0.invoke(new Object[]{r3.a().a});
            return;
        }

        public final void onFail(int r6, JSONObject r7) {
            Intrinsics.checkNotNullParameter(r7, "failParams");
            Callback r0 = this.b;
            if (r0 == null) goto L6;
            FalconApiCallResult.b r3 = new FalconApiCallResult.b(this.c.a, "fail");
            r3.d = r7;
            r3.e = r6;
            r0.invoke(new Object[]{r3.a().a});
            return;
        }

        public c(IAppContext r2, Callback r3, LKEvent r4, OPTrace r5) {
            Intrinsics.checkNotNullParameter(r2, "appContext");
            Intrinsics.checkNotNullParameter(r4, "lkEvent");
            Intrinsics.checkNotNullParameter(r5, "opTrace");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public a(uy7.a r2) {
        Intrinsics.checkNotNullParameter(r2, "appContext");
        this.a = r2;
        this.b = true;
        this.c = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("OpLynxBridgeDispatcher"));
    }

    public final void handleMethodInvoke(ILynxBridgeContext r9, String r10, JSONObject r11, Callback r12) {
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r11, "params");
        Log.i("OpLynxBridgeDispatcher", "handleMethodInvoke methodName: " + r10);
        if (TextUtils.isEmpty(r10) == false) goto L6;
        Log.e("OpLynxBridgeDispatcher", "handleMethodInvoke method is empty");
        return;
    L6:
        ILynxContainerContext r0 = r9.getContainerContext();
        OPTrace r2 = null;
        if (r0 == null) goto L16;
        Map r1 = r0.getBizExtra();
        if (r1 == null) goto L16;
        if (r1.containsKey("op_trace") == true) goto L14;
        r1 = null;
    L14:
        if (r1 == null) goto L16;
        Object r3 = r1.get("op_trace");
    L18:
        if ((r3 instanceof OPTrace) == false) goto L20;
        r2 = (OPTrace) r3;
    L20:
        if (r2 != null) goto L22;
        r2 = gyb.a.a().subTrace();
    L22:
        System.currentTimeMillis();
        LKEvent.b r4 = new LKEvent.b();     // Catch: Throwable -> L37
        r4.a = r10;     // Catch: Throwable -> L37
        r4.b = r11;     // Catch: Throwable -> L37
        r4.c = r9.getContext();     // Catch: Throwable -> L37
        LKEvent r13 = new LKEvent(r4);     // Catch: Throwable -> L37
        if (this.b == false) goto L31;
        p18.b.a r5 = r13.c();     // Catch: Throwable -> L37
        if (r5 == null) goto L29;
        r5.d("LKEvent", new Object[]{"setFindServiceContext"});     // Catch: Throwable -> L37
    L30:
        r13.h = r9;     // Catch: Throwable -> L37
        goto L31
    L29:
        Log.d("LKEvent", "setFindServiceContext");     // Catch: Throwable -> L37
    L31:
        C0001a r14 = new C0001a(this.a, this.c, r13);     // Catch: Throwable -> L37
        p18.b.a r6 = r13.c();     // Catch: Throwable -> L37
        if (r6 == null) goto L34;
        r6.i("LKEvent", new Object[]{"setAsyncHandleEventExecutor"});     // Catch: Throwable -> L37
    L35:
        r13.k = r14;     // Catch: Throwable -> L37
        r13.g = new c(this.a, r12, r13, r2);     // Catch: Throwable -> L37
        this.a.sendEvent(r13);     // Catch: Throwable -> L37
    L39:
        Log.e("OpLynxBridgeDispatcher", "API: " + r10 + " is not support");
        return;
    L34:
        Log.i("LKEvent", "setAsyncHandleEventExecutor");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Log.e("OpLynxBridgeDispatcher", "invoke method methodName: " + r10 + " cause exception", th);
    L16:
        r3 = null;
        goto L18
    }
}
