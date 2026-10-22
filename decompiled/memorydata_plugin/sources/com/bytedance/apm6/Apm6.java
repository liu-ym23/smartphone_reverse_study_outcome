package com.bytedance.apm6;

import android.content.Context;
import com.bytedance.apm6.hub.Apm;
import com.bytedance.services.slardar.config.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Apm6 {
    static final String OUTSIDE_MAX_SIZE_MB_TODAY = "max_size_mb_today";
    private static List<b> mConfigListeners;

    public Apm6() {
    }

    public static void dispatchSlardarResponse(JSONObject r4) {
        List<b> r0 = mConfigListeners;
        if (r0 == null) goto L8;
        Iterator<b> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.memorydata.plugin")).a(r4);
        goto L6
    L10:
        return;
    }

    public static Runnable init(Context r2) {
        final Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return Apm.initWithAsync(new AnonymousClass1(r3));
    }

    public static void registerResponseConfigListener(b r2) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return;
    L6:
        if (mConfigListeners != null) goto L9;
        mConfigListeners = new CopyOnWriteArrayList();
    L9:
        if (mConfigListeners.contains(r3) == true) goto L12;
        mConfigListeners.add(r3);
        return;
    }

    public static void unregisterResponseConfigListener(b r2) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        List<b> r0 = mConfigListeners;
        if (r0 == null) goto L9;
        r0.remove(r3);
        return;
    }
}
