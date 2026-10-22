package com.larus.dora.impl.bridge;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.doc.sdk.impl.BuildConfig;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.device.getCurrent")
public final class m extends XCoreIDLBridgeMethod<b, c> {
    public static final IntRange b = null;

    @XBridgeMethodName(name = "dora.device.getCurrent")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "deviceExtraInfo", required = BuildConfig.DEBUG)
        List<String> getDeviceExtraInfo();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "battery", required = BuildConfig.DEBUG)
        List<Number> getBattery();

        @XBridgeParamField(isGetter = true, keyPath = "btstate", required = BuildConfig.DEBUG)
        Number getBtstate();

        @XBridgeParamField(isGetter = true, keyPath = "charge", required = BuildConfig.DEBUG)
        List<Number> getCharge();

        @XBridgeParamField(isGetter = true, keyPath = "mac", required = BuildConfig.DEBUG)
        String getMac();

        @XBridgeParamField(isGetter = true, keyPath = "name", required = BuildConfig.DEBUG)
        String getName();

        @XBridgeParamField(isGetter = true, keyPath = "productId", required = BuildConfig.DEBUG)
        Number getProductId();

        @XBridgeParamField(isGetter = true, keyPath = "settings", required = BuildConfig.DEBUG)
        Object getSettings();

        @XBridgeParamField(isGetter = true, keyPath = "sku", required = BuildConfig.DEBUG)
        Number getSku();

        @XBridgeParamField(isGetter = true, keyPath = "sn", required = BuildConfig.DEBUG)
        String getSn();

        @XBridgeParamField(isGetter = true, keyPath = "state", required = BuildConfig.DEBUG)
        List<Number> getState();

        @XBridgeParamField(isGetter = true, keyPath = "supportAbilities", required = BuildConfig.DEBUG)
        List<String> getSupportAbilities();

        @XBridgeParamField(isGetter = true, keyPath = "vendorId", required = BuildConfig.DEBUG)
        Number getVendorId();

        @XBridgeParamField(isGetter = true, keyPath = "version", required = BuildConfig.DEBUG)
        String getVersion();

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "battery", required = BuildConfig.DEBUG)
        void setBattery(List<? extends Number> r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "btstate", required = BuildConfig.DEBUG)
        void setBtstate(Number r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "charge", required = BuildConfig.DEBUG)
        void setCharge(List<? extends Number> r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "mac", required = BuildConfig.DEBUG)
        void setMac(String r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "name", required = BuildConfig.DEBUG)
        void setName(String r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "productId", required = BuildConfig.DEBUG)
        void setProductId(Number r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "settings", required = BuildConfig.DEBUG)
        void setSettings(Object r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "sku", required = BuildConfig.DEBUG)
        void setSku(Number r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "sn", required = BuildConfig.DEBUG)
        void setSn(String r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "state", required = BuildConfig.DEBUG)
        void setState(List<? extends Number> r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "supportAbilities", required = BuildConfig.DEBUG)
        void setSupportAbilities(List<String> r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "vendorId", required = BuildConfig.DEBUG)
        void setVendorId(Number r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "version", required = BuildConfig.DEBUG)
        void setVersion(String r1);
    }

    static {
        b = new IntRange(0, 1);
    }

    public m() {
        this.a = "dora.device.getCurrent";
    }

    public final String getName() {
        return this.a;
    }

    public static boolean c(String r1) {
        if (Intrinsics.areEqual(r1, "AdaptationEnable") == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "CueToneVolume") == true) goto L10;
        if (Intrinsics.areEqual(r1, "GestureSettings") == true) goto L10;
        return false;
    }

    public static final List b(m r5, int[] r6) {
        r5.getClass();
        if (r6 == null) goto L13;
        int r0 = 0;
        if (r6.length != 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L13;
        ArrayList r8 = new ArrayList(r6.length);
        int r1 = r6.length;
    L11:
        if (r0 >= r1) goto L16;
        int r2 = r6[r0];
        Intrinsics.checkNotNull(Integer.valueOf(r2), "null cannot be cast to non-null type kotlin.Number");
        r8.add(Integer.valueOf(r2));
        r0 = r0 + 1;
        goto L11
    L16:
        return r8;
    L7:
        r7 = false;
    L13:
        return null;
    }

    public static Map e(n r3, Set r4) {
        LinkedHashMap r0 = new LinkedHashMap(2);
        if (r4.contains("AdaptationEnable") == false) goto L8;
        Boolean r1 = r3.a;
        if (r1 == null) goto L8;
        r0.put("isAdaptationEnable", Boolean.valueOf(r1.booleanValue()));
    L8:
        if (r4.contains("CueToneVolume") == false) goto L12;
        Integer r5 = r3.b;
        if (r5 == null) goto L12;
        r0.put("cueToneVolume", Integer.valueOf(r5.intValue()));
    L12:
        return r0;
    }

    public final void handle(IBDXBridgeContext r12, XBaseParamModel r13, CompletionBlock r14) {
        b r1 = (b) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        kj4.a r4 = kj4.a.g();
        Intrinsics.checkNotNull(r4);
        DoraDevice r3 = DoraAdapterExtKt.h(r4);
        if (r3 != null) goto L5;
        FLogger.a.w("DoraDeviceGetCurrentMethod", "dora.device.getCurrent current device is null");
        CompletionBlock.DefaultImpls.onFailure$default(r14, 0, "current dora device not found", null, 4, null);
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO())), null, null, new DoraDeviceGetCurrentMethod$handle$1(r1, this, r3, r4, r14, null), 3, null);
    }

    public static final Object a(m r22, kj4.a r23, String r24, Set r25, Continuation r26) {
        r22.getClass();
        String r4 = "dora.device.getCurrent cueToneVolume load returned null deviceKey=";
        String r5 = "dora.device.getCurrent cueToneVolume load ok deviceKey=";
        if ((r26 instanceof DoraDeviceGetCurrentMethod$loadDeviceSettings$1) == false) goto L7;
        DoraDeviceGetCurrentMethod$loadDeviceSettings$1 r6 = (DoraDeviceGetCurrentMethod$loadDeviceSettings$1) r26;
        int r7 = r6.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - Integer.MIN_VALUE;
    L8:
        Object r1 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r6.label;
        if (r9 == 0) goto L20;
        if (r9 == 1) goto L19;
        if (r9 != 2) goto L18;
        Set r10 = (Set) r6.L$6;
        Ref.BooleanRef r11 = (Ref.BooleanRef) r6.L$5;
        Ref.ObjectRef r12 = (Ref.ObjectRef) r6.L$4;
        Ref.ObjectRef r16 = (Ref.ObjectRef) r6.L$3;
        Set r17 = (Set) r6.L$2;
        String r18 = (String) r6.L$1;
        kj4.a r13 = (kj4.a) r6.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L15
        r4 = "dora.device.getCurrent cueToneVolume load returned null deviceKey=";
        final Ref.ObjectRef r14 = r16;
        Set r15 = r17;
        r5 = "dora.device.getCurrent cueToneVolume load ok deviceKey=";
        String r20 = r18;
    L145:
        int r0 = ((Number) r1).intValue();     // Catch: Throwable -> L76
        Integer r2 = Boxing.boxInt(r0);     // Catch: Throwable -> L76
        int r110 = r2.intValue();     // Catch: Throwable -> L76
        IntRange r21 = b;     // Catch: Throwable -> L76
        int r3 = r21.getFirst();     // Catch: Throwable -> L76
        kj4.a r27 = r13;
    L74:
        th = th;
    L78:
        r13 = r27;
    L82:
        Result.Companion r28 = Result.Companion;
        Object r30 = Result.constructor-impl(ResultKt.createFailure(th));
        Set r111 = r10;
        Ref.BooleanRef r31 = r11;
        String r32 = r20;
        final Ref.ObjectRef r33 = r12;
        kj4.a r34 = r13;
    L83:
        Throwable r35 = Result.exceptionOrNull-impl(r30);
        if (r35 == null) goto L90;
        FLogger.a.e("DoraDeviceGetCurrentMethod", "dora.device.getCurrent adaptationEnable load failed deviceKey=" + r32, r35);
    L90:
        if (r111.contains("CueToneVolume") == true) goto L92;
    L109:
        boolean r36 = true;
        if (r111.contains("CueToneVolume") == false) goto L113;
        FLogger.a.i("DoraDeviceGetCurrentMethod", "dora.device.getCurrent cueToneVolume use cache deviceKey=" + r32 + " value=" + r33.element);
    L113:
        if (r31.element == false) goto L116;
        DoraDeviceSettingsCache.a.update(r32, new l(r14, r33));
        FLogger.a.i("DoraDeviceGetCurrentMethod", "dora.device.getCurrent settings cache updated deviceKey=" + r32 + " requestedExtraInfo=" + r15);
    L116:
        if (r111.isEmpty() == false) goto L118;
        return null;
    L118:
        Object r37 = r14.element;
        Boolean r38 = (Boolean) r37;
        if (r111.contains("AdaptationEnable") == true) goto L122;
        r37 = null;
    L122:
        Boolean r40 = (Boolean) r37;
        Object r41 = r33.element;
        Integer r42 = (Integer) r41;
        if (r111.contains("CueToneVolume") == true) goto L126;
        r41 = null;
    L126:
        Integer r43 = (Integer) r41;
        n r44 = new n(r40, r43);
        if (r40 != null) goto L130;
        if (r43 != null) goto L130;
    L131:
        if (r36 == true) goto L133;
        n r45 = r44;
    L134:
        FLogger r46 = FLogger.a;
        StringBuilder r47 = new StringBuilder("dora.device.getCurrent settings result deviceKey=");
        r47.append(r32);
        r47.append(" value=");
        if (r45 == null) goto L137;
        Map r112 = e(r45, r15);
    L138:
        r47.append(r112);
        r46.i("DoraDeviceGetCurrentMethod", r47.toString());
        return r45;
    L137:
        r112 = null;
        goto L138
    L133:
        r45 = null;
    L130:
        r36 = false;
        goto L131
    L92:
        if (r33.element != null) goto L109;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L103
        Integer r50 = Boxing.boxInt(r34.z() & 255);     // Catch: Throwable -> L103
        r33.element = r50;     // Catch: Throwable -> L103
        if (r50 != null) goto L97;
        FLogger.a.w("DoraDeviceGetCurrentMethod", r4 + r32);     // Catch: Throwable -> L103
    L96:
        r36 = true;
        r31.element = true;     // Catch: Throwable -> L101
        Object r51 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L106:
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L113;
        FLogger.a.e("DoraDeviceGetCurrentMethod", "dora.device.getCurrent cueToneVolume load failed deviceKey=" + r32, r52);
    L101:
        th = th;
    L105:
        Result.Companion r53 = Result.Companion;
        r51 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L106
    L97:
        FLogger.a.i("DoraDeviceGetCurrentMethod", r5 + r32 + " value=" + r33.element);     // Catch: Throwable -> L103
    L103:
        th = th;
        r36 = true;
        goto L105
    L53:
        if (r110 > r21.getLast()) goto L56;
        if (r3 > r110) goto L56;
        boolean r54 = true;
    L58:
        if (Boxing.boxBoolean(r54).booleanValue() == false) goto L60;
        Integer r55 = r2;
    L61:
        if (r55 != null) goto L63;
        Boolean r56 = null;
    L68:
        r14.element = r56;     // Catch: Throwable -> L74
        if (r56 != null) goto L71;
        FLogger.a.w("DoraDeviceGetCurrentMethod", "dora.device.getCurrent adaptationEnable load ignored unexpected state=" + r0 + " deviceKey=" + r20);     // Catch: Throwable -> L74
    L72:
        r11.element = true;     // Catch: Throwable -> L74
        r30 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L74
        r111 = r10;
        r31 = r11;
        r32 = r20;
        r33 = r12;
        r34 = r27;
        goto L83
    L71:
        FLogger.a.i("DoraDeviceGetCurrentMethod", "dora.device.getCurrent adaptationEnable load ok deviceKey=" + r20 + " value=" + r14.element);     // Catch: Throwable -> L74
        goto L72
    L63:
        if (r55.intValue() != 1) goto L65;
        boolean r57 = true;
    L66:
        r56 = Boxing.boxBoolean(r57);     // Catch: Throwable -> L74
        goto L68
    L65:
        r57 = false;
        goto L66
    L60:
        r55 = null;
    L56:
        r54 = false;
    L76:
        th = th;
        r27 = r13;
    L15:
        th = th;
        r4 = "dora.device.getCurrent cueToneVolume load returned null deviceKey=";
        r14 = r16;
        r15 = r17;
        String r58 = r18;
        r5 = "dora.device.getCurrent cueToneVolume load ok deviceKey=";
    L81:
        r20 = r58;
        goto L82
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Set r60 = (Set) r6.L$2;
        r32 = (String) r6.L$1;
        r34 = (kj4.a) r6.L$0;
        ResultKt.throwOnFailure(r1);
        r15 = r60;
    L24:
        n r61 = (n) r1;
        if (r61 == null) goto L34;
        FLogger r62 = FLogger.a;
        StringBuilder r113 = new StringBuilder("dora.device.getCurrent settings cache hit deviceKey=");
        r113.append(r32);
        r113.append(" cachedKeys=");
        ArrayList r63 = new ArrayList();
        if (r61.a == null) goto L30;
        r63.add("AdaptationEnable");
    L30:
        if (r61.b == null) goto L32;
        r63.add("CueToneVolume");
    L32:
        r113.append(r63);
        r62.i("DoraDeviceGetCurrentMethod", r113.toString());
    L34:
        r14 = new Ref.ObjectRef();
        if (r61 == null) goto L37;
        Boolean r64 = r61.a;
    L38:
        r14.element = r64;
        r33 = new Ref.ObjectRef();
        if (r61 == null) goto L41;
        Integer r65 = r61.b;
    L42:
        r33.element = r65;
        r31 = new Ref.BooleanRef();
        r111 = SetsKt.minus(r15, "GestureSettings");
        if (r111.contains("AdaptationEnable") == false) goto L87;
        if (r14.element != null) goto L87;
        Result.Companion r66 = Result.Companion;     // Catch: Throwable -> L79
        r6.L$0 = r34;     // Catch: Throwable -> L79
        r6.L$1 = r32;     // Catch: Throwable -> L79
        r6.L$2 = r15;     // Catch: Throwable -> L79
        r6.L$3 = r14;     // Catch: Throwable -> L79
        r6.L$4 = r33;     // Catch: Throwable -> L79
        r6.L$5 = r31;     // Catch: Throwable -> L79
        r6.L$6 = r111;     // Catch: Throwable -> L79
        r6.label = 2;     // Catch: Throwable -> L79
        Object r67 = DoraAdapterExtKt.l(r34);     // Catch: Throwable -> L79
        if (r67 == r8) goto L153;
        r13 = r34;
        r10 = r111;
        r12 = r33;
        r20 = r32;
        r11 = r31;
        r1 = r67;
        goto L145
    L153:
        return r8;
    L79:
        th = th;
        r13 = r34;
        r10 = r111;
        r12 = r33;
        String r210 = r32;
        r11 = r31;
        r58 = r210;
    L87:
        if (r111.contains("AdaptationEnable") == false) goto L90;
        FLogger.a.i("DoraDeviceGetCurrentMethod", "dora.device.getCurrent adaptationEnable use cache deviceKey=" + r32 + " value=" + r14.element);
        goto L90
    L41:
        r65 = null;
        goto L42
    L37:
        r64 = null;
        goto L38
    L20:
        ResultKt.throwOnFailure(r1);
        DoraDeviceSettingsCache r68 = DoraDeviceSettingsCache.a;
        DoraDeviceGetCurrentMethod$loadDeviceSettings$cachedSnapshot$1 r70 = new DoraDeviceGetCurrentMethod$loadDeviceSettings$cachedSnapshot$1(null);
        r34 = r23;
        r6.L$0 = r34;
        r6.L$1 = r24;
        r15 = r25;
        r6.L$2 = r15;
        r6.label = 1;
        r1 = r68.a(r24, r70, r6);
        if (r1 == r8) goto L152;
        r32 = r24;
        goto L24
    L152:
        return r8;
    L7:
        r6 = new DoraDeviceGetCurrentMethod$loadDeviceSettings$1(r22, r26);
        goto L8
    }
}
