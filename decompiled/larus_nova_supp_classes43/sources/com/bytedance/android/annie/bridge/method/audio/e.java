package com.bytedance.android.annie.bridge.method.audio;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.live.browser.jsbridge.base.StartSpeechRecognitionResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.ttnet.TTNetInit;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import w20.df;
import w20.t6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "startSpeechRecognition")
public final class e extends t6<df, StartSpeechRecognitionResultModel> implements a.InterfaceC0059a {
    public final JSBridgeManager a;

    public e(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        JSBridgeManager r11 = (JSBridgeManager) r10.c(JSBridgeManager.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    @Override // com.bytedance.android.annie.bridge.method.audio.a.InterfaceC0059a
    public final void d(boolean r10) {
        StartSpeechRecognitionResultModel r0 = new StartSpeechRecognitionResultModel();
        if (r10 == false) goto L5;
        r0.a(StartSpeechRecognitionResultModel.Code.Success);
    L6:
        finishWithResult(r0);
        return;
    L5:
        r0.a(StartSpeechRecognitionResultModel.Code.Failed);
        r0.b("ASR setup failed");
        goto L6
    }

    public e(JSBridgeManager r1) {
        this.a = r1;
    }

    public final void invoke(Object r17, CallContext r18) {
        df r1 = (df) r17;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r18, "context");
        StartSpeechRecognitionResultModel r10 = new StartSpeechRecognitionResultModel();
        Boolean r11 = r1.l();
        Boolean r12 = Boolean.TRUE;
        boolean r13 = false;
        int r14 = 1;
        a r15 = null;
        if (Intrinsics.areEqual(r11, r12) == true) goto L17;
        String r16 = r1.b();
        if (r16 != null) goto L7;
    L10:
        boolean r19 = true;
    L11:
        if (r19 == false) goto L13;
        boolean r20 = false;
    L14:
        if (r20 == true) goto L17;
        r10.a(StartSpeechRecognitionResultModel.Code.InvalidParameter);
        r10.b("invalid appKey");
        finishWithResult(r10);
        return;
    L13:
        b8.a r21 = b8.a.a;
        b8.a.a(new b8.b("StartSpeechRecognitionMethod", LogLevel.INFO, null, "StartSpeechRecognitionMethod: " + r1.b()), true);
        r20 = true;
        goto L14
    L7:
        if (r16.length() == 0) goto L10;
        r19 = false;
    L17:
        if (Intrinsics.areEqual(r1.l(), r12) == true) goto L37;
        if (r1.j() == null) goto L24;
        Integer r22 = r1.j();
        Intrinsics.checkNotNull(r22);
        if (r22.intValue() > 0) goto L24;
    L32:
        boolean r23 = false;
    L34:
        if (r23 == true) goto L37;
        r10.a(StartSpeechRecognitionResultModel.Code.InvalidParameter);
        finishWithResult(r10);
        return;
    L24:
        if (r1.e() == null) goto L29;
        Integer r24 = r1.e();
        Intrinsics.checkNotNull(r24);
        if (r24.intValue() <= 0) goto L32;
    L29:
        if (r1.k() == null) goto L33;
        Integer r25 = r1.k();
        Intrinsics.checkNotNull(r25);
        if (r25.intValue() <= 0) goto L32;
    L33:
        r23 = true;
    L37:
        if (com.bytedance.android.annie.bridge.method.permission.c.a(r18.getContext(), "android.permission.RECORD_AUDIO") == true) goto L40;
        r10.a(StartSpeechRecognitionResultModel.Code.UnauthorizedAccess);
        finishWithResult(r10);
        return;
    L40:
        if (TTNetInit.getEffectiveConnectionType() <= 1) goto L42;
        boolean r26 = true;
    L43:
        if (r26 == true) goto L46;
        r10.a(StartSpeechRecognitionResultModel.Code.NetworkUnreachable);
        r10.b("Network unreachable");
        finishWithResult(r10);
        return;
    L46:
        if (Intrinsics.areEqual(r1.l(), r12) == true) goto L92;
        WeakHashMap<View, a> r27 = a.k;
        JSBridgeManager r28 = this.a;
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r1, "params");
        View r110 = r18.d;
        if (r110 == null) goto L84;
        WeakHashMap<View, a> r111 = a.k;
        a r29 = r111.get(r110);
        if (r29 == null) goto L62;
        r29.a = r28;
        r29.b = this;
        r29.c = r18;
        r29.d = r1.b();
        Integer r0 = r1.k();
        if (r0 == null) goto L54;
        r0.intValue();
    L54:
        r29.getClass();
        Integer r30 = r1.e();
        if (r30 == null) goto L57;
        r30.intValue();
    L57:
        r29.getClass();
        Integer r31 = r1.j();
        if (r31 == null) goto L60;
        r31.intValue();
    L60:
        r29.getClass();
    L80:
        r15 = r111.get(r110);
        goto L84
    L62:
        monitor-enter(a.class);
    L81:
        th = move-exception;
        throw th;
    L64:
        if (r111.get(r110) != null) goto L78;
        String r32 = r1.b();     // Catch: Throwable -> L81
        Integer r33 = r1.k();     // Catch: Throwable -> L81
        if (r33 == null) goto L68;
        int r34 = r33.intValue();     // Catch: Throwable -> L81
    L69:
        Integer r35 = r1.e();     // Catch: Throwable -> L81
        if (r35 == null) goto L72;
        int r36 = r35.intValue();     // Catch: Throwable -> L81
    L73:
        Integer r37 = r1.j();     // Catch: Throwable -> L81
        if (r37 == null) goto L76;
        int r38 = r37.intValue();     // Catch: Throwable -> L81
    L77:
        r111.put(r110, new a(r28, this, r18, r32, r34, r36, r38));     // Catch: Throwable -> L81
        goto L78
    L76:
        r38 = 60000;
        goto L77
    L72:
        r36 = 1500;
        goto L73
    L68:
        r34 = 6000;
    L78:
        Unit r39 = Unit.INSTANCE;     // Catch: Throwable -> L81
        monitor-exit(a.class);
    L84:
        if (r15 != null) goto L86;
        return;
    L86:
        if (r15.f != null) goto L88;
        PthreadHandlerThreadV2 r40 = new PthreadHandlerThreadV2("Audio_Process");
        ThreadMethodProxy.start(r40);
        r15.g = new Handler(r40.getLooper(), r15);
        r15.f = r40;
        Unit r41 = Unit.INSTANCE;
    L88:
        Handler r42 = r15.g;
        if (r42 == null) goto L91;
        r42.sendMessage(r42.obtainMessage(103));
    L91:
        a.a("startAsrAudio");
        return;
    L92:
        Context r43 = r18.getContext().getApplicationContext();
        Intrinsics.checkNotNull(r43, "null cannot be cast to non-null type android.app.Application");
        Application r44 = (Application) r43;
        String r112 = r1.d();
        if (r112 != null) goto L95;
    L98:
        boolean r45 = true;
    L99:
        if (r45 == false) goto L101;
        String r46 = ";key domain can not be empty";
    L102:
        String r113 = r1.f();
        if (r113 != null) goto L105;
    L108:
        boolean r114 = true;
    L109:
        if (r114 == false) goto L111;
        r46 = r46.concat(";key path can not be empty");
    L111:
        String r115 = r1.a();
        if (r115 != null) goto L114;
    L117:
        boolean r116 = true;
    L118:
        if (r116 == false) goto L120;
        r46 = r46 + ";key appId can not be empty";
    L120:
        String r117 = r1.c();
        if (r117 != null) goto L123;
    L126:
        boolean r118 = true;
    L127:
        if (r118 == false) goto L129;
        r46 = r46 + ";key appToken can not be empty";
    L129:
        String r119 = r1.h();
        if (r119 != null) goto L132;
    L135:
        boolean r120 = true;
    L136:
        if (r120 == false) goto L139;
        r46 = r46 + ";key resourceId can not be empty";
    L139:
        if (r46.length() != 0) goto L141;
        r13 = true;
    L141:
        if (r13 == false) goto L143;
        Intrinsics.checkNotNull(r112);
        Intrinsics.checkNotNull(r113);
        Intrinsics.checkNotNull(r115);
        Intrinsics.checkNotNull(r117);
        Intrinsics.checkNotNull(r119);
        a9.a r47 = new a9.a(r112, r113, r115, r117, r119);
    L145:
        if (Intrinsics.areEqual(r1.i(), r12) == false) goto L149;
        if (r47 == null) goto L149;
        r44.getCacheDir().getAbsolutePath();
    L149:
        JsonObject r48 = r1.g();
        if (r48 != null) goto L152;
    L156:
        Pair r49 = new Pair(r47, r46);
        if (r49.getFirst() != null) goto L159;
        r10.a(StartSpeechRecognitionResultModel.Code.InvalidParameter);
        r10.b((String) r49.getSecond());
        finishWithResult(r10);
        return;
    L159:
        new Ref.ObjectRef().element = "";
        AsrState r50 = f7.c.a;
        Context r51 = r18.getContext().getApplicationContext();
        Intrinsics.checkNotNull(r51, "null cannot be cast to non-null type android.app.Application");
        Application r52 = (Application) r51;
        Object r53 = r49.getFirst();
        Intrinsics.checkNotNull(r53);
        a9.a r54 = (a9.a) r53;
        d r55 = new d();
        Intrinsics.checkNotNullParameter(r52, "application");
        Intrinsics.checkNotNullParameter(r54, "settings");
        Intrinsics.checkNotNullParameter(r55, "listener");
        if (f7.c.a != AsrState.NONE) goto L166;
        r14 = 2;
        a9.e r56 = (a9.e) Annie.getService$default(a9.e.class, null, 2, null);
        if (r56 == null) goto L166;
        r56.v(r52, r54, new f7.b(r55));
        r14 = 3;
    L166:
        if (r14 == 0) goto L168;
        r10.a(StartSpeechRecognitionResultModel.Code.Failed);
        r10.b("init or start failed with code " + r14);
        finishWithResult(r10);
        return;
    L168:
        r10.a(StartSpeechRecognitionResultModel.Code.Success);
        r10.b("success");
        finishWithResult(r10);
        return;
    L152:
        if (r48.size() <= 0) goto L156;
        if (r47 == null) goto L156;
        r48.toString();
        goto L156
    L143:
        r47 = null;
        goto L145
    L132:
        if (r119.length() == 0) goto L135;
        r120 = false;
        goto L136
    L123:
        if (r117.length() == 0) goto L126;
        r118 = false;
        goto L127
    L114:
        if (r115.length() == 0) goto L117;
        r116 = false;
        goto L118
    L105:
        if (r113.length() == 0) goto L108;
        r114 = false;
        goto L109
    L101:
        r46 = "";
        goto L102
    L95:
        if (r112.length() == 0) goto L98;
        r45 = false;
        goto L99
    L42:
        r26 = false;
        goto L43
    }
}
