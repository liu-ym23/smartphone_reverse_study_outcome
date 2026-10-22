package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.model.ModeType;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class c extends d {
    public final IMusicControlNode.OperationType f;
    public final o g;
    public boolean h;
    public final boolean i;

    public void e(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
    }

    public void g(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
    }

    public void h() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d
    public final void c() {
        if (this.i == false) goto L5;
        e(this.d);
        return;
    L5:
        g(this.d);
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d
    public final void d() {
        super.d();
        h();
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d, com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public IMusicControlNode.OperationType getType() {
        return this.f;
    }

    public final void f(MusicPanel r4) {
        Intrinsics.checkNotNullParameter(r4, "panel");
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        g r1 = this.c;
        if (r1 == null) goto L8;
        r1.c(new IMusicControlNode.b(getType(), r4), this);
    L8:
        h();
    }

    public c(MusicPanel r2, boolean r3, ModeType r4) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "modeType");
        super(r2, r4);
        this.i = r3;
        this.f = IMusicControlNode.OperationType.CUT_MUSIC;
        this.g = o3.f();
    }
}
