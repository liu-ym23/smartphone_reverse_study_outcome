package com.larus.bmhome.chat.ab;

import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/ab/InputMultilineScene;", "", "sceneKey", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSceneKey", "()Ljava/lang/String;", "MAIN_CHAT", "IM_CHAT", "COT_DETAIL", "ALBUM_QUICK_INPUT", "CAMERA_PREVIEW", "GALLERY_PREVIEW", "DRIVE_PREVIEW", "OFFICE_DOC", "FLOAT_CHAT", "APPLET", "SKILL_PANEL", "CREATION", SuggestActionType.MUSIC, "NOTE", "CANVAS", "MINI_ARTIFACT", "LIVE_TUTOR", "VENUE", "OBRIC", "ECOMMERCE", "CHAT_JOB", "DOC_MEDIA_SELECT", "OUTER_CHAT", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum InputMultilineScene extends Enum<InputMultilineScene> {
    public static final InputMultilineScene ALBUM_QUICK_INPUT = null;
    public static final InputMultilineScene APPLET = null;
    public static final InputMultilineScene CAMERA_PREVIEW = null;
    public static final InputMultilineScene CANVAS = null;
    public static final InputMultilineScene CHAT_JOB = null;
    public static final InputMultilineScene COT_DETAIL = null;
    public static final InputMultilineScene CREATION = null;
    public static final InputMultilineScene DOC_MEDIA_SELECT = null;
    public static final InputMultilineScene DRIVE_PREVIEW = null;
    public static final InputMultilineScene ECOMMERCE = null;
    public static final InputMultilineScene FLOAT_CHAT = null;
    public static final InputMultilineScene GALLERY_PREVIEW = null;
    public static final InputMultilineScene IM_CHAT = null;
    public static final InputMultilineScene LIVE_TUTOR = null;
    public static final InputMultilineScene MAIN_CHAT = null;
    public static final InputMultilineScene MINI_ARTIFACT = null;
    public static final InputMultilineScene MUSIC = null;
    public static final InputMultilineScene NOTE = null;
    public static final InputMultilineScene OBRIC = null;
    public static final InputMultilineScene OFFICE_DOC = null;
    public static final InputMultilineScene OUTER_CHAT = null;
    public static final InputMultilineScene SKILL_PANEL = null;
    public static final InputMultilineScene VENUE = null;
    public static final /* synthetic */ InputMultilineScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String sceneKey;

    public static EnumEntries<InputMultilineScene> getEntries() {
        return b;
    }

    static {
        InputMultilineScene r0 = new InputMultilineScene("MAIN_CHAT", 0, "main_chat");
        MAIN_CHAT = r0;
        InputMultilineScene r1 = new InputMultilineScene("IM_CHAT", 1, "im_chat");
        IM_CHAT = r1;
        InputMultilineScene r2 = new InputMultilineScene("COT_DETAIL", 2, "cot_detail");
        COT_DETAIL = r2;
        InputMultilineScene r4 = new InputMultilineScene("ALBUM_QUICK_INPUT", 3, "album_quick_input");
        ALBUM_QUICK_INPUT = r4;
        InputMultilineScene r6 = new InputMultilineScene("CAMERA_PREVIEW", 4, "camera_preview");
        CAMERA_PREVIEW = r6;
        InputMultilineScene r8 = new InputMultilineScene("GALLERY_PREVIEW", 5, "gallery_preview");
        GALLERY_PREVIEW = r8;
        InputMultilineScene r10 = new InputMultilineScene("DRIVE_PREVIEW", 6, "drive_preview");
        DRIVE_PREVIEW = r10;
        InputMultilineScene r12 = new InputMultilineScene("OFFICE_DOC", 7, "office_doc");
        OFFICE_DOC = r12;
        InputMultilineScene r14 = new InputMultilineScene("FLOAT_CHAT", 8, "float_chat");
        FLOAT_CHAT = r14;
        InputMultilineScene r13 = new InputMultilineScene("APPLET", 9, "applet");
        APPLET = r13;
        InputMultilineScene r11 = new InputMultilineScene("SKILL_PANEL", 10, "skill_panel");
        SKILL_PANEL = r11;
        InputMultilineScene r9 = new InputMultilineScene("CREATION", 11, "creation");
        CREATION = r9;
        InputMultilineScene r7 = new InputMultilineScene(SuggestActionType.MUSIC, 12, "music");
        MUSIC = r7;
        InputMultilineScene r5 = new InputMultilineScene("NOTE", 13, "note");
        NOTE = r5;
        InputMultilineScene r3 = new InputMultilineScene("CANVAS", 14, "canvas");
        CANVAS = r3;
        InputMultilineScene r15 = new InputMultilineScene("MINI_ARTIFACT", 15, "mini_artifact");
        MINI_ARTIFACT = r15;
        InputMultilineScene r16 = new InputMultilineScene("LIVE_TUTOR", 16, "live_tutor");
        LIVE_TUTOR = r16;
        InputMultilineScene r17 = new InputMultilineScene("VENUE", 17, "venue");
        VENUE = r17;
        InputMultilineScene r18 = new InputMultilineScene("OBRIC", 18, "obric");
        OBRIC = r18;
        InputMultilineScene r19 = new InputMultilineScene("ECOMMERCE", 19, "ecommerce");
        ECOMMERCE = r19;
        InputMultilineScene r20 = new InputMultilineScene("CHAT_JOB", 20, "chat_job");
        CHAT_JOB = r20;
        InputMultilineScene r21 = new InputMultilineScene("DOC_MEDIA_SELECT", 21, "doc_media_select");
        DOC_MEDIA_SELECT = r21;
        InputMultilineScene r22 = new InputMultilineScene("OUTER_CHAT", 22, "outer_chat");
        OUTER_CHAT = r22;
        InputMultilineScene[] r23 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17, r18, r19, r20, r21, r22};
        a = r23;
        b = EnumEntriesKt.enumEntries(r23);
    }

    public static InputMultilineScene[] values() {
        return (InputMultilineScene[]) a.clone();
    }

    public final String getSceneKey() {
        return this.sceneKey;
    }

    public static InputMultilineScene valueOf(String r1) {
        return (InputMultilineScene) a.a(InputMultilineScene.class, r1);
    }

    public InputMultilineScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.sceneKey = r3;
    }
}
