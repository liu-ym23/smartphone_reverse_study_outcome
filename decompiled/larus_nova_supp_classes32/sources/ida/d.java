package ida;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.cocreationreview.s3;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public static void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "recordId");
        if ((!StringsKt.isBlank(r5)) == true) goto L6;
        r5 = null;
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        Context r0 = AppHost.a.getApplication().getApplicationContext();
        Intent r1 = new Intent();
        r1.setClassName("com.obric.recorder", "com.bytedanceos.recorder.activity.RecorderPlayActivity");
        r1.putExtra("RECORD_URI", r5);
        r1.setFlags(268468224);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        r0.startActivity(r1);     // Catch: Throwable -> L11
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (Result.isSuccess-impl(r3) == false) goto L16;
        Unit r4 = (Unit) r3;
        int r6 = s3.a;
        s3.b("audio_memory_original_record", "open recordId=".concat(r5));
    L16:
        Throwable r7 = Result.exceptionOrNull-impl(r3);
        if (r7 == null) goto L22;
        int r8 = s3.a;
        s3.c("audio_memory_original_record", "open failed recordId=" + r5 + " error=" + r7.getMessage());
        Toast.makeText(r0, "原始录音暂不可用", 0).show();
        return;
    L22:
        return;
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
