package com.larus.agents.impl.network;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(String r3, Class r4, JSONObject r5, ContinuationImpl r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WorkExperienceRemote$post$2(r4, r3, r5, null), r6);
    }
}
