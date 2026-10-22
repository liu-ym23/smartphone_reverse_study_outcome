package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x implements Function1<Boolean, Unit> {
    public final /* synthetic */ PictureSaveActionSheet a;
    public final /* synthetic */ String b;

    public final Object invoke(Object r9) {
        if (((Boolean) r9).booleanValue() == false) goto L6;
        PictureSaveActionSheet r10 = this.a;
        String r0 = this.b;
        int r1 = PictureSaveActionSheet.j;
        r10.getClass();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PictureSaveActionSheet$doDownloadImg$1(r10, r0, null), 3, null);
    L6:
        return Unit.INSTANCE;
    }

    public x(PictureSaveActionSheet r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
