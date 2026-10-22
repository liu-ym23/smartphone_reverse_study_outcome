package com.ss.android.lark.keyboard.edittext2.span;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.edittext2.widget.o;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class h extends o {
    public long a;
    public float b;
    public float c;
    public final Handler d;
    public final int e;

    public static final class a implements Runnable {
        public final TextView a;
        public final i b;

        public final void a() {
            this.a.cancelLongPress();
            this.b.b(this.a);
            ViewParent r0 = this.a.getParent();
            if ((r0 instanceof ViewGroup) == false) goto L6;
            long r4 = SystemClock.uptimeMillis();
            MotionEvent r1 = MotionEvent.obtain(r4, r4, 1, 0.0f, 0.0f, 0);
            r1.setSource(4098);
            ((ViewGroup) r0).dispatchTouchEvent(r1);
            r1.recycle();
        L6:
            Log.d("LongClickLinkMovementMethod", "CheckForLongClick: invoke long click");
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

        public a(TextView r2, i r3) {
            Intrinsics.checkNotNullParameter(r2, "widget");
            Intrinsics.checkNotNullParameter(r3, "target");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    static {
    }

    public h() {
        this.d = new Handler(Looper.getMainLooper());
        this.e = ViewConfiguration.getLongPressTimeout() - ViewConfiguration.getTapTimeout();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.widget.o, android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r12, Spannable r13, MotionEvent r14) {
        if (r14 == null) goto L40;
        if (r12 == null) goto L40;
        if (r13 == null) goto L40;
        int r0 = r14.getActionMasked();
        float r1 = r14.getX();
        float r2 = r14.getY();
        float r3 = r1 - r12.getTotalPaddingLeft();
        float r4 = r2 - r12.getTotalPaddingTop();
        float r5 = r3 + r12.getScrollX();
        float r6 = r4 + r12.getScrollY();
        Layout r7 = r12.getLayout();
        int r8 = r7.getOffsetForHorizontal(r7.getLineForVertical((int) r6), r5);
        i[] r9 = (i[]) r13.getSpans(r8, r8, i.class);
        boolean r10 = false;
        if (r9 != null) goto L9;
    L15:
        boolean r11 = true;
    L16:
        if (r11 == true) goto L18;
        i r15 = r9[0];
        Log.d("LongClickLinkMovementMethod", "onTouchEvent: action is " + r0);
        if (r0 == 0) goto L36;
        if (r0 != 1) goto L23;
        Log.d("LongClickLinkMovementMethod", "onTouchEvent: MotionEvent.ACTION_UP");
        if ((System.currentTimeMillis() - this.a) >= this.e) goto L38;
        this.d.removeMessages(65297);
    L38:
        return super.onTouchEvent(r12, r13, r14);
    L23:
        if (r0 != 2) goto L25;
        Log.d("LongClickLinkMovementMethod", "onTouchEvent: MotionEvent.ACTION_MOVE");
        int r16 = ViewConfiguration.get(r12.getContext()).getScaledTouchSlop();
        double r17 = 2;
        if ((((float) Math.pow(r5 - this.b, r17)) + ((float) Math.pow(r6 - this.c, r17))) <= (r16 * r16)) goto L31;
        r10 = true;
    L31:
        if (r10 == false) goto L38;
        this.d.removeMessages(65297);
        goto L38
    L25:
        if (r0 != 3) goto L38;
        Log.d("LongClickLinkMovementMethod", "onTouchEvent: MotionEvent.ACTION_CANCEL");
        this.d.removeMessages(65297);
        goto L38
    L36:
        Log.d("LongClickLinkMovementMethod", "onTouchEvent: MotionEvent.ACTION_DOWN, handler. handler contains pending msg:" + this.d.hasMessages(65297));
        this.d.removeMessages(65297);
        Handler r18 = this.d;
        Intrinsics.checkNotNull(r15);
        Message r19 = Message.obtain(r18, new a(r12, r15));
        r19.what = 65297;
        StringBuilder r20 = new StringBuilder("handler#sendDelay, delayed ");
        r20.append(this.e);
        Log.d("LongClickLinkMovementMethod", r20.toString());
        this.d.sendMessageDelayed(r19, this.e);
        this.a = System.currentTimeMillis();
        this.b = r5;
        this.c = r6;
        goto L38
    L18:
        return super.onTouchEvent(r12, r13, r14);
    L9:
        if (r9.length != 0) goto L11;
        boolean r21 = true;
    L12:
        if (r21 == true) goto L15;
        r11 = false;
        goto L16
    L11:
        r21 = false;
    L40:
        return super.onTouchEvent(r12, r13, r14);
    }
}
