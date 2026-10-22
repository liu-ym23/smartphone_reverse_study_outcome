package com.bytedance.ai.resource.core.operations;

import ai.j0;
import android.text.TextUtils;
import android.util.LruCache;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.core.AIPackageConfig;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBeanKt;
import com.bytedance.ai.resource.e0;
import com.bytedance.ai.resource.l;
import com.bytedance.ai.utils.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.d;
import kk.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/resource/core/operations/AbsAIPackageOperation;", "", "Result", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAbsAIPackageOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsAIPackageOperation.kt\ncom/bytedance/ai/resource/core/operations/AbsAIPackageOperation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,226:1\n1863#2,2:227\n1863#2,2:229\n1863#2,2:231\n*S KotlinDebug\n*F\n+ 1 AbsAIPackageOperation.kt\ncom/bytedance/ai/resource/core/operations/AbsAIPackageOperation\n*L\n92#1:227,2\n182#1:229,2\n185#1:231,2\n*E\n"})
public abstract class AbsAIPackageOperation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIPackage f2687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackageManifestBean f2688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AIPackageDeployment.AIPackageDeploymentItem f2689c;
    public final AtomicBoolean d;
    public volatile Result e;
    public final CopyOnWriteArraySet f;
    public final CopyOnWriteArraySet g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/operations/AbsAIPackageOperation$Result;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Result {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AIPackage f2690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f2692c;
        public final AIPackage.AIPackageType d;
        public final int e;
        public final String f;

        public Result(AIPackage r5, String r10, String r11, AIPackage.AIPackageType r12, int r13, String r14) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r11, Constant.APPID);
            Intrinsics.checkNotNullParameter(r12, "packageType");
            this.f2690a = r5;
            this.f2691b = r10;
            this.f2692c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Result) == true) goto L8;
            return false;
        L8:
            Result r10 = (Result) r5;
            if (Intrinsics.areEqual(this.f2690a, r10.f2690a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f2691b, r10.f2691b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f2692c, r10.f2692c) == true) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r10.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            AIPackage r5 = this.f2690a;
            int r10 = 0;
            if (r5 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = d.a(this.e, (this.d.hashCode() + a.b(this.f2692c, a.b(this.f2691b, r11 * 31, 31), 31)) * 31);
            String r13 = this.f;
            if (r13 == null) goto L11;
            r10 = r13.hashCode();
        L11:
            return r12 + r10;
        L5:
            r11 = r5.hashCode();
            goto L6
        }

        public final String toString() {
            StringBuilder r5 = new StringBuilder("Result(info=");
            r5.append(this.f2690a);
            r5.append(", packageName=");
            r5.append(this.f2691b);
            r5.append(", appId=");
            r5.append(this.f2692c);
            r5.append(", packageType=");
            r5.append(this.d);
            r5.append(", errorCode=");
            r5.append(this.e);
            r5.append(", errorMsg=");
            return j0.p(r5, this.f, ')');
        }
    }

    public AbsAIPackageOperation() {
        this.d = new AtomicBoolean(false);
        this.f = new CopyOnWriteArraySet();
        this.g = new CopyOnWriteArraySet();
    }

    public final AIPackageDeployment.AIPackageDeploymentItem a() {
        AIPackageDeployment.AIPackageDeploymentItem r5 = this.f2689c;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("deploymentInfo");
        return null;
    }

    public abstract Object a(Continuation r5);

    public final AIPackage b() {
        AIPackage r5 = this.f2687a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("oldAIPackage");
        return null;
    }

    public abstract AIPackage.PackageStatus c();

    public final AIPackage a(AIPackageManifestBean r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "manifestBean");
        Intrinsics.checkNotNullParameter(r11, "flag");
        Applet r5 = AIPackageManifestBeanKt.a(r10);
        if (r5 == null) goto L12;
        AIPackageManifestBean.AppletBean r12 = r10.getApplet();
        if (r12 == null) goto L7;
        String r13 = r12.getAppletId();
    L9:
        if (Intrinsics.areEqual(r13, a().getAppId()) == false) goto L12;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r5.f2274v = r11;
        return r5;
    L7:
        r13 = null;
    L12:
        ArrayList r14 = AIPackageManifestBeanKt.b(r10);
        if (r14 == null) goto L21;
        Iterator r15 = r14.iterator();
    L16:
        if (r15.hasNext() == false) goto L21;
        Widget r16 = (Widget) r15.next();
        if (Intrinsics.areEqual(r16.F, a().getAppId()) == false) goto L16;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r16.f2274v = r11;
        return r16;
    L21:
        return null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x019d -> B:65:0x01a0). Please report as a decompilation issue!!! */
    public final Object a(ContinuationImpl r15) {
        if ((r15 instanceof AbsAIPackageOperation$download$1) == false) goto L7;
        AbsAIPackageOperation$download$1 r5 = (AbsAIPackageOperation$download$1) r15;
        int r10 = r5.e;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r10 - Integer.MIN_VALUE;
    L8:
        Object r16 = r5.f2695c;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r5.e;
        boolean r13 = true;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        Iterator r14 = r5.f2694b;
        String r17 = r5.f2693a;
        ResultKt.throwOnFailure(r16);
    L65:
        boolean r18 = ((Boolean) r16).booleanValue();
        if (r18 == false) goto L61;
    L67:
        r13 = r18;
    L72:
        return Boxing.boxBoolean(r13);
    L61:
        if (r14.hasNext() == false) goto L67;
        String r19 = (String) r14.next();
        r5.f2693a = r17;
        r5.f2694b = r14;
        r5.e = 1;
        r16 = i.a.g(r19, r17, r5);
        if (r16 != r11) goto L65;
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        List<String> r110 = a().getResourceUrls();
        List r111 = r110;
        if (r110 != null) goto L33;
        ArrayList r112 = new ArrayList();
        LruCache r20 = e0.f2711a;
        AIPackageDeployment.AIPackageDeploymentItem r21 = a();
        Intrinsics.checkNotNullParameter(r21, "<this>");
        if (r21.getResourceUrl().length() <= 0) goto L29;
        u0.a r22 = s0.a.f21800c;
        if (r22 != null) goto L21;
    L23:
        if (r22 != null) goto L25;
    L27:
        String r23 = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source";
    L28:
        String r24 = r23 + '/' + r21.getResourceUrl();
    L30:
        r111 = r112;
        if (r24.length() <= 0) goto L33;
        r112.add(r24);
        r111 = r112;
        goto L33
    L25:
        if (r22.f22205p != true) goto L27;
    L26:
        r23 = "https://tosv.byted.org/obj/gecko-internal";
        goto L28
    L21:
        if (r22.f22203n != true) goto L23;
    L29:
        r24 = "";
    L33:
        String r25 = AIPackageConfig.f2571a;
        String r26 = AIPackageConfig.c(a());
        r18 = false;
        if (r111.isEmpty() == false) goto L36;
    L73:
        String r113 = "packageName: " + a().getPackageName() + ", appId: " + a().getAppId() + " ===> The download url and destination file are empty";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r114 = c.f2846a;
        if (r114 == null) goto L77;
        r114.e("AIPackageManager", r113);
    L77:
        return Boxing.boxBoolean(false);
    L36:
        if (r26.length() == 0) goto L73;
        String r27 = "packageName: " + a().getPackageName() + ", appId: " + a().getAppId() + " ===> Start downloading " + r26;
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r115 = c.f2846a;
        if (r115 == null) goto L41;
        r115.i("AIPackageManager", r27);
    L41:
        String r28 = a().getPackageName();
        Intrinsics.checkNotNullParameter(r28, "packageName");
        r17 = AIPackageConfig.f2571a + '/' + r28;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        File r29 = new File(r17);
        if (r29.exists() == true) goto L45;
        r29.mkdirs();
    L45:
        if (TextUtils.isEmpty(r26) == false) goto L47;
        boolean r30 = false;
    L48:
        if (r30 == false) goto L50;
    L68:
        StringBuilder r116 = new StringBuilder("packageName: ");
        r116.append(a().getPackageName());
        r116.append(", appId: ");
        r116.append(a().getAppId());
        r116.append(" ===> The ");
        r116.append(r26);
        String r117 = androidx.room.jarjarred.org.antlr.runtime.a.v(r116, " already exists", "AIPackageManager", "tag");
        t0.d r118 = c.f2846a;
        if (r118 == null) goto L72;
        r118.d("AIPackageManager", r117);
        goto L72
    L50:
        if (c.m(r26, a().getPackageName()) == true) goto L68;
        if (a().getBuildInPackage() == false) goto L59;
        StringBuilder r119 = new StringBuilder("packageName: ");
        r119.append(a().getPackageName());
        r119.append(", appId: ");
        r119.append(a().getAppId());
        r119.append(" ===> Built-in asset ");
        r119.append(r26);
        String r120 = androidx.room.jarjarred.org.antlr.runtime.a.v(r119, " does not exist", "AIPackageManager", "tag");
        t0.d r121 = c.f2846a;
        if (r121 == null) goto L58;
        r121.e("AIPackageManager", r120);
    L58:
        return Boxing.boxBoolean(false);
    L59:
        r14 = r111.iterator();
        goto L61
    L47:
        r30 = new File(r26).exists();
    L7:
        r5 = new AbsAIPackageOperation$download$1(this, r15);
        goto L8
    }

    public final void a(l r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        if (this.d.get() == false) goto L8;
        Result r11 = this.e;
        if (r11 == null) goto L10;
        r10.a(r11.f2690a, r11.f2691b, r11.f2692c, r11.d, r11.e, r11.f);
        return;
    L10:
        return;
    L8:
        this.f.add(r10);
    }

    public static Result a(AbsAIPackageOperation r10, AIPackage r11, int r12) {
        String r5 = r10.a().getPackageName();
        String r13 = r10.a().getAppId();
        if (r11 == null) goto L6;
        AIPackage.AIPackageType r14 = r11.e();
    L8:
        return new Result(r11, r5, r13, r14, r12, null);
    L6:
        r14 = AIPackage.AIPackageType.f2281c;
        goto L8
    }
}
