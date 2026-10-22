package l98;

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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\rJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\rHÆ\u0003J}\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\rHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006."}, d2 = {"Lcom/larus/avlink/env/diary/model/DiaryItem;", "", "id", "", "createTime", "title", "statusTag", "nextUpdateTime", "emotionInfo", "Lcom/larus/avlink/env/diary/model/EmotionInfo;", "summary", "content", "blockList", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/avlink/env/diary/model/EmotionInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getCreateTime", "getTitle", "getStatusTag", "getNextUpdateTime", "getEmotionInfo", "()Lcom/larus/avlink/env/diary/model/EmotionInfo;", "getSummary", "getContent", "getBlockList", "()Ljava/util/List;", "deserializeContentToBlocks", "Lcom/larus/im/bean/message/block/Block;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class a {

    @SerializedName("preview_contents")
    private final List<String> blockList;

    @SerializedName("content")
    private final String content;

    @SerializedName("create_time")
    private final String createTime;

    @SerializedName("emotion_info")
    private final b emotionInfo;

    @SerializedName("diary_id")
    private final String id;

    @SerializedName("next_update_time")
    private final String nextUpdateTime;

    @SerializedName("status_tag")
    private final String statusTag;

    @SerializedName("summary")
    private final String summary;

    @SerializedName("title")
    private final String title;

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
        if (Intrinsics.areEqual(this.statusTag, r6.statusTag) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.nextUpdateTime, r6.nextUpdateTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.emotionInfo, r6.emotionInfo) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.summary, r6.summary) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.blockList, r6.blockList) == true) goto L35;
        return false;
    L35:
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
        String r10 = this.statusTag;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.nextUpdateTime;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        b r16 = this.emotionInfo;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.summary;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.content;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        List<String> r25 = this.blockList;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
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

    public final String toString() {
        return "DiaryItem(id=" + this.id + ", createTime=" + this.createTime + ", title=" + this.title + ", statusTag=" + this.statusTag + ", nextUpdateTime=" + this.nextUpdateTime + ", emotionInfo=" + this.emotionInfo + ", summary=" + this.summary + ", content=" + this.content + ", blockList=" + this.blockList + ')';
    }

    public final List<Block> a() {
        FLogger r3 = FLogger.a;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        StringBuilder r4 = new StringBuilder("deserializeContentToBlocks: tempField size = ");     // Catch: Exception -> L32 JsonSyntaxException -> L34
        List<String> r1 = this.blockList;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r1 == null) goto L6;
        Integer r2 = Integer.valueOf(r1.size());     // Catch: Exception -> L32 JsonSyntaxException -> L34
    L7:
        r4.append(r2);     // Catch: Exception -> L32 JsonSyntaxException -> L34
        r3.d("DiaryItem", r4.toString());     // Catch: Exception -> L32 JsonSyntaxException -> L34
        List<String> r5 = this.blockList;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r5 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L16;
        r3.w("DiaryItem", "tempField is null or empty");     // Catch: Exception -> L32 JsonSyntaxException -> L34
        return null;
    L16:
        Gson r7 = new Gson();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        List<String> r8 = this.blockList;     // Catch: Exception -> L32 JsonSyntaxException -> L34
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
        r12.d("DiaryItem", r13.toString());     // Catch: Exception -> L26
        Block r15 = (Block) r7.fromJson(r11, Block.class);     // Catch: Exception -> L26
    L28:
        if (r15 == null) goto L18;
        r9.add(r15);     // Catch: Exception -> L32 JsonSyntaxException -> L34
        goto L18
    L23:
        r14 = null;
    L26:
        e = move-exception;
        FLogger.a.e("DiaryItem", "Failed to parse single block: " + e.getMessage());     // Catch: Exception -> L32 JsonSyntaxException -> L34
        r15 = null;
        goto L28
    L30:
        FLogger.a.d("DiaryItem", "Successfully parsed " + r9.size() + " blocks");     // Catch: Exception -> L32 JsonSyntaxException -> L34
        return r9;
    L10:
        if (r5.isEmpty() == true) goto L13;
        r6 = false;
        goto L14
    L6:
        r2 = null;
    L34:
        e = move-exception;
        FLogger.a.e("DiaryItem", "Failed to deserialize content to blocks: " + e.getMessage());
        return null;
    L32:
        e = move-exception;
        FLogger.a.e("DiaryItem", "Error deserializing content to blocks: " + e.getMessage());
        return null;
    }

    public a() {
        this.id = null;
        this.createTime = "";
        this.title = null;
        this.statusTag = null;
        this.nextUpdateTime = "";
        this.emotionInfo = null;
        this.summary = null;
        this.content = null;
        this.blockList = null;
    }

    public final List<String> b() {
        return this.blockList;
    }

    public final String c() {
        return this.createTime;
    }

    public final b d() {
        return this.emotionInfo;
    }

    public final String e() {
        return this.id;
    }

    public final String f() {
        return this.nextUpdateTime;
    }

    public final String g() {
        return this.title;
    }
}
