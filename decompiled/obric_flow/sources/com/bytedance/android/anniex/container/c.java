package com.bytedance.android.anniex.container;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.bytedance.ies.bullet.core.kit.bridge.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3138a;

    public /* synthetic */ c(int r5) {
        this.f3138a = r5;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final String getName() {
        switch(this.f3138a) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return "H5_tapWebMaskView";
    L6:
        return "H5_tapWebMaskView";
    L8:
        return "viewDisappeared";
    L10:
        return "viewAppeared";
    L12:
        return "on_key_back";
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final Object getParams() {
        switch(this.f3138a) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return null;
    L6:
        return null;
    L9:
        return new JSONObject();
    L11:
        return new JSONObject();
    L13:
        return new JSONObject();
    }
}
