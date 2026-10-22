package androidx.constraintlayout.core.state;

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

    public String currentContent(String r10) {
        RegistryCallback r11 = this.mCallbacks.get(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.currentMotionScene();
    }

    public String currentLayoutInformation(String r10) {
        RegistryCallback r11 = this.mCallbacks.get(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.currentLayoutInformation();
    }

    public long getLastModified(String r10) {
        RegistryCallback r11 = this.mCallbacks.get(r10);
        if (r11 != null) goto L5;
        return Long.MAX_VALUE;
    L5:
        return r11.getLastModified();
    }

    public Set<String> getLayoutList() {
        return this.mCallbacks.keySet();
    }

    public void register(String r10, RegistryCallback r11) {
        this.mCallbacks.put(r10, r11);
    }

    public void setDrawDebug(String r10, int r11) {
        RegistryCallback r12 = this.mCallbacks.get(r10);
        if (r12 == null) goto L6;
        r12.setDrawDebug(r11);
        return;
    }

    public void setLayoutInformationMode(String r10, int r11) {
        RegistryCallback r12 = this.mCallbacks.get(r10);
        if (r12 == null) goto L6;
        r12.setLayoutInformationMode(r11);
        return;
    }

    public void unregister(String r10, RegistryCallback r11) {
        this.mCallbacks.remove(r10);
    }

    public void updateContent(String r10, String r11) {
        RegistryCallback r12 = this.mCallbacks.get(r10);
        if (r12 == null) goto L6;
        r12.onNewMotionScene(r11);
        return;
    }

    public void updateDimensions(String r10, int r11, int r12) {
        RegistryCallback r13 = this.mCallbacks.get(r10);
        if (r13 == null) goto L6;
        r13.onDimensions(r11, r12);
        return;
    }

    public void updateProgress(String r10, float r11) {
        RegistryCallback r12 = this.mCallbacks.get(r10);
        if (r12 == null) goto L6;
        r12.onProgress(r11);
        return;
    }
}
