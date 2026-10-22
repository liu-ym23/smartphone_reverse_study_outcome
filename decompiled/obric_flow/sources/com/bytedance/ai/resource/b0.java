package com.bytedance.ai.resource;

import com.ivy.ivykit.plugin.impl.applet.ResourcesLoadException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f2567c;
    public final /* synthetic */ Function1 d;

    public /* synthetic */ b0(String r5, long r10, Function1 r11, int r12) {
        this.f2565a = r12;
        this.f2566b = r5;
        this.f2567c = r10;
        this.d = r11;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r12) {
        switch(this.f2565a) {
            case 0: goto L14;
            default: goto L4;
        };
    L4:
        Throwable r13 = (Throwable) r12;
        Intrinsics.checkNotNullParameter(r13, "throwable");
        if ((r13 instanceof ResourcesLoadException) == false) goto L8;
        ResourcesLoadException r5 = (ResourcesLoadException) r13;
        int r10 = r5.f9504a;
        String r11 = r5.f9505b;
    L7:
        String r14 = r11;
        int r15 = r10;
        String r16 = "load resource failed. errorCode: " + r15 + ", errorMsg: " + r14;
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L12;
        r17.e("AppletResourceLoader", r16);
    L12:
        z2.d.e("applet_file_load_end", new d0(this.f2566b, r14, System.currentTimeMillis() - this.f2567c, null, r15));
        this.d.invoke(r13);
        return Unit.INSTANCE;
    L8:
        r11 = r13.getMessage();
        r10 = 1000;
        goto L7
    L14:
        com.ivy.ivykit.api.plugin.b r18 = (com.ivy.ivykit.api.plugin.b) r12;
        Intrinsics.checkNotNullParameter(r18, "response");
        z2.d.e("applet_file_load_end", new d0(this.f2566b, null, System.currentTimeMillis() - this.f2567c, r18.f9481c, 0));
        this.d.invoke(r18);
        return Unit.INSTANCE;
    }
}
