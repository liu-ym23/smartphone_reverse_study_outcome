package j7b;

import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.z;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements d {
    public b() {
    }

    @Override // j7b.d
    public final void a(Channel r3, int r4, int r5, boolean r6) {
        Log.i("chatwindow", "clear Badge, channel: " + r3 + " maxPosition: " + r4);
        z.a r0 = new z.a();
        r0.a(r3);
        r0.b(new ArrayList());
        ArrayList r7 = new ArrayList();
        Intrinsics.checkNotNullParameter(r7, "foldIds");
        r0.c = r7;
        r0.d = r4;
        r0.e = r5;
        r0.g = r6;
        ImSdkService.f().yb(new z(r0));
    }
}
