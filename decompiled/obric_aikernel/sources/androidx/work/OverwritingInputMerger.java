package androidx.work;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class OverwritingInputMerger extends InputMerger {
    public OverwritingInputMerger() {
    }

    @Override // androidx.work.InputMerger
    @NonNull
    public Data merge(@NonNull List<Data> r10) {
        Data.Builder r11 = new Data.Builder();
        HashMap r12 = new HashMap();
        Iterator<Data> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.putAll(r13.next().getKeyValueMap());
        goto L4
    L6:
        r11.putAll(r12);
        return r11.build();
    }
}
