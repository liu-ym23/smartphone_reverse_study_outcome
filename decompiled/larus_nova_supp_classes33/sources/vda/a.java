package vda;

import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a extends ObricFloatChatPageState {
    public final float a;
    public int b;

    public a() {
        this(0.0f, 3);
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final String toString() {
        return super.toString() + "-velocity:" + this.a;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final int getHeight() {
        return this.b;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final void setHeight(int r1) {
        this.b = r1;
    }

    public a(float r7, int r8) {
        if ((r8 & 1) == 0) goto L5;
        r7 = 0.0f;
    L5:
        super(false, 0, false, 7, null);
        this.a = r7;
        this.b = 0;
    }
}
