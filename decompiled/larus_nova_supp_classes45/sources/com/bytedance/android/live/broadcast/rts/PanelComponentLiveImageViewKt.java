package com.bytedance.android.live.broadcast.rts;

import com.relax.relaxframework.TapEvent;
import com.relax.relaxframework.j5;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PanelComponentLiveImageViewKt {
    public static final Function1<TapEvent, Unit> a = null;
    public static final Function2<j, Function0<? extends ArrayList<j5>>, j5> b = null;

    static {
        PanelComponentLiveImageViewKt$LiveBaseCustomImage$1 r0 = PanelComponentLiveImageViewKt$LiveBaseCustomImage$1.INSTANCE;
        a = PanelComponentLiveImageViewKt$noop$1.INSTANCE;
        b = PanelComponentLiveImageViewKt$LiveCustomImageView$1.INSTANCE;
    }
}
