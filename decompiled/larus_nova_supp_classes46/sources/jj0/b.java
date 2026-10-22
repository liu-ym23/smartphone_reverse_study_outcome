package jj0;

import com.bytedance.android.livesdk.message.model.BackupSeiModel;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((BackupSeiModel) r3).getPts()), Long.valueOf(((BackupSeiModel) r4).getPts()));
    }
}
