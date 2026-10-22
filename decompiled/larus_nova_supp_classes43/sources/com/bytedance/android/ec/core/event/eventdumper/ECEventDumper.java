package com.bytedance.android.ec.core.event.eventdumper;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.event.eventdumper.model.ClassInfo;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedClassInfo;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEvent;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventBatch;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventKey;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventParam;
import com.bytedance.android.ec.core.event.eventdumper.model.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/ECEventDumper;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "a", "b", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECEventDumper extends BroadcastReceiver {
    public static final ug.a c = null;
    public static boolean d;
    public static final long e = 0;
    public static final int f = 0;
    public static boolean g;
    public static final a h = null;
    public final Gson a;
    public final b b;

    public static final class a {
        public a() {
        }

        public static String a(StackTraceElement[] r10) {
            StringBuilder r0 = new StringBuilder("stack trace: \n");
            int r1 = r10.length;
            int r11 = 0;
        L3:
            if (r11 >= r1) goto L6;
            StackTraceElement r12 = r10[r11];
            r0.append("     at ");
            r0.append(r12.toString());
            r0.append("\n");
            r11 = r11 + 1;
            goto L3
        L6:
            return r0.toString();
        }

        public static void c(tg.a r21) {
            Intrinsics.checkNotNullParameter(r21, "dumpedEvent");
            if (ECEventDumper.d == true) goto L5;
            return;
        L5:
            StackTraceElement[] r0 = ThreadMethodProxy.currentThread().getStackTrace();
            ug.a r10 = ECEventDumper.c;
            String r11 = r21.getEventName();
            Map<DumpedEventKey, DumpedEventParam> r12 = r21.getDumpedDumpedEventParams();
            String r13 = a(r0);
            DumpedClassInfo r14 = new DumpedClassInfo();
            ClassInfo r15 = new ClassInfo();
            r15.setClassFileName(r21.getClass().getSimpleName().concat(".kt"));
            Package r16 = r21.getClass().getPackage();
            if (r16 == null) goto L8;
            String r17 = r16.getName();
        L9:
            r15.setPkName(r17);
            Unit r18 = Unit.INSTANCE;
            r14.setEventClassInfo(r15);
            StackTraceElement r1 = (StackTraceElement) ArraysKt.getOrNull(r0, 4);
            if (r1 == null) goto L12;
            ClassInfo r19 = new ClassInfo();
            r19.setClassFileName(r1.getFileName());
            LinkedList r110 = new LinkedList(StringsKt.split$default(r1.getClassName(), new String[]{"."}, false, 0, 6, null));
            r110.removeLast();
            r19.setPkName(CollectionsKt.joinToString$default(r110, ".", null, null, 0, null, null, 62, null));
            r19.setLine(Integer.valueOf(r1.getLineNumber()));
            r14.setPostLocationClassInfo(r19);
        L12:
            r10.a(new DumpedEvent(r11, r12, r13, 0, r14, null, Integer.valueOf(r21.getEventClassVersion()), 40, null));
            return;
        L8:
            r17 = null;
            goto L9
        }

        public static boolean d(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            int r0 = Process.myPid();
            Object r11 = r10.getSystemService(com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            String r12 = null;
            if ((r11 instanceof ActivityManager) == true) goto L5;
            r11 = null;
        L5:
            ActivityManager r13 = (ActivityManager) r11;
            if (r13 == null) goto L25;
            List<ActivityManager.RunningAppProcessInfo> r14 = r13.getRunningAppProcesses();
            if (r14 == null) goto L25;
            Iterator<T> r15 = r14.iterator();
        L12:
            if (r15.hasNext() == false) goto L19;
            Object r16 = r15.next();
            if (((ActivityManager.RunningAppProcessInfo) r16).pid != r0) goto L16;
            boolean r17 = true;
        L17:
            if (r17 == false) goto L12;
        L20:
            ActivityManager.RunningAppProcessInfo r18 = (ActivityManager.RunningAppProcessInfo) r16;
            if (r18 == null) goto L24;
            r12 = r18.processName;
        L24:
            return Intrinsics.areEqual(r12, "com.ss.android.ugc.aweme");
        L16:
            r17 = false;
            goto L17
        L19:
            r16 = null;
        L25:
            return false;
        }

        public static void b(String r22, Map r23) {
            Intrinsics.checkNotNullParameter(r22, "eventName");
            if (ECEventDumper.d == true) goto L5;
            return;
        L5:
            StackTraceElement[] r0 = ThreadMethodProxy.currentThread().getStackTrace();
            HashMap r10 = new HashMap();
            if (r23 == null) goto L11;
            Iterator r1 = r23.entrySet().iterator();
        L9:
            if (r1.hasNext() == false) goto L11;
            Map.Entry r11 = (Map.Entry) r1.next();
            String r12 = (String) r11.getKey();
            Object r13 = r11.getValue();
            r10.put(new DumpedEventKey(r12, false, 2, null), new DumpedEventParam(String.valueOf(r13), false, null, 6, null));
        L11:
            ug.a r14 = ECEventDumper.c;
            String r15 = a(r0);
            DumpedClassInfo r16 = new DumpedClassInfo();
            StackTraceElement r17 = (StackTraceElement) ArraysKt.getOrNull(r0, 5);
            if (r17 == null) goto L14;
            ClassInfo r18 = new ClassInfo();
            r18.setClassFileName(r17.getFileName());
            LinkedList r19 = new LinkedList(StringsKt.split$default(r17.getClassName(), new String[]{"."}, false, 0, 6, null));
            r19.removeLast();
            Unit r110 = Unit.INSTANCE;
            r18.setPkName(CollectionsKt.joinToString$default(r19, ".", null, null, 0, null, null, 62, null));
            r18.setLine(Integer.valueOf(r17.getLineNumber()));
            r16.setPostLocationClassInfo(r18);
        L14:
            Unit r20 = Unit.INSTANCE;
            r14.a(new DumpedEvent(r22, r10, r15, 0, r16, null, -1, 40, null));
        }
    }

    public static final class b extends Handler {
        public final WeakReference<ECEventDumper> a;

        public b(ECEventDumper r10) {
            Intrinsics.checkNotNullParameter(r10, "eventDumper");
            this.a = new WeakReference(r10);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            int r11 = r10.what;
            int r0 = ECEventDumper.f;
            if (r11 != r0) goto L8;
            ECEventDumper r12 = this.a.get();
            if (r12 == null) goto L9;
            ECEventDumper.d = false;
            ECEventDumper.c.a.clear();
            r12.b.removeMessages(r0);
            return;
        L9:
            return;
        }
    }

    static {
        h = new a();
        c = new ug.a();
        e = 3000;
        f = 1;
    }

    public ECEventDumper() {
        this.a = new GsonBuilder().enableComplexMapKeySerialization().create();
        this.b = new b(this);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r10, Intent r11) {
        if (r11 == null) goto L7;
        Bundle r12 = r11.getExtras();
        if (r12 == null) goto L7;
        Integer r13 = Integer.valueOf(r12.getInt("cmd_type"));
    L8:
        int r0 = 0;
        if (r13 != null) goto L12;
    L24:
        if (r13 != null) goto L27;
    L29:
        if (r13 != null) goto L32;
        return;
    L32:
        if (r13.intValue() != 2) goto L41;
        d = false;
        c.a.clear();
        this.b.removeMessages(f);
        setResultData(GsonProtectorUtils.toJson(this.a, new Result(true, null, 2, null)));
        return;
    L41:
        return;
    L27:
        if (r13.intValue() != 1) goto L29;
        d = true;
        this.b.sendEmptyMessageDelayed(f, e);
        setResultData(GsonProtectorUtils.toJson(this.a, new Result(true, null, 2, null)));
        return;
    L12:
        if (r13.intValue() != 3) goto L24;
        if (d == false) goto L23;
        this.b.removeMessages(f);
        ug.a r14 = c;
        r14.getClass();
        ArrayList r15 = new ArrayList();
    L17:
        if (r0 >= 10) goto L22;
        if (r14.a.peekFirst() == null) goto L21;
        r15.add(r14.a.pop());
    L21:
        r0 = r0 + 1;
        goto L17
    L22:
        setResultData(GsonProtectorUtils.toJson(this.a, new DumpedEventBatch(new Result(true, null, 2, null), r15)));
        this.b.sendEmptyMessageDelayed(f, e);
        return;
    L23:
        setResultData(GsonProtectorUtils.toJson(this.a, new DumpedEventBatch(new Result(false, "not start"), null)));
        return;
    L7:
        r13 = null;
        goto L8
    }
}
