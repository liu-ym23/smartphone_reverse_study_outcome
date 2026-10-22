package com.bytedance.android.live.effect.sticker.chain;

import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.livesdk.config.n9;
import com.bytedance.android.livesdk.config.o9;
import com.bytedance.android.livesdk.widget.x0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements m {
    public f() {
    }

    @Override // com.bytedance.android.live.effect.sticker.chain.m
    public final void a(l r7) {
        Intrinsics.checkNotNullParameter(r7, "chain");
        if (((Boolean) n9.a.getValue()).booleanValue() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
    L17:
        r7.a();
        return;
    L10:
        if (Intrinsics.areEqual(r7.g.getStickerPanel(), d0.c) == false) goto L17;
        if (r7.g.getTransferType() != 2) goto L17;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.X3.getValue()).booleanValue() == false) goto L16;
        r7.a();
        return;
    L16:
        Ref.BooleanRef r1 = new Ref.BooleanRef();
        r1.element = false;
        x0.b r3 = new x0.b(r7.getContext(), 4);
        x0.d r4 = r3.a;
        r4.l = false;
        r4.c = "提示";
        r4.d = "裸眼3D效果将开启云端渲染,开播后请在预览弹窗中预览或进入直播间查看效果;直播中可随时切换或关闭";
        r4.n = true;
        r4.o = "不再提示";
        r4.p = new c(r1);
        r3.j(1, "取消", new d(r7));
        r3.j(0, "继续", new e(r1, r7));
        r3.k(1, true);
        r3.k(0, true);
        r3.n();
        return;
    L5:
        if (((Boolean) o9.a.getValue()).booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }
}
