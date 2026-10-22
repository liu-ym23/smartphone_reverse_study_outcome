package com.larus.drive.sdk.impl.service;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.loader.download.model.drive.DriveImagePreviewResponse;
import com.bytedance.ee.bear.drive.loader.download.model.drive.DriveVideoPreviewResponse;
import com.bytedance.ee.bear.drive.loader.download.platform.api.DriveVideoPreviewException;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k implements e89.d {

    public static final class a {
    }

    public static final class b implements Function1<Throwable, Unit> {
        public final /* synthetic */ h75.a a;

        public b(h75.a r1) {
            this.a = r1;
        }

        public final Object invoke(Object r1) {
            Throwable r2 = (Throwable) r1;
            h75.a r3 = this.a;
            if (r3 == null) goto L6;
            r3.cancel();
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class c implements h75.c {
        public final /* synthetic */ kotlinx.coroutines.i<String> a;

        public c(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void a(DriveImagePreviewResponse r5) {
            Intrinsics.checkNotNullParameter(r5, "info");
            if (this.a.isActive() == true) goto L5;
            return;
        L5:
            String r0 = r5.getUrl();
            FLogger.a.i("DriveGalleryServiceDelegate", "[fetchDriveImagePreviewUrl] Success; info=" + r5);
            this.a.resumeWith(Result.constructor-impl(r0));
        }

        public final void b(Throwable r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "e");
            Intrinsics.checkNotNullParameter(r5, "url");
            if (this.a.isActive() == true) goto L5;
            return;
        L5:
            FLogger.a.i("DriveGalleryServiceDelegate", "[fetchDriveImagePreviewUrl] Error; error=" + r4 + ", url=" + r5);
            this.a.resumeWith(Result.constructor-impl(r5));
        }
    }

    public static final class d implements Function1<Throwable, Unit> {
        public final /* synthetic */ h75.a a;

        public d(h75.a r1) {
            this.a = r1;
        }

        public final Object invoke(Object r1) {
            Throwable r2 = (Throwable) r1;
            h75.a r3 = this.a;
            if (r3 == null) goto L6;
            r3.cancel();
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class e implements h75.d {
        public final /* synthetic */ kotlinx.coroutines.i<String> a;
        public final /* synthetic */ k b;

        public final void a(DriveVideoPreviewResponse r5) {
            Intrinsics.checkNotNullParameter(r5, "info");
            if (this.a.isActive() == true) goto L5;
            return;
        L5:
            String r0 = k.h(this.b, r5);
            FLogger.a.i("DriveGalleryServiceDelegate", "[fetchDriveVideoPreviewUrl] Success; info=" + r5);
            this.a.resumeWith(Result.constructor-impl(r0));
        }

        public e(kotlinx.coroutines.j r1, k r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void b(DriveVideoPreviewException r4, DriveVideoPreviewResponse r5) {
            Intrinsics.checkNotNullParameter(r4, "e");
            Intrinsics.checkNotNullParameter(r5, "info");
            if (this.a.isActive() == true) goto L5;
            return;
        L5:
            FLogger.a.i("DriveGalleryServiceDelegate", "[fetchDriveVideoPreviewUrl] Error; error=" + r4 + ", info=" + r5);
            kotlinx.coroutines.i<String> r6 = this.a;
            Result.Companion r0 = Result.Companion;
            r6.resumeWith(Result.constructor-impl(k.h(this.b, r5)));
        }
    }

    static {
    }

    public k() {
    }

    @Override // e89.d
    public final Pair<Integer, Integer> a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = m0.b(r4);
        int r1 = (m0.a(r4) - i5.n()) - c(r4);
        return TuplesKt.to(Integer.valueOf(r0), Integer.valueOf(r1));
    }

    @Override // e89.d
    public final int c(Context r2) {
        if ((r2 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r3 = (FragmentActivity) r2;
    L6:
        if (r3 == null) goto L8;
        int r4 = com.larus.utils.u.b(r3);
    L9:
        if (r4 == 0) goto L11;
        return r4;
    L11:
        return i5.h();
    L8:
        r4 = 0;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    @Override // e89.d
    public final Fragment d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "fileToken");
        com.bytedance.ee.drive.preview.d r0 = t.a;
        com.bytedance.ee.drive.preview.d r1 = t.a;
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.Z5(r3, null, null);
    }

    public static final int g(k r0, String r1) {
        r0.getClass();
        if (r1 == null) goto L5;
        String r2 = r1.toLowerCase(Locale.ROOT);
    L6:
        if (r2 != null) goto L8;
    L26:
        return 4;
    L8:
        switch(r2.hashCode()) {
            case 1572835: goto L23;
            case 1604548: goto L19;
            case 1688155: goto L15;
            case 46737913: goto L11;
            default: goto L26;
        };
    L11:
        if (r2.equals("1080p") == false) goto L26;
        return 3;
    L15:
        if (r2.equals("720p") == false) goto L26;
        return 2;
    L19:
        if (r2.equals("480p") == false) goto L26;
        return 1;
    L23:
        if (r2.equals("360p") == false) goto L26;
        return 0;
    L5:
        r2 = null;
        goto L6
    }

    public static final String h(k r4, DriveVideoPreviewResponse r5) {
        r4.getClass();
        Map r0 = r5.getTranscodeUrls();
        String r3 = null;
        if ((!r0.isEmpty()) == false) goto L16;
        Map.Entry r6 = (Map.Entry) SequencesKt.firstOrNull(SequencesKt.sortedWith(SequencesKt.filter(CollectionsKt.asSequence(r0.entrySet()), new j()), new m(new l(r4))));
        if (r6 == null) goto L7;
        String r7 = (String) r6.getValue();
    L8:
        if (r7 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L16;
        return r7;
    L10:
        if (StringsKt.isBlank(r7) == true) goto L13;
        r1 = false;
        goto L14
    L7:
        r7 = null;
    L16:
        String r8 = r5.getOriginUrl();
        if ((!StringsKt.isBlank(r8)) == false) goto L20;
        r3 = r8;
    L20:
        return r3;
    }

    @Override // e89.d
    public final Object b(String r5, Continuation<? super String> r6) {
        com.bytedance.ee.drive.preview.d r0 = t.a;
        com.bytedance.ee.drive.preview.d r1 = t.a;
        if (r1 == null) goto L5;
        a85.c r2 = r1.Jd();
    L6:
        if (r2 != null) goto L9;
        FLogger.a.i("DriveGalleryServiceDelegate", "[fetchDriveVideoPreviewUrl] VideoLoader is null");
        return null;
    L9:
        kotlinx.coroutines.j r3 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r6), 1);
        r3.C();
        r3.i(new d(r2.fetchDriveVideoPreview(r5, new e(r3, this))));
        Object r7 = r3.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L12:
        return r7;
    L5:
        r2 = null;
        goto L6
    }

    @Override // e89.d
    public final Object e(String r5, Continuation<? super String> r6) {
        com.bytedance.ee.drive.preview.d r0 = t.a;
        com.bytedance.ee.drive.preview.d r1 = t.a;
        if (r1 == null) goto L5;
        a85.b r2 = r1.y7();
    L6:
        if (r2 != null) goto L9;
        FLogger.a.i("DriveGalleryServiceDelegate", "[fetchDriveImagePreviewUrl] ImageLoader is null");
        return null;
    L9:
        kotlinx.coroutines.j r3 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r6), 1);
        r3.C();
        r3.i(new b(r2.fetchDriveImagePreview(r5, new c(r3))));
        Object r7 = r3.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L12:
        return r7;
    L5:
        r2 = null;
        goto L6
    }

    @Override // e89.d
    public final String f(String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "fileToken");
        ik5.a r0 = t.c;
        if (r0 == null) goto L5;
        com.bytedance.ee.bear.list.cover.a r1 = r0.F9();
    L6:
        if (r1 != null) goto L10;
        FLogger.a.i("DriveGalleryServiceDelegate", "[fetchMediaCoverUrl] CoverLoader is null");
        return null;
    L10:
        return r1.a(r3, r4, r5, "near");
    L5:
        r1 = null;
        goto L6
    }
}
