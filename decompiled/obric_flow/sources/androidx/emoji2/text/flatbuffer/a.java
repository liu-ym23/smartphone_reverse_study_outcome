package androidx.emoji2.text.flatbuffer;

import com.google.common.math.l;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f521a;

    public /* synthetic */ a(int r5) {
        this.f521a = r5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch(this.f521a) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        l r5 = new l();
        r5.f9311a = 0;
        r5.f9312b = 0.0d;
        r5.f9313c = 0.0d;
        r5.d = Double.NaN;
        r5.e = Double.NaN;
        return r5;
    L7:
        return Utf8Old.a();
    }
}
