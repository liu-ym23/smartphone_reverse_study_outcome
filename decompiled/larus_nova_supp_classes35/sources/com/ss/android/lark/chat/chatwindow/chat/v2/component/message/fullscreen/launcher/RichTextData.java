package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.c;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0013J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR1\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/RichTextData;", "Ljava/io/Serializable;", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "title", BuildConfig.FLAVOR, "previewHangPoints", "Ljava/util/HashMap;", "Lcom/ss/android/lark/export/entity/PreviewHangPoint;", "Lkotlin/collections/HashMap;", "<init>", "(Lcom/ss/android/lark/widget/richtext/RichText;Ljava/lang/String;Ljava/util/HashMap;)V", "getRichText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getTitle", "()Ljava/lang/String;", "getPreviewHangPoints", "()Ljava/util/HashMap;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "isValid", "component1", "component2", "component3", "copy", "toString", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichTextData implements Serializable {
    public static final a Companion = null;
    private final HashMap<String, PreviewHangPoint> previewHangPoints;
    private final RichText richText;
    private final String title;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static RichTextData a(AudioContent r6) {
            Intrinsics.checkNotNullParameter(r6, "<this>");
            if (r6.getRecognizedRichText() == null) goto L5;
            RichText r7 = r6.getRecognizedRichText();
        L7:
            return new RichTextData(r7, null, null, 4, null);
        L5:
            r7 = c.c(r6.getRecognizedText());
            goto L7
        }

        @JvmStatic
        public static RichTextData b(PostContent r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return new RichTextData(r4.getRichText(), r4.getTitle(), new HashMap(r4.getPreviewHangPoints()));
        }

        @JvmStatic
        public static RichTextData c(TextContent r3) {
            Intrinsics.checkNotNullParameter(r3, "<this>");
            return new RichTextData(r3.getRichText(), null, new HashMap(r3.getPreviewHangPoints()));
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RichTextData copy$default(RichTextData r0, RichText r1, String r2, HashMap r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.richText;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.title;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.previewHangPoints;
    L12:
        return r0.copy(r1, r2, r3);
    }

    @JvmStatic
    public static final RichTextData parseRichText(AudioContent r1) {
        Companion.getClass();
        return a.a(r1);
    }

    @JvmStatic
    public static final RichTextData parseRichText(PostContent r1) {
        Companion.getClass();
        return a.b(r1);
    }

    @JvmStatic
    public static final RichTextData parseRichText(TextContent r1) {
        Companion.getClass();
        return a.c(r1);
    }

    public final RichText component1() {
        return this.richText;
    }

    public final String component2() {
        return this.title;
    }

    public final HashMap<String, PreviewHangPoint> component3() {
        return this.previewHangPoints;
    }

    public final RichTextData copy(RichText r2, String r3, HashMap<String, PreviewHangPoint> r4) {
        return new RichTextData(r2, r3, r4);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.richText, this.title, this.previewHangPoints});
    }

    public String toString() {
        return "RichTextData(richText=" + this.richText + ", title=" + this.title + ", previewHangPoints=" + this.previewHangPoints + ')';
    }

    public final boolean isValid() {
        if (this.richText == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final HashMap<String, PreviewHangPoint> getPreviewHangPoints() {
        return this.previewHangPoints;
    }

    public final RichText getRichText() {
        return this.richText;
    }

    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(RichTextData.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.RichTextData");
        RichTextData r6 = (RichTextData) r5;
        if (Intrinsics.areEqual(this.richText, r6.richText) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.previewHangPoints, r6.previewHangPoints) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public RichTextData(RichText r1, String r2, HashMap<String, PreviewHangPoint> r3) {
        this.richText = r1;
        this.title = r2;
        this.previewHangPoints = r3;
    }

    public /* synthetic */ RichTextData(RichText r1, String r2, HashMap r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
