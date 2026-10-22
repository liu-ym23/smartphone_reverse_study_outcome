package com.ss.android.lark.locationmessage.message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.biz.im.api.LocationInfo;
import com.ss.android.lark.chat.entity.message.content.LocationContent;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.locationmessage.ui.navigation.NavigateActivity;
import com.ss.android.lark.locationmessage.ui.navigation.NavigateResponsiveActivity;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ v5b.c a;
    public final /* synthetic */ LocationContent b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Context e;
    public final /* synthetic */ LocationMessageCell f;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (TextUtils.equals(this.a.getId(), this.a.getcId()) == false) goto L5;
        return;
    L5:
        String r8 = this.b.getLatitude();
        String r0 = this.b.getLongitude();
        int r1 = this.b.getZoomLevel();
        LocationInfo.b r2 = new LocationInfo.b(r8, r0);
        r2.a = ((LocationContentVO) this.a.b()).b;
        r2.b = this.c;
        r2.c = this.d;
        r2.f = r1;
        r2.g = this.f.a.isSecretChat();
        r2.h = this.b.isInternal();
        r2.i = true;
        Serializable r9 = new LocationInfo(r2, null);
        nqb.a r3 = (nqb.a) this.f.a.j5().b(nqb.a.class);
        if (r3 == null) goto L8;
        r5b.a r10 = this.f.a;
        int r11 = LocationMessageCell.h;
        r3.s();
        return;
    L8:
        Context r4 = this.e;
        Token r5 = LocationMessageCell.j;
        Scene.IM r6 = Scene.IM.INSTANCE;
        Bundle r12 = new Bundle();
        r12.putSerializable("extra_location", r9);
        r12.putString("extra_favorite_id", null);
        r12.putParcelable("location_token", r5);
        r12.putString("origin_merge_forward_id", null);
        r12.putSerializable("scene", r6);
        Intent r13 = new Intent(r4, NavigateActivity.class);
        if (ForsetiFGHelpers.d() == false) goto L11;
        r13 = new Intent(r4, NavigateResponsiveActivity.class);
    L11:
        r13.putExtras(r12);
        Activity r14 = oqb.a.a(r4);
        if (r14 == null) goto L14;
        r14.startActivityForResult(r13, -1);
        return;
    L14:
        r13.addFlags(268435456);
        r4.startActivity(r13);
    }

    public d(LocationMessageCell r1, v5b.c r2, LocationContent r3, String r4, String r5, FragmentActivity r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
