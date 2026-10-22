package com.ss.android.lark.chat.entity.message;

import com.bytedance.lark.pb.basic.v1.MessageAnalysisContent;
import com.bytedance.lark.pb.basic.v1.MessageAnalysisItem;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001)B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0000H\u0016J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JK\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageAnalysisConfig;", "Lcom/larksuite/framework/utils/diff/Diffable;", "Ljava/io/Serializable;", "titleItem", "Lcom/ss/android/lark/chat/entity/message/MessageAnalysisTitleItem;", "description", BuildConfig.FLAVOR, "analysisItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "meetingAnalysisContent", "Lcom/ss/android/lark/chat/entity/message/MeetingAnalysisContent;", "hasConfig", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/chat/entity/message/MessageAnalysisTitleItem;Ljava/lang/String;Ljava/util/ArrayList;Lcom/ss/android/lark/chat/entity/message/MeetingAnalysisContent;Z)V", "getTitleItem", "()Lcom/ss/android/lark/chat/entity/message/MessageAnalysisTitleItem;", "getDescription", "()Ljava/lang/String;", "getAnalysisItems", "()Ljava/util/ArrayList;", "getMeetingAnalysisContent", "()Lcom/ss/android/lark/chat/entity/message/MeetingAnalysisContent;", "getHasConfig", "()Z", "isItemSame", "diffable", "isContentSame", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageAnalysisConfig implements b<MessageAnalysisConfig>, Serializable {
    public static final a Companion = null;
    private final ArrayList<MessageAnalysisTitleItem> analysisItems;
    private final String description;
    private final boolean hasConfig;
    private final MeetingAnalysisContent meetingAnalysisContent;
    private final MessageAnalysisTitleItem titleItem;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageAnalysisConfig copy$default(MessageAnalysisConfig r3, MessageAnalysisTitleItem r4, String r5, ArrayList r6, MeetingAnalysisContent r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.titleItem;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.description;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.analysisItems;
    L11:
        ArrayList r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.meetingAnalysisContent;
    L14:
        MeetingAnalysisContent r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.hasConfig;
    L17:
        MessageAnalysisTitleItem r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final MessageAnalysisTitleItem component1() {
        return this.titleItem;
    }

    public final String component2() {
        return this.description;
    }

    public final ArrayList<MessageAnalysisTitleItem> component3() {
        return this.analysisItems;
    }

    public final MeetingAnalysisContent component4() {
        return this.meetingAnalysisContent;
    }

    public final boolean component5() {
        return this.hasConfig;
    }

    public final MessageAnalysisConfig copy(MessageAnalysisTitleItem r8, String r9, ArrayList<MessageAnalysisTitleItem> r10, MeetingAnalysisContent r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "titleItem");
        Intrinsics.checkNotNullParameter(r9, "description");
        Intrinsics.checkNotNullParameter(r10, "analysisItems");
        Intrinsics.checkNotNullParameter(r11, "meetingAnalysisContent");
        return new MessageAnalysisConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageAnalysisConfig) == true) goto L8;
        return false;
    L8:
        MessageAnalysisConfig r6 = (MessageAnalysisConfig) r5;
        if (Intrinsics.areEqual(this.titleItem, r6.titleItem) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.analysisItems, r6.analysisItems) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.meetingAnalysisContent, r6.meetingAnalysisContent) == true) goto L21;
        return false;
    L21:
        if (this.hasConfig == r6.hasConfig) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.titleItem.hashCode() * 31) + this.description.hashCode()) * 31) + this.analysisItems.hashCode()) * 31) + this.meetingAnalysisContent.hashCode()) * 31;
        if (this.hasConfig == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "MessageAnalysisConfig(titleItem=" + this.titleItem + ", description=" + this.description + ", analysisItems=" + this.analysisItems + ", meetingAnalysisContent=" + this.meetingAnalysisContent + ", hasConfig=" + this.hasConfig + ')';
    }

    public final ArrayList<MessageAnalysisTitleItem> getAnalysisItems() {
        return this.analysisItems;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getHasConfig() {
        return this.hasConfig;
    }

    public final MeetingAnalysisContent getMeetingAnalysisContent() {
        return this.meetingAnalysisContent;
    }

    public final MessageAnalysisTitleItem getTitleItem() {
        return this.titleItem;
    }

    @JvmStatic
    public static final MessageAnalysisConfig parseFromPbMessage(com.bytedance.lark.pb.basic.v1.MessageAnalysisConfig r11) {
        Companion.getClass();
        RichText r0 = null;
        if (r11 == null) goto L59;
        MessageAnalysisItem r1 = r11.title_item;
        if (r1 == null) goto L7;
        String r3 = r1.name;
    L8:
        String r4 = BuildConfig.FLAVOR;
        if (r3 != null) goto L11;
        r3 = BuildConfig.FLAVOR;
    L11:
        if (r1 == null) goto L13;
        String r5 = r1.icon_url;
    L14:
        if (r5 != null) goto L16;
        r5 = BuildConfig.FLAVOR;
    L16:
        if (r1 == null) goto L18;
        String r2 = r1.jump_url;
    L19:
        if (r2 != null) goto L21;
        r2 = BuildConfig.FLAVOR;
    L21:
        MessageAnalysisTitleItem r6 = new MessageAnalysisTitleItem(r3, r5, r2);
        String r7 = r11.description;
        ArrayList r8 = new ArrayList();
        List r9 = r11.analysis_items;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r12 = r9.iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        MessageAnalysisItem r13 = (MessageAnalysisItem) r12.next();
        r10.add(new MessageAnalysisTitleItem(r13.name, r13.icon_url, r13.jump_url));
        goto L23
    L25:
        r8.addAll(r10);
        Unit r14 = Unit.INSTANCE;
        MessageAnalysisContent r15 = r11.content;
        if (r15 == null) goto L28;
        String r16 = r15.content;
    L29:
        if (r16 != null) goto L31;
        r16 = BuildConfig.FLAVOR;
    L31:
        if (r15 == null) goto L33;
        String r17 = r15.jump_url;
    L34:
        if (r17 == null) goto L37;
        r4 = r17;
    L37:
        LinkedList r18 = new LinkedList();
        MessageAnalysisContent r19 = r11.content;
        if (r19 == null) goto L45;
        List r20 = r19.button;
        if (r20 == null) goto L45;
        Iterator r21 = r20.iterator();
    L43:
        if (r21.hasNext() == false) goto L45;
        com.bytedance.lark.pb.basic.v1.Button r22 = (com.bytedance.lark.pb.basic.v1.Button) r21.next();
        r18.add(new Button(r22.text, r22.button_jump_url));
    L45:
        Unit r23 = Unit.INSTANCE;
        MessageAnalysisContent r24 = r11.content;
        if (r24 == null) goto L48;
        com.bytedance.lark.pb.basic.v1.RichText r25 = r24.rich_text;
    L49:
        if (r25 == null) goto L56;
        if (r24 == null) goto L53;
        com.bytedance.lark.pb.basic.v1.RichText r26 = r24.rich_text;
    L54:
        r0 = g0.e(r26, null);
        goto L56
    L53:
        r26 = null;
    L56:
        return new MessageAnalysisConfig(r6, r7, r8, new MeetingAnalysisContent(r16, r4, r18, r0), r11.has_config.booleanValue());
    L48:
        r25 = null;
        goto L49
    L33:
        r17 = null;
        goto L34
    L28:
        r16 = null;
        goto L29
    L18:
        r2 = null;
        goto L19
    L13:
        r5 = null;
        goto L14
    L7:
        r3 = null;
        goto L8
    L59:
        return null;
    }

    public boolean isContentSame(MessageAnalysisConfig r4) {
        MessageAnalysisTitleItem r0 = this.titleItem;
        if (r4 == null) goto L5;
        MessageAnalysisTitleItem r1 = r4.titleItem;
    L7:
        if (Intrinsics.areEqual(r0, r1) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.description, r4.description) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.analysisItems, r4.analysisItems) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.meetingAnalysisContent, r4.meetingAnalysisContent) == true) goto L18;
        return false;
    L18:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((MessageAnalysisConfig) r1);
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((MessageAnalysisConfig) r1);
    }

    public boolean isItemSame(MessageAnalysisConfig r1) {
        return Intrinsics.areEqual(this, r1);
    }

    public MessageAnalysisConfig(MessageAnalysisTitleItem r2, String r3, ArrayList<MessageAnalysisTitleItem> r4, MeetingAnalysisContent r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "titleItem");
        Intrinsics.checkNotNullParameter(r3, "description");
        Intrinsics.checkNotNullParameter(r4, "analysisItems");
        Intrinsics.checkNotNullParameter(r5, "meetingAnalysisContent");
        this.titleItem = r2;
        this.description = r3;
        this.analysisItems = r4;
        this.meetingAnalysisContent = r5;
        this.hasConfig = r6;
    }
}
