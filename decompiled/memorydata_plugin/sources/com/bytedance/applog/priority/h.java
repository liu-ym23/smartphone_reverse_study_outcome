package com.bytedance.applog.priority;

import android.content.Context;
import android.util.Pair;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class h implements PriorityEventMetaFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.b f1791a;

    public h(com.bytedance.applog.b r1) {
        this.f1791a = r1;
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public String abSdkVersion() {
        i r0 = user();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.b() > 0) goto L8;
        return null;
    L8:
        return this.f1791a.e(String.valueOf(r0.b()));
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public long eventId() {
        return com.bytedance.applog.monitor.v3.f.a();
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public long eventIndex() {
        return this.f1791a.aB();
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public int nt() {
        return NetworkUtils.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1791a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getValue();
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public int sentryStainedValue(String r1) {
        return com.bytedance.applog.monitor.b.b(this.f1791a.ab(), r1);
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public i user() {
        long r1 = this.f1791a.bd();
        IBDAccountCallback r3 = this.f1791a.G();
        com.bytedance.applog.e.f r4 = this.f1791a.be();
        if (r3 == null) goto L12;
        Pair<Integer, Long> r5 = r3.getOdinUserInfo();
        if (((Long) ZeusTransformUtils.preCheckCast(r5.second, Long.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L8;
        long r2 = ((Long) ZeusTransformUtils.preCheckCast(r5.second, Long.class, "com.obric.memorydata.plugin")).longValue();
        int r8 = ((Integer) ZeusTransformUtils.preCheckCast(r5.first, Integer.class, "com.obric.memorydata.plugin")).intValue();
        long r11 = r2;
        long r16 = r11;
        int r13 = 1;
        int r14 = 1;
    L7:
        int r15 = r8;
    L14:
        return new i(this.f1791a.p(), r11, r13, r14, r15, r16);
    L8:
        if (r4 == null) goto L12;
        if (r4.j() == false) goto L12;
        long r6 = r4.f1586a;
        r8 = r4.f1587b;
        int r7 = r4.c;
        r11 = r1;
        r14 = r4.d;
        r13 = r7;
        r16 = r6;
    L12:
        r11 = r1;
        r16 = 0;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        goto L14
    }
}
