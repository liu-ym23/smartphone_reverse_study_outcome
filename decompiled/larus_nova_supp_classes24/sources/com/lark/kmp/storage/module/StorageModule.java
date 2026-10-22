package com.lark.kmp.storage.module;

import com.lark.kmp.containerization.b;
import com.lark.kmp.storage.GlobalLarkStorage;
import com.lark.kmp.storage.UserLarkStorage;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class StorageModule {
    static {
    }

    public static void a(final b r2) {
        Intrinsics.checkNotNullParameter(r2, "globalContainer");
        Function0<GlobalLarkStorage> r0 = new StorageModule$bindGlobalStorage$1(r2);
        r2.c(Reflection.getOrCreateKotlinClass(GlobalLarkStorage.class), r0);
    }

    public static void b(final String r1, final b r2) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r2, "userContainer");
        Function0<UserLarkStorage> r0 = new StorageModule$bindUserStorage$1(r1, r2);
        r2.c(Reflection.getOrCreateKotlinClass(UserLarkStorage.class), r0);
    }
}
