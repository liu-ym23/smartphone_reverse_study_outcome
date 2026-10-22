package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdk.message.model.d4;
import com.bytedance.android.livesdkapi.message.Text;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v0 extends com.bytedance.android.livesdk.interactivity.api.publicscreen.x implements u32.l.a {
    public static final /* synthetic */ int c = 0;
    public final RoomContext b;

    public static final class a {
    }

    @Override // u32.l.a
    public final void d(u32.l r1, int r2, int r3, Text r4, Text r5) {
        Intrinsics.checkNotNullParameter(r1, "vm");
        Intrinsics.checkNotNullParameter(r4, "normalText");
        Intrinsics.checkNotNullParameter(r5, "joinText");
    }

    static {
        int r1 = MessageCommonColorUtil.a;
        new com.bytedance.android.livesdk.interactivity.api.publicscreen.s.a(MessageCommonColorUtil.d(), MessageCommonColorUtil.b());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
        DiggContext r0 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(this.b);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.j<u32.l> r1 = r0.getDoubleLikeManager();
        if (r1 == null) goto L11;
        u32.l r2 = (u32.l) r1.getValue();
        if (r2 == null) goto L12;
        r2.removeListener(this);
        return;
    L12:
        return;
    L11:
        return;
    }

    public v0(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        DiggContext r3 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(this.b);
        if (r3 == null) goto L10;
        com.bytedance.live.datacontext.j<u32.l> r4 = r3.getDoubleLikeManager();
        if (r4 == null) goto L11;
        u32.l r5 = (u32.l) r4.getValue();
        if (r5 == null) goto L12;
        r5.addListener(this, false);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // u32.l.a
    public final void b(u32.l r3, com.bytedance.android.livesdk.interactivity.api.like.model.a r4) {
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "detail");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "detail");
    }

    @Override // u32.l.a
    public final void e(u32.l r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "vm");
        Intrinsics.checkNotNullParameter(r1, "vm");
    }

    @Override // u32.l.a
    public final void k(u32.l r3, List<d4> r4) {
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "userRank");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "userRank");
    }

    @Override // u32.l.a
    public final void l(u32.l r3, com.bytedance.android.livesdk.interactivity.api.like.model.a r4) {
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "detail");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "detail");
    }
}
