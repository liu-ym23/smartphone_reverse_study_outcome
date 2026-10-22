package com.ss.android.lark.contact.customized.mobileinvite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.contact.base.utils.InvRouterParam$From;
import com.ss.android.lark.inv.export.util.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.h;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements h.e {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public a(FragmentActivity r1, String r2) {
        this.a = r1;
        this.b = BuildConfig.FLAVOR;
        this.c = BuildConfig.FLAVOR;
        this.d = r2;
    }

    public final void a(boolean r8) {
        if (r8 == false) goto L17;
        int r0 = OfficeInviteExternalContactActivity.b;
        Activity r1 = this.a;
        String r2 = this.b;
        String r3 = this.c;
        String r4 = this.d;
        HashMap r5 = c.a(new Pair[]{Pair.create("invite_msg", r2), Pair.create("unique_id", r3), Pair.create("from_scenes", r4)});
        Log.i("Contact_InviteExternal", "start InviteExternalContactV2Activity params: " + r5);
        Intent r6 = new Intent(r1, OfficeInviteExternalContactActivity.class);
        Bundle r7 = new Bundle();
        Iterator r9 = r5.entrySet().iterator();
    L5:
        if (r9.hasNext() == false) goto L7;
        Map.Entry r10 = (Map.Entry) r9.next();
        r7.putString((String) r10.getKey(), (String) r10.getValue());
        goto L5
    L7:
        r6.putExtras(r7);
        if (Intrinsics.areEqual(InvRouterParam$From.ONBOARDING, r4) == false) goto L10;
        r1.startActivityForResult(r6, ScreenUtils.MAX_SYSTEM_BRIGHTNESS);
        goto L17
    L10:
        r1.startActivity(r6);
    L17:
        Statistics.sendEvent("invite_people_external_import", InvHitPoint.b(this.d).put("access", r8));     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        Log.e("InvHitPoint", e.getMessage());
    }
}
