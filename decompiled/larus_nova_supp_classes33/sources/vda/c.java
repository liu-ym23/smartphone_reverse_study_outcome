package vda;

import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c extends ObricFloatChatPageState {
    public int a;
    public final ObricFloatChatPageState b;

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final int getHeight() {
        return this.a;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final void setHeight(int r1) {
        this.a = r1;
    }

    public c(int r7, ObricFloatChatPageState r8) {
        super(false, 0, false, 7, null);
        this.a = r7;
        this.b = r8;
    }
}
