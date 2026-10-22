package zf0;

import com.bytedance.android.livesdk.chatroom.model.k1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends a {
    public final k1 d;

    public i(String r3, py.k r4, k1 r5) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "icon");
        Intrinsics.checkNotNullParameter(r5, "interactItem");
        super(r3, r4, r5.getType());
        this.d = r5;
    }
}
