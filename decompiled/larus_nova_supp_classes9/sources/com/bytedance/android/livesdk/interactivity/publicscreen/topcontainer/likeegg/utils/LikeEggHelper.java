package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import com.bytedance.android.live.base.model.data.n;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.widget.m0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.BitmapUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m60.i;
import py.k;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LikeEggHelper {
    public static final TokenCert a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static k f;
    public static String g;
    public static final CompositeDisposable h = null;

    public static final class a implements o60.e {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ Function0 b;

        public final void onPermissionDenied(String... r2) {
            Intrinsics.checkNotNullParameter(r2, "permissions");
            this.b.invoke();
        }

        public final void onPermissionGrant(String... r2) {
            Intrinsics.checkNotNullParameter(r2, "permissions");
            this.a.invoke();
        }

        public a(Function0 r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b<T1, T2, R> implements BiFunction {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2, Object r3) {
            sh6.b r4 = (sh6.b) r2;
            sh6.b r5 = (sh6.b) r3;
            Intrinsics.checkNotNullParameter(r4, "image");
            Intrinsics.checkNotNullParameter(r5, "qrCode");
            return new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.a((Bitmap) sh6.c.b(r4), (Bitmap) sh6.c.b(r5));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Context a;

        public c(Context r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.a r4 = (com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.a) r3;
            if (r4 == null) goto L5;
            Bitmap r0 = r4.a;
        L6:
            if (r0 != null) goto L8;
        L11:
            ALogger.e("LikeEggHelper", "load image fail");
            f2.c("图片保存失败", 0);
            return;
        L8:
            if (r4.b == null) goto L11;
            TokenCert r1 = LikeEggHelper.a;
            final Context r2 = this.a;
            LikeEggHelper.c(new LikeEggHelper$saveImageWithBitmap$1(r2, r4), LikeEggHelper$saveImageWithBitmap$2.INSTANCE);
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public static final class d<T, R> implements Function {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r3) {
            k r4 = (k) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            ALogger.d("LikeEggHelper", "loading QRCode, " + r4.getUrls());
            return a1.k(r4);
        }
    }

    public static final class e<T, R> implements Function {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r2) {
            Bitmap r3 = (Bitmap) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return sh6.c.a(r3);
        }
    }

    public static final class f<T, R> implements Function {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object apply(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            ALogger.e("LikeEggHelper", "download qrCode error", r4);
            return sh6.a.a;
        }
    }

    public static final class g<T, R> implements Function {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final Object apply(Object r2) {
            Bitmap r3 = (Bitmap) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return sh6.c.a(r3);
        }
    }

    public static final class h<T> implements ObservableOnSubscribe {
        public final /* synthetic */ String a;

        public h(String r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<sh6.b<Bitmap>> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Bitmap r0 = BitmapUtils.getBitmapFromSD(this.a);
            if (r0 == null) goto L5;
            r2.onNext(sh6.c.a(r0));
            r2.onComplete();
        L5:
            r2.onComplete();
        }
    }

    static {
        a = TokenCert.Companion.with("bpea-likeegg_request_permission");
        b = "https://p1-webcast-dycdn.byteimg.com/obj/webcast/ttlive_like_egg_prepare_state.webp";
        c = "https://p1-webcast-dycdn.byteimg.com/obj/webcast/ttlive_like_egg_state_prepare_to_active.webp";
        d = "https://p1-webcast-dycdn.byteimg.com/obj/webcast/ttlive_like_egg_active_state.webp";
        e = "https://p1-webcast-dycdn.byteimg.com/obj/webcast/ttlive_like_egg_easter_egg.webp";
        f = vh7.f.c(k.class);
        g = BuildConfig.FLAVOR;
        h = new CompositeDisposable();
    }

    public static int a(DataCenter r5) {
        u r2 = r.u(r5, null, 2);
        if (r2 == null) goto L38;
        j r3 = r2.N();
        if (r3 == null) goto L38;
        m0 r4 = (m0) r3.getValue();
        if (r4 == null) goto L38;
        Rect r6 = r4.a();
        if (r6 == null) goto L38;
        u r7 = r.u(r5, null, 2);
        if (r7 == null) goto L35;
        j r8 = r7.N();
        if (r8 == null) goto L35;
        m0 r9 = (m0) r8.getValue();
        if (r9 == null) goto L35;
        Rect r10 = r9.c();
        if (r10 == null) goto L35;
        if (r6.height() >= r6.width()) goto L23;
        boolean r0 = true;
    L24:
        boolean r1 = PadConfigUtils.c();
        boolean r11 = e5.n();
        if (r1 == true) goto L28;
        if (r0 == false) goto L28;
        int r13 = r10.bottom;
        int r14 = r6.bottom;
    L39:
        return r13 - r14;
    L28:
        if (r1 == false) goto L34;
        if (r11 == true) goto L34;
        if (r0 == false) goto L34;
        r13 = r10.bottom - r6.bottom;
        r14 = (int) UtilityKotlinExtentionsKt.h(38);
    L34:
        return (int) UtilityKotlinExtentionsKt.h(480);
    L23:
        r0 = false;
    L35:
        float r15 = UtilityKotlinExtentionsKt.h(480);
    L37:
        return (int) r15;
    L38:
        r15 = UtilityKotlinExtentionsKt.h(480);
        goto L37
    }

    public static void b(String r5, com.bytedance.android.livesdk.chatroom.likeegg.a r6) {
        Intrinsics.checkNotNullParameter(r5, "roomId");
        Intrinsics.checkNotNullParameter(r6, "msg");
        if (g.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L9:
        g = r5;
        r.k().getQrCodeInfo(5, g, LikeEggHelper$preloadQRCode$1.INSTANCE);
    L10:
        Iterator r7 = CollectionsKt.listOf(new String[]{e, b, c, d}).iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        String r1 = (String) r7.next();
        k r3 = vh7.f.c(k.class);
        r3.setUri(r1);
        r3.setUrls(CollectionsKt.listOf(r1));
        a1.z(r3);
        goto L12
    L14:
        com.bytedance.android.livesdk.chatroom.likeegg.a.b r8 = r6.jumpDetail;
        if (r8 == null) goto L37;
        n r9 = r8.templatePhotoJumpDetail;
        if (r9 == null) goto L46;
        List r10 = r9.a();
        if (r10 == null) goto L47;
        Iterator r11 = r10.iterator();
    L23:
        if (r11.hasNext() == false) goto L48;
        n.a r13 = (n.a) r11.next();
        String r2 = r13.templateId;
        if (r2 != null) goto L27;
    L32:
        k r4 = r13.templatePhoto;
        if (r4 == null) goto L23;
        if (r4.isValid() != true) goto L23;
        a1.z(r13.templatePhoto);
        goto L23
    L27:
        if (r2.length() != 0) goto L29;
        boolean r14 = true;
    L30:
        if (r14 == true) goto L32;
        r.k().preloadTemplateResource(r13.templateId);
        goto L32
    L29:
        r14 = false;
        goto L30
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L37:
        return;
    L8:
        if ((!Intrinsics.areEqual(g, r5)) == false) goto L10;
    L5:
        r0 = false;
        goto L6
    }

    public static void c(Function0 r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r3, "successAction");
        Intrinsics.checkNotNullParameter(r4, "failAction");
        Activity r0 = com.bytedance.android.live.core.utils.a.d();
        if (Build.VERSION.SDK_INT < 33) goto L5;
        List r1 = CollectionsKt.listOf("android.permission.READ_MEDIA_IMAGES");
    L6:
        SettingKey r2 = i.a;
        new i.b(r0).a(new a(r3, r4), a, r1);
        return;
    L5:
        r1 = CollectionsKt.listOf(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"});
        goto L6
    }

    public static void d(Context r4, Observable r5, DataCenter r6) {
        if (g.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L16;
        u r7 = r.u(r6, null, 2);
        if (r7 == null) goto L14;
        IRoom r8 = r7.k2();
        if (r8 == null) goto L14;
        String r9 = String.valueOf(r8.getId());
        if (r9 == null) goto L14;
    L15:
        g = r9;
    L14:
        r9 = BuildConfig.FLAVOR;
    L16:
        RxUtilKt.c(Observable.zip(r5, Observable.create(LikeEggHelper$saveImage$qrCode$1.a).subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.io()).flatMap(d.a).map(e.a).onErrorReturn(f.a), b.a).compose(RxUtil.rxSchedulerHelper()).onErrorReturnItem(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.a(null, null)).subscribe(new c(r4)), h);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public static void e(Context r1, k r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "imageModel");
        d(r1, a1.k(r2).compose(RxUtil.rxSchedulerHelper()).map(g.a), r3);
    }

    public static void f(Context r1, String r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "localPath");
        d(r1, Observable.create(new h(r2)).compose(RxUtil.rxSchedulerHelper()), r3);
    }
}
