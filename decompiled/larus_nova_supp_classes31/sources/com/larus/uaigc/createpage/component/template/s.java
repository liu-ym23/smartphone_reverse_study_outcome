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
public final class s implements zp9.m {
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

    public s(TemplateFeedComponent r1, int r2) {
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
    public final boolean a(UserCreation r7, int r8, String r9, String r10, @DoSameQuickMenuType String r11) {
        Intrinsics.checkNotNullParameter(r7, "userCreation");
        if (r7.b() == false) goto L6;
        return false;
    L6:
        TemplateFeedComponent r0 = this.a;
        int r12 = TemplateFeedComponent.I;
        r0.Q3(r7, r8, r9, r10, null);
        return true;
    }
}
