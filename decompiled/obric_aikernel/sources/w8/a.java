package w8;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13414b;

    @JvmOverloads
    public a(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "baseTag");
        this.f13413a = r10;
        this.f13414b = r11;
    }

    @Override // w8.g.a
    public void a(String r10, int r11, String r12, Throwable r13) {
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_MESSAGE);
        if (r10 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == true) goto L13;
        r12 = r10 + "-->" + r12;
    L13:
        if (this.f13414b == false) goto L15;
        StringBuilder r15 = new StringBuilder();
        r15.append('[');
        Thread r16 = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(r16, "Thread.currentThread()");
        r15.append(r16.getName());
        r15.append("]|");
        r15.append(r12);
        r12 = r15.toString();
    L15:
        if (r11 != 1) goto L17;
        Log.v(this.f13413a, r12);
        return;
    L17:
        if (r11 != 2) goto L19;
        Log.d(this.f13413a, r12);
        return;
    L19:
        if (r11 != 4) goto L21;
        Log.i(this.f13413a, r12);
        return;
    L21:
        if (r11 != 8) goto L23;
        String r17 = this.f13413a;
        if (r13 != null) goto L32;
        Log.w(r17, r12);
        return;
    L32:
        Log.w(r17, r12, r13);
        return;
    L23:
        if (r11 != 16) goto L43;
        String r18 = this.f13413a;
        if (r13 != null) goto L28;
        Log.e(r18, r12);
        return;
    L28:
        Log.e(r18, r12, r13);
        return;
    L43:
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r14 = false;
        goto L9
    }
}
