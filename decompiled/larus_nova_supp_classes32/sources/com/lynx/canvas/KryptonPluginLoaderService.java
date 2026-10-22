package com.lynx.canvas;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class KryptonPluginLoaderService extends KryptonService {

    public interface Callback {
        void onFinish(boolean r1, String r2);
    }

    public abstract ClassLoader getClassLoader(String r1);

    public abstract String getPluginPath(String r1);

    public abstract void loadPluginAsync(String r1, Callback r2);

    public abstract boolean loadPluginSync(String r1);

    public KryptonPluginLoaderService() {
    }
}
