package com.ss.android.lark.chat.chatwindow.chat.model.preload.v2;

import android.text.TextUtils;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask;
import com.ss.android.lark.biz.im.api.extension.message.f;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.MessageResourceLoadConfig;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.contact.base.entity.api.ContactMobileApi$From;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import e1c.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o1c.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements com.ss.android.lark.chat.chatwindow.chat.model.preload.b {
    public final String a;
    public final f b;
    public final Set<String> c;
    public final Map<String, IMessageResourcePreloadTask> d;
    public MessageResourceLoadConfig e;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.preload.v2.a$a, reason: collision with other inner class name */
    public static final class C0053a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ List<MessageInfo> b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(a r1, List<? extends MessageInfo> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            a r0 = this.a;
            List<MessageInfo> r1 = this.b;
            r0.getClass();
            LinkedHashSet r2 = new LinkedHashSet();
            Iterator<MessageInfo> r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L12;
            MessageInfo r4 = r3.next();
            String r5 = r4.getId();
            if (TextUtils.isEmpty(r5) == true) goto L4;
            if (r0.c.contains(r5) == true) goto L4;
            r2.add(r4);
            Set<String> r6 = r0.c;
            Intrinsics.checkNotNull(r5);
            r6.add(r5);
            goto L4
        L12:
            ArrayList r7 = new ArrayList();
            Iterator r8 = r2.iterator();
        L13:
            boolean r9 = false;
            if (r8.hasNext() == false) goto L20;
            Object r10 = r8.next();
            if (((MessageInfo) r10).getMessage().getType() != Message.Type.AUDIO) goto L18;
            r9 = true;
        L18:
            if (r9 == false) goto L13;
            r7.add(r10);
            goto L13
        L20:
            HashSet r11 = CollectionsKt.toHashSet(r7);
            if (CollectionUtils.isEmpty(r11) == true) goto L24;
            boolean r12 = d.m;
            d r13 = d.b.a;
            e r14 = new e();
            AudioResourceLoadTask r15 = new AudioResourceLoadTask();
            Intrinsics.checkNotNullParameter(r15, "task");
            Intrinsics.checkNotNullParameter(r15, "<set-?>");
            r14.a = r15;
            r14.b = new AudioResourceLoadTask.b(r11, r0.b, 12);
            r13.j(r14.a());
        L24:
            ArrayList r16 = new ArrayList();
            Iterator r17 = r2.iterator();
        L26:
            if (r17.hasNext() == false) goto L33;
            Object r18 = r17.next();
            if (((MessageInfo) r18).getMessage().getType() != Message.Type.MEDIA) goto L30;
            boolean r19 = true;
        L31:
            if (r19 == false) goto L26;
            r16.add(r18);
            goto L26
        L30:
            r19 = false;
            goto L31
        L33:
            HashSet r20 = CollectionsKt.toHashSet(r16);
            if (CollectionUtils.isEmpty(r20) == true) goto L37;
            boolean r21 = d.m;
            d r22 = d.b.a;
            e r23 = new e();
            MediaResourceLoadTask r24 = new MediaResourceLoadTask();
            Intrinsics.checkNotNullParameter(r24, "task");
            Intrinsics.checkNotNullParameter(r24, "<set-?>");
            r23.a = r24;
            r23.b = r20;
            r22.j(r23.a());
        L37:
            Iterator r25 = ((HashMap) r0.d).values().iterator();
        L39:
            if (r25.hasNext() == false) goto L64;
            IMessageResourcePreloadTask r26 = (IMessageResourcePreloadTask) r25.next();
            MessageResourceLoadConfig r27 = null;
            if (Intrinsics.areEqual(r26.getTaskType(), ContactMobileApi$From.DOC) == false) goto L49;
            MessageResourceLoadConfig r28 = r0.e;
            if (r28 != null) goto L46;
            Intrinsics.throwUninitializedPropertyAccessException("preloadLimitConfig");
            r28 = null;
        L46:
            if (r28.a == false) goto L39;
        L49:
            if (Intrinsics.areEqual(r26.getTaskType(), "mini_app") == false) goto L57;
            MessageResourceLoadConfig r29 = r0.e;
            if (r29 != null) goto L53;
            Intrinsics.throwUninitializedPropertyAccessException("preloadLimitConfig");
        L55:
            if (r27.b == true) goto L57;
        L53:
            r27 = r29;
        L57:
            ArrayList r30 = new ArrayList();
            Iterator r31 = r2.iterator();
        L59:
            if (r31.hasNext() == false) goto L63;
            Object r32 = r31.next();
            if (r26.d(((MessageInfo) r32).getMessage().getType()) == false) goto L59;
            r30.add(r32);
            goto L59
        L63:
            r26.c(CollectionsKt.toHashSet(r30));
            goto L39
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

    @Override // com.ss.android.lark.chat.chatwindow.chat.model.preload.b
    public final void destroy() {
        f r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        r0.d = null;
        Log.i("MessageResourceLoader_v2-" + this.a, "onDestroy");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.model.preload.b
    public final void a(com.ss.android.lark.chat.core.api.e r4) {
        Intrinsics.checkNotNullParameter(r4, "factory");
        List<IMessageResourcePreloadTask> r5 = r4.b(this.b);
        if (r5 == null) goto L8;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        IMessageResourcePreloadTask r0 = (IMessageResourcePreloadTask) r6.next();
        Map<String, IMessageResourcePreloadTask> r1 = this.d;
        HashMap r2 = (HashMap) r1;
        r2.put(r0.getTaskType(), r0);
    L8:
        this.e = MessageResourceLoadConfig.a();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.model.preload.b
    public final void b(List<? extends MessageInfo> r3) {
        Intrinsics.checkNotNullParameter(r3, "messageInfoList");
        if (DevicePerfUtils.f() == false) goto L5;
        return;
    L5:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(this, r3));
    }

    public a(@IMessageResourcePreloadTask.Scene String r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
        this.c = Collections.newSetFromMap(new ConcurrentHashMap());
        this.d = new HashMap();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.model.preload.b
    public final void c(String r4, List<? extends MessageInfo> r5, String r6, String r7, IGetDataCallback<Map<String, String>> r8) {
        Intrinsics.checkNotNullParameter(r4, "taskType");
        if (r5 == null) goto L5;
        HashSet r0 = new HashSet(r5);
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r4, "audio") == false) goto L10;
        boolean r9 = d.m;
        d.b.a.l(AudioResourceLoadTask.class, new AudioResourceLoadTask.b(r0, this.b, r6, r7), r8);
        return;
    L10:
        IMessageResourcePreloadTask r10 = (IMessageResourcePreloadTask) ((HashMap) this.d).get(r4);
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
