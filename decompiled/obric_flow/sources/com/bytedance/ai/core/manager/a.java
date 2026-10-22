package com.bytedance.ai.core.manager;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.jvm.internal.Intrinsics;
import z2.f;
import z2.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2140c;
    public final /* synthetic */ String d;

    public /* synthetic */ a(String r5, String r10, String r11, int r12) {
        this.f2138a = r12;
        this.f2139b = r5;
        this.f2140c = r10;
        this.d = r11;
    }

    @Override // z2.g
    public final void b(f r5) {
        switch(this.f2138a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "event");
        r5.f = this.f2139b;
        String r10 = this.f2140c;
        if (r10 == null) goto L7;
        r5.c("message_id", r10);
    L7:
        String r11 = this.d;
        if (r11 == null) goto L10;
        r5.c("replyFor", r11);
    L10:
        r5.c("success", "true");
        return;
    L12:
        Intrinsics.checkNotNullParameter(r5, "event");
        r5.f = this.f2139b;
        String r12 = this.f2140c;
        if (r12 == null) goto L15;
        r5.c("message_id", r12);
    L15:
        String r13 = this.d;
        if (r13 == null) goto L18;
        r5.c("replyFor", r13);
    L18:
        r5.c("content", "update applet from debug");
        Intrinsics.checkNotNullParameter("success", STGroup.DICT_KEY);
        r5.b("success", Boolean.TRUE);
    }
}
