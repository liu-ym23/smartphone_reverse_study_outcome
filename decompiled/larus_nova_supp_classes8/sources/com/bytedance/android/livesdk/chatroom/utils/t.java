package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.logsdk.format.Spm;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public final String b;
    public final String c;
    public final Map<String, Object> d;

    public static final class a {
    }

    static {
    }

    public final Spm a() {
        Spm.a r0 = Spm.Companion;
        String r1 = this.a;
        r0.getClass();
        Spm r2 = Spm.a.a(r1);
        Map<String, Object> r3 = this.d;
        if (r3 == null) goto L5;
        r2.addArgs(r3);
    L5:
        String r4 = this.c;
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == true) goto L14;
        r2.fromSpm(this.c);
    L14:
        return r2;
    L8:
        if (r4.length() == 0) goto L11;
        r5 = false;
        goto L12
    }

    public t(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "spm");
        Intrinsics.checkNotNullParameter(r3, "tagSuffix");
        this.a = r2;
        this.b = r3;
        this.c = null;
        this.d = null;
    }

    public final void b(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        Spm r4 = a().result(r3).reason(r2);
        String r5 = "DynamicSpmMonitor" + this.b;
        Intrinsics.checkNotNullParameter(r4, "$this$report");
        sw2.a.b(r4, r5);
    }

    public final void c(String r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        Spm r4 = a().reason(r2);
        if (r3 == null) goto L5;
        r4.args(r3);
    L5:
        Unit r5 = Unit.INSTANCE;
        String r6 = "DynamicSpmMonitor" + this.b;
        Intrinsics.checkNotNullParameter(r4, "$this$report");
        sw2.a.b(r4, r6);
    }
}
