package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.preview.entity.component.property.TimeProperty;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0013\u001a\u00020\tJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/TimingView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "timer", "Ljava/util/concurrent/ScheduledFuture;", "startTimerTask", BuildConfig.FLAVOR, "props", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeProperty;", "getCurrentTimeMilllis", BuildConfig.FLAVOR, "refreshTimerTextview", "timeProperty", "mainThread", BuildConfig.FLAVOR, "endTime", "endTimerTask", "transformTime4Second", BuildConfig.FLAVOR, "time", "Companion", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimingView extends AppCompatTextView {
    public static final /* synthetic */ int b = 0;
    public ScheduledFuture<?> a;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ TimingView a;
        public final /* synthetic */ String b;

        public b(TimingView r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setText(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ TimingView a;
        public final /* synthetic */ String b;

        public c(TimingView r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setText(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        UIHelper.dp2px(2.0f);
    }

    private final long getCurrentTimeMilllis() {
        g6b.a.InterfaceC0223a r0 = g6b.a.a;
        if (r0 == null) goto L6;
        return r0.getNtpTime();
    L6:
        return System.currentTimeMillis();
    }

    public final void y() {
        Log.i("TimingView", "endTimerTask");
        ScheduledFuture<?> r0 = this.a;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        Log.i("TimingView", "cancle:" + r0.cancel(true));
        this.a = null;
        return;
    }

    public TimingView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public static String A(long r10) {
        long r11 = Math.max(0, r10);
        long r2 = 60;
        long r4 = r11 % r2;
        long r6 = 3600;
        long r8 = (r11 % r6) / r2;
        long r12 = r11 / r6;
        if (r12 != 0) goto L5;
        StringCompanionObject r13 = StringCompanionObject.INSTANCE;
        return String.format(Locale.CHINA, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r8), Long.valueOf(r4)}, 2));
    L5:
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(Locale.CHINA, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r12), Long.valueOf(r8), Long.valueOf(r4)}, 3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(TimeProperty r6, boolean r7) {
        long r1 = 0;
        if (Intrinsics.areEqual(r6.isCountDown(), Boolean.TRUE) == false) goto L11;
        Long r0 = r6.getStartTimeStamp();
        if (r0 == null) goto L7;
        long r3 = r0.longValue();
    L8:
        Long r8 = r6.getEndTimeStamp();
        if (r8 == null) goto L18;
        r1 = r8.longValue();
    L18:
        String r9 = A(r3 - r1);
        if (r9 != null) goto L21;
        r9 = "00:00:00";
    L21:
        Log.i("TimingView", "isEnd time = ".concat(r9));
        if (r7 == true) goto L24;
        post(new b(this, r9));
    L25:
        y();
        return;
    L24:
        setText(r9);
        goto L25
    L7:
        r3 = 0;
        goto L8
    L11:
        Long r2 = r6.getEndTimeStamp();
        if (r2 == null) goto L14;
        r3 = r2.longValue();
    L15:
        Long r10 = r6.getStartTimeStamp();
        if (r10 == null) goto L18;
        r1 = r10.longValue();
        goto L18
    L14:
        r3 = 0;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(TimeProperty r9, boolean r10) {
        if (r9 == null) goto L4;
        Long r0 = r9.getStartTimeStamp();
    L5:
        if (r0 != null) goto L8;
        setText("00:00:00");
        return;
    L8:
        long r1 = getCurrentTimeMilllis() / 1000;
        Boolean r2 = r9.isEnd();
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L12;
        x(r9, r10);
        return;
    L12:
        Long r4 = r9.getEndTimeStamp();
        long r5 = 0;
        if (r4 == null) goto L15;
        long r6 = r4.longValue();
    L17:
        if (r6 <= 0) goto L23;
        if (r1 < r6) goto L23;
        x(r9, r10);
        return;
    L23:
        if (Intrinsics.areEqual(r9.isCountDown(), r3) == false) goto L29;
        Long r11 = r9.getStartTimeStamp();
        if (r11 == null) goto L27;
        long r7 = r11.longValue();
    L28:
        long r8 = r7 - r1;
    L35:
        if (r8 >= 0) goto L37;
        Log.e("TimingView", "both getCurrentTimeMilllis() and local time  are less than meeting start time, force to zero");
    L38:
        String r12 = A(r5);
        if (r10 == true) goto L41;
        CoreThreadPool.getDefault().getUIExecutor().execute(new c(this, r12));
        return;
    L41:
        setText(r12);
        return;
    L37:
        r5 = r8;
        goto L38
    L27:
        r7 = 0;
        goto L28
    L29:
        Long r13 = r9.getStartTimeStamp();
        if (r13 == null) goto L32;
        long r14 = r13.longValue();
    L33:
        r8 = r1 - r14;
        goto L35
    L32:
        r14 = 0;
        goto L33
    L15:
        r6 = 0;
        goto L17
    L4:
        r0 = null;
        goto L5
    }
}
