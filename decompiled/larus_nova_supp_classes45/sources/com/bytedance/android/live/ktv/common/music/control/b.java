package com.bytedance.android.live.ktv.common.music.control;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class b extends d {
    public final IMusicControlNode.OperationType f;
    public Context g;
    public String h;
    public String i;
    public boolean j;
    public final IRoom k;

    public static final class a {
    }

    static {
    }

    public void f(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "panel");
    }

    public void i(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "panel");
    }

    public void j(int r1, MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "panel");
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d
    public final void c() {
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        if (this.j == false) goto L8;
        f(this.d);
        return;
    L8:
        MusicPanel r1 = this.d;
        Intrinsics.checkNotNullParameter(r1, "panel");
        i(r1);
    }

    public final Context getContext() {
        return this.g;
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d, com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public IMusicControlNode.OperationType getType() {
        return this.f;
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d, com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public final void b(g r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        mb0.d.g("node_process", this.d);
        super.b(r3);
    }

    public final void g(MusicPanel r5) {
        Intrinsics.checkNotNullParameter(r5, "panel");
        r5.b = 1;
        j(2, r5);
        g r0 = this.c;
        if (r0 == null) goto L9;
        IMusicControlNode.OperationType r2 = getType();
        if (this.h != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("enterFrom");
    L7:
        r0.c(new IMusicControlNode.b(r2, r5), this);
        return;
    }

    public final void h(MusicPanel r5) {
        Intrinsics.checkNotNullParameter(r5, "panel");
        r5.b = 4;
        r5.w = System.currentTimeMillis();
        j(0, r5);
        g r0 = this.c;
        if (r0 == null) goto L9;
        IMusicControlNode.OperationType r2 = getType();
        if (this.h != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("enterFrom");
    L7:
        r0.b(new IMusicControlNode.b(r2, r5), this);
        return;
    }

    public b(MusicPanel r2, ModeType r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, "modeType");
        super(r2, r3);
        this.f = IMusicControlNode.OperationType.ADD_MUSIC;
        this.j = true;
        m r4 = o3.f().getRoom();
        if (r4 == null) goto L5;
        IRoom r5 = (IRoom) r4.getValue();
    L6:
        this.k = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static void e(b r2, Context r3, String r4, String r5, boolean r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 8) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 16) == 0) goto L11;
        r6 = true;
    L11:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        r2.g = r3;
        r2.h = r4;
        r2.i = r5;
        r2.j = r6;
    }
}
