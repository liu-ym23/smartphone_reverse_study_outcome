package com.bytedance.android.live.base.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ImageModel extends FlexModelBase<py.k> implements Parcelable, py.k {
    public static final Parcelable.Creator<ImageModel> CREATOR = null;
    protected static final int HASH_CODE_31 = 31;

    @SerializedName("avg_color")
    public String avgColor;

    @SerializedName("content")
    protected Content content;

    @SerializedName("height")
    public int height;
    private String iconStub;

    @SerializedName("image_type")
    protected int imageType;

    @SerializedName("is_animated")
    protected boolean isAnimated;
    private boolean isFeedCandidate;
    private boolean isLoaded;
    private boolean isMonitored;
    public boolean isNinePatch;
    public boolean isResizableImg;

    @SerializedName("uri")
    public String mUri;

    @SerializedName("url_list")
    public List<String> mUrls;

    @SerializedName("open_web_url")
    public String schema;

    @SerializedName("width")
    public int width;

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class Content extends FlexModelBase<py.k.b> implements Parcelable, py.k.b {
        public static final Parcelable.Creator<Content> CREATOR = null;

        @SerializedName("alternative_text")
        String accessibilityText;

        @SerializedName("font_color")
        String fontColor;

        @SerializedName("level")
        long level;

        @SerializedName("name")
        String name;

        public class a implements Parcelable.Creator<Content> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Content createFromParcel(Parcel r2) {
                return new Content(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final Content[] newArray(int r1) {
                return new Content[r1];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public Content() {
            super(py.k.b.class);
        }

        @Override // py.k.b
        public String getAccessibilityText() {
            return this.accessibilityText;
        }

        @Override // py.k.b
        public String getFontColor() {
            return this.fontColor;
        }

        @Override // py.k.b
        public long getLevel() {
            return this.level;
        }

        @Override // py.k.b
        public String getName() {
            return this.name;
        }

        public Content(Parcel r3) {
            super(py.k.b.class);
            this.name = r3.readString();
            this.fontColor = r3.readString();
            this.level = r3.readLong();
            this.accessibilityText = r3.readString();
        }

        public static boolean isValid(Content r1) {
            if (r1 != null) goto L4;
        L8:
            return false;
        L4:
            if (TextUtils.isEmpty(r1.getName()) == true) goto L8;
            if (TextUtils.isEmpty(r1.getFontColor()) == true) goto L8;
            return true;
        }

        @Override // py.k.b
        public void setAccessibilityText(String r1) {
            this.accessibilityText = r1;
        }

        @Override // py.k.b
        public void setFontColor(String r1) {
            this.fontColor = r1;
        }

        @Override // py.k.b
        public void setLevel(long r1) {
            this.level = r1;
        }

        @Override // py.k.b
        public void setName(String r1) {
            this.name = r1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            r3.writeString(this.name);
            r3.writeString(this.fontColor);
            r3.writeLong(this.level);
            r3.writeString(this.accessibilityText);
        }
    }

    public class a implements Parcelable.Creator<ImageModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImageModel createFromParcel(Parcel r2) {
            return new ImageModel(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ImageModel[] newArray(int r1) {
            return new ImageModel[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return hash(new Object[]{this.avgColor, this.mUri, this.mUrls, Integer.valueOf(this.width), Integer.valueOf(this.height)});
    }

    static {
        CREATOR = new a();
    }

    public ImageModel() {
        super(py.k.class);
        this.mUrls = new ArrayList();
        this.isNinePatch = false;
        this.isResizableImg = false;
    }

    @Override // py.k
    @SerializedName("image_type")
    public Integer getImageType() {
        return Integer.valueOf(this.imageType);
    }

    @Override // py.k
    public boolean isValid() {
        List<String> r0 = this.mUrls;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.size() <= 0) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("{\"uri\":\"");
        String r1 = this.mUri;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.append(r1);
        r0.append("\",\"image_type\":\"");
        String r3 = this.schema;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.append(r2);
        r0.append("\",\"url_list\":[");
        List<String> r4 = this.mUrls;
        if (r4 == null) goto L17;
        int r5 = r4.size();
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L17;
        r0.append("\"");
        r0.append((String) ListProtector.get(this.mUrls, r6));
        r0.append("\"");
        if (r6 == (r5 - 1)) goto L16;
        r0.append(",");
    L16:
        r6 = r6 + 1;
    L17:
        r0.append("]}");
        return r0.toString();
    }

    public ImageModel copy() {
        return fromJson(toJsonString(this));
    }

    @Override // py.k
    @SerializedName("content")
    public /* bridge */ /* synthetic */ py.k.b getImageContent() {
        return getImageContent();
    }

    @Override // py.k
    public String getAvgColor() {
        return this.avgColor;
    }

    @Override // py.k
    public int getHeight() {
        return this.height;
    }

    @Override // py.k
    public String getIconStub() {
        return this.iconStub;
    }

    @Override // py.k
    @SerializedName("open_web_url")
    public String getSchema() {
        return this.schema;
    }

    @Override // py.k
    @SerializedName("uri")
    public String getUri() {
        return this.mUri;
    }

    @Override // py.k, py.l
    @SerializedName("url_list")
    public List<String> getUrls() {
        return this.mUrls;
    }

    @Override // py.k
    public List<String> getUrlsKmp() {
        return this.mUrls;
    }

    @Override // py.k
    public int getWidth() {
        return this.width;
    }

    @Override // py.k
    @SerializedName("is_animated")
    public boolean isAnimated() {
        return this.isAnimated;
    }

    @Override // py.k
    public boolean isFeedCandidate() {
        return this.isFeedCandidate;
    }

    @Override // py.k
    public boolean isLoaded() {
        return this.isLoaded;
    }

    @Override // py.k
    public boolean isMonitored() {
        return this.isMonitored;
    }

    @Override // py.k
    public boolean isResizableImg() {
        return this.isResizableImg;
    }

    @Override // py.k
    @SerializedName("content")
    public Content getImageContent() {
        return this.content;
    }

    public ImageModel(Parcel r4) {
        super(py.k.class);
        this.mUrls = new ArrayList();
        boolean r0 = false;
        this.isNinePatch = false;
        this.isResizableImg = false;
        this.mUri = r4.readString();
        this.mUrls = r4.createStringArrayList();
        this.width = r4.readInt();
        this.height = r4.readInt();
        this.schema = r4.readString();
        this.imageType = r4.readInt();
        this.content = (Content) r4.readParcelable(Content.class.getClassLoader());
        if (r4.readByte() == 0) goto L5;
        boolean r1 = true;
    L6:
        this.isAnimated = r1;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.isLoaded = r2;
        if (r4.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.isMonitored = r3;
        if (r4.readByte() == 0) goto L17;
        r0 = true;
    L17:
        this.isFeedCandidate = r0;
        return;
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public static ImageModel fromJson(JSONObject r2) {
        return (ImageModel) GsonProtectorUtils.fromJson(GsonHelper.get(), r2.toString(), ImageModel.class);
    }

    public static ImageModel genBy(String r1) {
        ImageModel r0 = new ImageModel();
        r0.setUrls(Collections.singletonList(r1));
        return r0;
    }

    private static int hash(Object... r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r1 = r5.length;
        int r2 = 1;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L12;
        Object r4 = r5[r3];
        int r6 = r2 * 31;
        if (r4 != null) goto L10;
        int r7 = 0;
    L11:
        r2 = r6 + r7;
        r3 = r3 + 1;
        goto L6
    L10:
        r7 = r4.hashCode();
        goto L11
    L12:
        return r2;
    }

    public static String toJsonString(ImageModel r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return GsonProtectorUtils.toJson(GsonHelper.get(), r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L23;
        ImageModel r6 = (ImageModel) r5;
        if (this.width == r6.width) goto L13;
    L21:
        return false;
    L13:
        if (this.height != r6.height) goto L21;
        if (equals(this.avgColor, r6.avgColor) == false) goto L21;
        if (equals(this.mUri, r6.mUri) == false) goto L21;
        if (equals(this.mUrls, r6.mUrls) == false) goto L21;
        return true;
    }

    @Override // py.k
    public boolean equalsOnlyUri(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return equals(this.mUri, ((ImageModel) r3).mUri);
    }

    @Override // py.k
    @SerializedName("is_animated")
    public void setAnimated(boolean r1) {
        this.isAnimated = r1;
    }

    @Override // py.k
    public void setAvgColor(String r1) {
        this.avgColor = r1;
    }

    @Override // py.k
    @SerializedName("content")
    public void setContent(py.k.b r2) {
        this.content = (Content) m.b(r2, Content.class);
    }

    public void setFeedCandidate(boolean r1) {
        this.isFeedCandidate = r1;
    }

    @Override // py.k
    public void setHeight(int r1) {
        this.height = r1;
    }

    @Override // py.k
    public void setIconStub(String r1) {
        this.iconStub = r1;
    }

    @Override // py.k
    @SerializedName("image_type")
    public void setImageType(Integer r1) {
        this.imageType = r1.intValue();
    }

    @Override // py.k
    public void setIsResizableImg(boolean r1) {
        this.isResizableImg = r1;
    }

    @Override // py.k
    public void setLoaded(boolean r1) {
        this.isLoaded = r1;
    }

    public void setMonitored(boolean r1) {
        this.isMonitored = r1;
    }

    @Override // py.k
    @SerializedName("open_web_url")
    public void setSchema(String r1) {
        this.schema = r1;
    }

    @Override // py.k
    @SerializedName("uri")
    public void setUri(String r1) {
        this.mUri = r1;
    }

    @Override // py.k
    @SerializedName("url_list")
    public void setUrls(List<String> r1) {
        this.mUrls = r1;
    }

    @Override // py.k
    public void setWidth(int r1) {
        this.width = r1;
    }

    public static ImageModel fromJson(String r2) {
        return (ImageModel) GsonProtectorUtils.fromJson(GsonHelper.get(), r2, ImageModel.class);
    }

    public ImageModel(String r2, List<String> r3) {
        super(py.k.class);
        new ArrayList();
        this.isNinePatch = false;
        this.isResizableImg = false;
        this.mUri = r2;
        this.mUrls = r3;
    }

    private static boolean equals(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static ImageModel genBy(String r1, List<String> r2) {
        ImageModel r0 = new ImageModel();
        r0.setUri(r1);
        r0.setUrls(r2);
        return r0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeString(this.mUri);
        r2.writeStringList(this.mUrls);
        r2.writeInt(this.width);
        r2.writeInt(this.height);
        r2.writeString(this.schema);
        r2.writeInt(this.imageType);
        r2.writeParcelable(this.content, r3);
        r2.writeByte(this.isAnimated ? 1 : 0);
        r2.writeByte(this.isLoaded ? 1 : 0);
        r2.writeByte(this.isMonitored ? 1 : 0);
        r2.writeByte(this.isFeedCandidate ? 1 : 0);
    }

    public ImageModel(String r2, List<String> r3, String r4) {
        super(py.k.class);
        new ArrayList();
        this.isNinePatch = false;
        this.isResizableImg = false;
        this.mUri = r2;
        this.mUrls = r3;
        this.schema = r4;
    }
}
