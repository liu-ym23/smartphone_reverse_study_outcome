package com.bytedance.ai.resource.core.operations;

import android.content.Context;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.security.c;
import com.bytedance.ai.resource.security.e;
import com.bytedance.ai.resource.security.h;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BaseAIPackageHelper {
    public final AIPackageDeployment.AIPackageDeploymentItem a;
    public AIPackageManifestBean b;

    public final boolean b() {
        h2.a r0 = f2.b.c;
        if (r0 == null) goto L34;
        Context r1 = r0.a;
        if (r1 == null) goto L34;
        long r10 = this.a.getVersionCode();
        c r11 = c.a;
        String r12 = this.a.getPackageName();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "packageName");
        Object r13 = null;
        String r14 = ((Keva) c.b.getValue()).getString(c.b(r12, r10), null);
        if (r14 != null) goto L10;
    L13:
        boolean r15 = true;
    L15:
        if ((!r15) == true) goto L17;
    L19:
        String r16 = com.bytedance.ai.resource.core.a.c(this.a);
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L22
        Object r18 = Result.constructor-impl(FilesKt.readBytes(new PolarisFileWrapper(r16)));     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r18) == true) goto L28;
        r13 = r18;
    L28:
        byte[] r19 = (byte[]) r13;
        if (r19 != null) goto L32;
        g.a.e("AIPackageManager", "BundleStore is NULL");
        return false;
    L32:
        e r20 = e.a;
        String r21 = this.a.getPackageName();
        r20.getClass();
        return e.a(r1, r21, r10, r19);
    L22:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L17:
        if (c.c(r1, this.a.getPackageName(), r10) == null) goto L19;
        return true;
    L10:
        if (r14.length() == 0) goto L13;
        r15 = false;
    L34:
        return false;
    }

    public BaseAIPackageHelper(AIPackageDeployment.AIPackageDeploymentItem r10) {
        Intrinsics.checkNotNullParameter(r10, "deploymentInfo");
        this.a = r10;
    }

    public final Object c(Continuation<? super AbsAIPackageOperation.a> r10) {
        if ((r10 instanceof BaseAIPackageHelper$fetchManifest$1) == false) goto L7;
        BaseAIPackageHelper$fetchManifest$1 r0 = (BaseAIPackageHelper$fetchManifest$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        int r14 = 1;
        if (r13 == 0) goto L18;
        if (r13 == 1) goto L16;
        if (r13 != 2) goto L15;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L34
    L28:
        String r15 = (String) r11;     // Catch: Exception -> L34
        if (f(r15) == false) goto L33;
        String r16 = com.bytedance.ai.resource.core.a.a;     // Catch: Exception -> L34
        boolean r17 = new PolarisFileWrapper(com.bytedance.ai.resource.core.a.c(this.a)).exists();     // Catch: Exception -> L34
        if (r17 == true) goto L39;
    L42:
        AIPackageManifestBean r18 = AIPackageManifestBean.Companion.parseManifestJson(r15);     // Catch: Exception -> L34
        this.b = r18;     // Catch: Exception -> L34
        if (r18 == null) goto L48;
        if (r17 == false) goto L46;
        int r19 = 1;
    L47:
        r18.setHasKeyStore(r19);     // Catch: Exception -> L34
        goto L48
    L46:
        r19 = 0;
    L48:
        AIPackageManifestBean r20 = this.b;     // Catch: Exception -> L34
        if (r20 == null) goto L56;
        if (Intrinsics.areEqual(this.a.getVerifySignature(), Boxing.boxBoolean(true)) == true) goto L54;
        r14 = 0;
    L54:
        r20.setVerifySignature(r14);     // Catch: Exception -> L34
    L56:
        if (this.b == null) goto L58;
        g.a.d("AIPackageManager", "packageName: " + this.a.getPackageName() + ", appId: " + this.a.getAppId() + " ===> Parsing the Manifest succeeds");     // Catch: Exception -> L34
        return a(0, "");
    L58:
        g.a.e("AIPackageManager", "packageName: " + this.a.getPackageName() + ", appId: " + this.a.getAppId() + " ===> Failed to parse Manifest");     // Catch: Exception -> L34
        return a(6, "");
    L39:
        if (b() == true) goto L42;
        return a(15, "");
    L33:
        return a(14, "");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L34
    L22:
        AbsAIPackageOperation.a r21 = (AbsAIPackageOperation.a) r11;     // Catch: Exception -> L34
        if (r21.e == 0) goto L25;
        return r21;
    L25:
        r0.label = 2;     // Catch: Exception -> L34
        r11 = e(r0);     // Catch: Exception -> L34
        if (r11 != r12) goto L28;
        return r12;
    L18:
        ResultKt.throwOnFailure(r11);
        AIPackageDeployment.AIPackageDeploymentItem r22 = this.a;     // Catch: Exception -> L34
        r0.label = 1;     // Catch: Exception -> L34
        r11 = d(r22, r0);     // Catch: Exception -> L34
        if (r11 != r12) goto L22;
        return r12;
    L34:
        e = move-exception;
        g.a.e("AIPackageManager", "packageName: " + this.a.getPackageName() + ", appId: " + this.a.getAppId() + " ===> base_" + this.a.getVersionCode() + ".zip failed : " + ExceptionsKt.stackTraceToString(e));
        return a(IServerListener.WHAT_BYTELINK_SINK_ERROR, ExceptionsKt.stackTraceToString(e));
    L7:
        r0 = new BaseAIPackageHelper$fetchManifest$1(this, r10);
        goto L8
    }

    public final Object e(Continuation<? super String> r11) {
        AIPackageDeployment.AIPackageDeploymentItem r0 = this.a;
        j r1 = new j(IntrinsicsKt.intercepted(r11), 1);
        r1.C();
        AtomicReference r10 = new AtomicReference(r1);
        r1.i(new b(r10));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r1.getContext()), com.bytedance.ai.infra.thread_pool.b.a, null, new BaseAIPackageHelper$readManifestData$3$2(r0, r10, this, null), 2, null);
        Object r12 = r1.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L5:
        return r12;
    }

    public final boolean f(String r11) {
        Boolean r0 = this.a.getVerifySignature();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L16;
        String r10 = com.bytedance.ai.resource.core.a.a;
        AIPackageDeployment.AIPackageDeploymentItem r12 = this.a;
        Intrinsics.checkNotNullParameter(r12, "deploymentInfo");
        PolarisFileWrapper r13 = new PolarisFileWrapper(com.bytedance.ai.resource.core.a.a + '/' + r12.getPackageName() + "/base_" + r12.getVersionCode() + "/base/manifest.sign");
        if (r13.exists() == false) goto L14;
        h r14 = h.a;
        String r15 = this.a.getPackageName();
        long r16 = this.a.getVersionCode();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "packageName");
        if (Intrinsics.areEqual(h.b.get(r15 + '_' + r16), r1) == false) goto L17;
        return true;
    L17:
        e r17 = e.a;     // Catch: Exception -> L11
        String r18 = this.a.getPackageName();     // Catch: Exception -> L11
        byte[] r19 = FilesKt.readBytes(r13);     // Catch: Exception -> L11
        long r20 = this.a.getVersionCode();     // Catch: Exception -> L11
        r17.getClass();     // Catch: Exception -> L11
        return e.f(r18, r11, r19, r20);
    L11:
        e = move-exception;
        g.a.e("AIPackageManager", "read signFile error: " + e);
        return false;
    L14:
        g.a.e("AIPackageManager", "manifest.sign is NOT existed");
        return false;
    L16:
        return true;
    }

    public final AbsAIPackageOperation.a a(int r10, String r11) {
        return new AbsAIPackageOperation.a(null, this.a.getPackageName(), this.a.getAppId(), AIPackage.AIPackageType.UNKNOWN, r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0262 -> B:61:0x026a). Please report as a decompilation issue!!! */
    public final Object d(AIPackageDeployment.AIPackageDeploymentItem r25, Continuation<? super AbsAIPackageOperation.a> r26) {
        if ((r26 instanceof BaseAIPackageHelper$installBasePackage$1) == false) goto L7;
        BaseAIPackageHelper$installBasePackage$1 r10 = (BaseAIPackageHelper$installBasePackage$1) r26;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r1 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        String r14 = "";
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        Iterator r15 = (Iterator) r10.L$1;
        String r16 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
        Iterator r17 = r15;
        String r18 = "";
        Object r19 = r12;
        BaseAIPackageHelper$installBasePackage$1 r20 = r10;
        BaseAIPackageHelper r21 = this;
    L61:
        boolean r22 = ((Boolean) r1).booleanValue();
        if (r22 == false) goto L64;
        boolean r23 = r22;
        BaseAIPackageHelper r24 = r21;
    L65:
        if (r23 == true) goto L68;
        g.a.e("AIPackageManager", "packageName: " + r24.a.getPackageName() + ", appId: " + r24.a.getAppId() + " ===> Failed to download " + r16);
        return r24.a(2, r18);
    L68:
        String r27 = r18;
        String r28 = com.bytedance.ai.resource.core.a.a;
        if (com.bytedance.ai.resource.core.e.b(r16, com.bytedance.ai.resource.core.a.a(r24.a)) == true) goto L74;
        g.a.e("AIPackageManager", "packageName: " + r24.a.getPackageName() + ", appId: " + r24.a.getAppId() + " ===> Failed to unzip " + r16);
        return r24.a(11, r27);
    L74:
        return r24.a(0, r27);
    L64:
        Iterator r29 = r17;
        r23 = r22;
        r24 = r21;
        r10 = r20;
        r12 = r19;
        Iterator r30 = r29;
    L38:
        if (r30.hasNext() == false) goto L65;
        String r31 = (String) r30.next();
        r10.L$0 = r16;
        r10.L$1 = r30;
        r10.label = 1;
        if (r31.length() != 0) goto L42;
        boolean r32 = true;
    L43:
        if (r32 == false) goto L45;
    L57:
        g.a.e("AIPackageManager", "packageName: " + r24.a.getPackageName() + ", appId: " + r24.a.getAppId() + " ===> The download url and destination file are empty");
        Object r33 = Boxing.boxBoolean(false);
    L58:
        if (r33 != r12) goto L60;
        return r12;
    L60:
        BaseAIPackageHelper$installBasePackage$1 r210 = r10;
        r21 = r24;
        r1 = r33;
        r17 = r30;
        r19 = r12;
        r20 = r210;
        goto L61
    L45:
        if (r16.length() != 0) goto L47;
        boolean r34 = true;
    L48:
        if (r34 == true) goto L57;
        g r35 = g.a;
        r35.i("AIPackageManager", "packageName: " + r24.a.getPackageName() + ", appId: " + r24.a.getAppId() + " ===> Start downloading " + r16);
        String r110 = com.bytedance.ai.resource.core.a.a;
        String r111 = r24.a.getPackageName();
        Intrinsics.checkNotNullParameter(r111, "packageName");
        String r112 = com.bytedance.ai.resource.core.a.a + '/' + r111;
        f.h(r112);
        if (f.a(r16) == false) goto L53;
    L56:
        r35.d("AIPackageManager", "packageName: " + r24.a.getPackageName() + ", appId: " + r24.a.getAppId() + " ===> The " + r16 + " already exists");
        r33 = Boxing.boxBoolean(true);
        goto L58
    L53:
        if (f.l(r16, r24.a.getPackageName()) == true) goto L56;
        r33 = com.bytedance.ai.resource.a.a(r31, r112, r10);
        goto L58
    L47:
        r34 = false;
        goto L48
    L42:
        r32 = false;
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        String r36 = com.bytedance.ai.resource.core.a.d(r25);
        if (f.a(r36) == true) goto L72;
        g.a.d("AIPackageManager", "packageName: " + this.a.getPackageName() + ", appId: " + this.a.getAppId() + " ===> " + r36 + " does not exist");
        AppletResourceTool r37 = AppletResourceTool.a;
        AIPackageDeployment.AIPackageDeploymentItem r38 = this.a;
        r37.getClass();
        Intrinsics.checkNotNullParameter(r38, "<this>");
        ArrayList r39 = new ArrayList();
        List<String> r113 = r38.getResourceUrls();
        List<String> r114 = r113;
        if (r114 != null) goto L19;
    L22:
        boolean r115 = true;
    L24:
        if (r115 == true) goto L30;
        Iterator<T> r116 = r113.iterator();
    L27:
        if (r116.hasNext() == false) goto L29;
        String r117 = (String) r116.next();
        ListProtector.add(r39, 0, r117.substring(0, StringsKt.lastIndexOf$default(r117, "/", 0, false, 6, null)) + "/base_" + r38.getVersionCode() + ".zip");
        r14 = r14;
        goto L27
    L29:
        r18 = r14;
    L36:
        String r40 = com.bytedance.ai.resource.core.a.a;
        r16 = com.bytedance.ai.resource.core.a.b(this.a);
        r23 = false;
        r30 = r39.iterator();
        r24 = this;
        goto L38
    L30:
        r18 = "";
        if (r38.getResourceUrl().length() <= 0) goto L33;
        boolean r41 = true;
    L34:
        if (r41 == false) goto L36;
        int r42 = com.bytedance.ai.utils.a.a;
        r39.add(com.bytedance.ai.utils.a.C0050a.a() + '/' + r38.getResourceUrl().substring(0, StringsKt.lastIndexOf$default(r38.getResourceUrl(), "/", 0, false, 6, null)) + "/base_" + r38.getVersionCode() + ".zip");
        goto L36
    L33:
        r41 = false;
        goto L34
    L19:
        if (r114.isEmpty() == true) goto L22;
        r115 = false;
        goto L24
    L72:
        r27 = "";
        r24 = this;
    L7:
        r10 = new BaseAIPackageHelper$installBasePackage$1(this, r26);
        goto L8
    }
}
