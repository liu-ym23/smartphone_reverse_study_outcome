package com.larksuite.component.blockit.hashtag.add;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.blockit.hashtag.list.HashTagSwipeAdapter;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g implements HashTagSwipeAdapter.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ Context b;

    @Override // com.larksuite.component.blockit.hashtag.list.HashTagSwipeAdapter.a
    public final void b(oy7.e r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larksuite.component.blockit.hashtag.list.HashTagSwipeAdapter.a
    public final void a(oy7.e r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        b r0 = this.a;
        boolean r2 = false;
        if (r0.c == false) goto L30;
        Context r1 = this.b;
        Integer r8 = null;
        if (r10.l == false) goto L14;
        j.a r3 = r0.e;
        if (r3 == null) goto L9;
        r3.R5(r10);
    L9:
        JSONObject r11 = new JSONObject(r0.d);
        HashTagSwipeAdapter r4 = r0.f;
        if (r4 == null) goto L12;
        r8 = Integer.valueOf(r4.getItemCount() - 1);
    L12:
        r11.put("tag_count", r8);
        qy7.a.a("pano_action_panel_create_new_tag", r11);
        return;
    L14:
        if (r10.e == false) goto L17;
        r0.G0(y9c.d.i(r1, 2131892495), 0);
        return;
    L17:
        if (r10.f == false) goto L29;
        j.a r5 = r0.e;
        if (r5 == null) goto L21;
        r5.k4(r10);
    L21:
        JSONObject r6 = new JSONObject(r0.d);
        HashTagSwipeAdapter r7 = r0.f;
        if (r7 == null) goto L24;
        r8 = Integer.valueOf(r7.getItemCount() - 1);
    L24:
        r6.put("tag_count", r8);
        r6.put("tag_id", r10.a);
        if (((EditText) r0.a.findViewById(2131371788)).length() != 0) goto L27;
        String r12 = "recommend";
    L28:
        r6.put("tag_type", r12);
        qy7.a.a("pano_action_panel_add_listed_tag", r6);
        return;
    L27:
        r12 = "search";
        goto L28
    L29:
        com.larksuite.component.ui.dialog.d r9 = new com.larksuite.component.ui.dialog.d(r1);
        r9.j(2131892499);
        r9.c.titleLineCount(2);
        r9.h(UIHelper.mustacheFormat(2131892504, "name", r10.i));
        r9.b(2131378551, UIUtils.getString(r1, 2131892486), null);
        r9.i();
        return;
    L30:
        JSONObject r13 = new JSONObject(r0.d);
        r13.put("session_id", r0.h);
        r13.put("tag_id", r10.a);
        if (((EditText) r0.a.findViewById(2131371788)).length() <= 0) goto L33;
        r2 = true;
    L33:
        r13.put("if_input", r2);
        qy7.a.a("pano_mention_click_result", r13);
        Intent r14 = new Intent();
        r14.putExtra("extra.hash.tag.id", r10.a);
        r14.putExtra("extra.hash.tag.name", r10.c);
        r14.putExtra("extra.hash.tag.is.authorized", r10.f);
        FragmentActivity r15 = r0.b.getActivity();
        if (r15 == null) goto L36;
        r15.setResult(-1, r14);
    L36:
        FragmentActivity r16 = r0.b.getActivity();
        if (r16 == null) goto L44;
        r16.finish();
        return;
    }

    public g(b r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
