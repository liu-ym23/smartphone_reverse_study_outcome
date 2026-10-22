package i98;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\nJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u00109\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010(J¤\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0013HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b,\u0010\u001d¨\u0006@"}, d2 = {"Lcom/larus/avlink/env/diary/detail/model/DiaryDetail;", "", "id", "", "createTime", "title", "isRecording", "", "statusTag", "content", "", "emotionInfo", "Lcom/larus/avlink/env/diary/model/EmotionInfo;", "summary", "nextUpdateTime", "diaryStyle", "Lcom/larus/avlink/env/diary/style/api/DiaryStyleInfo;", "hasSetStyle", "actionType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Lcom/larus/avlink/env/diary/model/EmotionInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/avlink/env/diary/style/api/DiaryStyleInfo;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getCreateTime", "getTitle", "()Z", "getStatusTag", "getContent", "()Ljava/util/List;", "getEmotionInfo", "()Lcom/larus/avlink/env/diary/model/EmotionInfo;", "getSummary", "getNextUpdateTime", "getDiaryStyle", "()Lcom/larus/avlink/env/diary/style/api/DiaryStyleInfo;", "getHasSetStyle", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getActionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "blocks", "Lcom/larus/im/bean/message/block/Block;", "getBlocks", "deserializeContentToBlocks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Lcom/larus/avlink/env/diary/model/EmotionInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/avlink/env/diary/style/api/DiaryStyleInfo;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/avlink/env/diary/detail/model/DiaryDetail;", "equals", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class a {

    @SerializedName("action_type")
    private final Integer actionType;

    @SerializedName("contents")
    private final List<String> content;

    @SerializedName("create_time")
    private final String createTime;

    @SerializedName("style_info")
    private final m98.b diaryStyle;

    @SerializedName("emotion_info")
    private final l98.b emotionInfo;

    @SerializedName("has_set_style")
    private final Boolean hasSetStyle;

    @SerializedName("diary_id")
    private final String id;

    @SerializedName("is_recording")
    private final boolean isRecording;

    @SerializedName("next_update_time")
    private final String nextUpdateTime;

    @SerializedName("status_tag")
    private final String statusTag;

    @SerializedName("summary")
    private final String summary;

    @SerializedName("title")
    private final String title;

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null, 4095);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (this.isRecording == r6.isRecording) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.statusTag, r6.statusTag) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.emotionInfo, r6.emotionInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.summary, r6.summary) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.nextUpdateTime, r6.nextUpdateTime) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.diaryStyle, r6.diaryStyle) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.hasSetStyle, r6.hasSetStyle) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.actionType, r6.actionType) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.createTime;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.title;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.isRecording == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        String r12 = this.statusTag;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        List<String> r15 = this.content;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        l98.b r18 = this.emotionInfo;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        String r21 = this.summary;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        String r24 = this.nextUpdateTime;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        m98.b r27 = this.diaryStyle;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        Boolean r30 = this.hasSetStyle;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        Integer r33 = this.actionType;
        if (r33 == null) goto L51;
        r1 = r33.hashCode();
    L51:
        return r32 + r1;
    L45:
        r31 = r30.hashCode();
        goto L46
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
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = 1237;
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
        return "DiaryDetail(id=" + this.id + ", createTime=" + this.createTime + ", title=" + this.title + ", isRecording=" + this.isRecording + ", statusTag=" + this.statusTag + ", content=" + this.content + ", emotionInfo=" + this.emotionInfo + ", summary=" + this.summary + ", nextUpdateTime=" + this.nextUpdateTime + ", diaryStyle=" + this.diaryStyle + ", hasSetStyle=" + this.hasSetStyle + ", actionType=" + this.actionType + ')';
    }

    public final List<Block> c() {
        FLogger r3 = FLogger.a;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        StringBuilder r4 = new StringBuilder("deserializeContentToBlocks: content size = ");     // Catch: Exception -> L32 JsonSyntaxException -> L34
        List<String> r1 = this.content;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r1 == null) goto L6;
        Integer r2 = Integer.valueOf(r1.size());     // Catch: Exception -> L32 JsonSyntaxException -> L34
    L7:
        r4.append(r2);     // Catch: Exception -> L32 JsonSyntaxException -> L34
        r3.d("DiaryDetail", r4.toString());     // Catch: Exception -> L32 JsonSyntaxException -> L34
        List<String> r5 = this.content;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r5 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L16;
        r3.w("DiaryDetail", "content is null or empty");     // Catch: Exception -> L32 JsonSyntaxException -> L34
        return null;
    L16:
        Gson r7 = new Gson();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        List<String> r8 = this.content;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        ArrayList r9 = new ArrayList();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        Iterator<T> r10 = r8.iterator();     // Catch: Exception -> L32 JsonSyntaxException -> L34
    L18:
        if (r10.hasNext() == false) goto L30;
        String r11 = (String) r10.next();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        FLogger r12 = FLogger.a;     // Catch: Exception -> L26
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L26
        r13.append("Parsing block: ");     // Catch: Exception -> L26
        if (r11 == null) goto L23;
        String r14 = StringsKt.take(r11, 100);     // Catch: Exception -> L26
    L24:
        r13.append(r14);     // Catch: Exception -> L26
        r13.append("...");     // Catch: Exception -> L26
        r12.d("DiaryDetail", r13.toString());     // Catch: Exception -> L26
        Block r15 = (Block) r7.fromJson(r11, Block.class);     // Catch: Exception -> L26
    L28:
        if (r15 == null) goto L18;
        r9.add(r15);     // Catch: Exception -> L32 JsonSyntaxException -> L34
        goto L18
    L23:
        r14 = null;
    L26:
        e = move-exception;
        FLogger.a.e("DiaryDetail", "Failed to parse single block: " + e.getMessage());     // Catch: Exception -> L32 JsonSyntaxException -> L34
        r15 = null;
        goto L28
    L30:
        FLogger.a.d("DiaryDetail", "Successfully parsed " + r9.size() + " blocks");     // Catch: Exception -> L32 JsonSyntaxException -> L34
        return r9;
    L10:
        if (r5.isEmpty() == true) goto L13;
        r6 = false;
        goto L14
    L6:
        r2 = null;
    L34:
        e = move-exception;
        FLogger.a.e("DiaryDetail", "Failed to deserialize content to blocks: " + e.getMessage());
        return null;
    L32:
        e = move-exception;
        FLogger.a.e("DiaryDetail", "Error deserializing content to blocks: " + e.getMessage());
        return null;
    }

    public final Integer b() {
        return this.actionType;
    }

    public final List<String> d() {
        return this.content;
    }

    public final String e() {
        return this.createTime;
    }

    public final m98.b f() {
        return this.diaryStyle;
    }

    public final l98.b g() {
        return this.emotionInfo;
    }

    public final Boolean h() {
        return this.hasSetStyle;
    }

    public final String i() {
        return this.id;
    }

    public final String j() {
        return this.nextUpdateTime;
    }

    public final String k() {
        return this.statusTag;
    }

    public final String l() {
        return this.summary;
    }

    public final String m() {
        return this.title;
    }

    public static a a(a r17, Integer r18, int r19) {
        Boolean r3 = null;
        if ((r19 & 1) == 0) goto L5;
        String r5 = r17.id;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r6 = r17.createTime;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r7 = r17.title;
    L15:
        if ((r19 & 8) == 0) goto L17;
        boolean r8 = r17.isRecording;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r9 = r17.statusTag;
    L23:
        if ((r19 & 32) == 0) goto L25;
        List<String> r10 = r17.content;
    L27:
        if ((r19 & 64) == 0) goto L29;
        l98.b r11 = r17.emotionInfo;
    L31:
        if ((r19 & 128) == 0) goto L33;
        String r12 = r17.summary;
    L35:
        if ((r19 & 256) == 0) goto L37;
        String r13 = r17.nextUpdateTime;
    L39:
        if ((r19 & 512) == 0) goto L41;
        m98.b r14 = r17.diaryStyle;
    L43:
        if ((r19 & 1024) == 0) goto L45;
        r3 = r17.hasSetStyle;
    L45:
        Boolean r15 = r3;
        if ((r19 & 2048) == 0) goto L48;
        Integer r16 = r17.actionType;
    L50:
        return new a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L48:
        r16 = r18;
        goto L50
    L41:
        r14 = null;
        goto L43
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = false;
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

    public /* synthetic */ a(String r17, String r18, String r19, String r20, List r21, l98.b r22, String r23, String r24, m98.b r25, Boolean r26, Integer r27, int r28) {
        if ((r28 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r28 & 16) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r28 & 32) == 0) goto L21;
        List r9 = null;
    L23:
        if ((r28 & 64) == 0) goto L25;
        l98.b r10 = null;
    L27:
        if ((r28 & 128) == 0) goto L29;
        String r11 = null;
    L31:
        if ((r28 & 256) == 0) goto L33;
        String r12 = null;
    L35:
        if ((r28 & 512) == 0) goto L37;
        m98.b r13 = null;
    L39:
        if ((r28 & 1024) == 0) goto L41;
        Boolean r14 = Boolean.FALSE;
    L43:
        if ((r28 & 2048) == 0) goto L45;
        Integer r15 = null;
    L46:
        this(r4, r5, r6, false, r8, r9, r10, r11, r12, r13, r14, r15);
        return;
    L45:
        r15 = r27;
        goto L46
    L41:
        r14 = r26;
        goto L43
    L37:
        r13 = r25;
        goto L39
    L33:
        r12 = r24;
        goto L35
    L29:
        r11 = r23;
        goto L31
    L25:
        r10 = r22;
        goto L27
    L21:
        r9 = r21;
        goto L23
    L17:
        r8 = r20;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public a(String r1, String r2, String r3, boolean r4, String r5, List<String> r6, l98.b r7, String r8, String r9, m98.b r10, Boolean r11, Integer r12) {
        this.id = r1;
        this.createTime = r2;
        this.title = r3;
        this.isRecording = r4;
        this.statusTag = r5;
        this.content = r6;
        this.emotionInfo = r7;
        this.summary = r8;
        this.nextUpdateTime = r9;
        this.diaryStyle = r10;
        this.hasSetStyle = r11;
        this.actionType = r12;
    }
}
