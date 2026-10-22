package ad2;

import bytedance.io.BdFileSystem;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.ej1;
import com.bytedance.android.livesdk.config.si1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.bduploader.BDVideoUploader;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.TreeMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r<T> implements SingleOnSubscribe {
    public final /* synthetic */ k a;
    public final /* synthetic */ String b;
    public final /* synthetic */ BDVideoUploader c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Boolean h;
    public final /* synthetic */ CallContext i;

    public r(k r1, String r2, BDVideoUploader r3, String r4, String r5, String r6, String r7, Boolean r8, CallContext r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public final void subscribe(SingleEmitter<com.bytedance.android.livesdk.jsbridge.methods.upload.models.e> r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        String r0 = com.bytedance.android.live.core.utils.q.d(s1.getContext(), UriProtector.parse(this.b));
        long r1 = BdFileSystem.getFile(r0).length();
        this.c.setMediaDataReader(new d0(UriProtector.parse(r0), r1));
        this.c.setTopAccessKey(this.d);
        this.c.setTopSecretKey(this.e);
        this.c.setTopSessionToken(this.f);
        this.c.setSpaceName(this.g);
        BDVideoUploader r2 = this.c;
        ej1 r3 = ej1.a;
        r2.setUploadDomain(((si1) r3.getValue()).a());
        this.c.setSliceSize(((si1) r3.getValue()).b());
        if (Intrinsics.areEqual(this.h, Boolean.TRUE) == false) goto L5;
        this.c.setConfig(new TreeMap(MapsKt.mapOf(TuplesKt.to("copies", "both"))));
        BDVideoUploader r4 = this.c;
        int r5 = k.a;
        r4.setProcessActionType(1);
    L5:
        BDVideoUploader r7 = this.c;
        k r8 = this.a;
        CallContext r9 = this.i;
        r8.getClass();
        r7.setListener(new m(r7, r6, r9));
        this.c.start();
    }
}
