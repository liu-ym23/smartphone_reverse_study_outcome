package com.bytedance.badger.z;

import android.content.Context;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.data.EventReportEnum;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class p extends u0 {
    public final EventReportEnum a;

    public p(EventReportEnum r1) {
        this.a = r1;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r5, BadgerModuleBase.BadgerRequestData r6) {
        List r7 = com.bytedance.badger.y.g.a;     // Catch: Exception -> L8
        JSONObject r8 = com.bytedance.badger.y.g.h(this.a);     // Catch: Exception -> L8
        if (r8.optLong("create_time") != 0) goto L7;
        return new BadgerResult.Failure(-998, "not record");
    L7:
        return new BadgerResult.Success(new DataJson(r8));
    L8:
        e = move-exception;
        return new BadgerResult.Failure(-999, e.toString());
    }
}
