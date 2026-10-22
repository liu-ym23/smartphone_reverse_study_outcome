package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u000201B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020 H\u0002J \u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0012H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/TouchInterceptionLayout2;", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handler", "Landroid/os/Handler;", "mDoubleTapSlopSquare", BuildConfig.FLAVOR, "doubleClickEnable", BuildConfig.FLAVOR, "doubleClickListener", "Lcom/ss/android/lark/chatwindow/view/widget/TouchInterceptionLayout2$DoubleClickListener;", "mStillDown", "mCurrentDownEvent", "Landroid/view/MotionEvent;", "mPreviousUpEvent", "mIsDoubleTapping", "doubleTapTimeout", BuildConfig.FLAVOR, "getDoubleTapTimeout", "()J", "setDoubleTapTimeout", "(J)V", "doubleTapMinTime", "getDoubleTapMinTime", "setDoubleTapMinTime", "isConsumed", "setIsEnableDoubleClick", BuildConfig.FLAVOR, "enable", "setDoubleClickListener", "dispatchTouchEvent", "ev", "onTouchEvent", "event", "cancelChildrenLongPress", "viewGroup", "Landroid/view/ViewGroup;", ChameleonOpenTracker.OpenResult.CANCEL, "isConsideredDoubleTap", "firstDown", "firstUp", "secondDown", "dispatchTouchEventToChildren", "Companion", "DoubleClickListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchInterceptionLayout2 extends LKUIRoundableLayout {
    public boolean r;
    public long s;
    public long t;
    public boolean u;

    public static final class a extends Handler {
        public final /* synthetic */ TouchInterceptionLayout2 a;

        /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.FrameLayout, com.ss.android.lark.chatwindow.view.widget.TouchInterceptionLayout2] */
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
        @Override // android.os.Handler
        public final void handleMessage(Message r13) {
            Intrinsics.checkNotNullParameter(r13, "msg");
            super.handleMessage(r13);
            Log.d("TouchInterceptionLayout2", "handleMessage");
            if (r13.what != 65537) goto L17;
            ?? r1 = this.a;
            int r3 = 0;
            if (r1.u == false) goto L8;
            r1.performClick();
            this.a.u = false;
            return;
        L8:
            Log.d("TouchInterceptionLayout2", "performClick");
            Object r14 = r13.obj;
            if ((r14 instanceof MotionEvent) == false) goto L11;
            MotionEvent r15 = (MotionEvent) r14;
        L12:
            if (r15 == null) goto L20;
            LKUIRoundableLayout r0 = this.a;
            r0.getClass();
            MotionEvent r16 = MotionEvent.obtain(r15.getDownTime(), 1 + r15.getEventTime(), 1, r15.getX() - r0.getPaddingLeft(), r15.getY() - r0.getPaddingTop(), r15.getMetaState());
            int r2 = r0.getChildCount();
        L14:
            if (r3 >= r2) goto L16;
            View r4 = r0.getChildAt(r3);
            MotionEvent r5 = MotionEvent.obtain(r16);
            r4.dispatchTouchEvent(r5);
            r5.recycle();
            r3 = r3 + 1;
            goto L14
        L16:
            r16.recycle();
            return;
        L20:
            return;
        L11:
            r15 = null;
            goto L12
        L17:
            Log.d("TouchInterceptionLayout2", "unknown msg");
        }

        public a(TouchInterceptionLayout2 r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class b {
    }

    public interface c {
    }

    static {
    }

    public final void setDoubleClickListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "doubleClickListener");
    }

    public final long getDoubleTapMinTime() {
        return this.t;
    }

    public final long getDoubleTapTimeout() {
        return this.s;
    }

    public TouchInterceptionLayout2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        boolean r0 = this.r;
        return super/*android.widget.FrameLayout*/.dispatchTouchEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r2) {
        boolean r0 = this.r;
        return super/*android.widget.FrameLayout*/.onTouchEvent(r2);
    }

    public final void setDoubleTapMinTime(long r1) {
        this.t = r1;
    }

    public final void setDoubleTapTimeout(long r1) {
        this.s = r1;
    }

    public final void setIsEnableDoubleClick(boolean r1) {
        this.r = r1;
    }

    public TouchInterceptionLayout2(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 4, 0);
        this.s = 199;
        this.t = 40;
        new a(this, Looper.getMainLooper());
        ViewConfiguration r5 = ViewConfiguration.get(r3);
        r5.getScaledDoubleTapSlop();
        r5.getScaledDoubleTapSlop();
    }
}
