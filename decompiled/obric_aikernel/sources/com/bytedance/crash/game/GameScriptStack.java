package com.bytedance.crash.game;

import android.text.TextUtils;
import com.bytedance.crash.IScriptCallback;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GameScriptStack {
    private static final String FILE_NAME = "game_script_stack.txt";
    private static IScriptCallback sCallback;

    public GameScriptStack() {
    }

    public static void dump(File r10) {
        IScriptCallback r11 = sCallback;
        if (r11 == null) goto L11;
        String r12 = r11.getScriptStackWhenCrash();     // Catch: Throwable -> L8
        if (r12 == null) goto L12;
        FileSystemUtils.writeFile(new File(r10, FILE_NAME), r12);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public static void putTo(JSONObject r10, File r11) {
        File r12 = new File(r11, FILE_NAME);
        if (r12.exists() == false) goto L8;
        String r13 = FileSystemUtils.readUtf8File(r12);
        if (TextUtils.isEmpty(r13) == true) goto L9;
        JSONUtils.put(r10, "game_script_stack", r13);
        return;
    L9:
        return;
    }

    public static void setCallback(IScriptCallback r10) {
        sCallback = r10;
    }
}
