package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class OfficeSDKRustCallbackDispatchModule$provideLoginCallbackExecutorGroup$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public OfficeSDKRustCallbackDispatchModule$provideLoginCallbackExecutorGroup$1(Object r8) {
        super(0, r8, q.class, "isLoginCallbackExecutorEnabled", "isLoginCallbackExecutorEnabled()Z", 0);
    }

    public final Boolean invoke() {
        q r0 = (q) ((CallableReference) this).receiver;
        q r1 = q.a;
        r0.getClass();
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L5;
    L7:
        boolean r2 = false;
    L9:
        return Boolean.valueOf(r2);
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.officesdk.rust.login_callback_executor.disable") == true) goto L7;
        r2 = true;
        goto L9
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m683invoke() {
        return invoke();
    }
}
