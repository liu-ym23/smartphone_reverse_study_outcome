package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.app.AlertDialog;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.Location;
import com.bytedance.ai.bridge.service.NavigateMode;
import com.bytedance.ai.bridge.service.UserAction;
import com.bytedance.ai.model.p;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import k2.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/OpenMapAppMethod;", "Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL;", "<init>", "()V", "", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OpenMapAppMethod extends AbsOpenMapAppMethodIDL {
    public OpenMapAppMethod() {
    }

    public static /* synthetic */ Unit b(f r5, AbsOpenMapAppMethodIDL.OpenMapAppResultModel r10) {
        return handle$lambda$1(r5, r10);
    }

    private static final Unit handle$lambda$0(f r5, AbsOpenMapAppMethodIDL.OpenMapAppResultModel r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        r5.b(r10, "");
        return Unit.INSTANCE;
    }

    private static final Unit handle$lambda$1(f r5, AbsOpenMapAppMethodIDL.OpenMapAppResultModel r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        r5.b(r10, "");
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsOpenMapAppMethodIDL.OpenMapAppParamModel) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(n1.c r12, AbsOpenMapAppMethodIDL.OpenMapAppParamModel r13, f r14) {
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r14, "callback");
        Activity r15 = null;
        if (r13.getFrom() == null) goto L22;
        Location r11 = r13.getFrom();
        if (r11 == null) goto L7;
        String r16 = r11.getName();
    L8:
        if (r16 != null) goto L22;
        Location r17 = r13.getFrom();
        if (r17 == null) goto L12;
        Double r18 = r17.getLat();
    L13:
        if (r18 == null) goto L19;
        Location r19 = r13.getFrom();
        if (r19 == null) goto L17;
        Double r110 = r19.getLng();
    L18:
        if (r110 != null) goto L22;
    L17:
        r110 = null;
    L19:
        r14.a("must choose either the location name or the lat and lng");
        return;
    L12:
        r18 = null;
        goto L13
    L7:
        r16 = null;
    L22:
        if (r13.getTo().getLng() != null) goto L24;
    L65:
        r14.a("The destination name and longitude and latitude must be transmitted");
        return;
    L24:
        if (r13.getTo().getLat() == null) goto L65;
        String r111 = r13.getTo().getName();
        if (r111 == null) goto L65;
        if (r111.length() == 0) goto L65;
        t0.b r112 = p.f2294c;
        if (r112 == null) goto L33;
        r15 = r112.currentActivity();
    L33:
        if (r15 != null) goto L36;
        r14.a("can't find top activity");
        return;
    L36:
        boolean r113 = c.f2009a;
        d r114 = NavigateMode.f2079b;
        String r5 = r13.getMethod();
        r114.getClass();
        NavigateMode r115 = (NavigateMode) NavigateMode.f2080c.get(r5);
        if (r115 != null) goto L39;
        r115 = NavigateMode.d;
    L39:
        final Location r10 = r13.getTo();
        final Location r116 = r13.getFrom();
        final com.obric.feature.miniapp.widget.jsb.a r20 = new com.obric.feature.miniapp.widget.jsb.a(r14, 5);
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r115, "mode");
        Intrinsics.checkNotNullParameter(r10, "dest");
        ArrayList r117 = c.e;
        r117.clear();
        c.f2009a = c.c(r15, "com.autonavi.minimap");
        c.f2010b = c.c(r15, "com.tencent.map");
        c.f2011c = c.c(r15, "com.baidu.BaiduMap");
        if (c.f2009a == false) goto L43;
        final int r21 = 0;
        final Activity r22 = r15;
        final NavigateMode r23 = r115;
        r117.add(new Pair(UserAction.f2082c, new e2.d(r22, r10, r23, r116, r21)));
    L43:
        if (c.f2010b == false) goto L46;
        final int r24 = 1;
        final Activity r25 = r15;
        final NavigateMode r26 = r115;
        r117.add(new Pair(UserAction.f, new e2.d(r25, r10, r26, r116, r24)));
    L46:
        if (c.f2011c == false) goto L49;
        final int r27 = 2;
        final Activity r28 = r15;
        final NavigateMode r29 = r115;
        r117.add(new Pair(UserAction.e, new e2.d(r28, r10, r29, r116, r27)));
    L49:
        if (r117.isEmpty() == false) goto L51;
        final int r30 = 3;
        final Activity r31 = r15;
        final NavigateMode r32 = r115;
        r117.add(new Pair(UserAction.d, new e2.d(r31, r10, r32, r116, r30)));
    L51:
        String[] r118 = new String[r117.size()];
        int r119 = r117.size();
        int r33 = 0;
    L52:
        if (r33 >= r119) goto L54;
        r118[r33] = ((UserAction) ((Pair) r117.get(r33)).getFirst()).f2084b;
        r33 = r33 + 1;
        goto L52
    L54:
        final ArrayList r120 = new ArrayList(CollectionsKt.h(r117));
        Iterator r121 = r117.iterator();
    L56:
        if (r121.hasNext() == false) goto L58;
        r120.add(((UserAction) ((Pair) r121.next()).getFirst()).f2083a);
        goto L56
    L58:
        AlertDialog r122 = c.d;
        if (r122 == null) goto L61;
        r122.dismiss();
    L61:
        AlertDialog.Builder r123 = new AlertDialog.Builder(r15);
        UserAction r124 = UserAction.f2082c;
        AlertDialog r125 = r123.setTitle("选择地图").setItems(r118, new e2.b(r20, r120)).setOnCancelListener(new e2.c(r20, r120)).create();
        c.d = r125;
        if (r125 == null) goto L69;
        r125.show();
        return;
    }
}
