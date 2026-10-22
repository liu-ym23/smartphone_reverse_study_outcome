package com.larus.bmhome.utils;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a3 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ Function0<Unit> b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ExternalRedirectPromptFrequencyConfig.values().length];
            r0[ExternalRedirectPromptFrequencyConfig.FIRST_USE_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ExternalRedirectPromptFrequencyConfig.EACH_DOMAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ExternalRedirectPromptFrequencyConfig.NEVER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final void confirm() {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("click_type", 1);
        Unit r2 = Unit.INSTANCE;
        r0.reportEvent("external_domain_jumper", r1);
        ExternalRedirectPromptFrequencyConfig r3 = z2.a();
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        z2.b.storeBoolean("safety_domain_confirm_permission", true);
    L13:
        this.b.invoke();
        return;
    L5:
        if (r4 != 2) goto L7;
        String r5 = this.a;
        z2.a.storeBoolean(r5, true);
        goto L13
    L7:
        if (r4 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    public a3(String r1, Function0<Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
