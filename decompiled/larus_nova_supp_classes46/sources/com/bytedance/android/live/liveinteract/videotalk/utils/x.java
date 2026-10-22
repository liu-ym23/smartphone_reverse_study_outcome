package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.graphics.Bitmap;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ z a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ ILinkPlayerInfoBridge c;
    public final /* synthetic */ ti6.f d;

    public x(z r1, Ref.ObjectRef r2, ILinkPlayerInfoBridge r3, ti6.f r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r7) {
        Bitmap r4 = (Bitmap) r7;
        this.a.d.put((String) this.b.element, r4);
        this.a.c(this.c, this.d, (String) this.b.element, r4, true);
    }
}
