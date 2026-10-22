package do8;

import com.larus.bmhome.chat.ChatParam;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements Function0<ChatParam> {
    public final /* synthetic */ AttachReceiver a;

    public g(AttachReceiver r1) {
        this.a = r1;
    }

    public final Object invoke() {
        AttachReceiver r0 = this.a;
        if ((r0 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(ChatParam.class));
    }
}
