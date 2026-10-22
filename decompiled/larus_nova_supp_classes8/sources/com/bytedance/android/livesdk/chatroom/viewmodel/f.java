package com.bytedance.android.livesdk.chatroom.viewmodel;

import io.reactivex.subjects.BehaviorSubject;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface f {
    public static final a a = null;

    public static final class a {
        public static final Set<Integer> a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = SetsKt.setOf(new Integer[]{5, 9, 10, 16});
        }
    }

    static {
        a = a.b;
    }

    BehaviorSubject a();

    BehaviorSubject b();

    void c(i r1);

    void d(i r1);

    void e();

    boolean f(int r1, int r2);

    i g();

    void reset();

    i t();
}
