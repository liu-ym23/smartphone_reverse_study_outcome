package com.lynx.debugrouter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NativeSlotDelegate {
    private DebugRouterSlot slot;
    private String type;
    private String url;

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public NativeSlotDelegate(DebugRouterSlot r2) {
        this.slot = r2;
        this.url = r2.getTemplateUrl();
        this.type = r2.getType();
    }

    public void onMessage(String r2, String r3) {
        DebugRouterSlot r0 = this.slot;
        if (r0 == null) goto L6;
        r0.onMessage(r2, r3);
        return;
    }
}
