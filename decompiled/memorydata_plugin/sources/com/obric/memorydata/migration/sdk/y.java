package com.obric.memorydata.migration.sdk;

import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationQrCodec;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "encode", "", "payload", "Lcom/obric/memorydata/migration/sdk/QrPayload;", "decode", "encryptedQrText", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f11988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f11989b = null;

    static {
        f11988a = new y();
        f11989b = new Gson();
    }

    private y() {
    }

    public final QrPayload a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "encryptedQrText");
        String r2 = com.obric.memorydata.migration.sdk.internal.security.b.f11954a.b(r3);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L7;
        Object r4 = f11989b.fromJson(r2, QrPayload.class);
        Intrinsics.checkNotNullExpressionValue(r4, "fromJson(...)");
        return (QrPayload) ZeusTransformUtils.preCheckCast(r4, QrPayload.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException("invalid qr");
    }

    public final String a(QrPayload r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        com.obric.memorydata.migration.sdk.internal.security.b r1 = com.obric.memorydata.migration.sdk.internal.security.b.f11954a;
        String r3 = f11989b.toJson(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "toJson(...)");
        return r1.a(r3);
    }
}
