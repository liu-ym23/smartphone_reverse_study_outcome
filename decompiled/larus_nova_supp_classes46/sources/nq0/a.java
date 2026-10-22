package nq0;

import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.message.model.a6;
import com.bytedance.android.livesdk.message.model.ph;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import ro0.b;
import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends b<ph> {
    public final MessageType d;

    @Override // ro0.b
    public final MessageType a() {
        return this.d;
    }

    public a(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.d = MessageType.OPEN_PLATFORM_HIGH_VALUE_USER_DATA_MESSAGE;
    }

    @Override // ro0.b
    public final void b(d r3) {
        ph r4 = (ph) r3;
        Intrinsics.checkNotNullParameter(r4, MultiLinkOpenSource.MESSAGE);
        a6 r5 = r4.E();
        if (r5 == null) goto L23;
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L11;
        f r1 = r0.user();
        if (r1 == null) goto L11;
        String r2 = r1.n();
        if (r2 == null) goto L11;
    L13:
        if (q0.a(r5.a()) == true) goto L15;
        return;
    L15:
        if ((!Intrinsics.areEqual(r5.a(), r2)) == true) goto L24;
        DataCenter r6 = this.b.getDataCenter();
        if (r6 == null) goto L22;
        r6.put("open_platform_high_value_comment_user", Boolean.valueOf(r5.b()));
        return;
    L22:
        return;
    L24:
        return;
    L11:
        r2 = "0";
        goto L13
    }
}
