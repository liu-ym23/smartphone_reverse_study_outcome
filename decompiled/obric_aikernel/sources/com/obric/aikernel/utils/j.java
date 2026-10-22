package com.obric.aikernel.utils;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.runtime.utils.NetworkUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f5600a = null;

    static {
        f5600a = new j();
    }

    private j() {
    }

    public final boolean a() {
        return NetworkUtil.f5399a.e(AppContext.INSTANCE.getContext());
    }
}
