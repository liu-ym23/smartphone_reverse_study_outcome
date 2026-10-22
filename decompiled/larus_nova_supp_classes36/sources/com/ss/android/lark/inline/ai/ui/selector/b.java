package com.ss.android.lark.inline.ai.ui.selector;

import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.inline.ai.api.MentionType;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.NavPicker;
import com.ss.android.lark.picker.Picker;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.PickerConfig;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ View b;
    public final /* synthetic */ SelectorFragment c;

    public b(FragmentActivity r1, View r2, SelectorFragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a.isFinishing() == false) goto L5;
        return;
    L5:
        if (this.a.isDestroyed() == true) goto L21;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout r1 = (LinearLayout) this.b;
        if (r1 == null) goto L20;
        final SelectorFragment r2 = this.c;
        View r4 = null;
        if (Intrinsics.areEqual(r2.d, MentionType.USER.getValue()) == false) goto L14;
        final FragmentActivity r3 = r2.getActivity();
        if (r3 == null) goto L17;
        View r5 = new NavPicker(r3, null, 2, null);
        r5.scene(r2.f);
        NavPickerConfig r6 = new NavPickerConfig(new Dependency(r3, r3.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r6.navigation(new SelectorFragment$getNavPickerConfig$config$1$1(r2, r3));
        r6.searcher(new SelectorFragment$getNavPickerConfig$config$1$2(r2));
        r6.extra(new SelectorFragment$getNavPickerConfig$config$1$3(r2));
        r6.recommendList(SelectorFragment$getNavPickerConfig$config$1$4.INSTANCE);
        r5.init(r6);
        r4 = r5;
    L17:
        r1.addView(r4, 1, r0);
        return;
    L14:
        FragmentActivity r7 = r2.getActivity();
        if (r7 == null) goto L17;
        r4 = new Picker(r7);
        r4.scene(r2.f);
        PickerConfig r8 = new PickerConfig(new Dependency(r7, r7.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r8.searcher(new SelectorFragment$getPickerConfig$config$1$1(r2));
        r8.extra(new SelectorFragment$getPickerConfig$config$1$2(r2));
        r8.recommendList(new SelectorFragment$getPickerConfig$config$1$3(r2));
        r4.init(r8);
        goto L17
    L20:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
