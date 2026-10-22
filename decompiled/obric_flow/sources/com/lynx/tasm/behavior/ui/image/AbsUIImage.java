package com.lynx.tasm.behavior.ui.image;

import android.view.View;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsUIImage<T extends View> extends LynxUI<T> {
    @c0(name = "auto-size")
    public void setAutoSize(boolean r5) {
    }

    @c0(name = "blur-radius")
    public abstract void setBlurRadius(String r5);

    @c0(name = "capInsets")
    public abstract void setCapInsets(String r5);

    @c0(name = "cap-insets")
    public void setCapInsetsBackUp(String r5) {
    }

    @c0(name = "cap-insets-scale")
    public void setCapInsetsScale(String r5) {
    }

    @c0(defaultBoolean = false, name = "cover-start")
    public abstract void setCoverStart(boolean r5);

    @c0(defaultBoolean = false, name = "disable-default-placeholder")
    public void setDisableDefaultPlaceholder(boolean r5) {
    }

    @c0(name = "disable-default-resize")
    public void setDisableDefaultResize(boolean r5) {
    }

    @c0(name = "loop-count")
    public abstract void setLoopCount(int r5);

    @c0(name = "mode")
    public abstract void setObjectFit(String r5);

    @c0(name = "placeholder")
    public abstract void setPlaceholder(String r5);

    @c0(name = "prefetch-height")
    public abstract void setPreFetchHeight(String r5);

    @c0(name = "prefetch-width")
    public abstract void setPreFetchWidth(String r5);

    @c0(defaultBoolean = false, name = "repeat")
    public abstract void setRepeat(boolean r5);

    @c0(name = "src")
    public abstract void setSource(String r5);
}
