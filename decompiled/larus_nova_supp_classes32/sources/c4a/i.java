package c4a;

import android.text.TextUtils;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.y0;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.utils.s;
import com.lynx.devtool.helper.ScreenCapturer;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static final Lazy a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AudioSessionType.values().length];
            r0[AudioSessionType.QUIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AudioSessionType.MMT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AudioSessionType.RTC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = LazyKt.lazy(new h());
    }

    public static ISettingRepoService a() {
        return (ISettingRepoService) a.getValue();
    }

    public static void b(RealtimeCallParam.h r7, e3a.a r8, AudioSessionType r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "argumentData");
        Intrinsics.checkNotNullParameter(r9, "avSessionType");
        z2 r0 = z2.a;
        String r1 = r0.p1().getRealtimeCallAppKey();
        if (r1 != null) goto L5;
        r1 = "mcRPQyXTQo";
    L5:
        Integer r2 = r0.p1().getSamiBusinessId();
        if (r2 == null) goto L8;
        r7.n = r2.intValue();
    L8:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r7.b = r1;
        if (y0.d(r9) == false) goto L11;
    L14:
        String r3 = AudioServiceDelegate.a.M(r1);
    L15:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r7.a = r3;
        x58.a r4 = m58.h.a;
        boolean r10 = y0.e(r9);
        JSONObject r5 = new JSONObject();
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L19;
        String r11 = r6.F0();
        if (r11 == null) goto L19;
    L21:
        if (TextUtils.isEmpty(r11) == true) goto L23;
        r5.put("feature_key", r11);
    L23:
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("CommonConfig.reset isMinorMode=");
        AccountService r14 = AccountService.a;
        r13.append(r14.a());
        r12.i("RealtimeParamCreator", r13.toString());
        if (r14.a() == false) goto L26;
        r5.put("minor-mode", "1");
    L26:
        Unit r15 = Unit.INSTANCE;
        String r16 = m58.h.b(r10, r5, 2);
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r7.d = r16;
        String r17 = r14.getUserId();
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r7.f = r17;
        String r18 = o.a.getDeviceId();
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r7.g = r18;
        AppHost.Companion r19 = AppHost.a;
        String r20 = r19.getVersionName();
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r7.h = r20;
        r7.i = r19.getVersionCode();
        r7.j = r19.getUpdateVersionCode();
        int r21 = 1;
        if (HttpExtKt.e().c == false) goto L29;
    L32:
        boolean r22 = true;
    L33:
        r7.A = r22;
        int r23 = r0.realtimeMaxAliveDuration();
        if (s.a() == false) goto L36;
        r12.i("TouristCallLimit", "reset tourist realtime call duration, reason: login degrade");
        r23 = 180;
    L36:
        r7.k = r23;
        lq9.e r24 = r0.V2().getData();
        if (r24 == null) goto L39;
        boolean r25 = r24.a();
    L40:
        lq9.e r26 = r0.V2().getData();
        if (r26 == null) goto L43;
        int r27 = r26.c();
    L44:
        lq9.e r28 = r0.V2().getData();
        if (r28 == null) goto L48;
        int[] r29 = r28.b();
        if (r29 == null) goto L48;
    L49:
        RealtimeCallParam.f r30 = new RealtimeCallParam.f(new RealtimeCallParam.e(r25, r27, r29));
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r7.l = r30;
        if (c78.a.a().length() > 0) goto L53;
        r21 = 0;
    L53:
        r7.m = r21;
        String r31 = ((h88.a) r8).y;
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        r7.q = r31;
        String r32 = ((h88.a) r8).z;
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        r7.r = r32;
        r7.n = ObricAsrDelegate.b.n();
        return;
    L48:
        r29 = new int[]{300, 600, 900, 1200, ScreenCapturer.SCREEN_SHOT_PREVIEW_DELAY_TIME};
        goto L49
    L43:
        r27 = 0;
        goto L44
    L39:
        r25 = true;
        goto L40
    L29:
        if (HttpExtKt.e().a == true) goto L32;
        r22 = false;
    L19:
        r11 = NameKeys.UnloadStrategy_No_Strategy;
        goto L21
    L11:
        if (y0.b(r9) == true) goto L14;
        r3 = AudioServiceDelegate.a.d(r1);
        goto L15
    }
}
