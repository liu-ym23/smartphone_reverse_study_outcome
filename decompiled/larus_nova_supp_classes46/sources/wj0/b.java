package wj0;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final IBaseUser a;
    public final TalkRoomBaseDynamicEmoji b;
    public final k c;
    public final m0 d;

    public b(IBaseUser r2, TalkRoomBaseDynamicEmoji r3, k r4, m0 r5) {
        Intrinsics.checkNotNullParameter(r2, "fromUser");
        Intrinsics.checkNotNullParameter(r3, "dynamicEmoji");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
