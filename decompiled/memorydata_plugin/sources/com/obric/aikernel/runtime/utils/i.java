package com.obric.aikernel.runtime.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/aikernel/runtime/utils/OSUtils;", "", "()V", "TAG", "", "getSystemProperty", "key", "defaultValue", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f6230a = null;

    static {
        f6230a = new i();
    }

    private i() {
    }

    public static /* synthetic */ String a(i r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    public final String a(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Class r0 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        Object r1 = r0.getMethod("get", new Class[]{String.class, String.class}).invoke(r0, new Object[]{r8, r9});     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L5
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        d.f6216a.f("OSUtils", "get " + r8 + " failed: " + e);
        return r9;
    }
}
