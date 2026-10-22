package com.ss.android.lark.contact.impl.group.manage;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.base.fragment.BaseFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q9b.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MyManageGroupFragment extends BaseFragment {
    public static final /* synthetic */ int i = 0;
    public MyManageGroupPresenter d;
    public final c e;
    public final List<String> f;
    public m g;
    public q9b.a h;

    public class a implements q9b.a.InterfaceC0281a {
        public final /* synthetic */ MyManageGroupFragment a;

        @Override // q9b.a.InterfaceC0281a
        public final void a() {
            MyManageGroupPresenter r0 = this.a.d;
            if (r0 == null) goto L8;
            b r1 = (b) r0.getView();
            if (r1 == null) goto L9;
            r1.refresh();
            return;
        L9:
            return;
        }

        public a(MyManageGroupFragment r1) {
            this.a = r1;
        }
    }

    public MyManageGroupFragment() {
        this.e = new c(this);
        this.f = new ArrayList();
        this.g = null;
        this.h = null;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.destroy();
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        q9b.a r0 = this.h;
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
        this.h = r0;
        a r5 = new a(this);
        Intrinsics.checkNotNullParameter(r5, "onWindowChangedListener");
        r0.b = r5;
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        MyManageGroupPresenter r0 = new MyManageGroupPresenter(new d(), new MyManageGroupView(this.e, this.f, this.g));
        this.d = r0;
        r0.create();
        ((b) this.d.getView()).setEnableChatPreview(false);
        ((b) this.d.getView()).setExtras(null);
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        fsb.f.b().i("MyManageGroup");
        View r6 = r3.inflate(2131561182, r4, false);
        fsb.f.b().h("MyManageGroup");
        return r6;
    }
}
