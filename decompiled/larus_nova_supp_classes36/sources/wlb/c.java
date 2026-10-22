package wlb;

import android.content.Intent;
import com.ss.android.lark.inline.ai.api.ui.InlineAIPanel;
import com.ss.android.lark.inline.ai.api.ui.PromptGroup;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface c {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(c r2, List r3, String r4, boolean r5, Function0 r6, int r7) {
            if ((r7 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r7 & 4) == 0) goto L9;
            r5 = false;
        L9:
            if ((r7 & 8) == 0) goto L11;
            r6 = null;
        L11:
            r2.b(r3, r4, r5, r6);
        }
    }

    void a();

    void b(List<PromptGroup> r1, String r2, boolean r3, Function0<Unit> r4);

    void c();

    void d(InlineAIPanel r1);

    void destroy();

    i1<Boolean> isShowing();

    void onActivityResult(int r1, int r2, Intent r3);

    boolean onBackPressed();
}
