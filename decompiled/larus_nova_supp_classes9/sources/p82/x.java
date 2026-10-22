package p82;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x extends a {
    public final RoomContext e;

    @Override // p82.a
    public final int e() {
        return 2131567229;
    }

    public x(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        super(PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL);
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (com.bytedance.android.livesdk.interactivity.api.asr.utils.a.a() == false) goto L8;
        if (((Boolean) this.e.isAnchor().getValue()).booleanValue() == false) goto L8;
        return true;
    L8:
        return PublicScreenStyleHelper.n;
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r3) {
        super.onClick(r3);
        if (com.bytedance.android.livesdk.interactivity.api.asr.utils.a.a() == false) goto L5;
        xs2.b.a().post(new o42.k("comment_operate_panel"));
    L6:
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r4 = this.c;
        if (r4 == null) goto L10;
        r4.dismissDialog();
        return;
    L10:
        return;
    L5:
        xs2.b.a().post(new o42.j("comment_operate_panel"));
        goto L6
    }
}
