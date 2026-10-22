package o1b;

import com.bytedance.lark.pb.openplatform.v1.CommonEnum;
import com.bytedance.lark.pb.openplatform.v1.OpenAppBadgeNode;
import com.bytedance.lark.pb.openplatform.v1.PushOpenAppBadgeNodesRequest;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyOpenAppBadgeNode;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyOpenAppFeatureType;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyPushOpenAppBadgeNodesRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CommonEnum.OpenAppFeatureType.values().length];
            r0[CommonEnum.OpenAppFeatureType.MiniApp.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CommonEnum.OpenAppFeatureType.H5.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final MyPushOpenAppBadgeNodesRequest a(PushOpenAppBadgeNodesRequest r13) {
        Intrinsics.checkNotNullParameter(r13, "value");
        String r0 = r13.sid;
        List r14 = r13.notice_nodes;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L21;
        OpenAppBadgeNode r2 = (OpenAppBadgeNode) r15.next();
        String r4 = r2.id;
        String r5 = r2.app_id;
        CommonEnum.OpenAppFeatureType r3 = r2.feature;
        if (r3 != null) goto L8;
        int r6 = -1;
    L9:
        if (r6 != (-1)) goto L11;
        MyOpenAppFeatureType r7 = null;
    L19:
        r1.add(new MyOpenAppBadgeNode(r4, r5, r7, r2.need_show, r2.update_time, r2.badge_num.intValue(), r2.extra, r2.version));
        goto L4
    L11:
        if (r6 != 1) goto L13;
        r7 = MyOpenAppFeatureType.MiniApp;
        goto L19
    L13:
        if (r6 != 2) goto L16;
        r7 = MyOpenAppFeatureType.H5;
        goto L19
    L16:
        throw new NoWhenBranchMatchedException();
    L8:
        r6 = a.a[r3.ordinal()];
        goto L9
    L21:
        return new MyPushOpenAppBadgeNodesRequest(r1, r0);
    }
}
