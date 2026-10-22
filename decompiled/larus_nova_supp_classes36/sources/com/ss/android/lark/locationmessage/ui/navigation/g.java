package com.ss.android.lark.locationmessage.ui.navigation;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.BaseModel;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location.listener.LocationRequestOption;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends BaseModel implements b {
    public static final cqb.a b = null;
    public cqb.a a;

    static {
        b = new cqb.a(39.908823d, 116.39747d);
    }

    public g() {
        this.a = b;
    }

    @Override // com.ss.android.lark.locationmessage.ui.navigation.b
    public final boolean isAdminGpsEnabled() {
        return com.ss.android.lark.location.service.f.a().isAdminGpsEnabled();
    }

    public final void create() {
        super.create();
    }

    public final void destroy() {
        super.destroy();
    }

    @Override // com.ss.android.lark.locationmessage.ui.navigation.b
    public final void S(Context r7, Token r8, Scene r9, u r10) {
        f r5 = new f(this, r10);
        LocationRequestOption r2 = new LocationRequestOption();
        com.ss.android.lark.location.service.f.a().getLocationWithOption(r7, r2, r8, r9, r5);
    }
}
