package com.bytedance.android.ec.base.api.ai.conversation;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.WeakHashMap;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ConversationContextStore {
    public static final HashMap<Integer, ArrayDeque<a>> a = null;
    public static final ConversationContextStore b = null;

    public static final class a {
        public final WeakReference<Activity> a;
        public final b b;

        public final Activity getActivity() {
            return this.a.get();
        }

        public a(FragmentActivity r10, b r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            Intrinsics.checkNotNullParameter(r11, "session");
            this.b = r11;
            this.a = new WeakReference(r10);
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public boolean d;

        public b(String r10, String r11, String r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_CID);
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
        }
    }

    public ConversationContextStore() {
    }

    static {
        b = new ConversationContextStore();
        a = new HashMap();
    }

    public static a b(Activity r10) {
        ArrayDeque<a> r0 = a.get(Integer.valueOf(r10.getTaskId()));
        Object r1 = null;
        if (r0 == null) goto L20;
        ListIterator r11 = r0.listIterator(r0.size());
    L6:
        if (r11.hasPrevious() == false) goto L14;
        Object r12 = r11.previous();
        if (((a) r12).getActivity() != r10) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == false) goto L6;
        r1 = r12;
        goto L14
    L10:
        r13 = false;
    L14:
        return (a) r1;
    L20:
        return null;
    }

    @JvmStatic
    public static final synchronized ConversationContext getContext(Activity r10) {
        monitor-enter(ConversationContextStore.class);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L12
        a r11 = b(r10);     // Catch: Throwable -> L12
        if (r11 != null) goto L9;
        monitor-exit(ConversationContextStore.class);
        return null;
    L9:
        b r12 = r11.b;     // Catch: Throwable -> L12
        ConversationContext r1 = new ConversationContext(r12.a, r12.b, r12.c, r12.d);     // Catch: Throwable -> L12
        monitor-exit(ConversationContextStore.class);
        return r1;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized Boolean c(Activity r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L10
        a r11 = b(r10);     // Catch: Throwable -> L10
        if (r11 == null) goto L7;
        Boolean r12 = Boolean.valueOf(r11.b.d);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r12;
    L7:
        r12 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized String d(Activity r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L10
        a r11 = b(r10);     // Catch: Throwable -> L10
        if (r11 == null) goto L7;
        String r12 = r11.b.c;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r12;
    L7:
        r12 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized String e(Activity r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L10
        a r11 = b(r10);     // Catch: Throwable -> L10
        if (r11 == null) goto L7;
        String r12 = r11.b.b;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r12;
    L7:
        r12 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized ConversationContext f(FragmentActivity r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L25
        ArrayDeque<a> r0 = a.get(Integer.valueOf(r10.getTaskId()));     // Catch: Throwable -> L25
        if (r0 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if ((!r0.isEmpty()) == false) goto L13;
        if (((a) r0.last()).getActivity() != null) goto L13;
        r0.removeLast();     // Catch: Throwable -> L25
    L13:
        a r11 = (a) r0.lastOrNull();     // Catch: Throwable -> L25
        if (r11 != null) goto L18;
        monitor-exit(this);
        return null;
    L18:
        if (r11.getActivity() != r10) goto L22;
        b r1 = r11.b;     // Catch: Throwable -> L25
        ConversationContext r12 = new ConversationContext(r1.a, r1.b, r1.c, r1.d);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r12;
    L22:
        a r13 = new a(r10, r11.b);     // Catch: Throwable -> L25
        r0.addLast(r13);     // Catch: Throwable -> L25
        b r14 = r13.b;     // Catch: Throwable -> L25
        ConversationContext r15 = new ConversationContext(r14.a, r14.b, r14.c, r14.d);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r15;
    L25:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(final Activity r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L12
        HashMap<Integer, ArrayDeque<a>> r0 = a;     // Catch: Throwable -> L12
        ArrayDeque<a> r1 = r0.get(Integer.valueOf(r10.getTaskId()));     // Catch: Throwable -> L12
        if (r1 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        CollectionsKt.removeAll(r1, new ConversationContextStore$remove$1(r10));     // Catch: Throwable -> L12
        if (r1.isEmpty() == false) goto L10;
        r0.remove(Integer.valueOf(r10.getTaskId()));     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized ConversationContext h(FragmentActivity r10, AIChatSchemaParams r11) {
        monitor-enter(ConversationContextStore.class);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L54
        WeakHashMap<Activity, Bundle> r1 = xe.a.a;     // Catch: Throwable -> L54
        Bundle r12 = xe.a.a(r10);     // Catch: Throwable -> L54
        String r13 = null;
        if (r12 != null) goto L7;
    L12:
        boolean r14 = true;
    L13:
        if (r11 == null) goto L15;
        String r15 = r11.getConversationId();     // Catch: Throwable -> L54
    L16:
        boolean r16 = false;
        if (r15 != null) goto L19;
    L22:
        boolean r17 = true;
    L23:
        if (r17 == true) goto L27;
        b.a(r10, r15, r11.getOriginMessageId(), r11.getOriginBcmId(), r14);     // Catch: Throwable -> L54
        ConversationContext r18 = new ConversationContext(r15, r11.getOriginMessageId(), r11.getOriginBcmId(), r14);     // Catch: Throwable -> L54
        monitor-exit(ConversationContextStore.class);
        return r18;
    L27:
        if (r12 == null) goto L29;
        String r19 = r12.getString(ConversationConstants.KEY_CONVERSATION_CID);     // Catch: Throwable -> L54
    L30:
        if (r19 != null) goto L32;
    L33:
        r16 = true;
    L34:
        if (r16 == true) goto L38;
        String r110 = r12.getString(ConversationConstants.KEY_CONVERSATION_ORIGIN_MSG_ID);     // Catch: Throwable -> L54
        String r20 = r12.getString(ConversationConstants.KEY_CONVERSATION_ORIGIN_BCM_ID);     // Catch: Throwable -> L54
        b.a(r10, r19, r110, r20, r14);     // Catch: Throwable -> L54
        ConversationContext r111 = new ConversationContext(r19, r110, r20, r14);     // Catch: Throwable -> L54
        monitor-exit(ConversationContextStore.class);
        return r111;
    L38:
        ArrayDeque<a> r21 = a.get(Integer.valueOf(r10.getTaskId()));     // Catch: Throwable -> L54
        if (r21 != null) goto L41;
    L46:
        if (r11 == null) goto L48;
        String r22 = r11.getOriginMessageId();     // Catch: Throwable -> L54
    L49:
        if (r11 == null) goto L51;
        r13 = r11.getOriginBcmId();     // Catch: Throwable -> L54
    L51:
        String r112 = r13;
        b.a(r10, "", r22, r112, r14);     // Catch: Throwable -> L54
        ConversationContext r113 = new ConversationContext("", r22, r112, r14);     // Catch: Throwable -> L54
        monitor-exit(ConversationContextStore.class);
        return r113;
    L48:
        r22 = null;
        goto L49
    L41:
        if ((!r21.isEmpty()) != true) goto L46;
        ConversationContext r23 = b.f(r10);     // Catch: Throwable -> L54
        if (r23 == null) goto L46;
        monitor-exit(ConversationContextStore.class);
        return r23;
    L32:
        if (StringsKt.isBlank(r19) == false) goto L34;
    L29:
        r19 = null;
        goto L30
    L19:
        if (StringsKt.isBlank(r15) == true) goto L22;
        r17 = false;
        goto L23
    L15:
        r15 = null;
        goto L16
    L7:
        if (r12.containsKey(ConversationConstants.KEY_FIRST_MSG) == false) goto L9;
        Bundle r24 = r12;
    L10:
        if (r24 == null) goto L12;
        r14 = r24.getBoolean(ConversationConstants.KEY_FIRST_MSG);     // Catch: Throwable -> L54
        goto L13
    L9:
        r24 = null;
    L54:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(FragmentActivity r10, String r11, String r12, String r13, boolean r14) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_CID);     // Catch: Throwable -> L29
        HashMap<Integer, ArrayDeque<a>> r0 = a;     // Catch: Throwable -> L29
        Integer r1 = Integer.valueOf(r10.getTaskId());     // Catch: Throwable -> L29
        ArrayDeque<a> r15 = r0.get(r1);     // Catch: Throwable -> L29
        if (r15 != null) goto L6;
        r15 = new ArrayDeque();     // Catch: Throwable -> L29
        r0.put(r1, r15);     // Catch: Throwable -> L29
    L6:
        ArrayDeque<a> r16 = r15;     // Catch: Throwable -> L29
        Activity r17 = null;
        if ((!StringsKt.isBlank(r11)) == false) goto L18;
        ListIterator r18 = r16.listIterator(r16.size());     // Catch: Throwable -> L29
    L10:
        if (r18.hasPrevious() == false) goto L14;
        Object r19 = r18.previous();     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(((a) r19).b.a, r11) == false) goto L10;
    L15:
        a r20 = (a) r19;     // Catch: Throwable -> L29
        if (r20 == null) goto L18;
        b r21 = r20.b;     // Catch: Throwable -> L29
    L19:
        a r22 = (a) r16.lastOrNull();     // Catch: Throwable -> L29
        if (r22 == null) goto L22;
        r17 = r22.getActivity();     // Catch: Throwable -> L29
    L22:
        if (r17 != r10) goto L24;
        r16.removeLast();     // Catch: Throwable -> L29
    L24:
        if (r21 != null) goto L26;
        r21 = new b(r11, r12, r13, r14);     // Catch: Throwable -> L29
    L26:
        r16.addLast(new a(r10, r21));     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L14:
        r19 = null;
    L18:
        r21 = null;
    L29:
        th = move-exception;
        throw th;
    }
}
