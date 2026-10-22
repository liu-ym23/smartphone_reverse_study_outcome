package oa2;

import android.net.Uri;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.ui.ChatCarnivalView;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements ObservableOnSubscribe {
    public final /* synthetic */ ChatCarnivalView a;

    public a(ChatCarnivalView r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<Uri> r2) {
        Intrinsics.checkNotNullParameter(r2, "emitter");
        ArrayList r0 = com.bytedance.android.livesdk.gecko.offline.f.a;
        File r1 = com.bytedance.android.livesdk.gecko.offline.f.a(this.a.r);
        if (r1 == null) goto L5;
        r2.onNext(Uri.fromFile(r1));
    L6:
        r2.onComplete();
        return;
    L5:
        r2.onNext(UriProtector.parse(this.a.r));
        goto L6
    }
}
