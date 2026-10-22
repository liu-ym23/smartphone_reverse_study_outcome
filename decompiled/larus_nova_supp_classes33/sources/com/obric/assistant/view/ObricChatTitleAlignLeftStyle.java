package com.obric.assistant.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.view.ChatTitleAlignLeftStyle;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0014J0\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0014J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\n¨\u0006&"}, d2 = {"Lcom/obric/assistant/view/ObricChatTitleAlignLeftStyle;", "Lcom/larus/bmhome/view/ChatTitleAlignLeftStyle;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isRealtimeCallVisibleHookShow", "", "()Z", "setRealtimeCallVisibleHookShow", "(Z)V", "uiService", "Lcom/obric/assistant/spi/chat/IObricChatUIService;", "getUiService", "()Lcom/obric/assistant/spi/chat/IObricChatUIService;", "isImmerse", "onAttachedToWindow", "", "initView", "isMainCvs", "titleName", "", "ttsChecked", "isSideBar", "isEnterpriseColdStart", "value", "getTtsChecked", "setTtsChecked", "refresh", "alignSubtitleWithTitleStartInSimplifiedNavigator", "setupTtsButtonStatus", "obricBluetoothIconInternal", "", "type", "Lcom/obric/assistant/view/ObricChatTitleAlignLeftStyle$BlueIcon;", "defaultIcon", "Companion", "BlueIcon", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ObricChatTitleAlignLeftStyle extends ChatTitleAlignLeftStyle {
    public static final /* synthetic */ int W = 0;
    public boolean U;
    public boolean V;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/view/ObricChatTitleAlignLeftStyle$BlueIcon;", "", "i", "", "<init>", "(Ljava/lang/String;II)V", "getI", "()I", "ON", "OFF", "BLACK", "SUBSCRIBE", "GREY_DEFAULT", "GREY_DARK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BlueIcon extends Enum<BlueIcon> {
        public static final BlueIcon BLACK = null;
        public static final BlueIcon GREY_DARK = null;
        public static final BlueIcon GREY_DEFAULT = null;
        public static final BlueIcon OFF = null;
        public static final BlueIcon ON = null;
        public static final BlueIcon SUBSCRIBE = null;
        public static final /* synthetic */ BlueIcon[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int i;

        public static EnumEntries<BlueIcon> getEntries() {
            return b;
        }

        static {
            BlueIcon r0 = new BlueIcon("ON", 0, 0);
            ON = r0;
            BlueIcon r1 = new BlueIcon("OFF", 1, 1);
            OFF = r1;
            BlueIcon r3 = new BlueIcon("BLACK", 2, 2);
            BLACK = r3;
            BlueIcon r5 = new BlueIcon("SUBSCRIBE", 3, 3);
            SUBSCRIBE = r5;
            BlueIcon r7 = new BlueIcon("GREY_DEFAULT", 4, 4);
            GREY_DEFAULT = r7;
            BlueIcon r9 = new BlueIcon("GREY_DARK", 5, 5);
            GREY_DARK = r9;
            BlueIcon[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static BlueIcon[] values() {
            return (BlueIcon[]) a.clone();
        }

        public final int getI() {
            return this.i;
        }

        public static BlueIcon valueOf(String r1) {
            return (BlueIcon) r27.a.a(BlueIcon.class, r1);
        }

        public BlueIcon(String r1, int r2, int r3) {
            super(r1, r2);
            this.i = r3;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BlueIcon.values().length];
            r0[BlueIcon.ON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[BlueIcon.OFF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[BlueIcon.BLACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[BlueIcon.SUBSCRIBE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[BlueIcon.GREY_DEFAULT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[BlueIcon.GREY_DARK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.view.ObricChatTitleAlignLeftStyle$onAttachedToWindow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.view.ObricChatTitleAlignLeftStyle$onAttachedToWindow$1", f = "ObricChatTitleAlignLeftStyle.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricChatTitleAlignLeftStyle this$0;

        /* JADX INFO: renamed from: com.obric.assistant.view.ObricChatTitleAlignLeftStyle$onAttachedToWindow$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ObricChatTitleAlignLeftStyle a;

            public a(ObricChatTitleAlignLeftStyle r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                int r5 = ((Number) r3).intValue();
                FLogger.a.i("ObricChatTitleAlignLeftStyle", "onAttachedToWindow with iconStateFlow " + r5);
                this.a.V6();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(ObricChatTitleAlignLeftStyle r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IObricChatUIService r6 = ObricChatTitleAlignLeftStyle.r7(this.this$0);
            if (r6 == null) goto L18;
            z0 r7 = r6.e();
            if (r7 == null) goto L18;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.view.ObricChatTitleAlignLeftStyle$onAttachedToWindow$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.view.ObricChatTitleAlignLeftStyle$onAttachedToWindow$2", f = "ObricChatTitleAlignLeftStyle.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricChatTitleAlignLeftStyle this$0;

        /* JADX INFO: renamed from: com.obric.assistant.view.ObricChatTitleAlignLeftStyle$onAttachedToWindow$2$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ObricChatTitleAlignLeftStyle a;

            public a(ObricChatTitleAlignLeftStyle r1) {
                this.a = r1;
            }

            public final Object emit(Object r4, Continuation r5) {
                long r6 = ((Number) r4).longValue();
                FLogger.a.i("ObricChatTitleAlignLeftStyle", "onAttachedToWindow with doraSharedFlow " + r6);
                this.a.V6();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(ObricChatTitleAlignLeftStyle r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IObricChatUIService r6 = ObricChatTitleAlignLeftStyle.r7(this.this$0);
            if (r6 == null) goto L18;
            MutableSharedFlow r7 = r6.O();
            if (r7 == null) goto L18;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    private final IObricChatUIService getUiService() {
        return (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V6() {
        if (Ea() == false) goto L5;
        return;
    L5:
        IObricChatUIService r0 = getUiService();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L14;
        super.V6();
        return;
    L14:
        getBinding().D.setTag("");
        getBinding().D.setColorFilter(null);
        LottieAdapterView r3 = getBinding().D;
        if (getTtsChecked() == false) goto L17;
        int r4 = com.larus.utils.j0.a;
        int r5 = 2131898837;
    L18:
        r3.setContentDescription(com.larus.utils.j0.d(r5));
        if (getTtsGrey() == false) goto L25;
        getBinding().D.setTag("tts_isGray");
        boolean r6 = v19.h.a;
        if (v19.h.a(null) == false) goto L23;
        int r7 = w7(BlueIcon.GREY_DARK);
    L57:
        Drawable r8 = ContextCompat.getDrawable(getContext(), r7);
        if (r1 == false) goto L62;
        IFlowThemeConfigProvider r9 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r9 == null) goto L62;
        ThemeConfigScene r10 = ThemeConfigScene.CHAT;
        IFlowThemeConfigProvider.a.a(r9, r8, ThemeColorKey.NAVIBAR_TTS_BUTTON_COLOR, r10, AdaptThemeFeatureKey.NAVIBAR_TTS_BUTTON);
    L62:
        getBinding().D.setImageDrawable(r8);
        return;
    L23:
        r7 = w7(BlueIcon.GREY_DEFAULT);
        goto L57
    L25:
        if (getTtsBanned() == false) goto L31;
        if (getImmerse() == false) goto L29;
        r7 = 2131242247;
        goto L57
    L29:
        r7 = v19.c.b(2130971884, getContext(), 2131242245);
        goto L57
    L31:
        if (getEarphoneState().a == false) goto L40;
        if (getEarphoneState().b == true) goto L36;
        r7 = v19.c.b(2130971876, getContext(), 2131242220);
        goto L57
    L36:
        if (getImmerse() == false) goto L38;
        r7 = 2131242225;
        goto L57
    L38:
        r7 = v19.c.b(2130971877, getContext(), 2131242223);
        goto L57
    L40:
        if (getTtsChecked() == true) goto L42;
        r7 = w7(BlueIcon.OFF);
        goto L57
    L42:
        if (getImmerse() == false) goto L44;
        r7 = w7(BlueIcon.BLACK);
        goto L57
    L44:
        ChatParam r11 = getChatParam();
        if (r11 != null) goto L47;
    L49:
        boolean r12 = false;
    L50:
        if (r12 == false) goto L53;
        r7 = w7(BlueIcon.SUBSCRIBE);
        goto L57
    L53:
        if (getUseBlackStyle() == false) goto L55;
        r7 = w7(BlueIcon.BLACK);
        goto L57
    L55:
        r7 = w7(BlueIcon.ON);
        r1 = true;
        goto L57
    L47:
        if (r11.f != true) goto L49;
        r12 = true;
        goto L50
    L17:
        int r13 = com.larus.utils.j0.a;
        r5 = 2131898836;
        goto L18
    L8:
        if (r0.F() != true) goto L10;
        r2 = true;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onAttachedToWindow @@@@@@@@@@ ");
        r1.append(ViewTreeLifecycleOwner.get(this));
        r1.append(" scope is ");
        LifecycleOwner r2 = ViewTreeLifecycleOwner.get(this);
        if (r2 == null) goto L5;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r2);
    L6:
        r1.append(r3);
        r0.i("ObricChatTitleAlignLeftStyle", r1.toString());
        LifecycleOwner r4 = ViewTreeLifecycleOwner.get(this);
        if (r4 == null) goto L11;
        LifecycleCoroutineScope r5 = LifecycleOwnerKt.getLifecycleScope(r4);
        if (r5 == null) goto L11;
        BuildersKt.launch$default(r5, null, null, new AnonymousClass1(this, null), 3, null);
    L11:
        LifecycleOwner r6 = ViewTreeLifecycleOwner.get(this);
        if (r6 == null) goto L16;
        LifecycleCoroutineScope r7 = LifecycleOwnerKt.getLifecycleScope(r6);
        if (r7 == null) goto L16;
        BuildersKt.launch$default(r7, null, null, new AnonymousClass2(this, null), 3, null);
    L16:
        getBinding().E.setOnClickListener(new o(this));
        return;
    L5:
        r3 = null;
        goto L6
    }

    public boolean getTtsChecked() {
        return this.V;
    }

    public final boolean k6() {
        return this.U;
    }

    public final void refresh() {
        V6();
    }

    public ObricChatTitleAlignLeftStyle(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public static final /* synthetic */ IObricChatUIService r7(ObricChatTitleAlignLeftStyle r0) {
        return r0.getUiService();
    }

    public void setRealtimeCallVisibleHookShow(boolean r1) {
        this.U = r1;
    }

    public void setTtsChecked(boolean r4) {
        if (this.V == r4) goto L23;
        FLogger.a.i("ObricChatTitleAlignLeftStyle", "ttsChecked will set from " + this.V + " to " + r4);
        this.V = r4;
        IObricChatUIService r5 = getUiService();
        boolean r0 = false;
        if (r5 != null) goto L7;
    L9:
        if (r0 == false) goto L13;
        IObricChatUIService r6 = getUiService();
        if (r6 == null) goto L16;
        r6.K(this.V);
    L16:
        IObricChatUIService r7 = getUiService();
        if (r7 == null) goto L21;
        z0 r8 = r7.D();
        if (r8 == null) goto L21;
        r8.setValue(Boolean.valueOf(this.V));
    L21:
        V6();
        return;
    L13:
        IObricChatUIService r9 = getUiService();
        if (r9 == null) goto L16;
        r9.u(this.V);
        goto L16
    L7:
        if (r5.F() != true) goto L9;
        r0 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int w7(BlueIcon r3) {
        IObricChatUIService r0 = getUiService();
        if (r0 == null) goto L8;
        Integer r1 = r0.G(r3.getI());
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        switch(b.a[r3.ordinal()]) {
            case 1: goto L17;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L10;
        };
    L11:
        return 2131242218;
    L12:
        return 2131242219;
    L10:
        throw new NoWhenBranchMatchedException();
    L21:
        return v19.c.b(2130971881, getContext(), 2131242236);
    L22:
        return v19.c.b(2130971879, getContext(), 2131242228);
    L23:
        return v19.c.b(2130971875, getContext(), 2131242215);
    L17:
        return v19.c.b(2130971878, getContext(), 2131242227);
    }

    public void i6(boolean r2, String r3, boolean r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "titleName");
        super.i6(r2, r3, r4, r5, r6);
        TextView r7 = getBinding().z;
        ConstraintLayout.LayoutParams r8 = getBinding().z.getLayoutParams();
        ConstraintLayout.LayoutParams r9 = null;
        if ((r8 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r10 = r8;
    L6:
        if (r10 == null) goto L8;
        r10.goneStartMargin = 0;
        r9 = r10;
    L8:
        r7.setLayoutParams(r9);
        return;
    L5:
        r10 = null;
        goto L6
    }
}
