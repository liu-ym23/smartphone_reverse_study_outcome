package com.larus.uaigc.createpage.component.instruction;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t2 extends vp8.g {
    public final ComponentFeature h;
    public final String i;
    public final String j;
    public final Function1<Long, com.larus.bmhome.actionbar.model.e2> k;
    public final Function2<Long, List<? extends Uri>, Unit> l;
    public com.larus.uaigc.createpage.component.helper.f m;
    public long n;

    public final void d() {
        com.larus.uaigc.createpage.component.helper.f r0 = new com.larus.uaigc.createpage.component.helper.f(((vp8.g) this).g);
        this.m = r0;
        r0.b = new r2(this);
    }

    public final void p() {
        com.larus.uaigc.createpage.component.helper.f r0 = this.m;
        if (r0 == null) goto L11;
        FLogger.a.i("VideoEditorPickPhotoHelper", "onDestroy unregister launchers");
        ActivityResultLauncher<String> r1 = r0.i;
        if (r1 == null) goto L7;
        r1.unregister();
    L7:
        ActivityResultLauncher<Intent> r2 = r0.j;
        if (r2 == null) goto L12;
        r2.unregister();
        return;
    L12:
        return;
    }

    public final boolean f(final com.larus.bmhome.actionbar.model.z0 r11) {
        if (r11 == null) goto L12;
        com.larus.bmhome.actionbar.model.r r2 = r11.q;
        if (r2 == null) goto L12;
        Integer r3 = r2.a;
        if (r3 == null) goto L12;
        if (r3.intValue() != 33) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L69;
        com.larus.bmhome.actionbar.model.r r5 = r11.q;
        if (r5 == null) goto L23;
        com.larus.bmhome.actionbar.model.j1 r6 = r5.e;
        if (r6 == null) goto L23;
        String r7 = r6.v;
        if (r7 == null) goto L23;
        Long r8 = StringsKt.toLongOrNull(r7);
        if (r8 == null) goto L23;
        long r9 = r8.longValue();
    L24:
        this.n = r9;
        Function1<Long, com.larus.bmhome.actionbar.model.e2> r10 = this.k;
        final FragmentActivity r12 = null;
        if (r10 == null) goto L27;
        final com.larus.bmhome.actionbar.model.e2 r13 = (com.larus.bmhome.actionbar.model.e2) r10.invoke(Long.valueOf(r9));
    L28:
        IFlowSdkDepend r14 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r14 == null) goto L35;
        r14.H();
        VideoPortraitConfig r15 = com.larus.home.impl.sdk.l1.a.a();
        if (r15 == null) goto L35;
        if (r15.getEnableEditVideo() != true) goto L35;
        boolean r16 = true;
    L36:
        if (r13 == null) goto L56;
        Integer r17 = r13.a;
        if (r17 != null) goto L41;
    L43:
        boolean r18 = false;
    L44:
        Integer r19 = r13.b;
        if (r19 == null) goto L47;
        int r20 = r19.intValue();
    L48:
        com.larus.im.internal.delegate.c0.b.i("VideoModelInfo", "enableEditVideo=" + r16 + ", supportVideoSelection=" + r18 + ", selectVideoCount=" + r20);
        if (r16 == false) goto L53;
        if (r18 == false) goto L53;
        if (r20 <= 0) goto L53;
        boolean r21 = true;
    L54:
        if (r21 != true) goto L56;
        boolean r22 = true;
    L57:
        if (r22 == true) goto L62;
        Function2<Long, List<? extends Uri>, Unit> r110 = this.l;
        if (r110 == null) goto L61;
        r110.invoke(Long.valueOf(this.n), CollectionsKt.emptyList());
    L61:
        return true;
    L62:
        Activity r23 = AppHost.a.a().getCurrentActivity();
        if ((r23 instanceof FragmentActivity) == false) goto L65;
        r12 = (FragmentActivity) r23;
    L65:
        if (r12 != null) goto L67;
        return true;
    L67:
        com.obric.assistant.spi.keyguard.a.b(false, new s2(this, r13, r12, r11), 3);
        return true;
    L53:
        r21 = false;
        goto L54
    L47:
        r20 = 0;
        goto L48
    L41:
        if (r17.intValue() != 5) goto L43;
        r18 = true;
    L56:
        r22 = false;
    L35:
        r16 = false;
        goto L36
    L27:
        r13 = null;
    L23:
        r9 = 4;
        goto L24
    L69:
        return false;
    L12:
        r4 = false;
        goto L13
    }

    public t2(ComponentFeature r2, String r3, h0 r4, i0 r5) {
        Intrinsics.checkNotNullParameter(r2, "component");
        super(r2);
        this.h = r2;
        this.i = r3;
        this.j = "template_page";
        this.k = r4;
        this.l = r5;
        this.n = 4;
    }
}
