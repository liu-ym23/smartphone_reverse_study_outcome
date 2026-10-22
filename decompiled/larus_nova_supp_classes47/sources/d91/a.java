package d91;

import com.bytedance.android.livesdk.message.model.UserPrivilegeChangeMessage;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import rs0.t0;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements l {
    public final d a;
    public final String b;
    public final Function1<k, Unit> c;

    public final void onMessage(tlc.d r3) {
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        if ((r3 instanceof UserPrivilegeChangeMessage) == false) goto L13;
        UserPrivilegeChangeMessage r4 = (UserPrivilegeChangeMessage) r3;
        if (r4.H() == UserPrivilegeChangeMessage.UserPrivilegeType.AvatarBorder.getValue()) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r4.getUserIdStr(), this.b) == true) goto L9;
        return;
    L9:
        if (((Boolean) t0.a.getValue()).booleanValue() == false) goto L11;
        this.c.invoke(r4.G());
        return;
    L11:
        this.c.invoke(r4.E());
        return;
    }

    public a(d r2, String r3, Function1<? super k, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        Intrinsics.checkNotNullParameter(r4, "onUpdateAvatarBorder");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        r2.addMessageListener("WebcastUserPrivilegeChangeMessage", this);
    }
}
