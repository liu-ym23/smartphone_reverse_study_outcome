package com.ss.android.lark.conditional.access.nopermission.ui;

import android.app.Activity;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class q extends UDBaseDialogBuilder<q> {
    public final Activity a;

    public abstract q a(com.ss.android.lark.conditional.access.nopermission.manager.v r1);

    public abstract CustomDisplayTemplate b();

    public abstract InternalSecurityAction c();

    public abstract void d(CustomDisplayTemplate r1, InternalSecurityAction r2);

    public final Activity getActivity() {
        return this.a;
    }

    public q(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        this.a = r2;
    }
}
