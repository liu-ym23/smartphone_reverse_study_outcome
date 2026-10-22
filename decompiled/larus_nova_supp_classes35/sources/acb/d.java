package acb;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.PushSaveToSpaceStoreStateResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements com.ss.android.lark.sdk.f.a {
    public final /* synthetic */ e a;

    public class a implements g.b {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void a(byte[] r4) {
            PushSaveToSpaceStoreStateResponse r5 = (PushSaveToSpaceStoreStateResponse) PushSaveToSpaceStoreStateResponse.ADAPTER.decode(r4);     // Catch: Exception -> L4
            String r0 = r5.message_id;     // Catch: Exception -> L4
            int r6 = r5.state.getValue();     // Catch: Exception -> L4
            CoreThreadPool.getDefault().getUIExecutor().execute(new c(this, r0, r6));     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            tt5.a.f(e.getMessage(), e, false);
        }
    }

    public final void a() {
        g.e.a.b(Command.PUSH_SAVE_TO_SPACE_STORE_STATE, new a(this));
    }

    public d(e r1) {
        this.a = r1;
    }
}
