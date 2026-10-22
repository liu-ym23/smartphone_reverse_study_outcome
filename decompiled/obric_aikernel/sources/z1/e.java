package z1;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.SocketState;

/* JADX INFO: loaded from: classes.dex */
class e extends b {
    public e(@NonNull c.a r10) {
        super(r10);
    }

    @Override // z1.d
    public void a(Intent r10, com.bytedance.common.wschannel.model.a r11) {
        r10.setExtrasClassLoader(SocketState.class.getClassLoader());
        SocketState r12 = (SocketState) r10.getParcelableExtra(WsConstants.KEY_CONNECTION);
        ConnectionState r13 = b(r12.getChannelId(), r12.getConnectionState(), r12.isPrivateProtocolEnabled());     // Catch: Throwable -> L5
        this.f13752a.b(new com.bytedance.common.wschannel.event.a(r13, r12.getChannelType(), r12.getChannelId(), r12.getErrorCode()), r12.toJson());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
