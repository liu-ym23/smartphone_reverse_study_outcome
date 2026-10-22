package k80;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.autodispose.OutsideScopeException;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements CompletableSource {
    public final View a;

    /* JADX INFO: renamed from: k80.a$a, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC0242a extends qtc.a implements View.OnAttachStateChangeListener {
        public final View b;
        public final io.reactivex.b c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public final void b() {
            this.b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
            if (isDisposed() == true) goto L6;
            this.c.onComplete();
            return;
        }

        public ViewOnAttachStateChangeListenerC0242a(View r1, io.reactivex.b r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public a(View r1) {
        this.a = r1;
    }

    public final void subscribe(io.reactivex.b r3) {
        ViewOnAttachStateChangeListenerC0242a r0 = new ViewOnAttachStateChangeListenerC0242a(this.a, r3);
        r3.onSubscribe(r0);
        if (l80.b.a.getAsBoolean() == true) goto L8;
        r3.onError(new IllegalStateException("Views can only be bound to on the main thread!"));
        return;
    L8:
        if (this.a.isAttachedToWindow() == false) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L17;
        r3.onError(new OutsideScopeException("View is not attached!"));
        return;
    L17:
        this.a.addOnAttachStateChangeListener(r0);
        if (r0.isDisposed() == false) goto L26;
        this.a.removeOnAttachStateChangeListener(r0);
        return;
    L26:
        return;
    L10:
        if (this.a.getWindowToken() != null) goto L13;
        r1 = false;
    L21:
        e = move-exception;
        throw Exceptions.propagate(e);
    }
}
