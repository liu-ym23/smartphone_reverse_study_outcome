package o1b;

import com.bytedance.lark.pb.openplatform.v1.CommonGadgetPushRequest;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyCommonGadgetPushRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final MyCommonGadgetPushRequest a(CommonGadgetPushRequest r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        return new MyCommonGadgetPushRequest(r4.is_online.booleanValue(), r4.biz, r4.timestamp, r4.data);
    }
}
