package mmb;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.lark.dependency.k0;
import com.ss.android.lark.todo_api.ITodoApi;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements k0 {
    public b() {
    }

    public final void c(Fragment r2, int r3) {
        ((ITodoApi) LarkContext.spiByDwarf(ITodoApi.class)).startTodoAddAssigneeActivity(r2, r3);
    }

    public final void a(Fragment r2, String r3, int r4) {
        ((ITodoApi) LarkContext.spiByDwarf(ITodoApi.class)).startTodoCreateActivity(r2, r3, r4);
    }

    public final void b(Fragment r2, String r3, int r4) {
        ((ITodoApi) LarkContext.spiByDwarf(ITodoApi.class)).startTodoDisplayAssigneeActivity(r2, r3, r4);
    }
}
