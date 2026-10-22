package com.larus.agents.impl.settings;

import com.bytedance.keva.Keva;
import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
import com.larus.platform.service.AccountService;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class KevaOfficeTaskPreferenceRepository implements e {

    public static final class a {
    }

    static {
    }

    public KevaOfficeTaskPreferenceRepository() {
    }

    public static final Keva c(KevaOfficeTaskPreferenceRepository r2) {
        r2.getClass();
        int r3 = c.a;
        String r4 = AccountService.a.getSecUserId();
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r4 = "guest";
    L9:
        return Keva.getRepo(r4.concat("_office_task_preference"), 0);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.agents.impl.settings.e
    public final Object a(Continuation<? super b> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new KevaOfficeTaskPreferenceRepository$get$2(this, null), r4);
    }

    @Override // com.larus.agents.impl.settings.e
    public final Object b(String r4, Continuation<? super OfficeTaskPreferenceSaveResult> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new KevaOfficeTaskPreferenceRepository$save$2(r4, this, null), r5);
    }
}
