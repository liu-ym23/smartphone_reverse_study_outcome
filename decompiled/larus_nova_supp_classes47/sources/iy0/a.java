package iy0;

import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Liy0/a;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IOfficialChannelInfo;", "", "getCurrentShowId", "()I", "getCurrentShowId$annotations", "()V", "currentShowId", "", "getBackupRoomIdStr", "()Ljava/lang/String;", "getBackupRoomIdStr$annotations", "backupRoomIdStr", "", "getEnableHost", "()Z", "getEnableHost$annotations", "enableHost", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.e<IOfficialChannelInfo>, IOfficialChannelInfo {

    /* JADX INFO: renamed from: iy0.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0253a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "backup_room_id_str")
    String getBackupRoomIdStr();

    @FieldName(name = "current_show_id")
    int getCurrentShowId();

    @FieldName(name = "enable_host")
    boolean getEnableHost();

    /* synthetic */ Object getFlexInstance();
}
