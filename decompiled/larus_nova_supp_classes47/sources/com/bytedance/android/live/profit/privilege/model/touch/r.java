package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R\"\u0010\u0015\u001a\u00020\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R6\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\t\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010&\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\t\u001a\u0004\b#\u0010\u0005\"\u0004\b$\u0010\u0007R6\u0010+\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020'\u0018\u0001`\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\t\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R*\u0010/\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\t\u001a\u0004\b,\u0010\u0005\"\u0004\b-\u0010\u0007¨\u00060"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/r;", "Lvh7/c;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "getId$annotations", "()V", "id", "getMetaId", "setMetaId", "getMetaId$annotations", "metaId", "", "getPosition", "()I", "setPosition", "(I)V", "getPosition$annotations", "position", "getTemplate", "setTemplate", "getTemplate$annotations", "template", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/d;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getFreqCtrlParamsList", "()Ljava/util/List;", "setFreqCtrlParamsList", "(Ljava/util/List;)V", "getFreqCtrlParamsList$annotations", "freqCtrlParamsList", "getDuration", "setDuration", "getDuration$annotations", Constants.Keys.duration, "Lcom/bytedance/android/live/profit/privilege/model/touch/m;", "getRefreshParamsList", "setRefreshParamsList", "getRefreshParamsList$annotations", "refreshParamsList", "getPriority", "setPriority", "getPriority$annotations", "priority", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r extends vh7.c<r> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = Constants.Keys.duration)
    Long getDuration();

    @FieldName(name = "freq_ctrl_params_list")
    List<d> getFreqCtrlParamsList();

    @FieldName(name = "id")
    Long getId();

    @FieldName(name = "meta_id")
    Long getMetaId();

    @FieldName(name = "position")
    int getPosition();

    @FieldName(name = "priority")
    Long getPriority();

    @FieldName(name = "refresh_params_list")
    List<m> getRefreshParamsList();

    @FieldName(name = "template")
    Long getTemplate();

    @FieldName(name = "duration#setter")
    void setDuration(Long r1);

    @FieldName(name = "freq_ctrl_params_list#setter")
    void setFreqCtrlParamsList(List<? extends d> r1);

    @FieldName(name = "id#setter")
    void setId(Long r1);

    @FieldName(name = "meta_id#setter")
    void setMetaId(Long r1);

    @FieldName(name = "position#setter")
    void setPosition(int r1);

    @FieldName(name = "priority#setter")
    void setPriority(Long r1);

    @FieldName(name = "refresh_params_list#setter")
    void setRefreshParamsList(List<? extends m> r1);

    @FieldName(name = "template#setter")
    void setTemplate(Long r1);
}
