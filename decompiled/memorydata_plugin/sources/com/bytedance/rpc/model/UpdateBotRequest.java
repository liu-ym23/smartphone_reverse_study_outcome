package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateBotRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("BotId")
    public long botId;

    @SerializedName("BotRecommendType")
    public BotRecommendType botRecommendType;

    @SerializedName("DataSet")
    public String dataSet;

    @SerializedName("default_initial_lang")
    public String defaultInitialLang;

    @SerializedName("Delete")
    public boolean delete;

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

    @SerializedName("OperatorId")
    public long operatorId;

    @SerializedName("ProfileMemory")
    public String profileMemory;

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

    @SerializedName("UserId")
    public long userId;

    @SerializedName("VoiceType")
    public long voiceType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UpdateBotRequest() {
    }
}
