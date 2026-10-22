package oa1;

import com.bytedance.android.live.room.api.screenrotation.rotate.RotateInnerRequest;
import com.bytedance.android.live.room.api.screenrotation.rotate.d;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements c81.a {
    public static final a a = null;

    public a() {
    }

    @Override // c81.a
    public final String getTag() {
        return "RoomRotateInterceptor";
    }

    static {
        a = new a();
    }

    @Override // c81.a
    public final boolean a(d r2, RotateInnerRequest r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "request");
        RoomContext r4 = r2.a();
        if (r4 == null) goto L11;
        n r5 = r4.getExternalConfigJudger();
        if (r5 == null) goto L13;
        IExternalConfigJudger r6 = (IExternalConfigJudger) r5.getValue();
        if (r6 != null) goto L9;
        return false;
    L9:
        if (r6.disable(EXTERNAL_CONFIG_TYPE.OrientationChange, "orientationChange") != true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L11:
        return false;
    }
}
