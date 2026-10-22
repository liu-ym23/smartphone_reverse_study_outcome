package com.bytedance.android.livesdk.gift.effect.model;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.a1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.j3;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.model.w;
import com.bytedance.android.livesdk.message.model.zb;
import com.bytedance.bdlocation.BuildConfig;
import iy1.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import v12.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class EffectMessage implements c {
    public List<String> A;
    public final Map<Integer, Long> B;
    public h1 C;
    public int D;
    public j3 E;
    public w F;
    public int G;
    public boolean H;
    public int I;
    public int J;
    public boolean K;
    public int L;
    public List<Long> M;
    public String N;
    public boolean O;
    public List<n3> P;
    public int Q;
    public long a;
    public long b;
    public int c;
    public String d;
    public Map<Long, a> e;
    public int f;
    public boolean g;
    public IBaseUser h;
    public IBaseUser i;
    public String j;
    public zb k;
    public long l;
    public long m;
    public String n;
    public boolean o;
    public o0 p;
    public com.bytedance.android.livesdk.gift.model.a q;
    public String r;
    public String s;
    public a1 t;
    public int u;
    public int v;
    public boolean w;
    public long x;
    public String y;
    public m0 z;

    public static class PlayableAsset {
        private String lynxSchema;
        private String passThroughData;
        private int resourceType;

        public PlayableAsset() {
        }

        public String getLynxSchema() {
            return this.lynxSchema;
        }

        public String getPassThroughData() {
            return this.passThroughData;
        }

        public int getResourceType() {
            return this.resourceType;
        }

        public void setLynxSchema(String r1) {
            this.lynxSchema = r1;
        }

        public void setPassThroughData(String r1) {
            this.passThroughData = r1;
        }

        public void setResourceType(int r1) {
            this.resourceType = r1;
        }
    }

    public EffectMessage() {
        this.e = new LinkedHashMap();
        this.n = BuildConfig.FLAVOR;
        this.o = false;
        this.A = new ArrayList();
        this.B = new HashMap();
        this.C = null;
        this.D = 0;
        this.H = false;
        this.I = -1;
        this.J = 0;
        this.K = false;
        this.L = 0;
        this.M = new ArrayList();
        this.N = BuildConfig.FLAVOR;
        this.O = false;
        this.P = null;
    }

    @Override // v12.c
    public final String b() {
        return this.d;
    }

    @Override // v12.c
    public final boolean c() {
        return this.o;
    }

    @Override // v12.c
    public final String getDescription() {
        return this.j;
    }

    @Override // v12.c
    public final long getEffectId() {
        return this.b;
    }

    @Override // v12.c
    public final IBaseUser getFromUser() {
        return this.i;
    }

    @Override // v12.c
    public final long getGiftId() {
        return this.l;
    }

    @Override // v12.c
    public final String getInteractGiftInfo() {
        return this.r;
    }

    @Override // v12.c
    public final String getLogId() {
        return this.n;
    }

    @Override // v12.c
    public final long getMsgId() {
        return this.a;
    }

    @Override // v12.c
    public final int getPriority() {
        return this.c;
    }

    @Override // v12.c
    public final long getRepeatCount() {
        return this.m;
    }

    @Override // v12.c
    public final IBaseUser getToUser() {
        return this.h;
    }

    @Override // v12.c
    public final String getTraceId() {
        return this.y;
    }

    @Override // v12.c
    public final boolean isLocal() {
        return this.w;
    }

    public final void a(int r2, long r3) {
        Map<Integer, Long> r0 = this.B;
        HashMap r1 = (HashMap) r0;
        r1.put(Integer.valueOf(r2), Long.valueOf(r3));
    }
}
