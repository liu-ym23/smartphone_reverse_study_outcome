package com.ss.android.lark.framework.assembly.sp;

import com.ss.android.lark.storage.LarkKVStorage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements LarkKVStorage.a {
    public final /* synthetic */ InitUniStoreTask a;

    public final String getCurrentUserId() {
        return InitUniStoreTask.j(this.a);
    }

    public c(InitUniStoreTask r1) {
        this.a = r1;
    }
}
