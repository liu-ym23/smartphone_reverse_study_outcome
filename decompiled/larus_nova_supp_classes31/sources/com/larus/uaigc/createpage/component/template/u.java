package com.larus.uaigc.createpage.component.template;

import android.view.View;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.platform.service.z2;
import com.larus.profile.api.bean.UserCreationModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u implements zp9.m {
    public final /* synthetic */ TemplateFeedComponent a;
    public final /* synthetic */ int b;

    @Override // zp9.m
    public final boolean e() {
        return false;
    }

    @Override // zp9.m
    public final boolean g() {
        return false;
    }

    @Override // zp9.m
    public final boolean b(UserCreation r6) {
        Intrinsics.checkNotNullParameter(r6, "userCreation");
        if (TemplateFeedComponent.h3(this.a, r6, this.b, z2.a.R2(), true) == false) goto L5;
        return true;
    L5:
        Intrinsics.checkNotNullParameter(r6, "userCreation");
        return false;
    }

    @Override // zp9.m
    public final void c(TabItemInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "tabItemInfo");
        this.a.r = r3;
        Intrinsics.checkNotNullParameter(r3, "tabItemInfo");
    }

    @Override // zp9.m
    public final void d(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    @Override // zp9.m
    public final void i(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public u(TemplateFeedComponent r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // zp9.m
    public final void f(UserCreationModel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "userCreationModel");
    }

    @Override // zp9.m
    public final void h(UserCreationModel r1, l0 r2, View r3) {
        zp9.m.a.b(r1, r2);
    }

    @Override // zp9.m
    public final boolean a(UserCreation r8, int r9, String r10, String r11, @DoSameQuickMenuType String r12) {
        Intrinsics.checkNotNullParameter(r8, "userCreation");
        TemplateFeedComponent r0 = this.a;
        int r1 = this.b;
        int r13 = TemplateFeedComponent.I;
        return r0.j4(r1, r8, r9, r10, r11, null);
    }
}
