package com.larus.bmhome.chat.detail;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.ixigua.lib.track.TrackParams;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.api.d0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.utils.z1;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.MarkDownSelectorSettings;
import com.larus.trace.CopyContentTypeString;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lw8.l;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.a1;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006*\u0001T\b&\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u0089\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010J\u001a\u00020\"H\u0002J\b\u0010K\u001a\u00020\"H\u0002J\n\u0010V\u001a\u0004\u0018\u00010WH&J\b\u0010X\u001a\u00020YH&J\b\u0010Z\u001a\u00020YH&J\u0012\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\n\u0010_\u001a\u0004\u0018\u00010\u000fH\u0015J\"\u0010`\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010a\u001a\u00020\"H\u0004J\b\u0010b\u001a\u00020\\H\u0016J\u001a\u0010c\u001a\u00020\\2\u0006\u0010d\u001a\u00020e2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u0010\u0010f\u001a\u00020\\2\u0006\u0010g\u001a\u00020hH\u0016J\b\u0010i\u001a\u00020\\H\u0002J\u0010\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020mH\u0004J\u0018\u0010n\u001a\u00020o2\u0006\u0010l\u001a\u00020m2\u0006\u0010p\u001a\u00020\"H\u0004J\b\u0010q\u001a\u00020\\H\u0002J\u0018\u0010r\u001a\u00020\\2\u0006\u0010s\u001a\u00020m2\u0006\u0010t\u001a\u00020\"H\u0002J\u0012\u0010u\u001a\u0004\u0018\u00010v2\u0006\u0010s\u001a\u00020mH\u0002J\b\u0010w\u001a\u00020\"H&J\b\u0010x\u001a\u00020\\H\u0016J\b\u0010y\u001a\u00020\\H\u0016J\b\u0010z\u001a\u00020\\H\u0016J\b\u0010{\u001a\u00020\\H\u0016J\b\u0010|\u001a\u00020\\H\u0016J\u0012\u0010}\u001a\u00020\\2\b\b\u0002\u0010~\u001a\u00020\"H\u0016J\b\u0010\u007f\u001a\u00020\\H\u0016J&\u0010\u0081\u0001\u001a\u00020\\2\u0007\u0010\u0082\u0001\u001a\u00020\u000f2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\b\b\u0002\u0010~\u001a\u00020\"H\u0016J\u0011\u0010\u0085\u0001\u001a\u00020\\2\u0006\u0010d\u001a\u00020eH\u0016J\t\u0010\u0086\u0001\u001a\u00020\\H\u0005J\t\u0010\u0087\u0001\u001a\u00020\\H\u0005J\t\u0010\u0088\u0001\u001a\u00020\\H\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&R\u001a\u0010;\u001a\u00020.X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00100\"\u0004\b=\u00102R\u001a\u0010>\u001a\u00020\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010\u0014R\u001a\u0010A\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010$\"\u0004\bC\u0010&R\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bF\u0010GR\u000e\u0010L\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010N\u001a\u0004\u0018\u00010O8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bR\u0010I\u001a\u0004\bP\u0010QR\u0010\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0004\n\u0002\u0010UR\u000f\u0010\u0080\u0001\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"}, d2 = {"Lcom/larus/bmhome/chat/detail/AbstractCommonDetailFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "runtimeParamProvider", "Lcom/larus/bmhome/chat/detail/IBlockCommonDetailProvider;", "<init>", "(Lcom/larus/bmhome/chat/detail/IBlockCommonDetailProvider;)V", "getRuntimeParamProvider", "()Lcom/larus/bmhome/chat/detail/IBlockCommonDetailProvider;", "markDownTextView", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "getMarkDownTextView", "()Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "setMarkDownTextView", "(Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;)V", "value", "", "messageId", "getMessageId", "()Ljava/lang/String;", "setMessageId", "(Ljava/lang/String;)V", "conversationId", "getConversationId", "setConversationId", "info", "getInfo", "setInfo", "contentStr", "getContentStr", "setContentStr", "contentMarkDown", "getContentMarkDown", "setContentMarkDown", "enableDynamicCodeFence", "", "getEnableDynamicCodeFence", "()Z", "setEnableDynamicCodeFence", "(Z)V", "currentBot", "Lcom/larus/im/bean/bot/BotModel;", "getCurrentBot", "()Lcom/larus/im/bean/bot/BotModel;", "setCurrentBot", "(Lcom/larus/im/bean/bot/BotModel;)V", "chatKey", "", "getChatKey", "()J", "setChatKey", "(J)V", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "setChatParam", "(Lcom/larus/bmhome/chat/ChatParam;)V", "isImmersive", "setImmersive", "enterTime", "getEnterTime", "setEnterTime", "copyContent", "getCopyContent", "setCopyContent", "delayRender", "getDelayRender", "setDelayRender", "markDownSelectorSettings", "Lcom/larus/platform/model/MarkDownSelectorSettings;", "getMarkDownSelectorSettings", "()Lcom/larus/platform/model/MarkDownSelectorSettings;", "markDownSelectorSettings$delegate", "Lkotlin/Lazy;", "isTripleClickEnabled", "isReClickEnabled", "latestDoubleClickTime", "latestTripleClickTime", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "clickRunnable", "com/larus/bmhome/chat/detail/AbstractCommonDetailFragment$clickRunnable$1", "Lcom/larus/bmhome/chat/detail/AbstractCommonDetailFragment$clickRunnable$1;", "getMarkDownTextViewContainer", "Landroid/view/ViewGroup;", "getMarkdownTextSize", "", "getLineSpacingMult", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getCopyContentType", "getContentMarkdownForCode", "addExtraLine", "initParams", "onViewCreated", "view", "Landroid/view/View;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initView", "getTableConfig", "Lcom/larus/business/markdown/api/model/TableConfig;", "context", "Landroid/content/Context;", "getCodeBlockConfig", "Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "enableScroll", "setupMarkDownView", "bindTextView", "ctx", "isBackground", "createDetailMarkdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "enableScrollDefault", "onResume", "onPause", "onDestroy", "logEnterPage", "performSingleClick", "performDoubleClick", "isReClick", "performTripleClick", "waitForReSelect", "doPerformClick", "clickFrom", "clickCount", "", "performLongClick", "toggleScreenOrientation", "setOrientationToPortrait", "setOrientationToLandscape", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class AbstractCommonDetailFragment extends TraceFragment {
    public static final /* synthetic */ int z = 0;
    public final i e;
    public CustomMarkdownTextView f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public BotModel m;
    public long n;
    public ChatParam o;
    public boolean p;
    public long q;
    public String r;
    public boolean s;
    public final Lazy t;
    public long u;
    public long v;
    public final Lazy w;
    public final b x;
    public boolean y;

    public static final class a {
    }

    public static final class b implements Runnable {
        public int a;
        public final /* synthetic */ AbstractCommonDetailFragment b;

        public final void a() {
            int r0 = this.a;
            if (r0 != 1) goto L6;
            this.b.getClass();
        L13:
            this.a = 0;
            return;
        L6:
            if (r0 != 2) goto L9;
            AbstractCommonDetailFragment r1 = this.b;
            r1.u = SystemClock.elapsedRealtime();
            AbstractCommonDetailFragment r2 = this.b;
            r2.getClass();
            FLogger.a.i("AbstractCommonDetailFragment", "[selector_view]performDoubleClick");
            r2.Y90("double_click_text", 2, false);
            goto L13
        L9:
            if (r0 != 3) goto L13;
            if (AbstractCommonDetailFragment.W90(this.b) == false) goto L13;
            AbstractCommonDetailFragment r3 = this.b;
            r3.v = SystemClock.elapsedRealtime();
            AbstractCommonDetailFragment r4 = this.b;
            r4.getClass();
            FLogger.a.i("AbstractCommonDetailFragment", "[selector_view]performTripleClick");
            r4.Y90("triple_click_text", 3, false);
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(AbstractCommonDetailFragment r1) {
            this.b = r1;
        }
    }

    public static final class c implements d0 {
        public final /* synthetic */ AbstractCommonDetailFragment a;

        public c(AbstractCommonDetailFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void a(View r3, int r4, int r5) {
            if (r3 != null) goto L4;
            return;
        L4:
            if (Intrinsics.areEqual(r3, this.a.f) == true) goto L7;
            return;
        L7:
            if (r5 == 2) goto L9;
            return;
        L9:
            if (((MarkDownSelectorSettings) this.a.t.getValue()).getDoubleClickShiftStrategy() <= 0) goto L11;
            boolean r6 = true;
        L12:
            if (r6 == false) goto L17;
            final AbstractCommonDetailFragment r7 = this.a;
            r7.y = true;
            r3.postDelayed(new h(r7), 100);
            return;
        L17:
            return;
        L11:
            r6 = false;
            goto L12
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void b(SelectionRangeType r1, int r2, int r3, boolean r4, boolean r5, Rect r6, String r7) {
            d0.a.a(r1, r7);
        }
    }

    public static final class d implements View.OnLayoutChangeListener {
        public final /* synthetic */ AbstractCommonDetailFragment a;

        public d(AbstractCommonDetailFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            AbstractCommonDetailFragment.V90(this.a);
        }
    }

    static {
    }

    public AbstractCommonDetailFragment() {
        this(null);
    }

    public abstract boolean Z90();

    @CopyContentTypeString
    public String ca0() {
        return null;
    }

    public abstract float da0();

    public abstract ViewGroup fa0();

    public abstract float ga0();

    public final void T90() {
        String r16 = k();
        boolean r0 = false;
        if (r16 != null) goto L5;
    L10:
        if (r0 == false) goto L24;
        ChatParam r1 = this.o;
        String r2 = null;
        if (r1 == null) goto L14;
        String r30 = r1.d;
    L15:
        String r4 = this.g;
        String r3 = this.h;
        i r5 = this.e;
        if (r5 == null) goto L18;
        String r31 = r5.c();
    L19:
        BotModel r6 = this.m;
        if (r6 == null) goto L22;
        r2 = r6.getBotId();
    L22:
        a1.c(r2, null, null, null, r3, null, null, null, "click_full_screen_preview", null, null, null, null, null, null, r16, r30, null, null, null, null, null, null, null, null, null, null, null, null, null, r4, r31, null, null, null, null, null, null, null, null, null, null, null, null, this, null, null, null, null, null, null, null, -1573955, -16778753, 7);
        return;
    L18:
        r31 = null;
        goto L19
    L14:
        r30 = null;
        goto L15
    L24:
        return;
    L5:
        if (r16.length() <= 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 != true) goto L10;
        r0 = true;
        goto L10
    L7:
        r7 = false;
        goto L8
    }

    public final l0 ea0() {
        return (l0) this.w.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.detail.b] */
    private final void initView() {
        Context r0 = getContext();
        if (r0 == null) goto L15;
        CustomMarkdownTextView r1 = new CustomMarkdownTextView(r0, null, 6, 0);
        Lazy r2 = z1.a;
        View r3 = getView();
        if (r3 == null) goto L7;
        int r4 = r3.getWidth();
    L8:
        r1.setMarkdownWidth(z1.i(r4));
        r1.setBottomLineWeight(i5.x0(v19.c.b(2130971253, null, 2131166876)));
        r1.setLineColor(1207959551);
        r1.setTextSize(0, ga0());
        r1.setLineSpacing(0.0f, da0());
        int r5 = i5.Y();
        int r6 = i5.Y();
        FLogger.a.i("updatePaddingRelative", "view:CustomMarkdownTextView,source:,start:0,top:" + r5 + ",end:0,bottom:" + r6);
        r1.setPaddingRelative(0, r5, 0, r6);
        ViewGroup r7 = fa0();
        if (r7 == null) goto L11;
        r7.removeAllViews();
    L11:
        ViewGroup r8 = fa0();
        if (r8 == null) goto L14;
        r8.addView(r1, new ViewGroup.LayoutParams(-1, -2));
    L14:
        this.f = r1;
        r1.setOnClickListener(new f(this));
        r1.setOnLongClickListener(new g(this));
        goto L15
    L7:
        r4 = 0;
    L15:
        final ?? r9 = new com.larus.bmhome.chat.detail.b(this);
        if (this.s == false) goto L18;
        t0.c(new com.larus.bmhome.chat.detail.c(r9));
        return;
    L18:
        r9.invoke();
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        BotModel r0 = this.m;
        if (r0 == null) goto L5;
        String r1 = r0.getBotId();
    L6:
        String r2 = this.g;
        Long r3 = Long.valueOf(System.currentTimeMillis() - this.q);
        JSONObject r4 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r1 != null) goto L20;
    L11:
        if (r2 == null) goto L13;
        r4.put("message_id", r2);     // Catch: JSONException -> L9
    L13:
        r4.put("user_type", "bot");     // Catch: JSONException -> L9
        if (r3 == null) goto L18;
        r4.put("duration", r3.longValue());     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        FLogger.a.e("FullScreenEventHelper", "error in FullScreenEventHelper leaveFullScreenPreview " + e.getLocalizedMessage());
    L18:
        TrackParams r5 = new TrackParams().merge(r4);
        by7.a r6 = new by7.a("leave_full_screen_preview");
        r6.b = this;
        r6.a.merge(r5);
        r6.b();
        return;
    L20:
        r4.put("bot_id", r1);     // Catch: JSONException -> L9
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        b r0 = this.x;
        r0.a = 0;
        t0.a.removeCallbacks(r0);
    }

    public final void onResume() {
        super.onResume();
        this.x.a = 0;
        this.q = System.currentTimeMillis();
    }

    public AbstractCommonDetailFragment(i r3) {
        this.e = r3;
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.q = -1;
        this.r = "";
        this.t = LazyKt.lazy(new com.larus.bmhome.chat.detail.d());
        this.w = LazyKt.lazy(new e(this));
        this.x = new b(this);
    }

    public static void U90(AbstractCommonDetailFragment r9) {
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - r9.v) <= 300) goto L22;
        boolean r6 = true;
        if ((r0 - r9.u) <= 300) goto L8;
    L13:
        b r10 = r9.x;
        int r1 = r10.a + 1;
        r10.a = r1;
        if (r1 == 1) goto L17;
        r6 = false;
    L17:
        if (r6 == false) goto L21;
        t0.a.postDelayed(r10, 300);
        return;
    L21:
        return;
    L8:
        if (((MarkDownSelectorSettings) r9.t.getValue()).getTripleClickStrategy() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        FLogger.a.i("AbstractCommonDetailFragment", "[selector_view]performTripleClick");
        r9.Y90("triple_click_text", 3, false);
        r9.v = r0;
        return;
    L10:
        r2 = false;
        goto L11
    }

    public static final /* synthetic */ void V90(AbstractCommonDetailFragment r0) {
        r0.initView();
    }

    public static final boolean W90(AbstractCommonDetailFragment r0) {
        if (((MarkDownSelectorSettings) r0.t.getValue()).getTripleClickStrategy() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final l X90(Context r60) {
        gw8.c.a.getClass();
        gw8.c r2 = gw8.c.a.b();
        Integer r3 = null;
        if (r2 == null) goto L24;
        CustomMarkdownTextView r4 = this.f;
        String r5 = this.k;
        CodeBlockConfig r33 = aa0(r60, Z90());
        Intrinsics.checkNotNullParameter(r60, "context");
        View r6 = getView();
        int r9 = 0;
        if (r6 == null) goto L14;
        Integer r7 = Integer.valueOf(r6.getWidth());
        if (r7.intValue() <= 0) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == false) goto L12;
        r3 = r7;
    L12:
        if (r3 == null) goto L14;
        int r8 = r3.intValue();
    L15:
        View r11 = getView();
        if (r11 == null) goto L18;
        int r12 = r11.getPaddingStart();
    L19:
        int r13 = r8 - r12;
        View r14 = getView();
        if (r14 == null) goto L22;
        r9 = r14.getPaddingEnd();
    L22:
        int r15 = r13 - r9;
        int r16 = i5.r0();
        int r17 = i5.r0();
        float r18 = we8.a.a(i5.o(), this.p);
        int r19 = i5.b();
        int r110 = ContextCompat.getColor(r60, v19.c.b(2130972089, r60, 2131103169));
        int r111 = i5.q();
        int r25 = i5.r0();
        int r20 = ContextCompat.getColor(r60, R.color.transparent);
        int r0 = ContextCompat.getColor(r60, v19.c.b(2130972086, r60, 2131103159));
        return gw8.c.b.b(r2, r4, r5, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, r33, new TableConfig(false, 0, Float.valueOf(r18), Integer.valueOf(r19), Integer.valueOf(r110), null, Integer.valueOf(r17), Integer.valueOf(r16), Integer.valueOf(r15), Integer.valueOf(r15 / 2), Integer.valueOf(r111), Integer.valueOf(r25), null, null, false, false, false, false, false, null, Integer.valueOf(r20), Integer.valueOf(r0), 1044515, null), null, null, null, null, new mw8.b(ga0(), ContextCompat.getColor(r60, v19.c.b(2130972079, r60, 2131103136))), null, -6291457, 30));
    L18:
        r12 = 0;
        goto L19
    L9:
        r10 = false;
    L14:
        r8 = com.larus.utils.i.f(r60);
        goto L15
    L24:
        return null;
    }

    public void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        View r3 = getView();
        if (r3 == null) goto L6;
        r3.addOnLayoutChangeListener(new d(this));
        return;
    }

    public void onCreate(Bundle r6) {
        super.onCreate(r6);
        i r7 = this.e;
        if (r7 == null) goto L5;
        getArguments();
        r7.v();
    L5:
        Bundle r8 = getArguments();
        String r0 = "";
        if (r8 == null) goto L9;
        String r9 = r8.getString("key_mark_down_detail_raw_content");
        if (r9 == null) goto L9;
    L10:
        this.j = r9;
        Bundle r10 = getArguments();
        if (r10 == null) goto L14;
        String r11 = r10.getString("key_code_block_code_info");
        if (r11 == null) goto L14;
    L15:
        this.i = r11;
        Bundle r12 = getArguments();
        boolean r1 = false;
        if (r12 == null) goto L20;
        boolean r2 = true;
        if (r12.getBoolean("key_enable_dynamic_code_fence") != true) goto L20;
    L21:
        this.l = r2;
        if (Intrinsics.areEqual(k(), "code_full_screen_page") == false) goto L24;
        String r13 = ba0(this.i, this.j, false);
    L25:
        this.k = r13;
        Bundle r14 = getArguments();
        if (r14 == null) goto L29;
        String r15 = r14.getString("key_mark_down_detail_message_id");
        if (r15 == null) goto L29;
    L30:
        Intrinsics.checkNotNullParameter(r15, "value");
        i r3 = this.e;
        if (r3 == null) goto L33;
        r3.e(r15);
    L33:
        this.g = r15;
        Bundle r16 = getArguments();
        if (r16 == null) goto L37;
        String r17 = r16.getString("key_mark_down_detail_conversation_id");
        if (r17 == null) goto L37;
    L38:
        Intrinsics.checkNotNullParameter(r17, "value");
        i r4 = this.e;
        if (r4 == null) goto L41;
        r4.setConversationId(r17);
    L41:
        this.h = r17;
        Bundle r18 = getArguments();
        ChatParam r5 = null;
        if (r18 == null) goto L44;
        Serializable r19 = r18.getSerializable("key_mark_down_detail_bot_model");
    L46:
        if ((r19 instanceof BotModel) == false) goto L48;
        BotModel r20 = (BotModel) r19;
    L49:
        this.m = r20;
        Bundle r21 = getArguments();
        if (r21 == null) goto L52;
        long r22 = r21.getLong("key_mark_down_detail_chat_unique_key");
    L53:
        this.n = r22;
        Bundle r23 = getArguments();
        if (r23 == null) goto L56;
        ChatParam r24 = (ChatParam) r23.getParcelable("key_mark_down_detail_chat_param");
    L58:
        if ((r24 instanceof ChatParam) == false) goto L60;
        r5 = r24;
    L60:
        this.o = r5;
        Bundle r25 = getArguments();
        if (r25 == null) goto L63;
        boolean r26 = r25.getBoolean("key_mark_down_detail_is_immersive");
    L64:
        this.p = r26;
        Bundle r27 = getArguments();
        if (r27 == null) goto L70;
        String r28 = r27.getString("key_mark_down_detail_copy_content");
        if (r28 == null) goto L70;
        r0 = r28;
    L70:
        this.r = r0;
        Bundle r29 = getArguments();
        if (r29 == null) goto L73;
        r1 = r29.getBoolean("key_code_delay_render");
    L73:
        this.s = r1;
        return;
    L63:
        r26 = false;
        goto L64
    L56:
        r24 = null;
        goto L58
    L52:
        r22 = 0;
        goto L53
    L48:
        r20 = null;
        goto L49
    L44:
        r19 = null;
    L37:
        r17 = "";
    L29:
        r15 = "";
        goto L30
    L24:
        r13 = this.j;
    L20:
        r2 = false;
    L14:
        r11 = ChatDraftItem.TYPE_TEXT;
    L9:
        r9 = "";
        goto L10
    }

    public final CodeBlockConfig aa0(Context r33, boolean r34) {
        Intrinsics.checkNotNullParameter(r33, "context");
        int r7 = (int) ga0();
        int r0 = ContextCompat.getColor(r33, v19.c.b(2130972080, r33, 2131103140));
        return new CodeBlockConfig(0, 0, false, null, 0, Integer.valueOf(r7), false, null, false, false, null, false, 0, 0, null, null, r34, true, Integer.valueOf(r0), false, null, null, null, false, null, false, false, 133744540, null);
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        initView();
    }

    public final void Y90(String r14, int r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r14, "clickFrom");
        if (this.y == false) goto L6;
        if (r16 == true) goto L6;
        return;
    L6:
        this.y = false;
        i r0 = this.e;
        if (r0 == null) goto L17;
        BotModel r2 = this.m;
        ChatParam r1 = this.o;
        if (r1 == null) goto L11;
        String r3 = r1.e;
    L12:
        String r4 = r3;
        long r5 = this.n;
        CustomMarkdownTextView r6 = this.f;
        if (r6 != null) goto L15;
        return;
    L15:
        r0.d(this, r2, r4, r5, r6, r14, r15, r16, ca0(), new c(this));
        return;
    L11:
        r3 = null;
        goto L12
    }

    public final String ba0(String r9, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "info");
        Intrinsics.checkNotNullParameter(r10, "contentStr");
        if (r11 == false) goto L5;
        String r12 = "\r\n ";
    L7:
        if (r10.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        String r1 = " ";
    L14:
        if (this.l == false) goto L24;
        int r3 = 3;
        int r4 = 0;
        int r5 = 0;
    L17:
        if (r4 >= r10.length()) goto L23;
        if (r10.charAt(r4) != '`') goto L21;
        r5 = r5 + 1;
    L22:
        r3 = Math.max(r3, r5 + 1);
        r4 = r4 + 1;
        goto L17
    L21:
        r5 = 0;
        goto L22
    L23:
        String r13 = StringsKt.repeat("`", r3);
    L26:
        return r13 + r9 + "\r\n" + r1 + r12 + "\r\n" + r13;
    L24:
        r13 = "```";
        goto L26
    L12:
        r1 = r10;
        goto L14
    L9:
        r0 = false;
        goto L10
    L5:
        r12 = "";
        goto L7
    }
}
