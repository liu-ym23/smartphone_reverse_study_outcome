package com.bytedance.crash.game;

import android.text.TextUtils;
import com.bytedance.crash.IScriptCallback;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GameScriptStack {
    private static final String FILE_NAME = "game_script_stack.txt";
    private static IScriptCallback sCallback;

    public GameScriptStack() {
    }

    public static void dump(File r3) {
        IScriptCallback r0 = sCallback;
        if (r0 == null) goto L11;
        String r1 = r0.getScriptStackWhenCrash();     // Catch: Throwable -> L8
        if (r1 == null) goto L12;
        FileSystemUtils.writeFile(new File(r3, FILE_NAME), r1);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public static void putTo(JSONObject r2, File r3) {
        File r0 = new File(r3, FILE_NAME);
        if (r0.exists() == false) goto L8;
        String r4 = FileSystemUtils.readUtf8File(r0);
        if (TextUtils.isEmpty(r4) == true) goto L9;
        JSONUtils.put(r2, "game_script_stack", r4);
        return;
    L9:
        return;
    }

    public static void setCallback(IScriptCallback r2) {
        sCallback = (IScriptCallback) ZeusTransformUtils.wrapperContextForParams(r2, IScriptCallback.class, "com.obric.memorydata.plugin");
    }
}
