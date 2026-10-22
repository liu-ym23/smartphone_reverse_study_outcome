package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00011BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001a¨\u00062"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "site", "Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;", "coverImage", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "coverImageUrl", BuildConfig.FLAVOR, "duration", BuildConfig.FLAVOR, "srcUrl", "vid", "iframeUrl", "<init>", "(Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSite", "()Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;", "setSite", "(Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;)V", "getCoverImage", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setCoverImage", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getCoverImageUrl", "()Ljava/lang/String;", "setCoverImageUrl", "(Ljava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getSrcUrl", "setSrcUrl", "getVid", "setVid", "getIframeUrl", "setIframeUrl", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "clone", "Lcom/ss/android/lark/tangram/base/props/Props;", "Site", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoProperty extends BaseProperty {
    private ImageSet coverImage;
    private String coverImageUrl;
    private long duration;
    private String iframeUrl;
    private Site site;
    private String srcUrl;
    private String vid;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "XIGUA", "DOUYIN", "HUOSHAN", "YOUTUBE", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Site extends Enum<Site> {
        public static final a Companion = null;
        public static final Site DOUYIN = null;
        public static final Site HUOSHAN = null;
        public static final Site UNKNOWN = null;
        public static final Site XIGUA = null;
        public static final Site YOUTUBE = null;
        public static final /* synthetic */ Site[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            public static Site a(int r1) {
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L19;
                if (r1 == 3) goto L18;
                if (r1 == 4) goto L17;
                return Site.UNKNOWN;
            L17:
                return Site.YOUTUBE;
            L18:
                return Site.HUOSHAN;
            L19:
                return Site.DOUYIN;
            L15:
                return Site.XIGUA;
            }
        }

        public static EnumEntries<Site> getEntries() {
            return b;
        }

        static {
            Site r0 = new Site("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Site r1 = new Site("XIGUA", 1, 1);
            XIGUA = r1;
            Site r3 = new Site("DOUYIN", 2, 2);
            DOUYIN = r3;
            Site r5 = new Site("HUOSHAN", 3, 3);
            HUOSHAN = r5;
            Site r7 = new Site("YOUTUBE", 4, 4);
            YOUTUBE = r7;
            Site[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new a();
        }

        public static Site[] values() {
            return (Site[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Site valueOf(String r1) {
            return (Site) r27.a.a(Site.class, r1);
        }

        public Site(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public VideoProperty() {
        this(null, null, null, 0, null, null, null, 127, null);
    }

    public Props clone() {
        Site r1 = this.site;
        ImageSet r0 = this.coverImage;
        if (r0 == null) goto L5;
        ImageSet r2 = r0.clone();
    L6:
        VideoProperty r9 = new VideoProperty(r1, r2, this.coverImageUrl, this.duration, this.srcUrl, this.vid, this.iframeUrl);
        r9.setMarginLeft(getMarginLeft());
        r9.setMarginRight(getMarginRight());
        r9.setMarginTop(getMarginTop());
        r9.setMarginBottom(getMarginBottom());
        return r9;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = ((super.hashCode() * 31) + this.site.hashCode()) * 31;
        ImageSet r1 = this.coverImage;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        long r4 = this.duration;
        int r5 = (((r0 + r3) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        String r6 = this.srcUrl;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        String r9 = this.vid;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.iframeUrl;
        if (r12 == null) goto L17;
        int r13 = r12.hashCode();
    L18:
        int r14 = (r11 + r13) * 31;
        String r15 = this.coverImageUrl;
        if (r15 == null) goto L22;
        r2 = r15.hashCode();
    L22:
        return r14 + r2;
    L17:
        r13 = 0;
        goto L18
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final ImageSet getCoverImage() {
        return this.coverImage;
    }

    public final String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getIframeUrl() {
        return this.iframeUrl;
    }

    public final Site getSite() {
        return this.site;
    }

    public final String getSrcUrl() {
        return this.srcUrl;
    }

    public final String getVid() {
        return this.vid;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof VideoProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r8) == true) goto L11;
        return false;
    L11:
        VideoProperty r9 = (VideoProperty) r8;
        if (this.site == r9.site) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.coverImage, r9.coverImage) == true) goto L18;
        return false;
    L18:
        if (this.duration == r9.duration) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.srcUrl, r9.srcUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.vid, r9.vid) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.iframeUrl, r9.iframeUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.coverImageUrl, r9.coverImageUrl) == true) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r6 = r5.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L55;
        Map.Entry<Integer, PreviewData> r0 = r6.next();
        int r1 = r0.getKey().intValue();
        if (r1 == ComponentAttribute.site.getValue()) goto L9;
        ImageSet r3 = null;
        String r4 = null;
        String r7 = null;
        String r8 = null;
        String r9 = null;
        if (r1 == ComponentAttribute.cover_image.getValue()) goto L18;
        if (r1 == ComponentAttribute.src_url.getValue()) goto L24;
        if (r1 == ComponentAttribute.vid.getValue()) goto L30;
        if (r1 == ComponentAttribute.iframe_url.getValue()) goto L36;
        if (r1 == ComponentAttribute.cover_image_url.getValue()) goto L42;
        if (r1 != ComponentAttribute.duration.getValue()) goto L6;
        PreviewData r2 = r0.getValue();
        if (r2 == null) goto L53;
        Long r10 = r2.getLong();
        if (r10 == null) goto L53;
        long r11 = r10.longValue();
    L54:
        this.duration = r11;
    L53:
        r11 = 0;
        goto L54
    L42:
        PreviewData r12 = r0.getValue();
        if (r12 == null) goto L45;
        r4 = r12.getString();
    L45:
        this.coverImageUrl = r4;
        goto L6
    L36:
        PreviewData r13 = r0.getValue();
        if (r13 == null) goto L39;
        r7 = r13.getString();
    L39:
        this.iframeUrl = r7;
        goto L6
    L30:
        PreviewData r14 = r0.getValue();
        if (r14 == null) goto L33;
        r8 = r14.getString();
    L33:
        this.vid = r8;
        goto L6
    L24:
        PreviewData r15 = r0.getValue();
        if (r15 == null) goto L27;
        r9 = r15.getString();
    L27:
        this.srcUrl = r9;
        goto L6
    L18:
        PreviewData r16 = r0.getValue();
        if (r16 == null) goto L21;
        r3 = r16.getImageSet();
    L21:
        this.coverImage = r3;
        goto L6
    L9:
        Site.a r17 = Site.Companion;
        PreviewData r18 = r0.getValue();
        if (r18 == null) goto L14;
        Integer r19 = r18.getInt();
        if (r19 == null) goto L14;
        int r20 = r19.intValue();
    L15:
        r17.getClass();
        this.site = Site.a.a(r20);
    L14:
        r20 = 0;
        goto L15
    }

    public final void setCoverImage(ImageSet r1) {
        this.coverImage = r1;
    }

    public final void setCoverImageUrl(String r1) {
        this.coverImageUrl = r1;
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setIframeUrl(String r1) {
        this.iframeUrl = r1;
    }

    public final void setSite(Site r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.site = r2;
    }

    public final void setSrcUrl(String r1) {
        this.srcUrl = r1;
    }

    public final void setVid(String r1) {
        this.vid = r1;
    }

    public VideoProperty(Site r2, ImageSet r3, String r4, long r5, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "site");
        super(Type.VIDEO);
        this.site = r2;
        this.coverImage = r3;
        this.coverImageUrl = r4;
        this.duration = r5;
        this.srcUrl = r7;
        this.vid = r8;
        this.iframeUrl = r9;
    }

    public /* synthetic */ VideoProperty(Site r10, ImageSet r11, String r12, long r13, String r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        Site r0 = Site.UNKNOWN;
    L7:
        if ((r18 & 2) == 0) goto L9;
        ImageSet r1 = null;
    L10:
        int r2 = r18 & 4;
        String r3 = BuildConfig.FLAVOR;
        if (r2 == 0) goto L13;
        String r4 = BuildConfig.FLAVOR;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r5 = 0;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = BuildConfig.FLAVOR;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = BuildConfig.FLAVOR;
    L27:
        if ((r18 & 64) != 0) goto L30;
        r3 = r17;
    L30:
        this(r0, r1, r4, r5, r6, r7, r3);
        return;
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r1 = r11;
        goto L10
    L5:
        r0 = r10;
        goto L7
    }
}
