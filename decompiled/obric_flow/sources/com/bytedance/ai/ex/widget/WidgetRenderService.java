package com.bytedance.ai.ex.widget;

import android.app.Application;
import android.graphics.Color;
import android.os.Trace;
import android.view.View;
import android.widget.FrameLayout;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.ex.widget.inittasks.AISdkInitializer;
import com.bytedance.ai.ex.widget.rpc.MiniAppWidgetManagerRemote;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.model.p;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.l;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.ai.widget.models.OAppletWrap;
import com.bytedance.ai.widget.o;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.obric.feature.miniapp.widget.MiniAppConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import w0.m;
import w2.q;
import w2.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\rJ%\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0019Jn\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0082@¢\u0006\u0004\b\"\u0010#J%\u0010$\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b$\u0010%J9\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b(\u0010)Jn\u0010\"\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000b\u001a\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0086@¢\u0006\u0004\b\"\u0010*J\u0015\u0010+\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b-\u0010,J\u0015\u0010.\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b.\u0010,J\u0015\u0010/\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b/\u0010,J)\u00101\u001a\u0002002\u0006\u0010\u000b\u001a\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u0004\u0018\u0001052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b6\u00107JK\u00108\u001a\u0002002\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u000200¢\u0006\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010=R \u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00130>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010=R\u0014\u0010B\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010=R\u0014\u0010C\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010=R\u0014\u0010D\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010=R\u0014\u0010E\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010=R\u0014\u0010F\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010=R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00070G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006J"}, d2 = {"Lcom/bytedance/ai/ex/widget/WidgetRenderService;", "", "<init>", "()V", "Lcom/bytedance/ai/model/objects/WidgetInfo;", "widgetInfo", "", "", "viewContext", "buildCalendarOWidgetInitialTheme", "(Lcom/bytedance/ai/model/objects/WidgetInfo;Ljava/util/Map;)Ljava/util/Map;", "host", "getConversationId", "(Ljava/lang/Object;)Ljava/lang/String;", "getBotId", "getSectionId", "messageId", "Landroid/view/View;", "view", "Lx0/a;", "findWidgetManager", "(Ljava/lang/String;Landroid/view/View;)Lx0/a;", "manager", "", "removeWidgetManager", "(Ljava/lang/Object;Lx0/a;)V", "Landroid/widget/FrameLayout;", "parent", "Lw0/m;", "widgetLifeCycle", "Lw2/q;", "widgetConfig", "Lcom/bytedance/ai/widget/models/OAppletWrap;", "appletWrap", "createWidget", "(Ljava/lang/Object;Ljava/lang/String;Landroid/widget/FrameLayout;Lcom/bytedance/ai/model/objects/WidgetInfo;Lw0/m;Lw2/q;Ljava/util/Map;Lcom/bytedance/ai/widget/models/OAppletWrap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrCreateWidgetManager", "(Ljava/lang/Object;Lw2/q;)Lx0/a;", "appletId", "widgetId", "resolveScopedInitialTheme", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;", "(Lcom/bytedance/ai/model/objects/WidgetInfo;Landroid/widget/FrameLayout;Ljava/lang/Object;Ljava/lang/String;Lw0/m;Lw2/q;Ljava/util/Map;Lcom/bytedance/ai/widget/models/OAppletWrap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onViewCreated", "(Ljava/lang/Object;)V", "onHostShow", "onHostHide", "onHostDestroy", "", "destroyOwnedWidgetHost", "(Ljava/lang/Object;Ljava/lang/String;Landroid/view/View;)Z", "getWidgetManager", "(Ljava/lang/Object;)Lx0/a;", "Lcom/bytedance/ai/widget/contianer/f;", "findWidgetContainerByView", "(Landroid/view/View;)Lcom/bytedance/ai/widget/contianer/f;", MiniAppWidgetManagerRemote.METHOD_UPDATE_WIDGET_DATA, "(Lcom/bytedance/ai/model/objects/WidgetInfo;Ljava/lang/Object;Ljava/lang/String;Landroid/view/View;Ljava/util/Map;)Z", "widgetIsEmpty", "()Z", "TAG", "Ljava/lang/String;", "Ljava/util/WeakHashMap;", "widgetManagers", "Ljava/util/WeakHashMap;", WidgetRenderService.COMPACT_CONVERSATION_ID, WidgetRenderService.COMPACT_BOT_ID, WidgetRenderService.COMPACT_SECTION_ID, "VIEW_CONTEXT_RENDER_SCENE", "GLOBAL_PROP_APP_THEME", "OWIDGET_RENDER_SCENE", "", "CALENDAR_APPLET_IDS", "Ljava/util/Set;", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetRenderService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetRenderService.kt\ncom/bytedance/ai/ex/widget/WidgetRenderService\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,326:1\n1863#2,2:327\n1863#2:329\n1864#2:331\n1#3:330\n*S KotlinDebug\n*F\n+ 1 WidgetRenderService.kt\ncom/bytedance/ai/ex/widget/WidgetRenderService\n*L\n163#1:327,2\n272#1:329\n272#1:331\n*E\n"})
public final class WidgetRenderService {
    private static final Set<String> CALENDAR_APPLET_IDS = null;
    public static final String COMPACT_BOT_ID = "COMPACT_BOT_ID";
    public static final String COMPACT_CONVERSATION_ID = "COMPACT_CONVERSATION_ID";
    private static final String COMPACT_SECTION_ID = "COMPACT_SECTION_ID";
    private static final String GLOBAL_PROP_APP_THEME = "appTheme";
    public static final WidgetRenderService INSTANCE = null;
    private static final String OWIDGET_RENDER_SCENE = "owidget";
    private static final String TAG = "WidgetRenderHelper";
    private static final String VIEW_CONTEXT_RENDER_SCENE = "renderScene";
    private static final WeakHashMap<Object, x0.a> widgetManagers = null;

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.WidgetRenderService$createWidget$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.WidgetRenderService", f = "WidgetRenderService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {89, 91}, m = "createWidget", n = {"this", "widgetInfo", "parent", "host", "messageId", "widgetLifeCycle", "widgetConfig", "viewContext", "appletWrap"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetRenderService this$0;

        public AnonymousClass1(WidgetRenderService r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            this.result = r11;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createWidget(null, null, null, null, null, null, null, null, this);
        }
    }

