package o1b;

import com.bytedance.lark.pb.openplatform.v1.PushAppsNeedUpdateRequest;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyPushAppsNeedUpdateRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final MyPushAppsNeedUpdateRequest a(PushAppsNeedUpdateRequest r1) {
        Intrinsics.checkNotNullParameter(r1, "value");
        return new MyPushAppsNeedUpdateRequest(r1.timestamp);
    }
}
