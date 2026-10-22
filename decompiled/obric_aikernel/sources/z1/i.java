package z1;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
class i extends b {
    public i(@NonNull c.a r10) {
        super(r10);
    }

    @Override // z1.d
    public void a(Intent r10, com.bytedance.common.wschannel.model.a r11) {
        r10.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        String r12 = r10.getStringExtra(WsConstants.KEY_PAYLOAD_MD5);
        boolean r13 = r10.getBooleanExtra(WsConstants.KEY_SEND_RESULT, true);
        if (Logger.debug() == false) goto L5;
        Logger.d("AbsWsClientService", "get payloadMd5 = " + r12 + " sendResult = " + r13);
    L5:
        this.f13752a.f(r12, r13);
    }
}
