package com.ss.android.lark.keyboard.edittext;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public final KeyboardFunctionEditText a;
    public final CoroutineScope b;

    public static final class a {
    }

    static {
    }

    public e(KeyboardFunctionEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        this.a = r2;
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate());
        ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool());
    }
}
