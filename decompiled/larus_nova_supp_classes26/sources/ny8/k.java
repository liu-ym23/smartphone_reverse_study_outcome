package ny8;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.ImageObject;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BË\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bHÆ\u0003JÒ\u0001\u0010/\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bHÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00066"}, d2 = {"Lcom/larus/canvas/service/bean/SsePullCanvasBlockInfoRequest;", "", "canvasType", "", "generateType", "localId", "", "sendMsgId", "replyMsgId", "conversationId", "instructionTab", "", "Lcom/larus/canvas/service/bean/InstructionTab;", "originImage", "Lcom/larus/canvas/service/bean/ImageObject;", "seqStart", "", "canvasId", "canvasSubId", "prompt", "displayPromptPerRound", "refImages", "originBlocks", "Lcom/larus/canvas/service/bean/CanvasBlock;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/larus/canvas/service/bean/ImageObject;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "getOriginBlocks", "()Ljava/util/List;", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "()Ljava/lang/Long;", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/larus/canvas/service/bean/ImageObject;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/larus/canvas/service/bean/SsePullCanvasBlockInfoRequest;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {
    public final transient List<CanvasBlock> a;

    @SerializedName("canvas_id")
    public final Long canvasId;

    @SerializedName("canvas_sub_id")
    public final Long canvasSubId;

    @SerializedName("canvas_type")
    public final Integer canvasType;

    @SerializedName(MusicAppletPage.KEY_CONVERSATION_ID)
    public final String conversationId;

    @SerializedName("display_prompt_per_round")
    public final String displayPromptPerRound;

    @SerializedName("generate_type")
    public final Integer generateType;

    @SerializedName("instruction_tab")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final List<InstructionTab> instructionTab;

    @SerializedName("local_id")
    public final String localId;

    @SerializedName("origin_image")
    public final ImageObject originImage;

    @SerializedName("prompt")
    public final String prompt;

    @SerializedName("ref_images")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final List<ImageObject> refImages;

    @SerializedName("reply_msg_id")
    public final String replyMsgId;

    @SerializedName("send_msg_id")
    public final String sendMsgId;

    @SerializedName("seq_start")
    public final Long seqStart;

    public k() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.canvasType, r6.canvasType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.generateType, r6.generateType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localId, r6.localId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sendMsgId, r6.sendMsgId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.replyMsgId, r6.replyMsgId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.instructionTab, r6.instructionTab) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.originImage, r6.originImage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.seqStart, r6.seqStart) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.canvasId, r6.canvasId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.canvasSubId, r6.canvasSubId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.displayPromptPerRound, r6.displayPromptPerRound) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.refImages, r6.refImages) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.canvasType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.generateType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.localId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.sendMsgId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.replyMsgId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.conversationId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<InstructionTab> r19 = this.instructionTab;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        ImageObject r22 = this.originImage;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.seqStart;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Long r28 = this.canvasId;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Long r31 = this.canvasSubId;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.prompt;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.displayPromptPerRound;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        List<ImageObject> r40 = this.refImages;
        if (r40 == null) goto L59;
        r1 = r40.hashCode();
    L59:
        return ((r39 + r1) * 31) + this.a.hashCode();
    L53:
        r38 = r37.hashCode();
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

    public final String toString() {
        return "SsePullCanvasBlockInfoRequest(canvasType=" + this.canvasType + ", generateType=" + this.generateType + ", localId=" + this.localId + ", sendMsgId=" + this.sendMsgId + ", replyMsgId=" + this.replyMsgId + ", conversationId=" + this.conversationId + ", instructionTab=" + this.instructionTab + ", originImage=" + this.originImage + ", seqStart=" + this.seqStart + ", canvasId=" + this.canvasId + ", canvasSubId=" + this.canvasSubId + ", prompt=" + this.prompt + ", displayPromptPerRound=" + this.displayPromptPerRound + ", refImages=" + this.refImages + ", originBlocks=" + this.a + ')';
    }

    public k(Integer r18, Integer r19, String r20, String r21, String r22, String r23, List r24, ImageObject r25, Long r26, Long r27, Long r28, String r29, String r30, List r31, int r32) {
        if ((r32 & 1) == 0) goto L5;
        Integer r2 = null;
    L7:
        if ((r32 & 2) == 0) goto L9;
        Integer r4 = null;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r32 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r32 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r32 & 64) == 0) goto L29;
        List r9 = null;
    L31:
        if ((r32 & 128) == 0) goto L33;
        ImageObject r10 = null;
    L35:
        if ((r32 & 256) == 0) goto L37;
        Long r11 = null;
    L39:
        if ((r32 & 512) == 0) goto L41;
        Long r12 = null;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        Long r13 = null;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        List r3 = null;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        List<CanvasBlock> r1 = CollectionsKt.emptyList();
    L62:
        Intrinsics.checkNotNullParameter(r1, "originBlocks");
        this.canvasType = r2;
        this.generateType = r4;
        this.localId = r5;
        this.sendMsgId = r6;
        this.replyMsgId = r7;
        this.conversationId = r8;
        this.instructionTab = r9;
        this.originImage = r10;
        this.seqStart = r11;
        this.canvasId = r12;
        this.canvasSubId = r13;
        this.prompt = r14;
        this.displayPromptPerRound = r15;
        this.refImages = r3;
        this.a = r1;
        return;
    L61:
        r1 = null;
        goto L62
    L57:
        r3 = r31;
        goto L59
    L53:
        r15 = r30;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
