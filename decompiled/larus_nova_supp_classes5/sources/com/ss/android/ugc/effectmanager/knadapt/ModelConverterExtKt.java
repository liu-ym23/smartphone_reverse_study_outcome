package com.ss.android.ugc.effectmanager.knadapt;

import com.ss.android.ugc.effectmanager.DownloadableModelConfig;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.algorithm.FetchModelType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0007"}, d2 = {"toKNFetchModelType", "Lcom/ss/ugc/effectplatform/model/algorithm/FetchModelType;", "Lcom/ss/android/ugc/effectmanager/FetchModelType;", "toKNModel", "Lcom/ss/ugc/effectplatform/EffectConfig$ModelFileEnv;", "Lcom/ss/android/ugc/effectmanager/DownloadableModelConfig$ModelFileEnv;", "toOldFetchModelType", "effectmanager_release"}, k = 2, mv = {1, 1, 16})
public final class ModelConverterExtKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r0 = new int[FetchModelType.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[FetchModelType.ORIGIN.ordinal()] = 1;
            r0[FetchModelType.ZIP.ordinal()] = 2;
            int[] r1 = new int[com.ss.android.ugc.effectmanager.FetchModelType.values().length];
            $EnumSwitchMapping$1 = r1;
            r1[com.ss.android.ugc.effectmanager.FetchModelType.ORIGIN.ordinal()] = 1;
            r1[com.ss.android.ugc.effectmanager.FetchModelType.ZIP.ordinal()] = 2;
            int[] r2 = new int[DownloadableModelConfig.ModelFileEnv.values().length];
            $EnumSwitchMapping$2 = r2;
            r2[DownloadableModelConfig.ModelFileEnv.TEST.ordinal()] = 1;
            r2[DownloadableModelConfig.ModelFileEnv.ONLINE.ordinal()] = 2;
        }
    }

    public static final FetchModelType toKNFetchModelType(com.ss.android.ugc.effectmanager.FetchModelType r1) {
        int r2 = WhenMappings.$EnumSwitchMapping$1[r1.ordinal()];
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L8;
        return FetchModelType.ZIP;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return FetchModelType.ORIGIN;
    }

    public static final EffectConfig.ModelFileEnv toKNModel(DownloadableModelConfig.ModelFileEnv r1) {
        int r2 = WhenMappings.$EnumSwitchMapping$2[r1.ordinal()];
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L8;
        return EffectConfig.ModelFileEnv.ONLINE;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return EffectConfig.ModelFileEnv.TEST;
    }

    public static final com.ss.android.ugc.effectmanager.FetchModelType toOldFetchModelType(FetchModelType r1) {
        int r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L8;
        return com.ss.android.ugc.effectmanager.FetchModelType.ZIP;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return com.ss.android.ugc.effectmanager.FetchModelType.ORIGIN;
    }
}
