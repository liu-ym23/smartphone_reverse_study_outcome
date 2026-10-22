package com.larus.xbridge.custom;

import android.content.Context;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.CommonDouYinLoginKV;
import com.larus.login.api.CommonDouYinLoginUtil;
import com.larus.login.api.DouYinBindStatus;
import com.larus.login.api.ILoginApi;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "app.douyinAuth")
public final class z0 extends XCoreBridgeMethod {

    @XBridgeMethodName(name = "app.douyinAuth", params = {"extra_info", "guide_type", "go_market", "request_server", "track_info", "alert_config"})
    public final String a;

    public static final class a {
    }

    public static final class b implements com.larus.login.api.b0 {
        public final /* synthetic */ z0 a;
        public final /* synthetic */ com.bytedance.ies.xbridge.XBridgeMethod.Callback b;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[DouYinBindStatus.values().length];
                r0[DouYinBindStatus.ALREADY_BOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[DouYinBindStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[DouYinBindStatus.GO_ACCOUNT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[DouYinBindStatus.FAILURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[DouYinBindStatus.CANCEL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[DouYinBindStatus.GO_MARKET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                a = r0;
            }
        }

        public b(z0 r1, com.bytedance.ies.xbridge.XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(DouYinBindStatus r3, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "status");
            switch(a.a[r3.ordinal()]) {
                case 1: goto L16;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L11;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            z0 r6 = this.a;
            Integer r7 = Integer.valueOf(r4);
            com.bytedance.ies.xbridge.XBridgeMethod.Callback r1 = this.b;
            r6.getClass();
            z0.e(r7, 3, r5, r1);
            return;
        L7:
            z0 r8 = this.a;
            Integer r9 = Integer.valueOf(r4);
            if (r5 != null) goto L10;
            r5 = "cancel_auth";
        L10:
            com.bytedance.ies.xbridge.XBridgeMethod.Callback r2 = this.b;
            r8.getClass();
            z0.e(r9, 2, r5, r2);
            return;
        L11:
            z0 r10 = this.a;
            Integer r11 = Integer.valueOf(r4);
            com.bytedance.ies.xbridge.XBridgeMethod.Callback r12 = this.b;
            r10.getClass();
            z0.e(r11, 1, r5, r12);
            return;
        L12:
            Lazy r13 = CommonDouYinLoginKV.a;
            CommonDouYinLoginKV.d();
            z0 r14 = this.a;
            Integer r15 = Integer.valueOf(r4);
            if (r5 != null) goto L15;
            r5 = "success";
        L15:
            com.bytedance.ies.xbridge.XBridgeMethod.Callback r16 = this.b;
            r14.getClass();
            z0.e(r15, 0, r5, r16);
            return;
        L16:
            z0 r17 = this.a;
            Integer r18 = Integer.valueOf(r4);
            if (r5 != null) goto L19;
            r5 = "success";
        L19:
            com.bytedance.ies.xbridge.XBridgeMethod.Callback r19 = this.b;
            r17.getClass();
            z0.e(r18, 0, r5, r19);
            return;
        L5:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public final boolean canRunInBackground() {
        return true;
    }

    public z0() {
        this.a = "app.douyinAuth";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r43, com.bytedance.ies.xbridge.XBridgeMethod.Callback r44, XBridgePlatformType r45) {
        Intrinsics.checkNotNullParameter(r43, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r44, "callback");
        Intrinsics.checkNotNullParameter(r45, "type");
        int r2 = r43.getInt("guide_type");
        if (r43.getInt("go_market") != 1) goto L5;
        boolean r11 = true;
    L7:
        if (r43.getInt("request_server") != 1) goto L9;
        boolean r12 = true;
    L10:
        XReadableMap r3 = r43.getMap("extra_info");
        if (r3 == null) goto L36;
        Map r4 = r3.toMap();
        if (r4 == null) goto L36;
        Bundle r6 = new Bundle();
        Iterator r5 = r4.entrySet().iterator();
    L16:
        if (r5.hasNext() == false) goto L35;
        Map.Entry r7 = (Map.Entry) r5.next();
        String r8 = (String) r7.getKey();
        Object r9 = r7.getValue();
        if ((r9 instanceof String) == true) goto L19;
        if ((r9 instanceof Integer) == true) goto L22;
        if ((r9 instanceof Boolean) == true) goto L25;
        if ((r9 instanceof Float) == true) goto L28;
        if ((r9 instanceof Double) == true) goto L31;
        if ((r9 instanceof Long) == false) goto L16;
        r6.putLong(r8, ((Number) r9).longValue());
        goto L16
    L31:
        r6.putDouble(r8, ((Number) r9).doubleValue());
        goto L16
    L28:
        r6.putFloat(r8, ((Number) r9).floatValue());
        goto L16
    L25:
        r6.putBoolean(r8, ((Boolean) r9).booleanValue());
        goto L16
    L22:
        r6.putInt(r8, ((Number) r9).intValue());
        goto L16
    L19:
        r6.putString(r8, (String) r9);
        goto L16
    L35:
        Bundle r15 = r6;
    L37:
        XReadableMap r10 = r43.getMap("track_info");
        if (r10 == null) goto L40;
        Map r13 = r10.toMap();
    L41:
        if (r13 == null) goto L44;
        Object r14 = r13.get("current_page");
        if (r14 == null) goto L44;
    L45:
        String r16 = r14.toString();
        if (r13 == null) goto L49;
        Object r17 = r13.get("source");
        if (r17 == null) goto L49;
    L50:
        String r18 = r17.toString();
        XReadableMap r0 = r43.getMap("alert_config");
        if (r0 == null) goto L53;
        Map r1 = r0.toMap();
    L54:
        Context r19 = AppHost.a.a().getCurrentActivity();
        if ((r19 instanceof FragmentActivity) == false) goto L57;
        Context r20 = (FragmentActivity) r19;
    L58:
        if (r20 != null) goto L61;
        e(-999, 1, "current activity is null", r44);
        return;
    L61:
        CommonDouYinLoginUtil r21 = CommonDouYinLoginUtil.a;
        b r110 = new b(this, r44);
        if (r1 == null) goto L66;
        Object r22 = r1.get("title");
        if (r22 == null) goto L66;
        String r23 = r22.toString();
    L67:
        if (r1 == null) goto L71;
        Object r111 = r1.get("message");
        if (r111 == null) goto L71;
        String r112 = r111.toString();
    L72:
        if (r1 == null) goto L76;
        Object r24 = r1.get("download_btn");
        if (r24 == null) goto L76;
        String r25 = r24.toString();
    L77:
        GuideType.Companion.getClass();
        GuideType[] r26 = GuideType.values();
        int r27 = r26.length;
        int r28 = 0;
    L78:
        if (r28 >= r27) goto L86;
        GuideType r113 = r26[r28];
        GuideType[] r46 = r26;
        if (r113.getValue() != r2) goto L82;
        boolean r29 = true;
    L83:
        if (r29 == true) goto L87;
        r28 = r28 + 1;
        r26 = r46;
    L87:
        if (r113 != null) goto L89;
        int r30 = -1;
    L91:
        if (r30 == 1) goto L107;
        if (r30 == 2) goto L95;
        com.larus.login.api.i r114 = null;
    L113:
        com.larus.login.api.k0 r31 = new com.larus.login.api.k0(r20, r16, r18, null, r11, r12, r110, null, r15, null, r114, 200, null, null, null, null, null, 127624);
        r21.getClass();
        CommonDouYinLoginUtil.s(r31);
        return;
    L95:
        String r210 = ContextCompat.getString(r20, 2131906099);
        String r211 = ContextCompat.getString(r20, 2131906098);
        ILoginApi r32 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
        if (r32 == null) goto L100;
        boolean r33 = true;
        if (r32.I(r20) != true) goto L100;
    L101:
        if (r33 == true) goto L104;
        if (r25 != null) goto L105;
        r25 = ContextCompat.getString(r20, 2131906094);
    L105:
        r114 = new com.larus.login.api.i(2131239970, null, r210, r211, r25, ContextCompat.getString(r20, 2131906096), false, null, null, false, 32706);
        goto L113
    L104:
        r25 = ContextCompat.getString(r20, 2131906095);
        Intrinsics.checkNotNull(r25);
    L100:
        r33 = false;
        goto L101
    L107:
        if (r23 != null) goto L109;
        r23 = ContextCompat.getString(r20, 2131909268);
    L109:
        String r34 = r23;
        if (r112 != null) goto L112;
        r112 = ContextCompat.getString(r20, 2131909263);
    L112:
        r114 = new com.larus.login.api.i(2131239970, null, r34, r112, ContextCompat.getString(r20, 2131909260), ContextCompat.getString(r20, 2131909259), false, null, null, false, 32706);
        goto L113
    L89:
        r30 = a1.a[r113.ordinal()];
        goto L91
    L82:
        r29 = false;
        goto L83
    L86:
        r113 = null;
    L76:
        r25 = null;
    L71:
        r112 = null;
    L66:
        r23 = null;
        goto L67
    L57:
        r20 = null;
        goto L58
    L53:
        r1 = null;
    L49:
        r17 = r15.getString("enter_from", "douyin_auth_xbridge");
    L44:
        r14 = "xbridge";
        goto L45
    L40:
        r13 = null;
    L36:
        r15 = new Bundle();
        goto L37
    L9:
        r12 = false;
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    public static void e(Integer r3, Integer r4, String r5, com.bytedance.ies.xbridge.XBridgeMethod.Callback r6) {
        Pair[] r0 = new Pair[3];
        if (r4 == null) goto L5;
        int r7 = r4.intValue();
    L6:
        r0[0] = TuplesKt.to("status", Integer.valueOf(r7));
        if (r3 == null) goto L9;
        int r8 = r3.intValue();
    L10:
        r0[1] = TuplesKt.to(LynxResourceModule.CODE_KEY, Integer.valueOf(r8));
        if (r5 != null) goto L13;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        r0[2] = TuplesKt.to("msg", r5);
        r6.invoke(MapsKt.mutableMapOf(r0));
        return;
    L9:
        r8 = -1;
        goto L10
    L5:
        r7 = 1;
        goto L6
    }
}
