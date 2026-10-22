package com.larksuite.component.card.component.text;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.lark.pb.openplatform.v1.GetUuidRequest;
import com.google.gson.Gson;
import com.larksuite.component.card.action.InteractiveHandler;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxEventDetail;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.light.touch.TouchConsumeView;
import com.ss.android.lark.widget.span.UrlInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001WB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0007J\u0012\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u0012\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u0010.\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002J\n\u00101\u001a\u0004\u0018\u000102H\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u000205H\u0002J\u0012\u00106\u001a\u00020\u000e2\b\u00107\u001a\u0004\u0018\u000108H\u0016J \u00109\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001b2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=J\u001a\u0010>\u001a\u00020\u000e2\u0006\u00104\u001a\u0002052\b\u0010?\u001a\u0004\u0018\u000102H\u0002J\b\u0010@\u001a\u00020\u000eH\u0002J\b\u0010A\u001a\u00020\u0010H\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\b\u0010C\u001a\u00020\u001dH\u0002J\u0010\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020FH\u0002J\u0018\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u0017H\u0002J\u000e\u0010J\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020-J\b\u0010K\u001a\u00020\u001dH\u0002J\b\u0010L\u001a\u00020\u001dH\u0002J\u0010\u0010M\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020-H\u0002J\u001e\u0010N\u001a\u00020\u001d2\u0014\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020Q\u0018\u00010PH\u0016J\u0010\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\bH\u0002J\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0017H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006X"}, d2 = {"Lcom/larksuite/component/card/component/text/UniversalCardTextLynxUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/card/component/text/UniversalCardLightTextView;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "currentSelectionInfo", "Lcom/ss/android/lark/widget/select/SelectedTextInfo;", "selectionHelper", "Lcom/ss/android/lark/widget/select/TextSelectHelper;", "interactiveHandler", "Lcom/larksuite/component/card/action/InteractiveHandler;", "enableShowMore", "", "selectCopyWindow", "Landroid/widget/PopupWindow;", "getSelectCopyWindow", "()Landroid/widget/PopupWindow;", "selectCopyWindow$delegate", "Lkotlin/Lazy;", "previewImages", "", "", "checker", "Lcom/ss/android/lark/widget/listener/DuplicateEnterChecker;", "createView", "Landroid/content/Context;", "updateExtraData", "", "extraData", "", "contentText", "getContentText", "()Ljava/lang/String;", "setContentText", "(Ljava/lang/String;)V", "setContent", "props", "Lcom/lynx/react/bridge/ReadableMap;", "setPreviewImages", "images", "Lcom/lynx/react/bridge/ReadableArray;", "updateView", "textContent", "Lcom/larksuite/component/card/component/text/TextProps;", "resetView", "resetSelection", "disableNativeClick", "getCurrentShareData", "Lcom/larksuite/component/card/cardcontainer/UniversalCardShareData;", "initListener", "textView", "Lcom/ss/android/lark/widget/light/LKUILightTextView;", "dispatchEvent", "event", "Lcom/lynx/tasm/event/LynxEventDetail;", "doCopyText", "copyText", "", "token", "Lcom/bytedance/supervisor/token/Token;", "enableCopy", "cardShareData", "inDetailPage", "prepareSelectionWindow", "handleSelectionWindowDismiss", "handleSelectionTextCopy", "handleUrlClick", "urlInfo", "Lcom/ss/android/lark/widget/span/UrlInfo;", "handleAudioClick", "tag", "id", "setImageClickListener", "disableAtClick", "disableLinkClick", "setBaseStyle", "setEvents", "events", "", "Lcom/lynx/tasm/event/EventsListener;", "handleTextSelect", "info", "parseTextAlign", "", "textAlign", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardTextLynxUI extends LynxUI<UniversalCardLightTextView> {
    public static final /* synthetic */ int g = 0;
    public com.ss.android.lark.widget.select.g a;
    public com.ss.android.lark.widget.select.m b;
    public final InteractiveHandler c;
    public final Lazy d;
    public final List<String> e;
    public final rcc.a f;

    public static final class a {
    }

    static {
    }

    public final void Q() {
        Object r0 = ((LynxUI) this).mView;
        if (r0 == null) goto L5;
        ((UniversalCardLightTextView) r0).setUseOuterLayout(true);
        LKUILightTextView r1 = (UniversalCardLightTextView) ((LynxUI) this).mView;
        r1.setSpacingExtra(UIUtils.dp2px(r1.getContext(), 4.0f));
        ((UniversalCardLightTextView) ((LynxUI) this).mView).setEllipsize(TextUtils.TruncateAt.END);
        ((UniversalCardLightTextView) ((LynxUI) this).mView).setTextSize(UIUtils.dp2px(((LynxBaseUI) this).mContext.getContext(), 14.0f));
        LKUILightTextView r2 = ((LynxUI) this).mView;
        r2.setUrlSpanClickListener(new k(this));
        r2.setAtSpanClickListener(new l(this));
        r2.setOnClickListener(m.a);
        r2.setOnLongClickListener(new n(this, r2));
        r2.setCodeBlockV2SpanCLickListener(new o(r2));
        r2.setPersonSpanClickListener(new p(this));
        r2.setCardSpanClickListener(new q(this));
        ((UniversalCardLightTextView) ((LynxUI) this).mView).setGravity(3);
    L5:
        com.ss.android.lark.widget.select.m r3 = this.b;
        if (r3 == null) goto L8;
        r3.a();
    L8:
        com.ss.android.lark.widget.select.m r4 = this.b;
        if (r4 == null) goto L12;
        r4.h();
        return;
    }

    public final com.larksuite.component.card.cardcontainer.c O() {
        return (com.larksuite.component.card.cardcontainer.c) getLynxContext().getSharedData("card_share_data", com.larksuite.component.card.cardcontainer.c.class);
    }

    public UniversalCardTextLynxUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = new InteractiveHandler();
        this.d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UniversalCardTextLynxUI$selectCopyWindow$2(this));
        this.e = new ArrayList();
        this.f = new rcc.a();
    }

    public static final /* synthetic */ LynxContext M(UniversalCardTextLynxUI r0) {
        return ((LynxBaseUI) r0).mContext;
    }

    public static final /* synthetic */ View N(UniversalCardTextLynxUI r0) {
        return ((LynxUI) r0).mView;
    }

    public final void P(final UrlInfo r8) {
        if (this.f.a() == false) goto L6;
        Log.e("UniversalCardTextLynxUI", "url check isDuplicate: " + r8.href.hashCode());
        return;
    L6:
        final com.larksuite.component.card.cardcontainer.c r0 = O();
        if (r0 != null) goto L10;
        Log.e("UniversalCardTextLynxUI", "cardShareData null");
        return;
    L10:
        int r2 = com.larksuite.component.card.monitor.a.a;
        com.larksuite.component.card.monitor.a.c(r0.b.getVersion(), "markdown", r8.href, r0.c.getMonitorData(), r0.b.getCardID());
        Context r3 = ((LynxBaseUI) this).mContext.getContext();
        String r4 = r8.href;
        if (TextUtils.isEmpty(r4) == false) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L19;
        Log.e("UniversalCardTextLynxUI", "url check interceptUrl: " + r8.href.hashCode());
        return;
    L19:
        CardDataUtils r1 = CardDataUtils.a;
        Function1<String, Unit> r6 = new UniversalCardTextLynxUI$handleUrlClick$1(this, r8, r0);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "callback");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.larksuite.component.card.utils.b(new GetUuidRequest.Builder(), r6));
        return;
    L13:
        if (r4.toLowerCase().startsWith("lark://msgcard/unsupported_action") == false) goto L15;
        LKUIToast.show(r3, 2131891987);
        r5 = true;
        goto L16
    }

    public final void R(TextProps r12) {
        if (r12 != null) goto L7;
        Log.e("UniversalCardTextLynxUI", "setContent fail, content is empty");
        return;
    L7:
        if (r12.getPaddingLeft() == null) goto L9;
    L14:
        LKUILightTextView r1 = (UniversalCardLightTextView) ((LynxUI) this).mView;
        Context r2 = ((LynxBaseUI) this).mContext.getContext();
        Integer r3 = r12.getPaddingLeft();
        float r4 = 0.0f;
        if (r3 == null) goto L17;
        float r5 = r3.intValue();
    L18:
        int r6 = UIUtils.dp2px(r2, r5);
        Context r7 = ((LynxBaseUI) this).mContext.getContext();
        Integer r8 = r12.getPaddingTop();
        if (r8 == null) goto L21;
        float r9 = r8.intValue();
    L22:
        int r10 = UIUtils.dp2px(r7, r9);
        Context r11 = ((LynxBaseUI) this).mContext.getContext();
        Integer r13 = r12.getPaddingRight();
        if (r13 == null) goto L25;
        float r14 = r13.intValue();
    L26:
        int r15 = UIUtils.dp2px(r11, r14);
        Context r16 = ((LynxBaseUI) this).mContext.getContext();
        Integer r17 = r12.getPaddingBottom();
        if (r17 == null) goto L29;
        r4 = r17.intValue();
    L29:
        r1.setPadding(r6, r10, r15, UIUtils.dp2px(r16, r4));
    L30:
        String r19 = r12.getBgColor();
        int r20 = 0;
        if (r19 != null) goto L33;
    L44:
        String r21 = r12.getTextColor();
        if (r21 == null) goto L59;
        if (r21.length() <= 0) goto L49;
        boolean r22 = true;
    L50:
        if (r22 == true) goto L53;
        r21 = null;
    L53:
        if (r21 == null) goto L59;
        ((UniversalCardLightTextView) ((LynxUI) this).mView).setTextColor(Color.parseColor(r21));     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        Log.e("UniversalCardTextLynxUI", "textColor parseColor failed", th);
        goto L59
    L49:
        r22 = false;
    L59:
        if (TextUtils.isEmpty(r12.getAlign()) == false) goto L61;
    L99:
        UniversalCardLightTextView r0 = (UniversalCardLightTextView) ((LynxUI) this).mView;
        Float r23 = r12.getLineSpacing();
        if (r23 == null) goto L102;
        float r24 = r23.floatValue();
    L103:
        r0.setSpacingExtra(r24);
        Boolean r25 = r12.getAtClickable();
        Boolean r26 = Boolean.FALSE;
        if (Intrinsics.areEqual(r25, r26) == false) goto L107;
        ((UniversalCardLightTextView) ((LynxUI) this).mView).setAtSpanClickListener(new h());
    L107:
        if (Intrinsics.areEqual(r12.getLinkClickable(), r26) == false) goto L110;
        ((UniversalCardLightTextView) ((LynxUI) this).mView).setUrlSpanClickListener(new i());
    L110:
        if (Intrinsics.areEqual(r12.getAtClickable(), r26) == false) goto L112;
    L113:
        UniversalCardLightTextView r27 = (UniversalCardLightTextView) ((LynxUI) this).mView;
        if (r27 == null) goto L116;
        r27.setOnClickListener(null);
    L116:
        Intrinsics.checkNotNullParameter(r12, "props");
        ((UniversalCardLightTextView) ((LynxUI) this).mView).setImageSpanClickListener(new t(this, r12));
        return;
    L112:
        if (Intrinsics.areEqual(r12.getLinkClickable(), r26) == false) goto L116;
    L102:
        r24 = UIUtils.dp2px(((UniversalCardLightTextView) ((LynxUI) this).mView).getContext(), 4.0f);
        goto L103
    L61:
        if (r12.getAlign() == null) goto L99;
        UniversalCardLightTextView r29 = (UniversalCardLightTextView) ((LynxUI) this).mView;
        String r30 = r12.getAlign();
        if (TextUtils.isEmpty(r30) == true) goto L97;
        String[] r31 = (String[]) StringsKt.split$default(r30, new String[]{"\\|"}, false, 0, 6, null).toArray(new String[0]);
        if (r31.length != 0) goto L67;
        boolean r32 = true;
    L69:
        if ((true ^ r32) == false) goto L97;
        int r33 = r31.length;
        int r34 = 0;
    L71:
        if (r20 >= r33) goto L95;
        String r35 = r31[r20];
        if (TextUtils.isEmpty(r35) == true) goto L75;
        r35 = r35.toLowerCase(Locale.ROOT);
    L75:
        int r36 = r35.hashCode();
        if (r36 == (-1364013995)) goto L91;
        if (r36 == 3317767) goto L87;
        if (r36 != 108511772) goto L94;
        if (r35.equals("right") == false) goto L94;
        r34 = r34 | 5;
    L94:
        r20 = r20 + 1;
        goto L71
    L87:
        if (r35.equals("left") == false) goto L94;
        r34 = r34 | 3;
        goto L94
    L91:
        if (r35.equals("center") == false) goto L94;
        r34 = r34 | 1;
        goto L94
    L95:
        if (r34 == 0) goto L97;
    L98:
        r29.setGravity(r34);
        goto L99
    L67:
        r32 = false;
    L97:
        r34 = 3;
        goto L98
    L33:
        if (r19.length() <= 0) goto L35;
        boolean r37 = true;
    L36:
        if (r37 == true) goto L39;
        r19 = null;
    L39:
        if (r19 == null) goto L44;
        ((UniversalCardLightTextView) ((LynxUI) this).mView).setBackgroundColor(Color.parseColor(r19));     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        Log.e("UniversalCardTextLynxUI", "setBackgroundColor parseColor failed", th);
        goto L44
    L35:
        r37 = false;
        goto L36
    L25:
        r14 = 0.0f;
        goto L26
    L21:
        r9 = 0.0f;
        goto L22
    L17:
        r5 = 0.0f;
        goto L18
    L9:
        if (r12.getPaddingRight() != null) goto L14;
        if (r12.getPaddingTop() != null) goto L14;
        if (r12.getPaddingBottom() == null) goto L30;
        goto L14
    }

    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new UniversalCardLightTextView(r2);
    }

    public final boolean dispatchEvent(LynxEventDetail r8) {
        Object r0 = ((LynxUI) this).mView;
        if (((UniversalCardLightTextView) r0) == null) goto L41;
        boolean r1 = r0 instanceof LKUILightTextView;
        Integer r2 = null;
        if (r8 == null) goto L7;
        String r3 = r8.a.getName();
    L9:
        if (TextUtils.equals(r3, "tap") == false) goto L41;
        LKUILightTextView r4 = (UniversalCardLightTextView) ((LynxUI) this).mView;
        if (r8 == null) goto L13;
        Integer r5 = Integer.valueOf((int) r8.a().a);
    L14:
        if (r8 == null) goto L16;
        r2 = Integer.valueOf((int) r8.a().b);
    L16:
        r4.getClass();
        boolean r9 = false;
        if (r5 == null) goto L42;
        if (r2 == null) goto L46;
        Layout r6 = r4.U;
        if (r6 != null) goto L23;
        return false;
    L23:
        if ((r6.getText() instanceof Spanned) == false) goto L44;
        TouchConsumeView.c r7 = r4.W;
        int r10 = r5.intValue();
        int r11 = r2.intValue();
        CharSequence r12 = r6.getText();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.text.Spanned");
        Spanned r13 = (Spanned) r12;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r4, "widget");
        Intrinsics.checkNotNullParameter(r6, "layout");
        Intrinsics.checkNotNullParameter(r13, "buffer");
        int r14 = TouchConsumeView.c.b(r4, r6, r10, r11);
        ClickableSpan[] r15 = (ClickableSpan[]) r13.getSpans(r14, r14, ClickableSpan.class);
        if (r15 == null) goto L36;
        if (r15.length != 0) goto L29;
        boolean r16 = true;
    L31:
        if ((!r16) == false) goto L36;
        if (TouchConsumeView.c.a(r14, r15[0], r13) == false) goto L36;
        Log.d("TouchConsumeView", "currentLocationIsProcess return false, offset is " + r14);
        return false;
    L29:
        r16 = false;
    L36:
        if (r15.length != 0) goto L39;
        r9 = true;
    L39:
        return !r9;
    L44:
        return false;
    L46:
        return false;
    L42:
        return false;
    L13:
        r5 = null;
        goto L14
    L7:
        r3 = null;
    L41:
        return super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.dispatchEvent(r8);
    }

    @LynxProp(name = "props")
    public final void setContent(ReadableMap r4) {
        Intrinsics.checkNotNullParameter(r4, "props");
        TraceEvent.beginSection("UniversalCardTextLynxUI.setContent");
        if (UniversalCardTextPerfOpt.a() == true) goto L10;
        Q();
        Gson r1 = com.larksuite.component.card.component.g.a;     // Catch: Throwable -> L7
        TextProps r5 = (TextProps) com.larksuite.component.card.component.g.c(r4, TextProps.class);     // Catch: Throwable -> L7
    L9:
        R(r5);
    L7:
        th = move-exception;
        Log.e("UniversalCardTextLynxUI", "props from lynx transform failed", th);
        r5 = null;
    L10:
        TraceEvent.endSection("UniversalCardTextLynxUI.setContent");
    }

    public final void setEvents(Map<String, EventsListener> r2) {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.setEvents(r2);
        if (r2 == null) goto L6;
        r2.containsKey("isNeedShowMore");
        return;
    }

    @LynxProp(name = "previewImages")
    public final void setPreviewImages(ReadableArray r5) {
        ArrayList r0 = new ArrayList();
        if (r5 == null) goto L10;
        int r1 = r5.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        String r3 = r5.getString(r2);
        if (r3 == null) goto L9;
        r0.add(r3);
    L9:
        r2 = r2 + 1;
    L10:
        ((ArrayList) this.e).clear();
        ((ArrayList) this.e).addAll(r0);
    }

    public final void updateExtraData(Object r5) {
        if ((r5 instanceof c) == true) goto L5;
        return;
    L5:
        if (UniversalCardTextPerfOpt.a() == false) goto L7;
        Q();
        R(((c) r5).a);
    L7:
        c r6 = (c) r5;
        int r0 = r6.c;
        if (r0 == 0) goto L11;
        ((UniversalCardLightTextView) ((LynxUI) this).mView).setTextColor(r0);
    L11:
        if (Intrinsics.areEqual(r6.b, ((UniversalCardLightTextView) ((LynxUI) this).mView).getLayout()) == true) goto L13;
        Log.d("UniversalCardTextLynxUI", "setContentLayout: null");
    L13:
        int r1 = r6.d;
        if (r1 <= 0) goto L16;
        ((UniversalCardLightTextView) ((LynxUI) this).mView).setPadding(((UniversalCardLightTextView) getView()).getPaddingLeft(), r1, ((UniversalCardLightTextView) getView()).getPaddingRight(), r1);
    L16:
        ((UniversalCardLightTextView) ((LynxUI) this).mView).setLayout(r6.b);
    }
}
