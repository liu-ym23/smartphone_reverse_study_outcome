package f0;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f7239a;

    public g(Object r8) {
        this.f7239a = (LocaleList) r8;
    }

    @Override // f0.f
    public final String a() {
        return this.f7239a.toLanguageTags();
    }

    @Override // f0.f
    public final Object b() {
        return this.f7239a;
    }

    public final boolean equals(Object r8) {
        Object r10 = ((f) r8).b();
        return this.f7239a.equals(r10);
    }

    @Override // f0.f
    public final Locale get(int r8) {
        return this.f7239a.get(r8);
    }

    public final int hashCode() {
        return this.f7239a.hashCode();
    }

    @Override // f0.f
    public final boolean isEmpty() {
        return this.f7239a.isEmpty();
    }

    @Override // f0.f
    public final int size() {
        return this.f7239a.size();
    }

    public final String toString() {
        return this.f7239a.toString();
    }
}
