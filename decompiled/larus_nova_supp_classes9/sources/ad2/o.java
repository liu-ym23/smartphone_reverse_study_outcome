package ad2;

import com.ss.bduploader.BDImageUploader;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements Action {
    public final /* synthetic */ BDImageUploader a;

    public o(BDImageUploader r1) {
        this.a = r1;
    }

    public final void run() {
        this.a.stop();
    }
}
