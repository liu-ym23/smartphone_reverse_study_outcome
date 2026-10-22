package qh0;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.log.j0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements DialogInterface.OnClickListener {
    public final /* synthetic */ Map a;

    public q(Map r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        r3.dismiss();
        j0.l().sendLog("livesdk_anchor_face_recognition_cancel_click", this.a, new Object[0]);
    }
}
