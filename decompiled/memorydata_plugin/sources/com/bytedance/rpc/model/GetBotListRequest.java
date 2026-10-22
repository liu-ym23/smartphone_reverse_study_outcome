package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetBotListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("BotIds")
    public List<Long> botIds;

    @SerializedName("BotName")
    public String botName;

    @SerializedName("BotRecommendType")
    public BotRecommendType botRecommendType;

    @SerializedName("BotSpecies")
    public List<BotSpecies> botSpecies;

    @SerializedName("BotStatus")
    public List<BotStatus> botStatus;

    @SerializedName("BotTypes")
    public List<BotType> botTypes;

    @SerializedName("CreatorId")
    public long creatorId;

    @SerializedName("PageIndex")
    public long pageIndex;

    @SerializedName("PageSize")
    public long pageSize;

    @SerializedName("Recommend")
    public boolean recommend;

    @SerializedName("UserId")
    public long userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetBotListRequest() {
    }
}
