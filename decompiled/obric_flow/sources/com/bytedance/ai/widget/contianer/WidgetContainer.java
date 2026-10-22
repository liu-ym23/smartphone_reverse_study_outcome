package com.bytedance.ai.widget.contianer;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.model.widgets.o;
import com.bytedance.ai.widget.UIContextStrategy;
import com.bytedance.keva.Keva;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;
import m1.i;
import org.json.JSONObject;
import w0.m;
import w2.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ai/widget/contianer/WidgetContainer;", "Lcom/bytedance/ai/widget/contianer/f;", "Landroidx/lifecycle/LifecycleOwner;", "com/bytedance/ai/widget/contianer/g", "LifecycleEvent", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetContainer.kt\ncom/bytedance/ai/widget/contianer/WidgetContainer\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1116:1\n216#2,2:1117\n1863#3,2:1119\n1863#3,2:1122\n1863#3,2:1124\n1863#3:1126\n1863#3,2:1127\n1864#3:1129\n1#4:1121\n*S KotlinDebug\n*F\n+ 1 WidgetContainer.kt\ncom/bytedance/ai/widget/contianer/WidgetContainer\n*L\n662#1:1117,2\n703#1:1119,2\n998#1:1122,2\n1073#1:1124,2\n1092#1:1126\n1093#1:1127,2\n1092#1:1129\n*E\n"})
public abstract class WidgetContainer extends f implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleRegistry f3019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f3020c;
    public final ArrayList d;
    public final String e;
    public h f;
    public q g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Keva f3021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.ai.utils.a f3022i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LifecycleEvent f3023j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3024k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i f3025l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.ai.widget.f f3026m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f3027n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConcurrentHashMap f3028o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f3029p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function1 f3030q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3031r;
    public boolean s;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/widget/contianer/WidgetContainer$LifecycleEvent;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum LifecycleEvent extends Enum<LifecycleEvent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LifecycleEvent f3032a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final LifecycleEvent f3033b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final LifecycleEvent f3034c = null;
        public static final LifecycleEvent d = null;
        public static final LifecycleEvent e = null;
        public static final /* synthetic */ LifecycleEvent[] f = null;

        static {
            LifecycleEvent r5 = new LifecycleEvent("ON_START", 0);
            f3032a = r5;
            LifecycleEvent r10 = new LifecycleEvent("ON_LOAD_START", 1);
            f3033b = r10;
            LifecycleEvent r11 = new LifecycleEvent("ON_LOAD_ERROR", 2);
            f3034c = r11;
            LifecycleEvent r12 = new LifecycleEvent("ON_LOAD_FINISHED", 3);
            d = r12;
            LifecycleEvent r13 = new LifecycleEvent("ON_DESTROY", 4);
            e = r13;
            LifecycleEvent[] r14 = {r5, r10, r11, r12, r13};
            f = r14;
            EnumEntriesKt.enumEntries(r14);
        }

        public LifecycleEvent(String r5, int r10) {
            super(r5, r10);
        }

        public static LifecycleEvent valueOf(String r5) {
            return (LifecycleEvent) Enum.valueOf(LifecycleEvent.class, r5);
        }

        public static LifecycleEvent[] values() {
            return (LifecycleEvent[]) f.clone();
        }
    }

    public WidgetContainer() {
        this.f3019b = new LifecycleRegistry(this);
        this.f3020c = new LinkedHashMap();
        this.d = new ArrayList();
        this.e = UUID.randomUUID().toString();
        this.f3021h = Keva.getRepo("WIDGET_HEIGHT");
        this.f3022i = new com.bytedance.ai.utils.a();
        this.f3027n = LazyKt.lazy(new com.bytedance.ai.resource.core.db.b(this, 1));
        AppletWidgetContainer r5 = (AppletWidgetContainer) this;
        UIContextStrategy[] r10 = UIContextStrategy.f2914a;
        this.f3028o = new ConcurrentHashMap();
        this.f3029p = "default_context_widget_bot_id";
        this.s = true;
    }

    @Override // w0.i
    public final void a(long r5, long r10) {
        StringBuilder r11 = dn.a.K(r5, "navigationStart:", " drawEnd:");
        r11.append(r10);
        r11.append(", duration:");
        r11.append(r10 - r5);
        String r12 = r11.toString();
        Intrinsics.checkNotNullParameter("WidgetContainer", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L6;
        r13.d("WidgetContainer", r12);
        return;
    }

    public final void c(double r10, double r11) {
        int r12 = (int) ((((float) r11) * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
        StringBuilder r13 = new StringBuilder("handleContentSizeChange: ");
        h r14 = this.f;
        if (r14 == null) goto L5;
        String r15 = r14.a();
    L6:
        r13.append(r15);
        r13.append(" widgetSavedHeight = 0, webContentHeight = ");
        r13.append(r12);
        String r16 = r13.toString();
        Intrinsics.checkNotNullParameter("WidgetContainer", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L9;
        r17.d("WidgetContainer", r16);
    L9:
        if (r12 <= 0) goto L21;
        StringBuilder r18 = new StringBuilder("handleContentSizeChange: ");
        h r19 = this.f;
        if (r19 == null) goto L13;
        String r110 = r19.a();
    L14:
        String r20 = ug.a.c(r18, r110, " immediate = false", "WidgetContainer");
        t0.d r111 = com.bytedance.ai.utils.c.f2846a;
        if (r111 == null) goto L17;
        r111.d("WidgetContainer", r20);
    L17:
        this.f3022i.a(Integer.valueOf(r12), new WidgetContainer$handleContentSizeChange$1(this, null));
        if (this.f3023j != LifecycleEvent.d) goto L22;
        BuildersKt.launch$default(h0.a(t2.b.d), null, null, new WidgetContainer$handleContentSizeChange$2(this, null), 3, null);
        return;
    L22:
        return;
    L13:
        r110 = null;
        goto L14
    L21:
        return;
    L5:
        r15 = null;
        goto L6
    }

    public abstract View d();

    @Override // m2.a
    public final m3.a d(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "groupId");
        if (r10 == false) goto L13;
        StringBuilder r11 = new StringBuilder("getViewModel state ");
        LifecycleRegistry r12 = this.f3019b;
        r11.append(r12.getCurrentState());
        String r13 = r11.toString();
        Intrinsics.checkNotNullParameter("WidgetContainer", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L8;
        r14.d("WidgetContainer", r13);
    L8:
        if (r12.getCurrentState() != Lifecycle.State.DESTROYED) goto L10;
        return null;
    L10:
        return av.i.d(this, r5);
    L13:
        LinkedHashMap r15 = this.f3020c;
        m3.a r16 = (m3.a) r15.get(r5);
        if (r16 != null) goto L17;
        o r17 = new o(r5, 1);
        r15.put(r5, r17);
        return r17;
    L17:
        return r16;
    }

    @Override // w0.e
    public final String g() {
        return this.e;
    }

    @Override // w0.e
    public final String getAppletId() {
        h r5 = this.f;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.f3047a;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f3019b;
    }

    @Override // com.bytedance.ai.widget.contianer.f
    public final boolean h() {
        Rect r5 = new Rect();
        LinearLayout r10 = ((AppletWidgetContainer) this).C;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.isAttachedToWindow() != true) goto L12;
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r10.getGlobalVisibleRect(r5) != true) goto L14;
        return true;
    L14:
        return false;
    L12:
        return false;
    }

    public final void i(LifecycleEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "lifecycleEvent");
        String r10 = this + " dispatchLifecycleEvent " + r5;
        Intrinsics.checkNotNullParameter("WidgetContainer", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.d("WidgetContainer", r10);
    L5:
        this.f3023j = r5;
        Iterator r12 = this.d.iterator();
    L7:
        if (r12.hasNext() == false) goto L31;
        m r13 = (m) r12.next();
        int r14 = r5.ordinal();
        if (r14 != 0) goto L11;
        r13.onStart();
        goto L7
    L11:
        if (r14 != 1) goto L13;
        r13.onPageStart();
        goto L7
    L13:
        if (r14 != 2) goto L15;
        r13.onPageError();
        goto L7
    L15:
        if (r14 != 3) goto L17;
        r13.onPageFinish();
        new Rect();
        if (this.f3024k == true) goto L27;
        if (this.s == false) goto L7;
        if (h() == false) goto L7;
    L27:
        m();
        goto L7
    L17:
        if (r14 != 4) goto L20;
        r13.onDestroy();
        goto L7
    L20:
        throw new NoWhenBranchMatchedException();
    }

    public final void j(String r15) {
        String r5 = "dispatchLifecycleEventToWeb " + this + " lifecycle ==> " + r15;
        Intrinsics.checkNotNullParameter("WidgetContainer", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L5;
        r10.d("WidgetContainer", r5);
    L5:
        i r11 = this.f3025l;
        if (r11 == null) goto L45;
        JsonObject r12 = new JsonObject();
        Pair r13 = TuplesKt.to("viewId", this.e);
        h r14 = this.f;
        if (r14 == null) goto L11;
        String r16 = r14.f3048b;
        if (r16 == null) goto L11;
    L12:
        Pair r17 = TuplesKt.to("pageName", r16);
        h r18 = this.f;
        if (r18 == null) goto L16;
        String r19 = r18.d;
        if (r19 == null) goto L16;
    L17:
        Pair r20 = TuplesKt.to("botId", r19);
        h r21 = this.f;
        if (r21 == null) goto L21;
        String r22 = r21.e;
        if (r22 == null) goto L21;
    L22:
        Pair r23 = TuplesKt.to("msgId", r22);
        h r24 = this.f;
        if (r24 == null) goto L26;
        String r25 = r24.f3051i;
        if (r25 == null) goto L26;
    L27:
        Pair r26 = TuplesKt.to("mixtureCardId", r25);
        Pair r27 = TuplesKt.to("replyFor", "");
        Pair r110 = TuplesKt.to("conversationId", this.f3018a);
        h r28 = this.f;
        LinkedHashMap r29 = null;
        if (r28 == null) goto L30;
        Object r30 = r28.f3050h.get("createTime");
    L31:
        Pair r111 = TuplesKt.to("msgCreateTime", r30);
        Pair r112 = TuplesKt.to("appSettings", null);
        h r31 = this.f;
        if (r31 == null) goto L34;
        r29 = r31.f3050h;
    L34:
        Map r32 = MapsKt.mutableMapOf(new Pair[]{r13, r17, r20, r23, r26, r27, r110, r111, r112, TuplesKt.to("extra", r29)});
        h r113 = this.f;
        if (r113 == null) goto L42;
        Map r114 = r113.g;
        if (r114 == null) goto L42;
        Iterator r115 = r114.entrySet().iterator();
    L40:
        if (r115.hasNext() == false) goto L42;
        Map.Entry r33 = (Map.Entry) r115.next();
        r32.put((String) r33.getKey(), (String) r33.getValue());
    L42:
        r12.addProperty("eventName", new JSONObject(MapsKt.toMap(r32)).toString());
        Unit r116 = Unit.INSTANCE;
        r11.e(r15, r12);
        return;
    L30:
        r30 = null;
    L26:
        r25 = "";
    L21:
        r22 = "";
    L16:
        r19 = "";
    L11:
        r16 = "";
        goto L12
    }

    public final void k() {
        i(LifecycleEvent.e);
        j("onDestroy");
        Iterator r5 = this.f3020c.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((m3.a) r5.next()).a().a();
        goto L4
    L6:
        this.f3028o.clear();
    }

    public final void l() {
        this.f3024k = false;
        if (this.s == true) goto L5;
        return;
    L5:
        if (this.f3031r == false) goto L10;
        j("onHide");
        this.f3031r = false;
        return;
    }

    public final void m() {
        if (this.s == true) goto L5;
        return;
    L5:
        if (this.f3031r == false) goto L8;
        return;
    L8:
        if (this.f3023j == LifecycleEvent.d) goto L11;
        this.f3024k = true;
        return;
    L11:
        j("onShow");
        this.f3031r = true;
        com.bytedance.ai.utils.c.g(this.f3019b, Lifecycle.Event.ON_START);
    }

    @Override // w0.k
    public final void onMessageToAIBridge(String r5, JsonObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        i r11 = this.f3025l;
        if (r11 == null) goto L6;
        r11.e(r5, r10);
        return;
    }
}
