package li8;

import android.os.Build;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.platform.service.i2;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements Function0 {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ LocalTakePictureImpl b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;

    public /* synthetic */ j(Fragment r1, LocalTakePictureImpl r2, boolean r3, boolean r4, boolean r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke() {
        Fragment r0 = this.a;
        final LocalTakePictureImpl r2 = this.b;
        final boolean r3 = this.c;
        final boolean r4 = this.d;
        final boolean r5 = this.e;
        final boolean r6 = this.f;
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        List r7 = CollectionsKt.mutableListOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE"});
        i2 r1 = i2.b;
        i2.q(r0, r7, new b(r2, r3, r4, r5, r6));
    L7:
        return Unit.INSTANCE;
    L5:
        r2.a(r3, r4, r5, r6);
        goto L7
    }
}
