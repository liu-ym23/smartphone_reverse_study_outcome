package com.larksuite.component.blockit.hashtag.add;

import android.view.View;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AddHashTagPresenter extends BasePresenter<i, j, j.a> {
    public final BlockEntity a;
    public final boolean b;
    public final String c;
    public final String d;
    public final Map<String, Object> e;
    public boolean f;

    public final class ViewDelegate implements j.a {
        public final /* synthetic */ AddHashTagPresenter a;

        public ViewDelegate(AddHashTagPresenter r1) {
            this.a = r1;
        }

        @Override // com.larksuite.component.blockit.hashtag.add.j.a
        public final void R5(final oy7.e r7) {
            Intrinsics.checkNotNullParameter(r7, "data");
            AddHashTagPresenter r0 = this.a;
            if (r0.f == false) goto L5;
            return;
        L5:
            r0.f = true;
            i r1 = r0.getModel();
            String r2 = r7.c;
            final AddHashTagPresenter r3 = this.a;
            r1.T4(r2, r3.c, new UIGetDataCallback(new AddHashTagPresenter$ViewDelegate$onCreateHashTag$1(r7, r3)));
        }

        @Override // com.larksuite.component.blockit.hashtag.add.j.a
        public final void k4(final oy7.e r7) {
            Intrinsics.checkNotNullParameter(r7, "data");
            AddHashTagPresenter r0 = this.a;
            if (r0.f == false) goto L5;
            return;
        L5:
            r0.f = true;
            i r1 = r0.getModel();
            String r2 = r7.a;
            final AddHashTagPresenter r3 = this.a;
            r1.G2(r2, r3.c, new UIGetDataCallback(new AddHashTagPresenter$ViewDelegate$onAddHashTag$1(r7, r3)));
        }

        @Override // com.larksuite.component.blockit.hashtag.add.j.a
        public final void r7(final String r6) {
            Intrinsics.checkNotNullParameter(r6, "query");
            AddHashTagPresenter r0 = this.a;
            if (r0.b == false) goto L5;
            i r1 = r0.getModel();
            final AddHashTagPresenter r3 = this.a;
            r1.P7(r6, new UIGetDataCallback(new AddHashTagPresenter$ViewDelegate$onSearchHashTag$1(r3, r6)));
            return;
        L5:
            i r2 = r0.getModel();
            final AddHashTagPresenter r4 = this.a;
            r2.p3(r6, r4.d, new UIGetDataCallback(new AddHashTagPresenter$ViewDelegate$onSearchHashTag$2(r4, r6)));
        }
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new ViewDelegate(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        if (this.b == false) goto L5;
        getModel().P7("", new UIGetDataCallback(new AnonymousClass1(this)));
        return;
    L5:
        getModel().p3("", this.d, new UIGetDataCallback(new AnonymousClass2(this)));
    }

    public static final /* synthetic */ j H8(AddHashTagPresenter r0) {
        return r0.getView();
    }

    public AddHashTagPresenter(View r2, AddHashTagFragment.a r3, BlockEntity r4, boolean r5, String r6, String r7, Map r8) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "viewDependency");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        setView(new b(r2, r3, r5, r8));
        getView().setViewDelegate(new ViewDelegate(this));
        setModel(new a(r4));
    }
}
