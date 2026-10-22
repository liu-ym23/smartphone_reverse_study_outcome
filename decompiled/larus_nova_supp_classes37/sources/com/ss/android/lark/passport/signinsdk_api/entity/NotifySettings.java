package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class NotifySettings implements Serializable {
    private boolean disableMobileNotify;
    private boolean stillNotifyAt;
    private boolean stillNotifySpecialFocus;

    public NotifySettings() {
    }

    public boolean isDisableMobileNotify() {
        return this.disableMobileNotify;
    }

    public boolean isStillNotifyAt() {
        return this.stillNotifyAt;
    }

    public boolean isStillNotifySpecialFocus() {
        return this.stillNotifySpecialFocus;
    }

    public void setDisableMobileNotify(boolean r1) {
        this.disableMobileNotify = r1;
    }

    public void setStillNotifyAt(boolean r1) {
        this.stillNotifyAt = r1;
    }

    public void setStillNotifySpecialFocus(boolean r1) {
        this.stillNotifySpecialFocus = r1;
    }
}