    static {
        INSTANCE = new WidgetRenderService();
        widgetManagers = new WeakHashMap();
        CALENDAR_APPLET_IDS = SetsKt.setOf(new String[]{MiniAppConstants.APPLET_ID_CALENDAR, "com.flow.calendar2"});
    }

    private WidgetRenderService() {
    }

    public static /* synthetic */ boolean a(String r5, com.bytedance.ai.widget.contianer.f r10) {
        return updateWidgetData$lambda$7(r5, r10);
    }

    public static final /* synthetic */ Object access$createWidget(WidgetRenderService r5, Object r10, String r11, FrameLayout r12, WidgetInfo r13, m r14, q r15, Map r16, OAppletWrap r17, Continuation r18) {
        return r5.createWidget(r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ boolean b(String r5, com.bytedance.ai.widget.contianer.f r10) {
        return findWidgetManager$lambda$3$lambda$2(r5, r10);
    }

    private final Map<String, Object> buildCalendarOWidgetInitialTheme(WidgetInfo r5, Map<String, String> r10) {
        String r11 = resolveScopedInitialTheme(r5.getAppletId(), r5.getWidgetId(), r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return MapsKt.mapOf(TuplesKt.to(GLOBAL_PROP_APP_THEME, r11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object createWidget$default(WidgetRenderService r13, WidgetInfo r14, FrameLayout r15, Object r16, String r17, m r18, q r19, Map r20, OAppletWrap r21, Continuation r22, int r23, Object r24) {
        if ((r23 & 64) == 0) goto L5;
        Map r10 = null;
    L7:
        if ((r23 & 128) == 0) goto L9;
        OAppletWrap r11 = null;
    L11:
        return r13.createWidget(r14, r15, r16, r17, r18, r19, r10, r11, r22);
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }

    private final x0.a findWidgetManager(String r5, View r10) {
        Iterator<T> r11 = widgetManagers.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L17;
        x0.a r12 = (x0.a) r11.next();
        if (r5 != null) goto L8;
    L13:
        if (r10 == null) goto L4;
        o r13 = (o) r12;
        r13.getClass();
        if (r13.c(new com.bytedance.ai.widget.g(0, r10)) == null) goto L4;
        return r13;
    L8:
        if (StringsKt.isBlank(r5) == true) goto L13;
        f r14 = new f(r5, 0);
        if (((o) r12).c(r14) == null) goto L13;
        return r12;
    L17:
        return null;
    }

    private static final boolean findWidgetManager$lambda$3$lambda$2(String r5, com.bytedance.ai.widget.contianer.f r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetContainer");
        com.bytedance.ai.widget.contianer.h r11 = ((WidgetContainer) r10).f;
        String r12 = null;
        if (r11 == null) goto L5;
        String r13 = r11.e;
    L7:
        if (Intrinsics.areEqual(r13, r5) == true) goto L16;
        com.bytedance.ai.widget.contianer.h r14 = ((WidgetContainer) r10).f;
        if (r14 == null) goto L12;
        r12 = r14.e;
    L12:
        if (Intrinsics.areEqual(r12, r5) == true) goto L18;
        return false;
    L18:
        return true;
    L16:
        return true;
    L5:
        r13 = null;
        goto L7
    }

    private final String getBotId(Object r5) {
        if ((r5 instanceof IdentityLifecycleOwner) == false) goto L5;
        IdentityLifecycleOwner r10 = (IdentityLifecycleOwner) r5;
    L6:
        if (r10 == null) goto L11;
        String r11 = r10.getBotId();
        if (r11 == null) goto L13;
        return r11;
    L13:
        return COMPACT_BOT_ID;
    L11:
        return COMPACT_BOT_ID;
    L5:
        r10 = null;
        goto L6
    }

    private final String getConversationId(Object r5) {
        if ((r5 instanceof IdentityLifecycleOwner) == false) goto L5;
        IdentityLifecycleOwner r10 = (IdentityLifecycleOwner) r5;
    L6:
        if (r10 == null) goto L11;
        String r11 = r10.getConversationId();
        if (r11 == null) goto L13;
        return r11;
    L13:
        return COMPACT_CONVERSATION_ID;
    L11:
        return COMPACT_CONVERSATION_ID;
    L5:
        r10 = null;
        goto L6
    }

    private final x0.a getOrCreateWidgetManager(Object r10, q r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        WeakHashMap<Object, x0.a> r5 = widgetManagers;
        if (r5.containsKey(r10) == true) goto L14;
        o r12 = new o();
        if (r11 != null) goto L10;
        r11 = new q(com.bytedance.ai.utils.c.d(1), com.bytedance.ai.utils.c.d(1), Color.parseColor("#0F000000"), com.bytedance.ai.utils.c.d(134));
    L10:
        Intrinsics.checkNotNullParameter(r11, "config");
        r12.f3081a = r11;
        r5.put(r10, r12);
        String r13 = "new widget manager " + r12 + " host:" + r10;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L14;
        r14.i(TAG, r13);
    L14:
        return r5.get(r10);
    }

    private final String getSectionId(Object r5) {
        if ((r5 instanceof IdentityLifecycleOwner) == false) goto L5;
        IdentityLifecycleOwner r10 = (IdentityLifecycleOwner) r5;
    L6:
        if (r10 == null) goto L11;
        String r11 = r10.getSectionId();
        if (r11 == null) goto L13;
        return r11;
    L13:
        return COMPACT_SECTION_ID;
    L11:
        return COMPACT_SECTION_ID;
    L5:
        r10 = null;
        goto L6
    }

    private final void removeWidgetManager(Object r5, x0.a r10) {
        Iterator<Map.Entry<Object, x0.a>> r11 = widgetManagers.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Map.Entry<Object, x0.a> r12 = r11.next();
        if (r12.getKey() == r5) goto L9;
        if (r12.getValue() != r10) goto L4;
    L9:
        r11.remove();
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean updateWidgetData$default(WidgetRenderService r10, WidgetInfo r11, Object r12, String r13, View r14, Map r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = null;
    L6:
        return r10.updateWidgetData(r11, r12, r13, r14, r15);
    }

    private static final boolean updateWidgetData$lambda$7(String r5, com.bytedance.ai.widget.contianer.f r10) {
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        com.bytedance.ai.widget.contianer.h r11 = ((WidgetContainer) r10).f;
        if (r11 == null) goto L5;
        String r12 = r11.e;
    L7:
        return Intrinsics.areEqual(r12, r5);
    L5:
        r12 = null;
        goto L7
    }

    public final Object createWidget(WidgetInfo r10, FrameLayout r11, Object r12, String r13, m r14, q r15, Map<String, String> r16, OAppletWrap r17, Continuation<? super View> r18) {
        if ((r18 instanceof AnonymousClass1) == false) goto L8;
        AnonymousClass1 r5 = (AnonymousClass1) r18;
        int r19 = r5.label;
        if ((r19 & Integer.MIN_VALUE) == 0) goto L8;
        r5.label = r19 - Integer.MIN_VALUE;
    L7:
        AnonymousClass1 r110 = r5;
        Object r20 = r110.result;
        Object r21 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r22 = r110.label;
        if (r22 == 0) goto L19;
        if (r22 == 1) goto L17;
        if (r22 != 2) goto L16;
        ResultKt.throwOnFailure(r20);
        return r20;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r17 = (OAppletWrap) r110.L$8;
        r16 = (Map) r110.L$7;
        r15 = (q) r110.L$6;
        r14 = (m) r110.L$5;
        r13 = (String) r110.L$4;
        r12 = r110.L$3;
        r11 = (FrameLayout) r110.L$2;
        r10 = (WidgetInfo) r110.L$1;
        WidgetRenderService this = (WidgetRenderService) r110.L$0;
        ResultKt.throwOnFailure(r20);
    L18:
        OAppletWrap r23 = r17;
        Map<String, String> r111 = r16;
        q r112 = r15;
        m r113 = r14;
        WidgetInfo r114 = r10;
        Object r24 = r12;
        FrameLayout r25 = r11;
        if (r13 != null) goto L24;
        String r26 = UUID.randomUUID().toString();
    L25:
        r110.L$0 = null;
        r110.L$1 = null;
        r110.L$2 = null;
        r110.L$3 = null;
        r110.L$4 = null;
        r110.L$5 = null;
        r110.L$6 = null;
        r110.L$7 = null;
        r110.L$8 = null;
        r110.label = 2;
        Object r27 = this.createWidget(r24, r26, r25, r114, r113, r112, r111, r23, r110);
        if (r27 != r21) goto L28;
    L27:
        return r21;
    L28:
        return r27;
    L24:
        r26 = r13;
        goto L25
    L19:
        ResultKt.throwOnFailure(r20);
        AISdkInitializer r28 = AISdkInitializer.INSTANCE;
        r110.L$0 = this;
        r110.L$1 = r10;
        r110.L$2 = r11;
        r110.L$3 = r12;
        r110.L$4 = r13;
        r110.L$5 = r14;
        r110.L$6 = r15;
        r110.L$7 = r16;
        r110.L$8 = r17;
        r110.label = 1;
        if (r28.awaitAISdkInit(r110) != r21) goto L18;
    L8:
        r5 = new AnonymousClass1(this, r18);
        goto L7
    }

    public final boolean destroyOwnedWidgetHost(Object r10, String r11, View r12) {
        Intrinsics.checkNotNullParameter(r10, "host");
        x0.a r5 = getWidgetManager(r10);
        if (r5 != null) goto L11;
        r5 = findWidgetManager(r11, r12);
        if (r5 != null) goto L11;
        String r13 = "destroyOwnedWidgetHost missing manager host:" + r10 + " messageId:" + r11 + " view:" + r12;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L49;
        r14.w(TAG, r13);
        return false;
    L49:
        return false;
    L11:
        String r15 = "destroyOwnedWidgetHost host:" + r10 + " messageId:" + r11 + " view:" + r12 + " manager:" + r5;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L14;
        r16.d(TAG, r15);
    L14:
        if (r11 != null) goto L16;
    L31:
        if (r12 == null) goto L35;
        o r17 = (o) r5;
        com.bytedance.ai.widget.contianer.f r18 = r17.c(new com.bytedance.ai.widget.g(1, r12));
        if (r18 == null) goto L35;
        o.g(r18, r17.f3082b);
        o.g(r18, r17.d);
        o.g(r18, r17.f3083c);
        o.g(r18, r17.f3084h);
        com.bytedance.ai.widget.m r19 = (com.bytedance.ai.widget.m) r17.e.remove(r18);
    L35:
        ((o) r5).i();
        removeWidgetManager(r10, r5);
        AISdkInitializer r110 = AISdkInitializer.INSTANCE;
        t0.e r111 = r110.getWidgetHostLifecycle();
        if (r111 == null) goto L42;
        String r20 = getConversationId(r10);
        s0.b r112 = (s0.b) r111;
        if (r20 == null) goto L42;
        p.f(new b2.c(r20, 5));
    L42:
        if (r110.getWidgetHostLifecycle() == null) goto L50;
        getConversationId(r10);
        return true;
    L50:
        return true;
    L16:
        if (StringsKt.isBlank(r11) == true) goto L31;
        List r113 = CollectionsKt.listOf(r11);
        o r21 = (o) r5;
        Intrinsics.checkNotNullParameter(r113, "msgIds");
        String r22 = "onWidgetMessageRemoved " + r113;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L21;
        r23.i("WidgetManager", r22);
    L21:
        Iterator r114 = r113.iterator();
    L23:
        if (r114.hasNext() == false) goto L31;
        String r24 = (String) r114.next();
        com.bytedance.ai.widget.contianer.f r25 = r21.c(new com.bytedance.ai.widget.i(r24, 0));
        if (r25 == null) goto L30;
        String r26 = "onWidgetMessageRemoved msgId=" + r24 + ' ' + r25;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L29;
        r27.d("WidgetManager", r26);
    L29:
        o.g(r25, r21.f3082b);
        o.g(r25, r21.d);
        o.g(r25, r21.f3083c);
        o.g(r25, r21.f3084h);
        com.bytedance.ai.widget.m r28 = (com.bytedance.ai.widget.m) r21.e.remove(r25);
    L30:
        Intrinsics.areEqual(r25, null);
        goto L23
    }

    public final com.bytedance.ai.widget.contianer.f findWidgetContainerByView(View r5) {
        Iterator<T> r10 = widgetManagers.values().iterator();
    L3:
        com.bytedance.ai.widget.contianer.f r11 = null;
        if (r10.hasNext() == false) goto L10;
        o r12 = (o) ((x0.a) r10.next());
        r12.getClass();
        if (r5 == null) goto L9;
        r11 = r12.c(new com.bytedance.ai.widget.g(0, r5));
    L9:
        if (r11 == null) goto L3;
    L10:
        return r11;
    }

    public final x0.a getWidgetManager(Object r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return widgetManagers.get(r5);
    }

    public final void onHostDestroy(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        String r10 = "onHostDestroy host:" + r5;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.d(TAG, r10);
    L5:
        x0.a r12 = getWidgetManager(r5);
        if (r12 == null) goto L8;
        ((o) r12).i();
    L8:
        widgetManagers.remove(r5);
        AISdkInitializer r13 = AISdkInitializer.INSTANCE;
        t0.e r14 = r13.getWidgetHostLifecycle();
        if (r14 == null) goto L15;
        String r15 = getConversationId(r5);
        s0.b r16 = (s0.b) r14;
        if (r15 == null) goto L15;
        p.f(new b2.c(r15, 5));
    L15:
        if (r13.getWidgetHostLifecycle() == null) goto L18;
        getConversationId(r5);
        return;
    }

    public final void onHostHide(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        String r5 = "onHostHide host:" + r10;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.d(TAG, r5);
    L5:
        x0.a r12 = getWidgetManager(r10);
        if (r12 == null) goto L31;
        o r13 = (o) r12;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L10;
        r14.i("WidgetManager", "onHostHide");
    L10:
        HashMap r15 = r13.f3082b;
        Iterator r16 = r15.entrySet().iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        ((WidgetContainer) ((com.bytedance.ai.widget.contianer.f) ((Map.Entry) r16.next()).getValue())).l();
        goto L12
    L14:
        Iterator r17 = r15.entrySet().iterator();
    L16:
        if (r17.hasNext() == false) goto L18;
        WidgetContainer r18 = (WidgetContainer) ((com.bytedance.ai.widget.contianer.f) ((Map.Entry) r17.next()).getValue());
        r18.s = false;
        r18.j("onBackground");
        goto L16
    L18:
        Iterator<Map.Entry<String, com.bytedance.ai.widget.contianer.f>> r19 = r13.f3083c.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L22;
        WidgetContainer r20 = (WidgetContainer) r19.next().getValue();
        r20.s = false;
        r20.j("onBackground");
        goto L20
    L22:
        Iterator r21 = r13.d.entrySet().iterator();
    L24:
        if (r21.hasNext() == false) goto L26;
        WidgetContainer r22 = (WidgetContainer) ((com.bytedance.ai.widget.contianer.f) ((Map.Entry) r21.next()).getValue());
        r22.s = false;
        r22.j("onBackground");
        goto L24
    L26:
        Iterator r23 = r13.f3084h.entrySet().iterator();
    L28:
        if (r23.hasNext() == false) goto L31;
        Map.Entry r24 = (Map.Entry) r23.next();
        ((WidgetContainer) ((com.bytedance.ai.widget.contianer.f) r24.getValue())).l();
        WidgetContainer r25 = (WidgetContainer) ((com.bytedance.ai.widget.contianer.f) r24.getValue());
        r25.s = false;
        r25.j("onBackground");
    L31:
        if (AISdkInitializer.INSTANCE.getWidgetHostLifecycle() == null) goto L39;
        getConversationId(r10);
        return;
    }

    public final void onHostShow(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        String r5 = "onHostShow host:" + r10;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.d(TAG, r5);
    L5:
        x0.a r12 = getWidgetManager(r10);
        if (r12 == null) goto L47;
        o r13 = (o) r12;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L10;
        r14.i("WidgetManager", "onHostShow");
    L10:
        Trace.beginSection("initLynx");
        u0.a r15 = s0.a.f21800c;
        if (r15 == null) goto L15;
        Application r16 = r15.f22194a;
        if (r16 == null) goto L15;
        Intrinsics.checkNotNullParameter(r16, "context");
        IIvyAIPackageResourceService.Companion.ensureInitLynx(r16);
    L15:
        Trace.endSection();
        l r17 = o.f3079j;
        monitor-enter(r17);
        ArrayDeque r18 = o.f3080k;     // Catch: Throwable -> L43
        CollectionsKt.removeAll(r18, new com.bytedance.ai.widget.h(r13, 4));     // Catch: Throwable -> L43
        r18.addLast(new WeakReference(r13));     // Catch: Throwable -> L43
        monitor-exit(r17);
        Iterator r19 = r13.f3082b.entrySet().iterator();
    L21:
        if (r19.hasNext() == false) goto L23;
        WidgetContainer r20 = (WidgetContainer) ((com.bytedance.ai.widget.contianer.f) ((Map.Entry) r19.next()).getValue());
        r20.s = true;
        r20.j("onForeground");
        goto L21
    L23:
        Iterator<Map.Entry<String, com.bytedance.ai.widget.contianer.f>> r21 = r13.f3083c.entrySet().iterator();
    L25:
        if (r21.hasNext() == false) goto L27;
        WidgetContainer r22 = (WidgetContainer) r21.next().getValue();
        r22.s = true;
        r22.j("onForeground");
        goto L25
    L27:
        Iterator r23 = r13.d.entrySet().iterator();
    L29:
        if (r23.hasNext() == false) goto L31;
        WidgetContainer r24 = (WidgetContainer) ((com.bytedance.ai.widget.contianer.f) ((Map.Entry) r23.next()).getValue());
        r24.s = true;
        r24.j("onForeground");
        goto L29
    L31:
        Iterator r25 = r13.f3082b.values().iterator();
    L33:
        if (r25.hasNext() == false) goto L37;
        com.bytedance.ai.widget.contianer.f r26 = (com.bytedance.ai.widget.contianer.f) r25.next();
        if (r26.h() == false) goto L33;
        ((WidgetContainer) r26).m();
        goto L33
    L37:
        Iterator r27 = r13.f3084h.values().iterator();
    L39:
        if (r27.hasNext() == false) goto L47;
        com.bytedance.ai.widget.contianer.f r28 = (com.bytedance.ai.widget.contianer.f) r27.next();
        WidgetContainer r29 = (WidgetContainer) r28;
        r29.s = true;
        r29.j("onForeground");
        if (r28.h() == false) goto L39;
        ((WidgetContainer) r28).m();
    L43:
        th = move-exception;
        throw th;
    L47:
        if (AISdkInitializer.INSTANCE.getWidgetHostLifecycle() == null) goto L65;
        getConversationId(r10);
        return;
    }

    public final void onViewCreated(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        String r10 = "onViewCreated host:" + r5;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.d(TAG, r10);
    L5:
        t0.e r12 = AISdkInitializer.INSTANCE.getWidgetHostLifecycle();
        if (r12 == null) goto L12;
        String r13 = getConversationId(r5);
        s0.b r14 = (s0.b) r12;
        if (r13 == null) goto L13;
        p.f(new b2.c(r13, 6));
        return;
    L13:
        return;
    }

    public final String resolveScopedInitialTheme(String r5, String r10, Map<String, String> r11) {
        if (r11 != null) goto L5;
    L22:
        return null;
    L5:
        if (r11.isEmpty() == true) goto L22;
        if (Intrinsics.areEqual(r11.get(VIEW_CONTEXT_RENDER_SCENE), OWIDGET_RENDER_SCENE) == true) goto L11;
        return null;
    L11:
        if (CollectionsKt.contains(CALENDAR_APPLET_IDS, r5) == true) goto L13;
        return null;
    L13:
        String r12 = r11.get(GLOBAL_PROP_APP_THEME);
        if (r12 != null) goto L17;
        return null;
    L17:
        if (Intrinsics.areEqual(r12, WidgetView.UI_MODE_DARK) == false) goto L19;
    L21:
        return r12;
    L19:
        if (Intrinsics.areEqual(r12, WidgetView.UI_MODE_LIGHT) == true) goto L21;
        return null;
    }

    public final boolean updateWidgetData(WidgetInfo r27, Object r28, String r29, View r30, Map<String, String> r31) {
        Intrinsics.checkNotNullParameter(r27, "widgetInfo");
        int r19 = 0;
        if (r28 != null) goto L5;
        return false;
    L5:
        if (r29 != null) goto L7;
        return false;
    L7:
        String r20 = r27.getAppletId();
        String r14 = r27.getWidgetId();
        if (r20 != null) goto L10;
    L44:
        return false;
    L10:
        if (StringsKt.isBlank(r20) == true) goto L44;
        if (r14 == null) goto L44;
        if (StringsKt.isBlank(r14) == true) goto L44;
        x0.a r5 = getWidgetManager(r28);
        if (r5 != null) goto L19;
        return false;
    L19:
        o r10 = (o) r5;
        com.bytedance.ai.widget.contianer.f r11 = r10.c(new f(r29, 1));
        if (r11 != null) goto L27;
        if (r30 != null) goto L24;
        com.bytedance.ai.widget.contianer.f r12 = null;
    L23:
        r11 = r12;
        if (r11 != null) goto L27;
        return false;
    L24:
        r12 = r10.c(new com.bytedance.ai.widget.g(0, r30));
    L27:
        String r22 = r27.getWidgetData();
        String r23 = getBotId(r28);
        String r13 = getSectionId(r28);
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("enableZoom", Boolean.FALSE);
        r15.put("globalFloat", Boolean.TRUE);
        Map<String, Object> r16 = buildCalendarOWidgetInitialTheme(r27, r31);
        String r17 = r27.getMixtureCardId();
        String r18 = getConversationId(r28);
        com.bytedance.ai.widget.contianer.h r110 = new com.bytedance.ai.widget.contianer.h(r20, r14, r22, r23, r29, r13, r31, r15, r17, r18, r16, r27.getMcpName(), r27.getFullScreenRefresh(), null, 206912);
        Intrinsics.checkNotNullParameter(r110, "widgetContainerData");
        if (((AppletWidgetContainer) r11).f2993v != null) goto L30;
    L33:
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L36;
        r21.e("AppletWidgetContainer", "updateData: widgetLoader is NULL");
    L36:
        StringBuilder r24 = new StringBuilder("updateWidgetData host:");
        r24.append(r28);
        r24.append(" messageId:");
        r24.append(r29);
        r24.append(" widgetId:");
        r24.append(r14);
        r24.append(" dataLength=");
        String r25 = r27.getWidgetData();
        if (r25 == null) goto L39;
        r19 = r25.length();
    L39:
        r24.append(r19);
        String r26 = r24.toString();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r32 = com.bytedance.ai.utils.c.f2846a;
        if (r32 == null) goto L45;
        r32.d(TAG, r26);
        return true;
    L45:
        return true;
    L30:
        if (r18 != null) goto L32;
        r18 = "";
    L32:
        String r33 = null;
        Intrinsics.checkNotNullParameter(new ConversationWidgetData(r20, r14, r29, r23, r18, r33, r22, null, r110.f3056n, 128, null), "widgetData");
        goto L33
    }

    public final boolean widgetIsEmpty() {
        return widgetManagers.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object createWidget$default(WidgetRenderService r13, Object r14, String r15, FrameLayout r16, WidgetInfo r17, m r18, q r19, Map r20, OAppletWrap r21, Continuation r22, int r23, Object r24) {
        if ((r23 & 64) == 0) goto L5;
        Map r10 = null;
    L7:
        if ((r23 & 128) == 0) goto L9;
        OAppletWrap r11 = null;
    L11:
        return r13.createWidget(r14, r15, r16, r17, r18, r19, r10, r11, r22);
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.ai.ex.widget.WidgetRenderService$createWidget$context$1] */
    private final Object createWidget(Object r15, String r16, FrameLayout r17, WidgetInfo r18, final m r19, q r20, Map<String, String> r21, OAppletWrap r22, Continuation<? super View> r23) {
        String r5 = getConversationId(r15);
        String r10 = getSectionId(r15);
        String r11 = getBotId(r15);
        ?? r12 = new WidgetRenderService$createWidget$context$1(r19);
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("enableZoom", Boxing.boxBoolean(false));
        r13.put("globalFloat", Boxing.boxBoolean(true));
        Unit r14 = Unit.INSTANCE;
        r r110 = new r(r16, r5, r10, r11, r18, r17, r12, r21, r13, buildCalendarOWidgetInitialTheme(r18, r21), r22);
        x0.a r24 = getOrCreateWidgetManager(r15, r20);
        if (r24 != null) goto L5;
        return null;
    L5:
        return ((o) r24).e(r110, r23);
    }
}
