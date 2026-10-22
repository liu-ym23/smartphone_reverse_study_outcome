package com.bytedance.android.live.broadcastgame.opengame;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p {
    public static final boolean a(String r9, String r11) {
        Intrinsics.checkNotNullParameter(r9, "schema");
        Intrinsics.checkNotNullParameter(r11, "appId");
        int r0 = com.bytedance.bdp.live.livecontainer.base.schema.a.a;
        if (TextUtils.isEmpty(r9) == false) goto L5;
        LiveSchemaInfo.BdpsumCheckResult r1 = LiveSchemaInfo.BdpsumCheckResult.NONE;
    L21:
        if (r1 == LiveSchemaInfo.BdpsumCheckResult.NORMAL) goto L30;
        LruCache r2 = LiveSchemaInfo.r;
        LiveSchemaInfo r12 = LiveSchemaInfo.c.a(r9);
        if (r12 == null) goto L25;
        String r13 = (String) r12.c.getValue();
    L27:
        if ((!Intrinsics.areEqual(r13, r11)) == false) goto L31;
        return true;
    L31:
        return false;
    L25:
        r13 = null;
        goto L27
    L30:
        return false;
    L5:
        if (r9 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        List r3 = StringsKt.split$default(r9, new String[]{"&bdpsum="}, false, 0, 6, null);
        if (r3.size() >= 2) goto L10;
        r1 = LiveSchemaInfo.BdpsumCheckResult.NONE;
        goto L21
    L10:
        String r4 = (String) ListProtector.get(r3, 1);
        String r5 = com.bytedance.bdp.live.livecontainer.base.schema.a.a((String) ListProtector.get(r3, 0));
        if (TextUtils.isEmpty(r4) == false) goto L14;
        r1 = LiveSchemaInfo.BdpsumCheckResult.NONE;
        goto L21
    L14:
        if (TextUtils.isEmpty(r5) == false) goto L17;
        r1 = LiveSchemaInfo.BdpsumCheckResult.ERROR;
        goto L21
    L17:
        if (Intrinsics.areEqual(r4, r5) == false) goto L19;
        r1 = LiveSchemaInfo.BdpsumCheckResult.NORMAL;
        goto L21
    L19:
        r1 = LiveSchemaInfo.BdpsumCheckResult.ERROR;
        goto L21
    }
}
