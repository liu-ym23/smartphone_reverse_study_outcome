package com.ss.android.lark.passportc.api;

import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ContainerConstsKt {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ContainerConstsKt$ABSENT_SESSION$2.INSTANCE);
    }

    public static final UserSession a() {
        return (UserSession) a.getValue();
    }
}
