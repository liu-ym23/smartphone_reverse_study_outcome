package z1;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.SocketState;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class j extends b {
    public j(@NonNull c.a r10) {
        super(r10);
    }

    @Override // z1.d
    public void a(Intent r10, com.bytedance.common.wschannel.model.a r11) {
        Logger.d("AbsWsClientService", "sync socket state");
        r10.setExtrasClassLoader(SocketState.class.getClassLoader());
        ArrayList r12 = r10.getParcelableArrayListExtra(WsConstants.KEY_CONNECTION);
        if (r12 == null) goto L10;
        Iterator r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L16;
        SocketState r14 = (SocketState) r13.next();
        if (r14 == null) goto L6;
        b(r14.getChannelId(), r14.getConnectionState(), r14.isPrivateProtocolEnabled());
        goto L6
    L16:
        return;
    }
}
