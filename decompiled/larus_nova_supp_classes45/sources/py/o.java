package py;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\f\u0010\u0007R.\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0013"}, d2 = {"Lpy/o;", "Lvh7/c;", "Lpy/p;", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getRoomIdList", "()Ljava/util/List;", "getRoomIdList$annotations", "()V", "roomIdList", "", "getRoomIdStrList", "getRoomIdStrList$annotations", "roomIdStrList", "", "getRoomIdDisplay", "getRoomIdDisplay$annotations", "roomIdDisplay", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface o extends vh7.c<o>, p {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ long getId();

    @FieldName(name = "room_ids_display")
    List<Integer> getRoomIdDisplay();

    @FieldName(name = "room_ids")
    List<Long> getRoomIdList();

    @FieldName(name = "room_ids_str")
    List<String> getRoomIdStrList();
}
