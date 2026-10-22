package p20;

import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements ObservableOnSubscribe {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final void subscribe(ObservableEmitter<e.a> r11) {
        Intrinsics.checkNotNullParameter(r11, "it");
        a(Runtime.getRuntime(), "logcat -c");
        Reader r2 = new InputStreamReader(a(Runtime.getRuntime(), "logcat").getInputStream(), Charsets.UTF_8);
        if ((r2 instanceof BufferedReader) == false) goto L5;
        BufferedReader r3 = (BufferedReader) r2;
    L48:
        Iterator r0 = TextStreamsKt.lineSequence(r3).iterator();     // Catch: Throwable -> L43
    L8:
        if (r0.hasNext() == false) goto L40;
        String r1 = (String) r0.next();     // Catch: Throwable -> L43
        if (StringsKt.contains$default(r1, "JsBridge2: Received call:", false, 2, null) == false) goto L8;
        int r4 = r1.length();     // Catch: Throwable -> L43
        int r5 = 0;
    L12:
        int r6 = -1;
        if (r5 >= r4) goto L21;
        if (r1.charAt(r5) != '{') goto L17;
        boolean r8 = true;
    L18:
        if (r8 == true) goto L22;
        r5 = r5 + 1;     // Catch: Throwable -> L43
    L22:
        int r7 = r1.length() - 1;     // Catch: Throwable -> L43
    L23:
        if (r7 < 0) goto L31;
        if (r1.charAt(r7) != '}') goto L27;
        boolean r9 = true;
    L28:
        if (r9 == true) goto L29;
        r7 = r7 - 1;     // Catch: Throwable -> L43
        goto L23
    L29:
        r6 = r7;
        goto L31
    L27:
        r9 = false;
    L31:
        JSONObject r12 = new JSONObject(r1.substring(r5, r6 + 1));     // Catch: Throwable -> L43
        Object r13 = r12.get("func");     // Catch: Throwable -> L43
        if (r13 == null) goto L39;
        String r14 = (String) r13;     // Catch: Throwable -> L43
        Object r15 = r12.get("params");     // Catch: Throwable -> L43
        if (r15 == null) goto L37;
        r11.onNext(new e.a(r14, r12.optString("__callback_id"), ((JSONObject) r15).toString(), null, 18));     // Catch: Throwable -> L43
        goto L8
    L37:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: Throwable -> L43
    L39:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L43
    L17:
        r8 = false;
        goto L18
    L21:
        r5 = -1;
        goto L22
    L40:
        r11.onComplete();     // Catch: Throwable -> L43
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L43
        CloseableKt.closeFinally(r3, null);
        return;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L5:
        r3 = new BufferedReader(r2, IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        goto L48
    }

    public static Process a(Runtime r12, String r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13};
        f06.b r11 = new f06.b();
        f06.d r14 = r8.b(102900, "java/lang/Runtime", "exec", r12, r9, "java.lang.Process", r11);
        if (r14.a == false) goto L6;
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, null, r11, false);
        return (Process) r14.b;
    L6:
        Process r15 = r12.exec(r13);
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, r15, r11, true);
        return r15;
    }
}
