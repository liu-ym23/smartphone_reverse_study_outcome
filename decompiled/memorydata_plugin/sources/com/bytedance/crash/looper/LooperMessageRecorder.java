package com.bytedance.crash.looper;

import android.os.Message;
import com.bytedance.apm.block.j;
import com.bytedance.apm.block.k;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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

    public static void load(JSONObject r1, File r2) {
        loadFile(r1, LooperMessageConfig.getCurrentJsonFile(r2));
        loadFile(r1, LooperMessageConfig.getHistoryJsonFile(r2));
        loadFile(r1, LooperMessageConfig.getPendingJsonFile(r2));
        loadFile(r1, LooperMessageConfig.getBlockStackJsonFile(r2));
    }

    private static void loadFile(JSONObject r1, File r2) {
        String r3 = FileSystemUtils.readUtf8File(r2);     // Catch: Exception -> L6
        if (r3 == null) goto L9;
        JSONUtils.combineJson(r1, new JSONObject(r3));     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public void dumpMessages(File r1) {
        this.mMessageManager.dumpMessages(r1);
    }

    @Override // com.bytedance.apm.block.j
    public void messageDispatchStarting(String r1) {
        this.mMessageManager.onMessage(null);
    }

    @Override // com.bytedance.apm.block.j
    public void messageDispatched(String r1, Message r2) {
        this.mMessageManager.onMessage(r2);
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
        k.a(null);     // Catch: Throwable -> L11
        k.a(this);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void stop() {
        this.mIsStarted = false;
        this.mMessageManager.stop();
        k.b(this);
    }
}
