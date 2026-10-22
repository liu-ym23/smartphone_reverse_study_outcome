package com.larksuite.component.blockit.hashtag.list;

import android.view.View;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class HashTagListPresenter extends BasePresenter<j, k, k.a> {
    public final BlockEntity a;
    public final Map<String, Object> b;

    public final class ViewDelegate implements k.a {
        public final /* synthetic */ HashTagListPresenter a;

        @Override // com.larksuite.component.blockit.hashtag.list.k.a
        public final String I6() {
            return this.a.a.getBlockTypeID();
        }

        public ViewDelegate(HashTagListPresenter r1) {
            this.a = r1;
        }

        @Override // com.larksuite.component.blockit.hashtag.list.k.a
        public final void M3(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "tagId");
            Intrinsics.checkNotNullParameter(r6, "tagInstanceId");
            j r0 = this.a.getModel();
            final HashTagListPresenter r3 = this.a;
            r0.G7(r5, r6, new UIGetDataCallback(new HashTagListPresenter$ViewDelegate$onDeleteTag$1(r3)));
        }
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new ViewDelegate(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        H8(true);
    }

    public final void H8(final boolean r5) {
        getModel().B4(this.a.getBlockID(), new UIGetDataCallback(new HashTagListPresenter$loadData$1(this, r5)));
    }

    public HashTagListPresenter(View r2, HashTagListFragment.a r3, BlockEntity r4, String r5, Map r6) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "viewDependency");
        Intrinsics.checkNotNullParameter(r4, "blockEntity");
        this.a = r4;
        this.b = r6;
        setView(new b(r2, r3, r6));
        getView().setViewDelegate(new ViewDelegate(this));
        setModel(new a(r4, r5));
    }
}
