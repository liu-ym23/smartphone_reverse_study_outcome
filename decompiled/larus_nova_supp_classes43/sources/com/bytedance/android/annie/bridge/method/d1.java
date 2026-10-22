package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.method.abs.OpenResultModel;
import com.bytedance.android.annie.card.ContainerInitialPropsManager;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = com.bytedance.android.ec.core.event.a.VALUE_OPEN)
public final class d1 extends e7.n<e7.n0, OpenResultModel> {
    public static final List<String> b = null;
    public static final List<String> c = null;
    public final IHybridComponent a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OpenAPPTYPE.values().length];
            r0[OpenAPPTYPE.WEIXIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[OpenAPPTYPE.QQ.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            a = r0;
            int[] r1 = new int[OpenActionStatus.values().length];
            r1[OpenActionStatus.BEFORE_OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[OpenActionStatus.AFTER_OPEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            b = r1;
        }
    }

    static {
        b = CollectionsKt.listOf(new String[]{"alwaysCloseAfterOpen", "alwaysCloseBeforeOpen", "onlyCloseAfterOpenSucceed"});
        c = CollectionsKt.listOf(new String[]{"webcast_webview", "webcast_lynxview", "webcast_redirect"});
    }

    public final void l() {
        IHybridComponent r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hybridComponent");
        r0 = null;
    L5:
        AnnieFragmentManager.a(r0.containerId(), false, 6);
    }

    public d1(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        IHybridComponent r11 = (IHybridComponent) r10.c(IHybridComponent.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public static void k(e7.n0 r10) {
        String r0 = r10.e();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if ((!r11) == false) goto L21;
        if (r10.d() == null) goto L15;
        List<String> r12 = b;
        String r13 = r10.d();
        Intrinsics.checkNotNull(r13);
        if (r12.contains(r13) == true) goto L15;
    L16:
        if (r1 == false) goto L19;
        return;
    L19:
        throw new IllegalStateException("replaceType is not valid".toString());
    L15:
        r1 = true;
        goto L16
    L21:
        throw new IllegalStateException("url is null or empty".toString());
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r11 = false;
        goto L10
    }

    public static String m(e7.n0 r10) {
        Boolean r0 = r10.c();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == true) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r10.f(), r1) == false) goto L8;
        return null;
    L8:
        if (r10.d() != null) goto L10;
    L17:
        return "onlyCloseAfterOpenSucceed";
    L10:
        if (Intrinsics.areEqual(r10.d(), "onlyCloseAfterOpenSucceed") == true) goto L17;
        if (Intrinsics.areEqual(r10.d(), "alwaysCloseAfterOpen") == true) goto L20;
        return "alwaysCloseBeforeOpen";
    L20:
        return "alwaysCloseAfterOpen";
    }

    public final Uri j(e7.n0 r10) {
        String r0 = r10.e();
        Intrinsics.checkNotNull(r0);
        Uri r1 = UriProtector.parse(r0);
        if (CollectionsKt.contains(c, r1.getHost()) == false) goto L17;
        Uri.Builder r11 = r1.buildUpon();
        IHybridComponent r12 = this.a;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("hybridComponent");
        r12 = null;
    L7:
        r11.appendQueryParameter("_open_container_id", r12.containerId());
        if (Intrinsics.areEqual(r10.c(), Boolean.TRUE) == false) goto L13;
        if (Intrinsics.areEqual(m(r10), "onlyCloseAfterOpenSucceed") == false) goto L13;
        r11.appendQueryParameter("_close_after_open_success", "1");
    L13:
        if (r10.b() == null) goto L16;
        String r13 = UUID.randomUUID().toString();
        Lazy r14 = ContainerInitialPropsManager.a;
        JsonObject r15 = r10.b();
        Intrinsics.checkNotNullParameter(r13, "key");
        ((HashMap) ContainerInitialPropsManager.a.getValue()).put(r13, r15);
        r11.appendQueryParameter("__initialProps_data_key", r13);
    L16:
        return r11.build();
    L17:
        return r1;
    }

    public d1(IHybridComponent r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridComponent");
        this.a = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.n0 r12 = (e7.n0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        int r0 = x8.a.a;
        x8.a.d("Annie_OpenJSBMethod", "use open method, params: " + r12, false);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        k(r12);     // Catch: Throwable -> L5
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L10;
        x8.a.b("Annie_OpenJSBMethod", "Parameters invalid", false);
        OpenResultModel r15 = new OpenResultModel();
        r15.b(r14.getMessage());
        r15.a(OpenResultModel.Code.InvalidParam);
        finishWithResult(r15);
        return;
    L10:
        String r16 = null;
        o(OpenActionStatus.BEFORE_OPEN, r12, null);
        String r17 = r12.e();
        if (r17 == null) goto L19;
        if (StringsKt.startsWith$default(r17, "weixin", false, 2, null) == false) goto L16;
        n(OpenAPPTYPE.WEIXIN, r11);
        return;
    L16:
        if (StringsKt.startsWith$default(r17, "mqq", false, 2, null) == false) goto L19;
        n(OpenAPPTYPE.QQ, r11);
        return;
    L19:
        if (Intrinsics.areEqual(r12.f(), Boolean.TRUE) == false) goto L31;
        OpenActionStatus r18 = OpenActionStatus.AFTER_OPEN;
        String r19 = r12.e();     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L26
        Intent r20 = new Intent("android.intent.action.VIEW", UriProtector.parse(r19));     // Catch: Throwable -> L26
        r20.addFlags(268435456);     // Catch: Throwable -> L26
        r20.addCategory("android.intent.category.BROWSABLE");     // Catch: Throwable -> L26
        Context r21 = r11.getContext();     // Catch: Throwable -> L26
        ResolveInfo r22 = r21.getPackageManager().resolveActivity(r20, 65536);     // Catch: Throwable -> L26
        if (r22 == null) goto L24;
        ActivityInfo r23 = r22.activityInfo;     // Catch: Throwable -> L26
        r20.setClassName(r23.packageName, r23.name);     // Catch: Throwable -> L26
        r21.startActivity(r20);     // Catch: Throwable -> L26
    L49:
    L30:
        o(r18, r12, r16);
        return;
    L24:
        r21.startActivity(r20);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        Throwable r25 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r25 == null) goto L30;
        r16 = r25.getMessage();
        goto L30
    L31:
        OpenActionStatus r26 = OpenActionStatus.AFTER_OPEN;
        w9.a r27 = w9.a.a;     // Catch: Throwable -> L41
        Context r28 = r11.getContext();     // Catch: Throwable -> L41
        Uri r29 = j(r12);     // Catch: Throwable -> L41
        View r30 = r11.d;     // Catch: Throwable -> L41
        Map<String, Object> r31 = r12.a();     // Catch: Throwable -> L41
        if (r31 == null) goto L35;
        JSONObject r32 = new JSONObject(r31);     // Catch: Throwable -> L41
    L36:
        if (r27.j0(r28, r29, r30, r32) == true) goto L45;
        r16 = "not schema handler";
    L45:
        o(r26, r12, r16);
        return;
    L35:
        r32 = null;
    L41:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        Throwable r34 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r34 == null) goto L45;
        r16 = r34.getMessage();
    L5:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void n(OpenAPPTYPE r10, CallContext r11) {
        int[] r0 = b.a;
        int r1 = r0[r10.ordinal()];
        if (r1 == 1) goto L7;
        if (r1 == 2) goto L6;
        String r12 = "";
    L8:
        int r13 = r0[r10.ordinal()];
        if (r13 == 1) goto L13;
        if (r13 == 2) goto L12;
        String r14 = "";
    L15:
        if (Intrinsics.areEqual(r12, "") == false) goto L19;
        x8.a.b("Annie_OpenJSBMethod", "Parameters invalid", false);
        OpenResultModel r15 = new OpenResultModel();
        r15.b("Parameters invalid");
        r15.a(OpenResultModel.Code.InvalidParam);
        finishWithResult(r15);
        return;
    L19:
        if (ita.k.h(r11.getContext(), r12) == true) goto L21;
        int r16 = x8.a.a;
        x8.a.b("Annie_OpenJSBMethod", r14.concat(" not installed"), false);
        OpenResultModel r17 = new OpenResultModel();
        r17.a(OpenResultModel.Code.Failed);
        r17.b(r14.concat(" not installed"));
        finishWithResult(r17);
    L21:
        Context r18 = r11.getContext();
        if (r18 != null) goto L24;
    L27:
        OpenResultModel r19 = new OpenResultModel();
        r19.a(OpenResultModel.Code.Success);
        r19.b("Success");
        finishWithResult(r19);
        return;
    L24:
        if (StringUtils.isEmpty(r12) == true) goto L27;
        Intent r20 = r18.getPackageManager().getLaunchIntentForPackage(r12);     // Catch: Exception -> L29
        r20.addFlags(268435456);     // Catch: Exception -> L29
        r18.startActivity(r20);     // Catch: Exception -> L29
        goto L27
    L12:
        r14 = "QQ";
        goto L15
    L13:
        r14 = "weixin";
        goto L15
    L6:
        r12 = "com.tencent.mobileqq";
        goto L8
    L7:
        r12 = "com.tencent.mm";
        goto L8
    }

    public final void o(OpenActionStatus r10, e7.n0 r11, String r12) {
        int r13 = b.b[r10.ordinal()];
        if (r13 == 1) goto L23;
        if (r13 != 2) goto L29;
        String r14 = m(r11);
        if (Intrinsics.areEqual(r14, "onlyCloseAfterOpenSucceed") == false) goto L17;
        if (r12 != null) goto L17;
        List<String> r0 = c;
        String r15 = r11.e();
        Intrinsics.checkNotNull(r15);
        String r16 = UriProtector.parse(r15).getHost();
        if (r16 != null) goto L14;
        r16 = "";
    L14:
        if (r0.contains(r16) == true) goto L17;
        l();
    L19:
        if (r12 != null) goto L21;
        finishWithSuccess();
        return;
    L21:
        finishWithFailure();
        return;
    L17:
        if (Intrinsics.areEqual(r14, "alwaysCloseAfterOpen") == false) goto L19;
        l();
        goto L19
    L29:
        return;
    L23:
        if (Intrinsics.areEqual(m(r11), "alwaysCloseBeforeOpen") == false) goto L28;
        l();
        return;
    }
}
