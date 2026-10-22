package com.bytedance.android.livesdk.chatroom.viewmodel;

import io.reactivex.subjects.BehaviorSubject;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface e {
    public static final a a = null;

    public static final class a {
        public static final Set<Integer> a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = SetsKt.setOf(new Integer[]{12, 8, 16});
        }
    }

    static {
        a = a.b;
    }

    BehaviorSubject a();

    j b();

    void c(j r1);

    BehaviorSubject d();

    void e(j r1);

    void f(k r1);

    void g(k r1);

    int getWindowCount();

    j h();

    BehaviorSubject i();

    BehaviorSubject j();

    boolean k();

    void reset();

    j t();
}
