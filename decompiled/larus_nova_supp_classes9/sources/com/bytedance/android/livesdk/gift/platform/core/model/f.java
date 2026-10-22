package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.j3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftKmpInRoomService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.kmp.livesdk.gift.platform.GiftContext;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class f implements v12.d, v12.c {
    public long a;
    public long b;
    public long c;
    public int d;
    public IBaseUser e;
    public IBaseUser f;
    public h1 g;
    public long h;
    public String i;
    public j3 j;
    public long k;
    public List<String> l;
    public long m;
    public String n;
    public long o;
    public long p;
    public long q;
    public final String r;
    public String s;
    public final long t;
    public String u;
    public long v;
    public int w;
    public final Map<Integer, Long> x;

    public static final class a {
    }

    static {
    }

    @Override // v12.d
    public final String a() {
        return null;
    }

    @Override // v12.c
    public final boolean c() {
        return false;
    }

    @Override // v12.d
    public final boolean d() {
        return false;
    }

    @Override // v12.d
    public final String f() {
        return null;
    }

    @Override // v12.c
    public final String getInteractGiftInfo() {
        return null;
    }

    @Override // v12.d
    public final boolean isLocal() {
        return false;
    }

    public final long g() {
        h1 r0 = this.g;
        if (r0 == null) goto L5;
        int r1 = r0.getDiamondCount();
    L7:
        return r1;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // v12.d
    public final String getGiftInfo() {
        return "giftEnd: false ; comboCount: " + this.o + " ; groupId: " + this.q + " ; groupCount: " + this.p;
    }

    public final String h() {
        long r2 = 0;
        if (this.a != r2) goto L17;
        i12.e r0 = i12.o.b();
        GiftContext r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r3 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(GiftKmpInRoomService.class));
    L8:
        GiftKmpInRoomService r4 = (GiftKmpInRoomService) r3;
        if (r4 == null) goto L11;
        r1 = r4.bl();
    L11:
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.m r5 = r1.getBigGiftKeyCount();
        if (r5 == null) goto L15;
        r2 = ((Number) r5.getValue()).longValue() + 1;
        r5.setValue(Long.valueOf(r2));
    L15:
        this.a = r2;
        goto L17
    L7:
        r3 = null;
    L17:
        return String.valueOf(this.a);
    }

    public f() {
        long r0 = 0;
        this.a = r0;
        this.c = r0;
        this.h = r0;
        this.k = r0;
        this.l = new ArrayList();
        this.m = r0;
        this.n = BuildConfig.FLAVOR;
        this.o = r0;
        this.p = r0;
        this.q = r0;
        this.r = BuildConfig.FLAVOR;
        this.t = this.h;
        this.v = 1;
        this.x = new LinkedHashMap();
    }

    @Override // v12.c
    public final String b() {
        return this.i;
    }

    @Override // v12.d
    public final long e() {
        return this.o;
    }

    @Override // v12.d
    public final long getAssetId() {
        return this.t;
    }

    @Override // v12.d
    public final String getDescription() {
        return this.s;
    }

    @Override // v12.c
    public final long getEffectId() {
        return this.h;
    }

    @Override // v12.c
    public final IBaseUser getFromUser() {
        return this.e;
    }

    @Override // v12.d
    public final String getFromUserId() {
        return this.r;
    }

    @Override // v12.d
    public final long getGiftId() {
        return this.c;
    }

    @Override // v12.d
    public final long getGroupCount() {
        return this.p;
    }

    @Override // v12.d
    public final long getGroupId() {
        return this.q;
    }

    @Override // v12.d
    public final String getLogId() {
        return this.n;
    }

    @Override // v12.d
    public final long getMsgId() {
        return this.b;
    }

    @Override // v12.c
    public final int getPriority() {
        return this.w;
    }

    @Override // v12.c
    public final long getRepeatCount() {
        return this.v;
    }

    @Override // v12.d
    public final IBaseUser getToUser() {
        return this.f;
    }

    @Override // v12.d
    public final String getTraceId() {
        return this.u;
    }
}
