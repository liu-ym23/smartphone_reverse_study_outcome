package ic8;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q0 {
    public static final p0 a(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (p0) GsonProtectorUtils.fromJson(new Gson(), r2.getContent(), p0.class);
    L5:
        return null;
    }
}
