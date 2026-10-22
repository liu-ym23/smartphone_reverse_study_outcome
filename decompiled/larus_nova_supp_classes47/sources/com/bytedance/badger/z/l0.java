package com.bytedance.badger.z;

import android.content.Context;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l0 extends u0 {
    public l0() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r2, BadgerModuleBase.BadgerRequestData r3) {
        return new BadgerResult.Success(new DataString(r2.getPackageName()));
    }
}
