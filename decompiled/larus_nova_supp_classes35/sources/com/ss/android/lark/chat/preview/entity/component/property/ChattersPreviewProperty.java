package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.chat.preview.entity.component.Theme;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ChatterInfos;
import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001:BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0000H\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u00100\u001a\u00020\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003JZ\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0005HÖ\u0001J\t\u00109\u001a\u00020\rHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006;"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "theme", "Lcom/ss/android/lark/chat/preview/entity/component/Theme;", "chatterCounts", BuildConfig.FLAVOR, "chatterInfoList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo;", "maxShowCount", "chattersMode", "Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;", "title", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/chat/preview/entity/component/Theme;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;Ljava/lang/String;)V", "getTheme", "()Lcom/ss/android/lark/chat/preview/entity/component/Theme;", "setTheme", "(Lcom/ss/android/lark/chat/preview/entity/component/Theme;)V", "getChatterCounts", "()Ljava/lang/Integer;", "setChatterCounts", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getChatterInfoList", "()Ljava/util/List;", "setChatterInfoList", "(Ljava/util/List;)V", "getMaxShowCount", "setMaxShowCount", "getChattersMode", "()Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;", "setChattersMode", "(Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/ss/android/lark/chat/preview/entity/component/Theme;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;Ljava/lang/String;)Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "ChattersMode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChattersPreviewProperty extends BaseProperty {
    private Integer chatterCounts;
    private List<ChatterPreviewChatterInfo> chatterInfoList;
    private ChattersMode chattersMode;
    private Integer maxShowCount;
    private Theme theme;
    private String title;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ChattersPreviewProperty$ChattersMode;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATIC", "DYNAMIC", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChattersMode extends Enum<ChattersMode> {
        public static final a Companion = null;
        public static final ChattersMode DYNAMIC = null;
        public static final ChattersMode STATIC = null;
        public static final /* synthetic */ ChattersMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ChattersMode> getEntries() {
            return b;
        }

        static {
            ChattersMode r0 = new ChattersMode("STATIC", 0, 0);
            STATIC = r0;
            ChattersMode r1 = new ChattersMode("DYNAMIC", 1, 1);
            DYNAMIC = r1;
            ChattersMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static ChattersMode[] values() {
            return (ChattersMode[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static ChattersMode valueOf(String r1) {
            return (ChattersMode) r27.a.a(ChattersMode.class, r1);
        }

        public ChattersMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public ChattersPreviewProperty() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChattersPreviewProperty copy$default(ChattersPreviewProperty r4, Theme r5, Integer r6, List r7, Integer r8, ChattersMode r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.theme;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.chatterCounts;
    L8:
        Integer r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.chatterInfoList;
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.maxShowCount;
    L14:
        Integer r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.chattersMode;
    L17:
        ChattersMode r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.title;
    L20:
        Theme r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Theme component1() {
        return this.theme;
    }

    public final Integer component2() {
        return this.chatterCounts;
    }

    public final List<ChatterPreviewChatterInfo> component3() {
        return this.chatterInfoList;
    }

    public final Integer component4() {
        return this.maxShowCount;
    }

    public final ChattersMode component5() {
        return this.chattersMode;
    }

    public final String component6() {
        return this.title;
    }

    public final ChattersPreviewProperty copy(Theme r9, Integer r10, List<ChatterPreviewChatterInfo> r11, Integer r12, ChattersMode r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "chattersMode");
        return new ChattersPreviewProperty(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChattersPreviewProperty) == true) goto L8;
        return false;
    L8:
        ChattersPreviewProperty r6 = (ChattersPreviewProperty) r5;
        if (this.theme == r6.theme) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterCounts, r6.chatterCounts) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.chatterInfoList, r6.chatterInfoList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxShowCount, r6.maxShowCount) == true) goto L21;
        return false;
    L21:
        if (this.chattersMode == r6.chattersMode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L26;
        return false;
    L26:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        Theme r0 = this.theme;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.chatterCounts;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<ChatterPreviewChatterInfo> r7 = this.chatterInfoList;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.maxShowCount;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.chattersMode.hashCode()) * 31;
        String r13 = this.title;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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

    public String toString() {
        return "ChattersPreviewProperty(theme=" + this.theme + ", chatterCounts=" + this.chatterCounts + ", chatterInfoList=" + this.chatterInfoList + ", maxShowCount=" + this.maxShowCount + ", chattersMode=" + this.chattersMode + ", title=" + this.title + ')';
    }

    public ChattersPreviewProperty clone() {
        ChattersPreviewProperty r9 = new ChattersPreviewProperty(this.theme, this.chatterCounts, this.chatterInfoList, this.maxShowCount, null, null, 48, null);
        r9.setMarginLeft(getMarginLeft());
        r9.setMarginRight(getMarginRight());
        r9.setMarginTop(getMarginTop());
        r9.setMarginBottom(getMarginBottom());
        return r9;
    }

    public final Integer getChatterCounts() {
        return this.chatterCounts;
    }

    public final List<ChatterPreviewChatterInfo> getChatterInfoList() {
        return this.chatterInfoList;
    }

    public final ChattersMode getChattersMode() {
        return this.chattersMode;
    }

    public final Integer getMaxShowCount() {
        return this.maxShowCount;
    }

    public final Theme getTheme() {
        return this.theme;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Props m660clone() {
        return clone();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r6 = r5.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L57;
        Map.Entry<Integer, PreviewData> r0 = r6.next();
        int r1 = r0.getKey().intValue();
        if (r1 == ComponentAttribute.theme.getValue()) goto L9;
        Integer r3 = null;
        String r4 = null;
        Integer r7 = null;
        ArrayList<ChatterPreviewChatterInfo> r8 = null;
        r8 = null;
        if (r1 == ComponentAttribute.chatters_count.getValue()) goto L18;
        if (r1 == ComponentAttribute.chatters_infos.getValue()) goto L24;
        if (r1 == ComponentAttribute.max_show_count.getValue()) goto L32;
        if (r1 == ComponentAttribute.chatters_mode.getValue()) goto L38;
        if (r1 != ComponentAttribute.title.getValue()) goto L6;
        PreviewData r2 = r0.getValue();
        if (r2 == null) goto L56;
        r4 = r2.getString();
    L56:
        this.title = r4;
        goto L6
    L38:
        ChattersMode.a r9 = ChattersMode.Companion;
        PreviewData r10 = r0.getValue();
        if (r10 == null) goto L43;
        Integer r11 = r10.getInt();
        if (r11 == null) goto L43;
        int r12 = r11.intValue();
    L44:
        r9.getClass();
        if (r12 == 0) goto L49;
        if (r12 == 1) goto L48;
        ChattersMode r13 = ChattersMode.DYNAMIC;
    L50:
        this.chattersMode = r13;
        goto L6
    L48:
        r13 = ChattersMode.DYNAMIC;
        goto L50
    L49:
        r13 = ChattersMode.STATIC;
    L43:
        r12 = 1;
        goto L44
    L32:
        PreviewData r14 = r0.getValue();
        if (r14 == null) goto L35;
        r7 = r14.getInt();
    L35:
        this.maxShowCount = r7;
        goto L6
    L24:
        PreviewData r15 = r0.getValue();
        if (r15 == null) goto L29;
        ChatterInfos r16 = r15.getChatterInfos();
        if (r16 == null) goto L29;
        r8 = r16.getChatterInfos();
    L29:
        this.chatterInfoList = r8;
        goto L6
    L18:
        PreviewData r17 = r0.getValue();
        if (r17 == null) goto L21;
        r3 = r17.getInt();
    L21:
        this.chatterCounts = r3;
        goto L6
    L9:
        Theme.a r18 = Theme.Companion;
        PreviewData r19 = r0.getValue();
        if (r19 == null) goto L14;
        Integer r20 = r19.getInt();
        if (r20 == null) goto L14;
        int r21 = r20.intValue();
    L15:
        r18.getClass();
        this.theme = Theme.a.a(r21);
    L14:
        r21 = 0;
        goto L15
    }

    public final void setChatterCounts(Integer r1) {
        this.chatterCounts = r1;
    }

    public final void setChatterInfoList(List<ChatterPreviewChatterInfo> r1) {
        this.chatterInfoList = r1;
    }

    public final void setChattersMode(ChattersMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chattersMode = r2;
    }

    public final void setMaxShowCount(Integer r1) {
        this.maxShowCount = r1;
    }

    public final void setTheme(Theme r1) {
        this.theme = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public ChattersPreviewProperty(Theme r2, Integer r3, List<ChatterPreviewChatterInfo> r4, Integer r5, ChattersMode r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "chattersMode");
        super(Type.CHATTERS_PREVIEW);
        this.theme = r2;
        this.chatterCounts = r3;
        this.chatterInfoList = r4;
        this.maxShowCount = r5;
        this.chattersMode = r6;
        this.title = r7;
    }

    public /* synthetic */ ChattersPreviewProperty(Theme r5, Integer r6, List r7, Integer r8, ChattersMode r9, String r10, int r11, DefaultConstructorMarker r12) {
        List r0 = null;
        if ((r11 & 1) == 0) goto L5;
        Theme r13 = null;
    L7:
        if ((r11 & 2) == 0) goto L9;
        r6 = 0;
    L9:
        Integer r2 = r6;
        if ((r11 & 4) != 0) goto L14;
        r0 = r7;
    L14:
        if ((r11 & 8) == 0) goto L16;
        r8 = 0;
    L16:
        Integer r1 = r8;
        if ((r11 & 16) == 0) goto L19;
        r9 = ChattersMode.DYNAMIC;
    L19:
        ChattersMode r3 = r9;
        if ((r11 & 32) == 0) goto L22;
        r10 = BuildConfig.FLAVOR;
    L22:
        this(r13, r2, r0, r1, r3, r10);
        return;
    L5:
        r13 = r5;
        goto L7
    }
}
