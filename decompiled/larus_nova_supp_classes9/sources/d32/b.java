package d32;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.utils.CommentControlSwitchHelper;
import com.bytedance.android.livesdk.sharedpref.e;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "e");
        e<Long> r0 = CommentControlSwitchHelper.a;
        ALogger.w("CommentControlSwitchHelper", "fetchCommentControlMessage error " + r4.getMessage());
    }
}
