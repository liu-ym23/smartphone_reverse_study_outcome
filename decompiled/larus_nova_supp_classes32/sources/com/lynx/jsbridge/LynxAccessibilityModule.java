package com.lynx.jsbridge;

import android.os.Build;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxAccessibilityModule extends LynxContextModule {
    public static final String MSG = "msg";
    public static final String MSG_CONTENT = "content";
    public static final String MSG_MUTATION_STYLES = "mutation_styles";
    public static final String NAME = "LynxAccessibilityModule";

    public class a extends f6a.e {
        public final /* synthetic */ ReadableMap b;
        public final /* synthetic */ Callback c;
        public final /* synthetic */ LynxAccessibilityModule d;

        @Override // f6a.e
        public final void a() {
            JavaOnlyMap r0 = new JavaOnlyMap();
            this.d.registerMutationStyleInner(this.b, r0);
            this.c.invoke(new Object[]{r0});
        }

        public a(LynxAccessibilityModule r1, LynxContext r2, ReadableMap r3, Callback r4) {
            this.d = r1;
            this.b = r3;
            this.c = r4;
            super(r2);
        }
    }

    public class b extends f6a.e {
        public final /* synthetic */ ReadableMap b;
        public final /* synthetic */ Callback c;
        public final /* synthetic */ LynxAccessibilityModule d;

        @Override // f6a.e
        public final void a() {
            JavaOnlyMap r0 = new JavaOnlyMap();
            this.d.accessibilityAnnounceInner(this.b, r0);
            this.c.invoke(new Object[]{r0});
        }

        public b(LynxAccessibilityModule r1, LynxContext r2, ReadableMap r3, Callback r4) {
            this.d = r1;
            this.b = r3;
            this.c = r4;
            super(r2);
        }
    }

    public LynxAccessibilityModule(LynxContext r1) {
        super(r1);
    }

    @LynxMethod
    public void accessibilityAnnounce(ReadableMap r3, Callback r4) {
        UIThreadUtils.runOnUiThread(new b(this, this.mLynxContext, r3, r4));
    }

    public void accessibilityAnnounceInner(ReadableMap r4, JavaOnlyMap r5) {
        if (r4 == null) goto L4;
        String r6 = r4.getString(MSG_CONTENT);
    L6:
        if (r6 == null) goto L17;
        LynxContext r1 = this.mLynxContext;
        if (r1 != null) goto L10;
    L16:
        r5.putString("msg", "Error: LynxView missing");
        return;
    L10:
        if (r1.getLynxView() == null) goto L16;
        if (Build.VERSION.SDK_INT < 28) goto L14;
        this.mLynxContext.getLynxView().setAccessibilityPaneTitle(r6);
    L15:
        r5.putString("msg", "Success");
        return;
    L14:
        this.mLynxContext.getLynxView().announceForAccessibility(r6);
        goto L15
    L17:
        r5.putString("msg", "Params error: no content found");
        return;
    L4:
        r6 = null;
        goto L6
    }

    @LynxMethod
    public void registerMutationStyle(ReadableMap r3, Callback r4) {
        UIThreadUtils.runOnUiThread(new a(this, this.mLynxContext, r3, r4));
    }

    public void registerMutationStyleInner(ReadableMap r6, JavaOnlyMap r7) {
        if (this.mLynxContext.getLynxAccessibilityWrapper() != null) goto L6;
        r7.putString("msg", "Fail: init accessibility env error with a11y wrapper is null");
        return;
    L6:
        com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mLynxContext.getLynxAccessibilityWrapper();
        if (r0.k != null) goto L9;
    L26:
        r7.putString("msg", "Fail: init accessibility mutation env error");
        return;
    L9:
        if (r0.e() == false) goto L11;
    L13:
        ReadableArray r8 = r6.getArray(MSG_MUTATION_STYLES, null);
        if (r8 != null) goto L16;
        r7.putString("msg", "Fail: params error with keymutation_styles");
        return;
    L16:
        com.lynx.tasm.behavior.ui.accessibility.a r1 = r0.k;
        Set<String> r2 = r1.b;
        if (r2 == null) goto L25;
        ((HashSet) r2).clear();
        int r3 = 0;
    L20:
        if (r3 >= r8.size()) goto L25;
        if (r8.getType(r3) != ReadableType.String) goto L24;
        Set<String> r4 = r1.b;
        HashSet r5 = (HashSet) r4;
        r5.add(r8.getString(r3));
    L24:
        r3 = r3 + 1;
    L25:
        r7.putString("msg", "Success: finish register");
        return;
    L11:
        if (r0.f() == true) goto L13;
        goto L13
    }
}
