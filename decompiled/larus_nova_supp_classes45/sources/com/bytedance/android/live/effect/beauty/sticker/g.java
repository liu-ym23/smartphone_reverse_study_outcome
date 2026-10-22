package com.bytedance.android.live.effect.beauty.sticker;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements ObservableOnSubscribe {
    public final /* synthetic */ LiveStickerListAdapter a;
    public final /* synthetic */ List b;

    public g(LiveStickerListAdapter r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        Iterator r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Sticker r1 = com.bytedance.android.live.effect.sticker.d.b((Effect) r0.next());
        r1.setStickerPanel(this.a.p);
        ((ArrayList) this.a.b).add(r1);
        List<Long> r2 = this.a.c;
        ArrayList r3 = (ArrayList) r2;
        r3.add(Long.valueOf(r1.getId()));
        goto L4
    L6:
        r6.onComplete();
    }
}
