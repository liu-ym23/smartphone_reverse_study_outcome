package com.obric.memorydata.memory.ui.automemory.create;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionSheetHostFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryCreateCollectionSheetHostFragment extends Fragment {
    public static final a Companion = null;
    private static final String INFO_TAG = "create_collection_info";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionSheetHostFragment$Companion;", "", "<init>", "()V", "INFO_TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoMemoryCreateCollectionSheetHostFragment() {
        super(ZeusTransformUtils.mapRes(R.layout.fragment_base_create_collection_sheet, "layout", "fragment_base_create_collection_sheet"));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        if (r4 != null) goto L6;
        getChildFragmentManager().beginTransaction().add(ZeusTransformUtils.mapRes(R.id.sheet_container, OaidModel.KEY_ID, "sheet_container"), (Fragment) ZeusTransformUtils.preCheckCast(new AutoMemoryCreateCollectionInfoFragment(), Fragment.class, "com.obric.memorydata.plugin"), INFO_TAG).commitNowAllowingStateLoss();
        return;
    }
}
