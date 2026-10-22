package po;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnectionWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21376a = 0;

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.getKeyCode() != 67) goto L6;
        r5.getAction();
    L6:
        return super.sendKeyEvent(r5);
    }
}
