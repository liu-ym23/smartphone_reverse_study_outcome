package com.larus.bmhome.chat.layout.widget.handler;

import android.content.Context;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.t2;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.HtmlBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements pw8.b {
    public Message a;
    public final String b;
    public final Gson c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0002\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/handler/MindMapWidgetHandler$MindMapData;", "", "isPlaceholder", "", "isEmptySearch", "markdownText", "", "url", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMarkdownText", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/layout/widget/handler/MindMapWidgetHandler$MindMapData;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a {

        @SerializedName("is_empty_search")
        private final Boolean isEmptySearch;

        @SerializedName("is_placeholder")
        private final Boolean isPlaceholder;

        @SerializedName("markdown_text")
        private final String markdownText;

        @SerializedName("url")
        private final String url;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.isPlaceholder, r6.isPlaceholder) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.isEmptySearch, r6.isEmptySearch) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.markdownText, r6.markdownText) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.url, r6.url) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Boolean r0 = this.isPlaceholder;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Boolean r4 = this.isEmptySearch;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.markdownText;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.url;
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

        public final String toString() {
            return "MindMapData(isPlaceholder=" + this.isPlaceholder + ", isEmptySearch=" + this.isEmptySearch + ", markdownText=" + this.markdownText + ", url=" + this.url + ')';
        }

        public a() {
            Boolean r0 = Boolean.FALSE;
            this.isPlaceholder = r0;
            this.isEmptySearch = r0;
            this.markdownText = null;
            this.url = null;
        }

        public final String a() {
            return this.markdownText;
        }

        public final String b() {
            return this.url;
        }

        public final Boolean c() {
            return this.isPlaceholder;
        }
    }

    public static final class b implements pw8.a {
        public final /* synthetic */ f a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ HtmlBlock c;

        public final void a(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "parent");
        }

        public final void b(int r5, ViewGroup r6) {
            Intrinsics.checkNotNullParameter(r6, "currentViewGroup");
            r6.removeViewAt(r6.getChildCount() - 1);
            pw8.a r7 = pw8.b.a.a(this.a, this.b, 0, this.c, Boolean.TRUE);
            if (r7 == null) goto L6;
            r7.a(r6);
            return;
        }

        public b(f r1, Context r2, HtmlBlock r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final int priority() {
        return 12;
    }

    public f(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a = r2;
        this.b = "MindMapWidgetHandler";
        this.c = new Gson();
    }

    public final boolean c(uvc.b r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        if ((r2 instanceof HtmlBlock) == false) goto L9;
        int r0 = vh8.a.a;
        HtmlBlock r3 = (HtmlBlock) r2;
        if (vh8.a.b(r3.h) == false) goto L9;
        int r1 = t2.a;
        if (Intrinsics.areEqual(t2.b(r3.h), "mind-map") == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final pw8.a a(Context r3, int r4, uvc.b r5, Boolean r6, lw8.h r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "node");
        a r8 = null;
        if ((r5 instanceof HtmlBlock) == false) goto L5;
        HtmlBlock r9 = (HtmlBlock) r5;
    L6:
        if (r9 == null) goto L17;
        int r10 = t2.a;
        String r11 = t2.a(this.a.getMessageId(), ((HtmlBlock) r5).h);
        if (r11 == null) goto L17;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L11
        r8 = (a) this.c.fromJson(r11, a.class);     // Catch: Throwable -> L11
    L13:
        if (r8 == null) goto L17;
        FLogger.a.d(this.b, "[biz_deep_search] mindMapData.isPlaceholder == " + Intrinsics.areEqual(r8.c(), Boolean.TRUE));
        return new i(r3, r8, this);
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
    L17:
        return new j(r3, this);
    L5:
        r9 = null;
        goto L6
    }

    public final pw8.a b(Context r1, int r2, int r3, ViewGroup r4, uvc.b r5, Boolean r6, lw8.h r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "currentViewGroup");
        Intrinsics.checkNotNullParameter(r5, "node");
        if ((r5 instanceof HtmlBlock) == false) goto L5;
        HtmlBlock r8 = (HtmlBlock) r5;
    L6:
        if (r8 != null) goto L8;
    L11:
        return null;
    L8:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L11;
        return new b(this, r1, r8);
    L5:
        r8 = null;
        goto L6
    }
}
