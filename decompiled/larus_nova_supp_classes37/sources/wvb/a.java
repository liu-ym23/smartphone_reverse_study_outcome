package wvb;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.CloseReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final void a(uub.a r2, FragmentActivity r3, CloseReason r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (r2 != null) goto L9;
        if (r3 == null) goto L6;
        r3.finish();
    L6:
        lvb.a.e("MmRecordPageRouter", "[closePageOnErrorOrNativeFallback] navigator is null, finish activity, reason=" + r4);
        return;
    L9:
        if (r4.unexpectedError() == false) goto L16;
        boolean r5 = r2.n0();
        if (r5 == true) goto L14;
        if (r3 == null) goto L14;
        r3.finish();
    L14:
        lvb.a.e("MmRecordPageRouter", "[closePageOnErrorOrNativeFallback] unexpectedError, closeApplet=" + r5 + ", reason=" + r4);
        return;
    L16:
        lvb.a.e("MmRecordPageRouter", "[closePageOnErrorOrNativeFallback] skip normal close, reason=" + r4);
    }
}
