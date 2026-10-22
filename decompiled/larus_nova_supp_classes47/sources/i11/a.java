package i11;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.n;
import com.bytedance.android.livesdk.link.model.IListUserLinkmicContent;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.q;
import com.bytedance.android.livesdk.message.model.qj;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final String a(i6 r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$anchorLinkBaseInfoStr");
        StringBuilder r0 = new StringBuilder("(msgId=");
        r0.append(qj.a(r3));
        r0.append(" linkerId=");
        Intrinsics.checkNotNullParameter(r3, "$this$linkerIdExt");
        r0.append(r3.getLinkerId());
        r0.append(" scene=");
        Intrinsics.checkNotNullParameter(r3, "$this$sceneExt");
        r0.append(r3.getScene());
        r0.append(')');
        return r0.toString();
    }

    public static final p b(List<? extends p> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getOrganizer");
        Iterator<? extends p> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        p r0 = r4.next();
        if (q.a(r0) != IListUserLinkmicContent.IAnchorAuthRole.AnchorAuthRoleOrganizer.ordinal()) goto L4;
        return r0;
    L8:
        return null;
    }

    public static final String c(List<? extends p> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toAnchorLinkString");
        StringBuilder r0 = new StringBuilder("LinkAnchors{size=");
        r0.append(r5.size());
        r0.append(",");
        Iterator<? extends p> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L18;
        p r2 = r6.next();
        r0.append("[");
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L8;
        r0.append("id=");
        r0.append(r3.getIdString());
        r0.append(",name=");
        r0.append(r3.getNickName());
        r0.append(",room=");
        r0.append(n.a(r3));
        r0.append(",");
    L8:
        r0.append("link_id=");
        r0.append(r2.getLinkMicIdStr());
        r0.append(",status=");
        r0.append(r2.getStatus());
        if (q.d(r2) == 0) goto L12;
        r0.append(",pk_role=");
        r0.append(q.d(r2));
    L12:
        if (q.b(r2) == null) goto L15;
        r0.append(",linkMicIdInfo=");
        r0.append(q.b(r2));
    L15:
        if (q.a(r2) == 0) goto L17;
        r0.append(",anchor_auth_role=");
        r0.append(q.a(r2));
    L17:
        r0.append("]");
        goto L4
    L18:
        r0.append("}");
        return r0.toString();
    }

    public static final String d(List<? extends p> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toAnchorLinkStringEx");
        return c(CollectionsKt.toList(r1));
    }
}
