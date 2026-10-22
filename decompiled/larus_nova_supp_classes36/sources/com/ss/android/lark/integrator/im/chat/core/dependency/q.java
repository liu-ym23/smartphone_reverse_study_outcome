package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.util.ArrayList;
import java.util.List;
import w4b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q implements b0 {
    public q() {
    }

    public final ArrayList<BaseField> parseFields(List<GetUserProfileResponse.Field> r1) {
        return nmb.a.a().getCoreDependency().n();
    }

    public final void c(Context r1, Bundle r2) {
        nmb.a.a().getCoreDependency().l();
    }

    public final void e(Context r2, ProfileSource r3) {
        nmb.a.a().getCoreDependency().e(r2, r3);
    }

    public final void a(Context r1, String r2, String r3) {
        nmb.a.a().getCoreDependency().h();
    }

    public final void b(Context r3, y6b.b r4, Chat r5) {
        if (r4.x == false) goto L6;
        Log.i("ProfileDependency", "chatter is anonymous");
        return;
    L6:
        ProfileSource.a r0 = new ProfileSource.a();
        r0.e = r4.a;
        r0.g = r4.j;
        r0.d = r5.getId();
        r0.b = 0;
        r0.c = r5.getName();
        e(r3, r0.a());
    }
}
