package com.obric.assistant.remote_card_container.im;

import android.content.Context;
import com.obric.assistant.card.list.cell.AppEntityCell;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tfa.b;
import tfa.c;
import xc8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/remote_card_container/im/RemoteCardCell;", "Lcom/obric/assistant/card/list/cell/AppEntityCell;", "Lcom/obric/assistant/remote_card_container/im/RemoteCardCellState;", "Lcom/obric/assistant/remote_card_container/im/RemoteCardBox;", "<init>", "()V", "box", "getBox", "()Lcom/obric/assistant/remote_card_container/im/RemoteCardBox;", "setBox", "(Lcom/obric/assistant/remote_card_container/im/RemoteCardBox;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "createBox", "Lcom/larus/bmhome/chat/cell/MessageBox;", "context", "Landroid/content/Context;", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteCardCell extends AppEntityCell<c, b> {
    public b j;
    public final String k;

    public final oca.b r() {
        b r0 = this.j;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("box");
        return null;
    L7:
        return r0;
    }

    public RemoteCardCell() {
        this.k = "RemoteCardCell";
    }

    public final String s() {
        return this.k;
    }

    public final h o(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        b r0 = new b(r2);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.j = r0;
        return r0;
    }
}
