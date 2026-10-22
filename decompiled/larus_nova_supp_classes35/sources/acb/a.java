package acb;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.PushSaveToNutStoreStateResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements com.ss.android.lark.sdk.f.a {
    public final /* synthetic */ e a;

    /* JADX INFO: renamed from: acb.a$a, reason: collision with other inner class name */
    public class C0006a implements g.b {
        public final /* synthetic */ a a;

        public C0006a(a r1) {
            this.a = r1;
        }

        public final void a(byte[] r5) {
            e r0 = this.a.a;
            r0.getClass();
            PushSaveToNutStoreStateResponse r6 = (PushSaveToNutStoreStateResponse) PushSaveToNutStoreStateResponse.ADAPTER.decode(r5);     // Catch: Exception -> L5
            String r1 = r6.message_id;     // Catch: Exception -> L5
            int r7 = r6.state.getValue();     // Catch: Exception -> L5
            CoreThreadPool.getDefault().getUIExecutor().execute(new b(r0, r1, r7));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            tt5.a.f(e.getMessage(), e, false);
        }
    }

    public final void a() {
        g.e.a.b(Command.PUSH_SAVE_TO_NUT_STORE_STATE, new C0006a(this));
    }

    public a(e r1) {
        this.a = r1;
    }
}
