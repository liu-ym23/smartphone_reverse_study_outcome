package com.bytedance.android.live.effect.common;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public final Lazy a;
    public final Lazy b;
    public final List<Sticker> c;
    public final LiveEffectContextFactoryDelegate$Type d;

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.d;
    }

    public a(LiveEffectContextFactoryDelegate$Type r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter("live_camera_move", "panel");
        this.d = r3;
        this.a = LazyKt.lazy(new AbsLiveStickerCommonPresenter$composerManager$2(this));
        this.b = LazyKt.lazy(new AbsLiveStickerCommonPresenter$stickerDownloadHelper$2(this));
        this.c = new ArrayList();
    }
}
