package lh0;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.google.gson.JsonObject;
import ih0.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c {

    public static final class a {
        public static void a(h r2, JsonObject r3) {
            Intrinsics.checkNotNullParameter(r2, "updateCallback");
            r2.a(UpdateLinkmicStatusResultModel.Code.Success, "", r3);
        }

        public static /* synthetic */ void b(c r1, h r2) {
            r1.a(r2, null);
        }
    }

    void a(h r1, JsonObject r2);
}
