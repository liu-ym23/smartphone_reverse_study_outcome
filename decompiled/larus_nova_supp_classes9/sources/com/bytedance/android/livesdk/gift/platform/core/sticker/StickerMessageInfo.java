package com.bytedance.android.livesdk.gift.platform.core.sticker;

import android.os.Handler;
import com.bytedance.android.livesdk.gift.platform.core.model.w;
import com.bytedance.android.livesdk.message.model.o7;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class StickerMessageInfo {
    public final ed6.b<o7> a;
    public boolean b;
    public w c;
    public o7 d;
    public Map<String, Integer> e;
    public int f;
    public long g;
    public boolean h;
    public boolean i;
    public long j;
    public final Handler k;

    public StickerMessageInfo(Handler r3) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.k = r3;
        final StickerMessageInfo$otherMessages$1 r0 = new StickerMessageInfo$otherMessages$1(this);
        this.a = new ed6.b(new a(r0));
        this.e = new HashMap();
        this.g = 0;
        this.j = -1;
    }
}
