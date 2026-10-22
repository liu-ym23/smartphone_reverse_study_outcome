package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class LynxAccessibilityModule extends LynxContextModule {
    public static final String MSG = "msg";
    public static final String MSG_CONTENT = "content";
    public static final String MSG_MUTATION_STYLES = "mutation_styles";
    public static final String NAME = "LynxAccessibilityModule";

    public LynxAccessibilityModule(LynxContext r5) {
        super(r5);
    }

    @n
    public void accessibilityAnnounce(ReadableMap r10, Callback r11) {
        c r12 = new c(this, this.mLynxContext, r10, r11, 1);
        com.lynx.tasm.utils.j.a().post(r12);
    }

    public void accessibilityAnnounceInner(ReadableMap r5, JavaOnlyMap r10) {
        if (r5 == null) goto L4;
        String r11 = r5.getString("content");
    L6:
        if (r11 == null) goto L15;
        LynxContext r12 = this.mLynxContext;
        if (r12 != null) goto L10;
    L13:
        r10.putString("msg", "Error: LynxView missing");
        return;
    L10:
        if (r12.k() == null) goto L13;
        this.mLynxContext.k().setAccessibilityPaneTitle(r11);
        r10.putString("msg", "Success");
        return;
    L15:
        r10.putString("msg", "Params error: no content found");
        return;
    L4:
        r11 = null;
        goto L6
    }

    @n
    public void registerMutationStyle(ReadableMap r10, Callback r11) {
        c r12 = new c(this, this.mLynxContext, r10, r11, 0);
        com.lynx.tasm.utils.j.a().post(r12);
    }

    public void registerMutationStyleInner(ReadableMap r5, JavaOnlyMap r10) {
        if (this.mLynxContext.j() != null) goto L6;
        r10.putString("msg", "Fail: init accessibility env error with a11y wrapper is null");
        return;
    L6:
        com.lynx.tasm.behavior.ui.accessibility.d r11 = this.mLynxContext.j();
        if (r11.f10411k != null) goto L9;
    L28:
        r10.putString("msg", "Fail: init accessibility mutation env error");
        return;
    L9:
        if (r11.f() == false) goto L11;
    L13:
        ReadableArray r12 = r5.getArray(MSG_MUTATION_STYLES, null);
        if (r12 != null) goto L17;
        r10.putString("msg", "Fail: params error with keymutation_styles");
        return;
    L17:
        ym.p r13 = r11.f10411k;
        HashSet r14 = (HashSet) r13.f23313c;
        if (r14 == null) goto L26;
        r14.clear();
        int r15 = 0;
    L21:
        if (r15 >= r12.size()) goto L26;
        if (r12.getType(r15) != ReadableType.String) goto L25;
        ((HashSet) r13.f23313c).add(r12.getString(r15));
    L25:
        r15 = r15 + 1;
    L26:
        r10.putString("msg", "Success: finish register");
        return;
    L11:
        if (r11.g() == true) goto L13;
        goto L13
    }
}
