package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.keva.Keva;
import com.ivy.ivykit.api.plugin.IvyPluginService;
import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.GestureCardView;
import com.larus.im.bean.message.Message;
import com.larus.ivykit.plugin.TemplateInfo;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LynxBox extends xc8.h {
    public static final /* synthetic */ int M = 0;
    public Function3<? super View, ? super Fragment, ? super com.larus.bmhome.chat.api.v0, Unit> A;
    public Function0<Unit> B;
    public final List<Runnable> C;
    public final ImageView D;
    public final ImageView E;
    public GestureCardView F;
    public View.OnLongClickListener G;
    public com.larus.bmhome.chat.api.v0 H;
    public final String I;
    public final Lazy J;
    public final Lazy K;
    public final b1 L;
    public final TemplateInfo p;
    public final AttachReceiver q;
    public final Fragment r;
    public final e1 s;
    public final Message t;
    public final boolean u;
    public LynxShowState v;
    public kx7.b w;
    public View x;
    public Function0<Unit> y;
    public Function1<? super kx7.b, Unit> z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/LynxBox$LynxShowState;", "", "<init>", "(Ljava/lang/String;I)V", WcbRenderStatus.DEFAULT, "LOADING", "FAIL", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum LynxShowState extends Enum<LynxShowState> {
        public static final LynxShowState DEFAULT = null;
        public static final LynxShowState FAIL = null;
        public static final LynxShowState LOADING = null;
        public static final LynxShowState SUCCESS = null;
        public static final /* synthetic */ LynxShowState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LynxShowState> getEntries() {
            return b;
        }

        static {
            LynxShowState r0 = new LynxShowState(WcbRenderStatus.DEFAULT, 0);
            DEFAULT = r0;
            LynxShowState r1 = new LynxShowState("LOADING", 1);
            LOADING = r1;
            LynxShowState r3 = new LynxShowState("FAIL", 2);
            FAIL = r3;
            LynxShowState r5 = new LynxShowState("SUCCESS", 3);
            SUCCESS = r5;
            LynxShowState[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static LynxShowState[] values() {
            return (LynxShowState[]) a.clone();
        }

        public static LynxShowState valueOf(String r1) {
            return (LynxShowState) r27.a.a(LynxShowState.class, r1);
        }

        public LynxShowState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LynxShowState.values().length];
            r0[LynxShowState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LynxShowState.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LynxShowState.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    private final va8.p getChatListAbility() {
        return (va8.p) this.J.getValue();
    }

    private final va8.x getChatTraceAbility() {
        return (va8.x) this.K.getValue();
    }

    public final void x() {
        if (this.t == null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L17;
        com.larus.bmhome.chat.api.v0 r1 = this.H;
        if (r1 != null) goto L13;
        return;
    L13:
        Fragment r2 = getChatFragment();
        if (r2 != null) goto L16;
        return;
    L16:
        WidgetRenderDelegate.a.d(r2, r1);
        return;
    L17:
        kx7.b r3 = this.w;
        if (r3 == null) goto L22;
        r3.a();
        return;
    L22:
        return;
    L5:
        if (this.u == true) goto L8;
        r0 = false;
        goto L9
    }

    private final Fragment getChatFragment() {
        Fragment r0 = ei9.e.b(this);
        if (r0 != null) goto L10;
        va8.p r1 = getChatListAbility();
        if (r1 == null) goto L7;
        r0 = r1.me(this);
    L8:
        if (r0 != null) goto L10;
        r0 = this.r;
        goto L10
    L7:
        r0 = null;
    L10:
        if (r0 != null) goto L12;
        FLogger.a.e("LynxBox", "get chat fragment return null");
        com.larus.platform.service.g.a.ensureNotReachHere("LynxBox: get chat fragment return null");
    L12:
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.s.i == false) goto L6;
        x();
        return;
    }

    public final View getAppletLynxView() {
        return this.x;
    }

    public final Function3<View, Fragment, com.larus.bmhome.chat.api.v0, Unit> getAppletRenderFinishedCallBack() {
        return this.A;
    }

    public final LynxShowState getCurShowState() {
        return this.v;
    }

    public final e1 getLynxBoxConfig() {
        return this.s;
    }

    public final kx7.b getLynxPluginView() {
        return this.w;
    }

    public final Message getMessage() {
        return this.t;
    }

    public final Function0<Unit> getOnTimingSetupCallback() {
        return this.B;
    }

    public final String getRealTemplateUrl() {
        return this.I;
    }

    public final Function1<kx7.b, Unit> getRenderFinishedCallBack() {
        return this.z;
    }

    public final Function0<Unit> getRetryFetchLynxData() {
        return this.y;
    }

    public final TemplateInfo getTemplateInfo() {
        return this.p;
    }

    public final boolean getUseApplet() {
        return this.u;
    }

    public static final /* synthetic */ Fragment n(LynxBox r0) {
        return r0.getChatFragment();
    }

    public static final /* synthetic */ va8.x o(LynxBox r0) {
        return r0.getChatTraceAbility();
    }

    public static JSONObject u(HashMap r4) {
        JSONObject r0 = new JSONObject();
        Iterator r1 = r4.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r2 = (String) r1.next();
        Object r3 = r4.get(r2);
        if (r3 == null) goto L4;
        r0.put(r2, r3);
        goto L4
    L8:
        return r0;
    }

    public final void q(LynxShowState r2) {
        Intrinsics.checkNotNullParameter(r2, "showState");
        this.v = r2;
        int r3 = b.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        com.larus.utils.e1.x(this.D);
        com.larus.utils.e1.o(this.E);
        View r4 = this.x;
        if (r4 == null) goto L29;
        com.larus.utils.e1.o(r4);
    L29:
        kx7.b r5 = this.w;
        if (r5 == null) goto L39;
        BulletContainerView r6 = r5.c();
        if (r6 == null) goto L40;
        com.larus.utils.e1.o(r6);
        return;
    L40:
        return;
    L39:
        return;
    L5:
        if (r3 != 2) goto L7;
        com.larus.utils.e1.x(this.E);
        com.larus.utils.e1.o(this.D);
        View r7 = this.x;
        if (r7 == null) goto L21;
        com.larus.utils.e1.o(r7);
    L21:
        kx7.b r8 = this.w;
        if (r8 == null) goto L36;
        BulletContainerView r9 = r8.c();
        if (r9 == null) goto L37;
        com.larus.utils.e1.o(r9);
        return;
    L37:
        return;
    L36:
        return;
    L7:
        if (r3 != 3) goto L41;
        View r10 = this.x;
        if (r10 == null) goto L12;
        com.larus.utils.e1.x(r10);
    L12:
        kx7.b r11 = this.w;
        if (r11 == null) goto L17;
        BulletContainerView r12 = r11.c();
        if (r12 == null) goto L17;
        com.larus.utils.e1.x(r12);
    L17:
        com.larus.utils.e1.o(this.D);
        com.larus.utils.e1.o(this.E);
        return;
    }

    public final String r(String r11) {
        JSONObject r0 = new JSONObject();
        String r1 = this.s.j;
        if (r1 != null) goto L5;
        r1 = "unknown";
    L5:
        r0.put("applet_id", r1);
        r0.put("widget_id", this.s.h);
        String r2 = this.p.getMixtureCardId();
        if (r2 != null) goto L8;
    L20:
        r0.put("widget_data", r11);
        return r0.toString();
    L8:
        if (StringsKt.isBlank(r2) == true) goto L20;
        Message r3 = this.t;
        if (r3 == null) goto L16;
        String r4 = r3.getMessageId();
        if (r4 == null) goto L16;
        List r5 = StringsKt.split$default(r4, new String[]{"long_screenshot_"}, false, 0, 6, null);
        if (r5 == null) goto L16;
        int r6 = r5.size();
    L17:
        if (r6 <= 1) goto L19;
        r2 = r2 + '_' + r6;
    L19:
        r0.put("mixture_card_id", r2);
    L16:
        r6 = 1;
        goto L17
    }

    public final void setAppletLynxView(View r1) {
        this.x = r1;
    }

    public final void setAppletRenderFinishedCallBack(Function3<? super View, ? super Fragment, ? super com.larus.bmhome.chat.api.v0, Unit> r1) {
        this.A = r1;
    }

    public final void setCurShowState(LynxShowState r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.v = r2;
    }

    public final void setLynxPluginView(kx7.b r1) {
        this.w = r1;
    }

    public final void setOnTimingSetupCallback(Function0<Unit> r1) {
        this.B = r1;
    }

    public final void setRenderFinishedCallBack(Function1<? super kx7.b, Unit> r1) {
        this.z = r1;
    }

    public final void setRetryFetchLynxData(Function0<Unit> r1) {
        this.y = r1;
    }

    public final void t(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if (this.u == true) goto L5;
        return;
    L5:
        if (this.x != null) goto L24;
        int r0 = com.larus.utils.p0.a;
        JSONObject r1 = com.larus.utils.p0.b(this.s.g);
        JSONObject r2 = r1.optJSONObject("commonProps");
        if (r2 == null) goto L10;
        String r3 = r2.optString("messageId");
    L11:
        String r4 = "";
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        String r6 = this.p.getMixtureCardId();
        if (r6 == null) goto L18;
        r4 = r6;
    L18:
        String r7 = r1.optString("card_type");
        va8.x r8 = getChatTraceAbility();
        if (r8 == null) goto L21;
        Intrinsics.checkNotNull(r7);
        r8.Bq(r3, r7, r4);
    L21:
        s(r5, this.s);
        return;
    L10:
        r3 = null;
        goto L11
    }

    public final void w(final View.OnLongClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "onLongClickListener");
        this.G = r3;
        z19.j r0 = this.F;
        if (r0 == null) goto L6;
        r0.setOnLongClickListener(new u0(this, r3));
        return;
    }

    public final void s(Message r12, e1 r13) {
        Fragment r4 = getChatFragment();
        if (r4 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4), null, null, new LynxBox$initAppletLynxView$1(this, r13, r12, r4, null), 3, null);
    }

    public final void y(String r24, com.ivy.ivykit.api.plugin.d r25) {
        if (this.x == null) goto L24;
        String r3 = r24;
        JSONObject r2 = new JSONObject(r3);     // Catch: Throwable -> L19
        r2.put("containerWidth", r25.a);     // Catch: Throwable -> L19
        r2.put("log_data", u(r25.b));     // Catch: Throwable -> L19
        r2.put("commonProps", u(r25.c));     // Catch: Throwable -> L19
        String r1 = r2.toString();     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L19
    L11:
        com.larus.bmhome.chat.api.v0 r4 = this.H;
        if (r4 == null) goto L25;
        Fragment r5 = getChatFragment();
        if (r5 == null) goto L26;
        String r6 = r4.o;
        String r7 = r4.a;
        String r8 = r4.b;
        String r9 = r4.c;
        String r10 = r4.d;
        String r11 = r4.e;
        String r12 = r(r1);
        ic8.x r13 = r4.h;
        int r14 = r4.i;
        int r15 = r4.j;
        Map<String, String> r16 = r4.k;
        boolean r17 = r4.m;
        com.larus.bmhome.chat.api.v0 r18 = new com.larus.bmhome.chat.api.v0(r7, r8, r9, r10, r11, r12, null, r13, r14, r15, r16, r4.l, r17, false, r6, null, null, 106496);
        this.H = r18;
        WidgetRenderDelegate.a.e(r5, r18);
        return;
    L26:
        return;
    L25:
        return;
    L10:
        r1 = r3;
    L9:
        r3 = r24;
        goto L10
    }

    public final void z(final String r4, final String r5, final com.ivy.ivykit.api.plugin.d r6) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        Intrinsics.checkNotNullParameter(r5, "cardViewData");
        Intrinsics.checkNotNullParameter(r6, "pluginViewExtraData");
        Resources r0 = getResources();
        r6.a = (int) (getMaxWidth() / WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
        kx7.b r1 = this.w;
        if (r1 == null) goto L5;
        r1.b = r4;
        r1.d(r5, r6);
    L5:
        View r2 = this.x;
        if (this.u == false) goto L16;
        if (r2 != null) goto L16;
        List<Runnable> r3 = this.C;
        monitor-enter(r3);
        ((ArrayList) this.C).add(new t0(this, r4, r5, r6));     // Catch: Throwable -> L13
        monitor-exit(r3);
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        y(r5, r6);
    }

    public LynxBox(Context r16, int r17, TemplateInfo r18, AttachReceiver r19, Fragment r20, e1 r21, Message r22, boolean r23, int r24) {
        View r5 = null;
        if ((r24 & 16) == 0) goto L5;
        Fragment r4 = null;
    L7:
        if ((r24 & 32) == 0) goto L9;
        e1 r6 = new e1(null, 2047);
    L11:
        if ((r24 & 64) == 0) goto L13;
        Message r7 = null;
    L15:
        if ((r24 & 128) == 0) goto L19;
        if (r7 == null) goto L18;
        boolean r3 = true;
    L20:
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r18, "templateInfo");
        Intrinsics.checkNotNullParameter(r6, "lynxBoxConfig");
        super(r16);
        this.p = r18;
        this.q = r19;
        this.r = r4;
        this.s = r6;
        this.t = r7;
        this.u = r3;
        this.v = LynxShowState.DEFAULT;
        this.C = new ArrayList();
        ImageView r8 = new ImageView(r16);
        r8.setImageResource(2131242971);
        r8.setScaleType(ImageView.ScaleType.FIT_XY);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r8.setVisibility(8);
        this.D = r8;
        ImageView r13 = new ImageView(r16);
        r13.setImageResource(2131242972);
        r13.setScaleType(ImageView.ScaleType.FIT_XY);
        r13.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r13.setVisibility(8);
        r13.setOnClickListener(new v0(this));
        this.E = r13;
        this.J = LazyKt.lazy(new w0(this));
        this.K = LazyKt.lazy(new x0(this));
        this.L = new b1(this);
        setBoxType(r17);
        int r10 = r6.a;
        if (r10 == 0) goto L23;
        setMaxWidth(r10);
    L26:
        addView(r8);
        addView(r13);
        Keva r9 = pg9.i.a;
        String r11 = r18.getTemplateUrl();
        String r12 = "";
        if (r11 != null) goto L29;
        r11 = "";
    L29:
        String r14 = pg9.i.a(r11);
        if (r14.length() <= 0) goto L32;
        boolean r15 = true;
    L33:
        if (r15 == false) goto L88;
        this.I = r14;
        int r110 = com.larus.utils.p0.a;
        JSONObject r111 = com.larus.utils.p0.b(r6.g);
        JSONObject r112 = r111.optJSONObject("commonProps");
        if (r112 == null) goto L37;
        String r113 = r112.optString("messageId");
    L38:
        if (r113 != null) goto L40;
        r113 = "";
    L40:
        String r114 = r18.getMixtureCardId();
        if (r114 == null) goto L44;
        r12 = r114;
    L44:
        String r115 = r111.optString("card_type");
        if (r7 == null) goto L50;
        va8.x r1 = getChatTraceAbility();
        if (r1 == null) goto L49;
        Intrinsics.checkNotNull(r115);
        r1.Bq(r113, r115, r12);
    L49:
        s(r7, r6);
        return;
    L50:
        if (r3 == true) goto L90;
        Fragment r25 = getChatFragment();
        if (r25 == null) goto L58;
        LifecycleOwner r26 = r25.getViewLifecycleOwner();
        if (r26 == null) goto L58;
        Lifecycle r27 = r26.getLifecycle();
        if (r27 == null) goto L58;
        r27.addObserver(new AnonymousClass1(this));
    L58:
        va8.x r28 = getChatTraceAbility();
        if (r28 == null) goto L61;
        Intrinsics.checkNotNull(r115);
        r28.Bq(r113, r115, r12);
    L61:
        this.w = IvyPluginService.a.a(r16, r14, new z0(this), new a1(this, r113, r12, r115, r14), r6.g);
        if (r18.getCardType() != 1) goto L64;
    L67:
        float r29 = getResources().getDimension(v19.c.b(2130971546, null, 2131167462));
    L68:
        CardView r30 = new GestureCardView(r16, null, 6, 0);
        r30.setLayoutParams(new LinearLayout.LayoutParams(getMaxWidth(), -1));
        if (r6.b == true) goto L71;
        r30.setCardBackgroundColor(ContextCompat.getColor(r16, 2131102529));
    L71:
        r30.setRadius(r29);
        r30.setElevation(0.0f);
        if (r6.e == false) goto L77;
        pt8.a r31 = new pt8.a(r16, r29);
        kx7.b r32 = this.w;
        if (r32 == null) goto L76;
        r5 = r32.c();
    L76:
        r31.addView(r5, new ViewGroup.LayoutParams(getMaxWidth(), -1));
        r30.addView(r31, new ViewGroup.LayoutParams(-1, -1));
    L81:
        r30.setStrokeColor(ContextCompat.getColor(r16, 2131103162));
        r30.setStrokeWidth(r6.f ? 1 : 0);
        if (r18.getCardType() == 1) goto L84;
    L86:
        this.F = r30;
        addView(r30, new ViewGroup.LayoutParams(-1, -1));
        return;
    L84:
        if (r6.b == true) goto L86;
        View r2 = new View(r16);
        r2.setBackgroundResource(2131242973);
        r2.setLayoutParams(new LinearLayout.LayoutParams(getMaxWidth(), -1));
        r30.addView(r2, new FrameLayout.LayoutParams(-1, -1));
        goto L86
    L77:
        kx7.b r33 = this.w;
        if (r33 == null) goto L80;
        r5 = r33.c();
    L80:
        r30.addView(r5, new ViewGroup.LayoutParams(getMaxWidth(), -1));
        goto L81
    L64:
        if (r6.d == true) goto L67;
        r29 = 0.0f;
        goto L68
    L90:
        return;
    L37:
        r113 = null;
        goto L38
    L88:
        return;
    L32:
        r15 = false;
        goto L33
    L23:
        Lazy r116 = com.larus.bmhome.utils.z1.a;
        if (com.larus.bmhome.utils.z1.b(getBoxType(), getImmerseBgColor()) == false) goto L26;
        setMaxWidth(com.larus.bmhome.utils.z1.h(getBoxType(), getImmerseBgColor(), false, false, 28));
        goto L26
    L18:
        r3 = false;
        goto L20
    L19:
        r3 = r23;
        goto L20
    L13:
        r7 = r22;
        goto L15
    L9:
        r6 = r21;
        goto L11
    L5:
        r4 = r20;
        goto L7
    }
}
