package j3;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class c implements k3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8580a;

    public c(String r8) {
        this.f8580a = r8;
    }

    @Override // k3.c
    public final boolean isValid() {
        return !TextUtils.isEmpty(this.f8580a);
    }

    public final String toString() {
        return android.aimedia.a.i(new StringBuilder("Apm5LegacyEvent{logType='"), this.f8580a, "'}");
    }
}
