package com.larus.bot.impl.feature.edit.feature.autofill.model;

import com.google.gson.annotations.SerializedName;
import com.larus.bot.impl.bean.EnrichBotData;
import com.larus.im.bean.bot.CreationIdInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/autofill/model/BotEnrichParam;", "Ljava/io/Serializable;", "name", "", "botLang", "needDesc", "", "needVoiceType", "bgImgPrompt", "enrichBotContent", "", "Lcom/larus/bot/impl/bean/EnrichBotData;", "creationIdInfo", "Lcom/larus/im/bean/bot/CreationIdInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Lcom/larus/im/bean/bot/CreationIdInfo;)V", "Ljava/lang/Boolean;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotEnrichParam implements Serializable {

    @SerializedName("bg_img_prompt")
    public final String bgImgPrompt;

    @SerializedName("bot_lang")
    public final String botLang;

    @SerializedName("creation_id_info")
    public final CreationIdInfo creationIdInfo;

    @SerializedName("data")
    public final List<EnrichBotData> enrichBotContent;

    @SerializedName("bot_name")
    public final String name;

    @SerializedName("need_desc")
    public final Boolean needDesc;

    @SerializedName("need_voice_type")
    public final Boolean needVoiceType;

    public BotEnrichParam() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public BotEnrichParam(String r1, String r2, Boolean r3, Boolean r4, String r5, List<EnrichBotData> r6, CreationIdInfo r7) {
        this.name = r1;
        this.botLang = r2;
        this.needDesc = r3;
        this.needVoiceType = r4;
        this.bgImgPrompt = r5;
        this.enrichBotContent = r6;
        this.creationIdInfo = r7;
    }

    public /* synthetic */ BotEnrichParam(String r7, String r8, Boolean r9, Boolean r10, String r11, List r12, CreationIdInfo r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        Boolean r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Boolean r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        List r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        CreationIdInfo r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
