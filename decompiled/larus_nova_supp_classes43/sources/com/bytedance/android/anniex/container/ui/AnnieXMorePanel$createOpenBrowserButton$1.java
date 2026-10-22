package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXMorePanel$createOpenBrowserButton$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ia.c $container;
    final /* synthetic */ Context $context;

    public AnnieXMorePanel$createOpenBrowserButton$1(ia.c r1, Context r10) {
        this.$container = r1;
        this.$context = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m209invoke() {
        Intent r0 = new Intent("android.intent.action.VIEW", UriProtector.parse(this.$container.getCurrentUrl()));
        r0.addFlags(268435456);
        r0.addCategory("android.intent.category.BROWSABLE");
        ResolveInfo r1 = this.$context.getPackageManager().resolveActivity(r0, 65536);
        if (r1 == null) goto L6;
        Context r10 = this.$context;
        ActivityInfo r11 = r1.activityInfo;
        r0.setClassName(r11.packageName, r11.name);
        r10.startActivity(r0);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m209invoke();
        return Unit.INSTANCE;
    }
}
