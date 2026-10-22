package com.bytedance.android.ec.core.address;

import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.address.api.AddressApi;
import com.bytedance.android.ec.core.address.api.AddressItemVO;
import com.bytedance.android.ec.core.address.api.IAddressApi;
import com.bytedance.android.ec.core.address.api.RecommendAddressConfig;
import com.bytedance.android.ec.core.address.api.ReportAddressResponse;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AddressSDK {
    public static final w a = null;
    public static final com.bytedance.android.ec.core.address.a b = null;
    public static final u c = null;
    public static final boolean d = false;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static Boolean g;
    public static volatile Boolean h;
    public static Boolean i;
    public static final AddressSDK j = null;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r10) {
            ReportAddressResponse r11 = (ReportAddressResponse) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            AddressItemVO r0 = r11.getAddress();
            if (r0 == null) goto L5;
            r0.parseAddress();
        L5:
            return r11;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ String b;

        public b(Function2 r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void accept(Object r10) {
            ReportAddressResponse r11 = (ReportAddressResponse) r10;
            if (r11 != null) goto L5;
        L14:
            int r1 = s.a;
            String r12 = this.b;
            if (r11 == null) goto L17;
            Integer r13 = Integer.valueOf(r11.getStatusCode());
        L18:
            if (r11 == null) goto L20;
            String r14 = r11.getLogId();
        L21:
            s.d(r13, r12, r14);
            Function2 r15 = this.a;
            if (r15 == null) goto L28;
            StringBuilder r16 = new StringBuilder("返回地址为空，status_code=");
            if (r11 == null) goto L26;
            Integer r17 = Integer.valueOf(r11.getStatusCode());
        L27:
            r16.append(r17);
            Unit r18 = (Unit) r15.invoke(null, r16.toString());
            goto L28
        L26:
            r17 = null;
        L28:
            w r19 = AddressSDK.a;
            StringBuilder r20 = new StringBuilder("report address fail，status_code=");
            if (r11 == null) goto L31;
            Integer r21 = Integer.valueOf(r11.getStatusCode());
        L32:
            r20.append(r21);
            AddressSDK.g(r20.toString(), null, 6);
            return;
        L31:
            r21 = null;
            goto L32
        L20:
            r14 = null;
            goto L21
        L17:
            r13 = null;
            goto L18
        L5:
            if (r11.isValid() != true) goto L14;
            w r22 = AddressSDK.a;
            AddressSDKLog.a("report address success", false);
            AddressItemVO r23 = r11.getAddress();
            if (r23 == null) goto L11;
            RecommendAddressConfig r24 = r23.getConfig();
            if (r24 == null) goto L11;
            r24.adjustInvalidTime(r11.getServerTime());
        L11:
            Function2 r25 = this.a;
            if (r25 == null) goto L34;
            Unit r26 = (Unit) r25.invoke(r11.getAddress(), null);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function2 b;

        public c(String r1, Function2 r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            int r0 = s.a;
            s.d(null, this.a, null);
            AddressSDK.g("report address error", r11, 4);
            Function2 r1 = this.b;
            if (r1 == null) goto L10;
            StringBuilder r12 = new StringBuilder("请求失败：");
            if (r11 == null) goto L7;
            String r13 = r11.getMessage();
        L8:
            r12.append(r13);
            Unit r14 = (Unit) r1.invoke(null, r12.toString());
            return;
        L7:
            r13 = null;
            goto L8
        }
    }

    public AddressSDK() {
    }

    public static boolean q() {
        return ((Boolean) f.getValue()).booleanValue();
    }

    static {
        j = new AddressSDK();
        a = new w();
        b = new com.bytedance.android.ec.core.address.a();
        c = new u();
        Lazy r0 = ECAppInfoService.a;
        boolean r1 = false;
        Object r10 = 0;
        Object r11 = null;
        if (ECAppInfoService.h() == false) goto L179;
        int r12 = com.bytedance.android.ec.core.opt.ab.c.a;
        int r13 = com.bytedance.android.ec.core.opt.ab.m.a;
        boolean r14 = ECServiceManager.a;
        s83.g r15 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r15 == null) goto L10;
        s83.a r16 = r15.q();
        if (r16 == null) goto L10;
        Object r17 = r16.e("iesec_address_sdk_ab");
        if (r17 == null) goto L10;
    L177:
        if (((Number) r17).intValue() == 1) goto L351;
    L352:
        d = r1;
        e = LazyKt.lazy(AddressSDK$optRequestType$2.INSTANCE);
        f = LazyKt.lazy(AddressSDK$isEnableOptRequest$2.INSTANCE);
        i = Boolean.FALSE;
        return;
    L351:
        r1 = true;
    L10:
        int r18 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r19 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L167
        Object r21 = com.bytedance.android.ec.base.settings.d.c.get("iesec_address_sdk_ab");     // Catch: Throwable -> L61
        if (r21 != null) goto L16;
    L58:
        Object r22 = null;
    L59:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L61
    L63:
        Throwable r24 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L167
        if (r24 == null) goto L67;
        EnsureManager.ensureNotReachHere(r24);     // Catch: Throwable -> L167
    L67:
        if (Result.isFailure-impl(r23) == false) goto L70;
        r23 = null;
    L70:
        if ((r23 instanceof Integer) == true) goto L72;
        r23 = null;
    L72:
        r17 = (Integer) r23;     // Catch: Throwable -> L167
        if (r17 != null) goto L79;
        Object r25 = com.bytedance.android.ec.base.settings.d.a.get("iesec_address_sdk_ab");     // Catch: Throwable -> L167
        if ((r25 instanceof Integer) == true) goto L78;
        r25 = null;
    L78:
        r17 = (Integer) r25;     // Catch: Throwable -> L167
    L79:
        if (r17 != null) goto L177;
        int r26 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L167
        Object r27 = com.bytedance.android.ec.base.settings.d.c.get("iesec_address_sdk_ab");     // Catch: Throwable -> L131
        if (r27 != null) goto L86;
    L128:
        Object r28 = null;
    L129:
        Object r29 = Result.constructor-impl(r28);     // Catch: Throwable -> L131
    L133:
        Throwable r30 = Result.exceptionOrNull-impl(r29);     // Catch: Throwable -> L158
        if (r30 == null) goto L137;
        EnsureManager.ensureNotReachHere(r30);     // Catch: Throwable -> L158
    L137:
        if (Result.isFailure-impl(r29) == false) goto L140;
        r29 = null;
    L140:
        if ((r29 instanceof Integer) == true) goto L142;
        r29 = null;
    L142:
        r17 = (Integer) r29;     // Catch: Throwable -> L158
        if (r17 != null) goto L165;
        IHybridHostService r31 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L158
        if (r31 == null) goto L148;
        Object r32 = r31.getHostABValue("iesec_address_sdk_ab", r10);     // Catch: Throwable -> L158
    L149:
        if (r32 != null) goto L151;
    L164:
        r17 = r10;
        goto L165
    L151:
        if ((r32 instanceof Integer) == false) goto L154;
        r11 = r32;
    L154:
        Integer r33 = (Integer) r11;     // Catch: Throwable -> L158
        if (r33 == null) goto L164;
        r17 = r33;
        goto L165
    L158:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L167
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r35 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L167
        if (r35 == null) goto L163;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L167
    L163:
        if (Result.isFailure-impl(r17) == false) goto L165;
    L148:
        r32 = null;
    L165:
        com.bytedance.android.ec.base.settings.d.d("iesec_address_sdk_ab", r17);     // Catch: Throwable -> L167
        goto L177
    L86:
        if ((r27 instanceof Integer) == true) goto L88;
        Object r36 = null;
    L89:
        r28 = (Integer) r36;     // Catch: Throwable -> L131
        if (r28 != null) goto L129;
        if ((r27 instanceof Number) == false) goto L116;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L101;
        Float r37 = Float.valueOf(((Number) r27).floatValue());     // Catch: Throwable -> L131
        if ((r37 instanceof Integer) == true) goto L99;
        r37 = null;
    L99:
        r28 = (Integer) r37;     // Catch: Throwable -> L131
        goto L129
    L101:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L107;
        Double r38 = Double.valueOf(((Number) r27).doubleValue());     // Catch: Throwable -> L131
        if ((r38 instanceof Integer) == true) goto L105;
        r38 = null;
    L105:
        r28 = (Integer) r38;     // Catch: Throwable -> L131
        goto L129
    L107:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L110;
        r28 = Integer.valueOf(((Number) r27).intValue());     // Catch: Throwable -> L131
        goto L129
    L110:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L116;
        Long r39 = Long.valueOf(((Number) r27).longValue());     // Catch: Throwable -> L131
        if ((r39 instanceof Integer) == true) goto L114;
        r39 = null;
    L114:
        r28 = (Integer) r39;     // Catch: Throwable -> L131
    L116:
        if ((r27 instanceof JSONObject) == false) goto L118;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L124
        Object r40 = SDKSettingsCacheManager.a().fromJson(r27.toString(), Integer.class);     // Catch: Throwable -> L124
        if ((r40 instanceof Integer) == true) goto L122;
        r40 = null;
    L122:
        Object r41 = Result.constructor-impl((Integer) r40);     // Catch: Throwable -> L124
    L126:
        r28 = r41;
        if (Result.isFailure-impl(r28) == false) goto L129;
    L124:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L131
        r41 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L131
        goto L126
    L118:
        if ((r27 instanceof JSONArray) == false) goto L128;
    L88:
        r36 = r27;
    L131:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L158
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
        goto L133
    L16:
        if ((r21 instanceof Integer) == true) goto L18;
        Object r44 = null;
    L19:
        r22 = (Integer) r44;     // Catch: Throwable -> L61
        if (r22 != null) goto L59;
        if ((r21 instanceof Number) == false) goto L46;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L31;
        Float r45 = Float.valueOf(((Number) r21).floatValue());     // Catch: Throwable -> L61
        if ((r45 instanceof Integer) == true) goto L29;
        r45 = null;
    L29:
        r22 = (Integer) r45;     // Catch: Throwable -> L61
        goto L59
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L37;
        Double r46 = Double.valueOf(((Number) r21).doubleValue());     // Catch: Throwable -> L61
        if ((r46 instanceof Integer) == true) goto L35;
        r46 = null;
    L35:
        r22 = (Integer) r46;     // Catch: Throwable -> L61
        goto L59
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L40;
        r22 = Integer.valueOf(((Number) r21).intValue());     // Catch: Throwable -> L61
        goto L59
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L46;
        Long r47 = Long.valueOf(((Number) r21).longValue());     // Catch: Throwable -> L61
        if ((r47 instanceof Integer) == true) goto L44;
        r47 = null;
    L44:
        r22 = (Integer) r47;     // Catch: Throwable -> L61
    L46:
        if ((r21 instanceof JSONObject) == false) goto L48;
    L376:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L54
        Object r48 = SDKSettingsCacheManager.a().fromJson(r21.toString(), Integer.class);     // Catch: Throwable -> L54
        if ((r48 instanceof Integer) == true) goto L52;
        r48 = null;
    L52:
        Object r49 = Result.constructor-impl((Integer) r48);     // Catch: Throwable -> L54
    L56:
        r22 = r49;
        if (Result.isFailure-impl(r22) == false) goto L59;
    L54:
        th = move-exception;
        Result.Companion r50 = Result.Companion;     // Catch: Throwable -> L61
        r49 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L61
        goto L56
    L48:
        if ((r21 instanceof JSONArray) == false) goto L58;
    L18:
        r44 = r21;
    L61:
        th = move-exception;
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L167
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        Object r53 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r54 = Result.exceptionOrNull-impl(r53);
        if (r54 == null) goto L172;
        EnsureManager.ensureNotReachHere(r54);
    L172:
        if (Result.isFailure-impl(r53) == true) goto L175;
        r10 = r53;
    L175:
        r17 = r10;
        goto L177
    L179:
        com.bytedance.android.ec.core.abtest.d r55 = com.bytedance.android.ec.core.abtest.d.a;
        int r56 = com.bytedance.android.ec.core.abtest.j.a;
        int r57 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r58 = Result.Companion;     // Catch: Throwable -> L340
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L340
        SDKSettingsCacheManager r59 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L340
        r59.getClass();     // Catch: Throwable -> L230
        Object r60 = SDKSettingsCacheManager.b.get("iesec_address_sdk_ab");     // Catch: Throwable -> L230
        if (r60 != null) goto L185;
    L227:
        Object r61 = null;
    L228:
        Object r62 = Result.constructor-impl(r61);     // Catch: Throwable -> L230
    L232:
        Throwable r63 = Result.exceptionOrNull-impl(r62);     // Catch: Throwable -> L340
        if (r63 == null) goto L236;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L340
    L236:
        if (Result.isFailure-impl(r62) == false) goto L239;
        r62 = null;
    L239:
        if ((r62 instanceof Integer) == true) goto L241;
        r62 = null;
    L241:
        Object r64 = (Integer) r62;     // Catch: Throwable -> L340
        if (r64 != null) goto L248;
        r59.getClass();     // Catch: Throwable -> L340
        Object r65 = SDKSettingsCacheManager.a.get("iesec_address_sdk_ab");     // Catch: Throwable -> L340
        if ((r65 instanceof Integer) == true) goto L247;
        r65 = null;
    L247:
        r64 = (Integer) r65;     // Catch: Throwable -> L340
    L248:
        if (r64 != null) goto L350;
        int r66 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L340
    L327:
        th = move-exception;
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L340
        Object r68 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L340
    L330:
        if (Result.exceptionOrNull-impl(r68) != null) goto L372;
    L337:
        r64 = r68;
    L338:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L340
        SDKSettingsCacheManager.e("iesec_address_sdk_ab", r64);     // Catch: Throwable -> L340
        goto L350
    L372:
        r68 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_address_sdk_ab", Integer.class, r10);     // Catch: Throwable -> L334
    L335:
        if (r68 != null) goto L337;
        r64 = r10;
    L334:
        r68 = r10;
        goto L335
    L358:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L301
        Object r69 = SDKSettingsCacheManager.b.get("iesec_address_sdk_ab");     // Catch: Throwable -> L301
        if (r69 != null) goto L256;
    L298:
        Object r70 = null;
    L299:
        Object r71 = Result.constructor-impl(r70);     // Catch: Throwable -> L301
    L303:
        Throwable r72 = Result.exceptionOrNull-impl(r71);     // Catch: Throwable -> L327
        if (r72 == null) goto L307;
        EnsureManager.ensureNotReachHere(r72);     // Catch: Throwable -> L327
    L307:
        if (Result.isFailure-impl(r71) == false) goto L310;
        r71 = null;
    L310:
        if ((r71 instanceof Integer) == true) goto L312;
        r71 = null;
    L312:
        r68 = (Integer) r71;     // Catch: Throwable -> L327
        if (r68 != null) goto L337;
        jj4.b r73 = jj4.b.b;     // Catch: Throwable -> L327
        Object r74 = jj4.a.a("iesec_address_sdk_ab", Integer.class, r10, false);     // Catch: Throwable -> L327
        if (r74 != null) goto L319;
        Intrinsics.throwNpe();     // Catch: Throwable -> L327
    L319:
        if ((r74 instanceof Integer) == false) goto L322;
        r11 = r74;
    L322:
        Object r75 = (Integer) r11;     // Catch: Throwable -> L327
        if (r75 != null) goto L325;
        r75 = r10;
    L325:
        r68 = Result.constructor-impl(r75);     // Catch: Throwable -> L327
    L256:
        if ((r69 instanceof Integer) == true) goto L258;
        Object r76 = null;
    L259:
        r70 = (Integer) r76;     // Catch: Throwable -> L301
        if (r70 != null) goto L299;
        if ((r69 instanceof Number) == false) goto L286;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L271;
        Float r77 = Float.valueOf(((Number) r69).floatValue());     // Catch: Throwable -> L301
        if ((r77 instanceof Integer) == true) goto L269;
        r77 = null;
    L269:
        r70 = (Integer) r77;     // Catch: Throwable -> L301
        goto L299
    L271:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L277;
        Double r78 = Double.valueOf(((Number) r69).doubleValue());     // Catch: Throwable -> L301
        if ((r78 instanceof Integer) == true) goto L275;
        r78 = null;
    L275:
        r70 = (Integer) r78;     // Catch: Throwable -> L301
        goto L299
    L277:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L280;
        r70 = Integer.valueOf(((Number) r69).intValue());     // Catch: Throwable -> L301
        goto L299
    L280:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L286;
        Long r79 = Long.valueOf(((Number) r69).longValue());     // Catch: Throwable -> L301
        if ((r79 instanceof Integer) == true) goto L284;
        r79 = null;
    L284:
        r70 = (Integer) r79;     // Catch: Throwable -> L301
    L286:
        if ((r69 instanceof JSONObject) == false) goto L288;
    L374:
        Object r80 = SDKSettingsCacheManager.a().fromJson(r69.toString(), Integer.class);     // Catch: Throwable -> L294
        if ((r80 instanceof Integer) == true) goto L292;
        r80 = null;
    L292:
        Object r81 = Result.constructor-impl((Integer) r80);     // Catch: Throwable -> L294
    L296:
        r70 = r81;
        if (Result.isFailure-impl(r70) == false) goto L299;
    L294:
        th = move-exception;
        Result.Companion r82 = Result.Companion;     // Catch: Throwable -> L301
        r81 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L301
        goto L296
    L288:
        if ((r69 instanceof JSONArray) == false) goto L298;
    L258:
        r76 = r69;
    L301:
        th = move-exception;
        Result.Companion r83 = Result.Companion;     // Catch: Throwable -> L327
        r71 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L327
    L350:
        if (((Number) r64).intValue() != 1) goto L352;
    L185:
        if ((r60 instanceof Integer) == true) goto L187;
        Object r84 = null;
    L188:
        r61 = (Integer) r84;     // Catch: Throwable -> L230
        if (r61 != null) goto L228;
        if ((r60 instanceof Number) == false) goto L215;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L200;
        Float r85 = Float.valueOf(((Number) r60).floatValue());     // Catch: Throwable -> L230
        if ((r85 instanceof Integer) == true) goto L198;
        r85 = null;
    L198:
        r61 = (Integer) r85;     // Catch: Throwable -> L230
        goto L228
    L200:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L206;
        Double r86 = Double.valueOf(((Number) r60).doubleValue());     // Catch: Throwable -> L230
        if ((r86 instanceof Integer) == true) goto L204;
        r86 = null;
    L204:
        r61 = (Integer) r86;     // Catch: Throwable -> L230
        goto L228
    L206:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L209;
        r61 = Integer.valueOf(((Number) r60).intValue());     // Catch: Throwable -> L230
        goto L228
    L209:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L215;
        Long r87 = Long.valueOf(((Number) r60).longValue());     // Catch: Throwable -> L230
        if ((r87 instanceof Integer) == true) goto L213;
        r87 = null;
    L213:
        r61 = (Integer) r87;     // Catch: Throwable -> L230
    L215:
        if ((r60 instanceof JSONObject) == false) goto L217;
    L370:
        Object r88 = SDKSettingsCacheManager.a().fromJson(r60.toString(), Integer.class);     // Catch: Throwable -> L223
        if ((r88 instanceof Integer) == true) goto L221;
        r88 = null;
    L221:
        Object r89 = Result.constructor-impl((Integer) r88);     // Catch: Throwable -> L223
    L225:
        r61 = r89;
        if (Result.isFailure-impl(r61) == false) goto L228;
    L223:
        th = move-exception;
        Result.Companion r90 = Result.Companion;     // Catch: Throwable -> L230
        r89 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L230
        goto L225
    L217:
        if ((r60 instanceof JSONArray) == false) goto L227;
    L187:
        r84 = r60;
    L230:
        th = move-exception;
        Result.Companion r91 = Result.Companion;     // Catch: Throwable -> L340
        r62 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L340
    L340:
        th = move-exception;
        Result.Companion r92 = Result.Companion;
        Object r93 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r94 = Result.exceptionOrNull-impl(r93);
        if (r94 == null) goto L345;
        EnsureManager.ensureNotReachHere(r94);
    L345:
        if (Result.isFailure-impl(r93) == true) goto L348;
        r10 = r93;
    L348:
        r64 = r10;
        goto L350
    }

    public static wi.c m() {
        if (a.g.h() == false) goto L6;
        return DefaultLocationHostService.e;
    L6:
        return com.bytedance.android.ec.sdk.helper.d.b.getLocationService();
    }

    public final void p() {
        StringBuilder r0 = new StringBuilder("start init isEnableSDK=");
        boolean r1 = d;
        r0.append(r1);
        AddressSDKLog.a(r0.toString(), true);
        ii.a r10 = com.bytedance.android.ec.sdk.helper.d.b.getAccountService();
        if (r10 == null) goto L5;
        r10.a();
    L5:
        monitor-enter(this);
        if (r1 == true) goto L18;
    L16:
        monitor-exit(this);
        return;
    L18:
        w r11 = a;     // Catch: Throwable -> L13
        if (r11.h == true) goto L16;
        r11.h = true;     // Catch: Throwable -> L13
        Single.fromCallable(n.a).subscribeOn(Schedulers.io()).subscribe(o.a, p.a);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static boolean r() {
        wi.c r0 = m();
        if (r0 == null) goto L5;
        boolean r1 = r0.a();
        g = Boolean.valueOf(r1);
        return r1;
    L5:
        return false;
    }

    public static o83.a e(int r10) {
        if (r10 != 1) goto L5;
        boolean r11 = true;
    L6:
        o83.b r0 = new o83.b(null, r11, "xiaodian.supermarket_pop", 7);
        if (r10 == 1) goto L22;
        if (r10 == 2) goto L18;
        w r12 = a;
        r0.a = r12.b.c;
        if (r12.b.b >= z.j()) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == true) goto L15;
    L17:
        r0.c = 0;
    L30:
        ArrayList r14 = new ArrayList();
        if (r0.a == null) goto L33;
        r14.add(r0);
    L33:
        Iterator r1 = ((LinkedHashMap) a.a).entrySet().iterator();
    L35:
        if (r1.hasNext() == false) goto L45;
        Map.Entry r15 = (Map.Entry) r1.next();
        if (((AddressItemVO) r15.getValue()).getAddressVO() == null) goto L35;
        if (((AddressItemVO) r15.getValue()).getConfig() == null) goto L35;
        JSONObject r16 = ((AddressItemVO) r15.getValue()).getAddressVO();
        RecommendAddressConfig r17 = ((AddressItemVO) r15.getValue()).getConfig();
        if (r17 == null) goto L43;
        String r18 = r17.getBizCode();
    L44:
        r14.add(new o83.b(r16, false, r18, 14));
        goto L35
    L43:
        r18 = null;
        goto L44
    L45:
        o83.a r19 = new o83.a(r14, null, 2);
        if (r14.isEmpty() == false) goto L48;
        r19.b = 1;
        int r110 = s.a;
        s.a(3002, "GET_ADDRESS_RETURN_NULL", null);
    L48:
        return r19;
    L15:
        if (z.i(r0.a, r12.c.c) == true) goto L17;
        r0.b = r12.c.c;
        goto L17
    L12:
        r13 = false;
        goto L13
    L18:
        w r111 = a;
        if (r111.d.c == null) goto L21;
        r0.a = r111.d.c;
        r0.c = 2;
        goto L30
    L21:
        r0.a = r111.b.c;
        r0.c = 0;
        goto L30
    L22:
        w r112 = a;
        if (r112.c.c != null) goto L25;
        r0.c = 0;
        r0.a = r112.b.c;
        goto L30
    L25:
        if (Intrinsics.areEqual(i, Boolean.TRUE) == false) goto L27;
        r112.b.update(r112.c);
        r112.c.a();
        r0.a = r112.b.c;
    L28:
        r0.c = 1;
        goto L30
    L27:
        r0.a = r112.b.c;
        goto L28
    L5:
        r11 = false;
        goto L6
    }

    public static String l(kc.a.C0174a r1) {
        if (BtmSDK.INSTANCE.removeBcmChainPageId() == false) goto L6;
        return cd.a.b(r1.c);
    L6:
        return r1.b;
    }

    public static void n(String r10) {
        k0 r0 = a.g.g();     // Catch: Throwable -> L10
        if (r0 == null) goto L5;
        Boolean r1 = r0.a();     // Catch: Throwable -> L10
    L7:
        if ((!Intrinsics.areEqual(r1, Boolean.TRUE)) == false) goto L13;
        int r11 = com.bytedance.android.ec.core.address.c.a;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r10, "changeType");     // Catch: Throwable -> L10
        return;
    L13:
        return;
    L5:
        r1 = null;
    }

    public static void w(String r10) {
        if (d == true) goto L5;
        return;
    L5:
        int r1 = 0;
        AddressSDKLog.a("call showAddressUpdateDialog btm=" + r10, false);
        if (r10 != null) goto L8;
    L11:
        boolean r11 = true;
    L12:
        if (r11 == false) goto L14;
        w r12 = a;
        r12.a();
        r12.e++;
        return;
    L14:
        w r13 = a;
        Map<String, Integer> r14 = r13.l;
        if (r14 == null) goto L20;
        Integer r15 = r14.get(r10);
        if (r15 == null) goto L20;
        r1 = r15.intValue();
    L20:
        if (r13.l != null) goto L22;
        r13.l = new LinkedHashMap();
    L22:
        Map<String, Integer> r16 = r13.l;
        if (r16 == null) goto L27;
        Integer r17 = r16.put(r10, Integer.valueOf(r1 + 1));
        return;
    L27:
        return;
    L8:
        if (r10.length() == 0) goto L11;
        r11 = false;
        goto L12
    }

    public final synchronized Pair<Map<String, String>, Uri> o(Uri r12) {
        monitor-enter(this);
    L39:
        th = move-exception;
        throw th;
    L4:
        Pair<Map<String, String>, Uri> r1 = null;
        if (d == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        if (r12 == null) goto L37;
        w r0 = a;     // Catch: Throwable -> L39
        Map<String, j0> r10 = r0.g.c();     // Catch: Throwable -> L39
        if (r10 != null) goto L12;
    L15:
        boolean r11 = true;
    L16:
        if (r11 == true) goto L37;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L30
        String r14 = r12.getScheme();     // Catch: Throwable -> L30
        if (r14 != null) goto L21;
    L23:
        Uri r15 = UriProtector.parse(UriProtector.getQueryParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL));     // Catch: Throwable -> L30
    L24:
        String r16 = UriProtector.getQueryParameter(r12, "source_btm_token");     // Catch: Throwable -> L30
        Map<String, j0> r17 = r0.g.c();     // Catch: Throwable -> L30
        if (r17 == null) goto L32;
        j0 r18 = r17.get(r15.getPath());     // Catch: Throwable -> L30
        if (r18 == null) goto L32;
        final d r19 = i(j, null, r18.a(), r16, "hook_schema", 9);     // Catch: Throwable -> L30
        b2.a(new AddressSDK$startUpdateCycle$1(r19.b, new AddressSDK$hookSchema$3$1$1$1(r19)));     // Catch: Throwable -> L30
        String r20 = r19.a.a(true, null, null).toString();     // Catch: Throwable -> L30
        r1 = new Pair(MapsKt.mapOf(TuplesKt.to("ec_address_data", r20)), l0.c(r12, "ec_address_data", r20));     // Catch: Throwable -> L30
        goto L32
    L32:
        monitor-exit(this);
        return r1;
    L21:
        if (StringsKt.startsWith$default(r14, "http", false, 2, null) != true) goto L23;
        r15 = r12;
    L30:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L39
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L39
        return null;
    L12:
        if (r10.isEmpty() == true) goto L15;
        r11 = false;
    L37:
        monitor-exit(this);
        return null;
    }

    public static final void a(d r10, wi.a r11) {
        if (r10 == null) goto L5;
        final String r1 = r10.b;
    L6:
        if (r10 == null) goto L16;
        o83.a r12 = r10.a;
        if (r12 == null) goto L16;
        List r13 = r12.a;
        if (r13 == null) goto L16;
        o83.b r14 = (o83.b) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L16;
        if (Intrinsics.areEqual(r14.e, "xiaodian.supermarket_pop") == false) goto L16;
    L17:
        if (r14 == null) goto L21;
        JSONObject r15 = r14.a;
        if (r15 == null) goto L21;
        wi.a r16 = z.g(r15);
    L22:
        if (r1 == null) goto L48;
        if (r16 == null) goto L49;
        if (r11 != null) goto L26;
        return;
    L26:
        if (r14.d == false) goto L28;
        int r17 = s.a;
        s.a(9001, "GET_ADDRESS_OFFSET", MapsKt.mapOf(new Pair[]{TuplesKt.to("btm", r10.b), TuplesKt.to("offset_distance", Integer.valueOf((int) z.a(r16, r11)))}));
    L28:
        w r18 = a;
        if (r18.g.e().c() == true) goto L51;
        JSONObject r19 = r14.a;
        if (r19 == null) goto L33;
        String r20 = z.d(r19);
    L35:
        if ((!Intrinsics.areEqual(r20, "latest_selected_address")) == false) goto L52;
        Map<String, j0> r21 = r18.g.e().a();
        if (r21 != null) goto L39;
        return;
    L39:
        if (r21.containsKey(r10.b) != true) goto L54;
        Map<String, Integer> r22 = r18.l;
        if (r22 == null) goto L45;
        if (r22.containsKey(r10.b) != true) goto L45;
        return;
    L45:
        if (z.a(r16, r11) <= r18.g.e().b()) goto L56;
        h("fetch_poi", null, false, new AddressSDK$checkLocationChange$1(r1), 12);
        return;
    L56:
        return;
    L54:
        return;
    L52:
        return;
    L33:
        r20 = null;
        goto L35
    L51:
        return;
    L49:
        return;
    L48:
        return;
    L21:
        r16 = null;
    L16:
        r14 = null;
        goto L17
    L5:
        r1 = null;
        goto L6
    }

    public static final void c(String r12, JSONObject r13) {
        w r0 = a;
        JSONObject r1 = r0.b.c;
        if (r1 == null) goto L5;
        String r10 = z.b(r1);
    L6:
        JSONObject r11 = r13.optJSONObject("data");
        if (r11 == null) goto L9;
        String r14 = z.b(r11);
    L10:
        if (r11 == null) goto L12;
        Integer r15 = z.e(r11);
    L13:
        if (r14 == null) goto L28;
        if (r15 != null) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(r12, "updateAddress") == false) goto L20;
        AddressSDKLog.a("recv " + r12 + ": action=" + r13.optString("action") + " sourceType=" + r13.optInt(com.bytedance.android.ec.core.event.a.KEY_SOURCE_TYPE) + " curId=" + r10 + " recId=" + r14 + " recType=" + r15, false);
        return;
    L20:
        if (Intrinsics.areEqual(r12, "deleteAddress") == false) goto L30;
        String r16 = r13.optString("type");
        AddressSDKLog.a("recv " + r12 + ": type=" + r16 + " curId=" + r10 + " recId=" + r14 + " recType=" + r15, false);
        if (Intrinsics.areEqual(r16, "delete_all") == false) goto L31;
        int r17 = z.a;
        boolean r18 = z.i(r11, r0.b.c);
        if (r18 == false) goto L26;
        h("refresh", null, true, null, 22);
    L26:
        int r19 = s.a;
        s.a(3005, "DELETE_ALL_ADDRESS", MapsKt.mapOf(TuplesKt.to("is_same", Boolean.valueOf(r18))));
        return;
    L31:
        return;
    L30:
        return;
    L28:
        return;
    L12:
        r15 = null;
        goto L13
    L9:
        r14 = null;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    public static final void d(JSONObject r10, JSONObject r11) {
        if (r10 == null) goto L12;
        if (r11 == null) goto L14;
        JSONObject r12 = r10.optJSONObject("extra");
        if (r12 == null) goto L13;
        JSONObject r1 = r11.optJSONObject("extra");
        if (r1 != null) goto L10;
        r1 = new JSONObject();
        r11.put("extra", r1);
    L10:
        z1.b(r1, r12);
        return;
    L13:
        return;
    L14:
        return;
    }

    public static final void b(long r10, List r11, String r12) {
        AddressSDK r0 = j;
        monitor-enter(r0);
        Iterator r1 = r11.iterator();     // Catch: Throwable -> L51
        int r13 = -1;
    L6:
        if (r1.hasNext() == false) goto L48;
        AddressItemVO r14 = (AddressItemVO) r1.next();     // Catch: Throwable -> L51
        RecommendAddressConfig r15 = r14.getConfig();     // Catch: Throwable -> L51
        wi.a r16 = null;
        if (r15 == null) goto L10;
        String r17 = r15.getBizCode();     // Catch: Throwable -> L51
    L12:
        if (Intrinsics.areEqual(r17, "xiaodian.supermarket_pop") == true) goto L13;
        RecommendAddressConfig r18 = r14.getConfig();     // Catch: Throwable -> L51
        if (r18 == null) goto L6;
        String r19 = r18.getBizCode();     // Catch: Throwable -> L51
        if (r19 == null) goto L6;
        a.a.put(r19, r14);     // Catch: Throwable -> L51
        goto L6
    L13:
        r14.getConfig().adjustInvalidTime(r10);     // Catch: Throwable -> L51
        if (r14.getAddressVO() != null) goto L20;
        int r20 = s.a;     // Catch: Throwable -> L51
        if (a.b.c == null) goto L18;
        boolean r21 = true;
    L19:
        s.a(3004, "GET_ADDRESS_NET_EMPTY", MapsKt.mapOf(TuplesKt.to("has_address", Boolean.valueOf(r21))));     // Catch: Throwable -> L51
        goto L20
    L18:
        r21 = false;
    L20:
        w r22 = a;     // Catch: Throwable -> L51
        if (r22.b.c == null) goto L22;
        if (r14.getAddressVO() == null) goto L25;
        if (r() == true) goto L28;
        int r23 = z.a;     // Catch: Throwable -> L51
        JSONObject r24 = r22.b.c;     // Catch: Throwable -> L51
        if (r24 == null) goto L35;
        wi.a r25 = z.g(r24);     // Catch: Throwable -> L51
    L36:
        JSONObject r26 = r14.getAddressVO();     // Catch: Throwable -> L51
        if (r26 == null) goto L40;
        r16 = z.g(r26);     // Catch: Throwable -> L51
    L40:
        if (z.a(r25, r16) > r22.g.b().b()) goto L41;
        r13 = 5;
        goto L6
    L41:
        r22.c.update(r14);     // Catch: Throwable -> L51
        r13 = 6;
        goto L6
    L35:
        r25 = null;
        goto L36
    L28:
        int r27 = z.a;     // Catch: Throwable -> L51
        if (z.i(r14.getAddressVO(), r22.b.c) == false) goto L30;
        r13 = 3;
        goto L6
    L30:
        r22.c.update(r14);     // Catch: Throwable -> L51
        r13 = 4;
        goto L6
    L25:
        r13 = 1;
        goto L6
    L22:
        r22.b.update(r14);     // Catch: Throwable -> L51
        r13 = 0;
        goto L6
    L10:
        r17 = null;
        goto L12
    L48:
        AddressSDKLog.a("handleAddressList changeType=" + r12 + " size=" + r11.size() + " branch=" + r13, false);     // Catch: Throwable -> L51
        monitor-exit(r0);
        return;
    L51:
        th = move-exception;
        throw th;
    }

    public static void g(String r10, Throwable r11, int r12) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        int r13 = AddressSDKLog.a;
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        b2.a(new AddressSDKLog$e$1(r10, System.currentTimeMillis(), r11));
    }

    public static d f(int r10, Object r11, a0 r12, String r13) {
        o83.a r0 = e(r10);
        boolean r14 = true;
        if (r10 != 1) goto L10;
        if (r11 == null) goto L8;
        w r15 = a;
        if (r15.k.containsKey(r11) == true) goto L10;
        r15.k.put(r11, Unit.INSTANCE);
        r15.d.a();
    L9:
        boolean r16 = true;
    L11:
        List r17 = r0.a;
        Integer r18 = null;
        if (r17 == null) goto L21;
        Iterator r19 = r17.iterator();
    L15:
        if (r19.hasNext() == false) goto L19;
        Object r20 = r19.next();
        if (Intrinsics.areEqual(((o83.b) r20).e, "xiaodian.supermarket_pop") == false) goto L15;
    L20:
        o83.b r21 = (o83.b) r20;
    L22:
        if (r21 == null) goto L44;
        int r22 = AddressEventReporter.a;
        if (r12 == null) goto L26;
        String r23 = r12.a();
    L27:
        AddressEventReporter.b(r13, r23, r21);
        if (r21.c != 1) goto L32;
        JSONObject r24 = a.b.c;
        if (r24 == null) goto L32;
        t(r24, 1, 1, null);
    L32:
        JSONObject r25 = r21.a;
        if (r25 == null) goto L35;
        int r110 = z.a;
        Intrinsics.checkNotNullParameter(r25, "$this$getAddressDetail");
        String r26 = r25.optString(com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB);
    L36:
        if (r26 != null) goto L38;
    L41:
        boolean r27 = true;
    L42:
        if (r27 == false) goto L61;
        int r28 = s.a;
        s.a(3006, "GET_ADDRESS_RETURN_PART", MapsKt.mapOf(new Pair[]{TuplesKt.to("btm", r13), TuplesKt.to("sdk_address_type", Integer.valueOf(r21.c))}));
    L61:
        if (ECAppInfoService.e.i() == false) goto L65;
        Lazy r29 = FindAddressRecord.a;
        System.currentTimeMillis();
        f0 r30 = new f0();
        Intrinsics.checkNotNullParameter(r30, "item");
        Lazy r111 = FindAddressRecord.a;
        ((LinkedList) r111.getValue()).addFirst(r30);
        if (((LinkedList) r111.getValue()).size() <= 20) goto L65;
        ((LinkedList) r111.getValue()).pollLast();
    L65:
        StringBuilder r31 = new StringBuilder("findResult addrList.size=");
        List r112 = r0.a;
        if (r112 == null) goto L68;
        Integer r113 = Integer.valueOf(r112.size());
    L69:
        r31.append(r113);
        r31.append(" addrType=");
        if (r21 == null) goto L72;
        r18 = Integer.valueOf(r21.c);
    L72:
        r31.append(r18);
        r31.append(" clearSession=");
        r31.append(r16);
        AddressSDKLog.a(r31.toString(), false);
        Unit r32 = Unit.INSTANCE;
        return new d(r0, r13);
    L68:
        r113 = null;
        goto L69
    L38:
        if (r26.length() == 0) goto L41;
        r27 = false;
        goto L42
    L35:
        r26 = null;
        goto L36
    L26:
        r23 = null;
        goto L27
    L44:
        AddressItemVO r33 = a.b.a;
        if (r33 != null) goto L47;
    L49:
        boolean r34 = false;
    L50:
        if (r34 == false) goto L61;
        int r35 = AddressEventReporter.a;
        if (r12 == null) goto L54;
        String r114 = r12.a();
    L56:
        if (r10 == 1) goto L59;
        r14 = false;
    L59:
        AddressEventReporter.b(r13, r114, new o83.b(null, r14, "xiaodian.supermarket_pop", 7));
        goto L61
    L54:
        r114 = null;
        goto L56
    L47:
        if (r33.getAddressVO() != null) goto L49;
        r34 = true;
        goto L50
    L19:
        r20 = null;
        goto L20
    L21:
        r21 = null;
        goto L22
    L8:
        a.d.a();
    L10:
        r16 = false;
        goto L11
    }

    public static Disposable t(JSONObject r10, int r11, int r12, Function2 r13) {
        if (r11 != 0) goto L4;
        String r14 = "user_selected";
    L5:
        AddressSDKLog.a("start report, source=" + r14 + " channelType=" + r12 + " address=" + z.c(r10), false);
        AddressApi r0 = AddressApi.b;
        Intrinsics.checkNotNullParameter(r10, "$this$toSimpleAddress");
        int r1 = o83.b.f;
        JSONObject r15 = o83.b.a.a(r10, true);
        if (r15 == null) goto L8;
        String r16 = r15.toString();
    L10:
        return bg4.b.b(r0.reportAddress(r14, r16, Integer.valueOf(r12)).map(a.a)).subscribe(new b(r13, r14), new c(r14, r13));
    L8:
        r16 = null;
        goto L10
    L4:
        r14 = "system_selected";
        goto L5
    }

    public final synchronized o83.a k(Object r10, String r11, int r12, String r13) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_FROM);     // Catch: Throwable -> L28
        StringBuilder r1 = new StringBuilder("getAddress btmObj=");     // Catch: Throwable -> L28
        r1.append(r10);     // Catch: Throwable -> L28
        r1.append(" btm=");     // Catch: Throwable -> L28
        r1.append(r11);     // Catch: Throwable -> L28
        r1.append(" addrType=");     // Catch: Throwable -> L28
        r1.append(r12);     // Catch: Throwable -> L28
        r1.append(" isEnableSDK=");     // Catch: Throwable -> L28
        boolean r0 = d;     // Catch: Throwable -> L28
        r1.append(r0);     // Catch: Throwable -> L28
        r1.append(" setting_null=");     // Catch: Throwable -> L28
        w r14 = a;     // Catch: Throwable -> L28
        r1.append(r14.g.b);     // Catch: Throwable -> L28
        AddressSDKLog.a(r1.toString(), false);     // Catch: Throwable -> L28
        if (r0 == true) goto L10;
        o83.a r15 = new o83.a(null, 0, 1);     // Catch: Throwable -> L28
        monitor-exit(this);
        return r15;
    L10:
        if (r14.g.b == false) goto L14;
        o83.a r16 = new o83.a(null, 2, 1);     // Catch: Throwable -> L28
        monitor-exit(this);
        return r16;
    L14:
        if (r12 == 0) goto L25;
        if (r12 == 1) goto L25;
        if (r12 == 2) goto L25;
        if (r11 != null) goto L20;
        String r17 = null;
    L24:
        final d r18 = i(this, r10, r17, null, r13, 12);     // Catch: Throwable -> L28
        b2.a(new AddressSDK$startUpdateCycle$1(r18.b, new AddressSDK$getAddress$2$1(r18)));     // Catch: Throwable -> L28
        o83.a r19 = r18.a;     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
        return r19;
    L20:
        if (StringsKt.endsWith$default(r11, "c0.d0", false, 2, null) == true) goto L23;
        r11 = new Regex("c.*").replace(r11, "c0.d0");     // Catch: Throwable -> L28
    L23:
        r17 = r11;
    L25:
        b2.a(new AddressSDK$startUpdateCycle$1(null, null));     // Catch: Throwable -> L28
        r19 = e(r12);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public final void v(final String r11, int r12, final JSONObject r13, final o83.e r14) {
        com.bytedance.android.ec.core.address.a r0 = b;
        r0.getClass();
        Intrinsics.checkNotNullParameter("fetch_single_address", "key");
        Disposable r1 = r0.a.remove("fetch_single_address");
        if (r1 != null) goto L5;
    L7:
        int r10 = z.a;
        w r15 = a;
        if (z.h(r15.d.c, r11, Integer.valueOf(r12)) == false) goto L12;
        if (r14 == null) goto L22;
        r14.onSuccess(null);
        return;
    L22:
        return;
    L12:
        monitor-enter(this);
        r15.d.c = r13;     // Catch: Throwable -> L17
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        Function2<JSONObject, String, Unit> r17 = new AddressSDK$setSessionAddress$2(r11, r13, r14);
        AddressSDKLog.a("start fetch address, id=" + r11 + " type=" + r12, false);
        Lazy r18 = AddressApi.a;
        n("read_address");
        r0.a("fetch_single_address", bg4.b.b(IAddressApi.a.a(r(), "read_address", r11, Integer.valueOf(r12), null, null, ((Number) e.getValue()).intValue(), 96).map(j.a)).subscribe(new k(r17, r11, r12), new l(r11, r12, r17)));
        return;
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r1.isDisposed() == true) goto L7;
        r1.dispose();
        goto L7
    }

    public static void h(String r11, String r12, boolean r13, Function2 r14, int r15) {
        String r1 = null;
        if ((r15 & 4) == 0) goto L6;
        r12 = null;
    L6:
        if ((r15 & 8) == 0) goto L9;
        r13 = false;
    L9:
        if ((r15 & 16) == 0) goto L11;
        r14 = null;
    L11:
        StringBuilder r16 = new StringBuilder("start fetch address list, changeType=");
        r16.append(r11);
        r16.append(", isLogin=");
        com.bytedance.android.ec.sdk.helper.r r0 = com.bytedance.android.ec.sdk.helper.r.a;
        r16.append(r0.isLogin());
        r16.append(" fromDeleteAll=");
        r16.append(r13);
        AddressSDKLog.a(r16.toString(), false);
        if (r0.isLogin() == true) goto L15;
        return;
    L15:
        if (r() == false) goto L17;
    L22:
        JSONObject r17 = a.b.c;
        if (r17 == null) goto L25;
        JSONArray r10 = new JSONArray();
        JSONObject r18 = new JSONObject();
        int r19 = z.a;
        Intrinsics.checkNotNullParameter(r17, "$this$toSimpleAddress");
        int r20 = o83.b.f;
        r18.put("address", o83.b.a.a(r17, true));
        r18.put("biz_code", "xiaodian.supermarket_pop");
        Unit r110 = Unit.INSTANCE;
        r10.put(r18);
    L26:
        JSONObject r111 = new JSONObject();
        if (((AddressSDKLightLocateAB) AddressSDKLightLocateAB.a.getValue()).d() == false) goto L30;
        if (r12 == null) goto L30;
        r111.put("cool_start_type", r12);
    L30:
        Lazy r112 = AddressApi.a;
        n(r11);
        boolean r21 = r();
        if (r10 == null) goto L33;
        r1 = r10.toString();
    L33:
        Disposable r113 = bg4.b.b(IAddressApi.a.a(r21, r11, null, null, r1, r111.toString(), ((Number) e.getValue()).intValue(), 24).map(e.a)).subscribe(new f(r14, r11, r13), new g(r11));
        h = Boolean.FALSE;
        b.a("fetch_address_list", r113);
        return;
    L25:
        r10 = null;
        goto L26
    L17:
        if ((!Intrinsics.areEqual(r11, "fetch_poi")) == false) goto L22;
        long r22 = z.j() / ((long) 60);
        w r114 = a;
        if ((r22 - r114.i) < r114.g.b().a()) goto L36;
        r114.i = r22;
        goto L22
    }

    public static d j(Object r23, String r24, String r25, int r26, String r27) {
        if (r26 != 0) goto L5;
        int r10 = z.a;
        w r11 = a;
        String r12 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{z.k("active", r11.b.c), z.k("latest", r11.c.c), z.k("session", r11.d.c)}), " ", null, null, 0, null, null, 62, null);
    L6:
        AddressSDKLog.a("findViaBtmChain btm=" + r24 + " from=" + r27 + " sourceToken=" + r25 + " retry=" + r26 + ' ' + r12, false);
        w r14 = a;
        b0 r13 = r14.g.a().c();
        if (r26 == 0) goto L11;
        if (r13 == null) goto L10;
        int r15 = r13.b();
    L13:
        int r16 = r15;
    L16:
        if (a2.b(r25) == false) goto L18;
        kc.a r17 = BtmSDK.getBcmChainByToken$default(BtmSDK.INSTANCE, r25, r16, false, 4, null);
        int r18 = r16;
    L27:
        if (r17 == null) goto L89;
        List<kc.a.C0174a> r19 = r17.a;
        if (r19 == null) goto L89;
        x r20 = r14.g.a();
        int r21 = r19.size();
        String r110 = r24;
        String r111 = r110;
        int r22 = 0;
        a0 r112 = null;
    L31:
        if (r22 >= r21) goto L56;
        if (r111 != null) goto L37;
        String r113 = l((kc.a.C0174a) ListProtector.get(r19, r22));
        if (r113 != null) goto L36;
        r113 = "";
    L36:
        r111 = r113;
    L52:
        r110 = l((kc.a.C0174a) ListProtector.get(r19, r22));
        if (r112 != null) goto L56;
        r22 = r22 + 1;
        goto L31
    L37:
        a0 r28 = r20.a(l((kc.a.C0174a) ListProtector.get(r19, r22)));
        if (r28 == null) goto L40;
        List<a0> r114 = r28.b();
    L41:
        if (r114 == null) goto L51;
        Iterator<T> r115 = r28.b().iterator();
    L44:
        if (r115.hasNext() == false) goto L49;
        Object r116 = r115.next();
        if (Intrinsics.areEqual(((a0) r116).a(), r110) == false) goto L44;
    L50:
        if (r116 == null) goto L52;
    L49:
        r116 = null;
    L51:
        r112 = r28;
        goto L52
    L40:
        r114 = null;
    L56:
        a0 r29 = r20.a(r111);
        if (r29 == null) goto L59;
        int r30 = r29.getType();
    L60:
        if (r112 == null) goto L62;
        int r31 = r112.getType();
    L63:
        if (r29 == null) goto L65;
        Boolean r117 = r29.c();
    L67:
        if (Intrinsics.areEqual(r117, Boolean.TRUE) == false) goto L69;
        r31 = 0;
    L76:
        Boolean r32 = null;
    L77:
        Integer r1 = r20.b(r30, r31);
        if (r1 == null) goto L80;
        int r33 = r1.intValue();
    L81:
        if (r111 == null) goto L87;
        kc.a.C0174a r34 = (kc.a.C0174a) CollectionsKt.firstOrNull(r19);
        if (r34 == null) goto L85;
        Object r35 = r34.c;
    L86:
        Boolean r36 = Boolean.valueOf(r111.equals(r35));
    L88:
        i = r36;
        AddressSDKLog.a("findViaBtmChain preItem=[" + r112 + "] curItem=[" + r29 + "] preField=" + r31 + " curField=" + r30 + " listSize=" + r19.size() + " addrType=" + r33 + ", isTopPage=" + i, false);
        int r118 = r33;
        a0 r37 = r112;
    L91:
        return f(r118, r23, r37, r111);
    L85:
        r35 = r32;
        goto L86
    L87:
        r36 = r32;
        goto L88
    L80:
        r33 = 0;
        goto L81
    L69:
        if (r112 != null) goto L76;
        if (r19.size() != r18) goto L76;
        if (r26 == 0) goto L74;
        int r38 = s.a;
        r32 = null;
        s.a(3001, "BTM_CHAIN_SEARCH_FAIL", null);
        goto L77
    L74:
        return j(r23, r24, r25, r26 + 1, r27);
    L65:
        r117 = null;
        goto L67
    L62:
        r31 = 0;
        goto L63
    L59:
        r30 = 0;
    L89:
        r111 = r24;
        r37 = null;
        r118 = 0;
        goto L91
    L18:
        BtmSDK r39 = BtmSDK.INSTANCE;
        if ((r23 instanceof Fragment) == false) goto L23;
        PageFinder r40 = PageFinder.via((Fragment) r23);
    L21:
        PageFinder r119 = r40;
        r18 = r16;
        r17 = BtmSDK.getBcmChainByFinder$default(r39, r119, r18, false, 4, null);
        goto L27
    L23:
        if ((r23 instanceof View) == false) goto L25;
        r40 = PageFinder.via((View) r23);
        goto L21
    L25:
        r40 = PageFinder.via(r23);
        goto L21
    L10:
        r16 = 50;
        goto L16
    L11:
        if (r13 == null) goto L14;
        r15 = r13.a();
        goto L13
    L14:
        r16 = 20;
        goto L16
    L5:
        r12 = "";
        goto L6
    }

    public final void u(JSONObject r10, int r11, boolean r12, o83.e r13, o83.d r14) {
        if (d == true) goto L8;
        if (r13 == null) goto L63;
        r13.onFailed("未命中实验");
        return;
    L63:
        return;
    L8:
        if (r10 == null) goto L10;
        String r1 = z.b(r10);
    L11:
        if (r10 == null) goto L13;
        Integer r15 = z.e(r10);
    L15:
        if (r1 == null) goto L55;
        if (r15 == null) goto L55;
        AddressSDKLog.a("setAddress address=" + z.c(r10) + " source=" + r11 + " session=" + r12 + " extraParams=" + r14, false);
        if (r12 == false) goto L21;
        v(r1, r15.intValue(), r10, r13);
        return;
    L21:
        w r16 = a;
        if (z.i(r16.b.c, r10) == false) goto L25;
        if (r13 == null) goto L65;
        r13.onSuccess(null);
        return;
    L65:
        return;
    L25:
        if (r14 == null) goto L53;
        Boolean r0 = r14.a;
        Boolean r17 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r17) == false) goto L53;
        if (Intrinsics.areEqual(r14.b, r17) == false) goto L45;
        AddressSDK r18 = j;
        monitor-enter(r18);
    L42:
        th = move-exception;
        throw th;
    L33:
        if (r16.c.c != null) goto L35;
        r16.c.update(r16.b);     // Catch: Throwable -> L42
    L35:
        r16.b.a();     // Catch: Throwable -> L42
        r16.b.c = r10;     // Catch: Throwable -> L42
        if (Intrinsics.areEqual(r14.c, r17) == false) goto L39;
        if (r13 == null) goto L39;
        r13.onSuccess(r10);     // Catch: Throwable -> L42
    L39:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r18);
        goto L53
    L45:
        AddressSDK r20 = j;
        monitor-enter(r20);
        r16.b.a();     // Catch: Throwable -> L50
        r16.c.a();     // Catch: Throwable -> L50
        r16.b.c = r10;     // Catch: Throwable -> L50
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L50
        monitor-exit(r20);
    L50:
        th = move-exception;
        throw th;
    L53:
        s(r10, r11, r13, false, 3, r14);
        return;
    L55:
        if (r13 == null) goto L57;
        r13.onFailed("传入的 address 不合法");
    L57:
        int r21 = s.a;
        s.a(3003, "SET_ADDRESS_FORMAT_ERROR", MapsKt.mapOf(new Pair[]{TuplesKt.to("btm", z.f()), TuplesKt.to("is_session", Boolean.valueOf(r12)), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SOURCE_TYPE, Integer.valueOf(r11)), TuplesKt.to("address_id", r1), TuplesKt.to("address_type", r15)}));
        return;
    L13:
        r15 = null;
        goto L15
    L10:
        r1 = null;
        goto L11
    }

    public static d i(AddressSDK r10, Object r11, String r12, String r13, String r14, int r15) {
        Boolean r1 = null;
        if ((r15 & 1) == 0) goto L6;
        r11 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = null;
    L9:
        if ((r15 & 4) == 0) goto L11;
        r13 = null;
    L11:
        r10.getClass();
        int r16 = 0;
        if (a.g.a().d() == false) goto L139;
        u r17 = c;
        monitor-enter(r17);
        String r18 = u.a(r11, r12);     // Catch: Throwable -> L135
        FragmentActivity r19 = ECAppInfoService.e.getCurrentActivity();     // Catch: Throwable -> L135
        if ((r19 instanceof FragmentActivity) == true) goto L18;
        FragmentActivity r0 = null;
    L19:
        FragmentActivity r20 = r0;     // Catch: Throwable -> L135
        if (r20 == null) goto L22;
        FragmentManager r21 = r20.getSupportFragmentManager();     // Catch: Throwable -> L135
    L23:
        if (r21 == null) goto L25;
        List r22 = r21.getFragments();     // Catch: Throwable -> L135
    L27:
        if (r22 == null) goto L43;
        Iterator r23 = r22.iterator();     // Catch: Throwable -> L135
    L30:
        if (r23.hasNext() == false) goto L41;
        Object r24 = r23.next();     // Catch: Throwable -> L135
        Fragment r25 = (Fragment) r24;     // Catch: Throwable -> L135
        if (r25 != null) goto L34;
    L38:
        boolean r26 = false;
    L39:
        if (r26 == false) goto L30;
    L42:
        Fragment r27 = (Fragment) r24;     // Catch: Throwable -> L135
    L44:
        String r110 = u.a(r19, null);     // Catch: Throwable -> L135
        String r28 = u.a(r27, null);     // Catch: Throwable -> L135
        int r29 = r17.a.size() - 1;     // Catch: Throwable -> L135
    L46:
        if (r29 < 0) goto L55;
        u.a r30 = (u.a) CollectionsKt.getOrNull(r17.a, r29);     // Catch: Throwable -> L135
        if (r30 == null) goto L50;
        String r31 = r30.a;     // Catch: Throwable -> L135
    L52:
        if (Intrinsics.areEqual(r31, r18) == true) goto L56;
        r29 = r29 - 1;     // Catch: Throwable -> L135
    L56:
        if (r29 <= (-1)) goto L78;
        u.a r111 = (u.a) CollectionsKt.getOrNull(r17.a, r29);     // Catch: Throwable -> L135
        if (r110.length() <= 0) goto L60;
        boolean r32 = true;
    L61:
        if (r32 == false) goto L78;
        if (r111 == null) goto L64;
        String r33 = r111.c;     // Catch: Throwable -> L135
    L66:
        if (Intrinsics.areEqual(r110, r33) == false) goto L72;
        if (r111 == null) goto L69;
        String r34 = r111.d;     // Catch: Throwable -> L135
    L71:
        if ((!Intrinsics.areEqual(r28, r34)) == true) goto L78;
    L69:
        r34 = null;
    L72:
        if (r111 == null) goto L74;
        String r112 = r111.c;     // Catch: Throwable -> L135
    L76:
        if ((!Intrinsics.areEqual(r110, r112)) == true) goto L78;
        r17.b(r11, r12);     // Catch: Throwable -> L135
        goto L78
    L74:
        r112 = null;
        goto L76
    L64:
        r33 = null;
        goto L66
    L60:
        r32 = false;
    L78:
        if (r29 == (-1)) goto L81;
        if (r11 == null) goto L81;
    L84:
        monitor-exit(r17);
        x r35 = a.g.a();
        int r113 = CollectionsKt.reversed(c.a).size();
        String r114 = r12;
        a0 r36 = null;
        int r37 = 0;
    L86:
        if (r37 >= r113) goto L119;
        if (r12 != null) goto L94;
        u.a r38 = (u.a) CollectionsKt.getOrNull(c.a, r37);
        if (r38 == null) goto L91;
        r12 = r38.e;
    L92:
        if (r12 != null) goto L118;
        r12 = "";
    L118:
        r37 = r37 + 1;
        goto L86
    L91:
        r12 = null;
        goto L92
    L94:
        u.a r39 = (u.a) CollectionsKt.getOrNull(c.a, r37);
        if (r39 == null) goto L97;
        String r40 = r39.e;
    L98:
        a0 r41 = r35.a(r40);
        if (r41 == null) goto L101;
        List<a0> r42 = r41.b();
    L102:
        if (r42 == null) goto L111;
        Iterator<T> r43 = r41.b().iterator();
    L105:
        if (r43.hasNext() == false) goto L109;
        Object r44 = r43.next();
        if (Intrinsics.areEqual(((a0) r44).a(), r114) == false) goto L105;
    L110:
        if (r44 != null) goto L111;
    L112:
        u.a r115 = (u.a) CollectionsKt.getOrNull(c.a, r37);
        if (r115 == null) goto L115;
        r114 = r115.e;
    L116:
        if (r36 == null) goto L118;
    L115:
        r114 = null;
        goto L116
    L109:
        r44 = null;
    L111:
        r36 = r41;
        goto L112
    L101:
        r42 = null;
        goto L102
    L97:
        r40 = null;
    L119:
        a0 r116 = r35.a(r12);
        if (r116 == null) goto L122;
        int r117 = r116.getType();
    L123:
        if (r36 == null) goto L125;
        int r45 = r36.getType();
    L126:
        if (r116 == null) goto L129;
        r1 = r116.c();
    L129:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L131;
        r45 = 0;
    L131:
        Integer r46 = r35.b(r117, r45);
        if (r46 == null) goto L157;
        r16 = r46.intValue();
    L157:
        return f(r16, r11, r36, r12);
    L125:
        r45 = 0;
        goto L126
    L122:
        r117 = 0;
    L81:
        if (r17.a.size() < r17.b) goto L83;
        ListProtector.remove(r17.a, 0);     // Catch: Throwable -> L135
    L83:
        r17.a.add(new u.a(new WeakReference(r11), r110, r28, r12));     // Catch: Throwable -> L135
        goto L84
    L50:
        r31 = null;
        goto L52
    L55:
        r29 = -1;
        goto L56
    L34:
        if (r25.isVisible() == false) goto L38;
        if (r25.getUserVisibleHint() == false) goto L38;
        r26 = true;
        goto L39
    L41:
        r24 = null;
        goto L42
    L43:
        r27 = null;
        goto L44
    L25:
        r22 = null;
        goto L27
    L22:
        r21 = null;
        goto L23
    L18:
        r0 = r19;
    L135:
        th = move-exception;
        throw th;
    L139:
        return j(r11, r12, r13, 0, r14);
    }

    public static void s(final JSONObject r10, final int r11, final o83.e r12, final boolean r13, int r14, final o83.d r15) {
        Disposable r16 = t(r10, r11, r14, new AddressSDK$reportAddress$1(r10, r11, r13, r15, r12));
        b.a("report_address", r16);
    }
}
