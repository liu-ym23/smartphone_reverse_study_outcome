package com.bytedance.apm6;

import android.content.Context;
import com.bytedance.apm6.hub.Apm;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import u4.b;

/* JADX INFO: loaded from: classes.dex */
public class Apm6 {
    static final String OUTSIDE_MAX_SIZE_MB_TODAY = "max_size_mb_today";
    private static List<b> mConfigListeners;

    public Apm6() {
    }

    public static void dispatchSlardarResponse(JSONObject r10) {
        List<b> r11 = mConfigListeners;
        if (r11 == null) goto L8;
        Iterator<b> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        r12.next().onResponse(r10);
        goto L6
    L10:
        return;
    }

    public static Runnable init(final Context r10) {
        return Apm.initWithAsync(new AnonymousClass1(r10));
    }

    public static void registerResponseConfigListener(b r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (mConfigListeners != null) goto L8;
        mConfigListeners = new CopyOnWriteArrayList();
    L8:
        if (mConfigListeners.contains(r10) == true) goto L11;
        mConfigListeners.add(r10);
        return;
    }

    public static void unregisterResponseConfigListener(b r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        List<b> r11 = mConfigListeners;
        if (r11 == null) goto L8;
        r11.remove(r10);
        return;
    }
}
