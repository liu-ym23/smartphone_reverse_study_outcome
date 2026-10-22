package b51;

import com.bytedance.android.live.revlink.impl.settings.panel.LinkAutoMatchParamSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(LinkAutoMatchParamSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lb51/a;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends j<a> {

    /* JADX INFO: renamed from: b51.a$a, reason: collision with other inner class name */
    @JsonAdapter(LinkAutoMatchParamSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0003a {
    }

    @FieldName(name = "auto_acc_limite")
    int getAccelerateLimit();

    @FieldName(name = "auto_default_limite")
    int getDefaultWaitLimit();

    @FieldName(name = "auto_invite_limite")
    int getInviteLimitSec();

    @FieldName(name = "auto_pk_auto_index")
    int getPkAutoMatchIndex();

    @FieldName(name = "auto_wait_sec")
    long getWaitSec();
}
