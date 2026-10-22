package com.obric.aikernel.service.res;

import com.obric.aikernel.model.device.encrypt.KeyInfoDistributeImpl;
import com.obric.aikernel.model_decrypt.api.IDecryptFeature;
import com.obric.aikernel.model_decrypt.api.IDecryptFeatureKt;
import com.obric.aikernel.model_decrypt.api.callback.IModelInfoProvider;
import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManagerKt;
import com.obric.aikernel.model_decrypt.api.filemeta.ModelFileMetaData;
import com.obric.aikernel.model_preset.api.IModelPresetRes;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.data.AIModel;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class DecryptFeature implements PackageResourceManager.PresmConfig.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PackageResourceManager.PresmConfig f5454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f5455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f5456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<Pair<String, com.google.gson.k>>> f5457d;

    public static final class a implements IModelInfoProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DecryptFeature f5458a;

        a(DecryptFeature r10) {
            this.f5458a = r10;
        }

        @Override // com.obric.aikernel.model_decrypt.api.callback.IModelInfoProvider
        public List<Pair<String, com.google.gson.k>> getModelFileInfoList(String r10) {
            Intrinsics.checkNotNullParameter(r10, "modelName");
            return (List) DecryptFeature.g(this.f5458a).get(r10);
        }

        @Override // com.obric.aikernel.model_decrypt.api.callback.IModelInfoProvider
        public List<String> getModelFileNameList(String r10) {
            return IModelInfoProvider.DefaultImpls.getModelFileNameList(this, r10);
        }

        @Override // com.obric.aikernel.model_decrypt.api.callback.IModelInfoProvider
        public File getModelSaveDir(String r10) {
            Intrinsics.checkNotNullParameter(r10, "modelName");
            List r11 = StringsKt.split$default(r10, new char[]{'@'}, false, 0, 6, null);
            String r12 = (String) r11.get(0);
            String r13 = (String) r11.get(1);
            return new File(DecryptFeature.f(this.f5458a), "models/" + r12 + '/' + r13 + '/' + r12);
        }
    }

    public DecryptFeature(PackageResourceManager.PresmConfig r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        this.f5454a = r10;
        this.f5455b = new File(r10.getResRootDir());
        this.f5456c = LazyKt.lazy(DecryptFeature$modelPresetApi$2.INSTANCE);
        this.f5457d = new ConcurrentHashMap();
        IDecryptFeatureKt.getDecryptFeature().init(new a(this), new KeyInfoDistributeImpl());
    }

    public static final /* synthetic */ File f(DecryptFeature r10) {
        return r10.f5455b;
    }

    public static final /* synthetic */ ConcurrentHashMap g(DecryptFeature r10) {
        return r10.f5457d;
    }

    private final IModelPresetRes h() {
        return (IModelPresetRes) this.f5456c.getValue();
    }

    @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
    public Object a(String r10, String r11, String r12, String r13, String r14, Continuation<? super Pair<Boolean, String>> r15) {
        if ((r15 instanceof DecryptFeature$decrypt$1) == false) goto L7;
        DecryptFeature$decrypt$1 r16 = (DecryptFeature$decrypt$1) r15;
        int r17 = r16.label;
        if ((r17 & Integer.MIN_VALUE) == 0) goto L7;
        r16.label = r17 - Integer.MIN_VALUE;
    L8:
        Object r18 = r16.result;
        Object r19 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r20 = r16.label;
        if (r20 == 0) goto L19;
        if (r20 == 1) goto L16;
        if (r20 != 2) goto L15;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L31
    L29:
        Object r21 = Result.m32constructorimpl(Boxing.boxBoolean(((Boolean) r18).booleanValue()));     // Catch: Throwable -> L31
    L34:
        if (Result.m39isSuccessimpl(r21) == true) goto L36;
        Throwable r22 = Result.m35exceptionOrNullimpl(r21);
        if (r22 == null) goto L42;
        return new Pair(Boxing.boxBoolean(false), ExceptionsKt.stackTraceToString(r22));
    L42:
        return new Pair(Boxing.boxBoolean(false), "not impl");
    L36:
        return new Pair(Boxing.boxBoolean(((Boolean) r21).booleanValue()), "run DecryptFeature end.");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r14 = (String) r16.L$2;
        r13 = (String) r16.L$1;
        r12 = (String) r16.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L31
    L18:
        String r23 = r13;
        String r24 = r14;
        String r110 = r12;
        IDecryptFeature r25 = IDecryptFeatureKt.getDecryptFeature();     // Catch: Throwable -> L31
        r16.L$0 = null;     // Catch: Throwable -> L31
        r16.L$1 = null;     // Catch: Throwable -> L31
        r16.L$2 = null;     // Catch: Throwable -> L31
        r16.label = 2;     // Catch: Throwable -> L31
        r18 = r25.decrypt(r23, r24, false, r110, r16);     // Catch: Throwable -> L31
        if (r18 != r19) goto L29;
        return r19;
    L19:
        ResultKt.throwOnFailure(r18);
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L31
        File r27 = new File(r12);     // Catch: Throwable -> L31
        final ModelFileMetaData r28 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(r27);     // Catch: Throwable -> L31
        if (r28 == null) goto L23;
        IModelFileMetaDataManagerKt.getModelFileMetaDataManager().update(r27, false, new DecryptFeature$decrypt$2$1$1(r28));     // Catch: Throwable -> L31
    L23:
        IDecryptFeature r29 = IDecryptFeatureKt.getDecryptFeature();     // Catch: Throwable -> L31
        List<String> r30 = CollectionsKt.listOf(r10 + '@' + r11);     // Catch: Throwable -> L31
        r16.L$0 = r12;     // Catch: Throwable -> L31
        r16.L$1 = r13;     // Catch: Throwable -> L31
        r16.L$2 = r14;     // Catch: Throwable -> L31
        r16.label = 1;     // Catch: Throwable -> L31
        if (r29.requestKeyInfo(r30, r16) != r19) goto L18;
        return r19;
    L31:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r21 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L7:
        r16 = new DecryptFeature$decrypt$1(this, r15);
        goto L8
    }

    @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
    public boolean b() {
        return true;
    }

    @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
    public boolean c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "model");
        Intrinsics.checkNotNullParameter(r11, "version");
        return h().isPresetEncrypted(r10 + '@' + r11);
    }

    @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
    public Object d(Map<String, ? extends List<Pair<String, com.google.gson.k>>> r10, Continuation<? super Unit> r11) {
        this.f5457d.putAll(r10);
        Iterator<Map.Entry<String, List<Pair<String, com.google.gson.k>>>> r12 = this.f5457d.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Map.Entry<String, List<Pair<String, com.google.gson.k>>> r13 = r12.next();
        List r14 = StringsKt.split$default(r13.getKey(), new char[]{'@'}, false, 0, 6, null);
        if (new AIModel((String) r14.get(0), (String) r14.get(1), this.f5454a).H() == false) goto L4;
        this.f5457d.remove(r13.getKey());
        goto L4
    L8:
        IDecryptFeature r15 = IDecryptFeatureKt.getDecryptFeature();
        Set<String> r16 = this.f5457d.keySet();
        Intrinsics.checkNotNullExpressionValue(r16, "pendingModelFiles.keys");
        Object r17 = r15.requestKeyInfo(CollectionsKt.toList(r16), r11);
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r17;
    L12:
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
    public String e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "model");
        Intrinsics.checkNotNullParameter(r11, "version");
        return h().getDecryptPath(r10 + '@' + r11, "");
    }

    @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
    public boolean isPresetDecrypted(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "model");
        Intrinsics.checkNotNullParameter(r11, "version");
        return h().isPresetDecrypted(r10 + '@' + r11);
    }

    @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
    public Object waitDecrypting(Collection<String> r10, Continuation<? super Unit> r11) {
        Object r12 = h().waitDecrypting(r10, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }
}
