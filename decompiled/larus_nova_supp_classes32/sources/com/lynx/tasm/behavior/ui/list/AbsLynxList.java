package com.lynx.tasm.behavior.ui.list;

import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.g;
import com.lynx.tasm.l;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class AbsLynxList<T extends ViewGroup> extends UISimpleView<T> {
    public final g a;
    public LynxBaseUI b;

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean isScrollable() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public void onInsertChild(LynxBaseUI r1, int r2) {
    }

    @LynxProp(customType = "1", name = "cache-queue-ratio")
    public abstract void setCacheQueueRatio(f6a.a r1);

    @LynxProp(defaultInt = 1, name = "column-count")
    public abstract void setColumnCount(int r1);

    @LynxProp(defaultBoolean = false, name = "component-init-measure")
    public abstract void setComponentInitMeasure(boolean r1);

    @LynxProp(customType = "0", name = "list-cross-axis-gap")
    public abstract void setCrossAxisGap(float r1);

    @LynxProp(customType = "false", name = "paging-enabled")
    public abstract void setEnablePagerSnap(f6a.a r1);

    @LynxProp(name = "sticky")
    public abstract void setEnableSticky(f6a.a r1);

    @LynxProp(customType = "0", name = "initial-scroll-index")
    public abstract void setInitialScrollIndex(f6a.a r1);

    @LynxProp(defaultBoolean = false, name = "internal-cell-appear-notification")
    public void setInternalCellAppearNotification(boolean r1) {
    }

    @LynxProp(defaultBoolean = false, name = "internal-cell-disappear-notification")
    public void setInternalCellDisappearNotification(boolean r1) {
    }

    @LynxProp(defaultBoolean = false, name = "internal-cell-prepare-for-reuse-notification")
    public void setInternalCellPrepareForReuseNotification(boolean r1) {
    }

    @LynxProp(customType = "single", name = "list-type")
    public abstract void setListType(String r1);

    @LynxProp(defaultInt = MessageContentType.CARD, name = "lower-threshold")
    public abstract void setLowerThreshold(f6a.a r1);

    @LynxProp(defaultInt = 0, name = "lower-threshold-item-count")
    public void setLowerThresholdItemCount(f6a.a r1) {
    }

    @LynxProp(customType = "0", name = "list-main-axis-gap")
    public abstract void setMainAxisGap(float r1);

    @LynxProp(defaultBoolean = false, name = "needs-visible-cells")
    public abstract void setNeedVisibleCells(boolean r1);

    @LynxProp(defaultBoolean = false, name = "no-invalidate")
    public abstract void setNoInvalidate(boolean r1);

    @LynxProp(name = "item-snap")
    public abstract void setPagingAlignment(ReadableMap r1);

    @LynxProp(customType = "true", name = "enable-scroll")
    public abstract void setScrollEnable(f6a.a r1);

    @LynxProp(customType = "200", name = "scroll-event-throttle")
    public abstract void setScrollEventThrottle(f6a.a r1);

    @LynxProp(customType = "10", name = "scroll-state-change-event-throttle")
    public abstract void setScrollStateChangeEventThrottle(String r1);

    @LynxProp(customType = "false", name = "scroll-x")
    public abstract void setScrollX(f6a.a r1);

    @LynxProp(customType = "true", name = "scroll-y")
    public abstract void setScrollY(f6a.a r1);

    @LynxProp(defaultBoolean = false, name = "should-request-state-restore")
    public void setShouldRequestStateRestore(boolean r1) {
    }

    @LynxProp(defaultInt = 0, name = "sticky-offset")
    public abstract void setStickyOffset(f6a.a r1);

    @LynxProp(customType = "true", name = "touch-scroll")
    public abstract void setTouchScroll(f6a.a r1);

    @LynxProp(customType = VoiceDisplayScene.NONE, name = "update-animation")
    public abstract void setUpdateAnimation(String r1);

    @LynxProp(defaultInt = MessageContentType.CARD, name = "upper-threshold")
    public abstract void setUpperThreshold(f6a.a r1);

    @LynxProp(defaultInt = 0, name = "upper-threshold-item-count")
    public void setUpperThresholdItemCount(f6a.a r1) {
    }

    public final void N(LynxUI r3) {
        g r0 = this.a;
        l r1 = (l) r0;
        r1.e(getSign(), r3.getSign());
    }

    @LynxProp(customType = "false", name = "over-scroll")
    public void setOverScroll(f6a.a r3) {
        ReadableType r0 = r3.getType();
        if (r0 != ReadableType.String) goto L6;
        boolean r4 = "true".equals(r3.asString());
    L9:
        if (r4 == false) goto L11;
        ((ViewGroup) this.mView).setOverScrollMode(0);
        return;
    L11:
        ((ViewGroup) this.mView).setOverScrollMode(2);
        return;
    L6:
        if (r0 != ReadableType.Boolean) goto L8;
        r4 = r3.asBoolean();
        goto L9
    L8:
        r4 = true;
        goto L9
    }

    public AbsLynxList(LynxContext r1, Object r2) {
        super(r1, r2);
        this.a = r1.getListNodeInfoFetcher();
        this.b = null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r3, int r4) {
        this.b = r3;
        r3.setParent(this);
        List<LynxBaseUI> r0 = this.mChildren;
        ListProtector.add(r0, r0.size(), r3);
        onInsertChild(r3, r4);
    }

    public final UIComponent M(int r8, long r9, boolean r11) {
        g r0 = this.a;
        l r1 = (l) r0;
        int r10 = r1.c(getSign(), r8, r9, r11);
        if (r10 <= 0) goto L10;
        LynxBaseUI r12 = this.mContext.findLynxUIBySign(r10);
        if (r12 != null) goto L7;
        return null;
    L7:
        if ((r12 instanceof UIComponent) == true) goto L9;
        return null;
    L9:
        return (UIComponent) r12;
    L10:
        return null;
    }
}
