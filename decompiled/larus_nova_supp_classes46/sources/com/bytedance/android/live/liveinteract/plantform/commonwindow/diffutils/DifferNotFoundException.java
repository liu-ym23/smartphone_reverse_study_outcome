package com.bytedance.android.live.liveinteract.plantform.commonwindow.diffutils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class DifferNotFoundException extends RuntimeException {
    public DifferNotFoundException(Class<?> r3) {
        super("Do you have registered the differ for {className}.class in the DiffTypeTool?".replace("{className}", r3.getSimpleName()));
    }
}
