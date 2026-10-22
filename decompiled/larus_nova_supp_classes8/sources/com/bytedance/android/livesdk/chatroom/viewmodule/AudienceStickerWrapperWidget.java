package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.chatroom.presenter.AudienceStickerPresenter;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.LiveStickerTtfUtil;
import com.bytedance.android.livesdk.config.jt0;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationDetail;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationFontConfig;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/AudienceStickerWrapperWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/StickerWrapperWidget;", "Lcom/bytedance/android/livesdk/chatroom/presenter/AudienceStickerPresenter$IView;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/widget/u$a;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceStickerWrapperWidget extends StickerWrapperWidget implements AudienceStickerPresenter.IView, com.bytedance.android.livesdk.chatroom.widget.u.a {
    public static final /* synthetic */ int A = 0;
    public boolean k;
    public a l;
    public final int m;
    public final CompositeDisposable n;
    public long o;
    public String p;
    public long q;
    public String r;
    public boolean s;
    public boolean t;
    public long u;
    public long v;
    public boolean w;
    public boolean x;
    public Disposable y;
    public Disposable z;

    public static final class a {
        public final RoomDecoration a;
        public final boolean b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            RoomDecoration r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.b;
            ?? r4 = r3;
            if (r3 == false) goto L10;
            r4 = 1;
        L10:
            return r2 + r4;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "TempRoomDecoration(roomDecoration=" + this.a + ", record=" + this.b + ")";
        }

        public a(RoomDecoration r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "roomDecoration");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AudienceStickerWrapperWidget a;
        public final /* synthetic */ boolean b;

        public b(AudienceStickerWrapperWidget r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            if (this.b == false) goto L5;
            AudienceStickerWrapperWidget r7 = this.a;
            int r1 = AudienceStickerWrapperWidget.A;
            r7.Iq(false);
        L6:
            AudienceStickerWrapperWidget r8 = this.a;
            boolean r0 = this.b;
            Iterator r9 = ((ArrayList) r8.e).iterator();
            com.bytedance.android.livesdk.chatroom.widget.u r2 = null;
        L8:
            if (r9.hasNext() == false) goto L12;
            com.bytedance.android.livesdk.chatroom.widget.u r3 = (com.bytedance.android.livesdk.chatroom.widget.u) r9.next();
            if (r3.getRoomDecoration().isTextSticker() != r0) goto L8;
            r2 = r3;
            goto L8
        L12:
            if (r2 == null) goto L22;
            ImageView r10 = r2.m;
            if (r10 == null) goto L23;
            UtilityKotlinExtentionsKt.t(r10);
            return;
        L23:
            return;
        L22:
            return;
        L5:
            AudienceStickerWrapperWidget r11 = this.a;
            int r4 = AudienceStickerWrapperWidget.A;
            r11.Gq(false);
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ AudienceStickerWrapperWidget a;

        public d(AudienceStickerWrapperWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            AudienceStickerWrapperWidget r7 = this.a;
            a r0 = r7.l;
            if (r0 == null) goto L25;
            RoomDecoration r1 = r0.a;
            DecorationFontConfig r2 = null;
            if (r1 == null) goto L10;
            DecorationFontConfig r3 = r1.getTextFontConfig();
            if (r3 == null) goto L10;
            Long r4 = Long.valueOf(r3.getFontId());
        L12:
            if (LiveStickerTtfUtil.a(r4) == false) goto L17;
            a r8 = r7.l;
            if (r8 == null) goto L16;
            r7.xq(r8.a, r8.b);
        L16:
            r7.l = null;
            return;
        L17:
            a r9 = r7.l;
            if (r9 == null) goto L22;
            RoomDecoration r10 = r9.a;
            if (r10 == null) goto L22;
            r2 = r10.getTextFontConfig();
        L22:
            LiveStickerTtfUtil.b(r2);
            return;
        L10:
            r4 = null;
            goto L12
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final int getLayoutId() {
        return 2131568007;
    }

    public final String getSpm() {
        return "a100.a100.a109";
    }

    public final void Jq() {
        Iterator r0 = ((ArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        com.bytedance.android.livesdk.chatroom.widget.u r1 = (com.bytedance.android.livesdk.chatroom.widget.u) r0.next();
        if (r1.getRoomDecoration().isTextSticker() == true) goto L7;
        this.u = 0;
        this.v = r1.getRoomDecoration().getId();
        UtilityKotlinExtentionsKt.w(r1);
        this.w = true;
        r1.k();
        goto L4
    L7:
        this.o = 0;
        this.p = null;
        this.q = r1.getRoomDecoration().getId();
        this.r = r1.getRoomDecoration().getContent();
        UtilityKotlinExtentionsKt.w(r1);
        this.s = true;
        r1.k();
        goto L4
    }

    public AudienceStickerWrapperWidget() {
        int r0 = com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.c.a;
        this.m = jt0.a.getValue().intValue();
        this.n = new CompositeDisposable();
        this.s = true;
        this.w = true;
    }

    public final AudienceStickerPresenter Eq() {
        AudienceStickerPresenter r0 = yq();
        if (r0 == null) goto L7;
        return r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.presenter.AudienceStickerPresenter");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        AudienceStickerPresenter r0 = new AudienceStickerPresenter();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.g = r0;
        yq().g0(this);
        RoomOthersData r1 = this.i.others;
        if (r1 == null) goto L18;
        DecorationDetail r2 = r1.getDecoDetail();
        if (r2 == null) goto L18;
        DecorationDetail r3 = new DecorationDetail();
        RoomDecoration r4 = r2.getTextDecoration();
        if (r4 == null) goto L14;
        r3.setTextDecoration(RoomDecoration.Companion.copy(r4));
        AudienceStickerPresenter r5 = Eq();
        RoomDecoration r6 = r3.getTextDecoration();
        if (r6 == null) goto L12;
        String r7 = r6.getContent();
        if (r7 == null) goto L12;
    L13:
        r5.j0(r7);
    L12:
        r7 = "";
    L14:
        RoomDecoration r8 = r2.getImageDecoration();
        if (r8 == null) goto L17;
        r3.setImageDecoration(RoomDecoration.Companion.copy(r8));
    L17:
        OS(r3);
        this.k = true;
    L18:
        Lazy<String> r9 = LiveStickerTtfUtil.a;
        LiveStickerTtfUtil.c.observe(this, new d(this), true);
        if (com.bytedance.android.livesdk.config.setting.i.a.K() == true) goto L29;
        ILiveExpOptService r10 = jc1.k.f(ILiveExpOptService.class);
        if (r10 == null) goto L24;
        Disposable r11 = r10.registerExpBizListener(l61.d.a.c.e, new com.bytedance.android.livesdk.chatroom.viewmodule.d(this));
    L25:
        if (r11 == null) goto L28;
        this.n.add(r11);
        return;
    L28:
        return;
    L24:
        r11 = null;
        goto L25
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.n.dispose();
    }

    public final void onPause() {
        super.onPause();
        if (Intrinsics.areEqual(Build.BRAND, "HUAWEI") == true) goto L5;
        return;
    L5:
        if (this.k == false) goto L7;
        this.k = false;
    L7:
        this.l = null;
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L11;
        ((ViewGroup) r0).removeAllViews();
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void onResume() {
        super.onResume();
        if (Intrinsics.areEqual(Build.BRAND, "HUAWEI") == true) goto L5;
        return;
    L5:
        if (this.k == true) goto L22;
        RoomOthersData r0 = this.i.others;
        if (r0 == null) goto L20;
        DecorationDetail r1 = r0.getDecoDetail();
        if (r1 == null) goto L21;
        DecorationDetail r2 = new DecorationDetail();
        RoomDecoration r3 = r1.getTextDecoration();
        if (r3 == null) goto L14;
        r2.setTextDecoration(RoomDecoration.Companion.copy(r3));
    L14:
        RoomDecoration r4 = r1.getImageDecoration();
        if (r4 == null) goto L17;
        r2.setImageDecoration(RoomDecoration.Companion.copy(r4));
    L17:
        OS(r2);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final Disposable Fq(boolean r4) {
        return Single.timer(this.m, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r4), c.a);
    }

    public final void Gq(boolean r2) {
        this.x = r2;
        if (r2 == false) goto L11;
        Disposable r3 = this.z;
        if (r3 == null) goto L7;
        this.n.remove(r3);
    L7:
        Disposable r4 = Fq(false);
        this.z = r4;
        if (r4 == null) goto L12;
        RxUtilKt.c(r4, this.n);
        return;
    L12:
        return;
    }

    public final void Iq(boolean r2) {
        this.t = r2;
        if (r2 == false) goto L11;
        Disposable r3 = this.y;
        if (r3 == null) goto L7;
        this.n.remove(r3);
    L7:
        Disposable r4 = Fq(true);
        this.y = r4;
        if (r4 == null) goto L12;
        RxUtilKt.c(r4, this.n);
        return;
    L12:
        return;
    }

    public final void OU(DecorationDetail r6) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        this.o = this.q;
        this.p = this.r;
        this.q = 0;
        RoomDecoration r2 = null;
        this.r = null;
        this.u = this.v;
        this.v = 0;
        Iterator r0 = ((ArrayList) this.e).iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        com.bytedance.android.livesdk.chatroom.widget.u r1 = (com.bytedance.android.livesdk.chatroom.widget.u) r0.next();
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L12;
        ((ViewGroup) r3).removeView(r1);
        goto L7
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L13:
        ((ArrayList) this.e).clear();
        if (r6 == null) goto L16;
        r2 = r6.getTextDecoration();
    L16:
        if (r2 != null) goto L18;
        Eq().j0("");
    L18:
        if (r6 == null) goto L31;
        RoomDecoration r4 = r6.getTextDecoration();
        if (r4 == null) goto L22;
        wq(RoomDecoration.Companion.copy(r4));
        Eq().j0(r4.getContent());
    L22:
        RoomDecoration r5 = r6.getImageDecoration();
        if (r5 == null) goto L25;
        wq(RoomDecoration.Companion.copy(r5));
    L25:
        RoomOthersData r7 = this.i.others;
        if (r7 == null) goto L32;
        r7.setDecoDetail(r6);
        return;
    L32:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.u.a
    public final void T9(boolean r2) {
        if (r2 == false) goto L5;
        this.s = false;
        return;
    L5:
        this.w = false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.u.a
    public final void X6(boolean r2) {
        if (r2 == false) goto L5;
        Iq(true);
        return;
    L5:
        Gq(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.u.a
    public final boolean o8(boolean r1) {
        if (r1 == false) goto L5;
        return this.t;
    L5:
        return this.x;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.u.a
    public final boolean s9(boolean r1) {
        if (r1 == false) goto L5;
        return this.s;
    L5:
        return this.w;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final int zq(int r3) {
        int r0 = this.c[1];
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return r3;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final void xq(RoomDecoration r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "roomDecoration");
        if (r10.getImage() != null) goto L8;
        if (r10.getNinePatchImage() != null) goto L8;
        return;
    L8:
        if (r10.isTextSticker() == false) goto L20;
        if (r10.isCustomFont() == false) goto L20;
        DecorationFontConfig r0 = r10.getTextFontConfig();
        if (r0 == null) goto L14;
        Long r1 = Long.valueOf(r0.getFontId());
    L16:
        if (LiveStickerTtfUtil.a(r1) == true) goto L20;
        this.l = new a(r10, r11);
        LiveStickerTtfUtil.b(r10.getTextFontConfig());
        return;
    L14:
        r1 = null;
    L20:
        if (r10.isTextSticker() == false) goto L26;
        this.q = r10.getId();
        String r12 = r10.getContent();
        this.r = r12;
        if (this.q == this.o) goto L24;
    L25:
        this.s = true;
        Iq(true);
    L29:
        ViewGroup r2 = ((Widget) this).containerView;
        if (r2 == null) goto L44;
        com.bytedance.android.livesdk.chatroom.widget.u r13 = new com.bytedance.android.livesdk.chatroom.widget.u(r2, r10, false, this.c, null, this);
        if (r10.getType() != 1) goto L37;
        String r3 = r10.getContent();
        if (r3 != null) goto L36;
        r3 = "";
    L36:
        r13.setText(r3);
    L37:
        ((ArrayList) this.e).add(r13);
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L42;
        ((ViewGroup) r4).addView(r13);
        HashMap r14 = new HashMap();
        r14.put("sticker_id", String.valueOf(r10.getId()));
        com.bytedance.android.livesdk.log.u.l().sendLog("audience_sticker_show", r14, new Object[0]);
        return;
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L44:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L24:
        if ((!Intrinsics.areEqual(r12, this.p)) == false) goto L29;
    L26:
        long r5 = r10.getId();
        this.v = r5;
        if (r5 == this.u) goto L29;
        this.w = true;
        Gq(true);
        goto L29
    }
}
