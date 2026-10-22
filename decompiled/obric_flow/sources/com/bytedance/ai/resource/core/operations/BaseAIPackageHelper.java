package com.bytedance.ai.resource.core.operations;

import ai.j0;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageConfig;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.AIPackageZipExtractor;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.e0;
import com.bytedance.ai.utils.c;
import i.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/operations/BaseAIPackageHelper;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BaseAIPackageHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AIPackageDeployment.AIPackageDeploymentItem f2696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackageManifestBean f2697b;

    public BaseAIPackageHelper(AIPackageDeployment.AIPackageDeploymentItem r5) {
        Intrinsics.checkNotNullParameter(r5, "deploymentInfo");
        this.f2696a = r5;
    }

    public final Object a(ContinuationImpl r10) {
        if ((r10 instanceof BaseAIPackageHelper$fetchManifest$1) == false) goto L7;
        BaseAIPackageHelper$fetchManifest$1 r5 = (BaseAIPackageHelper$fetchManifest$1) r10;
        int r11 = r5.f;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r5.d;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r5.f;
        if (r14 == 0) goto L22;
        if (r14 == 1) goto L19;
        if (r14 != 2) goto L18;
        AIPackageManifestBean.Companion r15 = r5.f2700c;
        BaseAIPackageHelper r16 = r5.f2699b;
        BaseAIPackageHelper r17 = r5.f2698a;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L15
    L33:
        r16.f2697b = r15.parseManifestJson((String) r12);     // Catch: Exception -> L15
        if (r17.f2697b == null) goto L41;
        String r18 = "packageName: " + r17.f2696a.getPackageName() + ", appId: " + r17.f2696a.getAppId() + " ===> Parsing the Manifest succeeds";     // Catch: Exception -> L15
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");     // Catch: Exception -> L15
        d r19 = c.f2846a;     // Catch: Exception -> L15
        if (r19 == null) goto L40;
        r19.d("AIPackageManager", r18);     // Catch: Exception -> L15
    L40:
        return r17.a(0, "");
    L41:
        String r20 = "packageName: " + r17.f2696a.getPackageName() + ", appId: " + r17.f2696a.getAppId() + " ===> Failed to parse Manifest";     // Catch: Exception -> L15
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");     // Catch: Exception -> L15
        d r110 = c.f2846a;     // Catch: Exception -> L15
        if (r110 == null) goto L45;
        r110.e("AIPackageManager", r20);     // Catch: Exception -> L15
    L45:
        return r17.a(6, "");
    L15:
        Exception e = e;
    L48:
        StringBuilder r111 = new StringBuilder("packageName: ");
        jm.c.f(r17.f2696a, r111, ", appId: ");
        r111.append(r17.f2696a.getAppId());
        r111.append(" ===> base_");
        r111.append(r17.f2696a.getVersionCode());
        r111.append(".zip failed : ");
        String r112 = a.h(e, r111, "AIPackageManager");
        d r21 = c.f2846a;
        if (r21 == null) goto L52;
        r21.e("AIPackageManager", r112);
    L52:
        return r17.a(1000, ExceptionsKt.stackTraceToString(e));
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        BaseAIPackageHelper this = r5.f2698a;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L46
    L26:
        AbsAIPackageOperation.Result r113 = (AbsAIPackageOperation.Result) r12;     // Catch: Exception -> L46
        if (r113.e == 0) goto L29;
        return r113;
    L29:
        AIPackageManifestBean.Companion r114 = AIPackageManifestBean.Companion;     // Catch: Exception -> L46
        r5.f2698a = this;     // Catch: Exception -> L46
        r5.f2699b = this;     // Catch: Exception -> L46
        r5.f2700c = r114;     // Catch: Exception -> L46
        r5.f = 2;     // Catch: Exception -> L46
        Object r22 = this.a(r5);     // Catch: Exception -> L46
        if (r22 != r13) goto L32;
    L31:
        return r13;
    L32:
        r16 = this;
        r15 = r114;
        r12 = r22;
        r17 = r16;
        goto L33
    L22:
        ResultKt.throwOnFailure(r12);
        AIPackageDeployment.AIPackageDeploymentItem r115 = this.f2696a;     // Catch: Exception -> L46
        r5.f2698a = this;     // Catch: Exception -> L46
        r5.f = 1;     // Catch: Exception -> L46
        r12 = a(r115, r5);     // Catch: Exception -> L46
        if (r12 != r13) goto L26;
    L46:
        e = move-exception;
        BaseAIPackageHelper r116 = this;
        e = e;
        r17 = r116;
    L7:
        r5 = new BaseAIPackageHelper$fetchManifest$1(this, r10);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x02d9 -> B:89:0x02df). Please report as a decompilation issue!!! */
    public final Object a(AIPackageDeployment.AIPackageDeploymentItem r21, ContinuationImpl r22) {
        BaseAIPackageHelper r5 = this;
        if ((r22 instanceof BaseAIPackageHelper$installBasePackage$1) == false) goto L7;
        BaseAIPackageHelper$installBasePackage$1 r10 = (BaseAIPackageHelper$installBasePackage$1) r22;
        int r11 = r10.f;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.f = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.d;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.f;
        String r15 = "deploymentInfo";
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        Iterator r16 = r10.f2703c;
        String r17 = r10.f2702b;
        BaseAIPackageHelper r18 = r10.f2701a;
        ResultKt.throwOnFailure(r12);
        String r19 = "deploymentInfo";
        r13 = r13;
        BaseAIPackageHelper$installBasePackage$1 r20 = r10;
        Iterator r23 = r16;
        r5 = r18;
        String r24 = "/base_";
    L89:
        boolean r25 = ((Boolean) r12).booleanValue();
        if (r25 == false) goto L92;
        boolean r26 = r25;
    L93:
        if (r26 == true) goto L99;
        StringBuilder r27 = new StringBuilder("packageName: ");
        jm.c.f(r5.f2696a, r27, ", appId: ");
        r27.append(r5.f2696a.getAppId());
        r27.append(" ===> Failed to download ");
        r27.append(r17);
        String r28 = r27.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r29 = c.f2846a;
        if (r29 == null) goto L98;
        r29.e("AIPackageManager", r28);
    L98:
        return r5.a(2, "");
    L99:
        String r30 = "";
        String r31 = AIPackageConfig.f2571a;
        AIPackageDeployment.AIPackageDeploymentItem r32 = r5.f2696a;
        Intrinsics.checkNotNullParameter(r32, r19);
        StringBuilder r33 = new StringBuilder();
        r33.append(AIPackageConfig.f2571a);
        r33.append('/');
        jm.c.f(r32, r33, r24);
        r33.append(r32.getVersionCode());
        if (AIPackageZipExtractor.b(r17, r33.toString()) == true) goto L109;
        StringBuilder r34 = new StringBuilder("packageName: ");
        jm.c.f(r5.f2696a, r34, ", appId: ");
        r34.append(r5.f2696a.getAppId());
        r34.append(" ===> Failed to unzip ");
        r34.append(r17);
        String r35 = r34.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r36 = c.f2846a;
        if (r36 == null) goto L105;
        r36.e("AIPackageManager", r35);
    L105:
        return r5.a(11, r30);
    L109:
        return r5.a(0, r30);
    L92:
        BaseAIPackageHelper$installBasePackage$1 r110 = r20;
        r26 = r25;
        Iterator r37 = r23;
        BaseAIPackageHelper$installBasePackage$1 r38 = r110;
    L49:
        if (r37.hasNext() == false) goto L93;
        String r39 = (String) r37.next();
        r38.f2701a = r5;
        r38.f2702b = r17;
        r38.f2703c = r37;
        r38.f = 1;
        r5.getClass();
        if (r39.length() != 0) goto L54;
    L55:
        StringBuilder r40 = new StringBuilder("packageName: ");
        jm.c.f(r5.f2696a, r40, ", appId: ");
        r40.append(r5.f2696a.getAppId());
        r40.append(" ===> The download url and destination file are empty");
        String r41 = r40.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r42 = c.f2846a;
        if (r42 == null) goto L58;
        r42.e("AIPackageManager", r41);
    L58:
        Boolean r43 = Boxing.boxBoolean(false);
    L59:
        Object r44 = r43;
    L86:
        if (r44 != r13) goto L88;
        return r13;
    L88:
        BaseAIPackageHelper$installBasePackage$1 r111 = r38;
        r23 = r37;
        r12 = r44;
        r20 = r111;
        goto L89
    L54:
        if (r17.length() == 0) goto L55;
        StringBuilder r45 = new StringBuilder("packageName: ");
        jm.c.f(r5.f2696a, r45, ", appId: ");
        r45.append(r5.f2696a.getAppId());
        r45.append(" ===> Start downloading ");
        r45.append(r17);
        String r46 = r45.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r112 = c.f2846a;
        if (r112 == null) goto L64;
        r112.i("AIPackageManager", r46);
    L64:
        String r47 = AIPackageConfig.f2571a;
        String r48 = r5.f2696a.getPackageName();
        Intrinsics.checkNotNullParameter(r48, "packageName");
        String r49 = AIPackageConfig.f2571a + '/' + r48;
        Intrinsics.checkNotNullParameter(r49, "<this>");
        File r113 = new File(r49);
        if (r113.exists() == true) goto L68;
        r113.mkdirs();
    L68:
        if (TextUtils.isEmpty(r17) == false) goto L70;
        boolean r114 = false;
    L71:
        if (r114 == false) goto L73;
    L82:
        StringBuilder r50 = new StringBuilder("packageName: ");
        jm.c.f(r5.f2696a, r50, ", appId: ");
        r50.append(r5.f2696a.getAppId());
        r50.append(" ===> The ");
        r50.append(r17);
        r50.append(" already exists");
        String r51 = r50.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r52 = c.f2846a;
        if (r52 == null) goto L85;
        r52.d("AIPackageManager", r51);
    L85:
        r44 = Boxing.boxBoolean(true);
        goto L86
    L73:
        if (c.m(r17, r5.f2696a.getPackageName()) == true) goto L82;
        if (r5.f2696a.getBuildInPackage() == false) goto L81;
        StringBuilder r53 = new StringBuilder("packageName: ");
        jm.c.f(r5.f2696a, r53, ", appId: ");
        r53.append(r5.f2696a.getAppId());
        r53.append(" ===> Built-in asset ");
        r53.append(r17);
        r53.append(" does not exist");
        String r54 = r53.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r55 = c.f2846a;
        if (r55 == null) goto L80;
        r55.e("AIPackageManager", r54);
    L80:
        r43 = Boxing.boxBoolean(false);
        goto L59
    L81:
        r44 = a.g(r39, r49, r38);
        goto L86
    L70:
        r114 = new File(r17).exists();
        goto L71
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        String r56 = AIPackageConfig.f2571a;
        Intrinsics.checkNotNullParameter(r21, "deploymentInfo");
        StringBuilder r57 = new StringBuilder();
        r57.append(AIPackageConfig.f2571a);
        r57.append('/');
        jm.c.f(r21, r57, "/base_");
        r24 = "/base_";
        r57.append(r21.getVersionCode());
        r57.append("/base/manifest.json");
        String r58 = r57.toString();
        if (TextUtils.isEmpty(r58) == false) goto L17;
        boolean r59 = false;
    L18:
        if (r59 == true) goto L107;
        StringBuilder r60 = new StringBuilder("packageName: ");
        jm.c.f(r5.f2696a, r60, ", appId: ");
        r60.append(r5.f2696a.getAppId());
        r60.append(" ===> ");
        r60.append(r58);
        r60.append(" does not exist");
        String r61 = r60.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r62 = c.f2846a;
        if (r62 == null) goto L22;
        r62.d("AIPackageManager", r61);
    L22:
        LruCache r63 = e0.f2711a;
        AIPackageDeployment.AIPackageDeploymentItem r64 = r5.f2696a;
        Intrinsics.checkNotNullParameter(r64, "<this>");
        ArrayList r65 = new ArrayList();
        List<String> r66 = r64.getResourceUrls();
        if (r66 != null) goto L25;
    L26:
        BaseAIPackageHelper$installBasePackage$1 r115 = r10;
        r19 = "deploymentInfo";
        if (r64.getResourceUrl().length() <= 0) goto L47;
        u0.a r67 = s0.a.f21800c;
        if (r67 == null) goto L40;
        boolean r68 = true;
        if (r67.f22203n == true) goto L44;
    L41:
        if (r67 != null) goto L43;
    L45:
        String r69 = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source";
    L46:
        r65.add(r69 + '/' + r64.getResourceUrl().substring(0, StringsKt.u(r64.getResourceUrl(), "/")) + r24 + r64.getVersionCode() + ".zip");
        goto L47
    L43:
        if (r67.f22205p != r68) goto L45;
    L44:
        r69 = "https://tosv.byted.org/obj/gecko-internal";
        goto L46
    L40:
        r68 = true;
    L47:
        String r70 = AIPackageConfig.f2571a;
        r17 = AIPackageConfig.a(r5.f2696a);
        r37 = r65.iterator();
        r38 = r115;
        r26 = false;
        goto L49
    L25:
        if (r66.isEmpty() == true) goto L26;
        Iterator r71 = r66.iterator();
    L29:
        if (r71.hasNext() == false) goto L31;
        BaseAIPackageHelper$installBasePackage$1 r116 = r10;
        String r72 = (String) r71.next();
        StringBuilder r73 = j0.w(r72.substring(0, StringsKt.u(r72, "/")), r24);
        r73.append(r64.getVersionCode());
        r73.append(".zip");
        r65.add(0, r73.toString());
        r71 = r71;
        r15 = r15;
        r10 = r116;
        goto L29
    L31:
        r115 = r10;
        r19 = r15;
        goto L47
    L107:
        r30 = "";
        goto L109
    L17:
        r59 = new File(r58).exists();
    L7:
        r10 = new BaseAIPackageHelper$installBasePackage$1(r5, r22);
        goto L8
    }

    public final Object a(Continuation r12) {
        AIPackageDeployment.AIPackageDeploymentItem r5 = this.f2696a;
        final SafeContinuation r10 = new SafeContinuation(IntrinsicsKt.intercepted(r12));
        LruCache r11 = e0.f2711a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        e0.k("", e0.f(r5.getPackageName(), "base", "base_" + r5.getVersionCode() + "/base", "manifest.json", 0, null), new BaseAIPackageHelper$readManifestData$3$1(r10), new BaseAIPackageHelper$readManifestData$3$2(this, r10), true);
        Object r13 = r10.getOrThrow();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L5:
        return r13;
    }

    public final AbsAIPackageOperation.Result a(int r10, String r11) {
        return new AbsAIPackageOperation.Result(null, this.f2696a.getPackageName(), this.f2696a.getAppId(), AIPackage.AIPackageType.f2281c, r10, r11);
    }
}
