package tob;

import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static String a;
    public static int b;
    public static String c;
    public static String d;

    static {
        c = "";
        d = "";
    }

    public static void a() {
        String r1 = a;
        if (r1 == null) goto L5;
        Log.d("AppreciablePerformance", "endPlay");
        AppreciableKit.Companion.getInstance().end(r1, null, null, null, null, null);
    L5:
        a = null;
        b = 0;
        c = "";
        d = "";
    }

    public static void b(int r17) {
        if (a == null) goto L5;
        Log.e("AppreciablePerformance", "errorPlay, errorCode:" + r17 + ", audioLength:" + b + ", messageId:" + c + ", resourceKey:" + d);
        AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.Messenger, Scene.Chat, Event.audio_play, ErrorType.Other, ErrorLevel.Fatal, r17, null, null, null, Boolean.FALSE, null, c(b, c, d), null));
    L5:
        a = null;
        b = 0;
        c = "";
        d = "";
    }

    public static void d(String r3) {
        if (Intrinsics.areEqual(r3, c) == true) goto L5;
        return;
    L5:
        String r0 = a;
        if (r0 == null) goto L9;
        Log.i("AppreciablePerformance", "startDownload, messageId:" + r3);
        AppreciableKit.Companion.getInstance().spanStart(r0, "download_cost");
        return;
    }

    public static void f(String r3) {
        if (Intrinsics.areEqual(r3, c) == true) goto L5;
        return;
    L5:
        String r0 = a;
        if (r0 == null) goto L9;
        Log.i("AppreciablePerformance", "stopDownload, messageId:" + r3);
        AppreciableKit.Companion.getInstance().spanEnd(r0, "download_cost");
        return;
    }

    public static HashMap c(int r2, String r3, String r4) {
        HashMap r0 = new HashMap();
        r0.put("audio_length", Integer.valueOf(r2));
        if (r3 == null) goto L5;
        r0.put("message_id", r3);
    L5:
        if (r4 == null) goto L7;
        r0.put("resource_key", r4);
    L7:
        return r0;
    }

    public static void e(int r12, String r13, String r14) {
        Log.d("AppreciablePerformance", "startPlay, audioLength:" + r12 + ", messageId:" + r13 + ", resourceKey:" + r14);
        if (a != null) goto L5;
    L8:
        b = r12;
        c = r13;
        d = r14;
        a = AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Chat, Event.audio_play, null, true, null, null, c(r12, r13, r14), null);
        return;
    L5:
        if (Intrinsics.areEqual(c, r13) == false) goto L8;
        Log.d("AppreciablePerformance", "skip repeat start");
    }
}
