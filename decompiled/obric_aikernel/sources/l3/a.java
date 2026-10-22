package l3;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.framwork.core.sdklib.apm6.j;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MappedByteBuffer f10876a;

    public static synchronized void a(JSONObject r14) {
        monitor-enter(a.class);
        monitor-enter(SDKMonitor.class);     // Catch: Throwable -> L22
        String r10 = ya.a.a(j.c());     // Catch: Throwable -> L17
        if (f10876a != null) goto L14;
        File r11 = new File(j.c().getFilesDir(), "sdk_" + r10 + "_seq_num.txt");     // Catch: Throwable -> L17
        boolean r12 = r11.exists();     // Catch: Throwable -> L17
        if (r12 == true) goto L11;
        r11.createNewFile();     // Catch: Throwable -> L17
    L11:
        MappedByteBuffer r13 = new RandomAccessFile(r11, "rws").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 8);     // Catch: Throwable -> L17
        f10876a = r13;     // Catch: Throwable -> L17
        if (r12 == true) goto L14;
        r13.putLong(0, 0);     // Catch: Throwable -> L17
    L14:
        long r15 = f10876a.getLong(0);     // Catch: Throwable -> L17
        r14.put(Constants.KEY_SEQ_NO, r15);     // Catch: Throwable -> L17
        r14.put("process_name", r10);     // Catch: Throwable -> L17
        f10876a.putLong(0, r15 + 1);     // Catch: Throwable -> L17
        monitor-exit(SDKMonitor.class);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L20:
        monitor-exit(a.class);
    }
}
