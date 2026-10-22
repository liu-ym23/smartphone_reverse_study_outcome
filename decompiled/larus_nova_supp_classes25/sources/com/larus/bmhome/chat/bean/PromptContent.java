package com.larus.bmhome.chat.bean;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotSourceType;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.bean.bot.BotSwitchConfInfo;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SceneModelList;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lw8.l;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b=\b\u0007\u0018\u0000 G2\u00020\u0001:\r@ABCDEFGHIJKLB¥\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u00108\u001a\u00020\nJ\u0006\u00109\u001a\u00020\nJ\u0006\u0010:\u001a\u00020\fJ\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u0013\u0010<\u001a\u00020\n2\b\u0010=\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010>\u001a\u00020\fH\u0016J\b\u0010?\u001a\u0004\u0018\u00010\u0004R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R,\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010&\"\u0004\b2\u0010(R\"\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006M"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent;", "", "suggest", "", "", "suggestV2", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2;", "suggestItems", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "isNoDisappear", "", "suggestActionCardCnt", "", "onboardingDisplayStyle", "sugType", "businessExt", "", "wcbRenderStatus", "wcbTitle", "wcbTitleStyle", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;ZILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getSuggest", "()Ljava/util/List;", "setSuggest", "(Ljava/util/List;)V", "getSuggestV2", "setSuggestV2", "getSuggestItems", "setSuggestItems", "()Z", "setNoDisappear", "(Z)V", "getSuggestActionCardCnt", "()I", "setSuggestActionCardCnt", "(I)V", "getOnboardingDisplayStyle", "()Ljava/lang/String;", "setOnboardingDisplayStyle", "(Ljava/lang/String;)V", "getSugType", "setSugType", "getBusinessExt", "()Ljava/util/Map;", "setBusinessExt", "(Ljava/util/Map;)V", "getWcbRenderStatus", "setWcbRenderStatus", "getWcbTitle", "setWcbTitle", "getWcbTitleStyle", "()Ljava/lang/Integer;", "setWcbTitleStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isEmpty", "isPlaceholder", "size", "suggestTxt", "equals", "other", "hashCode", "toJson", "SuggestItem", "SuggestImageItem", "SuggestItemType", "SuggestV2", "SuggestPromptType", "TravelSuggestType", "SuggestV2Extra", "Companion", "SuggestV2ExtraForMultiAction", "SuggestV2Style", "CursorPosition", "DefaultOptionItem", "BotInfo", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PromptContent {
    public static final a Companion = null;

    @SerializedName("business_ext")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private Map<String, String> businessExt;

    @SerializedName("no_disappear")
    private boolean isNoDisappear;

    @SerializedName("onboarding_display_style")
    private String onboardingDisplayStyle;

    @SerializedName("sug_type")
    private String sugType;

    @SerializedName("suggest")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<String> suggest;

    @SerializedName("skill_card_cnt")
    private int suggestActionCardCnt;

    @SerializedName("suggest_items")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<SuggestItem> suggestItems;

    @SerializedName("suggest_v2")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<SuggestV2> suggestV2;

    @SerializedName("wcb_render_status")
    private String wcbRenderStatus;

    @SerializedName("wcb_title")
    private String wcbTitle;

    @SerializedName("wcb_title_style")
    private Integer wcbTitleStyle;

    @Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b|\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010+\u001a\u00020\u0017\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000107¢\u0006\u0004\b8\u00109J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010;J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010;J\u0011\u0010\u0090\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010CJ\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010CJ\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0017HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0012\u0010\u009c\u0001\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dHÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\nHÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010&HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010mJ\f\u0010¥\u0001\u001a\u0004\u0018\u00010*HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0017HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010-HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0018\u0010¯\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000107HÆ\u0003JÌ\u0003\u0010°\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\u00172\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000107HÆ\u0001¢\u0006\u0003\u0010±\u0001J\u0016\u0010²\u0001\u001a\u00020\u00172\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001HÖ\u0003J\n\u0010µ\u0001\u001a\u00020\nHÖ\u0001J\n\u0010¶\u0001\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010<\u001a\u0004\bA\u0010;R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010CR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001a\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010D\u001a\u0004\bG\u0010CR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010>R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010>R\u0016\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010>R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010>R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR&\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001e\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R \u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010>\"\u0004\b_\u0010`R \u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010>\"\u0004\bb\u0010`R \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010>\"\u0004\bd\u0010`R \u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u0018\u0010%\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0018\u0010'\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010>R\u001a\u0010(\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010n\u001a\u0004\bl\u0010mR \u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001e\u0010+\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010Q\"\u0004\bt\u0010uR \u0010,\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR \u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010>\"\u0004\b{\u0010`R \u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\"\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010>\"\u0005\b\u0081\u0001\u0010`R\"\u00102\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010>\"\u0005\b\u0083\u0001\u0010`R\"\u00103\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010>\"\u0005\b\u0085\u0001\u0010`R\"\u00104\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010>\"\u0005\b\u0087\u0001\u0010`R\"\u00105\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010>\"\u0005\b\u0089\u0001\u0010`R&\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001078\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001¨\u0006·\u0001"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$BotInfo;", "Ljava/io/Serializable;", "botId", "", "name", "", "iconImage", "Lcom/larus/im/bean/bot/BotIconImage;", "updateTime", "botType", "", "botCreatorInfo", "Lcom/larus/im/bean/bot/BotCreatorInfo;", "privateStatus", "conversationPage", "Lcom/larus/im/bean/bot/ConversationPage;", "descriptionForHuman", "model", "Lcom/larus/im/bean/bot/ModelItem;", "voiceType", "Lcom/larus/im/bean/bot/SpeakerVoice;", "editPos", "muted", "", "bioEdit", "bio", "botStatic", "Lcom/larus/im/bean/bot/BotStatistic;", "botConf", "", "Lcom/larus/im/bean/bot/BotConfItem;", "botMode", "bgImgUrl", "bgImgColor", "bgVideoModel", "switchConfInfo", "Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "onBoarding", "Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "callerName", "callerNameSetting", "sceneModelList", "Lcom/larus/im/bean/bot/SceneModelList;", "disabled", "firstMet", "Lcom/larus/im/bean/bot/FirstMet;", "bgImgUri", "bgImgInfo", "Lcom/larus/im/bean/bot/BgImageInfo;", "userBotGender", "userBotType", "dynamicImgUri", "dynamicImgUrl", "botIconMappedAppIcon", "extra", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Lcom/larus/im/bean/bot/BotIconImage;Ljava/lang/Long;Ljava/lang/Integer;Lcom/larus/im/bean/bot/BotCreatorInfo;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ConversationPage;Ljava/lang/String;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotStatistic;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Lcom/larus/bmhome/chat/bean/BotOnBoarding;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/SceneModelList;ZLcom/larus/im/bean/bot/FirstMet;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getBotId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getIconImage", "()Lcom/larus/im/bean/bot/BotIconImage;", "getUpdateTime", "getBotType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBotCreatorInfo", "()Lcom/larus/im/bean/bot/BotCreatorInfo;", "getPrivateStatus", "getConversationPage", "()Lcom/larus/im/bean/bot/ConversationPage;", "getDescriptionForHuman", "getModel", "()Lcom/larus/im/bean/bot/ModelItem;", "getVoiceType", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "getEditPos", "getMuted", "()Z", "getBioEdit", "getBio", "getBotStatic", "()Lcom/larus/im/bean/bot/BotStatistic;", "getBotConf", "()Ljava/util/List;", "setBotConf", "(Ljava/util/List;)V", "getBotMode", "()I", "setBotMode", "(I)V", "getBgImgUrl", "setBgImgUrl", "(Ljava/lang/String;)V", "getBgImgColor", "setBgImgColor", "getBgVideoModel", "setBgVideoModel", "getSwitchConfInfo", "()Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "setSwitchConfInfo", "(Lcom/larus/im/bean/bot/BotSwitchConfInfo;)V", "getOnBoarding", "()Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "getCallerName", "getCallerNameSetting", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSceneModelList", "()Lcom/larus/im/bean/bot/SceneModelList;", "setSceneModelList", "(Lcom/larus/im/bean/bot/SceneModelList;)V", "getDisabled", "setDisabled", "(Z)V", "getFirstMet", "()Lcom/larus/im/bean/bot/FirstMet;", "setFirstMet", "(Lcom/larus/im/bean/bot/FirstMet;)V", "getBgImgUri", "setBgImgUri", "getBgImgInfo", "()Lcom/larus/im/bean/bot/BgImageInfo;", "setBgImgInfo", "(Lcom/larus/im/bean/bot/BgImageInfo;)V", "getUserBotGender", "setUserBotGender", "getUserBotType", "setUserBotType", "getDynamicImgUri", "setDynamicImgUri", "getDynamicImgUrl", "setDynamicImgUrl", "getBotIconMappedAppIcon", "setBotIconMappedAppIcon", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "copy", "(Ljava/lang/Long;Ljava/lang/String;Lcom/larus/im/bean/bot/BotIconImage;Ljava/lang/Long;Ljava/lang/Integer;Lcom/larus/im/bean/bot/BotCreatorInfo;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ConversationPage;Ljava/lang/String;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotStatistic;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Lcom/larus/bmhome/chat/bean/BotOnBoarding;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/SceneModelList;ZLcom/larus/im/bean/bot/FirstMet;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/bmhome/chat/bean/PromptContent$BotInfo;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class BotInfo implements Serializable {

        @SerializedName("bg_img_avg_hue")
        private String bgImgColor;

        @SerializedName("bg_img_info")
        private BgImageInfo bgImgInfo;

        @SerializedName("bg_img_uri")
        private String bgImgUri;

        @SerializedName("bg_img_url")
        private String bgImgUrl;

        @SerializedName("bg_video_model")
        private String bgVideoModel;

        @SerializedName("bio")
        private final String bio;

        @SerializedName("user_edit_bio")
        private final String bioEdit;

        @SerializedName("bot_conf")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<BotConfItem> botConf;

        @SerializedName("creator_info")
        private final BotCreatorInfo botCreatorInfo;

        @SerializedName("bot_icon_mapped_app_icon")
        private String botIconMappedAppIcon;

        @SerializedName("id")
        private final Long botId;

        @SerializedName("bot_mode")
        private int botMode;

        @SerializedName("bot_stats")
        private final BotStatistic botStatic;

        @SerializedName("bot_type")
        private final Integer botType;

        @SerializedName("caller_name")
        private final String callerName;

        @SerializedName("caller_name_setting")
        private final Boolean callerNameSetting;

        @SerializedName("conversation_page")
        private final ConversationPage conversationPage;

        @SerializedName("description_for_human")
        private final String descriptionForHuman;

        @SerializedName("disabled")
        private boolean disabled;

        @SerializedName("dynamic_img_uri")
        private String dynamicImgUri;

        @SerializedName("dynamic_img_url")
        private String dynamicImgUrl;

        @SerializedName("edit_pos")
        private final String editPos;

        @SerializedName("extra")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final Map<String, String> extra;

        @SerializedName("first_meet")
        private FirstMet firstMet;

        @SerializedName("icon_image")
        private final BotIconImage iconImage;

        @SerializedName("model")
        private final ModelItem model;

        @SerializedName("muted")
        private final boolean muted;

        @SerializedName("name")
        private final String name;

        @SerializedName("onboarding")
        private final BotOnBoarding onBoarding;

        @SerializedName("private_status")
        private final Integer privateStatus;

        @SerializedName("call_model_list")
        private SceneModelList sceneModelList;

        @SerializedName("switch_conf")
        private BotSwitchConfInfo switchConfInfo;

        @SerializedName("update_time")
        private final Long updateTime;

        @SerializedName("user_bot_gender_starling_key")
        private String userBotGender;

        @SerializedName("user_bot_type_starling_key")
        private String userBotType;

        @SerializedName("voice_type")
        private final SpeakerVoice voiceType;

        public BotInfo() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, -1, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BotInfo copy$default(BotInfo r17, Long r18, String r19, BotIconImage r20, Long r21, Integer r22, BotCreatorInfo r23, Integer r24, ConversationPage r25, String r26, ModelItem r27, SpeakerVoice r28, String r29, boolean r30, String r31, String r32, BotStatistic r33, List r34, int r35, String r36, String r37, String r38, BotSwitchConfInfo r39, BotOnBoarding r40, String r41, Boolean r42, SceneModelList r43, boolean r44, FirstMet r45, String r46, BgImageInfo r47, String r48, String r49, String r50, String r51, String r52, Map r53, int r54, int r55, Object r56) {
            if ((r54 & 1) == 0) goto L5;
            Long r2 = r17.botId;
        L7:
            if ((r54 & 2) == 0) goto L9;
            String r3 = r17.name;
        L11:
            if ((r54 & 4) == 0) goto L13;
            BotIconImage r4 = r17.iconImage;
        L15:
            if ((r54 & 8) == 0) goto L17;
            Long r5 = r17.updateTime;
        L19:
            if ((r54 & 16) == 0) goto L21;
            Integer r6 = r17.botType;
        L23:
            if ((r54 & 32) == 0) goto L25;
            BotCreatorInfo r7 = r17.botCreatorInfo;
        L27:
            if ((r54 & 64) == 0) goto L29;
            Integer r8 = r17.privateStatus;
        L31:
            if ((r54 & 128) == 0) goto L33;
            ConversationPage r9 = r17.conversationPage;
        L35:
            if ((r54 & 256) == 0) goto L37;
            String r10 = r17.descriptionForHuman;
        L39:
            if ((r54 & 512) == 0) goto L41;
            ModelItem r11 = r17.model;
        L43:
            if ((r54 & 1024) == 0) goto L45;
            SpeakerVoice r12 = r17.voiceType;
        L47:
            if ((r54 & 2048) == 0) goto L49;
            String r13 = r17.editPos;
        L51:
            if ((r54 & 4096) == 0) goto L53;
            boolean r14 = r17.muted;
        L55:
            if ((r54 & 8192) == 0) goto L57;
            String r15 = r17.bioEdit;
        L58:
            String r310 = r15;
            if ((r54 & 16384) == 0) goto L61;
            String r16 = r17.bio;
        L62:
            String r311 = r16;
            if ((r54 & 32768) == 0) goto L65;
            BotStatistic r110 = r17.botStatic;
        L66:
            BotStatistic r312 = r110;
            if ((r54 & 65536) == 0) goto L69;
            List r111 = r17.botConf;
        L70:
            List r313 = r111;
            if ((r54 & 131072) == 0) goto L73;
            int r112 = r17.botMode;
        L74:
            int r314 = r112;
            if ((r54 & 262144) == 0) goto L77;
            String r113 = r17.bgImgUrl;
        L78:
            String r315 = r113;
            if ((r54 & 524288) == 0) goto L81;
            String r114 = r17.bgImgColor;
        L82:
            String r316 = r114;
            if ((r54 & 1048576) == 0) goto L85;
            String r115 = r17.bgVideoModel;
        L86:
            String r317 = r115;
            if ((r54 & 2097152) == 0) goto L89;
            BotSwitchConfInfo r116 = r17.switchConfInfo;
        L90:
            BotSwitchConfInfo r318 = r116;
            if ((r54 & 4194304) == 0) goto L93;
            BotOnBoarding r117 = r17.onBoarding;
        L94:
            BotOnBoarding r410 = r117;
            if ((r54 & 8388608) == 0) goto L97;
            String r118 = r17.callerName;
        L98:
            String r411 = r118;
            if ((r54 & 16777216) == 0) goto L101;
            Boolean r119 = r17.callerNameSetting;
        L102:
            Boolean r412 = r119;
            if ((r54 & 33554432) == 0) goto L105;
            SceneModelList r120 = r17.sceneModelList;
        L106:
            SceneModelList r413 = r120;
            if ((r54 & 67108864) == 0) goto L109;
            boolean r121 = r17.disabled;
        L110:
            boolean r414 = r121;
            if ((r54 & 134217728) == 0) goto L113;
            FirstMet r122 = r17.firstMet;
        L114:
            FirstMet r415 = r122;
            if ((r54 & 268435456) == 0) goto L117;
            String r123 = r17.bgImgUri;
        L118:
            String r416 = r123;
            if ((r54 & 536870912) == 0) goto L121;
            BgImageInfo r124 = r17.bgImgInfo;
        L122:
            BgImageInfo r417 = r124;
            if ((r54 & 1073741824) == 0) goto L125;
            String r125 = r17.userBotGender;
        L127:
            if ((r54 & Integer.MIN_VALUE) == 0) goto L129;
            String r1 = r17.userBotType;
        L130:
            String r418 = r1;
            if ((r55 & 1) == 0) goto L133;
            String r57 = r17.dynamicImgUri;
        L134:
            String r58 = r57;
            if ((r55 & 2) == 0) goto L137;
            String r59 = r17.dynamicImgUrl;
        L138:
            String r510 = r59;
            if ((r55 & 4) == 0) goto L141;
            String r60 = r17.botIconMappedAppIcon;
        L142:
            String r511 = r60;
            if ((r55 & 8) == 0) goto L145;
            Map r61 = r17.extra;
        L147:
            return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r125, r418, r58, r510, r511, r61);
        L145:
            r61 = r53;
            goto L147
        L141:
            r60 = r52;
            goto L142
        L137:
            r59 = r51;
            goto L138
        L133:
            r57 = r50;
            goto L134
        L129:
            r1 = r49;
            goto L130
        L125:
            r125 = r48;
            goto L127
        L121:
            r124 = r47;
            goto L122
        L117:
            r123 = r46;
            goto L118
        L113:
            r122 = r45;
            goto L114
        L109:
            r121 = r44;
            goto L110
        L105:
            r120 = r43;
            goto L106
        L101:
            r119 = r42;
            goto L102
        L97:
            r118 = r41;
            goto L98
        L93:
            r117 = r40;
            goto L94
        L89:
            r116 = r39;
            goto L90
        L85:
            r115 = r38;
            goto L86
        L81:
            r114 = r37;
            goto L82
        L77:
            r113 = r36;
            goto L78
        L73:
            r112 = r35;
            goto L74
        L69:
            r111 = r34;
            goto L70
        L65:
            r110 = r33;
            goto L66
        L61:
            r16 = r32;
            goto L62
        L57:
            r15 = r31;
            goto L58
        L53:
            r14 = r30;
            goto L55
        L49:
            r13 = r29;
            goto L51
        L45:
            r12 = r28;
            goto L47
        L41:
            r11 = r27;
            goto L43
        L37:
            r10 = r26;
            goto L39
        L33:
            r9 = r25;
            goto L35
        L29:
            r8 = r24;
            goto L31
        L25:
            r7 = r23;
            goto L27
        L21:
            r6 = r22;
            goto L23
        L17:
            r5 = r21;
            goto L19
        L13:
            r4 = r20;
            goto L15
        L9:
            r3 = r19;
            goto L11
        L5:
            r2 = r18;
            goto L7
        }

        public final Long component1() {
            return this.botId;
        }

        public final ModelItem component10() {
            return this.model;
        }

        public final SpeakerVoice component11() {
            return this.voiceType;
        }

        public final String component12() {
            return this.editPos;
        }

        public final boolean component13() {
            return this.muted;
        }

        public final String component14() {
            return this.bioEdit;
        }

        public final String component15() {
            return this.bio;
        }

        public final BotStatistic component16() {
            return this.botStatic;
        }

        public final List<BotConfItem> component17() {
            return this.botConf;
        }

        public final int component18() {
            return this.botMode;
        }

        public final String component19() {
            return this.bgImgUrl;
        }

        public final String component2() {
            return this.name;
        }

        public final String component20() {
            return this.bgImgColor;
        }

        public final String component21() {
            return this.bgVideoModel;
        }

        public final BotSwitchConfInfo component22() {
            return this.switchConfInfo;
        }

        public final BotOnBoarding component23() {
            return this.onBoarding;
        }

        public final String component24() {
            return this.callerName;
        }

        public final Boolean component25() {
            return this.callerNameSetting;
        }

        public final SceneModelList component26() {
            return this.sceneModelList;
        }

        public final boolean component27() {
            return this.disabled;
        }

        public final FirstMet component28() {
            return this.firstMet;
        }

        public final String component29() {
            return this.bgImgUri;
        }

        public final BotIconImage component3() {
            return this.iconImage;
        }

        public final BgImageInfo component30() {
            return this.bgImgInfo;
        }

        public final String component31() {
            return this.userBotGender;
        }

        public final String component32() {
            return this.userBotType;
        }

        public final String component33() {
            return this.dynamicImgUri;
        }

        public final String component34() {
            return this.dynamicImgUrl;
        }

        public final String component35() {
            return this.botIconMappedAppIcon;
        }

        public final Map<String, String> component36() {
            return this.extra;
        }

        public final Long component4() {
            return this.updateTime;
        }

        public final Integer component5() {
            return this.botType;
        }

        public final BotCreatorInfo component6() {
            return this.botCreatorInfo;
        }

        public final Integer component7() {
            return this.privateStatus;
        }

        public final ConversationPage component8() {
            return this.conversationPage;
        }

        public final String component9() {
            return this.descriptionForHuman;
        }

        public final BotInfo copy(Long r39, String r40, BotIconImage r41, Long r42, @BotSourceType Integer r43, BotCreatorInfo r44, Integer r45, ConversationPage r46, String r47, ModelItem r48, SpeakerVoice r49, String r50, boolean r51, String r52, String r53, BotStatistic r54, List<BotConfItem> r55, int r56, String r57, String r58, String r59, BotSwitchConfInfo r60, BotOnBoarding r61, String r62, Boolean r63, SceneModelList r64, boolean r65, FirstMet r66, String r67, BgImageInfo r68, String r69, String r70, String r71, String r72, String r73, Map<String, String> r74) {
            return new BotInfo(r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof BotInfo) == true) goto L8;
            return false;
        L8:
            BotInfo r6 = (BotInfo) r5;
            if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.iconImage, r6.iconImage) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.updateTime, r6.updateTime) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.botType, r6.botType) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.botCreatorInfo, r6.botCreatorInfo) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.privateStatus, r6.privateStatus) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.conversationPage, r6.conversationPage) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.descriptionForHuman, r6.descriptionForHuman) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.model, r6.model) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.voiceType, r6.voiceType) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.editPos, r6.editPos) == true) goto L45;
            return false;
        L45:
            if (this.muted == r6.muted) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.bioEdit, r6.bioEdit) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.bio, r6.bio) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.botStatic, r6.botStatic) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.botConf, r6.botConf) == true) goto L60;
            return false;
        L60:
            if (this.botMode == r6.botMode) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.bgImgUrl, r6.bgImgUrl) == true) goto L66;
            return false;
        L66:
            if (Intrinsics.areEqual(this.bgImgColor, r6.bgImgColor) == true) goto L69;
            return false;
        L69:
            if (Intrinsics.areEqual(this.bgVideoModel, r6.bgVideoModel) == true) goto L72;
            return false;
        L72:
            if (Intrinsics.areEqual(this.switchConfInfo, r6.switchConfInfo) == true) goto L75;
            return false;
        L75:
            if (Intrinsics.areEqual(this.onBoarding, r6.onBoarding) == true) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.callerName, r6.callerName) == true) goto L81;
            return false;
        L81:
            if (Intrinsics.areEqual(this.callerNameSetting, r6.callerNameSetting) == true) goto L84;
            return false;
        L84:
            if (Intrinsics.areEqual(this.sceneModelList, r6.sceneModelList) == true) goto L87;
            return false;
        L87:
            if (this.disabled == r6.disabled) goto L90;
            return false;
        L90:
            if (Intrinsics.areEqual(this.firstMet, r6.firstMet) == true) goto L93;
            return false;
        L93:
            if (Intrinsics.areEqual(this.bgImgUri, r6.bgImgUri) == true) goto L96;
            return false;
        L96:
            if (Intrinsics.areEqual(this.bgImgInfo, r6.bgImgInfo) == true) goto L99;
            return false;
        L99:
            if (Intrinsics.areEqual(this.userBotGender, r6.userBotGender) == true) goto L102;
            return false;
        L102:
            if (Intrinsics.areEqual(this.userBotType, r6.userBotType) == true) goto L105;
            return false;
        L105:
            if (Intrinsics.areEqual(this.dynamicImgUri, r6.dynamicImgUri) == true) goto L108;
            return false;
        L108:
            if (Intrinsics.areEqual(this.dynamicImgUrl, r6.dynamicImgUrl) == true) goto L111;
            return false;
        L111:
            if (Intrinsics.areEqual(this.botIconMappedAppIcon, r6.botIconMappedAppIcon) == true) goto L114;
            return false;
        L114:
            if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L116;
            return false;
        L116:
            return true;
        }

        public int hashCode() {
            Long r0 = this.botId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.name;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            BotIconImage r7 = this.iconImage;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Long r10 = this.updateTime;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Integer r13 = this.botType;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            BotCreatorInfo r16 = this.botCreatorInfo;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            Integer r19 = this.privateStatus;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            ConversationPage r22 = this.conversationPage;
            if (r22 != null) goto L33;
            int r23 = 0;
        L34:
            int r24 = (r21 + r23) * 31;
            String r25 = this.descriptionForHuman;
            if (r25 != null) goto L37;
            int r26 = 0;
        L38:
            int r27 = (r24 + r26) * 31;
            ModelItem r28 = this.model;
            if (r28 != null) goto L41;
            int r29 = 0;
        L42:
            int r30 = (r27 + r29) * 31;
            SpeakerVoice r31 = this.voiceType;
            if (r31 != null) goto L45;
            int r32 = 0;
        L46:
            int r33 = (r30 + r32) * 31;
            String r34 = this.editPos;
            if (r34 != null) goto L49;
            int r35 = 0;
        L50:
            int r36 = (r33 + r35) * 31;
            int r37 = 1231;
            if (this.muted == false) goto L53;
            int r38 = 1231;
        L54:
            int r39 = (r36 + r38) * 31;
            String r40 = this.bioEdit;
            if (r40 != null) goto L57;
            int r41 = 0;
        L58:
            int r42 = (r39 + r41) * 31;
            String r43 = this.bio;
            if (r43 != null) goto L61;
            int r44 = 0;
        L62:
            int r45 = (r42 + r44) * 31;
            BotStatistic r46 = this.botStatic;
            if (r46 != null) goto L65;
            int r47 = 0;
        L66:
            int r48 = (r45 + r47) * 31;
            List<BotConfItem> r49 = this.botConf;
            if (r49 != null) goto L69;
            int r50 = 0;
        L70:
            int r51 = (((r48 + r50) * 31) + this.botMode) * 31;
            String r52 = this.bgImgUrl;
            if (r52 != null) goto L73;
            int r53 = 0;
        L74:
            int r54 = (r51 + r53) * 31;
            String r55 = this.bgImgColor;
            if (r55 != null) goto L77;
            int r56 = 0;
        L78:
            int r57 = (r54 + r56) * 31;
            String r58 = this.bgVideoModel;
            if (r58 != null) goto L81;
            int r59 = 0;
        L82:
            int r60 = (r57 + r59) * 31;
            BotSwitchConfInfo r61 = this.switchConfInfo;
            if (r61 != null) goto L85;
            int r62 = 0;
        L86:
            int r63 = (r60 + r62) * 31;
            BotOnBoarding r64 = this.onBoarding;
            if (r64 != null) goto L89;
            int r65 = 0;
        L90:
            int r66 = (r63 + r65) * 31;
            String r67 = this.callerName;
            if (r67 != null) goto L93;
            int r68 = 0;
        L94:
            int r69 = (r66 + r68) * 31;
            Boolean r70 = this.callerNameSetting;
            if (r70 != null) goto L97;
            int r71 = 0;
        L98:
            int r72 = (r69 + r71) * 31;
            SceneModelList r73 = this.sceneModelList;
            if (r73 != null) goto L101;
            int r74 = 0;
        L102:
            int r75 = (r72 + r74) * 31;
            if (this.disabled == true) goto L106;
            r37 = 1237;
        L106:
            int r76 = (r75 + r37) * 31;
            FirstMet r77 = this.firstMet;
            if (r77 != null) goto L109;
            int r78 = 0;
        L110:
            int r79 = (r76 + r78) * 31;
            String r80 = this.bgImgUri;
            if (r80 != null) goto L113;
            int r81 = 0;
        L114:
            int r82 = (r79 + r81) * 31;
            BgImageInfo r83 = this.bgImgInfo;
            if (r83 != null) goto L117;
            int r84 = 0;
        L118:
            int r85 = (r82 + r84) * 31;
            String r86 = this.userBotGender;
            if (r86 != null) goto L121;
            int r87 = 0;
        L122:
            int r88 = (r85 + r87) * 31;
            String r89 = this.userBotType;
            if (r89 != null) goto L125;
            int r90 = 0;
        L126:
            int r91 = (r88 + r90) * 31;
            String r92 = this.dynamicImgUri;
            if (r92 != null) goto L129;
            int r93 = 0;
        L130:
            int r94 = (r91 + r93) * 31;
            String r95 = this.dynamicImgUrl;
            if (r95 != null) goto L133;
            int r96 = 0;
        L134:
            int r97 = (r94 + r96) * 31;
            String r99 = this.botIconMappedAppIcon;
            if (r99 != null) goto L137;
            int r100 = 0;
        L138:
            int r101 = (r97 + r100) * 31;
            Map<String, String> r102 = this.extra;
            if (r102 == null) goto L143;
            r1 = r102.hashCode();
        L143:
            return r101 + r1;
        L137:
            r100 = r99.hashCode();
            goto L138
        L133:
            r96 = r95.hashCode();
            goto L134
        L129:
            r93 = r92.hashCode();
            goto L130
        L125:
            r90 = r89.hashCode();
            goto L126
        L121:
            r87 = r86.hashCode();
            goto L122
        L117:
            r84 = r83.hashCode();
            goto L118
        L113:
            r81 = r80.hashCode();
            goto L114
        L109:
            r78 = r77.hashCode();
            goto L110
        L101:
            r74 = r73.hashCode();
            goto L102
        L97:
            r71 = r70.hashCode();
            goto L98
        L93:
            r68 = r67.hashCode();
            goto L94
        L89:
            r65 = r64.hashCode();
            goto L90
        L85:
            r62 = r61.hashCode();
            goto L86
        L81:
            r59 = r58.hashCode();
            goto L82
        L77:
            r56 = r55.hashCode();
            goto L78
        L73:
            r53 = r52.hashCode();
            goto L74
        L69:
            r50 = r49.hashCode();
            goto L70
        L65:
            r47 = r46.hashCode();
            goto L66
        L61:
            r44 = r43.hashCode();
            goto L62
        L57:
            r41 = r40.hashCode();
            goto L58
        L53:
            r38 = 1237;
            goto L54
        L49:
            r35 = r34.hashCode();
            goto L50
        L45:
            r32 = r31.hashCode();
            goto L46
        L41:
            r29 = r28.hashCode();
            goto L42
        L37:
            r26 = r25.hashCode();
            goto L38
        L33:
            r23 = r22.hashCode();
            goto L34
        L29:
            r20 = r19.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "BotInfo(botId=" + this.botId + ", name=" + this.name + ", iconImage=" + this.iconImage + ", updateTime=" + this.updateTime + ", botType=" + this.botType + ", botCreatorInfo=" + this.botCreatorInfo + ", privateStatus=" + this.privateStatus + ", conversationPage=" + this.conversationPage + ", descriptionForHuman=" + this.descriptionForHuman + ", model=" + this.model + ", voiceType=" + this.voiceType + ", editPos=" + this.editPos + ", muted=" + this.muted + ", bioEdit=" + this.bioEdit + ", bio=" + this.bio + ", botStatic=" + this.botStatic + ", botConf=" + this.botConf + ", botMode=" + this.botMode + ", bgImgUrl=" + this.bgImgUrl + ", bgImgColor=" + this.bgImgColor + ", bgVideoModel=" + this.bgVideoModel + ", switchConfInfo=" + this.switchConfInfo + ", onBoarding=" + this.onBoarding + ", callerName=" + this.callerName + ", callerNameSetting=" + this.callerNameSetting + ", sceneModelList=" + this.sceneModelList + ", disabled=" + this.disabled + ", firstMet=" + this.firstMet + ", bgImgUri=" + this.bgImgUri + ", bgImgInfo=" + this.bgImgInfo + ", userBotGender=" + this.userBotGender + ", userBotType=" + this.userBotType + ", dynamicImgUri=" + this.dynamicImgUri + ", dynamicImgUrl=" + this.dynamicImgUrl + ", botIconMappedAppIcon=" + this.botIconMappedAppIcon + ", extra=" + this.extra + ')';
        }

        public final String getBgImgColor() {
            return this.bgImgColor;
        }

        public final BgImageInfo getBgImgInfo() {
            return this.bgImgInfo;
        }

        public final String getBgImgUri() {
            return this.bgImgUri;
        }

        public final String getBgImgUrl() {
            return this.bgImgUrl;
        }

        public final String getBgVideoModel() {
            return this.bgVideoModel;
        }

        public final String getBio() {
            return this.bio;
        }

        public final String getBioEdit() {
            return this.bioEdit;
        }

        public final List<BotConfItem> getBotConf() {
            return this.botConf;
        }

        public final BotCreatorInfo getBotCreatorInfo() {
            return this.botCreatorInfo;
        }

        public final String getBotIconMappedAppIcon() {
            return this.botIconMappedAppIcon;
        }

        public final Long getBotId() {
            return this.botId;
        }

        public final int getBotMode() {
            return this.botMode;
        }

        public final BotStatistic getBotStatic() {
            return this.botStatic;
        }

        public final Integer getBotType() {
            return this.botType;
        }

        public final String getCallerName() {
            return this.callerName;
        }

        public final Boolean getCallerNameSetting() {
            return this.callerNameSetting;
        }

        public final ConversationPage getConversationPage() {
            return this.conversationPage;
        }

        public final String getDescriptionForHuman() {
            return this.descriptionForHuman;
        }

        public final boolean getDisabled() {
            return this.disabled;
        }

        public final String getDynamicImgUri() {
            return this.dynamicImgUri;
        }

        public final String getDynamicImgUrl() {
            return this.dynamicImgUrl;
        }

        public final String getEditPos() {
            return this.editPos;
        }

        public final Map<String, String> getExtra() {
            return this.extra;
        }

        public final FirstMet getFirstMet() {
            return this.firstMet;
        }

        public final BotIconImage getIconImage() {
            return this.iconImage;
        }

        public final ModelItem getModel() {
            return this.model;
        }

        public final boolean getMuted() {
            return this.muted;
        }

        public final String getName() {
            return this.name;
        }

        public final BotOnBoarding getOnBoarding() {
            return this.onBoarding;
        }

        public final Integer getPrivateStatus() {
            return this.privateStatus;
        }

        public final SceneModelList getSceneModelList() {
            return this.sceneModelList;
        }

        public final BotSwitchConfInfo getSwitchConfInfo() {
            return this.switchConfInfo;
        }

        public final Long getUpdateTime() {
            return this.updateTime;
        }

        public final String getUserBotGender() {
            return this.userBotGender;
        }

        public final String getUserBotType() {
            return this.userBotType;
        }

        public final SpeakerVoice getVoiceType() {
            return this.voiceType;
        }

        public final void setBgImgColor(String r1) {
            this.bgImgColor = r1;
        }

        public final void setBgImgInfo(BgImageInfo r1) {
            this.bgImgInfo = r1;
        }

        public final void setBgImgUri(String r1) {
            this.bgImgUri = r1;
        }

        public final void setBgImgUrl(String r1) {
            this.bgImgUrl = r1;
        }

        public final void setBgVideoModel(String r1) {
            this.bgVideoModel = r1;
        }

        public final void setBotConf(List<BotConfItem> r1) {
            this.botConf = r1;
        }

        public final void setBotIconMappedAppIcon(String r1) {
            this.botIconMappedAppIcon = r1;
        }

        public final void setBotMode(int r1) {
            this.botMode = r1;
        }

        public final void setDisabled(boolean r1) {
            this.disabled = r1;
        }

        public final void setDynamicImgUri(String r1) {
            this.dynamicImgUri = r1;
        }

        public final void setDynamicImgUrl(String r1) {
            this.dynamicImgUrl = r1;
        }

        public final void setFirstMet(FirstMet r1) {
            this.firstMet = r1;
        }

        public final void setSceneModelList(SceneModelList r1) {
            this.sceneModelList = r1;
        }

        public final void setSwitchConfInfo(BotSwitchConfInfo r1) {
            this.switchConfInfo = r1;
        }

        public final void setUserBotGender(String r1) {
            this.userBotGender = r1;
        }

        public final void setUserBotType(String r1) {
            this.userBotType = r1;
        }

        public BotInfo(Long r3, String r4, BotIconImage r5, Long r6, @BotSourceType Integer r7, BotCreatorInfo r8, Integer r9, ConversationPage r10, String r11, ModelItem r12, SpeakerVoice r13, String r14, boolean r15, String r16, String r17, BotStatistic r18, List<BotConfItem> r19, int r20, String r21, String r22, String r23, BotSwitchConfInfo r24, BotOnBoarding r25, String r26, Boolean r27, SceneModelList r28, boolean r29, FirstMet r30, String r31, BgImageInfo r32, String r33, String r34, String r35, String r36, String r37, Map<String, String> r38) {
            this.botId = r3;
            this.name = r4;
            this.iconImage = r5;
            this.updateTime = r6;
            this.botType = r7;
            this.botCreatorInfo = r8;
            this.privateStatus = r9;
            this.conversationPage = r10;
            this.descriptionForHuman = r11;
            this.model = r12;
            this.voiceType = r13;
            this.editPos = r14;
            this.muted = r15;
            this.bioEdit = r16;
            this.bio = r17;
            this.botStatic = r18;
            this.botConf = r19;
            this.botMode = r20;
            this.bgImgUrl = r21;
            this.bgImgColor = r22;
            this.bgVideoModel = r23;
            this.switchConfInfo = r24;
            this.onBoarding = r25;
            this.callerName = r26;
            this.callerNameSetting = r27;
            this.sceneModelList = r28;
            this.disabled = r29;
            this.firstMet = r30;
            this.bgImgUri = r31;
            this.bgImgInfo = r32;
            this.userBotGender = r33;
            this.userBotType = r34;
            this.dynamicImgUri = r35;
            this.dynamicImgUrl = r36;
            this.botIconMappedAppIcon = r37;
            this.extra = r38;
        }

        public /* synthetic */ BotInfo(Long r37, String r38, BotIconImage r39, Long r40, Integer r41, BotCreatorInfo r42, Integer r43, ConversationPage r44, String r45, ModelItem r46, SpeakerVoice r47, String r48, boolean r49, String r50, String r51, BotStatistic r52, List r53, int r54, String r55, String r56, String r57, BotSwitchConfInfo r58, BotOnBoarding r59, String r60, Boolean r61, SceneModelList r62, boolean r63, FirstMet r64, String r65, BgImageInfo r66, String r67, String r68, String r69, String r70, String r71, Map r72, int r73, int r74, DefaultConstructorMarker r75) {
            if ((r73 & 1) == 0) goto L5;
            Long r1 = null;
        L7:
            if ((r73 & 2) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r73 & 4) == 0) goto L13;
            BotIconImage r4 = null;
        L15:
            if ((r73 & 8) == 0) goto L17;
            Long r5 = null;
        L19:
            if ((r73 & 16) == 0) goto L21;
            Integer r6 = null;
        L23:
            if ((r73 & 32) == 0) goto L25;
            BotCreatorInfo r7 = null;
        L27:
            if ((r73 & 64) == 0) goto L29;
            Integer r8 = null;
        L31:
            if ((r73 & 128) == 0) goto L33;
            ConversationPage r9 = null;
        L35:
            if ((r73 & 256) == 0) goto L37;
            String r10 = null;
        L39:
            if ((r73 & 512) == 0) goto L41;
            ModelItem r11 = null;
        L43:
            if ((r73 & 1024) == 0) goto L45;
            SpeakerVoice r12 = null;
        L47:
            if ((r73 & 2048) == 0) goto L49;
            String r13 = null;
        L51:
            if ((r73 & 4096) == 0) goto L53;
            boolean r14 = false;
        L55:
            if ((r73 & 8192) == 0) goto L57;
            String r2 = null;
        L59:
            if ((r73 & 16384) == 0) goto L61;
            String r15 = null;
        L63:
            if ((r73 & 32768) == 0) goto L65;
            BotStatistic r16 = null;
        L67:
            if ((r73 & 65536) == 0) goto L69;
            List r17 = null;
        L71:
            if ((r73 & 131072) == 0) goto L73;
            int r18 = -1;
        L75:
            if ((r73 & 262144) == 0) goto L77;
            String r19 = null;
        L79:
            if ((r73 & 524288) == 0) goto L81;
            String r20 = null;
        L83:
            if ((r73 & 1048576) == 0) goto L85;
            String r21 = null;
        L87:
            if ((r73 & 2097152) == 0) goto L89;
            BotSwitchConfInfo r22 = null;
        L91:
            if ((r73 & 4194304) == 0) goto L93;
            BotOnBoarding r23 = null;
        L95:
            if ((r73 & 8388608) == 0) goto L97;
            String r24 = null;
        L99:
            if ((r73 & 16777216) == 0) goto L101;
            Boolean r25 = Boolean.FALSE;
        L103:
            if ((r73 & 33554432) == 0) goto L105;
            SceneModelList r26 = null;
        L107:
            if ((r73 & 67108864) == 0) goto L109;
            boolean r27 = false;
        L111:
            if ((r73 & 134217728) == 0) goto L113;
            FirstMet r28 = null;
        L115:
            if ((r73 & 268435456) == 0) goto L117;
            String r29 = null;
        L119:
            if ((r73 & 536870912) == 0) goto L121;
            BgImageInfo r30 = null;
        L123:
            if ((r73 & 1073741824) == 0) goto L125;
            String r31 = null;
        L127:
            if ((r73 & Integer.MIN_VALUE) == 0) goto L129;
            String r0 = null;
        L131:
            if ((r74 & 1) == 0) goto L133;
            String r32 = null;
        L135:
            if ((r74 & 2) == 0) goto L137;
            String r33 = null;
        L139:
            if ((r74 & 4) == 0) goto L141;
            String r34 = null;
        L143:
            if ((r74 & 8) == 0) goto L145;
            Map r35 = null;
        L146:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r0, r32, r33, r34, r35);
            return;
        L145:
            r35 = r72;
            goto L146
        L141:
            r34 = r71;
            goto L143
        L137:
            r33 = r70;
            goto L139
        L133:
            r32 = r69;
            goto L135
        L129:
            r0 = r68;
            goto L131
        L125:
            r31 = r67;
            goto L127
        L121:
            r30 = r66;
            goto L123
        L117:
            r29 = r65;
            goto L119
        L113:
            r28 = r64;
            goto L115
        L109:
            r27 = r63;
            goto L111
        L105:
            r26 = r62;
            goto L107
        L101:
            r25 = r61;
            goto L103
        L97:
            r24 = r60;
            goto L99
        L93:
            r23 = r59;
            goto L95
        L89:
            r22 = r58;
            goto L91
        L85:
            r21 = r57;
            goto L87
        L81:
            r20 = r56;
            goto L83
        L77:
            r19 = r55;
            goto L79
        L73:
            r18 = r54;
            goto L75
        L69:
            r17 = r53;
            goto L71
        L65:
            r16 = r52;
            goto L67
        L61:
            r15 = r51;
            goto L63
        L57:
            r2 = r50;
            goto L59
        L53:
            r14 = r49;
            goto L55
        L49:
            r13 = r48;
            goto L51
        L45:
            r12 = r47;
            goto L47
        L41:
            r11 = r46;
            goto L43
        L37:
            r10 = r45;
            goto L39
        L33:
            r9 = r44;
            goto L35
        L29:
            r8 = r43;
            goto L31
        L25:
            r7 = r42;
            goto L27
        L21:
            r6 = r41;
            goto L23
        L17:
            r5 = r40;
            goto L19
        L13:
            r4 = r39;
            goto L15
        L9:
            r3 = r38;
            goto L11
        L5:
            r1 = r37;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$CursorPosition;", "Ljava/io/Serializable;", "startPos", "", "endPos", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getStartPos", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndPos", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/PromptContent$CursorPosition;", "equals", "", "other", "", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class CursorPosition implements Serializable {

        @SerializedName("end_pos")
        private final Integer endPos;

        @SerializedName("start_pos")
        private final Integer startPos;

        public CursorPosition() {
            Integer r0 = null;
            this(r0, r0, 3, r0);
        }

        public static /* synthetic */ CursorPosition copy$default(CursorPosition r0, Integer r1, Integer r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.startPos;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.endPos;
        L9:
            return r0.copy(r1, r2);
        }

        public final Integer component1() {
            return this.startPos;
        }

        public final Integer component2() {
            return this.endPos;
        }

        public final CursorPosition copy(Integer r2, Integer r3) {
            return new CursorPosition(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CursorPosition) == true) goto L8;
            return false;
        L8:
            CursorPosition r6 = (CursorPosition) r5;
            if (Intrinsics.areEqual(this.startPos, r6.startPos) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.endPos, r6.endPos) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Integer r0 = this.startPos;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.endPos;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "CursorPosition(startPos=" + this.startPos + ", endPos=" + this.endPos + ')';
        }

        public final Integer getEndPos() {
            return this.endPos;
        }

        public final Integer getStartPos() {
            return this.startPos;
        }

        public CursorPosition(Integer r1, Integer r2) {
            this.startPos = r1;
            this.endPos = r2;
        }

        public /* synthetic */ CursorPosition(Integer r2, Integer r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$DefaultOptionItem;", "Ljava/io/Serializable;", "label", "", "defaultSelectionId", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getLabel", "()Ljava/lang/String;", "getDefaultSelectionId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/PromptContent$DefaultOptionItem;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class DefaultOptionItem implements Serializable {

        @SerializedName("default_selection_id")
        private final Integer defaultSelectionId;

        @SerializedName("label")
        private final String label;

        /* JADX WARN: Multi-variable type inference failed */
        public DefaultOptionItem() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DefaultOptionItem copy$default(DefaultOptionItem r0, String r1, Integer r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.label;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.defaultSelectionId;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.label;
        }

        public final Integer component2() {
            return this.defaultSelectionId;
        }

        public final DefaultOptionItem copy(String r2, Integer r3) {
            return new DefaultOptionItem(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DefaultOptionItem) == true) goto L8;
            return false;
        L8:
            DefaultOptionItem r6 = (DefaultOptionItem) r5;
            if (Intrinsics.areEqual(this.label, r6.label) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.defaultSelectionId, r6.defaultSelectionId) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.label;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.defaultSelectionId;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "DefaultOptionItem(label=" + this.label + ", defaultSelectionId=" + this.defaultSelectionId + ')';
        }

        public final Integer getDefaultSelectionId() {
            return this.defaultSelectionId;
        }

        public final String getLabel() {
            return this.label;
        }

        public DefaultOptionItem(String r1, Integer r2) {
            this.label = r1;
            this.defaultSelectionId = r2;
        }

        public /* synthetic */ DefaultOptionItem(String r2, Integer r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;", "Ljava/io/Serializable;", "uri", "", "url", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getUri", "()Ljava/lang/String;", "getUrl", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class SuggestImageItem implements Serializable {

        @SerializedName("height")
        private final Integer height;

        @SerializedName("uri")
        private final String uri;

        @SerializedName("url")
        private final String url;

        @SerializedName("width")
        private final Integer width;

        public SuggestImageItem() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ SuggestImageItem copy$default(SuggestImageItem r0, String r1, String r2, Integer r3, Integer r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.uri;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.url;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.width;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.height;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.uri;
        }

        public final String component2() {
            return this.url;
        }

        public final Integer component3() {
            return this.width;
        }

        public final Integer component4() {
            return this.height;
        }

        public final SuggestImageItem copy(String r2, String r3, Integer r4, Integer r5) {
            return new SuggestImageItem(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SuggestImageItem) == true) goto L8;
            return false;
        L8:
            SuggestImageItem r6 = (SuggestImageItem) r5;
            if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.url, r6.url) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.width, r6.width) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.height, r6.height) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r0 = this.uri;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.url;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.width;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.height;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SuggestImageItem(uri=" + this.uri + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ')';
        }

        public final Integer getHeight() {
            return this.height;
        }

        public final String getUri() {
            return this.uri;
        }

        public final String getUrl() {
            return this.url;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public SuggestImageItem(String r1, String r2, Integer r3, Integer r4) {
            this.uri = r1;
            this.url = r2;
            this.width = r3;
            this.height = r4;
        }

        public /* synthetic */ SuggestImageItem(String r2, String r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\bT\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u009d\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b\u0012\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\u0012\b\u0002\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b)\u0010*J\u0007\u0010\u0081\u0001\u001a\u00020\u000bJ\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001J\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\u0092\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0093\u0001J\u0013\u0010\u0094\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001bJ\u0017\u0010\u0095\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bJ\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010,\"\u0004\b8\u0010.R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b\n\u0010;\"\u0004\b<\u0010=R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010,\"\u0004\b@\u0010.R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010,\"\u0004\bB\u0010.R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010,\"\u0004\bD\u0010.R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.R&\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bG\u0010H\u001a\u0004\bI\u0010,\"\u0004\bJ\u0010.R&\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bK\u0010H\u001a\u0004\bL\u0010,\"\u0004\bM\u0010.R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR \u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010O\"\u0004\bS\u0010QR \u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010O\"\u0004\bU\u0010QR \u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010O\"\u0004\bW\u0010QR\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bX\u0010YR \u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010,\"\u0004\b\\\u0010.R.\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R.\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010^\"\u0004\bb\u0010`R\u001e\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010c\"\u0004\bd\u0010eR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b \u0010;\"\u0004\bk\u0010=R\"\u0010!\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\bl\u0010g\"\u0004\bm\u0010iR\"\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\bn\u0010g\"\u0004\bo\u0010iR \u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR \u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010q\"\u0004\bu\u0010sR(\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010(\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b(\u0010;\"\u0004\bz\u0010=R\u001d\u0010{\u001a\u0004\u0018\u00010|X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001¨\u0006\u0097\u0001"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "", "suggest", "", "bgColor", "darkBgColor", "fontColorLight", "fontColorDark", "strokeColorLight", "strokeColorDark", "isHighlightPush", "", "itemId", "itemType", "sendingContent", "schema", "iconUrl", "darkIconUrl", "lightUrlItem", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;", "darkUrlItem", "frontLightUrlItem", "frontDarkUrlItem", "expireTime", "", "wcbItem", "extra", "", "queryPassExtra", "isRichText", "candidateType", "", "isContinueAsk", "textIcon", "position", "displayRichTextContent", "Lcom/google/gson/JsonObject;", "sendRichTextContent", "childCandidates", "", "isCategoryCandidate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;Ljava/lang/Long;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Ljava/util/List;Ljava/lang/Boolean;)V", "getSuggest", "()Ljava/lang/String;", "setSuggest", "(Ljava/lang/String;)V", "getBgColor", "setBgColor", "getDarkBgColor", "setDarkBgColor", "getFontColorLight", "setFontColorLight", "getFontColorDark", "setFontColorDark", "getStrokeColorLight", "setStrokeColorLight", "getStrokeColorDark", "setStrokeColorDark", "()Ljava/lang/Boolean;", "setHighlightPush", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getItemId", "setItemId", "getItemType", "setItemType", "getSendingContent", "setSendingContent", "getSchema", "setSchema", "getIconUrl$annotations", "()V", "getIconUrl", "setIconUrl", "getDarkIconUrl$annotations", "getDarkIconUrl", "setDarkIconUrl", "getLightUrlItem", "()Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;", "setLightUrlItem", "(Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;)V", "getDarkUrlItem", "setDarkUrlItem", "getFrontLightUrlItem", "setFrontLightUrlItem", "getFrontDarkUrlItem", "setFrontDarkUrlItem", "getExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWcbItem", "setWcbItem", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getQueryPassExtra", "setQueryPassExtra", "()Z", "setRichText", "(Z)V", "getCandidateType", "()Ljava/lang/Integer;", "setCandidateType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "setContinueAsk", "getTextIcon", "setTextIcon", "getPosition", "setPosition", "getDisplayRichTextContent", "()Lcom/google/gson/JsonObject;", "setDisplayRichTextContent", "(Lcom/google/gson/JsonObject;)V", "getSendRichTextContent", "setSendRichTextContent", "getChildCandidates", "()Ljava/util/List;", "setChildCandidates", "(Ljava/util/List;)V", "setCategoryCandidate", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "getMarkdownContent", "()Lcom/larus/business/markdown/api/model/MarkdownContent;", "setMarkdownContent", "(Lcom/larus/business/markdown/api/model/MarkdownContent;)V", "isFontBold", "getSuggestV2ExtraForMultiAction", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2ExtraForMultiAction;", "getSuggestedType", "getShowFrom", "getPromptFrom", "getActivityId", "getActionBarTemplateId", "getTemplateSubType", "getTemplateId", "getTemplateVersion", "getTemplateRecExtra", "getTagCode", "getSugBizType", "getRawWcbCandidateType", "getCategoryId", "getRichTextType", "getSelectionPos", "Lkotlin/Pair;", "getSendMsgExtra", "getOMsgExtra", "getImageUrl", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class SuggestItem {

        @SerializedName("background_color")
        private String bgColor;

        @SerializedName("candidate_type")
        private Integer candidateType;

        @SerializedName("child_candidates")
        private List<SuggestItem> childCandidates;

        @SerializedName("dark_background_color")
        private String darkBgColor;

        @SerializedName("dark_icon_url")
        private String darkIconUrl;

        @SerializedName("dark_url_item")
        private SuggestImageItem darkUrlItem;

        @SerializedName("display_rich_text_content")
        private JsonObject displayRichTextContent;

        @SerializedName("expire_time")
        private final Long expireTime;

        @SerializedName("extra")
        private Map<String, String> extra;

        @SerializedName("font_color_dark")
        private String fontColorDark;

        @SerializedName("font_color_light")
        private String fontColorLight;

        @SerializedName("front_dark_url_item")
        private SuggestImageItem frontDarkUrlItem;

        @SerializedName("front_light_url_item")
        private SuggestImageItem frontLightUrlItem;

        @SerializedName("icon_url")
        private String iconUrl;

        @SerializedName("is_category_candidate")
        private Boolean isCategoryCandidate;

        @SerializedName("is_continue_ask")
        private Boolean isContinueAsk;

        @SerializedName("is_highlight_push")
        private Boolean isHighlightPush;

        @SerializedName("is_rich_text")
        private boolean isRichText;

        @SerializedName("item_id")
        private String itemId;

        @SerializedName("item_type")
        private String itemType;

        @SerializedName("light_url_item")
        private SuggestImageItem lightUrlItem;
        private transient l markdownContent;

        @SerializedName("position")
        private Integer position;

        @SerializedName("query_pass_extra")
        private Map<String, String> queryPassExtra;

        @SerializedName("schema")
        private String schema;

        @SerializedName("send_rich_text_content")
        private JsonObject sendRichTextContent;

        @SerializedName("sending_content")
        private String sendingContent;

        @SerializedName("border_color_dark")
        private String strokeColorDark;

        @SerializedName("border_color_light")
        private String strokeColorLight;

        @SerializedName("suggest")
        private String suggest;

        @SerializedName("text_icon")
        private Integer textIcon;

        @SerializedName("wcb_item")
        private String wcbItem;

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/bean/PromptContent$SuggestItem$getOMsgExtra$1$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        public static final class a extends TypeToken<Map<String, ? extends String>> {
            public a() {
            }
        }

        public SuggestItem() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, null);
        }

        @Deprecated(message = "use dark_url_item instead")
        public static /* synthetic */ void getDarkIconUrl$annotations() {
        }

        @Deprecated(message = "use light_url_item instead")
        public static /* synthetic */ void getIconUrl$annotations() {
        }

        public final String getActionBarTemplateId() {
            Map<String, String> r0 = this.extra;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get("action_bar_template_id");
        }

        public final String getActivityId() {
            Map<String, String> r0 = this.extra;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get("activity_id");
        }

        public final String getCategoryId() {
            Map<String, String> r0 = this.extra;
            if (r0 == null) goto L10;
            String r1 = r0.get("category_id");
            if (r1 != null) goto L7;
            return null;
        L7:
            if ((!StringsKt.isBlank(r1)) == true) goto L9;
            return null;
        L9:
            return r1;
        L10:
            return null;
        }

        public final String getImageUrl() {
            SuggestImageItem r0 = this.lightUrlItem;
            if (r0 == null) goto L6;
            String r1 = r0.getUrl();
            if (r1 == null) goto L6;
        L7:
            SuggestImageItem r2 = this.darkUrlItem;
            if (r2 == null) goto L11;
            String r3 = r2.getUrl();
            if (r3 == null) goto L11;
        L12:
            boolean r4 = h.a;
            if (h.a(null) == false) goto L18;
            if (r3 != null) goto L17;
            return r1;
        L17:
            return r3;
        L18:
            return r1;
        L11:
            r3 = this.darkIconUrl;
        L6:
            r1 = this.iconUrl;
            goto L7
        }

        public final Map<String, String> getOMsgExtra() {
            Map<String, String> r0 = this.extra;
            Object r1 = null;
            if (r0 == null) goto L25;
            String r2 = r0.get("o_msg_extra");
            if (r2 == null) goto L26;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
            if (o0.d(r2) == false) goto L9;
            Map r4 = (Map) new Gson().fromJson(r2, new a().getType());     // Catch: Throwable -> L12
        L10:
            Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L12
        L14:
            Throwable r6 = Result.exceptionOrNull-impl(r5);
            if (r6 == null) goto L18;
            FLogger.a.w("SuggestItem", "getOMsgExtra failed, oMsgExtraStr: ".concat(r2), r6);
        L18:
            if (Result.isFailure-impl(r5) == true) goto L22;
            r1 = r5;
        L22:
            return (Map) r1;
        L9:
            r4 = null;
        L12:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        L26:
            return null;
        L25:
            return null;
        }

        public final String getPromptFrom() {
            Map<String, String> r0 = this.extra;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get("prompt_from");
        }

        public final String getRawWcbCandidateType() {
            Map<String, String> r0 = this.extra;
            if (r0 == null) goto L10;
            String r1 = r0.get("candidate_type");
            if (r1 != null) goto L7;
            return null;
        L7:
            if ((!StringsKt.isBlank(r1)) == true) goto L9;
            return null;
        L9:
            return r1;
        L10:
            return null;
        }

        public final String getRichTextType() {
            JsonObject r0 = this.displayRichTextContent;
            boolean r2 = true;
            if (r0 == null) goto L9;
            JsonElement r1 = r0.get("is_rich_text");
            if (r1 == null) goto L9;
            if (r1.getAsBoolean() != true) goto L9;
            boolean r3 = true;
        L10:
            if (r3 == false) goto L12;
            return "display";
        L12:
            JsonObject r4 = this.sendRichTextContent;
            if (r4 == null) goto L19;
            JsonElement r5 = r4.get("is_rich_text");
            if (r5 == null) goto L19;
            if (r5.getAsBoolean() != true) goto L19;
        L20:
            if (r2 == false) goto L23;
            return "send";
        L23:
            if (this.isRichText == false) goto L25;
            return "legacy";
        L25:
            return null;
        L19:
            r2 = false;
        L9:
            r3 = false;
            goto L10
        }

        public final Pair<Integer, Integer> getSelectionPos() {
            Map<String, String> r0 = this.extra;
            if (r0 == null) goto L7;
            String r1 = r0.get("select_start_pos");
            if (r1 == null) goto L7;
            Integer r2 = StringsKt.toIntOrNull(r1);
        L8:
            Map<String, String> r3 = this.extra;
            if (r3 == null) goto L13;
            String r4 = r3.get("select_end_pos");
            if (r4 == null) goto L13;
            Integer r5 = StringsKt.toIntOrNull(r4);
        L14:
            if (r2 == null) goto L18;
            if (r5 == null) goto L18;
            return TuplesKt.to(r2, r5);
        L18:
            return null;
        L13:
            r5 = null;
        L7:
            r2 = null;
            goto L8
        }

        public final Map<String, String> getSendMsgExtra() {
            Map<String, String> r0 = this.queryPassExtra;
            if (r0 == null) goto L18;
            LinkedHashMap r1 = new LinkedHashMap();
            Iterator<Map.Entry<String, String>> r2 = r0.entrySet().iterator();
        L6:
            if (r2.hasNext() == false) goto L13;
            Map.Entry<String, String> r3 = r2.next();
            if (r3.getValue() == null) goto L10;
            boolean r4 = true;
        L11:
            if (r4 == false) goto L6;
            r1.put(r3.getKey(), r3.getValue());
            goto L6
        L10:
            r4 = false;
            goto L11
        L13:
            LinkedHashMap r5 = new LinkedHashMap(MapsKt.mapCapacity(r1.size()));
            Iterator r6 = r1.entrySet().iterator();
        L15:
            if (r6.hasNext() == false) goto L25;
            Map.Entry r7 = (Map.Entry) r6.next();
            Object r8 = r7.getKey();
            Object r9 = r7.getValue();
            Intrinsics.checkNotNull(r9);
            r5.put(r8, (String) r9);
            goto L15
        L25:
            return r5;
        L18:
            return MapsKt.emptyMap();
        }

        public final String getShowFrom() {
            Map<String, String> r0 = this.extra;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get("show_from");
        }

        public final String getSugBizType() {
            Map<String, String> r0 = this.extra;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get("sug_biz_type");
        }

        public final SuggestV2ExtraForMultiAction getSuggestV2ExtraForMultiAction() {
            if (Intrinsics.areEqual(this.itemType, SuggestItemType.FestivalWelcomeBack.getValue()) == true) goto L5;
            return null;
        L5:
            return g.a(this);
        }

        public final String getSuggestedType() {
            Map<String, String> r0 = this.extra;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get("suggested_type");
        }

        public final String getTagCode() {
            Map<String, String> r0 = this.extra;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get("tag_enum_mapping");
        }

        public final String getTemplateId() {
            Map<String, String> r0 = this.extra;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get("template_id");
        }

        public final String getTemplateRecExtra() {
            Map<String, String> r0 = this.extra;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get("template_rec_extra");
        }

        public final String getTemplateSubType() {
            Map<String, String> r0 = this.extra;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get("template_sub_type");
        }

        public final String getTemplateVersion() {
            Map<String, String> r0 = this.extra;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get("template_version");
        }

        public final boolean isFontBold() {
            Map<String, String> r0 = this.extra;
            if (r0 == null) goto L5;
            String r1 = r0.get("is_font_bold");
        L7:
            return Intrinsics.areEqual(r1, "true");
        L5:
            r1 = null;
            goto L7
        }

        public final String getBgColor() {
            return this.bgColor;
        }

        public final Integer getCandidateType() {
            return this.candidateType;
        }

        public final List<SuggestItem> getChildCandidates() {
            return this.childCandidates;
        }

        public final String getDarkBgColor() {
            return this.darkBgColor;
        }

        public final String getDarkIconUrl() {
            return this.darkIconUrl;
        }

        public final SuggestImageItem getDarkUrlItem() {
            return this.darkUrlItem;
        }

        public final JsonObject getDisplayRichTextContent() {
            return this.displayRichTextContent;
        }

        public final Long getExpireTime() {
            return this.expireTime;
        }

        public final Map<String, String> getExtra() {
            return this.extra;
        }

        public final String getFontColorDark() {
            return this.fontColorDark;
        }

        public final String getFontColorLight() {
            return this.fontColorLight;
        }

        public final SuggestImageItem getFrontDarkUrlItem() {
            return this.frontDarkUrlItem;
        }

        public final SuggestImageItem getFrontLightUrlItem() {
            return this.frontLightUrlItem;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final String getItemId() {
            return this.itemId;
        }

        public final String getItemType() {
            return this.itemType;
        }

        public final SuggestImageItem getLightUrlItem() {
            return this.lightUrlItem;
        }

        public final l getMarkdownContent() {
            return this.markdownContent;
        }

        public final Integer getPosition() {
            return this.position;
        }

        public final Map<String, String> getQueryPassExtra() {
            return this.queryPassExtra;
        }

        public final String getSchema() {
            return this.schema;
        }

        public final JsonObject getSendRichTextContent() {
            return this.sendRichTextContent;
        }

        public final String getSendingContent() {
            return this.sendingContent;
        }

        public final String getStrokeColorDark() {
            return this.strokeColorDark;
        }

        public final String getStrokeColorLight() {
            return this.strokeColorLight;
        }

        public final String getSuggest() {
            return this.suggest;
        }

        public final Integer getTextIcon() {
            return this.textIcon;
        }

        public final String getWcbItem() {
            return this.wcbItem;
        }

        public final Boolean isCategoryCandidate() {
            return this.isCategoryCandidate;
        }

        public final Boolean isContinueAsk() {
            return this.isContinueAsk;
        }

        public final Boolean isHighlightPush() {
            return this.isHighlightPush;
        }

        public final boolean isRichText() {
            return this.isRichText;
        }

        public final void setBgColor(String r1) {
            this.bgColor = r1;
        }

        public final void setCandidateType(Integer r1) {
            this.candidateType = r1;
        }

        public final void setCategoryCandidate(Boolean r1) {
            this.isCategoryCandidate = r1;
        }

        public final void setChildCandidates(List<SuggestItem> r1) {
            this.childCandidates = r1;
        }

        public final void setContinueAsk(Boolean r1) {
            this.isContinueAsk = r1;
        }

        public final void setDarkBgColor(String r1) {
            this.darkBgColor = r1;
        }

        public final void setDarkIconUrl(String r1) {
            this.darkIconUrl = r1;
        }

        public final void setDarkUrlItem(SuggestImageItem r1) {
            this.darkUrlItem = r1;
        }

        public final void setDisplayRichTextContent(JsonObject r1) {
            this.displayRichTextContent = r1;
        }

        public final void setExtra(Map<String, String> r1) {
            this.extra = r1;
        }

        public final void setFontColorDark(String r1) {
            this.fontColorDark = r1;
        }

        public final void setFontColorLight(String r1) {
            this.fontColorLight = r1;
        }

        public final void setFrontDarkUrlItem(SuggestImageItem r1) {
            this.frontDarkUrlItem = r1;
        }

        public final void setFrontLightUrlItem(SuggestImageItem r1) {
            this.frontLightUrlItem = r1;
        }

        public final void setHighlightPush(Boolean r1) {
            this.isHighlightPush = r1;
        }

        public final void setIconUrl(String r1) {
            this.iconUrl = r1;
        }

        public final void setItemId(String r1) {
            this.itemId = r1;
        }

        public final void setItemType(String r1) {
            this.itemType = r1;
        }

        public final void setLightUrlItem(SuggestImageItem r1) {
            this.lightUrlItem = r1;
        }

        public final void setMarkdownContent(l r1) {
            this.markdownContent = r1;
        }

        public final void setPosition(Integer r1) {
            this.position = r1;
        }

        public final void setQueryPassExtra(Map<String, String> r1) {
            this.queryPassExtra = r1;
        }

        public final void setRichText(boolean r1) {
            this.isRichText = r1;
        }

        public final void setSchema(String r1) {
            this.schema = r1;
        }

        public final void setSendRichTextContent(JsonObject r1) {
            this.sendRichTextContent = r1;
        }

        public final void setSendingContent(String r1) {
            this.sendingContent = r1;
        }

        public final void setStrokeColorDark(String r1) {
            this.strokeColorDark = r1;
        }

        public final void setStrokeColorLight(String r1) {
            this.strokeColorLight = r1;
        }

        public final void setSuggest(String r1) {
            this.suggest = r1;
        }

        public final void setTextIcon(Integer r1) {
            this.textIcon = r1;
        }

        public final void setWcbItem(String r1) {
            this.wcbItem = r1;
        }

        public SuggestItem(String r3, String r4, String r5, String r6, String r7, String r8, String r9, Boolean r10, String r11, String r12, String r13, String r14, String r15, String r16, SuggestImageItem r17, SuggestImageItem r18, SuggestImageItem r19, SuggestImageItem r20, Long r21, String r22, Map<String, String> r23, Map<String, String> r24, boolean r25, Integer r26, Boolean r27, Integer r28, Integer r29, JsonObject r30, JsonObject r31, List<SuggestItem> r32, Boolean r33) {
            this.suggest = r3;
            this.bgColor = r4;
            this.darkBgColor = r5;
            this.fontColorLight = r6;
            this.fontColorDark = r7;
            this.strokeColorLight = r8;
            this.strokeColorDark = r9;
            this.isHighlightPush = r10;
            this.itemId = r11;
            this.itemType = r12;
            this.sendingContent = r13;
            this.schema = r14;
            this.iconUrl = r15;
            this.darkIconUrl = r16;
            this.lightUrlItem = r17;
            this.darkUrlItem = r18;
            this.frontLightUrlItem = r19;
            this.frontDarkUrlItem = r20;
            this.expireTime = r21;
            this.wcbItem = r22;
            this.extra = r23;
            this.queryPassExtra = r24;
            this.isRichText = r25;
            this.candidateType = r26;
            this.isContinueAsk = r27;
            this.textIcon = r28;
            this.position = r29;
            this.displayRichTextContent = r30;
            this.sendRichTextContent = r31;
            this.childCandidates = r32;
            this.isCategoryCandidate = r33;
        }

        public /* synthetic */ SuggestItem(String r33, String r34, String r35, String r36, String r37, String r38, String r39, Boolean r40, String r41, String r42, String r43, String r44, String r45, String r46, SuggestImageItem r47, SuggestImageItem r48, SuggestImageItem r49, SuggestImageItem r50, Long r51, String r52, Map r53, Map r54, boolean r55, Integer r56, Boolean r57, Integer r58, Integer r59, JsonObject r60, JsonObject r61, List r62, Boolean r63, int r64, DefaultConstructorMarker r65) {
            if ((r64 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r64 & 2) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r64 & 4) == 0) goto L13;
            String r4 = null;
        L15:
            if ((r64 & 8) == 0) goto L17;
            String r5 = null;
        L19:
            if ((r64 & 16) == 0) goto L21;
            String r6 = null;
        L23:
            if ((r64 & 32) == 0) goto L25;
            String r7 = null;
        L27:
            if ((r64 & 64) == 0) goto L29;
            String r8 = null;
        L31:
            if ((r64 & 128) == 0) goto L33;
            Boolean r9 = Boolean.FALSE;
        L35:
            if ((r64 & 256) == 0) goto L37;
            String r10 = null;
        L39:
            if ((r64 & 512) == 0) goto L41;
            String r11 = null;
        L43:
            if ((r64 & 1024) == 0) goto L45;
            String r12 = null;
        L47:
            if ((r64 & 2048) == 0) goto L49;
            String r13 = null;
        L51:
            if ((r64 & 4096) == 0) goto L53;
            String r14 = null;
        L55:
            if ((r64 & 8192) == 0) goto L57;
            String r15 = null;
        L59:
            if ((r64 & 16384) == 0) goto L61;
            SuggestImageItem r2 = null;
        L63:
            if ((r64 & 32768) == 0) goto L65;
            SuggestImageItem r16 = null;
        L67:
            if ((r64 & 65536) == 0) goto L69;
            SuggestImageItem r17 = null;
        L71:
            if ((r64 & 131072) == 0) goto L73;
            SuggestImageItem r18 = null;
        L75:
            if ((r64 & 262144) == 0) goto L77;
            Long r19 = null;
        L79:
            if ((r64 & 524288) == 0) goto L81;
            String r20 = null;
        L83:
            if ((r64 & 1048576) == 0) goto L85;
            Map r21 = null;
        L87:
            if ((r64 & 2097152) == 0) goto L89;
            Map r22 = null;
        L91:
            if ((r64 & 4194304) == 0) goto L93;
            boolean r23 = false;
        L95:
            if ((r64 & 8388608) == 0) goto L97;
            Integer r24 = null;
        L99:
            if ((r64 & 16777216) == 0) goto L101;
            Boolean r25 = null;
        L103:
            if ((r64 & 33554432) == 0) goto L105;
            Integer r26 = null;
        L107:
            if ((r64 & 67108864) == 0) goto L109;
            Integer r27 = null;
        L111:
            if ((r64 & 134217728) == 0) goto L113;
            JsonObject r28 = null;
        L115:
            if ((r64 & 268435456) == 0) goto L117;
            JsonObject r29 = null;
        L119:
            if ((r64 & 536870912) == 0) goto L121;
            List r30 = null;
        L123:
            if ((r64 & 1073741824) == 0) goto L125;
            Boolean r0 = null;
        L126:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r0);
            return;
        L125:
            r0 = r63;
            goto L126
        L121:
            r30 = r62;
            goto L123
        L117:
            r29 = r61;
            goto L119
        L113:
            r28 = r60;
            goto L115
        L109:
            r27 = r59;
            goto L111
        L105:
            r26 = r58;
            goto L107
        L101:
            r25 = r57;
            goto L103
        L97:
            r24 = r56;
            goto L99
        L93:
            r23 = r55;
            goto L95
        L89:
            r22 = r54;
            goto L91
        L85:
            r21 = r53;
            goto L87
        L81:
            r20 = r52;
            goto L83
        L77:
            r19 = r51;
            goto L79
        L73:
            r18 = r50;
            goto L75
        L69:
            r17 = r49;
            goto L71
        L65:
            r16 = r48;
            goto L67
        L61:
            r2 = r47;
            goto L63
        L57:
            r15 = r46;
            goto L59
        L53:
            r14 = r45;
            goto L55
        L49:
            r13 = r44;
            goto L51
        L45:
            r12 = r43;
            goto L47
        L41:
            r11 = r42;
            goto L43
        L37:
            r10 = r41;
            goto L39
        L33:
            r9 = r40;
            goto L35
        L29:
            r8 = r39;
            goto L31
        L25:
            r7 = r38;
            goto L27
        L21:
            r6 = r37;
            goto L23
        L17:
            r5 = r36;
            goto L19
        L13:
            r4 = r35;
            goto L15
        L9:
            r3 = r34;
            goto L11
        L5:
            r1 = r33;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItemType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Bot", "Text", "HotNews", "TextToImg", "TelUGCBot", "Camera", "TelMainBot", "Album", "VLM", "FestivalWelcomeBack", "WcbCreation", "WcbCreationAlbum", "WcbCreationSameStyle", "WcbCreationAlbumMulti", "JumpSchema", "FillInput", "CameraNew", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum SuggestItemType extends Enum<SuggestItemType> {
        public static final SuggestItemType Album = null;
        public static final SuggestItemType Bot = null;
        public static final SuggestItemType Camera = null;
        public static final SuggestItemType CameraNew = null;
        public static final SuggestItemType FestivalWelcomeBack = null;
        public static final SuggestItemType FillInput = null;
        public static final SuggestItemType HotNews = null;
        public static final SuggestItemType JumpSchema = null;
        public static final SuggestItemType TelMainBot = null;
        public static final SuggestItemType TelUGCBot = null;
        public static final SuggestItemType Text = null;
        public static final SuggestItemType TextToImg = null;
        public static final SuggestItemType VLM = null;
        public static final SuggestItemType WcbCreation = null;
        public static final SuggestItemType WcbCreationAlbum = null;
        public static final SuggestItemType WcbCreationAlbumMulti = null;
        public static final SuggestItemType WcbCreationSameStyle = null;
        public static final /* synthetic */ SuggestItemType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<SuggestItemType> getEntries() {
            return b;
        }

        static {
            SuggestItemType r0 = new SuggestItemType("Bot", 0, "101");
            Bot = r0;
            SuggestItemType r1 = new SuggestItemType("Text", 1, "103");
            Text = r1;
            SuggestItemType r2 = new SuggestItemType("HotNews", 2, "108");
            HotNews = r2;
            SuggestItemType r4 = new SuggestItemType("TextToImg", 3, "111");
            TextToImg = r4;
            SuggestItemType r6 = new SuggestItemType("TelUGCBot", 4, "120");
            TelUGCBot = r6;
            SuggestItemType r8 = new SuggestItemType("Camera", 5, "112");
            Camera = r8;
            SuggestItemType r10 = new SuggestItemType("TelMainBot", 6, "113");
            TelMainBot = r10;
            SuggestItemType r12 = new SuggestItemType("Album", 7, "114");
            Album = r12;
            SuggestItemType r14 = new SuggestItemType("VLM", 8, "115");
            VLM = r14;
            SuggestItemType r13 = new SuggestItemType("FestivalWelcomeBack", 9, "200");
            FestivalWelcomeBack = r13;
            SuggestItemType r11 = new SuggestItemType("WcbCreation", 10, "201");
            WcbCreation = r11;
            SuggestItemType r9 = new SuggestItemType("WcbCreationAlbum", 11, "202");
            WcbCreationAlbum = r9;
            SuggestItemType r7 = new SuggestItemType("WcbCreationSameStyle", 12, "211");
            WcbCreationSameStyle = r7;
            SuggestItemType r5 = new SuggestItemType("WcbCreationAlbumMulti", 13, "212");
            WcbCreationAlbumMulti = r5;
            SuggestItemType r3 = new SuggestItemType("JumpSchema", 14, "301");
            JumpSchema = r3;
            SuggestItemType r15 = new SuggestItemType("FillInput", 15, "501");
            FillInput = r15;
            SuggestItemType r16 = new SuggestItemType("CameraNew", 16, "502");
            CameraNew = r16;
            SuggestItemType[] r17 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16};
            a = r17;
            b = EnumEntriesKt.enumEntries(r17);
        }

        public static SuggestItemType[] values() {
            return (SuggestItemType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static SuggestItemType valueOf(String r1) {
            return (SuggestItemType) r27.a.a(SuggestItemType.class, r1);
        }

        public SuggestItemType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestPromptType;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SuggestPromptType {
        public static final int BOT = 2;
        public static final int COMMUNITY_CREATION = 5;
        public static final a Companion = null;
        public static final int ENTRY = 3;
        public static final int PODCAST = 4;
        public static final int TEXT = 1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\b\u00103\u001a\u0004\u0018\u000100J\b\u00105\u001a\u0004\u0018\u000102R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2;", "Ljava/io/Serializable;", "suggestType", "", "content", "", "iconUrl", "darkIconUrl", "iconUri", "fontColorLight", "fontColorDark", "strokeColorLight", "strokeColorDark", "clickUrl", "botId", "extra", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSuggestType", "()Ljava/lang/Integer;", "setSuggestType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getDarkIconUrl", "setDarkIconUrl", "getIconUri", "setIconUri", "getFontColorLight", "setFontColorLight", "getFontColorDark", "setFontColorDark", "getStrokeColorLight", "setStrokeColorLight", "getStrokeColorDark", "setStrokeColorDark", "getClickUrl", "setClickUrl", "getBotId", "setBotId", "getExtra", "setExtra", "_suggestV2ExtraForMultiAction", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2ExtraForMultiAction;", "suggestV2Extra", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2Extra;", "getSuggestV2ExtForMultiAction", "_suggestV2Extra", "getSuggestV2Extra", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class SuggestV2 implements Serializable {
        private SuggestV2Extra _suggestV2Extra;
        private SuggestV2ExtraForMultiAction _suggestV2ExtraForMultiAction;

        @SerializedName("bot_id")
        private String botId;

        @SerializedName("click_url")
        private String clickUrl;

        @SerializedName("content")
        private String content;

        @SerializedName("dark_icon_url")
        private String darkIconUrl;

        @SerializedName("extra")
        private String extra;

        @SerializedName("font_color_dark")
        private String fontColorDark;

        @SerializedName("font_color_light")
        private String fontColorLight;

        @SerializedName("icon_uri")
        private String iconUri;

        @SerializedName("icon_url")
        private String iconUrl;

        @SerializedName("border_color_dark")
        private String strokeColorDark;

        @SerializedName("border_color_light")
        private String strokeColorLight;

        @SerializedName("suggest_type")
        private Integer suggestType;
        private SuggestV2Extra suggestV2Extra;

        public SuggestV2() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
        }

        public final SuggestV2ExtraForMultiAction getSuggestV2ExtForMultiAction() {
            SuggestV2ExtraForMultiAction r0 = this._suggestV2ExtraForMultiAction;
            if (r0 == null) goto L25;
            return r0;
        L25:
        L21:
            e = move-exception;
            FLogger.a.e("PromptContent", "getSuggestPromptExtra error >>> " + e);
        L24:
            return this._suggestV2ExtraForMultiAction;
        L6:
            if (o0.d(this.extra) == false) goto L24;
            SuggestV2ExtraForMultiAction r1 = (SuggestV2ExtraForMultiAction) new Gson().fromJson(this.extra, SuggestV2ExtraForMultiAction.class);     // Catch: Exception -> L21
            this._suggestV2ExtraForMultiAction = r1;     // Catch: Exception -> L21
            if (r1 == null) goto L10;
            r1.setBotId(this.botId);     // Catch: Exception -> L21
        L10:
            SuggestV2ExtraForMultiAction r2 = this._suggestV2ExtraForMultiAction;     // Catch: Exception -> L21
            if (r2 == null) goto L24;
            Integer r3 = this.suggestType;     // Catch: Exception -> L21
            if (r3 != null) goto L16;
        L18:
            String r4 = "spring_suggest";
        L19:
            r2.setSuggestType(r4);     // Catch: Exception -> L21
            goto L24
        L16:
            if (r3.intValue() != 5) goto L18;
            r4 = "ai_generate_suggest";
            goto L19
        }

        public final SuggestV2Extra getSuggestV2Extra() {
            SuggestV2Extra r1 = this._suggestV2Extra;
            if (r1 == null) goto L5;
            return r1;
        L5:
            a r2 = PromptContent.Companion;
            String r3 = this.extra;
            r2.getClass();
            SuggestV2Extra r4 = a.a(r3);
            if (r4 != null) goto L8;
            r4 = new SuggestV2Extra(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        L8:
            this._suggestV2Extra = r4;
            return r4;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final String getClickUrl() {
            return this.clickUrl;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDarkIconUrl() {
            return this.darkIconUrl;
        }

        public final String getExtra() {
            return this.extra;
        }

        public final String getFontColorDark() {
            return this.fontColorDark;
        }

        public final String getFontColorLight() {
            return this.fontColorLight;
        }

        public final String getIconUri() {
            return this.iconUri;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final String getStrokeColorDark() {
            return this.strokeColorDark;
        }

        public final String getStrokeColorLight() {
            return this.strokeColorLight;
        }

        public final Integer getSuggestType() {
            return this.suggestType;
        }

        public final void setBotId(String r1) {
            this.botId = r1;
        }

        public final void setClickUrl(String r1) {
            this.clickUrl = r1;
        }

        public final void setContent(String r1) {
            this.content = r1;
        }

        public final void setDarkIconUrl(String r1) {
            this.darkIconUrl = r1;
        }

        public final void setExtra(String r1) {
            this.extra = r1;
        }

        public final void setFontColorDark(String r1) {
            this.fontColorDark = r1;
        }

        public final void setFontColorLight(String r1) {
            this.fontColorLight = r1;
        }

        public final void setIconUri(String r1) {
            this.iconUri = r1;
        }

        public final void setIconUrl(String r1) {
            this.iconUrl = r1;
        }

        public final void setStrokeColorDark(String r1) {
            this.strokeColorDark = r1;
        }

        public final void setStrokeColorLight(String r1) {
            this.strokeColorLight = r1;
        }

        public final void setSuggestType(Integer r1) {
            this.suggestType = r1;
        }

        public SuggestV2(Integer r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12) {
            this.suggestType = r1;
            this.content = r2;
            this.iconUrl = r3;
            this.darkIconUrl = r4;
            this.iconUri = r5;
            this.fontColorLight = r6;
            this.fontColorDark = r7;
            this.strokeColorLight = r8;
            this.strokeColorDark = r9;
            this.clickUrl = r10;
            this.botId = r11;
            this.extra = r12;
        }

        public /* synthetic */ SuggestV2(Integer r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, int r26, DefaultConstructorMarker r27) {
            if ((r26 & 1) == 0) goto L5;
            Integer r1 = 1;
        L6:
            String r3 = null;
            if ((r26 & 2) == 0) goto L9;
            String r2 = null;
        L11:
            if ((r26 & 4) == 0) goto L13;
            String r4 = null;
        L15:
            if ((r26 & 8) == 0) goto L17;
            String r5 = null;
        L19:
            if ((r26 & 16) == 0) goto L21;
            String r6 = null;
        L23:
            if ((r26 & 32) == 0) goto L25;
            String r7 = null;
        L27:
            if ((r26 & 64) == 0) goto L29;
            String r8 = null;
        L31:
            if ((r26 & 128) == 0) goto L33;
            String r9 = null;
        L35:
            if ((r26 & 256) == 0) goto L37;
            String r10 = null;
        L39:
            if ((r26 & 512) == 0) goto L41;
            String r11 = null;
        L43:
            if ((r26 & 1024) == 0) goto L45;
            String r12 = null;
        L47:
            if ((r26 & 2048) != 0) goto L50;
            r3 = r25;
        L50:
            this(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r3);
            return;
        L45:
            r12 = r24;
            goto L47
        L41:
            r11 = r23;
            goto L43
        L37:
            r10 = r22;
            goto L39
        L33:
            r9 = r21;
            goto L35
        L29:
            r8 = r20;
            goto L31
        L25:
            r7 = r19;
            goto L27
        L21:
            r6 = r18;
            goto L23
        L17:
            r5 = r17;
            goto L19
        L13:
            r4 = r16;
            goto L15
        L9:
            r2 = r15;
            goto L11
        L5:
            r1 = r14;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b#\b\u0007\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0014¨\u0006-"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2Extra;", "Ljava/io/Serializable;", "requestId", "", "recommendBot1StType", "recommendBot2ndType", "recommendBot3StType", "bgImgUrl", "bgImgColor", "rsItemId", "", "rsRequestId", "deepResearchPhase", "deepResearchEntrance", "deepResearchId", "needDeepThink", "sendPrompt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "getRecommendBot1StType", "setRecommendBot1StType", "getRecommendBot2ndType", "setRecommendBot2ndType", "getRecommendBot3StType", "setRecommendBot3StType", "getBgImgUrl", "setBgImgUrl", "getBgImgColor", "setBgImgColor", "getRsItemId", "()Ljava/lang/Long;", "setRsItemId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getRsRequestId", "setRsRequestId", "getDeepResearchPhase", "getDeepResearchEntrance", "getDeepResearchId", "getNeedDeepThink", "getSendPrompt", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class SuggestV2Extra implements Serializable {

        @SerializedName("bg_img_avg_hue")
        private String bgImgColor;

        @SerializedName("bg_img_url")
        private String bgImgUrl;

        @SerializedName("deep_research_entrance")
        private final String deepResearchEntrance;

        @SerializedName("deep_research_id")
        private final String deepResearchId;

        @SerializedName("deep_research_phase")
        private final String deepResearchPhase;

        @SerializedName("need_deep_think")
        private final String needDeepThink;

        @SerializedName("recommend_bot_1st_type")
        private String recommendBot1StType;

        @SerializedName("recommend_bot_2nd_type")
        private String recommendBot2ndType;

        @SerializedName("recommend_bot_3rd_type")
        private String recommendBot3StType;

        @SerializedName("request_id")
        private String requestId;

        @SerializedName("rs_item_id")
        private Long rsItemId;

        @SerializedName("rs_req_id")
        private String rsRequestId;

        @SerializedName("send_prompt")
        private final String sendPrompt;

        public SuggestV2Extra() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        }

        public final String getBgImgColor() {
            return this.bgImgColor;
        }

        public final String getBgImgUrl() {
            return this.bgImgUrl;
        }

        public final String getDeepResearchEntrance() {
            return this.deepResearchEntrance;
        }

        public final String getDeepResearchId() {
            return this.deepResearchId;
        }

        public final String getDeepResearchPhase() {
            return this.deepResearchPhase;
        }

        public final String getNeedDeepThink() {
            return this.needDeepThink;
        }

        public final String getRecommendBot1StType() {
            return this.recommendBot1StType;
        }

        public final String getRecommendBot2ndType() {
            return this.recommendBot2ndType;
        }

        public final String getRecommendBot3StType() {
            return this.recommendBot3StType;
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public final Long getRsItemId() {
            return this.rsItemId;
        }

        public final String getRsRequestId() {
            return this.rsRequestId;
        }

        public final String getSendPrompt() {
            return this.sendPrompt;
        }

        public final void setBgImgColor(String r1) {
            this.bgImgColor = r1;
        }

        public final void setBgImgUrl(String r1) {
            this.bgImgUrl = r1;
        }

        public final void setRecommendBot1StType(String r1) {
            this.recommendBot1StType = r1;
        }

        public final void setRecommendBot2ndType(String r1) {
            this.recommendBot2ndType = r1;
        }

        public final void setRecommendBot3StType(String r1) {
            this.recommendBot3StType = r1;
        }

        public final void setRequestId(String r1) {
            this.requestId = r1;
        }

        public final void setRsItemId(Long r1) {
            this.rsItemId = r1;
        }

        public final void setRsRequestId(String r1) {
            this.rsRequestId = r1;
        }

        public SuggestV2Extra(String r1, String r2, String r3, String r4, String r5, String r6, Long r7, String r8, String r9, String r10, String r11, String r12, String r13) {
            this.requestId = r1;
            this.recommendBot1StType = r2;
            this.recommendBot2ndType = r3;
            this.recommendBot3StType = r4;
            this.bgImgUrl = r5;
            this.bgImgColor = r6;
            this.rsItemId = r7;
            this.rsRequestId = r8;
            this.deepResearchPhase = r9;
            this.deepResearchEntrance = r10;
            this.deepResearchId = r11;
            this.needDeepThink = r12;
            this.sendPrompt = r13;
        }

        public /* synthetic */ SuggestV2Extra(String r15, String r16, String r17, String r18, String r19, String r20, Long r21, String r22, String r23, String r24, String r25, String r26, String r27, int r28, DefaultConstructorMarker r29) {
            String r2 = null;
            if ((r28 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r28 & 2) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r28 & 4) == 0) goto L13;
            String r4 = null;
        L15:
            if ((r28 & 8) == 0) goto L17;
            String r5 = null;
        L19:
            if ((r28 & 16) == 0) goto L21;
            String r6 = null;
        L23:
            if ((r28 & 32) == 0) goto L25;
            String r7 = null;
        L27:
            if ((r28 & 64) == 0) goto L29;
            Long r8 = null;
        L31:
            if ((r28 & 128) == 0) goto L33;
            String r9 = null;
        L35:
            if ((r28 & 256) == 0) goto L37;
            String r10 = null;
        L39:
            if ((r28 & 512) == 0) goto L41;
            String r11 = null;
        L43:
            if ((r28 & 1024) == 0) goto L45;
            String r12 = null;
        L47:
            if ((r28 & 2048) == 0) goto L49;
            String r13 = null;
        L51:
            if ((r28 & 4096) != 0) goto L54;
            r2 = r27;
        L54:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r2);
            return;
        L49:
            r13 = r26;
            goto L51
        L45:
            r12 = r25;
            goto L47
        L41:
            r11 = r24;
            goto L43
        L37:
            r10 = r23;
            goto L39
        L33:
            r9 = r22;
            goto L35
        L29:
            r8 = r21;
            goto L31
        L25:
            r7 = r20;
            goto L27
        L21:
            r6 = r19;
            goto L23
        L17:
            r5 = r18;
            goto L19
        L13:
            r4 = r17;
            goto L15
        L9:
            r3 = r16;
            goto L11
        L5:
            r1 = r15;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B»\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\b\u00109\u001a\u0004\u0018\u000103J\u0010\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u000105J\b\u0010;\u001a\u0004\u0018\u000108R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0019\u0010\u001aR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u001aR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u001aR \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u001aR \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u001aR \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u001aR \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u001aR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u001aR\u001c\u0010/\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u001aR\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2ExtraForMultiAction;", "Ljava/io/Serializable;", "suggestActionType", "", "actionBarItemId", "actionBarTemplateId", "actionBarKey", "isFontBold", "msgExt", "cursorPos", "userPrompt", "schemaUrl", "speechKey", "actionBarDefaultSelectionCfg", "botInfo", "showFrom", "suggestStyle", "botId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSuggestActionType", "()Ljava/lang/String;", "getActionBarItemId", "getActionBarTemplateId", "getActionBarKey", "setFontBold", "(Ljava/lang/String;)V", "getMsgExt", "setMsgExt", "getCursorPos", "setCursorPos", "getUserPrompt", "setUserPrompt", "getSchemaUrl", "setSchemaUrl", "getSpeechKey", "setSpeechKey", "getActionBarDefaultSelectionCfg", "setActionBarDefaultSelectionCfg", "getBotInfo", "setBotInfo", "getShowFrom", "setShowFrom", "getSuggestStyle", "setSuggestStyle", "getBotId", "setBotId", "suggestType", "getSuggestType", "setSuggestType", "_cursorPosition", "Lcom/larus/bmhome/chat/bean/PromptContent$CursorPosition;", "_defaultOptionList", "", "Lcom/larus/bmhome/chat/bean/PromptContent$DefaultOptionItem;", "_botInfo", "Lcom/larus/bmhome/chat/bean/PromptContent$BotInfo;", "getCursorPosition", "getDefaultOptionList", "getBotInfoModel", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class SuggestV2ExtraForMultiAction implements Serializable {
        public static final a Companion = null;
        public static final String KEY_IMAGE_ASPECT_RATIO = "image_gen_aspect_ratio";
        public static final String KEY_IMAGE_GEN_STYLE_BTN = "image_gen_style_btn";
        public static final String KEY_MUSIC_GENRE = "music_genre";
        public static final String KEY_MUSIC_MOOD = "music_mood";
        public static final String KEY_MUSIC_VOCAL = "music_vocal";
        private BotInfo _botInfo;
        private CursorPosition _cursorPosition;
        private List<DefaultOptionItem> _defaultOptionList;

        @SerializedName("actionbar_default_selection_cfg")
        private String actionBarDefaultSelectionCfg;

        @SerializedName("actionbar_item_id")
        private final String actionBarItemId;

        @SerializedName("actionbar_key")
        private final String actionBarKey;

        @SerializedName("actionbar_template_id")
        private final String actionBarTemplateId;
        private transient String botId;

        @SerializedName("bot_info")
        private String botInfo;

        @SerializedName("cursor_pos")
        private String cursorPos;

        @SerializedName("is_font_bold")
        private String isFontBold;

        @SerializedName(ChatDraftItem.TYPE_MSG_EXT)
        private String msgExt;

        @SerializedName("schema_url")
        private String schemaUrl;

        @SerializedName("show_from")
        private String showFrom;

        @SerializedName("speech_key")
        private String speechKey;

        @SerializedName("suggest_action_type")
        private final String suggestActionType;

        @SerializedName("suggest_style")
        private String suggestStyle;
        private String suggestType;

        @SerializedName("user_prompt")
        private String userPrompt;

        public static final class a {
            public a() {
            }
        }

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/bean/PromptContent$SuggestV2ExtraForMultiAction$getDefaultOptionList$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/bmhome/chat/bean/PromptContent$DefaultOptionItem;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        public static final class b extends TypeToken<List<? extends DefaultOptionItem>> {
            public b() {
            }
        }

        static {
            Companion = new a();
        }

        public SuggestV2ExtraForMultiAction() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }

        public final BotInfo getBotInfoModel() {
            BotInfo r0 = this._botInfo;
            if (r0 == null) goto L11;
            return r0;
        L11:
            BotInfo r1 = (BotInfo) new Gson().fromJson(this.botInfo, BotInfo.class);     // Catch: Exception -> L7
        L9:
            this._botInfo = r1;
            return r1;
        L7:
            e = move-exception;
            FLogger.a.e("PromptContent", "getBotInfo error >>> " + e);
            r1 = null;
            goto L9
        }

        public final CursorPosition getCursorPosition() {
            CursorPosition r0 = this._cursorPosition;
            if (r0 == null) goto L11;
            return r0;
        L11:
            CursorPosition r1 = (CursorPosition) new Gson().fromJson(this.cursorPos, CursorPosition.class);     // Catch: Exception -> L7
        L9:
            this._cursorPosition = r1;
            return r1;
        L7:
            e = move-exception;
            FLogger.a.e("PromptContent", "getCursorPosition error >>> " + e);
            r1 = null;
            goto L9
        }

        public final List<DefaultOptionItem> getDefaultOptionList() {
            List<DefaultOptionItem> r0 = this._defaultOptionList;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Type r1 = new b().getType();
            FLogger.a.i("PromptContent", "instructionDefaultParams, actionBarDefaultSelectionCfg " + this.actionBarDefaultSelectionCfg);
            List<DefaultOptionItem> r2 = (List) new Gson().fromJson(this.actionBarDefaultSelectionCfg, r1);     // Catch: Exception -> L8
        L10:
            this._defaultOptionList = r2;
            return r2;
        L8:
            e = move-exception;
            FLogger.a.e("PromptContent", "getDefaultOptionList error >>> " + e);
            r2 = null;
            goto L10
        }

        public final String getActionBarDefaultSelectionCfg() {
            return this.actionBarDefaultSelectionCfg;
        }

        public final String getActionBarItemId() {
            return this.actionBarItemId;
        }

        public final String getActionBarKey() {
            return this.actionBarKey;
        }

        public final String getActionBarTemplateId() {
            return this.actionBarTemplateId;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final String getBotInfo() {
            return this.botInfo;
        }

        public final String getCursorPos() {
            return this.cursorPos;
        }

        public final String getMsgExt() {
            return this.msgExt;
        }

        public final String getSchemaUrl() {
            return this.schemaUrl;
        }

        public final String getShowFrom() {
            return this.showFrom;
        }

        public final String getSpeechKey() {
            return this.speechKey;
        }

        public final String getSuggestActionType() {
            return this.suggestActionType;
        }

        public final String getSuggestStyle() {
            return this.suggestStyle;
        }

        public final String getSuggestType() {
            return this.suggestType;
        }

        public final String getUserPrompt() {
            return this.userPrompt;
        }

        public final String isFontBold() {
            return this.isFontBold;
        }

        public final void setActionBarDefaultSelectionCfg(String r1) {
            this.actionBarDefaultSelectionCfg = r1;
        }

        public final void setBotId(String r1) {
            this.botId = r1;
        }

        public final void setBotInfo(String r1) {
            this.botInfo = r1;
        }

        public final void setCursorPos(String r1) {
            this.cursorPos = r1;
        }

        public final void setFontBold(String r1) {
            this.isFontBold = r1;
        }

        public final void setMsgExt(String r1) {
            this.msgExt = r1;
        }

        public final void setSchemaUrl(String r1) {
            this.schemaUrl = r1;
        }

        public final void setShowFrom(String r1) {
            this.showFrom = r1;
        }

        public final void setSpeechKey(String r1) {
            this.speechKey = r1;
        }

        public final void setSuggestStyle(String r1) {
            this.suggestStyle = r1;
        }

        public final void setSuggestType(String r1) {
            this.suggestType = r1;
        }

        public final void setUserPrompt(String r1) {
            this.userPrompt = r1;
        }

        public SuggestV2ExtraForMultiAction(@SuggestActionType String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15) {
            this.suggestActionType = r1;
            this.actionBarItemId = r2;
            this.actionBarTemplateId = r3;
            this.actionBarKey = r4;
            this.isFontBold = r5;
            this.msgExt = r6;
            this.cursorPos = r7;
            this.userPrompt = r8;
            this.schemaUrl = r9;
            this.speechKey = r10;
            this.actionBarDefaultSelectionCfg = r11;
            this.botInfo = r12;
            this.showFrom = r13;
            this.suggestStyle = r14;
            this.botId = r15;
        }

        public /* synthetic */ SuggestV2ExtraForMultiAction(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, int r32, DefaultConstructorMarker r33) {
            String r2 = null;
            if ((r32 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r32 & 2) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r32 & 4) == 0) goto L13;
            String r4 = null;
        L15:
            if ((r32 & 8) == 0) goto L17;
            String r5 = null;
        L19:
            if ((r32 & 16) == 0) goto L21;
            String r6 = null;
        L23:
            if ((r32 & 32) == 0) goto L25;
            String r7 = null;
        L27:
            if ((r32 & 64) == 0) goto L29;
            String r8 = null;
        L31:
            if ((r32 & 128) == 0) goto L33;
            String r9 = null;
        L35:
            if ((r32 & 256) == 0) goto L37;
            String r10 = null;
        L39:
            if ((r32 & 512) == 0) goto L41;
            String r11 = null;
        L43:
            if ((r32 & 1024) == 0) goto L45;
            String r12 = null;
        L47:
            if ((r32 & 2048) == 0) goto L49;
            String r13 = null;
        L51:
            if ((r32 & 4096) == 0) goto L53;
            String r14 = null;
        L55:
            if ((r32 & 8192) == 0) goto L57;
            String r15 = SuggestV2Style.DEFAULT.getValue();
        L59:
            if ((r32 & 16384) != 0) goto L62;
            r2 = r31;
        L62:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2);
            return;
        L57:
            r15 = r30;
            goto L59
        L53:
            r14 = r29;
            goto L55
        L49:
            r13 = r28;
            goto L51
        L45:
            r12 = r27;
            goto L47
        L41:
            r11 = r26;
            goto L43
        L37:
            r10 = r25;
            goto L39
        L33:
            r9 = r24;
            goto L35
        L29:
            r8 = r23;
            goto L31
        L25:
            r7 = r22;
            goto L27
        L21:
            r6 = r21;
            goto L23
        L17:
            r5 = r20;
            goto L19
        L13:
            r4 = r19;
            goto L15
        L9:
            r3 = r18;
            goto L11
        L5:
            r1 = r17;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2Style;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", WcbRenderStatus.DEFAULT, "COLORFUL", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum SuggestV2Style extends Enum<SuggestV2Style> {
        public static final SuggestV2Style COLORFUL = null;
        public static final SuggestV2Style DEFAULT = null;
        public static final /* synthetic */ SuggestV2Style[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<SuggestV2Style> getEntries() {
            return b;
        }

        static {
            SuggestV2Style r0 = new SuggestV2Style(WcbRenderStatus.DEFAULT, 0, "default");
            DEFAULT = r0;
            SuggestV2Style r1 = new SuggestV2Style("COLORFUL", 1, "colorful");
            COLORFUL = r1;
            SuggestV2Style[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static SuggestV2Style[] values() {
            return (SuggestV2Style[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static SuggestV2Style valueOf(String r1) {
            return (SuggestV2Style) r27.a.a(SuggestV2Style.class, r1);
        }

        public SuggestV2Style(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$TravelSuggestType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "SEARCH", SuggestActionType.CALL, "IMAGE4", "GREET", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum TravelSuggestType extends Enum<TravelSuggestType> {

        @SerializedName("2")
        public static final TravelSuggestType CALL = null;
        public static final a Companion = null;

        @SerializedName("4")
        public static final TravelSuggestType GREET = null;

        @SerializedName("3")
        public static final TravelSuggestType IMAGE4 = null;

        @SerializedName("1")
        public static final TravelSuggestType SEARCH = null;
        public static final /* synthetic */ TravelSuggestType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        public final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<TravelSuggestType> getEntries() {
            return b;
        }

        static {
            TravelSuggestType r0 = new TravelSuggestType("SEARCH", 0, 1);
            SEARCH = r0;
            TravelSuggestType r1 = new TravelSuggestType(SuggestActionType.CALL, 1, 2);
            CALL = r1;
            TravelSuggestType r4 = new TravelSuggestType("IMAGE4", 2, 3);
            IMAGE4 = r4;
            TravelSuggestType r6 = new TravelSuggestType("GREET", 3, 4);
            GREET = r6;
            TravelSuggestType[] r8 = {r0, r1, r4, r6};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
            Companion = new a();
        }

        public static TravelSuggestType[] values() {
            return (TravelSuggestType[]) a.clone();
        }

        public static TravelSuggestType valueOf(String r1) {
            return (TravelSuggestType) r27.a.a(TravelSuggestType.class, r1);
        }

        public TravelSuggestType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public a() {
        }

        public static SuggestV2Extra a(String r3) {
        L6:
            e = move-exception;
            FLogger.a.e("PromptContent", "getSuggestPromptExtra error >>> " + e);
            return null;
        L3:
            if (o0.d(r3) == false) goto L12;
            return (SuggestV2Extra) new Gson().fromJson(r3, SuggestV2Extra.class);
        L12:
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public PromptContent() {
        this(null, null, null, false, 0, null, null, null, null, null, null, 2047, null);
    }

    public final boolean isEmpty() {
        List<SuggestItem> r0 = this.suggestItems;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L32;
        List<String> r2 = this.suggest;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L33;
        List<SuggestV2> r4 = this.suggestV2;
        if (r4 != null) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == true) goto L27;
        return false;
    L27:
        if (this.suggestActionCardCnt == 0) goto L29;
        return false;
    L29:
        if (isPlaceholder() == true) goto L36;
        return true;
    L36:
        return false;
    L21:
        if (r4.isEmpty() == true) goto L24;
        r5 = false;
        goto L25
    L33:
        return false;
    L13:
        if (r2.isEmpty() == true) goto L16;
        r3 = false;
        goto L17
    L32:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean isPlaceholder() {
        Map<String, String> r0 = this.businessExt;
        if (r0 == null) goto L5;
        String r1 = r0.get("is_placeholder");
    L7:
        return Intrinsics.areEqual(r1, "1");
    L5:
        r1 = null;
        goto L7
    }

    public final int size() {
        int r0 = this.suggestActionCardCnt;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        List<SuggestV2> r1 = this.suggestV2;
        boolean r2 = true;
        if (r1 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L17;
        List<SuggestV2> r4 = this.suggestV2;
        if (r4 != null) goto L16;
        return 0;
    L16:
        return r4.size();
    L17:
        List<SuggestItem> r5 = this.suggestItems;
        if (r5 != null) goto L20;
    L23:
        boolean r6 = true;
    L24:
        if (r6 == true) goto L29;
        List<SuggestItem> r7 = this.suggestItems;
        if (r7 != null) goto L28;
        return 0;
    L28:
        return r7.size();
    L29:
        List<String> r8 = this.suggest;
        if (r8 != null) goto L32;
    L35:
        if (r2 == true) goto L42;
        List<String> r9 = this.suggest;
        if (r9 != null) goto L39;
        return 0;
    L39:
        return r9.size();
    L42:
        return 0;
    L32:
        if (r8.isEmpty() == true) goto L35;
        r2 = false;
        goto L35
    L20:
        if (r5.isEmpty() == true) goto L23;
        r6 = false;
        goto L24
    L8:
        if (r1.isEmpty() == true) goto L11;
        r3 = false;
        goto L12
    }

    public final List<String> suggestTxt() {
        List<SuggestV2> r0 = this.suggestV2;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        ArrayList r5 = null;
        if (r2 == true) goto L21;
        List<SuggestV2> r3 = this.suggestV2;
        if (r3 == null) goto L20;
        List<SuggestV2> r4 = r3;
        r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L15:
        if (r6.hasNext() == false) goto L20;
        String r7 = ((SuggestV2) r6.next()).getContent();
        if (r7 != null) goto L19;
        r7 = "";
    L19:
        r5.add(r7);
    L20:
        return r5;
    L21:
        List<SuggestItem> r8 = this.suggestItems;
        if (r8 != null) goto L24;
    L27:
        boolean r9 = true;
    L28:
        if (r9 == true) goto L39;
        List<SuggestItem> r10 = this.suggestItems;
        if (r10 == null) goto L38;
        List<SuggestItem> r11 = r10;
        r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r12 = r11.iterator();
    L33:
        if (r12.hasNext() == false) goto L38;
        String r13 = ((SuggestItem) r12.next()).getSuggest();
        if (r13 != null) goto L37;
        r13 = "";
    L37:
        r5.add(r13);
    L38:
        return r5;
    L39:
        List<String> r14 = this.suggest;
        if (r14 != null) goto L42;
    L43:
        r1 = true;
    L44:
        if (r1 == true) goto L48;
        return this.suggest;
    L48:
        return CollectionsKt.emptyList();
    L42:
        if (r14.isEmpty() == false) goto L44;
    L24:
        if (r8.isEmpty() == true) goto L27;
        r9 = false;
        goto L28
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final String toJson() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        return (String) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public int hashCode() {
        String r0 = toJson();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final Map<String, String> getBusinessExt() {
        return this.businessExt;
    }

    public final String getOnboardingDisplayStyle() {
        return this.onboardingDisplayStyle;
    }

    public final String getSugType() {
        return this.sugType;
    }

    public final List<String> getSuggest() {
        return this.suggest;
    }

    public final int getSuggestActionCardCnt() {
        return this.suggestActionCardCnt;
    }

    public final List<SuggestItem> getSuggestItems() {
        return this.suggestItems;
    }

    public final List<SuggestV2> getSuggestV2() {
        return this.suggestV2;
    }

    public final String getWcbRenderStatus() {
        return this.wcbRenderStatus;
    }

    public final String getWcbTitle() {
        return this.wcbTitle;
    }

    public final Integer getWcbTitleStyle() {
        return this.wcbTitleStyle;
    }

    public final boolean isNoDisappear() {
        return this.isNoDisappear;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof PromptContent) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(toJson(), ((PromptContent) r2).toJson());
    }

    public final void setBusinessExt(Map<String, String> r1) {
        this.businessExt = r1;
    }

    public final void setNoDisappear(boolean r1) {
        this.isNoDisappear = r1;
    }

    public final void setOnboardingDisplayStyle(String r1) {
        this.onboardingDisplayStyle = r1;
    }

    public final void setSugType(String r1) {
        this.sugType = r1;
    }

    public final void setSuggest(List<String> r1) {
        this.suggest = r1;
    }

    public final void setSuggestActionCardCnt(int r1) {
        this.suggestActionCardCnt = r1;
    }

    public final void setSuggestItems(List<SuggestItem> r1) {
        this.suggestItems = r1;
    }

    public final void setSuggestV2(List<SuggestV2> r1) {
        this.suggestV2 = r1;
    }

    public final void setWcbRenderStatus(String r1) {
        this.wcbRenderStatus = r1;
    }

    public final void setWcbTitle(String r1) {
        this.wcbTitle = r1;
    }

    public final void setWcbTitleStyle(Integer r1) {
        this.wcbTitleStyle = r1;
    }

    public PromptContent(List<String> r1, List<SuggestV2> r2, List<SuggestItem> r3, boolean r4, int r5, String r6, String r7, Map<String, String> r8, @WcbRenderStatus String r9, String r10, Integer r11) {
        this.suggest = r1;
        this.suggestV2 = r2;
        this.suggestItems = r3;
        this.isNoDisappear = r4;
        this.suggestActionCardCnt = r5;
        this.onboardingDisplayStyle = r6;
        this.sugType = r7;
        this.businessExt = r8;
        this.wcbRenderStatus = r9;
        this.wcbTitle = r10;
        this.wcbTitleStyle = r11;
    }

    public /* synthetic */ PromptContent(List r13, List r14, List r15, boolean r16, int r17, String r18, String r19, Map r20, String r21, String r22, Integer r23, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 1) == 0) goto L5;
        List r1 = CollectionsKt.emptyList();
    L7:
        if ((r24 & 2) == 0) goto L9;
        List r2 = CollectionsKt.emptyList();
    L11:
        if ((r24 & 4) == 0) goto L13;
        List r3 = CollectionsKt.emptyList();
    L15:
        if ((r24 & 8) == 0) goto L17;
        boolean r4 = false;
    L19:
        if ((r24 & 16) == 0) goto L21;
        int r6 = 0;
    L22:
        String r8 = "";
        if ((r24 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r24 & 64) != 0) goto L31;
        r8 = r19;
    L31:
        if ((r24 & 128) == 0) goto L33;
        Map r9 = MapsKt.emptyMap();
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = WcbRenderStatus.DEFAULT;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        Integer r0 = 0;
    L46:
        this(r1, r2, r3, r4, r6, r7, r8, r9, r10, r11, r0);
        return;
    L45:
        r0 = r23;
        goto L46
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L22
    L17:
        r4 = r16;
        goto L19
    L13:
        r3 = r15;
        goto L15
    L9:
        r2 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
