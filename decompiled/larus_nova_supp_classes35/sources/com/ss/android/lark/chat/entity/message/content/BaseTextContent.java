package com.ss.android.lark.chat.entity.message.content;

import android.text.Layout;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00132\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014J\b\u0010>\u001a\u00020\u0016H\u0007J\u0012\u0010?\u001a\u00020)2\b\u0010@\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R(\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u000205\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/BaseTextContent;", "T", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "getRichText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "setRichText", "(Lcom/ss/android/lark/widget/richtext/RichText;)V", "attachments", "Ljava/util/ArrayList;", "Lcom/bytedance/lark/pb/basic/v1/File;", "Lkotlin/collections/ArrayList;", "getAttachments", "()Ljava/util/ArrayList;", "setAttachments", "(Ljava/util/ArrayList;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "textInMemory", BuildConfig.FLAVOR, "getTextInMemory", "()Ljava/lang/String;", "setTextInMemory", "(Ljava/lang/String;)V", "previewHangPoints", BuildConfig.FLAVOR, "Lcom/ss/android/lark/export/entity/PreviewHangPoint;", "getPreviewHangPoints", "()Ljava/util/Map;", "setPreviewHangPoints", "(Ljava/util/Map;)V", "contentLayout", "Landroid/text/Layout;", "getContentLayout", "()Landroid/text/Layout;", "setContentLayout", "(Landroid/text/Layout;)V", "needReParseLayout", BuildConfig.FLAVOR, "getNeedReParseLayout", "()Z", "setNeedReParseLayout", "(Z)V", "urlPreviewList", "Lcom/ss/android/lark/chat/entity/message/MessageUrlPreview;", "getUrlPreviewList", "()Ljava/util/List;", "setUrlPreviewList", "(Ljava/util/List;)V", "docEntityMap", "Lcom/ss/android/lark/doc/entity/Doc;", "getDocEntityMap", "setDocEntityMap", "docResult", "Lcom/ss/android/lark/doc/entity/DocResult;", "getDocResult", "()Lcom/ss/android/lark/doc/entity/DocResult;", "setDocResult", "(Lcom/ss/android/lark/doc/entity/DocResult;)V", "getText", "isContentSame", "diffable", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseTextContent<T extends BaseTextContent<T>> extends Content {
    public transient Layout a;
    private ArrayList<File> attachments;
    public transient boolean b;
    private Map<String, ? extends Doc> docEntityMap;
    private DocResult docResult;
    private Map<String, PreviewHangPoint> previewHangPoints;
    private RichText richText;
    private String textInMemory;
    private List<? extends MessageUrlPreview> urlPreviewList;

    @Deprecated(message = BuildConfig.FLAVOR)
    public final String getText() {
        if (TextUtils.isEmpty(this.textInMemory) == true) goto L5;
    L7:
        String r0 = this.textInMemory;
        if (r0 != null) goto L11;
        return BuildConfig.FLAVOR;
    L11:
        return r0;
    L5:
        if (this.richText == null) goto L7;
        this.textInMemory = i.i(this.richText);
        goto L7
    }

    public BaseTextContent() {
        this.attachments = new ArrayList();
        this.textInMemory = BuildConfig.FLAVOR;
        this.previewHangPoints = new LinkedHashMap();
    }

    public final ArrayList<File> getAttachments() {
        return this.attachments;
    }

    public final Layout getContentLayout() {
        return this.a;
    }

    public final Map<String, Doc> getDocEntityMap() {
        return this.docEntityMap;
    }

    public final DocResult getDocResult() {
        return this.docResult;
    }

    public final boolean getNeedReParseLayout() {
        return this.b;
    }

    public final Map<String, PreviewHangPoint> getPreviewHangPoints() {
        return this.previewHangPoints;
    }

    public final RichText getRichText() {
        return this.richText;
    }

    public final String getTextInMemory() {
        return this.textInMemory;
    }

    public final List<MessageUrlPreview> getUrlPreviewList() {
        return this.urlPreviewList;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r7) {
        boolean r0 = r7 instanceof BaseTextContent;
        if (r0 == false) goto L10;
        Iterator<String> r2 = this.previewHangPoints.keySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        String r3 = r2.next();
        if (y28.a.c(this.previewHangPoints.get(r3), ((BaseTextContent) r7).previewHangPoints.get(r3)) == true) goto L6;
        return false;
    L10:
        if (r0 == true) goto L12;
    L14:
        if (r7 != null) goto L16;
        return false;
    L16:
        if ((r7 instanceof BaseTextContent) == true) goto L18;
        return false;
    L18:
        if (Objects.equals(((BaseTextContent) r7).richText, this.richText) == false) goto L26;
        return true;
    L26:
        return false;
    L12:
        if (Intrinsics.areEqual(this.attachments, ((BaseTextContent) r7).attachments) == true) goto L14;
        return false;
    }

    public final void setAttachments(List<File> r2) {
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        this.attachments = new ArrayList(r2);
    }

    public final void setContentLayout(Layout r1) {
        this.a = r1;
    }

    public final void setDocEntityMap(Map<String, ? extends Doc> r1) {
        this.docEntityMap = r1;
    }

    public final void setDocResult(DocResult r1) {
        this.docResult = r1;
    }

    public final void setNeedReParseLayout(boolean r1) {
        this.b = r1;
    }

    public final void setPreviewHangPoints(Map<String, PreviewHangPoint> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.previewHangPoints = r2;
    }

    public final void setRichText(RichText r1) {
        this.richText = r1;
    }

    public final void setTextInMemory(String r1) {
        this.textInMemory = r1;
    }

    public final void setUrlPreviewList(List<? extends MessageUrlPreview> r1) {
        this.urlPreviewList = r1;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Content) r1);
    }

    public final void setAttachments(ArrayList<File> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.attachments = r2;
    }
}
