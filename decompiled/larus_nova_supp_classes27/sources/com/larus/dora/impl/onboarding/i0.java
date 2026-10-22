package com.larus.dora.impl.onboarding;

import android.text.TextUtils;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.impl.util.DoraVideoType;
import com.larus.dora.impl.view.DoraMovieView;
import java.io.File;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i0 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraVideoType.values().length];
            r0[DoraVideoType.DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[DoraVideoType.DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX_TIMEOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[DoraVideoType.DORA_G_VIDEO_ONBOARDING_WELCOME_1.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[DoraVideoType.DORA_G_VIDEO_ONBOARDING_TAKE_PHOTO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[DoraVideoType.DORA_G_VIDEO_ONBOARDING_TAKE_PHOTO_LOOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[DoraVideoType.DORA_G_VIDEO_ONBOARDING_VIDEO_CALL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[DoraVideoType.DORA_G_VIDEO_ONBOARDING_VIDEO_CALL_LOOP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[DoraVideoType.DORA_G_VIDEO_ONBOARDING_MEDIA_CONTROL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[DoraVideoType.DORA_G_VIDEO_ONBOARDING_FINISH.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    public static final String a(DoraVideoType r3) {
        switch(a.a[r3.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        Pair r4 = TuplesKt.to(DoraResourceDeviceType.G1, "larus_dora_g_onboarding_finish");
    L14:
        com.larus.dora.impl.util.u r1 = com.larus.dora.impl.util.u.a;
        DoraResourceDeviceType r2 = (DoraResourceDeviceType) r4.getFirst();
        String r5 = (String) r4.getSecond();
        r1.getClass();
        File r6 = com.larus.dora.impl.util.u.f(r2, r5);
        if (r6 == null) goto L17;
        String r7 = r6.getAbsolutePath();
    L18:
        if (r7 != null) goto L21;
        return "";
    L21:
        return r7;
    L17:
        r7 = null;
        goto L18
    L6:
        r4 = TuplesKt.to(DoraResourceDeviceType.G1, "larus_dora_g_onboarding_media_control");
        goto L14
    L7:
        r4 = TuplesKt.to(DoraResourceDeviceType.G1, "larus_dora_g_onboarding_video_call_loop");
        goto L14
    L8:
        r4 = TuplesKt.to(DoraResourceDeviceType.G1, "larus_dora_g_onboarding_video_call");
        goto L14
    L9:
        r4 = TuplesKt.to(DoraResourceDeviceType.G1, "larus_dora_g_onboarding_take_photo_loop");
        goto L14
    L10:
        r4 = TuplesKt.to(DoraResourceDeviceType.G1, "larus_dora_g_onboarding_take_photo");
        goto L14
    L11:
        r4 = TuplesKt.to(DoraResourceDeviceType.G1, "larus_dora_g_onboarding_welcome_1");
        goto L14
    L12:
        r4 = TuplesKt.to(DoraResourceDeviceType.G_SERIES, "larus_dora_g_onboarding_unboxing_timeout");
        goto L14
    L13:
        r4 = TuplesKt.to(DoraResourceDeviceType.G_SERIES, "larus_dora_g_onboarding_unboxing");
        goto L14
    }

    public static final void b(DoraMovieView r2, DoraVideoType r3, int r4, DoraSKU r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "videoType");
        Intrinsics.checkNotNullParameter(r5, "doraSku");
        String r6 = com.larus.dora.impl.util.d0.a(r3, r5);
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r6 = a(r3);
    L8:
        g49.d.a("DoraOnboarding", "setVideoResource " + r3 + ", filePath=" + r6);
        if (TextUtils.isEmpty(r6) == false) goto L11;
        r2.setVideoResourceIdOnly(r4);
        return;
    L11:
        r2.setVideoResourcePathOnly(r6);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void c(DoraMovieView r4, DoraVideoType r5, int r6, DoraSKU r7) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "videoType");
        Intrinsics.checkNotNullParameter(r7, "doraSku");
        String r8 = com.larus.dora.impl.util.d0.a(r5, r7);
        boolean r1 = true;
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r8 = a(r5);
    L8:
        StringBuilder r2 = new StringBuilder("setVideoSource ");
        r2.append(r5);
        r2.append(", filePath=");
        r2.append(r8);
        r2.append(", isVideoEngineInit = ");
        if (r4.a == null) goto L11;
        boolean r9 = true;
    L12:
        r2.append(r9);
        g49.d.a("DoraOnboarding", r2.toString());
        if (r4.a != null) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L22;
        if (TextUtils.isEmpty(r8) == false) goto L20;
        r4.setDataSource(r6);
        return;
    L20:
        r4.setDataSource(r8);
        return;
    L22:
        if (TextUtils.isEmpty(r8) == false) goto L24;
        r4.setVideoResourceIdOnly(r6);
        return;
    L24:
        r4.setVideoResourcePathOnly(r8);
        return;
    L11:
        r9 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }
}
