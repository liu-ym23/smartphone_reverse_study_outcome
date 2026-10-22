package com.bytedance.ai.resource;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.model.objects.AIPackage;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements z2.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AIPackage.AIPackageType f2728c;
    public final /* synthetic */ Map d;

    public h(String r5, String r10, AIPackage.AIPackageType r11, Map r12) {
        this.f2726a = r5;
        this.f2727b = r10;
        this.f2728c = r11;
        this.d = r12;
    }

    @Override // z2.g
    public final void b(z2.f r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.f = this.f2726a;
        r10.g = this.f2727b;
        r10.c("resourceType", this.f2728c.name());
        j r5 = j.f2734a;
        int r11 = 1;
        int r12 = !j.n(this.f2726a) ? 1 : 0;
        Intrinsics.checkNotNullParameter("load_type", STGroup.DICT_KEY);
        r10.b("load_type", Integer.valueOf(r12));
        String r13 = this.f2726a;
        com.bytedance.ai.multiprocess.a r14 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r14 != null) goto L5;
    L15:
        r11 = 0;
    L16:
        Intrinsics.checkNotNullParameter("isClient", STGroup.DICT_KEY);
        r10.b("isClient", Integer.valueOf(r11));
        Map r15 = this.d;
        if (r15 == null) goto L20;
        r10.e(r15);
        return;
    L20:
        return;
    L5:
        if (r14.f2402c == false) goto L7;
        boolean r16 = true;
    L13:
        if (r16 != true) goto L15;
    L7:
        if (r13 != null) goto L9;
    L12:
        r16 = false;
        goto L13
    L9:
        if (r13.length() == 0) goto L12;
        r16 = r14.d.contains(r13);
        goto L13
    }
}
