package yu1;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class c {
    private Function1<? super String, Unit> updateTitle;

    public c() {
    }

    public final Function1<String, Unit> getUpdateTitle() {
        return this.updateTitle;
    }

    public final void setUpdateTitle(Function1<? super String, Unit> r1) {
        this.updateTitle = r1;
    }
}
