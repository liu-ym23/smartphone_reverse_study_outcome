package h4a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.api.g3;
import com.larus.platform.service.i2;
import com.larus.platform.service.k2;
import com.larus.xbridge.impl.choosemedia.BDXFileSelectionMethodHelper;
import com.larus.xbridge.impl.choosemedia.features.BDXPickPhotosAndVideosFeature;
import com.larus.xbridge.impl.choosemedia.features.BDXPickVideosFeature;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements hx7.c {
    public e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21, types: [android.os.AsyncTask, com.larus.xbridge.impl.choosemedia.features.h$c] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.larus.xbridge.impl.choosemedia.features.i] */
    public final void a(Context r17, final hx7.j r18, tx7.d.a r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r19, "callback");
        j4a.g r4 = j4a.g.a;
        Activity r0 = r4.getActivity(r17);
        final d r6 = new d(r0, r19, new WeakReference(r0));
        Intrinsics.checkNotNullParameter(r18, LynxResourceModule.PARAMS_KEY);
        ug9.b r1 = r4.getActivity(r6.a);
        boolean r5 = false;
        if ((r1 instanceof ug9.b) == false) goto L6;
        r1.I0(r6);
        i4a.a r2 = 0;
    L8:
        WeakReference r7 = new WeakReference(r1);
        List r3 = r18.a;
        String r8 = r18.b;
        BDXFileSelectionMethodHelper.FeatureType.Companion.getClass();
        Intrinsics.checkNotNullParameter(r8, "sourceType");
        List r9 = r3;
        if (r9 != null) goto L11;
    L14:
        boolean r10 = true;
    L15:
        if (r10 == false) goto L18;
        BDXFileSelectionMethodHelper.FeatureType r11 = BDXFileSelectionMethodHelper.FeatureType.UNSUPPORTED;
    L73:
        if (r11 != BDXFileSelectionMethodHelper.FeatureType.UNSUPPORTED) goto L75;
        r6.onFailed(-3, "Invalid fileType and sourceType in params");
        return;
    L75:
        int r12 = BDXFileSelectionMethodHelper.b.a[r11.ordinal()];
        if (r12 != 1) goto L78;
        final BDXPickVideosFeature r13 = new BDXPickVideosFeature(r7, r6, r2);
        r6.b = r13;
        Intrinsics.checkNotNullParameter(r18, LynxResourceModule.PARAMS_KEY);
        FragmentActivity r14 = r13.b.get();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.app.Activity");
        final FragmentActivity r15 = (Activity) r14;
        if ((r15 instanceof FragmentActivity) == false) goto L195;
        k2 r16 = k2.a;
        g3.a.b(r15, new com.larus.xbridge.impl.choosemedia.features.f(r13, r15));
        return;
    L195:
        return;
    L78:
        if (r12 != 2) goto L80;
        final com.larus.xbridge.impl.choosemedia.features.k r20 = new com.larus.xbridge.impl.choosemedia.features.k(r7, r6, r2);
        r6.b = r20;
        Intrinsics.checkNotNullParameter(r18, LynxResourceModule.PARAMS_KEY);
        r20.d = Intrinsics.areEqual(r18.e, Boolean.TRUE);
        final ?? r21 = new com.larus.xbridge.impl.choosemedia.features.i(r20, r18);
        FragmentActivity r22 = (Activity) r20.b.get();
        if (r22 != null) goto L151;
        return;
    L151:
        if (r20.d == false) goto L158;
        if (ContextCompat.checkSelfPermission(r22, "android.permission.CAMERA") != 0) goto L158;
        if (ContextCompat.checkSelfPermission(r22, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L158;
        r21.invoke();
        return;
    L158:
        if (r20.d == false) goto L160;
    L162:
        List r23 = CollectionsKt.mutableListOf(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"});
        if ((r22 instanceof FragmentActivity) == false) goto L194;
        i2.b.a(r22, r23, new com.larus.xbridge.impl.choosemedia.features.j(r21, r20));
        return;
    L194:
        return;
    L160:
        if (ContextCompat.checkSelfPermission(r22.getApplication(), "android.permission.CAMERA") != 0) goto L162;
        r21.invoke();
        return;
    L80:
        if (r12 != 3) goto L82;
        final com.larus.xbridge.impl.choosemedia.features.h r24 = new com.larus.xbridge.impl.choosemedia.features.h(r7, r6, r2);
        r6.b = r24;
        Intrinsics.checkNotNullParameter(r18, LynxResourceModule.PARAMS_KEY);
        final FragmentActivity r25 = (Activity) r24.b.get();
        if (r25 != null) goto L112;
        r24.c.onFailed(0, "Activity not found");
        return;
    L112:
        if (r25.getPackageManager().hasSystemFeature("android.hardware.camera.any") == true) goto L115;
        r24.c.onFailed(0, "Camera feature not found");
        return;
    L115:
        if (new Intent("android.media.action.IMAGE_CAPTURE").resolveActivity(r25.getPackageManager()) != null) goto L117;
        r24.c.onFailed(0, "Camera app not found");
        return;
    L117:
        r24.i = r18.f;
        Boolean r26 = r18.d;
        Boolean r27 = Boolean.TRUE;
        if (Intrinsics.areEqual(r26, r27) == false) goto L120;
    L123:
        boolean r28 = true;
    L124:
        r24.j = r28;
        r24.k = r18.g;
        r24.l = Intrinsics.areEqual(r18.e, r27);
        if (ContextCompat.checkSelfPermission(r25, "android.permission.CAMERA") != 0) goto L127;
        boolean r29 = true;
    L129:
        if (r24.l == false) goto L135;
        if (r29 == true) goto L132;
    L134:
        r29 = false;
        goto L135
    L132:
        if (ContextCompat.checkSelfPermission(r25, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L134;
        r29 = true;
    L135:
        if (r29 == false) goto L141;
        PthreadAsyncTask r30 = r24.h;
        if (r30 == null) goto L139;
        r30.cancel(false);
    L139:
        ?? r31 = new com.larus.xbridge.impl.choosemedia.features.h.c(r25, r24, r24.a);
        r31.executeOnExecutor(r24.d, new Unit[0]);
        r24.h = r31;
        return;
    L141:
        if (r24.l == false) goto L143;
        ArrayList r32 = CollectionsKt.arrayListOf(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"});
    L145:
        if ((r25 instanceof FragmentActivity) == false) goto L193;
        i2.b.a(r25, r32, new com.larus.xbridge.impl.choosemedia.features.g(r24, r25));
        return;
    L193:
        return;
    L143:
        r32 = CollectionsKt.arrayListOf(new String[]{"android.permission.CAMERA"});
        goto L145
    L127:
        r29 = false;
        goto L129
    L120:
        if (r18.g == true) goto L123;
        r28 = false;
        goto L124
    L82:
        if (r12 != 4) goto L84;
        final com.larus.xbridge.impl.choosemedia.features.e r33 = new com.larus.xbridge.impl.choosemedia.features.e(r7, r6, r2);
        r6.b = r33;
        Intrinsics.checkNotNullParameter(r18, LynxResourceModule.PARAMS_KEY);
        r33.d = r18.c;
        Boolean r34 = r18.d;
        Boolean r35 = Boolean.TRUE;
        if (Intrinsics.areEqual(r34, r35) == false) goto L93;
    L96:
        boolean r36 = true;
    L97:
        r33.e = r36;
        if (r33.d <= 1) goto L100;
        boolean r37 = true;
    L101:
        if (r37 == true) goto L104;
        r5 = r18.g;
    L104:
        r33.f = r5;
        Intrinsics.areEqual(r18.e, r35);
        r33.g = -1;
        FragmentActivity r38 = r33.b.get();
        Intrinsics.checkNotNull(r38, "null cannot be cast to non-null type android.app.Activity");
        final FragmentActivity r39 = (Activity) r38;
        if ((r39 instanceof FragmentActivity) == false) goto L192;
        k2 r40 = k2.a;
        g3.a.a(null, r39, false, null, false, new com.larus.xbridge.impl.choosemedia.features.b(r33, r39), 29);
        return;
    L192:
        return;
    L100:
        r37 = false;
        goto L101
    L93:
        if (r18.g == true) goto L96;
        r36 = false;
        goto L97
    L84:
        if (r12 != 5) goto L190;
        final BDXPickPhotosAndVideosFeature r41 = new BDXPickPhotosAndVideosFeature(r7, r6, r2);
        r6.b = r41;
        Intrinsics.checkNotNullParameter(r18, LynxResourceModule.PARAMS_KEY);
        r41.d = r18.g;
        FragmentActivity r42 = r41.b.get();
        Intrinsics.checkNotNull(r42, "null cannot be cast to non-null type android.app.Activity");
        final FragmentActivity r43 = (Activity) r42;
        if ((r43 instanceof FragmentActivity) == false) goto L191;
        k2 r44 = k2.a;
        g3.a.b(r43, new com.larus.xbridge.impl.choosemedia.features.a(r41, r43));
        return;
    L191:
        return;
    L190:
        return;
    L18:
        if (r3.size() <= 1) goto L48;
        List r45 = r3;
        boolean r110 = r45 instanceof Collection;
        if (r110 == true) goto L22;
    L24:
        Iterator r111 = r45.iterator();
    L26:
        if (r111.hasNext() == false) goto L31;
        if (Intrinsics.areEqual(((String) r111.next()).toLowerCase(Locale.getDefault()), "image") == false) goto L26;
        boolean r46 = true;
    L32:
        if (r46 == false) goto L48;
        if (r110 == true) goto L35;
    L37:
        Iterator r47 = r45.iterator();
    L39:
        if (r47.hasNext() == false) goto L43;
        if (Intrinsics.areEqual(((String) r47.next()).toLowerCase(Locale.getDefault()), LynxResourceModule.VIDEO_TYPE) == false) goto L39;
        boolean r48 = true;
    L44:
        if (r48 == false) goto L48;
        if (Intrinsics.areEqual(r8.toLowerCase(Locale.getDefault()), "album") == false) goto L48;
        r11 = BDXFileSelectionMethodHelper.FeatureType.PICK_PHOTO_AND_VIDEO_FROM_ALBUM;
    L43:
        r48 = false;
        goto L44
    L35:
        if (r45.isEmpty() == false) goto L37;
    L31:
        r46 = false;
        goto L32
    L22:
        if (r45.isEmpty() == false) goto L24;
    L48:
        String r49 = (String) ListProtector.get(r3, 0);
        if (r49 != null) goto L51;
        r11 = BDXFileSelectionMethodHelper.FeatureType.UNSUPPORTED;
        goto L73
    L51:
        if (Intrinsics.areEqual(r49.toLowerCase(Locale.getDefault()), "image") == false) goto L56;
        if (Intrinsics.areEqual(r8.toLowerCase(Locale.getDefault()), "camera") == false) goto L56;
        r11 = BDXFileSelectionMethodHelper.FeatureType.TAKE_PHOTO;
    L56:
        if (Intrinsics.areEqual(r49.toLowerCase(Locale.getDefault()), "image") == false) goto L61;
        if (Intrinsics.areEqual(r8.toLowerCase(Locale.getDefault()), "album") == false) goto L61;
        r11 = BDXFileSelectionMethodHelper.FeatureType.PICK_PHOTO_FROM_ALBUM;
    L61:
        if (Intrinsics.areEqual(r49.toLowerCase(Locale.getDefault()), LynxResourceModule.VIDEO_TYPE) == false) goto L66;
        if (Intrinsics.areEqual(r8.toLowerCase(Locale.getDefault()), "camera") == false) goto L66;
        r11 = BDXFileSelectionMethodHelper.FeatureType.TAKE_VIDEO;
    L66:
        if (Intrinsics.areEqual(r49.toLowerCase(Locale.getDefault()), LynxResourceModule.VIDEO_TYPE) == true) goto L68;
    L70:
        r11 = BDXFileSelectionMethodHelper.FeatureType.UNSUPPORTED;
        goto L73
    L68:
        if (Intrinsics.areEqual(r8.toLowerCase(Locale.getDefault()), "album") == false) goto L70;
        r11 = BDXFileSelectionMethodHelper.FeatureType.PICK_VIDEO_FROM_ALBUM;
        goto L73
    L11:
        if (r9.isEmpty() == true) goto L14;
        r10 = false;
        goto L15
    L6:
        if ((r1 instanceof FragmentActivity) == false) goto L170;
        r2 = new i4a.a(r6);
        goto L8
    L170:
        r6.onFailed(0, "Failed to find proper activity");
    }
}
