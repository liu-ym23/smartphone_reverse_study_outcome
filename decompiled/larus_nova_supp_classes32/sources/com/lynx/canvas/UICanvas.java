package com.lynx.canvas;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.krypton.ICanvasManager;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonModule;
import com.lynx.tasm.behavior.ui.utils.h;
import com.lynx.tasm.event.LynxEventDetail;
import com.miui.easygo.constant.EasyGoDbTable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UICanvas extends LynxUI<UICanvasView> {
    private static final int MAX_POINTER_COUNT = 5;
    private static final String TAG = "UICanvas";
    private static final int TOUCH_EVENT_BUFFER_SIZE = 112;
    private String mName;

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean dispatchEvent(LynxEventDetail r1) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public Map<String, String> getMemoryUsageDetail() {
        T r0 = this.mView;
        if (r0 != 0) goto L7;
        return null;
    L7:
        return ((UICanvasView) r0).getMemoryUsageDetail();
    }

    private CanvasManager getOrTryCreateCanvasManager() {
        getLynxContext();
        LynxKryptonModule r0 = (LynxKryptonModule) getLynxContext().getExtensionModuleByKey(LynxKryptonModule.TAG);
        if (r0 != null) goto L5;
        return null;
    L5:
        LynxKryptonHelper r1 = r0.getLynxKryptonHelper();
        if (r1 != null) goto L8;
        return null;
    L8:
        ICanvasManager r2 = r1.getCanvasManager();
        if (r2 == null) goto L12;
        LLog.i(TAG, "Canvas manager is already created.");
        return (CanvasManager) r2;
    L12:
        LLog.i(TAG, "Setup canvas environment from UICanvas in lazy mode.");
        r1.setupCanvasIfCanvasViewCreated();
        return (CanvasManager) r1.getCanvasManager();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        ((UICanvasView) this.mView).destroy();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public long getMemoryUsageBytes() {
        long r0 = super.getMemoryUsageBytes();
        T r2 = this.mView;
        if (r2 != 0) goto L6;
        return r0;
    L6:
        return r0 + ((UICanvasView) r2).getMemoryUsageBytes();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void layout() {
        super.layout();
        Rect r0 = getBoundingClientRect();
        ((UICanvasView) this.mView).notifyLayout(r0);
    }

    public UICanvas(LynxContext r2) {
        this(r2, null);
    }

    private int px2dip(float r2) {
        return (int) ((r2 / ((UICanvasView) this.mView).getScale()) + 0.5f);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public UICanvasView createView(Context r2) {
        if (getOrTryCreateCanvasManager() == null) goto L7;
        UICanvasView r0 = new UICanvasView(r2);
        this.mView = r0;
        return r0;
    L7:
        throw new RuntimeException("Canvas environment has not setup!!");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean dispatchTouch(MotionEvent r11) {
        int r1 = 0;
        if (isUserInteractionEnabled() == false) goto L20;
        LynxContext r0 = getLynxContext();
        UIBody r2 = r0.getUIBody();
        if (r0.getEnableTransformedTouchPosition() == false) goto L19;
        int r3 = r11.getActionIndex();
        int r4 = 5;
        if (r3 < 5) goto L9;
        return false;
    L9:
        int r5 = r11.getPointerCount();
        if (r5 > 5) goto L13;
        r4 = r5;
    L13:
        PointF r6 = h.b(this, new PointF(0.0f, 0.0f));
        ByteBuffer r7 = ByteBuffer.allocateDirect(112);
        float r8 = ((UICanvasView) this.mView).getScale();
        r7.order(ByteOrder.LITTLE_ENDIAN);
        r7.clear();
        r7.put((byte) r11.getActionMasked()).put((byte) r4).put((byte) r3).put((byte) 1).putInt(px2dip((int) r6.x)).putInt(px2dip((int) r6.y));
        float r9 = r11.getRawX() - r11.getX();
        float r10 = r11.getRawY() - r11.getY();
    L14:
        if (r1 >= r4) goto L17;
        PointF r12 = h.a(r2, this, new PointF(r11.getX(r1), r11.getY(r1)));
        r7.putInt(r11.getPointerId(r1)).putFloat(r12.x / r8).putFloat(r12.y / r8).putFloat((r11.getX(r1) + r9) / r8).putFloat((r11.getY(r1) + r10) / r8);
        r1 = r1 + 1;
        goto L14
    L17:
        return ((UICanvasView) this.mView).dispatchTransformedTouch(r7);
    L19:
        return ((UICanvasView) this.mView).dispatchTouch(r11, r2.getBoundingClientRect(), getBoundingClientRect());
    L20:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = EasyGoDbTable.Server.NAME)
    public void setName(String r3) {
        super.setName(r3);
        LynxKryptonModule r0 = (LynxKryptonModule) getLynxContext().getExtensionModuleByKey(LynxKryptonModule.TAG);
        if (r0 != null) goto L5;
        return;
    L5:
        LynxKryptonHelper r1 = r0.getLynxKryptonHelper();
        if (r3 == null) goto L13;
        if (r1 == null) goto L15;
        ((UICanvasView) this.mView).setup(r3, ((CanvasManager) r1.getCanvasManager()).getKryptonApp());
        if (this.mName != null) goto L14;
        this.mName = r3;
        String r4 = "url:" + getLynxContext().getTemplateUrl() + ", tag_name:" + r3;
        LLog.i(TAG, "set tag to canvas view: " + r4);
        ((UICanvasView) this.mView).setTag(r4);
        return;
    L14:
        return;
    L15:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return createView(r1);
    }

    public UICanvas(LynxContext r1, Object r2) {
        super(r1, r2);
    }
}
