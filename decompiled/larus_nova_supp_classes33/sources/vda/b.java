package vda;

import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b extends ObricFloatChatPageState {
    public int a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final String toString() {
        return super.toString() + "-moveTaskToBack:" + this.b + "-fromUser:" + this.c + "-isUseOverlayAnim:" + this.d;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final int getHeight() {
        return this.a;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final void setHeight(int r1) {
        this.a = r1;
    }

    public b(int r7, boolean r8, boolean r9, boolean r10) {
        super(false, r7, false, 5, null);
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
    }
}
