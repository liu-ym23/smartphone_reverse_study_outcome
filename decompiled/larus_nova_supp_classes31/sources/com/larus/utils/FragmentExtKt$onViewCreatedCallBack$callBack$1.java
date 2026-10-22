package com.larus.utils;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/larus/utils/FragmentExtKt$onViewCreatedCallBack$callBack$1", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "onFragmentViewCreated", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FragmentExtKt$onViewCreatedCallBack$callBack$1 extends FragmentManager.FragmentLifecycleCallbacks {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ FragmentManager c;

    public FragmentExtKt$onViewCreatedCallBack$callBack$1(Fragment r1, com.larus.aweme.impl.main_bot.b r2, FragmentManager r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFragmentViewCreated(FragmentManager r2, Fragment r3, View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        Intrinsics.checkNotNullParameter(r4, "v");
        super.onFragmentViewCreated(r2, r3, r4, r5);
        if (Intrinsics.areEqual(r3, this.a) == false) goto L6;
        this.b.invoke();
        this.c.unregisterFragmentLifecycleCallbacks(this);
        return;
    }
}
