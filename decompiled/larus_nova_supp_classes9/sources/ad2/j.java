package ad2;

import com.ss.bduploader.BDVideoUploader;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements Action {
    public final /* synthetic */ BDVideoUploader a;

    public j(BDVideoUploader r1) {
        this.a = r1;
    }

    public final void run() {
        this.a.stop();
    }
}
