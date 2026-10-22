package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.entity.message.AIRecommendQuestions;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class n0 implements z, com.ss.android.lark.passportc.api.r {
    public final com.ss.android.lark.passportc.api.m a;
    public final ConcurrentHashMap<Long, a> b;

    public static final class a {
        public AIRecommendQuestions a;
        public final ArrayList<a0> b;

        public a(AIRecommendQuestions r2, ArrayList<a0> r3) {
            Intrinsics.checkNotNullParameter(r3, "pushListener");
            this.a = r2;
            this.b = r3;
        }
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final com.ss.android.lark.passportc.api.m getPassport() {
        return this.a;
    }

    @Inject
    public n0(com.ss.android.lark.passportc.api.m r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        this.a = r2;
        this.b = new ConcurrentHashMap();
        r2.d(this);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.z
    public final AIRecommendQuestions kf(long r2) {
        a r3 = this.b.get(Long.valueOf(r2));
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.a;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.z
    public void update(long r3, AIRecommendQuestions r5) {
        Intrinsics.checkNotNullParameter(r5, "aIRecommendQuestions");
        ConcurrentHashMap<Long, a> r0 = this.b;
        Long r4 = Long.valueOf(r3);
        a r6 = r0.get(r4);
        if (r6 != null) goto L8;
        r6 = new a(r5, new ArrayList());
        a r7 = r0.putIfAbsent(r4, r6);
        if (r7 == null) goto L8;
        r6 = r7;
    L8:
        a r8 = r6;
        r8.a = r5;
        Iterator<T> r9 = r8.b.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        ((a0) r9.next()).a();
        goto L10
    }
}
