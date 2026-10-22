package com.bytedance.bpea.entry.api.device.info;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class SettingsEntry$Companion$getSecureAndroidIdUnsafe$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Context $context;

    public SettingsEntry$Companion$getSecureAndroidIdUnsafe$1(Context r1) {
        this.$context = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1627invoke() {
        ContentResolver r0 = this.$context.getContentResolver();
        f06.c r9 = new f06.c();
        Object[] r10 = {r0, "android_id"};
        f06.b r12 = new f06.b();
        f06.d r13 = r9.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r10, "java.lang.String", r12);
        if (r13.a == false) goto L5;
        r9.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r10, null, r12, false);
        return (String) r13.b;
    L5:
        String r1 = Settings.Secure.getString(r0, "android_id");
        r9.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r10, r1, r12, true);
        return r1;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1627invoke();
    }
}
