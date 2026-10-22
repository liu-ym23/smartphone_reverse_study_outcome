package t92;

import aa2.w;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import ec2.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends s92.a {
    public final Integer h;
    public long i;

    public a(IRoom r2, w r3, boolean r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "widget");
        super(r2, r3, r4, r5);
        this.h = (Integer) o.a.getValue();
        this.i = -1;
    }
}
