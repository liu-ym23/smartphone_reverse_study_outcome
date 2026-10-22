package com.obric.oui.c.a;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001&B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J(\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086\bø\u0001\u0000J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\"\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J(\u0010\u0016\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086\bø\u0001\u0000J\b\u0010\u0018\u001a\u00020\u0012H\u0007J\u0006\u0010\u0019\u001a\u00020\u000eJ\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J(\u0010\u001a\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086\bø\u0001\u0000J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J\u001e\u0010\u001e\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007J8\u0010\u001f\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0017H\u0086\bø\u0001\u0000J8\u0010!\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\"\u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J(\u0010$\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086\bø\u0001\u0000J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\"\u0010%\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010%\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J(\u0010%\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086\bø\u0001\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"Lcom/obric/oui/utils/log/L;", "", "()V", "ABOVE_VERBOSE", "", "BASE_TAG", "", com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b, ExifInterface.LONGITUDE_EAST, "I", "JSON_INDENT", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "androidLogger", "Lcom/obric/oui/utils/log/L$Logger;", "impl", "logLevelMask", "d", "", NotificationCompat.CATEGORY_MESSAGE, LocationMonitorConst.TAG, "Lkotlin/Function0;", "e", "", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "getImpl", "i", "isBlocked", "", "level", "json", "log", "t", "log0", "splitLines", "setImpl", BaseSwitches.V, "w", "Logger", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f13401b;
    private static final a c = null;
    private static int d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J.\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/obric/oui/utils/log/L$Logger;", "", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "", "writeLog", LocationMonitorConst.TAG, "", "level", "", NotificationCompat.CATEGORY_MESSAGE, "e", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
        void a(String r1, int r2, String r3, Throwable r4);
    }

    static {
        f13400a = new b();
        c = (a) ZeusTransformUtils.preCheckCast(new com.obric.oui.c.a.a("OUI_SDK", false, 2, null), a.class, "com.obric.memorydata.plugin");
        d = 31;
    }

    private b() {
    }

    static /* synthetic */ void a(b r6, String r7, int r8, String r9, Throwable r10, boolean r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        Throwable r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = false;
    L8:
        r6.a(r7, r8, r9, r4, r11);
    }

    private final void a(String r7, int r8, String r9, Throwable r10, boolean r11) {
        if (a(r8) == false) goto L5;
        return;
    L5:
        if (r11 == true) goto L7;
        a().a(r7, r8, r9, r10);
        return;
    L7:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"\n"}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        f13400a.a().a(r7, r8, r12, null);
        goto L9
    }

    @JvmStatic
    public static final void a(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        a(f13400a, r9, 1, r10, null, false, 24, null);
    }

    @JvmStatic
    public static final void a(String r9, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r9, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        a(f13400a, r9, 16, r10, r11, false, 16, null);
    }

    @JvmStatic
    public static final void b(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        a(f13400a, r9, 2, r10, null, false, 24, null);
    }

    @JvmStatic
    public static final void c(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        a(f13400a, r9, 4, r10, null, false, 24, null);
    }

    @JvmStatic
    public static final void d(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        a(f13400a, r9, 8, r10, null, false, 24, null);
    }

    @JvmStatic
    public static final void e(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        a(f13400a, r9, 16, r10, null, false, 24, null);
    }

    public final a a() {
        a r0 = f13401b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return c;
    }

    public final boolean a(int r1) {
        if ((d & r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
