package com.obric.memorydata.recommend.tile;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.ColorToken;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.utils.ResourceUtils;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/recommend/tile/LiveCardUtil;", "", "<init>", "()V", "COLLAPSE_TEMPLATE_ID", "", "HOST_TEXT_COLOR", "FALLBACK_TEXT_COLOR", "showLiveCard", "", "buildCollapseWidget", "Lcom/obric/livecard/api/entity/IslandWidget;", "startIcon", "Lcom/obric/livecard/api/entity/Icon;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "hostColor", "Lcom/obric/memorydata/recommend/tile/LiveCardUtil$HostColor;", "buildCollapseWidget$recommend_obricRelease", "resolveHostColor", "context", "Landroid/content/Context;", "CompatibleText", "CompatibleCommonCollapseTemplate", "HostColor", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveCardUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LiveCardUtil f12634a = null;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/recommend/tile/LiveCardUtil$CompatibleCommonCollapseTemplate;", "", "startIcon", "Lcom/obric/livecard/api/entity/Icon;", "startText", "Lcom/obric/memorydata/recommend/tile/LiveCardUtil$CompatibleText;", "endIcon", "endText", "<init>", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/memorydata/recommend/tile/LiveCardUtil$CompatibleText;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/memorydata/recommend/tile/LiveCardUtil$CompatibleText;)V", "getStartIcon", "()Lcom/obric/livecard/api/entity/Icon;", "getStartText", "()Lcom/obric/memorydata/recommend/tile/LiveCardUtil$CompatibleText;", "getEndIcon", "getEndText", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CompatibleCommonCollapseTemplate {
        private final Icon endIcon;
        private final CompatibleText endText;
        private final Icon startIcon;
        private final CompatibleText startText;

        public CompatibleCommonCollapseTemplate() {
            this(null, null, null, null, 15, null);
        }

        public CompatibleCommonCollapseTemplate(Icon r1, CompatibleText r2, Icon r3, CompatibleText r4) {
            this.startIcon = r1;
            this.startText = r2;
            this.endIcon = r3;
            this.endText = r4;
        }

        public /* synthetic */ CompatibleCommonCollapseTemplate(Icon r2, CompatibleText r3, Icon r4, CompatibleText r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }

        public static /* synthetic */ CompatibleCommonCollapseTemplate copy$default(CompatibleCommonCollapseTemplate r0, Icon r1, CompatibleText r2, Icon r3, CompatibleText r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.startIcon;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.startText;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.endIcon;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.endText;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final Icon component1() {
            return this.startIcon;
        }

        public final CompatibleText component2() {
            return this.startText;
        }

        public final Icon component3() {
            return this.endIcon;
        }

        public final CompatibleText component4() {
            return this.endText;
        }

        public final CompatibleCommonCollapseTemplate copy(Icon r1, CompatibleText r2, Icon r3, CompatibleText r4) {
            return new CompatibleCommonCollapseTemplate(r1, r2, r3, r4);
        }

        public final IslandWidget create() {
            return new IslandWidget("com.obric.island_applet:common_collapse_template", this, null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, CompatibleCommonCollapseTemplate.class) == true) goto L8;
            return false;
        L8:
            CompatibleCommonCollapseTemplate r6 = (CompatibleCommonCollapseTemplate) ZeusTransformUtils.preCheckCast(r5, CompatibleCommonCollapseTemplate.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.startIcon, r6.startIcon) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.startText, r6.startText) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.endIcon, r6.endIcon) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.endText, r6.endText) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final Icon getEndIcon() {
            return this.endIcon;
        }

        public final CompatibleText getEndText() {
            return this.endText;
        }

        public final Icon getStartIcon() {
            return this.startIcon;
        }

        public final CompatibleText getStartText() {
            return this.startText;
        }

        public int hashCode() {
            Icon r0 = this.startIcon;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            CompatibleText r4 = this.startText;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Icon r7 = this.endIcon;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            CompatibleText r10 = this.endText;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
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
            return "CompatibleCommonCollapseTemplate(startIcon=" + this.startIcon + ", startText=" + this.startText + ", endIcon=" + this.endIcon + ", endText=" + this.endText + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/obric/memorydata/recommend/tile/LiveCardUtil$CompatibleText;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "textSize", "", "textColor", "textLightColor", "fontWeight", "lineHeight", TypedValues.Custom.S_COLOR, "Lcom/obric/livecard/api/entity/ColorToken;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/obric/livecard/api/entity/ColorToken;)V", "getText", "()Ljava/lang/String;", "getTextSize", "()I", "getTextColor", "getTextLightColor", "getFontWeight", "getLineHeight", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CompatibleText {
        private final ColorToken color;
        private final String fontWeight;
        private final int lineHeight;
        private final String text;
        private final String textColor;
        private final String textLightColor;
        private final int textSize;

        public CompatibleText(String r2, int r3, String r4, String r5, String r6, int r7, ColorToken r8) {
            Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r4, "textColor");
            Intrinsics.checkNotNullParameter(r5, "textLightColor");
            Intrinsics.checkNotNullParameter(r6, "fontWeight");
            this.text = r2;
            this.textSize = r3;
            this.textColor = r4;
            this.textLightColor = r5;
            this.fontWeight = r6;
            this.lineHeight = r7;
            this.color = r8;
        }

        public /* synthetic */ CompatibleText(String r10, int r11, String r12, String r13, String r14, int r15, ColorToken r16, int r17, DefaultConstructorMarker r18) {
            if ((r17 & 64) == 0) goto L5;
            ColorToken r8 = null;
        L6:
            this(r10, r11, r12, r13, r14, r15, r8);
            return;
        L5:
            r8 = r16;
            goto L6
        }

        public static /* synthetic */ CompatibleText copy$default(CompatibleText r5, String r6, int r7, String r8, String r9, String r10, int r11, ColorToken r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.text;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.textSize;
        L8:
            int r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.textColor;
        L11:
            String r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.textLightColor;
        L14:
            String r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.fontWeight;
        L17:
            String r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.lineHeight;
        L20:
            int r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.color;
        L23:
            String r16 = r6;
            return r5.copy(r16, r15, r0, r1, r2, r3, r12);
        }

        public final String component1() {
            return this.text;
        }

        public final int component2() {
            return this.textSize;
        }

        public final String component3() {
            return this.textColor;
        }

        public final String component4() {
            return this.textLightColor;
        }

        public final String component5() {
            return this.fontWeight;
        }

        public final int component6() {
            return this.lineHeight;
        }

        public final ColorToken component7() {
            return this.color;
        }

        public final CompatibleText copy(String r9, int r10, String r11, String r12, String r13, int r14, ColorToken r15) {
            Intrinsics.checkNotNullParameter(r9, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r11, "textColor");
            Intrinsics.checkNotNullParameter(r12, "textLightColor");
            Intrinsics.checkNotNullParameter(r13, "fontWeight");
            return new CompatibleText(r9, r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, CompatibleText.class) == true) goto L8;
            return false;
        L8:
            CompatibleText r6 = (CompatibleText) ZeusTransformUtils.preCheckCast(r5, CompatibleText.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
            return false;
        L12:
            if (this.textSize == r6.textSize) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.textLightColor, r6.textLightColor) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.fontWeight, r6.fontWeight) == true) goto L24;
            return false;
        L24:
            if (this.lineHeight == r6.lineHeight) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.color, r6.color) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final ColorToken getColor() {
            return this.color;
        }

        public final String getFontWeight() {
            return this.fontWeight;
        }

        public final int getLineHeight() {
            return this.lineHeight;
        }

        public final String getText() {
            return this.text;
        }

        public final String getTextColor() {
            return this.textColor;
        }

        public final String getTextLightColor() {
            return this.textLightColor;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        public int hashCode() {
            int r0 = ((((((((((this.text.hashCode() * 31) + Integer.hashCode(this.textSize)) * 31) + this.textColor.hashCode()) * 31) + this.textLightColor.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + Integer.hashCode(this.lineHeight)) * 31;
            ColorToken r2 = this.color;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "CompatibleText(text=" + this.text + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", textLightColor=" + this.textLightColor + ", fontWeight=" + this.fontWeight + ", lineHeight=" + this.lineHeight + ", color=" + this.color + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/recommend/tile/LiveCardUtil$HostColor;", "", "resourceId", "", TypedValues.Custom.S_COLOR, "Lcom/obric/livecard/api/entity/ColorToken;", "<init>", "(Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)V", "getResourceId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)Lcom/obric/memorydata/recommend/tile/LiveCardUtil$HostColor;", "equals", "", "other", "hashCode", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f12635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ColorToken f12636b;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public a(Integer r1, ColorToken r2) {
            this.f12635a = r1;
            this.f12636b = r2;
        }

        public /* synthetic */ a(Integer r2, ColorToken r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }

        public final ColorToken a() {
            return this.f12636b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12635a, r6.f12635a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12636b, r6.f12636b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Integer r0 = this.f12635a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            ColorToken r4 = this.f12636b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "HostColor(resourceId=" + this.f12635a + ", color=" + this.f12636b + ')';
        }
    }

    static {
        f12634a = new LiveCardUtil();
    }

    private LiveCardUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final a a(Context r9) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L6;
        r8 = r10;
    L6:
        int r11 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin"), "oui_on_accent_text_1", TypedValues.Custom.S_COLOR, r8.getPackageName(), "com.obric.memorydata.plugin");
        if (r11 != 0) goto L11;
        Integer r0 = null;
        Object[] r1 = 0 == true ? 1 : 0;
        return new a(r0, r1, 3, 0 == true ? 1 : 0);
    L11:
        return new a(Integer.valueOf(r11), new ColorToken(Integer.valueOf(r11), Integer.valueOf(r11), null, 4, null));
    }

    public final IslandWidget a(Icon r10, String r11, a r12) {
        Intrinsics.checkNotNullParameter(r10, "startIcon");
        Intrinsics.checkNotNullParameter(r11, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r12, "hostColor");
        CompatibleText r2 = null;
        Icon r3 = null;
        return new CompatibleCommonCollapseTemplate(r10, r2, r3, new CompatibleText(r11, 14, "#FFFFFFFF", "#FFFFFFFF", "400", 20, r12.a()), 6, null).create();
    }

    public final void a() {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Icon r2 = new Icon(24, 24, ResourceUtils.INSTANCE.getDrawable(r1, ZeusTransformUtils.mapRes(R.drawable.ic_recommend_memory_tile_eye, "drawable", "ic_recommend_memory_tile_eye")), null, null, null, null, false, null, null, null, 2040, null);
        String r3 = r1.getString(ZeusTransformUtils.mapRes(R.string.screen_observation_enable_livecard_notice, TypedValues.Custom.S_STRING, "screen_observation_enable_livecard_notice"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        IslandSession r0 = new IslandSession(a(r2, r3, a(r1)), null, null, null, null, null, 3000L, 0, LiveCardType.MEMORY_DATA, null, null, null, 0, null, null, null, 0, 130750, null);
        IslandApi r4 = ILiveCard.Companion.getInst().getIslandService();
        if (r4 == null) goto L6;
        r4.createSession(r0, r1);
        return;
    }
}
