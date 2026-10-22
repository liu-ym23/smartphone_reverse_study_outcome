package vda;

import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f extends ObricFloatChatPageState {
    public final boolean a;

    public f() {
        this(true);
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final boolean getUseAnim() {
        return this.a;
    }

    public f(boolean r7) {
        super(false, 0, false, 7, null);
        this.a = r7;
    }
}
