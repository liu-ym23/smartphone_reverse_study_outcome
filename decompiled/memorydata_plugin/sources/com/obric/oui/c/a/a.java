package com.obric.oui.c.a;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/utils/log/AndroidLogger;", "Lcom/obric/oui/utils/log/L$Logger;", "baseTag", "", "printThreadName", "", "(Ljava/lang/String;Z)V", "writeLog", "", LocationMonitorConst.TAG, "level", "", NotificationCompat.CATEGORY_MESSAGE, "e", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13399b;

    public a(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "baseTag");
        this.f13398a = r2;
        this.f13399b = r3;
    }

    public /* synthetic */ a(String r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    @Override // com.obric.oui.c.a.b.a
    public void a(String r3, int r4, String r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_MESSAGE);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        r5 = r3 + "-->" + r5;
    L13:
        if (this.f13399b == false) goto L15;
        r5 = '[' + Thread.currentThread().getName() + "]|" + r5;
    L15:
        if (r4 != 1) goto L17;
        Log.v(this.f13398a, r5);
        return;
    L17:
        if (r4 != 2) goto L19;
        Log.d(this.f13398a, r5);
        return;
    L19:
        if (r4 != 4) goto L21;
        Log.i(this.f13398a, r5);
        return;
    L21:
        if (r4 != 8) goto L23;
        String r2 = this.f13398a;
        if (r6 != null) goto L32;
        Log.w(r2, r5);
        return;
    L32:
        Log.w(r2, r5, r6);
        return;
    L23:
        if (r4 != 16) goto L43;
        String r7 = this.f13398a;
        if (r6 != null) goto L28;
        Log.e(r7, r5);
        return;
    L28:
        Log.e(r7, r5, r6);
        return;
    L43:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
