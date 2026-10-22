package ah8;

import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c extends b {
    public final Message e;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.e, ((c) r4).e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    public final String toString() {
        return "WidgetCellState(widgetMessage=" + this.e + ')';
    }

    @Override // xc8.b
    public final int d() {
        Integer r0 = WidgetRenderDelegate.a.o(this.a.getContent());
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public c(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetMessage");
        super(r2);
        this.e = r2;
    }
}
