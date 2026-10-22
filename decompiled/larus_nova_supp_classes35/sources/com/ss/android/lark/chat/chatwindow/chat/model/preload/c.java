package com.ss.android.lark.chat.chatwindow.chat.model.preload;

import android.text.TextUtils;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask;
import com.ss.android.lark.biz.im.api.extension.message.TaskType;
import com.ss.android.lark.biz.im.api.extension.message.f;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.v2.AudioResourceLoadTask;
import com.ss.android.lark.chat.core.api.e;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.contact.base.entity.api.ContactMobileApi$From;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.chat.chatwindow.chat.model.preload.b {
    public final String a;
    public final f b;
    public final Map<String, IMessageResourcePreloadTask> c;
    public final Set<String> d;
    public MessageResourceLoadConfig e;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ List<MessageInfo> b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(c r1, List<? extends MessageInfo> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            c r0 = this.a;
            List<MessageInfo> r1 = this.b;
            r0.getClass();
            LinkedHashSet r2 = new LinkedHashSet();
            Iterator<MessageInfo> r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L12;
            MessageInfo r4 = r3.next();
            String r5 = r4.getId();
            if (TextUtils.isEmpty(r5) == true) goto L4;
            if (((HashSet) r0.d).contains(r5) == true) goto L4;
            r2.add(r4);
            Set<String> r6 = r0.d;
            Intrinsics.checkNotNull(r5);
            ((HashSet) r6).add(r5);
            goto L4
        L12:
            Iterator r7 = ((HashMap) r0.c).values().iterator();
        L14:
            if (r7.hasNext() == false) goto L45;
            IMessageResourcePreloadTask r8 = (IMessageResourcePreloadTask) r7.next();
            r8.isEnabled();
            MessageResourceLoadConfig r9 = null;
            if (Intrinsics.areEqual(r8.getTaskType(), ContactMobileApi$From.DOC) == false) goto L24;
            MessageResourceLoadConfig r10 = r0.e;
            if (r10 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("preloadLimitConfig");
            r10 = null;
        L21:
            if (r10.a == false) goto L14;
        L24:
            if (Intrinsics.areEqual(r8.getTaskType(), "mini_app") == false) goto L33;
            MessageResourceLoadConfig r11 = r0.e;
            if (r11 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("preloadLimitConfig");
        L30:
            if (r9.b == true) goto L33;
        L28:
            r9 = r11;
        L33:
            if (r8.f() == false) goto L35;
            HashSet r12 = r2;
        L36:
            Log.d(r0.d(), "handleMessages:" + r8.f() + '/' + r12.size() + '/' + r8.getTaskType());
            LinkedHashSet r13 = new LinkedHashSet();
            Iterator r14 = r12.iterator();
        L38:
            if (r14.hasNext() == false) goto L43;
            MessageInfo r15 = (MessageInfo) r14.next();
            if (r8.d(r15.getMessage().getType()) == false) goto L38;
            r13.add(r15);
            goto L38
        L43:
            if (CollectionUtils.isNotEmpty(r13) == false) goto L14;
            r8.c(r13);
            goto L14
        L35:
            r12 = new HashSet(r1);
            goto L36
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
    }

    static {
    }

    public final String d() {
        return "MessageResourceLoader-" + this.a;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.model.preload.b
    public final void destroy() {
        Iterator r0 = ((HashMap) this.c).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        IMessageResourcePreloadTask r1 = (IMessageResourcePreloadTask) r0.next();
        r1.b();
        Log.i(d(), "task " + r1.getTaskType() + " destroy result: true");
        goto L4
    L6:
        f r2 = this.b;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.d = null;
        Log.i(d(), "onDestroy");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.model.preload.b
    public final void a(e r4) {
        Intrinsics.checkNotNullParameter(r4, "factory");
        List<IMessageResourcePreloadTask> r5 = r4.a(this.b);
        if (r5 == null) goto L8;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        IMessageResourcePreloadTask r0 = (IMessageResourcePreloadTask) r6.next();
        ((HashMap) this.c).put(r0.getTaskType(), r0);
    L8:
        this.e = MessageResourceLoadConfig.a();
        Log.i(d(), "onCreate registered resource preload tasks: " + ((HashMap) this.c).keySet());
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.model.preload.b
    public final void b(List<? extends MessageInfo> r3) {
        Intrinsics.checkNotNullParameter(r3, "messageInfoList");
        if (DevicePerfUtils.d().ordinal() <= DevicePerfUtils.DevicePerfLevel.LOW.ordinal()) goto L5;
        return;
    L5:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(this, r3));
    }

    public c(@IMessageResourcePreloadTask.Scene String r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
        this.c = new HashMap();
        this.d = new HashSet();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.model.preload.b
    public final void c(@TaskType String r4, List<? extends MessageInfo> r5, String r6, String r7, IGetDataCallback<Map<String, String>> r8) {
        Intrinsics.checkNotNullParameter(r4, "taskType");
        if (r5 == null) goto L5;
        HashSet r0 = new HashSet(r5);
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r4, "audio") == false) goto L10;
        boolean r9 = e1c.d.m;
        e1c.d.b.a.l(AudioResourceLoadTask.class, new AudioResourceLoadTask.b(r0, this.b, r6, r7), r8);
        return;
    L10:
        IMessageResourcePreloadTask r10 = (IMessageResourcePreloadTask) ((HashMap) this.c).get(r4);
        if (r10 == null) goto L16;
        r10.e(r0, r8);
        return;
    L16:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
