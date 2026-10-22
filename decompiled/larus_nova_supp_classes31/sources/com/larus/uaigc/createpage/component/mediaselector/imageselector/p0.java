package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Lazy;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p0 implements ImageSelectorView.a {
    public final /* synthetic */ ImageSelectorComponent a;

    @Override // com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorView.a
    public final void a() {
        ImageSelectorComponent r0 = this.a;
        Lazy<Long> r1 = ImageSelectorComponent.X;
        r0.i4();
        ny9.u r2 = this.a.W3();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.d();
    L6:
        ny9.u r5 = this.a.W3();
        if (r5 == null) goto L9;
        String r6 = r5.getTemplateType();
    L10:
        ny9.u r7 = this.a.W3();
        if (r7 == null) goto L13;
        r3 = r7.h();
    L13:
        tx9.u3.f("delete", r4, r6, r3);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorView.a
    public final void b() {
        ImageSelectorComponent r0 = this.a;
        Lazy<Long> r1 = ImageSelectorComponent.X;
        r0.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), Dispatchers.getMain().getImmediate(), null, new ImageSelectorComponent$handleClickRetry$1(r0, null), 2, null);
    }

    public p0(ImageSelectorComponent r1) {
        this.a = r1;
    }

    @Override // com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorView.a
    public final void c(boolean r5) {
        ImageSelectorComponent r0 = this.a;
        Lazy<Long> r1 = ImageSelectorComponent.X;
        r0.j4();
        if (r5 == false) goto L5;
        String r6 = "upload";
    L6:
        ny9.u r2 = this.a.W3();
        String r3 = null;
        if (r2 == null) goto L9;
        String r4 = r2.d();
    L10:
        ny9.u r7 = this.a.W3();
        if (r7 == null) goto L13;
        String r8 = r7.getTemplateType();
    L14:
        ny9.u r9 = this.a.W3();
        if (r9 == null) goto L17;
        r3 = r9.h();
    L17:
        tx9.u3.f(r6, r4, r8, r3);
        return;
    L13:
        r8 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r6 = "replace";
        goto L6
    }
}
