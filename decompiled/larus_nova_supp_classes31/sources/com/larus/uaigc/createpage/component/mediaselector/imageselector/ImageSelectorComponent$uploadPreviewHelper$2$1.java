package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class ImageSelectorComponent$uploadPreviewHelper$2$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public ImageSelectorComponent$uploadPreviewHelper$2$1(Object r8) {
        super(0, r8, ImageSelectorComponent.class, "showFull", "showFull()Z", 0);
    }

    public final Boolean invoke() {
        ImageSelectorComponent r0 = (ImageSelectorComponent) ((CallableReference) this).receiver;
        Lazy<Long> r1 = ImageSelectorComponent.X;
        return Boolean.valueOf(r0.h5());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m105invoke() {
        return invoke();
    }
}
