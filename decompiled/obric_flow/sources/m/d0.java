package m;

import java.util.function.Supplier;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19870b;

    public d0(String r5, int r10) {
        this.f19869a = r5;
        this.f19870b = r10;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Pattern.compile(this.f19869a, this.f19870b);
    }
}
