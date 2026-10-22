package u92;

import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdk.interactivity.textmessage.model.b0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements j {
    public final IRoom a;

    public h(IRoom r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "textMessage");
        if ((r4 instanceof b0) == false) goto L24;
        b0 r5 = (b0) r4;
        b4 r0 = r5.b;
        String r1 = null;
        if (r0 == null) goto L7;
        IBaseUser r2 = r0.getUser();
    L8:
        IRoom r3 = this.a;
        if (r3 == null) goto L11;
        IBaseUser r6 = r3.getOwner();
    L12:
        if (r2 == null) goto L14;
        String r7 = r2.getIdString();
    L15:
        if (r6 == null) goto L18;
        r1 = r6.getIdString();
    L18:
        if (Intrinsics.areEqual(r7, r1) == false) goto L25;
        b4 r8 = r5.b;
        if (r8 == null) goto L26;
        r8.L1(r6);
        return false;
    L26:
        return false;
    L25:
        return false;
    L14:
        r7 = null;
        goto L15
    L11:
        r6 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    L24:
        return false;
    }
}
