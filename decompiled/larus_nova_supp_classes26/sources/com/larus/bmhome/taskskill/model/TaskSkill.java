package com.larus.bmhome.taskskill.model;

import android.os.Parcel;
import android.os.Parcelable;
import be8.b;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010/\u001a\u000200J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010%J\t\u0010<\u001a\u00020\tHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010(J¶\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010@J\u0006\u0010A\u001a\u00020\u000bJ\u0013\u0010B\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\u000bHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001J\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001dR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0019R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u0019¨\u0006L"}, d2 = {"Lcom/larus/bmhome/taskskill/model/TaskSkill;", "Landroid/os/Parcelable;", "name", "", "externalSkillId", "description", "_displayName", "_displayDescription", "recommend", "", "type", "", "visible", MusicAppletPage.KEY_PATH, "categories", "", "Lcom/larus/bmhome/taskskill/model/TaskSkillCategory;", "lastUsedAtMs", "", "isSuggestionRecommended", "suggestionPosition", "suggestionSkillsLimit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZLjava/lang/String;Ljava/util/List;Ljava/lang/Long;ZLjava/lang/Integer;Ljava/lang/Integer;)V", "getName", "()Ljava/lang/String;", "getExternalSkillId", "getDescription", "getRecommend", "()Z", "getType", "()I", "getVisible", "getPath", "getCategories", "()Ljava/util/List;", "getLastUsedAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSuggestionPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSuggestionSkillsLimit", "displayName", "getDisplayName", "displayDescription", "getDisplayDescription", "toAbilitySkill", "Lcom/larus/bmhome/chat/component/skill/SkillAbilitySkill;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZLjava/lang/String;Ljava/util/List;Ljava/lang/Long;ZLjava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/taskskill/model/TaskSkill;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskSkill implements Parcelable {
    public static final Parcelable.Creator<TaskSkill> CREATOR = null;

    @SerializedName("display_description")
    private final String _displayDescription;

    @SerializedName("display_name")
    private final String _displayName;
    public final Long a;
    public final boolean b;
    public final Integer c;

    @SerializedName("categories")
    private final List<TaskSkillCategory> categories;
    public final Integer d;

    @SerializedName("description")
    private final String description;

    @SerializedName("external_skill_id")
    private final String externalSkillId;

    @SerializedName("name")
    private final String name;

    @SerializedName(MusicAppletPage.KEY_PATH)
    private final String path;

    @SerializedName("recommend")
    private final boolean recommend;

    @SerializedName("type")
    private final int type;

    @SerializedName("visible")
    private final boolean visible;

    public static final class a implements Parcelable.Creator<TaskSkill> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TaskSkill createFromParcel(Parcel r19) {
            Intrinsics.checkNotNullParameter(r19, "parcel");
            String r3 = r19.readString();
            String r4 = r19.readString();
            String r5 = r19.readString();
            String r6 = r19.readString();
            String r7 = r19.readString();
            if (r19.readInt() == 0) goto L5;
            boolean r1 = true;
        L6:
            int r9 = r19.readInt();
            if (r19.readInt() == 0) goto L9;
            boolean r10 = true;
        L10:
            String r11 = r19.readString();
            if (r19.readInt() != 0) goto L13;
            ArrayList r12 = null;
        L22:
            if (r19.readInt() != 0) goto L24;
            Long r14 = null;
        L26:
            if (r19.readInt() == 0) goto L28;
            boolean r16 = true;
        L30:
            if (r19.readInt() != 0) goto L32;
            Integer r15 = null;
        L34:
            if (r19.readInt() != 0) goto L36;
            Integer r0 = null;
        L38:
            return new TaskSkill(r3, r4, r5, r6, r7, r1, r9, r10, r11, r12, r14, r16, r15, r0);
        L36:
            r0 = Integer.valueOf(r19.readInt());
            goto L38
        L32:
            r15 = Integer.valueOf(r19.readInt());
            goto L34
        L28:
            r16 = false;
            goto L30
        L24:
            r14 = Long.valueOf(r19.readLong());
            goto L26
        L13:
            int r13 = r19.readInt();
            ArrayList r17 = new ArrayList(r13);
            int r18 = 0;
        L14:
            if (r18 == r13) goto L20;
            if (r19.readInt() != 0) goto L18;
            TaskSkillCategory r2 = null;
        L19:
            r17.add(r2);
            r18 = r18 + 1;
            goto L14
        L18:
            r2 = TaskSkillCategory.CREATOR.createFromParcel(r19);
            goto L19
        L20:
            r12 = r17;
            goto L22
        L9:
            r10 = false;
            goto L10
        L5:
            r1 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TaskSkill[] newArray(int r1) {
            return new TaskSkill[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public TaskSkill() {
        this(null, null, null, null, false, 0, false, null, null, 16383);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TaskSkill) == true) goto L8;
        return false;
    L8:
        TaskSkill r6 = (TaskSkill) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.externalSkillId, r6.externalSkillId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this._displayName, r6._displayName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this._displayDescription, r6._displayDescription) == true) goto L24;
        return false;
    L24:
        if (this.recommend == r6.recommend) goto L27;
        return false;
    L27:
        if (this.type == r6.type) goto L30;
        return false;
    L30:
        if (this.visible == r6.visible) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.path, r6.path) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.categories, r6.categories) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L42;
        return false;
    L42:
        if (this.b == r6.b) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.externalSkillId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.description;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this._displayName;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this._displayDescription;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        int r16 = 1231;
        if (this.recommend == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (((r15 + r17) * 31) + this.type) * 31;
        if (this.visible == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        String r21 = this.path;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        List<TaskSkillCategory> r24 = this.categories;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        Long r27 = this.a;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        if (this.b == true) goto L46;
        r16 = 1237;
    L46:
        int r30 = (r29 + r16) * 31;
        Integer r31 = this.c;
        if (r31 != null) goto L49;
        int r32 = 0;
    L50:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.d;
        if (r34 == null) goto L55;
        r1 = r34.hashCode();
    L55:
        return r33 + r1;
    L49:
        r32 = r31.hashCode();
        goto L50
    L41:
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = 1237;
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

    public final String toString() {
        return "TaskSkill(name=" + this.name + ", externalSkillId=" + this.externalSkillId + ", description=" + this.description + ", _displayName=" + this._displayName + ", _displayDescription=" + this._displayDescription + ", recommend=" + this.recommend + ", type=" + this.type + ", visible=" + this.visible + ", path=" + this.path + ", categories=" + this.categories + ", lastUsedAtMs=" + this.a + ", isSuggestionRecommended=" + this.b + ", suggestionPosition=" + this.c + ", suggestionSkillsLimit=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeString(this.name);
        r6.writeString(this.externalSkillId);
        r6.writeString(this.description);
        r6.writeString(this._displayName);
        r6.writeString(this._displayDescription);
        r6.writeInt(this.recommend ? 1 : 0);
        r6.writeInt(this.type);
        r6.writeInt(this.visible ? 1 : 0);
        r6.writeString(this.path);
        List<TaskSkillCategory> r0 = this.categories;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L12:
        Long r8 = this.a;
        if (r8 != null) goto L15;
        r6.writeInt(0);
    L16:
        r6.writeInt(this.b ? 1 : 0);
        Integer r9 = this.c;
        if (r9 != null) goto L19;
        r6.writeInt(0);
    L20:
        Integer r10 = this.d;
        if (r10 != null) goto L23;
        r6.writeInt(0);
        return;
    L23:
        r6.writeInt(1);
        r6.writeInt(r10.intValue());
        return;
    L19:
        r6.writeInt(1);
        r6.writeInt(r9.intValue());
        goto L20
    L15:
        r6.writeInt(1);
        r6.writeLong(r8.longValue());
        goto L16
    L5:
        r6.writeInt(1);
        r6.writeInt(r0.size());
        Iterator<TaskSkillCategory> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        TaskSkillCategory r3 = r1.next();
        if (r3 == null) goto L10;
        r6.writeInt(1);
        r3.writeToParcel(r6, r7);
        goto L7
    L10:
        r6.writeInt(0);
        goto L7
    }

    public final String b() {
        String r0 = this._displayDescription;
        if (r0 != null) goto L5;
    L9:
        String r1 = this.description;
        if (r1 != null) goto L14;
        return "";
    L14:
        return r1;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L9;
        return r0;
    }

    public final String c() {
        String r0 = this._displayName;
        if (r0 != null) goto L5;
    L9:
        String r1 = this.name;
        if (r1 != null) goto L14;
        return "";
    L14:
        return r1;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L9;
        return r0;
    }

    public final b h() {
        String r0 = this.name;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r0;
        String r4 = this.externalSkillId;
        String r3 = c();
        String r5 = b();
        boolean r7 = this.recommend;
        int r8 = this.type;
        String r9 = this.path;
        List<TaskSkillCategory> r1 = this.categories;
        if (r1 == null) goto L14;
        TaskSkillCategory r6 = (TaskSkillCategory) CollectionsKt.firstOrNull(r1);
        if (r6 == null) goto L14;
        String r10 = r6.a();
        if (r10 == null) goto L14;
        if ((!StringsKt.isBlank(r10)) == false) goto L14;
        String r11 = r10;
    L16:
        return new b(r2, r3, r4, r5, "", r7, r8, r9, r11, this.a, this.b, this.c, this.d);
    L14:
        r11 = null;
        goto L16
    }

    public final String d() {
        return this.externalSkillId;
    }

    public final String e() {
        return this.path;
    }

    public final boolean g() {
        return this.recommend;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public static TaskSkill a(TaskSkill r19, Long r20, boolean r21, Integer r22, Integer r23, int r24) {
        List<TaskSkillCategory> r3 = null;
        if ((r24 & 1) == 0) goto L5;
        String r5 = r19.name;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r6 = r19.externalSkillId;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r7 = r19.description;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r8 = r19._displayName;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r9 = r19._displayDescription;
    L23:
        if ((r24 & 32) == 0) goto L25;
        boolean r10 = r19.recommend;
    L27:
        if ((r24 & 64) == 0) goto L29;
        int r11 = r19.type;
    L31:
        if ((r24 & 128) == 0) goto L33;
        boolean r12 = r19.visible;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r13 = r19.path;
    L39:
        if ((r24 & 512) == 0) goto L41;
        r3 = r19.categories;
    L41:
        List<TaskSkillCategory> r14 = r3;
        if ((r24 & 1024) == 0) goto L44;
        Long r15 = r19.a;
    L46:
        if ((r24 & 2048) == 0) goto L48;
        boolean r16 = r19.b;
    L50:
        if ((r24 & 4096) == 0) goto L52;
        Integer r17 = r19.c;
    L54:
        if ((r24 & 8192) == 0) goto L56;
        Integer r18 = r19.d;
    L57:
        r19.getClass();
        return new TaskSkill(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L56:
        r18 = r23;
        goto L57
    L52:
        r17 = r22;
        goto L54
    L48:
        r16 = r21;
        goto L50
    L44:
        r15 = r20;
        goto L46
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = false;
        goto L35
    L29:
        r11 = 0;
        goto L31
    L25:
        r10 = false;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public /* synthetic */ TaskSkill(String r19, String r20, String r21, String r22, boolean r23, int r24, boolean r25, String r26, List r27, int r28) {
        if ((r28 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r28 & 32) == 0) goto L21;
        boolean r9 = false;
    L23:
        if ((r28 & 64) == 0) goto L25;
        int r10 = 0;
    L27:
        if ((r28 & 128) == 0) goto L29;
        boolean r11 = false;
    L31:
        if ((r28 & 256) == 0) goto L33;
        String r12 = null;
    L35:
        if ((r28 & 512) == 0) goto L37;
        List r13 = null;
    L38:
        this(r4, r5, r6, r7, null, r9, r10, r11, r12, r13, null, false, null, null);
        return;
    L37:
        r13 = r27;
        goto L38
    L33:
        r12 = r26;
        goto L35
    L29:
        r11 = r25;
        goto L31
    L25:
        r10 = r24;
        goto L27
    L21:
        r9 = r23;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public TaskSkill(String r1, String r2, String r3, String r4, String r5, boolean r6, int r7, boolean r8, String r9, List<TaskSkillCategory> r10, Long r11, boolean r12, Integer r13, Integer r14) {
        this.name = r1;
        this.externalSkillId = r2;
        this.description = r3;
        this._displayName = r4;
        this._displayDescription = r5;
        this.recommend = r6;
        this.type = r7;
        this.visible = r8;
        this.path = r9;
        this.categories = r10;
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = r14;
    }
}
