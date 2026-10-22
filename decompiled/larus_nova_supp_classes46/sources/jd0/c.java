package jd0;

import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final IMessageBoardInfo f;

    public c() {
        this(0);
    }

    public /* synthetic */ c(int r8) {
        this("", "", false, false, false, (IMessageBoardInfo) vh7.f.c(IMessageBoardInfo.class));
    }

    public c(String r2, String r3, boolean r4, boolean r5, boolean r6, IMessageBoardInfo r7) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "secUid");
        Intrinsics.checkNotNullParameter(r7, "messageBoardInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
