package com.ss.android.lark.inline.ai.api.ui;

import android.view.View;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\bc\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u008b\u00012\u00020\u0001:\u0004\u008b\u0001\u008c\u0001B\u009b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0004\b'\u0010(J\b\u0010o\u001a\u00020\u0007H\u0016J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010s\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0002\u0010kJ¤\u0002\u0010\u0085\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\"\u001a\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010$\u001a\u00020\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&HÆ\u0001¢\u0006\u0003\u0010\u0086\u0001J\u0015\u0010\u0087\u0001\u001a\u00020\u00032\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\nHÖ\u0003J\u000b\u0010\u0089\u0001\u001a\u00030\u008a\u0001HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R:\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00101\"\u0004\b]\u00103R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u00101\"\u0004\b_\u00103R\u001c\u0010 \u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00101\"\u0004\ba\u00103R\u001c\u0010!\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00101\"\u0004\bc\u00103R\u001a\u0010\"\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010)\"\u0004\be\u0010+R\u001c\u0010#\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00101\"\u0004\bg\u00103R\u001a\u0010$\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010)\"\u0004\bi\u0010+R\u001e\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010n\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m¨\u0006\u008d\u0001"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/InlineAIPanel;", "Ljava/io/Serializable;", "isContentUseCustomView", "", "contentCustomView", "Landroid/view/View;", "content", "", "contentExtra", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "images", "Lcom/ss/android/lark/inline/ai/api/ui/Images;", "prompts", "Lcom/ss/android/lark/inline/ai/api/ui/Prompts;", "operates", "Lcom/ss/android/lark/inline/ai/api/ui/Operates;", "input", "Lcom/ss/android/lark/inline/ai/api/ui/Input;", "range", "Lcom/ss/android/lark/inline/ai/api/ui/Range;", "tips", "Lcom/ss/android/lark/inline/ai/api/ui/Tips;", "feedback", "Lcom/ss/android/lark/inline/ai/api/ui/Feedback;", "history", "Lcom/ss/android/lark/inline/ai/api/ui/History;", "dragBar", "Lcom/ss/android/lark/inline/ai/api/ui/DragBar;", "conversationId", "taskId", "theme", "maskType", "lock", "style", "showOnboarding", "heightRatio", "", "<init>", "(ZLandroid/view/View;Ljava/lang/String;Ljava/util/HashMap;Lcom/ss/android/lark/inline/ai/api/ui/Images;Lcom/ss/android/lark/inline/ai/api/ui/Prompts;Lcom/ss/android/lark/inline/ai/api/ui/Operates;Lcom/ss/android/lark/inline/ai/api/ui/Input;Lcom/ss/android/lark/inline/ai/api/ui/Range;Lcom/ss/android/lark/inline/ai/api/ui/Tips;Lcom/ss/android/lark/inline/ai/api/ui/Feedback;Lcom/ss/android/lark/inline/ai/api/ui/History;Lcom/ss/android/lark/inline/ai/api/ui/DragBar;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/Float;)V", "()Z", "setContentUseCustomView", "(Z)V", "getContentCustomView", "()Landroid/view/View;", "setContentCustomView", "(Landroid/view/View;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContentExtra", "()Ljava/util/HashMap;", "setContentExtra", "(Ljava/util/HashMap;)V", "getImages", "()Lcom/ss/android/lark/inline/ai/api/ui/Images;", "setImages", "(Lcom/ss/android/lark/inline/ai/api/ui/Images;)V", "getPrompts", "()Lcom/ss/android/lark/inline/ai/api/ui/Prompts;", "setPrompts", "(Lcom/ss/android/lark/inline/ai/api/ui/Prompts;)V", "getOperates", "()Lcom/ss/android/lark/inline/ai/api/ui/Operates;", "setOperates", "(Lcom/ss/android/lark/inline/ai/api/ui/Operates;)V", "getInput", "()Lcom/ss/android/lark/inline/ai/api/ui/Input;", "setInput", "(Lcom/ss/android/lark/inline/ai/api/ui/Input;)V", "getRange", "()Lcom/ss/android/lark/inline/ai/api/ui/Range;", "setRange", "(Lcom/ss/android/lark/inline/ai/api/ui/Range;)V", "getTips", "()Lcom/ss/android/lark/inline/ai/api/ui/Tips;", "setTips", "(Lcom/ss/android/lark/inline/ai/api/ui/Tips;)V", "getFeedback", "()Lcom/ss/android/lark/inline/ai/api/ui/Feedback;", "setFeedback", "(Lcom/ss/android/lark/inline/ai/api/ui/Feedback;)V", "getHistory", "()Lcom/ss/android/lark/inline/ai/api/ui/History;", "setHistory", "(Lcom/ss/android/lark/inline/ai/api/ui/History;)V", "getDragBar", "()Lcom/ss/android/lark/inline/ai/api/ui/DragBar;", "setDragBar", "(Lcom/ss/android/lark/inline/ai/api/ui/DragBar;)V", "getConversationId", "setConversationId", "getTaskId", "setTaskId", "getTheme", "setTheme", "getMaskType", "setMaskType", "getLock", "setLock", "getStyle", "setStyle", "getShowOnboarding", "setShowOnboarding", "getHeightRatio", "()Ljava/lang/Float;", "setHeightRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(ZLandroid/view/View;Ljava/lang/String;Ljava/util/HashMap;Lcom/ss/android/lark/inline/ai/api/ui/Images;Lcom/ss/android/lark/inline/ai/api/ui/Prompts;Lcom/ss/android/lark/inline/ai/api/ui/Operates;Lcom/ss/android/lark/inline/ai/api/ui/Input;Lcom/ss/android/lark/inline/ai/api/ui/Range;Lcom/ss/android/lark/inline/ai/api/ui/Tips;Lcom/ss/android/lark/inline/ai/api/ui/Feedback;Lcom/ss/android/lark/inline/ai/api/ui/History;Lcom/ss/android/lark/inline/ai/api/ui/DragBar;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/Float;)Lcom/ss/android/lark/inline/ai/api/ui/InlineAIPanel;", "equals", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "Companion", "Builder", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InlineAIPanel implements Serializable {
    public static final a Companion = null;
    public static final String STYLE_FULLSCREEN = "fullScreen";
    public transient View a;
    private String content;
    private HashMap<String, Object> contentExtra;
    private String conversationId;
    private DragBar dragBar;
    private Feedback feedback;
    private Float heightRatio;
    private History history;
    private Images images;
    private Input input;
    private boolean isContentUseCustomView;
    private boolean lock;
    private String maskType;
    private Operates operates;
    private Prompts prompts;
    private Range range;
    private boolean showOnboarding;
    private String style;
    private String taskId;
    private String theme;
    private Tips tips;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public InlineAIPanel() {
        this(false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, false, null, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InlineAIPanel copy$default(InlineAIPanel r17, boolean r18, View r19, String r20, HashMap r21, Images r22, Prompts r23, Operates r24, Input r25, Range r26, Tips r27, Feedback r28, History r29, DragBar r30, String r31, String r32, String r33, String r34, boolean r35, String r36, boolean r37, Float r38, int r39, Object r40) {
        if ((r39 & 1) == 0) goto L5;
        boolean r2 = r17.isContentUseCustomView;
    L7:
        if ((r39 & 2) == 0) goto L9;
        View r3 = r17.a;
    L11:
        if ((r39 & 4) == 0) goto L13;
        String r4 = r17.content;
    L15:
        if ((r39 & 8) == 0) goto L17;
        HashMap r5 = r17.contentExtra;
    L19:
        if ((r39 & 16) == 0) goto L21;
        Images r6 = r17.images;
    L23:
        if ((r39 & 32) == 0) goto L25;
        Prompts r7 = r17.prompts;
    L27:
        if ((r39 & 64) == 0) goto L29;
        Operates r8 = r17.operates;
    L31:
        if ((r39 & 128) == 0) goto L33;
        Input r9 = r17.input;
    L35:
        if ((r39 & 256) == 0) goto L37;
        Range r10 = r17.range;
    L39:
        if ((r39 & 512) == 0) goto L41;
        Tips r11 = r17.tips;
    L43:
        if ((r39 & 1024) == 0) goto L45;
        Feedback r12 = r17.feedback;
    L47:
        if ((r39 & 2048) == 0) goto L49;
        History r13 = r17.history;
    L51:
        if ((r39 & 4096) == 0) goto L53;
        DragBar r14 = r17.dragBar;
    L55:
        if ((r39 & 8192) == 0) goto L57;
        String r15 = r17.conversationId;
    L58:
        String r310 = r15;
        if ((r39 & 16384) == 0) goto L61;
        String r16 = r17.taskId;
    L62:
        String r311 = r16;
        if ((r39 & 32768) == 0) goto L65;
        String r110 = r17.theme;
    L66:
        String r312 = r110;
        if ((r39 & 65536) == 0) goto L69;
        String r111 = r17.maskType;
    L70:
        String r313 = r111;
        if ((r39 & 131072) == 0) goto L73;
        boolean r112 = r17.lock;
    L74:
        boolean r314 = r112;
        if ((r39 & 262144) == 0) goto L77;
        String r113 = r17.style;
    L78:
        String r315 = r113;
        if ((r39 & 524288) == 0) goto L81;
        boolean r114 = r17.showOnboarding;
    L83:
        if ((r39 & 1048576) == 0) goto L85;
        Float r1 = r17.heightRatio;
    L87:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r114, r1);
    L85:
        r1 = r38;
        goto L87
    L81:
        r114 = r37;
        goto L83
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final boolean component1() {
        return this.isContentUseCustomView;
    }

    public final Tips component10() {
        return this.tips;
    }

    public final Feedback component11() {
        return this.feedback;
    }

    public final History component12() {
        return this.history;
    }

    public final DragBar component13() {
        return this.dragBar;
    }

    public final String component14() {
        return this.conversationId;
    }

    public final String component15() {
        return this.taskId;
    }

    public final String component16() {
        return this.theme;
    }

    public final String component17() {
        return this.maskType;
    }

    public final boolean component18() {
        return this.lock;
    }

    public final String component19() {
        return this.style;
    }

    public final View component2() {
        return this.a;
    }

    public final boolean component20() {
        return this.showOnboarding;
    }

    public final Float component21() {
        return this.heightRatio;
    }

    public final String component3() {
        return this.content;
    }

    public final HashMap<String, Object> component4() {
        return this.contentExtra;
    }

    public final Images component5() {
        return this.images;
    }

    public final Prompts component6() {
        return this.prompts;
    }

    public final Operates component7() {
        return this.operates;
    }

    public final Input component8() {
        return this.input;
    }

    public final Range component9() {
        return this.range;
    }

    public final InlineAIPanel copy(boolean r24, View r25, String r26, HashMap<String, Object> r27, Images r28, Prompts r29, Operates r30, Input r31, Range r32, Tips r33, Feedback r34, History r35, DragBar r36, String r37, String r38, String r39, String r40, boolean r41, String r42, boolean r43, Float r44) {
        return new InlineAIPanel(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InlineAIPanel) == true) goto L8;
        return false;
    L8:
        InlineAIPanel r6 = (InlineAIPanel) r5;
        if (this.isContentUseCustomView == r6.isContentUseCustomView) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contentExtra, r6.contentExtra) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.images, r6.images) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.prompts, r6.prompts) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.operates, r6.operates) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.input, r6.input) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.range, r6.range) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tips, r6.tips) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.feedback, r6.feedback) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.history, r6.history) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.dragBar, r6.dragBar) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.theme, r6.theme) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.maskType, r6.maskType) == true) goto L60;
        return false;
    L60:
        if (this.lock == r6.lock) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.style, r6.style) == true) goto L66;
        return false;
    L66:
        if (this.showOnboarding == r6.showOnboarding) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.heightRatio, r6.heightRatio) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isContentUseCustomView == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        View r3 = this.a;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.content;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        HashMap<String, Object> r10 = this.contentExtra;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Images r13 = this.images;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Prompts r16 = this.prompts;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Operates r19 = this.operates;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Input r22 = this.input;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Range r25 = this.range;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Tips r28 = this.tips;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Feedback r31 = this.feedback;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        History r34 = this.history;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        DragBar r37 = this.dragBar;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.conversationId;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.taskId;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.theme;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.maskType;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        if (this.lock == false) goto L73;
        int r52 = 1231;
    L74:
        int r53 = (r51 + r52) * 31;
        String r54 = this.style;
        if (r54 != null) goto L77;
        int r55 = 0;
    L78:
        int r56 = (r53 + r55) * 31;
        if (this.showOnboarding == true) goto L82;
        r1 = 1237;
    L82:
        int r57 = (r56 + r1) * 31;
        Float r58 = this.heightRatio;
        if (r58 == null) goto L87;
        r4 = r58.hashCode();
    L87:
        return r57 + r4;
    L77:
        r55 = r54.hashCode();
        goto L78
    L73:
        r52 = 1237;
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
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
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("InlineAIPanel(isContentUseCustomView=");
        r0.append(this.isContentUseCustomView);
        r0.append(", contentCustomView=");
        r0.append(this.a);
        r0.append(", content=");
        String r1 = this.content;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append(", prompts=");
        r0.append(this.prompts);
        r0.append(", operates=");
        r0.append(this.operates);
        r0.append(", input=");
        r0.append(this.input);
        r0.append(", range=");
        r0.append(this.range);
        r0.append(", tips=");
        r0.append(this.tips);
        r0.append(", feedback=");
        r0.append(this.feedback);
        r0.append(", history=");
        r0.append(this.history);
        r0.append(", dragBar=");
        r0.append(this.dragBar);
        r0.append(", conversationId=");
        r0.append(this.conversationId);
        r0.append(", taskId=");
        r0.append(this.taskId);
        r0.append(", theme=");
        r0.append(this.theme);
        r0.append(", maskType=");
        r0.append(this.maskType);
        r0.append(", lock=");
        r0.append(this.lock);
        r0.append(",style=");
        r0.append(this.style);
        r0.append(",showOnboarding=");
        r0.append(this.showOnboarding);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final String getContent() {
        return this.content;
    }

    public final View getContentCustomView() {
        return this.a;
    }

    public final HashMap<String, Object> getContentExtra() {
        return this.contentExtra;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final DragBar getDragBar() {
        return this.dragBar;
    }

    public final Feedback getFeedback() {
        return this.feedback;
    }

    public final Float getHeightRatio() {
        return this.heightRatio;
    }

    public final History getHistory() {
        return this.history;
    }

    public final Images getImages() {
        return this.images;
    }

    public final Input getInput() {
        return this.input;
    }

    public final boolean getLock() {
        return this.lock;
    }

    public final String getMaskType() {
        return this.maskType;
    }

    public final Operates getOperates() {
        return this.operates;
    }

    public final Prompts getPrompts() {
        return this.prompts;
    }

    public final Range getRange() {
        return this.range;
    }

    public final boolean getShowOnboarding() {
        return this.showOnboarding;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTheme() {
        return this.theme;
    }

    public final Tips getTips() {
        return this.tips;
    }

    public final boolean isContentUseCustomView() {
        return this.isContentUseCustomView;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setContentCustomView(View r1) {
        this.a = r1;
    }

    public final void setContentExtra(HashMap<String, Object> r1) {
        this.contentExtra = r1;
    }

    public final void setContentUseCustomView(boolean r1) {
        this.isContentUseCustomView = r1;
    }

    public final void setConversationId(String r1) {
        this.conversationId = r1;
    }

    public final void setDragBar(DragBar r1) {
        this.dragBar = r1;
    }

    public final void setFeedback(Feedback r1) {
        this.feedback = r1;
    }

    public final void setHeightRatio(Float r1) {
        this.heightRatio = r1;
    }

    public final void setHistory(History r1) {
        this.history = r1;
    }

    public final void setImages(Images r1) {
        this.images = r1;
    }

    public final void setInput(Input r1) {
        this.input = r1;
    }

    public final void setLock(boolean r1) {
        this.lock = r1;
    }

    public final void setMaskType(String r1) {
        this.maskType = r1;
    }

    public final void setOperates(Operates r1) {
        this.operates = r1;
    }

    public final void setPrompts(Prompts r1) {
        this.prompts = r1;
    }

    public final void setRange(Range r1) {
        this.range = r1;
    }

    public final void setShowOnboarding(boolean r1) {
        this.showOnboarding = r1;
    }

    public final void setStyle(String r1) {
        this.style = r1;
    }

    public final void setTaskId(String r1) {
        this.taskId = r1;
    }

    public final void setTheme(String r1) {
        this.theme = r1;
    }

    public final void setTips(Tips r1) {
        this.tips = r1;
    }

    public InlineAIPanel(boolean r3, View r4, String r5, HashMap<String, Object> r6, Images r7, Prompts r8, Operates r9, Input r10, Range r11, Tips r12, Feedback r13, History r14, DragBar r15, String r16, String r17, String r18, String r19, boolean r20, String r21, boolean r22, Float r23) {
        this.isContentUseCustomView = r3;
        this.a = r4;
        this.content = r5;
        this.contentExtra = r6;
        this.images = r7;
        this.prompts = r8;
        this.operates = r9;
        this.input = r10;
        this.range = r11;
        this.tips = r12;
        this.feedback = r13;
        this.history = r14;
        this.dragBar = r15;
        this.conversationId = r16;
        this.taskId = r17;
        this.theme = r18;
        this.maskType = r19;
        this.lock = r20;
        this.style = r21;
        this.showOnboarding = r22;
        this.heightRatio = r23;
    }

    public /* synthetic */ InlineAIPanel(boolean r23, View r24, String r25, HashMap r26, Images r27, Prompts r28, Operates r29, Input r30, Range r31, Tips r32, Feedback r33, History r34, DragBar r35, String r36, String r37, String r38, String r39, boolean r40, String r41, boolean r42, Float r43, int r44, DefaultConstructorMarker r45) {
        if ((r44 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r44 & 2) == 0) goto L9;
        View r2 = null;
    L11:
        if ((r44 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r44 & 8) == 0) goto L17;
        HashMap r5 = null;
    L19:
        if ((r44 & 16) == 0) goto L21;
        Images r6 = null;
    L23:
        if ((r44 & 32) == 0) goto L25;
        Prompts r7 = null;
    L27:
        if ((r44 & 64) == 0) goto L29;
        Operates r8 = null;
    L31:
        if ((r44 & 128) == 0) goto L33;
        Input r9 = null;
    L35:
        if ((r44 & 256) == 0) goto L37;
        Range r10 = null;
    L39:
        if ((r44 & 512) == 0) goto L41;
        Tips r11 = null;
    L43:
        if ((r44 & 1024) == 0) goto L45;
        Feedback r12 = null;
    L47:
        if ((r44 & 2048) == 0) goto L49;
        History r13 = null;
    L51:
        if ((r44 & 4096) == 0) goto L53;
        DragBar r14 = null;
    L55:
        if ((r44 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r44 & 16384) == 0) goto L61;
        String r3 = null;
    L63:
        if ((r44 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r44 & 65536) == 0) goto L69;
        String r17 = null;
    L70:
        boolean r19 = true;
        if ((r44 & 131072) == 0) goto L73;
        boolean r18 = true;
    L75:
        if ((r44 & 262144) == 0) goto L77;
        String r20 = null;
    L79:
        if ((r44 & 524288) != 0) goto L83;
        r19 = r42;
    L83:
        if ((r44 & 1048576) == 0) goto L85;
        Float r0 = null;
    L86:
        this(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r3, r16, r17, r18, r20, r19, r0);
        return;
    L85:
        r0 = r43;
        goto L86
    L77:
        r20 = r41;
        goto L79
    L73:
        r18 = r40;
        goto L75
    L69:
        r17 = r39;
        goto L70
    L65:
        r16 = r38;
        goto L67
    L61:
        r3 = r37;
        goto L63
    L57:
        r15 = r36;
        goto L59
    L53:
        r14 = r35;
        goto L55
    L49:
        r13 = r34;
        goto L51
    L45:
        r12 = r33;
        goto L47
    L41:
        r11 = r32;
        goto L43
    L37:
        r10 = r31;
        goto L39
    L33:
        r9 = r30;
        goto L35
    L29:
        r8 = r29;
        goto L31
    L25:
        r7 = r28;
        goto L27
    L21:
        r6 = r27;
        goto L23
    L17:
        r5 = r26;
        goto L19
    L13:
        r4 = r25;
        goto L15
    L9:
        r2 = r24;
        goto L11
    L5:
        r1 = r23;
        goto L7
    }
}
