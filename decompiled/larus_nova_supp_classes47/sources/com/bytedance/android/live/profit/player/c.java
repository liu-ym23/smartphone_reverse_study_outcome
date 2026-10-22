package com.bytedance.android.live.profit.player;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ EnterEffectProfilePreviewView a;
    public final /* synthetic */ ITextureViewPlayerController b;
    public final /* synthetic */ String c;

    public c(EnterEffectProfilePreviewView r1, ITextureViewPlayerController r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r10) {
        s r12 = (s) r10;
        List r0 = (List) r12.b();
        if (r0 != null) goto L9;
        StringBuilder r1 = new StringBuilder("MaskSrc list create failed: ");
        Throwable r13 = r12.a();
        if (r13 == null) goto L7;
        String r14 = r13.getMessage();
    L8:
        r1.append(r14);
        ALogger.w("EnterEffectProfilePreview", r1.toString());
        return;
    L7:
        r14 = null;
        goto L8
    L9:
        ITextureViewPlayerController r15 = this.b;
        Iterator<T> r2 = r0.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        r15.setMaskSrc((MaskSrc) r2.next());
        goto L11
    L13:
        this.b.attachAlphaView(this.a);
        ITextureViewPlayerController.DefaultImpls.start$default(this.b, this.c, true, false, false, null, 28, null);
    }
}
