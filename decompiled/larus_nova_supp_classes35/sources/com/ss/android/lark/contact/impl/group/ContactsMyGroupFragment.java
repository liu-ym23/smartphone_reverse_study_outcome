package com.ss.android.lark.contact.impl.group;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import com.ss.android.lark.statistics.Statistics;
import fsb.f;
import kotlin.Lazy;
import org.json.JSONObject;
import q9b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ContactsMyGroupFragment extends BaseFragment {
    public static final /* synthetic */ int i = 0;
    public boolean d;
    public com.ss.android.lark.contact.impl.group.b e;
    public View f;
    public d g;
    public final a h;

    public class a implements ContactsMyGroupView.a {
        public final /* synthetic */ ContactsMyGroupFragment a;

        public a(ContactsMyGroupFragment r1) {
            this.a = r1;
        }
    }

    public static class b {
        public final Message a;
        public Chat b;

        public b(Message r1) {
            this.a = r1;
        }
    }

    public ContactsMyGroupFragment() {
        this.d = false;
        this.h = new a(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.e.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttach(Context r3) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onAttach(r3);
        if (getArguments() == null) goto L8;
        this.d = getArguments().getBoolean("IS_FROM_CONTACT_TAB", false);
        Message r4 = (Message) getArguments().getParcelable("SELECT_GROUP_MSG");
        if (r4 == null) goto L9;
        b r0 = new b(r4);
        this.g = new d(this, r0);
        getLifecycle().addObserver(new com.ss.android.lark.contact.impl.group.a(r0));
        return;
    L9:
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        if (getActivity() == null) goto L11;
        String r4 = getActivity().getIntent().getStringExtra("APPRECIABLE_KEY_CONTACTS_MY_GROUP");
        String r5 = r9b.a.a;
        if (r4 == null) goto L8;
        r9b.a.a = r4;
    L8:
        if (this.d == false) goto L12;
        Lazy r6 = ContactHitPoint.a;
        Statistics.sendEvent("contact_groups_category_click", new JSONObject().put("location", "created"));
        return;
    L12:
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        this.f = r4.inflate(2131558472, r5, false);
        f.b().h("onCreateView");
        f.b().i("initMVP");
        com.ss.android.lark.contact.impl.group.b r7 = new com.ss.android.lark.contact.impl.group.b(getActivity(), this.h, this.g, getChildFragmentManager());
        this.e = r7;
        r7.create();
        Lazy r8 = ContactHitPoint.a;
        Statistics.sendEvent("contact_groups_view");
        JSONObject r9 = new JSONObject();
        r9.put("member_type", ContactHitPoint.a());
        Statistics.sendEvent("contact_group_view", r9);
        f.b().h("initMVP");
        return this.f;
    }
}
