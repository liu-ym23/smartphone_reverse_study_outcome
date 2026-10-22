package com.bytedance.framwork.core.sdklib.b;

import android.content.Context;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.framwork.core.sdklib.apm6.j;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MappedByteBuffer f2618a;

    public static synchronized void a(JSONObject r14) {
        monitor-enter(a.class);
        monitor-enter(SDKMonitor.class);     // Catch: Throwable -> L22
        String r2 = com.ss.android.common.b.d.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
        if (f2618a != null) goto L14;
        File r3 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "sdk_" + r2 + "_seq_num.txt");     // Catch: Throwable -> L17
        boolean r5 = r3.exists();     // Catch: Throwable -> L17
        if (r5 == true) goto L11;
        r3.createNewFile();     // Catch: Throwable -> L17
    L11:
        MappedByteBuffer r4 = new RandomAccessFile(r3, "rws").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 8);     // Catch: Throwable -> L17
        f2618a = r4;     // Catch: Throwable -> L17
        if (r5 == true) goto L14;
        r4.putLong(0, 0);     // Catch: Throwable -> L17
    L14:
        long r6 = f2618a.getLong(0);     // Catch: Throwable -> L17
        r14.put(Constants.KEY_SEQ_NO, r6);     // Catch: Throwable -> L17
        r14.put("process_name", r2);     // Catch: Throwable -> L17
        f2618a.putLong(0, r6 + 1);     // Catch: Throwable -> L17
        monitor-exit(SDKMonitor.class);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L20:
        monitor-exit(a.class);
    }
}
