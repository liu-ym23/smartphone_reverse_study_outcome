package com.bytedance.ai.resource;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 implements z2.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2709c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public d0(String r5, String r10, long r11, String r12, int r13) {
        this.f2707a = r11;
        this.f2708b = r5;
        this.f2709c = r13;
        this.d = r10;
        this.e = r12;
    }

    @Override // z2.g
    public final void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter("cost", STGroup.DICT_KEY);
        r5.b("cost", Long.valueOf(this.f2707a));
        r5.c("url", this.f2708b);
        Intrinsics.checkNotNullParameter(WsConstants.ERROR_CODE, STGroup.DICT_KEY);
        r5.b(WsConstants.ERROR_CODE, Integer.valueOf(this.f2709c));
        String r10 = this.d;
        if (r10 == null) goto L5;
        r5.c("error_msg", r10);
    L5:
        String r11 = this.e;
        if (r11 == null) goto L9;
        r5.c("res_from", r11);
        return;
    }
}
