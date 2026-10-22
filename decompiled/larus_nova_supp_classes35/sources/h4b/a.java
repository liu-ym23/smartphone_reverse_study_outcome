package h4b;

import android.graphics.Point;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements e6b.b.a<y6b.a<?>, h3b.b> {
    public final /* synthetic */ c.a a;

    public a(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.c r1) {
        this.a = r1;
    }

    @Override // e6b.b.a
    public final void d(m r2, y6b.a<?> r3) {
        h3b.b r4 = (h3b.b) r2;
        y6b.a<?> r5 = r3;
        Intrinsics.checkNotNullParameter(r4, "cell");
        Intrinsics.checkNotNullParameter(r5, Keys.API_RETURN_KEY_DATA);
        c.a r0 = this.a;
        y6b.c<?> r6 = (y6b.c) r5;
        BlueprintCellViewHolder r7 = ((BlueprintCell) r4).h;
        if (r7 == null) goto L6;
        r0.b(r6, r7.getLayoutPosition());
        return;
    }

    @Override // e6b.b.a
    public final boolean c(m r4, y6b.a<?> r5, Point r6) {
        h3b.b r7 = (h3b.b) r4;
        y6b.a<?> r8 = r5;
        Intrinsics.checkNotNullParameter(r7, "cell");
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r6, "touchEventOnWindow");
        return this.a.a((y6b.c) r8, new com.ss.android.lark.chat.message.menu.context.a(r7, r8, r6));
    }

    @Override // e6b.b.a
    public final void h(m r2, y6b.a<?> r3, Point r4) {
        Intrinsics.checkNotNullParameter((h3b.b) r2, "cell");
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r4, "touchEventOnWindow");
    }
}
