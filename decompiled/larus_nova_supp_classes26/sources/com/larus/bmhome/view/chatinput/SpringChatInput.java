package com.larus.bmhome.view.chatinput;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.bmhome.chat.i4;
import com.larus.bmhome.view.ChatInputText;
import com.larus.chat.common.databinding.LarusWidgetInputSuggestedActionBinding;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.i;
import com.larus.input.impl.databinding.LarusWidgetInputSpringBinding;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.g;
import com.larus.platform.service.y0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import et8.c;
import et8.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ye8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0015\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fJ\u0012\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020!H\u0002J\u0012\u0010&\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020!H\u0016J\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0007H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/larus/bmhome/view/chatinput/SpringChatInput;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/input/impl/databinding/LarusWidgetInputSpringBinding;", "getBinding", "()Lcom/larus/input/impl/databinding/LarusWidgetInputSpringBinding;", "isImmersiveSlidingFeedVertical", "", "actionDownInActionBar", "setIsImmersiveSlidingFeedVertical", "", "isVertical", "gestureListener", "com/larus/bmhome/view/chatinput/SpringChatInput$gestureListener$2$1", "getGestureListener", "()Lcom/larus/bmhome/view/chatinput/SpringChatInput$gestureListener$2$1;", "gestureListener$delegate", "Lkotlin/Lazy;", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isTouchInView", "view", "Landroid/view/View;", "event", "onInterceptTouchEvent", "onTouchEvent", "inputAreaContainer", "Landroid/view/ViewGroup;", "setVisibility", "visibility", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpringChatInput extends ConstraintLayout {
    public static final /* synthetic */ int f = 0;
    public final LarusWidgetInputSpringBinding a;
    public boolean b;
    public boolean c;
    public final Lazy d;
    public final Lazy e;

    public static final class a {
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ SpringChatInput a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return true;
        }

        public b(SpringChatInput r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            this.a.performClick();
            return true;
        }
    }

    static {
    }

    public SpringChatInput(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SpringChatInput(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.e.getValue();
    }

    private final b getGestureListener() {
        return (b) this.d.getValue();
    }

    public final LarusWidgetInputSpringBinding getBinding() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static GestureDetector R5(SpringChatInput r2) {
        return new GestureDetector(r2.getContext(), r2.getGestureListener());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        if (r6 != null) goto L67;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L18;
        ViewParent r1 = getParent();     // Catch: Throwable -> L7
        if (r1 == null) goto L65;
        r1.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L7
    L65:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L16
        this.c = S5(findViewById(2131362044), r6);     // Catch: Throwable -> L16
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L61:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r6);
    L16:
        th = move-exception;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        FLogger.a.e("ChatInput", "dispatchTouchEvent failed:" + th);
        return true;
    L18:
        if (r6 != null) goto L20;
    L22:
        boolean r5 = false;
    L23:
        if (r5 == false) goto L61;
        if (S5(this, r6) == true) goto L61;
        if (this.b == false) goto L61;
        if (this.c == false) goto L61;
        i4 r7 = AppHost.a.a().getCurrentActivity();     // Catch: Throwable -> L7
        l r8 = null;
        if ((r7 instanceof i4) == false) goto L33;
        i4 r9 = r7;     // Catch: Throwable -> L7
    L34:
        if (r9 == null) goto L37;
        Fragment r10 = r9.getCurrentFragment();     // Catch: Throwable -> L7
        if (r10 == null) goto L37;
    L50:
        if (r10 == null) goto L52;
        r8 = (l) s1a.a.g(r10).getAbility(l.class);     // Catch: Throwable -> L7
    L52:
        if (r8 != null) goto L54;
    L56:
        boolean r11 = false;
    L57:
        if (r11 == true) goto L61;
        ViewParent r12 = getParent();     // Catch: Throwable -> L7
        if (r12 == null) goto L61;
        r12.requestDisallowInterceptTouchEvent(false);     // Catch: Throwable -> L7
        goto L61
    L54:
        if (r8.m0() != true) goto L56;
        r11 = true;
    L37:
        IFlowSdkDepend r13 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L7
        if (r13 == null) goto L42;
        r13.f0();     // Catch: Throwable -> L7
        Fragment r14 = i.a.a();     // Catch: Throwable -> L7
    L44:
        if ((r14 instanceof i4) == false) goto L46;
        i4 r15 = (i4) r14;     // Catch: Throwable -> L7
    L47:
        if (r15 == null) goto L49;
        r10 = r15.getCurrentFragment();     // Catch: Throwable -> L7
        goto L50
    L49:
        r10 = null;
        goto L50
    L46:
        r15 = null;
        goto L47
    L42:
        r14 = null;
        goto L44
    L33:
        r9 = null;
        goto L34
    L20:
        if (r6.getActionMasked() != 2) goto L22;
        r5 = true;
        goto L23
    L67:
        if (r6.getActionMasked() != 0) goto L9;
        r2 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        boolean r0 = y0.a.h();
        if (r3 == null) goto L11;
        if (r0 == true) goto L11;
        ArrayList<d> r4 = c.a;
        Intrinsics.checkNotNullParameter(getContext(), "context");
        Iterator<d> r5 = c.a.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r5.next().onIntercept();
        goto L7
    L9:
        return true;
    L11:
        if (isEnabled() == true) goto L16;
        if (this.c == true) goto L16;
        return true;
    L16:
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (isEnabled() == true) goto L9;
        if (this.c == true) goto L9;
        return getGestureDetector().onTouchEvent(r2);
    L9:
        return super/*android.view.ViewGroup*/.onTouchEvent(r2);
    }

    public final void setIsImmersiveSlidingFeedVertical(boolean r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r4) {
        super/*android.view.ViewGroup*/.setVisibility(r4);
        FLogger.a.i("ChatInput", "setVisibility visibility=" + r4);
        if (r4 != 4) goto L5;
    L7:
        g.a.ensureNotReachHere(new Throwable("ChatInput-SetVisibilityException"));
        return;
    L5:
        if (r4 == 8) goto L7;
    }

    public final boolean S5(View r6, MotionEvent r7) {
        if (r6 != null) goto L5;
        return false;
    L5:
        int[] r1 = new int[2];
        r6.getLocationOnScreen(r1);
        float r2 = r7.getRawX();
        float r8 = r7.getRawY();
        int r3 = r1[0];
        if (r2 >= r3) goto L8;
        return false;
    L8:
        if (r2 > (r3 + r6.getWidth())) goto L16;
        int r4 = r1[1];
        if (r8 >= r4) goto L12;
        return false;
    L12:
        if (r8 > (r4 + r6.getHeight())) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpringChatInput(Context r16, AttributeSet r17, int r18) {
        Intrinsics.checkNotNullParameter(r16, "context");
        super(r16, r17, r18);
        LayoutInflater.from(r16).inflate(2131563252, this);
        int r0 = 2131362038;
        if (ViewBindings.findChildViewById(this, 2131362038) == null) goto L95;
        r0 = 2131362039;
        if (((LinearLayout) ViewBindings.findChildViewById(this, 2131362039)) == null) goto L95;
        r0 = 2131362041;
        if (ViewBindings.findChildViewById(this, 2131362041) == null) goto L95;
        r0 = 2131362044;
        if (ViewBindings.findChildViewById(this, 2131362044) == null) goto L95;
        r0 = 2131362049;
        if (ViewBindings.findChildViewById(this, 2131362049) == null) goto L95;
        r0 = 2131362060;
        if (ViewBindings.findChildViewById(this, 2131362060) == null) goto L95;
        r0 = 2131362090;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(this, 2131362090);
        if (r2 == null) goto L95;
        r0 = 2131362091;
        if (ViewBindings.findChildViewById(this, 2131362091) == null) goto L95;
        r0 = 2131362092;
        if (((TextView) ViewBindings.findChildViewById(this, 2131362092)) == null) goto L95;
        r0 = 2131362093;
        if (ViewBindings.findChildViewById(this, 2131362093) == null) goto L95;
        r0 = 2131362097;
        if (ViewBindings.findChildViewById(this, 2131362097) == null) goto L95;
        r0 = 2131362113;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131362113);
        if (r3 == null) goto L95;
        r0 = 2131362118;
        if (((ViewStub) ViewBindings.findChildViewById(this, 2131362118)) == null) goto L95;
        r0 = 2131362119;
        if (((ViewStub) ViewBindings.findChildViewById(this, 2131362119)) == null) goto L95;
        r0 = 2131362120;
        if (((ImageView) ViewBindings.findChildViewById(this, 2131362120)) == null) goto L95;
        r0 = 2131362128;
        if (ViewBindings.findChildViewById(this, 2131362128) == null) goto L95;
        r0 = 2131362129;
        if (ViewBindings.findChildViewById(this, 2131362129) == null) goto L95;
        r0 = 2131362130;
        if (((TextView) ViewBindings.findChildViewById(this, 2131362130)) == null) goto L95;
        r0 = 2131362132;
        if (((ImageView) ViewBindings.findChildViewById(this, 2131362132)) == null) goto L95;
        r0 = 2131362133;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(this, 2131362133);
        if (r4 == null) goto L95;
        r0 = 2131362143;
        if (ViewBindings.findChildViewById(this, 2131362143) == null) goto L95;
        r0 = 2131362144;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(this, 2131362144);
        if (r5 == null) goto L95;
        r0 = 2131362145;
        if (ViewBindings.findChildViewById(this, 2131362145) == null) goto L95;
        r0 = 2131362153;
        if (ViewBindings.findChildViewById(this, 2131362153) == null) goto L95;
        r0 = 2131363511;
        if (ViewBindings.findChildViewById(this, 2131363511) == null) goto L95;
        r0 = 2131369128;
        if (((TextView) ViewBindings.findChildViewById(this, 2131369128)) == null) goto L95;
        r0 = 2131369229;
        View r6 = ViewBindings.findChildViewById(this, 2131369229);
        if (r6 == null) goto L95;
        r0 = 2131369230;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(this, 2131369230);
        if (r7 == null) goto L95;
        r0 = 2131369231;
        View r8 = ViewBindings.findChildViewById(this, 2131369231);
        if (r8 == null) goto L95;
        r0 = 2131373057;
        if (((EditText) ViewBindings.findChildViewById(this, 2131373057)) == null) goto L95;
        r0 = 2131375332;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(this, 2131375332);
        if (r9 == null) goto L95;
        r0 = 2131375333;
        if (((LinearLayout) ViewBindings.findChildViewById(this, 2131375333)) == null) goto L95;
        r0 = 2131375335;
        if (ViewBindings.findChildViewById(this, 2131375335) == null) goto L95;
        r0 = 2131375336;
        if (ViewBindings.findChildViewById(this, 2131375336) == null) goto L95;
        r0 = 2131375340;
        if (ViewBindings.findChildViewById(this, 2131375340) == null) goto L95;
        r0 = 2131375368;
        if (((ViewStub) ViewBindings.findChildViewById(this, 2131375368)) == null) goto L95;
        r0 = 2131375413;
        View r1 = ViewBindings.findChildViewById(this, 2131375413);
        if (r1 == null) goto L95;
        LarusWidgetInputSuggestedActionBinding.a(r1);
        r0 = 2131375415;
        if (((ChatInputText) ViewBindings.findChildViewById(this, 2131375415)) == null) goto L95;
        r0 = 2131375962;
        if (ViewBindings.findChildViewById(this, 2131375962) == null) goto L95;
        r0 = 2131377552;
        if (ViewBindings.findChildViewById(this, 2131377552) == null) goto L95;
        r0 = 2131377595;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(this, 2131377595);
        if (r10 == null) goto L95;
        r0 = 2131383294;
        if (((ProgressBar) ViewBindings.findChildViewById(this, 2131383294)) == null) goto L95;
        r0 = 2131387050;
        if (ViewBindings.findChildViewById(this, 2131387050) == null) goto L95;
        r0 = 2131392727;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(this, 2131392727);
        if (r11 == null) goto L95;
        r0 = 2131392769;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(this, 2131392769);
        if (r12 == null) goto L95;
        this.a = new LarusWidgetInputSpringBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        this.d = LazyKt.lazy(new et8.l(this));
        this.e = LazyKt.lazy(new m(this));
        return;
    L95:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public /* synthetic */ SpringChatInput(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
