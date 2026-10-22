package com.bytedance.ai.resource.core.operations;

import com.byted.cast.sink.api.IServerListener;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.core.e;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class AbsAIPackageOperation {
    public AIPackage a;
    public AIPackageManifestBean b;
    public AIPackageDeployment.AIPackageDeploymentItem c;
    public final AtomicBoolean d;
    public volatile a e;
    public final CopyOnWriteArraySet<AIPackageManager.b> f;
    public final CopyOnWriteArraySet<Continuation<a>> g;

    public static final class a {
        public final AIPackage a;
        public final String b;
        public final String c;
        public final AIPackage.AIPackageType d;
        public final int e;
        public final String f;

        public a() {
            this(null, null, null, null, 0, 63);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            AIPackage r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = ((((((((r10 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31;
            String r12 = this.f;
            if (r12 == null) goto L11;
            r1 = r12.hashCode();
        L11:
            return r11 + r1;
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Result(info=" + this.a + ", packageName=" + this.b + ", appId=" + this.c + ", packageType=" + this.d + ", errorCode=" + this.e + ", errorMsg=" + this.f + ')';
        }

        public /* synthetic */ a(AIPackage r10, String r11, String r12, AIPackage.AIPackageType r13, int r14, int r15) {
            if ((r15 & 1) == 0) goto L5;
            r10 = null;
        L5:
            AIPackage r1 = r10;
            if ((r15 & 2) == 0) goto L8;
            String r16 = "";
        L10:
            if ((r15 & 4) == 0) goto L12;
            String r17 = "";
        L14:
            if ((r15 & 8) == 0) goto L16;
            r13 = AIPackage.AIPackageType.UNKNOWN;
        L16:
            AIPackage.AIPackageType r18 = r13;
            if ((r15 & 16) == 0) goto L19;
            int r19 = IServerListener.WHAT_BYTELINK_SINK_ERROR;
        L20:
            this(r1, r16, r17, r18, r19, null);
            return;
        L19:
            r19 = r14;
            goto L20
        L12:
            r17 = r12;
            goto L14
        L8:
            r16 = r11;
            goto L10
        }

        public a(AIPackage r10, String r11, String r12, AIPackage.AIPackageType r13, int r14, String r15) {
            Intrinsics.checkNotNullParameter(r11, "packageName");
            Intrinsics.checkNotNullParameter(r12, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r13, "packageType");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
        }
    }

    public final AIPackageDeployment.AIPackageDeploymentItem d() {
        AIPackageDeployment.AIPackageDeploymentItem r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("deploymentInfo");
        return null;
    }

    public final AIPackage e() {
        AIPackage r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("oldAIPackage");
        return null;
    }

    public final boolean k() {
        String r0 = com.bytedance.ai.resource.core.a.a;
        return e.b(com.bytedance.ai.resource.core.a.f(d()), com.bytedance.ai.resource.core.a.e(d()));
    }

    public AbsAIPackageOperation() {
        this.d = new AtomicBoolean(false);
        this.f = new CopyOnWriteArraySet();
        this.g = new CopyOnWriteArraySet();
    }

    public AIPackage.PackageStatus j() {
        return AIPackage.PackageStatus.READY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0146 -> B:49:0x0149). Please report as a decompilation issue!!! */
    public final Object c(Continuation<? super Boolean> r15) {
        if ((r15 instanceof AbsAIPackageOperation$download$1) == false) goto L7;
        AbsAIPackageOperation$download$1 r0 = (AbsAIPackageOperation$download$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        boolean r12 = true;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        Iterator r13 = (Iterator) r0.L$1;
        String r14 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L49:
        boolean r17 = ((Boolean) r16).booleanValue();
        if (r17 == false) goto L52;
        r12 = r17;
    L57:
        return Boxing.boxBoolean(r12);
    L52:
        String r18 = r14;
        boolean r19 = r17;
    L53:
        String r110 = r18;
        if (r13.hasNext() == false) goto L54;
        String r20 = (String) r13.next();
        int r21 = com.bytedance.ai.resource.a.a;
        r0.L$0 = r110;
        r0.L$1 = r13;
        r0.label = 1;
        Object r22 = com.bytedance.ai.resource.a.a(r20, r110, r0);
        if (r22 != r10) goto L48;
        return r10;
    L48:
        r14 = r110;
        r16 = r22;
        goto L49
    L54:
        r12 = r19;
        goto L57
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        ?? r111 = d().getResourceUrls();
        r19 = false;
        if (r111 != 0) goto L29;
        r111 = new ArrayList();
        AppletResourceTool r23 = AppletResourceTool.a;
        AIPackageDeployment.AIPackageDeploymentItem r24 = d();
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "<this>");
        if (r24.getResourceUrl().length() <= 0) goto L19;
        boolean r25 = true;
    L20:
        if (r25 == false) goto L22;
        int r26 = com.bytedance.ai.utils.a.a;
        String r27 = com.bytedance.ai.utils.a.C0050a.a() + '/' + r24.getResourceUrl();
    L24:
        if (r27.length() <= 0) goto L26;
        boolean r28 = true;
    L27:
        if (r28 == false) goto L29;
        r111.add(r27);
        goto L29
    L26:
        r28 = false;
        goto L27
    L22:
        r27 = "";
        goto L24
    L19:
        r25 = false;
    L29:
        String r29 = com.bytedance.ai.resource.core.a.a;
        String r30 = com.bytedance.ai.resource.core.a.f(d());
        if (r111.isEmpty() == false) goto L32;
    L58:
        g.a.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> The download url and destination file are empty");
        return Boxing.boxBoolean(false);
    L32:
        if (r30.length() != 0) goto L34;
        boolean r31 = true;
    L35:
        if (r31 == true) goto L58;
        g r32 = g.a;
        r32.i("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> Start downloading " + r30);
        String r112 = d().getPackageName();
        Intrinsics.checkNotNullParameter(r112, "packageName");
        String r33 = com.bytedance.ai.resource.core.a.a + '/' + r112;
        f.h(r33);
        if (f.a(r30) == false) goto L40;
    L55:
        r32.d("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> The " + r30 + " already exists");
        goto L57
    L40:
        if (f.l(r30, d().getPackageName()) == true) goto L55;
        r18 = r33;
        r13 = r111.iterator();
        goto L53
    L34:
        r31 = false;
    L7:
        r0 = new AbsAIPackageOperation$download$1(this, r15);
        goto L8
    }

    public final void f(AIPackageManager.b r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        if (this.d.get() == false) goto L7;
        a r0 = this.e;
        if (r0 == null) goto L9;
        r10.a(r0.a, r0.b, r0.c, r0.d, r0.e, r0.f);
        return;
    L9:
        return;
    L7:
        this.f.add(r10);
    }

    public Object g(Continuation<? super a> r10) {
        return new a(null, null, null, null, 0, 63);
    }

    public final void h(AIPackageDeployment.AIPackageDeploymentItem r10) {
        Intrinsics.checkNotNullParameter(r10, "info");
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.c = r10;
    }

    public final void i(AIPackage r10) {
        Intrinsics.checkNotNullParameter(r10, "oldPackage");
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.a = r10;
    }

    public final AIPackage a(AIPackageManifestBean r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "manifestBean");
        Intrinsics.checkNotNullParameter(r11, "flag");
        Applet r0 = com.bytedance.ai.resource.core.bean.a.a(r10);
        if (r0 == null) goto L12;
        AIPackageManifestBean.AppletBean r12 = r10.getApplet();
        if (r12 == null) goto L7;
        String r13 = r12.getAppletId();
    L9:
        if (Intrinsics.areEqual(r13, d().getAppId()) == false) goto L12;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r0.v = r11;
        r0.D = r10.getHasKeyStore();
        r0.E = r10.getVerifySignature();
        return r0;
    L7:
        r13 = null;
    L12:
        List<Widget> r1 = com.bytedance.ai.resource.core.bean.a.b(r10);
        if (r1 == null) goto L21;
        Iterator r14 = ((ArrayList) r1).iterator();
    L16:
        if (r14.hasNext() == false) goto L21;
        Widget r15 = (Widget) r14.next();
        if (Intrinsics.areEqual(r15.K, d().getAppId()) == false) goto L16;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r15.v = r11;
        r15.D = r10.getHasKeyStore();
        r15.E = r10.getVerifySignature();
        return r15;
    L21:
        return null;
    }

    public static a b(AbsAIPackageOperation r10, AIPackage r11, int r12) {
        r10.getClass();
        String r13 = r10.d().getPackageName();
        String r14 = r10.d().getAppId();
        if (r11 == null) goto L6;
        AIPackage.AIPackageType r15 = r11.c();
        if (r15 == null) goto L6;
    L8:
        return new a(r11, r13, r14, r15, r12, null);
    L6:
        r15 = AIPackage.AIPackageType.UNKNOWN;
        goto L8
    }
}
