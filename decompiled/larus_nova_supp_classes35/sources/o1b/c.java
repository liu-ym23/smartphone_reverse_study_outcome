package o1b;

import com.alibaba.fastjson.JSON;
import com.bytedance.lark.pb.openplatform.v1.CommonEnum;
import com.bytedance.lark.pb.openplatform.v1.OpenAppBadgeNode;
import com.bytedance.lark.pb.openplatform.v1.PullOpenAppBadgeNodesRequest;
import com.bytedance.lark.pb.openplatform.v1.PullOpenAppBadgeNodesResponse;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyIdFeaturePair;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyLoadStrategy;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyOpenAppBadgeNode;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyOpenAppFeatureType;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyPullOpenAppBadgeNodesRequest;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyPullOpenAppBadgeNodesResponse;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {

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

    public static final PullOpenAppBadgeNodesRequest.Builder a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "params");
        PullOpenAppBadgeNodesRequest.Builder r1 = new PullOpenAppBadgeNodesRequest.Builder();     // Catch: Exception -> L41
        MyPullOpenAppBadgeNodesRequest r9 = (MyPullOpenAppBadgeNodesRequest) JSON.parseObject(r8, MyPullOpenAppBadgeNodesRequest.class);     // Catch: Exception -> L41
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L41
        Iterator<MyIdFeaturePair> r3 = r9.getIdFeaturePairs().iterator();     // Catch: Exception -> L41
    L5:
        if (r3.hasNext() == false) goto L23;
        MyIdFeaturePair r4 = r3.next();     // Catch: Exception -> L41
        PullOpenAppBadgeNodesRequest.IdFeaturePair.Builder r5 = new PullOpenAppBadgeNodesRequest.IdFeaturePair.Builder();     // Catch: Exception -> L41
        r5.app_id(r4.getAppId());     // Catch: Exception -> L41
        if (r4.getFeature() == null) goto L22;
        Integer r6 = r4.getFeature();     // Catch: Exception -> L41
        int r7 = MyOpenAppFeatureType.MiniApp.getValue();     // Catch: Exception -> L41
        if (r6 != null) goto L12;
    L14:
        int r10 = MyOpenAppFeatureType.H5.getValue();     // Catch: Exception -> L41
        if (r6 != null) goto L18;
    L20:
        CommonEnum.OpenAppFeatureType r11 = null;
    L21:
        r5.feature(r11);     // Catch: Exception -> L41
        goto L22
    L18:
        if (r6.intValue() != r10) goto L20;
        r11 = CommonEnum.OpenAppFeatureType.H5;     // Catch: Exception -> L41
        goto L21
    L12:
        if (r6.intValue() != r7) goto L14;
        r11 = CommonEnum.OpenAppFeatureType.MiniApp;     // Catch: Exception -> L41
    L22:
        r2.add(r5.build());     // Catch: Exception -> L41
        goto L5
    L23:
        r1.id_feature_pairs(r2);     // Catch: Exception -> L41
        r1.is_mobile(Boolean.valueOf(r9.isMobile()));     // Catch: Exception -> L41
        if (r9.getStrategy() == null) goto L39;
        Integer r12 = r9.getStrategy();     // Catch: Exception -> L41
        int r13 = MyLoadStrategy.Local.getValue();     // Catch: Exception -> L41
        if (r12 != null) goto L29;
    L31:
        int r14 = MyLoadStrategy.Net.getValue();     // Catch: Exception -> L41
        if (r12 != null) goto L35;
    L37:
        CommonEnum.LoadStrategy r15 = null;
    L38:
        r1.strategy(r15);     // Catch: Exception -> L41
        goto L39
    L35:
        if (r12.intValue() != r14) goto L37;
        r15 = CommonEnum.LoadStrategy.Net;     // Catch: Exception -> L41
        goto L38
    L29:
        if (r12.intValue() != r13) goto L31;
        r15 = CommonEnum.LoadStrategy.Local;     // Catch: Exception -> L41
    L39:
        r1.need_trigger_push(Boolean.valueOf(r9.getNeedTriggerPush()));     // Catch: Exception -> L41
        return r1;
    L41:
        return null;
    }

    public static final MyPullOpenAppBadgeNodesResponse b(PullOpenAppBadgeNodesResponse r12) {
        Intrinsics.checkNotNullParameter(r12, "value");
        ArrayList r0 = new ArrayList();
        Iterator r13 = r12.notice_nodes.iterator();
    L4:
        if (r13.hasNext() == false) goto L21;
        OpenAppBadgeNode r1 = (OpenAppBadgeNode) r13.next();
        String r3 = r1.id;
        String r4 = r1.app_id;
        CommonEnum.OpenAppFeatureType r2 = r1.feature;
        if (r2 != null) goto L8;
        int r5 = -1;
    L9:
        if (r5 != (-1)) goto L11;
        MyOpenAppFeatureType r6 = null;
    L19:
        r0.add(new MyOpenAppBadgeNode(r3, r4, r6, r1.need_show, r1.update_time, r1.badge_num.intValue(), r1.extra, r1.version));
        goto L4
    L11:
        if (r5 != 1) goto L13;
        r6 = MyOpenAppFeatureType.MiniApp;
        goto L19
    L13:
        if (r5 != 2) goto L16;
        r6 = MyOpenAppFeatureType.H5;
        goto L19
    L16:
        throw new NoWhenBranchMatchedException();
    L8:
        r5 = a.a[r2.ordinal()];
        goto L9
    L21:
        return new MyPullOpenAppBadgeNodesResponse(r0);
    }
}
