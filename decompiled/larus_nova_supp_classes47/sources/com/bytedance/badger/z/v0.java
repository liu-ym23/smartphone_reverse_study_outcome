package com.bytedance.badger.z;

import android.content.Context;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v0 extends u0 {
    public final /* synthetic */ Function0 a;

    public v0(Function0 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r2, BadgerModuleBase.BadgerRequestData r3) {
        return new BadgerResult.Success(new DataString((String) this.a.invoke()));
    }
}
