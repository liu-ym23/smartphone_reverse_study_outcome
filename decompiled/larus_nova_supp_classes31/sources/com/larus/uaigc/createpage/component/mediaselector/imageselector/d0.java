package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.uaigc.service.ICreationResourceAccessService;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class d0 implements Function2 {
    public final /* synthetic */ ImageSelectorComponent a;

    public /* synthetic */ d0(ImageSelectorComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r14, Object r15) {
        ImageSelectorComponent r6 = this.a;
        mr9.l r4 = (mr9.l) r14;
        String r2 = (String) r15;
        Lazy<Long> r16 = ImageSelectorComponent.X;
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r2, "localFilePath");
        r6.getClass();
        com.larus.uaigc.helper.f.a.getClass();
        boolean r17 = com.larus.uaigc.helper.f.a();
        if (r17 == true) goto L5;
        nz9.b.e("upload", "0", null);
    L5:
        if (r17 == false) goto L7;
        com.larus.bmhome.resource.access.f0 r1 = ICreationResourceAccessService.a.c(r6.J);
        r6.F = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r6), Dispatchers.getMain().getImmediate(), null, new ImageSelectorComponent$handleResourceAccessSuccess$1(r1, r2, r6, r4, null), 2, null);
    L9:
        return Unit.INSTANCE;
    L7:
        r6.F = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r6), Dispatchers.getMain().getImmediate(), null, new ImageSelectorComponent$handleUploadSuccess$1(r4, r6, r2, null), 2, null);
        goto L9
    }
}
