package com.larus.bmhome.chat.markdown.lynx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.LruCache;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.LynxBox;
import com.larus.bmhome.chat.layout.item.e1;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.common.apphost.AppHost;
import com.larus.crossplatform.card.impl.LynxRenderDataRepo;
import com.larus.im.bean.message.Message;
import com.larus.ivykit.plugin.TemplateInfo;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.utils.y0;
import com.larus.utils.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import oh8.g;
import oh8.h;
import oh8.i;
import oh8.j;
import oh8.k;
import oh8.l;
import oh8.m;
import oh8.n;
import org.json.JSONObject;
import usc.f;
import va8.a0;
import va8.p;
import va8.x;
import va8.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001dB\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00102\u001a\u000203H\u0016J>\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00109\u001a\u00020:2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0016J\u0018\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020CH\u0002J \u0010D\u001a\u00020C2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020\u001bH\u0002J\u0018\u0010G\u001a\u00020C2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u001bH\u0002J(\u0010I\u001a\"\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010=0Jj\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010=`KH\u0002J\b\u0010L\u001a\u00020:H\u0002J\b\u0010M\u001a\u00020CH\u0002J \u0010N\u001a\u00020C2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020\u001bH\u0002J\b\u0010O\u001a\u00020:H\u0002J\b\u0010P\u001a\u00020CH\u0016J\b\u0010Q\u001a\u00020\u001bH\u0002J\u0018\u0010R\u001a\u00020C2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010S\u001a\u00020\u001bH\u0002J/\u0010T\u001a\u0004\u0018\u0001HU\"\u0004\b\u0000\u0010U2\b\u0010V\u001a\u0004\u0018\u00010\u001b2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u0002HU\u0018\u00010XH\u0002¢\u0006\u0002\u0010YJR\u0010Z\u001a\u00020C2\b\u0010[\u001a\u0004\u0018\u0001032\u0006\u0010\\\u001a\u00020:2\u0006\u0010]\u001a\u00020:2\u0006\u0010^\u001a\u00020:2\u0006\u0010_\u001a\u00020:2\u0006\u0010`\u001a\u00020:2\u0006\u0010a\u001a\u00020:2\u0006\u0010b\u001a\u00020:2\u0006\u0010c\u001a\u00020:H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%R\u001d\u0010'\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b)\u0010*R\u001d\u0010,\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010!\u001a\u0004\b.\u0010/R\u0010\u00101\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/larus/bmhome/chat/markdown/lynx/MarkdownLynxWidget;", "Landroid/widget/FrameLayout;", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "Landroid/view/View$OnLayoutChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "data", "Lcom/larus/im/bean/message/Message;", "attachReceiver", "Lcom/larus/ui/arch/component/external/api/receiver/AttachReceiver;", "shareMessageListAdapter", "Lcom/larus/chat/api/ShareMessageListAdapterWrapper;", "lynxBox", "Lcom/larus/bmhome/chat/layout/item/LynxBox;", "lynxTemplateUri", "Landroid/net/Uri;", "spanSize", "Landroid/util/Size;", "pluginViewExtraData", "Lcom/ivy/ivykit/api/plugin/PluginViewExtraData;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "cardType", "", "chatListAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListAbility$delegate", "Lkotlin/Lazy;", "chatUtilAbility", "Lcom/larus/bmhome/ability/IChatUtilsAbility;", "getChatUtilAbility", "()Lcom/larus/bmhome/ability/IChatUtilsAbility;", "chatUtilAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "chatConversationAbility$delegate", "chatTraceAbility", "Lcom/larus/bmhome/ability/IChatTraceCoreAbility;", "getChatTraceAbility", "()Lcom/larus/bmhome/ability/IChatTraceCoreAbility;", "chatTraceAbility$delegate", "forceRefreshId", "asView", "Landroid/view/View;", "bindData", "textView", "Landroid/widget/TextView;", ChatDraftItem.TYPE_TEXT, "Landroid/text/Spanned;", "maxWidth", "", "payload", "", "", "getLynxPlaceHolderHeight", "lynxMaxWidth", "placeHolderHeightRatio", "", "refreshLynxWidget", "", "fetchAndBindLynxData", "lynxDataUrl", "fetchMessageId", "bindLynxData", "renderData", "generateCommonProps", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "cardInText", "reportMapCardShow", "fetchLynxDataByHttp", "getLynxBoxViewMeasuredHeight", "onRecycle", "getLynxCacheKey", "reportLynxCardShow", "jsonData", "safeFromJson", "T", "json", "classOfT", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "onLayoutChange", "v", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MarkdownLynxWidget extends FrameLayout implements f, View.OnLayoutChangeListener {
    public static final /* synthetic */ int o = 0;
    public Message a;
    public AttachReceiver b;
    public ry8.d c;
    public LynxBox d;
    public Uri e;
    public Size f;
    public final com.ivy.ivykit.api.plugin.d g;
    public usc.e h;
    public String i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public String n;

    public static final class a {
    }

    public static final class b implements Function0<a0> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(a0.class));
        }
    }

    public static final class c implements Function0<p> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(p.class));
        }
    }

    public static final class d implements Function0<x> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(x.class));
        }
    }

    public static final class e implements Function0<y> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    static {
    }

    public final void a() {
    }

    public final View asView() {
        return this;
    }

    public final Integer b(Size r1, TextView r2, Canvas r3, Paint r4) {
        return null;
    }

    public final Size c(TextView r1, usc.e r2, Map<String, ? extends Object> r3) {
        return null;
    }

    public final void e() {
    }

    private final a0 getChatConversationAbility() {
        return (a0) this.l.getValue();
    }

    private final p getChatListAbility() {
        return (p) this.j.getValue();
    }

    private final x getChatTraceAbility() {
        return (x) this.m.getValue();
    }

    private final y getChatUtilAbility() {
        return (y) this.k.getValue();
    }

    private final int getLynxBoxViewMeasuredHeight() {
        LynxBox r0 = this.d;
        if (r0 == null) goto L10;
        kx7.b r1 = r0.getLynxPluginView();
        if (r1 == null) goto L10;
        BulletContainerView r2 = r1.c();
        if (r2 == null) goto L10;
        return r2.getMeasuredHeight();
    L10:
        LynxBox r3 = this.d;
        if (r3 == null) goto L15;
        View r4 = r3.getAppletLynxView();
        if (r4 == null) goto L15;
        return r4.getMeasuredHeight();
    L15:
        return 0;
    }

    private final String getLynxCacheKey() {
        Uri r0 = this.e;
        if (r0 == null) goto L9;
        Uri.Builder r1 = r0.buildUpon();
        if (r1 == null) goto L9;
        Uri.Builder r2 = r1.appendQueryParameter("cardInText", String.valueOf(i()));
        if (r2 == null) goto L9;
        Uri r3 = r2.build();
    L11:
        return String.valueOf(r3);
    L9:
        r3 = null;
        goto L11
    }

    public final void f() {
        boolean r0 = !AppHost.a.isOversea();
        if (z2.a.enableRuyiLynxViewRecycle() == false) goto L34;
        if (r0 == true) goto L34;
        LynxBox r1 = this.d;
        if (r1 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L34;
        if (r1 != null) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L38;
        LynxBox r4 = this.d;
        if (r4 == null) goto L39;
        LruCache<String, List<LynxBox>> r5 = oh8.a.a;
        String r6 = getLynxCacheKey();
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        if (r4.getLynxBoxConfig().k == true) goto L24;
    L31:
        r4.x();
        FLogger.a.i("MarkdownLynxCacheManager", "ignore cache due to not enableAppletCache");
    L32:
        removeOnLayoutChangeListener(this);
        removeView(r4);
        return;
    L24:
        if (r4.s.i == true) goto L31;
        LruCache<String, List<LynxBox>> r7 = oh8.a.a;
        List<LynxBox> r8 = r7.get(r6);
        if (r8 != null) goto L29;
        List<LynxBox> r9 = r7.put(r6, CollectionsKt.mutableListOf(new LynxBox[]{r4}));
    L30:
        FLogger.a.i("MarkdownLynxCacheManager", "put lynxBox " + r4.getRealTemplateUrl());
        goto L32
    L29:
        r8.add(r4);
        List<LynxBox> r10 = r7.put(r6, r8);
        goto L30
    L39:
        return;
    L38:
        return;
    L15:
        if (r1.getVisibility() != 0) goto L17;
        r2 = true;
        goto L18
    L8:
        if (r1.s.i != true) goto L10;
        r3 = true;
    L34:
        LynxBox r11 = this.d;
        if (r11 == null) goto L40;
        r11.x();
        return;
    }

    public final int i() {
        usc.e r0 = this.h;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.i();
    L7:
        if (Intrinsics.areEqual(r2, "data-inline-no-margin") == true) goto L15;
        usc.e r3 = this.h;
        if (r3 == null) goto L12;
        r1 = r3.i();
    L12:
        if (Intrinsics.areEqual(r1, "data-inline") == true) goto L15;
        return 0;
    L15:
        return 1;
    L5:
        r2 = null;
        goto L7
    }

    public final HashMap<String, Object> j() {
        HashMap<String, Object> r0 = new HashMap();
        LynxBox r1 = this.d;
        if (r1 == null) goto L8;
        TemplateInfo r2 = r1.getTemplateInfo();
        if (r2 == null) goto L8;
        String r3 = r2.getTemplateId();
        if (r3 == null) goto L8;
    L9:
        r0.put("templateId", r3);
        a0 r4 = getChatConversationAbility();
        String r5 = null;
        if (r4 == null) goto L18;
        String r6 = r4.getBotId();
        if (r6 == null) goto L18;
        if (StringsKt.isBlank(r6) == false) goto L19;
        Message r7 = this.a;
        if (r7 == null) goto L18;
        r6 = r7.getSenderId();
    L19:
        r0.put("botId", r6);
        Message r8 = this.a;
        if (r8 == null) goto L22;
        String r9 = r8.getMessageId();
    L23:
        r0.put("messageId", r9);
        Message r10 = this.a;
        if (r10 == null) goto L26;
        String r11 = r10.getConversationId();
    L27:
        r0.put("conversationId", r11);
        x r12 = getChatTraceAbility();
        if (r12 == null) goto L30;
        String r13 = r12.jd();
    L31:
        r0.put("chatType", r13);
        Message r14 = this.a;
        if (r14 == null) goto L34;
        String r15 = r14.getReplyId();
    L35:
        r0.put("replyId", r15);
        x r16 = getChatTraceAbility();
        if (r16 == null) goto L38;
        String r17 = r16.k();
    L39:
        r0.put("currentPage", r17);
        x r18 = getChatTraceAbility();
        if (r18 == null) goto L42;
        String r19 = r18.L1();
    L43:
        r0.put("previousPage", r19);
        r0.put("cardInText", Integer.valueOf(i()));
        p r20 = getChatListAbility();
        if (r20 == null) goto L59;
        List r21 = r20.getCurrentList();
        if (r21 == null) goto L59;
        Iterator r22 = r21.iterator();
    L49:
        if (r22.hasNext() == false) goto L57;
        Object r23 = r22.next();
        String r24 = ((Message) r23).getMessageId();
        Message r25 = this.a;
        if (r25 == null) goto L53;
        String r26 = r25.getReplyId();
    L55:
        if (Intrinsics.areEqual(r24, r26) == false) goto L49;
    L58:
        Message r27 = (Message) r23;
    L60:
        if (r27 == null) goto L62;
        r5 = com.larus.bmhome.chat.bean.d.x(r27).getActionBarKey();
    L62:
        r0.put("actionBarKey", r5);
        return r0;
    L53:
        r26 = null;
        goto L55
    L57:
        r23 = null;
    L59:
        r27 = null;
        goto L60
    L42:
        r19 = null;
        goto L43
    L38:
        r17 = null;
        goto L39
    L34:
        r15 = null;
        goto L35
    L30:
        r13 = null;
        goto L31
    L26:
        r11 = null;
        goto L27
    L22:
        r9 = null;
    L18:
        r6 = null;
    L8:
        r3 = "";
        goto L9
    }

    public MarkdownLynxWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static void g(MarkdownLynxWidget r3) {
        usc.e r0 = r3.h;
        if (r0 == null) goto L5;
        r0.j();
    L5:
        Message r1 = r3.a;
        if (r1 == null) goto L27;
        String r2 = r1.getMessageId();
        if (r2 == null) goto L28;
        y r4 = r3.getChatUtilAbility();
        if (r4 == null) goto L12;
        r4.pf(r2);
    L12:
        y r5 = r3.getChatUtilAbility();
        if (r5 == null) goto L18;
        String r6 = r3.n;
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r5.pf(r6);
    L18:
        p r7 = r3.getChatListAbility();
        if (r7 == null) goto L21;
        boolean r8 = r7.x7(r2, 1);
    L22:
        if (r8 == true) goto L29;
        ry8.d r9 = r3.c;
        if (r9 == null) goto L30;
        r9.L0();
        return;
    L30:
        return;
    L29:
        return;
    L21:
        r8 = false;
        goto L22
    L28:
        return;
    }

    public MarkdownLynxWidget(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.f = new Size(0, 0);
        this.g = new com.ivy.ivykit.api.plugin.d();
        this.j = LazyKt.lazy(new g(this));
        this.k = LazyKt.lazy(new h(this));
        this.l = LazyKt.lazy(new i(this));
        this.m = LazyKt.lazy(new j(this));
    }

    public final void h(LynxBox r8, String r9) {
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        com.ivy.ivykit.api.plugin.d r1 = this.g;
        HashMap r3 = new HashMap();
        r3.put("template_id", r8.getTemplateInfo().getTemplateId());
        a0 r4 = getChatConversationAbility();
        String r5 = null;
        if (r4 == null) goto L11;
        String r6 = r4.getBotId();
    L12:
        r3.put("bot_id", r6);
        Message r7 = this.a;
        if (r7 == null) goto L15;
        String r10 = r7.getMessageId();
    L16:
        r3.put("message_id", r10);
        Message r11 = this.a;
        if (r11 == null) goto L19;
        String r12 = r11.getConversationId();
    L20:
        r3.put("conversation_id", r12);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.b = r3;
        com.ivy.ivykit.api.plugin.d r2 = this.g;
        HashMap<String, Object> r13 = j();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r2.c = r13;
        Message r14 = this.a;
        if (r14 == null) goto L24;
        String r15 = r14.getMessageId();
        if (r15 == null) goto L24;
    L25:
        r8.z(r15, r9, this.g);
        p r16 = getChatListAbility();
        if (r16 == null) goto L40;
        List r17 = r16.getCurrentList();
        if (r17 == null) goto L40;
        Iterator r18 = r17.iterator();
    L31:
        if (r18.hasNext() == false) goto L38;
        Object r19 = r18.next();
        if (((Message) r19).getContentType() != 50) goto L35;
        boolean r20 = true;
    L36:
        if (r20 == false) goto L31;
    L39:
        Message r21 = (Message) r19;
    L41:
        if (r21 == null) goto L43;
        String r22 = r21.getMessageId();
    L44:
        Message r23 = this.a;
        if (r23 == null) goto L48;
        r5 = r23.getMessageId();
    L48:
        if (Intrinsics.areEqual(r22, r5) == false) goto L58;
        p r24 = getChatListAbility();
        if (r24 == null) goto L59;
        r24.n2();
        return;
    L59:
        return;
    L58:
        return;
    L43:
        r22 = null;
        goto L44
    L35:
        r20 = false;
        goto L36
    L38:
        r19 = null;
    L40:
        r21 = null;
    L24:
        r15 = "";
        goto L25
    L19:
        r12 = null;
        goto L20
    L15:
        r10 = null;
        goto L16
    L11:
        r6 = null;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public final void k(LynxBox r5, String r6) {
        JSONObject r7 = z.b(r6);
        if (r7 != null) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        a0 r1 = getChatConversationAbility();
        String r2 = null;
        if (r1 == null) goto L8;
        String r3 = r1.getBotId();
    L9:
        r0.put("bot_id", r3);
        Message r4 = this.a;
        if (r4 == null) goto L12;
        String r8 = r4.getMessageId();
    L13:
        r0.put("message_id", r8);
        Message r9 = this.a;
        if (r9 == null) goto L16;
        r2 = r9.getConversationId();
    L16:
        r0.put("conversation_id", r2);
        r0.put("card_type", r7.optString("ala_src"));
        r0.put("template_id", r5.getTemplateInfo().getTemplateId());
        o.a.reportEvent("card_show", r0);
        return;
    L12:
        r8 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Size d(final TextView r41, Spanned r42, usc.e r43, int r44, Map<String, ? extends Object> r45) {
        Intrinsics.checkNotNullParameter(r41, "textView");
        Intrinsics.checkNotNullParameter(r42, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r43, "span");
        this.h = r43;
        int r15 = fh8.y.a(r44);
        LynxBox r0 = this.d;
        boolean r17 = true;
        String r18 = null;
        if (r0 != null) goto L5;
        if (r45 == null) goto L38;
        fh8.f r5 = fh8.h.b(r45);
    L39:
        if (r5 == null) goto L41;
        Message r11 = r5.b;
    L42:
        this.a = r11;
        if (r5 == null) goto L45;
        AttachReceiver r1 = r5.o;
    L46:
        this.b = r1;
        if (r5 == null) goto L49;
        RecyclerView.Adapter<?> r2 = r5.p;
    L51:
        if ((r2 instanceof ry8.d) == false) goto L53;
        ry8.d r3 = (ry8.d) r2;
    L54:
        this.c = r3;
        if (r5 == null) goto L57;
        String r4 = r5.j;
    L58:
        this.n = r4;
        if (r11 == null) goto L250;
        if (r43.k().length() != 0) goto L63;
        boolean r6 = true;
    L65:
        if (r6 == false) goto L67;
        String r7 = r43.h();
    L71:
        if (r7 != null) goto L73;
        r7 = "{}";
    L73:
        String r8 = r7;
        Object r9 = new Gson().fromJson(r8, TemplateInfo.class);     // Catch: Exception -> L76
    L78:
        TemplateInfo r23 = (TemplateInfo) r9;
        if (r23 == null) goto L81;
        JSONObject r10 = z.b(r8);
        if (r10 == null) goto L85;
        final String r12 = r10.optString("data_url");
        JSONObject r13 = new JSONObject(r10.optString("data"));
        this.i = r10.optString("ruyi_card_type");
        r13.put("commonProps", new JSONObject(j()));
        String r14 = r13.toString();
        final boolean r16 = Intrinsics.areEqual(r43.i(), "data-block-full");
        String r19 = r23.getTemplateUrl();
        if (r19 != null) goto L89;
        r19 = "";
    L89:
        Uri r20 = UriProtector.parse(r19);
        this.e = r20;
        if (r16 == false) goto L96;
        String r21 = y0.f(r20, "full_card_placeholder_ratio");
        if (r21 == null) goto L101;
        Float r22 = StringsKt.toFloatOrNull(r21);
        if (r22 == null) goto L101;
        float r24 = r22.floatValue();
    L102:
        boolean r25 = !AppHost.a.isOversea();
        if (r25 == false) goto L105;
        LynxBox r26 = null;
    L112:
        if (r26 == null) goto L114;
        this.d = r26;
        String r46 = r14;
        Message r37 = r11;
    L145:
        int r27 = getLynxBoxViewMeasuredHeight();
        if (r27 == 0) goto L148;
        int r28 = r27;
        int r29 = r15;
    L174:
        this.f = new Size(r29, r28);
        final LynxBox r30 = this.d;
        if (r30 == null) goto L248;
        r30.w(new k(r16, r41));
        String r31 = r37.getMessageId();
        if (r31 != null) goto L179;
    L182:
        boolean r110 = true;
    L183:
        if (r110 == true) goto L185;
        Intrinsics.checkNotNull(r12);
        if (r12.length() <= 0) goto L189;
        boolean r111 = true;
    L190:
        if (r111 == false) goto L199;
        final String r32 = r37.getMessageId();
        if (r32 != null) goto L194;
        r32 = "";
    L194:
        CoroutineScope r33 = LynxRenderDataRepo.a;
        Intrinsics.checkNotNullParameter(r32, "key");
        if (LynxRenderDataRepo.b.b(r32) == true) goto L197;
        r30.q(LynxBox.LynxShowState.LOADING);
        LynxRenderDataRepo.b(r12, r32, new oh8.f(r32, this, r30));
    L220:
        r30.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams r34 = r30.getLayoutParams();
        if (r34 == null) goto L246;
        ConstraintLayout.LayoutParams r35 = (ConstraintLayout.LayoutParams) r34;
        r35.setMarginStart(0);
        r35.setMarginEnd(0);
        r30.setLayoutParams(r35);
        if (r42.getSpanEnd(r43) == r42.length()) goto L227;
        r17 = false;
    L227:
        if (r16 == false) goto L229;
        int r112 = 0;
    L230:
        if (r17 == false) goto L233;
        if (r16 == true) goto L233;
        int r36 = getContext().getResources().getDimensionPixelSize(2131167562);
    L234:
        FLogger.a.i("updatePaddingRelative", "view:" + LynxBox.class.getSimpleName() + ",source:,start:0,top:" + r112 + ",end:0,bottom:" + r36);
        r30.setPaddingRelative(0, r112, 0, r36);
        r30.setMaxWidth(r29);
        r30.addOnLayoutChangeListener(this);
        if (this.c == null) goto L237;
        final Ref.ObjectRef r38 = new Ref.ObjectRef();
        final Message r39 = r37;
        r38.element = new l(this, r39);
        r30.setOnTimingSetupCallback(new m(r38));
        t0.d(new n(r38), 15000);
    L237:
        addView(r30, -1, -2);
        if (r27 == 0) goto L240;
    L243:
        int r113 = 0;
    L244:
        r30.setVisibility(r113);
        goto L248
    L240:
        if (this.c != null) goto L243;
        r113 = 4;
    L233:
        r36 = 0;
        goto L234
    L229:
        r112 = getContext().getResources().getDimensionPixelSize(2131167562);
        goto L230
    L246:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L197:
        LynxRenderDataRepo.c(r32, new oh8.e(r32, this, r30, r12));
        goto L220
    L199:
        if (r46.length() <= 0) goto L201;
        boolean r114 = true;
    L202:
        if (r114 == false) goto L220;
        if (r26 == null) goto L220;
        if (Intrinsics.areEqual(r30.getTemplateInfo().getTemplateId(), "9") == false) goto L219;
        JSONObject r40 = new JSONObject();
        a0 r47 = getChatConversationAbility();
        if (r47 == null) goto L209;
        String r48 = r47.getBotId();
    L210:
        r40.put("bot_id", r48);
        Message r49 = this.a;
        if (r49 == null) goto L213;
        r18 = r49.getMessageId();
    L213:
        r40.put("message_id", r18);
        Message r50 = this.a;
        if (r50 == null) goto L217;
        String r51 = r50.getConversationId();
        if (r51 == null) goto L217;
    L218:
        r40.put("conversation_id", r51);
        r40.put("map_type", "multiple");
        o.a.reportEvent("map_card_show", r40);
    L217:
        r51 = "";
        goto L218
    L209:
        r48 = null;
    L219:
        h(r30, r46);
        goto L220
    L201:
        r114 = false;
        goto L202
    L189:
        r111 = false;
        goto L190
    L185:
        return this.f;
    L179:
        if (r31.length() == 0) goto L182;
        r110 = false;
    L248:
        return this.f;
    L148:
        LruCache<String, List<LynxBox>> r52 = oh8.a.a;
        Message r53 = this.a;
        if (r53 == null) goto L151;
        String r54 = r53.getMessageId();
    L152:
        String r55 = this.i;
        r29 = r15;
        r28 = (int) (r29 / r24);
        if (r54 != null) goto L155;
    L158:
        boolean r115 = true;
    L159:
        if (r115 == true) goto L174;
        if (r55 != null) goto L162;
    L165:
        boolean r116 = true;
    L166:
        if (r116 == true) goto L174;
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L170
        r28 = oh8.a.b.getInt(r54 + '_' + r55, r28);     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        Throwable r58 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r58 == null) goto L174;
        FLogger.a.e("MarkdownLynxCacheManager", r58.toString());
        goto L174
    L162:
        if (r55.length() == 0) goto L165;
        r116 = false;
        goto L166
    L155:
        if (r54.length() == 0) goto L158;
        r115 = false;
        goto L159
    L151:
        r54 = null;
        goto L152
    L114:
        if (r5 == null) goto L118;
        Function0<? extends Fragment> r59 = r5.m;
        if (r59 == null) goto L118;
        Fragment r60 = (Fragment) r59.invoke();
    L119:
        if (r60 == null) goto L121;
        boolean r61 = true;
    L122:
        Context r210 = getContext();
        int r211 = r23.getGravity();
        AttachReceiver r117 = this.b;
        ry8.d r62 = this.c;
        if (r62 == null) goto L125;
        Fragment r212 = r62.f();
    L127:
        if (this.c == null) goto L129;
        boolean r213 = true;
    L131:
        if (Intrinsics.areEqual(r43.i(), "data-block-full") == true) goto L133;
    L135:
        boolean r310 = false;
    L136:
        String r63 = this.i;
        if (this.c == null) goto L139;
        boolean r311 = true;
    L140:
        r46 = r14;
        r37 = r11;
        e1 r214 = new e1(r15, true, true, true, r213, r310, r46, r63, r311, "com.ruyi.card", r61);
        if (r25 == false) goto L143;
        Message r215 = r37;
    L144:
        this.d = new LynxBox(r210, r211, r23, r117, r212, r214, r215, false, 128);
        goto L145
    L143:
        r215 = null;
        goto L144
    L139:
        r311 = false;
        goto L140
    L133:
        if (Intrinsics.areEqual(y0.f(this.e, "disable_full_card_border"), "1") == true) goto L135;
        r310 = true;
        goto L136
    L129:
        r213 = false;
        goto L131
    L125:
        r212 = null;
        goto L127
    L121:
        r61 = false;
    L118:
        r60 = null;
        goto L119
    L105:
        LruCache<String, List<LynxBox>> r118 = oh8.a.a;
        String r119 = getLynxCacheKey();
        Intrinsics.checkNotNullParameter(r119, "key");
        List<LynxBox> r120 = oh8.a.a.get(r119);
        if (r120 == null) goto L108;
        LynxBox r121 = (LynxBox) CollectionsKt.firstOrNull(r120);
    L109:
        if (r121 == null) goto L111;
        r120.remove(r121);
    L111:
        FLogger.a.i("MarkdownLynxCacheManager", "get cache lynxbox = " + r121);
        r26 = r121;
        goto L112
    L108:
        r121 = null;
    L101:
        r24 = 0.0f;
        goto L102
    L96:
        String r64 = y0.f(r20, "card_placeholder_ratio");
        if (r64 == null) goto L101;
        Float r65 = StringsKt.toFloatOrNull(r64);
        if (r65 == null) goto L101;
        r24 = r65.floatValue();
        goto L102
    L85:
        return this.f;
    L81:
        return this.f;
    L76:
        e = move-exception;
        FLogger.a.e("MarkdownLynxWidget", e.toString());
        r9 = null;
        goto L78
    L67:
        wc8.b r66 = wc8.b.a;
        String r67 = r11.getMessageId();
        if (r67 != null) goto L70;
        r67 = "";
    L70:
        r7 = r66.c(r67, r43.k(), "MarkdownLynxWidget");
        goto L71
    L63:
        r6 = false;
        goto L65
    L250:
        return this.f;
    L57:
        r4 = null;
        goto L58
    L53:
        r3 = null;
        goto L54
    L49:
        r2 = null;
        goto L51
    L45:
        r1 = null;
        goto L46
    L41:
        r11 = null;
        goto L42
    L38:
        r5 = null;
        goto L39
    L5:
        if (getLynxBoxViewMeasuredHeight() != 0) goto L7;
        this.f = new Size(r15, 0);
    L35:
        return this.f;
    L7:
        this.f = new Size(r15, r0.getMeasuredHeight());
        LruCache<String, List<LynxBox>> r68 = oh8.a.a;
        Message r69 = this.a;
        if (r69 == null) goto L10;
        r18 = r69.getMessageId();
    L10:
        String r70 = r18;
        String r71 = this.i;
        int r72 = r0.getMeasuredHeight();
        if (r70 != null) goto L13;
    L16:
        boolean r73 = true;
    L17:
        if (r73 == true) goto L31;
        if (r71 != null) goto L20;
    L23:
        if (r17 == true) goto L31;
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L27
        oh8.a.b.storeInt(r70 + '_' + r71, r72);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r75 = Result.Companion;
        Throwable r76 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r76 == null) goto L31;
        FLogger.a.e("MarkdownLynxCacheManager", r76.toString());
        goto L31
    L20:
        if (r71.length() == 0) goto L23;
        r17 = false;
    L31:
        LynxBox r77 = this.d;
        if (r77 == null) goto L35;
        r77.setVisibility(0);
        goto L35
    L13:
        if (r70.length() == 0) goto L16;
        r73 = false;
        goto L17
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r2 != r6) goto L6;
        if (r3 != r7) goto L6;
        if (r4 != r8) goto L6;
        if (r5 != r9) goto L6;
        return;
    L6:
        t0.c(new oh8.c(this));
    }
}
