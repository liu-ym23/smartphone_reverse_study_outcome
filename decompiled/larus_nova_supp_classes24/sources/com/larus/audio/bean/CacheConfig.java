package com.larus.audio.bean;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/audio/bean/CacheConfig;", "Ljava/io/Serializable;", "textType", "", "useCache", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getTextType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUseCache", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "msgOwnerId", "", "getMsgOwnerId", "()Ljava/lang/String;", "setMsgOwnerId", "(Ljava/lang/String;)V", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CacheConfig implements Serializable {
    private String msgOwnerId;

    @SerializedName("text_type")
    private final Integer textType;

    @SerializedName("use_cache")
    private final Boolean useCache;

    /* JADX WARN: Multi-variable type inference failed */
    public CacheConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public final String getMsgOwnerId() {
        return this.msgOwnerId;
    }

    public final Integer getTextType() {
        return this.textType;
    }

    public final Boolean getUseCache() {
        return this.useCache;
    }

    public final void setMsgOwnerId(String r1) {
        this.msgOwnerId = r1;
    }

    public CacheConfig(Integer r1, Boolean r2) {
        this.textType = r1;
        this.useCache = r2;
        this.msgOwnerId = "";
    }

    public /* synthetic */ CacheConfig(Integer r1, Boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = Boolean.FALSE;
    L8:
        this(r1, r2);
    }
}
