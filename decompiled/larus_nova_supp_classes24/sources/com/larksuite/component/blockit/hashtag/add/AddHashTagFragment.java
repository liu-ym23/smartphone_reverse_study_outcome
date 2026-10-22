package com.larksuite.component.blockit.hashtag.add;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.base.fragment.BaseFragment;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\"\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larksuite/component/blockit/hashtag/add/AddHashTagFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "mPresenter", "Lcom/larksuite/component/blockit/hashtag/add/AddHashTagPresenter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityCreated", "", "initMVP", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "Dependency", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AddHashTagFragment extends BaseFragment {

    public final class a implements b.a {
        public final /* synthetic */ AddHashTagFragment a;

        @Override // com.larksuite.component.blockit.hashtag.add.b.a
        public FragmentActivity getActivity() {
            return this.a.getActivity();
        }

        public a(AddHashTagFragment r1) {
            this.a = r1;
        }
    }

    public AddHashTagFragment() {
    }

    public final void onActivityCreated(Bundle r9) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r9);
        View r1 = getView();
        if (r1 == null) goto L33;
        Bundle r10 = getArguments();
        Object r0 = null;
        if (r10 == null) goto L7;
        Serializable r11 = r10.getSerializable("extra.block.entity");
    L9:
        if ((r11 instanceof BlockEntity) == false) goto L11;
        BlockEntity r3 = (BlockEntity) r11;
    L12:
        Bundle r12 = getArguments();
        if (r12 == null) goto L15;
        String r5 = r12.getString("extra.context.json");
    L16:
        Bundle r13 = getArguments();
        if (r13 == null) goto L19;
        boolean r4 = r13.getBoolean("extra.is.add.hash.tag", true);
    L20:
        Bundle r14 = getArguments();
        if (r14 == null) goto L23;
        String r6 = r14.getString("extra.user.id");
    L24:
        Bundle r15 = getArguments();
        if (r15 == null) goto L27;
        r0 = r15.get("extra.hit_point.params");
    L27:
        Map r2 = (Map) r0;
        if (r2 != null) goto L30;
        Map r7 = new HashMap();
    L31:
        new AddHashTagPresenter(r1, new a(this), r3, r4, r5, r6, r7).create();
        return;
    L30:
        r7 = r2;
        goto L31
    L23:
        r6 = null;
        goto L24
    L19:
        r4 = true;
        goto L20
    L15:
        r5 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    L7:
        r11 = null;
        goto L9
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r1, r2, r3);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561157, r3, false);
    }
}
