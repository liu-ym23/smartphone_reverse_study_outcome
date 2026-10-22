package com.obric.aikernel.model_decrypt.impl.util;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.k;
import com.obric.aikernel.api.b;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.model_decrypt.api.callback.IKeyInfoDistribute;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelCert;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelCertKt;
import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager;
import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManagerKt;
import com.obric.aikernel.model_decrypt.api.filemeta.ModelFileMetaData;
import com.obric.aikernel.model_decrypt.impl.DecryptFeatureImpl;
import com.obric.aikernel.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.t2;
import org.json.JSONObject;
import u7.d;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyInfoRequestHelper {
    public static final KeyInfoRequestHelper INSTANCE = null;
    private static final String TAG = "KeyInfoRequestHelper";
    private static final AtomicLong _requestId = null;
    private static final ExecutorCoroutineDispatcher innerSingleThreadContext = null;
    private static final boolean isObricType = false;

    /* JADX INFO: renamed from: com.obric.aikernel.model_decrypt.impl.util.KeyInfoRequestHelper$requestDecryptKeyInfo$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.util.KeyInfoRequestHelper", f = "KeyInfoRequestHelper.kt", i = {0, 0, 0}, l = {155}, m = "requestDecryptKeyInfo", n = {"keyAlias", "requestId", "startTime"}, s = {"L$0", "J$0", "J$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ KeyInfoRequestHelper this$0;

        AnonymousClass1(KeyInfoRequestHelper r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return KeyInfoRequestHelper.access$requestDecryptKeyInfo(this.this$0, 0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model_decrypt.impl.util.KeyInfoRequestHelper$requestKeyInfo$2, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.util.KeyInfoRequestHelper$requestKeyInfo$2", f = "KeyInfoRequestHelper.kt", i = {0, 1, 1}, l = {66, 73}, m = "invokeSuspend", n = {"lackDecryptInfoModels", "keyAlias", "fileKeyInfoMap"}, s = {"L$0", "L$0", "L$1"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<l0, Continuation<? super Object>, Object> {
        final /* synthetic */ List<String> $modelList;
        final /* synthetic */ long $requestId;
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass2(List<String> r10, long r11, Continuation<? super AnonymousClass2> r12) {
            this.$modelList = r10;
            this.$requestId = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass2(this.$modelList, this.$requestId, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Object> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<Object> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r33) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 != 2) goto L8;
            Map r12 = (Map) this.L$1;
            String r13 = (String) this.L$0;
            ResultKt.throwOnFailure(r33);
            final Map r14 = r12;
            final String r15 = r13;
            Object r16 = r33;
        L75:
            Iterator r17 = ((Iterable) r16).iterator();
        L77:
            if (r17.hasNext() == false) goto L79;
            IKeyInfoDistribute.KeyInfoItem r18 = (IKeyInfoDistribute.KeyInfoItem) r17.next();
            String r19 = new File(DecryptFeatureImpl.INSTANCE.getModelDir(r18.getModelName()), r18.getFileName()).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(r19, "File(DecryptFeatureImpl.…it.fileName).absolutePath");
            r14.put(r19, r18);
            goto L77
        L79:
            final LinkedHashMap r20 = new LinkedHashMap();
            if (KeyInfoRequestHelper.access$isObricType$p() == true) goto L93;
            Iterator r21 = r14.entrySet().iterator();
        L83:
            if (r21.hasNext() == false) goto L93;
            Map.Entry r22 = (Map.Entry) r21.next();
            String r23 = (String) r22.getKey();
            IKeyInfoDistribute.KeyInfoItem r24 = (IKeyInfoDistribute.KeyInfoItem) r22.getValue();
            ModelFileMetaData r25 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(new File(r23));
            if (r25 == null) goto L90;
            if (r25.lackDecryptInfo() != true) goto L90;
            boolean r26 = true;
        L91:
            if (r26 == false) goto L83;
            r20.put(r23, IModelCertKt.getModelCert().reEncryptFEK(r23, r15, r24.getKeyInfo(), false));
        L90:
            r26 = false;
        L93:
            IModelFileMetaDataManager r27 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager();
            final long r28 = this.$requestId;
            r27.batchAction(new AnonymousClass3(r14, r15, r28, r20));
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            List r29 = (List) this.L$0;
            ResultKt.throwOnFailure(r33);
            List r30 = r29;
            Object r31 = r33;
        L60:
            Pair r32 = (Pair) r31;
            String r34 = (String) r32.component1();
            String r35 = (String) r32.component2();
            if (r34.length() != 0) goto L63;
            boolean r36 = true;
        L64:
            if (r36 == false) goto L66;
        L95:
            AIKLog.INSTANCE.e(KeyInfoRequestHelper.TAG, "requestId: " + this.$requestId + ", fetch attest cert chain failed");
            return Boxing.boxBoolean(false);
        L66:
            if (r35.length() != 0) goto L68;
            boolean r37 = true;
        L69:
            if (r37 == true) goto L95;
            LinkedHashMap r110 = new LinkedHashMap();
            KeyInfoRequestHelper r38 = KeyInfoRequestHelper.INSTANCE;
            long r39 = this.$requestId;
            this.L$0 = r34;
            this.L$1 = r110;
            this.label = 2;
            r16 = KeyInfoRequestHelper.access$requestDecryptKeyInfo(r38, r39, r34, r35, r30, this);
            if (r16 != r10) goto L74;
            return r10;
        L74:
            r15 = r34;
            r14 = r110;
            goto L75
        L68:
            r37 = false;
            goto L69
        L63:
            r36 = false;
            goto L64
        L10:
            ResultKt.throwOnFailure(r33);
            List<String> r40 = this.$modelList;
            ArrayList r41 = new ArrayList();
            Iterator r42 = r40.iterator();
        L12:
            if (r42.hasNext() == false) goto L53;
            Object r43 = r42.next();
            String r44 = (String) r43;
            DecryptFeatureImpl r111 = DecryptFeatureImpl.INSTANCE;
            File r112 = r111.getModelDir(r44);
            List<Pair<String, k>> r113 = r111.getModelFileInfoList(r44);
            Object r210 = null;
            if (r113 == null) goto L34;
            ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
            Iterator<T> r310 = r113.iterator();
        L17:
            if (r310.hasNext() == false) goto L23;
            Pair r311 = (Pair) r310.next();
            AIKLog r115 = AIKLog.INSTANCE;
            r115.d(KeyInfoRequestHelper.TAG, "getModelFileInfoList check " + ((String) r311.getFirst()));
            final ModelFileMetaData r45 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(new File(r112, (String) r311.getFirst()));
            if (r45 != null) goto L21;
            String r116 = (String) r311.getFirst();
            String r46 = ((k) r311.getSecond()).s("md5").h();
            Intrinsics.checkNotNullExpressionValue(r46, "info.second.get(\"md5\").asString");
            File r47 = r112;
            r45 = new ModelFileMetaData(r44, r116, r46, true, ((k) r311.getSecond()).s("origin_size_bytes").g(), false, false, null, null, null, null, null, false, false, 16352, null);
            r115.d(KeyInfoRequestHelper.TAG, "getModelFileInfoList new metadata " + ((String) r311.getFirst()));
            IModelFileMetaDataManagerKt.getModelFileMetaDataManager().update(new File(r47, (String) r311.getFirst()), false, new KeyInfoRequestHelper$requestKeyInfo$2$lackDecryptInfoModels$1$lackFiles$1$1$1(r45));
        L22:
            r114.add(Boxing.boxBoolean(r45.lackDecryptInfo()));
            r112 = r47;
            r114 = r114;
            r42 = r42;
            goto L17
        L21:
            r47 = r112;
            goto L22
        L23:
            Iterator r312 = r42;
            File r48 = r112;
            Iterator r49 = r114.iterator();
        L25:
            if (r49.hasNext() == false) goto L29;
            Object r50 = r49.next();
            if (((Boolean) r50).booleanValue() == false) goto L25;
        L30:
            Boolean r51 = (Boolean) r50;
            if (r51 == null) goto L35;
            r210 = r51;
        L46:
            if (r210 == null) goto L48;
            boolean r52 = true;
        L49:
            if (r52 == false) goto L51;
            r41.add(r43);
        L51:
            r42 = r312;
            goto L12
        L48:
            r52 = false;
        L35:
            Iterator<T> r53 = DecryptFeatureImpl.INSTANCE.getModelFileList(r44).iterator();
        L37:
            if (r53.hasNext() == false) goto L46;
            Object r54 = r53.next();
            ModelFileMetaData r55 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(new File(r48, (String) r54));
            if (r55 != null) goto L41;
        L43:
            boolean r56 = false;
        L44:
            if (r56 == false) goto L37;
            r210 = r54;
            goto L46
        L41:
            if (r55.lackDecryptInfo() != true) goto L43;
            r56 = true;
            goto L44
        L29:
            r50 = null;
            goto L30
        L34:
            r312 = r42;
            r48 = r112;
            goto L35
        L53:
            if (r41.isEmpty() == false) goto L56;
            AIKLog.INSTANCE.d(KeyInfoRequestHelper.TAG, "requestId: " + this.$requestId + ", no model need fetch key info now");
            return Boxing.boxBoolean(true);
        L56:
            IModelCert r57 = IModelCertKt.getModelCert();
            this.L$0 = r41;
            this.label = 1;
            r31 = r57.fetchAttestCertChain(this);
            if (r31 != r10) goto L59;
            return r10;
        L59:
            r30 = r41;
            goto L60
        }
    }

    static {
        INSTANCE = new KeyInfoRequestHelper();
        innerSingleThreadContext = t2.b(TAG);
        _requestId = new AtomicLong(0);
        isObricType = b.f4431a.e().a();
    }

    private KeyInfoRequestHelper() {
    }

    public static final /* synthetic */ boolean access$isObricType$p() {
        return isObricType;
    }

    public static final /* synthetic */ Object access$requestDecryptKeyInfo(KeyInfoRequestHelper r10, long r11, String r12, String r13, List r14, Continuation r15) {
        return r10.requestDecryptKeyInfo(r11, r12, r13, r14, r15);
    }

    private final void reportRequestDecryptKeyInfo(String r10, boolean r11, long r12, String r13) {
        JSONObject r14 = new JSONObject();
        r14.put("isSuccess", r11);
        r14.put("duration", r12);
        if (r11 == true) goto L5;
        r14.put("errorMsg", r13);
        r14.put("keyAlias", r10);
        r14.put("hasNet", j.f5600a.a());
    L5:
        d.b("model_decrypt_request_key_info", r14);
        if (r11 == true) goto L9;
        TrackerApi r15 = TrackerApi.INSTANCE;
        JSONObject r16 = new JSONObject();
        r16.put(WsConstants.KEY_CONNECTION_TYPE, "request_key_info");
        AppContext r17 = AppContext.INSTANCE;
        r16.put("isAdminMode", r17.isAdminMode());
        r16.put("isDebug", r17.isDebug());
        r16.put("channel", r17.getChannel());
        r16.put("hasNet", j.f5600a.a());
        Unit r18 = Unit.INSTANCE;
        JSONObject r19 = new JSONObject();
        r19.put("duration", r12);
        JSONObject r110 = new JSONObject();
        r110.put("errorMsg", r13);
        r110.put("keyAlias", r10);
        r15.monitorEvent("model_decrypt_error", r16, r19, r110);
        return;
    }

    private final Object requestDecryptKeyInfo(long r13, String r15, String r16, List<String> r17, Continuation<? super Set<IKeyInfoDistribute.KeyInfoItem>> r18) {
        long r10 = r13;
        String r11 = r15;
        if ((r18 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r18;
        int r14 = r12.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r19 = r12.result;
        Object r20 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r21 = r12.label;
        if (r21 == 0) goto L14;
        if (r21 != 1) goto L13;
        long r22 = r12.J$1;
        long r23 = r12.J$0;
        r11 = (String) r12.L$0;
        ResultKt.throwOnFailure(r19);
        Object r24 = ((Result) r19).m41unboximpl();
        long r110 = r22;
        r10 = r23;
    L22:
        if (Result.m39isSuccessimpl(r24) == false) goto L24;
        Set r25 = (Set) r24;
        AIKLog.INSTANCE.d(TAG, "requestDecryptKeyInfo onSuccess. requestId: " + r10);
        INSTANCE.reportRequestDecryptKeyInfo(r11, true, SystemClock.elapsedRealtime() - r110, null);
    L24:
        Throwable r26 = Result.m35exceptionOrNullimpl(r24);
        if (r26 == null) goto L31;
        AIKLog.INSTANCE.w(TAG, "requestDecryptKeyInfo onFailure: requestId: " + r10 + ", " + r26.getMessage(), r26);
        KeyInfoRequestHelper r27 = INSTANCE;
        long r28 = SystemClock.elapsedRealtime() - r110;
        String r29 = r26.getMessage();
        if (r29 != null) goto L29;
        r29 = "";
    L29:
        r27.reportRequestDecryptKeyInfo(r11, false, r28, r29);
    L31:
        if (Result.m38isFailureimpl(r24) == false) goto L33;
        r24 = null;
    L33:
        Set r30 = (Set) r24;
        if (r30 == null) goto L36;
        return r30;
    L36:
        return SetsKt.emptySet();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r19);
        AIKLog r31 = AIKLog.INSTANCE;
        r31.d(TAG, "requestDecryptKeyInfo: requestId: " + r13 + ", keyAlias: " + r15 + ", modelList: " + r17);
        IKeyInfoDistribute r32 = DecryptFeatureImpl.INSTANCE.getIKeyInfoDistribute();
        if (r32 != null) goto L18;
        r31.e(TAG, "requestDecryptKeyInfo failed: keyInfoFetchApi is null");
        return SetsKt.emptySet();
    L18:
        r110 = SystemClock.elapsedRealtime();
        Set<String> r33 = CollectionsKt.toSet(r17);
        r12.L$0 = r11;
        r12.J$0 = r10;
        r12.J$1 = r110;
        r12.label = 1;
        r24 = r32.mo17onRequestKeyInfoBWLJW6A(r15, r16, r33, r12);
        if (r24 != r20) goto L22;
        return r20;
    L7:
        r12 = new AnonymousClass1(this, r18);
        goto L8
    }

    public final Object requestKeyInfo(List<String> r10, Continuation<? super Unit> r11) {
        long r12 = _requestId.getAndIncrement();
        AIKLog.INSTANCE.d(TAG, "requestKeyInfo: requestId = " + r12 + ", modelList = " + r10);
        Object r13 = h.b(m0.a(innerSingleThreadContext), null, null, new AnonymousClass2(r10, r12, null), 3, null).r(r11);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }
}
