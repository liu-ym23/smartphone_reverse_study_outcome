package com.larus.bmhome.view.actionbar.gaokao;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.IGaokaoPreferenceService;
import com.larus.bmhome.view.actionbar.gaokao.network.PreloadGaokaoProvinceConfHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/GaokaoPreferenceServiceImpl;", "Lcom/larus/bmhome/chat/api/IGaokaoPreferenceService;", "<init>", "()V", "showGaokaoPreference", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onTextSelected", "Lkotlin/Function1;", "", "onError", "Lkotlin/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoPreferenceServiceImpl implements IGaokaoPreferenceService {
    public GaokaoPreferenceServiceImpl() {
    }

    public final void a(FragmentActivity r10, LifecycleOwner r11, com.larus.bmhome.view.actionbar.edit.kmp.c r12, com.larus.bmhome.view.actionbar.edit.kmp.d r13) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "onTextSelected");
        PreloadGaokaoProvinceConfHelper r2 = PreloadGaokaoProvinceConfHelper.a;
        PreloadGaokaoProvinceConfHelper.a(LifecycleOwnerKt.getLifecycleScope(r11));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), Dispatchers.getMain(), null, new GaokaoPreferenceServiceImpl$showGaokaoPreference$1(r2, r10, r12, r13, null), 2, null);
    }
}
