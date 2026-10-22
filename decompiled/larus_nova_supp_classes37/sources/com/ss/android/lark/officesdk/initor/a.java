package com.ss.android.lark.officesdk.initor;

import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.basic.v1.NetDecorator;
import com.ss.android.lark.framework.assembly.rust.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.HostUriParamGroup;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKHostAppHeaderProvider;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a implements c {
    public final IOfficeSDKConfigProvider a;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.initor.a$a, reason: collision with other inner class name */
    public static final class C0009a {
    }

    static {
    }

    @Inject
    public a(IOfficeSDKConfigProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "officeSDKConfigProvider");
        this.a = r2;
    }

    public final void interceptRustInitRequest(InitSDKRequest.Builder r11) {
        if (this.a.isDebug() == false) goto L5;
        r11.is_anydoor_enable(Boolean.TRUE);
        Log.i("DevRustInitIntercept", "AnyDoor enabled for OfficeSDK debug package");
    L5:
        String r0 = this.a.getAppId();
        if (r0 == null) goto L8;
        r11.app_id(r0);
    L8:
        String r1 = this.a.getHostAppVersion();
        boolean r2 = false;
        if (r1 != null) goto L11;
    L19:
        String r3 = this.a.getAppName();
        if (r3 == null) goto L31;
        if (r3.length() <= 0) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == false) goto L31;
        Map r5 = r11.customized_init_meta;
        if (r5 != null) goto L29;
        r5 = MapsKt.emptyMap();
    L29:
        Map r6 = MapsKt.toMutableMap(r5);
        r6.put("host_app_name", r3);
        r11.customized_init_meta(r6);
        goto L31
    L24:
        r4 = false;
    L31:
        if (this.a.isDebug() == false) goto L50;
        Object r7 = null;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L41
        String r9 = LarkContext.getApplication().getSharedPreferences("office_sdk_env_prefs", 0).getString("tt_env", "");     // Catch: Throwable -> L41
        if (r9 != null) goto L36;
    L38:
        r9 = null;
    L39:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L41
    L44:
        if (Result.isFailure-impl(r10) == true) goto L47;
        r7 = r10;
    L47:
        String r12 = (String) r7;
        if (r12 == null) goto L50;
        Log.i("DevRustInitIntercept", "use debug tt env from office sdk panel");
    L51:
        if (r12 == null) goto L53;
        r11.x_tt_env(r12);
    L53:
        Integer r13 = this.a.getEnv();
        if (r13 == null) goto L56;
        int r14 = r13.intValue();
        gpb.a r15 = (gpb.a) ApiUtils.getApi(gpb.a.class);
        r11.env_v2(new InitSDKRequest.EnvV2.Builder().type(InitSDKRequest.EnvV2.Type.fromValue(r14)).unit(r15.getUserUnit()).brand(r15.getTenantBrand()).build());
    L56:
        List<String> r16 = this.a.getJournalPaths();
        if ((!r16.isEmpty()) == false) goto L62;
        Map r17 = r11.customized_init_meta;
        if (r17 != null) goto L61;
        r17 = MapsKt.emptyMap();
    L61:
        Map r18 = MapsKt.toMutableMap(r17);
        r18.put("host_journal_paths", new JSONArray(r16).toString());
        r11.customized_init_meta(r18);
    L62:
        String r19 = this.a.getRequestTagBase();
        if (r19 == null) goto L74;
        String r20 = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.map(CollectionsKt.asSequence(StringsKt.split$default(r19, new String[]{";"}, false, 0, 6, null)), DevRustInitIntercept$toRequestTagInitMeta$1.INSTANCE), DevRustInitIntercept$toRequestTagInitMeta$2.INSTANCE));
        if (r20 == null) goto L74;
        if (r20.length() <= 0) goto L69;
        r2 = true;
    L69:
        if (r2 == false) goto L74;
        Map r21 = r11.customized_init_meta;
        if (r21 != null) goto L73;
        r21 = MapsKt.emptyMap();
    L73:
        Map r22 = MapsKt.toMutableMap(r21);
        r22.put(OfficeSDKRequestTag.INIT_META_KEY, r20);
        r11.customized_init_meta(r22);
        Log.i("DevRustInitIntercept", "request tag init meta applied");
    L74:
        Boolean r23 = this.a.isEnableNewTtnetLogReporter();
        if (r23 == null) goto L77;
        boolean r24 = r23.booleanValue();
        r11.enable_new_ttnet_log_reporter(Boolean.valueOf(r24));
        Log.i("DevRustInitIntercept", "enable_new_ttnet_log_reporter applied: " + r24);
    L77:
        IOfficeSDKHostAppHeaderProvider r25 = this.a.getHostAppHeaderProvider();
        if (r25 == null) goto L127;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L81
        Object r27 = Result.constructor-impl(r25.getOfficeSDKHeader());     // Catch: Throwable -> L81
    L84:
        if (Result.isSuccess-impl(r27) == false) goto L111;
        List r28 = (List) r27;
        Log.i("DevRustInitIntercept", "HostApp header groups fetched, count=" + r28.size());
        List r29 = r28;
        Iterator r30 = r29.iterator();
    L87:
        if (r30.hasNext() == false) goto L98;
        HostUriParamGroup r31 = (HostUriParamGroup) r30.next();
        Set<String> r32 = r31.getUris();
        if (r32 == null) goto L94;
        Iterator<T> r33 = r32.iterator();
    L92:
        if (r33.hasNext() == false) goto L94;
        Log.d("DevRustInitIntercept", "HostApp header init uri: " + ((String) r33.next()));
    L94:
        Iterator<Map.Entry<String, String>> r34 = r31.getParams().entrySet().iterator();
    L96:
        if (r34.hasNext() == false) goto L87;
        Log.d("DevRustInitIntercept", "HostApp header init param: " + r34.next());
        goto L96
    L98:
        ArrayList r35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator r36 = r29.iterator();
    L100:
        if (r36.hasNext() == false) goto L118;
        HostUriParamGroup r37 = (HostUriParamGroup) r36.next();
        Set<String> r38 = r37.getUris();
        if (r38 == null) goto L105;
        List r39 = CollectionsKt.toList(r38);
        if (r39 == null) goto L105;
    L106:
        r35.add(new NetDecorator.Builder().urls(r39).headers(r37.getParams()).build());
    L105:
        r39 = CollectionsKt.emptyList();
        goto L106
    L118:
        r11.net_decorators(r35);     // Catch: Throwable -> L109
        Log.i("DevRustInitIntercept", "net_decorators applied: groups=" + r35.size());     // Catch: Throwable -> L109
    L109:
        th = move-exception;
        Log.e("DevRustInitIntercept", "apply net_decorators failed", th);
    L111:
        Throwable r110 = Result.exceptionOrNull-impl(r27);
        if (r110 == null) goto L114;
        Log.e("DevRustInitIntercept", "fetch HostApp header groups failed", r110);
    L114:
        Result.box-impl(r27);
        return;
    L81:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L84
    L127:
        return;
    L36:
        if ((!StringsKt.isBlank(r9)) == false) goto L38;
    L41:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L50:
        r12 = this.a.getTTEnv();
        goto L51
    L11:
        if (r1.length() <= 0) goto L13;
        boolean r42 = true;
    L14:
        if (r42 == false) goto L19;
        Map r43 = r11.customized_init_meta;
        if (r43 != null) goto L18;
        r43 = MapsKt.emptyMap();
    L18:
        Map r44 = MapsKt.toMutableMap(r43);
        r44.put("host_app_version", r1);
        r11.customized_init_meta(r44);
        goto L19
    L13:
        r42 = false;
        goto L14
    }
}
