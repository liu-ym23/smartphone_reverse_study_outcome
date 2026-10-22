package oa1;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.screenrotation.rotate.RotateInnerRequest;
import com.bytedance.android.live.room.api.screenrotation.rotate.c;
import com.bytedance.android.live.room.api.screenrotation.rotate.d;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements c81.a {
    public static final b a = null;

    public b() {
    }

    @Override // c81.a
    public final String getTag() {
        return "RotateInterceptor";
    }

    static {
        a = new b();
    }

    @Override // c81.a
    public final boolean a(d r5, RotateInnerRequest r6) {
        Intrinsics.checkNotNullParameter(r5, "session");
        Intrinsics.checkNotNullParameter(r6, "request");
        RoomContext r0 = r5.a();
        Object r2 = null;
        if ((r0 instanceof RoomContext) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L21;
        z71.a r1 = z71.b.a(r0);
        if (r1 == null) goto L21;
        c r3 = r1.getHandleRegistry();
        if (r3 == null) goto L21;
        List<c81.a> r4 = r3.e();
        if (r4 == null) goto L21;
        Iterator<T> r7 = r4.iterator();
    L14:
        if (r7.hasNext() == false) goto L19;
        Object r8 = r7.next();
        if (((c81.a) r8).a(r5, r6) == false) goto L14;
        r2 = r8;
    L19:
        if (((c81.a) r2) == null) goto L21;
        SimpleAlogArgsBuilder r9 = new SimpleAlogArgsBuilder();
        r9.d("RotateInterceptor");
        r9.c("转屏被拦截了");
        f81.a.a(r9.b());
        return true;
    L21:
        return false;
    }
}
