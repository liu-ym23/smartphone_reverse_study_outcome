package hy;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.multianchor.model.ListUserLinkmicContent;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final AnchorLinkUser a(List<AnchorLinkUser> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getOrganizer");
        Iterator<AnchorLinkUser> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        AnchorLinkUser r0 = r4.next();
        if (r0.getAnchorAuthRole() != ListUserLinkmicContent.AnchorAuthRole.AnchorAuthRoleOrganizer.ordinal()) goto L4;
        return r0;
    L8:
        return null;
    }

    public static final String b(List<AnchorLinkUser> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toAnchorLinkString");
        StringBuilder r0 = new StringBuilder("LinkAnchors{size=");
        r0.append(r5.size());
        r0.append(",");
        Iterator<AnchorLinkUser> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L29;
        AnchorLinkUser r2 = r6.next();
        r0.append("[");
        if (r2.getUser() == null) goto L19;
        r0.append("id=");
        IBaseUser r3 = r2.getUser();
        Long r4 = null;
        if (r3 == null) goto L10;
        String r7 = r3.getIdString();
    L11:
        r0.append(r7);
        r0.append(",name=");
        IBaseUser r8 = r2.getUser();
        if (r8 == null) goto L14;
        String r9 = r8.getNickName();
    L15:
        r0.append(r9);
        r0.append(",room=");
        IBaseUser r11 = r2.getUser();
        if (r11 == null) goto L18;
        r4 = Long.valueOf(r11.getLiveRoomId());
    L18:
        r0.append(r4);
        r0.append(",");
        goto L19
    L14:
        r9 = null;
        goto L15
    L10:
        r7 = null;
    L19:
        r0.append("link_id=");
        r0.append(r2.getLinkMicIdStr());
        r0.append(",link_status=");
        r0.append(r2.getStatus());
        r0.append(",");
        if (r2.getPkRole() == 0) goto L23;
        r0.append("pk_role=");
        r0.append(r2.getPkRole());
        r0.append(",");
    L23:
        if (r2.getAnchorLinkMicIdInfo() == null) goto L26;
        r0.append("linkMicIdInfo=");
        r0.append(r2.getAnchorLinkMicIdInfo());
        r0.append(",");
    L26:
        if (r2.getAnchorAuthRole() == 0) goto L28;
        r0.append("anchor_auth_role=");
        r0.append(r2.getAnchorAuthRole());
    L28:
        r0.append("]");
        goto L4
    L29:
        r0.append("}");
        return r0.toString();
    }
}
