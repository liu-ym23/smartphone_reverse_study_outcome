package sx8;

import com.larus.camera.api.params.InputParam;
import com.larus.camera.impl.ui.activity.CameraCaptureActivity;
import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ CameraCaptureActivity a;

    public /* synthetic */ a(CameraCaptureActivity r1) {
        this.a = r1;
    }

    public final Object invoke() {
        CameraCaptureActivity r0 = this.a;
        int r1 = CameraCaptureActivity.d;
        Serializable r2 = r0.getIntent().getSerializableExtra("CAMERA_INPUT_PARAM");
        if ((r2 instanceof InputParam) == true) goto L7;
        return null;
    L7:
        return (InputParam) r2;
    }
}
