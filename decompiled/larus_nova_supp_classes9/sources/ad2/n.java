package ad2;

import com.bytedance.android.livesdk.config.dj1;
import com.bytedance.android.livesdk.config.ri1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.bduploader.BDImageUploader;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<T> implements ObservableOnSubscribe {
    public final /* synthetic */ k a;
    public final /* synthetic */ BDImageUploader b;
    public final /* synthetic */ List c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Boolean h;
    public final /* synthetic */ CallContext i;

    public n(k r1, BDImageUploader r2, List r3, String r4, String r5, String r6, String r7, Boolean r8, CallContext r9) {
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

    public final void subscribe(ObservableEmitter<Pair<Integer, com.bytedance.android.livesdk.jsbridge.methods.upload.models.a>> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        BDImageUploader r0 = this.b;
        int r1 = this.c.size();
        Object[] r2 = this.c.toArray(new String[0]);
        if (r2 == null) goto L10;
        r0.setFilePath(r1, (String[]) r2);
        this.b.setTopAccessKey(this.d);
        this.b.setTopSecretKey(this.e);
        this.b.setTopSessionToken(this.f);
        this.b.setSpaceName(this.g);
        BDImageUploader r3 = this.b;
        dj1 r4 = dj1.a;
        r3.setUploadDomain(((ri1) r4.getValue()).a());
        this.b.setSliceSize(((ri1) r4.getValue()).b());
        this.b.setMaxConcurrentFileNum(this.c.size());
        TreeMap r6 = new TreeMap();
        r6.put("policy-set", "check,thumb,medium,large");
        this.b.setPolicyParams(r6);
        this.b.setObjectType("image");
        if (Intrinsics.areEqual(this.h, Boolean.TRUE) == false) goto L7;
        this.b.setConfig(new TreeMap(MapsKt.mapOf(TuplesKt.to("copies", "both"))));
        BDImageUploader r7 = this.b;
        int r8 = k.a;
        r7.setProcessActionType(1);
    L7:
        BDImageUploader r9 = this.b;
        k r10 = this.a;
        int r11 = this.c.size();
        CallContext r13 = this.i;
        r10.getClass();
        r9.setListener(new l(r5, r9, r11, r13));
        this.b.start();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
