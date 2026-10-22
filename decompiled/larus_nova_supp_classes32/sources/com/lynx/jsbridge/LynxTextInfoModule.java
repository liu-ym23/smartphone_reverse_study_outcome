package com.lynx.jsbridge;

import android.text.TextUtils;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxTextInfoModule extends LynxContextModule {
    public static final String NAME = "LynxTextInfoModule";

    public LynxTextInfoModule(LynxContext r1) {
        super(r1);
    }

    public LynxTextInfoModule(LynxContext r1, Object r2) {
        super(r1, r2);
    }

    @LynxMethod
    public WritableMap getTextInfo(String r6, ReadableMap r7) {
        String r0 = r7.getString("fontSize");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        JavaOnlyMap r8 = new JavaOnlyMap();
        r8.putInt("width", 0);
        return r8;
    L6:
        String r1 = r7.getString("fontFamily");
        String r2 = r7.getString("maxWidth");
        if (r7.hasKey("maxLine") == false) goto L9;
        int r9 = r7.getInt("maxLine");
    L11:
        return com.lynx.tasm.behavior.shadow.text.b.i(r6, r0, r1, r2, r9);
    L9:
        r9 = 1;
        goto L11
    }
}
