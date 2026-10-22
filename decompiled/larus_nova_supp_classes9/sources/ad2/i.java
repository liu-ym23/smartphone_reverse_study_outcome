package ad2;

import bytedance.io.BdFileSystem;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.ej1;
import com.bytedance.android.livesdk.config.si1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.bduploader.BDVideoUploader;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements ObservableOnSubscribe {
    public final /* synthetic */ c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ BDVideoUploader c;
    public final /* synthetic */ com.bytedance.android.livesdk.jsbridge.methods.upload.models.c d;
    public final /* synthetic */ CallContext e;

    public i(c r1, String r2, BDVideoUploader r3, com.bytedance.android.livesdk.jsbridge.methods.upload.models.c r4, CallContext r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void subscribe(ObservableEmitter<com.bytedance.android.livesdk.jsbridge.methods.upload.models.d> r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        String r0 = com.bytedance.android.live.core.utils.q.d(s1.getContext(), UriProtector.parse(this.b));
        long r1 = BdFileSystem.getFile(r0).length();
        this.c.setTopAccessKey(this.d.a);
        this.c.setTopSecretKey(this.d.b);
        this.c.setTopSessionToken(this.d.c);
        this.c.setSpaceName(this.d.d);
        BDVideoUploader r3 = this.c;
        ej1 r4 = ej1.a;
        r3.setUploadDomain(((si1) r4.getValue()).a());
        this.c.setSliceSize(((si1) r4.getValue()).b());
        this.c.setUserReference(this.d.e);
        this.c.setMediaDataReader(new d0(UriProtector.parse(r0), r1));
        BDVideoUploader r2 = this.c;
        c r5 = this.a;
        CallContext r6 = this.e;
        r5.getClass();
        r2.setListener(new d(r2, r7, r6));
        this.c.start();
    }
}
