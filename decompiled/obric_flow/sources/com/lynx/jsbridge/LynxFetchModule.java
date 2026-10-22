package com.lynx.jsbridge;

import android.content.Context;
import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.service.ILynxHttpService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class LynxFetchModule extends LynxModule {
    public static final String NAME = "LynxFetchModule";
    private static final AtomicLong streamingCounter = null;
    private static final String streamingEventNamePrefix = "LynxFetchModuleStreamingEvent";
    private final nm.b mSender;

    static {
        streamingCounter = new AtomicLong();
    }

    public LynxFetchModule(Context r5, Object r10) {
        super(r5);
        this.mSender = (nm.b) r10;
    }

    private void request(ILynxHttpService r5, HttpRequest r10, String r11, Callback r12) {
        r5.request(r10, new i(r12));
    }

    private void requestStreaming(ILynxHttpService r5, HttpRequest r10, String r11, Callback r12) {
        streamingCounter.getAndIncrement();
        nm.a r13 = new nm.a();
        r5.requestStreaming(r10, new i(r12), r13);
    }

    @n
    public void fetch(ReadableMap r10, Callback r11, Callback r12) {
        String r5 = r10.getString("url", "");
        HttpRequest r13 = new HttpRequest();
        r13.f9925a = r10.getString("method", "");
        r13.f9926b = r5;
        r10.getString("origin", "");
        r13.d = (JavaOnlyMap) r10.getMap("headers", new JavaOnlyMap());
        r13.f9927c = r10.getByteArray("body", new byte[0]);
        JavaOnlyMap r14 = (JavaOnlyMap) r10.getMap("lynxExtension", new JavaOnlyMap());
        r13.e = r14;
        boolean r15 = r14.getBoolean("useStreaming", false);
        ILynxHttpService r16 = (ILynxHttpService) ko.r.g().e(ILynxHttpService.class);
        if (r16 != null) goto L6;
        JavaOnlyMap r17 = new JavaOnlyMap();
        r17.put("message", "Lynx Http Service not registered");
        r12.invoke(new Object[]{r17});
        return;
    L6:
        if (r15 == true) goto L9;
        request(r16, r13, r5, r11);
        return;
    L9:
        requestStreaming(r16, r13, r5, r11);
    }
}
