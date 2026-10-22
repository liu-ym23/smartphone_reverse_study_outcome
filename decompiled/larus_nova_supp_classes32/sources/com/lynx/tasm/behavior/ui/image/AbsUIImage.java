package com.lynx.tasm.behavior.ui.image;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class AbsUIImage<T extends View> extends LynxUI<T> {
    @LynxProp(name = "auto-size")
    public void setAutoSize(boolean r1) {
    }

    @LynxProp(name = "blur-radius")
    public abstract void setBlurRadius(String r1);

    @LynxProp(name = "capInsets")
    public abstract void setCapInsets(String r1);

    @LynxProp(name = "cap-insets")
    public void setCapInsetsBackUp(String r1) {
    }

    @LynxProp(name = "cap-insets-scale")
    public void setCapInsetsScale(String r1) {
    }

    @LynxProp(defaultBoolean = false, name = "cover-start")
    public abstract void setCoverStart(boolean r1);

    @LynxProp(defaultBoolean = false, name = "disable-default-placeholder")
    public void setDisableDefaultPlaceholder(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "disable-default-resize")
    public void setDisableDefaultResize(boolean r1) {
    }

    @LynxProp(name = "loop-count")
    public abstract void setLoopCount(int r1);

    @LynxProp(name = "mode")
    public abstract void setObjectFit(String r1);

    @LynxProp(name = "placeholder")
    public abstract void setPlaceholder(String r1);

    @LynxProp(name = "prefetch-height")
    public abstract void setPreFetchHeight(String r1);

    @LynxProp(name = "prefetch-width")
    public abstract void setPreFetchWidth(String r1);

    @LynxProp(defaultBoolean = false, name = "repeat")
    public abstract void setRepeat(boolean r1);

    @LynxProp(name = LynxError.LYNX_ERROR_KEY_RESOURCE_URL)
    public abstract void setSource(String r1);

    public AbsUIImage(Context r1) {
        super(r1);
    }

    public AbsUIImage(LynxContext r1) {
        super(r1);
    }

    public AbsUIImage(LynxContext r1, Object r2) {
        super(r1, r2);
    }
}
