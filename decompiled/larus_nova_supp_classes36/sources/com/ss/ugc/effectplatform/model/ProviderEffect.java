package com.ss.ugc.effectplatform.model;

import com.ss.android.lark.keyboard.statistics.TextInputPluginHitPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b \b\u0017\u0018\u00002\u00020\u0001:\u0001)Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012¨\u0006*"}, d2 = {"Lcom/ss/ugc/effectplatform/model/ProviderEffect;", "", "id", "", "title", "user_name", "thumbnail_sticker", "Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", TextInputPluginHitPoint.Scene.STICKER, "tags", "", "click_url", "path", "extra", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClick_url", "()Ljava/lang/String;", "setClick_url", "(Ljava/lang/String;)V", "getExtra", "setExtra", "getId", "setId", "getPath", "setPath", "value", "sticker_info", "getSticker_info", "()Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", "setSticker_info", "(Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;)V", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getThumbnail_sticker", "setThumbnail_sticker", "getTitle", "setTitle", "getUser_name", "setUser_name", "StickerBean", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class ProviderEffect {
    private String click_url;
    private String extra;
    private String id;
    private String path;
    private StickerBean sticker;
    private List<String> tags;
    private StickerBean thumbnail_sticker;
    private String title;
    private String user_name;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/ss/ugc/effectplatform/model/ProviderEffect$StickerBean;", "", "url", "", "width", "height", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHeight", "()Ljava/lang/String;", "setHeight", "(Ljava/lang/String;)V", "getSize", "setSize", "getUrl", "setUrl", "getWidth", "setWidth", "effect_model_release"}, k = 1, mv = {1, 1, 16})
    public static class StickerBean {
        private String height;
        private String size;
        private String url;
        private String width;

        public StickerBean() {
            this(null, null, null, null, 15, null);
        }

        public String getHeight() {
            return this.height;
        }

        public String getSize() {
            return this.size;
        }

        public String getUrl() {
            return this.url;
        }

        public String getWidth() {
            return this.width;
        }

        public void setHeight(String r1) {
            this.height = r1;
        }

        public void setSize(String r1) {
            this.size = r1;
        }

        public void setUrl(String r1) {
            this.url = r1;
        }

        public void setWidth(String r1) {
            this.width = r1;
        }

        public StickerBean(String r1, String r2, String r3, String r4) {
            this.url = r1;
            this.width = r2;
            this.height = r3;
            this.size = r4;
        }

        public /* synthetic */ StickerBean(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
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

    public ProviderEffect() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public String getClick_url() {
        return this.click_url;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getId() {
        return this.id;
    }

    public String getPath() {
        return this.path;
    }

    public final StickerBean getSticker_info() {
        return this.sticker;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public StickerBean getThumbnail_sticker() {
        return this.thumbnail_sticker;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setClick_url(String r1) {
        this.click_url = r1;
    }

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setPath(String r1) {
        this.path = r1;
    }

    public final void setSticker_info(StickerBean r1) {
        this.sticker = r1;
    }

    public void setTags(List<String> r1) {
        this.tags = r1;
    }

    public void setThumbnail_sticker(StickerBean r1) {
        this.thumbnail_sticker = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setUser_name(String r1) {
        this.user_name = r1;
    }

    public ProviderEffect(String r1, String r2, String r3, StickerBean r4, StickerBean r5, List<String> r6, String r7, String r8, String r9) {
        this.id = r1;
        this.title = r2;
        this.user_name = r3;
        this.thumbnail_sticker = r4;
        this.sticker = r5;
        this.tags = r6;
        this.click_url = r7;
        this.path = r8;
        this.extra = r9;
    }

    public /* synthetic */ ProviderEffect(String r11, String r12, String r13, StickerBean r14, StickerBean r15, List r16, String r17, String r18, String r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 1) == 0) goto L5;
        String r1 = "";
    L6:
        String r3 = null;
        if ((r20 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        StickerBean r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        StickerBean r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r3 = r19;
    L38:
        this(r1, r2, r4, r5, r6, r7, r8, r9, r3);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L6
    }
}
