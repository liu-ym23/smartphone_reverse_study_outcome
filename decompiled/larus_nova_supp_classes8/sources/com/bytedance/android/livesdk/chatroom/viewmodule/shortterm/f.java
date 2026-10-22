package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.core.activity.ActivityHybridMonitor;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.b5;
import com.bytedance.android.live.core.setting.d5;
import com.bytedance.android.live.core.setting.p0;
import com.bytedance.android.live.core.setting.y1;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.chatroom.utils.t;
import com.bytedance.android.livesdk.chatroom.view.CommonIconEntryView;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.s7;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.sti.framework.IIconModel;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class f extends com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a<Integer> {
    public static final /* synthetic */ int s = 0;
    public vo1.i e;
    public com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a f;
    public CommonIconTemplate g;
    public TextView h;
    public c i;
    public t j;
    public com.bytedance.android.livesdk.chatroom.monitor.f k;
    public BubbleComponent l;
    public int m;
    public int n;
    public long o;
    public final Boolean p;
    public com.bytedance.android.live.base.model.n q;
    public final DataCenter r;

    public static final class a {
    }

    public interface b {
        void b();

        void c(vo1.i r1);

        void onLoadSuccess();
    }

    public interface c {
        void a(f r1);
    }

    public static final class d implements b {
        public final /* synthetic */ f a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public static final class a implements View.OnTouchListener {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View r7, MotionEvent r8) {
                if (r8.getAction() != 0) goto L34;
                t r9 = this.a.a.j;
                if (r9 == null) goto L7;
                int r0 = t.e;
                r9.c("clicked hybrid view", null);
            L7:
                com.bytedance.android.live.base.model.n r10 = this.a.a.q;
                List<Integer> r1 = n.a;
                if (r10 == null) goto L15;
                com.bytedance.android.live.base.model.q r2 = r10.shortTouchInfo;
                if (r2 == null) goto L15;
                int r11 = r10.type;
                if (r2.animationType != 2) goto L15;
                ((ArrayList) n.b).add(Integer.valueOf(r11));
            L15:
                this.a.a.performClick();
                int r12 = com.bytedance.android.livesdk.chatroom.utils.a.a;
                int r13 = ActivityMonitor.ActivityStatusCode.SUCCESS.getCode();
                f r3 = this.a.a;
                vo1.i r4 = r3.e;
                ActivityHybridMonitor.ContainerType r5 = ActivityHybridMonitor.ContainerType.WEB;
                Integer r6 = Integer.valueOf(((com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a) r3).d);
                String r14 = String.valueOf(this.a.a.o);
                String r15 = this.a.b;
                if (ActivityMonitor.a() == false) goto L35;
                JSONObject r16 = new JSONObject();
                r16.put("url", r15);
                r16.put("room_id", r14);
                r16.put("biz_id", r6);
                r16.put("msg", "performClick");
                JSONObject r17 = new JSONObject();
                r17.put("status_code", r13);
                if (r5 == null) goto L20;
                String r18 = r5.getType();
            L21:
                r17.put("category_1", r18);
                com.bytedance.android.livesdk.log.filter.o r19 = j0.l().c(x.class);
                if (r19 == null) goto L27;
                Map r20 = r19.getMap();
                if (r20 == null) goto L27;
                String r21 = (String) r20.get("enter_from_merge");
                if (r21 == null) goto L27;
            L29:
                if (x40.e.a(r21) == false) goto L31;
                r17.put("enter_from_merge", r21);
            L31:
                ActivityMonitor.c("ttlive_activity_short_touch_container_click", r17, null, r16);
                return false;
            L27:
                r21 = "";
                goto L29
            L20:
                r18 = null;
                goto L21
            L35:
                return false;
            L34:
                return false;
            }
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f.b
        public final void b() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f.b
        public final void onLoadSuccess() {
            f r0 = this.a;
            com.bytedance.android.live.base.model.n r1 = r0.q;
            Intrinsics.checkNotNullParameter(r1, "info");
            JSONObject r2 = new JSONObject();
            r2.put("type", "init");
            r2.put("data", r0.m(r1));
            vo1.i r3 = r0.e;
            if (r3 == null) goto L5;
            r3.sendJsEvent("H5_shortTouchMessage", r2);
        L5:
            r0.h("init short touch info", r2);
            t r4 = this.a.j;
            if (r4 == null) goto L8;
            r4.c("onLoadSuccess", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("url", this.b)}));
        L8:
            int r5 = com.bytedance.android.livesdk.chatroom.utils.a.a;
            int r6 = ActivityMonitor.ActivityStatusCode.SUCCESS.getCode();
            f r7 = this.a;
            vo1.i r8 = r7.e;
            ActivityHybridMonitor.ContainerType r9 = ActivityHybridMonitor.ContainerType.WEB;
            int r10 = ((com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a) r7).d;
            String r11 = String.valueOf(r7.o);
            String r12 = this.b;
            r r13 = z51.a.d(this.a.a());
            if (r13 == null) goto L17;
            com.bytedance.live.datacontext.m r14 = r13.C1();
            if (r14 == null) goto L17;
            StringBuilder r15 = new StringBuilder();
            Iterator r16 = ((Map) r14.getValue()).entrySet().iterator();
        L14:
            if (r16.hasNext() == false) goto L16;
            Map.Entry r17 = (Map.Entry) r16.next();
            StringsKt.append(r15, new String[]{(String) r17.getKey(), (String) r17.getValue()});
            goto L14
        L16:
            String r18 = r15.toString();
        L18:
            com.bytedance.android.livesdk.chatroom.utils.a.b(r6, "onLoadSuccess", r9, "1", r10, r11, r12, r18, System.currentTimeMillis() - this.c);
            return;
        L17:
            r18 = null;
            goto L18
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f.b
        public final void c(vo1.i r5) {
            Intrinsics.checkNotNullParameter(r5, "component");
            vo1.i r0 = this.a.e;
            IHybridComponent.HybridType r1 = null;
            if (r0 == null) goto L10;
            View r2 = r0.c();
            if (r2 == null) goto L10;
            CommonIconTemplate r3 = this.a.g;
            if (r3 == null) goto L9;
            r3.removeView(r2);
        L9:
            r2.setOnTouchListener(null);
        L10:
            vo1.i r4 = this.a.e;
            if (r4 == null) goto L13;
            r4.release();
        L13:
            this.a.e = r5;
            if (r5 == null) goto L34;
            View r6 = r5.c();
            if (r6 == null) goto L34;
            r6.setOnTouchListener(new a(this));
            if (((Boolean) b5.a.getValue()).booleanValue() == true) goto L20;
        L31:
            r6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            CommonIconTemplate r7 = this.a.g;
            if (r7 == null) goto L34;
            r7.addView(r6, 0);
            goto L34
        L20:
            if (((List) d5.a.getValue()).contains(String.valueOf(((com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a) this.a).d)) == true) goto L31;
            f r8 = this.a;
            com.bytedance.android.live.base.model.q r9 = r8.q.shortTouchInfo;
            if (r9 == null) goto L25;
            String r10 = r9.accessibleName;
            if (r10 == null) goto L25;
        L26:
            vo1.i r11 = r8.e;
            if (r11 == null) goto L29;
            View r12 = r11.g();
        L30:
            r3.c(r12, r10, true);
            goto L31
        L29:
            r12 = null;
        L25:
            r10 = "短触";
        L34:
            f r13 = this.a;
            TextView r14 = r13.h;
            if (r14 == null) goto L44;
            vo1.i r15 = r13.e;
            if (r15 == null) goto L40;
            r1 = r15.hybridType();
        L40:
            if (r1 != IHybridComponent.HybridType.LYNX) goto L42;
            String r16 = "lynx";
        L43:
            r14.setText(r16);
            goto L44
        L42:
            r16 = "h5";
        L44:
            this.a.i();
        }

        public d(f r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ f a;

        public e(f r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new wo1.d(this.a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f$f, reason: collision with other inner class name */
    public static final class C0056f implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ f a;

        public C0056f(f r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new wo1.e(this.a);
        }
    }

    static {
    }

    public final void onClick() {
    }

    public final IIconModel.EntryView getBigCardEntryViewForState() {
        if (n.a(this.q) == true) goto L8;
        t r1 = this.j;
        if (r1 == null) goto L7;
        int r3 = t.e;
        r1.c("no need show animation", null);
    L7:
        return null;
    L8:
        int r2 = q.a;
        com.bytedance.android.live.base.model.o r4 = this.q.shortTouchBigCard;
        if (r4 != null) goto L11;
    L10:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L27;
        t r6 = this.j;
        if (r6 == null) goto L24;
        int r7 = t.e;
        r6.c("use dynamic big card", null);
    L24:
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a r8 = new com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a(getContext(), this.q, this.r);
        this.f = r8;
        CommonIconEntryView r9 = r8.a();
        if (r9 != null) goto L30;
        return null;
    L30:
        return new IIconModel.EntryView(r9, this.q.shortTouchBigCard.duration + 500, false, 4, null);
    L27:
        CommonIconEntryView r14 = new CommonIconEntryView(getContext(), null, 6, 0);
        com.bytedance.android.live.base.model.q r10 = this.q.shortTouchInfo;
        r14.a(r10.imageUrl, r10.imgLayers);
        return new IIconModel.EntryView(r14, 0, false, 6, null);
    L11:
        String r11 = r4.bigCardUrl;
        r5 = true;
        if (r11 != null) goto L14;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == false) goto L20;
    L14:
        if (r11.length() == 0) goto L17;
        r12 = false;
        goto L18
    }

    public final long getDynamicPriorityShortTouch() {
        return this.q.dynamicPriority;
    }

    public final String getIconDesc() {
        String r0 = this.q.iconDesc;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void i() {
        vo1.i r0 = this.e;
        if (r0 == null) goto L5;
        r0.registerMethod("changeShortTouchSize", new e(this));
    L5:
        vo1.i r1 = this.e;
        if (r1 == null) goto L9;
        r1.registerMethod("changeSTTempState", new C0056f(this));
        return;
    }

    public final boolean isEnhancedStyleShortTouch() {
        if (this.q.enhancedTouch == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void onCreate() {
        c r0 = this.i;
        if (r0 == null) goto L5;
        r0.a(this);
    L5:
        this.j = new t("a100.a100.a113.a100", "CommonIconModel");
        DataCenter r1 = this.r;
        com.bytedance.android.livesdk.chatroom.monitor.f r2 = null;
        if (r1 == null) goto L10;
        IRoom r3 = (IRoom) r1.get("data_room", null);
        if (r3 == null) goto L10;
        long r4 = r3.getRoomId();
    L11:
        this.o = r4;
        int r5 = com.bytedance.android.livesdk.chatroom.monitor.a.a;
        if (((Boolean) LiveInfraSettingKeys.LIVE_ACTIVIY_TIME_MONITOR_SWITCH.getValue()).booleanValue() == false) goto L14;
        r2 = new com.bytedance.android.livesdk.chatroom.monitor.f(r4, 2);
    L14:
        this.k = r2;
        if (r2 == null) goto L18;
        r2.d("ST_ICONMODEL_ONCREATE");
        return;
    L18:
        return;
    L10:
        r4 = 0;
        goto L11
    }

    public final void onDestroy() {
        vo1.i r0 = this.e;
        if (r0 == null) goto L13;
        View r1 = r0.c();
        if (r1 == null) goto L13;
        ViewParent r2 = r1.getParent();
        if ((r2 instanceof ViewGroup) == true) goto L9;
        r2 = null;
    L9:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L12;
        r3.removeView(r1);
    L12:
        r1.setOnTouchListener(null);
    L13:
        vo1.i r4 = this.e;
        if (r4 == null) goto L16;
        r4.release();
    L16:
        this.e = null;
        this.g = null;
        this.h = null;
        super/*com.bytedance.android.livesdkapi.sti.framework.AbsIconModel*/.onDestroy();
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a r5 = this.f;
        if (r5 == null) goto L33;
        vo1.i r6 = r5.b;
        if (r6 == null) goto L29;
        View r7 = r6.c();
        if (r7 == null) goto L29;
        ViewParent r8 = r7.getParent();
        if ((r8 instanceof ViewGroup) == true) goto L25;
        r8 = null;
    L25:
        ViewGroup r9 = (ViewGroup) r8;
        if (r9 == null) goto L28;
        r9.removeView(r7);
    L28:
        r7.setOnTouchListener(null);
    L29:
        vo1.i r10 = r5.b;
        if (r10 == null) goto L32;
        r10.release();
    L32:
        r5.b = null;
    L33:
        BubbleComponent r11 = this.l;
        if (r11 == null) goto L39;
        com.bytedance.android.livesdk.chatroom.view.k r12 = r11.b;
        if (r12 == null) goto L40;
        r12.b();
        return;
    L40:
        return;
    }

    public final void onHideTempState() {
        if (this.e != null) goto L6;
        ALogger.i("CommonIconModel", "id:" + this.q.type + ",onHideTempState common icon modle is recycled");
        return;
    L6:
        JSONObject r0 = new JSONObject();
        r0.put("type", "hide");
        r0.put("strategy", m(this.q));
        vo1.i r1 = this.e;
        if (r1 == null) goto L9;
        r1.sendJsEvent("hybrid_tempShortTouch", r0);
    L9:
        super/*com.bytedance.android.livesdkapi.sti.framework.AbsIconModel*/.onHideTempState();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final CommonIconTemplate d() {
        long r0 = System.currentTimeMillis();
        com.bytedance.android.livesdk.chatroom.monitor.f r2 = this.k;
        if (r2 == null) goto L5;
        r2.d("GET_ICON_VIEW");
    L5:
        IHybridComponent.HybridType r5 = null;
        CommonIconTemplate r3 = new CommonIconTemplate(getContext(), null, 6, 0);
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Unit r4 = Unit.INSTANCE;
        this.g = r3;
        if (v.a() == false) goto L17;
        TextView r6 = new TextView(getContext());
        vo1.i r7 = this.e;
        if (r7 == null) goto L11;
        r5 = r7.hybridType();
    L11:
        if (r5 != IHybridComponent.HybridType.LYNX) goto L13;
        String r8 = "lynx";
    L14:
        r6.setText(r8);
        r6.setBackgroundColor(0);
        r6.setTextColor(-1);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2);
        r9.gravity = 8388661;
        r6.setLayoutParams(r9);
        this.h = r6;
        CommonIconTemplate r10 = this.g;
        if (r10 == null) goto L17;
        r10.addView(r6);
        goto L17
    L13:
        r8 = "h5";
    L17:
        String r11 = e(this.q.shortTouchInfo.loadUrl);
        String r12 = e(this.q.shortTouchInfo.fallbackUrl);
        g(this.q.shortTouchInfo.containerType, r11, r12, new d(this, r11, r0));
        return this.g;
    }

    public final void j() {
        IconTemplate r0 = getCurrentView();
        if (r0 == null) goto L10;
        final CommonIconTemplate r1 = (CommonIconTemplate) r0;
        Animator r2 = r1.a;
        if (r2 == null) goto L7;
        r2.end();
        r1.a = null;
    L7:
        final ObjectAnimator r3 = ObjectAnimator.ofFloat(r1, "rotation", Arrays.copyOf(new float[]{0.0f, 15.0f, -15.0f, 15.0f, -15.0f, 15.0f, -15.0f, 0.0f}, 8)).setDuration(700);
        final ObjectAnimator r4 = r3.clone();
        AnimatorSet r5 = new AnimatorSet();
        r5.play(r3);
        r5.play(r4).after(1000);
        com.bytedance.android.live.core.utils.h.a(r5, new CommonIconTemplate$shake$$inlined$apply$lambda$1(r1, r3, r4));
        r5.start();
        Unit r6 = Unit.INSTANCE;
        r1.a = r5;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.CommonIconTemplate");
    }

    public final void onAppear() {
        super/*com.bytedance.android.livesdkapi.sti.framework.AbsIconModel*/.onAppear();
        vo1.i r0 = this.e;
        if (r0 == null) goto L5;
        r0.sendJsEvent("hybird_shortTouch_appear", new JSONObject());
    L5:
        CommonIconTemplate r5 = this.g;
        if (r5 == null) goto L14;
        BubbleComponent r1 = this.l;
        if (r1 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.view.k r2 = r1.b;
        if (r2 == null) goto L12;
        r2.b();
    L12:
        Context r4 = getContext();
        com.bytedance.android.live.base.model.n r3 = this.q;
        BubbleComponent r6 = new BubbleComponent(r4, r5, r3.bubbleParams, r3.type, r3.timeStamp, this.r);
        this.l = r6;
        r6.a();
        return;
    }

    public final void onPause() {
        super/*com.bytedance.android.livesdkapi.sti.framework.AbsIconModel*/.onPause();
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a r0 = this.f;
        if (r0 == null) goto L5;
        r0.onPause();
    L5:
        ALogger.d("CommonIconModel", "on pause");
        l(false);
    }

    public final void onResume() {
        super/*com.bytedance.android.livesdkapi.sti.framework.AbsIconModel*/.onResume();
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a r0 = this.f;
        if (r0 == null) goto L5;
        r0.onResume();
    L5:
        ALogger.d("CommonIconModel", "on resume");
        l(true);
    }

    public final int getIconHeight() {
        return this.n;
    }

    public final int getIconWidth() {
        return this.m;
    }

    public final void c(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "function");
        if (((Boolean) y1.a.getValue()).booleanValue() == false) goto L6;
        g r0 = new g(r2);
        i0.i(c50.b.b(this.r), r0);
        return;
    L6:
        r2.invoke();
    }

    public final String e(String r5) {
        String r0 = "";
        if (r5 != null) goto L5;
        return "";
    L5:
        IRoom r1 = (IRoom) this.r.get("data_room", null);
        Uri.Builder r6 = UriProtector.parse(r5).buildUpon().appendQueryParameter("request_page", "top").appendQueryParameter("enter_from_merge", k1.c()).appendQueryParameter("enter_method", k1.d()).appendQueryParameter("action_type", k1.b());
        if (r1 == null) goto L9;
        String r2 = r1.getRequestId();
        if (r2 == null) goto L9;
    L10:
        Uri.Builder r7 = r6.appendQueryParameter("request_id", r2);
        if (r1 == null) goto L14;
        String r3 = r1.getIdStr();
        if (r3 == null) goto L14;
    L15:
        Uri.Builder r8 = r7.appendQueryParameter("room_id", r3);
        if (r1 == null) goto L21;
        IBaseUser r4 = r1.getOwner();
        if (r4 == null) goto L21;
        String r9 = r4.getIdString();
        if (r9 == null) goto L21;
    L22:
        Uri.Builder r10 = r8.appendQueryParameter("anchor_id", r9);
        String r11 = com.bytedance.android.livesdk.c.a().n();
        if (r11 == null) goto L27;
        r0 = r11;
    L27:
        return r10.appendQueryParameter("user_id", r0).appendQueryParameter("mix_container_bid", "live_short_touch").toString();
    L21:
        r9 = "";
    L14:
        r3 = "";
    L9:
        r2 = "";
        goto L10
    }

    public CommonIconTemplate f(int r1) {
        if (r1 == 0) goto L4;
        return null;
    L4:
        return d();
    }

    public /* bridge */ /* synthetic */ IconTemplate getViewForState(Object r1) {
        return f(((Number) r1).intValue());
    }

    public void k(com.bytedance.android.live.base.model.n r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        JSONObject r0 = new JSONObject();
        r0.put("type", "refresh");
        r0.put("data", m(r4));
        vo1.i r5 = this.e;
        if (r5 == null) goto L5;
        r5.sendJsEvent("H5_shortTouchMessage", r0);
    L5:
        h("refresh short touch info", r0);
    }

    public final void l(boolean r3) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L6
        r0.put("visible", r3);     // Catch: JSONException -> L6
        vo1.i r4 = this.e;     // Catch: JSONException -> L6
        if (r4 == null) goto L11;
        r4.sendJsEvent("H5_visibilityChange", r0);     // Catch: JSONException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public final JSONObject m(com.bytedance.android.live.base.model.n r7) {
        JSONObject r0 = new JSONObject();
        r0.put("type", r7.type);
        r0.put("priority", r7.priority);
        r0.put("min_webcast_sdk_version", r7.minSdkVersion);
        r0.put("current_time", String.valueOf(p6.b()));
        r0.put("short_touch_type", r7.showType);
        Object r2 = null;
        if (r7.shortTouchInfo == null) goto L51;
        JSONObject r1 = new JSONObject();
        com.bytedance.android.live.base.model.q r3 = r7.shortTouchInfo;
        if (r3 == null) goto L7;
        String r4 = r3.loadUrl;
    L8:
        r1.put("short_touch_url", r4);
        com.bytedance.android.live.base.model.q r5 = r7.shortTouchInfo;
        if (r5 == null) goto L11;
        String r6 = r5.fallbackUrl;
    L12:
        r1.put("short_touch_fallback_url", r6);
        com.bytedance.android.live.base.model.q r8 = r7.shortTouchInfo;
        if (r8 == null) goto L15;
        Integer r9 = Integer.valueOf(r8.containerType);
    L16:
        r1.put("container_type", r9);
        com.bytedance.android.live.base.model.q r10 = r7.shortTouchInfo;
        if (r10 == null) goto L19;
        Integer r11 = Integer.valueOf(r10.width);
    L20:
        r1.put("width", r11);
        com.bytedance.android.live.base.model.q r12 = r7.shortTouchInfo;
        if (r12 == null) goto L23;
        Integer r13 = Integer.valueOf(r12.height);
    L24:
        r1.put("height", r13);
        com.bytedance.android.live.base.model.q r14 = r7.shortTouchInfo;
        if (r14 == null) goto L27;
        String r15 = r14.imageUrl;
    L28:
        r1.put("img_url", r15);
        com.bytedance.android.live.base.model.q r16 = r7.shortTouchInfo;
        if (r16 == null) goto L31;
        String r17 = r16.jumpSchema;
    L32:
        r1.put("jump_schema", r17);
        com.bytedance.android.live.base.model.q r18 = r7.shortTouchInfo;
        if (r18 == null) goto L35;
        Integer r19 = Integer.valueOf(r18.showAnimation);
    L36:
        r1.put("show_animation", r19);
        com.bytedance.android.live.base.model.q r20 = r7.shortTouchInfo;
        if (r20 == null) goto L39;
        Integer r21 = Integer.valueOf(r20.animationType);
    L40:
        r1.put("animation_type", r21);
        com.bytedance.android.live.base.model.q r22 = r7.shortTouchInfo;
        if (r22 == null) goto L43;
        List r23 = r22.businessList;
    L44:
        if (r23 == null) goto L50;
        JSONArray r24 = new JSONArray();
        com.bytedance.android.live.base.model.q r25 = r7.shortTouchInfo;
        Intrinsics.checkNotNull(r25);
        Iterator r26 = r25.businessList.iterator();
    L47:
        if (r26.hasNext() == false) goto L49;
        r24.put((String) r26.next());
        goto L47
    L49:
        Unit r27 = Unit.INSTANCE;
        r1.put("sub_item_list", r24);
    L50:
        Unit r28 = Unit.INSTANCE;
        r0.put("short_touch_info", r1);
        goto L51
    L43:
        r23 = null;
        goto L44
    L39:
        r21 = null;
        goto L40
    L35:
        r19 = null;
        goto L36
    L31:
        r17 = null;
        goto L32
    L27:
        r15 = null;
        goto L28
    L23:
        r13 = null;
        goto L24
    L19:
        r11 = null;
        goto L20
    L15:
        r9 = null;
        goto L16
    L11:
        r6 = null;
        goto L12
    L7:
        r4 = null;
    L51:
        com.bytedance.android.live.base.model.o r29 = r7.shortTouchBigCard;
        if (r29 == null) goto L54;
        int r30 = q.a;
        Intrinsics.checkNotNull(r29);
        r0.put("short_touch_big_card", q.a(r29));
    L54:
        Object r31 = r7.payload;
        if (r31 == null) goto L57;
        r0.put("container_payload", r31);
    L57:
        String r32 = (String) this.r.get("data_pangle_scheme_params", "");
        if (r32 != null) goto L60;
    L67:
        return r0;
    L60:
        if (r32.length() <= 0) goto L62;
        boolean r33 = true;
    L63:
        if (r33 == false) goto L65;
        r2 = r32;
    L65:
        if (r2 == null) goto L67;
        r0.put("extra_pangle_params", r2);
        goto L67
    L62:
        r33 = false;
        goto L63
    }

    public final Map<String, Object> n(com.bytedance.android.live.base.model.n r4) {
        int r0 = q.a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r4, "$this$toJSONObject");     // Catch: Throwable -> L4
        JSONObject r5 = tv5.a.b(r4);     // Catch: Throwable -> L4
        r5.put("current_time", String.valueOf(p6.b()));     // Catch: Throwable -> L4
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L4
        return q.c(r5);
    L4:
        th = move-exception;
        ALogger.e("CommonIconModel", th);
        return null;
    }

    public final void onShowTempState(int r4) {
        if (this.e != null) goto L6;
        ALogger.i("CommonIconModel", "id:" + this.q.type + ",onShowTempState common icon modle is recycled");
        return;
    L6:
        JSONObject r0 = new JSONObject();
        r0.put("type", "show");
        r0.put("strategy", r4);
        vo1.i r1 = this.e;
        if (r1 == null) goto L9;
        r1.sendJsEvent("hybrid_tempShortTouch", r0);
    L9:
        super/*com.bytedance.android.livesdkapi.sti.framework.AbsIconModel*/.onShowTempState(r4);
    }

    public final void setIconHeight(int r1) {
        this.n = r1;
    }

    public final void setIconWidth(int r1) {
        this.m = r1;
    }

    public final IIconModel.EntryView getEntryViewForState(Object r21, Object r22) {
        Integer r2 = (Integer) r22;
        if (((Number) r21).intValue() == 0) goto L6;
        return null;
    L6:
        if (n.a(this.q) == true) goto L10;
        t r1 = this.j;
        if (r1 == null) goto L31;
        int r3 = t.e;
        r1.c("no need show animation", null);
        return null;
    L31:
        return null;
    L10:
        int r4 = q.a;
        com.bytedance.android.live.base.model.o r5 = this.q.shortTouchBigCard;
        if (r5 != null) goto L13;
    L12:
        boolean r6 = false;
    L22:
        if (r6 == false) goto L29;
        t r7 = this.j;
        if (r7 == null) goto L26;
        int r8 = t.e;
        r7.c("use dynamic big card", null);
    L26:
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a r9 = new com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a(getContext(), this.q, this.r);
        this.f = r9;
        CommonIconEntryView r10 = r9.a();
        if (r10 != null) goto L34;
        return null;
    L34:
        return new IIconModel.EntryView(r10, this.q.shortTouchBigCard.duration + 500, false, 4, null);
    L29:
        CommonIconEntryView r14 = new CommonIconEntryView(getContext(), null, 6, 0);
        com.bytedance.android.live.base.model.q r11 = this.q.shortTouchInfo;
        r14.a(r11.imageUrl, r11.imgLayers);
        return new IIconModel.EntryView(r14, 0, false, 6, null);
    L13:
        String r12 = r5.bigCardUrl;
        r6 = true;
        if (r12 != null) goto L16;
    L19:
        boolean r13 = true;
    L20:
        if (r13 == false) goto L22;
    L16:
        if (r12.length() == 0) goto L19;
        r13 = false;
        goto L20
    }

    public final void h(String r5, JSONObject r6) {
        if (this.p.booleanValue() == true) goto L13;
        HashMap r0 = new HashMap();
        r0.put("event_name", r5);
        r0.put("event_info", r6.toString());
        b0.o().j("ttlive_short_touch", r0);
        return;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L6
        r2.put("event_name", r5);     // Catch: Throwable -> L6
        r2.put("event_info", r6);     // Catch: Throwable -> L6
        b0.o().k("ttlive_short_touch", r2);     // Catch: Throwable -> L6
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L15;
        r8.printStackTrace();
        return;
    L15:
        return;
    L6:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public f(com.bytedance.android.live.base.model.n r2, DataCenter r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(Integer.valueOf(r4), r2.type);
        this.q = r2;
        this.r = r3;
        com.bytedance.android.live.base.model.q r5 = r2.shortTouchInfo;
        int r6 = 0;
        if (r5 == null) goto L5;
        int r7 = UtilityKotlinExtentionsKt.i(r5.width);
    L6:
        this.m = r7;
        com.bytedance.android.live.base.model.q r8 = this.q.shortTouchInfo;
        if (r8 == null) goto L9;
        r6 = UtilityKotlinExtentionsKt.i(r8.height);
    L9:
        this.n = r6;
        this.p = (Boolean) s7.a.getValue();
        return;
    L5:
        r7 = 0;
        goto L6
    }

    public static final void b(f r4, String r5, b r6) {
        r4.getClass();
        int r0 = vo1.e.a;
        vo1.a r1 = new vo1.a();
        Context r2 = r4.getContext();
        if (r2 == null) goto L10;
        vo1.i.a.a(r1, (Activity) r2, r5, new h(r6), new i(r4, r6));
        View r7 = r1.c();
        if (r7 == null) goto L7;
        r7.setBackgroundColor(0);
    L7:
        r1.loadUrl(r5);
        r6.c(r1);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public final void applyState(Object r1, Object r2, IconTemplate r3) {
        Integer r4 = (Integer) r1;
        if (((Number) r2).intValue() != 2) goto L6;
        requestDispose();
        return;
    }

    public void g(int r15, final String r16, final String r17, final d r18) {
        Intrinsics.checkNotNullParameter(r16, "url");
        Intrinsics.checkNotNullParameter(r17, "fallbackUrl");
        Intrinsics.checkNotNullParameter(r18, "callback");
        if (r15 == 1) goto L5;
        com.bytedance.android.livesdk.chatroom.monitor.f r0 = this.k;
        if (r0 == null) goto L48;
        r0.d("CREATE_HYBRID_VIEW_START");
    L48:
        com.bytedance.android.livesdk.chatroom.monitor.f r1 = this.k;
        if (r1 == null) goto L51;
        Intrinsics.checkNotNullParameter("H5", "containerType");
        r1.g = "H5";
    L51:
        int r2 = vo1.e.a;
        final vo1.a r11 = new vo1.a();
        Context r3 = getContext();
        if (r3 == null) goto L62;
        r11.d((Activity) r3, r16, new j(this, r18), new k(this, r18), "a100.a100.a113.a100");
        View r4 = r11.c();
        if (r4 == null) goto L56;
        r4.setBackgroundColor(0);
    L56:
        com.bytedance.android.livesdk.chatroom.monitor.f r5 = this.k;
        if (r5 == null) goto L59;
        r5.d("CREATE_HYBRID_VIEW_END");
    L59:
        c(new CommonIconModel$loadHybridComponent$$inlined$run$lambda$3(r11, this, r16, r18));
        return;
    L62:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L5:
        if (((Boolean) p0.a.getValue()).booleanValue() == false) goto L29;
        com.bytedance.android.livesdk.chatroom.monitor.f r12 = this.k;
        if (r12 == null) goto L9;
        r12.d("CREATE_HYBRID_VIEW_START");
    L9:
        com.bytedance.android.livesdk.chatroom.monitor.f r6 = this.k;
        if (r6 == null) goto L12;
        Intrinsics.checkNotNullParameter("LYNX", "containerType");
        r6.g = "LYNX";
    L12:
        jc1.k.n(IBaseBrowserService.class).initAnnie();
        int r7 = vo1.e.a;
        vo1.a r13 = new vo1.a();
        Context r8 = getContext();
        if (r8 == null) goto L28;
        Activity r9 = (Activity) r8;
        Map<String, ? extends Object> r10 = n(this.q);
        i2.c(UriProtector.parse(r16), "load_taro", 1);     // Catch: Exception -> L63
    L16:
        LynxThreadStrategy r14 = LynxThreadStrategy.ALL_ON_UI;
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r16, "url");
        Intrinsics.checkNotNullParameter(r14, "threadStrategy");
        Uri r19 = vo1.a.k(x6.a.d(r16), r16);
        r19.buildUpon().appendQueryParameter("lynx_thread", "0");
        IBaseBrowserService r20 = jc1.k.f(IBaseBrowserService.class);
        if (r20 == null) goto L19;
        com.bytedance.android.live.lynx.api.a r21 = r20.provideJsb2MethodFinder();
    L20:
        r13.e = r21;
        ra.a r22 = r13.i(r10, r19, r16);
        com.bytedance.android.anniex.assemble.a r23 = com.bytedance.android.anniex.assemble.a.a;
        AnnieXLynxView r24 = com.bytedance.android.anniex.api.c.a(r9, r22);
        r13.b = r24;
        com.bytedance.android.live.lynx.api.a r25 = r13.e;
        if (r25 == null) goto L23;
        r24.n(r25, 0);
    L23:
        com.bytedance.android.livesdk.chatroom.monitor.f r26 = this.k;
        if (r26 == null) goto L26;
        r26.d("CREATE_HYBRID_VIEW_END");
    L26:
        r18.c(r13);
        c(new CommonIconModel$loadHybridComponent$1(this, r17, r18, r16, r13));
        return;
    L19:
        r21 = null;
        goto L20
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L29:
        com.bytedance.android.livesdk.chatroom.monitor.f r27 = this.k;
        if (r27 == null) goto L32;
        r27.d("CREATE_HYBRID_VIEW_START");
    L32:
        com.bytedance.android.livesdk.chatroom.monitor.f r28 = this.k;
        if (r28 == null) goto L35;
        Intrinsics.checkNotNullParameter("LYNX", "containerType");
        r28.g = "LYNX";
    L35:
        int r29 = vo1.e.a;
        final vo1.a r30 = new vo1.a();
        Context r31 = getContext();
        if (r31 == null) goto L44;
        Activity r32 = (Activity) r31;
        i2.c(UriProtector.parse(r16), "load_taro", 1);     // Catch: Exception -> L64
    L39:
        r30.f(r32, r16, LynxThreadStrategy.ALL_ON_UI, new l(this, r17, r18, r16));
        com.bytedance.android.livesdk.chatroom.monitor.f r33 = this.k;
        if (r33 == null) goto L42;
        r33.d("CREATE_HYBRID_VIEW_END");
    L42:
        c(new CommonIconModel$loadHybridComponent$3(this, r30, r16, r18, r17));
        return;
    L44:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
}
