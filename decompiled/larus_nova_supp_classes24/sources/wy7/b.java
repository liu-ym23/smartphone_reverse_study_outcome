package wy7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.larksuite.component.card.component.personlist.detail.PersonListActivity;
import com.larksuite.component.card.navigation.UniversalCardLargeScreenAdapt;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import nnc.a0;
import onc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public b() {
    }

    public static void b(Activity r3, List r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "personList");
        boolean r0 = ForsetiConfig.a(r3);
        if (UniversalCardLargeScreenAdapt.b() == false) goto L8;
        if (r0 == false) goto L8;
        Bundle r5 = a(r3, r4, null);
        g r6 = f.a(r3);
        if (r6 == null) goto L10;
        a0 r1 = a0.a;
        Intrinsics.checkNotNullParameter(r5, "args");
        r6.d(new k(r5));
        return;
    L10:
        return;
    L8:
        Bundle r7 = a(r3, r4, null);
        Intent r2 = new Intent(r3, PersonListActivity.class);
        r2.putExtras(r7);
        r3.startActivity(r2);
    }

    public static Bundle a(Activity r3, List r4, String r5) {
        Bundle r0 = new Bundle();
        ArrayList<? extends Parcelable> r1 = new ArrayList();
        r1.addAll(r4);
        r0.putParcelableArrayList("person_list", r1);
        boolean r6 = false;
        if (r5 != null) goto L5;
    L10:
        if (r6 == false) goto L12;
        r5 = UIUtils.getString(r3, 2131890882);
    L12:
        r0.putString("title", r5);
        return r0;
    L5:
        if (r5.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 != true) goto L10;
        r6 = true;
        goto L10
    L7:
        r2 = false;
        goto L8
    }
}
