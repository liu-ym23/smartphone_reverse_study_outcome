package com.suite.lark.platform.component.widget_biz_permissionpurposewindow;

import android.os.Handler;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class PermissionPurposeWindowPermissionResult implements h.e, h.c {
    public final Lazy<Handler> a;

    public static final class a {
    }

    static {
    }

    public void a(boolean r1) {
    }

    public void b(StoragePermissionUtils.c r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public PermissionPurposeWindowPermissionResult() {
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, PermissionPurposeWindowPermissionResult$handlerLazy$1.INSTANCE);
    }
}
