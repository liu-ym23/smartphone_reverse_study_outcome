package com.bytedance.android.annie.api.container;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.business.container.AnnieXLiveDialog;
import com.bytedance.crash.d;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/annie/api/container/HybridDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/android/annie/api/card/IHybridComponent;", "<init>", "()V", "a", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public abstract class HybridDialog extends DialogFragment implements IHybridComponent {

    public interface a {
        void onDismiss();

        void onScroll(int r1);

        void onShow();
    }

    public boolean S90() {
        return this instanceof AnnieXLiveDialog;
    }

    public abstract void T90(a r1);

    public void U90(boolean r1) {
    }

    public abstract void V90(boolean r1);

    public abstract void W90(boolean r1);

    public abstract void X90(Function0<Unit> r1);

    public void Y90(boolean r1) {
    }

    public abstract void Z90(boolean r1);

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ void addOnPreDrawListener() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ boolean canGoBack() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    public abstract IHybridComponent getHybridComponent();

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ void goBack() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void hide() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean isPopup() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void setOnScrollChangeListener(IHybridComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
    }

    @Override // a7.b
    public final /* synthetic */ void setRadius(float r1) {
    }

    @Override // a7.b
    public final /* synthetic */ void setRadius(float r1, float r10, float r11, float r12) {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void show() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void close() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
    L8:
        IHybridComponent r0 = getHybridComponent();
        if (r0 == null) goto L11;
        r0.close();
    L11:
        release();
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L8;
        d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final String containerId() {
        IHybridComponent r0 = getHybridComponent();
        if (r0 == null) goto L6;
        String r1 = r0.containerId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final View getHybridView() {
        IHybridComponent r0 = getHybridComponent();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHybridView();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final IHybridComponent.HybridType hybridType() {
        IHybridComponent r0 = getHybridComponent();
        if (r0 == null) goto L7;
        IHybridComponent.HybridType r1 = r0.hybridType();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return IHybridComponent.HybridType.H5;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void release() {
        IHybridComponent r0 = getHybridComponent();
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public HybridDialog() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        IHybridComponent r0 = getHybridComponent();
        if (r0 == null) goto L6;
        r0.updateData(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        IHybridComponent r0 = getHybridComponent();
        if (r0 == null) goto L6;
        r0.updateGlobalProps(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void load(String r10, Map<String, ? extends Object> r11) {
        IHybridComponent r0 = getHybridComponent();
        if (r0 == null) goto L6;
        r0.load(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void registerMethod(String r10, f.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        IHybridComponent r0 = getHybridComponent();
        if (r0 == null) goto L6;
        r0.registerMethod(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final <T> void sendJsEvent(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "data");
        IHybridComponent r0 = getHybridComponent();
        if (r0 == null) goto L6;
        r0.sendJsEvent(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final <P, R> void registerMethod(String r10, g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        IHybridComponent r0 = getHybridComponent();
        if (r0 == null) goto L6;
        r0.registerMethod(r10, r11);
        return;
    }
}
