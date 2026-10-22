package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ z a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ ILinkPlayerInfoBridge c;
    public final /* synthetic */ ti6.f d;

    public y(z r1, Ref.ObjectRef r2, ILinkPlayerInfoBridge r3, ti6.f r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r9) {
        ALogger.e("VideoTalkAudioMixerV2", (Throwable) r9);
        z r10 = this.a;
        r10.d.put((String) this.b.element, r10.f);
        z r2 = this.a;
        r2.c(this.c, this.d, (String) this.b.element, r2.f, true);
    }
}
