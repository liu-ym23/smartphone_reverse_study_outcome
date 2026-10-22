package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\bg\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003%&'R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\"\u0010\u001f\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\"\u0010#\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\u0006¨\u0006("}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "Lvh7/c;", "", "getPosition", "()J", "setPosition", "(J)V", "getPosition$annotations", "()V", "position", "", "getStatus", "()I", "setStatus", "(I)V", "getStatus$annotations", "status", "", "getActiveName", "()Ljava/lang/String;", "setActiveName", "(Ljava/lang/String;)V", "getActiveName$annotations", "activeName", "getVerifyStatus", "setVerifyStatus", "getVerifyStatus$annotations", "verifyStatus", "getPositionType", "setPositionType", "getPositionType$annotations", "positionType", "getClientUIPosition", "setClientUIPosition", "getClientUIPosition$annotations", "clientUIPosition", "Companion", "a", "LinkmicPositionStatus", "LinkmicPositionType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkmicPositionItem extends vh7.c<LinkmicPositionItem> {
    public static final a Companion = null;
    public static final int LINKMIC_POSITION_VERIFY_STATUS_AUDITING = 1;
    public static final int LINKMIC_POSITION_VERIFY_STATUS_FAIL = 4;
    public static final int LINKMIC_POSITION_VERIFY_STATUS_PASS = 3;
    public static final int LINKMIC_POSITION_VERIFY_STATUS_UNKNOWN = 0;
    public static final int LINKMIC_POSITION_VERIFY_STATUS_UNPASS = 2;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem$LinkmicPositionStatus;", "", "NORMAL", "LOCKED", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkmicPositionStatus extends Enum<LinkmicPositionStatus> {
        public static final LinkmicPositionStatus LOCKED = null;
        public static final LinkmicPositionStatus NORMAL = null;
        public static final /* synthetic */ LinkmicPositionStatus[] a = null;

        static {
            LinkmicPositionStatus r1 = new LinkmicPositionStatus("NORMAL", 0);
            NORMAL = r1;
            LinkmicPositionStatus r2 = new LinkmicPositionStatus("LOCKED", 1);
            LOCKED = r2;
            a = new LinkmicPositionStatus[]{r1, r2};
        }

        public static LinkmicPositionStatus valueOf(String r1) {
            return (LinkmicPositionStatus) r27.a.a(LinkmicPositionStatus.class, r1);
        }

        public static LinkmicPositionStatus[] values() {
            return (LinkmicPositionStatus[]) a.clone();
        }

        public LinkmicPositionStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem$LinkmicPositionType;", "", "NORMAL", "PERFORMER", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkmicPositionType extends Enum<LinkmicPositionType> {
        public static final LinkmicPositionType NORMAL = null;
        public static final LinkmicPositionType PERFORMER = null;
        public static final /* synthetic */ LinkmicPositionType[] a = null;

        static {
            LinkmicPositionType r1 = new LinkmicPositionType("NORMAL", 0);
            NORMAL = r1;
            LinkmicPositionType r2 = new LinkmicPositionType("PERFORMER", 1);
            PERFORMER = r2;
            a = new LinkmicPositionType[]{r1, r2};
        }

        public static LinkmicPositionType valueOf(String r1) {
            return (LinkmicPositionType) r27.a.a(LinkmicPositionType.class, r1);
        }

        public static LinkmicPositionType[] values() {
            return (LinkmicPositionType[]) a.clone();
        }

        public LinkmicPositionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "active_name")
    String getActiveName();

    @FieldName(name = "client_ui_position")
    long getClientUIPosition();

    @FieldName(name = "position")
    long getPosition();

    @FieldName(name = "position_type")
    int getPositionType();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = "verify_status")
    int getVerifyStatus();

    @FieldName(name = "active_name#setter")
    void setActiveName(String r1);

    @FieldName(name = "client_ui_position#setter")
    void setClientUIPosition(long r1);

    @FieldName(name = "position#setter")
    void setPosition(long r1);

    @FieldName(name = "position_type#setter")
    void setPositionType(int r1);

    @FieldName(name = "status#setter")
    void setStatus(int r1);

    @FieldName(name = "verify_status#setter")
    void setVerifyStatus(int r1);
}
