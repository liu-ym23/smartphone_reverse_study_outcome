package com.ss.android.lark.contact.base.contact_new.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactPresenter;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import com.ss.android.lark.contact.base.contact_new.mvp.g;
import com.ss.android.lark.contact.base.service.a0;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class NewContactFragment extends BaseFragment {
    public NewContactPresenter d;
    public View e;
    public a f;

    public class a implements NewContactView.b {
        public final /* synthetic */ NewContactFragment a;

        public a(NewContactFragment r1) {
            this.a = r1;
        }
    }

    public NewContactFragment() {
        this.f = new a(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        NewContactPresenter r0 = this.d;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.f = null;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        a0.d(true);
        this.e = r2.inflate(2131558494, r3, false);
        NewContactPresenter r5 = new NewContactPresenter(new g(), new NewContactView(this.f));
        this.d = r5;
        r5.create();
        Lazy r6 = ContactHitPoint.a;
        JSONObject r7 = new JSONObject();
        r7.put("member_type", ContactHitPoint.a());
        Statistics.sendEvent("contact_new_view", r7);
        return this.e;
    }
}
