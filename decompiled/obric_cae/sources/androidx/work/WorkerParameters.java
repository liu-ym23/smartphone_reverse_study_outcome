package androidx.work;

import android.net.Network;
import android.net.Uri;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import s1.a0;
import s1.c0;

/* JADX INFO: loaded from: classes.dex */
public final class WorkerParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f2778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f2779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f2780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f2781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Executor f2783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u1.a f2784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y f2785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s f2786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f2787j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f2788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Uri> f2789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Network f2790c;

        public a() {
            this.f2788a = Collections.emptyList();
            this.f2789b = Collections.emptyList();
        }
    }

    public WorkerParameters(UUID r8, e r10, List r11, a r12, int r13, ExecutorService r14, u1.a r15, x r16, c0 r17, a0 r18) {
        this.f2778a = r8;
        this.f2779b = r10;
        this.f2780c = new HashSet(r11);
        this.f2781d = r12;
        this.f2782e = r13;
        this.f2783f = r14;
        this.f2784g = r15;
        this.f2785h = r16;
        this.f2786i = r17;
        this.f2787j = r18;
    }
}
