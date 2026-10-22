package wyb;

import android.app.Activity;
import android.net.Uri;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.idp_auth.FlowKaSsoStepInfo;
import com.ss.android.lark.passport.flow.mfa.FlowMfaBidpWebActivityType;
import com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession;
import com.ss.android.lark.passport.flow.mfa.e;
import com.ss.android.lark.passport.flow.mfa.g;
import com.ss.android.lark.passport.flow.mfa.m;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements syb.a<m> {
    public static final c a = null;
    public static final List<String> b = null;

    public c() {
    }

    @Override // syb.a
    public final String getName() {
        return "IdpAuthAction";
    }

    static {
        a = new c();
        b = CollectionsKt.listOf(new String[]{"url", "auth_url", "web_url", "redirect_url", "uri", "land_url"});
    }

    @Override // syb.a
    public final void a(String r17, m r18) {
        Intrinsics.checkNotNullParameter(r17, "nextStep");
        Intrinsics.checkNotNullParameter(r18, "context");
        PassportLog.d("IdpAuthAction", "enter action idp auth");
        JSONObject r4 = r18.c.getStepInfo();
        Set<String> r0 = a.b;
        a r1 = a.C0203a.a(r4);
        if (r1.a() == true) goto L5;
        PassportLog.b("IdpAuthAction", "unsupported idp channel: " + r1.a);
        r18.b.i(g.d());
        return;
    L5:
        r18.b.u(r4);
        Iterator<T> r2 = b.iterator();
    L6:
        boolean r6 = true;
        String r7 = null;
        if (r2.hasNext() == false) goto L16;
        String r5 = r4.getString((String) r2.next());
        if (r5 != null) goto L11;
    L13:
        r5 = null;
    L14:
        if (r5 == null) goto L6;
    L18:
        if (r5 != null) goto L20;
    L23:
        boolean r3 = true;
    L24:
        if (r3 == false) goto L26;
        PassportLog.b("IdpAuthAction", "idp auth url is empty");
        r18.b.t(r4, false);
        r18.b.i(g.e(r17));
        return;
    L26:
        r18.b.y(r18.c);
        r18.b.s(r18.c);
        WeakReference<Activity> r8 = r18.b.l.getAndSet(null);
        if (r8 == null) goto L33;
        Activity r9 = r8.get();
        if (r9 == null) goto L33;
        if (FlowMfaFlowSession.p(r9) == false) goto L33;
        Activity r10 = r9;
    L34:
        if (r10 != null) goto L36;
        Activity r11 = r18.getActivity();
    L37:
        e r12 = e.a;
        FlowMfaFlowSession r15 = r18.b;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r4, "stepInfo");
        Intrinsics.checkNotNullParameter(r15, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter("BIDP", "source");
        FlowKaSsoStepInfo.Companion.getClass();
        Intrinsics.checkNotNullParameter(r4, "stepInfo");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L40
        Object r14 = Result.constructor-impl((FlowKaSsoStepInfo) JSON.parseObject(r4.toJSONString(), FlowKaSsoStepInfo.class));     // Catch: Throwable -> L40
    L43:
        if (Result.isFailure-impl(r14) == false) goto L45;
        r14 = null;
    L45:
        FlowKaSsoStepInfo r16 = (FlowKaSsoStepInfo) r14;
        if (r16 != null) goto L48;
        PassportLog.b("FlowMfaChameleonWebOpener", "open BIDP url failed: step info is invalid");
    L91:
        boolean r19 = false;
    L114:
        if (r10 == null) goto L116;
        r10.finish();
    L116:
        if (r19 == true) goto L132;
        r18.b.t(r4, false);
        r18.b.i(g.e(r17));
        return;
    L132:
        return;
    L48:
        String r20 = r16.getPrimaryUrl();
        if (r20 != null) goto L51;
    L53:
        r20 = null;
    L54:
        if (r20 != null) goto L56;
    L59:
        boolean r110 = true;
    L60:
        if (r110 == false) goto L62;
        PassportLog.b("FlowMfaChameleonWebOpener", "open BIDP url failed: auth url is empty");
        goto L91
    L62:
        String r111 = e.d(r20);
        String r21 = r16.getUserAgent();
        if ((!StringsKt.isBlank(r21)) == false) goto L65;
        String r112 = r21;
    L67:
        if (r16.getShouldOpenWithBrowser() == false) goto L94;
        String r22 = r16.getLandUrl();
        if (r22 != null) goto L71;
    L73:
        if (r7 != null) goto L75;
    L78:
        if (r6 == false) goto L80;
        PassportLog.b("FlowMfaChameleonWebOpener", "open BIDP url failed: land url is empty");
        goto L91
    L80:
        String r23 = e.d(r7);
        Object r24 = Result.constructor-impl(UriProtector.parse(r23).buildUpon().appendQueryParameter("loadingpage", "true").build().toString());     // Catch: Throwable -> L83
    L85:
        Object r25 = r23;
        if (Result.isFailure-impl(r24) == true) goto L90;
        r25 = r24;
    L90:
        if (e.b(r11, (String) r25, "BIDP land_url", r112, r15, FlowMfaBidpWebActivityType.EXTERNAL_BROWSER_LOADING) == false) goto L91;
        PassportLog.d("FlowMfaChameleonWebOpener", "open BIDP loading web success, start external browser");
        r19 = e.c(r11, r111, r15);
    L83:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L85
    L75:
        if (StringsKt.isBlank(r7) == true) goto L78;
        r6 = false;
        goto L78
    L71:
        if ((!StringsKt.isBlank(r22)) == false) goto L73;
        r7 = r22;
        goto L73
    L94:
        if (StringsKt.startsWith(r111, "https://", true) == false) goto L96;
    L99:
        if (r6 == true) goto L123;
        r19 = e.c(r11, r111, r15);
        goto L114
    L123:
        Uri r27 = UriProtector.parse(r111);     // Catch: Throwable -> L108
        if (UriProtector.getQueryParameterNames(r27).contains("open_from_passport_idp") == false) goto L105;
        String r113 = r111;
    L106:
        Object r28 = Result.constructor-impl(r113);     // Catch: Throwable -> L108
    L110:
        Object r114 = r28;
        if (Result.isFailure-impl(r114) == false) goto L113;
        r114 = r111;
    L113:
        r19 = e.b(r11, (String) r114, "BIDP", r112, r15, FlowMfaBidpWebActivityType.INTERNAL_AUTH);
        goto L114
    L105:
        r113 = r27.buildUpon().appendQueryParameter("open_from_passport_idp", "true").build().toString();     // Catch: Throwable -> L108
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L108
    L108:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L110
    L96:
        if (StringsKt.startsWith(r111, "http://", true) == true) goto L99;
        r6 = false;
        goto L99
    L65:
        r112 = null;
        goto L67
    L56:
        if (StringsKt.isBlank(r20) == true) goto L59;
        r110 = false;
        goto L60
    L51:
        if ((!StringsKt.isBlank(r20)) == false) goto L53;
    L40:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L36:
        r11 = r10;
    L33:
        r10 = null;
        goto L34
    L20:
        if (StringsKt.isBlank(r5) == true) goto L23;
        r3 = false;
        goto L24
    L11:
        if ((!StringsKt.isBlank(r5)) == false) goto L13;
    L16:
        r5 = null;
        goto L18
    }

    @Override // syb.a
    public final boolean b(String r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "nextStep");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (Intrinsics.areEqual(r2, "idp_authentication") == false) goto L7;
        Set<String> r4 = a.b;
        if (a.C0203a.a(r3.c.getStepInfo()).a() == false) goto L7;
        return true;
    L7:
        return false;
    }
}
