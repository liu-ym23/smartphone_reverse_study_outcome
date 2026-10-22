package com.larus.agents.impl.network;

import com.larus.agents.impl.experience.WorkExperienceMutationResult;
import com.larus.agents.impl.experience.p;
import com.larus.agents.impl.experience.s;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface m {
    Object a(p r1, Continuation<? super WorkExperienceMutationResult> r2);

    Object b(boolean r1, Continuation<? super WorkExperienceMutationResult> r2);

    Object c(String r1, Continuation<? super Result<com.larus.agents.impl.experience.n>> r2);

    Object d(int r1, String r2, Continuation<? super Result<s>> r3);

    Object delete(String r1, Continuation<? super WorkExperienceMutationResult> r2);

    Object e(Continuation<? super Result<Boolean>> r1);

    Object update(String r1, p r2, Continuation<? super WorkExperienceMutationResult> r3);
}
