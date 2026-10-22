package com.ss.android.lark.contact.impl.group.join;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.base.fragment.BaseFragment;
import kotlin.jvm.internal.Intrinsics;
import q9b.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MyJoinGroupFragment extends BaseFragment {
    public MyJoinGroupPresenter d;
    public m e;
    public q9b.a f;
    public final a g;

    public class a implements MyJoinGroupView.a {
        public final /* synthetic */ MyJoinGroupFragment a;

        public a(MyJoinGroupFragment r1) {
            this.a = r1;
        }
    }

    public class b implements q9b.a.InterfaceC0281a {
        public final /* synthetic */ MyJoinGroupFragment a;

        @Override // q9b.a.InterfaceC0281a
        public final void a() {
            MyJoinGroupPresenter r0 = this.a.d;
            if (r0 == null) goto L8;
            com.ss.android.lark.contact.impl.group.join.b r1 = (com.ss.android.lark.contact.impl.group.join.b) r0.getView();
            if (r1 == null) goto L9;
            r1.refresh();
            return;
        L9:
            return;
        }

        public b(MyJoinGroupFragment r1) {
            this.a = r1;
        }
    }

    public MyJoinGroupFragment() {
        this.e = null;
        this.f = null;
        this.g = new a(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.destroy();
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        q9b.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Configuration r4 = getContext().getResources().getConfiguration();
        if (r4 == null) goto L6;
        q9b.a r0 = new q9b.a(r4);
        this.f = r0;
        b r5 = new b(this);
        Intrinsics.checkNotNullParameter(r5, "onWindowChangedListener");
        r0.b = r5;
        return;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        MyJoinGroupPresenter r0 = new MyJoinGroupPresenter(new c(), new MyJoinGroupView(this.g, this.e));
        this.d = r0;
        r0.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131561181, r3, false);
    }
}
