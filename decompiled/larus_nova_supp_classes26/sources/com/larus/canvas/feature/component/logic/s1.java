package com.larus.canvas.feature.component.logic;

import com.larus.bmhome.upload.ResourceUploader;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s1 implements Function1<Throwable, Unit> {
    public final /* synthetic */ String a;

    public s1(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r1) {
        Throwable r2 = (Throwable) r1;
        ResourceUploader r3 = ResourceUploader.a;
        ResourceUploader.c(this.a);
        return Unit.INSTANCE;
    }
}
