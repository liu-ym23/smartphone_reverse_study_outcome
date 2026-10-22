package com.bytedance.ai.resource;

import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBeanKt;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.l f2743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f0 f2744c;

    public m(String r5, kotlinx.coroutines.l r10, f0 r11) {
        this.f2742a = r5;
        this.f2743b = r10;
        this.f2744c = r11;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        com.ivy.ivykit.api.plugin.b r10 = (com.ivy.ivykit.api.plugin.b) r5;
        Intrinsics.checkNotNullParameter(r10, "manifestInfo");
        AIPackageManifestBean r11 = AIPackageManifestBean.Companion.parseManifestJson(r10.f9479a);
        kotlinx.coroutines.l r12 = this.f2743b;
        if (r11 != null) goto L8;
        String r13 = androidx.room.jarjarred.org.antlr.runtime.a.v(new StringBuilder("failed to parse manifest. packageName: "), this.f2742a, "AIPackageManager", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L7;
        r14.e("AIPackageManager", r13);
    L7:
        r12.resumeWith(Result.m124constructorimpl(null));
    L19:
        return Unit.INSTANCE;
    L8:
        String r15 = r11.getScmVersion();
        f0 r16 = this.f2744c;
        r16.f2722j = r15;
        r16.f2721i = r11.getVersionCode();
        Applet r17 = AIPackageManifestBeanKt.a(r11);
        String r18 = r10.f9481c;
        if (r17 == null) goto L11;
        r17.B = r18;
        Intrinsics.checkNotNullParameter(r17, "applet");
        r16.b(r17);
    L11:
        ArrayList r19 = AIPackageManifestBeanKt.b(r11);
        if (r19 == null) goto L17;
        Iterator r20 = r19.iterator();
    L15:
        if (r20.hasNext() == false) goto L17;
        Widget r21 = (Widget) r20.next();
        r21.B = r18;
        Intrinsics.checkNotNullParameter(r21, "widget");
        r16.b(r21);
    L17:
        r12.resumeWith(Result.m124constructorimpl(r16));
        goto L19
    }
}
