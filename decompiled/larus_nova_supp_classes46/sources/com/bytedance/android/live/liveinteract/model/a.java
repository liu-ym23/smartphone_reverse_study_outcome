package com.bytedance.android.live.liveinteract.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001e\u0010\b\u001a\u00060\u0002j\u0002`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R&\u0010\u000e\u001a\u00060\u0002j\u0002`\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0012\u001a\u00060\u0002j\u0002`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0010\u0010\u0005R\u001e\u0010\u0015\u001a\u00060\u0002j\u0002`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/model/a;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChorusId;", "getChorusId", "()J", "getChorusId$annotations", "()V", "chorusId", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/LeadSingerId;", "getLeadSingerId", "setLeadSingerId", "(J)V", "getLeadSingerId$annotations", "leadSingerId", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/TimeInt64;", "getStartTime", "getStartTime$annotations", "startTime", "getFinishTime", "getFinishTime$annotations", "finishTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.model.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0044a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "chorus_id")
    long getChorusId();

    @FieldName(name = "finish_time")
    long getFinishTime();

    @FieldName(name = "lead_singer_id")
    long getLeadSingerId();

    @FieldName(name = "start_time")
    long getStartTime();

    @FieldName(name = "lead_singer_id#setter")
    void setLeadSingerId(long r1);
}
