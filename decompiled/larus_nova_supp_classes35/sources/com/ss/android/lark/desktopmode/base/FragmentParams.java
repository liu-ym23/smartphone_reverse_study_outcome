package com.ss.android.lark.desktopmode.base;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FragmentParams implements Serializable {
    protected final ContainerType containerType;
    protected boolean needBringToFront;

    public static abstract class a<T extends a, S extends FragmentParams> {
    }

    public ContainerType getContainerType() {
        return this.containerType;
    }

    public boolean isBringToFront() {
        return this.needBringToFront;
    }

    public FragmentParams(ContainerType r1, boolean r2) {
        this.containerType = r1;
        this.needBringToFront = r2;
    }
}
