package com.lynx.debugrouter;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class MessageAssembler {
    public MessageAssembler() {
    }

    public static native String nativeAssembleDispatchDocumentUpdated();

    public static native String nativeAssembleDispatchFrameNavigated(String r0);

    public static native String nativeAssembleDispatchScreencastVisibilityChanged(boolean r0);

    public static native String nativeAssembleScreenCastFrame(int r0, String r1, String r2);

    public static String assembleDispatchDocumentUpdated() {
        return nativeAssembleDispatchDocumentUpdated();
    }

    public static String assembleDispatchFrameNavigated(String r0) {
        return nativeAssembleDispatchFrameNavigated(r0);
    }

    public static String assembleDispatchScreencastVisibilityChanged(boolean r0) {
        return nativeAssembleDispatchScreencastVisibilityChanged(r0);
    }

    public static String assembleScreenCastFrame(int r1, String r2, Map<String, Float> r3) {
        return nativeAssembleScreenCastFrame(r1, r2, new JSONObject(r3).toString());
    }
}
