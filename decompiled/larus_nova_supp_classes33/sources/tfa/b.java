package tfa;

import android.content.Context;
import com.larus.im.bean.message.Message;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.assistant.remote_card_container.widget.RemoteCardContainer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b extends oca.b {
    public final Lazy x;

    private final RemoteCardContainer getCardContainer() {
        return (RemoteCardContainer) this.x.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.x = LazyKt.lazy(new a(r2, this));
        addView(getCardContainer());
    }

    public final void o(AppIntentMessage r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "message");
        ufa.a.a.getClass();
        com.obric.assistant.remote_card_container.widget.a r4 = ufa.a.a(r3, r2);
        if (r4 != null) goto L6;
        p9a.b.b("RemoteCardBox", "cardInfo is null");
        return;
    L6:
        getCardContainer().setOnLongClickListener(getMOnLongClickListener());
        getCardContainer().b(r4);
    }
}
