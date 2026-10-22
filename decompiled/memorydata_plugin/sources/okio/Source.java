package okio;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.island.gr.IslandSession;
import java.io.Closeable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lokio/Source;", "Ljava/io/Closeable;", IslandSession.REOPEN_VALUE_CLOSE, "", "read", "", "sink", "Lokio/Buffer;", "byteCount", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "jvm"}, k = 1, mv = {1, 1, 11})
public interface Source extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    long read(Buffer r1, long r2);

    Timeout timeout();
}
