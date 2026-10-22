package c7;

import android.os.Bundle;
import b7.b;
import com.bytedance.android.annie.api.param.AnnieViewType;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class a {
    private int annieIsCard;
    private int annieIsPreRender;
    private final Bundle bundle;
    private b commonLifecycle;
    private String containerId;
    private boolean isFromFlow;
    private volatile String monitorID;
    private String type;
    private String url;
    private final String uuid;
    private AnnieViewType viewType;

    private final String generateID() {
        StringBuilder r0 = new StringBuilder();
        r0.append(System.currentTimeMillis());
        r0.append('-');
        r0.append(UUID.randomUUID());
        return r0.toString();
    }

    public final String getBizKey() {
        Bundle r1 = this.bundle;     // Catch: Throwable -> L10
        if (r1 == null) goto L13;
        String r10 = r1.getString("biz_key");     // Catch: Throwable -> L10
        if (r10 != null) goto L9;
        return "host";
    L9:
        return r10;
    L13:
        return "host";
    L15:
        return "host";
    }

    public final int getAnnieIsCard() {
        return this.annieIsCard;
    }

    public final int getAnnieIsPreRender() {
        return this.annieIsPreRender;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final b getCommonLifecycle() {
        return this.commonLifecycle;
    }

    public final String getContainerId() {
        return this.containerId;
    }

    public final String getMonitorID() {
        return this.monitorID;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final AnnieViewType getViewType() {
        return this.viewType;
    }

    public final boolean isFromFlow() {
        return this.isFromFlow;
    }

    public final void setAnnieIsCard(int r1) {
        this.annieIsCard = r1;
    }

    public final void setAnnieIsPreRender(int r1) {
        this.annieIsPreRender = r1;
    }

    public final void setCommonLifecycle(b r1) {
        this.commonLifecycle = r1;
    }

    public final void setContainerId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.containerId = r10;
    }

    public final void setFromFlow(boolean r1) {
        this.isFromFlow = r1;
    }

    public final void setMonitorID(String r1) {
        this.monitorID = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setViewType(AnnieViewType r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.viewType = r10;
    }

    public a(b r1, Bundle r10, String r11) {
        this.commonLifecycle = r1;
        this.bundle = r10;
        this.type = "";
        this.viewType = AnnieViewType.CARD;
        this.annieIsCard = -1;
        String r12 = generateID();
        this.containerId = r12;
        if (r11 != null) goto L5;
        r11 = r12;
    L5:
        this.uuid = r11;
    }
}
