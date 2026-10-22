package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.bean.IsInAppWhitelistData;
import com.bytedance.ai.resource.core.bean.OpenPlatformAppletItem;
import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$installAIPackagesWithVersionCodeInMemory$2", f = "AIPackageManager.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
final class AIPackageManager$installAIPackagesWithVersionCodeInMemory$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Boolean, ? extends Boolean>>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ AIPackageManager.b $listener;
    final /* synthetic */ String $packageName;
    final /* synthetic */ int $source;
    final /* synthetic */ String $token;
    final /* synthetic */ long $versionCode;
    final /* synthetic */ String $versionTag;
    final /* synthetic */ String $xToken;
    int label;

    /* JADX INFO: renamed from: com.bytedance.ai.resource.AIPackageManager$installAIPackagesWithVersionCodeInMemory$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$installAIPackagesWithVersionCodeInMemory$2$1", f = "AIPackageManager.kt", i = {0, 0, 0, 0}, l = {209, 234}, m = "invokeSuspend", n = {"scope", "remaining", "hasFailure", "done"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Boolean, ? extends Boolean>>, Object> {
        final /* synthetic */ AIPackageManager.b $listener;
        final /* synthetic */ List<AIPackageDeployment.AIPackageDeploymentItem> $packageList;
        final /* synthetic */ long $versionCode;
        final /* synthetic */ String $versionTag;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX INFO: renamed from: com.bytedance.ai.resource.AIPackageManager$installAIPackagesWithVersionCodeInMemory$2$1$a */
        public static final class a implements AIPackageManager.b {
            public final /* synthetic */ CoroutineScope a;
            public final /* synthetic */ AtomicBoolean b;
            public final /* synthetic */ AIPackageManager.b c;
            public final /* synthetic */ AtomicInteger d;
            public final /* synthetic */ CompletableDeferred<Boolean> e;

            public a(CoroutineScope r1, AtomicBoolean r10, AIPackageManager.b r11, AtomicInteger r12, CompletableDeferred<Boolean> r13) {
                this.a = r1;
                this.b = r10;
                this.c = r11;
                this.d = r12;
                this.e = r13;
            }

            @Override // com.bytedance.ai.resource.AIPackageManager.b
            public final void a(AIPackage r10, String r11, String r12, AIPackage.AIPackageType r13, int r14, String r15) {
                Intrinsics.checkNotNullParameter(r11, "packageName");
                Intrinsics.checkNotNullParameter(r12, BdpAwemeConstant.KEY_APP_ID);
                Intrinsics.checkNotNullParameter(r13, "packageType");
                if (CoroutineScopeKt.isActive(this.a) == true) goto L6;
                return;
            L6:
                if (r14 == 0) goto L8;
                this.b.set(true);
            L8:
                AIPackageManager.b r16 = this.c;
                if (r16 == null) goto L11;
                r16.a(r10, r11, r12, r13, r14, r15);
            L11:
                int r17 = this.d.addAndGet(-1);
                com.bytedance.ai.utils.g.a.i("AIPackageManager", "lastCount: " + r17);
                if (r17 != 0) goto L15;
                this.e.complete(Boolean.valueOf(!this.b.get()));
                return;
            }
        }

        public AnonymousClass1(List<AIPackageDeployment.AIPackageDeploymentItem> r1, String r10, long r11, AIPackageManager.b r12, Continuation<? super AnonymousClass1> r13) {
            this.$packageList = r1;
            this.$versionTag = r10;
            this.$versionCode = r11;
            this.$listener = r12;
            super(2, r13);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$packageList, this.$versionTag, this.$versionCode, this.$listener, r11);
            r12.L$0 = r10;
            return r12;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Pair<Boolean, Boolean>> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00aa -> B:30:0x0114). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0104 -> B:29:0x010a). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r29) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            Object r11 = null;
            if (r10 == 0) goto L10;
            if (r10 == 1) goto L9;
            if (r10 != 2) goto L8;
            ResultKt.throwOnFailure(r29);
            Object r12 = r29;
        L35:
            return new Pair(Boxing.boxBoolean(true), Boxing.boxBoolean(((Boolean) r12).booleanValue()));
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            long r13 = this.J$0;
            Iterator r14 = (Iterator) this.L$6;
            AIPackageManager.b r15 = (AIPackageManager.b) this.L$5;
            String r16 = (String) this.L$4;
            CompletableDeferred r17 = (CompletableDeferred) this.L$3;
            AtomicBoolean r18 = (AtomicBoolean) this.L$2;
            AtomicInteger r19 = (AtomicInteger) this.L$1;
            CoroutineScope r110 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r29);
            AIPackageManager.b r111 = r15;
            AnonymousClass1 r20 = this;
        L29:
            CoroutineScope r24 = r110;
            String r112 = r16;
            CoroutineScope r113 = r24;
            AtomicInteger r25 = r19;
            CompletableDeferred r114 = r17;
            AtomicInteger r115 = r25;
        L30:
            r11 = null;
        L12:
            if (r14.hasNext() == false) goto L31;
            AIPackageDeployment.AIPackageDeploymentItem r116 = (AIPackageDeployment.AIPackageDeploymentItem) r14.next();
            if (CoroutineScopeKt.isActive(r113) == false) goto L30;
            if (r112 != null) goto L18;
        L21:
            boolean r117 = true;
        L22:
            if (r117 == false) goto L24;
            long r118 = r13;
        L25:
            AIPackageManager r119 = AIPackageManager.a;
            AnonymousClass1 r21 = r20;
            AtomicInteger r22 = r115;
            AtomicBoolean r23 = r18;
            CompletableDeferred r26 = r114;
            String r27 = r112;
            a r28 = new a(r113, r18, r111, r22, r26);
            r21.L$0 = r113;
            r21.L$1 = r22;
            r21.L$2 = r23;
            r21.L$3 = r26;
            r21.L$4 = r27;
            r21.L$5 = r111;
            r21.L$6 = r14;
            r21.J$0 = r13;
            r21.label = 1;
            r119.getClass();
            if (AIPackageManager.i(r116, r118, r28, true, r21) != r1) goto L28;
            return r1;
        L28:
            r20 = r21;
            r110 = r113;
            r19 = r22;
            r17 = r26;
            r18 = r23;
            r16 = r27;
            goto L29
        L24:
            r118 = r116.getVersionCode();
            goto L25
        L18:
            if (r112.length() == 0) goto L21;
            r117 = false;
            goto L22
        L31:
            Object r30 = r11;
            AnonymousClass1 r31 = r20;
            r31.L$0 = r30;
            r31.L$1 = r30;
            r31.L$2 = r30;
            r31.L$3 = r30;
            r31.L$4 = r30;
            r31.L$5 = r30;
            r31.L$6 = r30;
            r31.label = 2;
            r12 = r114.await(r31);
            if (r12 != r1) goto L35;
            return r1;
        L10:
            ResultKt.throwOnFailure(r29);
            CoroutineScope r32 = (CoroutineScope) this.L$0;
            AtomicInteger r33 = new AtomicInteger(this.$packageList.size());
            AtomicBoolean r34 = new AtomicBoolean(false);
            CompletableDeferred r35 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            com.bytedance.ai.utils.g.a.i("AIPackageManager", "total package size: " + r33.get());
            List<AIPackageDeployment.AIPackageDeploymentItem> r120 = this.$packageList;
            String r121 = this.$versionTag;
            long r122 = this.$versionCode;
            AIPackageManager.b r123 = this.$listener;
            Iterator r124 = r120.iterator();
            r111 = r123;
            r112 = r121;
            r115 = r33;
            r20 = this;
            r113 = r32;
            r14 = r124;
            r18 = r34;
            r114 = r35;
            r13 = r122;
            goto L12
        }
    }

    public AIPackageManager$installAIPackagesWithVersionCodeInMemory$2(String r1, long r10, String r11, int r12, String r13, String r14, String r15, AIPackageManager.b r16, Continuation<? super AIPackageManager$installAIPackagesWithVersionCodeInMemory$2> r17) {
        this.$packageName = r1;
        this.$versionCode = r10;
        this.$versionTag = r11;
        this.$source = r12;
        this.$deviceId = r13;
        this.$token = r14;
        this.$xToken = r15;
        this.$listener = r16;
        super(2, r17);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new AIPackageManager$installAIPackagesWithVersionCodeInMemory$2(this.$packageName, this.$versionCode, this.$versionTag, this.$source, this.$deviceId, this.$token, this.$xToken, this.$listener, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<Boolean, Boolean>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r33) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r33);
        return r33;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r33);
        com.bytedance.ai.utils.g r1 = com.bytedance.ai.utils.g.a;
        r1.d("AIPackageManager", "packageName: " + this.$packageName + ", versionCode: " + this.$versionCode + ", versionTag: " + this.$versionTag + " ===> installAIPackageInMemory start");
        ConcurrentHashMap<String, AIPackageDeployment.AIPackageDeploymentItem> r11 = AIPackageDeployment.a;
        int r12 = this.$source;
        String r13 = this.$packageName;
        long r14 = this.$versionCode;
        String r15 = this.$versionTag;
        String r16 = this.$deviceId;
        String r17 = this.$token;
        String r18 = this.$xToken;
        Intrinsics.checkNotNullParameter(r13, "packageName");
        Intrinsics.checkNotNullParameter(r16, "deviceId");
        Intrinsics.checkNotNullParameter(r17, BdpShareBaseInfo.CHANNEL_TOKEN);
        Intrinsics.checkNotNullParameter(r18, "xToken");
        Lazy r19 = o5.b.a;
        Intrinsics.checkNotNullParameter(r13, "packageName");
        Intrinsics.checkNotNullParameter(r16, "deviceId");
        Intrinsics.checkNotNullParameter(r17, BdpShareBaseInfo.CHANNEL_TOKEN);
        Intrinsics.checkNotNullParameter(r18, "xToken");
        OpenPlatformBaseResponse<IsInAppWhitelistData> r20 = o5.b.a().requestDebugDeploymentInfo(r12, r13, r14, r15, r16, r17, r18);
        if (r20.getCode() != 0) goto L11;
        boolean r21 = true;
    L12:
        Pair r110 = null;
        if (r21 == false) goto L54;
        IsInAppWhitelistData r22 = r20.getData();
        StringBuilder r111 = new StringBuilder("packageName: ");
        r111.append(r13);
        r111.append(" , versionCode: ");
        r111.append(r14);
        String r112 = ", versionTag: ";
        r111.append(r112);
        r111.append(r15);
        r111.append("， logId:");
        r111.append(r20.getLogId());
        r111.append(" ===> Successful request for all debug Applets/Widgets under the specified Package : ");
        r111.append(r22);
        r1.i("AIPackageManager", r111.toString());
        if (r22 != null) goto L17;
        r1.e("AIPackageManager", "packageName: " + r13 + " , versionCode: " + r14 + r112 + r15 + "，logId = " + r20.getLogId() + " ===>Failed to request for all debug Applets/Widgets under the specified Package. data is NULL");
    L53:
        String r23 = ", versionCode: ";
    L55:
        if (r110 != null) goto L62;
        String r24 = "packageName: " + this.$packageName + r23 + this.$versionCode + r112 + this.$versionTag + " ===> failed to request debug deployment info";
        com.bytedance.ai.utils.g.a.e("AIPackageManager", r24);
        AIPackageManager.b r113 = this.$listener;
        if (r113 == null) goto L60;
        r113.a(null, this.$packageName, "", AIPackage.AIPackageType.UNKNOWN, 12, r24);
    L60:
        return new Pair(Boxing.boxBoolean(false), Boxing.boxBoolean(false));
    L62:
        if (((Boolean) r110.getFirst()).booleanValue() == true) goto L68;
        String r25 = "packageName: " + this.$packageName + r23 + this.$versionCode + r112 + this.$versionTag + " ===> installAIPackageInMemory is NOT allowed";
        com.bytedance.ai.utils.g.a.e("AIPackageManager", r25);
        AIPackageManager.b r114 = this.$listener;
        if (r114 == null) goto L67;
        r114.a(null, this.$packageName, "", AIPackage.AIPackageType.UNKNOWN, 16, r25);
    L67:
        return new Pair(Boxing.boxBoolean(false), Boxing.boxBoolean(false));
    L68:
        List r26 = (List) r110.getSecond();
        List r27 = r26;
        if (r27 != null) goto L71;
    L74:
        boolean r28 = true;
    L75:
        if (r28 == false) goto L81;
        String r29 = "packageName: " + this.$packageName + r23 + this.$versionCode + r112 + this.$versionTag + " is NOT exist";
        com.bytedance.ai.utils.g.a.e("AIPackageManager", r29);
        AIPackageManager.b r115 = this.$listener;
        if (r115 == null) goto L80;
        r115.a(null, this.$packageName, "", AIPackage.AIPackageType.UNKNOWN, 12, r29);
    L80:
        return new Pair(Boxing.boxBoolean(true), Boxing.boxBoolean(false));
    L81:
        AnonymousClass1 r30 = new AnonymousClass1(r26, this.$versionTag, this.$versionCode, this.$listener, null);
        this.label = 1;
        Object r31 = CoroutineScopeKt.coroutineScope(r30, this);
        if (r31 != r10) goto L92;
        return r10;
    L92:
        return r31;
    L71:
        if (r27.isEmpty() == true) goto L74;
        r28 = false;
        goto L75
    L17:
        if (r22.getAllowed() == true) goto L19;
        r1.e("AIPackageManager", "packageName: " + r13 + " , versionCode: " + r14 + r112 + r15 + " ===> request for all debug Applets/Widgets under the specified Package is NOT allowed: " + r22 + "， logId = " + r20.getLogId());
        r23 = ", versionCode: ";
        r110 = new Pair(Boolean.FALSE, null);
        goto L55
    L19:
        ArrayList r32 = new ArrayList();
        List<OpenPlatformAppletItem> r34 = r22.getAppletList();
        if (r34 == null) goto L51;
        Iterator<T> r35 = r34.iterator();
    L23:
        if (r35.hasNext() == false) goto L51;
        OpenPlatformAppletItem r36 = (OpenPlatformAppletItem) r35.next();
        Intrinsics.checkNotNullParameter(r36, "item");
        String r37 = r36.getAppId();     // Catch: Exception -> L47
        if (r37 != null) goto L29;
        String r210 = "";
    L30:
        String r38 = r36.getPackageName();     // Catch: Exception -> L47
        if (r38 != null) goto L33;
        String r211 = "";
    L34:
        String r39 = r36.getVersionCode();     // Catch: Exception -> L47
        if (r39 != null) goto L37;
        r39 = "";
    L37:
        long r212 = CastLongProtector.parseLong(r39);     // Catch: Exception -> L47
        String r40 = r36.getResourceUrl();     // Catch: Exception -> L47
        if (r40 != null) goto L40;
        String r213 = "";
    L41:
        String r41 = r36.getDigest();     // Catch: Exception -> L47
        if (r41 != null) goto L44;
        String r214 = "";
    L45:
        AIPackageDeployment.AIPackageDeploymentItem r42 = new AIPackageDeployment.AIPackageDeploymentItem(r210, r211, r212, r213, r214, r36.getResourceUrls(), false, r36.getVerifySignature(), null, 320, null);     // Catch: Exception -> L47
    L49:
        if (r42 == null) goto L23;
        r42.setVersionTag(r15);
        r32.add(r42);
        goto L23
    L44:
        r214 = r41;
        goto L45
    L40:
        r213 = r40;
        goto L41
    L33:
        r211 = r38;
        goto L34
    L29:
        r210 = r37;
    L47:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "packageName: " + r36.getPackageName() + ", appId: " + r36.getAppId() + " ===> responseItemBeanToDeploymentItem failed : " + ExceptionsKt.stackTraceToString(e));
        r42 = null;
    L51:
        r110 = new Pair(Boolean.TRUE, r32);
        goto L53
    L54:
        r112 = ", versionTag: ";
        StringBuilder r43 = new StringBuilder("packageName: ");
        r43.append(r13);
        r23 = ", versionCode: ";
        r43.append(r23);
        r43.append(r14);
        r43.append(r112);
        r43.append(r15);
        r43.append(" ===> Failed to request for all debug Applets/Widgets under the specified Package : code = ");
        r43.append(r20.getCode());
        r43.append(", msg = ");
        r43.append(r20.getMessage());
        r43.append(", logId = ");
        r43.append(r20.getLogId());
        r1.e("AIPackageManager", r43.toString());
        goto L55
    L11:
        r21 = false;
        goto L12
    }
}
