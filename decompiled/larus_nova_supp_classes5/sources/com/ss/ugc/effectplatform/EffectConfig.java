package com.ss.ugc.effectplatform;

import a0.b;
import blc.c;
import bytekn.foundation.concurrent.executor.AsyncExecutor;
import bytekn.foundation.io.file.FileManager;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.model.algorithm.FetchModelType;
import com.ss.ugc.effectplatform.repository.d;
import com.ss.ugc.effectplatform.task.q1;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class EffectConfig {
    public static final /* synthetic */ int d0 = 0;
    public final b<com.ss.ugc.effectplatform.cache.j> A;
    public final String B;
    public final String C;
    public q1 D;
    public final String E;
    public List<String> F;
    public final Object G;
    public final FetchModelType H;
    public final String I;
    public final ModelFileEnv J;
    public final String K;
    public final long L;
    public final d M;
    public final hlc.a N;
    public final Integer O;
    public final boolean P;
    public final String Q;
    public final boolean R;
    public final String[] S;
    public final boolean T;
    public final boolean U;
    public final boolean V;
    public final int W;
    public final boolean X;
    public final boolean Y;
    public final boolean Z;
    public final String a;
    public final boolean a0;
    public final String b;
    public final boolean b0;
    public final String c;
    public final boolean c0;
    public String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final HashMap<String, String> o;
    public final boolean p;
    public final int q;
    public final int r;
    public final int s;
    public final dlc.a t;
    public final b<INetworkClient> u;
    public final b<klc.a> v;
    public final b<clc.a> w;
    public final bytekn.foundation.concurrent.executor.a x;
    public final int y;
    public final b<blc.a> z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/ugc/effectplatform/EffectConfig$Builder;", "", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
    public static class Builder {
        public List<String> A;
        public Object B;
        public FetchModelType C;
        public String D;
        public ModelFileEnv E;
        public Integer F;
        public long G;
        public boolean H;
        public String I;
        public int J;
        public boolean K;
        public String[] L;
        public boolean M;
        public boolean N;
        public boolean O;
        public boolean P;
        public boolean Q;
        public boolean R;
        public boolean S;
        public boolean T;
        public int U;
        public boolean V;
        public boolean W;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public INetworkClient g;
        public dlc.a h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public int o;
        public int p;
        public String q;
        public bytekn.foundation.concurrent.executor.a r;
        public blc.a s;
        public klc.a t;
        public String u;
        public String v;
        public final HashMap<String, String> w;
        public int x;
        public String y;
        public boolean z;

        public Builder() {
            this.o = 1;
            this.p = 3;
            this.w = new HashMap();
            this.z = true;
            this.C = FetchModelType.ORIGIN;
            this.G = 838860800;
            this.I = "";
            this.J = 5;
            this.L = new String[0];
            this.R = true;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/ugc/effectplatform/EffectConfig$ModelFileEnv;", "", "TEST", "ONLINE", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
    public static final enum ModelFileEnv extends Enum<ModelFileEnv> {
        public static final ModelFileEnv ONLINE = null;
        public static final ModelFileEnv TEST = null;
        public static final /* synthetic */ ModelFileEnv[] a = null;

        static {
            ModelFileEnv r1 = new ModelFileEnv("TEST", 0);
            TEST = r1;
            ModelFileEnv r2 = new ModelFileEnv("ONLINE", 1);
            ONLINE = r2;
            a = new ModelFileEnv[]{r1, r2};
        }

        public static ModelFileEnv valueOf(String r1) {
            return (ModelFileEnv) r27.a.a(ModelFileEnv.class, r1);
        }

        public static ModelFileEnv[] values() {
            return (ModelFileEnv[]) a.clone();
        }

        public ModelFileEnv(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public EffectConfig(Builder r12) {
        this.a = r12.a;
        this.b = r12.b;
        this.c = r12.c;
        this.d = r12.d;
        String r0 = r12.i;
        if (r0 != null) goto L6;
        r0 = "online";
    L6:
        this.e = r0;
        String r1 = r12.j;
        if (r1 != null) goto L9;
        r1 = "android";
    L9:
        this.f = r1;
        this.g = r12.k;
        this.h = r12.l;
        String r2 = r12.m;
        if (r2 == null) goto L12;
        String r3 = r2;
    L13:
        this.i = r3;
        if (r2 != null) goto L17;
        r2 = "";
    L17:
        this.j = r2;
        String r4 = r12.n;
        if (r4 != null) goto L21;
        r4 = "";
    L21:
        this.k = r4;
        this.l = r12.e;
        String r5 = r12.f;
        if (r5 != null) goto L24;
        r5 = "0";
    L24:
        this.m = r5;
        this.n = r12.q;
        this.o = r12.w;
        this.p = r12.z;
        this.q = r12.o;
        this.r = r12.p;
        this.s = r12.x;
        dlc.a r6 = r12.h;
        if (r6 != null) goto L28;
        r6 = null;
    L28:
        this.t = r6;
        b<INetworkClient> r7 = new b(null);
        this.u = r7;
        b<klc.a> r8 = new b(null);
        this.v = r8;
        this.w = new b(null);
        AsyncExecutor r9 = r12.r;
        if (r9 != null) goto L32;
        r9 = new AsyncExecutor();
    L32:
        this.x = r9;
        int r10 = r12.J;
        this.y = r10;
        b<blc.a> r11 = new b(null);
        this.z = r11;
        b<com.ss.ugc.effectplatform.cache.j> r13 = new b(null);
        this.A = r13;
        this.B = r12.v;
        this.C = r12.u;
        q1.a r14 = new q1.a();
        r14.b = r10;
        r14.a = r9;
        this.D = r14.a();
        this.E = r12.y;
        this.F = r12.A;
        this.G = r12.B;
        this.H = r12.C;
        this.I = r12.D;
        this.J = r12.E;
        String r15 = r12.n;
        if (r15 != null) goto L36;
        r15 = r3 + FileManager.a + "algorithm";
    L36:
        this.K = r15;
        this.L = r12.G;
        this.M = d.c;
        this.N = new hlc.a();
        this.O = r12.F;
        this.P = r12.H;
        String r16 = r12.b;
        boolean r17 = false;
        if (r12.I.length() != 0) goto L39;
        boolean r18 = true;
    L40:
        if (r18 == false) goto L49;
        if (r16 != null) goto L43;
    L46:
        boolean r19 = true;
    L47:
        if (r19 == true) goto L49;
    L50:
        this.Q = r16;
        this.R = r12.K;
        this.S = r12.L;
        this.T = r12.M;
        this.U = r12.N;
        this.V = r12.O;
        this.W = r12.U;
        this.X = r12.Q;
        this.Y = r12.R;
        this.Z = r12.S;
        this.a0 = r12.T;
        this.b0 = r12.V;
        this.c0 = r12.W;
        Object r20 = r12.B;
        if (r20 != null) goto L53;
    L78:
        String r21 = r12.m;
        if (r21 != null) goto L82;
        r21 = r12.n;
    L82:
        com.ss.ugc.effectplatform.util.i r22 = com.ss.ugc.effectplatform.util.i.a;
        String r23 = com.ss.ugc.effectplatform.util.i.g(r21);
        if (r23 != null) goto L85;
    L90:
        String r24 = com.ss.ugc.effectplatform.util.i.g(r21);
        if (r24 != null) goto L93;
    L98:
        Object r25 = r12.s;
        if (r25 != null) goto L102;
        r25 = new c(this);
    L102:
        r11.a = r25;
        r8.a = r12.t;
        r13.a = null;
        boolean r26 = com.ss.ugc.effectplatform.util.k.a;
        boolean r27 = r12.O;
        if (com.ss.ugc.effectplatform.util.k.a == true) goto L107;
        if (r27 == true) goto L107;
        boolean r28 = false;
    L108:
        com.ss.ugc.effectplatform.util.k.a = r28;
        com.ss.ugc.effectplatform.task.algorithm.b r29 = com.ss.ugc.effectplatform.task.algorithm.a.a;
        boolean r110 = r12.P;
        if (com.ss.ugc.effectplatform.task.algorithm.a.c == true) goto L111;
        if (r110 == true) goto L111;
    L112:
        com.ss.ugc.effectplatform.task.algorithm.a.c = r17;
        return;
    L111:
        r17 = true;
    L107:
        r28 = true;
        goto L108
    L93:
        if (r24.length() <= 0) goto L95;
        boolean r30 = true;
    L96:
        if (r30 != true) goto L98;
        this.k = com.ss.ugc.effectplatform.util.i.g(r21) + FileManager.a + "effectmodel";
        goto L98
    L95:
        r30 = false;
        goto L96
    L85:
        if (r23.length() <= 0) goto L87;
        boolean r31 = true;
    L88:
        if (r31 != true) goto L90;
        this.j = com.ss.ugc.effectplatform.util.i.g(r21) + FileManager.a + "effectpreload";
        goto L90
    L87:
        r31 = false;
        goto L88
    L53:
        if (r12.g == null) goto L78;
        llc.b.a r32 = llc.b.g;
        if (r20 != null) goto L57;
        Intrinsics.throwNpe();
    L57:
        r32.getClass();
        if (llc.b.f != null) goto L70;
        Object r33 = llc.b.e;
        monitor-enter(r33);
    L67:
        th = move-exception;
        throw th;
    L62:
        if (llc.b.f != null) goto L64;
        llc.b.f = new llc.b(r20);     // Catch: Throwable -> L67
    L64:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L67
        monitor-exit(r33);
    L70:
        llc.b r34 = llc.b.f;
        if (r34 != null) goto L74;
        r34 = new llc.b(r20);
    L74:
        INetworkClient r35 = r12.g;
        if (r35 != null) goto L77;
        Intrinsics.throwNpe();
    L77:
        r7.a = new llc.d(r34, r35);
        goto L78
    L43:
        if (r16.length() == 0) goto L46;
        r19 = false;
    L49:
        r16 = r12.I;
        goto L50
    L39:
        r18 = false;
        goto L40
    L12:
        r3 = "";
        goto L13
    }
}
