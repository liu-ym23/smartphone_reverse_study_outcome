package com.larus.bmhome.utils;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.bigimg.AwemeImageFilter;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService$a;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.b;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p1 {
    public static final Lazy a = null;

    public p1() {
    }

    static {
        a = LazyKt.lazy(new l1());
    }

    public static void a(FragmentActivity r33, String r34, boolean r35, com.larus.bmhome.share.panel.h r36, by7.e r37, Function1 r38, boolean r39) {
        if (r35 == false) goto L4;
        IShareService$a.g(ShareServiceDelegate.b, r33, ShareScene.IMAGE_VIEWER, new b(r34, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r39, false, null, null, false, false, null, false, null, null, 67043326), r36, null, r37, false, 208);
        return;
    L4:
        ImageSave.x(ImageSave.a, r34, null, null, r38, r39, 22);
    }

    public static void b(final boolean r11, SearchImageInfo r12, final Context r13, com.larus.bmhome.share.panel.h r14, by7.e r15, Function1 r16, int r17) {
        if ((r17 & 8) == 0) goto L5;
        final com.larus.bmhome.share.panel.h r5 = null;
    L7:
        if ((r17 & 16) == 0) goto L9;
        final by7.e r6 = null;
    L11:
        if ((r17 & 32) == 0) goto L13;
        final Function1 r7 = null;
    L14:
        Intrinsics.checkNotNullParameter(r12, "imgItem");
        Intrinsics.checkNotNullParameter(r13, "context");
        Integer r0 = r12.getSourceFrom();
        int r2 = SourceFrom.DouYin.value;
        if (r0 != null) goto L18;
    L19:
        List r1 = r12.getFullSizeUrl();
        if (r1 == null) goto L23;
        String r3 = (String) CollectionsKt.firstOrNull(r1);
        if (r3 == null) goto L23;
    L24:
        c(r11, r3, r13, r5, r6, r7, false, 64);
        return;
    L23:
        r3 = r12.getThumbUrl();
        goto L24
    L18:
        if (r0.intValue() != r2) goto L19;
        AwemeImageFilter r4 = (AwemeImageFilter) a.getValue();
        String r8 = r12.getItemId();
        String r9 = r12.getUri();
        if (r9 != null) goto L28;
        r9 = "";
    L28:
        r4.a(r8, r9, r12.getAuthorShortId(), new n1(r11, r13, r5, r6, r7), new o1());
        return;
    L13:
        r7 = r16;
        goto L14
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public static void c(final boolean r13, final String r14, Context r15, com.larus.bmhome.share.panel.h r16, by7.e r17, Function1 r18, boolean r19, int r20) {
        FragmentActivity r2 = null;
        if ((r20 & 8) == 0) goto L5;
        com.larus.bmhome.share.panel.h r1 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        final by7.e r8 = null;
    L11:
        if ((r20 & 32) == 0) goto L13;
        final Function1 r9 = null;
    L14:
        boolean r4 = false;
        if ((r20 & 64) == 0) goto L17;
        final boolean r10 = false;
    L18:
        Intrinsics.checkNotNullParameter(r15, "context");
        if (r14 != null) goto L21;
    L22:
        r4 = true;
    L24:
        if (r4 == false) goto L27;
        FLogger.a.e("ImageDownloadOrShareUtils", "no url");
        return;
    L27:
        if ((r15 instanceof FragmentActivity) == false) goto L29;
        r2 = (FragmentActivity) r15;
    L29:
        if (r2 != null) goto L32;
        FLogger.a.e("ImageDownloadOrShareUtils", "no activity");
        return;
    L32:
        if (Build.VERSION.SDK_INT <= 29) goto L34;
    L36:
        a(r2, r14, r13, r1, r8, r9, r10);
        return;
    L34:
        if (ContextCompat.checkSelfPermission(r2, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L36;
        final FragmentActivity r5 = r2;
        final com.larus.bmhome.share.panel.h r7 = r1;
        i2.b.a(r2, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new m1(r5, r14, r13, r7, r8, r9, r10));
        return;
    L21:
        if (r14.length() != 0) goto L24;
    L17:
        r10 = r19;
        goto L18
    L13:
        r9 = r18;
        goto L14
    L9:
        r8 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
