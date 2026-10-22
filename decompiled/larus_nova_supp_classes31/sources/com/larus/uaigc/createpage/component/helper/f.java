package com.larus.uaigc.createpage.component.helper;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final Fragment a;
    public Function1<? super List<? extends Uri>, Unit> b;
    public int c;
    public int d;
    public long e;
    public Map<String, ? extends Object> f;
    public final MutableSharedFlow<b> g;
    public final a1 h;
    public final ActivityResultLauncher<String> i;
    public final ActivityResultLauncher<Intent> j;

    public static final class a {
    }

    static {
    }

    public f(Fragment r9) {
        Intrinsics.checkNotNullParameter(r9, "fragment");
        this.a = r9;
        this.c = 1;
        this.d = 1;
        MutableSharedFlow<b> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.g = r0;
        this.h = kotlinx.coroutines.flow.e.a(r0);
        this.i = r9.registerForActivityResult(new ActivityResultContracts.GetMultipleContents(), new d(this));
        this.j = r9.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new e(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), null, null, new VideoEditorPickPhotoHelper$initObservers$1(this, null), 3, null);
    }
}
