package li8;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ LocalTakePictureImpl a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ String h;

    public /* synthetic */ d(LocalTakePictureImpl r1, Fragment r2, String r3, String r4, boolean r5, boolean r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = true;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
    }

    public final Object invoke(Object r10) {
        LocalTakePictureImpl r0 = this.a;
        Fragment r1 = this.b;
        String r3 = this.c;
        boolean r4 = this.d;
        String r5 = this.e;
        boolean r6 = this.f;
        boolean r7 = this.g;
        String r2 = this.h;
        String r11 = (String) r10;
        if (r11 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == true) goto L11;
        r0.b(r1, r11, r3, r4, r5, r6, r7);
    L13:
        return Unit.INSTANCE;
    L11:
        FLogger.a.e("TakePictureService", "editPhotoFromRemoteUrl failed: " + r2);
        goto L13
    L5:
        if (r11.length() == 0) goto L8;
        r8 = false;
        goto L9
    }
}
