package com.lynx.jsbridge;

import android.util.Pair;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import i8a.n;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxResourceModule extends LynxContextModule {
    public static final String AUDIO_TYPE = "audio";
    private static final String AWAIT_TIMEOUT_MSG = "The prefetch task did not complete within the specified timeout.";
    public static final String CODE_KEY = "code";
    public static final String DATA_KEY = "data";
    public static final long DEFAULT_MEDIA_SIZE = 512000;
    public static final String DETAIL_KEY = "details";
    public static final String FONT_TYPE = "font";
    public static final String IMAGE_TYPE = "image";
    public static final String MSG_KEY = "msg";
    public static final String NAME = "LynxResourceModule";
    public static final String PARAMS_KEY = "params";
    private static final String PARAM_ERROR_FIX_SUGGESTION = "Please check the parameters passed to Lynx resource prefetch module.";
    private static final String RESOURCE_SERVICE_ERROR_FIX_SUGGESTION = "If it is a parameter error, please check the parameters passed in. If the Resource service does not exist, it may be due to an error that occurred while creating the resource service through reflection. Please contact the client RD for help.";
    public static final String TYPE_KEY = "type";
    public static final String URI_KEY = "uri";
    public static final String VIDEO_TYPE = "video";
    private ILynxImageService mImagePrefetchHelper;

    public class a implements v7a.e {
        public final /* synthetic */ Callback a;
        public final /* synthetic */ LynxResourceModule b;

        @Override // v7a.e
        public final void onImageMonitorInfo(JSONObject r1) {
        }

        @Override // v7a.e
        public final void onRequestSubmit(v7a.f r1) {
        }

        public a(LynxResourceModule r1, Callback r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // v7a.e
        public final void onFailure(int r4, Throwable r5) {
            Callback r6 = this.a;
            if (r6 == null) goto L6;
            r6.invoke(new Object[]{LynxResourceModule.access$000(this.b, r4, "prefetch image failed")});
            return;
        }

        @Override // v7a.e
        public final void onSuccess(u7a.a r3, v7a.f r4, v7a.d r5) {
            Callback r6 = this.a;
            if (r6 == null) goto L6;
            r6.invoke(new Object[]{LynxResourceModule.access$000(this.b, 0, NameKeys.UnloadStrategy_No_Strategy)});
            return;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ boolean[] b;
        public final /* synthetic */ JavaOnlyMap c;
        public final /* synthetic */ Callback d;
        public final /* synthetic */ int[] e;

        public class a implements Runnable {
            public final /* synthetic */ b a;

            public final void a() {
                b r0 = this.a;
                boolean[] r1 = r0.b;
                if (r1[0] == true) goto L11;
                r1[0] = true;
                r0.c.putInt(LynxResourceModule.CODE_KEY, 32104);
                this.a.c.putString("msg", LynxResourceModule.AWAIT_TIMEOUT_MSG);
                LynxResourceModule r4 = (LynxResourceModule) this.a.a.get();
                if (r4 == null) goto L8;
                LynxResourceModule.access$100(r4, 32104, LynxResourceModule.AWAIT_TIMEOUT_MSG, LynxResourceModule.RESOURCE_SERVICE_ERROR_FIX_SUGGESTION, null, "request");
            L8:
                if (this.a.d == null) goto L12;
                LLog.i(LynxResourceModule.NAME, " timeout invoke, count: " + this.a.e[0]);
                b r2 = this.a;
                r2.d.invoke(new Object[]{r2.c});
                return;
            L12:
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r1) {
                this.a = r1;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            LynxResourceModule r0 = (LynxResourceModule) this.a.get();     // Catch: Throwable -> L9
            if (r0 == null) goto L12;
            LynxContext r1 = r0.mLynxContext;     // Catch: Throwable -> L9
            if (r1 == null) goto L16;
            r1.runOnJSThread(new a(this));     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public b(WeakReference r1, boolean[] r2, JavaOnlyMap r3, Callback r4, int[] r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public class c implements g {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean[] c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JavaOnlyArray e;
        public final /* synthetic */ int[] f;
        public final /* synthetic */ int g;
        public final /* synthetic */ Callback h;
        public final /* synthetic */ JavaOnlyMap i;
        public final /* synthetic */ LynxResourceModule j;

        public class a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ c c;

            public final void a() {
                c r0 = this.c;
                if (r0.c[0] == false) goto L5;
                return;
            L5:
                JavaOnlyMap r1 = LynxResourceModule.access$000(r0.j, this.a, this.b);
                r1.putString(LynxResourceModule.URI_KEY, this.c.b);
                r1.putString("type", this.c.d);
                this.c.e.pushMap(r1);
                int[] r2 = this.c.f;
                r2[0] = r2[0] + 1;
                LLog.i(LynxResourceModule.NAME, "onComplete:" + this.c.b + " msg:" + this.b + " count:" + this.c.f[0]);
                c r3 = this.c;
                if (r3.f[0] != r3.g) goto L11;
                Callback r4 = r3.h;
                if (r4 == null) goto L12;
                r3.c[0] = true;
                r4.invoke(new Object[]{r3.i});
                return;
            L12:
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(c r1, int r2, String r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        public final void a(int r8, String r9) {
            LynxResourceModule r0 = (LynxResourceModule) this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.mLynxContext == null) goto L12;
            if (r8 == 0) goto L9;
            LynxResourceModule.access$100(r0, r8, r9, LynxResourceModule.RESOURCE_SERVICE_ERROR_FIX_SUGGESTION, this.b, "request");
        L9:
            r0.mLynxContext.runOnJSThread(new a(this, r8, r9));
            return;
        }

        public c(LynxResourceModule r1, WeakReference r2, String r3, boolean[] r4, String r5, JavaOnlyArray r6, int[] r7, int r8, Callback r9, JavaOnlyMap r10) {
            this.j = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }
    }

    public class d implements v7a.e {
        public final /* synthetic */ g a;

        @Override // v7a.e
        public final void onImageMonitorInfo(JSONObject r1) {
        }

        @Override // v7a.e
        public final void onRequestSubmit(v7a.f r1) {
        }

        public d(g r1) {
            this.a = r1;
        }

        @Override // v7a.e
        public final void onFailure(int r2, Throwable r3) {
            ((c) this.a).a(r2, "prefetch image failed");
        }

        @Override // v7a.e
        public final void onSuccess(u7a.a r1, v7a.f r2, v7a.d r3) {
            ((c) this.a).a(0, NameKeys.UnloadStrategy_No_Strategy);
        }
    }

    public class e implements FontFaceManager.f {
        public final /* synthetic */ g a;

        public e(g r1) {
            this.a = r1;
        }
    }

    public class f implements i8a.e.a {
        public final /* synthetic */ g a;

        public f(g r1) {
            this.a = r1;
        }
    }

    public interface g {
    }

    public LynxResourceModule(LynxContext r7) {
        super(r7);
        ILynxImageService r8 = (ILynxImageService) n.c().a(ILynxImageService.class);
        this.mImagePrefetchHelper = r8;
        if (r8 != null) goto L6;
        reportError(32102, "An exception occurred when try to get image prefetch helper.", "An error occurred while attempting to create a Java object ImagePrefetchHelper through reflection. This may be due to a change in the constructor interface of ImagePrefetchHelper, or because ImagePrefetchHelper is located in a plugin that is not ready. If you are unable to resolve this issue, you can seek help from the client RD.", null, null);
        return;
    }

    private JavaOnlyMap createResult(int r3, String r4) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putInt(CODE_KEY, r3);
        r0.putString("msg", r4);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.lynx.react.bridge.ReadableMap, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v4 */
    private JavaOnlyMap resourcePrefetch(ReadableMap r22, boolean r23) {
        LynxResourceModule r6 = this;
        int r7 = 0;
        JavaOnlyMap r9 = r6.createResult(0, NameKeys.UnloadStrategy_No_Strategy);
        ?? r10 = 0;
        ReadableArray r11 = r22.getArray(DATA_KEY, null);
        String r14 = "cancel";
        if (r11 == null) goto L5;
        JavaOnlyArray r5 = new JavaOnlyArray();
        int r4 = 0;
    L11:
        if (r4 >= r11.size()) goto L34;
        JavaOnlyMap r3 = r6.createResult(Integer.valueOf(r7).intValue(), NameKeys.UnloadStrategy_No_Strategy);
        if (r11.getType(r4) == ReadableType.Map) goto L16;
        String r8 = "Parameters error in Lynx resource prefetch module! The prefetch data should be a map.";
        int r24 = r4;
        JavaOnlyArray r17 = r5;
        String r12 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        Integer r18 = 32101;
    L26:
        if (r18.intValue() == 0) goto L33;
        int r1 = r18.intValue();
        if (r23 == false) goto L30;
        String r19 = "cancel";
    L31:
        reportError(r1, r8, RESOURCE_SERVICE_ERROR_FIX_SUGGESTION, r12, r19);
        goto L33
    L30:
        r19 = "request";
    L33:
        r3.putInt(CODE_KEY, r18.intValue());
        r3.putString("msg", r8);
        r17.pushMap(r3);
        r4 = r24 + 1;
        r5 = r17;
        r7 = 0;
        r10 = 0;
        r6 = this;
        goto L11
    L16:
        ReadableMap r0 = r11.getMap(r4);
        String r2 = r0.getString(URI_KEY, r10);
        r24 = r4;
        String r13 = r0.getString("type", r10);
        r17 = r5;
        ReadableMap r15 = r0.getMap(PARAMS_KEY, r10);
        if (r2 == null) goto L24;
        if (r13 == null) goto L24;
        if (r23 == false) goto L22;
        Pair<Integer, String> r16 = r6.cancelResourcePrefetchInternal(r2, r13, r15);
    L23:
        Integer r20 = (Integer) r16.first;
        String r21 = (String) r16.second;
        r3.putString(URI_KEY, r2);
        r3.putString("type", r13);
        r8 = r21;
        r12 = r2;
        r18 = r20;
        goto L26
    L22:
        r16 = r6.requestResourcePrefetchInternal(r2, r13, r15);
    L24:
        r8 = "Parameters error in Lynx resource prefetch module! 'uri' or 'type' is null.";
        r12 = r2;
        goto L15
    L34:
        r9.putArray(DETAIL_KEY, r5);
    L35:
        return r9;
    L5:
        if (r23 == true) goto L8;
        r14 = "request";
    L8:
        reportError(32101, "Parameters error in Lynx resource prefetch module! Value of 'data' should be an array.", PARAM_ERROR_FIX_SUGGESTION, null, r14);
        r9.putInt(CODE_KEY, 32101);
        r9.putString("msg", "Parameters error in Lynx resource prefetch module! Value of 'data' should be an array.");
        goto L35
    }

    @LynxMethod
    public void cancelResourcePrefetch(ReadableMap r3, Callback r4) {
        TraceEvent.beginSection("cancelResourcePrefetch");
        JavaOnlyMap r5 = resourcePrefetch(r3, true);
        TraceEvent.endSection("cancelResourcePrefetch");
        if (r4 == null) goto L6;
        r4.invoke(new Object[]{r5});
        return;
    }

    @LynxMethod
    public void requestResourcePrefetchImage(ReadableMap r11, Callback r12) {
        String r0 = r11.getString(URI_KEY, null);
        ReadableMap r13 = r11.getMap(PARAMS_KEY, null);
        if (r0 != null) goto L8;
        reportError(32101, "Parameters error in Lynx resource prefetch module! 'uri' is null.", PARAM_ERROR_FIX_SUGGESTION, null, null);
        if (r12 == null) goto L16;
        r12.invoke(new Object[]{createResult(32101, "Parameters error in Lynx resource prefetch module! 'uri' is null.")});
        return;
    L16:
        return;
    L8:
        ILynxImageService r3 = this.mImagePrefetchHelper;
        if (r3 != null) goto L14;
        reportError(32102, "Image prefetch helper do not exist!", RESOURCE_SERVICE_ERROR_FIX_SUGGESTION, null, null);
        if (r12 == null) goto L17;
        r12.invoke(new Object[]{createResult(32102, "Image prefetch helper do not exist!")});
        return;
    L17:
        return;
    L14:
        r3.prefetchImage(r0, this.mLynxContext.getFrescoCallerContext(), (Map) r13, new a(this, r12));
    }

    public static /* synthetic */ JavaOnlyMap access$000(LynxResourceModule r0, int r1, String r2) {
        return r0.createResult(r1, r2);
    }

    private Pair<Integer, String> cancelResourcePrefetchInternal(String r8, String r9, ReadableMap r10) {
        byte r0 = 0;
        int r1 = 0;
        r9.getClass();
        switch(r9.hashCode()) {
            case 93166550: goto L14;
            case 100313435: goto L10;
            case 112202875: goto L6;
            default: goto L4;
        };
    L4:
        r0 = -1;
    L16:
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
        switch(r0) {
            case 0: goto L23;
            case 1: goto L20;
            case 2: goto L23;
            default: goto L18;
        };
    L18:
        r1 = 32101;
        r3 = "Parameters error! Unknown type :".concat(r9);
    L32:
        LLog.i(NAME, "requestResourcePrefetch uri: " + r8 + " type: " + r9);
        return new Pair(r1, r3);
    L20:
        if (this.mImagePrefetchHelper != null) goto L32;
        r1 = 32102;
        r3 = "Image prefetch helper do not exist!";
        goto L32
    L23:
        if (r10 != null) goto L26;
        r1 = 32101;
    L25:
        r3 = "missing preloadKey!";
        goto L32
    L26:
        String r4 = r10.getString("preloadKey", null);
        String r11 = r10.getString("videoID", null);
        i8a.e r5 = (i8a.e) n.c().a(i8a.e.class);
        if (r5 != null) goto L29;
        r1 = 32103;
        r3 = "Resource service do not exist!";
        goto L32
    L29:
        if (r4 != null) goto L31;
        r1 = 32101;
        goto L25
    L31:
        r5.cancelPreloadMedia(r4, r11);
        goto L32
    L6:
        if (r9.equals(VIDEO_TYPE) == false) goto L4;
        r0 = 2;
        goto L16
    L10:
        if (r9.equals("image") == false) goto L4;
        r0 = 1;
        goto L16
    L14:
        if (r9.equals(AUDIO_TYPE) == true) goto L16;
        goto L16
    }

    private Pair<Integer, String> requestResourcePrefetchInternal(String r14, String r15, ReadableMap r16) {
        byte r2 = 0;
        Integer r10 = 0;
        r15.getClass();
        switch(r15.hashCode()) {
            case 3148879: goto L18;
            case 93166550: goto L14;
            case 100313435: goto L10;
            case 112202875: goto L6;
            default: goto L19;
        };
    L19:
        r2 = -1;
    L21:
        if (r2 != 0) goto L23;
        FontFaceManager.g.a.m(this.mLynxContext, r14, null);
    L42:
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
    L43:
        LLog.i(NAME, "requestResourcePrefetch uri: " + r14 + " type: " + r15);
        return new Pair(r10, r1);
    L23:
        if (r2 == 1) goto L31;
        if (r2 == 2) goto L27;
        if (r2 == 3) goto L31;
        r10 = 32101;
        r1 = "Parameters error! Unknown type :".concat(r15);
        goto L43
    L27:
        ILynxImageService r3 = this.mImagePrefetchHelper;
        if (r3 != null) goto L30;
        r10 = 32102;
        r1 = "Image prefetch helper do not exist!";
        goto L43
    L30:
        r3.prefetchImage(r14, this.mLynxContext.getFrescoCallerContext(), (Map) r16);
    L31:
        if (r16 != null) goto L34;
        int r4 = 32101;
    L33:
        r10 = r4;
        r1 = "missing preloadKey!";
        goto L43
    L34:
        String r5 = r16.getString("preloadKey", null);
        String r6 = r16.getString("videoID", null);
        long r11 = r16.getLong("size", DEFAULT_MEDIA_SIZE);
        i8a.e r7 = (i8a.e) n.c().a(i8a.e.class);
        if (r7 != null) goto L37;
        r10 = 32103;
        r1 = "Resource service do not exist!";
        goto L43
    L37:
        if (r5 != null) goto L40;
        r4 = 32101;
        goto L33
    L40:
        r7.preloadMedia(r14, r5, r6, r11, null);
        goto L42
    L6:
        if (r15.equals(VIDEO_TYPE) == false) goto L19;
        r2 = 3;
        goto L21
    L10:
        if (r15.equals("image") == false) goto L19;
        r2 = 2;
        goto L21
    L14:
        if (r15.equals(AUDIO_TYPE) == false) goto L19;
        r2 = 1;
        goto L21
    L18:
        if (r15.equals(FONT_TYPE) == true) goto L21;
        goto L19
    }

    private void resourcePrefetchAwaitComplete(ReadableMap r28, Callback r29, long r30) {
        String r14 = NameKeys.UnloadStrategy_No_Strategy;
        JavaOnlyMap r15 = createResult(0, NameKeys.UnloadStrategy_No_Strategy);
        ReadableMap r10 = null;
        ReadableArray r9 = r28.getArray(DATA_KEY, null);
        if (r9 != null) goto L8;
        reportError(32101, "Parameters error in Lynx resource prefetch module! Value of 'data' should be an array.", PARAM_ERROR_FIX_SUGGESTION, null, "request");
        r15.putInt(CODE_KEY, 32101);
        r15.putString("msg", "Parameters error in Lynx resource prefetch module! Value of 'data' should be an array.");
        if (r29 == null) goto L38;
        r29.invoke(new Object[]{r15});
        return;
    L38:
        return;
    L8:
        int r8 = r9.size();
        if (r8 != 0) goto L13;
        if (r29 == null) goto L39;
        r29.invoke(new Object[]{r15});
        return;
    L39:
        return;
    L13:
        int[] r6 = {0};
        boolean[] r7 = {false};
        JavaOnlyArray r5 = new JavaOnlyArray();
        r15.putArray(DETAIL_KEY, r5);
        WeakReference r4 = new WeakReference(this);
        UIThreadUtils.runOnUiThread(new b(r4, r7, r15, r29, r6), r30);
        int r13 = 0;
    L14:
        if (r13 >= r8) goto L34;
        if (r9.getType(r13) == ReadableType.Map) goto L18;
        String r11 = "Parameters error in Lynx resource prefetch module! The prefetch data should be a map.";
        ReadableMap r12 = r10;
        String r2 = r14;
        String r3 = r2;
        Integer r20 = 32101;
    L29:
        String r210 = r2;
        String r31 = r3;
        String r21 = r14;
        ReadableMap r16 = r12;
        int r32 = r13;
        String r17 = r11;
        int[] r22 = r6;
        boolean[] r23 = r7;
        int r24 = r8;
        ReadableArray r25 = r9;
        ReadableMap r26 = r10;
        c r1 = new c(this, r4, r210, r7, r31, r5, r22, r8, r29, r15);
        if (r20.intValue() == 0) goto L32;
        r1.a(r20.intValue(), r17);
    L33:
        r13 = r32 + 1;
        r14 = r21;
        r6 = r22;
        r7 = r23;
        r8 = r24;
        r9 = r25;
        r10 = r26;
        goto L14
    L32:
        requestResourcePrefetchInternalAwaitComplete(r210, r31, r16, r1);
        goto L33
    L18:
        ReadableMap r0 = r9.getMap(r13);
        String r18 = r0.getString(URI_KEY, r14);
        String r19 = r0.getString("type", r14);
        ReadableMap r27 = r0.getMap(PARAMS_KEY, r10);
        if (r18 == null) goto L27;
        if (r19 == null) goto L27;
        if (r18.isEmpty() == true) goto L27;
        if (r19.isEmpty() == true) goto L27;
        Integer r33 = 0;
        String r34 = r14;
    L28:
        r11 = r34;
        r20 = r33;
        r12 = r27;
        r3 = r19;
        r2 = r18;
    L27:
        r34 = "Parameters error in Lynx resource prefetch module! 'uri' or 'type' is null.";
        r33 = 32101;
        goto L28
    }

    @LynxMethod
    public void requestResourcePrefetch(ReadableMap r7, Callback r8, ReadableMap r9) {
        TraceEvent.beginSection("requestResourcePrefetch");
        long r2 = AutoEndConversationTime.AFTER_60_SECONDS;
        if (r9 == null) goto L5;
        boolean r4 = r9.getBoolean("awaitComplete", false);
        r2 = r9.getLong("awaitTimeout", AutoEndConversationTime.AFTER_60_SECONDS);
    L6:
        if (r4 == false) goto L8;
        LLog.i(NAME, " start resourcePrefetchAwaitComplete with timeout: " + r2);
        resourcePrefetchAwaitComplete(r7, r8, r2);
        JavaOnlyMap r10 = null;
    L9:
        TraceEvent.endSection("requestResourcePrefetch");
        if (r10 == null) goto L14;
        if (r8 == null) goto L15;
        r8.invoke(new Object[]{r10});
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r10 = resourcePrefetch(r7, false);
        goto L9
    L5:
        r4 = false;
        goto L6
    }

    private void requestResourcePrefetchInternalAwaitComplete(String r16, String r17, ReadableMap r18, g r19) {
        boolean r2 = false;
        Integer r11 = 0;
        r17.getClass();
        switch(r17.hashCode()) {
            case 3148879: goto L18;
            case 93166550: goto L14;
            case 100313435: goto L10;
            case 112202875: goto L6;
            default: goto L21;
        };
    L21:
        byte r3 = -1;
    L22:
        if (r3 != 0) goto L24;
        FontFaceManager.g.a.m(this.mLynxContext, r16, new e(r19));
    L43:
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        r2 = true;
    L44:
        if (r2 == true) goto L46;
        ((c) r19).a(r11.intValue(), r1);
    L46:
        LLog.i(NAME, "requestResourcePrefetchInternalAwaitComplete uri: " + r16 + " type: " + r17);
        return;
    L24:
        if (r3 == 1) goto L32;
        if (r3 == 2) goto L28;
        if (r3 == 3) goto L32;
        r11 = 32101;
        r1 = "Parameters error! Unknown type :".concat(r17);
        goto L44
    L28:
        ILynxImageService r4 = this.mImagePrefetchHelper;
        if (r4 != null) goto L31;
        r11 = 32102;
        r1 = "Image prefetch helper do not exist!";
        goto L44
    L31:
        r4.prefetchImage(r16, this.mLynxContext.getFrescoCallerContext(), (Map) r18, new d(r19));
    L32:
        if (r18 != null) goto L35;
        int r5 = 32101;
    L34:
        r11 = r5;
        r1 = "missing preloadKey!";
        goto L44
    L35:
        String r6 = r18.getString("preloadKey", null);
        String r7 = r18.getString("videoID", null);
        long r13 = r18.getLong("size", DEFAULT_MEDIA_SIZE);
        i8a.e r8 = (i8a.e) n.c().a(i8a.e.class);
        if (r8 != null) goto L38;
        r11 = 32103;
        r1 = "Resource service do not exist!";
        goto L44
    L38:
        if (r6 != null) goto L41;
        r5 = 32101;
        goto L34
    L41:
        r8.preloadMedia(r16, r6, r7, r13, new f(r19));
        goto L43
    L6:
        if (r17.equals(VIDEO_TYPE) == false) goto L21;
        r3 = 3;
        goto L22
    L10:
        if (r17.equals("image") == false) goto L21;
        r3 = 2;
        goto L22
    L14:
        if (r17.equals(AUDIO_TYPE) == false) goto L21;
        r3 = 1;
        goto L22
    L18:
        if (r17.equals(FONT_TYPE) == false) goto L21;
        r3 = 0;
        goto L22
    }

    private void reportError(int r3, String r4, String r5, String r6, String r7) {
        LynxError r0 = new LynxError(r3, r4, r5, "error");
        if (r6 == null) goto L5;
        r0.addCustomInfo("resourceUri", r6);
    L5:
        if (r7 == null) goto L7;
        r0.addCustomInfo("actionType", r7);
    L7:
        this.mLynxContext.handleLynxError(r0);
    }

    public static /* synthetic */ void access$100(LynxResourceModule r0, int r1, String r2, String r3, String r4, String r5) {
        r0.reportError(r1, r2, r3, r4, r5);
    }
}
