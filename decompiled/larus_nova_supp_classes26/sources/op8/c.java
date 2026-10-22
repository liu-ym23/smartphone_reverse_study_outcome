package op8;

import android.net.Uri;
import android.view.View;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class c implements f {
    public c() {
    }

    @Override // op8.f
    public void A3(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "uriList");
    }

    @Override // op8.f
    public void M7(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "inputView");
        Intrinsics.checkNotNullParameter(r3, "addedItemUri");
    }

    @Override // op8.f
    public void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }

    @Override // op8.f
    public void b(int r1, long r2) {
    }

    @Override // op8.f
    public void d(int r1) {
    }

    @Override // op8.f
    public void e(f.a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // op8.f
    public void f(f.b r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // op8.f
    public void f4(View r2) {
        Intrinsics.checkNotNullParameter(r2, "inputView");
    }

    @Override // op8.f
    public boolean g() {
        return false;
    }

    @Override // op8.f
    public void h(boolean r1) {
    }

    @Override // op8.f
    public void h0(Uri r1) {
    }

    @Override // op8.f
    public Map<String, String> getEventInfo() {
        return new LinkedHashMap();
    }
}
