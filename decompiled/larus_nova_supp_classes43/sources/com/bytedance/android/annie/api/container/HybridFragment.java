package com.bytedance.android.annie.api.container;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001WB\u0007¢\u0006\u0004\bU\u0010VJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J0\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0016J)\u0010\u000f\u001a\u00020\u0007\"\b\b\u0000\u0010\r*\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0011\u001a\u00020\u0007\"\b\b\u0000\u0010\r*\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000H'¢\u0006\u0004\b\u0011\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0017J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J*\u0010\u001a\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0018H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001e\u0010\u001d\u001a\u00020\u00072\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0018H\u0016J \u0010\u001e\u001a\u00020\u00072\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0018H\u0016J\u0006\u0010 \u001a\u00020\u001fJ\b\u0010!\u001a\u00020\u0007H&J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0003H&J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0003H&J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0003H&J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0003H&J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u001fH&J\b\u0010.\u001a\u00020\u0007H&J\b\u0010/\u001a\u00020\u001fH&J\b\u00100\u001a\u0004\u0018\u00010\u0002J\u0010\u00100\u001a\u0004\u0018\u00010\u00022\u0006\u00101\u001a\u00020\u001fJ\u0018\u00105\u001a\u00020\u00072\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\fH&J\b\u00106\u001a\u00020\u0007H\u0016J\b\u00107\u001a\u00020\u0007H\u0016J\b\u00108\u001a\u00020\u001fH\u0016J\b\u00109\u001a\u00020\u001fH\u0016J\b\u0010:\u001a\u00020\u0007H\u0016J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u001fH\u0016J\u0010\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u001fH\u0016J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u001fH\u0016J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020\u001fH\u0016R$\u0010F\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u001f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bF\u0010HR$\u0010I\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\u001f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bO\u0010G\u001a\u0004\bP\u0010H\"\u0004\bQ\u0010RR\"\u00101\u001a\u00020\u001f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b1\u0010G\u001a\u0004\bS\u0010H\"\u0004\bT\u0010R¨\u0006X"}, d2 = {"Lcom/bytedance/android/annie/api/container/HybridFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/android/annie/api/card/IHybridComponent;", "", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "Lcom/bytedance/ies/web/jsbridge2/f$b;", "method", "", "registerMethod", "P", "R", "Lcom/bytedance/ies/web/jsbridge2/g;", "", "T", "data", "sendJsEvent", "(Ljava/lang/String;Ljava/lang/Object;)V", "sendJsEventWithCache", "release", "handRelease", "Lcom/bytedance/android/annie/api/card/IHybridComponent$HybridType;", "hybridType", "containerId", com.bytedance.android.ec.core.event.a.KEY_URL, "", "renderData", "load", "Landroid/view/View;", "getHybridView", "updateData", "updateGlobalProps", "", "canBack", "cancelLoading", "title", "setHybridTitle", "titleColor", "setHybridTitleColor", "navBarColor", "setHybridNavBarColor", "statusBarBgColor", "setHybridStatusBarBgColor", "statusFontMode", "setHybridStatusFontMode", "b", "setCloseByGesture", "back", "disableDragDown", "getHybridComponent", "markPendingLoad", "Lcom/bytedance/android/annie/api/container/FragmentCustomMonitorKey;", "key", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "setCustomMonitorKey", "hide", "show", "canBackPresse", "isFullScreen", "closeByReplace", "fromPopup", "closeWithFrom", "enable", "enableClose", "visible", "realVisibleChange", "Lcom/bytedance/android/annie/api/container/HybridFragment$a;", "lifecycleListener", "registerLifecycleListener", "isAnnieXFragment", "<set-?>", "isLoaded", "Z", "()Z", "mAnnieCard", "Lcom/bytedance/android/annie/api/card/IHybridComponent;", "getMAnnieCard", "()Lcom/bytedance/android/annie/api/card/IHybridComponent;", "setMAnnieCard", "(Lcom/bytedance/android/annie/api/card/IHybridComponent;)V", "mSupportLazyLoad", "getMSupportLazyLoad", "setMSupportLazyLoad", "(Z)V", "getMarkPendingLoad", "setMarkPendingLoad", "<init>", "()V", "a", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public abstract class HybridFragment extends Fragment implements IHybridComponent {
    private boolean isLoaded;
    private IHybridComponent mAnnieCard;
    private boolean mSupportLazyLoad;
    private boolean markPendingLoad;

    public interface a {
        void onActivityResult(int r1, int r10, Intent r11);
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ void addOnPreDrawListener() {
    }

    public abstract void back();

    public boolean canBackPresse() {
        return true;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean canGoBack() {
        return false;
    }

    public abstract void cancelLoading();

    public void closeByReplace() {
    }

    public void closeWithFrom(boolean r1) {
    }

    public abstract boolean disableDragDown();

    public void enableClose(boolean r1) {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ void goBack() {
    }

    public boolean isAnnieXFragment() {
        return false;
    }

    public boolean isFullScreen() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean isPopup() {
        return false;
    }

    public void realVisibleChange(boolean r1) {
    }

    public void registerLifecycleListener(a r10) {
        Intrinsics.checkNotNullParameter(r10, "lifecycleListener");
    }

    @Deprecated(message = "没有业务调用，已废弃")
    public abstract <T> void sendJsEventWithCache(String r1, T r10);

    public abstract void setCloseByGesture(boolean r1);

    public abstract void setCustomMonitorKey(FragmentCustomMonitorKey r1, Object r10);

    public abstract void setHybridNavBarColor(String r1);

    public abstract void setHybridStatusBarBgColor(String r1);

    public abstract void setHybridStatusFontMode(String r1);

    public abstract void setHybridTitle(String r1);

    public abstract void setHybridTitleColor(String r1);

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void setOnScrollChangeListener(IHybridComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
    }

    @Override // a7.b
    public /* synthetic */ void setRadius(float r1) {
    }

    @Override // a7.b
    public /* synthetic */ void setRadius(float r1, float r10, float r11, float r12) {
    }

    public final boolean canBack() {
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canGoBack();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public String containerId() {
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L6;
        String r1 = r0.containerId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public View getHybridView() {
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHybridView();
    }

    @Deprecated(message = "不建议使用，请联系@jintai.001", replaceWith = @ReplaceWith(expression = "release()", imports = {}))
    public void handRelease() {
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void hide() {
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L6;
        r0.show();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public IHybridComponent.HybridType hybridType() {
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L7;
        IHybridComponent.HybridType r1 = r0.hybridType();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return IHybridComponent.HybridType.H5;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void release() {
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void show() {
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L6;
        r0.hide();
        return;
    }

    public HybridFragment() {
        this.mSupportLazyLoad = true;
    }

    public final IHybridComponent getHybridComponent() {
        return this.mAnnieCard;
    }

    public final IHybridComponent getMAnnieCard() {
        return this.mAnnieCard;
    }

    public final boolean getMSupportLazyLoad() {
        return this.mSupportLazyLoad;
    }

    public final boolean getMarkPendingLoad() {
        return this.markPendingLoad;
    }

    public final boolean isLoaded() {
        return this.isLoaded;
    }

    public final IHybridComponent getHybridComponent(boolean r10) {
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L5;
    L7:
        return r0;
    L5:
        if (this.isLoaded == true) goto L7;
        this.markPendingLoad = r10;
        goto L7
    }

    public final void setMAnnieCard(IHybridComponent r1) {
        this.mAnnieCard = r1;
    }

    public final void setMSupportLazyLoad(boolean r1) {
        this.mSupportLazyLoad = r1;
    }

    public final void setMarkPendingLoad(boolean r1) {
        this.markPendingLoad = r1;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L6;
        r0.updateData(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void updateGlobalProps(Map<String, ? extends Object> r10) {
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L6;
        r0.updateGlobalProps(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void load(String r10, Map<String, ? extends Object> r11) {
        this.isLoaded = true;
        this.mSupportLazyLoad = false;
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L6;
        r0.load(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void registerMethod(String r10, f.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L6;
        r0.registerMethod(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public <T> void sendJsEvent(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "data");
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L6;
        r0.sendJsEvent(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public <P, R> void registerMethod(String r10, g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        IHybridComponent r0 = this.mAnnieCard;
        if (r0 == null) goto L6;
        r0.registerMethod(r10, r11);
        return;
    }
}
