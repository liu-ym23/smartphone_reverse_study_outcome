package om8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.miaodaartifact.viewmodel.MiaodaArtifactVMData;
import com.larus.platform.service.LarkConnectorArtifactService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements nm8.d {
    public final /* synthetic */ b a;

    public final void b() {
        MiaodaArtifactVMData r0 = this.a.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (LarkConnectorArtifactService.a.c(r0.a) == false) goto L8;
        return;
    L8:
        String r1 = r0.b;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.length() <= 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L17;
        r1 = null;
    L17:
        if (r1 == null) goto L23;
        c r3 = this.a.b;
        if (r3 == null) goto L24;
        r3.b(r1);
        return;
    L24:
        return;
    L23:
        return;
    L13:
        r2 = false;
        goto L14
    }

    public a(b r1) {
        this.a = r1;
    }

    @Override // nm8.d
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        b r0 = this.a;
        MiaodaArtifactVMData r1 = r0.a;
        if (r1 == null) goto L8;
        c r2 = r0.b;
        if (r2 == null) goto L9;
        r2.a(r3, r1);
        return;
    L9:
        return;
    }
}
