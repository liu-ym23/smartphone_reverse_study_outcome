package com.ss.android.lark.picker.base.view.avataritem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.lark.pb.search.v2.ExtraInfoBlock;
import com.bytedance.lark.pb.search.v2.ExtraInfoBlockIcon;
import com.bytedance.lark.pb.search.v2.ExtraInfoBlockSegment;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.utils.SearchCommonFgUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.ExtraInfoSummary;
import com.ss.android.lark.search.dto.info.TagContent;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.t;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kac.a;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v3c.l;
import v3c.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0003,-.B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0014J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\nJ0\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\b\b\u0002\u0010'\u001a\u00020#H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010'\u001a\u00020#H\u0002J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/ExtraInfoView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "priority", "leftExtraTv", "Landroid/widget/TextView;", "midSeparatorTv", "rightExtraTv", "hasMeasure", "", "fgUtils", "Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "getExpectMeasuredWidth", "view", "Landroid/view/View;", "setExtraInfoSummary", "extraInfoSummary", "Lcom/ss/android/lark/search/dto/info/ExtraInfoSummary;", "type", "setTextExtraInfo", "textView", "contentWithoutTag", "", "tagContentList", "", "Lcom/ss/android/lark/search/dto/info/TagContent;", "iconKey", "getUdIconDrawable", "Landroid/graphics/drawable/Drawable;", "parsePriority", "resetView", "Priority", "Companion", "ExtraInfo", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ExtraInfoView extends LinearLayout {
    public static final Companion Companion = null;
    private static final float DP_4 = 4.0f;
    private static final float SCALE = 0.4f;
    private static final float TEXT_SIZE_12 = 12.0f;
    private static final float TEXT_SIZE_14 = 14.0f;
    private SearchCommonFgUtils fgUtils;
    private boolean hasMeasure;
    private TextView leftExtraTv;
    private TextView midSeparatorTv;
    private int priority;
    private TextView rightExtraTv;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/ExtraInfoView$Companion;", "", "<init>", "()V", "TEXT_SIZE_14", "", "TEXT_SIZE_12", "DP_4", "SCALE", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/ExtraInfoView$ExtraInfo;", "Ljava/io/Serializable;", "contentWithoutTag", "", "tagContentList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/TagContent;", "Lkotlin/collections/ArrayList;", "iconKey", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getContentWithoutTag", "()Ljava/lang/String;", "getTagContentList", "()Ljava/util/ArrayList;", "getIconKey", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class ExtraInfo implements Serializable {
        private final String contentWithoutTag;
        private final String iconKey;
        private final ArrayList<TagContent> tagContentList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ExtraInfo copy$default(ExtraInfo r0, String r1, ArrayList r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.contentWithoutTag;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.tagContentList;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.iconKey;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.contentWithoutTag;
        }

        public final ArrayList<TagContent> component2() {
            return this.tagContentList;
        }

        public final String component3() {
            return this.iconKey;
        }

        public final ExtraInfo copy(String r2, ArrayList<TagContent> r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "contentWithoutTag");
            Intrinsics.checkNotNullParameter(r3, "tagContentList");
            Intrinsics.checkNotNullParameter(r4, "iconKey");
            return new ExtraInfo(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ExtraInfo) == true) goto L8;
            return false;
        L8:
            ExtraInfo r6 = (ExtraInfo) r5;
            if (Intrinsics.areEqual(this.contentWithoutTag, r6.contentWithoutTag) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.tagContentList, r6.tagContentList) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.iconKey, r6.iconKey) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.contentWithoutTag.hashCode() * 31) + this.tagContentList.hashCode()) * 31) + this.iconKey.hashCode();
        }

        public String toString() {
            return "ExtraInfo(contentWithoutTag=" + this.contentWithoutTag + ", tagContentList=" + this.tagContentList + ", iconKey=" + this.iconKey + ')';
        }

        public final String getContentWithoutTag() {
            return this.contentWithoutTag;
        }

        public final String getIconKey() {
            return this.iconKey;
        }

        public final ArrayList<TagContent> getTagContentList() {
            return this.tagContentList;
        }

        public ExtraInfo(String r2, ArrayList<TagContent> r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "contentWithoutTag");
            Intrinsics.checkNotNullParameter(r3, "tagContentList");
            Intrinsics.checkNotNullParameter(r4, "iconKey");
            this.contentWithoutTag = r2;
            this.tagContentList = r3;
            this.iconKey = r4;
        }

        public /* synthetic */ ExtraInfo(String r1, ArrayList r2, String r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = "";
        L5:
            this(r1, r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/ExtraInfoView$Priority;", "", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Priority {
        public static final Companion Companion = null;
        public static final int LEFT_PRIORITY = 1;
        public static final int RIGHT_PRIORITY = 2;
        public static final int UNKNOWN = 0;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/ExtraInfoView$Priority$Companion;", "", "<init>", "()V", "UNKNOWN", "", "LEFT_PRIORITY", "RIGHT_PRIORITY", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int LEFT_PRIORITY = 1;
            public static final int RIGHT_PRIORITY = 2;
            public static final int UNKNOWN = 0;

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final int parsePriority(int r3) {
        if (r3 != 2) goto L5;
        return 1;
    L5:
        if (r3 != 6) goto L7;
        return 2;
    L7:
        if (r3 == 15) goto L12;
        return 0;
    L12:
        return 2;
    }

    public ExtraInfoView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final int getExpectMeasuredWidth(View r3) {
        r3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r3.getMeasuredWidth();
    }

    private final Drawable getUdIconDrawable(String r5) {
        String r6 = r5.toLowerCase();
        switch(r6.hashCode()) {
            case -267437798: goto L18;
            case 3108362: goto L14;
            case 3649456: goto L10;
            case 466743410: goto L6;
            default: goto L21;
        };
    L21:
        int r7 = -1;
    L22:
        if (r7 > 0) goto L26;
        return null;
    L26:
        return UDIconUtils.getIconDrawable(getContext(), a.b(r7), getResources().getColor(2131106620), new UDDimension.Dp(TEXT_SIZE_14));
    L6:
        if (r6.equals("visible") == false) goto L21;
        r7 = 2131256160;
        goto L22
    L10:
        if (r6.equals("wiki") == false) goto L21;
        r7 = 2131256245;
        goto L22
    L14:
        if (r6.equals("edit") == false) goto L21;
        r7 = 2131254285;
        goto L22
    L18:
        if (r6.equals("myfolder") == false) goto L21;
        r7 = 2131255196;
        goto L22
    }

    private final void resetView(int r6) {
        this.hasMeasure = false;
        this.leftExtraTv.setText("");
        this.leftExtraTv.setMaxWidth(Integer.MAX_VALUE);
        this.leftExtraTv.setCompoundDrawablePadding(0);
        this.leftExtraTv.setCompoundDrawables(null, null, null, null);
        this.midSeparatorTv.setText("");
        this.rightExtraTv.setText("");
        this.rightExtraTv.setMaxWidth(Integer.MAX_VALUE);
        this.rightExtraTv.setCompoundDrawablePadding(0);
        this.rightExtraTv.setCompoundDrawables(null, null, null, null);
        this.priority = parsePriority(r6);
    }

    public ExtraInfoView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, -1);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r9, int r10) {
        if (this.hasMeasure == true) goto L17;
        this.hasMeasure = true;
        int r1 = View.MeasureSpec.getSize(r9);
        int r2 = getExpectMeasuredWidth(this.leftExtraTv);
        int r3 = getExpectMeasuredWidth(this.midSeparatorTv);
        int r4 = getExpectMeasuredWidth(this.rightExtraTv);
        int r5 = r1 - r3;
        float r6 = r5;
        float r7 = SCALE * r6;
        if (((r3 + r2) + r4) <= r1) goto L17;
        int r8 = this.priority;
        if (r8 != 2) goto L12;
        int r11 = r5 - r4;
        if (r11 < r7) goto L11;
        this.leftExtraTv.setMaxWidth(r11);
        this.rightExtraTv.setMaxWidth(r4);
        goto L17
    L11:
        this.leftExtraTv.setMaxWidth((int) r7);
        this.rightExtraTv.setMaxWidth((int) (r6 - r7));
        goto L17
    L12:
        if (r8 != 1) goto L17;
        int r12 = r5 - r2;
        if (r12 < r7) goto L16;
        this.leftExtraTv.setMaxWidth(r2);
        this.rightExtraTv.setMaxWidth(r12);
        goto L17
    L16:
        this.leftExtraTv.setMaxWidth((int) (r6 - r7));
        this.rightExtraTv.setMaxWidth((int) r7);
    L17:
        super.onMeasure(r9, r10);
    }

    public final void setExtraInfoSummary(ExtraInfoSummary r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "extraInfoSummary");
        resetView(r20);
        if (r19.getExtraInfoList().isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r0 = r19.getExtraInfoList();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L60;
        ExtraInfoBlock r3 = (ExtraInfoBlock) r2.next();
        ExtraInfoBlockIcon r4 = r3.block_icon;
        String r5 = "";
        if (r4 == null) goto L12;
        String r6 = r4.icon_key;
        if (r6 == null) goto L12;
    L13:
        List r7 = r3.block_segments;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
        int r11 = 0;
    L15:
        if (r9.hasNext() == false) goto L46;
        Object r12 = r9.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        ExtraInfoBlockSegment r14 = (ExtraInfoBlockSegment) r12;
        if (r14 == null) goto L35;
        String r15 = r14.text_highlighted;
        if (r15 == null) goto L35;
        ExtraInfoBlockSegment.SegmentTextType r16 = r14.type;
        if (r16 != ExtraInfoBlockSegment.SegmentTextType.TIMESTAMP) goto L26;
        String r17 = r5;
        Iterator r18 = r9;
        r15 = t.a(getContext(), new Date(CastLongProtector.parseLong(r15) * ((long) 1000)), PickerBaseModuleDependency.getDependency().getCachedLanguageSetting());
    L33:
        if (r15 != null) goto L38;
    L36:
        r15 = r17;
    L38:
        if (r11 >= (r3.block_segments.size() - 1)) goto L45;
        if (r15.length() <= 0) goto L42;
        boolean r10 = true;
    L43:
        if (r10 == false) goto L45;
        r15 = r15 + r3.segment_separator;
        goto L45
    L42:
        r10 = false;
    L45:
        r8.add(r15);
        r11 = r13;
        r5 = r17;
        r9 = r18;
        goto L15
    L26:
        r17 = r5;
        r18 = r9;
        if (r16 != ExtraInfoBlockSegment.SegmentTextType.USERPROFILE) goto L33;
        ExtraInfoBlockSegment.UserProfile r21 = r14.user_profile;
        if (r21 == null) goto L32;
        r15 = r21.user_name;
        if (r15 != null) goto L33;
    L32:
        r15 = r17;
    L35:
        r17 = r5;
        r18 = r9;
        goto L36
    L46:
        Iterator r22 = r8.iterator();
        ExtraInfo r23 = null;
        if (r22.hasNext() == true) goto L49;
        Object r24 = null;
    L53:
        String r25 = (String) r24;
        if (r25 == null) goto L58;
        String r26 = m.a(r25);
        if (r26 == null) goto L58;
        l r27 = m.b(r26, this.fgUtils.isUrlIconMoreTypesEnable());
        r23 = new ExtraInfo(r27.a, new ArrayList(r27.b), r6);
    L58:
        if (r23 == null) goto L7;
        r1.add(r23);
        goto L7
    L49:
        r24 = r22.next();
    L51:
        if (r22.hasNext() == false) goto L53;
        r24 = ((String) r24) + ((String) r22.next());
    L12:
        r6 = "";
        goto L13
    L60:
        Iterator r28 = r1.iterator();
        int r29 = 0;
    L62:
        if (r28.hasNext() == false) goto L75;
        Object r30 = r28.next();
        int r110 = r29 + 1;
        if (r29 >= 0) goto L66;
        CollectionsKt.throwIndexOverflow();
    L66:
        ExtraInfo r31 = (ExtraInfo) r30;
        if (r29 != 0) goto L69;
        setTextExtraInfo(this.leftExtraTv, r31.getContentWithoutTag(), r31.getTagContentList(), r31.getIconKey());
    L73:
        r29 = r110;
        goto L62
    L69:
        if (r29 != 1) goto L73;
        setTextExtraInfo$default(this, this.rightExtraTv, r31.getContentWithoutTag(), r31.getTagContentList(), null, 8, null);
        goto L73
    L75:
        if (this.rightExtraTv.getText().length() <= 0) goto L77;
        boolean r32 = true;
    L78:
        if (r32 == false) goto L95;
        this.midSeparatorTv.setText(r19.getExtraInfoSeparator());
        return;
    L95:
        return;
    L77:
        r32 = false;
        goto L78
    }

    public ExtraInfoView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.priority = 1;
        this.fgUtils = new SearchCommonFgUtils();
        setOrientation(0);
        EllipsizedEmojiconTextView r10 = new EllipsizedEmojiconTextView(getContext());
        r10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r10.setIncludeFontPadding(false);
        r10.setGravity(16);
        r10.setEllipsize(TextUtils.TruncateAt.END);
        r10.setMaxLines(1);
        r10.setSingleLine(true);
        r10.setTextSize(2, TEXT_SIZE_14);
        r10.setTextColor(getContext().getResources().getColor(2131106620));
        addView(r10);
        this.leftExtraTv = r10;
        EllipsizedEmojiconTextView r11 = new EllipsizedEmojiconTextView(getContext());
        r11.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r11.setIncludeFontPadding(false);
        r11.setGravity(16);
        r11.setMaxLines(1);
        r11.setSingleLine(true);
        r11.setTextSize(2, 12.0f);
        r11.setTextColor(getContext().getResources().getColor(2131106620));
        addView(r11);
        this.midSeparatorTv = r11;
        EllipsizedEmojiconTextView r12 = new EllipsizedEmojiconTextView(getContext());
        r12.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r12.setIncludeFontPadding(false);
        r12.setGravity(16);
        r12.setEllipsize(TextUtils.TruncateAt.END);
        r12.setMaxLines(1);
        r12.setSingleLine(true);
        r12.setTextSize(2, TEXT_SIZE_14);
        r12.setTextColor(getContext().getResources().getColor(2131106620));
        addView(r12);
        this.rightExtraTv = r12;
    }

    private final void setTextExtraInfo(TextView r6, String r7, List<TagContent> r8, String r9) {
        Drawable r10 = getUdIconDrawable(r9);
        SpannableStringBuilder r0 = new SpannableStringBuilder(r7);
        if (CollectionUtils.isEmpty(r8) == false) goto L5;
        r6.setText(r0);
        r6.setCompoundDrawablePadding(UIHelper.dp2px(DP_4));
        r6.setCompoundDrawables(r10, null, null, null);
        return;
    L5:
        PickerBaseModuleDependency.getDependency().addSearchHighLightedTag(r0, r6, r8, getContext().getResources().getColor(2131103404));
        r6.setText(r0);
        r6.setCompoundDrawablePadding(UIHelper.dp2px(DP_4));
        r6.setCompoundDrawables(r10, null, null, null);
    }

    public static /* synthetic */ void setExtraInfoSummary$default(ExtraInfoView r0, ExtraInfoSummary r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.setExtraInfoSummary(r1, r2);
    }

    public static /* synthetic */ void setTextExtraInfo$default(ExtraInfoView r0, TextView r1, String r2, List r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = "";
    L5:
        r0.setTextExtraInfo(r1, r2, r3, r4);
    }
}
