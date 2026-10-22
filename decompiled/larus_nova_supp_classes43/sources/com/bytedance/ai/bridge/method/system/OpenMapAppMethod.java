package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.IHostMapDepend;
import com.bytedance.ai.bridge.service.Location;
import com.bytedance.ai.bridge.service.NavigateMode;
import com.bytedance.ai.bridge.service.UserAction;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import f3.h;
import f4.g;
import f4.i;
import f4.j;
import f4.k;
import f4.l;
import f4.m;
import f4.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/OpenMapAppMethod;", "Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenMapAppMethod extends AbsOpenMapAppMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public OpenMapAppMethod() {
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [f4.n] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, final h r12) {
        AbsOpenMapAppMethodIDL.a r13 = (AbsOpenMapAppMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r13.getFrom() == null) goto L21;
        Location r14 = r13.getFrom();
        if (r14 == null) goto L7;
        String r15 = r14.getName();
    L8:
        if (r15 != null) goto L21;
        Location r16 = r13.getFrom();
        if (r16 == null) goto L12;
        Double r17 = r16.getLat();
    L13:
        if (r17 == null) goto L19;
        Location r18 = r13.getFrom();
        if (r18 == null) goto L17;
        Double r19 = r18.getLng();
    L18:
        if (r19 != null) goto L21;
    L17:
        r19 = null;
    L19:
        h.a.a(r12, "must choose either the location name or the lat and lng", null, null, 14);
        return;
    L12:
        r17 = null;
        goto L13
    L7:
        r15 = null;
    L21:
        if (r13.getTo().getLng() != null) goto L23;
    L93:
        h.a.a(r12, "The destination name and longitude and latitude must be transmitted", null, null, 14);
        return;
    L23:
        if (r13.getTo().getLat() == null) goto L93;
        String r110 = r13.getTo().getName();
        int r20 = 0;
        if (r110 != null) goto L27;
    L30:
        boolean r111 = true;
    L31:
        if (r111 == true) goto L93;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r112 = AppletRuntimeManager.d;
        if (r112 == null) goto L36;
        final Activity r21 = r112.currentActivity();
    L37:
        if (r21 != null) goto L39;
        h.a.a(r12, "can't find top activity", null, null, 14);
        return;
    L39:
        IHostMapDepend r22 = r4.a.d;
        if (r22 == null) goto L45;
        NavigateMode.a r113 = NavigateMode.Companion;
        String r0 = r13.getMethod();
        r113.getClass();
        NavigateMode r114 = (NavigateMode) NavigateMode.access$getModeMap$cp().get(r0);
        if (r114 != null) goto L44;
        r114 = NavigateMode.DRIVING;
    L44:
        r22.openMapApp(r21, r114, r13.getTo(), r13.getFrom(), new m(r12));
        return;
    L45:
        b r115 = b.a;
        NavigateMode.a r1 = NavigateMode.Companion;
        String r23 = r13.getMethod();
        r1.getClass();
        final NavigateMode r24 = (NavigateMode) NavigateMode.access$getModeMap$cp().get(r23);
        if (r24 != null) goto L48;
        r24 = NavigateMode.DRIVING;
    L48:
        final Location r25 = r13.getTo();
        final Location r116 = r13.getFrom();
        final ?? r26 = new n(r12);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r24, "mode");
        Intrinsics.checkNotNullParameter(r25, "dest");
        ArrayList r117 = (ArrayList) b.g;
        r117.clear();
        b.c = b.b(r21, "com.autonavi.minimap");
        b.d = b.b(r21, "com.tencent.map");
        b.e = b.b(r21, "com.baidu.BaiduMap");
        if (b.c == false) goto L52;
        r117.add(new Pair(UserAction.AUTONAVI, new i(r21, r25, r24, r116)));
    L52:
        if (b.d == false) goto L55;
        r117.add(new Pair(UserAction.TENCENT, new j(r21, r25, r24, r116)));
    L55:
        if (b.e == false) goto L58;
        r117.add(new Pair(UserAction.BAIDU, new k(r21, r25, r24, r116)));
    L58:
        if (r117.isEmpty() == false) goto L60;
        r117.add(new Pair(UserAction.INSTALL_AUTONAVI, new l(r21, r25, r24, r116)));
    L60:
        String[] r118 = new String[r117.size()];
        int r119 = r117.size();
    L61:
        if (r20 >= r119) goto L63;
        r118[r20] = ((UserAction) ((Pair) ListProtector.get(b.g, r20)).getFirst()).getHumanStr();
        r20 = r20 + 1;
        goto L61
    L63:
        List<Pair<UserAction, Function0<Unit>>> r120 = b.g;
        final ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        Iterator r122 = ((ArrayList) r120).iterator();
    L65:
        if (r122.hasNext() == false) goto L67;
        r121.add(((UserAction) ((Pair) r122.next()).getFirst()).getValue());
        goto L65
    L67:
        AlertDialog r123 = b.f;
        if (r123 == null) goto L86;
        Handler r27 = DialogLancet.resolveDialogHandler(r123);
        if (r27 != null) goto L72;
    L74:
        DialogLancet.beforeDialogDismiss(r123);
        r123.dismiss();     // Catch: Throwable -> L77 Exception -> L79
    L83:
        DialogLancet.afterDialogDismiss(r123);
        goto L86
    L79:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L77
        Throwable r28 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L77
        if (r28 == null) goto L83;
        com.bytedance.crash.d.d(r28, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r123);
        throw th;
    L72:
        if (Looper.myLooper() == r27.getLooper()) goto L74;
        r27.post(DialogLancet.createDismissRunnable(r123));
    L86:
        AlertDialog r124 = new AlertDialog.Builder(r21).setTitle(UserAction.SELECT_MAP.getHumanStr()).setItems(r118, new g(r26, r121)).setOnCancelListener(new f4.h(r26, r121)).create();
        b.f = r124;
        if (r124 != null) goto L89;
        return;
    L89:
        if (DialogLancet.shouldBlockDialogShow(r124) == false) goto L96;
        DialogLancet.handleBlockedDialogShow(r124);
        return;
    L96:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L95
    L92:
        DialogLancet.beforeDialogShow(r124);
        r124.show();
        DialogLancet.afterDialogShow(r124);
        return;
    L36:
        r21 = null;
        goto L37
    L27:
        if (r110.length() == 0) goto L30;
        r111 = false;
        goto L31
    }
}
