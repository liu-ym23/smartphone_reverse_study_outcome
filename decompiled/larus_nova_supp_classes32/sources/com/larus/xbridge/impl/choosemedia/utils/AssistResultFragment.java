package com.larus.xbridge.impl.choosemedia.utils;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.lynx.jsbridge.LynxResourceModule;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016Ra\u0010\u0004\u001aI\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/xbridge/impl/choosemedia/utils/AssistResultFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onActivityResult", "Lkotlin/Function3;", NameKeys.UnloadStrategy_No_Strategy, "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "requestCode", "resultCode", "Landroid/content/Intent;", LynxResourceModule.DATA_KEY, NameKeys.UnloadStrategy_No_Strategy, "getOnActivityResult", "()Lkotlin/jvm/functions/Function3;", "setOnActivityResult", "(Lkotlin/jvm/functions/Function3;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistResultFragment extends Fragment {
    public Function3<? super Integer, ? super Integer, ? super Intent, Unit> d;

    public AssistResultFragment() {
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        Function3<? super Integer, ? super Integer, ? super Intent, Unit> r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("onActivityResult");
        r0 = null;
    L6:
        r0.invoke(Integer.valueOf(r2), Integer.valueOf(r3), r4);
    }
}
