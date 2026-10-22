package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import androidx.core.content.ContextCompat;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y1 implements Runnable {
    public final /* synthetic */ SaveDataURLMethod.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SaveDataURLMethod c;
    public final /* synthetic */ Context d;

    public static final class a implements Runnable {
        public final /* synthetic */ SaveDataURLMethod a;

        public a(SaveDataURLMethod r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SaveDataURLMethod r0 = this.a;     // Catch: Throwable -> L4
            SaveDataURLMethod.SaveDataURLResModel r1 = new SaveDataURLMethod.SaveDataURLResModel();     // Catch: Throwable -> L4
            r1.a(SaveDataURLMethod.SaveDataURLResModel.Code.Failed);     // Catch: Throwable -> L4
            r1.c("base64 string transform to bitmap failure");     // Catch: Throwable -> L4
            r0.finishWithResult(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ SaveDataURLMethod a;
        public final /* synthetic */ SaveDataURLMethod.SaveDataURLResModel b;

        public b(SaveDataURLMethod r1, SaveDataURLMethod.SaveDataURLResModel r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.finishWithResult(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SaveDataURLMethod a;
        public final /* synthetic */ String b;

        public c(SaveDataURLMethod r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SaveDataURLMethod r0 = this.a;     // Catch: Throwable -> L4
            SaveDataURLMethod.SaveDataURLResModel r1 = new SaveDataURLMethod.SaveDataURLResModel();     // Catch: Throwable -> L4
            String r10 = this.b;     // Catch: Throwable -> L4
            r1.a(SaveDataURLMethod.SaveDataURLResModel.Code.Success);     // Catch: Throwable -> L4
            r1.c("Success");     // Catch: Throwable -> L4
            r1.b(r10);     // Catch: Throwable -> L4
            r0.finishWithResult(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ SaveDataURLMethod a;

        public d(SaveDataURLMethod r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SaveDataURLMethod r0 = this.a;     // Catch: Throwable -> L4
            SaveDataURLMethod.SaveDataURLResModel r1 = new SaveDataURLMethod.SaveDataURLResModel();     // Catch: Throwable -> L4
            r1.a(SaveDataURLMethod.SaveDataURLResModel.Code.Failed);     // Catch: Throwable -> L4
            r1.c("save image failure");     // Catch: Throwable -> L4
            r0.finishWithResult(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements com.bytedance.android.annie.bridge.method.permission.b {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ SaveDataURLMethod.a c;
        public final /* synthetic */ SaveDataURLMethod d;

        public static final class a implements Runnable {
            public final /* synthetic */ SaveDataURLMethod a;
            public final /* synthetic */ Uri b;

            public a(SaveDataURLMethod r1, Uri r10) {
                this.a = r1;
                this.b = r10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SaveDataURLMethod r0 = this.a;     // Catch: Throwable -> L12
                SaveDataURLMethod.SaveDataURLResModel r1 = new SaveDataURLMethod.SaveDataURLResModel();     // Catch: Throwable -> L12
                Uri r10 = this.b;     // Catch: Throwable -> L12
                if (r10 == null) goto L5;
                SaveDataURLMethod.SaveDataURLResModel.Code r11 = SaveDataURLMethod.SaveDataURLResModel.Code.Success;     // Catch: Throwable -> L12
            L6:
                r1.a(r11);     // Catch: Throwable -> L12
                if (r10 == null) goto L9;
                String r12 = "Success";
            L10:
                r1.c(r12);     // Catch: Throwable -> L12
                r1.b(String.valueOf(r10));     // Catch: Throwable -> L12
                r0.finishWithResult(r1);     // Catch: Throwable -> L12
                return;
            L9:
                r12 = "Save to gallery failed";
                goto L10
            L5:
                r11 = SaveDataURLMethod.SaveDataURLResModel.Code.Failed;     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L16;
                return;
            L16:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ SaveDataURLMethod a;

            public b(SaveDataURLMethod r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SaveDataURLMethod r0 = this.a;     // Catch: Throwable -> L4
                SaveDataURLMethod.SaveDataURLResModel r1 = new SaveDataURLMethod.SaveDataURLResModel();     // Catch: Throwable -> L4
                r1.a(SaveDataURLMethod.SaveDataURLResModel.Code.FailedPermissionRejected);     // Catch: Throwable -> L4
                r1.c("Save to gallery failed for permission rejected");     // Catch: Throwable -> L4
                r1.b(null);     // Catch: Throwable -> L4
                r0.finishWithResult(r1);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.b
        public final void onRequestPermissionsResult(int r10, String[] r11, int[] r12) {
            Intrinsics.checkNotNullParameter(r11, "permissions");
            Intrinsics.checkNotNullParameter(r12, "grantResults");
            if (ContextCompat.checkSelfPermission(this.a, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L8;
            int r13 = com.bytedance.android.annie.util.k.a;
            Context r14 = this.a;
            String r15 = this.b;
            String r16 = this.c.d();
            Intrinsics.checkNotNull(r16);
            Uri r0 = null;
            Pair r17 = com.bytedance.android.annie.util.k.a(r14, r15, Intrinsics.areEqual(r16, "image"), null, null);
            if (r17 == null) goto L7;
            r0 = (Uri) r17.getFirst();
        L7:
            ThreadUtils.a().post(new a(this.d, r0));
            return;
        L8:
            String r18 = this.b;
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L11
            Object r20 = Result.constructor-impl(Boolean.valueOf(com.bytedance.android.annie.util.d.g(r18)));     // Catch: Throwable -> L11
        L13:
            Result.exceptionOrNull-impl(r20);
            ThreadUtils.a().post(new b(this.d));
            return;
        L11:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            r20 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L13
        }

        public e(Context r1, String r10, SaveDataURLMethod.a r11, SaveDataURLMethod r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }
    }

    public y1(SaveDataURLMethod.a r1, String r10, SaveDataURLMethod r11, Context r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    public final void a() {
        String r0 = this.a.a();
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "imgStr");
        boolean r10 = false;
        List r1 = StringsKt.split$default(r0, new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L9
        if (r1.size() != 1) goto L6;
        byte[] r11 = Base64.decode(r0, 0);     // Catch: Exception -> L9
    L7:
        Bitmap r12 = BitmapFactory.decodeByteArray(r11, 0, r11.length);     // Catch: Exception -> L9
    L10:
        if (r12 != null) goto L13;
        ThreadUtils.a().post(new a(this.c));
        return;
    L13:
        String r13 = this.a.b();
        if (r13 != null) goto L16;
    L19:
        boolean r14 = true;
    L21:
        if (r14 == true) goto L29;
        String r15 = this.a.b();
        Intrinsics.checkNotNull(r15);
        if (StringsKt.contains(r15, "png", true) == false) goto L25;
        boolean r16 = com.bytedance.android.annie.util.g.b(r12, new PolarisFileWrapper(this.b), 100, Bitmap.CompressFormat.PNG);
    L30:
        if (r16 == true) goto L32;
        ThreadUtils.a().post(new d(this.c));
        return;
    L32:
        if (this.a.d() == null) goto L85;
        IHybridComponent r17 = this.c.a;
        if ((r17 instanceof com.bytedance.android.annie.container.fragment.o) == false) goto L36;
        com.bytedance.android.annie.container.fragment.o r18 = (com.bytedance.android.annie.container.fragment.o) r17;
    L37:
        if (r18 == null) goto L50;
        c7.a r19 = r18.getAnnieContext();
        if (r19 == null) goto L50;
        SaveDataURLMethod r20 = this.c;
        WeakReference<HybridFragment> r21 = AnnieFragmentManager.b(r19.getUuid());
        if (r21 == null) goto L43;
        a7.b r22 = (HybridFragment) r21.get();
    L45:
        if ((r22 instanceof com.bytedance.android.annie.container.fragment.q) == false) goto L47;
        com.bytedance.android.annie.container.fragment.q r23 = (com.bytedance.android.annie.container.fragment.q) r22;
    L48:
        if (r23 != null) goto L52;
        r23 = r20.b;
    L52:
        if (com.bytedance.android.annie.util.d.e() == false) goto L54;
        int r24 = com.bytedance.android.annie.util.k.a;
        Context r25 = this.d;
        String r26 = this.b;
        String r27 = this.a.d();
        Intrinsics.checkNotNull(r27);
        Pair r28 = com.bytedance.android.annie.util.k.b(r25, r26, Intrinsics.areEqual(r27, "image"));
    L55:
        if (r28 == null) goto L57;
        Uri r29 = (Uri) r28.getFirst();
    L58:
        if (r28 == null) goto L60;
        Integer r30 = (Integer) r28.getSecond();
    L61:
        if (r29 == null) goto L63;
        boolean r31 = true;
    L64:
        if (r29 != null) goto L70;
        if (r30 == null) goto L70;
        if (r30.intValue() != (-1)) goto L70;
        boolean r32 = true;
    L72:
        if (ContextCompat.checkSelfPermission(this.d, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L74;
        r10 = true;
    L74:
        SaveDataURLMethod.SaveDataURLResModel r33 = new SaveDataURLMethod.SaveDataURLResModel();
        if (r31 == false) goto L77;
        r33.a(SaveDataURLMethod.SaveDataURLResModel.Code.Success);
        r33.c("Success");
        r33.b(String.valueOf(r29));
    L81:
        if (r31 == true) goto L83;
        if (r32 == false) goto L83;
        return;
    L83:
        ThreadUtils.a().post(new b(this.c, r33));
        return;
    L77:
        if (r10 == false) goto L79;
        r33.a(SaveDataURLMethod.SaveDataURLResModel.Code.Failed);
        r33.c("Save to gallery failed");
        r33.b(null);
        goto L81
    L79:
        if (r32 == true) goto L81;
        r33.a(SaveDataURLMethod.SaveDataURLResModel.Code.FailedPermissionRejected);
        r33.c("Save to gallery failed for no permission");
        r33.b(null);
    L70:
        r32 = false;
        goto L72
    L63:
        r31 = false;
        goto L64
    L60:
        r30 = null;
        goto L61
    L57:
        r29 = null;
        goto L58
    L54:
        int r34 = com.bytedance.android.annie.util.k.a;
        Context r35 = this.d;
        String r36 = this.b;
        String r37 = this.a.d();
        Intrinsics.checkNotNull(r37);
        r28 = com.bytedance.android.annie.util.k.a(r35, r36, Intrinsics.areEqual(r37, "image"), r23, new e(this.d, this.b, this.a, this.c));
        goto L55
    L47:
        r23 = null;
        goto L48
    L43:
        r22 = null;
    L50:
        r23 = null;
        goto L52
    L36:
        r18 = null;
        goto L37
    L85:
        ThreadUtils.a().post(new c(this.c, this.b));
        return;
    L25:
        String r38 = this.a.b();
        Intrinsics.checkNotNull(r38);
        if (StringsKt.contains(r38, "webp", true) == false) goto L28;
        r16 = com.bytedance.android.annie.util.g.b(r12, new PolarisFileWrapper(this.b), 100, Bitmap.CompressFormat.WEBP);
        goto L30
    L28:
        r16 = com.bytedance.android.annie.util.g.b(r12, new PolarisFileWrapper(this.b), 100, Bitmap.CompressFormat.JPEG);
        goto L30
    L29:
        r16 = com.bytedance.android.annie.util.g.b(r12, new PolarisFileWrapper(this.b), 100, Bitmap.CompressFormat.JPEG);
        goto L30
    L16:
        if (StringsKt.isBlank(r13) == true) goto L19;
        r14 = false;
        goto L21
    L6:
        r11 = Base64.decode((String) ListProtector.get(r1, 1), 0);     // Catch: Exception -> L9
    L9:
        r12 = null;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
