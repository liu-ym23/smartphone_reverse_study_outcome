package com.larus.audio.audiov3.config;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/audiov3/config/NetworkStatus;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "WEB_SOCKET_NORMAL", "WEB_SOCKET_CHANGE_FAIL", "WEB_SOCKET_CONNECTION_FAIL", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum NetworkStatus extends Enum<NetworkStatus> {
    public static final NetworkStatus WEB_SOCKET_CHANGE_FAIL = null;
    public static final NetworkStatus WEB_SOCKET_CONNECTION_FAIL = null;
    public static final NetworkStatus WEB_SOCKET_NORMAL = null;
    public static final /* synthetic */ NetworkStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int code;

    public static EnumEntries<NetworkStatus> getEntries() {
        return b;
    }

    static {
        NetworkStatus r0 = new NetworkStatus("WEB_SOCKET_NORMAL", 0, 1);
        WEB_SOCKET_NORMAL = r0;
        NetworkStatus r1 = new NetworkStatus("WEB_SOCKET_CHANGE_FAIL", 1, 2);
        WEB_SOCKET_CHANGE_FAIL = r1;
        NetworkStatus r4 = new NetworkStatus("WEB_SOCKET_CONNECTION_FAIL", 2, 3);
        WEB_SOCKET_CONNECTION_FAIL = r4;
        NetworkStatus[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static NetworkStatus[] values() {
        return (NetworkStatus[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static NetworkStatus valueOf(String r1) {
        return (NetworkStatus) a.a(NetworkStatus.class, r1);
    }

    public NetworkStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }
}
