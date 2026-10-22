package com.obric.aikernel.model_decrypt.api.callback;

import com.google.gson.k;
import java.io.File;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface IModelInfoProvider {

    public static final class DefaultImpls {
        public static List<Pair<String, k>> getModelFileInfoList(IModelInfoProvider r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "modelName");
            return null;
        }

        public static List<String> getModelFileNameList(IModelInfoProvider r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "modelName");
            return CollectionsKt.emptyList();
        }
    }

    List<Pair<String, k>> getModelFileInfoList(String r10);

    List<String> getModelFileNameList(String r10);

    File getModelSaveDir(String r10);
}
