package com.lynx.clay.embedding.engine.loader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class ResourceLoader {
    public ResourceLoader() {
    }

    public abstract void cancelAll(boolean r1);

    public void load(int r1, String r2, ResourceLoaderCallback r3, boolean r4, boolean r5) {
    }

    private void load(int r7, String r8, long r9, boolean r11, boolean r12) {
        load(r7, r8, new ResourceLoaderCallback(r9), r11, r12);
    }
}
