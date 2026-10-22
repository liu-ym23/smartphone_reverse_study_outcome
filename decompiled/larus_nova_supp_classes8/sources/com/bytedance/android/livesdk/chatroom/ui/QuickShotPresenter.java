package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.vs.model.VSRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class QuickShotPresenter {
    public VideoViewParams a;
    public final Context b;
    public final DataCenter c;
    public final IRoom d;
    public final b e;

    public static final class a {
    }

    public interface b {
        PopupWindow Xc(long r1, Bitmap r3, VideoViewParams r4);

        void vp(long r1, int r3, String r4);

        void ya(String r1, long r2, Bitmap r4, VideoViewParams r5);
    }

    public static final class c implements o60.e {
        public final /* synthetic */ QuickShotPresenter a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Bitmap c;

        public final void onPermissionDenied(String... r2) {
            Intrinsics.checkNotNullParameter(r2, "permissions");
        }

        public final void onPermissionGrant(String... r4) {
            Intrinsics.checkNotNullParameter(r4, "permissions");
            this.a.c(this.b, this.c);
        }

        public c(QuickShotPresenter r1, long r2, Bitmap r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    public static final class d<V> implements Callable {
        public final /* synthetic */ QuickShotPresenter a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ long c;

        public d(QuickShotPresenter r1, Bitmap r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.util.concurrent.Callable
        public final Bitmap call() {
            long r0 = System.currentTimeMillis();
            int r2 = oo1.i.a;
            Bitmap r3 = this.b;
            yr1.p r4 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.w();
            QuickShotPresenter r5 = this.a;
            Context r6 = r5.b;
            IBaseUser r7 = r5.d.getOwner();
            if (r7 == null) goto L6;
            String r8 = r7.getNickName();
            if (r8 == null) goto L6;
        L7:
            View r9 = r4.getQuickShotWatermark(r6, r8);
            vr1.u r10 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, null, 3);
            if (r10 == null) goto L18;
            Room r11 = r10.j0();
            if (r11 == null) goto L18;
            VSRoom r12 = r11.castToOrNull(VSRoom.class);
            if (r12 == null) goto L18;
            EpisodeExtraInfo r13 = r12.getEpisodeExtra();
            if (r13 == null) goto L18;
            if (r13.getStyle() != 2) goto L18;
            float r14 = 0.03f;
        L19:
            Intrinsics.checkNotNullParameter(r3, "bitmap");
            if (r9 != null) goto L22;
        L25:
            long r15 = System.currentTimeMillis();
            long r16 = this.c;
            long r17 = r15 - r0;
            int r1 = r9.a;
            vr1.o r18 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l();
            Map<String, String> r19 = MapsKt.mapOf(new Pair[]{TuplesKt.to("status", "1"), TuplesKt.to("sessionId", String.valueOf(r16)), TuplesKt.to("duration", String.valueOf(r17))});
            am2.x r20 = new am2.x();
            r20.a = "live";
            r20.e = "other";
            r20.b = "live_detail";
            r18.sendLog("livesdk_quick_shot_generate_frame", r19, new Object[]{r20, IRoom.class});
            return r3;
        L22:
            if (r3.getConfig() == null) goto L25;
            r9.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            Bitmap r21 = Bitmap.createBitmap(r9.getMeasuredWidth(), r9.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            Canvas r110 = new Canvas(r21);
            r9.layout(0, 0, r9.getMeasuredWidth(), r9.getMeasuredHeight());
            r9.draw(r110);
            int r22 = (int) (r3.getHeight() * r14);
            float r111 = r9.getMeasuredWidth() / r9.getMeasuredHeight();
            float r23 = r22;
            Bitmap r24 = Bitmap.createScaledBitmap(r21, (int) (r111 * r23), r22, false);
            int r112 = r3.getWidth();
            int r113 = r3.getHeight();
            Bitmap.Config r114 = r3.getConfig();
            Intrinsics.checkNotNull(r114);
            Bitmap r115 = Bitmap.createBitmap(r112, r113, r114);
            Canvas r116 = new Canvas(r115);
            r116.drawBitmap(r3, 0.0f, 0.0f, null);
            r116.drawBitmap(r24, 0.0f, r3.getHeight() - r23, null);
            r24.recycle();
            r21.recycle();
            r3 = r115;
        L18:
            r14 = 0.07f;
        L6:
            r8 = "";
            goto L7
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ QuickShotPresenter a;
        public final /* synthetic */ long b;

        public e(QuickShotPresenter r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r5) {
            Bitmap r6 = (Bitmap) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            QuickShotPresenter r0 = this.a;
            return new v5(r6, r0.e.Xc(this.b, r6, r0.a));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ QuickShotPresenter a;
        public final /* synthetic */ long b;

        public f(QuickShotPresenter r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r14) {
            v5 r15 = (v5) r14;
            long r0 = System.currentTimeMillis();
            String r2 = com.bytedance.android.livesdk.chatroom.utils.m2.a(this.a.b, r15.a, "douyin_quick_screenshot");
            long r3 = System.currentTimeMillis();
            DataCenter r5 = this.a.c;
            if (r5 != null) goto L5;
        L7:
            QuickShotPresenter r6 = this.a;
            r6.e.ya(r2, this.b, r15.a, r6.a);
            long r7 = this.b;
            boolean r16 = !TextUtils.isEmpty(r2);
            long r4 = r3 - r0;
            int r1 = r9.a;
            vr1.o r8 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l();
            Pair[] r9 = new Pair[3];
            if (r16 == false) goto L10;
            String r17 = "1";
        L11:
            r9[0] = TuplesKt.to("status", r17);
            r9[1] = TuplesKt.to("sessionId", String.valueOf(r7));
            r9[2] = TuplesKt.to("duration", String.valueOf(r4));
            Map<String, String> r18 = MapsKt.mapOf(r9);
            am2.x r10 = new am2.x();
            r10.a = "live";
            r10.e = "other";
            r10.b = "live_detail";
            r8.sendLog("livesdk_quick_shot_save_frame", r18, new Object[]{r10, IRoom.class});
            return;
        L10:
            r17 = "2";
            goto L11
        L5:
            if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r5, true) != true) goto L7;
            com.bytedance.android.live.core.utils.f2.c("快拍海报保存成功", 0);
            goto L7
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ QuickShotPresenter a;
        public final /* synthetic */ long b;

        public g(QuickShotPresenter r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            b r0 = this.a.e;
            long r1 = this.b;
            int r3 = com.bytedance.android.livesdk.chatroom.utils.n.a(r6);
            String r7 = r6.getMessage();
            if (r7 != null) goto L5;
            r7 = "";
        L5:
            r0.vp(r1, r3, r7);
        }
    }

    static {
    }

    public final void b(final long r10) {
        Context r0 = this.b;
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        final Activity r2 = (Activity) r0;
        if (r2 == null) goto L11;
        final long r3 = System.currentTimeMillis();
        int r1 = bs1.a.a;
        ILivePlayerClient r4 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.p().currentClient();
        if (r4 == null) goto L12;
        r4.saveFrame(new QuickShotPresenter$onClickQuickShotBtn$$inlined$apply$lambda$2(r2, r3, this, r10));
        return;
    L12:
        return;
    }

    public final void c(long r4, Bitmap r6) {
        if (r6 == null) goto L10;
        DataCenter r0 = this.c;
        if (r0 == null) goto L7;
        VideoViewParams r1 = (VideoViewParams) r0.get("live_render_view_params", null);
        if (r1 == null) goto L7;
    L8:
        this.a = r1;
        Observable.fromCallable(new d(this, r6, r4)).compose(RxUtil.rxSchedulerHelper()).subscribeOn(AndroidSchedulers.mainThread()).map(new e(this, r4)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new f(this, r4), new g(this, r4));
        return;
    L7:
        r1 = new VideoViewParams(0, 0, 0, 0.0f);
        goto L8
    }

    public QuickShotPresenter(Context r2, DataCenter r3, IRoom r4, b r5) {
        Intrinsics.checkNotNullParameter(r2, "currentContext");
        Intrinsics.checkNotNullParameter(r3, "currentDataCenter");
        Intrinsics.checkNotNullParameter(r4, "mRoom");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.a = new VideoViewParams(0, 0, 0, 0.0f);
    }

    public final void a(Activity r7, Bitmap r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "it");
        long r1 = System.currentTimeMillis() - r11;
        int r12 = r9.a;
        vr1.o r13 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l();
        boolean r4 = false;
        Map<String, String> r14 = MapsKt.mapOf(new Pair[]{TuplesKt.to("status", "1"), TuplesKt.to("sessionId", String.valueOf(r9)), TuplesKt.to("duration", String.valueOf(r1))});
        am2.x r2 = new am2.x();
        r2.a = "live";
        r2.e = "other";
        r2.b = "live_detail";
        r13.sendLog("livesdk_quick_shot_catch_frame", r14, new Object[]{r2, IRoom.class});
        Intrinsics.checkNotNullParameter(r7, "activity");
        if (Build.VERSION.SDK_INT >= 30) goto L5;
    L7:
        if (r4 == false) goto L9;
    L11:
        c(r9, r8);
        return;
    L9:
        if (m60.c.d(r7, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}) == true) goto L11;
        SettingKey r15 = m60.i.a;
        new m60.i.b(r7).b(new c(this, r9, r8), null, TokenCert.Companion.with("bpea-live_quick_shot_request_permission"), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        return;
    L5:
        if (r7.getApplicationInfo().targetSdkVersion < 30) goto L7;
        r4 = true;
        goto L7
    }
}
