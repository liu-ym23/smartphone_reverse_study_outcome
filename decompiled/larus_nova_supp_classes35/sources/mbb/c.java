package mbb;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.Flowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.text.DecimalFormat;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static volatile boolean a;
    public static volatile mbb.f b;
    public static volatile mbb.g c;
    public static volatile mbb.d d;
    public static volatile mbb.e e;

    public static final class a implements Action {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ obb.a c;
        public final /* synthetic */ long d;

        public a(String r1, String r2, obb.a r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void run() {
            boolean r0 = c.a;
            String r1 = this.a;
            String r2 = this.b;
            if (r2 != null) goto L5;
            r2 = BuildConfig.FLAVOR;
        L5:
            boolean r3 = c.b(BuildConfig.FLAVOR, -1, r1, r2);
            obb.a r4 = this.c;
            if (r4 == null) goto L8;
            IconScene r5 = r4.e;
        L9:
            c.j(r3, r5, true, this.d);
            return;
        L8:
            r5 = null;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ obb.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ImageView c;

        public b(obb.b r1, String r2, ImageView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            obb.b r0 = this.a;
            if (r0 == null) goto L6;
            String r1 = r0.b;
            if (r1 == null) goto L6;
        L8:
            if (TextUtils.equals(r1, this.c.getTag(2131363734).toString()) == false) goto L11;
            this.c.setImageBitmap(r5);
            return;
        L11:
            return;
        L6:
            r1 = this.b;
            goto L8
        }
    }

    /* JADX INFO: renamed from: mbb.c$c, reason: collision with other inner class name */
    public static final class C0257c<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ obb.a c;
        public final /* synthetic */ long d;

        public C0257c(String r1, String r2, obb.a r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r11) {
            Throwable r12 = (Throwable) r11;
            Log.e("DOCS_ICON_DocsIconCenter", "loadDocumentIcon only url fail , " + r12);
            boolean r0 = c.a;
            String r1 = this.a;
            String r2 = this.b;
            if (r2 != null) goto L5;
            r2 = BuildConfig.FLAVOR;
        L5:
            boolean r4 = c.b(BuildConfig.FLAVOR, -1, r1, r2);
            obb.a r3 = this.c;
            if (r3 == null) goto L8;
            IconScene r5 = r3.e;
        L9:
            c.i(r4, r5, false, this.d, r12.getMessage());
            return;
        L8:
            r5 = null;
            goto L9
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ obb.a d;
        public final /* synthetic */ long e;

        public d(String r1, int r2, String r3, obb.a r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void run() {
            boolean r0 = c.a;
            String r1 = this.a;
            int r2 = this.b;
            String r3 = this.c;
            if (r3 != null) goto L5;
            r3 = BuildConfig.FLAVOR;
        L5:
            boolean r4 = c.b(r1, r2, BuildConfig.FLAVOR, r3);
            obb.a r5 = this.d;
            if (r5 == null) goto L8;
            IconScene r6 = r5.e;
        L9:
            c.j(r4, r6, true, this.e);
            return;
        L8:
            r6 = null;
            goto L9
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ ImageView b;

        public e(String r1, ImageView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            if (TextUtils.equals(this.a, this.b.getTag(2131363734).toString()) == false) goto L6;
            this.b.setImageBitmap(r5);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ obb.a d;
        public final /* synthetic */ long e;

        public f(String r1, int r2, String r3, obb.a r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r11) {
            Throwable r12 = (Throwable) r11;
            boolean r0 = c.a;
            String r1 = this.a;
            int r2 = this.b;
            String r3 = this.c;
            if (r3 != null) goto L5;
            r3 = BuildConfig.FLAVOR;
        L5:
            boolean r4 = c.b(r1, r2, BuildConfig.FLAVOR, r3);
            obb.a r5 = this.d;
            if (r5 == null) goto L8;
            IconScene r6 = r5.e;
        L9:
            c.i(r4, r6, false, this.e, r12.getMessage());
            return;
        L8:
            r6 = null;
            goto L9
        }
    }

    public static final class g implements Action {
        public final /* synthetic */ String a;
        public final /* synthetic */ obb.a b;
        public final /* synthetic */ long c;

        public g(String r1, obb.a r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void run() {
            boolean r0 = c.a;
            boolean r1 = c.b(BuildConfig.FLAVOR, -1, this.a, BuildConfig.FLAVOR);
            obb.a r2 = this.b;
            if (r2 == null) goto L5;
            IconScene r3 = r2.e;
        L6:
            c.j(r1, r3, true, this.c);
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ obb.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ImageView c;

        public h(obb.b r1, String r2, ImageView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            String r0 = this.a.b;
            if (r0 != null) goto L6;
            r0 = this.b;
        L6:
            if (TextUtils.equals(r0, this.c.getTag(2131363734).toString()) == false) goto L9;
            this.c.setImageBitmap(r5);
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ obb.a b;
        public final /* synthetic */ long c;

        public i(String r1, obb.a r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Log.e("DOCS_ICON_DocsIconCenter", "loadDocumentIcon only url fail , " + ((Throwable) r5));
            boolean r6 = c.a;
            boolean r7 = c.b(BuildConfig.FLAVOR, -1, this.a, BuildConfig.FLAVOR);
            obb.a r0 = this.b;
            if (r0 == null) goto L5;
            IconScene r1 = r0.e;
        L6:
            c.j(r7, r1, false, this.c);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class j implements Action {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ obb.a c;
        public final /* synthetic */ long d;

        public j(String r1, int r2, obb.a r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void run() {
            boolean r0 = c.a;
            boolean r1 = c.b(this.a, this.b, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
            obb.a r2 = this.c;
            if (r2 == null) goto L5;
            IconScene r3 = r2.e;
        L6:
            c.j(r1, r3, true, this.d);
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ ImageView b;

        public k(String r1, ImageView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            if (TextUtils.equals(this.a, this.b.getTag(2131363734).toString()) == false) goto L6;
            this.b.setImageBitmap(r5);
            return;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ obb.a c;
        public final /* synthetic */ long d;

        public l(String r1, int r2, obb.a r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r5) {
            Log.e("DOCS_ICON_DocsIconCenter", "loadDocumentIcon only url fail , " + ((Throwable) r5));
            boolean r6 = c.a;
            boolean r7 = c.b(this.a, this.b, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
            obb.a r0 = this.c;
            if (r0 == null) goto L5;
            IconScene r1 = r0.e;
        L6:
            c.j(r7, r1, false, this.d);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class m implements Action {
        public final /* synthetic */ obb.c a;
        public final /* synthetic */ long b;

        public m(obb.c r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            boolean r0 = c.a;
            obb.c r1 = this.a;
            String r2 = r1.a;
            String r3 = BuildConfig.FLAVOR;
            if (r2 != null) goto L5;
            r2 = BuildConfig.FLAVOR;
        L5:
            Integer r4 = r1.getType();
            if (r4 == null) goto L8;
            int r5 = r4.intValue();
        L9:
            obb.c r6 = this.a;
            String r7 = r6.c;
            if (r7 != null) goto L12;
            r7 = BuildConfig.FLAVOR;
        L12:
            String r8 = r6.e;
            if (r8 == null) goto L16;
            r3 = r8;
        L16:
            c.j(c.b(r2, r5, r7, r3), this.a.n, true, this.b);
            return;
        L8:
            r5 = -1;
            goto L9
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ obb.c a;
        public final /* synthetic */ ImageView b;

        public n(obb.c r1, ImageView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            if (Intrinsics.areEqual(this.a.a(), this.b.getTag(2131363734)) == false) goto L6;
            this.b.setImageBitmap(r5);
            return;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ obb.c a;
        public final /* synthetic */ long b;

        public o(obb.c r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r12) {
            Throwable r13 = (Throwable) r12;
            Log.e("DOCS_ICON_DocsIconCenter", "loadIcon " + r13.getMessage());
            boolean r0 = c.a;
            obb.c r1 = this.a;
            String r2 = r1.a;
            String r3 = BuildConfig.FLAVOR;
            if (r2 != null) goto L5;
            r2 = BuildConfig.FLAVOR;
        L5:
            Integer r4 = r1.getType();
            if (r4 == null) goto L8;
            int r5 = r4.intValue();
        L9:
            obb.c r6 = this.a;
            String r7 = r6.c;
            if (r7 != null) goto L12;
            r7 = BuildConfig.FLAVOR;
        L12:
            String r8 = r6.e;
            if (r8 == null) goto L16;
            r3 = r8;
        L16:
            c.i(c.b(r2, r5, r7, r3), this.a.n, false, this.b, r13.getMessage());
            return;
        L8:
            r5 = -1;
            goto L9
        }
    }

    public c() {
    }

    static {
        a = true;
    }

    @JvmStatic
    public static final void h(ImageView r4, obb.c r5) {
        Intrinsics.checkNotNullParameter(r4, "iv");
        Intrinsics.checkNotNullParameter(r5, "iconModel");
        long r0 = System.nanoTime();
        r5.o = Long.valueOf(r0);
        r4.setTag(2131363734, r5.a());
        pbb.d.c(r5).doOnComplete(new m(r5, r0)).subscribe(new n(r5, r4), new o(r5, r0));
    }

    public static boolean b(String r1, int r2, String r3, String r4) {
        int r0 = obb.c.p;
        Intrinsics.checkNotNullParameter(r1, "token");
        obb.c.a r5 = new obb.c.a(r1, r2, r4);
        Intrinsics.checkNotNullParameter(r3, "url");
        r5.c = r3;
        obb.c r6 = new obb.c(r5);
        if (TextUtils.isEmpty(r6.a) == false) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == false) goto L15;
        Integer r8 = r6.f;
        if (r8 == null) goto L12;
        int r9 = r8.intValue();
    L13:
        if (r9 > 0) goto L15;
        return true;
    L12:
        r9 = 0;
    L15:
        return false;
    L5:
        if (r6.b == null) goto L7;
        r7 = true;
        goto L8
    }

    @JvmStatic
    public static final void e(ImageView r5, String r6, IconShape r7, obb.a r8) {
        Intrinsics.checkNotNullParameter(r5, "iv");
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r7, "shape");
        long r0 = System.nanoTime();
        Log.i("DOCS_ICON_DocsIconCenter", "loadDocumentIcon ");
        sbb.c.a.getClass();
        obb.b r3 = sbb.c.e(r6);
        if (r3 != null) goto L6;
        Log.e("DOCS_ICON_DocsIconCenter", "loadDocumentIcon url parse error");
        return;
    L6:
        String r2 = r3.b;
        if (r2 != null) goto L9;
        r2 = r6;
    L9:
        r5.setTag(2131363734, r2);
        int r4 = pbb.d.a;
        if (r8 != null) goto L12;
        obb.a r9 = new obb.a();
    L13:
        r9.f = Long.valueOf(r0);
        Unit r10 = Unit.INSTANCE;
        pbb.d.a(r3, r7, r9).doOnComplete(new g(r6, r8, r0)).subscribe(new h(r3, r6, r5), new i(r6, r8, r0));
        return;
    L12:
        r9 = r8;
        goto L13
    }

    public static /* synthetic */ void j(boolean r6, IconScene r7, boolean r8, long r9) {
        i(r6, r7, r8, r9, null);
    }

    @JvmStatic
    public static final Flowable<Bitmap> a(String r4, int r5, String r6, IconShape r7, obb.a r8) {
        Intrinsics.checkNotNullParameter(r4, "token");
        Intrinsics.checkNotNullParameter(r6, "meta");
        Intrinsics.checkNotNullParameter(r7, "shape");
        long r0 = System.nanoTime();
        Log.i("DOCS_ICON_DocsIconCenter", "getDocumentIcon with meta");
        sbb.c.a.getClass();
        obb.b r2 = sbb.c.a(r4, r5);
        boolean r9 = b(r4, r5, BuildConfig.FLAVOR, r6);
        if (r8 == null) goto L5;
        IconScene r10 = r8.e;
    L6:
        int r3 = pbb.d.a;
        if (r8 != null) goto L9;
        r8 = new obb.a();
    L9:
        r8.f = Long.valueOf(r0);
        Unit r11 = Unit.INSTANCE;
        return pbb.d.b(r2, r6, r7, r8).doOnComplete(new mbb.a(r9, r10, r0)).doOnError(new mbb.b(r9, r10, r0));
    L5:
        r10 = null;
        goto L6
    }

    @JvmStatic
    public static final void c(ImageView r9, String r10, int r11, IconShape r12, obb.a r13) {
        Intrinsics.checkNotNullParameter(r9, "iv");
        Intrinsics.checkNotNullParameter(r10, "token");
        Intrinsics.checkNotNullParameter(r12, "shape");
        long r7 = System.nanoTime();
        Log.i("DOCS_ICON_DocsIconCenter", "loadDocumentIcon " + r11);
        sbb.c.a.getClass();
        obb.b r0 = sbb.c.a(r10, r11);
        r9.setTag(2131363734, r10);
        int r1 = pbb.d.a;
        if (r13 != null) goto L5;
        obb.a r2 = new obb.a();
    L6:
        r2.f = Long.valueOf(r7);
        Unit r3 = Unit.INSTANCE;
        pbb.d.a(r0, r12, r2).doOnComplete(new j(r10, r11, r13, r7)).subscribe(new k(r10, r9), new l(r10, r11, r13, r7));
        return;
    L5:
        r2 = r13;
        goto L6
    }

    @JvmStatic
    public static final void f(ImageView r10, String r11, String r12, IconShape r13, obb.a r14) {
        Intrinsics.checkNotNullParameter(r10, "iv");
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r13, "shape");
        long r7 = System.nanoTime();
        Log.i("DOCS_ICON_DocsIconCenter", "loadDocumentIcon with meta");
        sbb.c.a.getClass();
        obb.b r9 = sbb.c.e(r11);
        if (r9 != null) goto L7;
        Log.e("DOCS_ICON_DocsIconCenter", "loadDocumentIcon url parse error");
        if (idb.f.a().isCurrentEnable("ccm.bitable.fix.appicon") == true) goto L7;
        return;
    L7:
        if (r9 == null) goto L10;
        String r0 = r9.b;
        if (r0 == null) goto L10;
    L11:
        r10.setTag(2131363734, r0);
        int r1 = pbb.d.a;
        if (r14 != null) goto L14;
        obb.a r2 = new obb.a();
    L15:
        r2.f = Long.valueOf(r7);
        Unit r3 = Unit.INSTANCE;
        pbb.d.b(r9, r12, r13, r2).doOnComplete(new a(r11, r12, r14, r7)).subscribe(new b(r9, r11, r10), new C0257c(r11, r12, r14, r7));
        return;
    L14:
        r2 = r14;
    L10:
        r0 = r11;
        goto L11
    }

    public static void i(boolean r7, IconScene r8, boolean r9, long r10, String r12) {
        if (r7 == false) goto L10;
        DecimalFormat r11 = vpb.f.a;     // Catch: Exception -> L5
        vpb.f.a("full", r8, 0, r9, System.nanoTime() - r10, r12);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("DOCS_ICON_DocsIconCenter", "reportDocIcon err", e);
        return;
    }

    @JvmStatic
    public static final void d(ImageView r10, String r11, int r12, String r13, IconShape r14, obb.a r15) {
        Intrinsics.checkNotNullParameter(r10, "iv");
        Intrinsics.checkNotNullParameter(r11, "token");
        Intrinsics.checkNotNullParameter(r14, "shape");
        long r8 = System.nanoTime();
        Log.i("DOCS_ICON_DocsIconCenter", "loadDocumentIcon with meta " + r12);
        sbb.c.a.getClass();
        obb.b r0 = sbb.c.a(r11, r12);
        r10.setTag(2131363734, r11);
        int r1 = pbb.d.a;
        if (r15 != null) goto L5;
        obb.a r2 = new obb.a();
    L6:
        r2.f = Long.valueOf(r8);
        Unit r3 = Unit.INSTANCE;
        pbb.d.b(r0, r13, r14, r2).doOnComplete(new d(r11, r12, r13, r15, r8)).subscribe(new e(r11, r10), new f(r11, r12, r13, r15, r8));
        return;
    L5:
        r2 = r15;
        goto L6
    }

    public static /* synthetic */ void g(ImageView r6, String r7, int r8, String r9, IconShape r10, int r11) {
        if ((r11 & 16) == 0) goto L5;
        r10 = IconShape.SQUARE;
    L5:
        d(r6, r7, r8, r9, r10, null);
    }
}
