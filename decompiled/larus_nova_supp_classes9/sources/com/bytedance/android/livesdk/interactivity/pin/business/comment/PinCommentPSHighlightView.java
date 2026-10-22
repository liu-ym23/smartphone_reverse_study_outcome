package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.config.cl0;
import com.bytedance.android.livesdk.interactivity.api.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.OperateInfo;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PinCommon;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/comment/PinCommentPSHighlightView;", "Landroid/widget/FrameLayout;", "Lg42/e;", BuildConfig.FLAVOR, "getContentHeight", "getMinHeight", "Lg42/c;", "pinContainer", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;", "highlightItem", BuildConfig.FLAVOR, "update", "Landroid/view/View;", "i", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinCommentPSHighlightView extends FrameLayout implements g42.e {
    public static final /* synthetic */ int j = 0;
    public final AutoEllipsesTextView a;
    public final TextView b;
    public final CompositeDisposable c;
    public Function0<Unit> d;
    public Disposable e;
    public boolean f;
    public final int g;
    public final int h;
    public final PinCommentPSHighlightView i;

    public static final class a implements tb2.b {
        public static final a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PinCommentPSHighlightView a;

        public b(PinCommentPSHighlightView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r2v8, types: [android.widget.TextView, com.bytedance.android.livesdk.interactivity.pin.business.comment.AutoEllipsesTextView] */
        public final void accept(Object r2) {
            o42.b r3 = (o42.b) r2;
            Function0<Unit> r4 = this.a.d;
            if (r4 == null) goto L5;
            Unit r5 = (Unit) r4.invoke();
        L5:
            boolean r6 = this.a.f;
            if (((Boolean) cl0.a.getValue()).booleanValue() == true) goto L8;
            r6 = false;
        L8:
            if (r6 == false) goto L14;
            ?? r7 = this.a.a;
            if (r7 == 0) goto L15;
            r7.post(new h(r7));
            return;
        L15:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.onClick(r2);
        }
    }

    public static final class d implements ak6.e {
        public final /* synthetic */ PinCommentPSHighlightView a;

        public d(PinCommentPSHighlightView r1) {
            this.a = r1;
        }

        public final void a(ak6.g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            Intrinsics.checkNotNullParameter(r2, "rendResult");
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [android.widget.TextView, com.bytedance.android.livesdk.interactivity.pin.business.comment.AutoEllipsesTextView] */
        public final void b(ak6.g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            AutoEllipsesTextView r0 = this.a.a;
            if (r0 == null) goto L5;
            r0.setContentText(r2.a);
        L5:
            boolean r3 = this.a.f;
            if (((Boolean) cl0.a.getValue()).booleanValue() == true) goto L8;
            r3 = false;
        L8:
            if (r3 == false) goto L14;
            ?? r4 = this.a.a;
            if (r4 == 0) goto L15;
            r4.post(new h(r4));
            return;
        L15:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ HighlightItem.c a;
        public final /* synthetic */ HighlightItem b;

        public e(HighlightItem.c r1, HighlightItem r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            if (this.a.b == false) goto L18;
            o32.b r4 = o.a();
            if (r4 == null) goto L9;
            n<Map<String, HighlightItem>> r5 = r4.getReviewingPinAndQAHighlightItems();
            if (r5 == null) goto L9;
            Map r6 = (Map) r5.getValue();
        L10:
            if (r6 != null) goto L12;
            return;
        L12:
            if (((HighlightItem) r6.remove(this.b.getUniqueKey())) == null) goto L25;
            o32.a.a("reviewing comment item display over time");
            o32.b r0 = o.a();
            if (r0 == null) goto L26;
            n<Map<String, HighlightItem>> r1 = r0.getReviewingPinAndQAHighlightItems();
            if (r1 == null) goto L27;
            r1.setValue(r6);
            return;
        L27:
            return;
        L26:
            return;
        L25:
            return;
        L9:
            r6 = null;
            goto L10
        L18:
            o32.a.a("review pass comment item display over time");
            o32.b r7 = o.a();
            if (r7 == null) goto L29;
            k<HighlightItem> r8 = r7.getItemDisplayEndEvent();
            if (r8 == null) goto L30;
            r8.post(this.b);
            return;
        L30:
            return;
        }
    }

    public static final class f extends nk6.a {
        public final /* synthetic */ PinCommentPSHighlightView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ HighlightItem.c c;
        public final /* synthetic */ g42.c d;

        public final void b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }

        public final boolean a(View r5, ek6.c r6, ClickableSpan r7) {
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r6, "action");
            Intrinsics.checkNotNullParameter(r7, "span");
            String r8 = null;
            if ((r6 instanceof ib2.a) == true) goto L5;
            r6 = null;
        L5:
            ib2.a r9 = (ib2.a) r6;
            if (r9 == null) goto L8;
            tb2.b r10 = r9.a;
        L9:
            boolean r11 = r10 instanceof a;
            if (r11 == false) goto L28;
            PinCommentPSHighlightView r13 = this.a;
            boolean r0 = this.b;
            HighlightItem.c r1 = this.c;
            g42.c r2 = this.d;
            int r3 = PinCommentPSHighlightView.j;
            r13.getClass();
            if (r0 == true) goto L25;
            if (r1 == null) goto L28;
            PinCommon r4 = r1.c();
            if (r4 == null) goto L28;
            OperateInfo r14 = r4.getOperateInfo();
            if (r14 == null) goto L28;
            String r15 = r14.getCreator();
            if (r15 == null) goto L28;
            if (r2 == null) goto L23;
            r8 = r2.getCurrentUserId();
        L23:
            if (r15.equals(r8) != true) goto L28;
        L25:
            if (com.bytedance.android.livesdk.interactivity.common.utils.h.b(r0) == false) goto L27;
            e42.b r16 = new e42.b(r1);
            r16.d = true;
            g42.i.a(r16);
            goto L28
        L27:
            f2.b(2131921367, 0);
        L28:
            return r11;
        L8:
            r10 = null;
            goto L9
        }

        public f(PinCommentPSHighlightView r1, boolean r2, HighlightItem.c r3, g42.c r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public PinCommentPSHighlightView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PinCommentPSHighlightView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // g42.e
    public int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(54);
    }

    @Override // g42.e
    public int getContentHeight() {
        return findViewById(2131367833).getHeight();
    }

    @Override // g42.e
    public View getView() {
        return this.i;
    }

    @Override // g42.e
    public final void a(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void d(int r2) {
        AppCompatTextView r0 = this.a;
        if (r0 != null) goto L5;
    L6:
        if (r2 <= 0) goto L12;
        AutoEllipsesTextView r1 = this.a;
        if (r1 == null) goto L13;
        r1.setMaxLines(r2);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.getMaxLines() != r2) goto L6;
    }

    @Override // g42.e
    public final void b(g42.c r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "item");
        g42.e.a.a(r2, r3);
        this.d = null;
        this.c.clear();
        this.f = false;
    }

    @Override // g42.e
    public void update(g42.c r3, HighlightItem r4) {
        Intrinsics.checkNotNullParameter(r3, "pinContainer");
        Intrinsics.checkNotNullParameter(r4, "highlightItem");
        e(r3, r4, z.e(r3.getDataCenter(), false));
    }

    public PinCommentPSHighlightView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new CompositeDisposable();
        this.g = UtilityKotlinExtentionsKt.i(8);
        this.h = UtilityKotlinExtentionsKt.i(3);
        FrameLayout.inflate(r2, 2131566735, this);
        this.a = (AutoEllipsesTextView) findViewById(2131390340);
        this.b = (TextView) findViewById(2131391308);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.i = this;
    }

    @Override // g42.e
    public final void c(DataCenter r3, g42.c r4, HighlightItem r5) {
        Intrinsics.checkNotNullParameter(r4, "pinContainer");
        Intrinsics.checkNotNullParameter(r5, "highlightItem");
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(r3).b(o42.b.class).subscribe(new b(this)), this.c);
        e(r4, r5, z.e(r4.getDataCenter(), false));
        DataCenter r6 = r4.getDataCenter();
        com.bytedance.android.livesdk.interactivity.api.h r7 = com.bytedance.android.livesdk.interactivity.api.i.a(MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r6, 0, 2), r6);
        if (r7 == null) goto L20;
        j<com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k> r8 = r7.getHighlightContext();
        if (r8 == null) goto L21;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k r9 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k) r8.getValue();
        if (r9 == null) goto L22;
        l r10 = r9.stateCenter();
        if (r10 == null) goto L23;
        z51.e r11 = r10.lifecycle();
        if (r11 == null) goto L24;
        Observable r13 = r11.a();
        if (r13 == null) goto L25;
        Observable r14 = RxUtilKt.h(r13);
        if (r14 == null) goto L26;
        Disposable r15 = r14.subscribe(new g(this));
        if (r15 == null) goto L27;
        RxUtilKt.c(r15, this.c);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void e(final g42.c r17, HighlightItem r18, boolean r19) {
        this.f = false;
        if (r18 == null) goto L5;
        HighlightItem.c r6 = r18.getCommentData();
    L6:
        if (r6 != null) goto L12;
        AppCompatTextView r1 = this.a;
        if (r1 == null) goto L10;
        r1.setText(BuildConfig.FLAVOR);
    L10:
        setClickable(false);
        return;
    L12:
        if (r17 == null) goto L14;
        DataCenter r7 = r17.getDataCenter();
    L15:
        com.bytedance.android.livesdk.interactivity.api.h r8 = com.bytedance.android.livesdk.interactivity.api.i.a(MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r7, 0, 2), r7);
        if (r8 == null) goto L24;
        j<com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k> r9 = r8.getHighlightContext();
        if (r9 == null) goto L24;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k r10 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k) r9.getValue();
        if (r10 == null) goto L24;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.j r11 = r10.mo773getContainer();
        if (r11 == null) goto L24;
        boolean r13 = r11.c(PinCommentPSHighlightView$isTopicCompShowing$1.INSTANCE);
    L25:
        if (r13 == false) goto L27;
        d(2);
    L28:
        Function0<Unit> r14 = new PinCommentPSHighlightView$doBindView$1(this, r17);
        this.d = r14;
        Unit r15 = (Unit) r14.invoke();
        if (r6.b == false) goto L37;
        TextView r3 = this.b;
        tb2.d r5 = new tb2.d();
        r5.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.g("置顶 ", "#99FFFFFF"));
        r5.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.g("内容审核中…", "#BFFFFFFF"));
        int r16 = mb2.c.a;
        Intrinsics.checkNotNullParameter(r5, "payload");
        LiveRichContentEngine.a().a().c(mb2.c.c(r5, 1.0f, "normal"), new com.bytedance.android.livesdk.interactivity.service.richcontent.config.b(true, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.h.b, false), new com.bytedance.android.livesdk.interactivity.pin.business.comment.f(r3));
        AppCompatTextView r4 = this.a;
        if (r4 == null) goto L33;
        UtilityKotlinExtentionsKt.t(r4);
    L33:
        TextView r20 = this.b;
        if (r20 == null) goto L36;
        UtilityKotlinExtentionsKt.w(r20);
    L36:
        setClickable(false);
    L77:
        if (r17 != null) goto L82;
        long r21 = r18.getEndTime() - p6.b();
        o32.a.a("pin comment can display " + r21 + " ms");
        if (r21 <= 0) goto L83;
        this.e = Observable.timer(r21, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r6, r18));
        return;
    L83:
        return;
    L82:
        return;
    L37:
        TextView r23 = this.b;
        if (r23 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r23);
    L40:
        AppCompatTextView r24 = this.a;
        if (r24 == null) goto L43;
        UtilityKotlinExtentionsKt.w(r24);
    L43:
        String r25 = Intrinsics.stringPlus(r6.e(), "：");
        String r26 = r6.d();
        if (r26 == null) goto L46;
        CharSequence r27 = com.bytedance.android.livesdk.interactivity.common.utils.g.a(r26, 14);
    L47:
        AutoEllipsesTextView r28 = this.a;
        if (r28 == null) goto L50;
        r28.b = false;
    L50:
        tb2.d r29 = new tb2.d();
        r29.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.g("置顶 ", "#99FFFFFF"));
        r29.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.g(r25, "#8CE7FF"));
        r29.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.g(String.valueOf(r27), "#FFFFFF"));
        if (r19 == true) goto L63;
        PinCommon r30 = r6.c();
        if (r30 == null) goto L67;
        OperateInfo r31 = r30.getOperateInfo();
        if (r31 == null) goto L67;
        String r33 = r31.getCreator();
        if (r33 == null) goto L67;
        if (r17 == null) goto L60;
        String r34 = r17.getCurrentUserId();
    L62:
        if (r33.equals(r34) != true) goto L67;
    L60:
        r34 = null;
    L67:
        int r35 = mb2.c.a;
        Intrinsics.checkNotNullParameter(r29, "payload");
        ek6.e r36 = mb2.c.c(r29, 1.0f, "normal");
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r37 = new com.bytedance.android.livesdk.interactivity.service.richcontent.config.b(true, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.h.b, false);
        f r38 = new f(this, r19, r6, r17);
        AppCompatTextView r39 = this.a;
        if (r39 == null) goto L70;
        r39.setMovementMethod(new u());
    L70:
        AppCompatTextView r40 = this.a;
        if (r40 == null) goto L73;
        r40.setHighlightColor(0);
    L73:
        AppCompatTextView r41 = this.a;
        if (r41 == null) goto L76;
        r41.setOnClickListener(new c(r38));
    L76:
        LiveRichContentEngine.a().a().c(r36, r37, new d(this));
    L63:
        AutoEllipsesTextView r43 = this.a;
        if (r43 == null) goto L66;
        r43.b = true;
    L66:
        r29.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" "));
        r29.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.a(2131251768).setClickAction(a.a));
        this.f = true;
        goto L67
    L46:
        r27 = null;
        goto L47
    L27:
        d(3);
    L24:
        r13 = false;
        goto L25
    L14:
        r7 = null;
        goto L15
    L5:
        r6 = null;
        goto L6
    }

    public /* synthetic */ PinCommentPSHighlightView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
