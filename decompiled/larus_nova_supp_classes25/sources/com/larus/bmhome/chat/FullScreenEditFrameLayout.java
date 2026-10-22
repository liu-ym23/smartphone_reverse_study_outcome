package com.larus.bmhome.chat;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.UIUtils;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.voice.VoiceMixInputPanel;
import com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputService;
import com.larus.bmhome.chat.component.bottom.voice.service.g;
import com.larus.bmhome.chat.component.bottom.voice.service.h;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.databinding.LarusPageChatFullScreenEditBinding;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Í\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001%\b\u0007\u0018\u0000 e2\u00020\u0001:\u0001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ§\u0001\u0010A\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001c0\u001b2\u001e\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001c0\u001e2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001c082\b\b\u0002\u00106\u001a\u00020\u00112\b\b\u0002\u00109\u001a\u00020\u00112\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020@0?¢\u0006\u0002\u0010BJ\u0006\u0010C\u001a\u00020\u001cJ,\u0010D\u001a\u00020\u001c2\b\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010F\u001a\u00020\u00072\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010JJ\b\u0010K\u001a\u00020\u001cH\u0002J\b\u0010L\u001a\u00020\u001cH\u0002J\u0010\u0010M\u001a\u00020\u001c2\b\u0010N\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010O\u001a\u00020\u001cJ\u000e\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0007J\u000e\u0010R\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0007H\u0002J\u0006\u0010V\u001a\u00020\u001cJ\u0010\u0010W\u001a\u00020\u001c2\b\b\u0002\u0010X\u001a\u00020\u0007J\u0010\u0010Y\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020\u001cH\u0014J\b\u0010]\u001a\u00020\u001cH\u0014J\b\u0010^\u001a\u00020\u0007H\u0002J\b\u0010_\u001a\u00020\u001cH\u0002J\b\u0010`\u001a\u00020\u001cH\u0002J\u0010\u0010a\u001a\u00020\u001c2\u0006\u0010b\u001a\u00020\u0007H\u0002J\b\u0010c\u001a\u00020\u001cH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010dH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001c0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b1\u00102R\u000e\u00104\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u001c08X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;X\u0082\u000e¢\u0006\u0004\n\u0002\u0010=R\u001a\u0010>\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020@0?X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/larus/bmhome/chat/FullScreenEditFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatFullScreenEditBinding;", "lastTouchX", "", "lastTouchY", "startTopMargin", "isImmersive", "", "textWatcher", "Landroid/text/TextWatcher;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "activity", "Landroidx/fragment/app/FragmentActivity;", "tracker", "Lcom/larus/bmhome/chat/component/bottom/voice/VoiceMixInputTracker;", "onClickSend", "Lkotlin/Function1;", "", "onUpdateInputText", "Lkotlin/Function3;", "", "deletingRichSpan", "affectedRichSpans", "", "Landroid/text/style/ReplacementSpan;", "richTextWatcher", "com/larus/bmhome/chat/FullScreenEditFrameLayout$richTextWatcher$1", "Lcom/larus/bmhome/chat/FullScreenEditFrameLayout$richTextWatcher$1;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "voiceInputService", "Lcom/larus/bmhome/chat/component/bottom/voice/service/VoiceMixInputService;", "getVoiceInputService", "()Lcom/larus/bmhome/chat/component/bottom/voice/service/VoiceMixInputService;", "voiceInputService$delegate", "Lkotlin/Lazy;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "getImeManager", "()Lcom/larus/bmhome/utils/ImeManager;", "imeManager$delegate", "useVoiceMixInput", "navigationBarHeight", "inModify", "onFold", "Lkotlin/Function0;", "enableSetFullEditBackground", "inputFilters", "", "Landroid/text/InputFilter;", "[Landroid/text/InputFilter;", "fullInputBoxMobParams", "", "", "init", "(Landroidx/fragment/app/FragmentActivity;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/bmhome/chat/component/bottom/voice/VoiceMixInputTracker;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;ZZ[Landroid/text/InputFilter;Ljava/util/Map;)V", "dealClickEvent", "dealVoiceMixInput", "fragmentActivity", "defaultImeHeight", "argumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "startVoiceInputAnimation", "stopVoiceInputAnimation", "setInputText", ChatDraftItem.TYPE_TEXT, "setDarkMode", "setImmersiveStyle", "backgroundColor", "adjustFontSize", "colorArrays", "", "color", "removeView", "adaptPadding", "margin", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onAttachedToWindow", "onDetachedFromWindow", "getImeHeight", "setupSendClick", "updateChatInputText", "dealOpenFullScreenEditView", "startMargin", "dealCloseFullScreenEditView", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FullScreenEditFrameLayout extends FrameLayout {
    public static final /* synthetic */ int u = 0;
    public final LarusPageChatFullScreenEditBinding a;
    public float b;
    public boolean c;
    public c d;
    public BotModel e;
    public FragmentActivity f;
    public com.larus.bmhome.chat.component.bottom.voice.d0 g;
    public Function1<? super Boolean, Unit> h;
    public Function3<? super CharSequence, ? super Boolean, ? super Boolean, Unit> i;
    public boolean j;
    public List<? extends ReplacementSpan> k;
    public final d l;
    public final CoroutineScope m;
    public final Lazy n;
    public final Lazy o;
    public boolean p;
    public boolean q;
    public Function0<Unit> r;
    public boolean s;
    public Map<String, String> t;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.chat.component.bottom.voice.b {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ de8.c b;

        @Override // com.larus.bmhome.chat.component.bottom.voice.b
        public final va8.o w0() {
            return null;
        }

        @Override // com.larus.bmhome.chat.component.bottom.voice.b
        public final de8.c f1() {
            return this.b;
        }

        @Override // com.larus.bmhome.chat.component.bottom.voice.b
        public FragmentActivity getActivity() {
            return this.a;
        }

        public b(FragmentActivity r1, de8.c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements TextWatcher {
        public final /* synthetic */ FullScreenEditFrameLayout a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public c(FullScreenEditFrameLayout r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            AppCompatImageView r0 = this.a.a.c;
            boolean r1 = false;
            if (r4 != null) goto L5;
        L8:
            boolean r5 = true;
        L9:
            if (r5 == true) goto L11;
        L12:
            r1 = true;
        L13:
            r0.setEnabled(r1);
            return;
        L11:
            if (this.a.q == false) goto L13;
        L5:
            if (StringsKt.isBlank(r4) == true) goto L8;
            r5 = false;
            goto L9
        }
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ FullScreenEditFrameLayout a;

        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r1, T r2) {
                return ComparisonsKt.compareValues((Integer) ((Pair) r2).getFirst(), (Integer) ((Pair) r1).getFirst());
            }
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public d(FullScreenEditFrameLayout r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r5) {
            FullScreenEditFrameLayout r0 = this.a;
            if (r0.j == false) goto L5;
            return;
        L5:
            if (r0.k.isEmpty() == true) goto L34;
            if (r5 == null) goto L35;
            List<? extends ReplacementSpan> r1 = this.a.k;
            ArrayList r2 = new ArrayList();
            Iterator<T> r3 = r1.iterator();
        L10:
            if (r3.hasNext() == false) goto L18;
            ReplacementSpan r4 = (ReplacementSpan) r3.next();
            int r6 = r5.getSpanStart(r4);
            int r7 = r5.getSpanEnd(r4);
            if (r6 < 0) goto L15;
            if (r7 <= r6) goto L15;
            Pair r8 = TuplesKt.to(Integer.valueOf(r6), Integer.valueOf(r7));
        L16:
            if (r8 == null) goto L10;
            r2.add(r8);
        L15:
            r8 = null;
            goto L16
        L18:
            List r9 = CollectionsKt.sortedWith(CollectionsKt.distinct(r2), new a());
            FullScreenEditFrameLayout r10 = this.a;
            r10.k = CollectionsKt.emptyList();
            if (r9.isEmpty() == false) goto L21;
            return;
        L21:
            this.a.j = true;
            Iterator r11 = r9.iterator();
        L23:
            if (r11.hasNext() == false) goto L25;
            Pair r12 = (Pair) r11.next();
            r5.delete(((Number) r12.component1()).intValue(), ((Number) r12.component2()).intValue());
            goto L23
        L25:
            this.a.j = false;
            return;
        L35:
            return;
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r9, int r10, int r11, int r12) {
            FullScreenEditFrameLayout r13 = this.a;
            if (r13.j == true) goto L27;
            if (r11 > 0) goto L7;
            return;
        L7:
            if ((r9 instanceof Editable) == false) goto L9;
            Editable r14 = (Editable) r9;
        L10:
            if (r14 != null) goto L12;
            return;
        L12:
            int r15 = r11 + r10;
            Object[] r0 = r14.getSpans(r10, r15, ReplacementSpan.class);
            ArrayList r1 = new ArrayList();
            int r2 = r0.length;
            int r4 = 0;
        L13:
            if (r4 >= r2) goto L22;
            Object r5 = r0[r4];
            ReplacementSpan r6 = (ReplacementSpan) r5;
            int r7 = r14.getSpanStart(r6);
            int r8 = r14.getSpanEnd(r6);
            if (r7 >= r15) goto L18;
            if (r8 <= r10) goto L18;
            boolean r16 = true;
        L19:
            if (r16 == false) goto L21;
            r1.add(r5);
        L21:
            r4 = r4 + 1;
        L18:
            r16 = false;
            goto L19
        L22:
            r13.k = CollectionsKt.distinct(r1);
            return;
        L9:
            r14 = null;
            goto L10
        }
    }

    static {
    }

    public FullScreenEditFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FullScreenEditFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static /* synthetic */ void d(FullScreenEditFrameLayout r0) {
        setInputText$lambda$26(r0);
    }

    public final void m() {
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r1.setDuration(100);
        r1.addUpdateListener(new a3(this));
        ViewGroup.LayoutParams r2 = this.a.j.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        final ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{r3.topMargin, UIUtils.getScreenHeight(getContext())});
        r4.setDuration(300);
        r4.addUpdateListener(new l3(r3, this));
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(new Animator[]{r4, r1});
        r5.start();
        Object r6 = null;
        if (getVoiceInputService().g() == false) goto L12;
        h r0 = getVoiceInputService().b();
        if ((!r0.b) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        CharSequence r7 = r0.a;
        if (r7 == null) goto L12;
        r6 = r7.toString();
    L12:
        Function3<? super CharSequence, ? super Boolean, ? super Boolean, Unit> r8 = this.i;
        if (r6 != null) goto L16;
        r6 = new SpannableStringBuilder(this.a.m.getText());
    L16:
        r8.invoke(r6, Boolean.TRUE, Boolean.valueOf(this.p));
    }

    private final int getImeHeight() {
        FragmentActivity r0 = this.f;
        if (r0 != null) goto L5;
        return 0;
    L5:
        Window r2 = r0.getWindow();
        if (r2 == null) goto L16;
        View r3 = r2.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L12;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L12:
        if (r3 == null) goto L16;
        Rect r1 = new Rect();
        r3.getWindowVisibleDisplayFrame(r1);
        int r5 = com.larus.utils.w0.a;
        return (com.larus.utils.w0.c(r0) - r1.bottom) - com.larus.utils.u.b(r0);
    L16:
        return 0;
    }

    private final com.larus.bmhome.utils.x1 getImeManager() {
        return (com.larus.bmhome.utils.x1) this.o.getValue();
    }

    private final VoiceMixInputService getVoiceInputService() {
        return (VoiceMixInputService) this.n.getValue();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.larus.bmhome.chat.z3, java.lang.Object] */
    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        n(UIUtils.getScreenHeight(getContext()));
        com.larus.utils.e1.d(this.a.c, new d3(this));
        com.larus.bmhome.utils.c2 r0 = new com.larus.bmhome.utils.c2();
        FrameLayout r1 = this.a.i;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L29;
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L8:
        if (r3 == null) goto L10;
        r3.bottomMargin = getImeHeight();
    L10:
        r0.b = getImeHeight();
        r1.setLayoutParams(r2);
        FragmentActivity r4 = this.f;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        View r5 = getRootView();
        ?? r6 = new z3(this);
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        Intrinsics.checkNotNullParameter(r6, "keyBoardHeightChange");
        if (Build.VERSION.SDK_INT >= 30) goto L25;
        Window r7 = r4.getWindow();
        if (r7 == null) goto L26;
        View r8 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L19;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r9 = ThreadMethodProxy.currentThread();
        if (r9 == com.larus.home.impl.utils.c.a) goto L19;
        com.larus.home.impl.utils.c.a(r9, "getDecorView");
    L19:
        if (r8 == null) goto L26;
        View r10 = r8.findViewById(R.id.content);
        if (r10 == null) goto L26;
        r10.getViewTreeObserver().addOnGlobalLayoutListener(new com.larus.bmhome.utils.a2(r8, r0, r4, r6));
    L26:
        EditText r11 = this.a.m;
        c r12 = new c(this);
        r11.addTextChangedListener(r12);
        this.d = r12;
        this.a.m.addTextChangedListener(this.l);
        postDelayed(new a4(this), 300);
        return;
    L25:
        ViewExtKt.a(r5, new com.larus.bmhome.utils.b2(r5, r4, r0, r6));
        goto L26
    L7:
        r3 = null;
        goto L8
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c r0 = this.d;
        if (r0 == null) goto L5;
        this.a.m.removeTextChangedListener(r0);
    L5:
        this.a.m.removeTextChangedListener(this.l);
    }

    public static Unit e(FullScreenEditFrameLayout r2) {
        r2.getVoiceInputService().h(true, new com.larus.bmhome.chat.component.bottom.voice.service.a());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void l(FullScreenEditFrameLayout r1) {
        FragmentActivity r0 = r1.f;
        if (r0 == null) goto L5;
        int r2 = com.larus.utils.u.b(r0);
    L6:
        r1.k(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    private static final void setInputText$lambda$26(FullScreenEditFrameLayout r1) {
        r1.a.h.fullScroll(DoraCallStateCode.DOUBAO_VUI_ERROR);
    }

    public final void k(int r6) {
        FragmentActivity r0 = this.f;
        if (r0 == null) goto L23;
        int r1 = com.larus.utils.u.c(r0);
        if (r1 != 0) goto L7;
    L9:
        if (r6 == 0) goto L24;
        ViewGroup.LayoutParams r2 = this.a.b.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L14:
        if (r3 == null) goto L16;
        int r4 = r3.bottomMargin;
    L17:
        if (r4 == r6) goto L25;
        ConstraintLayout r5 = this.a.b;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        if (r7 == null) goto L22;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        r8.bottomMargin = r6;
        r5.setLayoutParams(r8);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L25:
        return;
    L16:
        r4 = 0;
        goto L17
    L13:
        r3 = null;
        goto L14
    L24:
        return;
    L7:
        if (this.a.f.getPaddingTop() == r1) goto L9;
        FrameLayout r9 = this.a.f;
        r9.setPadding(r9.getPaddingLeft(), r1, r9.getPaddingRight(), r9.getPaddingBottom());
        goto L9
    }

    public final void n(int r7) {
        ViewGroup.LayoutParams r0 = this.a.j.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        final ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{r7, 0});
        r2.setDuration(300);
        r2.addUpdateListener(new b3(r1, this));
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r3.setDuration(100);
        r3.setInterpolator(new AccelerateInterpolator());
        r3.addUpdateListener(new c3(this));
        AnimatorSet r4 = new AnimatorSet();
        r4.playSequentially(new Animator[]{r2, r3});
        r4.start();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        r7.getRawX();
        float r0 = r7.getRawY();
        ViewGroup.LayoutParams r1 = this.a.j.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        int r8 = r7.getAction();
        if (r8 == 0) goto L22;
        if (r8 != 1) goto L6;
        int r9 = r2.topMargin;
        if (r9 < 400) goto L21;
        m();
    L23:
        return true;
    L21:
        n(r9);
        goto L23
    L6:
        if (r8 != 2) goto L23;
        float r10 = r0 - this.b;
        int r3 = r2.topMargin;
        if (r3 < 0) goto L14;
        if ((r3 + r10) < 0) goto L14;
        int r11 = (int) r10;
        r2.topMargin = r3 + r11;
        r2.bottomMargin -= r11;
        this.a.j.setLayoutParams(r2);
    L14:
        if (r2.topMargin <= 0) goto L16;
        this.a.b.setAlpha(0.0f);
    L17:
        this.b = r0;
        goto L23
    L16:
        this.a.b.setAlpha(1.0f);
        goto L17
    L22:
        this.b = r0;
        goto L23
    }

    public final void setImmersiveStyle(int r7) {
        this.c = true;
        int r1 = com.larus.bmhome.chat.immerse.k0.a(r7, 0.1f, 0.35f);
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(0);
        r2.setCornerRadius(c7.b(16));
        r2.setColor(r1);
        this.a.j.setBackground(r2);
        this.a.i.setBackground(new ColorDrawable(0));
        this.a.m.setHintTextColor(ve8.d.a(2131106539, getContext()));
        this.a.m.setTextColor(ve8.d.a(2131103298, getContext()));
        this.a.l.setImageResource(2131241433);
        com.larus.utils.e1.v(this.a.e, r1);
        FrameLayout r3 = this.a.o;
        GradientDrawable r4 = new GradientDrawable();
        r4.setShape(0);
        r4.setColors(new int[]{0, r7, r7, r7, r7, r7, r7, r7, r7, r7});
        r4.setAlpha(52);
        r3.setBackground(r4);
        View r0 = this.a.o.getChildAt(0);
        if ((r0 instanceof VoiceMixInputPanel) == false) goto L5;
        VoiceMixInputPanel r5 = (VoiceMixInputPanel) r0;
    L6:
        if (r5 == null) goto L9;
        r5.setImmersiveMode(r7);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void setInputText(CharSequence r4) {
        this.a.m.setText(r4, TextView.BufferType.SPANNABLE);
        EditText r0 = this.a.m;
        Editable r1 = r0.getText();
        boolean r2 = false;
        if (r1 == null) goto L5;
        int r3 = r1.length();
    L6:
        r0.setSelection(r3);
        this.a.m.setFocusable(true);
        AppCompatImageView r5 = this.a.c;
        if (r4 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
    L16:
        r2 = true;
    L17:
        r5.setEnabled(r2);
        this.a.h.post(new t3(this));
        return;
    L15:
        if (this.q == false) goto L17;
    L9:
        if (StringsKt.isBlank(r4) == true) goto L12;
        r6 = false;
        goto L13
    L5:
        r3 = 0;
        goto L6
    }

    public static Unit b(FullScreenEditFrameLayout r8, Ref.IntRef r9) {
        int r4 = RangesKt.coerceAtLeast(r8.getVoiceInputService().b().a.length() - r9.element, 0);
        com.larus.bmhome.chat.component.bottom.voice.d0 r2 = r8.g;
        if (r2 == null) goto L5;
        int r3 = r9.element;
        int r10 = com.larus.bmhome.chat.component.bottom.voice.d0.d;
        r2.d(r3, r4, "click_button", "error", "end");
    L5:
        r8.p = true;
        return Unit.INSTANCE;
    }

    public static Unit c(FullScreenEditFrameLayout r8, Ref.IntRef r9) {
        int r4 = RangesKt.coerceAtLeast(r8.getVoiceInputService().b().a.length() - r9.element, 0);
        com.larus.bmhome.chat.component.bottom.voice.d0 r2 = r8.g;
        if (r2 == null) goto L5;
        int r3 = r9.element;
        int r10 = com.larus.bmhome.chat.component.bottom.voice.d0.d;
        r2.d(r3, r4, "click_button", "mute_overtime", "end");
    L5:
        r8.p = true;
        return Unit.INSTANCE;
    }

    public static Unit h(FullScreenEditFrameLayout r1, AppCompatImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.m();
        r1.h.invoke(Boolean.valueOf(r1.getVoiceInputService().g()));
        return Unit.INSTANCE;
    }

    public FullScreenEditFrameLayout(final Context r22, AttributeSet r23, int r24) {
        Intrinsics.checkNotNullParameter(r22, "context");
        super(r22, r23, r24);
        View r2 = LayoutInflater.from(r22).inflate(2131563017, this, false);
        addView(r2);
        int r3 = 2131362094;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r2, 2131362094);
        if (r7 == null) goto L31;
        r3 = 2131362132;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r2, 2131362132);
        if (r8 == null) goto L31;
        r3 = 2131362153;
        LottieAdapterView r9 = ViewBindings.findChildViewById(r2, 2131362153);
        if (r9 == null) goto L31;
        r3 = 2131364510;
        View r10 = ViewBindings.findChildViewById(r2, 2131364510);
        if (r10 == null) goto L31;
        r3 = 2131367793;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131367793);
        if (r11 == null) goto L31;
        r3 = 2131371401;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131371401);
        if (r12 == null) goto L31;
        r3 = 2131371458;
        ScrollView r13 = (ScrollView) ViewBindings.findChildViewById(r2, 2131371458);
        if (r13 == null) goto L31;
        FrameLayout r14 = (FrameLayout) r2;
        r3 = 2131373350;
        ConstraintLayout r15 = ViewBindings.findChildViewById(r2, 2131373350);
        if (r15 == null) goto L31;
        r3 = 2131374688;
        FrameLayout r16 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131374688);
        if (r16 == null) goto L31;
        r3 = 2131374689;
        AppCompatImageView r17 = ViewBindings.findChildViewById(r2, 2131374689);
        if (r17 == null) goto L31;
        r3 = 2131375366;
        EditText r18 = (EditText) ViewBindings.findChildViewById(r2, 2131375366);
        if (r18 == null) goto L31;
        r3 = 2131375385;
        TouchInterceptingView r19 = ViewBindings.findChildViewById(r2, 2131375385);
        if (r19 == null) goto L31;
        r3 = 2131392727;
        FrameLayout r20 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131392727);
        if (r20 == null) goto L31;
        this.a = new LarusPageChatFullScreenEditBinding(r14, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        this.h = new u3();
        this.i = new v3();
        this.k = CollectionsKt.emptyList();
        this.l = new d(this);
        this.m = CoroutineScopeKt.MainScope();
        this.n = LazyKt.lazy(new w3(r22, this));
        this.o = LazyKt.lazy(new x3(this));
        this.r = new y3();
        this.t = MapsKt.emptyMap();
        return;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r3)));
    }

    public static void a(FullScreenEditFrameLayout r3, Ref.ObjectRef r4, MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        if (r5.getAction() != 0) goto L18;
        Rect r0 = new Rect();
        r3.a.c.getGlobalVisibleRect(r0);
        boolean r1 = r0.contains((int) r5.getRawX(), (int) r5.getRawY());
        View r2 = r3.findViewById(2131367924);
        if (r2 == null) goto L8;
        Rect r6 = new Rect();
        r2.getGlobalVisibleRect(r6);
        boolean r7 = r6.contains((int) r5.getRawX(), (int) r5.getRawY());
    L9:
        if (r1 == false) goto L11;
        r3.a.c.performClick();
    L11:
        if (r1 == false) goto L13;
        String r8 = "send_button_click";
    L16:
        r4.element = r8;
        r3.getVoiceInputService().h(!r1, new com.larus.bmhome.chat.component.bottom.voice.service.a());
        return;
    L13:
        if (r7 == false) goto L15;
        r8 = "stop_icon_click";
        goto L16
    L15:
        r8 = "click_screen";
        goto L16
    L8:
        r7 = false;
        goto L9
    }

    public /* synthetic */ FullScreenEditFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static Unit i(FullScreenEditFrameLayout r9, Ref.IntRef r10, Ref.ObjectRef r11, h r12) {
        if (r12 == null) goto L20;
        CharSequence r0 = r12.a;
        if (r12.b == false) goto L7;
        r9.a.m.setHint(r0);
    L13:
        if (r9.getVoiceInputService().g() == true) goto L19;
        int r5 = RangesKt.coerceAtLeast(r12.a.length() - r10.element, 0);
        com.larus.bmhome.chat.component.bottom.voice.d0 r3 = r9.g;
        if (r3 == null) goto L17;
        int r4 = r10.element;
        String r7 = (String) r11.element;
        int r13 = com.larus.bmhome.chat.component.bottom.voice.d0.d;
        r3.d(r4, r5, "click_button", r7, "end");
    L17:
        r9.p = true;
    L19:
        return Unit.INSTANCE;
    L7:
        r9.a.m.setHint(r9.getContext().getString(2131909200));
        r9.a.m.setText(r12.a, TextView.BufferType.SPANNABLE);
        EditText r1 = r9.a.m;
        Editable r2 = r1.getText();
        if (r2 == null) goto L10;
        int r6 = r2.length();
    L11:
        r1.setSelection(r6);
        goto L13
    L10:
        r6 = 0;
        goto L11
    L20:
        return Unit.INSTANCE;
    }

    public static Unit j(final FullScreenEditFrameLayout r7, com.larus.bmhome.chat.component.bottom.voice.c r8, Ref.BooleanRef r9, g r10) {
        if (r10 == null) goto L30;
        FLogger.a.i("FullScreenEditFrameLayout", "VoiceMixInputStatus change " + r10);
        if (r10.b != 2) goto L7;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L17;
        com.larus.utils.e1.x(r7.a.d);
        com.larus.utils.e1.y(r7.a.n, r10.a);
        com.larus.utils.e1.x(r7.a.e);
        r7.a.m.setCursorVisible(!r10.a);
        if (r10.a == false) goto L15;
        LottieAdapterView r1 = r7.a.d;
        r1.setRepeatCount(-1);
        r1.setRepeatMode(1);
        r1.setAnimation("lottie/voice_input_recording.json");
        r1.playAnimation();
        r8.d();
        com.larus.bmhome.chat.component.bottom.voice.d0 r11 = r7.g;
        if (r11 == null) goto L16;
        int r2 = com.larus.bmhome.chat.component.bottom.voice.d0.d;
        r11.c("click_button", "end");
    L16:
        com.larus.bmhome.utils.x1.d(r7.getImeManager(), 3);
        r9.element = r10.a;
        r7.post(new p3(r7));
    L29:
        return Unit.INSTANCE;
    L15:
        LottieAdapterView r3 = r7.a.d;
        r3.cancelAnimation();
        r3.setImageResource(v19.c.b(2130971892, r3.getContext(), 2131242301));
        r8.c();
        goto L16
    L17:
        com.larus.utils.e1.y(r7.a.d, !r10.a);
        com.larus.utils.e1.y(r7.a.n, r10.a);
        com.larus.utils.e1.y(r7.a.e, !r10.a);
        r7.a.m.setCursorVisible(true ^ r10.a);
        if (r10.a == false) goto L22;
        r8.d();
        com.larus.bmhome.chat.component.bottom.voice.d0 r12 = r7.g;
        if (r12 == null) goto L24;
        int r4 = com.larus.bmhome.chat.component.bottom.voice.d0.d;
        r12.c("click_button", "end");
    L24:
        if (r10.a == false) goto L26;
        com.larus.bmhome.utils.x1 r13 = r7.getImeManager();
        Set r5 = com.larus.bmhome.utils.x1.d;
        r13.a(false);
    L27:
        r9.element = r10.a;
        r7.post(new q3(r7));
        goto L29
    L26:
        com.larus.bmhome.utils.x1.d(r7.getImeManager(), 3);
        goto L27
    L22:
        r8.c();
        goto L24
    L7:
        r0 = false;
        goto L9
    L30:
        return Unit.INSTANCE;
    }

    public final void o(final FragmentActivity r12, int r13, final de8.c r14, final com.larus.bmhome.chat.component.cvs.y r15) {
        getVoiceInputService().getClass();
        if (com.larus.platform.service.z2.a.enableVoiceMixInput() == true) goto L5;
        return;
    L5:
        if (r12 != null) goto L7;
        return;
    L7:
        final Ref.IntRef r0 = new Ref.IntRef();
        r0.element = RangesKt.coerceAtLeast(r13, 0);
        final Ref.BooleanRef r16 = new Ref.BooleanRef();
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = "other";
        final Ref.IntRef r2 = new Ref.IntRef();
        b r3 = new b(r12, r14);
        getVoiceInputService().getClass();
        int r4 = VoiceMixInputService.d();
        if (r4 != 1) goto L10;
        final com.larus.bmhome.chat.component.bottom.voice.j0 r5 = new com.larus.bmhome.chat.component.bottom.voice.j0(null, this.a.o);
        r5.f(r3);
        getVoiceInputService().i(new e3(r5, this));
        com.larus.bmhome.chat.component.bottom.voice.c r6 = r5;
    L14:
        final com.larus.bmhome.chat.component.bottom.voice.c r9 = r6;
        ViewExtKt.n(this, null, null, new g3(r0, this, r9, r16), 3);
        this.a.d.setImageResource(v19.c.b(2130971892, getContext(), 2131242301));
        com.larus.utils.e1.x(this.a.d);
        com.larus.utils.e1.d(this.a.d, new h3(r2, this, r15, r14, r12));
        getVoiceInputService().k(new i3(this, r9, r16));
        getVoiceInputService().j(new j3(this, r2, r1));
        this.a.n.setEventHandler(new k3(this, r1));
        return;
    L10:
        if (r4 == 2) goto L12;
        return;
    L12:
        com.larus.bmhome.chat.component.bottom.voice.i0 r7 = new com.larus.bmhome.chat.component.bottom.voice.i0(null);
        r7.e(r3);
        Function0<Unit> r8 = new f3(this);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.f = r8;
        r6 = r7;
        goto L14
    }

    public static Unit f(final Ref.IntRef r3, final FullScreenEditFrameLayout r4, com.larus.bmhome.chat.component.bottom.voice.c r5, final Ref.BooleanRef r6, boolean r7) {
        r3.element = r4.getImeHeight();
        FLogger.a.i("FullScreenEditFrameLayout", "watchOnImeInsetsAnimationEnd imeHeight=" + r3.element + ", isImeShowing=" + r7);
        r4.getVoiceInputService().getClass();
        if (VoiceMixInputService.d() != 1) goto L12;
        FrameLayout r0 = r4.a.o;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L11;
        r1.height = r3.element;
        r0.setLayoutParams(r1);
        r4.post(new n3(r4, r6));
        if (r3.element == 0) goto L9;
        r4.post(new o3(r4, r6, r3));
    L9:
        r5.a(r3.element);
    L13:
        if (r7 == true) goto L16;
        com.larus.utils.e1.o(r4.a.d);
    L20:
        return Unit.INSTANCE;
    L16:
        if (r6.element == true) goto L18;
        com.larus.utils.e1.x(r4.a.d);
        goto L20
    L18:
        com.larus.utils.e1.o(r4.a.d);
        goto L20
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L12:
        com.larus.utils.e1.o(r4.a.o);
        r5.a(r3.element);
        goto L13
    }

    public static Unit g(final Ref.IntRef r9, final FullScreenEditFrameLayout r10, com.larus.bmhome.chat.component.cvs.y r11, de8.c r12, FragmentActivity r13, LottieAdapterView r14) {
        Intrinsics.checkNotNullParameter(r14, "it");
        r9.element = r10.a.m.length();
        VoiceMixInputService r0 = r10.getVoiceInputService();
        String r7 = null;
        if (r11 == null) goto L5;
        String r1 = r11.Y1();
    L7:
        if (r1 != null) goto L9;
        String r2 = "";
    L10:
        if (r12 == null) goto L14;
        Bundle r15 = r12.b;
        if (r15 == null) goto L14;
        String r16 = r15.getString("item_id", "");
    L15:
        if (r16 != null) goto L17;
        String r3 = "";
    L18:
        if (r11 == null) goto L20;
        String r17 = r11.getBotId();
    L21:
        if (r17 != null) goto L23;
        String r4 = "";
    L24:
        com.larus.bmhome.chat.component.bottom.voice.service.f r18 = new com.larus.bmhome.chat.component.bottom.voice.service.f(r2, r3, r4, r10.c, false);
        Editable r19 = r10.a.m.getText();
        if (r19 == null) goto L27;
        r7 = r19.toString();
    L27:
        if (r7 != null) goto L29;
        String r5 = "";
    L30:
        r0.m(r18, r5, r13, new com.larus.bmhome.chat.component.bottom.voice.service.b(), new com.larus.bmhome.chat.component.bottom.voice.service.c(), new r3(r10, r9), new s3(r10, r9));
        return Unit.INSTANCE;
    L29:
        r5 = r7;
        goto L30
    L23:
        r4 = r17;
        goto L24
    L20:
        r17 = null;
        goto L21
    L17:
        r3 = r16;
    L14:
        r16 = null;
        goto L15
    L9:
        r2 = r1;
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
