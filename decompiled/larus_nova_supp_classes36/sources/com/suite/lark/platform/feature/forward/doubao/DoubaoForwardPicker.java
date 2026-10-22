package com.suite.lark.platform.feature.forward.doubao;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.base.widget.SearchResultAdapter;
import com.ss.android.lark.picker.config.ConfigKt;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.doubao.LarkPicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DoubaoForwardPicker extends FrameLayout implements tib.e {
    public final LarkPicker a;
    public ICustomBinder b;

    public static final class a {
    }

    static {
    }

    @Override // tib.e
    public final void a() {
    }

    @Override // tib.e
    public final void c() {
        this.a.defaultMode(false);
    }

    @Override // tib.e
    public final void d() {
    }

    @Override // tib.e
    public final void e() {
    }

    @Override // tib.e
    public final void destroy() {
        this.a.destroy();
    }

    @Override // tib.e
    public final void h() {
        this.a.clearInputViewFocus();
    }

    public DoubaoForwardPicker(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        LarkPicker r0 = new LarkPicker(r4, null, 2, null);
        this.a = r0;
        addView(r0, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // tib.e
    public final void b(boolean r3) {
        this.a.switchMultipleStatus(r3, true);
    }

    @Override // tib.e
    public final void f(List<? extends SearchBaseInfo> r2) {
        LarkPicker r0 = this.a;
        if (r2 == null) goto L5;
        List r3 = CollectionsKt.toMutableList(r2);
    L6:
        r0.resetSelectedData(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // tib.e
    public final void g(final tib.b r8) {
        Intrinsics.checkNotNullParameter(r8, "config");
        BasePicker.IViewDependency r0 = r8.h;
        if (r0 != null) goto L16;
        if (r8.s == null) goto L7;
    L8:
        DoubaoForwardPicker$applyConfig$1 r1 = new DoubaoForwardPicker$applyConfig$1(this.a);
        Intrinsics.checkNotNullParameter(r1, "attach");
        SearchResultAdapter r2 = r8.s;
        if (r2 == null) goto L12;
        r1.invoke(r2);
        return;
    L12:
        if (r8.t == false) goto L44;
        r1.invoke(null);
        return;
    L44:
        return;
    L7:
        if (r8.t == true) goto L8;
    L16:
        if (r0 != null) goto L19;
        Log.e("DoubaoForwardPicker", "applyConfig failed: ForwardChatPickerConfig.viewDependency is null");
        return;
    L19:
        final FragmentActivity r4 = r0.getActivity();
        if ((r4 instanceof FragmentActivity) == true) goto L23;
        Log.e("DoubaoForwardPicker", "applyConfig failed: viewDependency.getActivity() is not FragmentActivity, activity=" + r4);
        return;
    L23:
        FragmentManager r3 = r0.getFragmentManager();
        if (r3 != null) goto L27;
        Log.e("DoubaoForwardPicker", "applyConfig failed: viewDependency.getFragmentManager() is null");
        return;
    L27:
        List<ActionType> r5 = r8.b;
        if (r5 != null) goto L30;
        r5 = CollectionsKt.emptyList();
    L30:
        FragmentActivity r6 = r4;
        this.a.init(r6, ConfigKt.pickerConfig(new Dependency(r6, r3), new Permissions(r5), new DoubaoForwardPicker$applyConfig$pickerConfig$1(r8, r4, this)));
        BasePicker.IOnPickModeChangeListener r7 = r8.p;
        if (r7 == null) goto L33;
        this.a.setPickModeChangeListener(r7);
    L33:
        ICustomBinder r9 = this.b;
        if (r9 == null) goto L36;
        this.a.setCustomBinder(r9);
    L36:
        DoubaoForwardPicker$applyConfig$4 r10 = new DoubaoForwardPicker$applyConfig$4(this.a);
        Intrinsics.checkNotNullParameter(r10, "attach");
        SearchResultAdapter r11 = r8.s;
        if (r11 == null) goto L40;
        r10.invoke(r11);
        return;
    L40:
        if (r8.t == false) goto L46;
        r10.invoke(null);
        return;
    }

    @Override // tib.e
    public final void i(boolean r2) {
        this.a.resetFocus(r2);
    }

    @Override // tib.e
    public void setConsumeResultLayoutClickWhenEmpty(boolean r2) {
        this.a.setConsumeResultLayoutClickWhenEmpty(r2);
    }

    @Override // tib.e
    public void setCustomBinder(ICustomBinder r2) {
        Intrinsics.checkNotNullParameter(r2, "binder");
        this.b = r2;
        this.a.setCustomBinder(r2);
    }
}
