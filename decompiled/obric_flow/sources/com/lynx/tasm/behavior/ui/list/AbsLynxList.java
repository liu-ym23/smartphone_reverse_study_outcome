package com.lynx.tasm.behavior.ui.list;

import android.view.ViewGroup;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.i;
import java.util.List;
import pm.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsLynxList<T extends ViewGroup> extends UISimpleView<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f10502a;

    public AbsLynxList(b0 r5, z r10) {
        super(r5, r10);
        this.f10502a = r5.f10141i;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        r5.setParent(this);
        List<LynxBaseUI> r11 = this.mChildren;
        r11.add(r11.size(), r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollable() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public void onInsertChild(LynxBaseUI r5, int r10) {
    }

    @c0(customType = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, name = "cache-queue-ratio")
    public abstract void setCacheQueueRatio(a r5);

    @c0(defaultInt = 1, name = "column-count")
    public abstract void setColumnCount(int r5);

    @c0(defaultBoolean = false, name = "component-init-measure")
    public abstract void setComponentInitMeasure(boolean r5);

    @c0(customType = "0", name = "list-cross-axis-gap")
    public abstract void setCrossAxisGap(float r5);

    @c0(customType = "false", name = "paging-enabled")
    public abstract void setEnablePagerSnap(a r5);

    @c0(name = "sticky")
    public abstract void setEnableSticky(a r5);

    @c0(customType = "0", name = "initial-scroll-index")
    public abstract void setInitialScrollIndex(a r5);

    @c0(defaultBoolean = false, name = "internal-cell-appear-notification")
    public void setInternalCellAppearNotification(boolean r5) {
    }

    @c0(defaultBoolean = false, name = "internal-cell-disappear-notification")
    public void setInternalCellDisappearNotification(boolean r5) {
    }

    @c0(defaultBoolean = false, name = "internal-cell-prepare-for-reuse-notification")
    public void setInternalCellPrepareForReuseNotification(boolean r5) {
    }

    @c0(customType = "single", name = "list-type")
    public abstract void setListType(String r5);

    @c0(defaultInt = 50, name = "lower-threshold")
    public abstract void setLowerThreshold(a r5);

    @c0(defaultInt = 0, name = "lower-threshold-item-count")
    public void setLowerThresholdItemCount(a r5) {
    }

    @c0(customType = "0", name = "list-main-axis-gap")
    public abstract void setMainAxisGap(float r5);

    @c0(defaultBoolean = false, name = "needs-visible-cells")
    public abstract void setNeedVisibleCells(boolean r5);

    @c0(defaultBoolean = false, name = "no-invalidate")
    public abstract void setNoInvalidate(boolean r5);

    @c0(customType = "false", name = "over-scroll")
    public void setOverScroll(a r5) {
        ReadableType r10 = r5.getType();
        if (r10 != ReadableType.String) goto L6;
        boolean r11 = "true".equals(r5.asString());
    L9:
        if (r11 == false) goto L12;
        ((ViewGroup) this.mView).setOverScrollMode(0);
        return;
    L12:
        ((ViewGroup) this.mView).setOverScrollMode(2);
        return;
    L6:
        if (r10 != ReadableType.Boolean) goto L8;
        r11 = r5.asBoolean();
        goto L9
    L8:
        r11 = true;
        goto L9
    }

    @c0(name = "item-snap")
    public abstract void setPagingAlignment(ReadableMap r5);

    @c0(customType = "true", name = "enable-scroll")
    public abstract void setScrollEnable(a r5);

    @c0(customType = "200", name = "scroll-event-throttle")
    public abstract void setScrollEventThrottle(a r5);

    @c0(customType = "10", name = "scroll-state-change-event-throttle")
    public abstract void setScrollStateChangeEventThrottle(String r5);

    @c0(customType = "false", name = "scroll-x")
    public abstract void setScrollX(a r5);

    @c0(customType = "true", name = "scroll-y")
    public abstract void setScrollY(a r5);

    @c0(defaultBoolean = false, name = "should-request-state-restore")
    public void setShouldRequestStateRestore(boolean r5) {
    }

    @c0(defaultInt = 0, name = "sticky-offset")
    public abstract void setStickyOffset(a r5);

    @c0(customType = "true", name = "touch-scroll")
    public abstract void setTouchScroll(a r5);

    @c0(customType = "none", name = "update-animation")
    public abstract void setUpdateAnimation(String r5);

    @c0(defaultInt = 50, name = "upper-threshold")
    public abstract void setUpperThreshold(a r5);

    @c0(defaultInt = 0, name = "upper-threshold-item-count")
    public void setUpperThresholdItemCount(a r5) {
    }
}
