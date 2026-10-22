package com.larus.bmhome.chat.deepresearch.component;

import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v implements mf9.d {
    public final /* synthetic */ DeepReSearchContentComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public final void onCancel() {
        FLogger r0 = FLogger.a;
        Map<String, Long> r1 = DeepReSearchContentComponent.M;
        r0.i("DeepSearchContent", "fetch deep research cancel , id = " + this.b + " curCursor = " + this.c);
    }

    public final void a(List<Block> r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        this.a.G3(r4, false);
        FLogger r0 = FLogger.a;
        Map<String, Long> r1 = DeepReSearchContentComponent.M;
        r0.d("DeepSearchContent", "fetch deep research update , id = " + this.b + " curCursor = " + this.c + " blocks = " + r4);
    }

    public final void b(List<Block> r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        this.a.G3(r4, true);
        FLogger r0 = FLogger.a;
        Map<String, Long> r1 = DeepReSearchContentComponent.M;
        r0.i("DeepSearchContent", "fetch deep research finish , id = " + this.b + " curCursor = " + this.c + " blocks = " + r4);
    }

    public final void onError(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        FLogger r0 = FLogger.a;
        Map<String, Long> r1 = DeepReSearchContentComponent.M;
        r0.e("DeepSearchContent", "fetch deep research error , id = " + this.b + " curCursor = " + this.c + " code = " + r4 + ", msg = " + r5);
    }

    public v(DeepReSearchContentComponent r1, String r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
