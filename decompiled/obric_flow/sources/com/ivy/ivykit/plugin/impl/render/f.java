package com.ivy.ivykit.plugin.impl.render;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends ql.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BulletContainerView f9526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9527c;
    public final com.ivy.ivykit.plugin.impl.jsb.a d;

    public f(Context r10, String r11, ol.c r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "renderUrl");
        super(r12);
        new LinkedHashSet();
        this.d = new com.ivy.ivykit.plugin.impl.jsb.a();
        rb.b r5 = new rb.b();
        Intrinsics.checkNotNullParameter(f.class, "clazz");
        r5.b(f.class, new rb.a(this, 0));
        this.f9527c = Intrinsics.areEqual(Uri.parse(r11).getQueryParameter("need_reload"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        ae.a r14 = new ae.a();
        r14.f161b = r13;
        Unit r15 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(ae.a.class, "clazz");
        r5.b(ae.a.class, new rb.a(r14, 0));
        BulletContainerView r16 = new BulletContainerView(r10, null, 6, 0);
        r16.setLayoutParams(new ViewGroup.LayoutParams(r16.getWidth(), -2));
        r16.setMCurrentScene(Scenes.d);
        r16.f(k5.d.f18613r);
        this.f9526b = r16;
        Uri r17 = Uri.parse(r11 + "&use_xbridge3=true");
        e r18 = new e(this);
        Intrinsics.checkNotNullParameter(r17, LynxResourceModule.URI_KEY);
        r16.j(r17, null, null, r5, r18);
    }
}
