package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\t\u00105\u001a\u000206HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u000206HÖ\u0001R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0005\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0015\"\u0004\b4\u0010\u0017¨\u0006<"}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectCategoryResponse;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", "id", "", DBDefinition.NAME, "key", "icon_normal_url", "icon_selected_url", "front_effect", "Lcom/ss/ugc/effectplatform/model/Effect;", "rear_effect", "total_effects", "", "tags", "tags_update_time", "collection_effect", "is_default", "", DBDefinition.EXTRA, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/Effect;Lcom/ss/ugc/effectplatform/model/Effect;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;)V", "getCollection_effect", "()Ljava/util/List;", "setCollection_effect", "(Ljava/util/List;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getFront_effect", "()Lcom/ss/ugc/effectplatform/model/Effect;", "setFront_effect", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "getIcon_normal_url", "setIcon_normal_url", "getIcon_selected_url", "setIcon_selected_url", "getId", "setId", "()Z", "set_default", "(Z)V", "getKey", "setKey", "getName", "setName", "getRear_effect", "setRear_effect", "getTags", "setTags", "getTags_update_time", "setTags_update_time", "getTotal_effects", "setTotal_effects", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectCategoryResponse implements AndroidParcelable {
    public static final Parcelable.Creator CREATOR = null;
    private List<? extends Effect> collection_effect;
    private String extra;
    private Effect front_effect;
    private String icon_normal_url;
    private String icon_selected_url;
    private String id;
    private boolean is_default;
    private String key;
    private String name;
    private Effect rear_effect;
    private List<String> tags;
    private String tags_update_time;
    private List<? extends Effect> total_effects;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r17) {
            String r1 = r17.readString();
            String r2 = r17.readString();
            String r3 = r17.readString();
            String r4 = r17.readString();
            String r5 = r17.readString();
            Effect r6 = (Effect) r17.readParcelable(EffectCategoryResponse.class.getClassLoader());
            Effect r7 = (Effect) r17.readParcelable(EffectCategoryResponse.class.getClassLoader());
            int r8 = r17.readInt();
            ArrayList r9 = new ArrayList(r8);
        L3:
            if (r8 == 0) goto L5;
            r9.add((Effect) r17.readParcelable(EffectCategoryResponse.class.getClassLoader()));
            r8 = r8 - 1;
            goto L3
        L5:
            ArrayList<String> r10 = r17.createStringArrayList();
            String r11 = r17.readString();
            int r12 = r17.readInt();
            ArrayList r13 = new ArrayList(r12);
        L6:
            if (r12 == 0) goto L9;
            r13.add((Effect) r17.readParcelable(EffectCategoryResponse.class.getClassLoader()));
            r12 = r12 - 1;
            goto L6
        L9:
            if (r17.readInt() == 0) goto L11;
            boolean r14 = true;
        L13:
            return new EffectCategoryResponse(r1, r2, r3, r4, r5, r6, r7, r9, r10, r11, r13, r14, r17.readString());
        L11:
            r14 = false;
            goto L13
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r1) {
            return new EffectCategoryResponse[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public EffectCategoryResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, null, 8191, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.id);
        r3.writeString(this.name);
        r3.writeString(this.key);
        r3.writeString(this.icon_normal_url);
        r3.writeString(this.icon_selected_url);
        r3.writeParcelable(this.front_effect, r4);
        r3.writeParcelable(this.rear_effect, r4);
        List<? extends Effect> r0 = this.total_effects;
        r3.writeInt(r0.size());
        Iterator<? extends Effect> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r3.writeParcelable(r1.next(), r4);
        goto L4
    L6:
        r3.writeStringList(this.tags);
        r3.writeString(this.tags_update_time);
        List<? extends Effect> r2 = this.collection_effect;
        r3.writeInt(r2.size());
        Iterator<? extends Effect> r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r3.writeParcelable(r5.next(), r4);
        goto L8
    L10:
        r3.writeInt(this.is_default ? 1 : 0);
        r3.writeString(this.extra);
    }

    public List<Effect> getCollection_effect() {
        return this.collection_effect;
    }

    public String getExtra() {
        return this.extra;
    }

    public Effect getFront_effect() {
        return this.front_effect;
    }

    public String getIcon_normal_url() {
        return this.icon_normal_url;
    }

    public String getIcon_selected_url() {
        return this.icon_selected_url;
    }

    public String getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public Effect getRear_effect() {
        return this.rear_effect;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTags_update_time() {
        return this.tags_update_time;
    }

    public List<Effect> getTotal_effects() {
        return this.total_effects;
    }

    public boolean is_default() {
        return this.is_default;
    }

    public void setCollection_effect(List<? extends Effect> r1) {
        this.collection_effect = r1;
    }

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setFront_effect(Effect r1) {
        this.front_effect = r1;
    }

    public void setIcon_normal_url(String r1) {
        this.icon_normal_url = r1;
    }

    public void setIcon_selected_url(String r1) {
        this.icon_selected_url = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setRear_effect(Effect r1) {
        this.rear_effect = r1;
    }

    public void setTags(List<String> r1) {
        this.tags = r1;
    }

    public void setTags_update_time(String r1) {
        this.tags_update_time = r1;
    }

    public void setTotal_effects(List<? extends Effect> r1) {
        this.total_effects = r1;
    }

    public void set_default(boolean r1) {
        this.is_default = r1;
    }

    public EffectCategoryResponse(String r1, String r2, String r3, String r4, String r5, Effect r6, Effect r7, List<? extends Effect> r8, List<String> r9, String r10, List<? extends Effect> r11, boolean r12, String r13) {
        this.id = r1;
        this.name = r2;
        this.key = r3;
        this.icon_normal_url = r4;
        this.icon_selected_url = r5;
        this.front_effect = r6;
        this.rear_effect = r7;
        this.total_effects = r8;
        this.tags = r9;
        this.tags_update_time = r10;
        this.collection_effect = r11;
        this.is_default = r12;
        this.extra = r13;
    }

    public /* synthetic */ EffectCategoryResponse(String r15, String r16, String r17, String r18, String r19, Effect r20, Effect r21, List r22, List r23, String r24, List r25, boolean r26, String r27, int r28, DefaultConstructorMarker r29) {
        String r2 = "";
        if ((r28 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r28 & 4) != 0) goto L14;
        r2 = r17;
    L14:
        String r5 = null;
        if ((r28 & 8) == 0) goto L17;
        String r4 = null;
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r28 & 32) == 0) goto L25;
        Effect r7 = null;
    L27:
        if ((r28 & 64) == 0) goto L29;
        Effect r8 = null;
    L31:
        if ((r28 & 128) == 0) goto L33;
        List r9 = new ArrayList();
    L35:
        if ((r28 & 256) == 0) goto L37;
        List r10 = new ArrayList();
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        List r12 = new ArrayList();
    L47:
        if ((r28 & 2048) == 0) goto L49;
        boolean r13 = false;
    L51:
        if ((r28 & 4096) != 0) goto L54;
        r5 = r27;
    L54:
        this(r1, r3, r2, r4, r6, r7, r8, r9, r10, r11, r12, r13, r5);
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
        r4 = r18;
        goto L19
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }
}
