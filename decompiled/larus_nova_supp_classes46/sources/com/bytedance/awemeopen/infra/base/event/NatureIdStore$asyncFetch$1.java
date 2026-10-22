package com.bytedance.awemeopen.infra.base.event;

import android.text.TextUtils;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class NatureIdStore$asyncFetch$1 extends Lambda implements Function0<Unit> {
    public static final NatureIdStore$asyncFetch$1 INSTANCE = null;

    static {
        INSTANCE = new NatureIdStore$asyncFetch$1();
    }

    public NatureIdStore$asyncFetch$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m887invoke() {
        Function0<String> r0 = AoNet.a;     // Catch: Throwable -> L11
        final String r1 = null;
        JSONObject r2 = new JSONObject(AoNet.a("https://content-open.douyin.com/aweme/open/export_sdk/common_params/", null).stringBody()).optJSONObject("data");     // Catch: Throwable -> L11
        if (r2 == null) goto L6;
        r1 = r2.optString("nature_open_id");     // Catch: Throwable -> L11
    L6:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        final String r3 = NatureIdStore.a();     // Catch: Throwable -> L11
        b.g = new AnonymousClass1(r3);     // Catch: Throwable -> L11
        return;
    L9:
        b.g = new AnonymousClass2(r1);     // Catch: Throwable -> L11
        NatureIdStore.b(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (AoEnv.h() == false) goto L17;
        AoLogger.c("NatureIdStore", new Object[]{"asyncFetch error", th});
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m887invoke();
        return Unit.INSTANCE;
    }
}
