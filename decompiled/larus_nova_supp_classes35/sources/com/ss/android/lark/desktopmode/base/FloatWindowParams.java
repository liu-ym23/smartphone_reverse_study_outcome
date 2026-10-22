package com.ss.android.lark.desktopmode.base;

import android.content.DialogInterface;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FloatWindowParams extends FragmentParams {
    private final int bgResId;
    private final List<Integer> coordination;
    private float dimAmount;
    private final String floatTag;
    private final int gravity;
    private final boolean isCancelable;
    private boolean isFloatStackBase;
    private DialogInterface.OnClickListener outsideClickListener;
    private boolean showTriangle;
    private final List<Integer> windowSize;

    public static final class a extends FragmentParams.a<a, FloatWindowParams> {
    }

    public int getBgResId() {
        return this.bgResId;
    }

    public List<Integer> getCoordination() {
        return this.coordination;
    }

    public float getDimAmount() {
        return this.dimAmount;
    }

    public String getFloatTag() {
        return this.floatTag;
    }

    public int getGravity() {
        return this.gravity;
    }

    public DialogInterface.OnClickListener getOutsideClickListener() {
        return this.outsideClickListener;
    }

    public List<Integer> getWindowSize() {
        return this.windowSize;
    }

    public boolean isCancelable() {
        return this.isCancelable;
    }

    public boolean isFloatStackBase() {
        return this.isFloatStackBase;
    }

    public boolean isShowTriangle() {
        return this.showTriangle;
    }

    public FloatWindowParams(FloatWindowParams r3) {
        super(r3.containerType, false);
        this.gravity = r3.gravity;
        this.coordination = r3.coordination;
        this.windowSize = r3.windowSize;
        this.isCancelable = r3.isCancelable;
        this.dimAmount = r3.dimAmount;
        this.showTriangle = r3.showTriangle;
        this.floatTag = r3.floatTag;
        this.bgResId = r3.bgResId;
        this.outsideClickListener = r3.outsideClickListener;
    }

    public void setFloatStackBase(boolean r1) {
        this.isFloatStackBase = r1;
    }

    public FloatWindowParams(a r1) {
        throw null;
    }

    public FloatWindowParams(int r2, ContainerType r3, List<Integer> r4, List<Integer> r5, boolean r6, float r7, boolean r8, String r9, int r10, DialogInterface.OnClickListener r11) {
        super(r3, false);
        this.gravity = r2;
        this.coordination = r4;
        this.windowSize = r5;
        this.isCancelable = r6;
        this.dimAmount = r7;
        this.showTriangle = r8;
        this.floatTag = r9;
        this.bgResId = r10;
        this.outsideClickListener = r11;
    }
}
