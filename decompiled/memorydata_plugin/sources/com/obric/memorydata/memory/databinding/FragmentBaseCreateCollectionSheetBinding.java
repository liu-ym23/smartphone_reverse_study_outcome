package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentBaseCreateCollectionSheetBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final FragmentContainerView sheetContainer;

    private FragmentBaseCreateCollectionSheetBinding(ConstraintLayout r1, FragmentContainerView r2) {
        this.rootView = r1;
        this.sheetContainer = r2;
    }

    public static FragmentBaseCreateCollectionSheetBinding bind(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.sheet_container, OaidModel.KEY_ID, "sheet_container");
        FragmentContainerView r1 = (FragmentContainerView) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), FragmentContainerView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return new FragmentBaseCreateCollectionSheetBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.class, "com.obric.memorydata.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static FragmentBaseCreateCollectionSheetBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentBaseCreateCollectionSheetBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_base_create_collection_sheet, "layout", "fragment_base_create_collection_sheet"), r4, false, "com.obric.memorydata.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return bind(r6);
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
