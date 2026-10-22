package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessPersonalAccessPolicy;", "", "<init>", "()V", "canRead", "", "hasAgreePrivacyAndLogin", "userId", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f11271a = null;

    static {
        f11271a = new g();
    }

    private g() {
    }

    public final boolean a(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        if (r3 == false) goto L11;
        Long r2 = StringsKt.toLongOrNull(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        if (r2 == null) goto L7;
        long r0 = r2.longValue();
    L9:
        if (r0 <= 0) goto L11;
        return true;
    L7:
        r0 = 0;
    L11:
        return false;
    }
}
