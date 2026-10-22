package u19;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.larus.common_ui.toast.ToastLayout;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a<T> implements f {
    private boolean _isShown;
    private int displayDuration;
    private Drawable iconDrawable;
    private int iconDrawableRes;
    private T instance;
    private Function1<? super LottieAdapterView, Unit> lottieConfig;
    private boolean shouldAutoDisappear;
    private CharSequence text;
    private ToastLayout toastLayout;
    private Integer toastYOffsetPx;

    /* JADX INFO: renamed from: u19.a$a, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC0141a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewOnAttachStateChangeListenerC0141a(ToastLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            this.a.removeOnAttachStateChangeListener(this);
            LottieAdapterView r3 = r2.findViewById(2131379210);
            if ((r3 instanceof LottieAdapterView) == false) goto L5;
            LottieAdapterView r4 = r3;
        L6:
            if (r4 == null) goto L9;
            r4.playAnimation();
            return;
        L9:
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public void clear() {
        this.iconDrawableRes = 0;
        this.iconDrawable = null;
        this.text = "";
        setLottieConfig(null);
        this.toastYOffsetPx = null;
        this.toastLayout = null;
    }

    public abstract boolean getSupportLottie();

    public abstract T newInstance(Context r1, LifecycleOwner r2, int r3, boolean r4);

    public a() {
        this.text = "";
        this.shouldAutoDisappear = true;
    }

    @Override // u19.f
    public void dismiss() {
        clear();
        this._isShown = false;
    }

    public int getDisplayDuration() {
        return this.displayDuration;
    }

    public Object getHoldInstance() {
        return this.instance;
    }

    public final Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    public final int getIconDrawableRes() {
        return this.iconDrawableRes;
    }

    public final T getInstance() {
        return this.instance;
    }

    public final Function1<LottieAdapterView, Unit> getLottieConfig() {
        return this.lottieConfig;
    }

    public final boolean getShouldAutoDisappear() {
        return this.shouldAutoDisappear;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final ToastLayout getToastLayout() {
        return this.toastLayout;
    }

    public final Integer getToastYOffsetPx() {
        return this.toastYOffsetPx;
    }

    public final boolean get_isShown() {
        return this._isShown;
    }

    @Override // u19.f
    public boolean isShown() {
        return this._isShown;
    }

    public void icon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.iconDrawable = r2;
    }

    @Override // u19.f
    public void lottie(Function1<? super LottieAdapterView, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        setLottieConfig(r2);
    }

    @Override // u19.f
    public void setAutoDisappear(boolean r1) {
        this.shouldAutoDisappear = r1;
    }

    public void setDisplayDuration(int r1) {
        this.displayDuration = r1;
    }

    public final void setIconDrawable(Drawable r1) {
        this.iconDrawable = r1;
    }

    public final void setIconDrawableRes(int r1) {
        this.iconDrawableRes = r1;
    }

    public final void setInstance(T r1) {
        this.instance = r1;
    }

    public final void setLottieConfig(Function1<? super LottieAdapterView, Unit> r2) {
        if (getSupportLottie() == false) goto L6;
        this.lottieConfig = r2;
        return;
    }

    public final void setShouldAutoDisappear(boolean r1) {
        this.shouldAutoDisappear = r1;
    }

    public final void setText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }

    public final void setToastLayout(ToastLayout r1) {
        this.toastLayout = r1;
    }

    public final void setToastYOffsetPx(Integer r1) {
        this.toastYOffsetPx = r1;
    }

    @Override // u19.f
    public void setYOffsetPx(Integer r1) {
        this.toastYOffsetPx = r1;
    }

    public final void set_isShown(boolean r1) {
        this._isShown = r1;
    }

    @Override // u19.f
    public void text(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.text = r2;
    }

    @Override // u19.f
    public void updateText(CharSequence r6) {
        Intrinsics.checkNotNullParameter(r6, "text");
        this.text = r6;
        ConstraintLayout r1 = this.toastLayout;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(r6, "text");
        TextView r2 = (TextView) r1.findViewById(2131388386);
        if (r2 == null) goto L7;
        r2.setText(r6);
    L7:
        T r3 = this.instance;
        ConstraintLayout r4 = null;
        if ((r3 instanceof Toast) == false) goto L10;
        Toast r5 = (Toast) r3;
    L11:
        if (r5 == null) goto L22;
        ConstraintLayout r7 = r5.getView();
        if (r7 != null) goto L15;
        return;
    L15:
        if ((r7 instanceof ToastLayout) == false) goto L17;
        r4 = (ToastLayout) r7;
    L17:
        if (r4 == null) goto L24;
        Intrinsics.checkNotNullParameter(r6, "text");
        TextView r0 = (TextView) r4.findViewById(2131388386);
        if (r0 == null) goto L25;
        r0.setText(r6);
        return;
    L25:
        return;
    L24:
        return;
    L22:
        return;
    L10:
        r5 = null;
        goto L11
    }

    @Override // u19.f
    public void icon(int r1) {
        if (r1 == 0) goto L5;
        this.iconDrawableRes = r1;
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.view.ViewGroup, com.larus.common_ui.toast.ToastLayout] */
    public ToastLayout buildLayout(Context r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        ?? r0 = new ToastLayout(v19.f.g(r9, r10));
        this.toastLayout = r0;
        if (getSupportLottie() == false) goto L19;
        Function1<? super LottieAdapterView, Unit> r11 = this.lottieConfig;
        if (r11 == null) goto L19;
        CharSequence r7 = this.text;
        Intrinsics.checkNotNullParameter(r7, "text");
        if (r0.T5(true, r7) == false) goto L9;
        ViewGroup.inflate(r0.getContext(), 2131562900, r0);
    L10:
        r0.R5(r10);
        TextView r12 = (TextView) r0.findViewById(2131388386);
        LottieAdapterView r1 = r0.findViewById(2131379210);
        Intrinsics.checkNotNull(r1);
        r11.invoke(r1);
        r12.setText(r7);
        if (r0.isAttachedToWindow() == false) goto L18;
        LottieAdapterView r13 = r0.findViewById(2131379210);
        if ((r13 instanceof LottieAdapterView) == false) goto L15;
        LottieAdapterView r14 = r13;
    L16:
        if (r14 == null) goto L32;
        r14.playAnimation();
    L32:
        r0.setYOffsetPx(this.toastYOffsetPx);
        return r0;
    L15:
        r14 = null;
        goto L16
    L18:
        r0.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0141a(r0));
        goto L32
    L9:
        ViewGroup.inflate(r0.getContext(), 2131562899, r0);
    L19:
        Drawable r15 = this.iconDrawable;
        if (r15 == null) goto L26;
        CharSequence r8 = this.text;
        Intrinsics.checkNotNullParameter(r8, "text");
        if (r0.T5(true, r8) == false) goto L24;
        ViewGroup.inflate(r0.getContext(), 2131562900, r0);
    L25:
        r0.R5(r10);
        TextView r16 = (TextView) r0.findViewById(2131388386);
        r0.findViewById(2131379210).setImageDrawable(r15);
        r16.setText(r8);
        goto L32
    L24:
        ViewGroup.inflate(r0.getContext(), 2131562899, r0);
        goto L25
    L26:
        int r17 = this.iconDrawableRes;
        if (r17 == 0) goto L30;
        r0.S5(Integer.valueOf(r17), this.text, r10);
        goto L32
    L30:
        if ((!StringsKt.isBlank(this.text)) == false) goto L32;
        r0.S5(0, this.text, r10);
        goto L32
    }

    public void show(Activity r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        this._isShown = true;
    }

    @Override // u19.f
    public void show(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this._isShown = true;
    }

    @Override // u19.f
    public void show(Fragment r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
        this._isShown = true;
    }

    public final T ensureInstance(Context r2, LifecycleOwner r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        T r0 = this.instance;
        if (r0 != null) goto L6;
        T r1 = newInstance(r2, r3, r4, r5);
        this.instance = r1;
        return r1;
    L6:
        return r0;
    }

    public static /* synthetic */ ToastLayout buildLayout$default(a r0, Context r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = false;
    L7:
        return r0.buildLayout(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildLayout");
    }

    public static /* synthetic */ Object ensureInstance$default(a r0, Context r1, LifecycleOwner r2, int r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L7;
        r4 = false;
    L7:
        return r0.ensureInstance(r1, r2, r3, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureInstance");
    }

    public static /* synthetic */ Object newInstance$default(a r0, Context r1, LifecycleOwner r2, int r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L7;
        r4 = false;
    L7:
        return r0.newInstance(r1, r2, r3, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newInstance");
    }
}
