package z1;

import android.content.Intent;
import android.os.Message;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {
    public f(@NonNull c.a r10) {
        super(r10);
    }

    @Override // z1.d
    public void a(Intent r10, @Nullable com.bytedance.common.wschannel.model.a r11) {
        r10.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        WsChannelMsg r12 = (WsChannelMsg) r10.getParcelableExtra(WsConstants.KEY_PAYLOAD);
        if (WsConstants.getOptLogic().get().booleanValue() == true) goto L9;
        Message r13 = new Message();
        r13.getData().putParcelable(WsConstants.KEY_PAYLOAD, r12);
        r13.getData().setClassLoader(WsChannelMsg.class.getClassLoader());
        Parcelable r14 = r13.getData().getParcelable(WsConstants.KEY_PAYLOAD);
        if ((r14 instanceof WsChannelMsg) == false) goto L8;
        r12 = (WsChannelMsg) r14;
        goto L9
    L8:
        r12 = null;
    L9:
        if (r12 != null) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("AbsWsClientService", "get wsChannelMsg = " + r12.toString());
    L13:
        if (r11 == null) goto L15;
        r12.receiveDataFromIpcTs = r11.f1368a;
    L15:
        this.f13752a.c(r12);
    }
}
