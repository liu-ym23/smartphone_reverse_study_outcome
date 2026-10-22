package com.larus.xbridge.impl.choosemedia.features;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.StatFs;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.jsbridge.LynxResourceModule;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k implements j4a.i {
    public final Function3<FragmentActivity, Intent, Integer, Unit> a;
    public final WeakReference<Activity> b;
    public final j4a.f c;
    public boolean d;
    public String e;

    public k(WeakReference r2, h4a.d r3, i4a.a r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "onFileSelected");
        this.a = r4;
        this.b = r2;
        this.c = r3;
    }

    @Override // j4a.i
    public final boolean onActivityResult(int r5, int r6, Intent r7) {
        if (r5 != 1311211) goto L31;
        if (r6 != 0) goto L8;
        this.c.onFailed(-7, "Failed to capture video");
        return true;
    L8:
        if (this.b.get() != null) goto L11;
        this.c.onFailed(0, "Activity obtained a null");
        return true;
    L11:
        StatFs r8 = null;
        if (r7 == null) goto L14;
        Uri r9 = r7.getData();
    L15:
        if (r9 != null) goto L17;
    L30:
        this.c.onFailed(0, "Video doesn't exist");
        goto L31
    L17:
        if (StringUtils.isEmpty(r9.toString()) == true) goto L30;
        String r10 = this.e;
        if (r10 != null) goto L32;
        r10 = r9.toString();
    L32:
        r8 = new StatFs(new PolarisFileWrapper(r10).getAbsolutePath());     // Catch: IllegalArgumentException -> L25
    L26:
        if (r8 == null) goto L28;
        long r2 = r8.getAvailableBytes();
    L29:
        List r11 = CollectionsKt.listOf(new hx7.k.a(r10, r2, LynxResourceModule.VIDEO_TYPE));
        j4a.f r12 = this.c;
        hx7.k r13 = new hx7.k();
        r13.a = r11;
        r12.a(r13);
        goto L31
    L28:
        r2 = 0;
        goto L29
    L14:
        r9 = null;
    L31:
        return true;
    }
}
