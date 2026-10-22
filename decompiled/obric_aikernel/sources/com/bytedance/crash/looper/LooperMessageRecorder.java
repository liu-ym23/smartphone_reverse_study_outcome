package com.bytedance.crash.looper;

import android.os.Message;
import androidx.annotation.NonNull;
import com.bytedance.apm.block.j;
import com.bytedance.apm.block.k;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LooperMessageRecorder implements j {
    private static final LooperMessageRecorder sInstance = null;
    private boolean mIsStarted;
    private final LooperMessageManager mMessageManager;

    static {
        sInstance = new LooperMessageRecorder();
    }

    public LooperMessageRecorder() {
        this.mMessageManager = new LooperMessageManager();
    }

    public static LooperMessageRecorder getInstance() {
        return sInstance;
    }

    public static void load(@NonNull JSONObject r10, File r11) {
        loadFile(r10, LooperMessageConfig.getCurrentJsonFile(r11));
        loadFile(r10, LooperMessageConfig.getHistoryJsonFile(r11));
        loadFile(r10, LooperMessageConfig.getPendingJsonFile(r11));
        loadFile(r10, LooperMessageConfig.getBlockStackJsonFile(r11));
    }

    private static void loadFile(@NonNull JSONObject r10, File r11) {
        String r12 = FileSystemUtils.readUtf8File(r11);     // Catch: Exception -> L6
        if (r12 == null) goto L9;
        JSONUtils.combineJson(r10, new JSONObject(r12));     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public void dumpMessages(File r10) {
        this.mMessageManager.dumpMessages(r10);
    }

    @Override // com.bytedance.apm.block.j
    public void messageDispatchStarting(String r10) {
        this.mMessageManager.onMessage(null);
    }

    @Override // com.bytedance.apm.block.j
    public void messageDispatched(String r10, Message r11) {
        this.mMessageManager.onMessage(r11);
    }

    public synchronized void start() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsStarted == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.mIsStarted = true;     // Catch: Throwable -> L11
        this.mMessageManager.start();     // Catch: Throwable -> L11
        k.d(null);     // Catch: Throwable -> L11
        k.a(this);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void stop() {
        this.mIsStarted = false;
        this.mMessageManager.stop();
        k.i(this);
    }
}
