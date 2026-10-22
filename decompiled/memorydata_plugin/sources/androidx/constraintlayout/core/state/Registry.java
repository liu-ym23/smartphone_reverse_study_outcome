package androidx.constraintlayout.core.state;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Registry {
    private static final Registry sRegistry = null;
    private HashMap<String, RegistryCallback> mCallbacks;

    static {
        sRegistry = new Registry();
    }

    public Registry() {
        this.mCallbacks = new HashMap();
    }

    public static Registry getInstance() {
        return sRegistry;
    }

    public String currentContent(String r2) {
        RegistryCallback r1 = (RegistryCallback) ZeusTransformUtils.preCheckCast(this.mCallbacks.get(r2), RegistryCallback.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.currentMotionScene();
    }

    public String currentLayoutInformation(String r2) {
        RegistryCallback r1 = (RegistryCallback) ZeusTransformUtils.preCheckCast(this.mCallbacks.get(r2), RegistryCallback.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.currentLayoutInformation();
    }

    public long getLastModified(String r2) {
        RegistryCallback r1 = (RegistryCallback) ZeusTransformUtils.preCheckCast(this.mCallbacks.get(r2), RegistryCallback.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return Long.MAX_VALUE;
    L5:
        return r1.getLastModified();
    }

    public Set<String> getLayoutList() {
        return this.mCallbacks.keySet();
    }

    public void register(String r3, RegistryCallback r4) {
        RegistryCallback r5 = (RegistryCallback) ZeusTransformUtils.wrapperContextForParams(r4, RegistryCallback.class, "com.obric.memorydata.plugin");
        this.mCallbacks.put(r3, r5);
    }

    public void setDrawDebug(String r2, int r3) {
        RegistryCallback r1 = (RegistryCallback) ZeusTransformUtils.preCheckCast(this.mCallbacks.get(r2), RegistryCallback.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.setDrawDebug(r3);
        return;
    }

    public void setLayoutInformationMode(String r2, int r3) {
        RegistryCallback r1 = (RegistryCallback) ZeusTransformUtils.preCheckCast(this.mCallbacks.get(r2), RegistryCallback.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.setLayoutInformationMode(r3);
        return;
    }

    public void unregister(String r3, RegistryCallback r4) {
        RegistryCallback r5 = (RegistryCallback) ZeusTransformUtils.wrapperContextForParams(r4, RegistryCallback.class, "com.obric.memorydata.plugin");
        this.mCallbacks.remove(r3);
    }

    public void updateContent(String r2, String r3) {
        RegistryCallback r1 = (RegistryCallback) ZeusTransformUtils.preCheckCast(this.mCallbacks.get(r2), RegistryCallback.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.onNewMotionScene(r3);
        return;
    }

    public void updateDimensions(String r2, int r3, int r4) {
        RegistryCallback r1 = (RegistryCallback) ZeusTransformUtils.preCheckCast(this.mCallbacks.get(r2), RegistryCallback.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.onDimensions(r3, r4);
        return;
    }

    public void updateProgress(String r2, float r3) {
        RegistryCallback r1 = (RegistryCallback) ZeusTransformUtils.preCheckCast(this.mCallbacks.get(r2), RegistryCallback.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.onProgress(r3);
        return;
    }
}
