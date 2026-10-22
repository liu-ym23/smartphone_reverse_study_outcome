package com.lynx.jsbridge;

import android.content.Context;
import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.jsbridge.network.HttpResponse;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.service.ILynxHttpService;
import com.obric.aivoice.core.data.NameKeys;
import i8a.i;
import i8a.n;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxFetchModule extends LynxModule {
    public static final String NAME = "LynxFetchModule";
    private static final String deprecatedStreamingFlag = "useStreaming";
    private static final String standardStreamingFlag = "enableFetchAPIStandardStreaming";
    private static final AtomicLong streamingCounter = null;
    private static final String streamingEventNamePrefix = "LynxFetchModuleStreamingEvent";
    private final z5a.b mSender;

    public class a extends i {
        public final /* synthetic */ String a;
        public final /* synthetic */ Callback b;

        @Override // i8a.i
        public final void a(HttpResponse r6) {
            JavaOnlyMap r0 = new JavaOnlyMap();
            r0.put(LynxEventReporter.PROP_NAME_URL, this.a);
            if (r6.getHttpBody() == null) goto L5;
            byte[] r1 = r6.getHttpBody();
        L6:
            r0.put("body", r1);
            JavaOnlyMap r2 = r6.getHttpHeaders();
            String r3 = NameKeys.UnloadStrategy_No_Strategy;
            if (r2 == null) goto L9;
            Object r4 = r6.getHttpHeaders();
        L10:
            r0.put("headers", r4);
            r0.put("status", Integer.valueOf(r6.getStatusCode()));
            if (r6.getStatusText() == null) goto L13;
            r3 = r6.getStatusText();
        L13:
            r0.put("statusText", r3);
            if (r6.getCustomInfo() == null) goto L16;
            JavaOnlyMap r7 = r6.getCustomInfo();
        L17:
            r0.put("lynxExtension", r7);
            this.b.invoke(new Object[]{r0});
            return;
        L16:
            r7 = new JavaOnlyMap();
            goto L17
        L9:
            r4 = NameKeys.UnloadStrategy_No_Strategy;
            goto L10
        L5:
            r1 = new byte[0];
            goto L6
        }

        public a(String r1, Callback r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public class b extends i {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Callback c;

        @Override // i8a.i
        public final void a(HttpResponse r6) {
            JavaOnlyMap r0 = new JavaOnlyMap();
            r0.put(LynxEventReporter.PROP_NAME_URL, this.a);
            r0.put("body", new byte[0]);
            JavaOnlyMap r2 = r6.getHttpHeaders();
            String r3 = NameKeys.UnloadStrategy_No_Strategy;
            if (r2 == null) goto L5;
            Object r4 = r6.getHttpHeaders();
        L6:
            r0.put("headers", r4);
            r0.put("status", Integer.valueOf(r6.getStatusCode()));
            if (r6.getStatusText() == null) goto L9;
            r3 = r6.getStatusText();
        L9:
            r0.put("statusText", r3);
            if (r6.getCustomInfo() == null) goto L12;
            JavaOnlyMap r7 = r6.getCustomInfo();
        L13:
            r7.putString("streamingId", this.b);
            r0.put("lynxExtension", r7);
            this.c.invoke(new Object[]{r0});
            return;
        L12:
            r7 = new JavaOnlyMap();
            goto L13
        L5:
            r4 = NameKeys.UnloadStrategy_No_Strategy;
            goto L6
        }

        public b(String r1, String r2, Callback r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        streamingCounter = new AtomicLong();
    }

    public LynxFetchModule(Context r1, Object r2) {
        super(r1);
        this.mSender = (z5a.b) r2;
    }

    @LynxMethod
    public void fetch(ReadableMap r7, Callback r8, Callback r9) {
        String r0 = r7.getString(LynxEventReporter.PROP_NAME_URL, NameKeys.UnloadStrategy_No_Strategy);
        HttpRequest r2 = new HttpRequest();
        r2.a = r7.getString("method", NameKeys.UnloadStrategy_No_Strategy);
        r2.b = r0;
        r7.getString("origin", NameKeys.UnloadStrategy_No_Strategy);
        r2.d = (JavaOnlyMap) r7.getMap("headers", new JavaOnlyMap());
        r2.c = r7.getByteArray("body", new byte[0]);
        JavaOnlyMap r10 = (JavaOnlyMap) r7.getMap("lynxExtension", new JavaOnlyMap());
        r2.e = r10;
        boolean r1 = r10.getBoolean(deprecatedStreamingFlag, false);
        boolean r11 = r10.getBoolean(standardStreamingFlag, false);
        ILynxHttpService r4 = (ILynxHttpService) n.c().a(ILynxHttpService.class);
        if (r4 != null) goto L6;
        JavaOnlyMap r12 = new JavaOnlyMap();
        r12.put("message", "Lynx Http Service not registered");
        r9.invoke(new Object[]{r12});
        return;
    L6:
        if (r1 == true) goto L9;
        if (r11 == true) goto L9;
        request(r4, r2, r0, r8);
        return;
    L9:
        requestStreaming(r4, r2, r0, r8);
    }

    private void request(ILynxHttpService r2, HttpRequest r3, String r4, Callback r5) {
        r2.request(r3, new a(r4, r5));
    }

    private void requestStreaming(ILynxHttpService r4, HttpRequest r5, String r6, Callback r7) {
        String r0 = streamingEventNamePrefix + streamingCounter.getAndIncrement();
        r4.requestStreaming(r5, new b(r6, r0, r7), new z5a.a(r0, this.mSender));
    }
}
