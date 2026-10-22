package vda;

import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e extends ObricFloatChatPageState {
    public final boolean a;
    public int b;
    public final Float c;

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final String toString() {
        return super.toString() + "-velocity:" + this.c;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final int getHeight() {
        return this.b;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final boolean getUseAnim() {
        return this.a;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final void setHeight(int r1) {
        this.b = r1;
    }

    public e(boolean r7, int r8, Float r9) {
        super(false, 0, false, 7, null);
        this.a = r7;
        this.b = r8;
        this.c = r9;
    }
}
