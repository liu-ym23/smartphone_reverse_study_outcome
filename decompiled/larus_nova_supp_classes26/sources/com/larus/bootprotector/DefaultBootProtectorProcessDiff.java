package com.larus.bootprotector;

import android.content.Context;
import ita.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/bootprotector/DefaultBootProtectorProcessDiff;", "Lcom/larus/bootprotector/IBootProtectorProcessDiff;", "<init>", "()V", "isMainProcess", "", "context", "Landroid/content/Context;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultBootProtectorProcessDiff implements IBootProtectorProcessDiff {

    public static final class a {
    }

    static {
    }

    public DefaultBootProtectorProcessDiff() {
    }

    public final boolean isMainProcess(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return k.i(r3);
    L5:
        th = move-exception;
        nu8.a.f("BootProtectorProcessDiff", th, "isMainProcess failed ");
        return false;
    }
}
