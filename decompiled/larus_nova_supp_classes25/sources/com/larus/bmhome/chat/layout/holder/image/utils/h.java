package com.larus.bmhome.chat.layout.holder.image.utils;

import android.os.Bundle;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import ny9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements xy9.a {
    public final /* synthetic */ xy9.b a;
    public final /* synthetic */ CreationSendMessageConfig b;
    public final /* synthetic */ wc9.e c;
    public final /* synthetic */ Function0<Unit> d;
    public final /* synthetic */ Function4<ImageEditDataWithMask, String, String, u, Unit> e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public final void closePage() {
        this.a.dismiss();
    }

    public final void a(Bundle r36) {
        Intrinsics.checkNotNullParameter(r36, "bundle");
        ImageEditDataWithMask r1 = r36.getSerializable("image_edit_data.with_mask");
        if ((r1 instanceof ImageEditDataWithMask) == false) goto L5;
        ImageEditDataWithMask r2 = r1;
    L6:
        if (r2 == null) goto L20;
        CreationSendMessageConfig r4 = this.b;
        wc9.e r7 = this.c;
        Function0<Unit> r3 = this.d;
        Function4<ImageEditDataWithMask, String, String, u, Unit> r5 = this.e;
        String r6 = this.f;
        String r8 = this.g;
        ICreationPageService.a.getClass();
        if (ICreationPageService.a.a() == false) goto L17;
        AiCreationEditUtils r34 = AiCreationEditUtils.a;
        if (r4 == null) goto L12;
        CreationSendMessageConfig r9 = CreationSendMessageConfig.copy$default(r4, null, null, r7, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217723, null);
    L13:
        r34.getClass();
        if (r9 != null) goto L16;
        FLogger.a.e("AiCreationEditUtils", "sendImageRemoveMessageOpt creationSendMessageConfig is null");
        goto L20
    L16:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AiCreationEditUtils$sendImageRemoveMessageOpt$1(r9, r2, r3, null), 2, null);
        goto L20
    L12:
        r9 = null;
        goto L13
    L17:
        if (r5 == null) goto L19;
        AiCreationEditUtils.a.getClass();
        r5.invoke(r2, r6, r8, AiCreationEditUtils.d());
    L19:
        r3.invoke();
    L20:
        this.a.dismiss();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public h(xy9.b r1, CreationSendMessageConfig r2, wc9.e r3, Function0<Unit> r4, Function4<? super ImageEditDataWithMask, ? super String, ? super String, ? super u, Unit> r5, String r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
