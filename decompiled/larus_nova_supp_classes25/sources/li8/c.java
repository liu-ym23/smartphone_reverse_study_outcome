package li8;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ LocalTakePictureImpl a;

    public /* synthetic */ c(LocalTakePictureImpl r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        LocalTakePictureImpl r0 = this.a;
        Intent r4 = (Intent) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        ActivityResultLauncher r1 = r0.a;
        if (r1 == null) goto L6;
        v19.b.a(r1, r4);
    L6:
        return Unit.INSTANCE;
    }
}
