package com.bytedance.ai.applet.login;

import android.app.Activity;
import com.bytedance.ai.applet.granting.GrantingAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements r4.f.a {
    public final /* synthetic */ String a;

    public d(String r1) {
        this.a = r1;
    }

    @Override // r4.f.a
    public final void a(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // r4.f.a
    public final void onCreated(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // r4.f.a
    public final void onPaused(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // r4.f.a
    public final void onResumed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        CustomLoginNavigator.a r11 = CustomLoginNavigator.b.get(this.a);
        if (r11 == null) goto L5;
        CustomLoginNavigator.LaunchSource r12 = r11.d;
    L7:
        if (r12 == CustomLoginNavigator.LaunchSource.CHAT) goto L9;
        return;
    L9:
        com.bytedance.ai.utils.g.a.i("CustomLoginNavigator", "host main activity resumed before login result, dismiss custom login: appletId=" + this.a);
        LoginProcessor r13 = LoginProcessor.a;
        String r0 = this.a;
        GrantingAction r1 = GrantingAction.DISMISSED;
        OperationType r14 = OperationType.LOGIN;
        r13.getClass();
        LoginProcessor.i(r0, r1, r14);
        return;
    L5:
        r12 = null;
        goto L7
    }

    @Override // r4.f.a
    public final void onStopped(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }
}
