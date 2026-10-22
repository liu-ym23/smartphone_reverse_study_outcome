package com.lynx.jsbridge;

import android.text.TextUtils;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.behavior.LynxContext;
import zm.t;

/* JADX INFO: loaded from: classes2.dex */
public class LynxTextInfoModule extends LynxContextModule {
    public static final String NAME = "LynxTextInfoModule";

    public LynxTextInfoModule(LynxContext r5) {
        super(r5);
    }

    @n
    public WritableMap getTextInfo(String r5, ReadableMap r10) {
        String r11 = r10.getString("fontSize");
        if (TextUtils.isEmpty(r11) == false) goto L6;
        JavaOnlyMap r12 = new JavaOnlyMap();
        r12.putInt("width", 0);
        return r12;
    L6:
        String r13 = r10.getString("fontFamily");
        String r14 = r10.getString("maxWidth");
        if (r10.hasKey("maxLine") == false) goto L9;
        int r15 = r10.getInt("maxLine");
    L11:
        return t.d(r5, r11, r13, r14, r15);
    L9:
        r15 = 1;
        goto L11
    }

    public LynxTextInfoModule(LynxContext r5, Object r10) {
        super(r5, r10);
    }
}
