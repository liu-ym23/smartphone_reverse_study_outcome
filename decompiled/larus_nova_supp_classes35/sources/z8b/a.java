package z8b;

import com.bytedance.lark.pb.im.v2.GetContactTokenResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.contact.base.entity.bean.ContactAvatarSourceStrategy;
import com.ss.android.lark.contact.base.entity.bean.InvitationInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public InvitationInfo a;
    public InvitationInfo b;
    public ErrorResult c;

    public a() {
    }

    public static a a(GetContactTokenResponse r2, ContactAvatarSourceStrategy r3) {
        if (r2 == null) goto L4;
        a r0 = new a();
        r0.a = InvitationInfo.parseFromPb(r2.qr_code, r3);
        r0.b = InvitationInfo.parseFromPb(r2.link, r3);
        return r0;
    L4:
        return new a();
    }
}
