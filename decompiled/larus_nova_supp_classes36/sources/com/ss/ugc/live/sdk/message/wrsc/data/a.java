package com.ss.ugc.live.sdk.message.wrsc.data;

import com.ss.android.lark.maintab.export.TabAppInfo;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import tlc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements c {
    public final long a;
    public final long b;
    public final String c;
    public final ByteString d;
    public final Object e;
    public final long f;
    public final String g;

    @Override // tlc.c
    public final Object getData() {
        return this.e;
    }

    @Override // tlc.c
    public final long getWRDSVersion() {
        return this.a;
    }

    public a(long r2, String r4, WebcastRoomDataSyncKeyValue r5, Object r6) {
        Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r5, "webcastRoomDataSyncKeyValue");
        this.f = r2;
        this.g = r4;
        Long r3 = r5.version;
        if (r3 == null) goto L5;
        long r7 = r3.longValue();
    L6:
        this.a = r7;
        Long r8 = r5.msgID;
        if (r8 == null) goto L9;
        long r9 = r8.longValue();
    L10:
        this.b = r9;
        String r10 = r5.bizLogID;
        if (r10 != null) goto L14;
        r10 = "";
    L14:
        this.c = r10;
        this.d = r5.payload;
        this.e = r6;
        return;
    L9:
        r9 = 0;
        goto L10
    L5:
        r7 = -1;
        goto L6
    }
}
