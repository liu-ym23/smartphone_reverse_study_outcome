package com.ss.android.lark.framework.assembly.rust;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/framework/assembly/rust/InitRustSdkTaskForSimple;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "passport", "Lcom/ss/android/lark/passportc/api/IPassportGlobalService;", "<init>", "(Lcom/ss/android/lark/passportc/api/IPassportGlobalService;)V", "execute", "", "context", "Landroid/content/Context;", "setRustDependency", "rust-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitRustSdkTaskForSimple extends AbstractLaunchTask<Object> {
    public final com.ss.android.lark.passportc.api.j c;

    @Inject
    public InitRustSdkTaskForSimple(com.ss.android.lark.passportc.api.j r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        this.c = r2;
    }

    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        com.ss.android.lark.sdk.i.b = new k(this);
        com.ss.android.lark.sdk.i.c = new l();
    }
}
