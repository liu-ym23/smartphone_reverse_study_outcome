package r11;

import com.bytedance.android.live.revlink.impl.config.AnchorLinkEnterRoomOptConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(AnchorLinkEnterRoomOptConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr11/a;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.j<a> {

    /* JADX INFO: renamed from: r11.a$a, reason: collision with other inner class name */
    @JsonAdapter(AnchorLinkEnterRoomOptConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0306a {
    }

    @FieldName(name = "sync_load_control_widget")
    boolean Y5();

    @FieldName(name = "preload_linkmic_list")
    boolean q5();

    @FieldName(name = "delay_load_link_widget")
    boolean v4();
}
