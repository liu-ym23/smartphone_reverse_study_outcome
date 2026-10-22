package com.bytedance.ai.resource;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements z2.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f2731c;
    public final /* synthetic */ AIPackage.AIPackageType d;
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;
    public final /* synthetic */ long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f2732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Map f2733i;

    public i(String r5, String r10, long r11, AIPackage.AIPackageType r12, int r13, String r14, long r15, String r16, Map r17) {
        this.f2729a = r5;
        this.f2730b = r10;
        this.f2731c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f2732h = r16;
        this.f2733i = r17;
    }

    @Override // z2.g
    public final void b(z2.f r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.f = this.f2729a;
        r10.g = this.f2730b;
        long r5 = this.f2731c;
        Intrinsics.checkNotNullParameter("versionCode", STGroup.DICT_KEY);
        r10.b("versionCode", Long.valueOf(r5));
        r10.c("resourceType", this.d.name());
        j r11 = j.f2734a;
        int r12 = 1;
        int r13 = !j.n(this.f2729a) ? 1 : 0;
        Intrinsics.checkNotNullParameter("load_type", STGroup.DICT_KEY);
        r10.b("load_type", Integer.valueOf(r13));
        int r14 = this.e;
        Intrinsics.checkNotNullParameter(WsConstants.ERROR_CODE, STGroup.DICT_KEY);
        r10.b(WsConstants.ERROR_CODE, Integer.valueOf(r14));
        String r15 = this.f;
        String r16 = "";
        if (r15 != null) goto L5;
        r15 = "";
    L5:
        r10.c("error_msg", r15);
        long r17 = this.g;
        Intrinsics.checkNotNullParameter("cost", STGroup.DICT_KEY);
        r10.b("cost", Long.valueOf(r17));
        String r18 = this.f2732h;
        if (r18 != null) goto L8;
    L11:
        r10.c("res_from", r16);
        String r19 = this.f2729a;
        com.bytedance.ai.multiprocess.a r20 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r20 != null) goto L14;
    L24:
        r12 = 0;
    L25:
        Intrinsics.checkNotNullParameter("isClient", STGroup.DICT_KEY);
        r10.b("isClient", Integer.valueOf(r12));
        Map r21 = this.f2733i;
        if (r21 == null) goto L29;
        r10.e(r21);
        return;
    L29:
        return;
    L14:
        if (r20.f2402c == false) goto L16;
        boolean r22 = true;
    L22:
        if (r22 != true) goto L24;
    L16:
        if (r19 != null) goto L18;
    L21:
        r22 = false;
        goto L22
    L18:
        if (r19.length() == 0) goto L21;
        r22 = r20.d.contains(r19);
        goto L22
    L8:
        if (Intrinsics.areEqual(r18, "cdnCache") == false) goto L10;
        r16 = "cdn_cache";
        goto L11
    L10:
        r16 = r18;
        goto L11
    }
}
