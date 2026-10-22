package com.bytedance.android.live.revlink.impl.multianchor.dialog.transfer.monitor;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/transfer/monitor/PlayerStatus;", "", "", "toString", "", Constants.OperatorKey.CODE, "I", "getCode", "()I", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "ERROR_CODE_NO_ERROR", "ERROR_CODE_LAYOUT_PARAM_MISMATCH", "ERROR_CODE_LAYOUT_PARAM_INVISIBLE", "ERROR_CODE_TOP_BG_ROOT_DIFF", "ERROR_CODE_BOTTOM_BG_ROOT_DIFF", "ERROR_CODE_TOP_BG_BELOW_RENDER", "ERROR_CODE_BOTTOM_BG_BELOW_RENDER", "ERROR_CODE_RENDER_SEI_DIFF", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PlayerStatus extends Enum<PlayerStatus> {
    public static final PlayerStatus ERROR_CODE_BOTTOM_BG_BELOW_RENDER = null;
    public static final PlayerStatus ERROR_CODE_BOTTOM_BG_ROOT_DIFF = null;
    public static final PlayerStatus ERROR_CODE_LAYOUT_PARAM_INVISIBLE = null;
    public static final PlayerStatus ERROR_CODE_LAYOUT_PARAM_MISMATCH = null;
    public static final PlayerStatus ERROR_CODE_NO_ERROR = null;
    public static final PlayerStatus ERROR_CODE_RENDER_SEI_DIFF = null;
    public static final PlayerStatus ERROR_CODE_TOP_BG_BELOW_RENDER = null;
    public static final PlayerStatus ERROR_CODE_TOP_BG_ROOT_DIFF = null;
    public static final /* synthetic */ PlayerStatus[] a = null;
    private final int code;
    private final String description;

    public static PlayerStatus valueOf(String r1) {
        return (PlayerStatus) a.a(PlayerStatus.class, r1);
    }

    public static PlayerStatus[] values() {
        return (PlayerStatus[]) a.clone();
    }

    static {
        PlayerStatus r1 = new PlayerStatus("ERROR_CODE_NO_ERROR", 0, 0, "multiPlayerNoError");
        ERROR_CODE_NO_ERROR = r1;
        PlayerStatus r2 = new PlayerStatus("ERROR_CODE_LAYOUT_PARAM_MISMATCH", 1, 1, "multiPlayerLayoutParamMismatch");
        ERROR_CODE_LAYOUT_PARAM_MISMATCH = r2;
        PlayerStatus r3 = new PlayerStatus("ERROR_CODE_LAYOUT_PARAM_INVISIBLE", 2, 2, "multiPlayerLayoutParamInvisible");
        ERROR_CODE_LAYOUT_PARAM_INVISIBLE = r3;
        PlayerStatus r4 = new PlayerStatus("ERROR_CODE_TOP_BG_ROOT_DIFF", 3, 3, "multiPlayerTopBgRootDiff");
        ERROR_CODE_TOP_BG_ROOT_DIFF = r4;
        PlayerStatus r5 = new PlayerStatus("ERROR_CODE_BOTTOM_BG_ROOT_DIFF", 4, 4, "multiPlayerBottomBgRootDiff");
        ERROR_CODE_BOTTOM_BG_ROOT_DIFF = r5;
        PlayerStatus r6 = new PlayerStatus("ERROR_CODE_TOP_BG_BELOW_RENDER", 5, 5, "multiPlayerTopBgBelowRender");
        ERROR_CODE_TOP_BG_BELOW_RENDER = r6;
        PlayerStatus r7 = new PlayerStatus("ERROR_CODE_BOTTOM_BG_BELOW_RENDER", 6, 6, "multiPlayerBottomBgBelowRender");
        ERROR_CODE_BOTTOM_BG_BELOW_RENDER = r7;
        PlayerStatus r8 = new PlayerStatus("ERROR_CODE_RENDER_SEI_DIFF", 7, 7, "multiPlayerRenderSeiDiff");
        ERROR_CODE_RENDER_SEI_DIFF = r8;
        a = new PlayerStatus[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.description;
    }

    public PlayerStatus(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.code = r3;
        this.description = r4;
    }
}
