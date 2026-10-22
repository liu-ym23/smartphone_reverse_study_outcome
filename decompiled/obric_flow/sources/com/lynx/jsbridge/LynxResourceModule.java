package com.lynx.jsbridge;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.ILynxImageService;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LynxResourceModule extends LynxContextModule {
    public static final String AUDIO_TYPE = "audio";
    public static final String CODE_KEY = "code";
    public static final String DATA_KEY = "data";
    public static final long DEFAULT_MEDIA_SIZE = 512000;
    public static final String DETAIL_KEY = "details";
    public static final String IMAGE_TYPE = "image";
    public static final String MSG_KEY = "msg";
    public static final String NAME = "LynxResourceModule";
    public static final String PARAMS_KEY = "params";
    public static final String TYPE_KEY = "type";
    public static final String URI_KEY = "uri";
    public static final String VIDEO_TYPE = "video";
    private ILynxImageService mImagePrefetchHelper;

    @RequiresApi(api = 19)
    public LynxResourceModule(LynxContext r5) {
        super(r5);
        ILynxImageService r10 = (ILynxImageService) ko.r.g().e(ILynxImageService.class);
        this.mImagePrefetchHelper = r10;
        if (r10 != null) goto L6;
        onErrorOccurred(new LynxError(32102, "An exception occurred when try to get image prefetch helper.", "An error occurred while attempting to create a Java object ImagePrefetchHelper through reflection. This may be due to a change in the constructor interface of ImagePrefetchHelper, or because ImagePrefetchHelper is located in a plugin that is not ready. If you are unable to resolve this issue, you can seek help from the client RD.", "error"));
        return;
    }

    private Pair<Integer, String> cancelResourcePrefetchInternal(String r10, String r11, @Nullable ReadableMap r12) {
        byte r5 = 0;
        int r13 = 0;
        r11.getClass();
        switch(r11.hashCode()) {
            case 93166550: goto L14;
            case 100313435: goto L10;
            case 112202875: goto L6;
            default: goto L4;
        };
    L4:
        r5 = -1;
    L16:
        switch(r5) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L22;
            default: goto L17;
        };
    L17:
        String r14 = "Parameters error! Unknown type :".concat(r11);
    L18:
        r13 = 32101;
    L32:
        LynxLog.b(2, NAME, com.lynx.tasm.utils.b.j("requestResourcePrefetch uri: ", r10, " type: ", r11));
        return new Pair(r13, r14);
    L22:
        r14 = "missing preloadKey!";
        if (r12 == null) goto L18;
        String r15 = r12.getString("preloadKey", null);
        String r16 = r12.getString("videoID", null);
        ko.e r17 = (ko.e) ko.r.g().e(ko.e.class);
        if (r17 != null) goto L28;
        r13 = 32103;
        r14 = "Resource service do not exist!";
        goto L32
    L28:
        if (r15 == null) goto L18;
        r17.cancelPreloadMedia(r15, r16);
    L31:
        r14 = "";
        goto L32
    L20:
        if (this.mImagePrefetchHelper != null) goto L31;
        r13 = 32102;
        r14 = "Image prefetch helper do not exist!";
        goto L32
    L6:
        if (r11.equals("video") == false) goto L34;
        r5 = 2;
        goto L16
    L34:
        r5 = -1;
        goto L16
    L10:
        if (r11.equals("image") == false) goto L35;
        r5 = 1;
        goto L16
    L35:
        r5 = -1;
        goto L16
    L14:
        if (r11.equals("audio") == true) goto L16;
        r5 = -1;
        goto L16
    }

    private void onErrorOccurred(LynxError r5) {
        this.mLynxContext.b(r5);
    }

    private Pair<Integer, String> requestResourcePrefetchInternal(String r12, String r13, @Nullable ReadableMap r14) {
        byte r5 = 0;
        int r10 = 0;
        r13.getClass();
        switch(r13.hashCode()) {
            case 93166550: goto L14;
            case 100313435: goto L10;
            case 112202875: goto L6;
            default: goto L4;
        };
    L4:
        r5 = -1;
    L16:
        switch(r5) {
            case 0: goto L23;
            case 1: goto L19;
            case 2: goto L23;
            default: goto L17;
        };
    L17:
        String r11 = "Parameters error! Unknown type :".concat(r13);
    L18:
        r10 = 32101;
    L33:
        LynxLog.b(2, NAME, com.lynx.tasm.utils.b.j("requestResourcePrefetch uri: ", r12, " type: ", r13));
        return new Pair(r10, r11);
    L19:
        ILynxImageService r15 = this.mImagePrefetchHelper;
        if (r15 != null) goto L22;
        r10 = 32102;
        r11 = "Image prefetch helper do not exist!";
        goto L33
    L22:
        this.mLynxContext.getClass();
        r15.prefetchImage(r12, null, (Map) r14);
    L32:
        r11 = "";
        goto L33
    L23:
        r11 = "missing preloadKey!";
        if (r14 == null) goto L18;
        String r16 = r14.getString("preloadKey", null);
        String r17 = r14.getString("videoID", null);
        long r18 = r14.getLong("size", DEFAULT_MEDIA_SIZE);
        ko.e r19 = (ko.e) ko.r.g().e(ko.e.class);
        if (r19 != null) goto L29;
        r10 = 32103;
        r11 = "Resource service do not exist!";
        goto L33
    L29:
        if (r16 == null) goto L18;
        r19.preloadMedia(r12, r16, r17, r18);
        goto L32
    L6:
        if (r13.equals("video") == false) goto L35;
        r5 = 2;
        goto L16
    L35:
        r5 = -1;
        goto L16
    L10:
        if (r13.equals("image") == false) goto L36;
        r5 = 1;
        goto L16
    L36:
        r5 = -1;
        goto L16
    L14:
        if (r13.equals("audio") == true) goto L16;
        r5 = -1;
        goto L16
    }

    private Pair<Integer, String> resourcePrefetch(ReadableMap r18, boolean r19, JavaOnlyMap r20) {
        int r5 = 0;
        Integer r10 = 0;
        ReadableArray r11 = r18.getArray("data", null);
        String r12 = "request";
        if (r11 != null) goto L8;
        String r13 = "Parameters error in Lynx resource prefetch module! Value of 'data' should be an array.";
        LynxError r14 = new LynxError(32101, "Parameters error in Lynx resource prefetch module! Value of 'data' should be an array.", "Please check the parameters passed to Lynx resource prefetch module.", "error");
        if (r19 == false) goto L7;
        r12 = "cancel";
    L7:
        r14.b("actionType", r12);
        onErrorOccurred(r14);
        r10 = 32101;
    L34:
        return new Pair(r10, r13);
    L8:
        JavaOnlyArray r15 = new JavaOnlyArray();
    L10:
        if (r5 >= r11.size()) goto L32;
        JavaOnlyMap r16 = new JavaOnlyMap();
        if (r11.getType(r5) == ReadableType.Map) goto L15;
        String r17 = "Parameters error in Lynx resource prefetch module! The prefetch data should be a map.";
        Integer r110 = r10;
        ReadableArray r111 = r11;
        String r112 = "";
    L14:
        Integer r113 = 32101;
    L25:
        if (r113.intValue() == 0) goto L31;
        LynxError r21 = new LynxError(r113.intValue(), r17, "If it is a parameter error, please check the parameters passed in. If the Resource service does not exist, it may be due to an error that occurred while creating the resource service through reflection. Please contact the client RD for help.", "error");
        r21.b("resourceUri", r112);
        if (r19 == false) goto L29;
        String r22 = "cancel";
    L30:
        r21.b("actionType", r22);
        onErrorOccurred(r21);
        goto L31
    L29:
        r22 = "request";
    L31:
        r16.putInt("code", r113.intValue());
        r16.putString("msg", r17);
        r15.pushMap(r16);
        r5 = r5 + 1;
        r11 = r111;
        r10 = r110;
        goto L10
    L15:
        ReadableMap r114 = r11.getMap(r5);
        r112 = r114.getString(URI_KEY, null);
        r110 = r10;
        String r23 = r114.getString("type", null);
        r111 = r11;
        ReadableMap r24 = r114.getMap(PARAMS_KEY, null);
        if (r112 == null) goto L23;
        if (r23 == null) goto L23;
        if (r19 == false) goto L21;
        Pair<Integer, String> r25 = cancelResourcePrefetchInternal(r112, r23, r24);
    L22:
        r113 = (Integer) r25.first;
        String r26 = (String) r25.second;
        r16.putString(URI_KEY, r112);
        r16.putString("type", r23);
        r17 = r26;
        goto L25
    L21:
        r25 = requestResourcePrefetchInternal(r112, r23, r24);
    L23:
        r17 = "Parameters error in Lynx resource prefetch module! 'uri' or 'type' is null.";
        goto L14
    L32:
        r20.putArray(DETAIL_KEY, r15);
        r13 = "";
        goto L34
    }

    @n
    public void cancelResourcePrefetch(ReadableMap r5, Callback r10) {
        TraceEvent.c("cancelResourcePrefetch");
        JavaOnlyMap r11 = new JavaOnlyMap();
        Pair<Integer, String> r12 = resourcePrefetch(r5, true, r11);
        Integer r13 = (Integer) r12.first;
        String r14 = (String) r12.second;
        TraceEvent.a(0, "cancelResourcePrefetch");
        r11.putInt("code", r13.intValue());
        r11.putString("msg", r14);
        if (r10 == null) goto L6;
        r10.invoke(new Object[]{r11});
        return;
    }

    @n
    public void requestResourcePrefetch(ReadableMap r5, Callback r10) {
        TraceEvent.c("requestResourcePrefetch");
        JavaOnlyMap r11 = new JavaOnlyMap();
        Pair<Integer, String> r12 = resourcePrefetch(r5, false, r11);
        Integer r13 = (Integer) r12.first;
        String r14 = (String) r12.second;
        TraceEvent.a(0, "requestResourcePrefetch");
        r11.putInt("code", r13.intValue());
        r11.putString("msg", r14);
        if (r10 == null) goto L6;
        r10.invoke(new Object[]{r11});
        return;
    }

    @n
    public void requestResourcePrefetchImage(ReadableMap r10, Callback r11) {
        String r5 = r10.getString(URI_KEY, null);
        ReadableMap r12 = r10.getMap(PARAMS_KEY, null);
        if (r5 != null) goto L8;
        onErrorOccurred(new LynxError(32101, "Parameters error in Lynx resource prefetch module! 'uri' is null.", "Please check the parameters passed to Lynx resource prefetch module.", "error"));
        if (r11 == null) goto L16;
        JavaOnlyMap r13 = new JavaOnlyMap();
        r13.putInt("code", 32101);
        r13.putString("msg", "Parameters error in Lynx resource prefetch module! 'uri' is null.");
        r11.invoke(new Object[]{r13});
        return;
    L16:
        return;
    L8:
        ILynxImageService r14 = this.mImagePrefetchHelper;
        if (r14 != null) goto L14;
        onErrorOccurred(new LynxError(32102, "Image prefetch helper do not exist!", "If the Resource service does not exist, it may be due to an error that occurred while creating the resource service through reflection. Please contact the client RD for help.", "error"));
        if (r11 == null) goto L17;
        JavaOnlyMap r15 = new JavaOnlyMap();
        r15.putInt("code", 32102);
        r15.putString("msg", "Image prefetch helper do not exist!");
        r11.invoke(new Object[]{r15});
        return;
    L17:
        return;
    L14:
        this.mLynxContext.getClass();
        r14.prefetchImage(r5, null, (Map) r12, new ym.d(r11));
    }
}
