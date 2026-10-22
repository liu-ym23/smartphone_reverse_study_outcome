package com.obric.aikernel.multiusr;

import com.obric.aikernel.AuthProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class AuthProviderEntry extends AuthProvider {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f4716i;

    public AuthProviderEntry() {
        this(false, 1, null);
    }

    public AuthProviderEntry(boolean r10) {
        super(null, false, 3, null);
        this.f4716i = r10;
    }

    public /* synthetic */ AuthProviderEntry(boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = false;
    L5:
        this(r10);
    }

    @Override // com.obric.aikernel.AuthProvider
    public boolean d() {
        return this.f4716i;
    }
}
