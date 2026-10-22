package com.bytedance.android.ec.core.anchorv3;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Printer;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.opt.messagequeue.ForceDoFrameMessage;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BasePdpMessageOptWorker {
    public static Field f;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final a j = null;
    public boolean a;
    public Printer b;
    public Boolean c;
    public boolean d;
    public final List<Function1<Boolean, Unit>> e;

    public static final class a {
        public a() {
        }

        public static Object b(Message r10) {
            Intrinsics.checkNotNullParameter(r10, "$this$getLifecycleStateRequest");
            if (r10.what == 159) goto L6;
            return null;
        L6:
            if (BasePdpMessageOptWorker.f == null) goto L18;
        L16:
            Field r0 = BasePdpMessageOptWorker.f;     // Catch: Exception -> L15
            if (r0 == null) goto L20;
            return r0.get(r10.obj);
        L20:
            return null;
        L21:
            return null;
        L18:
            Field r1 = r10.obj.getClass().getDeclaredField("mLifecycleStateRequest");     // Catch: Exception -> L9
            r1.setAccessible(true);     // Catch: Exception -> L9
        L10:
            BasePdpMessageOptWorker.f = r1;
        L9:
            r1 = null;
            goto L10
        }

        public static final Message a(a r1, MessageQueue r10) {
            r1.getClass();
            Field r0 = (Field) BasePdpMessageOptWorker.g.getValue();     // Catch: Exception -> L13
            if (r0 == null) goto L6;
            Object r11 = r0.get(r10);     // Catch: Exception -> L13
        L8:
            if ((r11 instanceof Message) == true) goto L10;
            r11 = null;
        L10:
            return (Message) r11;
        L6:
            r11 = null;
        L16:
            return null;
        }
    }

    public static final class b implements Printer {
        public final /* synthetic */ BasePdpMessageOptWorker a;

        public b(BasePdpMessageOptWorker r1) {
            this.a = r1;
        }

        @Override // android.util.Printer
        public final void println(String r10) {
            Printer r0 = this.a.b;
            if (r0 == null) goto L5;
            r0.println(r10);
        L5:
            Boolean r1 = this.a.c;
            if (r1 != null) goto L8;
            Boolean r11 = Boolean.valueOf(StringsKt.startsWith$default(r10, "<", false, 2, null));
        L9:
            this.a.c = r11;
            if (PdpMessageOpt.a == false) goto L13;
            PdpMessageOpt.e("loopMessage isAfter=" + r11 + ' ' + r10);
        L13:
            if (r11.booleanValue() == false) goto L16;
            this.a.d();
            return;
        L16:
            return;
        L8:
            r11 = Boolean.valueOf(!r1.booleanValue());
            goto L9
        }
    }

    public abstract void a(Object r1);

    public abstract void b();

    public abstract void c(boolean r1);

    public abstract void d();

    public abstract void e(boolean r1);

    public abstract void g();

    public abstract void i();

    static {
        j = new a();
        g = LazyKt.lazy(BasePdpMessageOptWorker$Companion$field_MessageQueue_mMessage$2.INSTANCE);
        h = LazyKt.lazy(BasePdpMessageOptWorker$Companion$field_Message_next$2.INSTANCE);
        i = LazyKt.lazy(BasePdpMessageOptWorker$Companion$field_Looper_mLogging$2.INSTANCE);
    }

    public final void f() {
        if (this.d == true) goto L6;
        this.d = true;
        boolean r0 = PdpMessageOpt.a;
        Intrinsics.checkNotNullParameter("schedule force do frame", MessageIndication.MESSAGE_TYPE_MSG);
        ForceDoFrameMessage.a();
        return;
    }

    public final void h() {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        a r0 = j;
        Looper r1 = Looper.getMainLooper();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$getCurLogging");
        Printer r10 = null;
        Field r11 = (Field) i.getValue();     // Catch: Exception -> L17
        if (r11 == null) goto L9;
        Object r12 = r11.get(r1);     // Catch: Exception -> L17
    L11:
        if ((r12 instanceof Printer) == true) goto L13;
        r12 = null;
    L13:
        r10 = (Printer) r12;     // Catch: Exception -> L17
        goto L15
    L9:
        r12 = null;
    L15:
        this.b = r10;
        Looper.getMainLooper().setMessageLogging(new b(this));
    }

    public BasePdpMessageOptWorker() {
        this.e = new ArrayList();
    }
}
