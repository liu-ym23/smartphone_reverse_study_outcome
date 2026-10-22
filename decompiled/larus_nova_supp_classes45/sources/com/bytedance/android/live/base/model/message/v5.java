package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\b\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\"\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR$\u0010&\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\b\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/base/model/message/v5;", "Lvh7/c;", "", "getAction", "()I", "setAction", "(I)V", "getAction$annotations", "()V", "action", "", "getMatchId", "()J", "setMatchId", "(J)V", "getMatchId$annotations", "matchId", "", "getMatchIdStr", "()Ljava/lang/String;", "setMatchIdStr", "(Ljava/lang/String;)V", "getMatchIdStr$annotations", "matchIdStr", "", "getEventId", "()Ljava/util/List;", "setEventId", "(Ljava/util/List;)V", "getEventId$annotations", "eventId", "getContentId", "setContentId", "getContentId$annotations", "contentId", "getContentIdStr", "setContentIdStr", "getContentIdStr$annotations", "contentIdStr", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v5 extends vh7.c<v5> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "action")
    int getAction();

    @FieldName(name = "content_id")
    long getContentId();

    @FieldName(name = "content_id_str")
    String getContentIdStr();

    @FieldName(name = "event_ids")
    List<Long> getEventId();

    @FieldName(name = "match_id")
    long getMatchId();

    @FieldName(name = "match_id_str")
    String getMatchIdStr();

    @FieldName(name = "action#setter")
    void setAction(int r1);

    @FieldName(name = "content_id#setter")
    void setContentId(long r1);

    @FieldName(name = "content_id_str#setter")
    void setContentIdStr(String r1);

    @FieldName(name = "event_ids#setter")
    void setEventId(List<Long> r1);

    @FieldName(name = "match_id#setter")
    void setMatchId(long r1);

    @FieldName(name = "match_id_str#setter")
    void setMatchIdStr(String r1);
}
