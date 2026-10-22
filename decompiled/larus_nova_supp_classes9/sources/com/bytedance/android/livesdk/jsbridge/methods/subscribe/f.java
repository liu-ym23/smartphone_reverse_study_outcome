package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.Base64;
import com.bytedance.android.live.browser.jsbridge.base.SelectMediaResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.SimpleMediaInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.functions.Function;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w20.wd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T, R> implements Function {
    public final /* synthetic */ wd a;

    public f(wd r1) {
        this.a = r1;
    }

    public final Object apply(Object r13) {
        List r14 = (List) r13;
        Intrinsics.checkNotNullParameter(r14, "it");
        int r0 = d.a;
        boolean r1 = Intrinsics.areEqual(this.a.h(), Boolean.TRUE);
        Intrinsics.checkNotNullParameter(r14, "originList");
        ArrayList r2 = new ArrayList();
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L43;
        SimpleMediaInfo r3 = (SimpleMediaInfo) r15.next();
        SelectMediaResultModel.b r4 = new SelectMediaResultModel.b();
        r3.getClass();
        r4.c();
        r4.f(r3.a);
        String r5 = r3.h;
        boolean r6 = false;
        if (r5 == null) goto L12;
        String r7 = r5.toLowerCase(Locale.getDefault());
        if (r7 == null) goto L12;
        if (StringsKt.contains$default(r7, "video", false, 2, null) != true) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        String r9 = "video";
    L16:
        r4.h(r9);
        r4.d(r3.e);
        r4.e(Long.valueOf(r3.f));
        r4.g(Integer.valueOf(r3.c));
        r4.j(Integer.valueOf(r3.d));
        String r10 = r3.h;
        if (r10 == null) goto L23;
        String r11 = r10.toLowerCase(Locale.getDefault());
        if (r11 == null) goto L23;
        if (StringsKt.contains$default(r11, "video", false, 2, null) != true) goto L23;
        r6 = true;
    L23:
        if (r6 == false) goto L26;
        SelectMediaResultModel.c r16 = new SelectMediaResultModel.c();
        r16.b(Long.valueOf(r3.b));
        r4.i(r16);
    L26:
        if (Intrinsics.areEqual(r4.a(), "video") == false) goto L42;
        if (r1 == false) goto L42;
        SelectMediaResultModel.c r17 = r4.b();
        if (r17 == null) goto L42;
        String r18 = r3.a;
        if (r18 != null) goto L44;
    L40:
        String r19 = BuildConfig.FLAVOR;
    L41:
        r17.a(r19);
        goto L42
    L44:
        MediaMetadataRetriever r20 = new MediaMetadataRetriever();     // Catch: Throwable -> L38
        r20.setDataSource(s1.getContext(), UriProtector.parse(r18));     // Catch: Throwable -> L38
        Bitmap r21 = r20.getFrameAtTime(0, 3);     // Catch: Throwable -> L38
        if (r21 == null) goto L40;
        ByteArrayOutputStream r23 = new ByteArrayOutputStream();     // Catch: Throwable -> L38
        r21.compress(Bitmap.CompressFormat.JPEG, 30, r23);     // Catch: Throwable -> L38
        r19 = Base64.encodeToString(r23.toByteArray(), 2);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        ALogger.e("CoverUtils", th);
    L42:
        r2.add(r4);
        goto L4
    L15:
        r9 = "image";
    L12:
        r8 = false;
        goto L13
    L43:
        return r2;
    }
}
