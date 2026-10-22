package com.larksuite.component.blockit.hashtag.list;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.blockit.entity.BlockTypeID;
import com.larksuite.component.blockit.entity.TagPermissionType;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements HashTagSwipeAdapter.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ SpannableString c;

    @Override // com.larksuite.component.blockit.hashtag.list.HashTagSwipeAdapter.a
    public final void a(oy7.e r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r4.f == false) goto L5;
        JSONObject r0 = new JSONObject(this.a.c);
        r0.put("tag_id", r4.a);
        r0.put("from", "panel");
        qy7.a.a("pano_panel_and_view_jump", r0);
        this.a.a.getContext();
        ((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).b();
        return;
    L5:
        com.larksuite.component.ui.dialog.d r1 = new com.larksuite.component.ui.dialog.d(this.b);
        r1.j(2131892501);
        r1.c.titleLineCount(2);
        r1.h(UIHelper.mustacheFormat(2131892502, "name", r4.i));
        r1.b(2131378551, this.c, null);
        r1.i();
    }

    @Override // com.larksuite.component.blockit.hashtag.list.HashTagSwipeAdapter.a
    public final void b(oy7.e r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        if (r9.g == false) goto L14;
        String r0 = UIHelper.getString(2131892491);
        SpannableString r4 = new SpannableString(r0);
        r4.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(2131103493)), 0, r0.length(), 33);
        String r1 = UIHelper.mustacheFormat(2131892494, "name", r9.c);
        if (r9.j != TagPermissionType.Private.value()) goto L13;
        k.a r2 = this.a.d;
        if (r2 == null) goto L9;
        String r3 = r2.I6();
    L11:
        if (Intrinsics.areEqual(r3, BlockTypeID.CHAT.getValue()) == false) goto L13;
        r1 = UIHelper.getString(2131892492);
        goto L13
    L9:
        r3 = null;
    L13:
        com.larksuite.component.ui.dialog.d r5 = new com.larksuite.component.ui.dialog.d(this.b);
        r5.k(UIHelper.getString(2131892493));
        r5.c.titleLineCount(2);
        r5.h(r1);
        r5.b(2131378550, UIHelper.getString(2131892481), new c(this.a));
        r5.b(2131378551, r4, new d(this.a, r9));
        r5.i();
        return;
    L14:
        com.larksuite.component.ui.dialog.d r6 = new com.larksuite.component.ui.dialog.d(this.b);
        r6.j(2131892500);
        r6.c.titleLineCount(2);
        r6.h(UIHelper.mustacheFormat(2131892483, "name", r9.i));
        r6.b(2131378551, this.c, new e(this.a));
        r6.i();
    }

    public f(b r1, FragmentActivity r2, SpannableString r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
