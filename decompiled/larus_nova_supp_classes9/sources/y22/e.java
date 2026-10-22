package y22;

import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentEntry;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface e {
    CommentInputConfig a(CommentFlowContext r1);

    CommentFlowContext b(CommentEntry r1, Map r2);

    void c(CommentFlowContext r1);

    void d(CommentFlowContext r1);

    void destroy();

    boolean e(CommentFlowContext r1);

    void f(CommentFlowContext r1);

    String getName();
}
