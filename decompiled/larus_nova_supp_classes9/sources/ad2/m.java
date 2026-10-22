package ad2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.bduploader.BDVideoInfo;
import com.ss.bduploader.BDVideoUploader;
import com.ss.bduploader.BDVideoUploaderListener;
import io.reactivex.SingleEmitter;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements BDVideoUploaderListener {
    public final /* synthetic */ BDVideoUploader a;
    public final /* synthetic */ SingleEmitter b;
    public final /* synthetic */ CallContext c;

    public final String getStringFromExtern(int r1) {
        return null;
    }

    public final void onLog(int r1, int r2, String r3) {
    }

    public final int videoUploadCheckNetState(int r1, int r2) {
        return r1;
    }

    public final void onUploadVideoStage(int r3, long r4) {
        ALogger.d("UploadHelperV2", "stage: " + r3 + ", timestamp: " + r4);
    }

    public m(BDVideoUploader r1, SingleEmitter r2, CallContext r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onNotify(int r4, long r5, BDVideoInfo r7) {
        if (r4 == 0) goto L20;
        Long r6 = null;
        String r8 = null;
        if (r4 != 1) goto L6;
        CallContext r9 = this.c;
        JSONObject r10 = new JSONObject();
        if (r7 == null) goto L19;
        r6 = Long.valueOf(r7.mProgress);
    L19:
        r10.put("progress", r6);
        Unit r11 = Unit.INSTANCE;
        r9.b("subscribe.upload.progress", r10);
        return;
    L6:
        if (r4 != 2) goto L27;
        this.a.close();
        SingleEmitter r13 = this.b;
        StringBuilder r0 = new StringBuilder("BDUpload failed,");
        if (r7 == null) goto L11;
        Long r1 = Long.valueOf(r7.mErrorCode);
    L12:
        r0.append(r1);
        r0.append(", ");
        if (r7 == null) goto L15;
        r8 = r7.mErrorMsg;
    L15:
        r0.append(r8);
        r13.onError(new Throwable(r0.toString()));
        return;
    L11:
        r1 = null;
        goto L12
    L27:
        return;
    L20:
        if (r7 != null) goto L23;
        this.a.close();
        this.b.onError(new Throwable("Complete with empty result"));
        return;
    L23:
        this.b.onSuccess(new com.bytedance.android.livesdk.jsbridge.methods.upload.models.e(r7.mVideoId, r7.mVideoMediaInfo, r7.mEncryptionMeta));
        this.a.close();
    }
}
