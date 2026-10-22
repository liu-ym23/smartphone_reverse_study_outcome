package y32;

import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a extends ExternalBaseMessage {
    public boolean a;

    public abstract InteractivityMessageType E();

    public final void setLocalInsertMsg(boolean r1) {
    }

    public final boolean supportDisplayText() {
        return false;
    }

    public final ExternalMessageType getExternalMessageType() {
        return E().getExternalMessageType();
    }

    public final int getIntType() {
        return E().getMessageIntType();
    }

    public a() {
    }

    public final boolean isTooMuchMsg() {
        return this.a;
    }

    public final void setTooMuchMsg(boolean r1) {
        this.a = r1;
    }
}
