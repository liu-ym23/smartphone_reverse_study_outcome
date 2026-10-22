package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival;

import am2.x;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cc2.n;
import cc2.p;
import com.bytedance.android.live.base.model.message.y3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.gift.model.e;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.g;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.j;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.monitor.DanmakuMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.CarnivalAutoTestUtil;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.barrage.carnival.DanmakuCarnivalManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.ui.ChatCarnivalView;
import com.bytedance.android.livesdk.k6;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.effectmanager.DownloadableModelSupport;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import o22.f;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/carnival/DanmakuCarnivalTrayManager;", "Lf52/d;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DanmakuCarnivalTrayManager implements f52.d, l, Observer<KVData> {
    public f52.b a;
    public boolean b;
    public boolean c;
    public long d;
    public final CompositeDisposable e;
    public final CompositeDisposable f;
    public final Lazy g;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.b h;
    public h i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy<ChatCarnivalView> m;
    public final Lazy n;
    public final Lazy o;
    public o22.d p;
    public final Lazy q;
    public final a r;
    public final String s;

    public static final class a extends p<cc2.d> {
        public final Set<cc2.d> f;
        public final Set<cc2.d> g;

        @Override // cc2.p
        public final Set<cc2.d> b() {
            return this.g;
        }

        @Override // cc2.p
        public final Set<cc2.d> c() {
            return this.f;
        }

        public a(c r2) {
            super(true, r2);
            this.f = SetsKt.emptySet();
            this.g = SetsKt.setOf(cc2.d.a.c);
        }
    }

    public final class b implements o22.c {
        public Disposable a;
        public j b;
        public boolean c;
        public final /* synthetic */ DanmakuCarnivalTrayManager d;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ ChatCarnivalView a;
            public final /* synthetic */ b b;
            public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.barrage.model.a c;
            public final /* synthetic */ o22.d d;

            public a(ChatCarnivalView r1, b r2, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r3, o22.d r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void accept(Object r4) {
                f r5 = (f) r4;
                if (this.b.d.c == false) goto L32;
                o22.b.a("onShowCarnivalTrayContentEvent. show=" + r5.a);
                if (r5.a == false) goto L20;
                UtilityKotlinExtentionsKt.t(this.a.getCarnivalBtn());
                com.bytedance.android.livesdk.interactivity.api.barrage.model.a r6 = this.c;
                if ((r6 instanceof j) == true) goto L10;
                r6 = null;
            L10:
                j r7 = (j) r6;
                if (r7 == null) goto L26;
                com.bytedance.android.livesdk.interactivity.api.barrage.data.l r8 = r7.B();
                if (r8 == null) goto L27;
                com.bytedance.android.livesdk.interactivity.api.barrage.data.h r9 = r8.a();
                if (r9 == null) goto L28;
                String r10 = r9.a();
                if (r10 == null) goto L33;
                TextView r1 = this.a.getChatCarnivalContent();
                r1.setText(r10);
                r1.setPadding(0, 0, UtilityKotlinExtentionsKt.i(6), 0);
                this.a.setOnClickListener(null);
                this.b.c = true;
                return;
            L33:
                return;
            L28:
                return;
            L27:
                return;
            L26:
                return;
            L20:
                b r11 = this.b;
                if (r11.c == false) goto L30;
                r11.c = false;
                j r2 = r11.b;
                if (r2 == null) goto L31;
                r11.h(r2);
                TextView r13 = this.b.d.l().getChatCarnivalContent();
                r13.setText(r2.m());
                r13.setPadding(0, 0, 0, 0);
                UtilityKotlinExtentionsKt.w(this.a.getCarnivalBtn());
                return;
            L31:
                return;
            L30:
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.DanmakuCarnivalTrayManager$b$b, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0195b implements View.OnClickListener {
            public final /* synthetic */ b a;
            public final /* synthetic */ j b;

            public ViewOnClickListenerC0195b(b r1, j r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r10) {
                k.n(IBaseLiveActionHandler.class).handle(r10.getContext(), this.b.y());
                com.bytedance.android.livesdk.interactivity.api.barrage.model.a r11 = this.a.d.l().getCurrentMsg();
                String r0 = DanmakuCarnivalTrayManager.d(this.a.d);
                int r1 = com.bytedance.android.livesdk.interactivity.common.utils.c.a;
                Intrinsics.checkNotNullParameter(r0, "carnivalType");
                HashMap r2 = new HashMap();
                Long r3 = null;
                if (r11 == null) goto L5;
                Long r4 = Long.valueOf(r11.h());
            L6:
                if (r4 != null) goto L9;
            L11:
                if (r4 != null) goto L14;
            L16:
                String r5 = BuildConfig.FLAVOR;
            L17:
                r2.put("trigger_type", r5);
                if (r11 == null) goto L20;
                r3 = Long.valueOf(r11.getMessageId());
            L20:
                r2.put("comment_carnival_ID", String.valueOf(r3));
                if (r11 == null) goto L25;
                Map<String, String> r13 = r11.f();
                if (r13 == null) goto L25;
                r2.putAll(r13);
            L25:
                r2.put("carnival_type", r0);
                j0.l().sendLog("livesdk_comment_carnival_tray_click", r2, new Object[]{new x(), IRoom.class});
                return;
            L14:
                if (r4.longValue() != 2) goto L16;
                r5 = e.FETCH_FROM_SETTING;
                goto L17
            L9:
                if (r4.longValue() != 1) goto L11;
                r5 = "prop";
                goto L17
            L5:
                r4 = null;
                goto L6
            }
        }

        public final void i() {
            Disposable r0 = this.a;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            this.a = null;
            ((q4.b) this.d.k.getValue()).a();
            this.d.l().setOnClickListener(null);
            this.d.l().clearAnimation();
            ((q4.b) this.d.l.getValue()).c();
            com.bytedance.android.livesdk.interactivity.api.publicscreen.b r1 = this.d.h;
            if (r1 != null) goto L8;
        L10:
            boolean r2 = false;
        L11:
            if (r2 == false) goto L17;
            com.bytedance.android.livesdk.interactivity.api.publicscreen.b r3 = this.d.h;
            if (r3 == null) goto L17;
            m<g> r4 = r3.getContour();
            if (r4 == null) goto L17;
            g r5 = (g) r4.getValue();
        L17:
            this.d.getClass();
            DanmakuCarnivalTrayManager.m("close contour algorithm");
            this.d.k().a();
            this.d.f.clear();
            if (v.a() == true) goto L20;
            return;
        L20:
            if (CarnivalAutoTestUtil.a == false) goto L24;
            CarnivalAutoTestUtil.a();
            return;
        L24:
            return;
        L8:
            if (r1.hasCleared() == true) goto L10;
            r2 = true;
            goto L11
        }

        public b(DanmakuCarnivalTrayManager r1) {
            this.d = r1;
        }

        public final void h(j r3) {
            if (r3.p() == true) goto L5;
        L7:
            this.d.l().setOnClickListener(null);
            return;
        L5:
            if (r3.y() == null) goto L7;
            this.d.l().setOnClickListener(new ViewOnClickListenerC0195b(this, r3));
        }

        @Override // o22.c
        public final void a(DanmakuCarnivalManager r2, j r3) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r3, "msg");
            this.d.l().setCurrentMsg(r3);
            this.b = r3;
            if (this.c == true) goto L10;
            DanmakuCarnivalTrayManager r4 = this.d;
            if (r4.c == false) goto L8;
            r4.l().getChatCarnivalContent().setText(r3.m());
        L8:
            h(r3);
            return;
        }

        @Override // o22.c
        public final void b(DanmakuCarnivalManager r2, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r3) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r3, "msg");
            this.d.getClass();
            DanmakuCarnivalTrayManager.m("onCarnivalEnd");
            i();
        }

        @Override // o22.c
        public final void c(DanmakuCarnivalManager r2, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r3) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r3, "msg");
            this.d.getClass();
            DanmakuCarnivalTrayManager.m("onCarnivalStop");
            i();
        }

        @Override // o22.c
        public final void d(o22.d r11, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r13) {
            Intrinsics.checkNotNullParameter(r11, "manager");
            Intrinsics.checkNotNullParameter(r13, "msg");
            this.d.getClass();
            DanmakuCarnivalTrayManager.m("in carnival");
            ((q4.b) this.d.j.getValue()).a();
            ChatCarnivalView r0 = this.d.l();
            UtilityKotlinExtentionsKt.w(r0);
            r0.setClickable(true);
            com.bytedance.android.livesdk.interactivity.api.barrage.model.a r2 = r0.a;
            if (r2 == null) goto L20;
            UtilityKotlinExtentionsKt.t(r0.l);
            UtilityKotlinExtentionsKt.w(r0.m);
            UtilityKotlinExtentionsKt.w(r0.i);
            HSImageView r3 = r0.h;
            r0.e.add(Observable.create(new oa2.b(r0)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new oa2.c(r3, r2, r0)));
            if (r2.c() != 1) goto L7;
            int r4 = 0;
        L8:
            r3.setVisibility(r4);
            String r5 = r2.m();
            if (r5 == null) goto L17;
            TextView r6 = r0.j;
            r6.setText(r5);
            r6.setPadding(0, 0, 0, 0);
            if (v.a() == false) goto L17;
            if (CarnivalAutoTestUtil.a == false) goto L17;
            if (CarnivalAutoTestUtil.a() == null) goto L17;
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
        L17:
            py.k r7 = r2.e();
            if (r7 == null) goto L20;
            ImageUtil.loadImage(r0.i, r7, 0);
            goto L20
        L7:
            r4 = 8;
        L20:
            boolean r8 = r13 instanceof j;
            com.bytedance.android.livesdk.interactivity.api.barrage.model.a r9 = null;
            if (r8 == true) goto L23;
            com.bytedance.android.livesdk.interactivity.api.barrage.model.a r10 = null;
        L24:
            j r14 = (j) r10;
            if (r14 == null) goto L27;
            h(r14);
        L27:
            ((q4.b) this.d.k.getValue()).c();
            com.bytedance.android.livesdk.interactivity.common.utils.c.b(r0.getCurrentMsg(), DanmakuCarnivalTrayManager.d(this.d), DanmakuCarnivalTrayManager.g(this.d));
            long r15 = 0;
            if (this.d.d <= 0) goto L31;
            r15 = System.currentTimeMillis() - this.d.d;
        L31:
            com.bytedance.android.livesdk.interactivity.api.barrage.model.a r16 = r0.getCurrentMsg();
            if (r16 == null) goto L34;
            Long r17 = Long.valueOf(r16.h());
        L35:
            com.bytedance.android.livesdk.interactivity.common.utils.c.a(r17, Long.valueOf(r15));
            this.d.c = true;
            if (r11.a() == false) goto L42;
            if (r8 == false) goto L40;
            r9 = r13;
        L40:
            this.b = (j) r9;
            this.a = xs2.b.a().b(f.class).subscribe(new a(r0, this, r13, r11));
            return;
        L42:
            return;
        L34:
            r17 = null;
            goto L35
        L23:
            r10 = r13;
            goto L24
        }

        @Override // o22.c
        public final void f(o22.d r3, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r4) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            Intrinsics.checkNotNullParameter(r4, "msg");
            this.d.getClass();
            DanmakuCarnivalTrayManager.m("onWarmup");
            UtilityKotlinExtentionsKt.w(this.d.l());
            ((q4.b) this.d.j.getValue()).c();
            DanmakuCarnivalTrayManager r5 = this.d;
            r5.d = System.currentTimeMillis();
            this.d.c = false;
            this.c = false;
            if (v.a() == true) goto L5;
            return;
        L5:
            if (CarnivalAutoTestUtil.a == false) goto L9;
            CarnivalAutoTestUtil.a();
            return;
        }

        @Override // o22.c
        public final void e(DanmakuCarnivalManager r6, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r6, "manager");
            Intrinsics.checkNotNullParameter(r7, "msg");
            this.d.getClass();
            DanmakuCarnivalTrayManager.m("in countdown");
            Disposable r9 = this.a;
            if (r9 == null) goto L5;
            r9.dispose();
        L5:
            Long r10 = null;
            this.a = null;
            this.d.l().setOnClickListener(null);
            if (r8 == false) goto L15;
            ((q4.b) this.d.j.getValue()).a();
            ChatCarnivalView r11 = this.d.l();
            UtilityKotlinExtentionsKt.w(r11);
            r11.a(true);
            r11.clearAnimation();
            ((q4.b) this.d.k.getValue()).c();
            com.bytedance.android.livesdk.interactivity.common.utils.c.b(r11.getCurrentMsg(), DanmakuCarnivalTrayManager.d(this.d), DanmakuCarnivalTrayManager.g(this.d));
            long r2 = 0;
            if (this.d.d <= 0) goto L11;
            r2 = System.currentTimeMillis() - this.d.d;
        L11:
            com.bytedance.android.livesdk.interactivity.api.barrage.model.a r13 = r11.getCurrentMsg();
            if (r13 == null) goto L14;
            r10 = Long.valueOf(r13.h());
        L14:
            com.bytedance.android.livesdk.interactivity.common.utils.c.a(r10, Long.valueOf(r2));
        L16:
            this.d.c = false;
            this.c = false;
            return;
        L15:
            this.d.l().a(false);
            goto L16
        }

        @Override // o22.c
        public final void g(o22.d r17, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r18, boolean r19) {
            Intrinsics.checkNotNullParameter(r17, "manager");
            Intrinsics.checkNotNullParameter(r18, "msg");
            this.d.getClass();
            DanmakuCarnivalTrayManager.m("onCarnivalStart");
            ((q4.b) this.d.l.getValue()).a();
            if (n22.a.b() == false) goto L8;
            if (r18.o() == false) goto L8;
            this.d.getClass();
            DanmakuCarnivalTrayManager.m("receive a carnival message,open contour");
            this.d.k().b();
        L8:
            if (this.d.l().getParent() != null) goto L10;
            r17.h(this.d.l(), new ViewGroup.LayoutParams(-1, -1));
        L10:
            this.d.l().setCurrentMsg(r18);
            ChatCarnivalView r1 = this.d.l();
            r1.d = this.d.h;
            com.bytedance.android.livesdk.interactivity.api.barrage.model.a r3 = r1.a;
            if (r3 == null) goto L61;
            String r6 = r3.i();
            if (r6 == null) goto L27;
            TextView r9 = r1.j;
            r9.setText(r6);
            r9.setTextColor(ColorProtector.parseColor(r3.l()));
            int r10 = (int) fm3.e.a(r9.getContext(), 8.0f);
            if (r3.h() != 1) goto L18;
            r9.setPadding(r10, 0, 0, 0);
        L21:
            if (v.a() == false) goto L27;
            if (CarnivalAutoTestUtil.a == false) goto L27;
            if (CarnivalAutoTestUtil.a() == null) goto L27;
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            goto L27
        L18:
            if (r3.h() != 2) goto L21;
            r9.setPadding(r10, 0, r10, 0);
        L27:
            HSImageView r7 = r1.l;
            if (r3.h() != 1) goto L30;
            r1.e.add(Observable.create(new oa2.a(r1)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new oa2.d(r7, r3, r1)));
            r7.setVisibility(0);
        L32:
            if (r3.b() == null) goto L34;
            int r8 = com.bytedance.android.live.schema.helper.g.b(r3.b(), ColorProtector.parseColor("#FF308A"));
        L35:
            r1.b = r8;
            Drawable r11 = r1.g.getBackground();
            if (r11 == null) goto L60;
            boolean r13 = true;
            ((GradientDrawable) r11).setColors(new int[]{Color.argb(8, 0, 0, 0), Color.argb(38, 0, 0, 0)});
            Drawable r14 = r1.f.getBackground();
            if (r14 == null) goto L58;
            ((GradientDrawable) r14).setColors(new int[]{Color.argb(72, Color.red(r1.b), Color.green(r1.b), Color.blue(r1.b)), Color.argb(22, Color.red(r1.b), Color.green(r1.b), Color.blue(r1.b))});
            UtilityKotlinExtentionsKt.t(r1.m);
            UtilityKotlinExtentionsKt.t(r1.i);
            UtilityKotlinExtentionsKt.t(r1.h);
            UtilityKotlinExtentionsKt.t(r1.k);
            r1.e.clear();
            py.k r15 = r3.e();
            if (r15 == null) goto L43;
            k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r15, new oa2.e(r1));
        L43:
            if (r3.a() == false) goto L45;
            r1.m.setBackground(s1.m(2131250169));
            goto L61
        L45:
            com.bytedance.android.livesdk.interactivity.api.publicscreen.b r4 = r1.d;
            if (r4 == null) goto L52;
            m<Boolean> r5 = r4.isDanmakuVisible();
            if (r5 == null) goto L52;
            Boolean r16 = (Boolean) r5.getValue();
            if (r16 == null) goto L52;
            r13 = r16.booleanValue();
        L52:
            r1.c = r13;
            ImageView r20 = r1.m;
            if (r13 == false) goto L55;
            Drawable r21 = s1.m(2131250553);
        L56:
            r20.setBackground(r21);
            r1.m.setOnClickListener(new oa2.f(r1));
            goto L61
        L55:
            r21 = s1.m(2131250552);
            goto L56
        L58:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        L60:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        L34:
            r8 = ColorProtector.parseColor("#FF308A");
            goto L35
        L30:
            r7.setController(null);
            r7.setVisibility(8);
        L61:
            this.d.l().setClickable(false);
            if (r19 == true) goto L65;
            this.d.getClass();
            DanmakuCarnivalTrayManager.m("skip warmup");
            UtilityKotlinExtentionsKt.u(this.d.l());
            this.d.d = -1;
        L65:
            if (v.a() == true) goto L67;
            return;
        L67:
            if (CarnivalAutoTestUtil.a == true) goto L69;
            return;
        L69:
            if (CarnivalAutoTestUtil.a() != null) goto L71;
            return;
        L71:
            if (r18.a() == false) goto L73;
            String r2 = "EcomCarnival";
        L74:
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            return;
        L73:
            r2 = "ChatCarnival";
            goto L74
        }
    }

    public static final class c implements n<cc2.d> {
        public final /* synthetic */ DanmakuCarnivalTrayManager a;

        public c(DanmakuCarnivalTrayManager r1) {
            this.a = r1;
        }

        @Override // cc2.n
        public final void a(cc2.d r1, Boolean r2) {
            UtilityKotlinExtentionsKt.w(this.a.l());
        }

        @Override // cc2.n
        public final void b(cc2.d r1, Boolean r2) {
            UtilityKotlinExtentionsKt.t(this.a.l());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ DanmakuCarnivalTrayManager a;

        public d(DanmakuCarnivalTrayManager r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            sh6.b r6 = (sh6.b) r5;
            HashMap<String, List<String>> r7 = com.bytedance.android.livesdk.interactivity.textmessage.utils.f.a;
            com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.c r8 = new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.c(this);
            Intrinsics.checkNotNullParameter(r8, "listener");
            if (DownloadableModelSupport.isInitialized() == true) goto L6;
            k.n(IMiddleWareHostContext.class).initDownloadableModelSupport();
        L6:
            if (DownloadableModelSupport.isInitialized() == false) goto L8;
            DownloadableModelSupport r0 = DownloadableModelSupport.getInstance();
        L9:
            if (r0 == null) goto L12;
            r0.fetchResourcesByRequirementsAndModelNames(new String[0], com.bytedance.android.livesdk.interactivity.textmessage.utils.f.a, new com.bytedance.android.livesdk.interactivity.textmessage.utils.g(r8));
            return;
        L12:
            return;
        L8:
            r0 = null;
            goto L9
        }
    }

    public final com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.a k() {
        return (com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.a) this.o.getValue();
    }

    public final ChatCarnivalView l() {
        return (ChatCarnivalView) this.n.getValue();
    }

    @Override // f52.d
    public final void onUnload() {
        m("onDestroyChatCarnival");
        o22.d r0 = this.p;
        if (r0 == null) goto L5;
        r0.f(null);
        this.p = null;
    L5:
        k().a();
        if (this.m.isInitialized() == false) goto L8;
        l().e.clear();
    L8:
        this.e.clear();
        this.f.clear();
    }

    public DanmakuCarnivalTrayManager() {
        this.e = new CompositeDisposable();
        this.f = new CompositeDisposable();
        this.g = LazyKt.lazy(DanmakuCarnivalTrayManager$mainHandler$2.INSTANCE);
        this.j = LazyKt.lazy(new DanmakuCarnivalTrayManager$warmupTrayEnterAnim$2(this));
        this.k = LazyKt.lazy(new DanmakuCarnivalTrayManager$carnivalTrayEnterAnim$2(this));
        this.l = LazyKt.lazy(new DanmakuCarnivalTrayManager$carnivalTrayExitAnim$2(this));
        Lazy<ChatCarnivalView> r0 = LazyKt.lazy(new DanmakuCarnivalTrayManager$carnivalViewDelegate$1(this));
        this.m = r0;
        this.n = r0;
        this.o = LazyKt.lazy(new DanmakuCarnivalTrayManager$contourManager$2(this));
        this.q = LazyKt.lazy(new DanmakuCarnivalTrayManager$danmakuCarnivalListener$2(this));
        this.s = "DanmakuCarnivalViewManager";
        this.r = new a(new c(this));
    }

    @Override // f52.d
    public final String getId() {
        return this.s;
    }

    public static final String d(DanmakuCarnivalTrayManager r1) {
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r2 = r1.l().getCurrentMsg();
        if (r2 != null) goto L5;
    L7:
        return "comment";
    L5:
        if (r2.a() != true) goto L7;
        return "trade";
    }

    public static final Map g(DanmakuCarnivalTrayManager r4) {
        r4.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        f52.b r1 = r4.a;
        if (r1 == null) goto L7;
        z.a r3 = z.a;
        DataCenter r2 = r1.getDataCenter();
        r3.getClass();
        if (z.a.a(r2) == false) goto L7;
        r0.put("show_area", "public_screen_emphasize");
    L9:
        if (r4.b == false) goto L11;
        String r5 = "1";
    L12:
        r0.put("is_anchor", r5);
        return r0;
    L11:
        r5 = "0";
    L7:
        r0.put("show_area", "public_screen_normal");
        goto L9
    }

    public static void m(String r1) {
        ALogger.i("CARNIVAL_MESSAGE", r1);
    }

    @Override // f52.d
    public final void j(f52.b r7) {
        Intrinsics.checkNotNullParameter(r7, "container");
        this.a = r7;
        IRoomContextService r8 = k.f(IRoomContextService.class);
        if (r8 == null) goto L16;
        f52.b r4 = this.a;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L7:
        o r9 = IRoomContextService.a.a(r8, r4.getDataCenter(), 0, 2);
        if (r9 == null) goto L16;
        com.bytedance.live.datacontext.j r10 = r9.getMessageManager();
        if (r10 == null) goto L16;
        vlc.d r11 = (vlc.d) r10.getValue();
        if (r11 == null) goto L16;
        Disposable r13 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.c(r11, "WebcastRoomAppConfigMessage", this);
        if (r13 == null) goto L16;
        RxUtilKt.c(r13, this.e);
    L16:
        f52.b r14 = this.a;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L19:
        r14.getDataCenter().observe("data_link_state", this).observe("cmd_change_interactivity_component_visibility", this);
        this.h = q.b();
        this.i = q.g();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r15 = this.h;
        if (r15 == null) goto L24;
        com.bytedance.live.datacontext.j<o22.d> r16 = r15.getDanmakuCarnivalManager();
        if (r16 == null) goto L24;
        r16.c(new DanmakuCarnivalTrayManager$onLoad$1(this));
    L24:
        IRoomContextService r17 = k.f(IRoomContextService.class);
        boolean r5 = false;
        if (r17 == null) goto L34;
        f52.b r6 = this.a;
        if (r6 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L29:
        o r18 = IRoomContextService.a.a(r17, r6.getDataCenter(), 0, 2);
        if (r18 == null) goto L34;
        Boolean r19 = r18.isAnchor();
        if (r19 == null) goto L34;
        boolean r20 = r19.booleanValue();
    L35:
        this.b = r20;
        n22.a.a = r20;
        k6 r21 = k6.a;
        if (((Integer) r21.getValue()).intValue() > 2) goto L38;
        r5 = true;
    L38:
        if (r5 == false) goto L50;
        h r23 = this.i;
        if (r23 == null) goto L52;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> r24 = r23.getLiveStream();
        if (r24 == null) goto L53;
        Maybe r25 = r24.b();
        if (r25 == null) goto L54;
        Maybe r26 = r25.observeOn(Schedulers.io());
        if (r26 == null) goto L55;
        Disposable r27 = r26.subscribe(new d(this));
        if (r27 == null) goto L56;
        RxUtilKt.c(r27, this.e);
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L50:
        com.bytedance.android.livesdk.interactivity.api.settings.config.f r0 = DanmakuMonitor.a;
        DanmakuMonitor.a("can't download:" + ((Integer) r21.getValue()));
        return;
    L34:
        r20 = false;
        goto L35
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        Object r0 = null;
        if (r7 == null) goto L5;
        String r1 = r7.getKey();
    L6:
        if (r1 == null) goto L73;
        int r2 = r1.hashCode();
        if (r2 == (-826138222)) goto L49;
        if (r2 == 872172481) goto L14;
        return;
    L14:
        if (r1.equals("data_link_state") == false) goto L61;
        Integer r8 = (Integer) r7.getData(0);
        if (r8 != null) goto L18;
        r8 = 0;
    L18:
        int r9 = r8.intValue();
        if (r9 != 0) goto L21;
        boolean r3 = true;
    L22:
        boolean r4 = gd0.v.a(r9, 4);
        boolean r10 = gd0.v.a(r9, 2);
        if (r3 == true) goto L30;
        if (r4 == true) goto L30;
        if (r10 == true) goto L27;
    L29:
        boolean r11 = false;
    L31:
        if (r11 == true) goto L33;
        n22.a.c = false;
        k().a();
        return;
    L33:
        n22.a.c = true;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r13 = this.h;
        if (r13 == null) goto L63;
        m<Boolean> r14 = r13.isCarnivalStarted();
        if (r14 != null) goto L38;
        return;
    L38:
        if (((Boolean) r14.getValue()).booleanValue() != true) goto L65;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r15 = this.h;
        if (r15 == null) goto L66;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r16 = r15.getChatCarnivalMessage();
        if (r16 == null) goto L67;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r17 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r16.getValue();
        if (r17 != null) goto L46;
        return;
    L46:
        if (r17.p() != 1) goto L69;
        k().b();
        return;
    L69:
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L63:
        return;
    L27:
        if (this.b == false) goto L29;
    L30:
        r11 = true;
        goto L31
    L21:
        r3 = false;
        goto L22
    L61:
        return;
    L49:
        if (r1.equals("cmd_change_interactivity_component_visibility") == false) goto L71;
        Object r18 = r7.getData();
        if ((r18 instanceof cc2.e) == false) goto L54;
        r0 = r18;
    L54:
        cc2.e r5 = (cc2.e) r0;
        if (r5 == null) goto L72;
        cc2.f r19 = r5.b(cc2.d.class);
        if (r19 == null) goto L75;
        this.r.e(r19.a, r19.b);
        return;
    L75:
        return;
    L72:
        return;
    L71:
        return;
    L73:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onMessage(tlc.d r2) {
        if ((r2 instanceof y3) == false) goto L11;
        com.bytedance.android.live.base.model.message.b r3 = ((y3) r2).getAnchorFaceConfig();
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.contourEnable == true) goto L9;
        k().a();
        boolean r4 = n22.a.a;
        n22.a.b = true;
        return;
    L9:
        boolean r5 = n22.a.a;
        n22.a.b = false;
        return;
    }
}
