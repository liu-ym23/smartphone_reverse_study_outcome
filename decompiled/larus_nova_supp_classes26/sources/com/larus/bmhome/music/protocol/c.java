package com.larus.bmhome.music.protocol;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Image;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/music/protocol/ListMusicGenTemplateData;", "", "<init>", "()V", "templateList", "", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "Lcom/larus/bmhome/music/protocol/MusicGenTemplate;", "getTemplateList", "()Ljava/util/List;", "hasMore", "", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "moreTemplateCover", "Lcom/larus/im/bean/message/Image;", "getMoreTemplateCover", "()Lcom/larus/im/bean/message/Image;", "textConf", "Lcom/larus/bmhome/music/protocol/TextConf;", "getTextConf", "()Lcom/larus/bmhome/music/protocol/TextConf;", "nextOffset", "", "getNextOffset", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("more_template_cover")
    private final Image moreTemplateCover;

    @SerializedName("next_offset")
    private final Integer nextOffset;

    @SerializedName(MusicAppletPage.SOURCE_TEMPLATE_LIST)
    private final List<bq8.a> templateList;

    @SerializedName("text_conf")
    private final p textConf;

    public c() {
        this.templateList = CollectionsKt.emptyList();
        this.hasMore = Boolean.FALSE;
        this.nextOffset = 0;
    }

    public final Boolean a() {
        return this.hasMore;
    }

    public final Integer b() {
        return this.nextOffset;
    }

    public final List<bq8.a> c() {
        return this.templateList;
    }
}
