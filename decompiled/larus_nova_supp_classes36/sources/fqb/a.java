package fqb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.location.dto.POIConfig;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location_ui.picklocation.LocationActivity;
import com.ss.android.lark.location_ui.picklocation.LocationFragment;
import com.ss.android.lark.location_ui.picklocation.LocationResponsiveActivity;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final AtomicInteger a = null;

    static {
        a = new AtomicInteger();
    }

    public static LocationFragment a(POIConfig r5, Token r6, Scene r7, gqb.a r8, boolean r9) {
        LocationFragment r0 = new LocationFragment();
        Bundle r1 = new Bundle();
        String r2 = "location_key_unique" + a.getAndIncrement();
        r1.putBoolean("only_fragment", true);
        r1.putString("location_unique_key", r2);
        r1.putParcelable("location_token", r6);
        r1.putSerializable("scene", r7);
        r1.putBoolean("is_office_sdk", r9);
        hqb.a.a(r2).a = r8;
        r1.putSerializable("location_request_config", r5);
        r0.setArguments(r1);
        return r0;
    }

    public static Intent b(Context r3, POIConfig r4, Token r5, Scene r6, gqb.a r7, boolean r8) {
        Bundle r0 = new Bundle();
        String r1 = "location_key_unique" + a.getAndIncrement();
        r0.putString("location_unique_key", r1);
        hqb.a.a(r1).a = r7;
        r0.putSerializable("location_request_config", r4);
        r0.putParcelable("location_token", r5);
        r0.putSerializable("scene", r6);
        r0.putBoolean("is_office_sdk", r8);
        Intent r9 = new Intent(r3, LocationActivity.class);
        if (ForsetiFGHelpers.d() == false) goto L5;
        r9 = new Intent(r3, LocationResponsiveActivity.class);
    L5:
        r9.putExtras(r0);
        if ((r3 instanceof Activity) == true) goto L8;
        r9.addFlags(268435456);
    L8:
        return r9;
    }

    public static void c(Activity r6, Integer r7, POIConfig r8, Token r9, Scene r10, gqb.a r11, boolean r12, boolean r13) {
        if (r7 != null) goto L4;
        r6.startActivity(b(r6, r8, r9, r10, r11, r13));
        return;
    L4:
        r6.startActivityForResult(b(r6, r8, r9, r10, r11, r13), r7.intValue());
    }
}
