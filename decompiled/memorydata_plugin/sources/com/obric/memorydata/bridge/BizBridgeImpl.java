package com.obric.memorydata.bridge;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.rpc.model.POIInfo;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.awareness.impl.producer.f;
import com.obric.memorydata.intelligence.appuse.AppCategoryMsg;
import com.obric.memorydata.intelligence.appuse.IAudioPlayPeriod;
import com.obric.memorydata.intelligence.appuse.IMovementItem;
import com.obric.memorydata.intelligence.appuse.IScreenLockPeriod;
import com.obric.memorydata.intelligence.appuse.IUsageInfo;
import com.obric.memorydata.intelligence.b.b;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.personalcontext.util.c;
import com.obric.memorydata.personalcontext.vectordb.d;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "not use")
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0006J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\tJ$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0010J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J$\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\u00062\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020#J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020#J)\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020#2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u00101J\u000e\u00105\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006J\u000e\u00106\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006J\u0016\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/memorydata/bridge/BizBridgeImpl;", "", "<init>", "()V", "getAllInstalled3rdPartyAppName", "", "", "getAllInstalledSystemAppNameWithIcon", "getLastNetworkType", "", "getBuildSerial", "getPackageCategory", ObricMemoryConstants.KEY_PACKAGE_NAME, "getAppUsageDuration", "Lcom/obric/memorydata/intelligence/appuse/IUsageInfo;", "startTimestamp", "", "endTimestamp", "getAudioPlayPeriod", "Lcom/obric/memorydata/intelligence/appuse/IAudioPlayPeriod;", "getMovementList", "Lcom/obric/memorydata/intelligence/appuse/IMovementItem;", "getScreenLockPeriod", "Lcom/obric/memorydata/intelligence/appuse/IScreenLockPeriod;", "getAllPoiByLocation", "Lcom/bytedance/rpc/model/POIInfo;", "latitude", "", "longitude", "radius", "getPoiByLocation", "poiEqualDelta", "getDayType", "timestamp", "initElementPropertyTemporaryDataVector", "", "initElementRelationTemporaryDataVector", "callBizAsFlow", "modelName", Params.CONTENT, "useCloud", "textValidTimeRecord", "", "textToConvertTimeTextRecord", "validTimeInterval", "extractTimeInterval", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "enablePostProcess", "timeBase", "(Ljava/lang/String;ZLjava/lang/Long;)Ljava/lang/String;", "textValidAlarmTimeRecord", "textToConvertAlarmTimeTextRecord", "validAlarmTimeInterval", "extractAlarmTimeInterval", "extractTimeDescription", "writeGlobalSetting", "", "key", EventBody.KEY_VALUE, "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BizBridgeImpl {
    public static final BizBridgeImpl INSTANCE = null;
    private static final Map<String, String> textToConvertAlarmTimeTextRecord = null;
    private static final Map<String, String> textToConvertTimeTextRecord = null;
    private static final Map<String, Long> textValidAlarmTimeRecord = null;
    private static final Map<String, Long> textValidTimeRecord = null;
    private static final long validAlarmTimeInterval = 30000;
    private static final long validTimeInterval = 30000;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8800a = null;

        static {
            int[] r0 = new int[EmbeddingState.values().length];
            r0[EmbeddingState.USE_VLM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[EmbeddingState.USE_LITTLE_MODEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f8800a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.bridge.BizBridgeImpl$callBizAsFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.bridge.BizBridgeImpl$callBizAsFlow$1", f = "BizBridgeImpl.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ String $modelName;
        final /* synthetic */ Ref.ObjectRef<String> $responseJson;
        final /* synthetic */ boolean $useCloud;
        int label;

        AnonymousClass1(String r3, String r4, boolean r5, Ref.ObjectRef<String> r6, Continuation<? super AnonymousClass1> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.$modelName = r3;
            this.$content = r4;
            this.$useCloud = r5;
            this.$responseJson = r6;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$modelName, this.$content, this.$useCloud, this.$responseJson, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r14v5, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            ?? r15 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
            if (r15 == 0) goto L14;
            this.$responseJson.element = r15;
            return Unit.INSTANCE;
        L14:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            com.obric.memorydata.aikernelcore.a r16 = com.obric.memorydata.aikernelcore.a.INSTANCE;
            String r4 = this.$modelName;
            String r5 = this.$content;
            boolean r6 = this.$useCloud;
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r14 = com.obric.memorydata.aikernelcore.a.a(r16, r4, r5, r6, 0, null, r10, 24, null);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.bridge.BizBridgeImpl$getAllPoiByLocation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/bytedance/rpc/model/POIInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.bridge.BizBridgeImpl$getAllPoiByLocation$1", f = "BizBridgeImpl.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    static final class C11021 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends POIInfo>>, Object> {
        final /* synthetic */ double $latitude;
        final /* synthetic */ double $longitude;
        final /* synthetic */ int $radius;
        int label;

        C11021(double r3, double r5, int r7, Continuation<? super C11021> r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.$latitude = r3;
            this.$longitude = r5;
            this.$radius = r7;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11021(this.$latitude, this.$longitude, this.$radius, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends POIInfo>> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super List<? extends POIInfo>> r4) {
            return ((C11021) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11021.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            com.obric.memorydata.awareness.poi.a r2 = com.obric.memorydata.awareness.poi.a.f8779a;
            double r3 = this.$latitude;
            double r5 = this.$longitude;
            int r11 = this.$radius;
            Continuation<? super List<? extends POIInfo>> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r10 = r2.a(r3, r5, r11, r7);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.bridge.BizBridgeImpl$getPoiByLocation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/bytedance/rpc/model/POIInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.bridge.BizBridgeImpl$getPoiByLocation$1", f = "BizBridgeImpl.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    static final class C11031 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends POIInfo>>, Object> {
        final /* synthetic */ double $latitude;
        final /* synthetic */ double $longitude;
        final /* synthetic */ int $poiEqualDelta;
        int label;

        C11031(double r3, double r5, int r7, Continuation<? super C11031> r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.$latitude = r3;
            this.$longitude = r5;
            this.$poiEqualDelta = r7;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11031(this.$latitude, this.$longitude, this.$poiEqualDelta, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends POIInfo>> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super List<? extends POIInfo>> r4) {
            return ((C11031) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11031.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            com.obric.memorydata.awareness.poi.a r2 = com.obric.memorydata.awareness.poi.a.f8779a;
            double r3 = this.$latitude;
            double r5 = this.$longitude;
            int r11 = this.$poiEqualDelta;
            Continuation<? super List<? extends POIInfo>> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r10 = r2.b(r3, r5, r11, r7);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    static {
        INSTANCE = new BizBridgeImpl();
        textValidTimeRecord = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        textToConvertTimeTextRecord = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        textValidAlarmTimeRecord = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        textToConvertAlarmTimeTextRecord = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private BizBridgeImpl() {
    }

    public static /* synthetic */ String callBizAsFlow$default(BizBridgeImpl r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = false;
    L12:
        return r1.callBizAsFlow(r2, r3, r4);
    }

    public static /* synthetic */ String extractTimeInterval$default(BizBridgeImpl r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.extractTimeInterval(r1, r2);
    }

    public static /* synthetic */ String extractTimeInterval$default(BizBridgeImpl r0, String r1, boolean r2, Long r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.extractTimeInterval(r1, r2, r3);
    }

    public final String callBizAsFlow(String r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "modelName");
        Intrinsics.checkNotNullParameter(r9, Params.CONTENT);
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = "";
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r8, r9, r10, r7, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        return (String) ZeusTransformUtils.preCheckCast(r7.element, String.class, "com.obric.memorydata.plugin");
    }

    public final String extractAlarmTimeInterval(String r10) {
        Intrinsics.checkNotNullParameter(r10, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Map<String, Long> r0 = textValidAlarmTimeRecord;
        if (r0.containsKey(r10) == false) goto L16;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0.get(r10), Long.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L16;
        ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();
        long r4 = System.currentTimeMillis() - r1.longValue();
        boolean r6 = false;
        if (1 <= r4) goto L9;
    L11:
        if (r6 == false) goto L16;
        Map<String, String> r2 = textToConvertAlarmTimeTextRecord;
        if (r2.containsKey(r10) == false) goto L16;
        String r9 = r2.get(r10);
        Intrinsics.checkNotNull(r9);
        return (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin");
    L9:
        if (r4 >= 30000) goto L11;
        r6 = true;
    L16:
        TaskRequest.Builder r3 = new TaskRequest.Builder("alarm_time_extract");
        JSONObject r5 = new JSONObject();
        r5.put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r10);
        TaskResult r11 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r3.setInputParam(r5), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        if (r11.getCode() != 0) goto L19;
        r0.put(r10, Long.valueOf(System.currentTimeMillis()));
        textToConvertAlarmTimeTextRecord.put(r10, r11.getOutput().toString());
    L19:
        String r12 = r11.getOutput().toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        return r12;
    }

    public final String extractTimeDescription(String r3) {
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        TaskRequest.Builder r0 = new TaskRequest.Builder("time_description_extract");
        JSONObject r1 = new JSONObject();
        r1.put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r3);
        String r2 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r0.setInputParam(r1), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute().getOutput().toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    }

    public final String extractTimeInterval(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return extractTimeInterval(r2, r3, null);
    }

    public final String extractTimeInterval(String r10, boolean r11, Long r12) {
        Intrinsics.checkNotNullParameter(r10, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Map<String, Long> r0 = textValidTimeRecord;
        if (r0.containsKey(r10) == false) goto L16;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0.get(r10), Long.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L16;
        ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();
        long r4 = System.currentTimeMillis() - r1.longValue();
        boolean r6 = false;
        if (1 <= r4) goto L9;
    L11:
        if (r6 == false) goto L16;
        Map<String, String> r2 = textToConvertTimeTextRecord;
        if (r2.containsKey(r10) == false) goto L16;
        String r9 = r2.get(r10);
        Intrinsics.checkNotNull(r9);
        return (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin");
    L9:
        if (r4 >= 30000) goto L11;
        r6 = true;
    L16:
        TaskRequest.Builder r3 = new TaskRequest.Builder("time_extract");
        JSONObject r5 = new JSONObject();
        r5.put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r10);
        r5.put("enablePostProcess", r11);
        if (r12 == null) goto L19;
        r5.put("time_base", r12.longValue());
    L19:
        TaskResult r13 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r3.setInputParam(r5), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        if (r13.getCode() != 0) goto L22;
        r0.put(r10, Long.valueOf(System.currentTimeMillis()));
        textToConvertTimeTextRecord.put(r10, r13.getOutput().toString());
    L22:
        String r14 = r13.getOutput().toString();
        Intrinsics.checkNotNullExpressionValue(r14, "toString(...)");
        return r14;
    }

    public final List<String> getAllInstalled3rdPartyAppName() {
        return (List) ZeusTransformUtils.preCheckCast(b.c(), List.class, "com.obric.memorydata.plugin");
    }

    public final List<String> getAllInstalledSystemAppNameWithIcon() {
        return (List) ZeusTransformUtils.preCheckCast(b.d(), List.class, "com.obric.memorydata.plugin");
    }

    public final List<POIInfo> getAllPoiByLocation(double r8, double r10, int r12) {
        return (List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C11021(r8, r10, r12, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin");
    }

    public final List<IUsageInfo> getAppUsageDuration(long r1, long r3) {
        return com.obric.memorydata.intelligence.appuse.b.f9935a.a(r1, r3);
    }

    public final List<IAudioPlayPeriod> getAudioPlayPeriod(long r1, long r3) {
        return com.obric.memorydata.intelligence.appuse.b.f9935a.c(r1, r3);
    }

    @Deprecated(message = "not use")
    public final String getBuildSerial() {
        return AppContext.INSTANCE.getServerDeviceId();
    }

    public final String getDayType(long r1) {
        return f.f8749a.a(r1);
    }

    public final int getLastNetworkType() {
        return com.obric.memorydata.intelligence.b.i.f9950a.a();
    }

    public final List<IMovementItem> getMovementList(long r1, long r3) {
        return com.obric.memorydata.intelligence.appuse.b.f9935a.d(r1, r3);
    }

    public final String getPackageCategory(String r3) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        AppCategoryMsg r2 = com.obric.memorydata.intelligence.appuse.a.f9933a.a(r3);
        if (r2 != null) goto L6;
        return null;
    L6:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getSubCategory(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        return r2.getCategory();
    L16:
        return r2.getSubCategory();
    L9:
        if (r4.length() == 0) goto L12;
        r5 = false;
        goto L13
    }

    public final List<POIInfo> getPoiByLocation(double r8, double r10, int r12) {
        return (List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C11031(r8, r10, r12, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin");
    }

    public final List<IScreenLockPeriod> getScreenLockPeriod(long r1, long r3) {
        return (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.intelligence.appuse.b.f9935a.b(r1, r3), List.class, "com.obric.memorydata.plugin");
    }

    public final boolean initElementPropertyTemporaryDataVector() {
        RunLog.INSTANCE.debug("BizBridgeImpl", "Begin init ElementPropertyTemporaryDataVector in ElementPropertyTemporaryDataVector from papaya.");
        EmbeddingState r4 = c.f12363a.b();
        int r5 = a.f8800a[r4.ordinal()];
        if (r5 != 1) goto L5;
        d r6 = new d("ElementPropertyTemporaryDataVector", true);
    L14:
        return r6.b();
    L5:
        if (r5 == 2) goto L12;
        boolean r7 = new d("ElementPropertyTemporaryDataVector", true).b();
        if (new d("ElementPropertyTemporaryDataVector", false).b() == false) goto L11;
        if (r7 == false) goto L11;
        return true;
    L11:
        return false;
    L12:
        r6 = new d("ElementPropertyTemporaryDataVector", false);
        goto L14
    }

    public final boolean initElementRelationTemporaryDataVector() {
        RunLog.INSTANCE.debug("BizBridgeImpl", "Begin init ElementRelationTemporaryDataVector in ElementRelationTemporaryDataVector from papaya.");
        EmbeddingState r4 = c.f12363a.b();
        int r5 = a.f8800a[r4.ordinal()];
        if (r5 != 1) goto L5;
        d r6 = new d("ElementRelationTemporaryDataVector", true);
    L14:
        return r6.b();
    L5:
        if (r5 == 2) goto L12;
        boolean r7 = new d("ElementRelationTemporaryDataVector", true).b();
        if (new d("ElementRelationTemporaryDataVector", false).b() == false) goto L11;
        if (r7 == false) goto L11;
        return true;
    L11:
        return false;
    L12:
        r6 = new d("ElementRelationTemporaryDataVector", false);
        goto L14
    }

    public final void writeGlobalSetting(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "key");
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BizBridgeImpl", "===>writeGlobalSetting key:" + r9 + ", value:" + r10, false, 4, null);
        Settings.Global.putString(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r9, r10);
    }
}
