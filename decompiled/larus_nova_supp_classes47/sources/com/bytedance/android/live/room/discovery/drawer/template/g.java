package com.bytedance.android.live.room.discovery.drawer.template;

import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdkapi.depend.model.live.DrawerConfig;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ LiveDrawerEntranceCommonWidget a;

    public g(LiveDrawerEntranceCommonWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        LiveDrawerEntranceCommonWidget r3 = (LiveDrawerEntranceCommonWidget) r2;
        DrawerConfig r4 = this.a.b;
        if (r4 == null) goto L15;
        DrawerConfig.EntranceIcon r5 = r4.getEntranceIcon();
        if (r5 == null) goto L15;
        if (r5.getAnimStopMethod() != 1) goto L15;
        SimpleDraweeView r6 = this.a.c;
        if (r6 == null) goto L15;
        DraweeController r7 = r6.getController();
        if (r7 == null) goto L15;
        Animatable r8 = r7.getAnimatable();
        if (r8 == null) goto L15;
        r8.stop();
    L15:
        this.a.d = true;
    }
}
