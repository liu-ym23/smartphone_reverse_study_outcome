package com.obric.memorydata.ui.impl;

import android.content.Context;
import com.obric.memorydata.middleware.api.app.IPrivacyManager;
import com.obric.memorydata.ui.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0016J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/ui/impl/PrivacyManagerImpl;", "Lcom/obric/memorydata/middleware/api/app/IPrivacyManager;", "<init>", "()V", "getInst", "requestAgreePrivacy", "", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function1;", "", "requestGlobalAgreePrivacy", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PrivacyManagerImpl implements IPrivacyManager {
    public static final PrivacyManagerImpl INSTANCE = null;

    static {
        INSTANCE = new PrivacyManagerImpl();
    }

    private PrivacyManagerImpl() {
    }

    @JvmStatic
    public static final PrivacyManagerImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.app.IPrivacyManager
    public void requestAgreePrivacy(Context r2, Function1<? super Boolean, Unit> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "callback");
    }

    @Override // com.obric.memorydata.middleware.api.app.IPrivacyManager
    public void requestGlobalAgreePrivacy(Context r2, Function1<? super Boolean, Unit> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "callback");
        e.f13004a.a(r1, r4);
    }
}
