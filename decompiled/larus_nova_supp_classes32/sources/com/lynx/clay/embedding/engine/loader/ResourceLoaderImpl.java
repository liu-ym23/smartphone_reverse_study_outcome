package com.lynx.clay.embedding.engine.loader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ResourceLoaderImpl extends ResourceLoader {
    static String LOADER_EMPTY_ERR = "The resource Loader is not configured on the service side";
    static c sProvider;
    FrescoImageLoader mImageLoader;
    b mLoader;

    public static class a implements c {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract void cancelAll(boolean r1);

        public void load(int r1, String r2, ResourceLoaderCallback r3, boolean r4, boolean r5) {
        }

        public void loadAsFile(String r1, d r2, boolean r3) {
        }
    }

    public interface c {
    }

    public static ResourceLoaderImpl create() {
        return new ResourceLoaderImpl();
    }

    public ResourceLoaderImpl() {
        b r0 = null;
        this.mLoader = null;
        this.mImageLoader = null;
        c r1 = sProvider;
        if (r1 == null) goto L5;
        r0 = ((a) r1).a;
    L5:
        this.mLoader = r0;
    }

    public static void SetResourceLoader(b r1) {
        sProvider = new a(r1);
    }

    public static void SetResourceLoaderProvider(c r0) {
        sProvider = r0;
    }

    @Override // com.lynx.clay.embedding.engine.loader.ResourceLoader
    public void cancelAll(boolean r2) {
        FrescoImageLoader r0 = this.mImageLoader;
        if (r0 == null) goto L5;
        r0.cancelAll(r2);
    L5:
        b r1 = this.mLoader;
        if (r1 == null) goto L9;
        r1.cancelAll(r2);
        return;
    }

    public void loadAsFile(String r2, d r3, boolean r4) {
        b r0 = this.mLoader;
        if (r0 == null) goto L5;
        r0.loadAsFile(r2, r3, r4);
        return;
    L5:
        h5a.a r5 = (h5a.a) r3;
        r5.a(LOADER_EMPTY_ERR);
    }

    @Override // com.lynx.clay.embedding.engine.loader.ResourceLoader
    public void load(int r7, String r8, ResourceLoaderCallback r9, boolean r10, boolean r11) {
        b r0 = this.mLoader;
        if (r0 == null) goto L5;
        r0.load(r7, r8, r9, r10, r11);
        return;
    L5:
        r9.onFailed(LOADER_EMPTY_ERR);
    }
}
