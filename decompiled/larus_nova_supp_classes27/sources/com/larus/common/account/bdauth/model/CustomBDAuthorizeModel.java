package com.larus.common.account.bdauth.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.applog.api.IApplog;
import com.larus.common.account.bdauth.api.AuthorizeApiOrigin;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;
import za7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class CustomBDAuthorizeModel implements vz8.a {
    public final Context a;
    public final String b;
    public final String c;
    public final String d;
    public final Lazy e;

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.model.CustomBDAuthorizeModel$registerNewUser$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.account.bdauth.model.CustomBDAuthorizeModel", f = "CustomBDAuthorizeModel.kt", i = {}, l = {79}, m = "registerNewUser", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CustomBDAuthorizeModel this$0;

        public AnonymousClass1(CustomBDAuthorizeModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.registerNewUser(this);
        }
    }

    public final Context getContext() {
        return this.a;
    }

    public CustomBDAuthorizeModel(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = "CustomBDAuthorizeModel";
        this.c = "/passport/open/auth_info/v2/";
        this.d = "/passport/open/auth/";
        this.e = LazyKt.lazy(new b());
    }

    @Override // vz8.a
    public final Object registerNewUser(Continuation<? super Boolean> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L30
    L19:
        String r8 = (String) r7;     // Catch: Throwable -> L30
        if (r8 != null) goto L22;
    L25:
        if (r4 == false) goto L29;
        return Boxing.boxBoolean(false);
    L29:
        return Boxing.boxBoolean(Intrinsics.areEqual(FlowDoraConnectReason.SUCCESS, new JSONObject(r8).optString("message")));
    L22:
        if (r8.length() == 0) goto L25;
        r4 = false;
        goto L25
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        AuthorizeApiOrigin r9 = (AuthorizeApiOrigin) this.e.getValue();     // Catch: Throwable -> L30
        r0.label = 1;     // Catch: Throwable -> L30
        r7 = r9.registerNewUser(r0);     // Catch: Throwable -> L30
        if (r7 != r2) goto L19;
        return r2;
    L31:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }

    @Override // vz8.a
    public final Object a(fb7.c r9, Continuation r10) {
        if ((r10 instanceof CustomBDAuthorizeModel$requestGetAuthInfoV2$1) == false) goto L7;
        CustomBDAuthorizeModel$requestGetAuthInfoV2$1 r0 = (CustomBDAuthorizeModel$requestGetAuthInfoV2$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = "";
        int r5 = -1;
        boolean r6 = true;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Ref.ObjectRef r12 = (Ref.ObjectRef) r0.L$1;
        fb7.c r7 = (fb7.c) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
    L50:
        String r13 = (String) r11;     // Catch: Throwable -> L14
        if (r13 == null) goto L57;
        r12.element = ya7.a.a(r13);     // Catch: Throwable -> L14
    L57:
        Object r14 = r12.element;
        String r8 = "fail";
        if (r14 != null) goto L60;
        r4 = this.a.getString(2131894449);
    L70:
        IApplog.Companion r15 = IApplog.a;
        JSONObject r16 = new JSONObject();
        r16.put("code", r5);
        r16.put("path", this.c);
        r16.put("msg", r4);
        Unit r17 = Unit.INSTANCE;
        r15.reportEvent("flow_request_event", r16);
        FLogger.a.i(this.b, "requestGetAuthInfoV2 code=" + r5 + ", msg=" + r4);
        c(r7, r8, r5, r4);
        return r12.element;
    L60:
        za7.c r18 = (za7.c) r14;
        r5 = 0;
        if (((d) r18).a == true) goto L64;
        r6 = false;
    L64:
        if (r6 == true) goto L69;
        r5 = ((d) r18).b;
        String r110 = ((d) r18).c;
        if (r110 == null) goto L70;
        r4 = r110;
        goto L70
    L69:
        r8 = FlowDoraConnectReason.SUCCESS;
    L14:
        th = th;
        Ref.ObjectRef r20 = r12;
        r9 = r7;
    L56:
        th.printStackTrace();
        za7.c r21 = new za7.c();
        r20.element = r21;
        int r22 = xz8.b.a;
        ((d) r21).b = xz8.b.a.a(th);
        r7 = r9;
        r12 = r20;
        goto L57
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        String r111 = null;
        if (TextUtils.isEmpty(null) == false) goto L38;
        StringBuilder r112 = new StringBuilder();
        r112.append(r9.g);
        if (TextUtils.isEmpty(r9.h) == true) goto L30;
        if (r112.length() > 0) goto L26;
    L28:
        r112.append(r9.h);
        goto L30
    L26:
        if (r112.charAt(r112.length() - 1) == ',') goto L28;
        r112.append(",");
    L30:
        if (TextUtils.isEmpty(r9.i) == false) goto L32;
    L37:
        r111 = r112.toString();
        goto L38
    L32:
        if (r112.length() > 0) goto L34;
    L36:
        r112.append(r9.i);
        goto L37
    L34:
        if (r112.charAt(r112.length() - 1) == ',') goto L36;
        r112.append(",");
    L38:
        r20 = new Ref.ObjectRef();
        AuthorizeApiOrigin r23 = (AuthorizeApiOrigin) this.e.getValue();     // Catch: Throwable -> L55
        if (r9 == null) goto L43;
        String r24 = r9.e;     // Catch: Throwable -> L55
        if (r24 == null) goto L43;
    L44:
        if (r111 != null) goto L46;
        r111 = "";
    L46:
        r0.L$0 = r9;     // Catch: Throwable -> L55
        r0.L$1 = r20;     // Catch: Throwable -> L55
        r0.label = 1;     // Catch: Throwable -> L55
        r11 = r23.getAuthInfo(r24, r111, r0);     // Catch: Throwable -> L55
        if (r11 != r2) goto L49;
        return r2;
    L49:
        r7 = r9;
        r12 = r20;
    L43:
        r24 = "";
    L55:
        th = th;
    L7:
        r0 = new CustomBDAuthorizeModel$requestGetAuthInfoV2$1(this, r10);
        goto L8
    }

    public static void c(fb7.c r2, String r3, int r4, String r5) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L7
        if (r2 == null) goto L5;
        r0.put("client_key", r2.e);     // Catch: JSONException -> L7
    L5:
        r0.put("sdk_version", 7);     // Catch: JSONException -> L7
        r0.put("params_for_special", "uc_login");     // Catch: JSONException -> L7
    L9:
        if (r0 != null) goto L11;
        r0 = new JSONObject();     // Catch: JSONException -> L16
    L11:
        r0.put("result", r3);     // Catch: JSONException -> L16
        r0.put("errCode", r4);     // Catch: JSONException -> L16
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r0.put("errDesc", r5);     // Catch: JSONException -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L16
        r0 = null;
        goto L9
    }

    @Override // vz8.a
    public final Object b(fb7.c r17, String r18, Map r110, Continuation r20) {
        fb7.c r2 = r17;
        if ((r20 instanceof CustomBDAuthorizeModel$requestGetAuthCodeV2$1) == false) goto L7;
        CustomBDAuthorizeModel$requestGetAuthCodeV2$1 r3 = (CustomBDAuthorizeModel$requestGetAuthCodeV2$1) r20;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        int r8 = 0;
        String r10 = "";
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        Ref.ObjectRef r9 = (Ref.ObjectRef) r3.L$1;
        fb7.c r11 = (fb7.c) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14
        Ref.ObjectRef r12 = r9;
        r2 = r11;
    L128:
        String r1 = (String) r0;     // Catch: Throwable -> L142
        if (r1 == null) goto L145;
        za7.a r13 = new za7.a();     // Catch: Throwable -> L142
        ya7.a.b(r13, r1);     // Catch: Exception -> L138 Throwable -> L142
        if (((d) r13).a == false) goto L166;
        JSONObject r14 = ((d) r13).d;     // Catch: Exception -> L138 Throwable -> L142
        if (r14 == null) goto L136;
        r13.e = r14.optString("code");     // Catch: Exception -> L138 Throwable -> L142
        goto L166
    L136:
        ((d) r13).b = -1;     // Catch: Exception -> L138 Throwable -> L142
    L166:
    L140:
        r12.element = r13;     // Catch: Throwable -> L142
        goto L145
    L138:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L142
    L142:
        Throwable th = th;
        r11 = r2;
        r9 = r12;
    L144:
        za7.a r15 = new za7.a();
        r9.element = r15;
        int r16 = xz8.b.a;
        ((d) r15).b = xz8.b.a.a(th);
        r12 = r9;
        r2 = r11;
    L145:
        Object r21 = r12.element;
        String r22 = "fail";
        if (r21 != null) goto L148;
        r10 = this.a.getString(2131894449);
        r8 = -1;
    L158:
        IApplog.Companion r23 = IApplog.a;
        JSONObject r24 = new JSONObject();
        r24.put("code", r8);
        r24.put("path", this.d);
        r24.put("msg", r10);
        Unit r25 = Unit.INSTANCE;
        r23.reportEvent("flow_request_event", r24);
        FLogger.a.i(this.b, "requestGetAuthInfoV2 code=" + r8 + ", msg=" + r10);
        c(r2, r22, r8, r10);
        return r12.element;
    L148:
        za7.a r26 = (za7.a) r21;
        if (((d) r26).a == true) goto L152;
        r7 = false;
    L152:
        if (r7 == true) goto L157;
        r8 = ((d) r26).b;
        String r27 = ((d) r26).c;
        if (r27 == null) goto L158;
        r10 = r27;
        goto L158
    L157:
        r22 = FlowDoraConnectReason.SUCCESS;
    L14:
        th = th;
        goto L144
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        if (TextUtils.isEmpty(r18) == true) goto L23;
        if (r18 == null) goto L26;
        String r28 = r18;
    L27:
        Context r30 = this.a;
        if (r2 == null) goto L31;
        String r111 = ((fb7.a) r2).a;
        if (r111 == null) goto L31;
    L32:
        String r112 = null;
        if (TextUtils.isEmpty(r111) == false) goto L164;
    L42:
        ArrayList r113 = null;
    L43:
        HashMap r31 = new HashMap();
        if (r2 == null) goto L47;
        String r114 = r2.e;
        if (r114 == null) goto L47;
    L48:
        r31.put("client_key", r114);
        r31.put("response_type", "code");
        r31.put("source", "native");
        r31.put("scope", r28);
        if (r2 == null) goto L51;
        String r32 = r2.f;
    L53:
        if (TextUtils.isEmpty(r32) == true) goto L59;
        if (r2 == null) goto L57;
        String r33 = r2.f;
        if (r33 == null) goto L57;
    L58:
        r31.put("from", r33);
    L57:
        r33 = "";
    L59:
        if (r2 == null) goto L61;
        String r34 = r2.f;
    L63:
        if (TextUtils.equals("wap_to_native", r34) == false) goto L74;
        if (r2 == null) goto L66;
        String r35 = r2.d;
    L68:
        if (TextUtils.isEmpty(r35) == true) goto L74;
        if (r2 == null) goto L72;
        String r36 = r2.d;
        if (r36 == null) goto L72;
    L73:
        r31.put("redirect_uri", r36);
    L72:
        r36 = "";
        goto L73
    L66:
        r35 = null;
    L74:
        if (r2 == null) goto L76;
        String r37 = r2.c;
    L78:
        if (TextUtils.isEmpty(r37) == true) goto L84;
        if (r2 == null) goto L82;
        String r38 = r2.c;
        if (r38 == null) goto L82;
    L83:
        r31.put("state", r38);
    L82:
        r38 = "";
    L84:
        if (r2 == null) goto L86;
        String r40 = ((fb7.a) r2).a;
    L88:
        if (TextUtils.isEmpty(r40) == true) goto L98;
        if (r2 == null) goto L92;
        String r41 = ((fb7.a) r2).a;
        if (r41 == null) goto L92;
    L169:
        String r42 = gb7.a.a(r41.getBytes());     // Catch: Exception -> L95
    L97:
        r31.put("app_identity", r42);
    L95:
        e = move-exception;
        e.printStackTrace();
        r42 = null;
    L92:
        r41 = "";
    L98:
        if (r113 == null) goto L109;
        if (r113.isEmpty() == true) goto L109;
        StringBuilder r43 = new StringBuilder();
        int r115 = 0;
    L103:
        if (r115 >= r113.size()) goto L107;
        if (r115 == 0) goto L106;
        r43.append(",");
    L106:
        r43.append((String) ListProtector.get(r113, r115));
        r115 = r115 + 1;
        goto L103
    L107:
        r112 = r43.toString();
    L109:
        if (TextUtils.isEmpty(r112) == true) goto L111;
        r31.put("signature", r112);
        r31.put("sign", r112);
    L111:
        if (r110 == null) goto L124;
        Iterator r44 = r110.entrySet().iterator();
    L114:
        if (r44.hasNext() == false) goto L124;
        Map.Entry r116 = (Map.Entry) r44.next();
        String r117 = (String) r116.getKey();
        String r118 = (String) r116.getValue();
        if (TextUtils.isEmpty(r117) == true) goto L114;
        if (TextUtils.isEmpty(r118) == true) goto L114;
        if (r117 != null) goto L121;
        r117 = "";
    L121:
        if (r118 != null) goto L123;
        r118 = "";
    L123:
        r31.put(r117, r118);
    L124:
        r12 = new Ref.ObjectRef();
        AuthorizeApiOrigin r45 = (AuthorizeApiOrigin) this.e.getValue();     // Catch: Throwable -> L142
        r3.L$0 = r2;     // Catch: Throwable -> L142
        r3.L$1 = r12;     // Catch: Throwable -> L142
        r3.label = 1;     // Catch: Throwable -> L142
        r0 = r45.getAuthCode(r31, r3);     // Catch: Throwable -> L142
        if (r0 != r5) goto L128;
        return r5;
    L86:
        r40 = null;
        goto L88
    L76:
        r37 = null;
        goto L78
    L61:
        r34 = null;
        goto L63
    L51:
        r32 = null;
    L47:
        r114 = "";
        goto L48
    L164:
        PackageInfo r46 = r30.getPackageManager().getPackageInfo(r111, 64);     // Catch: PackageManager.NameNotFoundException -> L41
        r113 = new ArrayList();
        Signature[] r47 = r46.signatures;
        if (r47 == null) goto L42;
        int r119 = r47.length;
        int r120 = 0;
    L39:
        if (r120 >= r119) goto L43;
        r113.add(gb7.a.a(r47[r120].toByteArray()));
        r120 = r120 + 1;
    L31:
        r111 = "";
    L26:
        r28 = "";
        goto L27
    L23:
        if (r2 == null) goto L26;
        r28 = r2.g;
        if (r28 != null) goto L27;
    L7:
        r3 = new CustomBDAuthorizeModel$requestGetAuthCodeV2$1(this, r20);
        goto L8
    }
}
