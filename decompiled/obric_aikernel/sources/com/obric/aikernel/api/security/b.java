package com.obric.aikernel.api.security;

import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class b implements com.obric.aikernel.api.d {

    public static final class a implements PackageResourceManager.PresmConfig.b {
        a() {
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
        public Object a(String r10, String r11, String r12, String r13, String r14, Continuation<? super Pair<Boolean, String>> r15) {
            return PackageResourceManager.PresmConfig.b.a.a(this, r10, r11, r12, r13, r14, r15);
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
        public boolean b() {
            return PackageResourceManager.PresmConfig.b.a.b(this);
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
        public boolean c(String r10, String r11) {
            return PackageResourceManager.PresmConfig.b.a.d(this, r10, r11);
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
        public Object d(Map<String, ? extends List<Pair<String, k>>> r10, Continuation<? super Unit> r11) {
            return PackageResourceManager.PresmConfig.b.a.f(this, r10, r11);
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
        public String e(String r10, String r11) {
            return PackageResourceManager.PresmConfig.b.a.c(this, r10, r11);
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
        public boolean isPresetDecrypted(String r10, String r11) {
            return PackageResourceManager.PresmConfig.b.a.e(this, r10, r11);
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
        public Object waitDecrypting(Collection<String> r10, Continuation<? super Unit> r11) {
            return PackageResourceManager.PresmConfig.b.a.g(this, r10, r11);
        }
    }

    public b() {
    }

    public boolean a() {
        return false;
    }

    public PackageResourceManager.PresmConfig.b b(PackageResourceManager.PresmConfig r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        return new a();
    }

    @Deprecated(message = "useless from 26.06.01")
    public int c() {
        return 0;
    }
}
