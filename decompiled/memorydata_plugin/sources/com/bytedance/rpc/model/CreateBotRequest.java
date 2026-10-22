package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class CreateBotRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("BotRecommendType")
    public BotRecommendType botRecommendType;

    @SerializedName("BotSpecies")
    public BotSpecies botSpecies;

    @SerializedName("BotType")
    public BotType botType;

    @SerializedName("CreatorId")
    public long creatorId;

    @SerializedName("DescriptionForHuman")
    public String descriptionForHuman;

    @SerializedName("DescriptionForModel")
    public String descriptionForModel;

    @SerializedName("Edit")
    public String edit;
    public String ext;

    @SerializedName("IconUri")
    public String iconUri;

    @SerializedName("ModelType")
    public long modelType;

    @SerializedName("Name")
    public String name;

    @SerializedName("onboarding_mode")
    public OnboardingSourceMode onboardingMode;

    @SerializedName("Prompt")
    public String prompt;

    @SerializedName("Recommend")
    public boolean recommend;

    @SerializedName("RecommendIndex")
    public long recommendIndex;

    @SerializedName("Temperature")
    public double temperature;

    @SerializedName("Tools")
    public String tools;

    @SerializedName("top_k")
    public long topK;

    @SerializedName("top_p")
    public double topP;

    @SerializedName("VoiceType")
    public long voiceType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public CreateBotRequest() {
    }
}
