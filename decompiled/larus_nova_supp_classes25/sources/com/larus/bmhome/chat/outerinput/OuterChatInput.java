package com.larus.bmhome.chat.outerinput;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.f9;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.o4;
import com.larus.bmhome.chat.require.IMainBotService;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.bmhome.utils.y2;
import com.larus.bmhome.view.j2;
import com.larus.common_ui.view.ChatInputInnerView;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.conversation.InputLeftButtonStyle;
import com.larus.input.impl.databinding.LarusWidgetInputOuterBinding;
import com.larus.platform.service.o2;
import com.larus.platform.service.z1;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.e1;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 @2\u00020\u0001:\u0001@B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001f\u001a\u00020 H\u0002J&\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020 H\u0003J\b\u0010.\u001a\u00020 H\u0003J\f\u0010/\u001a\u00020 *\u000200H\u0002J\b\u00101\u001a\u00020 H\u0002J\u0018\u00102\u001a\u00020 2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0002J\u0006\u00106\u001a\u000207J\u0018\u00108\u001a\u00020\n2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0002J(\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020\n2\n\b\u0002\u0010;\u001a\u0004\u0018\u0001002\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010=\u001a\u00020\nH\u0002J\b\u0010>\u001a\u00020?H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001e\u001a\u0004\b*\u0010+¨\u0006A"}, d2 = {"Lcom/larus/bmhome/chat/outerinput/OuterChatInput;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/input/impl/databinding/LarusWidgetInputOuterBinding;", "tabFragment", "Landroidx/fragment/app/Fragment;", "info", "Lcom/larus/im/bean/conversation/Conversation;", "tabKey", "", "bot", "Lcom/larus/im/bean/bot/BotModel;", "actionShown", "inputLeftActionStyle", "Ljava/lang/Integer;", "navigationView", "Landroid/view/View;", "getNavigationView", "()Landroid/view/View;", "navigationView$delegate", "Lkotlin/Lazy;", "init", "", "setup", "(Landroidx/fragment/app/Fragment;Lcom/larus/im/bean/conversation/Conversation;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setText", "setActionSpeakResource", "updateActionSpeakGroupStyle", "setBottomMenuEntranceVisible", "addClickListeners", "cameraLongClickListener", "Lcom/larus/bmhome/view/LongPressTouchListener;", "getCameraLongClickListener", "()Lcom/larus/bmhome/view/LongPressTouchListener;", "cameraLongClickListener$delegate", "setActionEntranceLongClickListener", "addTouchListeners", "adaptInputEventForTabKey", "Lcom/larus/bmhome/chat/outerinput/OuterInputEventBus$OuterInputEvent;", "refreshStatus", "setActionEntranceVisible", "botConf", "", "Lcom/larus/im/bean/bot/BotConfItem;", "isShowingRealTimeEntrance", "", "getActionShownByConf", "openMainBot", "eventId", "downEvent", "clickFrom", "getStatus", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class OuterChatInput extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;
    public LarusWidgetInputOuterBinding a;
    public Fragment b;
    public wc9.e c;
    public String d;
    public BotModel e;
    public int f;
    public Integer g;
    public final Lazy h;
    public final Lazy i;

    public static final class a {
    }

    static {
    }

    private final j2 getCameraLongClickListener() {
        return (j2) this.i.getValue();
    }

    private final View getNavigationView() {
        return (View) this.h.getValue();
    }

    private final int getStatus() {
        o2 r0 = o2.a;
        int r1 = Keva.getRepo(r0.e(), 0).getInt("chat_input_status", -1);
        IAIChatService.Companion r3 = IAIChatService.a;
        if (r3.h7() == false) goto L5;
        Keva.getRepo(r0.e(), 0).storeInt("chat_input_status", 2);
        return 2;
    L5:
        if (r1 <= 0) goto L7;
        return r1;
    L7:
        return r3.w7();
    }

    public final void V5() {
        int r0 = getStatus();
        z2 r1 = z2.a;
        if (r1.m3() == true) goto L6;
        if (r0 != 2) goto L6;
        r0 = 1;
    L6:
        FLogger.a.i("OuterChatInput", "refreshStatus, status:" + r0);
        LarusWidgetInputOuterBinding r4 = null;
        if (r0 != 2) goto L61;
        LarusWidgetInputOuterBinding r2 = this.a;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L11:
        e1.o(r2.l);
        LarusWidgetInputOuterBinding r3 = this.a;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L14:
        e1.x(r3.d);
        LarusWidgetInputOuterBinding r5 = this.a;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L17:
        e1.x(r5.m);
        LarusWidgetInputOuterBinding r6 = this.a;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L20:
        ChatInputInnerView r7 = r6.m;
        IAIChatService.Companion r8 = IAIChatService.a;
        Fragment r9 = this.b;
        if (r9 == null) goto L23;
        FragmentActivity r10 = r9.getActivity();
    L24:
        BotModel r11 = this.e;
        wc9.e r12 = this.c;
        if (r12 == null) goto L27;
        String r13 = r12.a;
    L28:
        boolean r14 = r8.N7(r10, r11, r13);
        r7.R5(r14, r14, r14, false, null);
        LarusWidgetInputOuterBinding r15 = this.a;
        if (r15 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L31:
        e1.o(r15.j);
        LarusWidgetInputOuterBinding r16 = this.a;
        if (r16 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L34:
        AppCompatImageView r17 = r16.k;
        Fragment r18 = this.b;
        if (r18 == null) goto L37;
        FragmentActivity r19 = r18.getActivity();
    L38:
        BotModel r20 = this.e;
        wc9.e r21 = this.c;
        if (r21 == null) goto L41;
        String r22 = r21.a;
    L43:
        if (r8.Q7(r19, r20, r22) == false) goto L45;
        int r23 = 0;
    L46:
        r17.setVisibility(r23);
        if (r1.X().a() == false) goto L78;
        LarusWidgetInputOuterBinding r24 = this.a;
        if (r24 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L51:
        AppCompatImageView r25 = r24.k;
        if (r25 == null) goto L78;
        LarusWidgetInputOuterBinding r26 = this.a;
        if (r26 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L56:
        AppCompatImageView r27 = r26.k;
        if (r27 == null) goto L59;
        Context r28 = r27.getContext();
    L60:
        r25.setImageResource(v19.c.b(2130971940, r28, 2131242508));
        goto L78
    L59:
        r28 = null;
    L78:
        if (r1.m3() == true) goto L88;
        LarusWidgetInputOuterBinding r29 = this.a;
        if (r29 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r29 = null;
    L82:
        e1.o(r29.m);
        LarusWidgetInputOuterBinding r30 = this.a;
        if (r30 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L86:
        e1.o(r4.j);
        return;
    L85:
        r4 = r30;
        goto L86
    L88:
        return;
    L45:
        r23 = 8;
        goto L46
    L41:
        r22 = null;
        goto L43
    L37:
        r19 = null;
        goto L38
    L27:
        r13 = null;
        goto L28
    L23:
        r10 = null;
        goto L24
    L61:
        LarusWidgetInputOuterBinding r31 = this.a;
        if (r31 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L64:
        e1.x(r31.l);
        LarusWidgetInputOuterBinding r32 = this.a;
        if (r32 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r32 = null;
    L67:
        e1.o(r32.d);
        LarusWidgetInputOuterBinding r33 = this.a;
        if (r33 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r33 = null;
    L70:
        e1.o(r33.m);
        LarusWidgetInputOuterBinding r34 = this.a;
        if (r34 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r34 = null;
    L73:
        e1.x(r34.j);
        LarusWidgetInputOuterBinding r35 = this.a;
        if (r35 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r35 = null;
    L76:
        e1.o(r35.k);
        goto L78
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentActivity Y5() {
        Context r0 = getContext();
    L4:
        if ((r0 instanceof ContextWrapper) == false) goto L8;
        if ((r0 instanceof FragmentActivity) == true) goto L8;
        r0 = ((ContextWrapper) r0).getBaseContext();
    L8:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        return (FragmentActivity) r0;
    }

    public OuterChatInput(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.d = "";
        this.h = LazyKt.lazy(new j(this));
        this.i = LazyKt.lazy(new k(this));
        FLogger.a.i("OuterChatInput", "init");
    }

    public static j2 R5(final OuterChatInput r3) {
        Function1 r1 = new m(r3);
        Function1 r4 = new n();
        Lazy r2 = y2.a;
        return new j2(r1, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setActionEntranceVisible(List<BotConfItem> r11) {
        Integer r0 = this.g;
        boolean r5 = false;
        LarusWidgetInputOuterBinding r6 = null;
        if (r0 == null) goto L19;
        int r12 = r0.intValue();
        if (r12 != InputLeftButtonStyle.ButtonStyle_Camera.getValue()) goto L8;
    L54:
        int r13 = 1;
    L56:
        this.f = r13;
        FLogger.a.i("OuterChatInput", "setActionEntranceVisible, actionShown:" + this.f);
        int r14 = this.f;
        if (r14 == 1) goto L112;
        if (r14 == 2) goto L96;
        if (r14 == 3) goto L78;
        if (r14 != 4) goto L128;
        LarusWidgetInputOuterBinding r15 = this.a;
        if (r15 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L65:
        r15.b.setVisibility(8);
        LarusWidgetInputOuterBinding r16 = this.a;
        if (r16 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L68:
        AppCompatImageView r17 = r16.c;
        if (r17 == null) goto L128;
        LarusWidgetInputOuterBinding r1 = this.a;
        if (r1 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L73:
        AppCompatImageView r2 = r1.c;
        if (r2 == null) goto L76;
        Context r3 = r2.getContext();
    L77:
        r17.setImageResource(v19.c.b(2130971940, r3, 2131242508));
        goto L128
    L76:
        r3 = null;
    L128:
        LarusWidgetInputOuterBinding r18 = this.a;
        if (r18 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L132:
        if (r18.b.getVisibility() == 0) goto L135;
        return;
    L135:
        if (this.f != 1) goto L141;
        LarusWidgetInputOuterBinding r19 = this.a;
        if (r19 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L140:
        r6.b.setOnTouchListener(getCameraLongClickListener());
        return;
    L139:
        r6 = r19;
        goto L140
    L141:
        LarusWidgetInputOuterBinding r110 = this.a;
        if (r110 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L144:
        r110.b.setOnTouchListener(null);
        return;
    L78:
        LarusWidgetInputOuterBinding r111 = this.a;
        if (r111 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L81:
        r111.b.setVisibility(0);
        wc9.e r112 = this.c;
        if (r112 == null) goto L89;
        int r4 = InputLeftButtonStyle.ButtonStyle_File_Icon2.getValue();
        Integer r113 = r112.C;
        if (r113 == null) goto L89;
        if (r4 != r113.intValue()) goto L89;
        r5 = true;
    L89:
        if (r5 == false) goto L91;
        int r114 = v19.c.b(2130971937, getContext(), 2131242502);
    L92:
        LarusWidgetInputOuterBinding r7 = this.a;
        if (r7 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L95:
        r7.c.setImageResource(r114);
        goto L128
    L91:
        r114 = v19.c.b(2130971936, getContext(), 2131242498);
        goto L92
    L96:
        LarusWidgetInputOuterBinding r115 = this.a;
        if (r115 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L99:
        r115.b.setVisibility(0);
        LarusWidgetInputOuterBinding r116 = this.a;
        if (r116 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L102:
        AppCompatImageView r117 = r116.c;
        if (r117 == null) goto L128;
        LarusWidgetInputOuterBinding r8 = this.a;
        if (r8 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L107:
        AppCompatImageView r9 = r8.c;
        if (r9 == null) goto L110;
        Context r10 = r9.getContext();
    L111:
        r117.setImageResource(v19.c.b(2130971926, r10, 2131242472));
        goto L128
    L110:
        r10 = null;
        goto L111
    L112:
        LarusWidgetInputOuterBinding r118 = this.a;
        if (r118 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L115:
        r118.b.setVisibility(0);
        LarusWidgetInputOuterBinding r119 = this.a;
        if (r119 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L118:
        AppCompatImageView r120 = r119.c;
        if (r120 == null) goto L128;
        LarusWidgetInputOuterBinding r20 = this.a;
        if (r20 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L123:
        AppCompatImageView r21 = r20.c;
        if (r21 == null) goto L126;
        Context r22 = r21.getContext();
    L127:
        r120.setImageResource(v19.c.b(2130971931, r22, 2131242482));
        goto L128
    L126:
        r22 = null;
        goto L127
    L8:
        if (r12 != InputLeftButtonStyle.ButtonStyle_Photo.getValue()) goto L11;
    L43:
        r13 = 2;
        goto L56
    L11:
        if (r12 != InputLeftButtonStyle.ButtonStyle_File_Icon1.getValue()) goto L14;
    L47:
        r13 = 3;
        goto L56
    L14:
        if (r12 == InputLeftButtonStyle.ButtonStyle_File_Icon2.getValue()) goto L47;
        if (r12 == InputLeftButtonStyle.ButtonStyle_Call.getValue()) goto L51;
    L55:
        r13 = 0;
    L51:
        r13 = 4;
        goto L56
    L19:
        if (r11 == null) goto L35;
        Iterator<T> r121 = r11.iterator();
    L22:
        if (r121.hasNext() == false) goto L31;
        Object r23 = r121.next();
        BotConfItem r24 = (BotConfItem) r23;
        if (Intrinsics.areEqual(r24.getConfGroupKey(), "show_icon") == true) goto L26;
    L28:
        boolean r25 = false;
    L29:
        if (r25 == false) goto L22;
    L32:
        BotConfItem r26 = (BotConfItem) r23;
        if (r26 == null) goto L35;
        String r122 = r26.getConfValue();
    L36:
        if (r122 == null) goto L55;
        switch(r122.hashCode()) {
            case -1367751899: goto L53;
            case 3045982: goto L49;
            case 3143036: goto L45;
            case 92896879: goto L41;
            default: goto L55;
        };
    L41:
        if (r122.equals("album") == true) goto L43;
    L45:
        if (r122.equals("file") == true) goto L47;
    L49:
        if (r122.equals("call") == true) goto L51;
    L53:
        if (r122.equals("camera") == false) goto L55;
    L26:
        if (Intrinsics.areEqual(r24.getConfKey(), "show_icon") == false) goto L28;
        r25 = true;
        goto L29
    L31:
        r23 = null;
    L35:
        r122 = null;
        goto L36
    }

    public OuterChatInput(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.d = "";
        this.h = LazyKt.lazy(new j(this));
        this.i = LazyKt.lazy(new k(this));
        FLogger.a.i("OuterChatInput", "init");
    }

    public static final /* synthetic */ void T5(OuterChatInput r0, List r1) {
        r0.setActionEntranceVisible(r1);
    }

    public OuterChatInput(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = "";
        this.h = LazyKt.lazy(new j(this));
        this.i = LazyKt.lazy(new k(this));
        FLogger.a.i("OuterChatInput", "init");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object Z5(Fragment r24, wc9.e r25, String r26, Continuation<? super Unit> r27) {
        if ((r27 instanceof OuterChatInput$setup$1) == false) goto L7;
        OuterChatInput$setup$1 r1 = (OuterChatInput$setup$1) r27;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        OuterChatInput$setup$1 r13 = r1;
        Object r0 = r13.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r13.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        wc9.e r4 = (wc9.e) r13.L$0;
        ResultKt.throwOnFailure(r0);
        int r5 = 1;
        char r6 = 0;
    L63:
        BotModel r10 = (BotModel) r0;
        if (r10 == null) goto L66;
        this.e = r10;
    L67:
        if (r10 == null) goto L69;
        List r7 = r10.getBotConf();
    L70:
        setActionEntranceVisible(r7);
        LarusWidgetInputOuterBinding r8 = this.a;
        if (r8 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L73:
        TextView r9 = r8.l;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        String r14 = r9.getContext().getResources().getString(2131900771);
        Object[] r15 = new Object[r5];
        r15[r6] = r9.getContext().getResources().getString(2131907240);
        r9.setText(String.format(r14, Arrays.copyOf(r15, r5)));
        z2 r16 = z2.a;
        if (r16.useOldVoiceInputIcon() == false) goto L88;
        LarusWidgetInputOuterBinding r17 = this.a;
        if (r17 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L78:
        AppCompatImageView r18 = r17.i;
        if (r18 == null) goto L101;
        LarusWidgetInputOuterBinding r19 = this.a;
        if (r19 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L83:
        AppCompatImageView r20 = r19.i;
        if (r20 == null) goto L86;
        Context r21 = r20.getContext();
    L87:
        r18.setImageResource(v19.c.b(2130971766, r21, 2131241573));
        goto L101
    L86:
        r21 = null;
    L101:
        final LarusWidgetInputOuterBinding r22 = this.a;
        if (r22 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L104:
        Integer r23 = r16.asrStrengthenConfig().getAsrSpeakStyle();
        if (r23 == null) goto L111;
        if (r23.intValue() != 3) goto L111;
        e1.o(r22.i);
        e1.x(r22.f);
        r22.h.setTextSize(r5, 17.0f);
        int r28 = l0.a;
        r22.h.setText((CharSequence) l0.a(r22.h.getText(), new i(r22, this)));
    L128:
        LarusWidgetInputOuterBinding r29 = this.a;
        if (r29 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r29 = null;
    L131:
        FrameLayout r30 = r29.e;
        if (o4.a() == false) goto L134;
        int r110 = 0;
    L135:
        r30.setVisibility(r110);
        LarusWidgetInputOuterBinding r31 = this.a;
        if (r31 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L138:
        e1.d(r31.b, new e(this));
        LarusWidgetInputOuterBinding r32 = this.a;
        if (r32 != null) goto L141;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r32 = null;
    L141:
        e1.d(r32.d, new f(this));
        LarusWidgetInputOuterBinding r33 = this.a;
        if (r33 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r33 = null;
    L144:
        e1.d(r33.e, new g(this));
        LarusWidgetInputOuterBinding r34 = this.a;
        if (r34 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r34 = null;
    L147:
        e1.d(r34.k, new h(this));
        final Ref.IntRef r35 = new Ref.IntRef();
        final Ref.IntRef r36 = new Ref.IntRef();
        View.OnTouchListener r37 = new l(r35, this, r36);
        LarusWidgetInputOuterBinding r38 = this.a;
        if (r38 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r38 = null;
    L150:
        r38.l.setOnTouchListener(r37);
        LarusWidgetInputOuterBinding r39 = this.a;
        if (r39 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r39 = null;
    L153:
        r39.m.setOnTouchListener(r37);
        LarusWidgetInputOuterBinding r40 = this.a;
        if (r40 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r40 = null;
    L156:
        r40.j.setOnTouchListener(r37);
        V5();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(Y5()), null, null, new OuterChatInput$setup$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(Y5()), null, null, new OuterChatInput$setup$3(r4, this, r10, null), 3, null);
        return Unit.INSTANCE;
    L134:
        r110 = 8;
    L111:
        if (r23 != null) goto L114;
    L119:
        if (r23 != null) goto L122;
    L127:
        e1.x(r22.i);
        e1.o(r22.f);
        goto L128
    L122:
        if (r23.intValue() != r5) goto L127;
        e1.o(r22.i);
        e1.x(r22.f);
        ConstraintLayout r41 = r22.f;
        if (r41 == null) goto L126;
        r41.setBackgroundResource(v19.c.b(2130970547, r41.getContext(), 2131238571));
    L126:
        e1.x(r22.g);
        r22.h.setTextSize(r5, 14.0f);
        TextView r42 = r22.h;
        r42.setText(r42.getText().toString());
        goto L128
    L114:
        if (r23.intValue() != 2) goto L119;
        e1.o(r22.i);
        e1.x(r22.f);
        ConstraintLayout r43 = r22.f;
        if (r43 == null) goto L118;
        r43.setBackgroundResource(v19.c.b(2130970547, r43.getContext(), 2131238571));
    L118:
        e1.o(r22.g);
        r22.h.setTextSize(r5, 14.0f);
        TextView r44 = r22.h;
        r44.setText(r44.getText().toString());
        goto L128
    L88:
        LarusWidgetInputOuterBinding r45 = this.a;
        if (r45 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r45 = null;
    L91:
        AppCompatImageView r46 = r45.i;
        if (r46 == null) goto L101;
        LarusWidgetInputOuterBinding r47 = this.a;
        if (r47 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r47 = null;
    L96:
        AppCompatImageView r48 = r47.i;
        if (r48 == null) goto L99;
        Context r49 = r48.getContext();
    L100:
        r46.setImageResource(v19.c.b(2130971763, r49, 2131241556));
        goto L101
    L99:
        r49 = null;
        goto L100
    L69:
        r7 = null;
        goto L70
    L66:
        r10 = null;
        goto L67
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (this.a != null) goto L17;
        this.b = r24;
        this.c = r25;
        this.d = r26;
        Lazy r50 = f9.a;
        if (r25 == null) goto L21;
        String r51 = r25.a;
    L22:
        if (r25 == null) goto L24;
        Integer r52 = r25.v;
    L25:
        Integer r53 = f9.b(r25, r51, r52);
        this.g = r53;
        if (r53 == null) goto L28;
        FLogger.a.i("OuterChatInput", "[MainConversationInputFallback] outerSetup resolvedStyle=" + this.g);
    L28:
        LayoutInflater.from(getContext()).inflate(2131563251, this);
        int r54 = 2131362039;
        if (((LinearLayout) ViewBindings.findChildViewById(this, 2131362039)) == null) goto L159;
        r54 = 2131362090;
        FrameLayout r55 = (FrameLayout) ViewBindings.findChildViewById(this, 2131362090);
        if (r55 == null) goto L159;
        r54 = 2131362091;
        AppCompatImageView r56 = ViewBindings.findChildViewById(this, 2131362091);
        if (r56 == null) goto L159;
        r54 = 2131362097;
        AppCompatImageView r57 = ViewBindings.findChildViewById(this, 2131362097);
        if (r57 == null) goto L159;
        r54 = 2131362113;
        FrameLayout r58 = (FrameLayout) ViewBindings.findChildViewById(this, 2131362113);
        if (r58 == null) goto L159;
        r54 = 2131362128;
        ConstraintLayout r59 = ViewBindings.findChildViewById(this, 2131362128);
        if (r59 == null) goto L159;
        r54 = 2131362129;
        AppCompatImageView r60 = ViewBindings.findChildViewById(this, 2131362129);
        if (r60 == null) goto L159;
        r54 = 2131362130;
        TextView r61 = (TextView) ViewBindings.findChildViewById(this, 2131362130);
        if (r61 == null) goto L159;
        r54 = 2131362143;
        AppCompatImageView r111 = ViewBindings.findChildViewById(this, 2131362143);
        if (r111 == null) goto L159;
        r54 = 2131362144;
        FrameLayout r112 = (FrameLayout) ViewBindings.findChildViewById(this, 2131362144);
        if (r112 == null) goto L159;
        r54 = 2131362145;
        AppCompatImageView r113 = ViewBindings.findChildViewById(this, 2131362145);
        if (r113 == null) goto L159;
        r54 = 2131375335;
        if (ViewBindings.findChildViewById(this, 2131375335) == null) goto L159;
        r54 = 2131375336;
        if (ViewBindings.findChildViewById(this, 2131375336) == null) goto L159;
        r54 = 2131375415;
        TextView r114 = (TextView) ViewBindings.findChildViewById(this, 2131375415);
        if (r114 == null) goto L159;
        r54 = 2131375962;
        if (ViewBindings.findChildViewById(this, 2131375962) == null) goto L159;
        r54 = 2131387050;
        ChatInputInnerView r210 = ViewBindings.findChildViewById(this, 2131387050);
        if (r210 == null) goto L159;
        this.a = new LarusWidgetInputOuterBinding(this, r55, r56, r57, r58, r59, r60, r61, r111, r112, r113, r114, r210);
        IBotRepoService r62 = RepoDispatcherDelegate.b.b();
        r4 = r25;
        String r63 = r4.a;
        r13.L$0 = r4;
        r5 = 1;
        r13.label = 1;
        r6 = 0;
        r0 = r62.j1(r63, false, r13);
        if (r0 != r12) goto L63;
        return r12;
    L159:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r54)));
    L24:
        r52 = null;
        goto L25
    L21:
        r51 = null;
        goto L22
    L17:
        return Unit.INSTANCE;
    L7:
        r1 = new OuterChatInput$setup$1(this, r27);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void S5(Ref.IntRef r7, OuterChatInput r8, Ref.IntRef r9, View r10, MotionEvent r11) {
        MutableSharedFlow<Integer> r0 = OuterInputEventBus.a;
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNullParameter(r11, "<this>");
        OuterInputEventBus.OuterInputEvent r1 = new OuterInputEventBus.OuterInputEvent(r11.getAction(), r11.getX(), r11.getY(), 0.0f, 0.0f);
        if (r11.getAction() != 0) goto L28;
        View r2 = r8.getNavigationView();
        if (r2 == null) goto L7;
        int r3 = r2.getHeight();
    L8:
        r7.element = r3;
        LarusWidgetInputOuterBinding r12 = r8.a;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L12:
        if (Intrinsics.areEqual(r10, r12.l) == false) goto L14;
        int r13 = DoraCallStateCode.DORA_NEW_USER_GUIDE;
    L27:
        OuterInputEventBus.b(r8.d).resetReplayCache();
        U5(r8, r13, r1, null, 4);
    L44:
        if (r11.getAction() != 0) goto L46;
        OuterInputEventBus.a(r8.d).resetReplayCache();
    L46:
        OuterInputEventBus.a(r8.d).tryEmit(r1);
        if (r11.getActionMasked() != 2) goto L52;
        int r14 = r9.element + 1;
        r9.element = r14;
        if (r14 != 1) goto L56;
        FLogger.a.i("OuterChatInput", "onTouchEvent event=" + r11.getAction() + ", MOVE");
        return;
    L56:
        return;
    L52:
        if (r9.element <= 0) goto L54;
        FLogger.a.i("OuterChatInput", "onTouchEvent:" + r11.getAction() + ", after " + r9.element + " MOVE");
        r9.element = 0;
        return;
    L54:
        FLogger.a.i("OuterChatInput", "onTouchEvent:" + r11.getAction());
        return;
    L14:
        LarusWidgetInputOuterBinding r15 = r8.a;
        if (r15 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L18:
        if (Intrinsics.areEqual(r10, r15.m) == false) goto L20;
        r13 = 202;
        goto L27
    L20:
        LarusWidgetInputOuterBinding r16 = r8.a;
        if (r16 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L24:
        if (Intrinsics.areEqual(r10, r16.j) == false) goto L26;
        r13 = 203;
        goto L27
    L26:
        r13 = -1;
        goto L27
    L7:
        r3 = 0;
        goto L8
    L28:
        View r17 = r8.getNavigationView();
        if (r17 != null) goto L31;
    L36:
        boolean r18 = false;
    L37:
        if (r18 == true) goto L40;
        float r19 = r1.c;
        float r20 = r7.element;
        r1.c = r19 + r20;
        r1.e += r20;
    L40:
        if (Intrinsics.areEqual(r8.d, "aweeme_feed_fragment") == false) goto L42;
        r1.b -= com.larus.utils.i.d(r8.getContext());
    L42:
        OuterInputEventBus.b(r8.d).tryEmit(r1);
        goto L44
    L31:
        if (r17.getVisibility() != 0) goto L33;
        boolean r110 = true;
    L34:
        if (r110 != true) goto L36;
        r18 = true;
        goto L37
    L33:
        r110 = false;
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void U5(OuterChatInput r18, int r19, OuterInputEventBus.OuterInputEvent r20, String r21, int r22) {
        String r2 = null;
        if ((r22 & 2) == 0) goto L5;
        OuterInputEventBus.OuterInputEvent r1 = null;
    L7:
        if ((r22 & 4) == 0) goto L9;
        String r4 = null;
    L10:
        r18.getClass();
        FLogger.a.i("OuterChatInput", "openMainBot, eventId:" + r19);
        z1.a.c(r18.Y5());
        Pair[] r5 = new Pair[10];
        r5[0] = TuplesKt.to("arg_outer_input_tab_key", r18.d);
        BotModel r6 = r18.e;
        if (r6 == null) goto L13;
        String r7 = r6.getBotId();
    L14:
        r5[1] = TuplesKt.to("argBotId", r7);
        wc9.e r8 = r18.c;
        if (r8 == null) goto L17;
        r2 = r8.a;
    L17:
        r5[2] = TuplesKt.to("argConversationId", r2);
        r5[3] = TuplesKt.to("arg_outer_input_event_id", Integer.valueOf(r19));
        r5[4] = TuplesKt.to("arg_outer_input_down_event", r1);
        r5[5] = TuplesKt.to("click_from", r4);
        int r3 = b0.a;
        r5[6] = TuplesKt.to("enter_method", b0.a(r18.d));
        r5[7] = TuplesKt.to("enter_from", b0.a(r18.d));
        String r9 = r18.d;
        Intrinsics.checkNotNullParameter(r9, "tabKey");
        switch(r9.hashCode()) {
            case -1462439438: goto L29;
            case -1039689911: goto L26;
            case -503960960: goto L23;
            case 1619864869: goto L20;
            default: goto L31;
        };
    L20:
        String r10 = "chat_list";
        if (r9.equals("chat_list") == false) goto L31;
    L32:
        r5[8] = TuplesKt.to("argPreviousPage", r10);
        if (Intrinsics.areEqual(r18.d, "aweme_feed_dialog") == false) goto L35;
    L38:
        String r11 = "0";
    L39:
        r5[9] = TuplesKt.to("argOpenNewChatPage", r11);
        Bundle r12 = com.larus.utils.f.c(r5);
        MainBotServiceDelegate r13 = MainBotServiceDelegate.b;
        Context r14 = r18.getContext();
        wc9.e r15 = r18.c;
        if (r15 == null) goto L46;
        ConversationPage r16 = r15.g;
        if (r16 == null) goto L46;
        Integer r17 = r16.getDefaultStatus();
        if (r17 == null) goto L46;
        int r23 = r17.intValue();
    L47:
        int r110 = r23;
        wc9.e r24 = r18.c;
        if (r24 == null) goto L53;
        ConversationPage r25 = r24.g;
        if (r25 == null) goto L53;
        List r26 = r25.getPageList();
        if (r26 == null) goto L53;
    L54:
        List r111 = r26;
        wc9.e r0 = r18.c;
        if (r0 == null) goto L61;
        ConversationPage r27 = r0.g;
        if (r27 == null) goto L61;
        Integer r28 = r27.getPagePosition();
        if (r28 == null) goto L61;
        int r112 = r28.intValue();
    L62:
        r13.c(r14, new IMainBotService.a(r12, r110, r111, r112, 2130772380, 2130772384, null, 64));
        return;
    L61:
        r112 = 0;
    L53:
        r26 = CollectionsKt.emptyList();
    L46:
        r23 = PageType.Chat.getType();
        goto L47
    L35:
        if (Intrinsics.areEqual(r18.d, "aweeme_feed_fragment") == true) goto L38;
        r11 = "1";
        goto L39
    L23:
        r10 = "bot_list_profile";
        if (r9.equals("bot_list_profile") == true) goto L32;
    L26:
        r10 = "notify";
        if (r9.equals("notify") == true) goto L32;
    L29:
        r10 = "bot_list_discover";
        if (r9.equals("bot_list_discover") == true) goto L32;
    L31:
        r10 = "";
        goto L32
    L13:
        r7 = null;
        goto L14
    L9:
        r4 = r21;
        goto L10
    L5:
        r1 = r20;
        goto L7
    }
}
