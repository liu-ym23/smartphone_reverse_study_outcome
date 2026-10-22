package a2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import b3.h;
import b3.p;
import com.bytedance.ai.bridge.method.info.GetAppInfoMethod;
import com.bytedance.ai.bridge.method.router.AbsCreateTextMethodIDL;
import com.bytedance.ai.bridge.method.router.AbsCreateWidgetMethodIDL;
import com.bytedance.ai.bridge.method.router.AbsReplyLocalPluginMethodIDL;
import com.bytedance.ai.bridge.method.router.CreateTextMethod;
import com.bytedance.ai.bridge.method.router.CreateWidgetMethod;
import com.bytedance.ai.bridge.method.router.ReplyLocalPluginMethod;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.k;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f53a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f54b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f55c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ c(int r5, Object r10, Object r11, Object r12, Object r13) {
        this.f53a = r5;
        this.f54b = r10;
        this.f55c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r15) {
        int r5 = 0;
        Object r10 = this.d;
        Object r11 = this.f55c;
        Object r12 = this.e;
        Object r13 = this.f54b;
        switch(this.f53a) {
            case 0: goto L40;
            case 1: goto L38;
            case 2: goto L36;
            case 3: goto L34;
            default: goto L4;
        };
    L4:
        String r16 = (String) r15;
        int r14 = AppletRuntime.f2196x;
        Intrinsics.checkNotNullParameter(r16, "errorMsg");
        AppletRuntime r17 = (AppletRuntime) r13;
        r17.f2202m = "evaluate Mainjs error --> " + r16;
        Intrinsics.checkNotNullParameter(r16, "msg");
        Regex r18 = new Regex("Message:\\s(.*?)(?=,\\sStack:|$)");
        Regex r19 = new Regex("(?s)Stack:\\s(.*)");
        String r20 = null;
        MatchResult r21 = Regex.find$default(r18, r16, 0, 2, null);
        MatchResult r110 = Regex.find$default(r19, r16, 0, 2, null);
        if (r21 == null) goto L9;
        List<String> r22 = r21.getGroupValues();
        if (r22 == null) goto L9;
        String r23 = r22.get(1);
    L10:
        if (r110 == null) goto L14;
        List<String> r111 = r110.getGroupValues();
        if (r111 == null) goto L14;
        r20 = r111.get(1);
    L14:
        Pair r112 = new Pair(r23, r20);
        String r24 = (String) r112.component1();
        String r113 = (String) r112.component2();
        com.bytedance.ai.utils.c.n(r17.f2202m);
        AtomicBoolean r114 = z2.d.f23373a;
        AppletErrorCode r25 = AppletErrorCode.f2379c;
        if (r24 != null) goto L17;
        String r26 = "";
    L18:
        k r115 = new k(2, r17, (String) r12);
        Intrinsics.checkNotNullParameter(r25, "code");
        Intrinsics.checkNotNullParameter(r26, "msg");
        Intrinsics.checkNotNullParameter(r115, "build");
        z2.d.a(new z2.c(r25, r26, r113, r115, System.currentTimeMillis()));
        String r27 = (String) r11;
        if (r27 == null) goto L27;
        String r28 = (String) r10;
        if (r28 == null) goto L27;
        p r116 = h.f841a;
        if (r24 != null) goto L25;
        r24 = "";
    L25:
        h.a(201, r27, r24, r28);
    L27:
        if (s0.c.f21802b == false) goto L32;
        Activity r117 = s0.c.b();
        if (r117 == null) goto L32;
        AlertDialog.Builder r118 = new AlertDialog.Builder(r117);
        r118.setTitle("MainJS evaluate Error");
        r118.setMessage(r17.f2202m);
        r118.setPositiveButton("Retry", new com.bytedance.ai.model.c(r17, r5));
        r118.setNegativeButton("Cancel", new com.bytedance.ai.model.d(r5));
        r117.runOnUiThread(new com.bytedance.ai.model.e(r118, r5));
    L32:
        return Unit.INSTANCE;
    L17:
        r26 = r24;
    L9:
        r23 = null;
        goto L10
    L34:
        return ReplyLocalPluginMethod.b((o1.f) r13, (String) r11, (AbsReplyLocalPluginMethodIDL.ReplyLocalPluginParamModel) r10, (String) r12, (AppletRuntime) r15);
    L36:
        return CreateWidgetMethod.b((o1.f) r13, (AbsCreateWidgetMethodIDL.CreateWidgetParamModel) r11, (n1.c) r10, (CreateWidgetMethod) r12, (AppletRuntime) r15);
    L38:
        return CreateTextMethod.b((o1.f) r13, (AbsCreateTextMethodIDL.CreateTextParamModel) r11, (n1.c) r10, (CreateTextMethod) r12, (AppletRuntime) r15);
    L40:
        return GetAppInfoMethod.c((o1.f) r13, (IHostContextDepend) r11, (Context) r10, (GetAppInfoMethod) r12, (JsonObject) r15);
    }
}
