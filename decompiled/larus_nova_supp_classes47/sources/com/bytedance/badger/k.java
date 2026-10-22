package com.bytedance.badger;

import com.bytedance.badger.data.BadgerNativeUpdateCallback;
import com.bytedance.badger.data.BadgerUpdateInfo;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements BadgerNativeUpdateCallback {
    public final /* synthetic */ Function1 a;

    public k(Function1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.badger.data.BadgerNativeUpdateCallback
    public final void onUpdate(BadgerUpdateInfo r4) {
        e.f("BadgerCore", "scene complete onUpdate " + r4);
        this.a.invoke(r4.copy());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        e.e("BadgerCore", "Failed to call fullCallback: " + th.getMessage());
    }
}
