package mv0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 implements l71.g {
    public static final d0 a = null;

    public d0() {
    }

    static {
        a = new d0();
    }

    @Override // l71.g
    public final Map<String, String> a(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        int r0 = ju2.f.M;
        return ju2.f.a.a(r2).b();
    }
}
