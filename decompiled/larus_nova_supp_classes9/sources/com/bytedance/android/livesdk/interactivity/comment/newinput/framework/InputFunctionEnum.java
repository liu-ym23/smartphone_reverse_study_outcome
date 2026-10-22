package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0001\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bj\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionEnum;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mark", "I", "getMark", "()I", BuildConfig.FLAVOR, "priority", "J", "getPriority", "()J", "setPriority", "(J)V", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionType;", "type", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionType;", "getType", "()Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionType;", "setType", "(Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionType;)V", BuildConfig.FLAVOR, "logValue", "Ljava/lang/String;", "getLogValue", "()Ljava/lang/String;", "setLogValue", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "Companion", "a", "ChatInputCarrier_UnKnown", "ChatInputCarrier_Fold", "ChatInputCarrier_Emoji", "ChatInputCarrier_Audio", "ChatInputCarrier_Share", "ChatInputCarrier_Video", "ChatInputCarrier_FastChat", "ChatInputCarrier_CustomerService", "ChatInputCarrier_AI", "ChatInputCarrier_Mention", "ChatInputCarrier_Highlight", "ChatInputCarrier_Interest", "ChatInputCarrier_Truth", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputFunctionEnum extends Enum<InputFunctionEnum> {
    public static final InputFunctionEnum ChatInputCarrier_AI = null;
    public static final InputFunctionEnum ChatInputCarrier_Audio = null;
    public static final InputFunctionEnum ChatInputCarrier_CustomerService = null;
    public static final InputFunctionEnum ChatInputCarrier_Emoji = null;
    public static final InputFunctionEnum ChatInputCarrier_FastChat = null;
    public static final InputFunctionEnum ChatInputCarrier_Fold = null;
    public static final InputFunctionEnum ChatInputCarrier_Highlight = null;
    public static final InputFunctionEnum ChatInputCarrier_Interest = null;
    public static final InputFunctionEnum ChatInputCarrier_Mention = null;
    public static final InputFunctionEnum ChatInputCarrier_Share = null;
    public static final InputFunctionEnum ChatInputCarrier_Truth = null;
    public static final InputFunctionEnum ChatInputCarrier_UnKnown = null;
    public static final InputFunctionEnum ChatInputCarrier_Video = null;
    public static final a Companion = null;
    public static final /* synthetic */ InputFunctionEnum[] a = null;
    private String desc;
    private String logValue;
    private final int mark;
    private long priority;
    private InputFunctionType type;

    public static final class a {
        public a() {
        }
    }

    public static InputFunctionEnum valueOf(String r1) {
        return (InputFunctionEnum) r27.a.a(InputFunctionEnum.class, r1);
    }

    public static InputFunctionEnum[] values() {
        return (InputFunctionEnum[]) a.clone();
    }

    static {
        InputFunctionType r20 = InputFunctionType.Common;
        InputFunctionEnum r10 = new InputFunctionEnum("ChatInputCarrier_UnKnown", 0, 0, 0, r20, CardLockInfo.sUNKNOWN, "未知");
        ChatInputCarrier_UnKnown = r10;
        InputFunctionEnum r1 = new InputFunctionEnum("ChatInputCarrier_Fold", 1, 10000, 100000, InputFunctionType.Function, "fold", "展开");
        ChatInputCarrier_Fold = r1;
        InputFunctionEnum r2 = new InputFunctionEnum("ChatInputCarrier_Emoji", 2, 1, 600, r20, "emoji", "表情");
        ChatInputCarrier_Emoji = r2;
        InputFunctionEnum r3 = new InputFunctionEnum("ChatInputCarrier_Audio", 3, 2, 500, r20, "audio", "语音功能");
        ChatInputCarrier_Audio = r3;
        InputFunctionEnum r4 = new InputFunctionEnum("ChatInputCarrier_Share", 4, 3, 400, r20, "collection", "互动分享");
        ChatInputCarrier_Share = r4;
        InputFunctionEnum r5 = new InputFunctionEnum("ChatInputCarrier_Video", 5, 4, 300, r20, "video_share", "视频");
        ChatInputCarrier_Video = r5;
        InputFunctionType r6 = InputFunctionType.Special;
        InputFunctionEnum r7 = new InputFunctionEnum("ChatInputCarrier_FastChat", 6, 5, 200, r6, "common_comment", "快捷评论");
        ChatInputCarrier_FastChat = r7;
        InputFunctionEnum r8 = new InputFunctionEnum("ChatInputCarrier_CustomerService", 7, 6, 100, r6, "custom_service", "客服");
        ChatInputCarrier_CustomerService = r8;
        InputFunctionEnum r9 = new InputFunctionEnum("ChatInputCarrier_AI", 8, 7, 250, r6, "ai_qa", "AI互动入口");
        ChatInputCarrier_AI = r9;
        InputFunctionEnum r11 = new InputFunctionEnum("ChatInputCarrier_Mention", 9, 8, 700, r20, "mention", "At他人");
        ChatInputCarrier_Mention = r11;
        InputFunctionEnum r13 = new InputFunctionEnum("ChatInputCarrier_Highlight", 10, 9, 300, r6, "comment_highlight", "标记高光");
        ChatInputCarrier_Highlight = r13;
        InputFunctionType r15 = InputFunctionType.More;
        InputFunctionEnum r14 = new InputFunctionEnum("ChatInputCarrier_Interest", 11, IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW, 0, r15, "interest_card", "分享兴趣");
        ChatInputCarrier_Interest = r14;
        InputFunctionEnum r16 = new InputFunctionEnum("ChatInputCarrier_Truth", 12, 1001, 0, r15, "truth_question", "真心话");
        ChatInputCarrier_Truth = r16;
        a = new InputFunctionEnum[]{r10, r1, r2, r3, r4, r5, r7, r8, r9, r11, r13, r14, r16};
        Companion = new a();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getLogValue() {
        return this.logValue;
    }

    public final int getMark() {
        return this.mark;
    }

    public final long getPriority() {
        return this.priority;
    }

    public final InputFunctionType getType() {
        return this.type;
    }

    public final void setDesc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.desc = r2;
    }

    public final void setLogValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.logValue = r2;
    }

    public final void setPriority(long r1) {
        this.priority = r1;
    }

    public final void setType(InputFunctionType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    public InputFunctionEnum(String r1, int r2, int r3, long r4, InputFunctionType r6, String r7, String r8) {
        super(r1, r2);
        this.mark = r3;
        this.priority = r4;
        this.type = r6;
        this.logValue = r7;
        this.desc = r8;
    }
}
