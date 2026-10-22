package com.larksuite.component.blockit.hashtag.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.hashtag.add.AddHashTagActivity;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.base.fragment.BaseFragment;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\"\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larksuite/component/blockit/hashtag/list/HashTagListFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "mPresenter", "Lcom/larksuite/component/blockit/hashtag/list/HashTagListPresenter;", "mAddTagRequestCode", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityCreated", "", "initMVP", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "Dependency", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class HashTagListFragment extends BaseFragment {
    public HashTagListPresenter d;
    public final int e;

    public final class a implements b.a {
        public final /* synthetic */ HashTagListFragment a;

        @Override // com.larksuite.component.blockit.hashtag.list.b.a
        public final void a() {
            if (this.a.getActivity() == null) goto L18;
            HashTagListFragment r0 = this.a;
            Bundle r1 = r0.getArguments();
            Serializable r3 = null;
            if (r1 == null) goto L7;
            Serializable r2 = r1.getSerializable("extra.block.entity");
        L8:
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larksuite.component.blockit.entity.BlockEntity");
            BlockEntity r4 = (BlockEntity) r2;
            Bundle r5 = r0.getArguments();
            if (r5 == null) goto L11;
            String r6 = r5.getString("extra.context.json");
        L12:
            Bundle r7 = r0.getArguments();
            if (r7 == null) goto L15;
            r3 = r7.getSerializable("extra.hit_point.params");
        L15:
            if (r4 == null) goto L19;
            r0.startActivityForResult(new Intent(r0.getContext(), AddHashTagActivity.class).putExtra("extra.block.entity", r4).putExtra("extra.context.json", r6).putExtra("extra.hit_point.params", r3), r0.e);
            return;
        L19:
            return;
        L11:
            r6 = null;
            goto L12
        L7:
            r2 = null;
            goto L8
        }

        @Override // com.larksuite.component.blockit.hashtag.list.b.a
        public final FragmentActivity b() {
            return this.a.getActivity();
        }

        public a(HashTagListFragment r1) {
            this.a = r1;
        }
    }

    public HashTagListFragment() {
        this.e = 1;
    }

    public final void onActivityCreated(Bundle r7) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r7);
        View r1 = getView();
        if (r1 == null) goto L22;
        Bundle r8 = getArguments();
        Object r0 = null;
        if (r8 == null) goto L7;
        Serializable r9 = r8.getSerializable("extra.block.entity");
    L8:
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.larksuite.component.blockit.entity.BlockEntity");
        BlockEntity r3 = (BlockEntity) r9;
        Bundle r10 = getArguments();
        if (r10 == null) goto L11;
        String r4 = r10.getString("extra.context.json");
    L12:
        Bundle r11 = getArguments();
        if (r11 == null) goto L15;
        r0 = r11.get("extra.hit_point.params");
    L15:
        Map r2 = (Map) r0;
        if (r2 != null) goto L18;
        Map r5 = new HashMap();
    L19:
        if (r3 == null) goto L23;
        HashTagListPresenter r12 = new HashTagListPresenter(r1, new a(this), r3, r4, r5);
        this.d = r12;
        r12.create();
        return;
    L23:
        return;
    L18:
        r5 = r2;
        goto L19
    L11:
        r4 = null;
        goto L12
    L7:
        r9 = null;
        goto L8
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r1, r2, r3);
        if (r1 == this.e) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L11;
        HashTagListPresenter r4 = this.d;
        if (r4 == null) goto L12;
        r4.H8(false);
        return;
    L12:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561205, r3, false);
    }
}
