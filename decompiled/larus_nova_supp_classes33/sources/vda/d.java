package vda;

import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d extends ObricFloatChatPageState {
    public final boolean a;
    public final Float b;
    public final String c;

    public d() {
        this(true, null, "");
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final String toString() {
        return super.toString() + "-velocity:" + this.b + "-reason: " + this.c;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final boolean getUseAnim() {
        return this.a;
    }

    public d(boolean r8, Float r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, WindowEvent.Params.REASON);
        super(false, 0, false, 7, null);
        this.a = r8;
        this.b = r9;
        this.c = r10;
    }
}
