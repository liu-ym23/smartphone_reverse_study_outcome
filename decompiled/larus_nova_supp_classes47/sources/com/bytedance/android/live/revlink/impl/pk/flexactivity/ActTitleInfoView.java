package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.b4;
import com.bytedance.android.livesdk.link.model.p3;
import com.bytedance.android.livesdk.link.model.v9;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import cy0.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import mz0.i;
import mz0.m;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0012\u0010\u0016B#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0012\u0010\u0019J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActTitleInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "activityId", "Lcom/bytedance/android/livesdk/link/model/v9;", "titleArea", "", "update", "Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActTitleInfoView$b;", "e", "Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActTitleInfoView$b;", "getListener", "()Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActTitleInfoView$b;", "setListener", "(Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActTitleInfoView$b;)V", "listener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ActTitleInfoView extends ConstraintLayout {
    public static final /* synthetic */ int g = 0;
    public Map<Integer, View> a;
    public String b;
    public int c;
    public Disposable d;
    public b e;
    public final View f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ActTitleInfoView a;

        public a(ActTitleInfoView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ActTitleInfoView r5 = this.a;
            int r0 = r5.c;
            if (r0 < 0) goto L15;
            b r1 = r5.e;
            if (r1 == null) goto L8;
            r1.Kv(r5.b, r0);
        L8:
            HashMap r2 = new HashMap();
            r2.put("show_type", com.bytedance.android.live.revlink.impl.pk.flexactivity.b.a());
            r2.put("flex_activity_id", r5.b);
            r2.put("room_status", "live");
            com.bytedance.android.live.revlink.impl.control.dialog.e r6 = LinkRevPanelDataContext.Companion.a(IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal(), r5.b);
            if (r6 == null) goto L13;
            Map<String, String> r7 = r6.f;
            if (r7 == null) goto L13;
            r2.putAll(r7);
        L13:
            n r8 = new n();
            Map<String, String> r3 = r8.a;
            Intrinsics.checkNotNullParameter(r3, "map");
            Intrinsics.checkNotNullParameter(r2, "map");
            r3.putAll(r2);
            m r9 = new m();
            r9.b(LogCommon.PAGE_SOURCE_LOG);
            r9.b(LogCommon.ROOM);
            List<Object> r10 = r8.b;
            ArrayList r12 = (ArrayList) r10;
            r12.addAll(r9.a);
            cy0.e.a.getClass();
            j r13 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(i.class));
            Intrinsics.checkNotNull(r14);
            ((i) ((f80.a) r14)).w3("livesdk_flexible_match_click", r8.a, r8.b);
            return;
        }
    }

    public interface b {
        void Kv(String r1, int r2);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ActTitleInfoView a;
        public final /* synthetic */ String b;

        public c(ActTitleInfoView r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            ConstraintLayout r10 = this.a;
            String r0 = this.b;
            int r1 = ActTitleInfoView.g;
            r10.getClass();
            com.bytedance.android.live.revenue.core.util.j.a r2 = com.bytedance.android.live.revenue.core.util.j.C0;
            k r3 = (k) com.bytedance.android.live.revenue.core.util.f.d(r2.a(), k.class);
            String r4 = "";
            if (r3 == null) goto L10;
            IRoom r5 = r3.getRoom();
            if (r5 == null) goto L10;
            IBaseUser r6 = r5.getOwner();
            if (r6 == null) goto L10;
            String r7 = r6.getNickName();
            if (r7 == null) goto L10;
        L11:
            k r8 = (k) com.bytedance.android.live.revenue.core.util.f.d(r2.a(), k.class);
            boolean r12 = false;
            if (r8 == null) goto L23;
            IRoom r13 = r8.getRoom();
            if (r13 == null) goto L23;
            IBaseUser r14 = r13.getOwner();
            if (r14 == null) goto L23;
            py.k r15 = r14.getAvatarMedium();
            if (r15 == null) goto L23;
            List r16 = r15.getUrls();
            if (r16 == null) goto L23;
            String r17 = (String) ListProtector.get(r16, 0);
            if (r17 == null) goto L23;
        L24:
            HashMap r18 = new HashMap();
            k r19 = (k) com.bytedance.android.live.revenue.core.util.f.d(r2.a(), k.class);
            if (r19 == null) goto L34;
            IRoom r20 = r19.getRoom();
            if (r20 == null) goto L34;
            IBaseUser r22 = r20.getOwner();
            if (r22 == null) goto L34;
            String r23 = r22.getIdString();
            if (r23 == null) goto L34;
            r4 = r23;
        L34:
            r18.put("anchor_id", r4);
            r18.put("anchor_name", URLEncoder.encode(r7, "UTF-8"));
            r18.put("anchor_avatar_url", r17);
            String r24 = u.b(r0, r18);
            if (r24.length() <= 0) goto L37;
            r12 = true;
        L37:
            if (r12 == false) goto L39;
            String r25 = r24;
        L40:
            if (r25 == null) goto L43;
            vh6.c.b(pq2.a.class).s3(r10.getContext(), UriProtector.parse(r24));
            return;
        L43:
            return;
        L39:
            r25 = null;
        L23:
            r17 = "";
        L10:
            r7 = "";
            goto L11
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ long a;

        public d(long r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            long r0 = ((Number) r5).longValue();
            return Long.valueOf(this.a - r0);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ActTitleInfoView a;
        public final /* synthetic */ b4 b;

        public e(ActTitleInfoView r1, b4 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            if (r7.longValue() > 0) goto L7;
            ((TextView) this.a._$_findCachedViewById(2131390410)).setText(this.b.getEndText());
            UtilityKotlinExtentionsKt.t(this.a._$_findCachedViewById(2131390416));
            Disposable r8 = this.a.d;
            if (r8 == null) goto L9;
            r8.dispose();
            return;
        L9:
            return;
        L7:
            ActTitleInfoView r0 = this.a;
            long r1 = r7.longValue();
            int r9 = ActTitleInfoView.g;
            r0.R5(r1);
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final b getListener() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActTitleInfoView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedHashMap();
        this.b = "";
        this.c = -1;
        this.f = LayoutInflater.from(getContext()).inflate(2131566351, this);
        ((TextView) _$_findCachedViewById(2131391270)).setOnClickListener(new a(this));
    }

    public final void R5(long r7) {
        String r8 = com.bytedance.live.kmp.util.e.c((int) r7);
        SpannableString r9 = new SpannableString(r8);
        r9.setSpan(new com.bytedance.android.live.revlink.impl.pk.flexactivity.e(s1.h(2131107486), s1.h(2131108041)), 0, 2, 33);
        r9.setSpan(new com.bytedance.android.live.revlink.impl.pk.flexactivity.e(s1.h(2131107486), s1.h(2131108041)), 3, 5, 33);
        r9.setSpan(new com.bytedance.android.live.revlink.impl.pk.flexactivity.e(s1.h(2131107486), s1.h(2131108041)), 6, r8.length(), 33);
        ((TextView) _$_findCachedViewById(2131390410)).setText(r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setListener(b r1) {
        this.e = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActTitleInfoView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        this.b = "";
        this.c = -1;
        this.f = LayoutInflater.from(getContext()).inflate(2131566351, this);
        ((TextView) _$_findCachedViewById(2131391270)).setOnClickListener(new a(this));
    }

    public final void update(String r13, v9 r14) {
        Intrinsics.checkNotNullParameter(r13, "activityId");
        Intrinsics.checkNotNullParameter(r14, "titleArea");
        this.b = r13;
        p3 r15 = r14.getButton();
        int r0 = -1;
        if (r15 == null) goto L7;
        Long r16 = r15.getActType();
        if (r16 == null) goto L7;
        int r17 = (int) r16.longValue();
    L8:
        this.c = r17;
        TextView r18 = (TextView) _$_findCachedViewById(2131390917);
        String r1 = r14.getTitle();
        String r2 = "";
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        r18.setText(r1);
        TextView r19 = (TextView) _$_findCachedViewById(2131391524);
        String r3 = r14.getDesc();
        if (r3 == null) goto L15;
        r2 = r3;
    L15:
        r19.setText(r2);
        String r110 = r14.getRuleUrl();
        boolean r4 = false;
        if (r110 != null) goto L18;
    L21:
        boolean r5 = true;
    L23:
        if (r5 == true) goto L25;
        HSImageView r6 = _$_findCachedViewById(2131374713);
        UtilityKotlinExtentionsKt.w(r6);
        r6.setOnClickListener(new c(this, r110));
    L26:
        p3 r111 = r14.getButton();
        ConstraintLayout.LayoutParams r7 = null;
        if (r111 == null) goto L29;
        String r8 = r111.getText();
    L30:
        if (r8 != null) goto L32;
    L35:
        boolean r9 = true;
    L37:
        if (r9 == true) goto L81;
        TextView r10 = (TextView) _$_findCachedViewById(2131391270);
        UtilityKotlinExtentionsKt.w(r10);
        if (r111 == null) goto L41;
        String r12 = r111.getText();
    L42:
        r10.setText(r12);
        if (r111 == null) goto L45;
        String r20 = r111.getBgColor();
    L46:
        if (r20 != null) goto L48;
    L51:
        boolean r22 = true;
    L52:
        if (r22 == true) goto L60;
        ShapeDrawable r23 = new ShapeDrawable();
        Integer r24 = Integer.valueOf(Color.parseColor(r20));     // Catch: IllegalArgumentException -> L56
    L57:
        if (r24 == null) goto L59;
        r23.getPaint().setColor(r24.intValue());
    L59:
        float r25 = com.bytedance.android.live.revenue.common.i.a(4);
        r23.setShape(new RoundRectShape(new float[]{r25, r25, r25, r25, r25, r25, r25, r25}, null, null));
        Unit r26 = Unit.INSTANCE;
        r10.setBackground(r23);
    L61:
        if (r111 == null) goto L63;
        String r112 = r111.getTextColor();
    L64:
        if (r112 != null) goto L66;
    L69:
        boolean r27 = true;
    L70:
        if (r27 == false) goto L116;
        r10.setTextColor(-1);
    L74:
        r10.setClickable(true);
        ConstraintLayout.LayoutParams r113 = _$_findCachedViewById(2131369197).getLayoutParams();
        if ((r113 instanceof ConstraintLayout.LayoutParams) == false) goto L78;
        r7 = r113;
    L78:
        ConstraintLayout.LayoutParams r28 = r7;
        if (r28 == null) goto L89;
        ((ViewGroup.MarginLayoutParams) r28).topMargin = s1.f(80.0f);
    L89:
        Disposable r114 = this.d;
        if (r114 == null) goto L92;
        r114.dispose();
    L92:
        UtilityKotlinExtentionsKt.t(_$_findCachedViewById(2131378649));
        b4 r115 = r14.getCountDown();
        if (r115 == null) goto L118;
        Long r29 = r115.getTimestamp();
        if (r29 == null) goto L97;
        long r30 = r29.longValue();
    L99:
        if (r30 == 0) goto L119;
        UtilityKotlinExtentionsKt.w(_$_findCachedViewById(2131378649));
        String r116 = r115.getText();
        if (r116 != null) goto L103;
    L104:
        r4 = true;
    L106:
        if (r4 == true) goto L108;
        TextView r117 = (TextView) _$_findCachedViewById(2131390416);
        r117.setText(r115.getText());
        UtilityKotlinExtentionsKt.w(r117);
    L109:
        long r32 = WebcastRedirectException.UNKNOWN;
        long r33 = ((r30 * r32) - com.bytedance.live.kmp.util.e.b()) / r32;
        if (r33 <= 0) goto L120;
        R5(r33);
        this.d = du2.a.b(0, 1, TimeUnit.SECONDS).take(1 + r33).delay(0, TimeUnit.MILLISECONDS).map(new d(r33)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r115), f.a);
        return;
    L120:
        return;
    L108:
        UtilityKotlinExtentionsKt.t(_$_findCachedViewById(2131390416));
        goto L109
    L103:
        if (StringsKt.isBlank(r116) == false) goto L106;
    L119:
        return;
    L97:
        r30 = 0;
        goto L99
    L118:
        return;
    L116:
        r0 = Color.parseColor(r112);     // Catch: IllegalArgumentException -> L113
    L72:
        r10.setTextColor(r0);
        goto L74
    L66:
        if (StringsKt.isBlank(r112) == true) goto L69;
        r27 = false;
        goto L70
    L63:
        r112 = null;
    L56:
        r24 = null;
        goto L57
    L60:
        r10.setBackgroundResource(2131249467);
        goto L61
    L48:
        if (StringsKt.isBlank(r20) == true) goto L51;
        r22 = false;
        goto L52
    L45:
        r20 = null;
        goto L46
    L41:
        r12 = null;
        goto L42
    L81:
        ConstraintLayout.LayoutParams r118 = _$_findCachedViewById(2131369197).getLayoutParams();
        if ((r118 instanceof ConstraintLayout.LayoutParams) == false) goto L85;
        r7 = r118;
    L85:
        ConstraintLayout.LayoutParams r34 = r7;
        if (r34 == null) goto L88;
        ((ViewGroup.MarginLayoutParams) r34).topMargin = s1.f(20.0f);
    L88:
        UtilityKotlinExtentionsKt.t(_$_findCachedViewById(2131391270));
        goto L89
    L32:
        if (StringsKt.isBlank(r8) == true) goto L35;
        r9 = false;
        goto L37
    L29:
        r8 = null;
        goto L30
    L25:
        UtilityKotlinExtentionsKt.t(_$_findCachedViewById(2131374713));
        goto L26
    L18:
        if (StringsKt.isBlank(r110) == true) goto L21;
        r5 = false;
    L7:
        r17 = -1;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActTitleInfoView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.b = "";
        this.c = -1;
        this.f = LayoutInflater.from(getContext()).inflate(2131566351, this);
        ((TextView) _$_findCachedViewById(2131391270)).setOnClickListener(new a(this));
    }
}
