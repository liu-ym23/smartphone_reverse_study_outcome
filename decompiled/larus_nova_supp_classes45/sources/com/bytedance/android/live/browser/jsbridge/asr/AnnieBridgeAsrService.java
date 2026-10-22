package com.bytedance.android.live.browser.jsbridge.asr;

import a9.d;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.ILiveWrappedAudio;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreDataType;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICorePropertyId;
import com.bytedance.android.livesdk.user.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mf2.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Deprecated(message = "不支持 LLM 能力，请使用 AnnieBridgeAsrWithLLMService 代替")
public final class AnnieBridgeAsrService implements d {
    public mf2.a a;
    public final Lazy b;

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    static {
    }

    public final void H() {
        mf2.a r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.e() == 0) goto L7;
        r0.b();
        ALogger.d("AnnieBridgeAsrService", "stopping sami handle");
        LiveWrappedSAMICorePropertyId r2 = LiveWrappedSAMICorePropertyId.SAMICorePropertyID_Base_NAME;
        ALogger.d("AnnieBridgeAsrService", "force result: " + r0.c());
        ALogger.d("AnnieBridgeAsrService", "destroy result: " + r0.a());
        ALogger.d("AnnieBridgeAsrService", "stopped sami handle");
    L7:
        this.a = null;
    }

    public AnnieBridgeAsrService() {
        this.b = LazyKt.lazy(AnnieBridgeAsrService$gsonService$2.INSTANCE);
        new b();
    }

    public final void Y0(byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "pcmData");
        mf2.a r7 = this.a;
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.e() == 0) goto L22;
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r0 = ILiveWrappedAudio.a.a();
        if (r0 == null) goto L9;
        f r1 = r0.newSAMICoreBlock();
    L10:
        if (r1 == null) goto L12;
        LiveWrappedSAMICoreDataType r2 = LiveWrappedSAMICoreDataType.SAMICoreDataType_Float;
        r1.a();
    L12:
        if (r1 == null) goto L17;
        ILiveWrappedAudio r3 = ILiveWrappedAudio.a.a();
        if (r3 == null) goto L16;
        r3.newSAMICoreAudioBin();
    L16:
        r1.b();
    L17:
        if (r1 == null) goto L19;
        r1.c();
    L19:
        r7.f();
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final boolean t0(String r9, com.bytedance.android.annie.bridge.method.audio.a.c r11) {
        Intrinsics.checkNotNullParameter(r9, "appId");
        Intrinsics.checkNotNullParameter(r11, "callbackListener");
        H();
        String r12 = null;
        if (this.a != null) goto L9;
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r13 = ILiveWrappedAudio.a.a();
        if (r13 == null) goto L7;
        mf2.a r14 = r13.newSAMICore();
    L8:
        this.a = r14;
        goto L9
    L7:
        r14 = null;
    L9:
        mf2.a r15 = this.a;
        if (r15 == null) goto L87;
        boolean r3 = true;
        if (r15.e() != 0) goto L85;
        ALogger.d("AnnieBridgeAsrService", "start to create handle");
        r15.b();
        JSONObject r16 = new JSONObject();
        IHostWebView r1 = k.f(IHostWebView.class);
        if (r1 == null) goto L67;
        Map r2 = r1.getHeaderMap("https://" + k.n(IMiddlewareNetworkService.class).getHostDomain());
        if (r2 == null) goto L67;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r5 = r2.entrySet().iterator();
    L19:
        if (r5.hasNext() == false) goto L40;
        Map.Entry r6 = (Map.Entry) r5.next();
        CharSequence r7 = (CharSequence) r6.getKey();
        if (r7 != null) goto L23;
    L26:
        boolean r8 = true;
    L27:
        if (r8 == true) goto L37;
        CharSequence r17 = (CharSequence) r6.getValue();
        if (r17 != null) goto L31;
    L34:
        boolean r18 = true;
    L35:
        if (r18 == true) goto L37;
        boolean r19 = true;
    L38:
        if (r19 == false) goto L19;
        r4.put(r6.getKey(), r6.getValue());
        goto L19
    L31:
        if (r17.length() == 0) goto L34;
        r18 = false;
    L37:
        r19 = false;
        goto L38
    L23:
        if (r7.length() == 0) goto L26;
        r8 = false;
        goto L27
    L40:
        Iterator r21 = r4.keySet().iterator();
    L42:
        if (r21.hasNext() == false) goto L46;
        Object r22 = r21.next();
        if (StringsKt.equals((String) r22, "X-Tt-Token", true) == false) goto L42;
    L47:
        String r23 = (String) r22;
        String r24 = "";
        if (r23 == null) goto L53;
        String r25 = (String) r4.get(r23);
        if (r25 != null) goto L52;
        r25 = "";
    L52:
        r16.put("x-tt-token", r25);
    L53:
        Iterator r26 = r4.keySet().iterator();
    L55:
        if (r26.hasNext() == false) goto L59;
        Object r27 = r26.next();
        if (StringsKt.equals((String) r27, "sdk-version", true) == false) goto L55;
    L60:
        String r28 = (String) r27;
        if (r28 == null) goto L67;
        String r29 = (String) r4.get(r28);
        if (r29 == null) goto L66;
        r24 = r29;
    L66:
        r16.put("sdk-version", r24);
        goto L67
    L59:
        r27 = null;
        goto L60
    L46:
        r22 = null;
    L67:
        IMiddlewareUserService r31 = k.f(IMiddlewareUserService.class);
        if (r31 == null) goto L81;
        e r32 = r31.user();
        if (r32 == null) goto L81;
        String r33 = r32.getSessionKey();
        if (r33 == null) goto L81;
        if (r33.length() > 0) goto L77;
        r3 = false;
    L77:
        if (r3 == false) goto L79;
        r12 = r33;
    L79:
        if (r12 == null) goto L81;
        r16.put("cookie", "sessionid=".concat(r12));
    L81:
        r16.put("passport-auth", "session");
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r34 = ILiveWrappedAudio.a.a();
        if (r34 == null) goto L84;
        r34.newSAMICoreAsrContextCreateParameter();
    L84:
        return false;
    L85:
        ALogger.d("AnnieBridgeAsrService", "handle is existed");
        return true;
    L87:
        return false;
    }
}
