package com.obric.aikernel.model_preset.impl.decrypt;

import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.store.IStoreManager;
import com.obric.aikernel.middleware.api.store.StoreManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t7.a;

/* JADX INFO: loaded from: classes2.dex */
public final class PresetDecryptReEncryptKeySP {
    public static final PresetDecryptReEncryptKeySP INSTANCE = null;
    private static final String TAG = "PresetDecryptReEncryptKeySP";
    private static final a modelFileMetaStore = null;

    static {
        INSTANCE = new PresetDecryptReEncryptKeySP();
        modelFileMetaStore = IStoreManager.a.a(StoreManager.INSTANCE, "AIKernel_model_file_preset_re_encrypt_key", 0, 2, null);
    }

    private PresetDecryptReEncryptKeySP() {
    }

    public final synchronized String getReEncryptKey(String r10, String r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "modelName");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r11, "fileName");     // Catch: Throwable -> L8
        String r12 = modelFileMetaStore.getString(r10 + '/' + r11, "");     // Catch: Throwable -> L8
        if (r12 != null) goto L6;
        r12 = "";
    L6:
        monitor-exit(this);
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void removeInvalidKeys(Set<Pair<String, String>> r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "validStatusList");     // Catch: Throwable -> L21
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));     // Catch: Throwable -> L21
        Iterator<T> r12 = r10.iterator();     // Catch: Throwable -> L21
    L5:
        if (r12.hasNext() == false) goto L7;
        Pair r13 = (Pair) r12.next();     // Catch: Throwable -> L21
        r11.add(((String) r13.getFirst()) + '/' + ((String) r13.getSecond()));     // Catch: Throwable -> L21
        goto L5
    L7:
        String[] r14 = modelFileMetaStore.e();     // Catch: Throwable -> L21
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L21
        int r16 = r14.length;     // Catch: Throwable -> L21
        int r17 = 0;
    L9:
        if (r17 >= r16) goto L14;
        String r18 = r14[r17];     // Catch: Throwable -> L21
        if ((true ^ r11.contains(r18)) == false) goto L13;
        r15.add(r18);     // Catch: Throwable -> L21
    L13:
        r17 = r17 + 1;     // Catch: Throwable -> L21
        goto L9
    L14:
        Iterator r19 = r15.iterator();     // Catch: Throwable -> L21
    L15:
        if (r19.hasNext() == false) goto L19;
        String r20 = (String) r19.next();     // Catch: Throwable -> L21
        AIKLog.INSTANCE.d(TAG, "remove invalid status: " + r20);     // Catch: Throwable -> L21
        modelFileMetaStore.f(new String[]{r20});     // Catch: Throwable -> L21
        goto L15
    L19:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final synchronized void saveReEncryptKey(String r10, String r11, String r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "modelName");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r11, "fileName");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r12, "reEncryptKey");     // Catch: Throwable -> L6
        AIKLog.INSTANCE.d(TAG, "saveReEncryptKey: " + r10 + '/' + r11);     // Catch: Throwable -> L6
        modelFileMetaStore.b(r10 + '/' + r11, r12);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
