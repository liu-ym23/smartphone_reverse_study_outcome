package com.bytedance.apm6.consumer.slardar.header;

import android.util.Log;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeaderStoreManager {
    private static final long MAX_EXPIRE_TIME = 604800000;
    private static final String SUFFIX = ".bin";
    private File directory;
    private volatile boolean initialized;

    private static class InnerHolder {
        private static final HeaderStoreManager instance = null;

        static {
            instance = new HeaderStoreManager();
        }

        private InnerHolder() {
        }

        static /* synthetic */ HeaderStoreManager access$000() {
            return instance;
        }
    }

    public HeaderStoreManager() {
    }

    private String getFileName(String r1) {
        return r1 + SUFFIX;
    }

    public static HeaderStoreManager getInstance() {
        return InnerHolder.access$000();
    }

    private synchronized void initialize() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == false) goto L19;
        monitor-exit(this);
        return;
    L19:
        File r0 = new File(DiskEnvironmentHelper.getWorkingDirectory(), "header");     // Catch: Throwable -> L11
        this.directory = r0;     // Catch: Throwable -> L11
        if (r0.exists() == true) goto L13;
        this.directory.mkdirs();     // Catch: Throwable -> L11
    L13:
        this.initialized = true;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        Logger.e("APM", "header store init error " + th.toString());     // Catch: Throwable -> L16
        goto L13
    }

    void deleteExpireFile() {
        initialize();
        File r0 = this.directory;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.listFiles(new AnonymousClass1(this));
    }

    HeaderInfo getHeaderInfo(String r4) {
        initialize();
        if (this.directory != null) goto L5;
        return null;
    L5:
        byte[] r3 = FileUtils.readFileToByteArray(new File(this.directory, getFileName(r4)));
        if (r3 != null) goto L8;
        return null;
    L8:
        return HeaderUtils.deserialize(r3);
    }

    void saveHeaderInfo(String r3, HeaderInfo r4) {
        initialize();
        if (this.directory != null) goto L5;
        return;
    L5:
        JSONObject r5 = HeaderUtils.serialize(r4);
        if (r5 != null) goto L8;
        return;
    L8:
        File r0 = new File(this.directory, getFileName(r3));
        FileChannel r2 = null;
        r2 = new FileOutputStream(r0).getChannel();     // Catch: Throwable -> L11
        r2.write(ByteBuffer.wrap(r5.toString().getBytes()));     // Catch: Throwable -> L11
    L10:
        IOUtils.closeQuietly(r2);
        return;
    L11:
        th = move-exception;
        Log.e("APM", "header couldn't write file" + th.getMessage());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        IOUtils.closeQuietly(r2);
        throw th;
    }
}
